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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.util.FakeObservableListListener;
import org.eclipse.papyrus.layers.stackmodel.util.ObservableListView;
import org.eclipse.uml2.uml.NamedElement;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	 * Test an expression
	 * @throws LayersException 
	 */
	@Test
	public void testExpression() throws LayersException {
		
//		Shape s;
//		((NamedElement)s.getElement()).getName().startsWith(prefix);
		
		String expression = "self.oclAsType(Shape).visible = true";
//		self.oclAsType(Shape).element.oclAsType(uml::NamedElement).name.startsWith('C') = true
//		"self.element.oclAsType(uml::NamedElement).name.startsWith('C') = true";
//	    "self.oclIsKindOf(Shape)",
//	    "self.oclIsKindOf(Shape) and self.oclAsType(Shape).visible = true",
//		    "self.oclAsType(Shape).visible = true",

		String modelFileName = "/test/models/model1";
		Diagram diagram = getDiagram(modelFileName);
		List<EObject> searchRoots = diagram.getChildren();

		ExpressionMatcher expressionMatcher = new ExpressionMatcher(expression, searchRoots);
		assertNotNull("object created", expressionMatcher);
		
		// Expression with uml can't works because there is no uml model.
		assertTrue("result not empty", !expressionMatcher.getMatchingElements().isEmpty());
		
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

	/**
	 * Test removing elements.
	 * @throws LayersException 
	 */
	@Test
	public void testRemoveElements() throws LayersException {
		String expression = "self.oclIsKindOf(Shape)";
//	    "self.oclIsKindOf(Shape)",
//	    "self.oclIsKindOf(Shape) and self.oclAsType(Shape).visible = true",
//		    "self.oclAsType(Shape).visible = true",

		String modelFileName = "/test/models/model1";
		Diagram diagram = getDiagram(modelFileName);
		
		int removedElementCount = 5;
		int addedElementCount = 0;
		int expectedEventCount = 1;
		
		FakeObservableListListener<View> notifyingListListener = new FakeObservableListListener<View>();
		ExpressionMatcher expressionMatcher = new ExpressionMatcher(expression, diagram);
		
		expressionMatcher.getMatchingElements().getEventBus().register(notifyingListListener);

		// Action
		notifyingListListener.traces.clear();
		removeElements(diagram, removedElementCount);
		expressionMatcher.refreshMatchingElements();
		
		// Assert
		assertSame("event propagated", expectedEventCount, notifyingListListener.traces.size());
		
		ObservableListView<View>.ObservableListEvent event = notifyingListListener.traces.get(0).notifier;

		assertEquals("expected removed count", removedElementCount, event.getRemovedElements().size());
		assertEquals("expected added count", addedElementCount, event.getAddedElements().size());
	}

	/**
	 * Test removing elements.
	 * @throws LayersException 
	 */
	@Test
	public void testAddElements() throws LayersException {
		String expression = "self.oclIsKindOf(Shape)";
//	    "self.oclIsKindOf(Shape)",
//	    "self.oclIsKindOf(Shape) and self.oclAsType(Shape).visible = true",
//		    "self.oclAsType(Shape).visible = true",

		String modelFileName = "/test/models/model1";
		Diagram diagram = getDiagram(modelFileName);
		
		int removedElementCount = 0;
		int addedElementCount = 5;
		int expectedEventCount = 1;
		int viewsCount = diagram.getChildren().size();
		
		FakeObservableListListener<View> notifyingListListener = new FakeObservableListListener<View>();
		ExpressionMatcher expressionMatcher = new ExpressionMatcher(expression, diagram);
		
		expressionMatcher.getMatchingElements().getEventBus().register(notifyingListListener);

		// Action
		notifyingListListener.traces.clear();
		addShapeElements(diagram, addedElementCount);
		removeElements(diagram, removedElementCount);
		expressionMatcher.refreshMatchingElements();
		
		// Assert
		assertSame("elements added", viewsCount+addedElementCount, diagram.getChildren().size());
				
		assertSame("event propagated", expectedEventCount, notifyingListListener.traces.size());
		
		ObservableListView<View>.ObservableListEvent event = notifyingListListener.traces.get(0).notifier;

		assertEquals("expected removed count", removedElementCount, event.getRemovedElements().size());
		assertEquals("expected added count", addedElementCount, event.getAddedElements().size());
	}

	/**
	 * Test removing elements.
	 * @throws LayersException 
	 */
	@Test
	public void testAddAndRemoveElements() throws LayersException {
		String expression = "self.oclIsKindOf(Shape)";
//	    "self.oclIsKindOf(Shape)",
//	    "self.oclIsKindOf(Shape) and self.oclAsType(Shape).visible = true",
//		    "self.oclAsType(Shape).visible = true",

		String modelFileName = "/test/models/model1";
		Diagram diagram = getDiagram(modelFileName);
		
		int removedElementCount = 4;
		int addedElementCount = 5;
		int expectedEventCount = 1;
		int viewsCount = diagram.getChildren().size();
		
		FakeObservableListListener<View> notifyingListListener = new FakeObservableListListener<View>();
		ExpressionMatcher expressionMatcher = new ExpressionMatcher(expression, diagram);
		
		expressionMatcher.getMatchingElements().getEventBus().register(notifyingListListener);

		// Action
		notifyingListListener.traces.clear();
		removeElements(diagram, removedElementCount);
		addShapeElements(diagram, addedElementCount);
		expressionMatcher.refreshMatchingElements();
		
		// Assert
		assertSame("elements added", viewsCount+addedElementCount-removedElementCount, diagram.getChildren().size());
				
		assertSame("event propagated", expectedEventCount, notifyingListListener.traces.size());
		
		ObservableListView<View>.ObservableListEvent event = notifyingListListener.traces.get(0).notifier;

		assertEquals("expected removed count", removedElementCount, event.getRemovedElements().size());
		assertEquals("expected added count", addedElementCount, event.getAddedElements().size());
	}


	/**
	 * Remove n Views from the provided diagram
	 * @param diagram
	 * @param removedElementCount
	 */
	private void removeElements(Diagram diagram, int removedElementCount) {

		List<View> views = diagram.getChildren();
		
		int index = views.size()-1;
		for( int i=0; i<removedElementCount&&index>=0; i++) {
			diagram.removeChild(views.get(index));
			index = views.size()-1;
		}
		
	}

	/**
	 * Add n Views to the provided diagram
	 * @param diagram
	 * @param removedElementCount
	 */
	private void addShapeElements(Diagram diagram, int elementCount) {

		for( int i=0; i<elementCount; i++) {
			diagram.createChild(NotationPackage.eINSTANCE.getShape());
		}
		
	}


}
