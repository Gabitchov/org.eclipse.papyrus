/*****************************************************************************
 * Copyright (c) 2013 Cedric Dumoulin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.layers.stackmodel.layers.util;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.util.LayersFactoryTestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test utility to create tree of layers..
 * 
 * @author cedric dumoulin
 *
 */
public class LayerFactoryTestUtilsTest {

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
	 * Test creation of a tree of layers.
	 */
	@Test
	public void testCreateTreeImpl() {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();

		// Create stack
		LayersStack stack = application.getLayersStackFor(diagram);
		
		// Create layers
		LayersFactoryTestUtils factory = new LayersFactoryTestUtils(application);
		factory.newTopLayer("top", 
				factory.newLayer("layer1"),
				factory.newLayer("layer2"),
				factory.newTopLayer("container1", 
				  factory.newLayer("layer3") )
				);
		     
	    TopLayerOperator top = (TopLayerOperator)factory.getLayer("top");
	    TopLayerOperator container1 = (TopLayerOperator)factory.getLayer("top");
		Layer layer1 = (Layer)factory.getLayer("layer1");
		Layer layer2 = (Layer)factory.getLayer("layer1");
		Layer layer3 = (Layer)factory.getLayer("layer1");
		
		
		// Assert
		assertNotNull("object created", top);
		
		assertNotNull("object created", container1);

		assertNotNull("object created", layer1);

		assertNotNull("object created", layer2);

		assertNotNull("object created", layer3);
	}

}
