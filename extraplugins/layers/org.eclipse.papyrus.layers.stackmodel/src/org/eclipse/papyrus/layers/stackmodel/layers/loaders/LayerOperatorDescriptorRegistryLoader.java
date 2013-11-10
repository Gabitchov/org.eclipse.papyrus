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

import org.eclipse.papyrus.layers.stackmodel.NotFoundException;
import org.eclipse.papyrus.layers.stackmodel.layers.CustomPropertyOperator;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersFactory;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;
import org.eclipse.papyrus.layers.stackmodel.operators.BooleanAndOperator;
import org.eclipse.papyrus.layers.stackmodel.operators.BooleanOrOperator;


/**
 * Class used to load a {@link LayerOperatorDescriptorRegistry}.
 * 
 * @author cedric dumoulin
 *
 *@deprecated use {@link RegistriesLoader} instead.
 *
 */
public class LayerOperatorDescriptorRegistryLoader implements ILayerOperatorDescriptorRegistryLoader {

	/**
	 * Load the specified registry. Initialize its Descriptors and its Operators.
	 * 
	 * @param layerOperatorDescriptorRegistry
	 * @param propertyRegistry
	 */
	public void loadRegistryOld(LayerOperatorDescriptorRegistry descriptorRegistry, PropertyRegistry propertyRegistry) {

		// Custom operator declarations
		// operatorName, operatorImplementationClass
		String[] operatorDeclarations = new String[] {
				"booleanOr", BooleanOrOperator.class.getName(),
				"booleanAnd", BooleanAndOperator.class.getName(),
				
		}; 
		
		// Load operators
		for( int i=0; i<operatorDeclarations.length; i+=2) {
			CustomPropertyOperator operator = LayersFactory.eINSTANCE.createCustomPropertyOperator();
			operator.setName(operatorDeclarations[i]);
			operator.setClassname(operatorDeclarations[i+1]);
			descriptorRegistry.addPropertyOperator(operator);
		}
		
		// AndLayerStackOperatorDescriptor
		// propertyName, operatorName
		String[] andDescriptorDeclarations = new String [] {
				"isVisible", "booleanAnd",
		};
		
		LayerOperatorDescriptor andDescriptor = LayersFactory.eINSTANCE.createAndStackedLayerOperatorDescriptor();
		descriptorRegistry.addLayerOperatorDescriptor(andDescriptor);
		
		// attach operator to layer and property
		String descriptorName = andDescriptor.getName();
		for( int i=0; i<andDescriptorDeclarations.length; i+=2) {
			try {
				descriptorRegistry.attachOperatorToDescriptor(propertyRegistry.getProperty(andDescriptorDeclarations[i]), andDescriptorDeclarations[i+1], descriptorName);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		// OrLayerStackOperatorDescriptor
		// propertyName, operatorName
		String[] orDescriptorDeclarations = new String [] {
				"isVisible", "booleanOr",
		};
		
		LayerOperatorDescriptor orDescriptor = LayersFactory.eINSTANCE.createOrStackedLayerOperatorDescriptor();
		descriptorRegistry.addLayerOperatorDescriptor(orDescriptor);
		
		// attach operator to layer and property
		descriptorName = orDescriptor.getName();
		for( int i=0; i<orDescriptorDeclarations.length; i+=2) {
			try {
				descriptorRegistry.attachOperatorToDescriptor(propertyRegistry.getProperty(orDescriptorDeclarations[i]), orDescriptorDeclarations[i+1], descriptorName);
			} catch (NotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}

	/**
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.loaders.ILayerOperatorDescriptorRegistryLoader#loadLayerOperatorDescriptorRegistry(org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry, org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry)
	 *
	 * @param descriptorRegistry
	 * @param propertyRegistry
	 */
	public void loadLayerOperatorDescriptorRegistry(LayerOperatorDescriptorRegistry descriptorRegistry, PropertyRegistry propertyRegistry) {

		createLayersConfigModel();
		
	}

	/**
	 * Create a Model
	 */
	private void createLayersConfigModel() {
		// TODO Auto-generated method stub
		
	}
	
}
