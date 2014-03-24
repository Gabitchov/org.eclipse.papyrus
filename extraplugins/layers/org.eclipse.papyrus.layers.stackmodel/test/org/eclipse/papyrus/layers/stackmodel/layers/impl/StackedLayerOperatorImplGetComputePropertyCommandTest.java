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
package org.eclipse.papyrus.layers.stackmodel.layers.impl;

import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createFolder;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createLayerOperatorConfig;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createLayerOperatorsMultipleBinding;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createOperatorBinding;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createPropertyId;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createPropertyOperatorConfig;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createTypeConfig;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.layers.configmodel.layersconfig.Folder;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding;
import org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.PropertyId;
import org.eclipse.papyrus.layers.configmodel.layersconfig.TypeConfig;
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.command.ComputePropertyValueCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.Layer;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersStackApplication;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.StackedLayerOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.impl.FakeOperator.FakeCommand;
import org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModel;
import org.eclipse.papyrus.layers.stackmodel.layers.loaders.RegistriesLoader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author dumoulin
 *
 */
public class StackedLayerOperatorImplGetComputePropertyCommandTest {

	private static final String FAKE_STACKED_LAYERS_OPERATOR_NAME = "FakeStackedLayersOperator";

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.StackedLayerOperatorImpl#StackedLayerOperatorImpl()}.
	 * @throws LayersException 
	 */
	@Test
	public void testStackedLayerOperatorImpl() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		LayerOperatorDescriptorRegistry layerOperatorDescriptorRegistry = application.getLayerOperatorDescriptorRegistry();

		// populate the StackedLayerOperator with appropriate descriptor.
		LayersConfigModel model = new LayersConfigModel();
		initLayersConfigWithTestStackedOperator(model, propertyRegistry);
		RegistriesLoader loader = new RegistriesLoader(model);
		loader.loadLayerOperatorDescriptorRegistry(layerOperatorDescriptorRegistry, propertyRegistry);
		
		// Know, create a LayerOperator
		// Create a StackedLayerOperator
		StackedLayerOperator layer = (StackedLayerOperator)layerOperatorDescriptorRegistry.getLayerOperatorDescriptor(FAKE_STACKED_LAYERS_OPERATOR_NAME).createLayerOperator();
		layer.setApplication(application);
		
		// Check object creation
		assertNotNull( "object created", layer);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerOperatorImpl#getComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, org.eclipse.papyrus.layers.stackmodel.layers.Property)}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetComputePropertyValueCommand() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		LayerOperatorDescriptorRegistry layerOperatorDescriptorRegistry = application.getLayerOperatorDescriptorRegistry();

		// populate the StackedLayerOperator with appropriate descriptor.
		LayersConfigModel model = new LayersConfigModel();
		initLayersConfigWithTestStackedOperator(model, propertyRegistry);
		RegistriesLoader loader = new RegistriesLoader(model);
		loader.loadLayerOperatorDescriptorRegistry(layerOperatorDescriptorRegistry, propertyRegistry);
		
		// Know, create a LayerOperator
		// Create a StackedLayerOperator
		StackedLayerOperator layer = (StackedLayerOperator)layerOperatorDescriptorRegistry.getLayerOperatorDescriptor(FAKE_STACKED_LAYERS_OPERATOR_NAME).createLayerOperator();
		layer.setApplication(application);

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
		Layer layer2 = createLayer( layer, Arrays.asList(view1, view2), Arrays.asList(property1, property2));
		
		// Create layer3: views ={} propInstances={}
		Layer layer3 = createLayer( layer, Arrays.asList(view3), Arrays.asList(property2, property3));
		
		// Checks
		ComputePropertyValueCommand cmd = layer.getComputePropertyValueCommand(view2, property1); 
		assertNotNull("cmd created", cmd);
		assertTrue("cmd is of Fake type", cmd instanceof FakeCommand );
		assertSame("cmd has 1 sub command", 1, ((FakeCommand)cmd).nestedCommand.size());
		
