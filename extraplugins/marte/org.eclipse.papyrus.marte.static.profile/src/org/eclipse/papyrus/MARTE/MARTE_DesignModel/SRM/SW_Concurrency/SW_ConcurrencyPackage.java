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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.SW_ResourceCorePackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.Alloc.AllocPackage;
import org.eclipse.papyrus.MARTE.MARTE_Foundations.GRM.GRMPackage;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SW_ConcurrencyFactory
 * @model kind="package"
 * @generated
 */
public interface SW_ConcurrencyPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SW_Concurrency";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/SW_Concurrency/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SW_Concurrency";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SW_ConcurrencyPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.EntryPointImpl <em>Entry Point</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.EntryPointImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getEntryPoint()
	 * @generated
	 */
	int ENTRY_POINT = 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__KIND = AllocPackage.ALLOCATE__KIND;

	/**
	 * The feature id for the '<em><b>Nature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__NATURE = AllocPackage.ALLOCATE__NATURE;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__BASE_ABSTRACTION = AllocPackage.ALLOCATE__BASE_ABSTRACTION;

	/**
	 * The feature id for the '<em><b>Implied Constraint</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__IMPLIED_CONSTRAINT = AllocPackage.ALLOCATE__IMPLIED_CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Is Reentrant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__IS_REENTRANT = AllocPackage.ALLOCATE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Routine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT__ROUTINE = AllocPackage.ALLOCATE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Entry Point</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENTRY_POINT_FEATURE_COUNT = AllocPackage.ALLOCATE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl <em>Sw Concurrent Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getSwConcurrentResource()
	 * @generated
	 */
	int SW_CONCURRENT_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__RES_MULT = SW_ResourceCorePackage.SW_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__IS_PROTECTED = SW_ResourceCorePackage.SW_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__IS_ACTIVE = SW_ResourceCorePackage.SW_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__BASE_PROPERTY = SW_ResourceCorePackage.SW_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__BASE_INSTANCE_SPECIFICATION = SW_ResourceCorePackage.SW_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__BASE_CLASSIFIER = SW_ResourceCorePackage.SW_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__BASE_LIFELINE = SW_ResourceCorePackage.SW_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__BASE_CONNECTABLE_ELEMENT = SW_ResourceCorePackage.SW_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__IDENTIFIER_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__STATE_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__MEMORY_SIZE_FOOTPRINT = SW_ResourceCorePackage.SW_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__CREATE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__DELETE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__INITIALIZE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__TYPE = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Activation Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__ACTIVATION_CAPACITY = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Entry Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__ENTRY_POINTS = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Adress Space</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__ADRESS_SPACE = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Period Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__PERIOD_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Priority Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__PRIORITY_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Stack Size Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__STACK_SIZE_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Activate Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__ACTIVATE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Enable Concurrency Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__ENABLE_CONCURRENCY_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Resume Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__RESUME_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Suspend Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__SUSPEND_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Terminate Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__TERMINATE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Disable Concurrency Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__DISABLE_CONCURRENCY_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Share Data Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__SHARE_DATA_RESOURCES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Message Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__MESSAGE_RESOURCES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Mutual Exclusion Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__MUTUAL_EXCLUSION_RESOURCES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Notification Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__NOTIFICATION_RESOURCES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Heap Size Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE__HEAP_SIZE_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 17;

	/**
	 * The number of structural features of the '<em>Sw Concurrent Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_CONCURRENT_RESOURCE_FEATURE_COUNT = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 18;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.InterruptResourceImpl <em>Interrupt Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.InterruptResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getInterruptResource()
	 * @generated
	 */
	int INTERRUPT_RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__RES_MULT = SW_CONCURRENT_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__IS_PROTECTED = SW_CONCURRENT_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__IS_ACTIVE = SW_CONCURRENT_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__BASE_PROPERTY = SW_CONCURRENT_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__BASE_INSTANCE_SPECIFICATION = SW_CONCURRENT_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__BASE_CLASSIFIER = SW_CONCURRENT_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__BASE_LIFELINE = SW_CONCURRENT_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__BASE_CONNECTABLE_ELEMENT = SW_CONCURRENT_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__IDENTIFIER_ELEMENTS = SW_CONCURRENT_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__STATE_ELEMENTS = SW_CONCURRENT_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__MEMORY_SIZE_FOOTPRINT = SW_CONCURRENT_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__CREATE_SERVICES = SW_CONCURRENT_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__DELETE_SERVICES = SW_CONCURRENT_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__INITIALIZE_SERVICES = SW_CONCURRENT_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__TYPE = SW_CONCURRENT_RESOURCE__TYPE;

	/**
	 * The feature id for the '<em><b>Activation Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__ACTIVATION_CAPACITY = SW_CONCURRENT_RESOURCE__ACTIVATION_CAPACITY;

	/**
	 * The feature id for the '<em><b>Entry Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__ENTRY_POINTS = SW_CONCURRENT_RESOURCE__ENTRY_POINTS;

	/**
	 * The feature id for the '<em><b>Adress Space</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__ADRESS_SPACE = SW_CONCURRENT_RESOURCE__ADRESS_SPACE;

	/**
	 * The feature id for the '<em><b>Period Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__PERIOD_ELEMENTS = SW_CONCURRENT_RESOURCE__PERIOD_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Priority Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__PRIORITY_ELEMENTS = SW_CONCURRENT_RESOURCE__PRIORITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Stack Size Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__STACK_SIZE_ELEMENTS = SW_CONCURRENT_RESOURCE__STACK_SIZE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Activate Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__ACTIVATE_SERVICES = SW_CONCURRENT_RESOURCE__ACTIVATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Enable Concurrency Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__ENABLE_CONCURRENCY_SERVICES = SW_CONCURRENT_RESOURCE__ENABLE_CONCURRENCY_SERVICES;

	/**
	 * The feature id for the '<em><b>Resume Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__RESUME_SERVICES = SW_CONCURRENT_RESOURCE__RESUME_SERVICES;

	/**
	 * The feature id for the '<em><b>Suspend Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__SUSPEND_SERVICES = SW_CONCURRENT_RESOURCE__SUSPEND_SERVICES;

	/**
	 * The feature id for the '<em><b>Terminate Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__TERMINATE_SERVICES = SW_CONCURRENT_RESOURCE__TERMINATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Disable Concurrency Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__DISABLE_CONCURRENCY_SERVICES = SW_CONCURRENT_RESOURCE__DISABLE_CONCURRENCY_SERVICES;

	/**
	 * The feature id for the '<em><b>Share Data Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__SHARE_DATA_RESOURCES = SW_CONCURRENT_RESOURCE__SHARE_DATA_RESOURCES;

	/**
	 * The feature id for the '<em><b>Message Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__MESSAGE_RESOURCES = SW_CONCURRENT_RESOURCE__MESSAGE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Mutual Exclusion Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__MUTUAL_EXCLUSION_RESOURCES = SW_CONCURRENT_RESOURCE__MUTUAL_EXCLUSION_RESOURCES;

	/**
	 * The feature id for the '<em><b>Notification Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__NOTIFICATION_RESOURCES = SW_CONCURRENT_RESOURCE__NOTIFICATION_RESOURCES;

	/**
	 * The feature id for the '<em><b>Heap Size Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__HEAP_SIZE_ELEMENTS = SW_CONCURRENT_RESOURCE__HEAP_SIZE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__KIND = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Maskable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__IS_MASKABLE = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Vector Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__VECTOR_ELEMENTS = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mask Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__MASK_ELEMENTS = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Routine Connect Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__ROUTINE_CONNECT_SERVICES = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Routine Disconnect Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE__ROUTINE_DISCONNECT_SERVICES = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Interrupt Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERRUPT_RESOURCE_FEATURE_COUNT = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwSchedulableResourceImpl <em>Sw Schedulable Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwSchedulableResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getSwSchedulableResource()
	 * @generated
	 */
	int SW_SCHEDULABLE_RESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__RES_MULT = SW_CONCURRENT_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__IS_PROTECTED = SW_CONCURRENT_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__IS_ACTIVE = SW_CONCURRENT_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__BASE_PROPERTY = SW_CONCURRENT_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__BASE_INSTANCE_SPECIFICATION = SW_CONCURRENT_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__BASE_CLASSIFIER = SW_CONCURRENT_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__BASE_LIFELINE = SW_CONCURRENT_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__BASE_CONNECTABLE_ELEMENT = SW_CONCURRENT_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__IDENTIFIER_ELEMENTS = SW_CONCURRENT_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__STATE_ELEMENTS = SW_CONCURRENT_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__MEMORY_SIZE_FOOTPRINT = SW_CONCURRENT_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__CREATE_SERVICES = SW_CONCURRENT_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__DELETE_SERVICES = SW_CONCURRENT_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__INITIALIZE_SERVICES = SW_CONCURRENT_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__TYPE = SW_CONCURRENT_RESOURCE__TYPE;

	/**
	 * The feature id for the '<em><b>Activation Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__ACTIVATION_CAPACITY = SW_CONCURRENT_RESOURCE__ACTIVATION_CAPACITY;

	/**
	 * The feature id for the '<em><b>Entry Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__ENTRY_POINTS = SW_CONCURRENT_RESOURCE__ENTRY_POINTS;

	/**
	 * The feature id for the '<em><b>Adress Space</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__ADRESS_SPACE = SW_CONCURRENT_RESOURCE__ADRESS_SPACE;

	/**
	 * The feature id for the '<em><b>Period Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__PERIOD_ELEMENTS = SW_CONCURRENT_RESOURCE__PERIOD_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Priority Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__PRIORITY_ELEMENTS = SW_CONCURRENT_RESOURCE__PRIORITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Stack Size Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__STACK_SIZE_ELEMENTS = SW_CONCURRENT_RESOURCE__STACK_SIZE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Activate Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__ACTIVATE_SERVICES = SW_CONCURRENT_RESOURCE__ACTIVATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Enable Concurrency Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__ENABLE_CONCURRENCY_SERVICES = SW_CONCURRENT_RESOURCE__ENABLE_CONCURRENCY_SERVICES;

	/**
	 * The feature id for the '<em><b>Resume Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__RESUME_SERVICES = SW_CONCURRENT_RESOURCE__RESUME_SERVICES;

	/**
	 * The feature id for the '<em><b>Suspend Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__SUSPEND_SERVICES = SW_CONCURRENT_RESOURCE__SUSPEND_SERVICES;

	/**
	 * The feature id for the '<em><b>Terminate Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__TERMINATE_SERVICES = SW_CONCURRENT_RESOURCE__TERMINATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Disable Concurrency Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__DISABLE_CONCURRENCY_SERVICES = SW_CONCURRENT_RESOURCE__DISABLE_CONCURRENCY_SERVICES;

	/**
	 * The feature id for the '<em><b>Share Data Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__SHARE_DATA_RESOURCES = SW_CONCURRENT_RESOURCE__SHARE_DATA_RESOURCES;

	/**
	 * The feature id for the '<em><b>Message Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__MESSAGE_RESOURCES = SW_CONCURRENT_RESOURCE__MESSAGE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Mutual Exclusion Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__MUTUAL_EXCLUSION_RESOURCES = SW_CONCURRENT_RESOURCE__MUTUAL_EXCLUSION_RESOURCES;

	/**
	 * The feature id for the '<em><b>Notification Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__NOTIFICATION_RESOURCES = SW_CONCURRENT_RESOURCE__NOTIFICATION_RESOURCES;

	/**
	 * The feature id for the '<em><b>Heap Size Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__HEAP_SIZE_ELEMENTS = SW_CONCURRENT_RESOURCE__HEAP_SIZE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Sched Params</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__SCHED_PARAMS = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dependent Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__DEPENDENT_SCHEDULER = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Host</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__HOST = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Is Static Scheduling Feature</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__IS_STATIC_SCHEDULING_FEATURE = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Is Preemptable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__IS_PREEMPTABLE = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Schedulers</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__SCHEDULERS = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Deadline Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__DEADLINE_ELEMENTS = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Deadline Type Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__DEADLINE_TYPE_ELEMENTS = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Time Slice Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__TIME_SLICE_ELEMENTS = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Delay Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__DELAY_SERVICES = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Join Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__JOIN_SERVICES = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Yield Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE__YIELD_SERVICES = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Sw Schedulable Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SCHEDULABLE_RESOURCE_FEATURE_COUNT = SW_CONCURRENT_RESOURCE_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwTimerResourceImpl <em>Sw Timer Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwTimerResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getSwTimerResource()
	 * @generated
	 */
	int SW_TIMER_RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE__RES_MULT = GRMPackage.TIMER_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE__IS_PROTECTED = GRMPackage.TIMER_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE__IS_ACTIVE = GRMPackage.TIMER_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE__BASE_PROPERTY = GRMPackage.TIMER_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE__BASE_INSTANCE_SPECIFICATION = GRMPackage.TIMER_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE__BASE_CLASSIFIER = GRMPackage.TIMER_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE__BASE_LIFELINE = GRMPackage.TIMER_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE__BASE_CONNECTABLE_ELEMENT = GRMPackage.TIMER_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE__DURATION = GRMPackage.TIMER_RESOURCE__DURATION;

	/**
	 * The feature id for the '<em><b>Is Periodic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE__IS_PERIODIC = GRMPackage.TIMER_RESOURCE__IS_PERIODIC;

	/**
	 * The feature id for the '<em><b>Duration Elements</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE__DURATION_ELEMENTS = GRMPackage.TIMER_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Sw Timer Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_TIMER_RESOURCE_FEATURE_COUNT = GRMPackage.TIMER_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.MemoryPartitionImpl <em>Memory Partition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.MemoryPartitionImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getMemoryPartition()
	 * @generated
	 */
	int MEMORY_PARTITION = 5;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__RES_MULT = SW_ResourceCorePackage.SW_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__IS_PROTECTED = SW_ResourceCorePackage.SW_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__IS_ACTIVE = SW_ResourceCorePackage.SW_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__BASE_PROPERTY = SW_ResourceCorePackage.SW_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__BASE_INSTANCE_SPECIFICATION = SW_ResourceCorePackage.SW_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__BASE_CLASSIFIER = SW_ResourceCorePackage.SW_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__BASE_LIFELINE = SW_ResourceCorePackage.SW_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__BASE_CONNECTABLE_ELEMENT = SW_ResourceCorePackage.SW_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__IDENTIFIER_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__STATE_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__MEMORY_SIZE_FOOTPRINT = SW_ResourceCorePackage.SW_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__CREATE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__DELETE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__INITIALIZE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Concurrent Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__CONCURRENT_RESOURCES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Memory Spaces</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__MEMORY_SPACES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Fork</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__FORK = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Exit</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__EXIT = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Base Namespace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION__BASE_NAMESPACE = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Memory Partition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_PARTITION_FEATURE_COUNT = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.AlarmImpl <em>Alarm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.AlarmImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getAlarm()
	 * @generated
	 */
	int ALARM = 6;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__RES_MULT = INTERRUPT_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__IS_PROTECTED = INTERRUPT_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__IS_ACTIVE = INTERRUPT_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__BASE_PROPERTY = INTERRUPT_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__BASE_INSTANCE_SPECIFICATION = INTERRUPT_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__BASE_CLASSIFIER = INTERRUPT_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__BASE_LIFELINE = INTERRUPT_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__BASE_CONNECTABLE_ELEMENT = INTERRUPT_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__IDENTIFIER_ELEMENTS = INTERRUPT_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__STATE_ELEMENTS = INTERRUPT_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__MEMORY_SIZE_FOOTPRINT = INTERRUPT_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__CREATE_SERVICES = INTERRUPT_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__DELETE_SERVICES = INTERRUPT_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__INITIALIZE_SERVICES = INTERRUPT_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__TYPE = INTERRUPT_RESOURCE__TYPE;

	/**
	 * The feature id for the '<em><b>Activation Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__ACTIVATION_CAPACITY = INTERRUPT_RESOURCE__ACTIVATION_CAPACITY;

	/**
	 * The feature id for the '<em><b>Entry Points</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__ENTRY_POINTS = INTERRUPT_RESOURCE__ENTRY_POINTS;

	/**
	 * The feature id for the '<em><b>Adress Space</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__ADRESS_SPACE = INTERRUPT_RESOURCE__ADRESS_SPACE;

	/**
	 * The feature id for the '<em><b>Period Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__PERIOD_ELEMENTS = INTERRUPT_RESOURCE__PERIOD_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Priority Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__PRIORITY_ELEMENTS = INTERRUPT_RESOURCE__PRIORITY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Stack Size Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__STACK_SIZE_ELEMENTS = INTERRUPT_RESOURCE__STACK_SIZE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Activate Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__ACTIVATE_SERVICES = INTERRUPT_RESOURCE__ACTIVATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Enable Concurrency Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__ENABLE_CONCURRENCY_SERVICES = INTERRUPT_RESOURCE__ENABLE_CONCURRENCY_SERVICES;

	/**
	 * The feature id for the '<em><b>Resume Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__RESUME_SERVICES = INTERRUPT_RESOURCE__RESUME_SERVICES;

	/**
	 * The feature id for the '<em><b>Suspend Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__SUSPEND_SERVICES = INTERRUPT_RESOURCE__SUSPEND_SERVICES;

	/**
	 * The feature id for the '<em><b>Terminate Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__TERMINATE_SERVICES = INTERRUPT_RESOURCE__TERMINATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Disable Concurrency Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__DISABLE_CONCURRENCY_SERVICES = INTERRUPT_RESOURCE__DISABLE_CONCURRENCY_SERVICES;

	/**
	 * The feature id for the '<em><b>Share Data Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__SHARE_DATA_RESOURCES = INTERRUPT_RESOURCE__SHARE_DATA_RESOURCES;

	/**
	 * The feature id for the '<em><b>Message Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__MESSAGE_RESOURCES = INTERRUPT_RESOURCE__MESSAGE_RESOURCES;

	/**
	 * The feature id for the '<em><b>Mutual Exclusion Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__MUTUAL_EXCLUSION_RESOURCES = INTERRUPT_RESOURCE__MUTUAL_EXCLUSION_RESOURCES;

	/**
	 * The feature id for the '<em><b>Notification Resources</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__NOTIFICATION_RESOURCES = INTERRUPT_RESOURCE__NOTIFICATION_RESOURCES;

	/**
	 * The feature id for the '<em><b>Heap Size Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__HEAP_SIZE_ELEMENTS = INTERRUPT_RESOURCE__HEAP_SIZE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__KIND = INTERRUPT_RESOURCE__KIND;

	/**
	 * The feature id for the '<em><b>Is Maskable</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__IS_MASKABLE = INTERRUPT_RESOURCE__IS_MASKABLE;

	/**
	 * The feature id for the '<em><b>Vector Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__VECTOR_ELEMENTS = INTERRUPT_RESOURCE__VECTOR_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Mask Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__MASK_ELEMENTS = INTERRUPT_RESOURCE__MASK_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Routine Connect Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__ROUTINE_CONNECT_SERVICES = INTERRUPT_RESOURCE__ROUTINE_CONNECT_SERVICES;

	/**
	 * The feature id for the '<em><b>Routine Disconnect Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__ROUTINE_DISCONNECT_SERVICES = INTERRUPT_RESOURCE__ROUTINE_DISCONNECT_SERVICES;

	/**
	 * The feature id for the '<em><b>Is Watchdog</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__IS_WATCHDOG = INTERRUPT_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Timers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM__TIMERS = INTERRUPT_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Alarm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALARM_FEATURE_COUNT = INTERRUPT_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptKind <em>Interrupt Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getInterruptKind()
	 * @generated
	 */
	int INTERRUPT_KIND = 7;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.EntryPoint <em>Entry Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Entry Point</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.EntryPoint
	 * @generated
	 */
	EClass getEntryPoint();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.EntryPoint#isIsReentrant <em>Is Reentrant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Reentrant</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.EntryPoint#isIsReentrant()
	 * @see #getEntryPoint()
	 * @generated
	 */
	EAttribute getEntryPoint_IsReentrant();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.EntryPoint#getRoutine <em>Routine</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Routine</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.EntryPoint#getRoutine()
	 * @see #getEntryPoint()
	 * @generated
	 */
	EReference getEntryPoint_Routine();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource <em>Sw Concurrent Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sw Concurrent Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource
	 * @generated
	 */
	EClass getSwConcurrentResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getType()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EAttribute getSwConcurrentResource_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getActivationCapacity <em>Activation Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Activation Capacity</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getActivationCapacity()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EAttribute getSwConcurrentResource_ActivationCapacity();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getEntryPoints <em>Entry Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Entry Points</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getEntryPoints()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_EntryPoints();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getAdressSpace <em>Adress Space</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Adress Space</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getAdressSpace()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_AdressSpace();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getPeriodElements <em>Period Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Period Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getPeriodElements()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_PeriodElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getPriorityElements <em>Priority Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Priority Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getPriorityElements()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_PriorityElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getStackSizeElements <em>Stack Size Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Stack Size Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getStackSizeElements()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_StackSizeElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getActivateServices <em>Activate Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Activate Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getActivateServices()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_ActivateServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getEnableConcurrencyServices <em>Enable Concurrency Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Enable Concurrency Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getEnableConcurrencyServices()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_EnableConcurrencyServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getResumeServices <em>Resume Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Resume Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getResumeServices()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_ResumeServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getSuspendServices <em>Suspend Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Suspend Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getSuspendServices()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_SuspendServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getTerminateServices <em>Terminate Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Terminate Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getTerminateServices()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_TerminateServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getDisableConcurrencyServices <em>Disable Concurrency Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Disable Concurrency Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getDisableConcurrencyServices()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_DisableConcurrencyServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getShareDataResources <em>Share Data Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Share Data Resources</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getShareDataResources()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_ShareDataResources();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getMessageResources <em>Message Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Message Resources</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getMessageResources()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_MessageResources();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getMutualExclusionResources <em>Mutual Exclusion Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mutual Exclusion Resources</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getMutualExclusionResources()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_MutualExclusionResources();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getNotificationResources <em>Notification Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Notification Resources</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getNotificationResources()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_NotificationResources();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getHeapSizeElements <em>Heap Size Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Heap Size Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwConcurrentResource#getHeapSizeElements()
	 * @see #getSwConcurrentResource()
	 * @generated
	 */
	EReference getSwConcurrentResource_HeapSizeElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource <em>Interrupt Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interrupt Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource
	 * @generated
	 */
	EClass getInterruptResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#getKind()
	 * @see #getInterruptResource()
	 * @generated
	 */
	EAttribute getInterruptResource_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#isIsMaskable <em>Is Maskable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Maskable</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#isIsMaskable()
	 * @see #getInterruptResource()
	 * @generated
	 */
	EAttribute getInterruptResource_IsMaskable();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#getVectorElements <em>Vector Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Vector Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#getVectorElements()
	 * @see #getInterruptResource()
	 * @generated
	 */
	EReference getInterruptResource_VectorElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#getMaskElements <em>Mask Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mask Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#getMaskElements()
	 * @see #getInterruptResource()
	 * @generated
	 */
	EReference getInterruptResource_MaskElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#getRoutineConnectServices <em>Routine Connect Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Routine Connect Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#getRoutineConnectServices()
	 * @see #getInterruptResource()
	 * @generated
	 */
	EReference getInterruptResource_RoutineConnectServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#getRoutineDisconnectServices <em>Routine Disconnect Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Routine Disconnect Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptResource#getRoutineDisconnectServices()
	 * @see #getInterruptResource()
	 * @generated
	 */
	EReference getInterruptResource_RoutineDisconnectServices();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource <em>Sw Schedulable Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sw Schedulable Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource
	 * @generated
	 */
	EClass getSwSchedulableResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#isIsStaticSchedulingFeature <em>Is Static Scheduling Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Static Scheduling Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#isIsStaticSchedulingFeature()
	 * @see #getSwSchedulableResource()
	 * @generated
	 */
	EAttribute getSwSchedulableResource_IsStaticSchedulingFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#isIsPreemptable <em>Is Preemptable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Preemptable</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#isIsPreemptable()
	 * @see #getSwSchedulableResource()
	 * @generated
	 */
	EAttribute getSwSchedulableResource_IsPreemptable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getSchedulers <em>Schedulers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Schedulers</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getSchedulers()
	 * @see #getSwSchedulableResource()
	 * @generated
	 */
	EReference getSwSchedulableResource_Schedulers();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getDeadlineElements <em>Deadline Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Deadline Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getDeadlineElements()
	 * @see #getSwSchedulableResource()
	 * @generated
	 */
	EReference getSwSchedulableResource_DeadlineElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getDeadlineTypeElements <em>Deadline Type Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Deadline Type Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getDeadlineTypeElements()
	 * @see #getSwSchedulableResource()
	 * @generated
	 */
	EReference getSwSchedulableResource_DeadlineTypeElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getTimeSliceElements <em>Time Slice Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Time Slice Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getTimeSliceElements()
	 * @see #getSwSchedulableResource()
	 * @generated
	 */
	EReference getSwSchedulableResource_TimeSliceElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getDelayServices <em>Delay Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Delay Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getDelayServices()
	 * @see #getSwSchedulableResource()
	 * @generated
	 */
	EReference getSwSchedulableResource_DelayServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getJoinServices <em>Join Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Join Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getJoinServices()
	 * @see #getSwSchedulableResource()
	 * @generated
	 */
	EReference getSwSchedulableResource_JoinServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getYieldServices <em>Yield Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Yield Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwSchedulableResource#getYieldServices()
	 * @see #getSwSchedulableResource()
	 * @generated
	 */
	EReference getSwSchedulableResource_YieldServices();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwTimerResource <em>Sw Timer Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sw Timer Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwTimerResource
	 * @generated
	 */
	EClass getSwTimerResource();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwTimerResource#getDurationElements <em>Duration Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Duration Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.SwTimerResource#getDurationElements()
	 * @see #getSwTimerResource()
	 * @generated
	 */
	EReference getSwTimerResource_DurationElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition <em>Memory Partition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Partition</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition
	 * @generated
	 */
	EClass getMemoryPartition();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition#getConcurrentResources <em>Concurrent Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Concurrent Resources</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition#getConcurrentResources()
	 * @see #getMemoryPartition()
	 * @generated
	 */
	EReference getMemoryPartition_ConcurrentResources();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition#getMemorySpaces <em>Memory Spaces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Memory Spaces</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition#getMemorySpaces()
	 * @see #getMemoryPartition()
	 * @generated
	 */
	EReference getMemoryPartition_MemorySpaces();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition#getFork <em>Fork</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Fork</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition#getFork()
	 * @see #getMemoryPartition()
	 * @generated
	 */
	EReference getMemoryPartition_Fork();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition#getExit <em>Exit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Exit</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition#getExit()
	 * @see #getMemoryPartition()
	 * @generated
	 */
	EReference getMemoryPartition_Exit();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition#getBase_Namespace <em>Base Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Namespace</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.MemoryPartition#getBase_Namespace()
	 * @see #getMemoryPartition()
	 * @generated
	 */
	EReference getMemoryPartition_Base_Namespace();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.Alarm <em>Alarm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Alarm</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.Alarm
	 * @generated
	 */
	EClass getAlarm();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.Alarm#isIsWatchdog <em>Is Watchdog</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Watchdog</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.Alarm#isIsWatchdog()
	 * @see #getAlarm()
	 * @generated
	 */
	EAttribute getAlarm_IsWatchdog();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.Alarm#getTimers <em>Timers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Timers</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.Alarm#getTimers()
	 * @see #getAlarm()
	 * @generated
	 */
	EReference getAlarm_Timers();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptKind <em>Interrupt Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Interrupt Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptKind
	 * @generated
	 */
	EEnum getInterruptKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SW_ConcurrencyFactory getSW_ConcurrencyFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.EntryPointImpl <em>Entry Point</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.EntryPointImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getEntryPoint()
		 * @generated
		 */
		EClass ENTRY_POINT = eINSTANCE.getEntryPoint();

		/**
		 * The meta object literal for the '<em><b>Is Reentrant</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENTRY_POINT__IS_REENTRANT = eINSTANCE.getEntryPoint_IsReentrant();

		/**
		 * The meta object literal for the '<em><b>Routine</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENTRY_POINT__ROUTINE = eINSTANCE.getEntryPoint_Routine();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl <em>Sw Concurrent Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwConcurrentResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getSwConcurrentResource()
		 * @generated
		 */
		EClass SW_CONCURRENT_RESOURCE = eINSTANCE.getSwConcurrentResource();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SW_CONCURRENT_RESOURCE__TYPE = eINSTANCE.getSwConcurrentResource_Type();

		/**
		 * The meta object literal for the '<em><b>Activation Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SW_CONCURRENT_RESOURCE__ACTIVATION_CAPACITY = eINSTANCE.getSwConcurrentResource_ActivationCapacity();

		/**
		 * The meta object literal for the '<em><b>Entry Points</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__ENTRY_POINTS = eINSTANCE.getSwConcurrentResource_EntryPoints();

		/**
		 * The meta object literal for the '<em><b>Adress Space</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__ADRESS_SPACE = eINSTANCE.getSwConcurrentResource_AdressSpace();

		/**
		 * The meta object literal for the '<em><b>Period Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__PERIOD_ELEMENTS = eINSTANCE.getSwConcurrentResource_PeriodElements();

		/**
		 * The meta object literal for the '<em><b>Priority Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__PRIORITY_ELEMENTS = eINSTANCE.getSwConcurrentResource_PriorityElements();

		/**
		 * The meta object literal for the '<em><b>Stack Size Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__STACK_SIZE_ELEMENTS = eINSTANCE.getSwConcurrentResource_StackSizeElements();

		/**
		 * The meta object literal for the '<em><b>Activate Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__ACTIVATE_SERVICES = eINSTANCE.getSwConcurrentResource_ActivateServices();

		/**
		 * The meta object literal for the '<em><b>Enable Concurrency Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__ENABLE_CONCURRENCY_SERVICES = eINSTANCE.getSwConcurrentResource_EnableConcurrencyServices();

		/**
		 * The meta object literal for the '<em><b>Resume Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__RESUME_SERVICES = eINSTANCE.getSwConcurrentResource_ResumeServices();

		/**
		 * The meta object literal for the '<em><b>Suspend Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__SUSPEND_SERVICES = eINSTANCE.getSwConcurrentResource_SuspendServices();

		/**
		 * The meta object literal for the '<em><b>Terminate Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__TERMINATE_SERVICES = eINSTANCE.getSwConcurrentResource_TerminateServices();

		/**
		 * The meta object literal for the '<em><b>Disable Concurrency Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__DISABLE_CONCURRENCY_SERVICES = eINSTANCE.getSwConcurrentResource_DisableConcurrencyServices();

		/**
		 * The meta object literal for the '<em><b>Share Data Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__SHARE_DATA_RESOURCES = eINSTANCE.getSwConcurrentResource_ShareDataResources();

		/**
		 * The meta object literal for the '<em><b>Message Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__MESSAGE_RESOURCES = eINSTANCE.getSwConcurrentResource_MessageResources();

		/**
		 * The meta object literal for the '<em><b>Mutual Exclusion Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__MUTUAL_EXCLUSION_RESOURCES = eINSTANCE.getSwConcurrentResource_MutualExclusionResources();

		/**
		 * The meta object literal for the '<em><b>Notification Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__NOTIFICATION_RESOURCES = eINSTANCE.getSwConcurrentResource_NotificationResources();

		/**
		 * The meta object literal for the '<em><b>Heap Size Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_CONCURRENT_RESOURCE__HEAP_SIZE_ELEMENTS = eINSTANCE.getSwConcurrentResource_HeapSizeElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.InterruptResourceImpl <em>Interrupt Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.InterruptResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getInterruptResource()
		 * @generated
		 */
		EClass INTERRUPT_RESOURCE = eINSTANCE.getInterruptResource();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERRUPT_RESOURCE__KIND = eINSTANCE.getInterruptResource_Kind();

		/**
		 * The meta object literal for the '<em><b>Is Maskable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERRUPT_RESOURCE__IS_MASKABLE = eINSTANCE.getInterruptResource_IsMaskable();

		/**
		 * The meta object literal for the '<em><b>Vector Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERRUPT_RESOURCE__VECTOR_ELEMENTS = eINSTANCE.getInterruptResource_VectorElements();

		/**
		 * The meta object literal for the '<em><b>Mask Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERRUPT_RESOURCE__MASK_ELEMENTS = eINSTANCE.getInterruptResource_MaskElements();

		/**
		 * The meta object literal for the '<em><b>Routine Connect Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERRUPT_RESOURCE__ROUTINE_CONNECT_SERVICES = eINSTANCE.getInterruptResource_RoutineConnectServices();

		/**
		 * The meta object literal for the '<em><b>Routine Disconnect Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERRUPT_RESOURCE__ROUTINE_DISCONNECT_SERVICES = eINSTANCE.getInterruptResource_RoutineDisconnectServices();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwSchedulableResourceImpl <em>Sw Schedulable Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwSchedulableResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getSwSchedulableResource()
		 * @generated
		 */
		EClass SW_SCHEDULABLE_RESOURCE = eINSTANCE.getSwSchedulableResource();

		/**
		 * The meta object literal for the '<em><b>Is Static Scheduling Feature</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SW_SCHEDULABLE_RESOURCE__IS_STATIC_SCHEDULING_FEATURE = eINSTANCE.getSwSchedulableResource_IsStaticSchedulingFeature();

		/**
		 * The meta object literal for the '<em><b>Is Preemptable</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SW_SCHEDULABLE_RESOURCE__IS_PREEMPTABLE = eINSTANCE.getSwSchedulableResource_IsPreemptable();

		/**
		 * The meta object literal for the '<em><b>Schedulers</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_SCHEDULABLE_RESOURCE__SCHEDULERS = eINSTANCE.getSwSchedulableResource_Schedulers();

		/**
		 * The meta object literal for the '<em><b>Deadline Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_SCHEDULABLE_RESOURCE__DEADLINE_ELEMENTS = eINSTANCE.getSwSchedulableResource_DeadlineElements();

		/**
		 * The meta object literal for the '<em><b>Deadline Type Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_SCHEDULABLE_RESOURCE__DEADLINE_TYPE_ELEMENTS = eINSTANCE.getSwSchedulableResource_DeadlineTypeElements();

		/**
		 * The meta object literal for the '<em><b>Time Slice Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_SCHEDULABLE_RESOURCE__TIME_SLICE_ELEMENTS = eINSTANCE.getSwSchedulableResource_TimeSliceElements();

		/**
		 * The meta object literal for the '<em><b>Delay Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_SCHEDULABLE_RESOURCE__DELAY_SERVICES = eINSTANCE.getSwSchedulableResource_DelayServices();

		/**
		 * The meta object literal for the '<em><b>Join Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_SCHEDULABLE_RESOURCE__JOIN_SERVICES = eINSTANCE.getSwSchedulableResource_JoinServices();

		/**
		 * The meta object literal for the '<em><b>Yield Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_SCHEDULABLE_RESOURCE__YIELD_SERVICES = eINSTANCE.getSwSchedulableResource_YieldServices();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwTimerResourceImpl <em>Sw Timer Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SwTimerResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getSwTimerResource()
		 * @generated
		 */
		EClass SW_TIMER_RESOURCE = eINSTANCE.getSwTimerResource();

		/**
		 * The meta object literal for the '<em><b>Duration Elements</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_TIMER_RESOURCE__DURATION_ELEMENTS = eINSTANCE.getSwTimerResource_DurationElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.MemoryPartitionImpl <em>Memory Partition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.MemoryPartitionImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getMemoryPartition()
		 * @generated
		 */
		EClass MEMORY_PARTITION = eINSTANCE.getMemoryPartition();

		/**
		 * The meta object literal for the '<em><b>Concurrent Resources</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_PARTITION__CONCURRENT_RESOURCES = eINSTANCE.getMemoryPartition_ConcurrentResources();

		/**
		 * The meta object literal for the '<em><b>Memory Spaces</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_PARTITION__MEMORY_SPACES = eINSTANCE.getMemoryPartition_MemorySpaces();

		/**
		 * The meta object literal for the '<em><b>Fork</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_PARTITION__FORK = eINSTANCE.getMemoryPartition_Fork();

		/**
		 * The meta object literal for the '<em><b>Exit</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_PARTITION__EXIT = eINSTANCE.getMemoryPartition_Exit();

		/**
		 * The meta object literal for the '<em><b>Base Namespace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_PARTITION__BASE_NAMESPACE = eINSTANCE.getMemoryPartition_Base_Namespace();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.AlarmImpl <em>Alarm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.AlarmImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getAlarm()
		 * @generated
		 */
		EClass ALARM = eINSTANCE.getAlarm();

		/**
		 * The meta object literal for the '<em><b>Is Watchdog</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALARM__IS_WATCHDOG = eINSTANCE.getAlarm_IsWatchdog();

		/**
		 * The meta object literal for the '<em><b>Timers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALARM__TIMERS = eINSTANCE.getAlarm_Timers();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptKind <em>Interrupt Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.InterruptKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Concurrency.impl.SW_ConcurrencyPackageImpl#getInterruptKind()
		 * @generated
		 */
		EEnum INTERRUPT_KIND = eINSTANCE.getInterruptKind();

	}

} //SW_ConcurrencyPackage
