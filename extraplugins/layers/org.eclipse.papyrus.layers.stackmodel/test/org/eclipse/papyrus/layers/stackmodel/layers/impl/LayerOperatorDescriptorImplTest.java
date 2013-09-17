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
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class LayerOperatorDescriptorImplTest {

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
	 * Create an operator
	 * @param string
	 * @return
	 */
	protected PropertyOperator createOperator(String name) {
		PropertyOperator propertyOperator = LayersFactory.eINSTANCE.createPropertyOperator();
		propertyOperator.setName(name);
		
		return propertyOperator;
	}

	/**
	 * Create a Property
	 * @param string
	 * @param i
	 * @return
	 */
	protected Property createProperty(String name, int index) {

		Property property = LayersFactory.eINSTANCE.createProperty();
		property.setName(name);
		property.setIndex(index);
		
		return property;
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorImpl#getPropertyOperator(org.eclipse.papyrus.layers.stackmodel.layers.Property)}.
	 * @throws NotFoundException 
	 */
	@Test
	public void testGetPropertyOperator() throws NotFoundException {
		// Create and init descriptor
		int expectedSize = 5;
		DefaultPropertyOperator defaultPropertyOperator = LayersFactory.eINSTANCE.createDefaultPropertyOperator();
		LayerOperatorDescriptor descriptor = LayersFactory.eINSTANCE.createLayerOperatorDescriptor();
		descriptor.setPropertyCollectionSize(expectedSize, defaultPropertyOperator);

		// Create a Properties
		int i = 0;
		Property property1 = createProperty( "prop" + i, i++);
		Property property2 = createProperty( "prop" + i, i++);
		Property property4 = createProperty( "prop4" , 4);
		
		// Create Operators
		i=0;
		PropertyOperator operator1 = createOperator( "oper" + i++ );
		PropertyOperator operator2 = createOperator( "oper" + i++ );
		PropertyOperator operator4 = createOperator( "oper4"  );
		
		// Try to add
		descriptor.setPropertyOperator(property1, operator1);
		descriptor.setPropertyOperator(property2, operator2);
		descriptor.setPropertyOperator(property4, operator4);
		
		// Do test
		assertSame("operators size has not changed", expectedSize, descriptor.getPropertyOperators().size());
		assertSame("operator can be found", operator1, descriptor.getPropertyOperator(property1));
		assertSame("operator can be found", operator2, descriptor.getPropertyOperator(property2));
		assertSame("operator can be found", operator4, descriptor.getPropertyOperator(property4));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorImpl#setPropertyOperator(org.eclipse.papyrus.layers.stackmodel.layers.Property, org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator)}.
	 * @throws NotFoundException 
	 */
	@Test
	public void testSetPropertyOperator() throws NotFoundException {
		// Create and init descriptor
		int expectedSize = 5;
		DefaultPropertyOperator defaultPropertyOperator = LayersFactory.eINSTANCE.createDefaultPropertyOperator();
		LayerOperatorDescriptor descriptor = LayersFactory.eINSTANCE.createLayerOperatorDescriptor();
		descriptor.setPropertyCollectionSize(expectedSize, defaultPropertyOperator);

		// Create a Properties
		int i = 0;
		Property property1 = createProperty( "prop" + i, i++);
		Property property2 = createProperty( "prop" + i, i++);
		Property property4 = createProperty( "prop4" , 4);
		
		// Create Operators
		i=0;
		PropertyOperator operator1 = createOperator( "oper" + i++ );
		PropertyOperator operator2 = createOperator( "oper" + i++ );
		PropertyOperator operator4 = createOperator( "oper4"  );
		
		// Try to add
		descriptor.setPropertyOperator(property1, operator1);
		descriptor.setPropertyOperator(property2, operator2);
		descriptor.setPropertyOperator(property4, operator4);
		
		// Do test
		assertSame("operators size has not changed", expectedSize, descriptor.getPropertyOperators().size());
		assertSame("operator can be found", operator1, descriptor.getPropertyOperator(property1));
		assertSame("operator can be found", operator2, descriptor.getPropertyOperator(property2));
		assertSame("operator can be found", operator4, descriptor.getPropertyOperator(property4));

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorImpl#createLayerOperator()}.
	 */
	@Test
	public void testCreateLayerOperator() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerOperatorDescriptorImpl#setPropertyCollectionSize(int, org.eclipse.papyrus.layers.stackmodel.layers.DefaultPropertyOperator)}.
	 */
	@Test
	public void testSetPropertyCollectionSize() {


		// Create and init descriptor
		int expectedSize = 5;
		DefaultPropertyOperator defaultPropertyOperator = LayersFactory.eINSTANCE.createDefaultPropertyOperator();
		LayerOperatorDescriptor descriptor = LayersFactory.eINSTANCE.createLayerOperatorDescriptor();
		descriptor.setPropertyCollectionSize(expectedSize, defaultPropertyOperator);

		// Check operators init
		assertSame("list has the expected size", expectedSize, descriptor.getPropertyOperators().size());
		
		assertSame("list is initialized", defaultPropertyOperator, descriptor.getPropertyOperators().get(0));
	}

}
