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

import static org.junit.Assert.*;

import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperatorDescriptor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class StackedLayerOperatorDescriptorImplTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.StackedLayerOperatorDescriptorImpl#StackedLayerOperatorDescriptorImpl()}.
	 */
	@Test
	public void testStackedLayerOperatorDescriptorImpl() {
		// Create an instance of the class
		StackedLayerOperatorDescriptor descriptor = LayersFactory.eINSTANCE.createStackedLayerOperatorDescriptor();
		
		assertNotNull("object created", descriptor);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorImpl#getName()}.
	 */
	@Test
	public void testGetName() {
		// Create an instance of the class
		StackedLayerOperatorDescriptor descriptor = LayersFactory.eINSTANCE.createStackedLayerOperatorDescriptor();
		
		// Do test
		assertSame("name correctly set", "StackedLayerOperator", descriptor.getName());
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorImpl#createLayerOperator()}.
	 */
	@Test
	public void testCreateLayerOperator() {
		// Create an instance of the class
		StackedLayerOperatorDescriptor descriptor = LayersFactory.eINSTANCE.createStackedLayerOperatorDescriptor();
		
		AbstractLayerOperator layerOperator = descriptor.createLayerOperator();
		assertNotNull("layer created", layerOperator);
		assertTrue("right type", layerOperator instanceof StackedLayerOperator);
		assertSame("descriptor is set", descriptor, layerOperator.getLayerOperatorDescriptor());
	}

}
