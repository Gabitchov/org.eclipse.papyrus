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

import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.CommonViewer;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @author VL222926
 * 
 *         This plugin tests the activation of the correct handler for
 *         differents selection in the ModelExplorer
 */
public class DeleteHandlerTest extends AbstractHandlerTest {

	/**
	 * the id of the delete command
	 */
	private static final String DELETE_COMMAND_ID = "org.eclipse.ui.edit.delete"; //$NON-NLS-1$

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public DeleteHandlerTest() {
		super(DeleteHandlerTest.DELETE_COMMAND_ID, Activator.getDefault().getBundle());
	}

	/**
	 * We test if we can delete the root of the Model or not
	 */
	@Test
	public void deleteRootOfTheModel() {
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
		Assert.assertTrue(obj == getRootOfTheModel());
		final IHandler currentHandler = getActiveHandler();
		if(currentHandler == null) {
			// not a problem in this case
		} else {
			Assert.assertFalse("We can delete the root of the model. It is not the wanted behavior", currentHandler.isEnabled()); //$NON-NLS-1$
		}
	}

	@Test
	public void deleteLinkItemTest() {
		final CommonViewer commonViewer = getCommonViewer();
		commonViewer.expandToLevel(3);
		final Object[] expandedElement = commonViewer.getExpandedElements();
		for(final Object object : expandedElement) {
			if(object instanceof org.eclipse.emf.facet.infra.browser.uicore.internal.model.LinkItem) {
				selectElementInTheModelexplorer((ITreeElement)object);
				final IHandler handler = getActiveHandler();
				if(handler != null) {
					//FIXME: The test fails. However, at runtime, the handler is hidden from the ModelExplorer (instead of disabled), which is an acceptable behavior
					Assert.assertFalse("The handler " + handler + " is active on LinkItem, it is not the wanted behavior", handler.isHandled() && handler.isEnabled()); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
	}
}
