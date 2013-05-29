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

import org.eclipse.emf.common.util.EList;
import org.eclipse.papyrus.eastadl.timing.TimeDuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Pattern Event Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The [Concrete] Pattern Event Constraint describes that an event occurs following a known pattern. The pattern event model is characterized by the following parameters:
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getPeriod <em>Period</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getOccurence <em>Occurence</em>}</li>
 *   <li>{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getJitter <em>Jitter</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getPatternEventConstraint()
 * @model
 * @generated
 */
public interface PatternEventConstraint extends EventConstraint {
	/**
	 * Returns the value of the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The jitter specifies maximal possible time interval the occurrence of the events within the given period can vary (formerly: can be delayed).
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Jitter</em>' reference.
	 * @see #setJitter(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getPatternEventConstraint_Jitter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TimeDuration getJitter();

	/**
	 * Returns the value of the '<em><b>Minimum Inter Arrival Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The minimum inter-arrival time specifies the minimal possible time interval between two consecutive occurrences of the event within the given period.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Minimum Inter Arrival Time</em>' reference.
	 * @see #setMinimumInterArrivalTime(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getPatternEventConstraint_MinimumInterArrivalTime()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TimeDuration getMinimumInterArrivalTime();

	/**
	 * Returns the value of the '<em><b>Occurence</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.papyrus.eastadl.timing.TimeDuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The set occurrence (1..n) specifies the offset for each occurrence of the event in the specified period. Each occurrence is specified from the beginning of the period
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Occurence</em>' reference list.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getPatternEventConstraint_Occurence()
	 * @model required="true"
	 * @generated
	 */
	EList<TimeDuration> getOccurence();

	/**
	 * Returns the value of the '<em><b>Period</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The period specifies the time interval within the event occurs any number of times following a pattern.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Period</em>' reference.
	 * @see #setPeriod(TimeDuration)
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage#getPatternEventConstraint_Period()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	TimeDuration getPeriod();

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getJitter <em>Jitter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Jitter</em>' reference.
	 * @see #getJitter()
	 * @generated
	 */
	void setJitter(TimeDuration value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum Inter Arrival Time</em>' reference.
	 * @see #getMinimumInterArrivalTime()
	 * @generated
	 */
	void setMinimumInterArrivalTime(TimeDuration value);

	/**
	 * Sets the value of the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getPeriod <em>Period</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Period</em>' reference.
	 * @see #getPeriod()
	 * @generated
	 */
	void setPeriod(TimeDuration value);

} // PatternEventConstraint
