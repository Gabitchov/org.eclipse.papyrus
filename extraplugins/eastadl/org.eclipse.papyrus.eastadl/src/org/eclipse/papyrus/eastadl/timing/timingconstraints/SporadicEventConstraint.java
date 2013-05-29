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
 * A representation of the model object '<em><b>Sporadic Event Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The Sporadic Event Constraint describes that an event occurs occasionally. In general it is supposed that the event eventually occurs. Indeed, it is also known that some of the events do not occur for whatsoever reasons.
 * 
 * Note! The parameters minimum inter-arrival time and maximum inter-arrival time must reference the same point in time. Typically, this is the point in time that specifies the beginning of the period subject to consideration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getJitter <em>Jitter</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getMaximumInterArrivalTime <em>Maximum Inter Arrival Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getSporadicEventConstraint()
 * @model
 * @generated
 */
public interface SporadicEventConstraint extends EventConstraint {
	/**
	 * Returns the value of the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional parameter jitter specifies the maximal possible time interval the occurrence of an event can vary (formerly: be delayed). By nature, a sporadic event is supposed to occur at any time, thus it is one of the characteristic that the occurrence is jittery.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Jitter</em>' reference.
	 * @see #setJitter(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getSporadicEventConstraint_Jitter()
	 * @model ordered="false"
	 * @generated
	 */
	TimeDuration getJitter();

	/**
	 * Returns the value of the '<em><b>Maximum Inter Arrival Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The optional parameter maximum inter-arrival time specifies the maximal possible time interval between two consecutive occurrences of an event.
	 * The maximum inter-arrival time may be used to describe different cases:
	 * (1) The maximum inter-arrival time is equal to the duration of the period.
	 * (2) The maximum inter-arrival time is used to specify a point in time within the period that immediately follows the period subject to consideration.
	 * (3) The maximum inter-arrival time is used to specify a point in time within one of the subsequent periods that follow the period subject to consideration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maximum Inter Arrival Time</em>' reference.
	 * @see #setMaximumInterArrivalTime(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getSporadicEventConstraint_MaximumInterArrivalTime()
	 * @model ordered="false"
	 * @generated
	 */
	TimeDuration getMaximumInterArrivalTime();

	/**
	 * Returns the value of the '<em><b>Minimum Inter Arrival Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum inter-arrival time specifies is the minimal possible time interval between two consecutive occurrences of an event.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum Inter Arrival Time</em>' reference.
	 * @see #setMinimumInterArrivalTime(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getSporadicEventConstraint_MinimumInterArrivalTime()
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
	 * @return the value of the '<em>Period</em>' reference.
	 * @see #setPeriod(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getSporadicEventConstraint_Period()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TimeDuration getPeriod();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getJitter <em>Jitter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jitter</em>' reference.
	 * @see #getJitter()
	 * @generated
	 */
	void setJitter(TimeDuration value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getMaximumInterArrivalTime <em>Maximum Inter Arrival Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maximum Inter Arrival Time</em>' reference.
	 * @see #getMaximumInterArrivalTime()
	 * @generated
	 */
	void setMaximumInterArrivalTime(TimeDuration value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Inter Arrival Time</em>' reference.
	 * @see #getMinimumInterArrivalTime()
	 * @generated
	 */
	void setMinimumInterArrivalTime(TimeDuration value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getPeriod <em>Period</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' reference.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(TimeDuration value);

} // SporadicEventConstraint
