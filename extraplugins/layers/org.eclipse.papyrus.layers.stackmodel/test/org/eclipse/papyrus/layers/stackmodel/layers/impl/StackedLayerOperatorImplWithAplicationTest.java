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

import static org.junit.Assert.*;

import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class StackedLayerOperatorImplWithAplicationTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.StackedLayerOperatorImpl#resetDescriptor()}.
	 */
	@Test
	public void testResetDescriptor() {
		// Create objects to test
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		LayerOperatorDescriptor layerDesc = LayersFactory.eINSTANCE.createLayerOperatorDescriptor();
		String layerDescName = "myLayerDesc";
		layerDesc.setName(layerDescName );
		application.getLayerOperatorDescriptorRegistry().addLayerOperatorDescriptor(layerDesc);
		
		StackedLayerOperator layer = LayersFactory.eINSTANCE.createStackedLayerOperator();

		// Check if the descriptor is unset
		assertFalse("descriptor is not set", layer.isDescriptorSet());
		
		// Set name and application.
		// This should call reset, and set the descriptor
		layer.setLayerOperatorDescriptorName(layerDescName);
		layer.setApplication(application);
		
		// check if the descriptor is set
		assertTrue("descriptor is set", layer.isDescriptorSet());
		assertSame("right descriptor is set", layerDesc, layer.getLayerOperatorDescriptor());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.StackedLayerOperatorImpl#StackedLayerOperatorImpl()}.
	 */
	@Test
	public void testStackedLayerOperatorImpl() {
		// Create objects to test
		StackedLayerOperator layer = LayersFactory.eINSTANCE.createStackedLayerOperator();

		// Check if the descriptor is unset
		assertNotNull("layer is created", layer);
		assertFalse("descriptor is not set", layer.isDescriptorSet());
		
	}

}
