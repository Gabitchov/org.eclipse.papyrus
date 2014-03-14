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
package org.eclipse.papyrus.eastadl.timing;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.timing.TimingPackage
 * @generated
 */
public interface TimingFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	TimingFactory eINSTANCE = org.eclipse.papyrus.eastadl.timing.impl.TimingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Event Chain</em>'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @return a new object of class '<em>Event Chain</em>'.
	 * @generated
	 */
	EventChain createEventChain();

	/**
	 * Returns a new object of class '<em>Execution Time Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Execution Time Constraint</em>'.
	 * @generated
	 */
	ExecutionTimeConstraint createExecutionTimeConstraint();

	/**
	 * Returns a new object of class '<em>Precedence Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Precedence Constraint</em>'.
	 * @generated
	 */
	PrecedenceConstraint createPrecedenceConstraint();

	/**
	 * Returns a new object of class '<em>Time Duration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Time Duration</em>'.
	 * @generated
	 */
	TimeDuration createTimeDuration();

	/**
	 * Returns a new object of class '<em>Timing</em>'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @return a new object of class '<em>Timing</em>'.
	 * @generated
	 */
	Timing createTiming();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	TimingPackage getTimingPackage();

} // TimingFactory
