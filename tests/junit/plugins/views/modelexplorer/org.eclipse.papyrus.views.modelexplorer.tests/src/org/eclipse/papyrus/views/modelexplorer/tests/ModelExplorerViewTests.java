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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.swt.widgets.Display;
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
		Assert.assertSame("The function revealSemanticElement seems doesn't work on the root of the model", obj, getRootOfTheModel()); //$NON-NLS-1$
	}

}
