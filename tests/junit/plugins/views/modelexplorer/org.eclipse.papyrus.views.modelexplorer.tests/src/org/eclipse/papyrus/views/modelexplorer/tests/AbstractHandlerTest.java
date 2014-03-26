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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.internal.treeproxy.TreeElement;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.FileUtils;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.internal.handlers.HandlerProxy;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.ui.part.IPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.osgi.framework.Bundle;

//TODO a part of this plugin should be moved in an upper test plugin
public abstract class AbstractHandlerTest {

	/** the di extension */
	protected static final String EXTENSION_DI = ".di"; //$NON-NLS-1$

	/** the notation extension */
	protected static final String EXTENSION_NOTATION = ".notation"; //$NON-NLS-1$

	/** the uml extension */
	protected static final String EXTENSION_UML = ".uml"; //$NON-NLS-1$

	/** the name of the file to open */
	protected static final String FILE_NAME = "model"; //$NON-NLS-1$

	/** the name of the project used to test the handler */
	protected static final String PROJECT_NAME = "Project Handler Test"; //$NON-NLS-1$

	/** the id of the model explorer */
	public static final String viewId = "org.eclipse.papyrus.views.modelexplorer.modelexplorer"; //$NON-NLS-1$

	/** the root of the model */
	protected EObject modelRoot;

	protected ModelExplorerView modelExplorerView;

	protected Command testedCommand;

	protected CommonViewer commonViewer;

	protected ISelectionService selectionService;

	protected final String commandId;

	protected CoreMultiDiagramEditor editor;

