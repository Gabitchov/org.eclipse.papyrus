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


import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;
import org.eclipse.uml2.uml.Property;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Attribute Value</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * UserAttributeValue represents a specific value for a certain user attribute. User attributes are simple key/value pairs which can be attached to
 * all UserAttributeableElements. Each user attribute is identified by a globally unique key.
 * 
 * In principle, there is no restriction which user attributes, i.e. keys, may be attached to a particular element and what strings may be used as
 * value (cf. class UserAttributeableElement). However, user attribute definitions can be used to define a set of legal values for a particular key
 * (see class UserAttributeDefinition) and user attribute element types can be used to state what attributes, i.e. keys, may or should be attached to
 * elements of certain types (cf. class UserAttributeElementType).
 * 
 * The actual value is captured in attribute 'value' and is always represented as a string.
 * 
 * Extension:
 * Class, Property
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getBase_Class <em>Base Class</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getValue <em>Value</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getBase_Property <em>Base Property</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getDefinition <em>Definition</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeValue()
 * @model
 * @generated
 */
public interface UserAttributeValue extends EAElement {

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
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeValue_Base_Class()
	 * @model ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getBase_Class <em>Base Class</em>}'
	 * reference.
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
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeValue_Value()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getValue();

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(UserAttributeDefinition)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeValue_Definition()
	 * @model ordered="false"
	 * @generated
	 */
	UserAttributeDefinition getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getDefinition <em>Definition</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(UserAttributeDefinition value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

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
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeValue_Base_Property()
	 * @model ordered="false"
	 * @generated
	 */
	Property getBase_Property();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue#getBase_Property
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

} // UserAttributeValue
