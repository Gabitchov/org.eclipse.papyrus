package org.eclipse.papyrus.sysml.diagram.internalblock.tests;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.sysml.diagram.internalblock.Activator;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.intro.IIntroPart;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Abstract Papyrus initialization class (required to get Service activation).
 */
public abstract class AbstractTest {

	public static boolean isInitialized = false;

	public static IEditorPart editor = null;
	
	public static String editorID = "org.eclipse.papyrus.infra.core.papyrusEditor";

	@BeforeClass
	public static void openPapyrusWithAnEmptyProject() throws Exception {
		IIntroPart introPart = PlatformUI.getWorkbench().getIntroManager().getIntro();
		PlatformUI.getWorkbench().getIntroManager().closeIntro(introPart);
		// Prepare new project for tests
		IProject testProject = ResourcesPlugin.getWorkspace().getRoot().getProject("TestProject");
		if(!testProject.exists()) {
			testProject.create(new NullProgressMonitor());
		}

		if(!testProject.isOpen()) {
			testProject.open(new NullProgressMonitor());
		}

		// Copy EmptyModel from bundle to the test project
		IFile emptyModel_di = testProject.getFile("ModelWithIBD.di");
		IFile emptyModel_no = testProject.getFile("ModelWithIBD.notation");
		IFile emptyModel_uml = testProject.getFile("ModelWithIBD.uml");

		if(!isInitialized) {
			isInitialized = true;
			emptyModel_di.create(Activator.getInstance().getBundle().getResource("/model/ModelWithIBD.di").openStream(), true, new NullProgressMonitor());
			emptyModel_no.create(Activator.getInstance().getBundle().getResource("/model/ModelWithIBD.notation").openStream(), true, new NullProgressMonitor());
			emptyModel_uml.create(Activator.getInstance().getBundle().getResource("/model/ModelWithIBD.uml").openStream(), true, new NullProgressMonitor());
		}
		
		// Open the EmptyModel.di file with Papyrus (assumed to be the default editor for "di" files here).
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		editor = page.openEditor(new FileEditorInput(emptyModel_di), editorID);
	}

	@AfterClass
	public static void closePapyrusAndCleanProject() throws Exception {
		// Close the editor without saving content created during tests
		IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		page.closeEditor(editor, false);
	}
}
