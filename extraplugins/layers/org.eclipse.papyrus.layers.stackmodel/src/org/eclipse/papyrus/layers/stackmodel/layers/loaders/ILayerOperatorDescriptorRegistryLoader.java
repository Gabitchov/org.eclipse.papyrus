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

import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyRegistry;


/**
 * Interface that a {@link LayerOperatorDescriptorRegistry} loader should implements.
 * 
 * @author cedric dumoulin
 *
 */
public interface ILayerOperatorDescriptorRegistryLoader {

	/**
	 * Load the specified registry. Initialize its Descriptors and its Operators.
	 * 
	 * @param layerOperatorDescriptorRegistry
	 * @param propertyRegistry
	 */
	public void loadLayerOperatorDescriptorRegistry(LayerOperatorDescriptorRegistry descriptorRegistry, PropertyRegistry propertyRegistry);

}
