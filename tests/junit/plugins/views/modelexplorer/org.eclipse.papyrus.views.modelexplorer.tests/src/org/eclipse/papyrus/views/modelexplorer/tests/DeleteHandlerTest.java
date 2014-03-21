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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.EStructuralFeatureTreeElement;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.swt.widgets.Display;
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

		RunnableWithResult<IWorkbenchPart> runnable;

		Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<IWorkbenchPart>() {

			public void run() {
				try {
					IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
					IWorkbenchPart activePart = activePage.getActivePart();
					setResult(activePart);
					setStatus(Status.OK_STATUS);
				} catch (Exception ex) {
					setStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID, ex.getMessage()));
				}
			}
		});

		Assert.assertEquals(runnable.getStatus().getMessage(), IStatus.OK, runnable.getStatus().getSeverity());

		IWorkbenchPart activePart = runnable.getResult();

		Assert.assertTrue("The active part is not the ModelExplorer", activePart instanceof ModelExplorerPageBookView); //$NON-NLS-1$

		final IStructuredSelection currentSelection = getCurrentSelection();
		Assert.assertEquals("Only one element should be selected", currentSelection.size(), 1); //$NON-NLS-1$
		Object obj = currentSelection.getFirstElement();
			obj = EMFHelper.getEObject(obj);
		Assert.assertSame(getRootOfTheModel(), obj);
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

		RunnableWithResult<Object[]> runnable;
		Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<Object[]>() {

			public void run() {
				commonViewer.expandToLevel(3);
				setResult(commonViewer.getExpandedElements());
				setStatus(Status.OK_STATUS);
			}
		});

		final Object[] expandedElement = runnable.getResult();
		for(final Object object : expandedElement) {
			if(object instanceof EStructuralFeatureTreeElement) {
				selectElementInTheModelexplorer((EStructuralFeatureTreeElement)object);
				final IHandler handler = getActiveHandler();
				if(handler != null) {
					Assert.assertFalse("The handler " + handler + " is active on LinkItem, it is not the wanted behavior", handler.isEnabled()); //$NON-NLS-1$ //$NON-NLS-2$
				}
			}
		}
	}
}
