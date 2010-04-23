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
import org.eclipse.papyrus.core.utils.DiResourceSet;


public class ResourceLoadingTests extends TestCase {
	
	// une classe de test par modèle testé
	// une classe de test par strategy

	public static String resourceUri = "org.eclipse.papyrus.core.test/resources/";

	private DiResourceSet diResourceSet;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		diResourceSet = new DiResourceSet();
		String global = resourceUri + "TestModel1/model1";
		URI diUri = URI.createPlatformPluginURI(global + ".di", false);
		URI modelUri = URI.createPlatformPluginURI(global + ".uml", false);
		URI notationUri = URI.createPlatformPluginURI(global + ".notation", false);
		diResourceSet.loadResources(diUri, notationUri, modelUri, null);
	}

	/**
	 * Test get objects of controlled resources.
	 */
	public void testGetObjectOfControlledResource() {
		// test getting EObject of the specified URI
		// level 0
		URI uriClass0 = URI.createPlatformPluginURI(resourceUri + "TestModel1/model1.uml#_mrla0E61Ed-33f5wCAz2-g", false);
		EObject eObject = diResourceSet.getEObject(uriClass0, true);
		assertNotNull("error strategy 0", eObject);
		// level 1
		URI uriClass1 = URI.createPlatformPluginURI(resourceUri + "TestModel1/Package0.uml#_pOAUQE61Ed-33f5wCAz2-g", false);
		EObject eObject2 = diResourceSet.getEObject(uriClass1, true);
		assertNotNull("error strategy 0", eObject2);
		// level 2
		URI uriClass2 = URI.createPlatformPluginURI(resourceUri + "TestModel1/Package1.uml#_twSMoE61Ed-33f5wCAz2-g", false);
		EObject eObject3 = diResourceSet.getEObject(uriClass2, true);
		assertNotNull("error strategy 0", eObject3);
		
	}
	
	// test avec le getPageRef
	
//	public void testGetResolveAll() {
//		int nbResources = diResourceSet.getResources().size();
//		EcoreUtil.resolveAll(diResourceSet);
//		assertEquals(nbResources, diResourceSet.getResources().size());
//	}
	
	public void testGetObjectOfProfileResource() {
		
	}

	public void testGetObjectOfPathmapResource() {
		
	}

	public void testGetProxyOfControlledResource() {
		
	}
	
	public void testGetObjectOfAnyResource() {
		
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

//	private EObject getModel(URI uri) throws Exception {
//		if(uri == null) {
//			throw new Exception("No path provided");
//		}
//		EObject model = null;
//		try {
//			Resource resource = diResourceSet.getResource(uri, true);
//			if(resource.getContents().size() > 0) {
//				model = resource.getContents().get(0);
//			} else {
//				throw new Exception("Model can not be loaded from URL: " + uri.toString());
//			}
//		} catch (RuntimeException e) {
//			throw new Exception("Model can not be loaded from URL: " + uri.toString());
//		}
//		return model;
//	}

}
