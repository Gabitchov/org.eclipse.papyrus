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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operator Binding</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getLayerOperatorConfig <em>Layer Operator Config</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getPropertyId <em>Property Id</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getOwner <em>Owner</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getOperatorBinding()
 * @model
 * @generated
 */
public interface OperatorBinding extends EObject {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' reference.
	 * @see #setOperator(OperatorConfig)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getOperatorBinding_Operator()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	OperatorConfig getOperator();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getOperator <em>Operator</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' reference.
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(OperatorConfig value);

	/**
	 * Returns the value of the '<em><b>Layer Operator Config</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Operator Config</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Operator Config</em>' reference.
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getOperatorBinding_LayerOperatorConfig()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	LayerOperatorConfig getLayerOperatorConfig();

	/**
	 * Returns the value of the '<em><b>Property Id</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Id</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Id</em>' reference.
	 * @see #setPropertyId(PropertyId)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getOperatorBinding_PropertyId()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PropertyId getPropertyId();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getPropertyId <em>Property Id</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Id</em>' reference.
	 * @see #getPropertyId()
	 * @generated
	 */
	void setPropertyId(PropertyId value);

	/**
	 * Returns the value of the '<em><b>Owner</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding#getBindings <em>Bindings</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owner</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owner</em>' container reference.
	 * @see #setOwner(LayerOperatorMultipleBinding)
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayersconfigPackage#getOperatorBinding_Owner()
	 * @see org.eclipse.papyrus.layers.configmodel.layersconfig.LayerOperatorMultipleBinding#getBindings
	 * @model opposite="bindings" required="true" transient="false" ordered="false"
	 * @generated
	 */
	LayerOperatorMultipleBinding getOwner();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.configmodel.layersconfig.OperatorBinding#getOwner <em>Owner</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owner</em>' container reference.
	 * @see #getOwner()
	 * @generated
	 */
	void setOwner(LayerOperatorMultipleBinding value);

} // OperatorBinding
