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
package org.eclipse.papyrus.infra.nattable.model.nattable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Paste Problem</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.PasteProblem#getPastedText <em>Pasted Text</em>}</li>
 *   <li>{@link org.eclipse.papyrus.infra.nattable.model.nattable.PasteProblem#getUnresolvedText <em>Unresolved Text</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getPasteProblem()
 * @model
 * @generated
 */
public interface PasteProblem extends Problem {
	/**
	 * Returns the value of the '<em><b>Pasted Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pasted Text</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pasted Text</em>' attribute.
	 * @see #setPastedText(String)
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getPasteProblem_PastedText()
	 * @model
	 * @generated
	 */
	String getPastedText();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.infra.nattable.model.nattable.PasteProblem#getPastedText <em>Pasted Text</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pasted Text</em>' attribute.
	 * @see #getPastedText()
	 * @generated
	 */
	void setPastedText(String value);

	/**
	 * Returns the value of the '<em><b>Unresolved Text</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Unresolved Text</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Unresolved Text</em>' attribute list.
	 * @see org.eclipse.papyrus.infra.nattable.model.nattable.NattablePackage#getPasteProblem_UnresolvedText()
	 * @model
	 * @generated
	 */
	EList<String> getUnresolvedText();

} // PasteProblem
