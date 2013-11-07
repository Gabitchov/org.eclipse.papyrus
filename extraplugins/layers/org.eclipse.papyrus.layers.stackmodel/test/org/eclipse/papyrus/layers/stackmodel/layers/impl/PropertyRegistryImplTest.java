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

import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class PropertyRegistryImplTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertyRegistryImpl#PropertyRegistryImpl()}.
	 */
	@Test
	public void testPropertyRegistryImpl() {
		// Create registry
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();
		assertNotNull("registry created", registry);
		
		// check internal object initialization
		assertNotNull("type registry created", registry.getTypeRegistry());
		assertNotNull("properties created", registry.getProperties());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertyRegistryImpl#PropertyRegistryImpl()}.
	 */
	@Test
	public void testinit() {
		// Create registry
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();
		assertNotNull("registry created", registry);
		
		// check init
		assertTrue("property list size is correct", registry.getProperties().size()>0);
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertyRegistryImpl#PropertyRegistryImpl()}.
	 */
	@Test
	public void testinitDefaultValue() {
		// Create registry
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();
		assertNotNull("registry created", registry);
		
		// check init
		assertTrue("property list size is correct", registry.getProperties().size()>0);
		
		// Check if default value is set for the first property
		assertNotNull("property list size is correct", registry.getProperties().get(0).getDefaultValue());
		
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertyRegistryImpl#getProperties()}.
	 */
	@Test
	public void testGetProperties() {
		// Create registry
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();
		assertNotNull("registry created", registry);
		
		// check internal object initialization
		assertNotNull("properties list created", registry.getProperties());
		assertTrue("properties created", registry.getProperties().size()>0);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertyRegistryImpl#getPropertiesCount()}.
	 */
	@Test
	public void testGetPropertiesCount() {
		// Create registry
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();
		assertNotNull("registry created", registry);
		
		// check internal object initialization
		assertSame("count is ok", registry.getProperties().size(), registry.getPropertiesCount());

		// Add a property
		Property property = LayersFactory.eINSTANCE.createProperty();
		property.setName("prop1");
		registry.getProperties().add(property);
		
		assertSame("count is ok", registry.getProperties().size(), registry.getPropertiesCount());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertyRegistryImpl#getTypeRegistry()}.
	 */
	@Test
	public void testGetTypeRegistry() {
		// Create registry
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();
		assertNotNull("registry created", registry);
		
		// check internal object initialization
		assertNotNull("type registry created", registry.getTypeRegistry());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertyRegistryImpl#getPropertyIndex(java.lang.String)}.
	 * @throws NotFoundException 
	 */
	@Test
	public void testGetPropertyIndex() throws NotFoundException {
		// Create registry
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();

		// test method
		int index = 0;
		Property property = registry.getProperties().get(index);
		
		assertEquals("index found", index, registry.getPropertyIndex(property.getName() ) );
	
	}

	/**
	 * Add a new Property and test if the index is correctly set.
	 * @throws NotFoundException 
	 */
	@Test
	public void testAddProperty() throws NotFoundException {
		// Create registry
		PropertyRegistry registry = LayersFactory.eINSTANCE.createPropertyRegistry();

		// Create a property
		String typeName = "boolean";
		String name = "prop1";
		Property property = LayersFactory.eINSTANCE.createProperty();
		property.setName(name);
		property.setType(registry.getTypeRegistry().getTypes().get(typeName));

		// Add property to registry
		registry.addProperty(property);
		
		// Get the property
		Property propFound = registry.getProperty(name);
		assertSame( "property found", property, propFound);
		
		assertTrue("property index set", propFound.getIndex()>=0);
		
	}


}
