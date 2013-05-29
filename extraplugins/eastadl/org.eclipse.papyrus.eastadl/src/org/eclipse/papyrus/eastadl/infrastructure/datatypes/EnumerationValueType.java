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
package org.eclipse.papyrus.eastadl.infrastructure.datatypes;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Enumeration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Value Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The EnumerationValueType is a specific ValueType applicable for Enumerations. It provides the possibility to describe semantics of the baseEnumeration's literals and the information, if multiple values of the baseEnumeration may be selected or not.
 * 
 * Semantics:
 * The EnumerationValueType adds the ability to describe semantics of the baseEnumeration's literals and if multiple values of the baseEnumeration may be selected or not.
 * 
 * 
 * Notation:
 * The datatype EnumerationValueType is denoted using the rectangle symbol with keyword «Datatype EnumerationValueType».
 * 
 * Extension: UML Enumeration
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType#isIsMultiValued <em>Is Multi Valued</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType#getLiteralSemantics <em>Literal Semantics</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType#getBase_Enumeration <em>Base Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getEnumerationValueType()
 * @model
 * @generated
 */
public interface EnumerationValueType extends ValueType {
	/**
	 * Returns the value of the '<em><b>Literal Semantics</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Semantics</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Semantics</em>' attribute list.
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getEnumerationValueType_LiteralSemantics()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" lower="2"
	 * @generated
	 */
	EList<String> getLiteralSemantics();

	/**
	 * Returns the value of the '<em><b>Base Enumeration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Enumeration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Enumeration</em>' reference.
	 * @see #setBase_Enumeration(Enumeration)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getEnumerationValueType_Base_Enumeration()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Enumeration getBase_Enumeration();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType#getBase_Enumeration <em>Base Enumeration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Enumeration</em>' reference.
	 * @see #getBase_Enumeration()
	 * @generated
	 */
	void setBase_Enumeration(Enumeration value);

	/**
	 * Returns the value of the '<em><b>Is Multi Valued</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Multi Valued</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Multi Valued</em>' attribute.
	 * @see #setIsMultiValued(boolean)
	 * @see org.eclipse.papyrus.eastadl.infrastructure.datatypes.DatatypesPackage#getEnumerationValueType_IsMultiValued()
	 * @model unique="false" dataType="org.eclipse.uml2.types.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsMultiValued();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.infrastructure.datatypes.EnumerationValueType#isIsMultiValued <em>Is Multi Valued</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Multi Valued</em>' attribute.
	 * @see #isIsMultiValued()
	 * @generated
	 */
	void setIsMultiValued(boolean value);

} // EnumerationValueType