	/**
	 * the bundle to use to get the model to test
	 */
	protected final Bundle bundle;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param bundle
	 *        the bundle used to load the model
	 */
	public AbstractHandlerTest(Bundle bundle) {
		this(null, bundle);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param commandId
	 *        the id of the command to test
	 */
	public AbstractHandlerTest(String commandId, Bundle bundle) {
		Assert.assertNotNull("Bundle can't be null to do the test.", bundle);
		this.commandId = commandId;
		this.bundle = bundle;
	}

	/**
	 * 
	 * @param file
	 *        the file to open
	 * @return the opened editor
	 * @throws PartInitException
	 */
	// TODO should be moved in an upper plugin test
	protected IEditorPart openEditor(final IFile file) throws PartInitException {
		RunnableWithResult<IEditorPart> runnable;
		Display.getDefault().syncExec(runnable = new RunnableWithResult.Impl<IEditorPart>() {

			public void run() {
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				try {
					IEditorPart editor = IDE.openEditor(activePage, file);
					setResult(editor);
					setStatus(Status.OK_STATUS);
				} catch (Exception ex) {
					setStatus(new Status(IStatus.ERROR, bundle.getSymbolicName(), "Cannot open the editor"));
				}
			}
		});

		Assert.assertEquals(runnable.getStatus().getMessage(), IStatus.OK, runnable.getStatus().getSeverity());

		return runnable.getResult();
	}

	/**
	 * This method tests if the active part is the model explorer
	 */
	protected void testIsModelExplorerActivePart() {
		RunnableWithResult<IWorkbenchPart> activePartRunnable;
		Display.getDefault().syncExec(activePartRunnable = new RunnableWithResult.Impl<IWorkbenchPart>(){
			public void run(){
				IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IWorkbenchPart activePart = activePage.getActivePart();
				setResult(activePart);
			}
		});

		Assert.assertTrue("The active part is not the ModelExplorer", activePartRunnable.getResult() instanceof ModelExplorerPageBookView); //$NON-NLS-1$
	}

	/**
	 * This method selects an element in the modelexplorer and test that the new
	 * selection is the wanted selection using assertion
	 * 
	 * @param elementToSelect
	 *        the element to select
	 */
	protected void selectElementInTheModelexplorer(EObject elementToSelect) {
		final List<EObject> selectedElement = new ArrayList<EObject>();
		selectedElement.add(elementToSelect);
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				modelExplorerView.revealSemanticElement(selectedElement);
			}
		});

		IStructuredSelection currentSelection = (IStructuredSelection)selectionService.getSelection();
		Assert.assertEquals("Only one element should be selected", 1, currentSelection.size()); //$NON-NLS-1$
		Object obj = currentSelection.getFirstElement();
		obj = EMFHelper.getEObject(obj);
		Assert.assertSame("the current selected element is not the wanted element", elementToSelect, obj); //$NON-NLS-1$
	}

	/**
	 * This method selects an element in the modelexplorer and test that the new
	 * selection is the wanted selection using assertion
	 * 
	 * @param elementToSelect
	 *        the element to select
	 */
	protected void selectElementInTheModelexplorer(final TreeElement elementToSelect) {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				commonViewer.setSelection(new StructuredSelection(elementToSelect));
			}
		});

		IStructuredSelection currentSelection = (IStructuredSelection)selectionService.getSelection();
		Assert.assertEquals("Only one element should be selected", 1, currentSelection.size()); //$NON-NLS-1$
		Object obj = currentSelection.getFirstElement();
		Assert.assertSame("the current selected element is not the wanted element", elementToSelect, obj); //$NON-NLS-1$
	}

	protected IStructuredSelection getCurrentSelection() {
		return (IStructuredSelection)selectionService.getSelection();
	}

	/**
	 * 
	 * @return the current handler for the command
	 */
	protected IHandler getActiveHandler() {
		IHandler currentHandler = testedCommand.getHandler();
		if(currentHandler instanceof HandlerProxy) {
			currentHandler = ((HandlerProxy)currentHandler).getHandler();
		}
		return currentHandler;
	}

	@Before
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

				commonViewer.expandToLevel(2);

				// store the root of the model
				Object[] visibleElement = commonViewer.getVisibleExpandedElements();
				modelRoot = EMFHelper.getEObject(visibleElement[0]);

				List<Customization> appliedCustomizations=org.eclipse.papyrus.views.modelexplorer.Activator.getDefault().getCustomizationManager().getManagedCustomizations();
				Customization SimpleUML=null;
				Iterator<?>iter=appliedCustomizations.iterator();
				while(iter.hasNext()) {
					Customization custo = (Customization)iter.next();
					if( custo.getName().equals("SimpleUML")){
						SimpleUML=custo;
					}
				}
				org.junit.Assert.assertNotNull("Custom SimpleUML not found", SimpleUML);
				org.eclipse.papyrus.views.modelexplorer.Activator.getDefault().getCustomizationManager().getManagedCustomizations().add(0, SimpleUML);
				setStatus(Status.OK_STATUS);
			}
		});

		Assert.assertEquals(runnable.getStatus().getMessage(), IStatus.OK, runnable.getStatus().getSeverity());

		while(modelRoot.eContainer() != null) {
			modelRoot = modelRoot.eContainer();
		}
	}

	/**
	 * 
	 * @return the root of the model
	 */
	public EObject getRootOfTheModel() {
		return modelRoot;
	}

	/**
	 * 
	 * @return the model explorer view
	 */
	public ModelExplorerView getModelExplorerView() {
		return modelExplorerView;
	}

	/**
	 * 
	 * @return the common viewer
	 */
	public CommonViewer getCommonViewer() {
		return commonViewer;
	}

	public TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(getRootOfTheModel());
	}

	public CommandStack getCommandStack() {
		return getEditingDomain().getCommandStack();
	}

	public void undoRedoTest() {
		Assert.assertTrue("I can't undo the command!", getCommandStack().canUndo());
		getCommandStack().undo();
		Assert.assertTrue("I can't Redo the command!", getCommandStack().canRedo());
		getCommandStack().redo();
	}

	public void undoRedo(int time) {
		for(int i = 0; i < time; i++) {
			undoRedoTest();
		}
	}

	@After
	public void endOfTests() {
		Display.getDefault().syncExec(new Runnable() {

			public void run() {
				// So that the Workbench can be closed.
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeEditor(editor, false);
			}
		});
	}
}
