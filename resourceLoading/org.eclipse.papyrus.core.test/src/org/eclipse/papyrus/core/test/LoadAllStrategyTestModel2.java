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
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.papyrus.core.utils.DiResourceSet;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Type;


public class LoadAllStrategyTestModel2 extends TestCase {

	public static String resourceUri = "org.eclipse.papyrus.core.test/resources/TestModel2/";

	private DiResourceSet diResourceSet;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		diResourceSet = new DiResourceSet();
		String path = resourceUri + "Package0";
		URI diUri = URI.createPlatformPluginURI(path + ".di", false);
		URI modelUri = URI.createPlatformPluginURI(path + ".uml", false);
		URI notationUri = URI.createPlatformPluginURI(path + ".notation", false);
		diResourceSet.loadResources(diUri, notationUri, modelUri, null);
	}
	
	/** Gets an object from a reference to the high level resource */
	public void testGetReferenceInControlledRessource() {		
		URI uriClass1 = URI.createPlatformPluginURI(resourceUri + "Package0.uml#_nvSxAFEaEd-KU8D5rCZoaQ", false);
		EObject class1 = diResourceSet.getEObject(uriClass1, true);
		Type type = ((Class) class1).getAttributes().get(0).getType();
		assertNotNull("GetType from package0: Type of the property", type);
		
		URI uriClass0 = URI.createPlatformPluginURI(resourceUri + "model1.uml#_lUxPUFEaEd-KU8D5rCZoaQ", false);
		EObject class0 = diResourceSet.getEObject(uriClass0, true);
		assertNotNull("GetEObject from model1: Type of the property", type);
		
		assertEquals("Load object from a reference", type, class0);
	}
	
	/** Gets a figure contains in the high level resource. */
	public void testGetFigureInControlledRessource() {
		URI uriFigurePackage0 = URI.createPlatformPluginURI(resourceUri + "Package0.notation#_s-QJMFEaEd-KU8D5rCZoaQ", false);
		EObject figurePackage0 = diResourceSet.getEObject(uriFigurePackage0, true);
		EObject element = null;
		if (figurePackage0 instanceof Node) {
			Node node = (Node)figurePackage0;
			element = node.getElement();
		}
		
		URI uriFigureModel1 = URI.createPlatformPluginURI(resourceUri + "model1.notation#_lVEKQFEaEd-KU8D5rCZoaQ", false);
		EObject figureModel1 = diResourceSet.getEObject(uriFigureModel1, true);
		
		assertEquals("Load figure from high level resource", figureModel1, element);
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