		cmd = layer.getComputePropertyValueCommand(view1, property1); 
		assertNotNull("cmd created", cmd);
		assertTrue("cmd is of Fake type", cmd instanceof FakeCommand );
		assertSame("cmd has 1 sub command", 2, ((FakeCommand)cmd).nestedCommand.size());
		
		// Check not existing
		cmd = layer.getComputePropertyValueCommand(view3, property1); 
		assertNull("cmd is null", cmd);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerOperatorImpl#getViewsComputePropertyValueCommand(java.util.List, org.eclipse.papyrus.layers.stackmodel.layers.Property)}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetViewsComputePropertyValueCommandListOfViewProperty() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		LayerOperatorDescriptorRegistry layerOperatorDescriptorRegistry = application.getLayerOperatorDescriptorRegistry();

		// populate the StackedLayerOperator with appropriate descriptor.
		LayersConfigModel model = new LayersConfigModel();
		initLayersConfigWithTestStackedOperator(model, propertyRegistry);
		RegistriesLoader loader = new RegistriesLoader(model);
		loader.loadLayerOperatorDescriptorRegistry(layerOperatorDescriptorRegistry, propertyRegistry);
		
		// Know, create a LayerOperator
		// Create a StackedLayerOperator
		StackedLayerOperator layer = (StackedLayerOperator)layerOperatorDescriptorRegistry.getLayerOperatorDescriptor(FAKE_STACKED_LAYERS_OPERATOR_NAME).createLayerOperator();
		layer.setApplication(application);

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
		Layer layer3 = createLayer( layer, Arrays.asList(view2, view3), Arrays.asList(property2, property3));
		
