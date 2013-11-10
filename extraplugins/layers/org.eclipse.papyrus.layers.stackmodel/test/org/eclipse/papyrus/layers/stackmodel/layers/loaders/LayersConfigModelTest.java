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
package org.eclipse.papyrus.layers.stackmodel.layers.loaders;

import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createFolder;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createLayerOperatorConfig;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.layers.configmodel.layersconfig.Folder;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class LayersConfigModelTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModel#LayersConfigModel()}.
	 */
	@Test
	public void testLayersConfigModel() {
		// Create object		
		LayersConfigModel model = new LayersConfigModel();
		
		assertNotNull("object created", model);
		// Check if resource and root folder are created
		assertNotNull("resource created", model.getResource());
		assertNotNull("root folder created", model.getRootFolder());
		
	}

	/**
	 * Check if we can initialize an instance externally.
	 */
	@Test
	public void testExternalInitialization() {
		// Create object		
		LayersConfigModel model = new LayersConfigModel();
		
		initLayersConfigModel(model);
		
		// Do checking
		assertTrue("Some def are set in root", model.getRootFolder().getFolderElements().size()>0);
	}

	/**
	 * Initialize the provided model with some defs for tests.
	 * 
	 * @param model
	 */
	private void initLayersConfigModel(LayersConfigModel model) {
		// Create model
		Folder layeropFolder = createFolder(model.getRootFolder(), "layerOpDesc");
		
		createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorA", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorB", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorC", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorD", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
	}

	/**
	 * Check if internal initialization work.
	 */
	@Test
	public void testInternalInitialization() {
		// Create object		
		LayersConfigModel model = LayersConfigModel.getInstance();
		
		assertNotNull("object created", model);
		assertTrue("Some def are set in root", model.getRootFolder().getFolderElements().size()>0);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModel#getResource()}.
	 */
	@Test
	public void testGetResource() {
		// Create object		
		LayersConfigModel model = new LayersConfigModel();
		
		assertNotNull("resource created", model.getResource());
		
		assertTrue("resource populated", model.getResource().getContents().size()>0);
	}

}
