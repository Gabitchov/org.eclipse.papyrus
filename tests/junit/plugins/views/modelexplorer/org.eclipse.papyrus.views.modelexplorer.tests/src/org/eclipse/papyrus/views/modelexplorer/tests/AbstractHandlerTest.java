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
import java.util.List;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.emf.facet.util.core.internal.exported.FileUtils;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.infra.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.views.modelexplorer.ModelExplorerView;
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
import org.eclipse.ui.intro.IIntroPart;
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
	private static final String PROJECT_NAME = "Project Handler Test"; //$NON-NLS-1$

	/** the id of the model explorer */
	public static final String viewId = "org.eclipse.papyrus.views.modelexplorer.modelexplorer"; //$NON-NLS-1$

	/** the root of the model */
	private EObject modelRoot;

	private ModelExplorerView modelExplorerView;

	private Command testedCommand;

	private CommonViewer commonViewer;

	private ISelectionService selectionService;

	private final String commandId;

	private CoreMultiDiagramEditor editor;

	/**
	 * the bundle to use to get the model to test
	 */
	private final Bundle bundle;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param bundle
	 *        the bundle used to load the model
	 */
	public AbstractHandlerTest(final Bundle bundle) {
		Assert.assertNotNull("Bundle can't be null to do the test.", bundle);
		this.bundle = bundle;
		this.commandId = null;
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param commandId
	 *        the id of the command to test
	 */
	public AbstractHandlerTest(final String commandId, final Bundle bundle) {
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
		final IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
		PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);

		final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final IEditorPart editor = IDE.openEditor(activePage, file);
		return editor;
	}

	/**
	 * This method tests if the active part is the model explorer
	 */
	protected void testIsModelExplorerActivePart() {
		final IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		final IWorkbenchPart activePart = activePage.getActivePart();
		Assert.assertTrue("The active part is not the ModelExplorer", activePart instanceof ModelExplorerPageBookView); //$NON-NLS-1$
	}

	/**
	 * This method selects an element in the modelexplorer and test that the new
	 * selection is the wanted selection using assertion
	 * 
	 * @param elementToSelect
	 *        the element to select
	 */
	protected void selectElementInTheModelexplorer(final EObject elementToSelect) {
		final List<EObject> selectedElement = new ArrayList<EObject>();
		selectedElement.add(elementToSelect);
		this.modelExplorerView.revealSemanticElement(selectedElement);
		final IStructuredSelection currentSelection = (IStructuredSelection)this.selectionService.getSelection();
		Assert.assertTrue("Only one element should be selected", currentSelection.size() == 1); //$NON-NLS-1$
		Object obj = currentSelection.getFirstElement();
		if(obj instanceof IAdaptable) {
			obj = ((IAdaptable)obj).getAdapter(EObject.class);
		}
		Assert.assertTrue("the current selected element is not the wanted element", obj == elementToSelect); //$NON-NLS-1$
	}

	/**
	 * This method selects an element in the modelexplorer and test that the new
	 * selection is the wanted selection using assertion
	 * 
	 * @param elementToSelect
	 *        the element to select
	 */
	protected void selectElementInTheModelexplorer(final ITreeElement elementToSelect) {
		this.commonViewer.setSelection(new StructuredSelection(elementToSelect));
		final IStructuredSelection currentSelection = (IStructuredSelection)this.selectionService.getSelection();
		Assert.assertTrue("Only one element should be selected", currentSelection.size() == 1); //$NON-NLS-1$
		final Object obj = currentSelection.getFirstElement();
		Assert.assertTrue("the current selected element is not the wanted element", obj == elementToSelect); //$NON-NLS-1$
	}

	protected IStructuredSelection getCurrentSelection() {
		return (IStructuredSelection)this.selectionService.getSelection();
	}

	/**
	 * 
	 * @return the current handler for the command
	 */
	protected IHandler getActiveHandler() {
		IHandler currentHandler = this.testedCommand.getHandler();
		if(currentHandler instanceof HandlerProxy) {
			currentHandler = ((HandlerProxy)currentHandler).getHandler();
		}
		return currentHandler;
	}

	@Before
	public void initTests() throws CoreException, IOException {
		final IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
		PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);

		// we clean the workspace and create a new project to test the handlers
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		for(final IProject project : workspace.getRoot().getProjects()) {
			project.delete(true, new NullProgressMonitor());
		}
		final IProject testProject = workspace.getRoot().getProject(AbstractHandlerTest.PROJECT_NAME);
		testProject.create(new NullProgressMonitor());
		testProject.open(new NullProgressMonitor());

		// we copy the file of the tested model in the new project
		FileUtils.copyFileFromBundle("/resources/" + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_UML, //$NON-NLS-1$
			testProject, '/' + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_UML, this.bundle);
		FileUtils.copyFileFromBundle("/resources/" + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_NOTATION, //$NON-NLS-1$
			testProject, '/' + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_NOTATION, this.bundle);
		FileUtils.copyFileFromBundle("/resources/" + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_DI, //$NON-NLS-1$
			testProject, '/' + AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_DI, this.bundle);
		final IFile file = testProject.getFile(AbstractHandlerTest.FILE_NAME + AbstractHandlerTest.EXTENSION_DI);

		// we open the editor
		this.editor = (CoreMultiDiagramEditor)openEditor(file);
		final IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		// we look for the modelexplorer
		final IViewPart modelexplorer = activeWorkbenchWindow.getActivePage().showView(AbstractHandlerTest.viewId);
		final ModelExplorerPageBookView view = (ModelExplorerPageBookView)modelexplorer;
		final IPage currentPage = view.getCurrentPage();
		final ModelExplorerPage page = (ModelExplorerPage)currentPage;
		final IViewPart viewer = page.getViewer();
		this.modelExplorerView = (ModelExplorerView)viewer;
		this.modelExplorerView.setFocus();

		// we look for the common viewer
		this.commonViewer = this.modelExplorerView.getCommonViewer();

		// we look for the selection service
		this.selectionService = activeWorkbenchWindow.getSelectionService();

		// we look for the testedCommand
		final ICommandService commandService = (ICommandService)activeWorkbenchWindow.getService(ICommandService.class);
		if(this.commandId != null) {
			this.testedCommand = commandService.getCommand(this.commandId);
		}

		this.commonViewer.expandToLevel(2);

		// store the root of the model
		final Object[] visibleElement = this.commonViewer.getVisibleExpandedElements();
		if(visibleElement[0] instanceof IAdaptable) {
			this.modelRoot = (EObject)((IAdaptable)visibleElement[0]).getAdapter(EObject.class);
		}

		while(this.modelRoot.eContainer() != null) {
			this.modelRoot = this.modelRoot.eContainer();
		}
	}

	/**
	 * 
	 * @return the root of the model
	 */
	public EObject getRootOfTheModel() {
		return this.modelRoot;
	}

	/**
	 * 
	 * @return the model explorer view
	 */
	public ModelExplorerView getModelExplorerView() {
		return this.modelExplorerView;
	}

	/**
	 * 
	 * @return the common viewer
	 */
	public CommonViewer getCommonViewer() {
		return this.commonViewer;
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

	public void undoRedo(final int time) {
		for(int i = 0; i < time; i++) {
			undoRedoTest();
		}
	}

	@After
	public void endOfTests() {
		// So that the Workbench can be closed.
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
	}
}
