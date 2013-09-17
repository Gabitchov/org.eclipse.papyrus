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
package org.eclipse.papyrus.layers.stackmodel.layers;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Operator Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor#getPropertyOperators <em>Property Operators</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerOperatorDescriptor()
 * @model
 * @generated
 */
public interface LayerOperatorDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Property Operators</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Operators</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Operators</em>' reference list.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerOperatorDescriptor_PropertyOperators()
	 * @model transient="true"
	 * @generated
	 */
	EList<PropertyOperator> getPropertyOperators();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerOperatorDescriptor_Name()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.String" required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.NotFoundException" propertyRequired="true" propertyOrdered="false"
	 * @generated
	 */
	PropertyOperator getPropertyOperator(Property property) throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model propertyRequired="true" propertyOrdered="false" operatorRequired="true" operatorOrdered="false"
	 * @generated
	 */
	void setPropertyOperator(Property property, PropertyOperator operator);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractLayerOperator createLayerOperator();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model sizeDataType="org.eclipse.papyrus.layers.stackmodel.layers.int" sizeRequired="true" sizeOrdered="false" defaultPropertyOperatorRequired="true" defaultPropertyOperatorOrdered="false"
	 * @generated
	 */
	void setPropertyCollectionSize(int size, DefaultPropertyOperator defaultPropertyOperator);

} // LayerOperatorDescriptor
