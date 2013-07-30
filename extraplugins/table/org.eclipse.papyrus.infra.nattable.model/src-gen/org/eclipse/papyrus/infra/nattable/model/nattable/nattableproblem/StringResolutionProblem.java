/**
 * Copyright (c) 2013 CEA LIST.
 * 
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>String Resolution Problem</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * This kind of problem is used when the user set a value as a text in a Cell and the system can't convert this string value into the correct type
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem#getValueAsString <em>Value As String</em>}</li>
 * <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem#getUnresolvedString <em>Unresolved String
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.NattableproblemPackage#getStringResolutionProblem()
 * @model
 * @generated
 */
public interface StringResolutionProblem extends Problem {

	/**
	 * Returns the value of the '<em><b>Value As String</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The text which is the source of the problem
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Value As String</em>' attribute.
	 * @see #setValueAsString(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.NattableproblemPackage#getStringResolutionProblem_ValueAsString()
	 * @model required="true"
	 * @generated
	 */
	String getValueAsString();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.StringResolutionProblem#getValueAsString
	 * <em>Value As String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Value As String</em>' attribute.
	 * @see #getValueAsString()
	 * @generated
	 */
	void setValueAsString(String value);

	/**
	 * Returns the value of the '<em><b>Unresolved String</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * the text or a substring of it, which is the source of the problem
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Unresolved String</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.nattableproblem.NattableproblemPackage#getStringResolutionProblem_UnresolvedString()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getUnresolvedString();

} // StringResolutionProblem
