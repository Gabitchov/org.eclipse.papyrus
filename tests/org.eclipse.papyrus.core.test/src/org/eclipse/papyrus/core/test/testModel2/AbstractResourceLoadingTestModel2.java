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
package org.eclipse.papyrus.core.test.testModel2;

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
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.core.resourceloading.OnDemandLoadingModelSetServiceFactory;
import org.eclipse.papyrus.core.resourceloading.preferences.StrategyChooser;
import org.eclipse.papyrus.core.test.Activator;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;


/**
 * Abstract class to test all the strategies with TestModel2
 * - Check that a model resource is loaded when a model contains reference to it.
 * - Check that a notation resource is loaded when a diagram contains reference to it.
 * 
 * @author eperico
 * 
 */
public abstract class AbstractResourceLoadingTestModel2 extends TestCase {
	
	public static final String RESOURCE_URI = "org.eclipse.papyrus.core.test/resources/TestModel2/";

	private static final String INITIAL_PATH = "resources/TestModel2/";

	private String[] resources = new String[]{ "model1", "Package0" };

	private String[] extensions = new String[]{ ".di", ".notation", ".uml" };

	protected ModelSet modelSet;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		StrategyChooser.setCurrentStrategy(getStrategy());
		// first we need to create the test project from the plugin to the workspace test platform
		IProject project = copyTestModelToThePlatform();
		modelSet = (ModelSet)new OnDemandLoadingModelSetServiceFactory().createServiceInstance();
		if(project != null) {
			IFile modelFile = project.getFile(INITIAL_PATH + "model1.di");
			modelSet.loadModels(modelFile);
		}
	}

	/**
	 * Copy test model from the test plugin to the platform where the tests are executed
	 * 
	 * @return the project in the runtime platform
	 * @throws Exception
	 */
	private IProject copyTestModelToThePlatform() throws Exception {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.core.test");
		IProgressMonitor monitor = new NullProgressMonitor();

		if(!project.exists()) {
			project.create(monitor);
			project.open(monitor);
			for(String res : resources) {
				for(String s : extensions) {
					IFile file = project.getFile(INITIAL_PATH + res + s);
					// link all the models resources
					if(!file.exists()) {
						createFolder(project, "resources/");
						createFolder(project, INITIAL_PATH);
						URL url = FileLocator.find(Activator.getDefault().getBundle(), new Path(INITIAL_PATH + res + s), null);
						URL newFile = FileLocator.resolve(url);
						file.createLink(newFile.toURI(), IResource.REPLACE, monitor);
					}
				}
			}
		}
		project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		return project;
	}
	
	/**
	 * Gets the current resource loading strategy.
	 * 
	 * @return the strategy
	 */
	public abstract int getStrategy();
	
	/** 
	 * Gets an object (Class0) from a reference (type of property) to the high level resource (model1) 
	 */
	public void testGetReferenceInControlledRessource() {
		URI uriProperty0 = URI.createPlatformResourceURI(RESOURCE_URI + "Package0.uml#_57LlkIRSEd-ZSb15jhF0Qw", false);
		EObject property0 = modelSet.getEObject(uriProperty0, true);
		Type type = null;
		if(property0 instanceof Property) {
			type = ((Property)property0).getType();
			assertTestGetDanglingReferenceFromParentResource("Get type from controlled resource is resolved", type);
		}
		
		URI uriClass0 = URI.createPlatformResourceURI(RESOURCE_URI + "model1.uml#_1766sIRSEd-ZSb15jhF0Qw", false);
		EObject class0 = modelSet.getEObject(uriClass0, true);
		assertEquals("Load object from a reference", type, class0);
	}
	
	private void assertTestGetDanglingReferenceFromParentResource(String message, EObject eObject) {
		switch(getStrategy()) {
		case 0:
			// Load all the needed resources
			assertTrue(message, !eObject.eIsProxy());
			break;
		case 1:
			// Load the additional resources (profile and pathmap). Controlled resources are not loaded
			assertTrue(message, eObject.eIsProxy());
			break;
		case 2:
			// Load the additional resources (profile and pathmap) and the needed controlled resources
			assertTrue(message, !eObject.eIsProxy());
			break;
		default:
			break;
		}
	}
	
	/** 
	 * Gets a figure (figure of Class0) contains in the high level resource (model1) from a diagram in controlled resource (Package0) 
	 */
	public void testGetFigureInControlledRessource() {
		URI uriFigurePackage0 = URI.createPlatformResourceURI(RESOURCE_URI + "Package0.notation#_-ig9EIRSEd-ZSb15jhF0Qw", false);
		EObject figurePackage0 = modelSet.getEObject(uriFigurePackage0, true);
		EObject element = null;
		if (figurePackage0 instanceof Node) {
			Node node = (Node)figurePackage0;
			element = node.getElement();
			assertNotNull("Element from the figure not null", element);
		}
		
		URI uriClass0 = URI.createPlatformResourceURI(RESOURCE_URI + "model1.uml#_1766sIRSEd-ZSb15jhF0Qw", false);
		EObject class0 = modelSet.getEObject(uriClass0, true);
		assertEquals("Load figure from high level resource", class0, element);
	}
	
	public void testResolveAll() {
		int nbResources = modelSet.getResources().size();
		EcoreUtil.resolveAll(modelSet);
		assertEquals(nbResources, modelSet.getResources().size());
	}
	
	/**
	 * {@inheritDoc}
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
	 * Creates the folder name in the specified project
	 * 
	 * @param project
	 * @param name
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
