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

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.eclipse.uml2.uml.Class;

/**
 * 
 * @author cedric dumoulin
 *
 */
public class NotationAndUmlModelsFactoryTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.NotationAndUmlModelsFactory#newDiagram()}.
	 */
	@Test
	public void testNotationAndUmlModelsTestUtils() {
		NotationAndUmlModelsFactory factory = new NotationAndUmlModelsFactory();
		
		assertNotNull("object created", factory);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.NotationAndUmlModelsFactory#newDiagram()}.
	 */
	@Test
	public void testNewDiagram() {
		NotationAndUmlModelsFactory factory = new NotationAndUmlModelsFactory();
		
		Diagram diagram1 =factory.newDiagram();
		
		assertNotNull("diagram1 created", diagram1);
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.NotationAndUmlModelsFactory#newClass(org.eclipse.gmf.runtime.notation.Diagram, java.lang.String)}.
	 */
	@Test
	public void testNewClass() {
		NotationAndUmlModelsFactory factory = new NotationAndUmlModelsFactory();
		
		// Action
		Diagram diagram1 =factory.newDiagram();
		Class c1 = factory.newClass(diagram1, "C1");
		Class c2 = factory.newClass(diagram1, "C2");
		
		// Lookup Shape
		View shape1 = factory.lookupViewFor(diagram1, c1);
		View shape2 = factory.lookupViewFor(diagram1, c2);
		
		// Assert
		assertNotNull("class created", c1);
		assertNotNull("shape created", shape2);
		assertNotNull("shape created", shape1);
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.util.NotationAndUmlModelsFactory#remove(org.eclipse.gmf.runtime.notation.Diagram, java.lang.String)}.
	 */
	@Test
	public void testRemove() {
		NotationAndUmlModelsFactory factory = new NotationAndUmlModelsFactory();
		
		Diagram diagram1 =factory.newDiagram();
		Class c1 = factory.newClass(diagram1, "C1");
		Class c2 = factory.newClass(diagram1, "C2");
		
		// Lookup Shape
		View shape1 = factory.lookupViewFor(diagram1, c1);
		View shape2 = factory.lookupViewFor(diagram1, c2);

		// Action
		View removedShape = factory.remove(diagram1, c1);
		View lookupResult = factory.lookupViewFor(diagram1, c1);
		
		// Assert
		assertNotNull("object removed found", removedShape);
		assertSame("Right object removed", shape1, removedShape);
		
		assertNull("lookupResult null after remove", lookupResult);
		
	}

}
