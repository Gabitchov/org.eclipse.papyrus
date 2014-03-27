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

import org.eclipse.papyrus.layers.configmodel.layersconfig.Folder;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding;
import org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigFactory;
import org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding;
import org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorConfig;
import org.eclipse.papyrus.layers.configmodel.layersconfig.PropertyId;
import org.eclipse.papyrus.layers.configmodel.layersconfig.TypeConfig;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator;


/**
 * Set of utility methods to create elements in a {@link LayersConfigModel}.
 * 
 * @author cedric dumoulin
 *
 */
public class LayersConfigModelUtils {

	/**
	 * Create a {@link Folder} element
	 * @param parent
	 * @param name
	 * @return
	 */
	static public Folder createFolder(Folder parent, String name) {
		Folder folder = LayersconfigFactory.eINSTANCE.createFolder();
		folder.setName(name);
		parent.getFolderElements().add(folder);
		return folder;
	}

	/**
	 * Create a {@link LayerOperatorConfig} element
	 * @param parent
	 * @param ID
	 * @param classname
	 * @return
	 */
	static public  LayerOperatorConfig createLayerOperatorConfig(Folder parent, String ID, String classname) {
		LayerOperatorConfig config = LayersconfigFactory.eINSTANCE.createLayerOperatorConfig();
		config.setName(ID);
		config.setClassname(classname);
		parent.getFolderElements().add(config);
		return config;
	}

	/**
	 * Create a {@link OperatorConfig} element
	 * @param parent
	 * @param ID
	 * @param classname
	 * @return
	 */
	static public  OperatorConfig createPropertyOperatorConfig(Folder parent, String ID, String classname) {
		OperatorConfig config = LayersconfigFactory.eINSTANCE.createOperatorConfig();
		config.setName(ID);
		config.setClassname(classname);
		parent.getFolderElements().add(config);
		return config;
	}

	/**
	 * 
	 * @param owner
	 * @param layerOperator
	 * @return
	 */
	static public LayerOperatorMultipleBinding createLayerOperatorsMultipleBinding(Folder owner, LayerOperatorConfig layerOperator) {
		LayerOperatorMultipleBinding config = LayersconfigFactory.eINSTANCE.createLayerOperatorMultipleBinding();
		config.setLayerOperatorConfig(layerOperator);
		owner.getFolderElements().add(config);
		return config;
	}

	static public OperatorBinding createOperatorBinding(LayerOperatorMultipleBinding owner, PropertyId propertyId, OperatorConfig operatorConfig) {
		OperatorBinding binding = LayersconfigFactory.eINSTANCE.createOperatorBinding();
		binding.setPropertyId(propertyId);
		binding.setOperator(operatorConfig);
		binding.setOwner(owner);
		return binding;
	}

	static public PropertyId createPropertyId(Folder parent, String ID, TypeConfig type) {
		PropertyId propertyId = LayersconfigFactory.eINSTANCE.createPropertyId();
		propertyId.setName(ID);
		propertyId.setType(type);
		parent.getFolderElements().add(propertyId);
		return propertyId;
	}

	static public TypeConfig createTypeConfig(Folder parent, String ID) {
		TypeConfig config = LayersconfigFactory.eINSTANCE.createTypeConfig();
		config.setName(ID);
		parent.getFolderElements().add(config);
		return config;
	}

}
