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

import org.eclipse.uml2.uml.Abstraction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Allocate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getNature <em>Nature</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getBase_Abstraction <em>Base Abstraction</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getImpliedConstraint <em>Implied Constraint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage#getAllocate()
 * @model
 * @generated
 */
public interface Allocate extends EObject {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationKind
	 * @see #setKind(AllocationKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage#getAllocate_Kind()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	AllocationKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(AllocationKind value);

	/**
	 * Returns the value of the '<em><b>Nature</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationNature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nature</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nature</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationNature
	 * @see #setNature(AllocationNature)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage#getAllocate_Nature()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	AllocationNature getNature();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getNature <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nature</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocationNature
	 * @see #getNature()
	 * @generated
	 */
	void setNature(AllocationNature value);

	/**
	 * Returns the value of the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Abstraction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Abstraction</em>' reference.
	 * @see #setBase_Abstraction(Abstraction)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage#getAllocate_Base_Abstraction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Abstraction getBase_Abstraction();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.Allocate#getBase_Abstraction <em>Base Abstraction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Abstraction</em>' reference.
	 * @see #getBase_Abstraction()
	 * @generated
	 */
	void setBase_Abstraction(Abstraction value);

	/**
	 * Returns the value of the '<em><b>Implied Constraint</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Implied Constraint</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Implied Constraint</em>' reference list.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage#getAllocate_ImpliedConstraint()
	 * @model ordered="false"
	 * @generated
	 */
	EList<NfpConstraint> getImpliedConstraint();

} // Allocate
