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

import org.eclipse.papyrus.layers.stackmodel.layers.IntInstance;
import org.eclipse.papyrus.layers.stackmodel.layers.IntType;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeInstance;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class IntTypeImplTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.IntTypeImpl#createInstance()}.
	 */
	@Test
	public void testCreateInstance() {
		IntType type = LayersFactory.eINSTANCE.createIntType();

		TypeInstance instance = type.createInstance();
		assertNotNull("instance created", instance);
		assertTrue("Right instance", instance instanceof IntInstance);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.IntTypeImpl#IntTypeImpl()}.
	 */
	@Test
	public void testIntTypeImpl() {
		IntType type = LayersFactory.eINSTANCE.createIntType();

		assertNotNull("object created", type);
		
		assertEquals("name initialized", "int", type.getName());
	}

}
