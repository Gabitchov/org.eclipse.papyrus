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

package org.eclipse.papyrus.layers.stackmodel.exprmatcher;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

/**
 * @author cedric dumoulin
 *
 */
public class ExpressionMatcherTest {

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
	
	/**
	 * Get the diagram contained in the specified resource.
	 * @param modelFileName
	 * @return
	 */
	private Diagram getDiagram( String modelFileName ) {
		
		// Get the Resource containing the diagram
		EObject root = getResource(modelFileName, "notation").getContents().get(0);
		
		return (Diagram)root;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.exprmatcher.ExpressionMatcher#ExpressionMatcher(java.lang.String, java.util.List)}.
	 * @throws LayersException 
	 */
	@Test
	public void testExpressionMatcher() throws LayersException {
		
		
		String expression = "self.oclIsKindOf(Shape)";
//	    "self.oclIsKindOf(Shape)",
//	    "self.oclIsKindOf(Shape) and self.oclAsType(Shape).visible = true",
//		    "self.oclAsType(Shape).visible = true",

		String modelFileName = "/test/models/model1";
		Diagram diagram = getDiagram(modelFileName);
		List<EObject> searchRoots = diagram.getChildren();

		ExpressionMatcher expressionMatcher = new ExpressionMatcher(expression, searchRoots);
		assertNotNull("object created", expressionMatcher);
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.exprmatcher.ExpressionMatcher#ExpressionMatcher(java.lang.String, java.util.List)}.
	 * @throws LayersException 
	 */
	@Test
	public void testExpressionMatcherWithWrongExpr() throws LayersException {
		
		// Wrong expr
		String expression = "self.o";

		String modelFileName = "/test/models/model1";
		Diagram diagram = getDiagram(modelFileName);
		List<EObject> searchRoots = diagram.getChildren();

		
		ExpressionMatcher expressionMatcher;
		try {
			expressionMatcher = new ExpressionMatcher(expression, searchRoots);
		} catch (Exception e) {
			// shoul have one
			return;
		}
		fail("An exception should be thrown");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.exprmatcher.ExpressionMatcher#refreshMatchingElements()}.
	 * @throws LayersException 
	 */
	@Test
	public void testRefreshMatchingElements() throws LayersException {
		String expression = "self.oclIsKindOf(Shape)";
//	    "self.oclIsKindOf(Shape)",
//	    "self.oclIsKindOf(Shape) and self.oclAsType(Shape).visible = true",
//		    "self.oclAsType(Shape).visible = true",

		String modelFileName = "/test/models/model1";
		Diagram diagram = getDiagram(modelFileName);
		List<EObject> searchRoots = diagram.getChildren();

		ExpressionMatcher expressionMatcher = new ExpressionMatcher(expression, searchRoots);
		assertNotNull("object created", expressionMatcher);
		assertTrue( "elements founds",  expressionMatcher.getMatchingElements().size()>0 );
		
		// Call refresh
		expressionMatcher.refreshMatchingElements();
		assertEquals( "elements founds",  20, expressionMatcher.getMatchingElements().size() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.exprmatcher.ExpressionMatcher#getExpression()}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetExpression() throws LayersException {
		String expression = "self.oclIsKindOf(Shape)";

		String modelFileName = "/test/models/model1";
		Diagram diagram = getDiagram(modelFileName);
		List<EObject> searchRoots = diagram.getChildren();

		ExpressionMatcher expressionMatcher = new ExpressionMatcher(expression, searchRoots);
		
		assertEquals("expression found", expression, expressionMatcher.getExpression());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.exprmatcher.ExpressionMatcher#setExpression(java.lang.String)}.
	 * @throws LayersException 
	 */
	@Test
	public void testSetExpression() throws LayersException {
		String expression = "self.oclIsKindOf(Shape)";
//	    "self.oclIsKindOf(Shape)",
//	    "self.oclIsKindOf(Shape) and self.oclAsType(Shape).visible = true",
//		    "self.oclAsType(Shape).visible = true",

		String modelFileName = "/test/models/model1";
		Diagram diagram = getDiagram(modelFileName);
		List<EObject> searchRoots = diagram.getChildren();

		ExpressionMatcher expressionMatcher = new ExpressionMatcher(expression, searchRoots);
		assertNotNull("object created", expressionMatcher);
		assertTrue( "elements founds",  expressionMatcher.getMatchingElements().size()>0 );
		
		// Set the expression
		expressionMatcher.setExpression("self.oclAsType(Shape).visible = true");
		assertTrue( "elements founds",  expressionMatcher.getMatchingElements().size()>0 );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.exprmatcher.ExpressionMatcher#getMatchingElements()}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetMatchingElements() throws LayersException {
		String expression = "self.oclIsKindOf(Shape)";
//	    "self.oclIsKindOf(Shape)",
//	    "self.oclIsKindOf(Shape) and self.oclAsType(Shape).visible = true",
//		    "self.oclAsType(Shape).visible = true",

		String modelFileName = "/test/models/model1";
		Diagram diagram = getDiagram(modelFileName);
		List<EObject> searchRoots = diagram.getChildren();

		ExpressionMatcher expressionMatcher = new ExpressionMatcher(expression, searchRoots);
		assertNotNull("object created", expressionMatcher);
		assertTrue( "elements founds",  expressionMatcher.getMatchingElements().size()>0 );
		assertEquals( "elements founds",  20, expressionMatcher.getMatchingElements().size() );
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
	 * Test if the resource needed for the test exists.
	 * 
	 * @throws ModelMultiException
	 */
	@Test
	public void testDiagramExist() throws IOException, CoreException {
	
		String modelFileName = "/test/models/model1";
		Diagram diagram = getDiagram(modelFileName);
		
		assertNotNull("Diagram exist", diagram);
	}

	
}
