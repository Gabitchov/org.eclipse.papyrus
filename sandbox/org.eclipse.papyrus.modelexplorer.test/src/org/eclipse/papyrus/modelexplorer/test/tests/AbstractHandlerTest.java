package org.eclipse.papyrus.modelexplorer.test.tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
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
	protected static final String EXTENSION_DI = ".di";

	/** the notation extension */
	protected static final String EXTENSION_NOTATION = ".notation";

	/** the uml extension */
	protected static final String EXTENSION_UML = ".uml";

	/** the name of the file to open */
	protected static final String FILE_NAME = "model";

	/** the name of the project used to test the handler */
	private static final String PROJECT_NAME = "Project Handler Test"; //$NON-NLS-1$

	/** all the papyrus tables of the model */
	protected List<PapyrusTableInstance> papyrusTable = new ArrayList<PapyrusTableInstance>();

	/** all the papyrus diagrams of the model */
	protected List<Diagram> diagrams = new ArrayList<Diagram>();

	/** the id of the model explorer */
	protected static final String viewId = "org.eclipse.papyrus.modelexplorer.modelexplorer";

	/** the root of the model */
	protected Package rootOfTheModel;

	protected ModelExplorerView modelExplorerView;

	protected Command testedCommand;

	protected CommonViewer commonViewer;

	protected ISelectionService selectionService;

	private String commandId;

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
		Assert.isTrue(activePart instanceof ModelExplorerPageBookView, "The active part is not the ModelExplorer");
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
		Assert.isTrue(((IStructuredSelection)currentSelection).size() == 1, "Only one element should be selected");
		Object obj = currentSelection.getFirstElement();
		if(obj instanceof IAdaptable) {
			obj = ((IAdaptable)obj).getAdapter(EObject.class);
		}
		Assert.isTrue(obj == elementToSelect, "the current selected element is not the wanted element");
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
		Assert.isTrue(((IStructuredSelection)currentSelection).size() == 1, "Only one element should be selected");
		Object obj = currentSelection.getFirstElement();
		Assert.isTrue(obj == elementToSelect, "the current selected element is not the wanted element");
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
		//TODO : a best way to do that?
		IEditorPart activeEditor = editor.getActiveEditor();
		IPageMngr pageManager = (IPageMngr)editor.getAdapter(IPageMngr.class);
		List<Object> pages = pageManager.allPages();

		for(Object current : pages) {
			if(current instanceof Diagram) {
				diagrams.add((Diagram)current);
			} else if(current instanceof PapyrusTableInstance) {
				papyrusTable.add((PapyrusTableInstance)current);
			}
		}



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
		for(int i = 0; i < visibleElement.length; i++) {
			System.out.println(visibleElement[i]);
		}
		EObject el = null;
		if(visibleElement[0] instanceof IAdaptable) {
			el = (EObject)((IAdaptable)visibleElement[0]).getAdapter(EObject.class);
		}
		if(el instanceof org.eclipse.uml2.uml.Element) {
			rootOfTheModel = (Package)org.eclipse.papyrus.umlutils.PackageUtil.getRootPackage((org.eclipse.uml2.uml.Element)el);
		}
		//TODO : test that all the fields are not null
	}



	@After
	public void endOfTests() {
		// So that the Workbench can be closed.
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
	}
}