		// Checks
		List<ComputePropertyValueCommand> cmds = layer.getViewsComputePropertyValueCommand(Arrays.asList(view1, view2), property1); 
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 2, cmds.size());
		int i=0;
		assertTrue("cmd is of Fake type", cmds.get(i) instanceof FakeCommand );
		assertSame("cmd has 1 sub command", 2, ((FakeCommand)cmds.get(i)).nestedCommand.size());
		i++;
		assertTrue("cmd is of Fake type", cmds.get(i) instanceof FakeCommand );
		assertSame("cmd has 1 sub command", 1, ((FakeCommand)cmds.get(i)).nestedCommand.size());
		
		// Check wrong property2
		cmds = layer.getViewsComputePropertyValueCommand(Arrays.asList(view1, view3), property3);
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 2, cmds.size());
		i=0;
		assertSame("cmd is null", null, cmds.get(i++));
		assertTrue("cmd is of Fake type", cmds.get(i) instanceof FakeCommand );
		assertSame("cmd has 1 sub command", 1, ((FakeCommand)cmds.get(i)).nestedCommand.size());
		
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
		assertTrue("cmd is of Fake type", cmds.get(i++) instanceof FakeCommand );
		assertSame("cmd is null", null, cmds.get(i++));
		assertSame("cmd is null", null, cmds.get(i++));

	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.impl.AbstractLayerOperatorImpl#getPropertiesComputePropertyValueCommand(org.eclipse.gmf.runtime.notation.View, java.util.List)}.
	 * @throws LayersException 
	 */
	@Test
	public void testGetPropertiesComputePropertyValueCommandViewListOfProperty() throws LayersException {
		// Create requested objects
		LayersStackApplication application = LayersFactory.eINSTANCE.createLayersStackApplication();
		PropertyRegistry propertyRegistry = application.getPropertyRegistry();
		LayerOperatorDescriptorRegistry layerOperatorDescriptorRegistry = application.getLayerOperatorDescriptorRegistry();

		// populate the StackedLayerOperator with appropriate descriptor.
		LayersConfigModel model = new LayersConfigModel();
		initLayersConfigWithTestStackedOperator(model, propertyRegistry);
		RegistriesLoader loader = new RegistriesLoader(model);
		loader.loadLayerOperatorDescriptorRegistry(layerOperatorDescriptorRegistry, propertyRegistry);
		
		// Know, create a LayerOperator
		// Create a StackedLayerOperator
		StackedLayerOperator layer = (StackedLayerOperator)layerOperatorDescriptorRegistry.getLayerOperatorDescriptor(FAKE_STACKED_LAYERS_OPERATOR_NAME).createLayerOperator();
		layer.setApplication(application);
		
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
		Layer layer3 = createLayer( layer, Arrays.asList(view2,view3), Arrays.asList(property3));
		
		// Check view
		List<ComputePropertyValueCommand> cmds = layer.getPropertiesComputePropertyValueCommand(view1, Arrays.asList(property1, property2));
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 2, cmds.size());
		int i=0;
		assertTrue("cmd is of Fake type", cmds.get(i) instanceof FakeCommand );
		assertSame("cmd has 1 sub command", 2, ((FakeCommand)cmds.get(i)).nestedCommand.size());
		i++;
		assertTrue("cmd is of Fake type", cmds.get(i) instanceof FakeCommand );
		assertSame("cmd has 1 sub command", 1, ((FakeCommand)cmds.get(i)).nestedCommand.size());
		
		// Check wrong property4
		cmds = layer.getPropertiesComputePropertyValueCommand(view2, Arrays.asList(property1, property4));
		assertNotNull("cmd created", cmds);
		assertSame("cmd size is equals to views size", 2, cmds.size());
		i=0;
		assertTrue("cmd is of Fake type", cmds.get(i++) instanceof FakeCommand );
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
		assertTrue("cmd is of Fake type", cmds.get(i++) instanceof FakeCommand );
		assertSame("cmd is null", null, cmds.get(i++));
		assertTrue("cmd is of Fake type", cmds.get(i++) instanceof FakeCommand );

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
	 * Create a config model ready to initialize the {@link LayerOperatorDescriptorRegistry} with
	 * a StackedLayerOperator containing FakeLayerOperator.
	 * 
	 * @param model
	 */
	private void initLayersConfigWithTestStackedOperator(LayersConfigModel model, PropertyRegistry propertyRegistry) {
		// Create model
		Folder layeropFolder = createFolder(model.getRootFolder(), "layerOpDesc");
		
		// Create LayerOperators descriptor
		LayerOperatorConfig fakeLayerOp = createLayerOperatorConfig(layeropFolder, FAKE_STACKED_LAYERS_OPERATOR_NAME, LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		
		// Create Operators
		Folder operatorFolder = createFolder(model.getRootFolder(), "operatorDesc");
		OperatorConfig operator = createPropertyOperatorConfig(operatorFolder, "FakeOperator", FakeOperator.class.getName());

	
		// Create basic types 
		Folder typeFolder = createFolder(model.getRootFolder(), "types");
		TypeConfig typeBoolean = createTypeConfig(typeFolder, "boolean");
		
		// Create properties 
		// Use the names of the first properties in registry
		// Specify a type, but it is not used by framework
		Folder propertiesFolder = createFolder(model.getRootFolder(), "properties");
		int index = 0;
		PropertyId property1 = createPropertyId(propertiesFolder, propertyRegistry.getProperties().get(index++).getName(), typeBoolean);
		PropertyId property2 = createPropertyId(propertiesFolder, propertyRegistry.getProperties().get(index++).getName(), typeBoolean);
		PropertyId property3 = createPropertyId(propertiesFolder, propertyRegistry.getProperties().get(index++).getName(), typeBoolean);
		
		// Bind operators to layers
		Folder opBindingFolder = createFolder(model.getRootFolder(), "opBindings");
	
		LayerOperatorMultipleBinding layerOpBindingsA = createLayerOperatorsMultipleBinding(opBindingFolder, fakeLayerOp);
		createOperatorBinding(layerOpBindingsA, property1, operator);
		createOperatorBinding(layerOpBindingsA, property2, operator);
		createOperatorBinding(layerOpBindingsA, property3, operator);
	}

}
