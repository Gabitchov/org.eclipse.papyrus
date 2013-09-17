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
package org.eclipse.papyrus.layers.runtime.model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class LayersModelTest {

	/**
	 * URI used to store the created model.
	 */
	protected static final String PROJECT_MODEL_URI = "org.eclipse.papyrus.infra.core/tmp/model1.di";

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
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.model.LayersModel#LayersModel()}.
	 * @throws CoreException 
	 * @throws IOException 
	 */
	@Test
	public void testLayersModel() throws CoreException, IOException {
		// Create ModelSet and Model
		ModelSet mngr = new ModelSet();
		LayersModel layersModel = new LayersModel();
		mngr.registerModel(layersModel);
		// Do create resources
		URI uri = URI.createPlatformResourceURI(PROJECT_MODEL_URI, true);
		mngr.createModels(uri);
		
		// Check if root exist
		assertNotNull("layer model root created", layersModel.getLayerStackApplication());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.model.LayersModel#lookupLayerStackApplication()}.
	 */
	@Test
	public void testLookupLayerStackApplication() {
		// Create ModelSet and Model
		ModelSet mngr = new ModelSet();
		LayersModel layersModel = new LayersModel();
		mngr.registerModel(layersModel);
		// Do create resources
		URI uri = URI.createPlatformResourceURI(PROJECT_MODEL_URI, true);
		mngr.createModels(uri);
		
		// Check if application lookup
		assertNull("lookup application return null", layersModel.lookupLayerStackApplication());
		
		// Get the application, this create it
		assertNotNull("layer model root created", layersModel.getLayerStackApplication());
		// lookup again, this found the application
		assertNotNull("layer model root created", layersModel.lookupLayerStackApplication());
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.runtime.model.LayersModel#getLayerStackApplication()}.
	 */
	@Test
	public void testGetLayerStackApplication() {
		// Create ModelSet and Model
		ModelSet mngr = new ModelSet();
		LayersModel layersModel = new LayersModel();
		mngr.registerModel(layersModel);
		// Do create resources
		URI uri = URI.createPlatformResourceURI(PROJECT_MODEL_URI, true);
		mngr.createModels(uri);
		
		// Check if root exist
		assertNotNull("layer model root created", layersModel.getLayerStackApplication());
		assertTrue("LayerStackApplication is found", layersModel.getLayerStackApplication() instanceof  LayersStackApplication);
	}

}
