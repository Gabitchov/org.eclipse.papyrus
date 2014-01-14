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
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerOperator#getLayers <em>Layers</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerOperator()
 * @model abstract="true"
 * @generated
 */
public interface LayerOperator extends LayerExpression, LayersContainer {

	/**
	 * Returns the value of the '<em><b>Layers</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.layers.stackmodel.layers.LayerExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layers</em>' containment reference list.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerOperator_Layers()
	 * @model containment="true"
	 * @generated
	 */
	EList<LayerExpression> getLayers();
} // LayerOperator
