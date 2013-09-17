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
import org.eclipse.papyrus.layers.stackmodel.LayersException;
import org.eclipse.papyrus.layers.stackmodel.NotFoundException;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Layer Operator Descriptor Registry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry#getDescriptors <em>Descriptors</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry#getPropertyOperators <em>Property Operators</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry#getPropertyCollectionSize <em>Property Collection Size</em>}</li>
 *   <li>{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry#getDefaultOperator <em>Default Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerOperatorDescriptorRegistry()
 * @model
 * @generated
 */
public interface LayerOperatorDescriptorRegistry extends EObject {
	/**
	 * Returns the value of the '<em><b>Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Descriptors</em>' containment reference list.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerOperatorDescriptorRegistry_Descriptors()
	 * @model containment="true" transient="true" ordered="false"
	 * @generated
	 */
	EList<LayerOperatorDescriptor> getDescriptors();

	/**
	 * Returns the value of the '<em><b>Property Operators</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.layers.stackmodel.layers.PropertyOperator}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Operators</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Operators</em>' containment reference list.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerOperatorDescriptorRegistry_PropertyOperators()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<PropertyOperator> getPropertyOperators();

	/**
	 * Returns the value of the '<em><b>Property Collection Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Collection Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Collection Size</em>' attribute.
	 * @see #setPropertyCollectionSize(int)
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerOperatorDescriptorRegistry_PropertyCollectionSize()
	 * @model dataType="org.eclipse.papyrus.layers.stackmodel.layers.int" required="true" ordered="false"
	 * @generated
	 */
	int getPropertyCollectionSize();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.layers.stackmodel.layers.LayerOperatorDescriptorRegistry#getPropertyCollectionSize <em>Property Collection Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Property Collection Size</em>' attribute.
	 * @see #getPropertyCollectionSize()
	 * @generated
	 */
	void setPropertyCollectionSize(int value);

	/**
	 * Returns the value of the '<em><b>Default Operator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Operator</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Default Operator</em>' reference.
	 * @see org.eclipse.papyrus.layers.stackmodel.layers.LayersPackage#getLayerOperatorDescriptorRegistry_DefaultOperator()
	 * @model required="true" transient="true" changeable="false" ordered="false"
	 * @generated
	 */
	DefaultPropertyOperator getDefaultOperator();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model descriptorRequired="true" descriptorOrdered="false"
	 * @generated
	 */
	void addLayerOperatorDescriptor(LayerOperatorDescriptor descriptor);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.NotFoundException" nameDataType="org.eclipse.papyrus.layers.stackmodel.layers.String" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	LayerOperatorDescriptor getLayerOperatorDescriptor(String name) throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model operatorRequired="true" operatorOrdered="false"
	 * @generated
	 */
	void addPropertyOperator(PropertyOperator operator);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.NotFoundException" nameDataType="org.eclipse.papyrus.layers.stackmodel.layers.String" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	PropertyOperator getPropertyOperator(String name) throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model exceptions="org.eclipse.papyrus.layers.stackmodel.layers.NotFoundException" propertyRequired="true" propertyOrdered="false" operatorNameDataType="org.eclipse.papyrus.layers.stackmodel.layers.String" operatorNameRequired="true" operatorNameOrdered="false" layerDescriptorNameDataType="org.eclipse.papyrus.layers.stackmodel.layers.String" layerDescriptorNameRequired="true" layerDescriptorNameOrdered="false"
	 * @generated
	 */
	void attachOperatorToDescriptor(Property property, String operatorName, String layerDescriptorName) throws NotFoundException;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exceptions="org.eclipse.papyrus.layers.stackmodel.layers.LayersException" layerOperatorIDDataType="org.eclipse.papyrus.layers.stackmodel.layers.String" layerOperatorIDRequired="true" layerOperatorIDOrdered="false"
	 * @generated
	 */
	AbstractLayerOperator createLayerOperator(String layerOperatorID) throws LayersException;

} // LayerOperatorDescriptorRegistry
