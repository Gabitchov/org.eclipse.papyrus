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
/**
 */
package org.eclipse.papyrus.layers.configmodel.layersconfig;

import org.eclipse.papyrus.layers.stackmodel.InstanciationException;
import org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Operator Config</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getLayerOperatorConfig()
 * @model
 * @generated
 */
public interface LayerOperatorConfig extends InstanciableElement {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorDescriptor" required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciationException"
	 * @generated
	 */
	LayerOperatorDescriptor createLayersOperatorDescriptor() throws InstanciationException;
} // LayerOperatorConfig
