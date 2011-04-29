/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.extendedtypes;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import junit.framework.Assert;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.papyrus.uml.service.types.element.UMLElementTypes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Tests for {@link ExtendedTypesRegistry}
 */
public class ExtendedTypesRegistryTests implements ITestConstants {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
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
	 * Test method for {@link org.eclipse.papyrus.extendedtypes.ExtendedTypesRegistry#getInstance()}.
	 */
	@Test
	public final void testGetInstance() {
		Assert.assertNotNull("The singleton instance should not be null", ExtendedTypesRegistry.getInstance());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.extendedtypes.ExtendedTypesRegistry#loadExtendedTypeSets()}.
	 */
	@Test
	public final void testLoadExtendedTypeSets() {
		List<ExtendedElementTypeSet> result = ExtendedTypesRegistry.getInstance().loadExtendedTypeSets();


		assertNotNull("The list of extended type sets should not be null after loading", result);
		assertTrue("The list of extended type sets should not be empty after loading", result.size() > 0);

		boolean found = false;
		for(ExtendedElementTypeSet set : result) {
			if(ExtendedTypeSetName_Test1.equals(set.getId())) {
				found = true;
			}
		}
		assertTrue("The list should contain Extended Type Set from Test1: " + ExtendedTypeSetName_Test1, found);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.extendedtypes.ExtendedTypesRegistry#createResourceSet()}.
	 */
	@Test
	public final void testCreateResourceSet() {
		ResourceSet set = ExtendedTypesRegistry.getInstance().createResourceSet();
		assertNotNull("Resource set should not be null", set);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.extendedtypes.ExtendedTypesRegistry#getExtendedElementTypeSet(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testGetExtendedElementTypeSet() {
		ExtendedElementTypeSet set = ExtendedTypesRegistry.getInstance().getExtendedElementTypeSet(TEST1_CONFIGURATION_SET_ID, TEST1_MODEL_PATH, Activator.PLUGIN_ID);
		assertNotNull("Element type model file set should be  found", set);

		ExtendedElementTypeSet set2 = ExtendedTypesRegistry.getInstance().getExtendedElementTypeSet("null", NO_FILE, Activator.PLUGIN_ID);
		assertNull("Element type model file set should not be found", set2);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.extendedtypes.ExtendedTypesRegistry#getType(java.lang.String)}.
	 */
	@Test
	public final void testGetType() {
		IElementType classType = ExtendedTypesRegistry.getInstance().getType(UMLElementTypes.CLASS.getId());
		assertNotNull("element Type for class should be found", classType);

		IElementType extendedClassType = ExtendedTypesRegistry.getInstance().getType(CLASS1_TEST_TYPE_ID);
		assertNotNull("element Type for class should be found", extendedClassType);

		IElementType noType = ExtendedTypesRegistry.getInstance().getType(NO_TYPE);
		assertNull("element Type for class should not be found", noType);
	}
}
