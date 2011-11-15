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
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gmf.runtime.common.core.service.IProvider;
import org.eclipse.gmf.runtime.common.core.service.Service;
import org.eclipse.gmf.runtime.diagram.ui.internal.services.palette.PaletteToolEntry;
import org.eclipse.gmf.runtime.gef.ui.internal.palette.PaletteStack;
import org.eclipse.papyrus.uml.diagram.common.service.PapyrusPaletteService;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.PaletteConfiguration;
import org.eclipse.papyrus.uml.diagram.paletteconfiguration.provider.ExtendedPluginPaletteProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Tests the usage of the extended palette provider in the {@link PapyrusPaletteService}
 */
public class EXtendedPluginPaletteProviderTests_PapyrusService implements ITestConstants {

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
	 * Test method for
	 * {@link org.eclipse.papyrus.common.providers.ExtendedPluginPaletteProvider#contributeToPalette(org.eclipse.ui.IEditorPart, java.lang.Object, org.eclipse.gef.palette.PaletteRoot, java.util.Map)}
	 * .
	 */
	@Test
	public final void testContributeToPalette() {
		List<? extends Service.ProviderDescriptor> descriptors = PapyrusPaletteService.getInstance().getProviders();

		ExtendedPluginPaletteProvider extendedProvider = null;
		// check the test descriptor is in the list
		for(Service.ProviderDescriptor descriptor : descriptors) {
			IProvider provider = descriptor.getProvider();
			if(provider instanceof ExtendedPluginPaletteProvider) {
				ExtendedPluginPaletteProvider extendedPluginPaletteProvider = (ExtendedPluginPaletteProvider)provider;
				List<PaletteConfiguration> contributions = extendedPluginPaletteProvider.getContributions();
				if(contributions != null && !contributions.isEmpty()) {
					String id = contributions.get(0).getId();
					if(PALETTE_TEST1_ID.equals(id)) {
						extendedProvider = extendedPluginPaletteProvider;
					}
				}
			}
		}

		assertNotNull("Provider for Test1 has not been found", extendedProvider);

		PaletteRoot root = new PaletteRoot();
		extendedProvider.contributeToPalette(null, null, root, new HashMap());

		//check root now
		List rootChildren = root.getChildren();
		assertNotNull("Root children should not be null", rootChildren);
		assertTrue("Root children should be size 1", rootChildren.size() == 1); // one drawer is contributed

		for(Object drawer : rootChildren) {
			assertTrue("Child of the root is not a drawer: " + drawer, drawer instanceof org.eclipse.gef.palette.PaletteDrawer);
			List toolsAndStack = ((org.eclipse.gef.palette.PaletteDrawer)drawer).getChildren();
			assertTrue("Drawer should have 3 children: 1 stack and 2 tools.", toolsAndStack.size() == 3);

			Object tool0 = toolsAndStack.get(0);
			assertTrue("first element should be a Tool", tool0 instanceof PaletteToolEntry);
			assertTrue("first element should have id palettetest1.tool0", ((PaletteToolEntry)tool0).getId().equals("palettetest1.tool0"));
			assertTrue("first element should have label MetaClass", ((PaletteToolEntry)tool0).getLabel().equals("MetaClass"));

			Object stack1 = toolsAndStack.get(1);
			assertTrue("2nd element should be a Stack", stack1 instanceof PaletteStack);
			assertTrue("2nd element should have id palettetest1.stack1", ((PaletteStack)stack1).getId().equals("palettetest1.stack1"));
			assertTrue("2nd element should have label Stack 1", ((PaletteStack)stack1).getLabel().equals("Stack 1"));

			List stackChildren = ((PaletteStack)stack1).getChildren();
			assertTrue("Stack should have 2 children: 2 tools. but has " + stackChildren.size() + " child(ren).", stackChildren.size() == 3);
			Object stackChild = stackChildren.get(0);
			assertTrue("stack should be a tool", stackChild instanceof PaletteToolEntry);
			assertTrue("tool should have id palettetest1.operation but is " + ((PaletteToolEntry)stackChild).getId(), ((PaletteToolEntry)stackChild).getId().equals("palettetest1.operation"));
			assertTrue("first element should have label \"Operation\" but is " + ((PaletteToolEntry)stackChild).getLabel(), ((PaletteToolEntry)stackChild).getLabel().equals("Operation"));

			stackChild = stackChildren.get(1);
			assertTrue("stack should be a tool", stackChild instanceof PaletteToolEntry);
			assertTrue("tool should have id palettetest1.property but is " + ((PaletteToolEntry)stackChild).getId(), ((PaletteToolEntry)stackChild).getId().equals("palettetest1.property"));
			assertTrue("first element should have label \"Property\" but is " + ((PaletteToolEntry)stackChild).getLabel(), ((PaletteToolEntry)stackChild).getLabel().equals("Property"));


			Object tool3 = toolsAndStack.get(2);
			assertTrue("3rd element should be a Tool", tool3 instanceof PaletteToolEntry);
			assertTrue("3rd element should have id palettetest1.tool3", ((PaletteToolEntry)tool3).getId().equals("palettetest1.tool3"));
			assertTrue("3rd element should have label \"Dependency\", but is " + ((PaletteToolEntry)tool3).getLabel(), ((PaletteToolEntry)tool3).getLabel().equals("Dependency"));

		}
	}

}
