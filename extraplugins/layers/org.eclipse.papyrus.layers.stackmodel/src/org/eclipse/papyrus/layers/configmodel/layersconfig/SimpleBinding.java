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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.SimpleBinding#getOperators <em>Operators</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.SimpleBinding#getLayerOperatorMultipleBinding <em>Layer Operator Multiple Binding</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getSimpleBinding()
 * @model
 * @generated
 */
public interface SimpleBinding extends LayersOperatorBinding {
	/**
	 * Returns the value of the '<em><b>Operators</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operators</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operators</em>' reference.
	 * @see #setOperators(OperatorConfig)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getSimpleBinding_Operators()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OperatorConfig getOperators();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.SimpleBinding#getOperators <em>Operators</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operators</em>' reference.
	 * @see #getOperators()
	 * @generated
	 */
	void setOperators(OperatorConfig value);

	/**
	 * Returns the value of the '<em><b>Layer Operator Multiple Binding</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Operator Multiple Binding</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Operator Multiple Binding</em>' container reference.
	 * @see #setLayerOperatorMultipleBinding(LayerOperatorMultipleBinding)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getSimpleBinding_LayerOperatorMultipleBinding()
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding#getBindings
	 * @model opposite="bindings" required="true" transient="false" ordered="false"
	 * @generated
	 */
	LayerOperatorMultipleBinding getLayerOperatorMultipleBinding();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.SimpleBinding#getLayerOperatorMultipleBinding <em>Layer Operator Multiple Binding</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Operator Multiple Binding</em>' container reference.
	 * @see #getLayerOperatorMultipleBinding()
	 * @generated
	 */
	void setLayerOperatorMultipleBinding(LayerOperatorMultipleBinding value);

} // SimpleBinding
