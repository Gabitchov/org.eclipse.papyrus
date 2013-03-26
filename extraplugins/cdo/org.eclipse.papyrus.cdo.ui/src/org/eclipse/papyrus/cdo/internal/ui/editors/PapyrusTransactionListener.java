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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.common.id.CDOID;
import org.eclipse.emf.cdo.common.lock.CDOLockState;
import org.eclipse.emf.cdo.common.revision.CDOIDAndBranch;
import org.eclipse.emf.cdo.dawn.gmf.util.DawnDiagramUpdater;
import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.emf.cdo.transaction.CDOTransactionConflictEvent;
import org.eclipse.emf.cdo.transaction.CDOTransactionFinishedEvent;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.cdo.view.CDOView;
import org.eclipse.emf.cdo.view.CDOViewInvalidationEvent;
import org.eclipse.emf.cdo.view.CDOViewLocksChangedEvent;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.BasicNotifierImpl.EObservableAdapterList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.change.util.ChangeRecorder;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.IWorkspaceCommandStack;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.net4j.util.event.IEvent;
import org.eclipse.net4j.util.event.IListener;
import org.eclipse.papyrus.cdo.core.resource.CDOUndoContext;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.Activator;
import org.eclipse.papyrus.cdo.internal.ui.decorators.CDOStateAdapter;
import org.eclipse.papyrus.cdo.internal.ui.decorators.CDOStateLabelDecorator;
import org.eclipse.papyrus.cdo.internal.ui.l10n.Messages;
import org.eclipse.papyrus.cdo.internal.ui.util.UIUtil;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.core.services.ServicesRegistry;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

/**
 * This is the PapyrusTransactionListener type. Enjoy.
 */
public class PapyrusTransactionListener implements IListener {

	private final ServicesRegistry services;

	private final Predicate<Adapter> shouldPropagate = new Predicate<Adapter>() {

		public boolean apply(Adapter input) {
			return (input instanceof ECrossReferenceAdapter) //
				|| (input instanceof EContentAdapter) //
				|| (input instanceof ChangeRecorder);
		}
	};

	private final Set<Adapter> contentAdapters;

	public PapyrusTransactionListener(ServicesRegistry services, ResourceSet resourceSet) {
		super();

		this.services = services;

		contentAdapters = Sets.newHashSet(Iterables.filter(resourceSet.eAdapters(), shouldPropagate));
		((EObservableAdapterList)resourceSet.eAdapters()).addListener(new EObservableAdapterList.Listener() {

			public void added(Notifier notifier, Adapter adapter) {
				if(adapter instanceof EContentAdapter) {
					contentAdapters.add(adapter);
				}
			}

			public void removed(Notifier notifier, Adapter adapter) {
				contentAdapters.remove(adapter);
			}
		});

	}

	public void notifyEvent(IEvent event) {
		if(event instanceof CDOViewInvalidationEvent) {
			handleViewInvalidationEvent((CDOViewInvalidationEvent)event);
		} else if(event instanceof CDOTransactionConflictEvent) {
			handleTransactionConflictEvent((CDOTransactionConflictEvent)event);
		} else if(event instanceof CDOViewLocksChangedEvent) {
			handleLocksChangedEvent((CDOViewLocksChangedEvent)event);
		} else if(event instanceof CDOTransactionFinishedEvent) {
			handleTransactionFinishedEvent((CDOTransactionFinishedEvent)event);
		} else {
			handleEvent(event);
		}
	}

	protected void handleTransactionConflictEvent(CDOTransactionConflictEvent event) {
		if(UIUtil.ensureUIThread(this, event)) {
			CDOObject cdoObject = event.getConflictingObject();
			EObject element = CDOUtil.getEObject(cdoObject);
			View view = DawnDiagramUpdater.findViewByContainer(element);

			if(view == null) {
				// it's not actually a view that is conflicted, but a model
				// element
				if(cdoObject.cdoConflict()) {
					CDOStateAdapter.setState(element, DawnState.CONFLICT);

					CDOStateLabelDecorator.fireLabelUpdates();
				}
			}
		}
	}

	protected void handleLocksChangedEvent(CDOViewLocksChangedEvent event) {
		if(UIUtil.ensureUIThread(this, event)) {
			Map<EObject, DawnState> changedObjects = new HashMap<EObject, DawnState>();
			CDOView cdoView = event.getSource();

			for(CDOLockState state : event.getLockStates()) {
				Object lockedObject = state.getLockedObject();

				CDOID id;
				if(lockedObject instanceof CDOID) {
					id = (CDOID)lockedObject;
				} else if(lockedObject instanceof CDOIDAndBranch) {
					id = ((CDOIDAndBranch)lockedObject).getID();
				} else {
					throw new RuntimeException("Unexpected object type: " //$NON-NLS-1$
						+ lockedObject);
				}

				if(id != null) {
					CDOObject object = cdoView.getObject(id);
					EObject element = CDOUtil.getEObject(object);

					View view = DawnDiagramUpdater.findViewByContainer(element);

					if(view == null) {
						// it's not actually a view that is locked, but a model
						// element

						if(CDOUtils.isLocked(object, false)) {
							throw new IllegalStateException("Locally locked objects should not occur."); //$NON-NLS-1$
						} else if(CDOUtils.isLocked(object, true)) {
							changedObjects.put(element, DawnState.LOCKED_REMOTELY);
						} else {
							changedObjects.put(element, DawnState.CLEAN);
						}
					}
				}
			}

			handleLocks(changedObjects);
		}
	}

