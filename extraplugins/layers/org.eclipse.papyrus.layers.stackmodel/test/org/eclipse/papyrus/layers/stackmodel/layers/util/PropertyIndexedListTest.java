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
package org.eclipse.papyrus.layers.stackmodel.layers.util;

import static org.junit.Assert.*;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.papyrus.layers.stackmodel.BadStateException;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.NullInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class PropertyIndexedListTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.util.PropertyIndexedList#PropertyIndexedList(java.util.Map, java.lang.Class, org.eclipse.emf.ecore.InternalEObject, int, int)}.
	 */
	@Test
	public void testPropertyIndexedList() {
		
		// Create an object which already have a map
		// Here, we use Layer
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();
		assertTrue("registry has proprties", registry.getProperties().size() >0);
		
		PropertyIndexedList<TypeInstance> list = new PropertyIndexedList<TypeInstance>(layer.getPropertyValueMap(), TypeInstance.class, (InternalEObject)layer, 0, LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUE_MAP, NullInstance.NULLINSTANCE);
		list.setPropertyList(registry.getProperties());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.util.PropertyIndexedList#setPropertyList(java.util.List)}.
	 */
	@Test
	public void testSetPropertyList() {
		// Create an object which already have a map
		// Here, we use Layer
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();
		assertTrue("registry has proprties", registry.getProperties().size() >0);
		
		PropertyIndexedList<TypeInstance> list = new PropertyIndexedList<TypeInstance>(layer.getPropertyValueMap(), TypeInstance.class, (InternalEObject)layer, 0, LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUE_MAP, NullInstance.NULLINSTANCE);
		list.setPropertyList(registry.getProperties());
		
		assertEquals("list size is correct", registry.getProperties().size(), list.size());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.util.PropertyIndexedList#get(org.eclipse.papyrus.layers.stackmodel.layers.Property)}.
	 * @throws BadStateException 
	 */
	@Test
	public void testGetProperty() throws BadStateException {
		// Create an object which already have a map
		// Here, we use Layer
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();
		assertTrue("registry has proprties", registry.getProperties().size() >0);
		
		PropertyIndexedList<TypeInstance> list = new PropertyIndexedList<TypeInstance>(layer.getPropertyValueMap(), TypeInstance.class, (InternalEObject)layer, 0, LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUE_MAP, NullInstance.NULLINSTANCE);
		list.setPropertyList(registry.getProperties());
		
		// Add an instnace in the map
		Property property0 = registry.getProperties().get(0);
		TypeInstance instance0 = property0.createInstance();
		layer.getPropertyValueMap().put(property0.getName(), instance0);

		// checks
		assertEquals("list size is correct", registry.getProperties().size(), list.size());
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.util.PropertyIndexedList#set(org.eclipse.papyrus.layers.stackmodel.layers.Property, java.lang.Object)}.
	 * @throws BadStateException 
	 */
	@Test
	public void testSetPropertyT() throws BadStateException {
		// Create an object which already have a map
		// Here, we use Layer
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();
		assertTrue("registry has proprties", registry.getProperties().size() >0);
		
		PropertyIndexedList<TypeInstance> list = new PropertyIndexedList<TypeInstance>(layer.getPropertyValueMap(), TypeInstance.class, (InternalEObject)layer, 0, LayersPackage.ABSTRACT_LAYER__PROPERTY_VALUE_MAP, NullInstance.NULLINSTANCE);
		list.setPropertyList(registry.getProperties());
		
		// Add an instnace in the map
		Property property0 = registry.getProperties().get(0);
		TypeInstance instance0 = property0.createInstance();
		layer.getPropertyValueMap().put(property0.getName(), instance0);
		
		// Check that the instance is in the list
		assertSame("value is in the list at right position", instance0, list.get(0));
	}

}
