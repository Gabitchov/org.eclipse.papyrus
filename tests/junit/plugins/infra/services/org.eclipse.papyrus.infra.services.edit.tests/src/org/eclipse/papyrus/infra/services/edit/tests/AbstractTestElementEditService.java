package org.eclipse.papyrus.infra.services.edit.tests;

import static org.junit.Assert.fail;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.gmf.runtime.emf.type.core.ClientContextManager;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IClientContext;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.MetamodelType;
import org.eclipse.papyrus.infra.services.edit.Activator;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditServiceProvider;
import org.eclipse.papyrus.infra.services.edit.tests.edit.helper.EPackageEditHelper;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * Abstract Papyrus initialization class (required to get Service activation).
 */
public abstract class AbstractTestElementEditService {

	protected static final String PAPYRUS_CONTEXT_ID = "org.eclipse.papyrus.infra.services.edit.TypeContext"; //$NON-NLS-1$

	protected IElementType eClassType;

	protected IElementType ePackgType;

	protected IElementEditServiceProvider service;

	@BeforeClass
	public static void openPapyrusWithAnEmptyProject() throws Exception {

		try {
			// Prepare new project for tests
			IProject testProject = ResourcesPlugin.getWorkspace().getRoot().getProject("TestProject");
			if(!testProject.exists()) {
				testProject.create(new NullProgressMonitor());
			}
			if(!testProject.isOpen()) {
				testProject.open(new NullProgressMonitor());
			}

			// Copy EmptyModel from bundle to the test project
			IFile emptyModel_di = testProject.getFile("EmptyModel.di");
			IFile emptyModel_no = testProject.getFile("EmptyModel.notation");
			IFile emptyModel_uml = testProject.getFile("EmptyModel.uml");

			emptyModel_di.create(Activator.getDefault().getBundle().getResource("/model/EmptyModel.di").openStream(), true, new NullProgressMonitor());
			emptyModel_no.create(Activator.getDefault().getBundle().getResource("/model/EmptyModel.notation").openStream(), true, new NullProgressMonitor());
			emptyModel_uml.create(Activator.getDefault().getBundle().getResource("/model/EmptyModel.uml").openStream(), true, new NullProgressMonitor());

			// Open the EmptyModel.di file with Papyrus (assumed to be the default editor for "di" files here).
			IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(emptyModel_di.getName());
			page.openEditor(new FileEditorInput(emptyModel_di), desc.getId());

		} catch (Exception e) {
			fail("Papyrus initialization failed (" + e.getMessage() + ")."); // $NON-NLS-1$
		}
	}

	@Before
	public void setUp() {
		// To prepare this test two element types are added to Papyrus Client Context
		ElementTypeRegistry.getInstance().register(new MetamodelType("ECLASS_TEST_ID", null, "ECLASS", EcorePackage.eINSTANCE.getEClass(), null)); //$NON-NLS-1$
		ElementTypeRegistry.getInstance().register(new MetamodelType("EPACKG_TEST_ID", null, "EPACKG", EcorePackage.eINSTANCE.getEPackage(), new EPackageEditHelper())); //$NON-NLS-1$

		eClassType = ElementTypeRegistry.getInstance().getType("ECLASS_TEST_ID");
		ePackgType = ElementTypeRegistry.getInstance().getType("EPACKG_TEST_ID");

		IClientContext context = ClientContextManager.getInstance().getClientContext(PAPYRUS_CONTEXT_ID);
		context.bindId("ECLASS_TEST_ID"); //$NON-NLS-1$
		context.bindId("EPACKG_TEST_ID"); //$NON-NLS-1$

		service = ElementEditServiceUtils.getEditServiceProvider();
	}

	@AfterClass
	public static void closePapyrusAndCleanProject() {
		// Close all editors
		boolean closed = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage().closeAllEditors(false);
		if(!closed) {
			fail("Could not close editors correctly.");
		}

		// Delete test project
		IProject testProject = ResourcesPlugin.getWorkspace().getRoot().getProject("TestProject");
		try {
			testProject.delete(true, new NullProgressMonitor());
		} catch (CoreException e) {
			fail("Could delete test project correctly (" + e.getMessage() + ").");
		}
	}
}
