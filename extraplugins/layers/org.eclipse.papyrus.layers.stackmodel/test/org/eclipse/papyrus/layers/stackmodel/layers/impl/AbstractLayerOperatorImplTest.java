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
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class AbstractLayerOperatorImplTest {

	/**
	 * Object to test.
	 * As the {@link AbstractLayerOperator} is abstract, the implementation
	 * is one of the concrete subtype.
	 * 
	 */
	protected AbstractLayerOperator abstractLayerOperator;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		abstractLayerOperator = LayersFactory.eINSTANCE.createStackedLayerOperator();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerOperatorImpl#AbstractLayerOperatorImpl()}.
	 */
	@Test
	public void testAbstractLayerOperatorImpl() {
		assertNotNull("layerOperaator created", abstractLayerOperator);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerOperatorImpl#isDescriptorSet()}.
	 */
	@Test
	public void testIsDescriptorSet() {
		
		// Create objects requested for test
		LayerOperatorDescriptor layerDesc = LayersFactory.eINSTANCE.createLayerOperatorDescriptor();

		// Check 
		assertFalse( "descriptor is not set after creation", abstractLayerOperator.isDescriptorSet());
		
		// Set name and application.
		// This should call reset, and set the descriptor
		abstractLayerOperator.setLayerOperatorDescriptor(layerDesc);
		
		// check if the descriptor is set
		assertTrue("descriptor is set", abstractLayerOperator.isDescriptorSet());
		assertSame("right descriptor is set", layerDesc, abstractLayerOperator.getLayerOperatorDescriptor());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerOperatorImpl#resetDescriptor()}.
	 */
	@Test
	@Ignore
	public void testResetDescriptor() {
		fail("Not yet implemented");
	}

}
