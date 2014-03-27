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
package org.eclipse.papyrus.layers.stackmodel;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.ecore.EObject;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;


/**
 * 
 * @author dumoulin
 *
 * 
 */
public class PropertyValueFactoryTest {

	private static final String PROPERTY_NAME = "name";
	public static final String LOCAL_NSURI = "org.eclipse.papyrus.layers.0.10";
	public static final String EXT_NSURI = "org.eclipse.papyrus.extpropertymodel.0.10";
	public static final String CLASS_LAYER = "Layer";
	public static final String CLASS_EXTPROPERTY = "StringAndIntPropertyValue";
	
	
	/**
	 * Initialize EMF registry for standalone tests.
	 * Do not do it for plugin tests
	 * 
	 */
	@BeforeClass
	static public void setRegistry() {
	
		
	}
	
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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.PropertyValueFactory#newInstance(java.lang.String, java.lang.String)}.
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Ignore
	public void testLocalNewInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		PropertyValueFactory factory = new PropertyValueFactory();
		Object instance = factory.newInstance("org.eclipse.papyrus.layers.stackmodel", "org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackImpl");

	
		assertNotNull("instance created", instance);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.PropertyValueFactory#loadClass(java.lang.String, java.lang.String)}.
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testLoadLocalClass() throws ClassNotFoundException {

		// Try to load a local class
		PropertyValueFactory factory = new PropertyValueFactory();
		Class<?> type = factory.loadClass("org.eclipse.papyrus.layers.stackmodel", "org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersStackImpl");

	
		assertNotNull("class loaded", type);
	}

	/**
	 * Test method 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	public void testLocalnewEClassInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		PropertyValueFactory factory = new PropertyValueFactory();
		Object instance = factory.newEClassInstance(LOCAL_NSURI, CLASS_LAYER);

	
		assertNotNull("instance created", instance);
	}

	/**
	 * Test method 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Ignore
	public void testDistnewEClassInstance() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		PropertyValueFactory factory = new PropertyValueFactory();
		Object instance = factory.newEClassInstance(EXT_NSURI, CLASS_EXTPROPERTY);

	
		assertNotNull("instance created", instance);
	}

	/**
	 * Test method 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	@Test
	@Ignore
	public void testSetValue() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		PropertyValueFactory factory = new PropertyValueFactory();
		EObject instance = factory.newEClassInstance(EXT_NSURI, CLASS_EXTPROPERTY);

		String value = "John Doe";
		factory.setEObjectPropertyValue(instance, PROPERTY_NAME, value);
		
		// Try to get the value
		Object res = factory.getEObjectPropertyValue(instance, PROPERTY_NAME);

		assertNotNull("value found", res);
		assertEquals("value found", value, res);
	}


}
