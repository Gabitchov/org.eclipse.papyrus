package org.eclipse.papyrus.modelexplorer.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.Element;

import org.eclipse.core.commands.Command;
import org.eclipse.core.commands.CommandManager;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.util.core.internal.FileUtils;
import org.eclipse.gmf.runtime.emf.core.util.PackageUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.core.utils.PapyrusTrace;
import org.eclipse.papyrus.modelexplorer.ModelExplorerPage;
import org.eclipse.papyrus.modelexplorer.ModelExplorerPageBookView;
import org.eclipse.papyrus.modelexplorer.ModelExplorerView;
import org.eclipse.papyrus.modelexplorer.handler.DeleteCommandHandler;
import org.eclipse.papyrus.sasheditor.contentprovider.IPageMngr;
import org.eclipse.papyrus.table.instance.papyrustableinstance.PapyrusTableInstance;
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
import org.eclipse.ui.part.IPage;
import org.eclipse.ui.services.IServiceLocator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.osgi.framework.Bundle;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.navigator.CommonViewer;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.internal.impl.AssociationImpl;

/**
 * 
 * @author VL222926
 * 
 *         This plugin tests the activation of the correct handler for differents selection in the ModelExplorer
 */
//FIXME : remove the dependency with EMF-Facet
public class DeleteHandlerActivationTest {

	private static final String PROJECT_NAME = "Project Handler Test"; //$NON-NLS-1$

	private static final String EXTENSION_DI = ".di";

	private static final String EXTENSION_NOTATION = ".notation";

	private static final String EXTENSION_UML = ".uml";

	private static final String FILE_NAME = "model";

	private static final String COMMAND_TO_TEST = "org.eclipse.ui.edit.delete";

	protected static final String viewId = "org.eclipse.papyrus.modelexplorer.modelexplorer";

	private Package rootOfTheModel;


	private List<PapyrusTableInstance> papyrusTable = new ArrayList<PapyrusTableInstance>();

	private List<Diagram> diagrams = new ArrayList<Diagram>();

	protected ModelExplorerView modelExplorerView;

	protected Command testedCommand;

	protected CommonViewer commonViewer;

	protected ISelectionService selectionService;

	@Before
	public void initTests() throws CoreException, IOException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		for(IProject project : workspace.getRoot().getProjects()) {
			project.delete(true, new NullProgressMonitor());
		}
		IProject testProject = workspace.getRoot().getProject(DeleteHandlerActivationTest.PROJECT_NAME);
		testProject.create(new NullProgressMonitor());
		testProject.open(new NullProgressMonitor());

		Bundle bundle = Activator.getDefault().getBundle();
		FileUtils.copyFileFromBundle("/resources/" + FILE_NAME + EXTENSION_UML, //$NON-NLS-1$
			testProject, '/' + FILE_NAME + EXTENSION_UML, bundle);
		FileUtils.copyFileFromBundle("/resources/" + FILE_NAME + EXTENSION_NOTATION, //$NON-NLS-1$
			testProject, '/' + FILE_NAME + EXTENSION_NOTATION, bundle);
		FileUtils.copyFileFromBundle("/resources/" + FILE_NAME + EXTENSION_DI, //$NON-NLS-1$
			testProject, '/' + FILE_NAME + EXTENSION_DI, bundle);
		IFile file = testProject.getFile(FILE_NAME + EXTENSION_DI);
		editor = (CoreMultiDiagramEditor)openEditor(file);
		IEditorPart activeEditor = editor.getActiveEditor();
		IPageMngr pageManager = (IPageMngr)editor.getAdapter(IPageMngr.class);
		List<Object> pages = pageManager.allPages();
		int d = 0;
		d++;

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
		testedCommand = commandService.getCommand(COMMAND_TO_TEST);

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

	private CoreMultiDiagramEditor editor;


	private static IEditorPart openEditor(final IFile file) throws PartInitException {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorPart editor = IDE.openEditor(activePage, file);

		return editor;
	}

	/**
	 * We test if we can delete the root of the Model or not
	 */
	@Test
	public void deleteRootOfTheModel() {
		List<EObject> selectedElement = new ArrayList<EObject>();
		selectedElement.add(rootOfTheModel);
		modelExplorerView.revealSemanticElement(selectedElement);
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IWorkbenchPart activePart = activePage.getActivePart();
		Assert.isTrue(activePart instanceof ModelExplorerPageBookView, "The active part is not the ModelExplorer");

		IStructuredSelection currentSelection = (IStructuredSelection)selectionService.getSelection();
		Assert.isTrue(((IStructuredSelection)currentSelection).size() == 1, "Only one element should be selected");
		Object obj = currentSelection.getFirstElement();
		if(obj instanceof IAdaptable) {
			obj = ((IAdaptable)obj).getAdapter(EObject.class);
		}
		Assert.isTrue(obj == rootOfTheModel);
		IHandler currentHandler = testedCommand.getHandler();
		if(currentHandler == null) {
			//not a problem in this case
		} else {
			Assert.isTrue(currentHandler.isEnabled() == false, "We can delete the root of the model. It is not the wanted behavior");
		}
	}

