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

import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createFolder;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createLayerOperatorConfig;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createLayerOperatorsMultipleBinding;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createOperatorBinding;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createPropertyId;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createPropertyOperatorConfig;
import static org.eclipse.papyrus.layers.stackmodel.layers.loaders.LayersConfigModelUtils.createTypeConfig;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.papyrus.layers.configmodel.layersconfig.Folder;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigFactory;
import org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding;
import org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.PropertyId;
import org.eclipse.papyrus.layers.configmodel.layersconfig.TypeConfig;
import org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage;
import org.eclipse.papyrus.layers.stackmodel.operators.BooleanAndOperator;
import org.eclipse.papyrus.layers.stackmodel.operators.BooleanOrOperator;
import org.eclipse.papyrus.layers.stackmodel.operators.FillAverageOperator;


/**
 * This class encapsulate an LayersConfig model.
 * It provides a default instance initialized with a model.
 * @author cedric dumoulin
 *
 */
public class LayersConfigModel {

	/**
	 * The default instance used by all applications. 
	 */
	static final protected LayersConfigModel instance;
	
	protected Resource resource;
	
	
	
	/**
	 * Create and initialize default instance.
	 */
	static {
		instance = new LayersConfigModel();
		instance.initDefaultModel();
	}
	
	/**
	 * Constructor.
	 *
	 */
	public LayersConfigModel() {
		createResourceAndRootFolder();
	}

	
	/**
	 * @return the instance
	 */
	public static LayersConfigModel getInstance() {
		return instance;
	}

