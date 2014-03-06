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
package org.eclipse.papyrus.eastadl.timing.timingconstraints.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.*;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.AgeTimingConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.InputSynchronizationConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.OutputSynchronizationConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.ReactionConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsFactory;
import org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class TimingconstraintsFactoryImpl extends EFactoryImpl implements TimingconstraintsFactory {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static TimingconstraintsPackage getPackage() {
		return TimingconstraintsPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static TimingconstraintsFactory init() {
		try {
			TimingconstraintsFactory theTimingconstraintsFactory = (TimingconstraintsFactory)EPackage.Registry.INSTANCE.getEFactory(TimingconstraintsPackage.eNS_URI);
			if(theTimingconstraintsFactory != null) {
				return theTimingconstraintsFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new TimingconstraintsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimingconstraintsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch(eClass.getClassifierID()) {
		case TimingconstraintsPackage.AGE_TIMING_CONSTRAINT:
			return createAgeTimingConstraint();
		case TimingconstraintsPackage.INPUT_SYNCHRONIZATION_CONSTRAINT:
			return createInputSynchronizationConstraint();
		case TimingconstraintsPackage.OUTPUT_SYNCHRONIZATION_CONSTRAINT:
			return createOutputSynchronizationConstraint();
		case TimingconstraintsPackage.REACTION_CONSTRAINT:
			return createReactionConstraint();
		case TimingconstraintsPackage.SPORADIC_EVENT_CONSTRAINT:
			return createSporadicEventConstraint();
		case TimingconstraintsPackage.PERIODIC_EVENT_CONSTRAINT:
			return createPeriodicEventConstraint();
		case TimingconstraintsPackage.PATTERN_EVENT_CONSTRAINT:
			return createPatternEventConstraint();
		case TimingconstraintsPackage.ARBITRARY_EVENT_CONSTRAINT:
			return createArbitraryEventConstraint();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AgeTimingConstraint createAgeTimingConstraint() {
		AgeTimingConstraintImpl ageTimingConstraint = new AgeTimingConstraintImpl();
		return ageTimingConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ArbitraryEventConstraint createArbitraryEventConstraint() {
		ArbitraryEventConstraintImpl arbitraryEventConstraint = new ArbitraryEventConstraintImpl();
		return arbitraryEventConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public InputSynchronizationConstraint createInputSynchronizationConstraint() {
		InputSynchronizationConstraintImpl inputSynchronizationConstraint = new InputSynchronizationConstraintImpl();
		return inputSynchronizationConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public OutputSynchronizationConstraint createOutputSynchronizationConstraint() {
		OutputSynchronizationConstraintImpl outputSynchronizationConstraint = new OutputSynchronizationConstraintImpl();
		return outputSynchronizationConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PatternEventConstraint createPatternEventConstraint() {
		PatternEventConstraintImpl patternEventConstraint = new PatternEventConstraintImpl();
		return patternEventConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public PeriodicEventConstraint createPeriodicEventConstraint() {
		PeriodicEventConstraintImpl periodicEventConstraint = new PeriodicEventConstraintImpl();
		return periodicEventConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ReactionConstraint createReactionConstraint() {
		ReactionConstraintImpl reactionConstraint = new ReactionConstraintImpl();
		return reactionConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public SporadicEventConstraint createSporadicEventConstraint() {
		SporadicEventConstraintImpl sporadicEventConstraint = new SporadicEventConstraintImpl();
		return sporadicEventConstraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public TimingconstraintsPackage getTimingconstraintsPackage() {
		return (TimingconstraintsPackage)getEPackage();
	}

} //TimingconstraintsFactoryImpl
