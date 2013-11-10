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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Operator To Operator Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorToOperatorBinding#getOperators <em>Operators</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorToOperatorBinding#getLayerOperator <em>Layer Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getLayerOperatorToOperatorBinding()
 * @model
 * @generated
 */
public interface LayerOperatorToOperatorBinding extends FolderElement, LayersOperatorBinding {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' reference.
	 * @see #setOperators(OperatorConfig)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getLayerOperatorToOperatorBinding_Operators()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OperatorConfig getOperators();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorToOperatorBinding#getOperators <em>Operators</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operators</em>' reference.
	 * @see #getOperators()
	 * @generated
	 */
	void setOperators(OperatorConfig value);

	/**
	 * Returns the value of the '<em><b>Layer Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Operator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Operator</em>' reference.
	 * @see #setLayerOperator(LayerOperatorConfig)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getLayerOperatorToOperatorBinding_LayerOperator()
	 * @model ordered="false"
	 * @generated
	 */
	LayerOperatorConfig getLayerOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorToOperatorBinding#getLayerOperator <em>Layer Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Operator</em>' reference.
	 * @see #getLayerOperator()
	 * @generated
	 */
	void setLayerOperator(LayerOperatorConfig value);

} // LayerOperatorToOperatorBinding
