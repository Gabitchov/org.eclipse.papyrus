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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage
 * @generated
 */
public interface TimingconstraintsFactory extends EFactory {

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	TimingconstraintsFactory eINSTANCE = org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Age Timing Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Age Timing Constraint</em>'.
	 * @generated
	 */
	AgeTimingConstraint createAgeTimingConstraint();

	/**
	 * Returns a new object of class '<em>Arbitrary Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Arbitrary Event Constraint</em>'.
	 * @generated
	 */
	ArbitraryEventConstraint createArbitraryEventConstraint();

	/**
	 * Returns a new object of class '<em>Input Synchronization Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Input Synchronization Constraint</em>'.
	 * @generated
	 */
	InputSynchronizationConstraint createInputSynchronizationConstraint();

	/**
	 * Returns a new object of class '<em>Output Synchronization Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Output Synchronization Constraint</em>'.
	 * @generated
	 */
	OutputSynchronizationConstraint createOutputSynchronizationConstraint();

	/**
	 * Returns a new object of class '<em>Pattern Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Pattern Event Constraint</em>'.
	 * @generated
	 */
	PatternEventConstraint createPatternEventConstraint();

	/**
	 * Returns a new object of class '<em>Periodic Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Periodic Event Constraint</em>'.
	 * @generated
	 */
	PeriodicEventConstraint createPeriodicEventConstraint();

	/**
	 * Returns a new object of class '<em>Reaction Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Reaction Constraint</em>'.
	 * @generated
	 */
	ReactionConstraint createReactionConstraint();

	/**
	 * Returns a new object of class '<em>Sporadic Event Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return a new object of class '<em>Sporadic Event Constraint</em>'.
	 * @generated
	 */
	SporadicEventConstraint createSporadicEventConstraint();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the package supported by this factory.
	 * @generated
	 */
	TimingconstraintsPackage getTimingconstraintsPackage();

} //TimingconstraintsFactory
