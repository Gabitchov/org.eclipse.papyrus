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

import junit.framework.TestCase;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.core.preferences.StrategyChooser;
import org.eclipse.papyrus.resource.ModelSet;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.SashWindowsMngr;


public class LoadAllStrategyTestModel1 extends TestCase {

	public static String resourceUri = "org.eclipse.papyrus.core.test/resources/TestModel1/";

	private ModelSet modelSet;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		StrategyChooser.setCurrentStrategy(0);
		
		IProject p = ResourcesPlugin.getWorkspace().getRoot().getProject("org.eclipse.papyrus.core.test");
		IFile modelFile = p.getFile("resources/TestModel1/model1.di");
		modelSet = new ModelSet();
		modelSet.loadModels(modelFile);

//		String path = resourceUri + "model1";
//		URI diUri = URI.createPlatformPluginURI(path + ".di", false);
//		URI modelUri = URI.createPlatformPluginURI(path + ".uml", false);
//		URI notationUri = URI.createPlatformPluginURI(path + ".notation", false);
//		modelSet.loadResources(diUri, notationUri, modelUri, null);
	}

	/**
	 * Test get objects of controlled resources.
	 */
	public void testGetObjectOfControlledResource() {
		// test getting EObject of the specified URI
		// level 0
		URI uriClass0 = URI.createPlatformPluginURI(resourceUri + "model1.uml#_gH3N8FEMEd-2krC_WR-1xA", false);
		EObject eObject = modelSet.getEObject(uriClass0, true);
		assertNotNull("Load object of the current resource: ", eObject);
		// level 1
		URI uriClass1 = URI.createPlatformPluginURI(resourceUri + "Package0.uml#_iyx8EFEMEd-2krC_WR-1xA", false);
		EObject eObject2 = modelSet.getEObject(uriClass1, true);
		assertNotNull("Load object a controlled resource at level 1", eObject2);
		// level 2
		URI uriClass2 = URI.createPlatformPluginURI(resourceUri + "Package1.uml#_lq9DEFEMEd-2krC_WR-1xA", false);
		EObject eObject3 = modelSet.getEObject(uriClass2, true);
		assertNotNull("Load object a controlled resource at level 2", eObject3);
	}
	
	public void testGetPageRefOfControlledResource() {
		// get notation reference from di resource
		String fragment = "_lEguIFEMEd-2krC_WR-1xA";
		URI uriDiagram = URI.createPlatformPluginURI(resourceUri + "Package1.notation#" + fragment, false);
		EObject diagram = modelSet.getEObject(uriDiagram, true);
		assertNotNull("Load diagram from uri", diagram);
		
		URI diUri = URI.createPlatformPluginURI("model1.di", false);
		Resource diResource = modelSet.getResource(diUri, true);
		if(diResource.getContents().size() > 0) {
			EObject eObject = diResource.getContents().get(0);
			if (eObject instanceof SashWindowsMngr) {
				SashWindowsMngr sashWindowMngr = (SashWindowsMngr)eObject;
				for (PageRef pageRef : sashWindowMngr.getPageList().getAvailablePage()) {
					if (pageRef.getEmfPageIdentifier() != null && pageRef.getEmfPageIdentifier().toString().endsWith(fragment)) {
						assertEquals("Load diagram from page ref", diagram, pageRef.getEmfPageIdentifier());
					}
				}
			}
		}
	}
	
	public void testGetObjectOfProfileResource() {
		URI uriPlatformProfile = URI.createPlatformPluginURI(resourceUri + "MyProfile.uml#_XkGiwB07Ed-QQ4mYkrb7Gg", false);
		EObject platformProfile = modelSet.getEObject(uriPlatformProfile, true);
		assertNotNull("Load a platform profile resource", platformProfile);
	}

	public void testGetObjectOfPathmapResource() {
		URI uriPathmapProfile = URI.createPlatformPluginURI("pathmap://UML_PROFILES/Ecore.profile.uml#_0", false);
		EObject pathmapProfile = modelSet.getEObject(uriPathmapProfile, true);
		assertNotNull("Load a pathmap profile resource", pathmapProfile);
		
	}
	
	public void testResolveAll() {
		int nbResources = modelSet.getResources().size();
		EcoreUtil.resolveAll(modelSet);
		assertEquals(nbResources, modelSet.getResources().size());
	}
	
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

}
