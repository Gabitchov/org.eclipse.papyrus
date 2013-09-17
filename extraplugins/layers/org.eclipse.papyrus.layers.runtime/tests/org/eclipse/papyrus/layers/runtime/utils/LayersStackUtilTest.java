/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin Cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.runtime.utils;

import static org.junit.Assert.*;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class LayersStackUtilTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.utils.LayersStackUtil#getInstance()}.
	 */
	@Test
	public void testGetInstance() {
		LayersStackUtil layerStackUtil = LayersStackUtil.getInstance();
		assertNotNull("shared instance exist", layerStackUtil);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.utils.LayersStackUtil#getLayersStack(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testGetLayersStack() {
		LayersStackUtil layerStackUtil = LayersStackUtil.getInstance();
		
		// Create a Diagram
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		// Try to get a LayersStack
		// Layer stack is created
		LayersStack layerStack = layerStackUtil.getLayersStack(diagram);
		// Check result
		assertNotNull("layerStack created", layerStack);
		
		// Try to get it again: previous LayersStack should be returned
		LayersStack layerStack2 = layerStackUtil.getLayersStack(diagram);
		// Check result
		assertNotNull("layerStack found", layerStack2);
		assertSame("same layerStack found", layerStack, layerStack2);
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.utils.LayersStackUtil#lookupLayersStack(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testLookupLayersStack() {
		LayersStackUtil layerStackUtil = LayersStackUtil.getInstance();
		// Create a Diagram
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		// Try to lookup a LayersStack
		// No Layer stack is created
		LayersStack layerStack = layerStackUtil.lookupLayersStack(diagram);
		// Check result
		assertNull("no layerStack created", layerStack);
		
		// Now, create a LayersStack
		LayersStack createdLayersStack = layerStackUtil.createLayersStack(diagram);
		// Check result
		assertNotNull("layerStack created", createdLayersStack);
		
		// Try to lookup
		layerStack = layerStackUtil.lookupLayersStack(diagram);
		assertNotNull("layerStack created", layerStack);
		assertSame("same layerStack found", createdLayersStack, layerStack);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.utils.LayersStackUtil#createLayersStack(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testCreateLayersStack() {
		LayersStackUtil layerStackUtil = LayersStackUtil.getInstance();

		// Create a Diagram
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Now, create a LayersStack
		LayersStack createdLayersStack = layerStackUtil.createLayersStack(diagram);
		// Check result
		assertNotNull("layerStack created", createdLayersStack);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.utils.LayersStackUtil#removeLayersStack(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testRemoveLayersStack() {
		LayersStackUtil layerStackUtil = LayersStackUtil.getInstance();
		
		// Create a Diagram
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		// Try to get a LayersStack
		// Layer stack is created
		LayersStack layerStack = layerStackUtil.getLayersStack(diagram);
		// Check result
		assertNotNull("layerStack created", layerStack);
		
		// Try to remove it
		layerStackUtil.removeLayersStack(diagram);
		// Check removal
		layerStack= layerStackUtil.lookupLayersStack(diagram);
		assertNull("layer stack not found (removed)", layerStack);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.utils.LayersStackUtil#testIsLayersStackAttached(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testIsLayersStackAttached() {
		LayersStackUtil layerStackUtil = LayersStackUtil.getInstance();
		// Create a Diagram
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		// Check result
		assertFalse("no layer stack attached", layerStackUtil.isLayersStackAttached(diagram));
		
		// Now, create a LayersStack
		LayersStack createdLayersStack = layerStackUtil.createLayersStack(diagram);
		// Check result
		assertNotNull("layerStack created", createdLayersStack);
		
		// Check result
		assertTrue("layer stack attached", layerStackUtil.isLayersStackAttached(diagram));
  
		// Remove LayersStack and check
		layerStackUtil.removeLayersStack(diagram);
		assertFalse("no layer stack attached", layerStackUtil.isLayersStackAttached(diagram));
			
	}

}
