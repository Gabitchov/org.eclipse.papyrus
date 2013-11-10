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
package org.eclipse.papyrus.layers.configmodel.layersconfig.impl;

import static org.junit.Assert.*;

import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigFactory;
import org.eclipse.papyrus.layers.stackmodel.InstanciationException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class LayerOperatorConfigImplTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayerOperatorConfigImpl#LayerOperatorConfigImpl()}.
	 */
	@Test
	public void testLayerOperatorConfigImpl() {
		
		// Create object
		LayerOperatorConfig config = LayersconfigFactory.eINSTANCE.createLayerOperatorConfig();
		config.setClassname(LayersPackage.eINSTANCE.getLayerOperatorDescriptor().getName());
		

		assertNotNull("object created", config);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.configmodel.layersconfig.impl.LayerOperatorConfigImpl#createLayersOperatorDescriptor()}.
	 * @throws InstanciationException 
	 */
	@Test
	public void testCreateLayersOperatorDescriptor() throws InstanciationException {
		// Create object
		LayerOperatorConfig config = LayersconfigFactory.eINSTANCE.createLayerOperatorConfig();
		config.setClassname(LayersPackage.eINSTANCE.getLayerOperatorDescriptor().getName());

		// check creation 
		LayerOperatorDescriptor desc =config.createLayersOperatorDescriptor();
		assertNotNull("desc created", desc);
	}

}
