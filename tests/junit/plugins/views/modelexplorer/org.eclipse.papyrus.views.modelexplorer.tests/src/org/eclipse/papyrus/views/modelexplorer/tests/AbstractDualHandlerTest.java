/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Benoit Maggi (CEA LIST) benoit.maggi@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.modelexplorer.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.FileUtils;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.internal.handlers.HandlerProxy;
import org.eclipse.ui.part.IPage;
import org.junit.Assert;
import org.junit.Before;
import org.osgi.framework.Bundle;

/**
 * Just duplicate the mecanism to handle scenario with 2 handlers
 */
public abstract class AbstractDualHandlerTest extends AbstractHandlerTest{


	/** The second tested command. */
	protected Command secondTestedCommand;
	
	/** The second command id. */
	protected final String secondCommandId;	
	
	/**
	 * Instantiates a new abstract dual handler test.
	 *
	 * @param commandId the command id
	 * @param secondCommandId the second command id
	 * @param bundle the bundle
	 */
	public AbstractDualHandlerTest(String commandId, String secondCommandId, Bundle bundle) {
		super(commandId, bundle);
		this.secondCommandId = secondCommandId;
	}

	
	/**
	 * Gets the second active handler.
	 *
	 * @return the second active handler
	 */
	protected IHandler getSecondActiveHandler() {
		IHandler currentHandler = secondTestedCommand.getHandler();
		if(currentHandler instanceof HandlerProxy) {
			currentHandler = ((HandlerProxy)currentHandler).getHandler();
		}
		return currentHandler;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.views.modelexplorer.tests.AbstractHandlerTest#initTests()
	 */
	@Before
	@Override
	public void initTests() throws CoreException, IOException {
		// we clean the workspace and create a new project to test the handlers
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		for(IProject project : workspace.getRoot().getProjects()) {
			project.delete(true, new NullProgressMonitor());
		}
		IProject testProject = workspace.getRoot().getProject(AbstractHandlerTest.PROJECT_NAME);
		testProject.create(new NullProgressMonitor());
		testProject.open(new NullProgressMonitor());

		// we copy the file of the tested model in the new project
		FileUtils.copyFileFromBundle("/resources/" + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_UML, //$NON-NLS-1$
			testProject, '/' + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_UML, bundle);
		FileUtils.copyFileFromBundle("/resources/" + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_NOTATION, //$NON-NLS-1$
			testProject, '/' + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_NOTATION, bundle);
		FileUtils.copyFileFromBundle("/resources/" + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_DI, //$NON-NLS-1$
			testProject, '/' + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_DI, bundle);
		IFile file = testProject.getFile(AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_DI);

		// we open the editor
		editor = (CoreMultiDiagramEditor)openEditor(file);

		RunnableWithResult runnable;

		Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl() {

			public void run() {
				IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

				// we look for the modelexplorer
				IViewPart modelexplorer;
				try {
					modelexplorer = activeWorkbenchWindow.getActivePage().showView(AbstractHandlerTest.viewId);
				} catch (PartInitException ex) {
					ex.printStackTrace(System.out);
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), ex.getMessage()));
					return;
				}
				ModelExplorerPageBookView view = (ModelExplorerPageBookView)modelexplorer;
				IPage currentPage = view.getCurrentPage();
				ModelExplorerPage page = (ModelExplorerPage)currentPage;
				IViewPart viewer = page.getViewer();
				modelExplorerView = (ModelExplorerView)viewer;
				modelExplorerView.setFocus();

				// we look for the common viewer
				commonViewer = modelExplorerView.getCommonViewer();

				// we look for the selection service
				selectionService = activeWorkbenchWindow.getSelectionService();

				// we look for the testedCommand
				ICommandService commandService = (ICommandService)activeWorkbenchWindow.getService(ICommandService.class);
				if(commandId != null) {
					testedCommand = commandService.getCommand(commandId);
				}
				if(commandId != null) {
					secondTestedCommand = commandService.getCommand(secondCommandId);
				}
				
				commonViewer.expandToLevel(2);

				// store the root of the model
				Object[] visibleElement = commonViewer.getVisibleExpandedElements();
				modelRoot = EMFHelper.getEObject(visibleElement[0]);

				setStatus(Status.OK_STATUS);
			}
		});

		Assert.assertEquals(runnable.getStatus().getMessage(), IStatus.OK, runnable.getStatus().getSeverity());

		while(modelRoot.eContainer() != null) {
			modelRoot = modelRoot.eContainer();
		}
	}
	
	/**
	 * This method selects many elements in the modelexplorer and test that the new
	 * selection is the wanted selection using assertion
	 * 
	 * @param elementToSelect
	 *        the list element to select
	 */
	protected void selectListElementInTheModelexplorer(List<EObject> listElementToSelect) {
		final List<EObject> selectedElement = new ArrayList<EObject>();
		selectedElement.addAll(listElementToSelect);
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				modelExplorerView.revealSemanticElement(selectedElement);
			}
		});

		IStructuredSelection currentSelection = (IStructuredSelection)selectionService.getSelection();
		Assert.assertEquals("Only one element should be selected", listElementToSelect.size(), currentSelection.size()); //$NON-NLS-1$
	}
	
	
	
}
