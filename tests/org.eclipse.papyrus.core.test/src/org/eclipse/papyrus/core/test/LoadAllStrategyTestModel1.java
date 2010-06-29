/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.test;

import java.net.URL;

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.core.resourceloading.OnDemandLoadingModelSetServiceFactory;
import org.eclipse.papyrus.core.resourceloading.preferences.StrategyChooser;
import org.eclipse.papyrus.resource.ModelSet;

/**
 * Test the strategy with id 2 = Load the additional resources (profile and pathmap) and the needed controlled resources
 * - Check that all the controlled resources are loaded
 * - Check that all the needed profiles (resource and pathmap) are loaded
 * 
 * @author eperico
 *
 */
public class LoadAllStrategyTestModel1 extends TestCase {

	public static final String RESOURCE_URI = "org.eclipse.papyrus.core.test/resources/TestModel1/";

	private ModelSet modelSet;


	@Override
	protected void setUp() throws Exception {
		super.setUp();
		// Load the additional resources (profile and pathmap) and the needed controlled resources
		StrategyChooser.setCurrentStrategy(2);

		// first we need to create the test project from the plugin to the workspace test platform
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.core.test");
		IProgressMonitor monitor = new NullProgressMonitor();
		String[] resources = new String[] {"resources/TestModel1/model1.", "resources/TestModel1/Package0.", "resources/TestModel1/Package1."};
		String[] extensions = new String[]{ "di", "notation", "uml" };
		if(!project.exists()) {
			project.create(monitor);
			project.open(monitor);
			for (String res : resources) {
				for(String s : extensions) {
					IFile file = project.getFile(res + s);
					if(!file.exists()) {
						createFolder(project, "resources/");
						createFolder(project, "resources/TestModel1/");
						URL url = FileLocator.find(Activator.getDefault().getBundle(), new Path(res + s), null);
						URL newFile = FileLocator.resolve(url);
						file.createLink(newFile.toURI(), IResource.REPLACE, monitor);
					}
				}				
			}
			String profilePath = "resources/TestModel1/MyProfile.uml";
			IFile file = project.getFile(profilePath);
			if(!file.exists()) {
				URL url = FileLocator.find(Activator.getDefault().getBundle(), new Path(profilePath), null);
				URL newFile = FileLocator.resolve(url);
				file.createLink(newFile.toURI(), IResource.REPLACE, monitor);				
			}
		}
		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		IFile modelFile = project.getFile("resources/TestModel1/model1.di");
		modelSet = (ModelSet)new OnDemandLoadingModelSetServiceFactory().createServiceInstance();
		modelSet.loadModels(modelFile);
	}


	/**
	 * Gets objects of controlled resources.
	 * - get an object (Class0) from the current resource (model1)
	 * - get an object (Class1) from the first controlled resource (Package0)
	 * - get an object (Class2) from the second controlled resource (Package1)
	 */
	public void testGetObjectOfControlledResource() {
		// test getting EObject of the specified URI
		// level 0
		URI uriClass0 = URI.createPlatformResourceURI(RESOURCE_URI + "model1.uml#_SEFk0H04Ed-RG-XtCG9Nmw", false);
		EObject eObject = modelSet.getEObject(uriClass0, true);
		assertNotNull("Load object of the current resource: ", eObject);
		// level 1
		URI uriClass1 = URI.createPlatformResourceURI(RESOURCE_URI + "Package0.uml#_nQhGUH04Ed-RG-XtCG9Nmw", false);
		EObject eObject2 = modelSet.getEObject(uriClass1, true);
		assertNotNull("Load object in a controlled resource at level 1", eObject2);
		// level 2
		URI uriClass2 = URI.createPlatformResourceURI(RESOURCE_URI + "Package1.uml#_sRCZ4H04Ed-RG-XtCG9Nmw", false);
		EObject eObject3 = modelSet.getEObject(uriClass2, true);
		assertNotNull("Load object in a controlled resource at level 2", eObject3);
	}

	/**
	 * Gets diagrams of controlled resources.
	 * - get a diagram (NewDiagram) from the current resource (model1)
	 * - get a diagram (Diagram0) from the first controlled resource (Package0)
	 * - get a diagram (Diagram1) from the second controlled resource (Package1)
	 */
	public void testGetDiagramOfControlledResource() {
		// get notation reference from di resource
		// level 0
		URI uriNewDiagram = URI.createPlatformResourceURI(RESOURCE_URI + "model1.notation#_QtEHgH04Ed-RG-XtCG9Nmw", false);
		EObject newDiagram = modelSet.getEObject(uriNewDiagram, true);
		assertNotNull("Load diagram in a controlled resource at level 2", newDiagram);
		// level 1
		URI uriDiagram0 = URI.createPlatformResourceURI(RESOURCE_URI + "Package0.notation#_mvutcH04Ed-RG-XtCG9Nmw", false);
		EObject diagram0 = modelSet.getEObject(uriDiagram0, true);
		assertNotNull("Load diagram in a controlled resource at level 2", diagram0);
		// level 2
		URI uriDiagram1 = URI.createPlatformResourceURI(RESOURCE_URI + "Package1.notation#_r1npMH04Ed-RG-XtCG9Nmw", false);
		EObject diagram1 = modelSet.getEObject(uriDiagram1, true);
		assertNotNull("Load diagram in a controlled resource at level 2", diagram1);
	}

	/**
	 * Gets a needed profile resource from the local project 
	 */
	public void testGetObjectOfProfileResource() {
		URI uriPlatformProfile = URI.createPlatformResourceURI(RESOURCE_URI + "MyProfile.uml#_XkGiwB07Ed-QQ4mYkrb7Gg", false);
		EObject platformProfile = modelSet.getEObject(uriPlatformProfile, true);
		assertNotNull("Load a platform profile resource", platformProfile);
	}

	/**
	 * Gets a needed profile resource from a pathmap
	 */
	public void testGetObjectOfPathmapResource() {
		URI uriPathmapProfile = URI.createURI("pathmap://UML_PROFILES/Ecore.profile.uml#_0");
		EObject pathmapProfile = modelSet.getEObject(uriPathmapProfile, true);
		assertNotNull("Load a pathmap profile resource", pathmapProfile);

	}

	/**
	 * Tests that all the needed resources are loaded
	 */
	public void testResolveAll() {
		int nbResources = modelSet.getResources().size();
		EcoreUtil.resolveAll(modelSet);
		assertEquals(nbResources, modelSet.getResources().size());
	}

	/**
	 * @see junit.framework.TestCase#tearDown()
	 */
	@Override
	protected void tearDown() throws Exception {
		// Unload models
		for(Resource r : modelSet.getResources()) {
			try {
				r.unload();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		super.tearDown();
	}

	/**
	 * @param project
	 * @throws CoreException
	 */
	private void createFolder(IProject project, String name) throws CoreException {
		IFolder parent = project.getFolder(name);
		if(!parent.exists()) {
			parent.create(true, true, new NullProgressMonitor());
		}
		assert (parent.exists());
	}

}
