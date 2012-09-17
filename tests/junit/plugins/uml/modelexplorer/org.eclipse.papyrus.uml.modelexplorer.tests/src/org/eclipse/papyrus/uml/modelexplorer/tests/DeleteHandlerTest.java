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
package org.eclipse.papyrus.uml.modelexplorer.tests;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.tests.AbstractHandlerTest;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Model;
import org.junit.Assert;
import org.junit.Test;


/**
 * 
 * @author VL222926
 * 
 *         This plugin tests the activation of the correct handler for differents selection in the ModelExplorer
 */
public class DeleteHandlerTest extends AbstractHandlerTest {

	/**
	 * the id of the delete command
	 */
	private static final String DELETE_COMMAND_ID = "org.eclipse.ui.edit.delete";

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public DeleteHandlerTest() {
		super(DELETE_COMMAND_ID, Activator.getDefault().getBundle());
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
			Assert.assertTrue("We can delete the root of the model. It is not the wanted behavior", currentHandler.isEnabled() == false); //$NON-NLS-1$
		}
	}

	/**
	 * We test if we can delete other uml elements
	 */
	@Test
	public void deleteUMLElementsTest() {
		testIsModelExplorerActivePart();

		int size = ((Model)getRootOfTheModel()).getPackagedElements().size();
		EObject elementToDelete;
		while(((Model)getRootOfTheModel()).getPackagedElements().size() != 0) {
			//we need to clean the selection
			getCommonViewer().setSelection(new StructuredSelection());
			IStructuredSelection currentSelection = getCurrentSelection();
			elementToDelete = ((Model)getRootOfTheModel()).getPackagedElements().get(0);
			List<EObject> selectedElement = new ArrayList<EObject>();
			selectedElement.add(elementToDelete);
			getModelExplorerView().revealSemanticElement(selectedElement);
			currentSelection = getCurrentSelection();
			Assert.assertTrue("Only one element should be selected", currentSelection.size() == 1);
			Object obj = currentSelection.getFirstElement();
			if(obj instanceof IAdaptable) {
				obj = ((IAdaptable)obj).getAdapter(EObject.class);
			}
			Assert.assertTrue(obj == elementToDelete);
			IHandler currentHandler = getActiveHandler();
			Assert.assertTrue("We can't delete the following element" + elementToDelete, currentHandler.isEnabled());
			try {
				currentHandler.execute(new ExecutionEvent());
			} catch (ExecutionException e) {
				Assert.fail();
			}

			int newSize = ((Model)getRootOfTheModel()).getPackagedElements().size();
			Assert.assertTrue(newSize == (size - 1));
			//We test the undo
			Assert.assertTrue(getCommandStack().canUndo());
			getCommandStack().undo();
			newSize = ((Model)getRootOfTheModel()).getPackagedElements().size();
			Assert.assertTrue(newSize == size);

			//we test the redo
			Assert.assertTrue(getCommandStack().canRedo());
			getCommandStack().redo();
			newSize = ((Model)getRootOfTheModel()).getPackagedElements().size();
			Assert.assertTrue(newSize == size - 1);
			size = newSize;
		}
		int newSize = ((Model)getRootOfTheModel()).getPackagedElements().size();
		Assert.assertTrue(newSize == 0);
		undoRedo(10);
	}


	@Test
	public void deleteReadOnlyElementsTest() {
		Assert.fail();
		//TODO this tests doesn't work because the method revealSemanticElement is not able to reveal imported element
		//		testIsModelExplorerActivePart();
		//
		//		List<PackageImport> packageImports = ((Model)getRootOfTheModel()).getPackageImports();
		//		EObject elementToDelete;
		//		for(int i = 0; i < packageImports.size(); i++) {
		//			//we clean the selection
		//			getCommonViewer().setSelection(new StructuredSelection());
		//			IStructuredSelection currentSelection = getCurrentSelection();
		//			Assert.isTrue(currentSelection.isEmpty());
		//
		//			List<EObject> selectedElement = new ArrayList<EObject>();
		//			selectedElement.add(packageImports.get(i).getImportedPackage());
		//			getModelExplorerView().revealSemanticElement(selectedElement);
		//			currentSelection = getCurrentSelection();
		////			IContentProvider contentProvider = getModelExplorerView().getCommonViewer().getContentProvider();
		////			Object[] children = ((ITreeContentProvider)contentProvider).getChildren(currentSelection.getFirstElement());
		////			for(int iter = 0; iter < children.length; iter++) {
		////				Object tcurrent = children[0];
		////				int d = 0;
		////				d++;
		////			}
		////			selectedElement.clear();
		//			elementToDelete = packageImports.get(i);
		////			selectedElement.add(elementToDelete);
		//
		//			getModelExplorerView().revealSemanticElement(selectedElement);
		//
		//
		//			currentSelection = getCurrentSelection();
		//			Assert.isTrue(currentSelection.size() == 1, "Only one element should be selected");
		//			Object obj = currentSelection.getFirstElement();
		//			if(obj instanceof IAdaptable) {
		//				obj = ((IAdaptable)obj).getAdapter(EObject.class);
		//			}
		//			Assert.isTrue(obj == elementToDelete);
		//			IHandler currentHandler = getActiveHandler();
		//			Assert.isTrue(currentHandler.isEnabled(), "We can't delete the following element" + elementToDelete);
		//		}
	}
}
