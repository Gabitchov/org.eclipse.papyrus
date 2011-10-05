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
package org.eclipse.papyrus.paletteconfiguration.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

import org.eclipse.core.runtime.Platform;
import org.eclipse.papyrus.paletteconfiguration.PaletteConfiguration;
import org.eclipse.papyrus.paletteconfiguration.provider.ExtendedPluginPaletteProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Tests cases for the operation load palette configuration
 */
public class ExtendedPluginPaletteProviderTests_LoadPaletteConfiguration extends ExtendedPluginPaletteProvider implements ITestConstants {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	 * Test method for {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#loadConfigurationModel(java.lang.String, java.lang.String)}.
	 */
	@Test
	public final void testLoadConfigurationModel_Test1InPlugin() {
		Collection<PaletteConfiguration> result = null;
		try {
			result = loadConfigurationModel(Platform.getBundle(BUNDLE_ID), "model/Test1.paletteconfiguration");
		} catch (FileNotFoundException e) {
			fail("Exception: " + e.getMessage());
		} catch (IOException e) {
			fail("I/O Exception: " + e.getMessage());
		}
		assertNotNull("Collection should not be null", result);
		assertTrue("Collection should return one, and only one element, not :" + result.size(), result.size() == 1);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#loadConfigurationModel(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testLoadConfigurationModel_Test1InFragmentItself() {
		Collection<PaletteConfiguration> result = null;
		try {
			result = loadConfigurationModel(Platform.getBundle(FRAGMENT_ID), "model/Test1.paletteconfiguration");
		} catch (FileNotFoundException e) {
			fail("Exception: " + e.getMessage());
		} catch (IOException e) {
			fail("I/O Exception: " + e.getMessage());
		}
		assertNotNull("Collection should not be null", result);
		assertTrue("Collection should return one, and only one element, not :" + result.size(), result.size() == 1);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#loadConfigurationModel(java.lang.String, java.lang.String)}
	 * .
	 */
	@Test
	public final void testLoadConfigurationModel_NotExistingFile() {
		Collection<PaletteConfiguration> result = null;
		try {
			result = loadConfigurationModel(Platform.getBundle(FRAGMENT_ID), "model/NoConfiguration.paletteconfiguration");
		} catch (FileNotFoundException e) {
			// this should come here
		} catch (IOException e) {
			fail("I/O Exception: " + e.getMessage());
		}
		assertNull("Collection should be null", result);
	}

}
