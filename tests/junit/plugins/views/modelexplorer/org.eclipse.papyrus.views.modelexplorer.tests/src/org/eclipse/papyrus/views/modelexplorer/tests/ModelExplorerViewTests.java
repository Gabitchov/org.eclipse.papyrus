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
package org.eclipse.papyrus.views.modelexplorer.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.junit.Assert;
import org.junit.Test;


public class ModelExplorerViewTests extends AbstractHandlerTest {

	/**
	 * 
	 * Constructor.
	 * This plugin test the ModelExplorerView
	 */
	public ModelExplorerViewTests() {
		super(Activator.getDefault().getBundle());
	}

	/**
	 * tests the method reveal semantic element on the root element
	 */
	@Test
	public void revealSemanticElement_rootTest() {
		final List<EObject> selectedElement = new ArrayList<EObject>();
		selectedElement.add(getRootOfTheModel());
		getModelExplorerView().revealSemanticElement(selectedElement);
		final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final IWorkbenchPart activePart = activePage.getActivePart();
		Assert.assertTrue("The active part is not the ModelExplorer", activePart instanceof ModelExplorerPageBookView); //$NON-NLS-1$
		final IStructuredSelection currentSelection = getCurrentSelection();
		Assert.assertTrue("Only one element should be selected", currentSelection.size() == 1); //$NON-NLS-1$
		Object obj = currentSelection.getFirstElement();
		if(obj instanceof IAdaptable) {
			obj = ((IAdaptable)obj).getAdapter(EObject.class);
		}
		Assert.assertTrue("The function revealSemanticElement seems doesn't work on the root of the model", obj == getRootOfTheModel());
	}

}
