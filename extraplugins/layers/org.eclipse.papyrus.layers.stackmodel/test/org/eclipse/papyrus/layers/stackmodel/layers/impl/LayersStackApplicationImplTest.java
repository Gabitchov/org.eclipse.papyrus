/*******************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Cedric Dumoulin - cedric.dumoulin@lifl.fr
 ******************************************************************************/
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class LayersStackApplicationImplTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#LayersStackApplicationImpl()}.
	 */
	@Test
	public void testLayersStackApplicationImpl() {
		// Create instance
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		assertNotNull("instance created", application);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#init()}.
	 */
	@Test
	public void testInit() {
		// Create instance
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();

	    // Check other instances creation
		assertNotNull("propertyRegistry created", application.getPropertyRegistry()	);
		assertNotNull("layerDescriptorRegistry created", application.getLayerDescriptorRegistry()	);
		assertNotNull("propertySetterRegistry  created", application.getPropertySetterRegistry()	);
		assertNotNull("LayerOperatorDescriptorRegistry  created", application.getLayerOperatorDescriptorRegistry()	);
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#getLayersStacks()}.
	 */
	@Test
	public void testGetLayersStacks() {
		// Create instance
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();

	    // Check other instances creation
		assertNotNull("stacks list created", application.getLayersStacks()	);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#getPropertyRegistry()}.
	 */
	@Test
	public void testGetPropertyRegistry() {
		// Create instance
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();

	    // Check other instances creation
		assertNotNull("propertyRegistry created", application.getPropertyRegistry()	);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#getLayerDescriptorRegistry()}.
	 */
	@Test
	public void testGetLayerDescriptorRegistry() {
		// Create instance
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();

	    // Check other instances creation
		assertNotNull("layerDescriptorRegistry created", application.getLayerDescriptorRegistry()	);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#removeLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testRemoveLayersStackFor() {
		// Create instance
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		// try to get a layer stack
		application.getLayersStackFor(diagram);
		
		// Create a second stack
		Diagram diagram2 = NotationFactory.eINSTANCE.createDiagram();
		LayersStack stack2 = application.getLayersStackFor(diagram2);

		// Remove first stack
		application.removeLayersStackFor(diagram);
		// Check if not exist
		assertFalse("stack is detached", application.isLayersStackAttachedFor(diagram));
		assertTrue("stack is attached", application.isLayersStackAttachedFor(diagram2));
		assertSame("get found previous stack", stack2, application.getLayersStackFor(diagram2));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#isLayersStackAttachedFor(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testIsLayersStackAttachedFor() {
		// Create instance
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		// check if there is a stack
		assertFalse( "no stack is found", application.isLayersStackAttachedFor(diagram) );
		
		// try to get a layer stack
		LayersStack stack = application.getLayersStackFor(diagram);
		assertNotNull("stack is created", stack);
		
		assertTrue("stack is attached", application.isLayersStackAttachedFor(diagram));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#lookupLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram)}.
	 * @throws NotFoundException 
	 */
	@Test
	public void testLookupLayersStackFor() throws NotFoundException {
		// Create instance
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		// Try to lookup. Should found nothing
		try {
			application.lookupLayersStackFor(diagram);
			fail("An NotFoundException should be throw");
		} catch (NotFoundException e) {
		}
		
		// try to get a layer stack
		LayersStack stack = application.getLayersStackFor(diagram);
		assertNotNull("stack is created", stack);
		
		assertSame("lookup found stack", stack, application.lookupLayersStackFor(diagram));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#getLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testGetLayersStackFor() {
		// Create instance
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		// try to get a layer stack
		LayersStack stack = application.getLayersStackFor(diagram);
		assertNotNull("stack is created", stack);
		
		// Create a second stack
		Diagram diagram2 = NotationFactory.eINSTANCE.createDiagram();
		LayersStack stack2 = application.getLayersStackFor(diagram2);
		assertNotNull("stack is created", stack2);

		// Get them again
		assertSame("get found previuous stack", stack, application.getLayersStackFor(diagram));
		assertSame("get found previuous stack", stack2, application.getLayersStackFor(diagram2));
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackApplicationImpl#createLayersStackFor(org.eclipse.gmf.runtime.notation.Diagram)}.
	 */
	@Test
	public void testCreateLayersStackFor() {
		// Create instance
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		
		// try to get a layer stack
		LayersStack stack = application.createLayersStackFor(diagram);
		assertNotNull("stack is created", stack);
		
	}

}
