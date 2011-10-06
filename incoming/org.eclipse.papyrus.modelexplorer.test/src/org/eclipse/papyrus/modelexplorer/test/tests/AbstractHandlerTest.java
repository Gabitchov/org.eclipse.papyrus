/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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
package org.eclipse.papyrus.modelexplorer.test.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.infra.browser.uicore.internal.model.ITreeElement;
import org.eclipse.emf.facet.util.core.internal.FileUtils;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.modelexplorer.test.Activator;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;
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
import org.eclipse.uml2.uml.Package;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;


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

	/** all the papyrus tables of the model */
	protected List<PapyrusTableInstance> papyrusTable = new ArrayList<PapyrusTableInstance>();

	/** all the papyrus diagrams of the model */
	protected List<Diagram> diagrams = new ArrayList<Diagram>();

	/** the id of the model explorer */
	protected static final String viewId = "org.eclipse.papyrus.modelexplorer.modelexplorer"; //$NON-NLS-1$

	/** the root of the model */
	protected Package rootOfTheModel;

	/** the model explorer view */
	protected ModelExplorerView modelExplorerView;

	/** the tested command */
	protected Command testedCommand;

	/** the common viewer */
	protected CommonViewer commonViewer;

	/** the selection servive */
	protected ISelectionService selectionService;

	/** the id of the command to test */
	private String commandId;

	/** the IPageMngr */
	private IPageMngr pageManager;

	/**
	 * useful messages for the tests
	 */
	public static final String INITIALIZATION_ERROR = "Initialization error"; //$NON-NLS-1$

	public static final String IT_IS_NOT_THE_REQUIRED_BEHAVIOR = "It is not the required behavior"; //$NON-NLS-1$

	public static final String THE_HANDLER = "The handler"; //$NON-NLS-1$


	/**
	 * 
	 * Constructor.
	 * 
	 * @param commandId
	 *        the id of the command to test
	 */
	public AbstractHandlerTest(String commandId) {
		this.commandId = commandId;
	}

	/**
	 * 
	 * @param file
	 *        the file to open
	 * @return
	 *         the opened editor
	 * @throws PartInitException
	 */
	protected IEditorPart openEditor(final IFile file) throws PartInitException {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = IDE.openEditor(activePage, file);
		return editor;
	}

	/**
	 * This method tests if the active part is the model explorer
	 */
	protected void testIsModelExplorerActivePart() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IWorkbenchPart activePart = activePage.getActivePart();
		Assert.isTrue(activePart instanceof ModelExplorerPageBookView, "The active part is not the ModelExplorer"); //$NON-NLS-1$
	}

	/**
	 * This method selects an element in the modelexplorer and test that the new selection is the wanted selection using assertion
	 * 
	 * @param elementToSelect
	 *        the element to select
	 */
	protected void selectElementInTheModelexplorer(final EObject elementToSelect) {
		List<EObject> selectedElement = new ArrayList<EObject>();
		selectedElement.add(elementToSelect);
		modelExplorerView.revealSemanticElement(selectedElement);
		IStructuredSelection currentSelection = (IStructuredSelection)selectionService.getSelection();
		Assert.isTrue(!((IStructuredSelection)currentSelection).isEmpty(), "The current selection is empty!"); //$NON-NLS-1$
		Assert.isTrue(((IStructuredSelection)currentSelection).size() == 1, "Only one element should be selected"); //$NON-NLS-1$
		Object obj = currentSelection.getFirstElement();
		if(obj instanceof IAdaptable) {
			obj = ((IAdaptable)obj).getAdapter(EObject.class);
		}
		Assert.isTrue(obj == elementToSelect, "the current selected element is not the wanted element"); //$NON-NLS-1$
	}

	/**
	 * This method selects an element in the modelexplorer and test that the new selection is the wanted selection using assertion
	 * 
	 * @param elementToSelect
	 *        the element to select
	 */
	protected void selectElementInTheModelexplorer(final ITreeElement elementToSelect) {
		commonViewer.setSelection(new StructuredSelection(elementToSelect));
		IStructuredSelection currentSelection = (IStructuredSelection)selectionService.getSelection();
		Assert.isTrue(((IStructuredSelection)currentSelection).size() == 1, "Only one element should be selected"); //$NON-NLS-1$
		Object obj = currentSelection.getFirstElement();
		Assert.isTrue(obj == elementToSelect, "the current selected element is not the wanted element"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return
	 *         the current handler for the command
	 */
	protected IHandler getActiveHandler() {
		IHandler currentHandler = testedCommand.getHandler();
		if(currentHandler instanceof HandlerProxy) {
			currentHandler = ((HandlerProxy)currentHandler).getHandler();
		}
		return currentHandler;
	}

	/**
	 * This method cleans the workspace, creates a new project with the model and initialize the fields of the class
	 * 
	 * @throws CoreException
	 * @throws IOException
	 */
	@Before
	public void initTests() throws CoreException, IOException {
		//we clean the workspace and create a new project to test the handlers
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		for(IProject project : workspace.getRoot().getProjects()) {
			project.delete(true, new NullProgressMonitor());
		}
		IProject testProject = workspace.getRoot().getProject(AbstractHandlerTest.PROJECT_NAME);
		testProject.create(new NullProgressMonitor());
		testProject.open(new NullProgressMonitor());

		//we copy the file of the tested model in the new project
		Bundle bundle = Activator.getDefault().getBundle();
		FileUtils.copyFileFromBundle("/resources/" + FILE_NAME + EXTENSION_UML, //$NON-NLS-1$
			testProject, '/' + FILE_NAME + EXTENSION_UML, bundle);
		FileUtils.copyFileFromBundle("/resources/" + FILE_NAME + EXTENSION_NOTATION, //$NON-NLS-1$
			testProject, '/' + FILE_NAME + EXTENSION_NOTATION, bundle);
		FileUtils.copyFileFromBundle("/resources/" + FILE_NAME + EXTENSION_DI, //$NON-NLS-1$
			testProject, '/' + FILE_NAME + EXTENSION_DI, bundle);
		IFile file = testProject.getFile(FILE_NAME + EXTENSION_DI);

		//we open the editor
		CoreMultiDiagramEditor editor = (CoreMultiDiagramEditor)openEditor(file);

		//we store all the diagrams and tables of the model
		IEditorPart activeEditor = editor.getActiveEditor();
		pageManager = (IPageMngr)editor.getAdapter(IPageMngr.class);

		diagrams = getDiagrams();
		papyrusTable = getTables();

		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();

		//we look for the modelexplorer
		IViewPart modelexplorer = activeWorkbenchWindow.getActivePage().showView(viewId);
		ModelExplorerPageBookView view = (ModelExplorerPageBookView)modelexplorer;
		IPage currentPage = view.getCurrentPage();
		ModelExplorerPage page = (ModelExplorerPage)currentPage;
		IViewPart viewer = page.getViewer();
		modelExplorerView = (ModelExplorerView)viewer;
		modelExplorerView.setFocus();

		//we look for the common viewer
		commonViewer = modelExplorerView.getCommonViewer();

		//we look for the selection service
		selectionService = activeWorkbenchWindow.getSelectionService();

		//we look for the testedCommand
		ICommandService commandService = (ICommandService)activeWorkbenchWindow.getService(ICommandService.class);
		testedCommand = commandService.getCommand(commandId);

		commonViewer.expandToLevel(2);
		Object[] visibleElement = commonViewer.getVisibleExpandedElements();
		EObject el = null;
		if(visibleElement[0] instanceof IAdaptable) {
			el = (EObject)((IAdaptable)visibleElement[0]).getAdapter(EObject.class);
		}
		if(el instanceof org.eclipse.uml2.uml.Element) {
			rootOfTheModel = (Package)org.eclipse.papyrus.umlutils.PackageUtil.getRootPackage((org.eclipse.uml2.uml.Element)el);
		}
		Assert.isTrue(rootOfTheModel != null, INITIALIZATION_ERROR + " I can't find the root of the model"); //$NON-NLS-1$
		Assert.isTrue(commandId != null, INITIALIZATION_ERROR + " Initialization error : the commandid can't be null"); //$NON-NLS-1$
		Assert.isTrue(commonViewer != null, INITIALIZATION_ERROR + " I can' find the CommonViewer"); //$NON-NLS-1$
		Assert.isTrue(selectionService != null, INITIALIZATION_ERROR + " I can't find the SelectionService"); //$NON-NLS-1$
		Assert.isTrue(pageManager != null, INITIALIZATION_ERROR + " I can't find the IPageMngr"); //$NON-NLS-1$
		Assert.isTrue(diagrams.size() != 0, INITIALIZATION_ERROR + " I can't find diagrams in this model"); //$NON-NLS-1$
		Assert.isTrue(papyrusTable.size() != 0, INITIALIZATION_ERROR + " I can't find tables in this model"); //$NON-NLS-1$
	}

	/**
	 * 
	 * @return
	 *         the tables owned by the IPageMngr
	 */
	protected List<PapyrusTableInstance> getTables() {
		List<Object> pages = pageManager.allPages();
		List<PapyrusTableInstance> tables = new ArrayList<PapyrusTableInstance>();
		for(Object current : pages) {
			if(current instanceof PapyrusTableInstance) {
				tables.add((PapyrusTableInstance)current);
			}
		}
		return tables;
	}

	/**
	 * 
	 * @return
	 *         the diagrams owned by the IPageMngr
	 */
	protected List<Diagram> getDiagrams() {
		List<Object> pages = pageManager.allPages();
		List<Diagram> diagrams = new ArrayList<Diagram>();
		for(Object current : pages) {
			if(current instanceof Diagram) {
				diagrams.add((Diagram)current);
			}
		}
		return diagrams;
	}

	/**
	 * do an undo of the last executed command
	 */
	private void doUndo() {
		Assert.isTrue(getCommandStack().canUndo(), "I can't undo the last executed command"); //$NON-NLS-1$
		getCommandStack().undo();
	}

	/**
	 * do a redo on the last executed command
	 */
	private void doRedo() {
		Assert.isTrue(getCommandStack().canRedo(), "I can't redo the last executed command"); //$NON-NLS-1$
		getCommandStack().redo();
	}

	/**
	 * Execute the current command
	 * @throws NotDefinedException
	 * @throws NotEnabledException
	 * @throws NotHandledException
	 * @throws ExecutionException
	 */
	protected void executeActiveCommand() throws NotDefinedException, NotEnabledException, NotHandledException, ExecutionException {
		testedCommand.executeWithChecks(new ExecutionEvent(testedCommand, Collections.emptyMap(), null, null));
	}

	/**
	 * 
	 * @return
	 *         the command stack
	 */
	private CommandStack getCommandStack() {
		EditingDomain domain = modelExplorerView.getEditingDomain();
		Assert.isNotNull(domain, "I can't find the EditingDomain"); //$NON-NLS-1$
		CommandStack commandStack = domain.getCommandStack();
		Assert.isNotNull(commandStack, "I can't find the CommandStack"); //$NON-NLS-1$
		return commandStack;
	}

	/**
	 * 
	 * @param time
	 *        the number of time we want to do Undo/Redo
	 */
	protected void doUndoRedo(int time) {
		Assert.isTrue(time >= 1);//to be sure that the calling method is correctly written
		for(int i = 0; i < time; i++) {
			doUndo();
			doRedo();
		}
	}


	/**
	 * We close the editors
	 */
	@After
	public void endOfTests() {
		// So that the Workbench can be closed.
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
	}
}
