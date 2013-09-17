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
import org.eclipse.papyrus.layers.stackmodel.layers.PropertySetterRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * 
 * Test the class without application object.
 * The map should work.
 * 
 * @author cedric dumoulin
 *
 */
public class PropertySetterRegistryImplTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterRegistryImpl#PropertySetterRegistryImpl()}.
	 */
	@Test
	public void testPropertySetterRegistryImpl() {
		PropertySetterRegistry registry = LayersFactory.eINSTANCE.createPropertySetterRegistry();
		assertNotNull("registry created", registry);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterRegistryImpl#getPropertySetters()}.
	 */
	@Test
	public void testGetPropertySetters() {
		PropertySetterRegistry registry = LayersFactory.eINSTANCE.createPropertySetterRegistry();
		assertNotNull("property setters can be retrieved", registry.getPropertySetters());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterRegistryImpl#getSetterMap()}.
	 */
	@Test
	public void testGetSetterMap() {
		PropertySetterRegistry registry = LayersFactory.eINSTANCE.createPropertySetterRegistry();
		assertNotNull("map can be retrieved", registry.getSetterMap());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterRegistryImpl#getApplication()}.
	 */
	@Test
	public void testGetApplication() {
		PropertySetterRegistry registry = LayersFactory.eINSTANCE.createPropertySetterRegistry();
		assertNull("application is not set", registry.getApplication());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterRegistryImpl#setApplication(org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 */
	@Test
	@Ignore
	public void testSetApplication() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterRegistryImpl#getPropertySetter(org.eclipse.papyrus.layers.stackmodel.layers.Property)}.
	 */
	@Test
	@Ignore
	public void testGetPropertySetterProperty() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterRegistryImpl#getPropertySetter(java.lang.String)}.
	 * @throws NotFoundException 
	 */
	@Test
	public void testGetPropertySetterString() throws NotFoundException {
		PropertySetterRegistry registry = LayersFactory.eINSTANCE.createPropertySetterRegistry();

	
		assertNotNull("Default property can be retrieved", registry.getPropertySetter("isValid"));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.PropertySetterRegistryImpl#addPropertySetter(org.eclipse.papyrus.layers.stackmodel.layers.PropertySetter)}.
	 * @throws NotFoundException 
	 */
	@Test
	public void testAddPropertySetter() throws NotFoundException {
		PropertySetterRegistry registry = LayersFactory.eINSTANCE.createPropertySetterRegistry();

		PropertySetterImpl setter = new PropertySetterImpl() {
			public String getPropertyName() {return "myProperty";};
		};
		
		// add the setter
		registry.addPropertySetter(setter);
		// Try to get it in the map
		assertNotNull("property can be retrieved from map", registry.getSetterMap().get("myProperty") );
		assertNotNull("property can be retrieved from dedicated method", registry.getPropertySetter("myProperty"));

	}

}
