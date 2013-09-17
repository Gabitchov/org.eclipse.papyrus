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
/**
 */
package org.eclipse.papyrus.layers.configmodel.layersconfig;

import org.eclipse.papyrus.layers.stackmodel.InstanciationException;
import org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Config</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getOperatorConfig()
 * @model
 * @generated
 */
public interface OperatorConfig extends InstanciableElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model dataType="org.eclipse.papyrus.layers.configmodel.layersconfig.PropertyOperator" required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.configmodel.layersconfig.InstanciationException"
	 * @generated
	 */
	PropertyOperator createOperatorDescriptor() throws InstanciationException;

} // OperatorConfig
