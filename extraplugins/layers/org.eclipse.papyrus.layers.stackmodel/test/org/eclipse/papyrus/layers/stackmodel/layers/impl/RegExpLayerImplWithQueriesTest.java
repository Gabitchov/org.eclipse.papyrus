/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.query.conditions.eobjects.EObjectCondition;
import org.eclipse.emf.query.ocl.conditions.BooleanOCLCondition;
import org.eclipse.emf.query.statements.FROM;
import org.eclipse.emf.query.statements.IQueryResult;
import org.eclipse.emf.query.statements.SELECT;
import org.eclipse.emf.query.statements.WHERE;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author dumoulin
 *
 */
public class RegExpLayerImplWithQueriesTest {

	/**
	 * Name of the plugin that is created.
	 */
	final protected String PLUGIN_PROJECT_NAME = "org.eclipse.papyrus.layers.stackmodel";

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#RegExpLayerImpl()}.
	 */
	@Test
	public void testRegExpLayerImpl() {
		RegExpLayer layer = LayersFactory.eINSTANCE.createRegExpLayer();
		
		assertNotNull("object created", layer);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#setExpr(java.lang.String)}.
	 */
	@Test
	public void testSetExpr() {
		RegExpLayer layer = LayersFactory.eINSTANCE.createRegExpLayer();
		
		assertNotNull("object created", layer);
		
		layer.setExpr("An expression");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.RegExpLayerImpl#evaluateExpr()}.
	 * @throws ParserException 
	 */
	@Test
	public void testEvaluateExpr() throws ParserException {
		RegExpLayer layer = LayersFactory.eINSTANCE.createRegExpLayer();
		
		assertNotNull("object created", layer);
		
		layer.setExpr("An expression");
//		List<View> res = layer.evaluateExpr();
//		
//		assertNotNull("object created", res);
		
		
		String modelNotationKey = "notation";
		String modelUMLKey = "uml";

		String modelFileName = "/test/models/model1";
		
		Resource resource = getResource(modelFileName, modelNotationKey);

		OCL ocl = OCL.newInstance();
		EObjectCondition  condition = new BooleanOCLCondition<EClassifier, EClass, EObject>(
		    ocl.getEnvironment(),
//		    "self.oclIsKindOf(Shape)",
//		    "self.oclIsKindOf(Shape) and self.oclAsType(Shape).visible = true",
		    "self.oclAsType(Shape).visible = true",
		    NotationPackage.Literals.SHAPE
		    );

		SELECT statement = new SELECT(SELECT.UNBOUNDED, false,
			new FROM(resource.getContents()), new WHERE(condition),
			new NullProgressMonitor());

		IQueryResult results = statement.execute();
			
		assertNotNull("got result", results);
		assertFalse("results is not empty", results.isEmpty());
	}


	/**
	 * Test if the resource needed for the test exists.
	 * 
	 * @throws ModelMultiException
	 */
	@Test
	public void testResourceExist() throws IOException, CoreException {

		String modelNotationKey = "notation";
		String modelUMLKey = "uml";

		String modelFileName = "/test/models/model1";
		
		Resource resource = getResource(modelFileName, modelNotationKey);
		
		assertNotNull("modelFile exist", resource);
		assertTrue("model is loaded", !resource.getContents().isEmpty());
	}

	/**
	 * @param modelFileName
	 * @param modelNotationKey
	 * @return
	 */
	private Resource getResource(String modelFileName, String modelNotationKey) {
		ResourceSet resourceSet = new ResourceSetImpl();
		
		
		URI uri = URI.createPlatformPluginURI(PLUGIN_PROJECT_NAME+ modelFileName + "." +  modelNotationKey, true);
//		URI uri = URI.createPlatformPluginURI("/org.eclipse.papyrus.layers.stackmodel/model/layers.notation", true);

		
		System.out.println("URI=" + uri.toString());
		Resource resource = resourceSet.getResource(uri, true);
		return resource;
	}
	


}
