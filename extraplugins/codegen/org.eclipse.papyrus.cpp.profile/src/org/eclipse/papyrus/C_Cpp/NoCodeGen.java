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

import org.eclipse.uml2.uml.Element;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>No Code Gen</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * No code generation should be done for this element. This also means that no include directive is generated, if the class is referenced.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.C_Cpp.NoCodeGen#getBase_element <em>Base element</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getNoCodeGen()
 * @model
 * @generated
 */
public interface NoCodeGen extends EObject {
	/**
	 * Returns the value of the '<em><b>Base element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base element</em>' reference.
	 * @see #setBase_element(Element)
	 * @see org.eclipse.papyrus.C_Cpp.C_CppPackage#getNoCodeGen_Base_element()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Element getBase_element();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.C_Cpp.NoCodeGen#getBase_element <em>Base element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base element</em>' reference.
	 * @see #getBase_element()
	 * @generated
	 */
	void setBase_element(Element value);

} // NoCodeGen