	/**
	 * @precondition The current thread is the UI thread
	 */
	void handleLocks(Map<EObject, DawnState> changedObjects) {
		if(!changedObjects.isEmpty()) {
			for(Map.Entry<EObject, DawnState> next : changedObjects.entrySet()) {

				EObject element = next.getKey();
				DawnState state = next.getValue();

				CDOStateAdapter.setState(element, state);
			}

			CDOStateLabelDecorator.fireLabelUpdates();
		}
	}

	protected void handleViewInvalidationEvent(CDOViewInvalidationEvent event) {
		if(UIUtil.ensureUIThread(this, event)) {
			// process changed objects to ensure propagation of adapters to new objects.
			// CDO doesn't tell us about new objects, but it does tell us that their
			// containers changed, so we have to go fishing
			for(EObject next : CDOUtils.getEObjects(event.getDirtyObjects())) {
				for(EObject possiblyNew : next.eContents()) {
					synchronizeAdapters(possiblyNew);
				}
			}

			// also, purge any operations from the local history that changed the objects that
			// were changed by the remote transaction
			handleOperationHistory(event);
		}
	}

	protected void synchronizeAdapters(EObject object) {
		object.eAdapters().addAll(Sets.difference(contentAdapters, ImmutableSet.copyOf(object.eAdapters())));
	}

	protected void handleOperationHistory(CDOViewInvalidationEvent event) {
		IOperationHistory history = getOperationHistory();
		if(history != null) {
			Iterable<EObject> affectedObjects = CDOUtils.getEObjects(Iterables.concat(event.getDirtyObjects(), event.getDetachedObjects()));
			if(!Iterables.isEmpty(affectedObjects)) {
				IUndoContext context = new CDOUndoContext(affectedObjects);
				if(context != null) {
					IUndoableOperation undoOperation = history.getUndoOperation(context);
					IUndoableOperation redoOperation = history.getRedoOperation(context);

					if((undoOperation != null) || (redoOperation != null)) {
						// notify listeners of the impending changes.  We do this before flushing
						// the undo context because we depend on the fact that the UndoActionHandler
						// and RedoActionHandler only react when the operation is their current
						// operation (which means it mustn't have the context removed yet) *and* the
						// update is posted asynchronously
						if(undoOperation != null) {
							history.operationChanged(undoOperation);
						}
						if(redoOperation != null) {
							history.operationChanged(redoOperation);
						}

						// flush the history for this editor
						history.dispose(getEditorUndoContext(), true, true, false);

						NotificationBuilder.createAsyncPopup(Messages.PapyrusTransactionListener_0).setType(Type.INFO).run();
					}
				}
			}
		}
	}

	protected IOperationHistory getOperationHistory() {
		IOperationHistory result = null;

		try {
			EditingDomain domain = services.getService(TransactionalEditingDomain.class);
			if(domain != null) {
				CommandStack stack = domain.getCommandStack();
				if(stack instanceof IWorkspaceCommandStack) {
					result = ((IWorkspaceCommandStack)stack).getOperationHistory();
				}
			}
		} catch (ServiceException e) {
			Activator.log.error("Failed to get editor operation history from service registry.", e); //$NON-NLS-1$
		}

		return result;
	}

	protected IUndoContext getEditorUndoContext() {
		IUndoContext result = null;

		try {
			result = services.getService(IUndoContext.class);
		} catch (ServiceException e) {
			Activator.log.error("Failed to get editor undo context from service registry.", e); //$NON-NLS-1$
		}

		return result;
	}

	protected void handleTransactionFinishedEvent(CDOTransactionFinishedEvent event) {
		// review all conflicts and locks
		Map<EObject, DawnState> stateUpdates = Maps.newHashMap();

		for(CDOStateAdapter next : CDOStateAdapter.getAll(event.getSource().getResourceSet())) {

			Object target = next.getTarget();
			if(target instanceof EObject) {
				EObject object = (EObject)target;
				stateUpdates.put(object, CDOUtils.computeState(object));
			}
		}

		for(Map.Entry<EObject, DawnState> next : stateUpdates.entrySet()) {
			CDOStateAdapter.setState(next.getKey(), next.getValue());
		}

		CDOStateLabelDecorator.fireLabelUpdates();
	}

	protected void handleEvent(IEvent event) {
		// pass
	}
}
