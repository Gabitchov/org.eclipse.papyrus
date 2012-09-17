/**
 * 
 */
package org.eclipse.papyrus.infra.core.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcoreFactory;
import org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource.ModelKind;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Run as "JUnit Plugin-Test"
 * 
 * @author cedric dumoulin
 *
 */
public class AbstractModelWithSharedResourceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test that the resource is created only once.
	 * Test method for {@link org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#createModel(org.eclipse.core.runtime.IPath)}.
	 */
	@Test
	public void testCreateModel() {
		
		String model1Key = "ecore";
		String model2Key = "genmodel";

		// Create models with different key, but use same extension (default from FakeModelWithSharedResource)
		FakeModelWithSharedResource<EPackage> model1 = new FakeModelWithSharedResource<EPackage>(ModelKind.master, model1Key, EPackage.class);
		FakeModelWithSharedResource<EClass> model2 = new FakeModelWithSharedResource<EClass>(model2Key, EClass.class);
		
		ModelSet modelSet = new ModelSet();
		modelSet.registerModel(model1);
		modelSet.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.infra.core");
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);

		// Call creates
		modelSet.createsModels(model1File);
		
		// Do check
		assertNotNull( "resource created", model1.getResouce() );
		assertNotNull( "resource created", model2.getResouce() );
		assertEquals("Resource is shared", model1.getResouce(), model2.getResouce());

		
	}

	/**
	 * Create and save models.
	 * @throws IOException 
	 * @throws CoreException 
	 */
	private void createAndSave(String model1Key, String model2Key) throws IOException, CoreException {

		FakeModelWithSharedResource<EPackage> model1 = new FakeModelWithSharedResource<EPackage>(ModelKind.master, model1Key, EPackage.class);
		FakeModelWithSharedResource<EClass> model2 = new FakeModelWithSharedResource<EClass>(model2Key, EClass.class);
		
		ModelSet modelSet = new ModelSet();
		modelSet.registerModel(model1);
		modelSet.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.infra.core");
		if(!p.exists())
			  p.create(new NullProgressMonitor());
		p.open(new NullProgressMonitor());
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);
		
		// Call creates and save
		
		modelSet.createsModels(model1File);
		model1.getResouce().setModified(true);
		modelSet.save(new NullProgressMonitor());
		modelSet.unload();
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#loadModel(org.eclipse.core.runtime.IPath)}.
	 * @throws CoreException 
	 * @throws IOException 
	 * @throws ModelMultiException 
	 */
	@Test
	public void testLoadModelIPath() throws IOException, CoreException, ModelMultiException {
		
		
		String model1Key = "ecore";
		String model2Key = "genmodel";
		
		createAndSave(model1Key, model2Key);

		FakeModelWithSharedResource<EPackage> model1 = new FakeModelWithSharedResource<EPackage>(ModelKind.master, model1Key, EPackage.class);
		FakeModelWithSharedResource<EClass> model2 = new FakeModelWithSharedResource<EClass>(model2Key, EClass.class);
		
		ModelSet modelSet = new ModelSet();
		modelSet.registerModel(model1);
		modelSet.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.infra.core");
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);

		// Call creates
		modelSet.loadModels(model1File);
		
		// Do check
		assertNotNull( "resource loaded", model1.getResouce() );
		assertNotNull( "resource loaded", model2.getResouce() );
		assertEquals("Resource is shared", model1.getResouce(), model2.getResouce());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#saveModel()}.
	 * @throws IOException 
	 * @throws CoreException 
	 */
	@Test
	public void testSaveModel() throws IOException, CoreException {
		String model1Key = "ecore";
		String model2Key = "genmodel";

		FakeModelWithSharedResource<EPackage> model1 = new FakeModelWithSharedResource<EPackage>(ModelKind.master, model1Key, EPackage.class);
		FakeModelWithSharedResource<EClass> model2 = new FakeModelWithSharedResource<EClass>(model2Key, EClass.class);
		
		ModelSet modelSet = new ModelSet();
		modelSet.registerModel(model1);
		modelSet.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.infra.core");
		if(!p.exists())
			  p.create(new NullProgressMonitor());
		p.open(new NullProgressMonitor());
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);
		
		// Call creates and save
		
		modelSet.createsModels(model1File);
		model1.getResouce().setModified(true);
		modelSet.save(new NullProgressMonitor());
		
		// Do check
		assertNotNull( "resource created", model1.getResouce() );
		assertNotNull( "resource created", model2.getResouce() );
		assertEquals("Resource is shared", model1.getResouce(), model2.getResouce());
		// Check weither it is save
		assertFalse("Resource is saved", model1.getResouce().isModified());
		assertFalse("Resource is saved", model2.getResouce().isModified());
		// TODO : check that it is saved only once !

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#getModelRoot()}.
	 */
	@Test
	public void testGetModelRoot() {
		String model1Key = "ecore";
		String model2Key = "genmodel";

		FakeModelWithSharedResource<EPackage> model1 = new FakeModelWithSharedResource<EPackage>(ModelKind.master, model1Key, EPackage.class);
		FakeModelWithSharedResource<EClass> model2 = new FakeModelWithSharedResource<EClass>(model2Key, EClass.class);
		
		ModelSet modelSet = new ModelSet();
		modelSet.registerModel(model1);
		modelSet.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.infra.core");
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);

		// Call creates 
		modelSet.createsModels(model1File);
		// Add elements in both model
		EPackage p1 = EcoreFactory.eINSTANCE.createEPackage();
		model1.addModelRoot(p1);
		
		EClass c1 = EcoreFactory.eINSTANCE.createEClass();
		model2.addModelRoot(c1);
		
		// Do check
		assertEquals( "root found", p1, model1.getModelRoot() );
		assertEquals( "root found", c1, model2.getModelRoot() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#getModelRoot()}.
	 */
	@Test
	public void testGetModelRoots() {
		String model1Key = "ecore";
		String model2Key = "genmodel";

		FakeModelWithSharedResource<EPackage> model1 = new FakeModelWithSharedResource<EPackage>(ModelKind.master, model1Key, EPackage.class);
		FakeModelWithSharedResource<EClass> model2 = new FakeModelWithSharedResource<EClass>(model2Key, EClass.class);
		
		ModelSet modelSet = new ModelSet();
		modelSet.registerModel(model1);
		modelSet.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.infra.core");
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);

		// Call creates 
		modelSet.createsModels(model1File);
		// Add elements in both model
		EPackage p1 = EcoreFactory.eINSTANCE.createEPackage();
		model1.addModelRoot(p1);
		EPackage p2 = EcoreFactory.eINSTANCE.createEPackage();
		model1.addModelRoot(p2);
		EPackage p3 = EcoreFactory.eINSTANCE.createEPackage();
		model1.addModelRoot(p3);
		
		EClass c1 = EcoreFactory.eINSTANCE.createEClass();
		model2.addModelRoot(c1);
		EClass c2 = EcoreFactory.eINSTANCE.createEClass();
		model2.addModelRoot(c2);
		EClass c3 = EcoreFactory.eINSTANCE.createEClass();
		model2.addModelRoot(c3);
		
		// Do check
		List<EPackage> lp = model1.getModelRoots();
		List<EClass> lc = model2.getModelRoots();
		
		assertNotNull("list exist", lp );
		assertEquals("list size", 3, lp.size());
		assertTrue("element found", lp.contains(p1));
		assertTrue("element found", lp.contains(p2));
		assertTrue("element found", lp.contains(p3));
		
		assertNotNull("list exist", lc );
		assertEquals("list size", 3, lc.size());
		assertTrue("element found", lc.contains(c1));
		assertTrue("element found", lc.contains(c2));
		assertTrue("element found", lc.contains(c3));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.infra.core.resource.AbstractModelWithSharedResource#addModelRoot(org.eclipse.emf.ecore.EObject)}.
	 */
	@Test
	public void testAddModelRoot() {
		String model1Key = "ecore";
		String model2Key = "genmodel";

		FakeModelWithSharedResource<EPackage> model1 = new FakeModelWithSharedResource<EPackage>(ModelKind.master, model1Key, EPackage.class);
		FakeModelWithSharedResource<EClass> model2 = new FakeModelWithSharedResource<EClass>(model2Key, EClass.class);
		
		ModelSet modelSet = new ModelSet();
		modelSet.registerModel(model1);
		modelSet.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.infra.core");
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);

		// Call creates 
		modelSet.createsModels(model1File);
		// Add elements in both model
		EPackage p1 = EcoreFactory.eINSTANCE.createEPackage();
		model1.addModelRoot(p1);
		
		EClass c1 = EcoreFactory.eINSTANCE.createEClass();
		model2.addModelRoot(c1);
		
		// Do check
		assertTrue("model contain element", model1.getResouce().getContents().contains(p1) );
		assertTrue("model contain element", model2.getResouce().getContents().contains(c1) );
	}

}
