/*******************************************************************************
 * Copyright (c) 2010 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.modelexplorer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmt.modisco.infra.browser.uicore.CustomizableModelContentProvider;
import org.eclipse.gmt.modisco.infra.browser.uicore.internal.model.ModelElementItem;
import org.eclipse.papyrus.core.editor.IMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.core.utils.EditorUtils;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * the content provider that inherits of modisco properties
 */
@SuppressWarnings("restriction")
public class MoDiscoContentProvider extends CustomizableModelContentProvider {

	protected DiResourceSet diResourceSet;

	/** The list of open pages (diagrams) */
	protected IPageMngr pageMngr;

	public MoDiscoContentProvider() {
		super(Activator.getDefault().getCustomizationManager());

	}

	private DiResourceSet getDiResourceSet() {
		return EditorUtils.getDiResourceSet();
	}

	@Override
	public Object[] getChildren(final Object parentElement) {
		this.diResourceSet = getDiResourceSet();
		pageMngr = EditorUtils.getIPageMngr(diResourceSet.getDiResource());

		ArrayList<Object> result = new ArrayList<Object>();

		Object[] arrayObject = super.getChildren(parentElement);
		if (arrayObject != null) {
			for (int i = 0; i < arrayObject.length; i++) {
				result.add(arrayObject[i]);
			}
		}
		if (parentElement instanceof ModelElementItem
				&& ((ModelElementItem) (parentElement)).getEObject() instanceof EObject) {
			List<Diagram> diagramList = findAllExistingDiagrams((EObject) ((ModelElementItem) parentElement)
					.getEObject());
			Iterator<Diagram> iterator = diagramList.iterator();
			while (iterator.hasNext()) {
				result.add(iterator.next());
			}
		}
		return result.toArray();
	}

	/**
	 * @param owner
	 *            the owner of the diagrams
	 * @return the list of diagrams contained by the given owner
	 */
	private List<Diagram> findAllExistingDiagrams(EObject owner) {
		ArrayList<Diagram> diagrams = new ArrayList<Diagram>();

		// Walk on page (Diagram) references
		for (Object page : pageMngr.allPages()) {
			if (!(page instanceof Diagram)) {
				continue;
			}
			// We have a GMF Diagram
			Diagram diagram = (Diagram) page;
			if (owner.equals(diagram.getElement())) {
				diagrams.add(diagram);
			}

		}

		return diagrams;
	}

	@Override
	public EObject[] getRootElements(Object inputElement) {
		// we are standing for the multi editor
		try {
			IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow();
			if (workbenchWindow == null) {
				return null;
			}
			IWorkbenchPage page = workbenchWindow.getActivePage();
			if (page != null && page.getActiveEditor() instanceof IMultiDiagramEditor) {
				EList<EObject> contents = EditorUtils.getDiResourceSet()
						.getModelResource().getContents();
				ArrayList<EObject> result = new ArrayList<EObject>();
				Iterator<EObject> iterator = contents.iterator();
				while (iterator.hasNext()) {
					EObject eObject = (EObject) iterator.next();
					if (!(eObject instanceof DynamicEObjectImpl)) {
						result.add(eObject);
					}
				}
				return result.toArray(new EObject[result.size()]);
			}
		} catch (Exception e) {
			Activator.log.error(e);
		}
		return new EObject[0];

	}
}
