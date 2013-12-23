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

package org.eclipse.papyrus.layers.stackmodel.util;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.eclipse.uml2.uml.Class;

import com.google.common.collect.Lists;

/**
 * 
 * 
 * @author cedric dumoulin
 *
 */
public class DiagramViewToListSynchronizerTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.DiagramViewToListSynchronizer#DiagramViewToListSynchronizer(org.eclipse.gmf.runtime.notation.Diagram, java.util.Collection)}.
	 */
	@Test
	public void testDiagramViewToListSynchronizer() {
		
		// Create variables
		NotationAndUmlModelsFactory factory = new NotationAndUmlModelsFactory();
		Diagram diagram1 =factory.newDiagram();

		List<View> list = new ArrayList<View>();
		
		// 
		DiagramViewToListSynchronizer listSynchronizer = new DiagramViewToListSynchronizer(diagram1, list);
		
		// assert
		assertNotNull("object created", listSynchronizer);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.DiagramViewToListSynchronizer#setDiagram(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testSetDiagram() {
		// Create variables
		NotationAndUmlModelsFactory factory = new NotationAndUmlModelsFactory();
		Diagram diagram1 =factory.newDiagram();
		Class C1 = factory.newClass(diagram1, "C1");
		View shape1 = factory.lookupViewFor(diagram1, C1);
		Class C2 = factory.newClass(diagram1, "C2");
		View shape2 = factory.lookupViewFor(diagram1, C2);
		Class C3 = factory.newClass(diagram1, "C3");
		View shape3 = factory.lookupViewFor(diagram1, C3);
		
		List<View> expectedViews1 = Lists.newArrayList(shape1, shape2, shape3);
		
		// Check if the list is set on init
		List<View> list = new ArrayList<View>();
		DiagramViewToListSynchronizer listSynchronizer = new DiagramViewToListSynchronizer(diagram1, list);
		int expectedSize = 3;
		// Assert
		assertEquals("list size", expectedSize, list.size());
		assertTrue("list correctly set", list.containsAll(expectedViews1) );
		
		
		// Now, change the diagram
		Diagram diagram2 =factory.newDiagram();
		Class C21 = factory.newClass(diagram2, "C1");
		View shape21 = factory.lookupViewFor(diagram2, C21);
		Class C22 = factory.newClass(diagram2, "C2");
		View shape22 = factory.lookupViewFor(diagram2, C22);
		Class C23 = factory.newClass(diagram2, "C3");
		View shape23 = factory.lookupViewFor(diagram2, C23);
		List<View> expectedViews2 = Lists.newArrayList(shape21, shape22, shape23);
		int expectedSize2 = 3;
		

		// Action
		listSynchronizer.setDiagram(diagram2);
		// Assert
		assertEquals("list size", expectedSize2, list.size());
		assertTrue("list correctly set", list.containsAll(expectedViews2) );
	}

	/**
	 * Test list sync
	 */
	@Test
	public void testSyncWhenViewIsAdded() {
		
		// Create variables
		NotationAndUmlModelsFactory factory = new NotationAndUmlModelsFactory();
		Diagram diagram1 =factory.newDiagram();

		int expectedSize = 1;
		List<View> list = new ArrayList<View>();
		DiagramViewToListSynchronizer listSynchronizer = new DiagramViewToListSynchronizer(diagram1, list);
		// Action
		Class C1 = factory.newClass(diagram1, "C1");
		View shape1 = factory.lookupViewFor(diagram1, C1);
		
		// assert
		assertEquals("listSize", expectedSize, list.size());
		assertTrue("list contain expected view", list.contains(shape1));
	}

	/**
	 * Test list sync
	 */
	@Test
	public void testSyncWhenViewIsRemoved() {
		
		// Create variables
		NotationAndUmlModelsFactory factory = new NotationAndUmlModelsFactory();
		Diagram diagram1 =factory.newDiagram();

		int expectedSize = 3;
		List<View> list = new ArrayList<View>();
		DiagramViewToListSynchronizer listSynchronizer = new DiagramViewToListSynchronizer(diagram1, list);

		Class C1 = factory.newClass(diagram1, "C1");
		View shape1 = factory.lookupViewFor(diagram1, C1);
		Class C2 = factory.newClass(diagram1, "C2");
		View shape2 = factory.lookupViewFor(diagram1, C2);
		Class C3 = factory.newClass(diagram1, "C3");
		View shape3 = factory.lookupViewFor(diagram1, C3);
		
		// assert before
		assertEquals("listSize", expectedSize, list.size());
		assertTrue("list contain expected view", list.contains(shape2));

		// Action
		factory.remove(diagram1, C2);
		// assert
		assertEquals("listSize", expectedSize-1, list.size());
		assertFalse("list contain expected view", list.contains(shape2));
	}


}
