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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.gef.ui.internal.palette.PaletteDrawer;
import org.eclipse.gmf.runtime.gef.ui.internal.palette.PaletteStack;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.provider.ExtendedPluginPaletteProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Test Class for {@link ExtendedPluginPaletteProvider#retrieveExistingEntry} method
 */
public class ExtendedPluginPaletteProviderTests_RetrievePredefinedEntry extends ExtendedPluginPaletteProvider {

	/** id of drawer n°1 */
	protected static final String DRAWER1_ID = "drawer1"; //$NON-NLS-1$

	/** id of drawer n°2 */
	protected static final String DRAWER2_ID = "drawer2"; //$NON-NLS-1$

	/** id of drawer not existing */
	protected static final String DRAWER_NO_ID = "drawerNot"; //$NON-NLS-1$

	/** id of stack n°1 */
	protected static final String STACK1_ID = "stack1"; //$NON-NLS-1$

	/** id of stack not existing */
	protected static final String STACK_NO_ID = "stackNot"; //$NON-NLS-1$

	/** id of tool n°1 */
	protected static final String TOOL1_ID = "tool1"; //$NON-NLS-1$

	/** id of tool not existing */
	protected static final String TOOL_NO_ID = "toolNot"; //$NON-NLS-1$

	/** id of object n°1 */
	protected static final String OBJECT1_ID = "object1"; //$NON-NLS-1$

	/** map used for the tests */
	private static Map predefinedEntries;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		predefinedEntries = new HashMap();
		addDrawer(DRAWER1_ID);
		addDrawer(DRAWER2_ID);
		addTool(TOOL1_ID);
		addStack(STACK1_ID);
		addObject(OBJECT1_ID);
	}

	/**
	 * Adds an undefined object to the predefined entries
	 * 
	 * @param id
	 *        id of the object
	 */
	private static void addObject(String id) {
		predefinedEntries.put(id, new Object());
	}

	/**
	 * adds a stack to the predefined entries
	 * 
	 * @param id
	 *        id of the stack
	 */
	private static void addStack(String id) {
		PaletteStack stack = new PaletteStack(id, id, id, null);
		predefinedEntries.put(id, stack);
	}

	/**
	 * adds a tool to the predefined entries
	 * 
	 * @param id
	 *        id of the tool
	 */
	private static void addTool(String id) {
		PaletteToolEntry entry = new PaletteToolEntry(id, id, null);
		predefinedEntries.put(id, entry);
	}

	/**
	 * adds a drawer to the predefined entries
	 * 
	 * @param id
	 *        id of the drawer
	 */
	private static void addDrawer(String id) {
		PaletteDrawer drawer = new PaletteDrawer(id, id);
		predefinedEntries.put(id, drawer);
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
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#retrieveExistingEntry(java.util.Map, java.lang.String, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testRetrieveExistingEntry_retrieveExistingDrawer() {
		Object value = retrieveExistingEntry(predefinedEntries, DRAWER1_ID, PaletteDrawer.class);

		assertNotNull(DRAWER1_ID + "should be found", value);
		assertTrue(DRAWER1_ID + "should be a GMF PaletteDrawer, but is :" + value.getClass().getName(), value instanceof PaletteDrawer);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#retrieveExistingEntry(java.util.Map, java.lang.String, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testRetrieveExistingEntry_retrieveNotExistingDrawer() {
		Object value = retrieveExistingEntry(predefinedEntries, DRAWER_NO_ID, PaletteDrawer.class);

		assertNull("No drawer should be found, but found: " + value, value);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#retrieveExistingEntry(java.util.Map, java.lang.String, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testRetrieveExistingEntry_retrieveExistingStack() {
		Object value = retrieveExistingEntry(predefinedEntries, STACK1_ID, PaletteStack.class);

		assertNotNull(STACK1_ID + "should be found", value);
		assertTrue(STACK1_ID + "should be a GMF PaletteStack, but is :" + value.getClass().getName(), value instanceof PaletteStack);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#retrieveExistingEntry(java.util.Map, java.lang.String, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testRetrieveExistingEntry_retrieveNonExistingStack() {
		Object value = retrieveExistingEntry(predefinedEntries, STACK_NO_ID, PaletteStack.class);

		assertNull("No stack should be found, but found: " + value, value);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#retrieveExistingEntry(java.util.Map, java.lang.String, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testRetrieveExistingEntry_retrieveExistingTool() {
		Object value = retrieveExistingEntry(predefinedEntries, TOOL1_ID, PaletteToolEntry.class);

		assertNotNull(TOOL1_ID + "should be found", value);
		assertTrue(TOOL1_ID + "should be a GMF PaletteToolEntry, but is :" + value.getClass().getName(), value instanceof PaletteToolEntry);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#retrieveExistingEntry(java.util.Map, java.lang.String, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testRetrieveExistingEntry_retrieveNonExistingTool() {
		Object value = retrieveExistingEntry(predefinedEntries, TOOL_NO_ID, PaletteToolEntry.class);

		assertNull("No toolentry should be found, but found: " + value, value);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#retrieveExistingEntry(java.util.Map, java.lang.String, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testRetrieveExistingEntry_retrieveWrongTypedElement_DrawerClass() {
		Object value = retrieveExistingEntry(predefinedEntries, TOOL1_ID, PaletteDrawer.class);
		assertNull("value should be null, as not from correct type: " + value, value);

		value = retrieveExistingEntry(predefinedEntries, STACK1_ID, PaletteDrawer.class);
		assertNull("value should be null, as not from correct type: " + value, value);

		value = retrieveExistingEntry(predefinedEntries, OBJECT1_ID, PaletteDrawer.class);
		assertNull("value should be null, as not from correct type: " + value, value);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#retrieveExistingEntry(java.util.Map, java.lang.String, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testRetrieveExistingEntry_retrieveWrongTypedElement_StackClass() {
		Object value = retrieveExistingEntry(predefinedEntries, TOOL1_ID, PaletteStack.class);
		assertNull("value should be null, as not from correct type: " + value, value);

		value = retrieveExistingEntry(predefinedEntries, DRAWER1_ID, PaletteStack.class);
		assertNull("value should be null, as not from correct type: " + value, value);

		value = retrieveExistingEntry(predefinedEntries, OBJECT1_ID, PaletteStack.class);
		assertNull("value should be null, as not from correct type: " + value, value);
	}

	/**
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#retrieveExistingEntry(java.util.Map, java.lang.String, java.lang.Class)}
	 * .
	 */
	@Test
	public final void testRetrieveExistingEntry_retrieveWrongTypedElement_ToolClass() {
		Object value = retrieveExistingEntry(predefinedEntries, DRAWER1_ID, PaletteToolEntry.class);
		assertNull("value should be null, as not from correct type: " + value, value);

		value = retrieveExistingEntry(predefinedEntries, STACK1_ID, PaletteToolEntry.class);
		assertNull("value should be null, as not from correct type: " + value, value);

		value = retrieveExistingEntry(predefinedEntries, OBJECT1_ID, PaletteToolEntry.class);
		assertNull("value should be null, as not from correct type: " + value, value);
	}
}