	/**
	 * Init the object with a default model.
	 */
	private void initDefaultModel() {
		// Create model
		Folder layeropFolder = createFolder(getRootFolder(), "layerOp");
		
		LayerOperatorConfig stackedLayersOperatorConfig = createLayerOperatorConfig(layeropFolder, "stackedLayersOperator", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		LayerOperatorConfig stackedLayersOperatorMinimunConfig = createLayerOperatorConfig(layeropFolder, "stackedLayersOperatorMinimum", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		createLayerOperatorConfig(layeropFolder, "stackedLayersOperatorMaximum", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());
		LayerOperatorConfig stackedLayersOperatorAverage = createLayerOperatorConfig(layeropFolder, "stackedLayersOperatorAverage", LayersPackage.eINSTANCE.getStackedLayerOperatorDescriptor().getName());

		// Create Operators
		Folder operatorFolder = createFolder(getRootFolder(), "operatorDesc");
		OperatorConfig operatorBooleanAnd = createPropertyOperatorConfig(operatorFolder, "operatorBooleanAnd", BooleanAndOperator.class.getName());
		OperatorConfig operatorBooleanOr = createPropertyOperatorConfig(operatorFolder, "operatorBooleanOr", BooleanOrOperator.class.getName());
		OperatorConfig operatorFillAverage = createPropertyOperatorConfig(operatorFolder, "operatorFillAverage", FillAverageOperator.class.getName());
	
	
		// Create basic types 
		Folder typeFolder = createFolder(getRootFolder(), "types");
		TypeConfig typeBoolean = createTypeConfig(typeFolder, "boolean");
		TypeConfig typeInt = createTypeConfig(typeFolder, "int");
		TypeConfig typeString = createTypeConfig(typeFolder, "String");
		TypeConfig typeFont = createTypeConfig(typeFolder, "Font");
		TypeConfig typeColor = createTypeConfig(typeFolder, "Color");
		TypeConfig typeFill = createTypeConfig(typeFolder, "Fill");
		TypeConfig typeLine = createTypeConfig(typeFolder, "Line");
		
		// Create properties 
		Folder propertiesFolder = createFolder(getRootFolder(), "properties");
		PropertyId propertyIsVisible = createPropertyId(propertiesFolder, "isVisible", typeBoolean);
		PropertyId propertyIsAbstract = createPropertyId(propertiesFolder, "isAbstract", typeBoolean);
		PropertyId propertyFill = createPropertyId(propertiesFolder, "fill", typeFill);
		PropertyId propertyLine = createPropertyId(propertiesFolder, "line", typeLine);
		PropertyId propertyFont = createPropertyId(propertiesFolder, "font", typeFont);
		PropertyId propertyBgcolor = createPropertyId(propertiesFolder, "bgcolor", typeColor);
		PropertyId propertyFgcolor = createPropertyId(propertiesFolder, "fgcolor", typeColor);
		
		// Bind operators to layers
		Folder opBindingFolder = createFolder(getRootFolder(), "opBindings");
	
		LayerOperatorMultipleBinding layerOpBindingsA = createLayerOperatorsMultipleBinding(opBindingFolder, stackedLayersOperatorConfig);
		createOperatorBinding(layerOpBindingsA, propertyIsVisible, operatorBooleanAnd);
		createOperatorBinding(layerOpBindingsA, propertyIsAbstract, operatorBooleanAnd);
		createOperatorBinding(layerOpBindingsA, propertyFill, operatorFillAverage);
	
		LayerOperatorMultipleBinding layerOpBindingsB = createLayerOperatorsMultipleBinding(opBindingFolder, stackedLayersOperatorMinimunConfig);
		createOperatorBinding(layerOpBindingsB, propertyIsVisible, operatorBooleanOr);
		createOperatorBinding(layerOpBindingsB, propertyIsAbstract, operatorBooleanOr);
		createOperatorBinding(layerOpBindingsB, propertyFill, operatorFillAverage);
	
		LayerOperatorMultipleBinding layerOpBindingsAverage = createLayerOperatorsMultipleBinding(opBindingFolder, stackedLayersOperatorAverage);
		createOperatorBinding(layerOpBindingsAverage, propertyIsVisible, operatorBooleanOr);
		createOperatorBinding(layerOpBindingsAverage, propertyIsAbstract, operatorBooleanOr);
		createOperatorBinding(layerOpBindingsAverage, propertyFill, operatorFillAverage);
	
	}

	/**
	 * Create the resource and add it the root folder.
	 * 
	 * @return
	 */
	protected Folder createResourceAndRootFolder() {
		// Create a resource set.
		ResourceSet resourceSet = new ResourceSetImpl();

		// Register the default resource factory -- only needed for stand-alone!
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());

		// Get the URI of the model file.
		URI fileURI = URI.createURI("config.layersconfig");

		// Create a resource for this file.
		resource = resourceSet.createResource(fileURI);
		Folder parent = LayersconfigFactory.eINSTANCE.createFolder();
		resource.getContents().add(parent);
		return parent;
	}


	/**
	 * @return the resource
	 */
	public Resource getResource() {
		return resource;
	}

	/**
	 * Get the root folder of the model.
	 * There is always a root folder
	 * @return
	 */
	public Folder getRootFolder() {
		return (Folder)getResource().getContents().get(0);
	}
	
	/**
	 * Get all {@link LayerOperatorConfig} contained in the model.
	 * @return
	 */
	public List<LayerOperatorConfig> getAllLayerOperatorConfig() {

		List<LayerOperatorConfig> res = new ArrayList<LayerOperatorConfig>();
		
		TreeIterator<EObject> iter = resource.getAllContents();
		while(iter.hasNext()) {
			EObject obj = iter.next();
			if( obj instanceof LayerOperatorConfig) {
				res.add((LayerOperatorConfig)obj);
			}
		}
		return res;
	}

	/**
	 * Get all object of the specified type contained in the model.
	 * 
	 * @param type The expected type for objects
	 * 
	 * @return A list of object with the specified type.
	 */
	@SuppressWarnings("unchecked")
	public <T extends EObject> List<T> getAllOfType( Class<T> type) {
		List<T> res = new ArrayList<T>();
		
		TreeIterator<EObject> iter = resource.getAllContents();
		while(iter.hasNext()) {
			EObject obj = iter.next();
			if( type.isInstance(obj) ) {
				res.add((T)obj);
			}
		}
		return res;
	}

	/**
	 * Get all operators config objects.
	 * 
	 * @return
	 */
	public List<OperatorConfig> getAllOperatorConfig() {
		
		return getAllOfType(OperatorConfig.class);
	}


	/**
	 * Get all {@link OperatorBinding} declared in the model.
	 * @return
	 */
	public List<OperatorBinding> getAllOperatorBinding() {
		return getAllOfType(OperatorBinding.class);
	}


	/**
	 * Initialize the provided model with some defs for tests.
	 * 
	 * @param model
	 */
	private void initLayersConfigModel(LayersConfigModel model) {
		
	}
}
