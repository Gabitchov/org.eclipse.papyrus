package org.eclipse.papyrus.sysml.diagram.blockdefinition.tests;



import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.core.editor.CoreMultiDiagramEditor;
import org.eclipse.papyrus.sysml.diagram.blockdefinition.Activator;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Abstract Papyrus initialization class (required to get Service activation).
 */
public abstract class AbstractTest {

	public static boolean isInitialized = false;

	public static IEditorPart editor = null;

	@BeforeClass public static void openPapyrusWithAnEmptyProject() throws Exception {

		// Only initialize once...
		if(!isInitialized) {
			isInitialized = true;

			try {
				
				// Prepare new project for tests
				IProject testProject = ResourcesPlugin.getWorkspace().getRoot().getProject("TestProject");
				if(!testProject.exists()) {
					testProject.create(new NullProgressMonitor());
				}
				if(!testProject.isOpen()) {
					testProject.open(new NullProgressMonitor());
				}

				// Copy test model from bundle to the test project
				IFile model_di = testProject.getFile("ModelWithBDD.di");
				IFile model_no = testProject.getFile("ModelWithBDD.notation");
				IFile model_uml = testProject.getFile("ModelWithBDD.uml");

				model_di.create(Activator.getInstance().getBundle().getResource("/model/ModelWithBDD.di").openStream(), true, new NullProgressMonitor());
				model_no.create(Activator.getInstance().getBundle().getResource("/model/ModelWithBDD.notation").openStream(), true, new NullProgressMonitor());
				model_uml.create(Activator.getInstance().getBundle().getResource("/model/ModelWithBDD.uml").openStream(), true, new NullProgressMonitor());

				// Open the EmptyModel.di file with Papyrus (assumed to be the default editor for "di" files here).
				IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
				IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(model_di.getName());
				editor = (CoreMultiDiagramEditor)page.openEditor(new FileEditorInput(model_di), desc.getId()).getAdapter(CoreMultiDiagramEditor.class);

			} catch (Exception e) {
				throw new Exception("Papyrus initialization failed (" + e.getMessage() + ").", e); // $NON-NLS-1$
			}
		}

	}

	@AfterClass	public static void closePapyrusAndCleanProject() throws Exception {
		editor.doSave(new NullProgressMonitor());
	}
}
