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
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.util.Arrays;
import java.util.List;

import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.TopLayerOperator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * Test the {#getComputePropertyValueCommand(...)} commands
 * @author cedric dumoulin
 *
 */
public class TopLayerOperatorImplGetComputeCommandTest {

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
	 * Create a layer with the specified view and property set
	 * 
	 * @param asList
	 * @param asList2
	 * @return
	 * @throws LayersException 
	 */
	protected Layer createLayer(LayerOperator parent, List<View> views, List<Property> properties) throws LayersException {

		// Create the layer
		Layer layer = LayersFactory.eINSTANCE.createLayer();
		// Set the application (needed ?)
		layer.setApplication(parent.getApplication());
		// Attach it to its parent
		parent.getLayers().add(layer);
		
		
		// Add views
		for( View view : views) {
			layer.getViews().add(view);
		}
		
		// Add property instances
		for(Property property : properties) {
			layer.addPropertyInstance(property);
		}
		return layer;
	}

	/**
	 * Test method for {@link #createLayer(List, List)}
	 * @throws LayersException 
	 */
	@Test
	public void testCreateLayer() throws LayersException {
		
		// Create requested objects
		TopLayerOperator layerParent = LayersFactory.eINSTANCE.createTopLayerOperator();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layerParent.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();

		// Create Views
		View view1 = NotationFactory.eINSTANCE.createShape();
		View view2 = NotationFactory.eINSTANCE.createShape();
		View view3 = NotationFactory.eINSTANCE.createShape();
		
		// Create Properties
		int index = 0;
		Property property1 = propertyRegistry.getProperties().get(index++);
		Property property2 = propertyRegistry.getProperties().get(index++);
		Property property3 = propertyRegistry.getProperties().get(index++);
		
		// Create layer1: views ={} propInstances={}
		Layer layer = createLayer( layerParent, Arrays.asList(view1, view2), Arrays.asList(property1, property2));
		
		// Checks
		assertNotNull("layer created", layer);
		assertSame("views added", 2, layer.getViews().size());
		
		assertSame("property instance added", 2, layer.getPropertyValueMap().values().size());
		assertSame("property instance is correctly set", layer.getPropertyValueMap().get(property1.getName()), layer.getPropertyInstance(property1));
		assertSame("property instance is correctly set", layer.getPropertyValueMap().get(property2.getName()), layer.getPropertyInstance(property2));
	}
	
		/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.TopLayerOperatorImpl#getComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.layers.stackmodel.layers.Property)}.
		 * @throws LayersException 
	 */
	@Test
	public void testGetComputePropertyValueCommand() throws LayersException {
		// Create requested objects
		TopLayerOperator layer = LayersFactory.eINSTANCE.createTopLayerOperator();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();

		// Create Views
		View view1 = NotationFactory.eINSTANCE.createShape();
		View view2 = NotationFactory.eINSTANCE.createShape();
		View view3 = NotationFactory.eINSTANCE.createShape();
		
		// Create Properties
		int index = 0;
		Property property1 = propertyRegistry.getProperties().get(index++);
		Property property2 = propertyRegistry.getProperties().get(index++);
		Property property3 = propertyRegistry.getProperties().get(index++);
		
		// Create layer1: views ={} propInstances={}
		Layer layer1 = createLayer( layer, Arrays.asList(view1), Arrays.asList(property1));
		
		// Create layer2: views ={} propInstances={}
		Layer layer2 = createLayer( layer, Arrays.asList(view2), Arrays.asList(property1, property2));
		
		// Create layer3: views ={} propInstances={}
		Layer layer3 = createLayer( layer, Arrays.asList(view3), Arrays.asList(property2, property3));
		
		// Checks
		ComputePropertyValueCommand cmd = layer.getComputePropertyValueCommand(view1, property1); 
		assertNotNull("cmd created", cmd);
		assertSame("cmd s the property instance", layer1.getPropertyInstance(property1), cmd);
		
		cmd = layer.getComputePropertyValueCommand(view2, property1); 
		assertNotNull("cmd created", cmd);
		assertSame("cmd s the property instance", layer2.getPropertyInstance(property1), cmd);
		
		// Check not existing
		cmd = layer.getComputePropertyValueCommand(view3, property1); 
		assertNull("cmd is null", cmd);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.TopLayerOperatorImpl#getViewsComputePropertyValueCommand(java.util.List, org.eclipse.papyrus.layers.stackmodel.layers.Property)}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetViewsComputePropertyValueCommandListOfViewProperty() throws LayersException {
		// Create requested objects
		TopLayerOperator layer = LayersFactory.eINSTANCE.createTopLayerOperator();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();

		// Create Views
		View view1 = NotationFactory.eINSTANCE.createShape();
		View view2 = NotationFactory.eINSTANCE.createShape();
		View view3 = NotationFactory.eINSTANCE.createShape();
		View view4 = NotationFactory.eINSTANCE.createShape();
		
		// Create Properties
		int index = 0;
		Property property1 = propertyRegistry.getProperties().get(index++);
		Property property2 = propertyRegistry.getProperties().get(index++);
		Property property3 = propertyRegistry.getProperties().get(index++);
		Property property4 = propertyRegistry.getProperties().get(index++);
		
		// Create layer1: views ={} propInstances={}
		Layer layer1 = createLayer( layer, Arrays.asList(view1), Arrays.asList(property1));
		
		// Create layer2: views ={} propInstances={}
		Layer layer2 = createLayer( layer, Arrays.asList(view2), Arrays.asList(property1, property2));
		
		// Create layer3: views ={} propInstances={}
		Layer layer3 = createLayer( layer, Arrays.asList(view3), Arrays.asList(property2, property3));
		
		// Checks
		List<ComputePropertyValueCommand> cmds = layer.getViewsComputePropertyValueCommand(Arrays.asList(view1, view2), property1); 
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 2, cmds.size());
		int i=0;
		assertSame("cmd is the property instance", layer1.getPropertyInstance(property1), cmds.get(i++));
		assertSame("cmd is the property instance", layer2.getPropertyInstance(property1), cmds.get(i++));
		
		// Check wrong property2
		cmds = layer.getViewsComputePropertyValueCommand(Arrays.asList(view1, view2), property2);
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 2, cmds.size());
		i=0;
		assertSame("cmd is the property instance", null, cmds.get(i++));
		assertSame("cmd is the property instance", layer2.getPropertyInstance(property2), cmds.get(i++));
		
		// Check wrong view
		cmds = layer.getViewsComputePropertyValueCommand(Arrays.asList(view4), property3);
		assertNull("cmd created", cmds);
		
		// Check wrong property
		cmds = layer.getViewsComputePropertyValueCommand(Arrays.asList(view1, view2), property4);
		assertNull("cmd created", cmds);
		
		// Check list with null
		cmds = layer.getViewsComputePropertyValueCommand(Arrays.asList(view1, null, view3), property1);
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 3, cmds.size());
		i=0;
		assertSame("cmd is the property instance", layer1.getPropertyInstance(property1), cmds.get(i++));
		assertSame("cmd is null", null, cmds.get(i++));
		assertSame("cmd is the property instance", null, cmds.get(i++));

		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.TopLayerOperatorImpl#getPropertiesComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, java.util.List)}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetPropertiesComputePropertyValueCommandViewListOfProperty() throws LayersException {
		// Create requested objects
		TopLayerOperator layer = LayersFactory.eINSTANCE.createTopLayerOperator();
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		layer.setApplication(application);
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();

		// Create Views
		View view1 = NotationFactory.eINSTANCE.createShape();
		View view2 = NotationFactory.eINSTANCE.createShape();
		View view3 = NotationFactory.eINSTANCE.createShape();
		View view4 = NotationFactory.eINSTANCE.createShape();
		
		// Create Properties
		int index = 0;
		Property property1 = propertyRegistry.getProperties().get(index++);
		Property property2 = propertyRegistry.getProperties().get(index++);
		Property property3 = propertyRegistry.getProperties().get(index++);
		Property property4 = propertyRegistry.getProperties().get(index++);
		
		// Create layer1: views ={} propInstances={}
		Layer layer1 = createLayer( layer, Arrays.asList(view1), Arrays.asList(property1));
		
		// Create layer2: views ={} propInstances={}
		Layer layer2 = createLayer( layer, Arrays.asList(view1, view2), Arrays.asList(property1, property2));
		
		// Create layer3: views ={} propInstances={}
		Layer layer3 = createLayer( layer, Arrays.asList(view3), Arrays.asList(property3));
		
		// Check view
		List<ComputePropertyValueCommand> cmds = layer.getPropertiesComputePropertyValueCommand(view1, Arrays.asList(property1, property2));
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 2, cmds.size());
		int i=0;
		assertSame("cmd is the property instance", layer1.getPropertyInstance(property1), cmds.get(i++));
		assertSame("cmd is the property instance", layer2.getPropertyInstance(property2), cmds.get(i++));
		
		// Check wrong property4
		cmds = layer.getPropertiesComputePropertyValueCommand(view2, Arrays.asList(property1, property4));
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 2, cmds.size());
		i=0;
		assertSame("cmd is the property instance", layer2.getPropertyInstance(property1), cmds.get(i++));
		assertSame("cmd is the property instance", null, cmds.get(i++));
		
		// Check wrong view
		cmds = layer.getPropertiesComputePropertyValueCommand(view4, Arrays.asList(property3));
		assertNull("cmd created", cmds);
		
		// Check wrong view
		cmds = layer.getPropertiesComputePropertyValueCommand(view3, Arrays.asList(property1, property2));
		assertNull("cmd created", cmds);
		
		// Check list with null
		cmds = layer.getPropertiesComputePropertyValueCommand(view1, Arrays.asList(property1, null, property2));
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 3, cmds.size());
		i=0;
		assertSame("cmd is the property instance", layer1.getPropertyInstance(property1), cmds.get(i++));
		assertSame("cmd is null", null, cmds.get(i++));
		assertSame("cmd is the property instance", layer2.getPropertyInstance(property2), cmds.get(i++));
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.TopLayerOperatorImpl#TopLayerOperatorImpl()}.
	 */
	@Test
	public void testTopLayerOperatorImpl() {
		TopLayerOperator layer = LayersFactory.eINSTANCE.createTopLayerOperator();
		assertNotNull("object created", layer);
	}

}
