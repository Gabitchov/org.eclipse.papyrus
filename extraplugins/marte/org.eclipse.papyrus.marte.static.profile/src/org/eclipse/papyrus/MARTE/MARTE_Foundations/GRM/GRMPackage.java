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
package org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMFactory
 * @model kind="package"
 * @generated
 */
public interface GRMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "GRM";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/GRM/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "GRM";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GRMPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__RES_MULT = 0;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__IS_PROTECTED = 1;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__IS_ACTIVE = 2;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_PROPERTY = 3;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_INSTANCE_SPECIFICATION = 4;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_CLASSIFIER = 5;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_LIFELINE = 6;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__BASE_CONNECTABLE_ELEMENT = 7;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.StorageResourceImpl <em>Storage Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.StorageResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getStorageResource()
	 * @generated
	 */
	int STORAGE_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_RESOURCE__RES_MULT = RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_RESOURCE__IS_PROTECTED = RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_RESOURCE__IS_ACTIVE = RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_RESOURCE__BASE_PROPERTY = RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_RESOURCE__BASE_INSTANCE_SPECIFICATION = RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_RESOURCE__BASE_CLASSIFIER = RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_RESOURCE__BASE_LIFELINE = RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_RESOURCE__BASE_CONNECTABLE_ELEMENT = RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Element Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_RESOURCE__ELEMENT_SIZE = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Storage Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STORAGE_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.CommunicationEndPointImpl <em>Communication End Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.CommunicationEndPointImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getCommunicationEndPoint()
	 * @generated
	 */
	int COMMUNICATION_END_POINT = 2;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_END_POINT__RES_MULT = RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_END_POINT__IS_PROTECTED = RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_END_POINT__IS_ACTIVE = RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_END_POINT__BASE_PROPERTY = RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_END_POINT__BASE_INSTANCE_SPECIFICATION = RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_END_POINT__BASE_CLASSIFIER = RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_END_POINT__BASE_LIFELINE = RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_END_POINT__BASE_CONNECTABLE_ELEMENT = RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Packet Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_END_POINT__PACKET_SIZE = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Communication End Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_END_POINT_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SynchronizationResourceImpl <em>Synchronization Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SynchronizationResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getSynchronizationResource()
	 * @generated
	 */
	int SYNCHRONIZATION_RESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESOURCE__RES_MULT = RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESOURCE__IS_PROTECTED = RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESOURCE__IS_ACTIVE = RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESOURCE__BASE_PROPERTY = RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESOURCE__BASE_INSTANCE_SPECIFICATION = RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESOURCE__BASE_CLASSIFIER = RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESOURCE__BASE_LIFELINE = RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESOURCE__BASE_CONNECTABLE_ELEMENT = RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The number of structural features of the '<em>Synchronization Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYNCHRONIZATION_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ConcurrencyResourceImpl <em>Concurrency Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ConcurrencyResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getConcurrencyResource()
	 * @generated
	 */
	int CONCURRENCY_RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENCY_RESOURCE__RES_MULT = RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENCY_RESOURCE__IS_PROTECTED = RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENCY_RESOURCE__IS_ACTIVE = RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENCY_RESOURCE__BASE_PROPERTY = RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENCY_RESOURCE__BASE_INSTANCE_SPECIFICATION = RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENCY_RESOURCE__BASE_CLASSIFIER = RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENCY_RESOURCE__BASE_LIFELINE = RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENCY_RESOURCE__BASE_CONNECTABLE_ELEMENT = RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The number of structural features of the '<em>Concurrency Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONCURRENCY_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl <em>Scheduler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getScheduler()
	 * @generated
	 */
	int SCHEDULER = 5;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__RES_MULT = RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__IS_PROTECTED = RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__IS_ACTIVE = RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__BASE_PROPERTY = RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__BASE_INSTANCE_SPECIFICATION = RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__BASE_CLASSIFIER = RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__BASE_LIFELINE = RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__BASE_CONNECTABLE_ELEMENT = RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Is Preemptible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__IS_PREEMPTIBLE = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__SCHED_POLICY = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Other Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__OTHER_SCHED_POLICY = RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__SCHEDULE = RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Processing Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__PROCESSING_UNITS = RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__HOST = RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Protected Shared Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__PROTECTED_SHARED_RESOURCES = RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Schedulable Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER__SCHEDULABLE_RESOURCES = RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Scheduler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ProcessingResourceImpl <em>Processing Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ProcessingResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getProcessingResource()
	 * @generated
	 */
	int PROCESSING_RESOURCE = 6;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__RES_MULT = RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__IS_PROTECTED = RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__IS_ACTIVE = RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__BASE_PROPERTY = RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__BASE_INSTANCE_SPECIFICATION = RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__BASE_CLASSIFIER = RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__BASE_LIFELINE = RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__BASE_CONNECTABLE_ELEMENT = RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__SPEED_FACTOR = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__MAIN_SCHEDULER = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Processing Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ComputingResourceImpl <em>Computing Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ComputingResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getComputingResource()
	 * @generated
	 */
	int COMPUTING_RESOURCE = 7;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTING_RESOURCE__RES_MULT = PROCESSING_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTING_RESOURCE__IS_PROTECTED = PROCESSING_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTING_RESOURCE__IS_ACTIVE = PROCESSING_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTING_RESOURCE__BASE_PROPERTY = PROCESSING_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTING_RESOURCE__BASE_INSTANCE_SPECIFICATION = PROCESSING_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTING_RESOURCE__BASE_CLASSIFIER = PROCESSING_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTING_RESOURCE__BASE_LIFELINE = PROCESSING_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTING_RESOURCE__BASE_CONNECTABLE_ELEMENT = PROCESSING_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTING_RESOURCE__SPEED_FACTOR = PROCESSING_RESOURCE__SPEED_FACTOR;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTING_RESOURCE__MAIN_SCHEDULER = PROCESSING_RESOURCE__MAIN_SCHEDULER;

	/**
	 * The number of structural features of the '<em>Computing Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTING_RESOURCE_FEATURE_COUNT = PROCESSING_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.MutualExclusionResourceImpl <em>Mutual Exclusion Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.MutualExclusionResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getMutualExclusionResource()
	 * @generated
	 */
	int MUTUAL_EXCLUSION_RESOURCE = 8;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__RES_MULT = RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__IS_PROTECTED = RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__IS_ACTIVE = RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__BASE_PROPERTY = RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__BASE_INSTANCE_SPECIFICATION = RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__BASE_CLASSIFIER = RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__BASE_LIFELINE = RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__BASE_CONNECTABLE_ELEMENT = RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Protect Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ceiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__CEILING = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Other Protect Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL = RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE__SCHEDULER = RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Mutual Exclusion Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MUTUAL_EXCLUSION_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulableResourceImpl <em>Schedulable Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulableResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getSchedulableResource()
	 * @generated
	 */
	int SCHEDULABLE_RESOURCE = 9;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE__RES_MULT = RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE__IS_PROTECTED = RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE__IS_ACTIVE = RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE__BASE_PROPERTY = RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE__BASE_INSTANCE_SPECIFICATION = RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE__BASE_CLASSIFIER = RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE__BASE_LIFELINE = RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE__BASE_CONNECTABLE_ELEMENT = RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Sched Params</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE__SCHED_PARAMS = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependent Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE__DEPENDENT_SCHEDULER = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE__HOST = RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Schedulable Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULABLE_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SecondarySchedulerImpl <em>Secondary Scheduler</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SecondarySchedulerImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getSecondaryScheduler()
	 * @generated
	 */
	int SECONDARY_SCHEDULER = 10;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__RES_MULT = SCHEDULER__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__IS_PROTECTED = SCHEDULER__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__IS_ACTIVE = SCHEDULER__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__BASE_PROPERTY = SCHEDULER__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__BASE_INSTANCE_SPECIFICATION = SCHEDULER__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__BASE_CLASSIFIER = SCHEDULER__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__BASE_LIFELINE = SCHEDULER__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__BASE_CONNECTABLE_ELEMENT = SCHEDULER__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Is Preemptible</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__IS_PREEMPTIBLE = SCHEDULER__IS_PREEMPTIBLE;

	/**
	 * The feature id for the '<em><b>Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__SCHED_POLICY = SCHEDULER__SCHED_POLICY;

	/**
	 * The feature id for the '<em><b>Other Sched Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__OTHER_SCHED_POLICY = SCHEDULER__OTHER_SCHED_POLICY;

	/**
	 * The feature id for the '<em><b>Schedule</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__SCHEDULE = SCHEDULER__SCHEDULE;

	/**
	 * The feature id for the '<em><b>Processing Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__PROCESSING_UNITS = SCHEDULER__PROCESSING_UNITS;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__HOST = SCHEDULER__HOST;

	/**
	 * The feature id for the '<em><b>Protected Shared Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__PROTECTED_SHARED_RESOURCES = SCHEDULER__PROTECTED_SHARED_RESOURCES;

	/**
	 * The feature id for the '<em><b>Schedulable Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__SCHEDULABLE_RESOURCES = SCHEDULER__SCHEDULABLE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Virtual Processing Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER__VIRTUAL_PROCESSING_UNITS = SCHEDULER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Secondary Scheduler</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SECONDARY_SCHEDULER_FEATURE_COUNT = SCHEDULER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.CommunicationMediaImpl <em>Communication Media</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.CommunicationMediaImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getCommunicationMedia()
	 * @generated
	 */
	int COMMUNICATION_MEDIA = 11;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__RES_MULT = PROCESSING_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__IS_PROTECTED = PROCESSING_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__IS_ACTIVE = PROCESSING_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__BASE_PROPERTY = PROCESSING_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__BASE_INSTANCE_SPECIFICATION = PROCESSING_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__BASE_CLASSIFIER = PROCESSING_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__BASE_LIFELINE = PROCESSING_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__BASE_CONNECTABLE_ELEMENT = PROCESSING_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__SPEED_FACTOR = PROCESSING_RESOURCE__SPEED_FACTOR;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__MAIN_SCHEDULER = PROCESSING_RESOURCE__MAIN_SCHEDULER;

	/**
	 * The feature id for the '<em><b>Element Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__ELEMENT_SIZE = PROCESSING_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__BASE_CONNECTOR = PROCESSING_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Transm Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__TRANSM_MODE = PROCESSING_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__BLOCK_T = PROCESSING_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Packet T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__PACKET_T = PROCESSING_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA__CAPACITY = PROCESSING_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Communication Media</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_MEDIA_FEATURE_COUNT = PROCESSING_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.DeviceResourceImpl <em>Device Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.DeviceResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getDeviceResource()
	 * @generated
	 */
	int DEVICE_RESOURCE = 12;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE__RES_MULT = PROCESSING_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE__IS_PROTECTED = PROCESSING_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE__IS_ACTIVE = PROCESSING_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE__BASE_PROPERTY = PROCESSING_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE__BASE_INSTANCE_SPECIFICATION = PROCESSING_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE__BASE_CLASSIFIER = PROCESSING_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE__BASE_LIFELINE = PROCESSING_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE__BASE_CONNECTABLE_ELEMENT = PROCESSING_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE__SPEED_FACTOR = PROCESSING_RESOURCE__SPEED_FACTOR;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE__MAIN_SCHEDULER = PROCESSING_RESOURCE__MAIN_SCHEDULER;

	/**
	 * The number of structural features of the '<em>Device Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_RESOURCE_FEATURE_COUNT = PROCESSING_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.TimingResourceImpl <em>Timing Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.TimingResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getTimingResource()
	 * @generated
	 */
	int TIMING_RESOURCE = 13;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_RESOURCE__RES_MULT = RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_RESOURCE__IS_PROTECTED = RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_RESOURCE__IS_ACTIVE = RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_RESOURCE__BASE_PROPERTY = RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_RESOURCE__BASE_INSTANCE_SPECIFICATION = RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_RESOURCE__BASE_CLASSIFIER = RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_RESOURCE__BASE_LIFELINE = RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_RESOURCE__BASE_CONNECTABLE_ELEMENT = RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The number of structural features of the '<em>Timing Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMING_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ClockResourceImpl <em>Clock Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ClockResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getClockResource()
	 * @generated
	 */
	int CLOCK_RESOURCE = 14;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESOURCE__RES_MULT = TIMING_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESOURCE__IS_PROTECTED = TIMING_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESOURCE__IS_ACTIVE = TIMING_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESOURCE__BASE_PROPERTY = TIMING_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESOURCE__BASE_INSTANCE_SPECIFICATION = TIMING_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESOURCE__BASE_CLASSIFIER = TIMING_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESOURCE__BASE_LIFELINE = TIMING_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESOURCE__BASE_CONNECTABLE_ELEMENT = TIMING_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The number of structural features of the '<em>Clock Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOCK_RESOURCE_FEATURE_COUNT = TIMING_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.TimerResourceImpl <em>Timer Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.TimerResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getTimerResource()
	 * @generated
	 */
	int TIMER_RESOURCE = 15;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_RESOURCE__RES_MULT = TIMING_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_RESOURCE__IS_PROTECTED = TIMING_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_RESOURCE__IS_ACTIVE = TIMING_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_RESOURCE__BASE_PROPERTY = TIMING_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_RESOURCE__BASE_INSTANCE_SPECIFICATION = TIMING_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_RESOURCE__BASE_CLASSIFIER = TIMING_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_RESOURCE__BASE_LIFELINE = TIMING_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_RESOURCE__BASE_CONNECTABLE_ELEMENT = TIMING_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_RESOURCE__DURATION = TIMING_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Periodic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_RESOURCE__IS_PERIODIC = TIMING_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Timer Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIMER_RESOURCE_FEATURE_COUNT = TIMING_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl <em>Gr Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getGrService()
	 * @generated
	 */
	int GR_SERVICE = 16;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GR_SERVICE__OWNER = 0;

	/**
	 * The feature id for the '<em><b>Base Execution Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GR_SERVICE__BASE_EXECUTION_SPECIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GR_SERVICE__BASE_BEHAVIORAL_FEATURE = 2;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GR_SERVICE__BASE_BEHAVIOR = 3;

	/**
	 * The feature id for the '<em><b>Base Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GR_SERVICE__BASE_COLLABORATION = 4;

	/**
	 * The feature id for the '<em><b>Base Collaboration Use</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GR_SERVICE__BASE_COLLABORATION_USE = 5;

	/**
	 * The number of structural features of the '<em>Gr Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GR_SERVICE_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ReleaseImpl <em>Release</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ReleaseImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getRelease()
	 * @generated
	 */
	int RELEASE = 17;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__OWNER = GR_SERVICE__OWNER;

	/**
	 * The feature id for the '<em><b>Base Execution Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__BASE_EXECUTION_SPECIFICATION = GR_SERVICE__BASE_EXECUTION_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__BASE_BEHAVIORAL_FEATURE = GR_SERVICE__BASE_BEHAVIORAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__BASE_BEHAVIOR = GR_SERVICE__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__BASE_COLLABORATION = GR_SERVICE__BASE_COLLABORATION;

	/**
	 * The feature id for the '<em><b>Base Collaboration Use</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE__BASE_COLLABORATION_USE = GR_SERVICE__BASE_COLLABORATION_USE;

	/**
	 * The number of structural features of the '<em>Release</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_FEATURE_COUNT = GR_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.AcquireImpl <em>Acquire</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.AcquireImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getAcquire()
	 * @generated
	 */
	int ACQUIRE = 18;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE__OWNER = GR_SERVICE__OWNER;

	/**
	 * The feature id for the '<em><b>Base Execution Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE__BASE_EXECUTION_SPECIFICATION = GR_SERVICE__BASE_EXECUTION_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE__BASE_BEHAVIORAL_FEATURE = GR_SERVICE__BASE_BEHAVIORAL_FEATURE;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE__BASE_BEHAVIOR = GR_SERVICE__BASE_BEHAVIOR;

	/**
	 * The feature id for the '<em><b>Base Collaboration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE__BASE_COLLABORATION = GR_SERVICE__BASE_COLLABORATION;

	/**
	 * The feature id for the '<em><b>Base Collaboration Use</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE__BASE_COLLABORATION_USE = GR_SERVICE__BASE_COLLABORATION_USE;

	/**
	 * The feature id for the '<em><b>Is Blocking</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE__IS_BLOCKING = GR_SERVICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Acquire</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_FEATURE_COUNT = GR_SERVICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ResourceUsageImpl <em>Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ResourceUsageImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getResourceUsage()
	 * @generated
	 */
	int RESOURCE_USAGE = 19;

	/**
	 * The feature id for the '<em><b>Exec Time</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__EXEC_TIME = 0;

	/**
	 * The feature id for the '<em><b>Allocated Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__ALLOCATED_MEMORY = 1;

	/**
	 * The feature id for the '<em><b>Used Memory</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__USED_MEMORY = 2;

	/**
	 * The feature id for the '<em><b>Power Peak</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__POWER_PEAK = 3;

	/**
	 * The feature id for the '<em><b>Energy</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__ENERGY = 4;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__BASE_NAMED_ELEMENT = 5;

	/**
	 * The feature id for the '<em><b>Sub Usage</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__SUB_USAGE = 6;

	/**
	 * The feature id for the '<em><b>Used Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__USED_RESOURCES = 7;

	/**
	 * The feature id for the '<em><b>Msg Size</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__MSG_SIZE = 8;

	/**
	 * The number of structural features of the '<em>Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE_FEATURE_COUNT = 9;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getResMult <em>Res Mult</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Res Mult</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getResMult()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_ResMult();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#isIsProtected <em>Is Protected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Protected</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#isIsProtected()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_IsProtected();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#isIsActive <em>Is Active</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Active</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#isIsActive()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_IsActive();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Property()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_InstanceSpecification <em>Base Instance Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Instance Specification</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_InstanceSpecification()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Base_InstanceSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Classifier <em>Base Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Classifier</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Classifier()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Base_Classifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Lifeline <em>Base Lifeline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Lifeline</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_Lifeline()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Base_Lifeline();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_ConnectableElement <em>Base Connectable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connectable Element</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Resource#getBase_ConnectableElement()
	 * @see #getResource()
	 * @generated
	 */
	EReference getResource_Base_ConnectableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.StorageResource <em>Storage Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Storage Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.StorageResource
	 * @generated
	 */
	EClass getStorageResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.StorageResource#getElementSize <em>Element Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.StorageResource#getElementSize()
	 * @see #getStorageResource()
	 * @generated
	 */
	EAttribute getStorageResource_ElementSize();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationEndPoint <em>Communication End Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication End Point</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationEndPoint
	 * @generated
	 */
	EClass getCommunicationEndPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationEndPoint#getPacketSize <em>Packet Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Packet Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationEndPoint#getPacketSize()
	 * @see #getCommunicationEndPoint()
	 * @generated
	 */
	EAttribute getCommunicationEndPoint_PacketSize();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SynchronizationResource <em>Synchronization Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Synchronization Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SynchronizationResource
	 * @generated
	 */
	EClass getSynchronizationResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ConcurrencyResource <em>Concurrency Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Concurrency Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ConcurrencyResource
	 * @generated
	 */
	EClass getConcurrencyResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler <em>Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduler</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler
	 * @generated
	 */
	EClass getScheduler();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#isIsPreemptible <em>Is Preemptible</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Preemptible</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#isIsPreemptible()
	 * @see #getScheduler()
	 * @generated
	 */
	EAttribute getScheduler_IsPreemptible();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedPolicy <em>Sched Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sched Policy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedPolicy()
	 * @see #getScheduler()
	 * @generated
	 */
	EAttribute getScheduler_SchedPolicy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getOtherSchedPolicy <em>Other Sched Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Other Sched Policy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getOtherSchedPolicy()
	 * @see #getScheduler()
	 * @generated
	 */
	EAttribute getScheduler_OtherSchedPolicy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedule <em>Schedule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Schedule</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedule()
	 * @see #getScheduler()
	 * @generated
	 */
	EAttribute getScheduler_Schedule();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getProcessingUnits <em>Processing Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Processing Units</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getProcessingUnits()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_ProcessingUnits();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Host</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getHost()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_Host();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getProtectedSharedResources <em>Protected Shared Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Protected Shared Resources</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getProtectedSharedResources()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_ProtectedSharedResources();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedulableResources <em>Schedulable Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Schedulable Resources</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Scheduler#getSchedulableResources()
	 * @see #getScheduler()
	 * @generated
	 */
	EReference getScheduler_SchedulableResources();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource <em>Processing Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource
	 * @generated
	 */
	EClass getProcessingResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource#getSpeedFactor <em>Speed Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Speed Factor</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource#getSpeedFactor()
	 * @see #getProcessingResource()
	 * @generated
	 */
	EAttribute getProcessingResource_SpeedFactor();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource#getMainScheduler <em>Main Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Main Scheduler</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ProcessingResource#getMainScheduler()
	 * @see #getProcessingResource()
	 * @generated
	 */
	EReference getProcessingResource_MainScheduler();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ComputingResource <em>Computing Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computing Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ComputingResource
	 * @generated
	 */
	EClass getComputingResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource <em>Mutual Exclusion Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mutual Exclusion Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource
	 * @generated
	 */
	EClass getMutualExclusionResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getProtectKind <em>Protect Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Protect Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getProtectKind()
	 * @see #getMutualExclusionResource()
	 * @generated
	 */
	EAttribute getMutualExclusionResource_ProtectKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getCeiling <em>Ceiling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ceiling</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getCeiling()
	 * @see #getMutualExclusionResource()
	 * @generated
	 */
	EAttribute getMutualExclusionResource_Ceiling();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getOtherProtectProtocol <em>Other Protect Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Other Protect Protocol</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getOtherProtectProtocol()
	 * @see #getMutualExclusionResource()
	 * @generated
	 */
	EAttribute getMutualExclusionResource_OtherProtectProtocol();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getScheduler <em>Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Scheduler</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.MutualExclusionResource#getScheduler()
	 * @see #getMutualExclusionResource()
	 * @generated
	 */
	EReference getMutualExclusionResource_Scheduler();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource <em>Schedulable Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Schedulable Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource
	 * @generated
	 */
	EClass getSchedulableResource();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getSchedParams <em>Sched Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Sched Params</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getSchedParams()
	 * @see #getSchedulableResource()
	 * @generated
	 */
	EAttribute getSchedulableResource_SchedParams();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getDependentScheduler <em>Dependent Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Dependent Scheduler</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getDependentScheduler()
	 * @see #getSchedulableResource()
	 * @generated
	 */
	EReference getSchedulableResource_DependentScheduler();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getHost <em>Host</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Host</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SchedulableResource#getHost()
	 * @see #getSchedulableResource()
	 * @generated
	 */
	EReference getSchedulableResource_Host();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SecondaryScheduler <em>Secondary Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Secondary Scheduler</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SecondaryScheduler
	 * @generated
	 */
	EClass getSecondaryScheduler();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SecondaryScheduler#getVirtualProcessingUnits <em>Virtual Processing Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Virtual Processing Units</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.SecondaryScheduler#getVirtualProcessingUnits()
	 * @see #getSecondaryScheduler()
	 * @generated
	 */
	EReference getSecondaryScheduler_VirtualProcessingUnits();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia <em>Communication Media</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Media</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia
	 * @generated
	 */
	EClass getCommunicationMedia();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getElementSize <em>Element Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Element Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getElementSize()
	 * @see #getCommunicationMedia()
	 * @generated
	 */
	EAttribute getCommunicationMedia_ElementSize();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getBase_Connector()
	 * @see #getCommunicationMedia()
	 * @generated
	 */
	EReference getCommunicationMedia_Base_Connector();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getTransmMode <em>Transm Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transm Mode</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getTransmMode()
	 * @see #getCommunicationMedia()
	 * @generated
	 */
	EAttribute getCommunicationMedia_TransmMode();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getBlockT <em>Block T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Block T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getBlockT()
	 * @see #getCommunicationMedia()
	 * @generated
	 */
	EAttribute getCommunicationMedia_BlockT();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getPacketT <em>Packet T</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Packet T</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getPacketT()
	 * @see #getCommunicationMedia()
	 * @generated
	 */
	EAttribute getCommunicationMedia_PacketT();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Capacity</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.CommunicationMedia#getCapacity()
	 * @see #getCommunicationMedia()
	 * @generated
	 */
	EAttribute getCommunicationMedia_Capacity();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.DeviceResource <em>Device Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.DeviceResource
	 * @generated
	 */
	EClass getDeviceResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.TimingResource <em>Timing Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timing Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.TimingResource
	 * @generated
	 */
	EClass getTimingResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ClockResource <em>Clock Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Clock Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ClockResource
	 * @generated
	 */
	EClass getClockResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.TimerResource <em>Timer Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Timer Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.TimerResource
	 * @generated
	 */
	EClass getTimerResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.TimerResource#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.TimerResource#getDuration()
	 * @see #getTimerResource()
	 * @generated
	 */
	EAttribute getTimerResource_Duration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.TimerResource#isIsPeriodic <em>Is Periodic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Periodic</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.TimerResource#isIsPeriodic()
	 * @see #getTimerResource()
	 * @generated
	 */
	EAttribute getTimerResource_IsPeriodic();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService <em>Gr Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Gr Service</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService
	 * @generated
	 */
	EClass getGrService();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Owner</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getOwner()
	 * @see #getGrService()
	 * @generated
	 */
	EReference getGrService_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getBase_ExecutionSpecification <em>Base Execution Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Execution Specification</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getBase_ExecutionSpecification()
	 * @see #getGrService()
	 * @generated
	 */
	EReference getGrService_Base_ExecutionSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavioral Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getBase_BehavioralFeature()
	 * @see #getGrService()
	 * @generated
	 */
	EReference getGrService_Base_BehavioralFeature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getBase_Behavior <em>Base Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getBase_Behavior()
	 * @see #getGrService()
	 * @generated
	 */
	EReference getGrService_Base_Behavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getBase_Collaboration <em>Base Collaboration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Collaboration</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getBase_Collaboration()
	 * @see #getGrService()
	 * @generated
	 */
	EReference getGrService_Base_Collaboration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getBase_CollaborationUse <em>Base Collaboration Use</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Collaboration Use</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GrService#getBase_CollaborationUse()
	 * @see #getGrService()
	 * @generated
	 */
	EReference getGrService_Base_CollaborationUse();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Release <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Release
	 * @generated
	 */
	EClass getRelease();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Acquire <em>Acquire</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Acquire</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Acquire
	 * @generated
	 */
	EClass getAcquire();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Acquire#isIsBlocking <em>Is Blocking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Blocking</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.Acquire#isIsBlocking()
	 * @see #getAcquire()
	 * @generated
	 */
	EAttribute getAcquire_IsBlocking();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage <em>Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Usage</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage
	 * @generated
	 */
	EClass getResourceUsage();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getExecTime <em>Exec Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Exec Time</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getExecTime()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EAttribute getResourceUsage_ExecTime();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getAllocatedMemory <em>Allocated Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Allocated Memory</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getAllocatedMemory()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EAttribute getResourceUsage_AllocatedMemory();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getUsedMemory <em>Used Memory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Used Memory</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getUsedMemory()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EAttribute getResourceUsage_UsedMemory();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getPowerPeak <em>Power Peak</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Power Peak</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getPowerPeak()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EAttribute getResourceUsage_PowerPeak();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getEnergy <em>Energy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Energy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getEnergy()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EAttribute getResourceUsage_Energy();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getBase_NamedElement <em>Base Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Named Element</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getBase_NamedElement()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EReference getResourceUsage_Base_NamedElement();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getSubUsage <em>Sub Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sub Usage</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getSubUsage()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EReference getResourceUsage_SubUsage();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getUsedResources <em>Used Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Used Resources</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getUsedResources()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EReference getResourceUsage_UsedResources();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getMsgSize <em>Msg Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Msg Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.ResourceUsage#getMsgSize()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EAttribute getResourceUsage_MsgSize();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GRMFactory getGRMFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Res Mult</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__RES_MULT = eINSTANCE.getResource_ResMult();

		/**
		 * The meta object literal for the '<em><b>Is Protected</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__IS_PROTECTED = eINSTANCE.getResource_IsProtected();

		/**
		 * The meta object literal for the '<em><b>Is Active</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__IS_ACTIVE = eINSTANCE.getResource_IsActive();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__BASE_PROPERTY = eINSTANCE.getResource_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Base Instance Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__BASE_INSTANCE_SPECIFICATION = eINSTANCE.getResource_Base_InstanceSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__BASE_CLASSIFIER = eINSTANCE.getResource_Base_Classifier();

		/**
		 * The meta object literal for the '<em><b>Base Lifeline</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__BASE_LIFELINE = eINSTANCE.getResource_Base_Lifeline();

		/**
		 * The meta object literal for the '<em><b>Base Connectable Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE__BASE_CONNECTABLE_ELEMENT = eINSTANCE.getResource_Base_ConnectableElement();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.StorageResourceImpl <em>Storage Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.StorageResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getStorageResource()
		 * @generated
		 */
		EClass STORAGE_RESOURCE = eINSTANCE.getStorageResource();

		/**
		 * The meta object literal for the '<em><b>Element Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STORAGE_RESOURCE__ELEMENT_SIZE = eINSTANCE.getStorageResource_ElementSize();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.CommunicationEndPointImpl <em>Communication End Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.CommunicationEndPointImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getCommunicationEndPoint()
		 * @generated
		 */
		EClass COMMUNICATION_END_POINT = eINSTANCE.getCommunicationEndPoint();

		/**
		 * The meta object literal for the '<em><b>Packet Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATION_END_POINT__PACKET_SIZE = eINSTANCE.getCommunicationEndPoint_PacketSize();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SynchronizationResourceImpl <em>Synchronization Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SynchronizationResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getSynchronizationResource()
		 * @generated
		 */
		EClass SYNCHRONIZATION_RESOURCE = eINSTANCE.getSynchronizationResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ConcurrencyResourceImpl <em>Concurrency Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ConcurrencyResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getConcurrencyResource()
		 * @generated
		 */
		EClass CONCURRENCY_RESOURCE = eINSTANCE.getConcurrencyResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl <em>Scheduler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulerImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getScheduler()
		 * @generated
		 */
		EClass SCHEDULER = eINSTANCE.getScheduler();

		/**
		 * The meta object literal for the '<em><b>Is Preemptible</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER__IS_PREEMPTIBLE = eINSTANCE.getScheduler_IsPreemptible();

		/**
		 * The meta object literal for the '<em><b>Sched Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER__SCHED_POLICY = eINSTANCE.getScheduler_SchedPolicy();

		/**
		 * The meta object literal for the '<em><b>Other Sched Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER__OTHER_SCHED_POLICY = eINSTANCE.getScheduler_OtherSchedPolicy();

		/**
		 * The meta object literal for the '<em><b>Schedule</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULER__SCHEDULE = eINSTANCE.getScheduler_Schedule();

		/**
		 * The meta object literal for the '<em><b>Processing Units</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__PROCESSING_UNITS = eINSTANCE.getScheduler_ProcessingUnits();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__HOST = eINSTANCE.getScheduler_Host();

		/**
		 * The meta object literal for the '<em><b>Protected Shared Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__PROTECTED_SHARED_RESOURCES = eINSTANCE.getScheduler_ProtectedSharedResources();

		/**
		 * The meta object literal for the '<em><b>Schedulable Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER__SCHEDULABLE_RESOURCES = eINSTANCE.getScheduler_SchedulableResources();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ProcessingResourceImpl <em>Processing Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ProcessingResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getProcessingResource()
		 * @generated
		 */
		EClass PROCESSING_RESOURCE = eINSTANCE.getProcessingResource();

		/**
		 * The meta object literal for the '<em><b>Speed Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESSING_RESOURCE__SPEED_FACTOR = eINSTANCE.getProcessingResource_SpeedFactor();

		/**
		 * The meta object literal for the '<em><b>Main Scheduler</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING_RESOURCE__MAIN_SCHEDULER = eINSTANCE.getProcessingResource_MainScheduler();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ComputingResourceImpl <em>Computing Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ComputingResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getComputingResource()
		 * @generated
		 */
		EClass COMPUTING_RESOURCE = eINSTANCE.getComputingResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.MutualExclusionResourceImpl <em>Mutual Exclusion Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.MutualExclusionResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getMutualExclusionResource()
		 * @generated
		 */
		EClass MUTUAL_EXCLUSION_RESOURCE = eINSTANCE.getMutualExclusionResource();

		/**
		 * The meta object literal for the '<em><b>Protect Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND = eINSTANCE.getMutualExclusionResource_ProtectKind();

		/**
		 * The meta object literal for the '<em><b>Ceiling</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTUAL_EXCLUSION_RESOURCE__CEILING = eINSTANCE.getMutualExclusionResource_Ceiling();

		/**
		 * The meta object literal for the '<em><b>Other Protect Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL = eINSTANCE.getMutualExclusionResource_OtherProtectProtocol();

		/**
		 * The meta object literal for the '<em><b>Scheduler</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MUTUAL_EXCLUSION_RESOURCE__SCHEDULER = eINSTANCE.getMutualExclusionResource_Scheduler();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulableResourceImpl <em>Schedulable Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SchedulableResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getSchedulableResource()
		 * @generated
		 */
		EClass SCHEDULABLE_RESOURCE = eINSTANCE.getSchedulableResource();

		/**
		 * The meta object literal for the '<em><b>Sched Params</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SCHEDULABLE_RESOURCE__SCHED_PARAMS = eINSTANCE.getSchedulableResource_SchedParams();

		/**
		 * The meta object literal for the '<em><b>Dependent Scheduler</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULABLE_RESOURCE__DEPENDENT_SCHEDULER = eINSTANCE.getSchedulableResource_DependentScheduler();

		/**
		 * The meta object literal for the '<em><b>Host</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULABLE_RESOURCE__HOST = eINSTANCE.getSchedulableResource_Host();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SecondarySchedulerImpl <em>Secondary Scheduler</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.SecondarySchedulerImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getSecondaryScheduler()
		 * @generated
		 */
		EClass SECONDARY_SCHEDULER = eINSTANCE.getSecondaryScheduler();

		/**
		 * The meta object literal for the '<em><b>Virtual Processing Units</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SECONDARY_SCHEDULER__VIRTUAL_PROCESSING_UNITS = eINSTANCE.getSecondaryScheduler_VirtualProcessingUnits();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.CommunicationMediaImpl <em>Communication Media</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.CommunicationMediaImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getCommunicationMedia()
		 * @generated
		 */
		EClass COMMUNICATION_MEDIA = eINSTANCE.getCommunicationMedia();

		/**
		 * The meta object literal for the '<em><b>Element Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATION_MEDIA__ELEMENT_SIZE = eINSTANCE.getCommunicationMedia_ElementSize();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMMUNICATION_MEDIA__BASE_CONNECTOR = eINSTANCE.getCommunicationMedia_Base_Connector();

		/**
		 * The meta object literal for the '<em><b>Transm Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATION_MEDIA__TRANSM_MODE = eINSTANCE.getCommunicationMedia_TransmMode();

		/**
		 * The meta object literal for the '<em><b>Block T</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATION_MEDIA__BLOCK_T = eINSTANCE.getCommunicationMedia_BlockT();

		/**
		 * The meta object literal for the '<em><b>Packet T</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATION_MEDIA__PACKET_T = eINSTANCE.getCommunicationMedia_PacketT();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMMUNICATION_MEDIA__CAPACITY = eINSTANCE.getCommunicationMedia_Capacity();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.DeviceResourceImpl <em>Device Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.DeviceResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getDeviceResource()
		 * @generated
		 */
		EClass DEVICE_RESOURCE = eINSTANCE.getDeviceResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.TimingResourceImpl <em>Timing Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.TimingResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getTimingResource()
		 * @generated
		 */
		EClass TIMING_RESOURCE = eINSTANCE.getTimingResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ClockResourceImpl <em>Clock Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ClockResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getClockResource()
		 * @generated
		 */
		EClass CLOCK_RESOURCE = eINSTANCE.getClockResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.TimerResourceImpl <em>Timer Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.TimerResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getTimerResource()
		 * @generated
		 */
		EClass TIMER_RESOURCE = eINSTANCE.getTimerResource();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER_RESOURCE__DURATION = eINSTANCE.getTimerResource_Duration();

		/**
		 * The meta object literal for the '<em><b>Is Periodic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TIMER_RESOURCE__IS_PERIODIC = eINSTANCE.getTimerResource_IsPeriodic();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl <em>Gr Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GrServiceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getGrService()
		 * @generated
		 */
		EClass GR_SERVICE = eINSTANCE.getGrService();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GR_SERVICE__OWNER = eINSTANCE.getGrService_Owner();

		/**
		 * The meta object literal for the '<em><b>Base Execution Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GR_SERVICE__BASE_EXECUTION_SPECIFICATION = eINSTANCE.getGrService_Base_ExecutionSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Behavioral Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GR_SERVICE__BASE_BEHAVIORAL_FEATURE = eINSTANCE.getGrService_Base_BehavioralFeature();

		/**
		 * The meta object literal for the '<em><b>Base Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GR_SERVICE__BASE_BEHAVIOR = eINSTANCE.getGrService_Base_Behavior();

		/**
		 * The meta object literal for the '<em><b>Base Collaboration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GR_SERVICE__BASE_COLLABORATION = eINSTANCE.getGrService_Base_Collaboration();

		/**
		 * The meta object literal for the '<em><b>Base Collaboration Use</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GR_SERVICE__BASE_COLLABORATION_USE = eINSTANCE.getGrService_Base_CollaborationUse();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ReleaseImpl <em>Release</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ReleaseImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getRelease()
		 * @generated
		 */
		EClass RELEASE = eINSTANCE.getRelease();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.AcquireImpl <em>Acquire</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.AcquireImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getAcquire()
		 * @generated
		 */
		EClass ACQUIRE = eINSTANCE.getAcquire();

		/**
		 * The meta object literal for the '<em><b>Is Blocking</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACQUIRE__IS_BLOCKING = eINSTANCE.getAcquire_IsBlocking();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ResourceUsageImpl <em>Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.ResourceUsageImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.impl.GRMPackageImpl#getResourceUsage()
		 * @generated
		 */
		EClass RESOURCE_USAGE = eINSTANCE.getResourceUsage();

		/**
		 * The meta object literal for the '<em><b>Exec Time</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_USAGE__EXEC_TIME = eINSTANCE.getResourceUsage_ExecTime();

		/**
		 * The meta object literal for the '<em><b>Allocated Memory</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_USAGE__ALLOCATED_MEMORY = eINSTANCE.getResourceUsage_AllocatedMemory();

		/**
		 * The meta object literal for the '<em><b>Used Memory</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_USAGE__USED_MEMORY = eINSTANCE.getResourceUsage_UsedMemory();

		/**
		 * The meta object literal for the '<em><b>Power Peak</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_USAGE__POWER_PEAK = eINSTANCE.getResourceUsage_PowerPeak();

		/**
		 * The meta object literal for the '<em><b>Energy</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_USAGE__ENERGY = eINSTANCE.getResourceUsage_Energy();

		/**
		 * The meta object literal for the '<em><b>Base Named Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_USAGE__BASE_NAMED_ELEMENT = eINSTANCE.getResourceUsage_Base_NamedElement();

		/**
		 * The meta object literal for the '<em><b>Sub Usage</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_USAGE__SUB_USAGE = eINSTANCE.getResourceUsage_SubUsage();

		/**
		 * The meta object literal for the '<em><b>Used Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_USAGE__USED_RESOURCES = eINSTANCE.getResourceUsage_UsedResources();

		/**
		 * The meta object literal for the '<em><b>Msg Size</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_USAGE__MSG_SIZE = eINSTANCE.getResourceUsage_MsgSize();

	}

} //GRMPackage
