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

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

import org.eclipse.emf.cdo.CDOObject;
import org.eclipse.emf.cdo.dawn.appearance.DawnElementStylizer;
import org.eclipse.emf.cdo.dawn.editors.IDawnEditor;
import org.eclipse.emf.cdo.dawn.gmf.appearance.DawnAppearancer;
import org.eclipse.emf.cdo.dawn.gmf.editors.impl.DawnGMFEditorSupport;
import org.eclipse.emf.cdo.dawn.gmf.notifications.impl.DawnGMFHandler;
import org.eclipse.emf.cdo.dawn.gmf.util.DawnDiagramUpdater;
import org.eclipse.emf.cdo.dawn.notifications.BasicDawnListener;
import org.eclipse.emf.cdo.dawn.spi.DawnState;
import org.eclipse.emf.cdo.dawn.ui.stylizer.DawnElementStylizerRegistry;
import org.eclipse.emf.cdo.util.CDOUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.cdo.internal.core.CDOUtils;
import org.eclipse.papyrus.cdo.internal.ui.util.UIUtil;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;

/**
 * This is the PapyrusGMFEditorSupport type. Enjoy.
 */
public class PapyrusGMFEditorSupport
		extends DawnGMFEditorSupport {

	private static final Predicate<EStructuralFeature.Setting> IS_VIEW_REFERENCE = new Predicate<EStructuralFeature.Setting>() {

		public boolean apply(EStructuralFeature.Setting input) {
			return input.getEStructuralFeature() == NotationPackage.Literals.VIEW__ELEMENT;
		}
	};

	private static final Function<EStructuralFeature.Setting, View> OWNER_VIEW = new Function<EStructuralFeature.Setting, View>() {

		public View apply(EStructuralFeature.Setting input) {
			return (View) input.getEObject();
		}
	};

	/**
	 * @param editor
	 */
	public PapyrusGMFEditorSupport(IDawnEditor editor) {
		super(editor);
	}

	@Override
	protected DawnGMFHandler createDawnGMFHandler(IDawnEditor editor) {
		return new PapyrusGMFHandler(editor);
	}

	@Override
	protected BasicDawnListener getLockingHandler() {
		return new PapyrusGMFLockingHandler(getEditor());
	}

	@Override
	public void lockObject(Object objectToBeLocked) {
		if (objectToBeLocked instanceof EditPart) {
			super.lockObject(objectToBeLocked);

			// the super implementation locked the semantic element, so update
			// its presentation
			CDOObject cdo = CDOUtils
				.getCDOObject(getSemanticElement((EditPart) objectToBeLocked));
			if (cdo != null) {
				updateAppearance(cdo);
			}
		} else {
			EObject element = EMFHelper.getEObject(objectToBeLocked);
			CDOObject cdo = (element == null)
				? null
				: CDOUtils.getCDOObject(element);

			if (element != null) {
				CDOUtils.lock(cdo);

				updateAppearance(cdo);

				// and update any views in my diagram
				for (View next : getViewsOfElement(element)) {
					cdo = CDOUtils.getCDOObject(next);
					if (cdo != null) {
						CDOUtils.lock(cdo);
						updateAppearance(cdo);
					}
				}

				refresh();
			}
		}
	}

	private void updateAppearance(CDOObject cdoObject) {
		EObject element = CDOUtil.getEObject(cdoObject);
		DawnElementStylizer stylizer = DawnElementStylizerRegistry.instance
			.getStylizer(element);

		if (stylizer != null) {
			if (cdoObject.cdoConflict()) {
				stylizer.setConflicted(element,
					DawnAppearancer.TYPE_CONFLICT_REMOTELY_AND_LOCALLY_CHANGED);
			} else if (CDOUtils.isLocked(cdoObject, true)) {
				stylizer.setLocked(element,
					DawnAppearancer.TYPE_LOCKED_GLOBALLY);
			} else if (CDOUtils.isLocked(cdoObject, false)) {
				stylizer
					.setLocked(element, DawnAppearancer.TYPE_LOCKED_LOCALLY);
			} else {
				stylizer.setDefault(element);
			}
		}
	}

	@Override
	public void unlockObject(Object objectToBeUnlocked) {
		if (objectToBeUnlocked instanceof EditPart) {
			super.unlockObject(objectToBeUnlocked);

			// the super implementation unlocked the semantic element, so update
			// its presentation
			CDOObject cdo = CDOUtils
				.getCDOObject(getSemanticElement((EditPart) objectToBeUnlocked));
			if (cdo != null) {
				updateAppearance(cdo);
			}
		} else {
			EObject element = EMFHelper.getEObject(objectToBeUnlocked);
			CDOObject cdo = (element == null)
				? null
				: CDOUtils.getCDOObject(element);

			if (element != null) {
				CDOUtils.unlock(cdo);

				updateAppearance(cdo);

				// and update any views in my diagram
				for (View next : getViewsOfElement(element)) {
					cdo = CDOUtils.getCDOObject(next);
					if (cdo != null) {
						CDOUtils.unlock(cdo);
						updateAppearance(cdo);
					}
				}

				refresh();
			}
		}
	}

	@Override
	public void handleRemoteLockChanges(Map<Object, DawnState> changedObjects) {
		if (UIUtil.ensureUIThread(this, changedObjects)) {
			// filter the event to cover only the objects that are views in or
			// have views in my diagram
			Map<Object, DawnState> filtered = filter(changedObjects);
			if (filtered != null) {
				super.handleRemoteLockChanges(filtered);
			}
		}
	}

	protected Map<Object, DawnState> filter(
			Map<Object, DawnState> changedObjects) {

		Map<Object, DawnState> result = Maps.newHashMap(changedObjects);

		if (filter(result.keySet(), getDiagramEditor(getEditor()))) {
			if (result.isEmpty()) {
				result = null;
			}
		}

		return result;
	}

	public static View findView(DiagramDocumentEditor diagramEditor,
			EObject element) {

		View result = null;

		Diagram diagram = diagramEditor.getDiagram();
		View view = DawnDiagramUpdater.findViewByContainer(element);

		if (view != null) {
			if (EcoreUtil.isAncestor(diagram, view)) {
				result = view;
			}
		} else {
			// find the view of the element that is in my diagram
			for (View next : getViewsOfElement(element)) {
				if (EcoreUtil.isAncestor(diagram, next)) {
					result = next;
					break;
				}
			}
		}

		return result;
	}

	public static Iterable<View> getViewsOfElement(EObject element) {
		Iterable<View> result = Collections.emptyList();

		ECrossReferenceAdapter xrefs = ECrossReferenceAdapter
			.getCrossReferenceAdapter(element);
		if (xrefs != null) {
			Collection<EStructuralFeature.Setting> settings = xrefs
				.getNonNavigableInverseReferences(element);
			result = Iterables.transform(
				Iterables.filter(settings, IS_VIEW_REFERENCE), OWNER_VIEW);
		}

		return result;

	}

	static boolean filter(Collection<?> objects,
			DiagramDocumentEditor diagramEditor) {

		boolean result = false;

		for (Iterator<?> iter = objects.iterator(); iter.hasNext();) {
			Object next = iter.next();

			if (next instanceof CDOObject) {
				EObject element = CDOUtil.getEObject((CDOObject) next);

				// get the view of this element in the current diagram
				View view = findView(diagramEditor, element);
				if (view == null) {
					iter.remove();
					result = true;
				}
			}
		}

		return result;
	}

	public static EObject getSemanticElement(EditPart editPart) {
		EObject result = null;

		Object model = editPart.getModel();
		if (model instanceof EObject) {
			View view = DawnDiagramUpdater.findViewByContainer((EObject) model);
			if (view != null) {
				result = view.getElement();
			}
		}

		return result;
	}
}
