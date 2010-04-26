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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.papyrus.sashwindows.di.PageRef;
import org.eclipse.papyrus.sashwindows.di.SashWindowsMngr;


public class LoadAllStrategyTestModel1 extends TestCase {

	public static String resourceUri = "org.eclipse.papyrus.core.test/resources/TestModel1/";

	private DiResourceSet diResourceSet;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		diResourceSet = new DiResourceSet();
		String path = resourceUri + "model1";
		URI diUri = URI.createPlatformPluginURI(path + ".di", false);
		URI modelUri = URI.createPlatformPluginURI(path + ".uml", false);
		URI notationUri = URI.createPlatformPluginURI(path + ".notation", false);
		diResourceSet.loadResources(diUri, notationUri, modelUri, null);
	}

	/**
	 * Test get objects of controlled resources.
	 */
	public void testGetObjectOfControlledResource() {
		// test getting EObject of the specified URI
		// level 0
		URI uriClass0 = URI.createPlatformPluginURI(resourceUri + "model1.uml#_gH3N8FEMEd-2krC_WR-1xA", false);
		EObject eObject = diResourceSet.getEObject(uriClass0, true);
		assertNotNull("Load object of the current resource: ", eObject);
		// level 1
		URI uriClass1 = URI.createPlatformPluginURI(resourceUri + "Package0.uml#_iyx8EFEMEd-2krC_WR-1xA", false);
		EObject eObject2 = diResourceSet.getEObject(uriClass1, true);
		assertNotNull("Load object a controlled resource at level 1", eObject2);
		// level 2
		URI uriClass2 = URI.createPlatformPluginURI(resourceUri + "Package1.uml#_lq9DEFEMEd-2krC_WR-1xA", false);
		EObject eObject3 = diResourceSet.getEObject(uriClass2, true);
		assertNotNull("Load object a controlled resource at level 2", eObject3);
	}
	
	public void testGetPageRefOfControlledResource() {
		// get notation reference from di resource
		String fragment = "_lEguIFEMEd-2krC_WR-1xA";
		URI uriDiagram = URI.createPlatformPluginURI(resourceUri + "Package1.notation#" + fragment, false);
		EObject diagram = diResourceSet.getEObject(uriDiagram, true);
		assertNotNull("Load diagram from uri", diagram);
		
		URI diUri = URI.createPlatformPluginURI("model1.di", false);
		Resource diResource = diResourceSet.getResource(diUri, true);
		if(diResource.getContents().size() > 0) {
			EObject eObject = diResource.getContents().get(0);
			if (eObject instanceof SashWindowsMngr) {
				SashWindowsMngr sashWindowMngr = (SashWindowsMngr)eObject;
				for (PageRef pageRef : sashWindowMngr.getPageList().getAvailablePage()) {
					if (pageRef.getEmfPageIdentifier() != null && pageRef.getEmfPageIdentifier().toString().endsWith(fragment)) {
						URI uriDiagram2 = URI.createPlatformPluginURI(pageRef.getEmfPageIdentifier().toString(), false);
						assertEquals("Load diagram from page ref", uriDiagram, uriDiagram2);
					}
				}
			}
		}
	}
	
	public void testGetObjectOfProfileResource() {
		URI uriPlatformProfile = URI.createPlatformPluginURI(resourceUri + "MyProfile.uml#_XkGiwB07Ed-QQ4mYkrb7Gg", false);
		EObject platformProfile = diResourceSet.getEObject(uriPlatformProfile, true);
		assertNotNull("Load a platform profile resource", platformProfile);
	}

	public void testGetObjectOfPathmapResource() {
		URI uriPathmapProfile = URI.createPlatformPluginURI("pathmap://UML_PROFILES/Ecore.profile.uml#_0", false);
		EObject pathmapProfile = diResourceSet.getEObject(uriPathmapProfile, true);
		assertNotNull("Load a pathmap profile resource", pathmapProfile);
		
	}
	
	public void testResolveAll() {
		int nbResources = diResourceSet.getResources().size();
		EcoreUtil.resolveAll(diResourceSet);
		assertEquals(nbResources, diResourceSet.getResources().size());
	}
	
	@Override
	protected void tearDown() throws Exception {
		// Unload models
		for(Resource r : diResourceSet.getResources()) {
			try {
				r.unload();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		super.tearDown();
	}

}
