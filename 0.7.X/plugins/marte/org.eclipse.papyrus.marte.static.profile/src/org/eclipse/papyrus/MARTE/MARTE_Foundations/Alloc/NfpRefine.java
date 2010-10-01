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
 *  Chokri MRAIDHA (CEA LIST) chokri.mraidha@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;

import org.eclipse.uml2.uml.Dependency;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nfp Refine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.NfpRefine#getBase_Dependency <em>Base Dependency</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.NfpRefine#getConstraint <em>Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage#getNfpRefine()
 * @model
 * @generated
 */
public interface NfpRefine extends EObject {
	/**
	 * Returns the value of the '<em><b>Base Dependency</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Dependency</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Dependency</em>' reference.
	 * @see #setBase_Dependency(Dependency)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage#getNfpRefine_Base_Dependency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Dependency getBase_Dependency();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.NfpRefine#getBase_Dependency <em>Base Dependency</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Dependency</em>' reference.
	 * @see #getBase_Dependency()
	 * @generated
	 */
	void setBase_Dependency(Dependency value);

	/**
	 * Returns the value of the '<em><b>Constraint</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constraint</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constraint</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage#getNfpRefine_Constraint()
	 * @model ordered="false"
	 * @generated
	 */
	EList<NfpConstraint> getConstraint();

} // NfpRefine
