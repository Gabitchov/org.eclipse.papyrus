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

package org.eclipse.papyrus.layers.stackmodel.layers.impl;

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
 * Test initilaization of Layers when inserted in a tree of layers.
 * Use the LayerStack as container.
 * 
 * @author cedric dumoulin
 *
 */
public class LayerExpressionInitWithApplicationImplTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#LayerExpressionImpl()}.
	 */
	@Test
	public void testLayerExpressionImpl() {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
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
	    stack.setLayers(top);
	    TopLayerOperator container1 = (TopLayerOperator)factory.getLayer("top");
		Layer layer1 = (Layer)factory.getLayer("layer1");
		Layer layer2 = (Layer)factory.getLayer("layer1");
		Layer layer3 = (Layer)factory.getLayer("layer1");
		
		
		// Assert
		assertNotNull("object created", top);
		assertEquals("application initialized", application, top.getApplication() );
		
		assertNotNull("object created", container1);
		assertEquals("application initialized", application, container1.getApplication() );

		assertNotNull("object created", layer1);
		assertEquals("application initialized", application, layer1.getApplication() );

		assertNotNull("object created", layer2);
		assertEquals("application initialized", application, layer2.getApplication() );

		assertNotNull("object created", layer3);
		assertEquals("application initialized", application, layer3.getApplication() );
	}

	/**
	 * Test if properties are set after adding a subtree
	 */
	@Test
	public void testAddSubTreeImpl() {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
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
		     
		factory.newTopLayer("container2", 
				factory.newLayer("layer21"),
				factory.newLayer("layer22")
				);
		     
		TopLayerOperator top = (TopLayerOperator)factory.getLayer("top");
		stack.setLayers(top);
	    TopLayerOperator container2 = (TopLayerOperator)factory.getLayer("container2");
		Layer layer21 = (Layer)factory.getLayer("layer21");
		Layer layer22 = (Layer)factory.getLayer("layer22");
		
		// action
		// Add subtree
		top.getLayers().add(container2);
		
		// Assert
		assertNotNull("object created", top);
		assertEquals("application initialized", application, top.getApplication() );
		
		assertNotNull("object created", container2);
		assertEquals("application initialized", application, container2.getApplication() );
		assertEquals("container (stack) initialized", stack, container2.getOwningLayersStack() );

		assertNotNull("object created", layer21);
		assertEquals("application initialized", application, layer21.getApplication() );
		assertEquals("container (stack) initialized", stack, layer21.getOwningLayersStack() );

		assertNotNull("object created", layer22);
		assertEquals("application initialized", application, layer22.getApplication() );
		assertEquals("container (stack) initialized", stack, layer22.getOwningLayersStack() );

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#isLayerEnabled()}.
	 */
	@Test
	public void testIsLayerEnabled() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#isBranchEnabled()}.
	 */
	@Test
	public void testIsBranchEnabled() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayerExpressionImpl#getOwningLayersStack()}.
	 */
	@Test
	public void testGetOwningLayersStack() {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
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
	    stack.setLayers(top);
	    TopLayerOperator container1 = (TopLayerOperator)factory.getLayer("top");
		Layer layer1 = (Layer)factory.getLayer("layer1");
		Layer layer2 = (Layer)factory.getLayer("layer1");
		Layer layer3 = (Layer)factory.getLayer("layer1");
		
		
		// Assert
		assertNotNull("object created", top);
		assertEquals("container (stack) initialized", stack, top.getOwningLayersStack() );
		
		assertNotNull("object created", container1);
		assertEquals("container (stack) initialized", stack, container1.getOwningLayersStack() );

		assertNotNull("object created", layer1);
		assertEquals("container (stack) initialized", stack, layer1.getOwningLayersStack() );

		assertNotNull("object created", layer2);
		assertEquals("container (stack) initialized", stack, layer2.getOwningLayersStack() );

		assertNotNull("object created", layer3);
		assertEquals("container (stack) initialized", stack, layer3.getOwningLayersStack() );
	}

}
