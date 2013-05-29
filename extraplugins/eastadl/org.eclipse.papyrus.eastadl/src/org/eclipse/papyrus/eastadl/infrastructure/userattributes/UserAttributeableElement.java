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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>User Attributeable Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * UserAttributableElement represents an element to which user attributes can be attached. This is done by way of UserAttributeValues (see association 'uaValues'). What user attributes a certain element should be supplied with can be defined beforehand with UserAttributeDefinitions which are organized in UserAttributeElementTypes (see association 'uaTypes').
 * 
 * IMPORTANT: It is technically possible and legal to attach any key/value pair, even if this is in conflict with the attribute definitions of the UserAttributeElementTypes of this UserAttributeableElement (as defined by association 'uaTypes'). All implementations of this information model must expect such attribute definition violations. The reason for this is that (1) the attribute definitions and the types they define for the attributes are only meant as a guideline for working with user attributes on the modeling level, not as an implementation level type system and (2) this convention avoids a multitude of intricate problems when editing a model's user attribute definitions or values, which significantly simplifies implementation.
 * 
 * 
 * Extension:
 * NamedElement
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getUaValue <em>Ua Value</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getUaType <em>Ua Type</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getAttributedElement <em>Attributed Element</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getBase_NamedElement <em>Base Named Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeableElement()
 * @model
 * @generated
 */
public interface UserAttributeableElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Ua Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeElementType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The UAElementTypes of this user attirbuteable element.
	 * 
	 * It is possible to provide more than one type.  In that case, the UserAttributeDefinitions of all UAElementTypes apply.  If there are several attribute definitions with an identical 'key', then the corresponding user attribute will be applied only once.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ua Type</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeableElement_UaType()
	 * @model ordered="false"
	 * @generated
	 */
	EList<UserAttributeElementType> getUaType();

	/**
	 * Returns the value of the '<em><b>Attributed Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributed Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributed Element</em>' reference.
	 * @see #setAttributedElement(NamedElement)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeableElement_AttributedElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getAttributedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getAttributedElement <em>Attributed Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attributed Element</em>' reference.
	 * @see #getAttributedElement()
	 * @generated
	 */
	void setAttributedElement(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Named Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Named Element</em>' reference.
	 * @see #setBase_NamedElement(NamedElement)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeableElement_Base_NamedElement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NamedElement getBase_NamedElement();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeableElement#getBase_NamedElement <em>Base Named Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Named Element</em>' reference.
	 * @see #getBase_NamedElement()
	 * @generated
	 */
	void setBase_NamedElement(NamedElement value);

	/**
	 * Returns the value of the '<em><b>Ua Value</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserAttributeValue}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The user attribute values, i.e. key-value pairs, which are attached to this element.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Ua Value</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.userattributes.UserattributesPackage#getUserAttributeableElement_UaValue()
	 * @model ordered="false"
	 * @generated
	 */
	EList<UserAttributeValue> getUaValue();

} // UserAttributeableElement
