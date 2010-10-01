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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimePackage
 * @generated
 */
public interface TimeFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimeFactory eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimeFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Timed Domain</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Domain</em>'.
	 * @generated
	 */
	TimedDomain createTimedDomain();

	/**
	 * Returns a new object of class '<em>Clock</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clock</em>'.
	 * @generated
	 */
	Clock createClock();

	/**
	 * Returns a new object of class '<em>Clock Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clock Type</em>'.
	 * @generated
	 */
	ClockType createClockType();

	/**
	 * Returns a new object of class '<em>Timed Value Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Value Specification</em>'.
	 * @generated
	 */
	TimedValueSpecification createTimedValueSpecification();

	/**
	 * Returns a new object of class '<em>Timed Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Constraint</em>'.
	 * @generated
	 */
	TimedConstraint createTimedConstraint();

	/**
	 * Returns a new object of class '<em>Clock Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Clock Constraint</em>'.
	 * @generated
	 */
	ClockConstraint createClockConstraint();

	/**
	 * Returns a new object of class '<em>Timed Instant Observation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Instant Observation</em>'.
	 * @generated
	 */
	TimedInstantObservation createTimedInstantObservation();

	/**
	 * Returns a new object of class '<em>Timed Duration Observation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Duration Observation</em>'.
	 * @generated
	 */
	TimedDurationObservation createTimedDurationObservation();

	/**
	 * Returns a new object of class '<em>Timed Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Event</em>'.
	 * @generated
	 */
	TimedEvent createTimedEvent();

	/**
	 * Returns a new object of class '<em>Timed Processing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Timed Processing</em>'.
	 * @generated
	 */
	TimedProcessing createTimedProcessing();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TimePackage getTimePackage();

} //TimeFactory
