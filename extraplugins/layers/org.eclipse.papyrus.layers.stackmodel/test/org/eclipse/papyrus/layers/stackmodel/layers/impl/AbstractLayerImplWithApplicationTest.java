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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test methods declared in {@link AbstractLayer}.
 * Use a {@link Layer} for test.
 * 
 * @author cedric dumoulin
 *
 */
public class AbstractLayerImplWithApplicationTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#getPropertyValueMap()}.
	 */
	@Test
	public void testAbstractLayer() {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		
		// Add instances to the layer
		int index = 1;
		Property property1 = propertyRegistry.getProperties().get(index++);
		Property property2 = propertyRegistry.getProperties().get(index++);

		// check if we can retrieve the instance
		assertNotNull("PropertyValueMap exis", layer);

	}
	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerImpl#getAttachedProperties()}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetAttachedProperties() throws LayersException {
		// Create objects to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		
		// Add instances to the layer
		int index = 1;
		Property property1 = propertyRegistry.getProperties().get(index++);
		Property property2 = propertyRegistry.getProperties().get(index++);
		
		layer.addPropertyInstance(property1);
		layer.addPropertyInstance(property2);
		
		// check if we can get the list 
		assertEquals("size is same as available properties", 2, layer.getAttachedProperties().size());
		
		// Check property order
		assertTrue("property is found", layer.getAttachedProperties().contains(property1) );
		assertTrue("property is found", layer.getAttachedProperties().contains(property2) );
		
		
	}

}
