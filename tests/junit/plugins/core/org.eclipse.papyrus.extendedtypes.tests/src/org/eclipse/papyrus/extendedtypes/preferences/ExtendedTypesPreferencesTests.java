/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.extendedtypes.preferences;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.ui.IMemento;
import org.eclipse.ui.XMLMemento;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Test class for {@link ExtendedTypesPreferences}
 */
public class ExtendedTypesPreferencesTests extends ExtendedTypesPreferences {

	/** id of the extended type set for tests */
	private final static String EXTENDED_TYPES_TEST_ID = "testExtendedTypes";

	/**
	 * @throws java.lang.Exception
	 *         exception thrown in case of issues
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 *         exception thrown in case of issues
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 *         exception thrown in case of issues
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 *         exception thrown in case of issues
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test for local definitions of Palette in preferences
	 */
	@Test
	public final void testLocalRedefinitions() {
		// 1. saves the root memento 
		XMLMemento rootMemento = getLocalRedefinitions();
		IMemento[] extendedTypesRedefinitions = rootMemento.getChildren(EXTENDED_TYPES_REDEFINITION);

		int initialLength = extendedTypesRedefinitions.length;

		// 2. test add
		// be sure not already existing
		String path = getExtendedTypesRedefinition(EXTENDED_TYPES_TEST_ID);
		assertNull("There should be no test extendedTypes yet", path);

		registerLocalRedefinition(EXTENDED_TYPES_TEST_ID, "testAdd.xml");

		int newLength = initialLength + 1;
		XMLMemento newMemento = getLocalRedefinitions();
		IMemento[] newPaletteRedefinitions = newMemento.getChildren(EXTENDED_TYPES_REDEFINITION);
		assertTrue("There should be " + newLength + " elements, currently " + newPaletteRedefinitions.length, newLength == newPaletteRedefinitions.length);
		String newPath = getExtendedTypesRedefinition(EXTENDED_TYPES_TEST_ID);
		assertEquals("There should be a new path for the extendedTypes id", "testAdd.xml", newPath);

		// 3. test remove
		unregisterLocalRedefinition(EXTENDED_TYPES_TEST_ID);
		newMemento = getLocalRedefinitions();
		newPaletteRedefinitions = newMemento.getChildren(EXTENDED_TYPES_REDEFINITION);
		assertTrue("There should be " + newLength + " elements", newPaletteRedefinitions.length == initialLength);
		newPath = getExtendedTypesRedefinition(EXTENDED_TYPES_TEST_ID);
		assertNull("There should be no path for the extendedTypes id", newPath);

	}
}
