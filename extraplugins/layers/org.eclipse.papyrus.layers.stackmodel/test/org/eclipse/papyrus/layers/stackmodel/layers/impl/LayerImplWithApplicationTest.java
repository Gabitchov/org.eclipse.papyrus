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
import static org.junit.Assert.assertSame;

import org.eclipse.papyrus.layers.stackmodel.BadStateException;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.NullInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Tests applied to an instance initialied with an Application.
 * @author cedric dumoulin
 *
 */
public class LayerImplWithApplicationTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#resetAllPropertyValuesFromRegistry()}.
	 */
	@Test
	public void testLayer() {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		
		// check creation
		assertNotNull("application available", layer.getApplication());
		assertNotNull("property registry available", layer.getApplication().getPropertyRegistry());
	}

	/**
	 * Check if the {@link AbstractLayerImpl#propertyValues} list allows double.
	 */
	@Test
	public void testPropertyValuesAlowsDouble() {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		
		// check creation
		TypeInstance instance = NullInstance.NULLINSTANCE;
		
		layer.getPropertyValues().add(instance);	
		assertEquals("instance added", 1, layer.getPropertyValues().size());
		
		layer.getPropertyValues().add(instance);	
		assertEquals("same instance added==> double allowed", 2, layer.getPropertyValues().size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#resetAllPropertyValuesFromRegistry()}.
	 * @throws BadStateException 
	 */
	@Test
	public void testResetAllPropertyValuesFromRegistry() throws BadStateException {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		
		// Fill the map with an instance for the 2 first properties
		int index = 0;
		Property property = propertyRegistry.getProperties().get(index);
		TypeInstance instance = property.createInstance();
		layer.getPropertyValueMap().put(property.getName(), instance);
		
		Property property2 = propertyRegistry.getProperties().get(++index);
		TypeInstance instance2 = property2.createInstance();
		layer.getPropertyValueMap().put(property2.getName(), instance2);
		
		// call the method
		layer.resetAllPropertyValuesFromRegistry();
		// check if the propertyValues is correct
		assertEquals("size is same as available properties", propertyRegistry.getProperties().size(), layer.getPropertyValues().size());
		
		// Check property order
		assertSame("instance is at right index", instance, layer.getPropertyValues().get(0) );
		assertSame("instance is at right index", instance2, layer.getPropertyValues().get(1) );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#resetAllPropertyValuesFromRegistry()}.
	 * @throws BadStateException 
	 */
	@Test
	public void testAutomaticSynchronizationAfterAdd() throws BadStateException {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		
		// Fill the map with an instance for the 2 first properties
		int index = 0;
		Property property = propertyRegistry.getProperties().get(index);
		TypeInstance instance = property.createInstance();
		layer.getPropertyValueMap().put(property.getName(), instance);
		
		Property property2 = propertyRegistry.getProperties().get(++index);
		TypeInstance instance2 = property2.createInstance();
		layer.getPropertyValueMap().put(property2.getName(), instance2);
		
		// check if the propertyValues is correct
		assertEquals("size is same as available properties", propertyRegistry.getProperties().size(), layer.getPropertyValues().size());
		
		// Check property order
		assertSame("instance is at right index", instance, layer.getPropertyValues().get(0) );
		assertSame("instance is at right index", instance2, layer.getPropertyValues().get(1) );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#resetAllPropertyValuesFromRegistry()}.
	 * @throws BadStateException 
	 */
	@Test
	public void testAutomaticSynchronizationAfterRemove() throws BadStateException {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		
		// Fill the map with an instance 
		int index = 1;
		Property property = propertyRegistry.getProperties().get(index);
		TypeInstance instance = property.createInstance();
		layer.getPropertyValueMap().put(property.getName(), instance);
		
		// check if the propertyValues is correct
		assertEquals("size is same as available properties", propertyRegistry.getProperties().size(), layer.getPropertyValues().size());
		
		// Check property order
		assertSame("instance is at right index", instance, layer.getPropertyValues().get(index) );
		
		// Do remove instance
		layer.getPropertyValueMap().removeKey(property.getName());
		assertSame("instance is removed", NullInstance.NULLINSTANCE, layer.getPropertyValues().get(index) );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#synchronizePropertyValue(java.lang.String, org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance)}.
	 * Test synchronization.
	 * @throws BadStateException 
	 */
	@Test
	public void testSynchronizePropertyValue() throws BadStateException {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		
		// Get a property from PropertyRegistry
		int index = 1;
		Property property = application.getPropertyRegistry().getProperties().get(index);
		// create an instance of property
		TypeInstance instance = property.createInstance();
		// Add an instance to map
		layer.getPropertyValueMap().put(property.getName(), instance);
		
		// Check if the instance is also added to propertyValues
		assertSame("instance set to values at right index", instance, layer.getPropertyValues().get(index));
		
		// remove instance
		layer.getPropertyValueMap().removeKey(property.getName());
		assertEquals("propertyValues.size() is the same", application.getPropertyRegistry().getProperties().size(), layer.getPropertyValues().size());
		assertSame("instance removed from propertyValues", NullInstance.NULLINSTANCE, layer.getPropertyValues().get(index));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#getPropertyValues()}.
	 * Test if {@link Layer#getPropertyValues() is synchronized when an instance}
	 * is added to {@link Layer#getPropertyValueMap()}.


	 */
	@Test
	public void testGetPropertyValues() {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		
		// check list
		assertNotNull("list is created", layer.getPropertyValues());
		assertEquals("list.size()==number of available properties", application.getPropertyRegistry().getProperties().size(), layer.getPropertyValues().size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerImpl#getPropertyValueMap()}.
	 * @throws BadStateException 
	 */
	@Test
	public void testGetPropertyValueMap() throws BadStateException {
		// Create objets to test
		LayerImpl layer = (LayerImpl)LayersFactory.eINSTANCE.createLayer();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		
		// Check map
		assertNotNull("map is created", layer.getPropertyValueMap());
		
		// Try to add an instance in the map
		int index = 0;
		Property property = propertyRegistry.getProperties().get(index);
		TypeInstance instance = property.createInstance();
		layer.getPropertyValueMap().put(property.getName(), instance);
		
		// check retrieving
		assertSame("got the instance", instance, layer.getPropertyValueMap().get(property.getName() ));
		
		
	}

}
