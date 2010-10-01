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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.Time;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NfpConstraint;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Clock Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsCoincidenceBased <em>Is Coincidence Based</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsPrecedenceBased <em>Is Precedence Based</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsChronometricBased <em>Is Chronometric Based</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockConstraint()
 * @model
 * @generated
 */
public interface ClockConstraint extends NfpConstraint, TimedElement {
	/**
	 * Returns the value of the '<em><b>Is Coincidence Based</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Coincidence Based</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Coincidence Based</em>' attribute.
	 * @see #setIsCoincidenceBased(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockConstraint_IsCoincidenceBased()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsCoincidenceBased();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsCoincidenceBased <em>Is Coincidence Based</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Coincidence Based</em>' attribute.
	 * @see #isIsCoincidenceBased()
	 * @generated
	 */
	void setIsCoincidenceBased(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Precedence Based</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Precedence Based</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Precedence Based</em>' attribute.
	 * @see #setIsPrecedenceBased(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockConstraint_IsPrecedenceBased()
	 * @model unique="false" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsPrecedenceBased();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsPrecedenceBased <em>Is Precedence Based</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Precedence Based</em>' attribute.
	 * @see #isIsPrecedenceBased()
	 * @generated
	 */
	void setIsPrecedenceBased(boolean value);

	/**
	 * Returns the value of the '<em><b>Is Chronometric Based</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Chronometric Based</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Chronometric Based</em>' attribute.
	 * @see #setIsChronometricBased(boolean)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getClockConstraint_IsChronometricBased()
	 * @model unique="false" dataType="org.eclipse.papyrus.MARTE_Library.MARTE_PrimitivesTypes.Boolean" required="true" ordered="false"
	 * @generated
	 */
	boolean isIsChronometricBased();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsChronometricBased <em>Is Chronometric Based</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Chronometric Based</em>' attribute.
	 * @see #isIsChronometricBased()
	 * @generated
	 */
	void setIsChronometricBased(boolean value);

} // ClockConstraint
