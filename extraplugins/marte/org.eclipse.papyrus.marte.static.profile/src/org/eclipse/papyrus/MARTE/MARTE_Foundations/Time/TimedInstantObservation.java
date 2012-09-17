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

import org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind;
import org.eclipse.uml2.uml.TimeObservation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Timed Instant Observation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation#getObsKind <em>Obs Kind</em>}</li>
 *   <li>{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation#getBase_TimeObservation <em>Base Time Observation</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedInstantObservation()
 * @model
 * @generated
 */
public interface TimedInstantObservation extends TimedElement {
	/**
	 * Returns the value of the '<em><b>Obs Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Obs Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Obs Kind</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind
	 * @see #setObsKind(EventKind)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedInstantObservation_ObsKind()
	 * @model unique="false" ordered="false"
	 * @generated
	 */
	EventKind getObsKind();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation#getObsKind <em>Obs Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Obs Kind</em>' attribute.
	 * @see org.eclipse.papyrus.MARTE_Library.TimeTypesLibrary.EventKind
	 * @see #getObsKind()
	 * @generated
	 */
	void setObsKind(EventKind value);

	/**
	 * Returns the value of the '<em><b>Base Time Observation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Time Observation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Time Observation</em>' reference.
	 * @see #setBase_TimeObservation(TimeObservation)
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage#getTimedInstantObservation_Base_TimeObservation()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TimeObservation getBase_TimeObservation();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation#getBase_TimeObservation <em>Base Time Observation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Time Observation</em>' reference.
	 * @see #getBase_TimeObservation()
	 * @generated
	 */
	void setBase_TimeObservation(TimeObservation value);

} // TimedInstantObservation