	protected void testIsModelExplorerActivePart() {
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IWorkbenchPart activePart = activePage.getActivePart();
		Assert.isTrue(activePart instanceof ModelExplorerPageBookView, "The active part is not the ModelExplorer");
	}
	
	/**
	 * We test if we can delete other uml elements
	 */
	@Test
	public void deleteUMLElementsTest() {
		testIsModelExplorerActivePart();

		List<PackageableElement> packagedElements = rootOfTheModel.getPackagedElements();
		EObject elementToDelete;
		for(int i = 0; i < packagedElements.size(); i++) {
			//we need to clean the selection
			commonViewer.setSelection(new StructuredSelection());
			IStructuredSelection currentSelection = (IStructuredSelection)selectionService.getSelection();
			elementToDelete = packagedElements.get(i);
			List<EObject> selectedElement = new ArrayList<EObject>();
			selectedElement.add(elementToDelete);
			modelExplorerView.revealSemanticElement(selectedElement);
			currentSelection = (IStructuredSelection)selectionService.getSelection();
			Assert.isTrue(((IStructuredSelection)currentSelection).size() == 1, "Only one element should be selected");
			Object obj = currentSelection.getFirstElement();
			if(obj instanceof IAdaptable) {
				obj = ((IAdaptable)obj).getAdapter(EObject.class);
			}
			Assert.isTrue(obj == elementToDelete);
			IHandler currentHandler = testedCommand.getHandler();
			if(currentHandler instanceof HandlerProxy) {
				currentHandler = ((HandlerProxy)currentHandler).getHandler();
			}
			Assert.isTrue(currentHandler instanceof DeleteCommandHandler, "The current handler is " + currentHandler + " instead of org.eclipse.papyrus.modelexplorer.handler.DeleteCommandHandler");
			Assert.isTrue(currentHandler.isEnabled(), "We can't delete the following element" + elementToDelete);
		}
	}

	@Test
	public void deleteReadOnlyElementsTest() {
		testIsModelExplorerActivePart();

		List<PackageImport> packageImports = rootOfTheModel.getPackageImports();
		EObject elementToDelete;
		for(int i = 0; i < packageImports.size(); i++) {
			//we clean the selection
			commonViewer.setSelection(new StructuredSelection());
			IStructuredSelection currentSelection = (IStructuredSelection)selectionService.getSelection();
			Assert.isTrue(currentSelection.isEmpty());

			List<EObject> selectedElement = new ArrayList<EObject>();
			selectedElement.add(packageImports.get(i));
			modelExplorerView.revealSemanticElement(selectedElement);
			currentSelection = (IStructuredSelection)selectionService.getSelection();
			IContentProvider contentProvider = modelExplorerView.getCommonViewer().getContentProvider();
			Object[] children = ((ITreeContentProvider)contentProvider).getChildren(currentSelection.getFirstElement());
			for(int iter = 0; iter < children.length; iter++) {
				Object tcurrent = children[0];
				int d = 0;
				d++;
			}
			selectedElement.clear();
			elementToDelete = packageImports.get(0).getImportedPackage();
			selectedElement.add(elementToDelete);


			modelExplorerView.revealSemanticElement(selectedElement);


			currentSelection = (IStructuredSelection)selectionService.getSelection();
			Assert.isTrue(((IStructuredSelection)currentSelection).size() == 1, "Only one element should be selected");
			Object obj = currentSelection.getFirstElement();
			if(obj instanceof IAdaptable) {
				obj = ((IAdaptable)obj).getAdapter(EObject.class);
			}
			Assert.isTrue(obj == elementToDelete);
			IHandler currentHandler = testedCommand.getHandler();
			if(currentHandler instanceof HandlerProxy) {
				currentHandler = ((HandlerProxy)currentHandler).getHandler();
			}
			Assert.isTrue(currentHandler instanceof DeleteCommandHandler, "The current handler is " + currentHandler + " instead of org.eclipse.papyrus.modelexplorer.handler.DeleteCommandHandler");
			Assert.isTrue(currentHandler.isEnabled(), "We can't delete the following element" + elementToDelete);
		}
	}

	@Test
	public void deleteDiagramTest() {
		Assert.isTrue(false, "TODO");
	}

	@Test
	public void deletePapyrusTableInstanceTest() {
		Assert.isTrue(false, "TODO");
	}

	@Test
	public void deleteLinkTest() {
		Assert.isTrue(false, "TODO");
	}


	@After
	public void endOfTests() {
		// So that the Workbench can be closed.
		PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
	}
}
