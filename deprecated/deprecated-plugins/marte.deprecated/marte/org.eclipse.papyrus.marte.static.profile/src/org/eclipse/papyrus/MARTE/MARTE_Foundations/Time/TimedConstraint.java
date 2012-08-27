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

import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedConstraint#getInterpretation <em>Interpretation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedConstraint()
 * @model
 * @generated
 */
public interface TimedConstraint extends NfpConstraint, TimedElement {
	/**
	 * Returns the value of the '<em><b>Interpretation</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Interpretation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Interpretation</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind
	 * @see #setInterpretation(TimeInterpretationKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedConstraint_Interpretation()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	TimeInterpretationKind getInterpretation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedConstraint#getInterpretation <em>Interpretation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Interpretation</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.TimeInterpretationKind
	 * @see #getInterpretation()
	 * @generated
	 */
	void setInterpretation(TimeInterpretationKind value);

} // TimedConstraint
