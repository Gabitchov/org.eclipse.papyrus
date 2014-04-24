/*****************************************************************************
 * Copyright (c) 2010, 2013 Atos Origin, CEA, and others.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *  Christian W. Damus (CEA) - Work around regression in URI parsing in EMF 2.9
 *
 *****************************************************************************/
package org.eclipse.papyrus.core.resourceloading.tests.testModel2;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.resourceloading.OnDemandLoadingModelSetServiceFactory;
import org.eclipse.papyrus.infra.services.resourceloading.preferences.StrategyChooser;
import org.eclipse.papyrus.junit.utils.tests.AbstractPapyrusTest;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Type;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Abstract class to test all the strategies with TestModel2
 * - Check that a model resource is loaded when a model contains reference to it.
 * - Check that a notation resource is loaded when a diagram contains reference to it.
 *
 * @author eperico
 *
 */
public abstract class AbstractResourceLoadingTestModel2 extends AbstractPapyrusTest {

	public static final String INITIAL_PATH = "resources/TestModel2/";

	public static final String RESOURCE_URI = ITestConstants.FRAGMENT_ID + "/" + INITIAL_PATH;

	private String[] resources = new String[]{ "model1", "Package0" };

	private String[] extensions = new String[]{ ".di", ".notation", ".uml" };

	protected ModelSet modelSet;

	private IFile resourceLoaded;

	/**
	 * {@inheritDoc}
	 */
	@Before
	public void setUp() throws Exception {
		StrategyChooser.setCurrentStrategy(getStrategy());
		// first we need to create the test project from the plugin to the workspace test platform
		IProject project = copyTestModelToThePlatform();
		modelSet = (ModelSet)new OnDemandLoadingModelSetServiceFactory().createServiceInstance();
		if(project != null) {
			resourceLoaded = getResourceToLoad(project);
			modelSet.loadModels(resourceLoaded);
		}
	}

