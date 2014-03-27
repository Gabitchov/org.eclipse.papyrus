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

import static org.junit.Assert.*;

import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.TypeRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class TypeRegistryImplTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.TypeRegistryImpl#TypeRegistryImpl()}.
	 */
	@Test
	public void testTypeRegistryImpl() {
		TypeRegistry registry = LayersFactory.eINSTANCE.createTypeRegistry();
		assertNotNull("registry created", registry);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.TypeRegistryImpl#init()}.
	 */
	@Test
	public void testInit() {
		TypeRegistry registry = LayersFactory.eINSTANCE.createTypeRegistry();
		assertNotNull("registry created", registry);
		
		// Try to get initialized types
		assertNotNull( "type found", registry.getTypes().get("boolean") );
		assertNotNull( "type found", registry.getTypes().get("int") );
		assertNotNull( "type found", registry.getTypes().get("String") );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.TypeRegistryImpl#getTypes()}.
	 */
	@Test
	public void testGetTypes() {
		TypeRegistry registry = LayersFactory.eINSTANCE.createTypeRegistry();
		assertNotNull("registry created", registry);
		
		assertNotNull("map created", registry.getTypes());
	}

}
