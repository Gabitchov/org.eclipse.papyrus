package org.eclipse.papyrus.resource;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test for {@link ModelSet}.
 * <br> 
 * Run as "JUnit Plugin-Test"
 * 
 * @author cedric dumoulin
 *
 */
public class ModelSetTest {

	/**
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.resource.ModelSet.registerModel(IModel)} .
	 */
	@Test
	public void testRegisterModel() {
		ModelSet mngr = new ModelSet();
		
		FakeModel model1 = new FakeModel("model1");
		
		mngr.registerModel(model1);
		
		assertNotNull("mngr is set", model1.getModelManager());
		assertNotNull("model is registered", mngr.getModel("model1"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.resource.ModelSet#getModel(String)} .
	 */
	@Test
	public void testGetModel() {
		ModelSet mngr = new ModelSet();
		
		FakeModel model1 = new FakeModel("model1");
		FakeModel model2 = new FakeModel("model2");
		
		mngr.registerModel(model1);
		mngr.registerModel(model2);
		
		assertNotNull("model is registered", mngr.getModel("model1"));
		assertNotNull("model is registered", mngr.getModel("model2"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.resource.ModelSet#getTransactionalEditingDomain()} .
	 */
	@Test
	public void testGetTransactionalEditingDomain() {
		ModelSet mngr = new ModelSet();
		
		assertNotNull("editing domain created", mngr.getTransactionalEditingDomain() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.resource.ModelSet#createsModels(IFile)} .
	 */
	@Test
	public void testCreatesModels() throws IOException, CoreException {
		ModelSet mngr = new ModelSet();
		
		String model1Key = "ecore";
		String model2Key = "genmodel";
		
		FakeModel model1 = new FakeModel(model1Key);
		FakeModel model2 = new FakeModel(model2Key);
		
		mngr.registerModel(model1);
		mngr.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.core");
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);

		// Do create
		mngr.createsModels(model1File);
		
		assertNotNull( "resource created", model1.getResouce() );
		assertNotNull( "resource created", model2.getResouce() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.resource.ModelSet#loadModels(IFile)} .
	 */
	@Test
	public void testLoadModels() throws IOException, CoreException {
		
		// Create models so they exists
		testSave();
		
		// Now do load
		ModelSet mngr = new ModelSet();
		
		String model1Key = "ecore";
		String model2Key = "genmodel";
		
		FakeModel model1 = new FakeModel(model1Key);
		FakeModel model2 = new FakeModel(model2Key);
		
		mngr.registerModel(model1);
		mngr.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.core");
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);
		IFile model2File = p.getFile("tmp/model1." + model2Key);

		assertTrue("modelFile exist", model1File.exists());
		assertTrue("modelFile exist", model2File.exists());

		// Try to load
		mngr.loadModels(model1File);
		
		assertNotNull( "resource created", model1.getResouce() );
		assertNotNull( "resource created", model2.getResouce() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.resource.ModelSet#save(IProgressMonitor)} .
	 */
	@Test
	public void testSave() throws CoreException, IOException {
		ModelSet mngr = new ModelSet();
		
		String model1Key = "ecore";
		String model2Key = "genmodel";
		
		FakeModel model1 = new FakeModel(model1Key);
		FakeModel model2 = new FakeModel(model2Key);
		
		mngr.registerModel(model1);
		mngr.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.core");
		if(!p.exists())
		  p.create(new NullProgressMonitor());
		p.open(new NullProgressMonitor());
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);
		IFile model2File = p.getFile("tmp/model1." + model2Key);

		// Do create and save
		mngr.createsModels(model1File);
		mngr.save(new NullProgressMonitor());
		//
		assertTrue("resource created", model1File.exists());
		assertTrue("resource created", model2File.exists());
		//
		assertNotNull( "resource created", model1.getResouce() );
		assertNotNull( "resource created", model2.getResouce() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.resource.ModelSet#saveAs(IPath)} .
	 */
	@Test
	public void testSaveAs() throws CoreException, IOException {
		ModelSet mngr = new ModelSet();
		
		String model1Key = "ecore";
		String model2Key = "genmodel";
		
		FakeModel model1 = new FakeModel(model1Key);
		FakeModel model2 = new FakeModel(model2Key);
		
		mngr.registerModel(model1);
		mngr.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.core");
		if(!p.exists())
		  p.create(new NullProgressMonitor());
		p.open(new NullProgressMonitor());
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);

		// Do create and save
		mngr.createsModels(model1File);
		mngr.save(new NullProgressMonitor());
		
		// Change the name
		IFile newModel1File = p.getFile("tmp/model2." + model1Key);
		IFile newModel2File = p.getFile("tmp/model2." + model2Key);
		IPath newPath = newModel1File.getFullPath();
		
		mngr.saveAs(newPath);
		// check creation
		
		assertTrue("resource created", newModel2File.exists());
		assertTrue("resource created", newModel2File.exists());
		//
		assertNotNull( "resource created", model1.getResouce() );
		assertNotNull( "resource created", model2.getResouce() );

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.resource.ModelSet#unload()} .
	 */
	@Test
	public void testUnload() {
		ModelSet mngr = new ModelSet();
		
		String model1Key = "ecore";
		String model2Key = "genmodel";
		
		FakeModel model1 = new FakeModel(model1Key);
		FakeModel model2 = new FakeModel(model2Key);
		
		mngr.registerModel(model1);
		mngr.registerModel(model2);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.core");
		
		IFile model1File = p.getFile("tmp/model1." + model1Key);

		// Do create and then unload
		mngr.createsModels(model1File);
		mngr.unload();
		
		assertNull( "resource unloaded", model1.getResouce() );
		assertNull( "resource unloaded", model2.getResouce() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.resource.ModelSet#addModelSetSnippet(IModelManagerSnippet)} .
	 */
	@Test
	public void testAddModelSetSnippet() {
		ModelSet mngr = new ModelSet();
		
		// Add snippets
		TestTrace trace = new TestTrace();
		mngr.addModelSetSnippet(new FakeModelManagerSnippet(trace, "snippet1"));
		mngr.addModelSetSnippet(new FakeModelManagerSnippet(trace, "snippet2"));
		
		// Do create
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.core");
		IFile model1File = p.getFile("tmp/model1.ecore" );
		mngr.createsModels(model1File);
		
		// Check calls
		assertTrue("snippet1 called", trace.contains("snippet1", "start"));
		assertTrue("snippet2 called", trace.contains("snippet2", "start"));

	}
	
	/**
	 * Test that snippets are called after a call to createsModels()
	 */
	@Test
	public void testSnippetCalledAfterCreateModels() {
		ModelSet mngr = new ModelSet();
		
		// Add snippets
		TestTrace trace = new TestTrace();
		mngr.addModelSetSnippet(new FakeModelManagerSnippet(trace, "snippet1"));
		mngr.addModelSetSnippet(new FakeModelManagerSnippet(trace, "snippet2"));
		
		// Do create
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.core");
		IFile model1File = p.getFile("tmp/model1.ecore" );
		mngr.createsModels(model1File);
		
		// Check calls
		assertTrue("snippet1 called", trace.contains("snippet1", "start"));
		assertTrue("snippet2 called", trace.contains("snippet2", "start"));

		// dispose
		mngr.unload();
		// Check calls
		assertTrue("snippet1 called", trace.contains("snippet1", "dispose"));
		assertTrue("snippet2 called", trace.contains("snippet2", "dispose"));

	}
	
	/**
	 * Test that snippets are called after a call to loadModels()
	 */
	@Test
	public void testSnippetCalledAfterLoadModels() {
		
		// force model creation
		testSnippetCalledAfterCreateModels();
		
		// now  do load.
		ModelSet mngr = new ModelSet();
		
		// Add snippets
		TestTrace trace = new TestTrace();
		mngr.addModelSetSnippet(new FakeModelManagerSnippet(trace, "snippet1"));
		mngr.addModelSetSnippet(new FakeModelManagerSnippet(trace, "snippet2"));
		
		// Do create
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.core");
		IFile model1File = p.getFile("tmp/model1.ecore" );
		mngr.loadModels(model1File);
		
		// Check calls
		assertTrue("snippet1 called", trace.contains("snippet1", "start"));
		assertTrue("snippet2 called", trace.contains("snippet2", "start"));

		// dispose
		mngr.unload();
		// Check calls
		assertTrue("snippet1 called", trace.contains("snippet1", "dispose"));
		assertTrue("snippet2 called", trace.contains("snippet2", "dispose"));
		
	}

}
