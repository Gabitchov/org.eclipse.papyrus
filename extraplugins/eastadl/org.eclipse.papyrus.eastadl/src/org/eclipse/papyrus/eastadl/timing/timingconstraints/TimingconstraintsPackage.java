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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.timing.TimingPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This section describes the timing constraints.
 * <!-- end-model-doc -->
 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.TimingconstraintsFactory
 * @model kind="package"
 * @generated
 */
public interface TimingconstraintsPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.DelayConstraintImpl <em>Delay Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.DelayConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getDelayConstraint()
		 * @generated
		 */
		EClass DELAY_CONSTRAINT = eINSTANCE.getDelayConstraint();

		/**
		 * The meta object literal for the '<em><b>Jitter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELAY_CONSTRAINT__JITTER = eINSTANCE.getDelayConstraint_Jitter();

		/**
		 * The meta object literal for the '<em><b>Nominal</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELAY_CONSTRAINT__NOMINAL = eINSTANCE.getDelayConstraint_Nominal();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELAY_CONSTRAINT__SCOPE = eINSTANCE.getDelayConstraint_Scope();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.AgeTimingConstraintImpl <em>Age Timing Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.AgeTimingConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getAgeTimingConstraint()
		 * @generated
		 */
		EClass AGE_TIMING_CONSTRAINT = eINSTANCE.getAgeTimingConstraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.EventConstraintImpl <em>Event Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.EventConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getEventConstraint()
		 * @generated
		 */
		EClass EVENT_CONSTRAINT = eINSTANCE.getEventConstraint();

		/**
		 * The meta object literal for the '<em><b>Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_CONSTRAINT__EVENT = eINSTANCE.getEventConstraint_Event();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_CONSTRAINT__OFFSET = eINSTANCE.getEventConstraint_Offset();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.InputSynchronizationConstraintImpl <em>Input Synchronization Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.InputSynchronizationConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getInputSynchronizationConstraint()
		 * @generated
		 */
		EClass INPUT_SYNCHRONIZATION_CONSTRAINT = eINSTANCE.getInputSynchronizationConstraint();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INPUT_SYNCHRONIZATION_CONSTRAINT__WIDTH = eINSTANCE.getInputSynchronizationConstraint_Width();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.OutputSynchronizationConstraintImpl <em>Output Synchronization Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.OutputSynchronizationConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getOutputSynchronizationConstraint()
		 * @generated
		 */
		EClass OUTPUT_SYNCHRONIZATION_CONSTRAINT = eINSTANCE.getOutputSynchronizationConstraint();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OUTPUT_SYNCHRONIZATION_CONSTRAINT__WIDTH = eINSTANCE.getOutputSynchronizationConstraint_Width();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.ReactionConstraintImpl <em>Reaction Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.ReactionConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getReactionConstraint()
		 * @generated
		 */
		EClass REACTION_CONSTRAINT = eINSTANCE.getReactionConstraint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.SporadicEventConstraintImpl <em>Sporadic Event Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.SporadicEventConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getSporadicEventConstraint()
		 * @generated
		 */
		EClass SPORADIC_EVENT_CONSTRAINT = eINSTANCE.getSporadicEventConstraint();

		/**
		 * The meta object literal for the '<em><b>Jitter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPORADIC_EVENT_CONSTRAINT__JITTER = eINSTANCE.getSporadicEventConstraint_Jitter();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPORADIC_EVENT_CONSTRAINT__PERIOD = eINSTANCE.getSporadicEventConstraint_Period();

		/**
		 * The meta object literal for the '<em><b>Maximum Inter Arrival Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPORADIC_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME = eINSTANCE.getSporadicEventConstraint_MaximumInterArrivalTime();

		/**
		 * The meta object literal for the '<em><b>Minimum Inter Arrival Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPORADIC_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME = eINSTANCE.getSporadicEventConstraint_MinimumInterArrivalTime();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PeriodicEventConstraintImpl <em>Periodic Event Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PeriodicEventConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getPeriodicEventConstraint()
		 * @generated
		 */
		EClass PERIODIC_EVENT_CONSTRAINT = eINSTANCE.getPeriodicEventConstraint();

		/**
		 * The meta object literal for the '<em><b>Jitter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERIODIC_EVENT_CONSTRAINT__JITTER = eINSTANCE.getPeriodicEventConstraint_Jitter();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERIODIC_EVENT_CONSTRAINT__PERIOD = eINSTANCE.getPeriodicEventConstraint_Period();

		/**
		 * The meta object literal for the '<em><b>Minimum Inter Arrival Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERIODIC_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME = eINSTANCE.getPeriodicEventConstraint_MinimumInterArrivalTime();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PatternEventConstraintImpl <em>Pattern Event Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PatternEventConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getPatternEventConstraint()
		 * @generated
		 */
		EClass PATTERN_EVENT_CONSTRAINT = eINSTANCE.getPatternEventConstraint();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EVENT_CONSTRAINT__PERIOD = eINSTANCE.getPatternEventConstraint_Period();

		/**
		 * The meta object literal for the '<em><b>Minimum Inter Arrival Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME = eINSTANCE.getPatternEventConstraint_MinimumInterArrivalTime();

		/**
		 * The meta object literal for the '<em><b>Occurence</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EVENT_CONSTRAINT__OCCURENCE = eINSTANCE.getPatternEventConstraint_Occurence();

		/**
		 * The meta object literal for the '<em><b>Jitter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PATTERN_EVENT_CONSTRAINT__JITTER = eINSTANCE.getPatternEventConstraint_Jitter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.ArbitraryEventConstraintImpl <em>Arbitrary Event Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.ArbitraryEventConstraintImpl
		 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getArbitraryEventConstraint()
		 * @generated
		 */
		EClass ARBITRARY_EVENT_CONSTRAINT = eINSTANCE.getArbitraryEventConstraint();

		/**
		 * The meta object literal for the '<em><b>Minimum Inter Arrival Time</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME = eINSTANCE.getArbitraryEventConstraint_MinimumInterArrivalTime();

		/**
		 * The meta object literal for the '<em><b>Maximum Inter Arrival Time</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME = eINSTANCE.getArbitraryEventConstraint_MaximumInterArrivalTime();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "timingconstraints";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Timing/TimingConstraints/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "TimingConstraints";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimingconstraintsPackage eINSTANCE = org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.DelayConstraintImpl <em>Delay Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.DelayConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getDelayConstraint()
	 * @generated
	 */
	int DELAY_CONSTRAINT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT__NAME = TimingPackage.TIMING_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT__BASE_NAMED_ELEMENT = TimingPackage.TIMING_CONSTRAINT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT__OWNED_COMMENT = TimingPackage.TIMING_CONSTRAINT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT__MODE = TimingPackage.TIMING_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT__UPPER = TimingPackage.TIMING_CONSTRAINT__UPPER;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT__LOWER = TimingPackage.TIMING_CONSTRAINT__LOWER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT__BASE_CLASS = TimingPackage.TIMING_CONSTRAINT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT__BASE_CONSTRAINT = TimingPackage.TIMING_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT__JITTER = TimingPackage.TIMING_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Nominal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT__NOMINAL = TimingPackage.TIMING_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT__SCOPE = TimingPackage.TIMING_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Delay Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_CONSTRAINT_FEATURE_COUNT = TimingPackage.TIMING_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.AgeTimingConstraintImpl <em>Age Timing Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.AgeTimingConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getAgeTimingConstraint()
	 * @generated
	 */
	int AGE_TIMING_CONSTRAINT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__NAME = DELAY_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__BASE_NAMED_ELEMENT = DELAY_CONSTRAINT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__OWNED_COMMENT = DELAY_CONSTRAINT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__MODE = DELAY_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__UPPER = DELAY_CONSTRAINT__UPPER;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__LOWER = DELAY_CONSTRAINT__LOWER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__BASE_CLASS = DELAY_CONSTRAINT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__BASE_CONSTRAINT = DELAY_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__JITTER = DELAY_CONSTRAINT__JITTER;

	/**
	 * The feature id for the '<em><b>Nominal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__NOMINAL = DELAY_CONSTRAINT__NOMINAL;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT__SCOPE = DELAY_CONSTRAINT__SCOPE;

	/**
	 * The number of structural features of the '<em>Age Timing Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGE_TIMING_CONSTRAINT_FEATURE_COUNT = DELAY_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.EventConstraintImpl <em>Event Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.EventConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getEventConstraint()
	 * @generated
	 */
	int EVENT_CONSTRAINT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONSTRAINT__NAME = TimingPackage.TIMING_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONSTRAINT__BASE_NAMED_ELEMENT = TimingPackage.TIMING_CONSTRAINT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONSTRAINT__OWNED_COMMENT = TimingPackage.TIMING_CONSTRAINT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONSTRAINT__MODE = TimingPackage.TIMING_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONSTRAINT__UPPER = TimingPackage.TIMING_CONSTRAINT__UPPER;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONSTRAINT__LOWER = TimingPackage.TIMING_CONSTRAINT__LOWER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONSTRAINT__BASE_CLASS = TimingPackage.TIMING_CONSTRAINT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONSTRAINT__BASE_CONSTRAINT = TimingPackage.TIMING_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONSTRAINT__EVENT = TimingPackage.TIMING_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONSTRAINT__OFFSET = TimingPackage.TIMING_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_CONSTRAINT_FEATURE_COUNT = TimingPackage.TIMING_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.InputSynchronizationConstraintImpl <em>Input Synchronization Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.InputSynchronizationConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getInputSynchronizationConstraint()
	 * @generated
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__NAME = AGE_TIMING_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__BASE_NAMED_ELEMENT = AGE_TIMING_CONSTRAINT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__OWNED_COMMENT = AGE_TIMING_CONSTRAINT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__MODE = AGE_TIMING_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__UPPER = AGE_TIMING_CONSTRAINT__UPPER;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__LOWER = AGE_TIMING_CONSTRAINT__LOWER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__BASE_CLASS = AGE_TIMING_CONSTRAINT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__BASE_CONSTRAINT = AGE_TIMING_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__JITTER = AGE_TIMING_CONSTRAINT__JITTER;

	/**
	 * The feature id for the '<em><b>Nominal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__NOMINAL = AGE_TIMING_CONSTRAINT__NOMINAL;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__SCOPE = AGE_TIMING_CONSTRAINT__SCOPE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT__WIDTH = AGE_TIMING_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Input Synchronization Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_SYNCHRONIZATION_CONSTRAINT_FEATURE_COUNT = AGE_TIMING_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.ReactionConstraintImpl <em>Reaction Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.ReactionConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getReactionConstraint()
	 * @generated
	 */
	int REACTION_CONSTRAINT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__NAME = DELAY_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__BASE_NAMED_ELEMENT = DELAY_CONSTRAINT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__OWNED_COMMENT = DELAY_CONSTRAINT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__MODE = DELAY_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__UPPER = DELAY_CONSTRAINT__UPPER;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__LOWER = DELAY_CONSTRAINT__LOWER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__BASE_CLASS = DELAY_CONSTRAINT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__BASE_CONSTRAINT = DELAY_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__JITTER = DELAY_CONSTRAINT__JITTER;

	/**
	 * The feature id for the '<em><b>Nominal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__NOMINAL = DELAY_CONSTRAINT__NOMINAL;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT__SCOPE = DELAY_CONSTRAINT__SCOPE;

	/**
	 * The number of structural features of the '<em>Reaction Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REACTION_CONSTRAINT_FEATURE_COUNT = DELAY_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.OutputSynchronizationConstraintImpl <em>Output Synchronization Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.OutputSynchronizationConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getOutputSynchronizationConstraint()
	 * @generated
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__NAME = REACTION_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__BASE_NAMED_ELEMENT = REACTION_CONSTRAINT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__OWNED_COMMENT = REACTION_CONSTRAINT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__MODE = REACTION_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__UPPER = REACTION_CONSTRAINT__UPPER;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__LOWER = REACTION_CONSTRAINT__LOWER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__BASE_CLASS = REACTION_CONSTRAINT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__BASE_CONSTRAINT = REACTION_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__JITTER = REACTION_CONSTRAINT__JITTER;

	/**
	 * The feature id for the '<em><b>Nominal</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__NOMINAL = REACTION_CONSTRAINT__NOMINAL;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__SCOPE = REACTION_CONSTRAINT__SCOPE;

	/**
	 * The feature id for the '<em><b>Width</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT__WIDTH = REACTION_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Output Synchronization Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_SYNCHRONIZATION_CONSTRAINT_FEATURE_COUNT = REACTION_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.SporadicEventConstraintImpl <em>Sporadic Event Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.SporadicEventConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getSporadicEventConstraint()
	 * @generated
	 */
	int SPORADIC_EVENT_CONSTRAINT = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__NAME = EVENT_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__BASE_NAMED_ELEMENT = EVENT_CONSTRAINT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__OWNED_COMMENT = EVENT_CONSTRAINT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__MODE = EVENT_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__UPPER = EVENT_CONSTRAINT__UPPER;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__LOWER = EVENT_CONSTRAINT__LOWER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__BASE_CLASS = EVENT_CONSTRAINT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__BASE_CONSTRAINT = EVENT_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__EVENT = EVENT_CONSTRAINT__EVENT;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__OFFSET = EVENT_CONSTRAINT__OFFSET;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__JITTER = EVENT_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Period</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__PERIOD = EVENT_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Maximum Inter Arrival Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME = EVENT_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Minimum Inter Arrival Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME = EVENT_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sporadic Event Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPORADIC_EVENT_CONSTRAINT_FEATURE_COUNT = EVENT_CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PeriodicEventConstraintImpl <em>Periodic Event Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PeriodicEventConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getPeriodicEventConstraint()
	 * @generated
	 */
	int PERIODIC_EVENT_CONSTRAINT = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__NAME = EVENT_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__BASE_NAMED_ELEMENT = EVENT_CONSTRAINT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__OWNED_COMMENT = EVENT_CONSTRAINT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__MODE = EVENT_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__UPPER = EVENT_CONSTRAINT__UPPER;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__LOWER = EVENT_CONSTRAINT__LOWER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__BASE_CLASS = EVENT_CONSTRAINT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__BASE_CONSTRAINT = EVENT_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__EVENT = EVENT_CONSTRAINT__EVENT;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__OFFSET = EVENT_CONSTRAINT__OFFSET;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__JITTER = EVENT_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Period</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__PERIOD = EVENT_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Minimum Inter Arrival Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME = EVENT_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Periodic Event Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERIODIC_EVENT_CONSTRAINT_FEATURE_COUNT = EVENT_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PatternEventConstraintImpl <em>Pattern Event Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.PatternEventConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getPatternEventConstraint()
	 * @generated
	 */
	int PATTERN_EVENT_CONSTRAINT = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__NAME = EVENT_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__BASE_NAMED_ELEMENT = EVENT_CONSTRAINT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__OWNED_COMMENT = EVENT_CONSTRAINT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__MODE = EVENT_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__UPPER = EVENT_CONSTRAINT__UPPER;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__LOWER = EVENT_CONSTRAINT__LOWER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__BASE_CLASS = EVENT_CONSTRAINT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__BASE_CONSTRAINT = EVENT_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__EVENT = EVENT_CONSTRAINT__EVENT;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__OFFSET = EVENT_CONSTRAINT__OFFSET;

	/**
	 * The feature id for the '<em><b>Period</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__PERIOD = EVENT_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Minimum Inter Arrival Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME = EVENT_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Occurence</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__OCCURENCE = EVENT_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Jitter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT__JITTER = EVENT_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Pattern Event Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PATTERN_EVENT_CONSTRAINT_FEATURE_COUNT = EVENT_CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.ArbitraryEventConstraintImpl <em>Arbitrary Event Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.ArbitraryEventConstraintImpl
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.impl.TimingconstraintsPackageImpl#getArbitraryEventConstraint()
	 * @generated
	 */
	int ARBITRARY_EVENT_CONSTRAINT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__NAME = EVENT_CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__BASE_NAMED_ELEMENT = EVENT_CONSTRAINT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__OWNED_COMMENT = EVENT_CONSTRAINT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__MODE = EVENT_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>Upper</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__UPPER = EVENT_CONSTRAINT__UPPER;

	/**
	 * The feature id for the '<em><b>Lower</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__LOWER = EVENT_CONSTRAINT__LOWER;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__BASE_CLASS = EVENT_CONSTRAINT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__BASE_CONSTRAINT = EVENT_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__EVENT = EVENT_CONSTRAINT__EVENT;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__OFFSET = EVENT_CONSTRAINT__OFFSET;

	/**
	 * The feature id for the '<em><b>Minimum Inter Arrival Time</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__MINIMUM_INTER_ARRIVAL_TIME = EVENT_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Maximum Inter Arrival Time</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT__MAXIMUM_INTER_ARRIVAL_TIME = EVENT_CONSTRAINT_FEATURE_COUNT + 1;


	/**
	 * The number of structural features of the '<em>Arbitrary Event Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARBITRARY_EVENT_CONSTRAINT_FEATURE_COUNT = EVENT_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.AgeTimingConstraint <em>Age Timing Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Age Timing Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.AgeTimingConstraint
	 * @generated
	 */
	EClass getAgeTimingConstraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint <em>Arbitrary Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arbitrary Event Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint
	 * @generated
	 */
	EClass getArbitraryEventConstraint();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint#getMaximumInterArrivalTime <em>Maximum Inter Arrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Maximum Inter Arrival Time</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint#getMaximumInterArrivalTime()
	 * @see #getArbitraryEventConstraint()
	 * @generated
	 */
	EReference getArbitraryEventConstraint_MaximumInterArrivalTime();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Minimum Inter Arrival Time</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.ArbitraryEventConstraint#getMinimumInterArrivalTime()
	 * @see #getArbitraryEventConstraint()
	 * @generated
	 */
	EReference getArbitraryEventConstraint_MinimumInterArrivalTime();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint <em>Delay Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delay Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint
	 * @generated
	 */
	EClass getDelayConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getJitter <em>Jitter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Jitter</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getJitter()
	 * @see #getDelayConstraint()
	 * @generated
	 */
	EReference getDelayConstraint_Jitter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getNominal <em>Nominal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Nominal</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getNominal()
	 * @see #getDelayConstraint()
	 * @generated
	 */
	EReference getDelayConstraint_Nominal();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scope</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.DelayConstraint#getScope()
	 * @see #getDelayConstraint()
	 * @generated
	 */
	EReference getDelayConstraint_Scope();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.EventConstraint <em>Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.EventConstraint
	 * @generated
	 */
	EClass getEventConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.EventConstraint#getEvent <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Event</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.EventConstraint#getEvent()
	 * @see #getEventConstraint()
	 * @generated
	 */
	EReference getEventConstraint_Event();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.EventConstraint#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Offset</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.EventConstraint#getOffset()
	 * @see #getEventConstraint()
	 * @generated
	 */
	EReference getEventConstraint_Offset();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.InputSynchronizationConstraint <em>Input Synchronization Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Synchronization Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.InputSynchronizationConstraint
	 * @generated
	 */
	EClass getInputSynchronizationConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.InputSynchronizationConstraint#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Width</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.InputSynchronizationConstraint#getWidth()
	 * @see #getInputSynchronizationConstraint()
	 * @generated
	 */
	EReference getInputSynchronizationConstraint_Width();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.OutputSynchronizationConstraint <em>Output Synchronization Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Synchronization Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.OutputSynchronizationConstraint
	 * @generated
	 */
	EClass getOutputSynchronizationConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.OutputSynchronizationConstraint#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Width</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.OutputSynchronizationConstraint#getWidth()
	 * @see #getOutputSynchronizationConstraint()
	 * @generated
	 */
	EReference getOutputSynchronizationConstraint_Width();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint <em>Pattern Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pattern Event Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint
	 * @generated
	 */
	EClass getPatternEventConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getJitter <em>Jitter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Jitter</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getJitter()
	 * @see #getPatternEventConstraint()
	 * @generated
	 */
	EReference getPatternEventConstraint_Jitter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Minimum Inter Arrival Time</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getMinimumInterArrivalTime()
	 * @see #getPatternEventConstraint()
	 * @generated
	 */
	EReference getPatternEventConstraint_MinimumInterArrivalTime();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getOccurence <em>Occurence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Occurence</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getOccurence()
	 * @see #getPatternEventConstraint()
	 * @generated
	 */
	EReference getPatternEventConstraint_Occurence();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Period</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.PatternEventConstraint#getPeriod()
	 * @see #getPatternEventConstraint()
	 * @generated
	 */
	EReference getPatternEventConstraint_Period();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint <em>Periodic Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Periodic Event Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint
	 * @generated
	 */
	EClass getPeriodicEventConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getJitter <em>Jitter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Jitter</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getJitter()
	 * @see #getPeriodicEventConstraint()
	 * @generated
	 */
	EReference getPeriodicEventConstraint_Jitter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Minimum Inter Arrival Time</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getMinimumInterArrivalTime()
	 * @see #getPeriodicEventConstraint()
	 * @generated
	 */
	EReference getPeriodicEventConstraint_MinimumInterArrivalTime();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Period</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.PeriodicEventConstraint#getPeriod()
	 * @see #getPeriodicEventConstraint()
	 * @generated
	 */
	EReference getPeriodicEventConstraint_Period();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.ReactionConstraint <em>Reaction Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reaction Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.ReactionConstraint
	 * @generated
	 */
	EClass getReactionConstraint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint <em>Sporadic Event Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sporadic Event Constraint</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint
	 * @generated
	 */
	EClass getSporadicEventConstraint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getJitter <em>Jitter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Jitter</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getJitter()
	 * @see #getSporadicEventConstraint()
	 * @generated
	 */
	EReference getSporadicEventConstraint_Jitter();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getMaximumInterArrivalTime <em>Maximum Inter Arrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Maximum Inter Arrival Time</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getMaximumInterArrivalTime()
	 * @see #getSporadicEventConstraint()
	 * @generated
	 */
	EReference getSporadicEventConstraint_MaximumInterArrivalTime();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getMinimumInterArrivalTime <em>Minimum Inter Arrival Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Minimum Inter Arrival Time</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getMinimumInterArrivalTime()
	 * @see #getSporadicEventConstraint()
	 * @generated
	 */
	EReference getSporadicEventConstraint_MinimumInterArrivalTime();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Period</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.timingconstraints.SporadicEventConstraint#getPeriod()
	 * @see #getSporadicEventConstraint()
	 * @generated
	 */
	EReference getSporadicEventConstraint_Period();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TimingconstraintsFactory getTimingconstraintsFactory();

} //TimingconstraintsPackage