	/**
	 * Copy test model from the test plugin to the platform where the tests are executed
	 *
	 * @return the project in the runtime platform
	 * @throws Exception
	 */
	private IProject copyTestModelToThePlatform() throws Exception {
		IProject project = ResourcesPlugin.getWorkspace().getRoot().getProject(ITestConstants.FRAGMENT_ID);
		IProgressMonitor monitor = new NullProgressMonitor();

		if(project != null && !project.exists()) {
			project.create(monitor);
		}
		project.open(monitor);
		for(String res : resources) {
			for(String s : extensions) {
				IFile file = project.getFile(INITIAL_PATH + res + s);
				// link all the models resources
				if(!file.exists()) {
					createFolder(project, "resources/");
					createFolder(project, INITIAL_PATH);
					URL url = FileLocator.find(Platform.getBundle(ITestConstants.FRAGMENT_ID), new Path(INITIAL_PATH + res + s), null);
					URL newFile = FileLocator.resolve(url);

					// encode the URI for spaces in the path
					file.createLink(new URL(newFile.toString().replaceAll(" ", "%20")).toURI(), IResource.REPLACE, monitor);
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
	 * Gets the resource to load, the one it is opened with the papyrus editor
	 *
	 * @param project
	 *        the project in which the resources should be
	 *
	 * @return the resource to load
	 */
	public abstract IFile getResourceToLoad(IProject project);

	/**
	 * Gets an object (Class0) from a reference (type of property) to the high level resource (model1)
	 */
	@Test
	public void testGetReferenceInControlledRessource() {
		URI uriProperty0 = URI.createPlatformResourceURI(RESOURCE_URI + "Package0.uml", false).appendFragment("_57LlkIRSEd-ZSb15jhF0Qw");
		EObject property0 = modelSet.getEObject(uriProperty0, true);
		Type type = null;
		if(property0 instanceof Property) {
			type = ((Property)property0).getType();
			assertTestGetDanglingReferenceFromParentResource("Get type from controlled resource is resolved", type);
		}

		URI uriClass0 = URI.createPlatformResourceURI(RESOURCE_URI + "model1.uml", false).appendFragment("_1766sIRSEd-ZSb15jhF0Qw");
		EObject class0 = modelSet.getEObject(uriClass0, true);
		assertTestGetReferenceInControlledRessource("Type of property is resolved ? :", type, class0);
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
			if(resourceLoaded != null && resourceLoaded.getName().contains("model1")) {
				assertTrue(message, !eObject.eIsProxy());
			} else {
				// when Package0 is opened, model1 is not loaded because it is not a controlled resource
				assertTrue(message, eObject.eIsProxy());
			}
			break;
		default:
			break;
		}
	}

	private void assertTestGetReferenceInControlledRessource(String message, EObject eObject1, EObject eObject2) {
		switch(getStrategy()) {
		case 0:
			// Load all the needed resources
			assertSame(message, eObject1, eObject2);
			break;
		case 1:
			// Load the additional resources (profile and pathmap). Controlled resources are not loaded
			assertNotSame(message, eObject1, eObject2);
			break;
		case 2:
			// Load the additional resources (profile and pathmap) and the needed controlled resources
			if(resourceLoaded != null && resourceLoaded.getName().contains("model1")) {
				assertSame(message, eObject1, eObject2);
			} else {
				// when Package0 is opened, model1 is not loaded because it is not a controlled resource
				assertNotSame(message, eObject1, eObject2);
			}
			break;
		default:
			break;
		}
	}

	/**
	 * Gets a figure (figure of Class0) contains in the high level resource (model1) from a diagram in controlled resource (Package0)
	 */
	@Test
	public void testGetFigureInControlledRessource() {
		URI uriFigurePackage0 = URI.createPlatformResourceURI(RESOURCE_URI + "Package0.notation", false).appendFragment("_-ig9EIRSEd-ZSb15jhF0Qw");
		EObject figurePackage0 = modelSet.getEObject(uriFigurePackage0, true);
		assertTestGetFigureInControlledRessource1("Get figure in Package0 resource", figurePackage0);
		EObject element = null;
		if(figurePackage0 instanceof Node) {
			Node node = (Node)figurePackage0;
			element = node.getElement();
		}
		URI uriClass0 = URI.createPlatformResourceURI(RESOURCE_URI + "model1.uml", false).appendFragment("_1766sIRSEd-ZSb15jhF0Qw");
		EObject class0 = modelSet.getEObject(uriClass0, true);
		assertTestGetFigureInControlledRessource2("Load figure from high level resource", class0, element);
	}

	private void assertTestGetFigureInControlledRessource1(String message, EObject eObject) {
		switch(getStrategy()) {
		case 0:
			// Load all the needed resources
			assertTrue(message, !eObject.eIsProxy());
			break;
		case 1:
			// Load the additional resources (profile and pathmap). Controlled resources are not loaded
			if(resourceLoaded != null && resourceLoaded.getName().contains("model1")) {
				//assertTrue(message, eObject.eIsProxy());
				// eObject is null, not a proxy
				assertNull(message, eObject);
			} else {
				// when Package0 is opened, model1 is not loaded because it is not a controlled resource
				assertTrue(message, !eObject.eIsProxy());
			}
			break;
		case 2:
			// Load the additional resources (profile and pathmap) and the needed controlled resources
			assertTrue(message, !eObject.eIsProxy());
			break;
		default:
			break;
		}
	}

	private void assertTestGetFigureInControlledRessource2(String message, EObject eObject1, EObject eObject2) {
		switch(getStrategy()) {
		case 0:
			// Load all the needed resources
			assertSame(message, eObject1, eObject2);
			break;
		case 1:
			// Load the additional resources (profile and pathmap). Controlled resources are not loaded
			assertNotSame(message, eObject1, eObject2);
			break;
		case 2:
			// Load the additional resources (profile and pathmap) and the needed controlled resources
			if(resourceLoaded != null && resourceLoaded.getName().contains("model1")) {
				assertSame(message, eObject1, eObject2);
			} else {
				// when Package0 is opened, model1 is not loaded because it is not a controlled resource
				assertNotSame(message, eObject1, eObject2);
			}
			break;
		default:
			break;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@After
	public void tearDown() throws Exception {
		// Unload models
		List<Resource> resources = new ArrayList<Resource>(modelSet.getResources());
		for(Resource r : resources) {
			try {
				r.unload();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
