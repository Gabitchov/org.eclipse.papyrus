/**
 * Copyright (c) 2013 CEA LIST
 * 
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *    CEA LIST - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.C_Cpp;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.uml2.uml.PrimitiveType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Typedef</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Typedef#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.Typedef#getBase_primitivetype <em>Base primitivetype</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getTypedef()
 * @model
 * @generated
 */
public interface Typedef extends EObject {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' attribute.
	 * @see #setDefinition(String)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getTypedef_Definition()
	 * @model unique="false" dataType="org.eclipse.uml2.types.String" required="true" ordered="false"
	 * @generated
	 */
	String getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Typedef#getDefinition <em>Definition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' attribute.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(String value);

	/**
	 * Returns the value of the '<em><b>Base primitivetype</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base primitivetype</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base primitivetype</em>' reference.
	 * @see #setBase_primitivetype(PrimitiveType)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getTypedef_Base_primitivetype()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PrimitiveType getBase_primitivetype();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.Typedef#getBase_primitivetype <em>Base primitivetype</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base primitivetype</em>' reference.
	 * @see #getBase_primitivetype()
	 * @generated
	 */
	void setBase_primitivetype(PrimitiveType value);

} // Typedef
