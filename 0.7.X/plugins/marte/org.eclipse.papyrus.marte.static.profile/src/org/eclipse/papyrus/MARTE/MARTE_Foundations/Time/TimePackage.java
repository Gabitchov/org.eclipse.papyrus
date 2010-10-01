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

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.MARTE.MARTE_Foundations.NFPs.NFPsPackage;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimeFactory
 * @model kind="package"
 * @generated
 */
public interface TimePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "Time";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/Time/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "Time";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TimePackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedDomainImpl <em>Timed Domain</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedDomainImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedDomain()
	 * @generated
	 */
	int TIMED_DOMAIN = 0;

	/**
	 * The feature id for the '<em><b>Base Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_DOMAIN__BASE_NAMESPACE = 0;

	/**
	 * The number of structural features of the '<em>Timed Domain</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_DOMAIN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockImpl <em>Clock</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getClock()
	 * @generated
	 */
	int CLOCK = 1;

	/**
	 * The feature id for the '<em><b>Standard</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK__STANDARD = 0;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK__BASE_INSTANCE_SPECIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK__TYPE = 2;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK__UNIT = 3;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK__BASE_PROPERTY = 4;

	/**
	 * The feature id for the '<em><b>Base Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK__BASE_EVENT = 5;

	/**
	 * The number of structural features of the '<em>Clock</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl <em>Clock Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getClockType()
	 * @generated
	 */
	int CLOCK_TYPE = 2;

	/**
	 * The feature id for the '<em><b>Nature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_TYPE__NATURE = 0;

	/**
	 * The feature id for the '<em><b>Unit Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_TYPE__UNIT_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Is Logical</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_TYPE__IS_LOGICAL = 2;

	/**
	 * The feature id for the '<em><b>Resol Attr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_TYPE__RESOL_ATTR = 3;

	/**
	 * The feature id for the '<em><b>Max Val Attr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_TYPE__MAX_VAL_ATTR = 4;

	/**
	 * The feature id for the '<em><b>Offset Attr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_TYPE__OFFSET_ATTR = 5;

	/**
	 * The feature id for the '<em><b>Get Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_TYPE__GET_TIME = 6;

	/**
	 * The feature id for the '<em><b>Set Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_TYPE__SET_TIME = 7;

	/**
	 * The feature id for the '<em><b>Index To Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_TYPE__INDEX_TO_VALUE = 8;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_TYPE__BASE_CLASS = 9;

	/**
	 * The number of structural features of the '<em>Clock Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_TYPE_FEATURE_COUNT = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedElementImpl <em>Timed Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedElementImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedElement()
	 * @generated
	 */
	int TIMED_ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ELEMENT__ON = 0;

	/**
	 * The number of structural features of the '<em>Timed Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_ELEMENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedValueSpecificationImpl <em>Timed Value Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedValueSpecificationImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedValueSpecification()
	 * @generated
	 */
	int TIMED_VALUE_SPECIFICATION = 4;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_VALUE_SPECIFICATION__ON = TIMED_ELEMENT__ON;

	/**
	 * The feature id for the '<em><b>Interpretation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_VALUE_SPECIFICATION__INTERPRETATION = TIMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Value Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_VALUE_SPECIFICATION__BASE_VALUE_SPECIFICATION = TIMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Timed Value Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_VALUE_SPECIFICATION_FEATURE_COUNT = TIMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedConstraintImpl <em>Timed Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedConstraintImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedConstraint()
	 * @generated
	 */
	int TIMED_CONSTRAINT = 5;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_CONSTRAINT__KIND = NFPsPackage.NFP_CONSTRAINT__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_CONSTRAINT__BASE_CONSTRAINT = NFPsPackage.NFP_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_CONSTRAINT__MODE = NFPsPackage.NFP_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_CONSTRAINT__ON = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Interpretation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_CONSTRAINT__INTERPRETATION = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Timed Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_CONSTRAINT_FEATURE_COUNT = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockConstraintImpl <em>Clock Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockConstraintImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getClockConstraint()
	 * @generated
	 */
	int CLOCK_CONSTRAINT = 6;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT__KIND = NFPsPackage.NFP_CONSTRAINT__KIND;

	/**
	 * The feature id for the '<em><b>Base Constraint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT__BASE_CONSTRAINT = NFPsPackage.NFP_CONSTRAINT__BASE_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Mode</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT__MODE = NFPsPackage.NFP_CONSTRAINT__MODE;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT__ON = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Coincidence Based</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT__IS_COINCIDENCE_BASED = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Precedence Based</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT__IS_PRECEDENCE_BASED = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Chronometric Based</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT__IS_CHRONOMETRIC_BASED = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Clock Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_CONSTRAINT_FEATURE_COUNT = NFPsPackage.NFP_CONSTRAINT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedInstantObservationImpl <em>Timed Instant Observation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedInstantObservationImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedInstantObservation()
	 * @generated
	 */
	int TIMED_INSTANT_OBSERVATION = 7;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_INSTANT_OBSERVATION__ON = TIMED_ELEMENT__ON;

	/**
	 * The feature id for the '<em><b>Obs Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_INSTANT_OBSERVATION__OBS_KIND = TIMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Time Observation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_INSTANT_OBSERVATION__BASE_TIME_OBSERVATION = TIMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Timed Instant Observation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_INSTANT_OBSERVATION_FEATURE_COUNT = TIMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedDurationObservationImpl <em>Timed Duration Observation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedDurationObservationImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedDurationObservation()
	 * @generated
	 */
	int TIMED_DURATION_OBSERVATION = 8;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_DURATION_OBSERVATION__ON = TIMED_ELEMENT__ON;

	/**
	 * The feature id for the '<em><b>Obs Kind</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_DURATION_OBSERVATION__OBS_KIND = TIMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Duration Observation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_DURATION_OBSERVATION__BASE_DURATION_OBSERVATION = TIMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Timed Duration Observation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_DURATION_OBSERVATION_FEATURE_COUNT = TIMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedEventImpl <em>Timed Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedEventImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedEvent()
	 * @generated
	 */
	int TIMED_EVENT = 9;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_EVENT__ON = TIMED_ELEMENT__ON;

	/**
	 * The feature id for the '<em><b>Repetition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_EVENT__REPETITION = TIMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Time Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_EVENT__BASE_TIME_EVENT = TIMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Every</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_EVENT__EVERY = TIMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Timed Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_EVENT_FEATURE_COUNT = TIMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedProcessingImpl <em>Timed Processing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedProcessingImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedProcessing()
	 * @generated
	 */
	int TIMED_PROCESSING = 10;

	/**
	 * The feature id for the '<em><b>On</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_PROCESSING__ON = TIMED_ELEMENT__ON;

	/**
	 * The feature id for the '<em><b>Base Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_PROCESSING__BASE_ACTION = TIMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_PROCESSING__BASE_BEHAVIOR = TIMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Message</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_PROCESSING__BASE_MESSAGE = TIMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_PROCESSING__DURATION = TIMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_PROCESSING__START = TIMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Finish</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_PROCESSING__FINISH = TIMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Timed Processing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMED_PROCESSING_FEATURE_COUNT = TIMED_ELEMENT_FEATURE_COUNT + 6;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedDomain <em>Timed Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Domain</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedDomain
	 * @generated
	 */
	EClass getTimedDomain();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedDomain#getBase_Namespace <em>Base Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Namespace</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedDomain#getBase_Namespace()
	 * @see #getTimedDomain()
	 * @generated
	 */
	EReference getTimedDomain_Base_Namespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock <em>Clock</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock
	 * @generated
	 */
	EClass getClock();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getStandard <em>Standard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Standard</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getStandard()
	 * @see #getClock()
	 * @generated
	 */
	EAttribute getClock_Standard();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getBase_InstanceSpecification()
	 * @see #getClock()
	 * @generated
	 */
	EReference getClock_Base_InstanceSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getType()
	 * @see #getClock()
	 * @generated
	 */
	EReference getClock_Type();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unit</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getUnit()
	 * @see #getClock()
	 * @generated
	 */
	EReference getClock_Unit();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getBase_Property()
	 * @see #getClock()
	 * @generated
	 */
	EReference getClock_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getBase_Event <em>Base Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Event</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.Clock#getBase_Event()
	 * @see #getClock()
	 * @generated
	 */
	EReference getClock_Base_Event();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType <em>Clock Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType
	 * @generated
	 */
	EClass getClockType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getNature <em>Nature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getNature()
	 * @see #getClockType()
	 * @generated
	 */
	EAttribute getClockType_Nature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getUnitType <em>Unit Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Unit Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getUnitType()
	 * @see #getClockType()
	 * @generated
	 */
	EReference getClockType_UnitType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#isIsLogical <em>Is Logical</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Logical</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#isIsLogical()
	 * @see #getClockType()
	 * @generated
	 */
	EAttribute getClockType_IsLogical();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getResolAttr <em>Resol Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resol Attr</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getResolAttr()
	 * @see #getClockType()
	 * @generated
	 */
	EReference getClockType_ResolAttr();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getMaxValAttr <em>Max Val Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Max Val Attr</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getMaxValAttr()
	 * @see #getClockType()
	 * @generated
	 */
	EReference getClockType_MaxValAttr();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getOffsetAttr <em>Offset Attr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Offset Attr</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getOffsetAttr()
	 * @see #getClockType()
	 * @generated
	 */
	EReference getClockType_OffsetAttr();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getGetTime <em>Get Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Get Time</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getGetTime()
	 * @see #getClockType()
	 * @generated
	 */
	EReference getClockType_GetTime();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getSetTime <em>Set Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Set Time</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getSetTime()
	 * @see #getClockType()
	 * @generated
	 */
	EReference getClockType_SetTime();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getIndexToValue <em>Index To Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Index To Value</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getIndexToValue()
	 * @see #getClockType()
	 * @generated
	 */
	EReference getClockType_IndexToValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockType#getBase_Class()
	 * @see #getClockType()
	 * @generated
	 */
	EReference getClockType_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedElement <em>Timed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Element</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedElement
	 * @generated
	 */
	EClass getTimedElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedElement#getOn <em>On</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedElement#getOn()
	 * @see #getTimedElement()
	 * @generated
	 */
	EReference getTimedElement_On();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedValueSpecification <em>Timed Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Value Specification</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedValueSpecification
	 * @generated
	 */
	EClass getTimedValueSpecification();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedValueSpecification#getInterpretation <em>Interpretation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interpretation</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedValueSpecification#getInterpretation()
	 * @see #getTimedValueSpecification()
	 * @generated
	 */
	EAttribute getTimedValueSpecification_Interpretation();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedValueSpecification#getBase_ValueSpecification <em>Base Value Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Value Specification</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedValueSpecification#getBase_ValueSpecification()
	 * @see #getTimedValueSpecification()
	 * @generated
	 */
	EReference getTimedValueSpecification_Base_ValueSpecification();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedConstraint <em>Timed Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Constraint</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedConstraint
	 * @generated
	 */
	EClass getTimedConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedConstraint#getInterpretation <em>Interpretation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interpretation</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedConstraint#getInterpretation()
	 * @see #getTimedConstraint()
	 * @generated
	 */
	EAttribute getTimedConstraint_Interpretation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint <em>Clock Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock Constraint</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint
	 * @generated
	 */
	EClass getClockConstraint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsCoincidenceBased <em>Is Coincidence Based</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Coincidence Based</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsCoincidenceBased()
	 * @see #getClockConstraint()
	 * @generated
	 */
	EAttribute getClockConstraint_IsCoincidenceBased();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsPrecedenceBased <em>Is Precedence Based</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Precedence Based</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsPrecedenceBased()
	 * @see #getClockConstraint()
	 * @generated
	 */
	EAttribute getClockConstraint_IsPrecedenceBased();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsChronometricBased <em>Is Chronometric Based</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Chronometric Based</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.ClockConstraint#isIsChronometricBased()
	 * @see #getClockConstraint()
	 * @generated
	 */
	EAttribute getClockConstraint_IsChronometricBased();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation <em>Timed Instant Observation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Instant Observation</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation
	 * @generated
	 */
	EClass getTimedInstantObservation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation#getObsKind <em>Obs Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Obs Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation#getObsKind()
	 * @see #getTimedInstantObservation()
	 * @generated
	 */
	EAttribute getTimedInstantObservation_ObsKind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation#getBase_TimeObservation <em>Base Time Observation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Time Observation</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedInstantObservation#getBase_TimeObservation()
	 * @see #getTimedInstantObservation()
	 * @generated
	 */
	EReference getTimedInstantObservation_Base_TimeObservation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedDurationObservation <em>Timed Duration Observation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Duration Observation</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedDurationObservation
	 * @generated
	 */
	EClass getTimedDurationObservation();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedDurationObservation#getObsKind <em>Obs Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Obs Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedDurationObservation#getObsKind()
	 * @see #getTimedDurationObservation()
	 * @generated
	 */
	EAttribute getTimedDurationObservation_ObsKind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedDurationObservation#getBase_DurationObservation <em>Base Duration Observation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Duration Observation</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedDurationObservation#getBase_DurationObservation()
	 * @see #getTimedDurationObservation()
	 * @generated
	 */
	EReference getTimedDurationObservation_Base_DurationObservation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedEvent <em>Timed Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Event</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedEvent
	 * @generated
	 */
	EClass getTimedEvent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedEvent#getRepetition <em>Repetition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Repetition</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedEvent#getRepetition()
	 * @see #getTimedEvent()
	 * @generated
	 */
	EAttribute getTimedEvent_Repetition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedEvent#getBase_TimeEvent <em>Base Time Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Time Event</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedEvent#getBase_TimeEvent()
	 * @see #getTimedEvent()
	 * @generated
	 */
	EReference getTimedEvent_Base_TimeEvent();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedEvent#getEvery <em>Every</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Every</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedEvent#getEvery()
	 * @see #getTimedEvent()
	 * @generated
	 */
	EReference getTimedEvent_Every();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing <em>Timed Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timed Processing</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing
	 * @generated
	 */
	EClass getTimedProcessing();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Action <em>Base Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Action</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Action()
	 * @see #getTimedProcessing()
	 * @generated
	 */
	EReference getTimedProcessing_Base_Action();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Behavior <em>Base Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Behavior()
	 * @see #getTimedProcessing()
	 * @generated
	 */
	EReference getTimedProcessing_Base_Behavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Message <em>Base Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Message</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getBase_Message()
	 * @see #getTimedProcessing()
	 * @generated
	 */
	EReference getTimedProcessing_Base_Message();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Duration</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getDuration()
	 * @see #getTimedProcessing()
	 * @generated
	 */
	EReference getTimedProcessing_Duration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getStart()
	 * @see #getTimedProcessing()
	 * @generated
	 */
	EReference getTimedProcessing_Start();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getFinish <em>Finish</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Finish</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.TimedProcessing#getFinish()
	 * @see #getTimedProcessing()
	 * @generated
	 */
	EReference getTimedProcessing_Finish();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	TimeFactory getTimeFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedDomainImpl <em>Timed Domain</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedDomainImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedDomain()
		 * @generated
		 */
		EClass TIMED_DOMAIN = eINSTANCE.getTimedDomain();

		/**
		 * The meta object literal for the '<em><b>Base Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_DOMAIN__BASE_NAMESPACE = eINSTANCE.getTimedDomain_Base_Namespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockImpl <em>Clock</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getClock()
		 * @generated
		 */
		EClass CLOCK = eINSTANCE.getClock();

		/**
		 * The meta object literal for the '<em><b>Standard</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOCK__STANDARD = eINSTANCE.getClock_Standard();

		/**
		 * The meta object literal for the '<em><b>Base Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getClock_Base_InstanceSpecification();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK__TYPE = eINSTANCE.getClock_Type();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK__UNIT = eINSTANCE.getClock_Unit();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK__BASE_PROPERTY = eINSTANCE.getClock_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Base Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK__BASE_EVENT = eINSTANCE.getClock_Base_Event();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl <em>Clock Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockTypeImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getClockType()
		 * @generated
		 */
		EClass CLOCK_TYPE = eINSTANCE.getClockType();

		/**
		 * The meta object literal for the '<em><b>Nature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOCK_TYPE__NATURE = eINSTANCE.getClockType_Nature();

		/**
		 * The meta object literal for the '<em><b>Unit Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_TYPE__UNIT_TYPE = eINSTANCE.getClockType_UnitType();

		/**
		 * The meta object literal for the '<em><b>Is Logical</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOCK_TYPE__IS_LOGICAL = eINSTANCE.getClockType_IsLogical();

		/**
		 * The meta object literal for the '<em><b>Resol Attr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_TYPE__RESOL_ATTR = eINSTANCE.getClockType_ResolAttr();

		/**
		 * The meta object literal for the '<em><b>Max Val Attr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_TYPE__MAX_VAL_ATTR = eINSTANCE.getClockType_MaxValAttr();

		/**
		 * The meta object literal for the '<em><b>Offset Attr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_TYPE__OFFSET_ATTR = eINSTANCE.getClockType_OffsetAttr();

		/**
		 * The meta object literal for the '<em><b>Get Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_TYPE__GET_TIME = eINSTANCE.getClockType_GetTime();

		/**
		 * The meta object literal for the '<em><b>Set Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_TYPE__SET_TIME = eINSTANCE.getClockType_SetTime();

		/**
		 * The meta object literal for the '<em><b>Index To Value</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_TYPE__INDEX_TO_VALUE = eINSTANCE.getClockType_IndexToValue();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLOCK_TYPE__BASE_CLASS = eINSTANCE.getClockType_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedElementImpl <em>Timed Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedElementImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedElement()
		 * @generated
		 */
		EClass TIMED_ELEMENT = eINSTANCE.getTimedElement();

		/**
		 * The meta object literal for the '<em><b>On</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_ELEMENT__ON = eINSTANCE.getTimedElement_On();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedValueSpecificationImpl <em>Timed Value Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedValueSpecificationImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedValueSpecification()
		 * @generated
		 */
		EClass TIMED_VALUE_SPECIFICATION = eINSTANCE.getTimedValueSpecification();

		/**
		 * The meta object literal for the '<em><b>Interpretation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMED_VALUE_SPECIFICATION__INTERPRETATION = eINSTANCE.getTimedValueSpecification_Interpretation();

		/**
		 * The meta object literal for the '<em><b>Base Value Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_VALUE_SPECIFICATION__BASE_VALUE_SPECIFICATION = eINSTANCE.getTimedValueSpecification_Base_ValueSpecification();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedConstraintImpl <em>Timed Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedConstraintImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedConstraint()
		 * @generated
		 */
		EClass TIMED_CONSTRAINT = eINSTANCE.getTimedConstraint();

		/**
		 * The meta object literal for the '<em><b>Interpretation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMED_CONSTRAINT__INTERPRETATION = eINSTANCE.getTimedConstraint_Interpretation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockConstraintImpl <em>Clock Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.ClockConstraintImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getClockConstraint()
		 * @generated
		 */
		EClass CLOCK_CONSTRAINT = eINSTANCE.getClockConstraint();

		/**
		 * The meta object literal for the '<em><b>Is Coincidence Based</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOCK_CONSTRAINT__IS_COINCIDENCE_BASED = eINSTANCE.getClockConstraint_IsCoincidenceBased();

		/**
		 * The meta object literal for the '<em><b>Is Precedence Based</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOCK_CONSTRAINT__IS_PRECEDENCE_BASED = eINSTANCE.getClockConstraint_IsPrecedenceBased();

		/**
		 * The meta object literal for the '<em><b>Is Chronometric Based</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLOCK_CONSTRAINT__IS_CHRONOMETRIC_BASED = eINSTANCE.getClockConstraint_IsChronometricBased();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedInstantObservationImpl <em>Timed Instant Observation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedInstantObservationImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedInstantObservation()
		 * @generated
		 */
		EClass TIMED_INSTANT_OBSERVATION = eINSTANCE.getTimedInstantObservation();

		/**
		 * The meta object literal for the '<em><b>Obs Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMED_INSTANT_OBSERVATION__OBS_KIND = eINSTANCE.getTimedInstantObservation_ObsKind();

		/**
		 * The meta object literal for the '<em><b>Base Time Observation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_INSTANT_OBSERVATION__BASE_TIME_OBSERVATION = eINSTANCE.getTimedInstantObservation_Base_TimeObservation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedDurationObservationImpl <em>Timed Duration Observation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedDurationObservationImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedDurationObservation()
		 * @generated
		 */
		EClass TIMED_DURATION_OBSERVATION = eINSTANCE.getTimedDurationObservation();

		/**
		 * The meta object literal for the '<em><b>Obs Kind</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMED_DURATION_OBSERVATION__OBS_KIND = eINSTANCE.getTimedDurationObservation_ObsKind();

		/**
		 * The meta object literal for the '<em><b>Base Duration Observation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_DURATION_OBSERVATION__BASE_DURATION_OBSERVATION = eINSTANCE.getTimedDurationObservation_Base_DurationObservation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedEventImpl <em>Timed Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedEventImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedEvent()
		 * @generated
		 */
		EClass TIMED_EVENT = eINSTANCE.getTimedEvent();

		/**
		 * The meta object literal for the '<em><b>Repetition</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMED_EVENT__REPETITION = eINSTANCE.getTimedEvent_Repetition();

		/**
		 * The meta object literal for the '<em><b>Base Time Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_EVENT__BASE_TIME_EVENT = eINSTANCE.getTimedEvent_Base_TimeEvent();

		/**
		 * The meta object literal for the '<em><b>Every</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_EVENT__EVERY = eINSTANCE.getTimedEvent_Every();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedProcessingImpl <em>Timed Processing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimedProcessingImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.Time.impl.TimePackageImpl#getTimedProcessing()
		 * @generated
		 */
		EClass TIMED_PROCESSING = eINSTANCE.getTimedProcessing();

		/**
		 * The meta object literal for the '<em><b>Base Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_PROCESSING__BASE_ACTION = eINSTANCE.getTimedProcessing_Base_Action();

		/**
		 * The meta object literal for the '<em><b>Base Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_PROCESSING__BASE_BEHAVIOR = eINSTANCE.getTimedProcessing_Base_Behavior();

		/**
		 * The meta object literal for the '<em><b>Base Message</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_PROCESSING__BASE_MESSAGE = eINSTANCE.getTimedProcessing_Base_Message();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_PROCESSING__DURATION = eINSTANCE.getTimedProcessing_Duration();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_PROCESSING__START = eINSTANCE.getTimedProcessing_Start();

		/**
		 * The meta object literal for the '<em><b>Finish</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TIMED_PROCESSING__FINISH = eINSTANCE.getTimedProcessing_Finish();

	}

} //TimePackage
