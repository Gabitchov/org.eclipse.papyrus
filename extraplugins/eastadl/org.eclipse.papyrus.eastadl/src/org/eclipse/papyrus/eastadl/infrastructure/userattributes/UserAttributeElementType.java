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

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.infrastructure.elements.EAElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Attribute Element Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * UserAttributeElementType represents a certain, user-defined type of user attributeable elements. With such a type, one or more user attributes can be defined for all user attributeable elements of that type.
 * 
 * For example, engineers at Volkswagen could create a UserAttributeElementType called "VWFunction" with a single user attribute definition. That way, all FunctionTypes for which "VWFunction" is defined as the UserAttributeElementType via association uaType will have the corresponding user attribute.
 * 
 * User attribute element types can be compared to stereotypes in UML2, but are less rigidly defined.
 * 
 * Extension:
 * Class
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getExtendedElementType <em>Extended Element Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getAttribute <em>Attribute</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getBase_Class <em>Base Class</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getValidFor <em>Valid For</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeElementType()
 * @model
 * @generated
 */
public interface UserAttributeElementType extends EAElement {
	/**
	 * Returns the value of the '<em><b>Attribute</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeDefinition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The attributes defined for this type.
	 * 
	 * Note that also inherited attribute definitions need to be taken into account.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Attribute</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeElementType_Attribute()
	 * @model ordered="false"
	 * @generated
	 */
	EList<UserAttributeDefinition> getAttribute();

	/**
	 * Returns the value of the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Class</em>' reference.
	 * @see #setBase_Class(org.eclipse.uml2.uml.Class)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeElementType_Base_Class()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	org.eclipse.uml2.uml.Class getBase_Class();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getBase_Class <em>Base Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Class</em>' reference.
	 * @see #getBase_Class()
	 * @generated
	 */
	void setBase_Class(org.eclipse.uml2.uml.Class value);

	/**
	 * Returns the value of the '<em><b>Extended Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The UAElementTypes this type is inheriting from.
	 * 
	 * When UAElementType ET2 inherits from type ET1, then this means that all attributes defined for ET1 by way of UserAttributeDefinitions are available whenever ET2 is specified as the type of a user attributeable element (in addition to those directly defined in ET2).  This includes UserAttributeDefinitions which ET1 itself may inherit from other types.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Extended Element Type</em>' reference.
	 * @see #setExtendedElementType(UserAttributeElementType)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeElementType_ExtendedElementType()
	 * @model ordered="false"
	 * @generated
	 */
	UserAttributeElementType getExtendedElementType();

	/**
	 * Returns the value of the '<em><b>Valid For</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid For</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid For</em>' attribute.
	 * @see #setValidFor(String)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeElementType_ValidFor()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" ordered="false"
	 * @generated
	 */
	String getValidFor();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getExtendedElementType <em>Extended Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extended Element Type</em>' reference.
	 * @see #getExtendedElementType()
	 * @generated
	 */
	void setExtendedElementType(UserAttributeElementType value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType#getValidFor <em>Valid For</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Valid For</em>' attribute.
	 * @see #getValidFor()
	 * @generated
	 */
	void setValidFor(String value);

} // UserAttributeElementType
