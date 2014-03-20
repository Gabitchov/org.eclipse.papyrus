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
package org.eclipse.papyrus.eastadl.timing.timingconstraints;

import org.eclipse.papyrus.eastadl.timing.TimeDuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Periodic Event Constraint</b></em>'.
 * <!-- end-user-doc -->
 * 
 * <!-- begin-model-doc -->
 * The PeriodicEventConstraint describes that an event occurs periodically.
 * <!-- end-model-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getJitter <em>Jitter</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getPeriod <em>Period</em>}</li>
 * <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getPeriodicEventConstraint()
 * @model
 * @generated
 */
public interface PeriodicEventConstraint extends EventConstraint {

	/**
	 * Returns the value of the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The jitter specifies the maximal possible time interval the occurrence of an event can vary (formerly: be delayed).
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Jitter</em>' reference.
	 * @see #setJitter(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getPeriodicEventConstraint_Jitter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TimeDuration getJitter();

	/**
	 * Returns the value of the '<em><b>Minimum Inter Arrival Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum inter-arrival time specifies the minimal possible time interval between two consecutive occurrences of an event.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Minimum Inter Arrival Time</em>' reference.
	 * @see #setMinimumInterArrivalTime(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getPeriodicEventConstraint_MinimumInterArrivalTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TimeDuration getMinimumInterArrivalTime();

	/**
	 * Returns the value of the '<em><b>Period</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The period specifies the ideal time interval between two subsequent occurrences of the event.
	 * <!-- end-model-doc -->
	 * 
	 * @return the value of the '<em>Period</em>' reference.
	 * @see #setPeriod(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getPeriodicEventConstraint_Period()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TimeDuration getPeriod();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getJitter <em>Jitter</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Jitter</em>' reference.
	 * @see #getJitter()
	 * @generated
	 */
	void setJitter(TimeDuration value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getMinimumInterArrivalTime
	 * <em>Minimum Inter Arrival Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Minimum Inter Arrival Time</em>' reference.
	 * @see #getMinimumInterArrivalTime()
	 * @generated
	 */
	void setMinimumInterArrivalTime(TimeDuration value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getPeriod <em>Period</em>}'
	 * reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @param value
	 *        the new value of the '<em>Period</em>' reference.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(TimeDuration value);

} // PeriodicEventConstraint
