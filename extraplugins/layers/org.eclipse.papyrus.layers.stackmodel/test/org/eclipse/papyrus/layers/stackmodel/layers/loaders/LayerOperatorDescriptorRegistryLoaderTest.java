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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.Property;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


/**
 * @author cedric dumoulin
 *
 */
public class LayerOperatorDescriptorRegistryLoaderTest {

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
	 * Test method for constructor.
	 */
	@Test
	public void testLayerOperatorDescriptorRegistryLoader() {
		
		LayerOperatorDescriptorRegistryLoader loader = new LayerOperatorDescriptorRegistryLoader();

		assertNotNull("object created", loader);
	}

	/**
	 * Test method for {@link org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayerOperatorDescriptorRegistryLoader#loadLayerOperatorDescriptorRegistry(org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry, org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry)}.
     * Check if the loader correctly initialize the LayerOperator and the Operators.
     * Registry loading do not use this loader (LayerOperatorDescriptorRegistryLoader) anymore. 
     * The new loader {@link RegistriesLoader} is now used.
     * 
	 * @throws NotFoundException 
	 */
	@Test
	@Ignore 
	public void testLoadRegistry() throws NotFoundException {
		
		// Create a PropertyRegistry
		PropertyRegistry propertyRegistry = LayersFactory.eINSTANCE.createPropertyRegistry();
		
		// Create a registry
		int propertiesCollectionSize = propertyRegistry.getPropertiesCount();
		LayerOperatorDescriptorRegistry registry = LayersFactory.eINSTANCE.createLayerOperatorDescriptorRegistry();
		registry.setPropertyCollectionSize(propertiesCollectionSize);
		// Create the loader
		LayerOperatorDescriptorRegistryLoader loader = new LayerOperatorDescriptorRegistryLoader();

	
		// Load the registry with the loader
		loader.loadLayerOperatorDescriptorRegistry(registry, propertyRegistry);
		
		// check registry content
		assertNotNull("layerOperator AndLayerOperator loaded", registry.getLayerOperatorDescriptor("OrStackedLayerOperator") );
		assertNotNull("layerOperator OrLayerOperator loaded", registry.getLayerOperatorDescriptor("AndStackedLayerOperator") );
		

		assertNotNull("Operator BooleanAnd loaded", registry.getPropertyOperator("booleanOr"));
		assertNotNull("Operator BooleanAnd loaded", registry.getPropertyOperator("booleanAnd"));
		
		// Check attachment
		Property isVisibleProp = propertyRegistry.getProperty("isVisible");
		assertNotNull("property set", isVisibleProp);
		assertNotNull("Operator attached to AndLayerOperator ", registry.getLayerOperatorDescriptor("OrStackedLayerOperator").getPropertyOperator(isVisibleProp) );
		assertNotNull("Operator attached to  OrLayerOperator ", registry.getLayerOperatorDescriptor("AndStackedLayerOperator").getPropertyOperator(isVisibleProp) );
		// check if the right operator is attached to the right layerOperator
		assertSame("Operator attached to AndLayerOperator ", registry.getPropertyOperator("booleanOr"), registry.getLayerOperatorDescriptor("OrStackedLayerOperator").getPropertyOperator(isVisibleProp) );
		assertSame("Operator attached to  OrLayerOperator ", registry.getPropertyOperator("booleanAnd"), registry.getLayerOperatorDescriptor("AndStackedLayerOperator").getPropertyOperator(isVisibleProp) );
		
	}

}
