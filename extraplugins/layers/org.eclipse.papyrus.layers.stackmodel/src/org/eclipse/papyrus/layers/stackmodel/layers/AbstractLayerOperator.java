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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Layer Operator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator#getLayerOperatorDescriptor <em>Layer Operator Descriptor</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator#getLayerOperatorDescriptorName <em>Layer Operator Descriptor Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getAbstractLayerOperator()
 * @model abstract="true"
 * @generated
 */
public interface AbstractLayerOperator extends LayerOperator {

	/**
	 * Returns the value of the '<em><b>Layer Operator Descriptor</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Operator Descriptor</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Operator Descriptor</em>' reference.
	 * @see #setLayerOperatorDescriptor(LayerOperatorDescriptor)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getAbstractLayerOperator_LayerOperatorDescriptor()
	 * @model required="true" transient="true" ordered="false"
	 * @generated
	 */
	LayerOperatorDescriptor getLayerOperatorDescriptor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator#getLayerOperatorDescriptor <em>Layer Operator Descriptor</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Operator Descriptor</em>' reference.
	 * @see #getLayerOperatorDescriptor()
	 * @generated
	 */
	void setLayerOperatorDescriptor(LayerOperatorDescriptor value);

	/**
	 * Returns the value of the '<em><b>Layer Operator Descriptor Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Layer Operator Descriptor Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Layer Operator Descriptor Name</em>' attribute.
	 * @see #setLayerOperatorDescriptorName(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getAbstractLayerOperator_LayerOperatorDescriptorName()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getLayerOperatorDescriptorName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.AbstractLayerOperator#getLayerOperatorDescriptorName <em>Layer Operator Descriptor Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Layer Operator Descriptor Name</em>' attribute.
	 * @see #getLayerOperatorDescriptorName()
	 * @generated
	 */
	void setLayerOperatorDescriptorName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.papyrus.layers.stackmodel.layers.boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isDescriptorSet();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void resetDescriptor();
} // AbstractLayerOperator
