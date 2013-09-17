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
package org.eclipse.papyrus.layers.stackmodel.layers.loaders;

import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createFolder;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createLayerOperatorConfig;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createLayerOperatorsMultipleBinding;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createOperatorBinding;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createPropertyId;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createPropertyOperatorConfig;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createTypeConfig;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.eclipse.papyrus.layers.configmodel.layersconfig.Folder;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding;
import org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.PropertyId;
import org.eclipse.papyrus.layers.configmodel.layersconfig.TypeConfig;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.eclipse.papyrus.layers.stackmodel.operators.BooleanAndOperator;
import org.eclipse.papyrus.layers.stackmodel.operators.BooleanOrOperator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class RegistriesLoaderTest {

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
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.loaders.RegistriesLoader#RegistriesLoader(org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModel)}.
	 */
	@Test
	public void testRegistriesLoader() {
		
		/**
		 * Create a model used as input for the loader.
		 */
		LayersConfigModel model = new LayersConfigModel();
		initLayersConfigModel(model);
		// Create the loader
		RegistriesLoader loader = new RegistriesLoader(model);
		
		// Check creation
		assertNotNull("loader created", loader);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.loaders.RegistriesLoader#loadLayerOperatorDescriptorRegistry(org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry, org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry)}.
	 */
	@Test
	public void testLoadLayerOperator() {
		
		/**
		 * Create a model used as input for the loader.
		 */
		LayersConfigModel model = new LayersConfigModel();
		initLayersConfigModel(model);
		// Create the loader
		RegistriesLoader loader = new RegistriesLoader(model);
		// CreatePropertyRegistry
		PropertyRegistry propertyRegistry = LayersFactory.eINSTANCE.createPropertyRegistry();

		// Create a LayerOperatorRegistry
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertyRegistry.getPropertiesCount());
		
		// call load
		loader.loadLayerOperatorDescriptorRegistry(registry, propertyRegistry);
		
		// Check result
		assertTrue( "descriptors created", registry.getDescriptors().size()>0 );
		assertTrue( "operators created", registry.getPropertyOperators().size()>0 );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.loaders.RegistriesLoader#loadLayerOperatorDescriptorRegistry(org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry, org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry)}.
	 * @throws NotFoundException 
	 */
	@Test
	public void testLoadLayerOperatorDescriptorRegistry() throws NotFoundException {
		
		/**
		 * Create a model used as input for the loader.
		 */
		LayersConfigModel model = new LayersConfigModel();
		initLayersConfigModel(model);
		// Create the loader
		RegistriesLoader loader = new RegistriesLoader(model);
		// CreatePropertyRegistry
		PropertyRegistry propertyRegistry = LayersFactory.eINSTANCE.createPropertyRegistry();

		// Create a LayerOperatorRegistry
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertyRegistry.getPropertiesCount());
		
		// call load
		loader.loadLayerOperatorDescriptorRegistry(registry, propertyRegistry);
		
		// Check result
		assertTrue( "descriptors created", registry.getDescriptors().size()>0 );
		assertTrue( "operators created", registry.getPropertyOperators().size()>0 );

		// Check if a layer as its operaor
		assertNotNull("descriptor found", registry.getLayerOperatorDescriptor("StackedLayersOperatorA"));

		// check its operators
		assertTrue("operators set", registry.getLayerOperatorDescriptor("StackedLayersOperatorA").getPropertyOperators().size() >0);
		// check its operators
		Property property = propertyRegistry.getProperty("isVisible");
		assertNotNull("operator found", registry.getLayerOperatorDescriptor("StackedLayersOperatorA").getPropertyOperator(property) );
		
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.loaders.RegistriesLoader#loadLayerOperatorDescriptorRegistry(org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry, org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry)}.
	 * @throws NotFoundException 
	 */
	@Test
	public void testLoadLayerOperatorOnly() throws NotFoundException {
		
		/**
		 * Create a model used as input for the loader.
		 */
		LayersConfigModel model = new LayersConfigModel();
		initModelWithLayerOperatorOnly(model);
		// Create the loader
		RegistriesLoader loader = new RegistriesLoader(model);
		// CreatePropertyRegistry
		PropertyRegistry propertyRegistry = LayersFactory.eINSTANCE.createPropertyRegistry();

		// Create a LayerOperatorRegistry
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertyRegistry.getPropertiesCount());
		
		// call load
		loader.loadLayerOperatorDescriptorRegistry(registry, propertyRegistry);
		
		// Check result
		assertTrue( "descriptors created", registry.getDescriptors().size()>0 );
		assertNotNull("descriptor found", registry.getLayerOperatorDescriptor("StackedLayersOperatorA"));
	}

	/**
	 * 
	 * @param model
	 */
	private void initModelWithLayerOperatorOnly(LayersConfigModel model) {
		// Create model
		Folder layeropFolder = createFolder(model.getRootFolder(), "layerOpDesc");
		
		// Create LayerOperators descriptor
		LayerOperatorConfig layerOpA = createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorA", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		LayerOperatorConfig layerOpB = createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorB", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorC", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorD", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
	}
	/**
	 * Initialize the provided model with some defs for tests.
	 * 
	 * @param model
	 */
	private void initLayersConfigModel(LayersConfigModel model) {
		// Create model
		Folder layeropFolder = createFolder(model.getRootFolder(), "layerOpDesc");
		
		// Create LayerOperators descriptor
		LayerOperatorConfig layerOpA = createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorA", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		LayerOperatorConfig layerOpB = createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorB", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorC", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		createLayerOperatorConfig(layeropFolder, "StackedLayersOperatorD", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		
		// Create Operators
		Folder operatorFolder = createFolder(model.getRootFolder(), "operatorDesc");
		OperatorConfig operatorBooleanAnd = createPropertyOperatorConfig(operatorFolder, "operatorBooleanAnd", BooleanAndOperator.class.getName());
		OperatorConfig operatorBooleanOr = createPropertyOperatorConfig(operatorFolder, "operatorBooleanOr", BooleanOrOperator.class.getName());

	
		// Create basic types 
		Folder typeFolder = createFolder(model.getRootFolder(), "types");
		TypeConfig typeBoolean = createTypeConfig(typeFolder, "boolean");
		TypeConfig typeInt = createTypeConfig(typeFolder, "int");
		TypeConfig typeString = createTypeConfig(typeFolder, "String");
		TypeConfig typeFont = createTypeConfig(typeFolder, "Font");
		TypeConfig typeColor = createTypeConfig(typeFolder, "Color");
		TypeConfig typeFill = createTypeConfig(typeFolder, "Fill");
		TypeConfig typeLine = createTypeConfig(typeFolder, "Line");
		
		// Create properties 
		Folder propertiesFolder = createFolder(model.getRootFolder(), "properties");
		PropertyId propertyIsVisible = createPropertyId(propertiesFolder, "isVisible", typeBoolean);
		PropertyId propertyIsAbstract = createPropertyId(propertiesFolder, "isAbstract", typeBoolean);
		PropertyId propertyFill = createPropertyId(propertiesFolder, "fill", typeFill);
		PropertyId propertyLine = createPropertyId(propertiesFolder, "line", typeLine);
		PropertyId propertyFont = createPropertyId(propertiesFolder, "font", typeFont);
		PropertyId propertyBgcolor = createPropertyId(propertiesFolder, "bgcolor", typeColor);
		PropertyId propertyFgcolor = createPropertyId(propertiesFolder, "fgcolor", typeColor);
		
		// Bind operators to layers
		Folder opBindingFolder = createFolder(model.getRootFolder(), "opBindings");
	
		LayerOperatorMultipleBinding layerOpBindingsA = createLayerOperatorsMultipleBinding(opBindingFolder, layerOpA);
		createOperatorBinding(layerOpBindingsA, propertyIsVisible, operatorBooleanAnd);
		createOperatorBinding(layerOpBindingsA, propertyIsAbstract, operatorBooleanAnd);

		LayerOperatorMultipleBinding layerOpBindingsB = createLayerOperatorsMultipleBinding(opBindingFolder, layerOpB);
		createOperatorBinding(layerOpBindingsB, propertyIsVisible, operatorBooleanOr);
		createOperatorBinding(layerOpBindingsB, propertyIsAbstract, operatorBooleanOr);
		
	}



}
