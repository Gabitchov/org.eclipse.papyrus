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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.papyrus.layers.stackmodel.BadStateException;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.NullInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.util.PropertyUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class LayerImplTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#LayerImpl()}.
	 */
	@Test
	public void testLayerImpl() {
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		assertNotNull("object created", layer);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#getPropertyValues()}.
	 */
	@Test
	public void testGetPropertyValues() {
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		
		assertNotNull("list created", layer.getPropertyValues());
	}

	/**
	 * Check if the {@link AbstractLayerImpl#propertyValues} list allows double.
	 */
	@Test
	public void testPropertyValuesAllowsDouble() {
		// Create object to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		
		// check creation
		TypeInstance instance = NullInstance.NULLINSTANCE;
		
		layer.getPropertyValues().add(instance);	
		assertEquals("instance added", 1, layer.getPropertyValues().size());
		
		layer.getPropertyValues().add(instance);	
		assertEquals("same instance added==> double allowed", 2, layer.getPropertyValues().size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#getPropertyValueMap()}.
	 */
	@Test
	public void testGetPropertyValueMap() {
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		
		assertNotNull("PropertyValueMap exist", layer.getPropertyValueMap());
		
		// Create a type instance and add it to layer
		TypeInstance typeInstance = LayersFactory.eINSTANCE.createStringInstance();
		String key = "name";
		layer.getPropertyValueMap().put(key, typeInstance);
		
		// check if we can retrieve the instance
		assertNotNull("PropertyValueMap exis", layer.getPropertyValueMap().get(key));

	}

	/**
	 * Test method .
	 * @throws BadStateException 
	 */
	@Test
	public void testResetAllPropertyValuesFromRegistry() throws BadStateException {
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		
		// call method.
		// Nothing should happen
		layer.resetAllPropertyValuesFromRegistry();
		
		// check
		assertEquals("list is empty", 0, layer.getPropertyValues().size());
	}


	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#getViews()}.
	 */
	@Test
	public void testGetViews() {
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		
		assertNotNull("list created", layer.getViews());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#addPropertyInstance(org.eclipse.papyrus.layers.stackmodel.layers.Property)}.
	 * @throws LayersException 
	 */
	@Test
	public void testAddPropertyInstance() throws LayersException {
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		
		String propertyName = "isSunday";
		Property property = PropertyUtils.getInstance().createProperty( propertyName, LayersPackage.eINSTANCE.getBooleanType());
		layer.addPropertyInstance(property);
		
		assertNotNull("list created", layer.getPropertyValueMap().get(propertyName));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#addPropertyInstance(org.eclipse.papyrus.layers.stackmodel.layers.Property)}.
	 * @throws LayersException 
	 */
	@Test
	public void testgetPropertyInstanceByProperty() throws LayersException {
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		
		String propertyName = "isSunday";
		Property property = PropertyUtils.getInstance().createProperty( propertyName, LayersPackage.eINSTANCE.getBooleanType());
		layer.addPropertyInstance(property);
		
		assertNotNull("property found by property", layer.getPropertyInstance(property));

		assertNotNull("property found by name", layer.getPropertyInstance(propertyName));
	}


}
