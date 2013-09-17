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
import org.eclipse.papyrus.layers.stackmodel.layers.DefaultPropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class LayerOperatorDescriptorRegistryImplTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#LayerOperatorDescriptorRegistryImpl()}.
	 */
	@Test
	public void testLayerOperatorDescriptorRegistryImpl() {


		// Create a registry
		int propertiesCollectionSize = 10;
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);
		
		assertNotNull("registry created", registry);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#getDescriptors()}.
	 */
	@Test
	public void testGetDescriptors() {
		// Create a registry
		int propertiesCollectionSize = 10;
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);
		
		assertNotNull("descriptors list is set", registry.getDescriptors());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#getPropertyOperators()}.
	 */
	@Test
	public void testGetPropertyOperators() {
		// Create a registry
		int propertiesCollectionSize = 10;
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);
		
		assertNotNull("operators list is set", registry.getPropertyOperators());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#getPropertyCollectionSize()}.
	 */
	@Test
	public void testGetPropertyCollectionSize() {
		// Create a registry
		int propertiesCollectionSize = 10;
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);
		
		assertSame("sie is set", propertiesCollectionSize, registry.getPropertyCollectionSize());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#setPropertyCollectionSize(int)}.
	 */
	@Test
	public void testSetPropertyCollectionSize() {
		// Create a registry
		int propertiesCollectionSize = 10;
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);
		
		assertSame("size set", propertiesCollectionSize, registry.getPropertyCollectionSize());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#getDefaultOperator()}.
	 */
	@Test
	public void testGetDefaultOperator() {
		// Create a registry
		int propertiesCollectionSize = 10;
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);
		
		// Check the default operator
		assertNotNull("default operator set", registry.getDefaultOperator());
		assertTrue("default operator type", registry.getDefaultOperator() instanceof DefaultPropertyOperator);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#addLayerOperatorDescriptor(org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor)}.
	 */
	@Test
	public void testAddLayerOperatorDescriptor() {
		// Create a registry
		int propertiesCollectionSize = 10;
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);

	    // Create a LayerOperatorDesc
		LayerOperatorDescriptor descriptor = LayersFactory.eINSTANCE.createAndStackedLayerOperatorDescriptor();

		// Add it
		registry.addLayerOperatorDescriptor(descriptor);
		
		// Check if correctly added
		assertSame("list size increased", 1, registry.getDescriptors().size());
		assertSame("descriptor found", descriptor, registry.getDescriptors().get(0));
		
		assertSame("descriptor property size set", propertiesCollectionSize, descriptor.getPropertyOperators().size());
		
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#getLayerOperatorDescriptor(java.lang.String)}.
	 * @throws NotFoundException 
	 */
	@Test
	public void testGetLayerOperatorDescriptor() throws NotFoundException {
		// Create a registry
		int propertiesCollectionSize = 10;
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);

	    // Create a LayerOperatorDesc
		LayerOperatorDescriptor descriptor = LayersFactory.eINSTANCE.createLayerOperatorDescriptor();
		descriptor.setName("desc1");
		
		// Add it
		registry.addLayerOperatorDescriptor(descriptor);
				
		// Try to get by its name
		assertSame("descriptor found by its name", descriptor, registry.getLayerOperatorDescriptor(descriptor.getName()));

		// Try with a wrong name
		try {
			registry.getLayerOperatorDescriptor("wrong name");
			fail("Wrong name send an NotFoundException");
		} catch (NotFoundException e) {
			// ok
		}
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#addPropertyOperator(org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator)}.
	 */
	@Test
	public void testAddPropertyOperator() {
		// Create a registry
		int propertiesCollectionSize = 10;
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);

	    // Create a PropertyOperator
		PropertyOperator operator1 = LayersFactory.eINSTANCE.createPropertyOperator();
		operator1.setName("op1");

		// Add it
		registry.addPropertyOperator(operator1);
		
		// Check if correctly added
		assertSame("list size increased", 1, registry.getPropertyOperators().size());
		assertSame("descriptor found", operator1, registry.getPropertyOperators().get(0));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#getPropertyOperator(java.lang.String)}.
	 * @throws NotFoundException 
	 */
	@Test
	public void testGetPropertyOperator() throws NotFoundException {
		// Create a registry
		int propertiesCollectionSize = 10;
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);

	    // Create a PropertyOperator
		PropertyOperator operator1 = LayersFactory.eINSTANCE.createPropertyOperator();
		operator1.setName("op1");

		// Add it
		registry.addPropertyOperator(operator1);
		
		// Try to get by its name
		assertSame("operator found by its name", operator1, registry.getPropertyOperator(operator1.getName()));

		// Try with a wrong name
		try {
			registry.getPropertyOperator("wrong name");
			fail("Wrong name send an NotFoundException");
		} catch (NotFoundException e) {
			// ok
		}
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorRegistryImpl#attachOperatorToDescriptor(org.eclipse.papyrus.layers.stackmodel.layers.Property, java.lang.String, java.lang.String)}.
	 * @throws NotFoundException 
	 */
	@Test
	public void testAttachOperatorToDescriptor() throws NotFoundException {
		// Create a registry
		int propertiesCollectionSize = 10;
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);

	    // Create a LayerOperatorDesc
		LayerOperatorDescriptor descriptor = LayersFactory.eINSTANCE.createLayerOperatorDescriptor();
		descriptor.setName("desc1");
		
		// Add it
		registry.addLayerOperatorDescriptor(descriptor);
		
	    // Create a PropertyOperator
		PropertyOperator operator1 = LayersFactory.eINSTANCE.createPropertyOperator();
		operator1.setName("op1");

		// Add it
		registry.addPropertyOperator(operator1);
		
		// Create a property
		Property prop1 = LayersFactory.eINSTANCE.createProperty();
		prop1.setName("prop1");
		prop1.setIndex(0);
		
		// Attach Property
		registry.attachOperatorToDescriptor(prop1, operator1.getName(), descriptor.getName());
		
		// Check if the operator is added to LayerOperator
		assertSame("operator found in layer", operator1, descriptor.getPropertyOperator(prop1));
	}

}
