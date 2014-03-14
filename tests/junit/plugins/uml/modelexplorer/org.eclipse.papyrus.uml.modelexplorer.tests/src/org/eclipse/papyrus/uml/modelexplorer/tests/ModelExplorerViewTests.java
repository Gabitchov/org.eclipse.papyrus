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

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.tests.AbstractHandlerTest;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Package;
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
	public void revealSemanticElement_selectRootTest() {
		final List<EObject> selectedElement = new ArrayList<EObject>();
		selectedElement.add(getRootOfTheModel());
		getModelExplorerView().revealSemanticElement(selectedElement);
		RunnableWithResult<IWorkbenchPart> activePartRunnable;
		Display.getDefault().syncExec(activePartRunnable = new RunnableWithResult.Impl<IWorkbenchPart>() {

			public void run() {
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IWorkbenchPart activePart = activePage.getActivePart();
				setResult(activePart);
			}
		});

		Assert.assertTrue("The active part is not the ModelExplorer", activePartRunnable.getResult() instanceof ModelExplorerPageBookView); //$NON-NLS-1$
		final IStructuredSelection currentSelection = getCurrentSelection();
		Assert.assertEquals("Only one element should be selected", 1, currentSelection.size()); //$NON-NLS-1$
		Object obj = currentSelection.getFirstElement();
		if(obj instanceof IAdaptable) {
			obj = ((IAdaptable)obj).getAdapter(EObject.class);
		}

		Assert.assertEquals("The function revealSemanticElement seems doesn't work on the root of the model", getRootOfTheModel(), obj);
	}


	/**
	 * tests the method reveal semantic element selects the correct element
	 */
	@Test
	public void revealSemanticElement_selectChildrenTest() {
		final List<EObject> selectedElement = new ArrayList<EObject>();
		final Package pack = (Package)getRootOfTheModel();
		final List<NamedElement> members = pack.getOwnedMembers();
		final int size = members.size();
		Assert.assertTrue(size != 0);//to be sure that the tested model is correct
		for(NamedElement current : members) {
			selectedElement.clear();
			selectedElement.add(current);

			RunnableWithResult<IWorkbenchPart> runnable;
			Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<IWorkbenchPart>() {

				public void run() {
					getModelExplorerView().revealSemanticElement(selectedElement);
					final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					final IWorkbenchPart activePart = activePage.getActivePart();

					setResult(activePart);
				}
			});

			IWorkbenchPart activePart = runnable.getResult();

			Assert.assertTrue("The active part is not the ModelExplorer", activePart instanceof ModelExplorerPageBookView); //$NON-NLS-1$
			final IStructuredSelection currentSelection = getCurrentSelection();
			Assert.assertTrue("Only one element should be selected", currentSelection.size() == 1); //$NON-NLS-1$
			Object obj = currentSelection.getFirstElement();
			if(obj instanceof IAdaptable) {
				obj = ((IAdaptable)obj).getAdapter(EObject.class);
			}
			Assert.assertTrue("The function revealSemanticElement seems doesn't work with children", obj == current);
		}
	}

	/**
	 * tests the method reveal semantic element on the root element
	 */
	@Test
	public void revealSemanticElement_selectChildrenTestList() {
		final List<EObject> selectedElement = new ArrayList<EObject>();
		final Package pack = (Package)getRootOfTheModel();
		final List<NamedElement> members = pack.getOwnedMembers();
		final int size = members.size();
		Assert.assertTrue(size != 0);//to be sure that the tested model is correct
		selectedElement.addAll(members);

		RunnableWithResult<IWorkbenchPart> runnable;
		Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<IWorkbenchPart>() {

			public void run() {
				getModelExplorerView().revealSemanticElement(selectedElement);
				final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				final IWorkbenchPart activePart = activePage.getActivePart();

				setResult(activePart);
			}
		});

		IWorkbenchPart activePart = runnable.getResult();


		Assert.assertTrue("The active part is not the ModelExplorer", activePart instanceof ModelExplorerPageBookView); //$NON-NLS-1$
		final IStructuredSelection currentSelection = getCurrentSelection();
		Assert.assertTrue("Multi selction doesn't work with the method revealSemanticElement", currentSelection.size() == size); //$NON-NLS-1$
	}

	/**
	 * tests the method reveal semantic element on the root element
	 */
	@Test
	public void revealSemanticElement_selectImportedPackage() {
		final List<EObject> selectedElement = new ArrayList<EObject>();
		final Package pack = (Package)getRootOfTheModel();
		final EList<Package> importedPackage = pack.getImportedPackages();
		final int size = importedPackage.size();
		Assert.assertTrue(size != 0);//to be sure that the tested model is correct
		for(NamedElement current : importedPackage) {

			waitForPendingMessages();

			selectedElement.clear();
			selectedElement.add(current);
			getModelExplorerView().revealSemanticElement(selectedElement);
			RunnableWithResult<IWorkbenchPart> activePartRunnable;
			Display.getDefault().syncExec(activePartRunnable = new RunnableWithResult.Impl<IWorkbenchPart>() {

				public void run() {
					IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					IWorkbenchPart activePart = activePage.getActivePart();
					setResult(activePart);
				}
			});

			Assert.assertTrue("The active part is not the ModelExplorer", activePartRunnable.getResult() instanceof ModelExplorerPageBookView); //$NON-NLS-1$
			final IStructuredSelection currentSelection = getCurrentSelection();
			Assert.assertEquals("I don't get the correct selection", 1, currentSelection.size()); //$NON-NLS-1$
			Object obj = currentSelection.getFirstElement();
			if(obj instanceof IAdaptable) {
				obj = ((IAdaptable)obj).getAdapter(EObject.class);
			}
			Assert.assertEquals("The function revealSemanticElement seems doesn't work with importedPackage", current, obj);
		}
	}

	private void waitForPendingMessages() {
		//Run all pending tasks to refresh the ModelExplorer
		if(Display.getCurrent() != null) {
			while(true) {
				try {
					if(!Display.getCurrent().readAndDispatch()) {
						break;
					}
				} catch (Throwable t) {
					Activator.log.error(t);
				}
			}
		}
	}

	@Test
	public void revealSemanticElement_selectImportedPackageList() {
		final List<EObject> selectedElement = new ArrayList<EObject>();
		final Package pack = (Package)getRootOfTheModel();
		final EList<Package> importedPackage = pack.getImportedPackages();
		final int size = importedPackage.size();
		Assert.assertNotSame(0, size);//to be sure that the tested model is correct

		//Run all pending tasks to refresh the ModelExplorer
		waitForPendingMessages();

		selectedElement.addAll(importedPackage);
		getModelExplorerView().revealSemanticElement(selectedElement);
		RunnableWithResult<IWorkbenchPart> activePartRunnable;
		Display.getDefault().syncExec(activePartRunnable = new RunnableWithResult.Impl<IWorkbenchPart>() {

			public void run() {
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IWorkbenchPart activePart = activePage.getActivePart();
				setResult(activePart);
			}
		});

		Assert.assertTrue("The active part is not the ModelExplorer", activePartRunnable.getResult() instanceof ModelExplorerPageBookView); //$NON-NLS-1$
		final IStructuredSelection currentSelection = getCurrentSelection();
		Assert.assertEquals("I don't get the current selection for revealSemanticElement_importedPackageList", 1, currentSelection.size()); //$NON-NLS-1$
	}
}
