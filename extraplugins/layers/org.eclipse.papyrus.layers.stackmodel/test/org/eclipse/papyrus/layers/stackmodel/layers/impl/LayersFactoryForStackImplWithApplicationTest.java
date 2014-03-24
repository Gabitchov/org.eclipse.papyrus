/*****************************************************************************
 * Copyright (c) 2014 Cedric Dumoulin.
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

import static org.junit.Assert.*;

import java.util.List;

import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerState;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactoryForStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStack;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.RegExpLayer;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.util.LayersFactoryTestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class LayersFactoryForStackImplWithApplicationTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#LayersFactoryForStackImpl()}.
	 * @throws LayersException 
	 */
	@Test
	public void testCreateLayersFactoryForStackImpl() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Create stack
		LayersStack owningStack = application.getLayersStackFor(diagram);
		
		LayersFactoryForStack factory = LayersFactoryForStack.eINSTANCE;
		assertNotNull("factory created", factory);
		
		// Create tree
		TopLayerOperator rootLayer = factory.createTopLayerOperator(owningStack, owningStack, application);
		Layer layer1 = factory.createLayer(rootLayer, owningStack, application);
		Layer layer2 = factory.createLayer(rootLayer, owningStack, application);
		TopLayerOperator layerOperator1 = factory.createTopLayerOperator(rootLayer, owningStack, application);
		Layer layer3 = factory.createLayer(layerOperator1, owningStack, application);
		
		// asserts
		assertNotNull("Layer created", rootLayer);
		assertNotNull("Layer created", layer1);
		assertNotNull("Layer created", layer2);
		assertNotNull("Layer created", layerOperator1);
		assertNotNull("Layer created", layer3);
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#findNewLayerName(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer)}.
	 */
	@Test
	public void testFindNewLayerName() {
		
		LayersFactoryForStackImpl factory = new LayersFactoryForStackImpl();
		String expectedName1 = factory.LAYER_NAME_PREFIX + "0";
		
		
		LayerOperator parent = LayersFactory.eINSTANCE.createTopLayerOperator();
		String name1 = factory.findNewLayerName(parent);
		
		assertEquals( "expected name", expectedName1, name1);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createLayersStack()}.
	 */
	@Test
	@Ignore
	public void testCreateLayersStack() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#initLayer(org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression, org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 */
	@Test
	public void testInitLayer() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Create stack
		LayersStack owningStack = application.getLayersStackFor(diagram);
		
		LayersFactoryForStack factory = LayersFactoryForStack.eINSTANCE;
		
		// Create a Tree
		TopLayerOperator rootLayer = factory.createTopLayerOperator(owningStack, owningStack, application);

		// Create a layer and initialize it
		Layer layer1 = LayersFactory.eINSTANCE.createLayer();		
		factory.initLayer(layer1, rootLayer, owningStack, application);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", rootLayer, layer1.eContainer() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createLayer(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 */
	@Test
	public void testCreateLayer() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Create stack
		LayersStack owningStack = application.getLayersStackFor(diagram);
		
		LayersFactoryForStack factory = LayersFactoryForStack.eINSTANCE;
		
		// Create tree
		TopLayerOperator rootLayer = factory.createTopLayerOperator(owningStack, owningStack, application);
		Layer layer1 = factory.createLayer(rootLayer, owningStack, application);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", rootLayer, layer1.eContainer() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createLayer(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 */
	@Test
	public void testCreateLayerAsRoot() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Create stack
		LayersStack owningStack = application.getLayersStackFor(diagram);
		
		LayersFactoryForStack factory = LayersFactoryForStack.eINSTANCE;
		
		// Create tree
		Layer layer1 = factory.createLayer(owningStack, owningStack, application);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", owningStack, layer1.eContainer() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createRegExpLayer(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 */
	@Test
	public void testCreateRegExpLayer() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Create stack
		LayersStack owningStack = application.getLayersStackFor(diagram);
		
		LayersFactoryForStack factory = LayersFactoryForStack.eINSTANCE;
		
		// Create tree
		TopLayerOperator rootLayer = factory.createTopLayerOperator(owningStack, owningStack, application);
		RegExpLayer layer1 = factory.createRegExpLayer(rootLayer, owningStack, application);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", rootLayer, layer1.eContainer() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createLayer(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 */
	@Test
	public void testCreateRegExpLayerAsRoot() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Create stack
		LayersStack owningStack = application.getLayersStackFor(diagram);
		
		LayersFactoryForStack factory = LayersFactoryForStack.eINSTANCE;
		
		// Create tree
		RegExpLayer layer1 = factory.createRegExpLayer(owningStack, owningStack, application);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", owningStack, layer1.eContainer() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createTopLayerOperator(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 */
	@Test
	public void testCreateTopLayerOperator() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Create stack
		LayersStack owningStack = application.getLayersStackFor(diagram);
		
		LayersFactoryForStack factory = LayersFactoryForStack.eINSTANCE;
		
		// Create tree
		TopLayerOperator rootLayer = factory.createTopLayerOperator(owningStack, owningStack, application);
		TopLayerOperator layer1 = factory.createTopLayerOperator(rootLayer, owningStack, application);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", rootLayer, layer1.eContainer() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createTopLayerOperator(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 */
	@Test
	public void testCreateTopLayerOperatorAsRoot() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Create stack
		LayersStack owningStack = application.getLayersStackFor(diagram);
		
		LayersFactoryForStack factory = LayersFactoryForStack.eINSTANCE;
		
		// Create tree
		TopLayerOperator layer1 = factory.createTopLayerOperator(owningStack, owningStack, application);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", owningStack, layer1.eContainer() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createStackedLayerOperator(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 */
	@Test
	public void testCreateStackedLayerOperator() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Create stack
		LayersStack owningStack = application.getLayersStackFor(diagram);
		
		LayersFactoryForStack factory = LayersFactoryForStack.eINSTANCE;
		
		// Create tree
		TopLayerOperator rootLayer = factory.createTopLayerOperator(owningStack, owningStack, application);
		StackedLayerOperator layer1 = factory.createStackedLayerOperator(rootLayer, owningStack, application);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", rootLayer, layer1.eContainer() );
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.LayersFactoryForStackImpl#createTopLayerOperator(org.eclipse.papyrus.layers.stackmodel.layers.LayersContainer, org.eclipse.papyrus.layers.stackmodel.layers.LayersStack, org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication)}.
	 * @throws LayersException 
	 */
	@Test
	public void testCreateStackedLayerOperatorAsRoot() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Create stack
		LayersStack owningStack = application.getLayersStackFor(diagram);
		
		LayersFactoryForStack factory = LayersFactoryForStack.eINSTANCE;
		
		// Create tree
		StackedLayerOperator layer1 = factory.createStackedLayerOperator(owningStack, owningStack, application);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", owningStack, layer1.eContainer() );
	}

	/**
	 * Test method for {@link LayersFactoryForStackImpl#createLayerOperator(String, LayersContainer, LayersStack, LayersStackApplication)}.
	 * @throws LayersException 
	 */
	@Test
	public void testCreateLayerOperator() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		Diagram diagram = NotationFactory.eINSTANCE.createDiagram();
		// Create stack
		LayersStack owningStack = application.getLayersStackFor(diagram);
		
		LayersFactoryForStack factory = LayersFactoryForStack.eINSTANCE;
		
		// Create tree
		TopLayerOperator rootLayer = factory.createTopLayerOperator(owningStack, owningStack, application);
		List<LayerOperatorDescriptor> operatorDescs = application.getLayerOperatorDescriptorRegistry().getDescriptors();
		assertNotNull("descs found", operatorDescs);
		assertTrue("a least one desc is defined", operatorDescs.size()>0);
		
		String layerID = operatorDescs.get(0).getName();
		AbstractLayerOperator layer1 = factory.createLayerOperator(layerID, rootLayer, owningStack, application);
		
		// asserts
		assertNotNull("Layer created", layer1);
		assertSame("state attached", LayerState.ATTACHED, layer1.getState() );
		assertSame("application set", application, layer1.getApplication() );
		assertSame("owningStack set", owningStack, layer1.getOwningLayersStack() );
		assertSame("parent set", rootLayer, layer1.eContainer() );
	}


}
