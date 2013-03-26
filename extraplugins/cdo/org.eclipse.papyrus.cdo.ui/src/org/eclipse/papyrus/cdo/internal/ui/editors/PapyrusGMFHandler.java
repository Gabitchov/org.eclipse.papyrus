/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.cdo.internal.ui.editors;

import static org.eclipse.emf.cdo.dawn.gmf.editors.impl.DawnGMFEditorSupport.getDiagramEditor;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.revision.delta.CDOFeatureDelta;
import org.eclipse.emf.cdo.common.revision.delta.CDORevisionDelta;
import org.eclipse.emf.cdo.dawn.editors.IDawnEditor;
import org.eclipse.emf.cdo.dawn.gmf.notifications.impl.DawnGMFHandler;
import org.eclipse.emf.cdo.dawn.gmf.util.DawnDiagramUpdater;
import org.eclipse.emf.cdo.transaction.CDOTransaction;
import org.eclipse.emf.cdo.transaction.CDOTransactionConflictEvent;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.cdo.internal.ui.util.UIUtil;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * This is the PapyrusGMFHandler type. Enjoy.
 */
public class PapyrusGMFHandler extends DawnGMFHandler {

	public PapyrusGMFHandler(IDawnEditor editor) {
		super(editor);
	}

	@Override
	public void attachingObject(CDOTransaction transaction, CDOObject object) {
		// bug 404077: we don't need to refresh edit-parts for objects attached to the transaction
		// because GMF will take care of refreshing edit-parts.  So, suppress the super behaviour
	}

	@Override
	public void handleViewInvalidationEvent(CDOViewInvalidationEvent event) {
		if(UIUtil.ensureUIThread(this, event)) {
			// filter the event to cover only the objects that are views in or
			// have views in my diagram
			CDOViewInvalidationEvent filtered = filter(event);
			if(filtered != null) {
				super.handleViewInvalidationEvent(filtered);
			}
		}
	}

	@Override
	public void handleTransactionConflictEvent(CDOTransactionConflictEvent event) {
		if(UIUtil.ensureUIThread(this, event)) {
			// filter the event to cover only the objects that are views in or
			// have views in my diagram
			CDOTransactionConflictEvent filtered = filter(event);
			if(filtered != null) {
				super.handleTransactionConflictEvent(filtered);
			}
		}
	}

	protected CDOViewInvalidationEvent filter(final CDOViewInvalidationEvent event) {
		CDOViewInvalidationEvent result = event;

		boolean filtered = false;

		final Set<CDOObject> dirty = Sets.newHashSet(event.getDirtyObjects());
		final Set<CDOObject> detached = Sets.newHashSet(event.getDetachedObjects());
		final Map<CDOObject, CDORevisionDelta> deltas = Maps.newHashMap(event.getRevisionDeltas());

		filtered = filter(dirty) || filtered;
		filtered = filter(detached) || filtered;
		filtered = filter(deltas.keySet()) || filtered;

		if(filtered) {
			if(dirty.isEmpty() && detached.isEmpty() && deltas.isEmpty()) {
				result = null;
			} else {
				result = new CDOViewInvalidationEvent() {

					public CDOView getSource() {
						return event.getSource();
					}

					public long getTimeStamp() {
						return event.getTimeStamp();
					}

					public Map<CDOObject, CDORevisionDelta> getRevisionDeltas() {
						return deltas;
					}

					public Set<CDOObject> getDirtyObjects() {
						return dirty;
					}

					public Set<CDOObject> getDetachedObjects() {
						return detached;
					}
				};
			}
		}

		return result;
	}

	protected boolean filter(Collection<?> objects) {
		return PapyrusGMFEditorSupport.filter(objects, getDiagramEditor(editor));
	}

	protected CDOTransactionConflictEvent filter(CDOTransactionConflictEvent event) {
		CDOObject cdoObject = event.getConflictingObject();
		EObject element = CDOUtil.getEObject(cdoObject);
		DiagramDocumentEditor diagramEditor = getDiagramEditor(editor);

		// get the view of this element in the current diagram
		View view = PapyrusGMFEditorSupport.findView(diagramEditor, element);

		return (view == null) ? null : event;
	}

	@Override
	public void modifyingObject(CDOTransaction transaction, final CDOObject object, CDOFeatureDelta featureDelta) {
		if(object instanceof Resource) {
			// GMF doesn't need to refresh a resource
			return;
		}

		// bug 404077: we don't need to refresh edit-parts for objects attached to the transaction
		// because GMF will take care of refreshing edit-parts.  So, suppress the super behaviour
		// vis-a-vis refreshing the object and setting the editor dirty

		RefreshAdapter.refreshLater(object, editor);
	}

	//
	// Nested types
	//

	private static final class RefreshAdapter extends AdapterImpl implements Runnable {

		private static Object TYPE = new Object();

		private static final ConcurrentMap<IDawnEditor, Runnable> pending = new ConcurrentHashMap<IDawnEditor, Runnable>();

		private final IDawnEditor editor;

		RefreshAdapter(IDawnEditor editor) {
			super();

			this.editor = editor;
		}

		static void refreshLater(Notifier notifier, IDawnEditor editor) {
			// don't add another one to this object
			if(EcoreUtil.getExistingAdapter(notifier, TYPE) == null) {
				notifier.eAdapters().add(new RefreshAdapter(editor));
			}
		}

		@Override
		public void notifyChanged(Notification notification) {
			// removal of adapters doesn't require refresh, especially if
			// the adapter that is removed is the CDO legacy adapter! (which
			// then results in issues)
			if(notification.getEventType() != Notification.REMOVING_ADAPTER) {
				post();
				getTarget().eAdapters().remove(this);
			}
		}

		private void post() {
			// don't schedule redundant refreshes for this editor
			if(UIUtil.ensureUIThread(this)) {
				if(pending.putIfAbsent(editor, this) == this) {
					run();
				}
			}
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == TYPE;
		}

		public void run() {
			pending.remove(editor, this);

			DiagramDocumentEditor diagramEditor = getDiagramEditor(editor);
			if(diagramEditor != null) {
				DawnDiagramUpdater.refreshEditPart(diagramEditor.getDiagramEditPart(), diagramEditor);
			}
		}
	}
}
