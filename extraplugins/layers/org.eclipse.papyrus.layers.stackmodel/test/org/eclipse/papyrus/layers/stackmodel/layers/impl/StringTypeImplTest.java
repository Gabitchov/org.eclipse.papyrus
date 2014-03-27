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
import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.StringInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.StringType;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class StringTypeImplTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.StringTypeImpl#createInstance()}.
	 */
	@Test
	public void testCreateInstance() {
		StringType type = LayersFactory.eINSTANCE.createStringType();

		TypeInstance instance = type.createInstance();
		assertNotNull("instance created", instance);
		assertTrue("Right instance", instance instanceof StringInstance);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.StringTypeImpl#StringTypeImpl()}.
	 */
	@Test
	public void testStringTypeImpl() {
		StringType type = LayersFactory.eINSTANCE.createStringType();

		assertNotNull("object created", type);
		
		assertEquals("name initialized", "String", type.getName());
	}

}
