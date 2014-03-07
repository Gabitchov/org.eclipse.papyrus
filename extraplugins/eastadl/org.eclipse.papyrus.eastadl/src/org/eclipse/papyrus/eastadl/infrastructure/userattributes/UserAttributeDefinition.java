/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sara TUCCI (CEA LIST) sara.tucci@cea.fr - Initial API and implementation
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *  David SERVAT (CEA LIST) david.servat@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eastadl.infrastructure.userattributes;


import org.eclipse.papyrus.eastadl.infrastructure.datatypes.EADatatype;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.uml2.uml.Property;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Attribute Definition</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * UserAttributeDefinition represents a user attribute, i.e. it states that all UserAttributeableElements of a certain UserAttributeElementType are to
 * be attached with an attribute identified by 'key'. For example, it can be specified that certain elements should be amended with an attribute
 * "Status".
 * 
 * Extension:
 * Class, Property
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getDefaultValue <em>Default Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getType <em>Type</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getBase_Property <em>Base Property</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeDefinition()
 * @model
 * @generated
 */
public interface UserAttributeDefinition extends EAElement {

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeDefinition_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getBase_Class
	 * <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Default Value</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Default Value</em>' attribute.
	 * @see #setDefaultValue(String)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeDefinition_DefaultValue()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getDefaultValue();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getDefaultValue
	 * <em>Default Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Default Value</em>' attribute.
	 * @see #getDefaultValue()
	 * @generated
	 */
	void setDefaultValue(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(EADatatype)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeDefinition_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EADatatype getType();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getType <em>Type</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(EADatatype value);

	/**
	 * Returns the value of the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Property</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Base Property</em>' reference.
	 * @see #setBase_Property(Property)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeDefinition_Base_Property()
	 * @model ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition#getBase_Property
	 * <em>Base Property</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Base Property</em>' reference.
	 * @see #getBase_Property()
	 * @generated
	 */
	void setBase_Property(Property value);

} // UserAttributeDefinition
