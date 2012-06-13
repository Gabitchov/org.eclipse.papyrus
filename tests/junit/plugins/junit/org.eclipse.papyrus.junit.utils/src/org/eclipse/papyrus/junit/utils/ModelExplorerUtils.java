/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.IPage;
import org.junit.Assert;

/**
 * Useful methods for the ModelExplorer view
 */
public class ModelExplorerUtils {

	/**
	 * the ID of the ModelExplorerView
	 */
	private static final String ModelExplorerViewId = "org.eclipse.papyrus.views.modelexplorer.modelexplorer"; //$NON-NLS-1$

	private ModelExplorerUtils() {
		// to prevent instanciation
	}

	/**
	 * 
	 * @return
	 *         the opened modelexplorer. Warning, it should be better that Papyrus was opened yet
	 * @throws PartInitException
	 */
	public static ModelExplorerView openModelExplorerView() throws PartInitException {
		IViewPart modelexplorer = null;
		modelexplorer = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().showView(ModelExplorerViewId);
		final ModelExplorerPageBookView view = (ModelExplorerPageBookView)modelexplorer;
		final IPage currentPage = view.getCurrentPage();
		final ModelExplorerPage page = (ModelExplorerPage)currentPage;
		final IViewPart viewer = page.getViewer();
		Assert.assertNotNull(viewer);
		viewer.setFocus();
		return (ModelExplorerView)viewer;
	}

	/**
	 * 
	 * @param view
	 *        the modelexplorer to manipulate
	 * @param elements
	 *        the elements to select
	 */
	public static void setSelectionInTheModelexplorer(final ModelExplorerView view, List<?> elements) {
		view.revealSemanticElement(elements);
		final List<?> currentSelection = getCurrentSelectionInTheModelExplorer();
		Assert.assertTrue("The current selection is not the wanted selection", elements.containsAll(currentSelection));
		Assert.assertTrue("The current selection is not the wanted selection", currentSelection.containsAll(elements));
	}

	/**
	 * 
	 * @return
	 *         the object selected in the ModelExplorer
	 *         //TODO : should be moved in the ModelExplorer
	 */
	public static List<?> getCurrentSelectionInTheModelExplorer() {
		final IStructuredSelection currentSelection = (IStructuredSelection)PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection(ModelExplorerViewId);
		final List<Object> selection = new ArrayList<Object>();
		final Iterator<?> iter = currentSelection.iterator();
		while(iter.hasNext()) {
			final Object current = iter.next();
			if(current instanceof IAdaptable) {
				final EObject adaptedObject = (EObject)((IAdaptable)current).getAdapter(EObject.class);
				Assert.assertNotNull(NLS.bind("The object {0} can't be adapted to EObject", current), adaptedObject);
				selection.add(adaptedObject);
			} else {
				selection.add(current);
			}

		}
		return selection;
	}

	/**
	 * 
	 * @param view
	 *        the ModelExplorerView
	 * @return
	 *         the root of the Model
	 *         //TODO : should be moved in the ModelExplorer
	 */
	public static final EObject getRootInModelExplorer(final ModelExplorerView view) {
		view.getCommonViewer().expandToLevel(2);

		// store the root of the model
		final Object[] visibleElement = view.getCommonViewer().getVisibleExpandedElements();
		EObject modelRoot = null;
		if(visibleElement[0] instanceof IAdaptable) {
			modelRoot = (EObject)((IAdaptable)visibleElement[0]).getAdapter(EObject.class);
		}
		Assert.assertNotNull(modelRoot);
		while(modelRoot.eContainer() != null) {
			modelRoot = modelRoot.eContainer();
		}
		return modelRoot;
	}
}
