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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_ResourceCore.SW_ResourceCorePackage;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SW_InteractionFactory
 * @model kind="package"
 * @generated
 */
public interface SW_InteractionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SW_Interaction";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/SW_Interaction/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SW_Interaction";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SW_InteractionPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwInteractionResourceImpl <em>Sw Interaction Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwInteractionResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getSwInteractionResource()
	 * @generated
	 */
	int SW_INTERACTION_RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__RES_MULT = SW_ResourceCorePackage.SW_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__IS_PROTECTED = SW_ResourceCorePackage.SW_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__IS_ACTIVE = SW_ResourceCorePackage.SW_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__BASE_PROPERTY = SW_ResourceCorePackage.SW_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__BASE_INSTANCE_SPECIFICATION = SW_ResourceCorePackage.SW_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__BASE_CLASSIFIER = SW_ResourceCorePackage.SW_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__BASE_LIFELINE = SW_ResourceCorePackage.SW_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__BASE_CONNECTABLE_ELEMENT = SW_ResourceCorePackage.SW_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__IDENTIFIER_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__STATE_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__MEMORY_SIZE_FOOTPRINT = SW_ResourceCorePackage.SW_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__CREATE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__DELETE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__INITIALIZE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Is Intra Memory Partition Interaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Waiting Queue Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__WAITING_QUEUE_POLICY = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Waiting Queue Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__WAITING_QUEUE_CAPACITY = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Waiting Policy Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE__WAITING_POLICY_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Sw Interaction Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_INTERACTION_RESOURCE_FEATURE_COUNT = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwCommunicationResourceImpl <em>Sw Communication Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwCommunicationResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getSwCommunicationResource()
	 * @generated
	 */
	int SW_COMMUNICATION_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__RES_MULT = SW_INTERACTION_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__IS_PROTECTED = SW_INTERACTION_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__IS_ACTIVE = SW_INTERACTION_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__BASE_PROPERTY = SW_INTERACTION_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__BASE_INSTANCE_SPECIFICATION = SW_INTERACTION_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__BASE_CLASSIFIER = SW_INTERACTION_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__BASE_LIFELINE = SW_INTERACTION_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__BASE_CONNECTABLE_ELEMENT = SW_INTERACTION_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__IDENTIFIER_ELEMENTS = SW_INTERACTION_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__STATE_ELEMENTS = SW_INTERACTION_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__MEMORY_SIZE_FOOTPRINT = SW_INTERACTION_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__CREATE_SERVICES = SW_INTERACTION_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__DELETE_SERVICES = SW_INTERACTION_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__INITIALIZE_SERVICES = SW_INTERACTION_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Is Intra Memory Partition Interaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION = SW_INTERACTION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION;

	/**
	 * The feature id for the '<em><b>Waiting Queue Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__WAITING_QUEUE_POLICY = SW_INTERACTION_RESOURCE__WAITING_QUEUE_POLICY;

	/**
	 * The feature id for the '<em><b>Waiting Queue Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__WAITING_QUEUE_CAPACITY = SW_INTERACTION_RESOURCE__WAITING_QUEUE_CAPACITY;

	/**
	 * The feature id for the '<em><b>Waiting Policy Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__WAITING_POLICY_ELEMENTS = SW_INTERACTION_RESOURCE__WAITING_POLICY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__SPEED_FACTOR = SW_INTERACTION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__MAIN_SCHEDULER = SW_INTERACTION_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Element Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__ELEMENT_SIZE = SW_INTERACTION_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__BASE_CONNECTOR = SW_INTERACTION_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Transm Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__TRANSM_MODE = SW_INTERACTION_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__BLOCK_T = SW_INTERACTION_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Packet T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__PACKET_T = SW_INTERACTION_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE__CAPACITY = SW_INTERACTION_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Sw Communication Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_COMMUNICATION_RESOURCE_FEATURE_COUNT = SW_INTERACTION_RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwSynchronizationResourceImpl <em>Sw Synchronization Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwSynchronizationResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getSwSynchronizationResource()
	 * @generated
	 */
	int SW_SYNCHRONIZATION_RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__RES_MULT = SW_INTERACTION_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__IS_PROTECTED = SW_INTERACTION_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__IS_ACTIVE = SW_INTERACTION_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__BASE_PROPERTY = SW_INTERACTION_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__BASE_INSTANCE_SPECIFICATION = SW_INTERACTION_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__BASE_CLASSIFIER = SW_INTERACTION_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__BASE_LIFELINE = SW_INTERACTION_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__BASE_CONNECTABLE_ELEMENT = SW_INTERACTION_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__IDENTIFIER_ELEMENTS = SW_INTERACTION_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__STATE_ELEMENTS = SW_INTERACTION_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__MEMORY_SIZE_FOOTPRINT = SW_INTERACTION_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__CREATE_SERVICES = SW_INTERACTION_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__DELETE_SERVICES = SW_INTERACTION_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__INITIALIZE_SERVICES = SW_INTERACTION_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Is Intra Memory Partition Interaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION = SW_INTERACTION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION;

	/**
	 * The feature id for the '<em><b>Waiting Queue Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__WAITING_QUEUE_POLICY = SW_INTERACTION_RESOURCE__WAITING_QUEUE_POLICY;

	/**
	 * The feature id for the '<em><b>Waiting Queue Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__WAITING_QUEUE_CAPACITY = SW_INTERACTION_RESOURCE__WAITING_QUEUE_CAPACITY;

	/**
	 * The feature id for the '<em><b>Waiting Policy Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE__WAITING_POLICY_ELEMENTS = SW_INTERACTION_RESOURCE__WAITING_POLICY_ELEMENTS;

	/**
	 * The number of structural features of the '<em>Sw Synchronization Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT = SW_INTERACTION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SharedDataComResourceImpl <em>Shared Data Com Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SharedDataComResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getSharedDataComResource()
	 * @generated
	 */
	int SHARED_DATA_COM_RESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__RES_MULT = SW_COMMUNICATION_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__IS_PROTECTED = SW_COMMUNICATION_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__IS_ACTIVE = SW_COMMUNICATION_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__BASE_PROPERTY = SW_COMMUNICATION_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__BASE_INSTANCE_SPECIFICATION = SW_COMMUNICATION_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__BASE_CLASSIFIER = SW_COMMUNICATION_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__BASE_LIFELINE = SW_COMMUNICATION_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__BASE_CONNECTABLE_ELEMENT = SW_COMMUNICATION_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__IDENTIFIER_ELEMENTS = SW_COMMUNICATION_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__STATE_ELEMENTS = SW_COMMUNICATION_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__MEMORY_SIZE_FOOTPRINT = SW_COMMUNICATION_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__CREATE_SERVICES = SW_COMMUNICATION_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__DELETE_SERVICES = SW_COMMUNICATION_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__INITIALIZE_SERVICES = SW_COMMUNICATION_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Is Intra Memory Partition Interaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION = SW_COMMUNICATION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION;

	/**
	 * The feature id for the '<em><b>Waiting Queue Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__WAITING_QUEUE_POLICY = SW_COMMUNICATION_RESOURCE__WAITING_QUEUE_POLICY;

	/**
	 * The feature id for the '<em><b>Waiting Queue Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__WAITING_QUEUE_CAPACITY = SW_COMMUNICATION_RESOURCE__WAITING_QUEUE_CAPACITY;

	/**
	 * The feature id for the '<em><b>Waiting Policy Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__WAITING_POLICY_ELEMENTS = SW_COMMUNICATION_RESOURCE__WAITING_POLICY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__SPEED_FACTOR = SW_COMMUNICATION_RESOURCE__SPEED_FACTOR;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__MAIN_SCHEDULER = SW_COMMUNICATION_RESOURCE__MAIN_SCHEDULER;

	/**
	 * The feature id for the '<em><b>Element Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__ELEMENT_SIZE = SW_COMMUNICATION_RESOURCE__ELEMENT_SIZE;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__BASE_CONNECTOR = SW_COMMUNICATION_RESOURCE__BASE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Transm Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__TRANSM_MODE = SW_COMMUNICATION_RESOURCE__TRANSM_MODE;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__BLOCK_T = SW_COMMUNICATION_RESOURCE__BLOCK_T;

	/**
	 * The feature id for the '<em><b>Packet T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__PACKET_T = SW_COMMUNICATION_RESOURCE__PACKET_T;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__CAPACITY = SW_COMMUNICATION_RESOURCE__CAPACITY;

	/**
	 * The feature id for the '<em><b>Read Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__READ_SERVICES = SW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Write Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE__WRITE_SERVICES = SW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Shared Data Com Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHARED_DATA_COM_RESOURCE_FEATURE_COUNT = SW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.MessageComResourceImpl <em>Message Com Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.MessageComResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getMessageComResource()
	 * @generated
	 */
	int MESSAGE_COM_RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__RES_MULT = SW_COMMUNICATION_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__IS_PROTECTED = SW_COMMUNICATION_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__IS_ACTIVE = SW_COMMUNICATION_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__BASE_PROPERTY = SW_COMMUNICATION_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__BASE_INSTANCE_SPECIFICATION = SW_COMMUNICATION_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__BASE_CLASSIFIER = SW_COMMUNICATION_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__BASE_LIFELINE = SW_COMMUNICATION_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__BASE_CONNECTABLE_ELEMENT = SW_COMMUNICATION_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__IDENTIFIER_ELEMENTS = SW_COMMUNICATION_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__STATE_ELEMENTS = SW_COMMUNICATION_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__MEMORY_SIZE_FOOTPRINT = SW_COMMUNICATION_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__CREATE_SERVICES = SW_COMMUNICATION_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__DELETE_SERVICES = SW_COMMUNICATION_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__INITIALIZE_SERVICES = SW_COMMUNICATION_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Is Intra Memory Partition Interaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION = SW_COMMUNICATION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION;

	/**
	 * The feature id for the '<em><b>Waiting Queue Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__WAITING_QUEUE_POLICY = SW_COMMUNICATION_RESOURCE__WAITING_QUEUE_POLICY;

	/**
	 * The feature id for the '<em><b>Waiting Queue Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__WAITING_QUEUE_CAPACITY = SW_COMMUNICATION_RESOURCE__WAITING_QUEUE_CAPACITY;

	/**
	 * The feature id for the '<em><b>Waiting Policy Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__WAITING_POLICY_ELEMENTS = SW_COMMUNICATION_RESOURCE__WAITING_POLICY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Speed Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__SPEED_FACTOR = SW_COMMUNICATION_RESOURCE__SPEED_FACTOR;

	/**
	 * The feature id for the '<em><b>Main Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__MAIN_SCHEDULER = SW_COMMUNICATION_RESOURCE__MAIN_SCHEDULER;

	/**
	 * The feature id for the '<em><b>Element Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__ELEMENT_SIZE = SW_COMMUNICATION_RESOURCE__ELEMENT_SIZE;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__BASE_CONNECTOR = SW_COMMUNICATION_RESOURCE__BASE_CONNECTOR;

	/**
	 * The feature id for the '<em><b>Transm Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__TRANSM_MODE = SW_COMMUNICATION_RESOURCE__TRANSM_MODE;

	/**
	 * The feature id for the '<em><b>Block T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__BLOCK_T = SW_COMMUNICATION_RESOURCE__BLOCK_T;

	/**
	 * The feature id for the '<em><b>Packet T</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__PACKET_T = SW_COMMUNICATION_RESOURCE__PACKET_T;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__CAPACITY = SW_COMMUNICATION_RESOURCE__CAPACITY;

	/**
	 * The feature id for the '<em><b>Is Fixed Message Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__IS_FIXED_MESSAGE_SIZE = SW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mechanism</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__MECHANISM = SW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Message Size Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__MESSAGE_SIZE_ELEMENTS = SW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Message Queue Capacity Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_CAPACITY_ELEMENTS = SW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Message Queue Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_POLICY = SW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Send Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__SEND_SERVICES = SW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Receive Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE__RECEIVE_SERVICES = SW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Message Com Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MESSAGE_COM_RESOURCE_FEATURE_COUNT = SW_COMMUNICATION_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.NotificationResourceImpl <em>Notification Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.NotificationResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getNotificationResource()
	 * @generated
	 */
	int NOTIFICATION_RESOURCE = 5;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__RES_MULT = SW_SYNCHRONIZATION_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__IS_PROTECTED = SW_SYNCHRONIZATION_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__IS_ACTIVE = SW_SYNCHRONIZATION_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__BASE_PROPERTY = SW_SYNCHRONIZATION_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__BASE_INSTANCE_SPECIFICATION = SW_SYNCHRONIZATION_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__BASE_CLASSIFIER = SW_SYNCHRONIZATION_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__BASE_LIFELINE = SW_SYNCHRONIZATION_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__BASE_CONNECTABLE_ELEMENT = SW_SYNCHRONIZATION_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__IDENTIFIER_ELEMENTS = SW_SYNCHRONIZATION_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__STATE_ELEMENTS = SW_SYNCHRONIZATION_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__MEMORY_SIZE_FOOTPRINT = SW_SYNCHRONIZATION_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__CREATE_SERVICES = SW_SYNCHRONIZATION_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__DELETE_SERVICES = SW_SYNCHRONIZATION_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__INITIALIZE_SERVICES = SW_SYNCHRONIZATION_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Is Intra Memory Partition Interaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION = SW_SYNCHRONIZATION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION;

	/**
	 * The feature id for the '<em><b>Waiting Queue Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__WAITING_QUEUE_POLICY = SW_SYNCHRONIZATION_RESOURCE__WAITING_QUEUE_POLICY;

	/**
	 * The feature id for the '<em><b>Waiting Queue Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__WAITING_QUEUE_CAPACITY = SW_SYNCHRONIZATION_RESOURCE__WAITING_QUEUE_CAPACITY;

	/**
	 * The feature id for the '<em><b>Waiting Policy Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__WAITING_POLICY_ELEMENTS = SW_SYNCHRONIZATION_RESOURCE__WAITING_POLICY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Occurence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__OCCURENCE = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mechanism</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__MECHANISM = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Occurence Count Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__OCCURENCE_COUNT_ELEMENTS = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mask Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__MASK_ELEMENTS = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Flush Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__FLUSH_SERVICES = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Signal Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__SIGNAL_SERVICES = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wait Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__WAIT_SERVICES = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Clear Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE__CLEAR_SERVICES = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Notification Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NOTIFICATION_RESOURCE_FEATURE_COUNT = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl <em>Sw Mutual Exclusion Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getSwMutualExclusionResource()
	 * @generated
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE = 6;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__RES_MULT = SW_SYNCHRONIZATION_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__IS_PROTECTED = SW_SYNCHRONIZATION_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__IS_ACTIVE = SW_SYNCHRONIZATION_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__BASE_PROPERTY = SW_SYNCHRONIZATION_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__BASE_INSTANCE_SPECIFICATION = SW_SYNCHRONIZATION_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__BASE_CLASSIFIER = SW_SYNCHRONIZATION_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__BASE_LIFELINE = SW_SYNCHRONIZATION_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__BASE_CONNECTABLE_ELEMENT = SW_SYNCHRONIZATION_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__IDENTIFIER_ELEMENTS = SW_SYNCHRONIZATION_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__STATE_ELEMENTS = SW_SYNCHRONIZATION_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__MEMORY_SIZE_FOOTPRINT = SW_SYNCHRONIZATION_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__CREATE_SERVICES = SW_SYNCHRONIZATION_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__DELETE_SERVICES = SW_SYNCHRONIZATION_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__INITIALIZE_SERVICES = SW_SYNCHRONIZATION_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Is Intra Memory Partition Interaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION = SW_SYNCHRONIZATION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION;

	/**
	 * The feature id for the '<em><b>Waiting Queue Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__WAITING_QUEUE_POLICY = SW_SYNCHRONIZATION_RESOURCE__WAITING_QUEUE_POLICY;

	/**
	 * The feature id for the '<em><b>Waiting Queue Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__WAITING_QUEUE_CAPACITY = SW_SYNCHRONIZATION_RESOURCE__WAITING_QUEUE_CAPACITY;

	/**
	 * The feature id for the '<em><b>Waiting Policy Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__WAITING_POLICY_ELEMENTS = SW_SYNCHRONIZATION_RESOURCE__WAITING_POLICY_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Protect Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__PROTECT_KIND = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ceiling</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__CEILING = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Other Protect Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__OTHER_PROTECT_PROTOCOL = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Scheduler</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__SCHEDULER = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Mechanism</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__MECHANISM = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Concurrent Access Protocol</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__CONCURRENT_ACCESS_PROTOCOL = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Access Token Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__ACCESS_TOKEN_ELEMENTS = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Release Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__RELEASE_SERVICES = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Acquire Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE__ACQUIRE_SERVICES = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Sw Mutual Exclusion Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SW_MUTUAL_EXCLUSION_RESOURCE_FEATURE_COUNT = SW_SYNCHRONIZATION_RESOURCE_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.QueuePolicyKind <em>Queue Policy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.QueuePolicyKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getQueuePolicyKind()
	 * @generated
	 */
	int QUEUE_POLICY_KIND = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageResourceKind <em>Message Resource Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageResourceKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getMessageResourceKind()
	 * @generated
	 */
	int MESSAGE_RESOURCE_KIND = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationKind <em>Notification Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getNotificationKind()
	 * @generated
	 */
	int NOTIFICATION_KIND = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResourceKind <em>Notification Resource Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResourceKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getNotificationResourceKind()
	 * @generated
	 */
	int NOTIFICATION_RESOURCE_KIND = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MutualExclusionResourceKind <em>Mutual Exclusion Resource Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MutualExclusionResourceKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getMutualExclusionResourceKind()
	 * @generated
	 */
	int MUTUAL_EXCLUSION_RESOURCE_KIND = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.ConcurrentAccessProtocolKind <em>Concurrent Access Protocol Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.ConcurrentAccessProtocolKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getConcurrentAccessProtocolKind()
	 * @generated
	 */
	int CONCURRENT_ACCESS_PROTOCOL_KIND = 12;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource <em>Sw Interaction Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sw Interaction Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource
	 * @generated
	 */
	EClass getSwInteractionResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#isIsIntraMemoryPartitionInteraction <em>Is Intra Memory Partition Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Intra Memory Partition Interaction</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#isIsIntraMemoryPartitionInteraction()
	 * @see #getSwInteractionResource()
	 * @generated
	 */
	EAttribute getSwInteractionResource_IsIntraMemoryPartitionInteraction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#getWaitingQueuePolicy <em>Waiting Queue Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Waiting Queue Policy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#getWaitingQueuePolicy()
	 * @see #getSwInteractionResource()
	 * @generated
	 */
	EAttribute getSwInteractionResource_WaitingQueuePolicy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#getWaitingQueueCapacity <em>Waiting Queue Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Waiting Queue Capacity</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#getWaitingQueueCapacity()
	 * @see #getSwInteractionResource()
	 * @generated
	 */
	EAttribute getSwInteractionResource_WaitingQueueCapacity();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#getWaitingPolicyElements <em>Waiting Policy Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Waiting Policy Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwInteractionResource#getWaitingPolicyElements()
	 * @see #getSwInteractionResource()
	 * @generated
	 */
	EReference getSwInteractionResource_WaitingPolicyElements();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwCommunicationResource <em>Sw Communication Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sw Communication Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwCommunicationResource
	 * @generated
	 */
	EClass getSwCommunicationResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwSynchronizationResource <em>Sw Synchronization Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sw Synchronization Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwSynchronizationResource
	 * @generated
	 */
	EClass getSwSynchronizationResource();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SharedDataComResource <em>Shared Data Com Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shared Data Com Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SharedDataComResource
	 * @generated
	 */
	EClass getSharedDataComResource();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SharedDataComResource#getReadServices <em>Read Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Read Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SharedDataComResource#getReadServices()
	 * @see #getSharedDataComResource()
	 * @generated
	 */
	EReference getSharedDataComResource_ReadServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SharedDataComResource#getWriteServices <em>Write Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Write Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SharedDataComResource#getWriteServices()
	 * @see #getSharedDataComResource()
	 * @generated
	 */
	EReference getSharedDataComResource_WriteServices();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource <em>Message Com Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Message Com Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource
	 * @generated
	 */
	EClass getMessageComResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#isIsFixedMessageSize <em>Is Fixed Message Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Fixed Message Size</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#isIsFixedMessageSize()
	 * @see #getMessageComResource()
	 * @generated
	 */
	EAttribute getMessageComResource_IsFixedMessageSize();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getMechanism <em>Mechanism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mechanism</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getMechanism()
	 * @see #getMessageComResource()
	 * @generated
	 */
	EAttribute getMessageComResource_Mechanism();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getMessageSizeElements <em>Message Size Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Message Size Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getMessageSizeElements()
	 * @see #getMessageComResource()
	 * @generated
	 */
	EReference getMessageComResource_MessageSizeElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getMessageQueueCapacityElements <em>Message Queue Capacity Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Message Queue Capacity Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getMessageQueueCapacityElements()
	 * @see #getMessageComResource()
	 * @generated
	 */
	EReference getMessageComResource_MessageQueueCapacityElements();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getMessageQueuePolicy <em>Message Queue Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Queue Policy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getMessageQueuePolicy()
	 * @see #getMessageComResource()
	 * @generated
	 */
	EAttribute getMessageComResource_MessageQueuePolicy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getSendServices <em>Send Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Send Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getSendServices()
	 * @see #getMessageComResource()
	 * @generated
	 */
	EReference getMessageComResource_SendServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getReceiveServices <em>Receive Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Receive Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageComResource#getReceiveServices()
	 * @see #getMessageComResource()
	 * @generated
	 */
	EReference getMessageComResource_ReceiveServices();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource <em>Notification Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Notification Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource
	 * @generated
	 */
	EClass getNotificationResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getOccurence <em>Occurence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Occurence</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getOccurence()
	 * @see #getNotificationResource()
	 * @generated
	 */
	EAttribute getNotificationResource_Occurence();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getMechanism <em>Mechanism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mechanism</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getMechanism()
	 * @see #getNotificationResource()
	 * @generated
	 */
	EAttribute getNotificationResource_Mechanism();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getOccurenceCountElements <em>Occurence Count Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Occurence Count Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getOccurenceCountElements()
	 * @see #getNotificationResource()
	 * @generated
	 */
	EReference getNotificationResource_OccurenceCountElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getMaskElements <em>Mask Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Mask Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getMaskElements()
	 * @see #getNotificationResource()
	 * @generated
	 */
	EReference getNotificationResource_MaskElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getFlushServices <em>Flush Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Flush Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getFlushServices()
	 * @see #getNotificationResource()
	 * @generated
	 */
	EReference getNotificationResource_FlushServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getSignalServices <em>Signal Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Signal Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getSignalServices()
	 * @see #getNotificationResource()
	 * @generated
	 */
	EReference getNotificationResource_SignalServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getWaitServices <em>Wait Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Wait Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getWaitServices()
	 * @see #getNotificationResource()
	 * @generated
	 */
	EReference getNotificationResource_WaitServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getClearServices <em>Clear Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Clear Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResource#getClearServices()
	 * @see #getNotificationResource()
	 * @generated
	 */
	EReference getNotificationResource_ClearServices();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource <em>Sw Mutual Exclusion Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sw Mutual Exclusion Resource</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource
	 * @generated
	 */
	EClass getSwMutualExclusionResource();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getMechanism <em>Mechanism</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mechanism</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getMechanism()
	 * @see #getSwMutualExclusionResource()
	 * @generated
	 */
	EAttribute getSwMutualExclusionResource_Mechanism();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getConcurrentAccessProtocol <em>Concurrent Access Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Concurrent Access Protocol</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getConcurrentAccessProtocol()
	 * @see #getSwMutualExclusionResource()
	 * @generated
	 */
	EAttribute getSwMutualExclusionResource_ConcurrentAccessProtocol();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getAccessTokenElements <em>Access Token Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Access Token Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getAccessTokenElements()
	 * @see #getSwMutualExclusionResource()
	 * @generated
	 */
	EReference getSwMutualExclusionResource_AccessTokenElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getReleaseServices <em>Release Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Release Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getReleaseServices()
	 * @see #getSwMutualExclusionResource()
	 * @generated
	 */
	EReference getSwMutualExclusionResource_ReleaseServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getAcquireServices <em>Acquire Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Acquire Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.SwMutualExclusionResource#getAcquireServices()
	 * @see #getSwMutualExclusionResource()
	 * @generated
	 */
	EReference getSwMutualExclusionResource_AcquireServices();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.QueuePolicyKind <em>Queue Policy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Queue Policy Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.QueuePolicyKind
	 * @generated
	 */
	EEnum getQueuePolicyKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageResourceKind <em>Message Resource Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Message Resource Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageResourceKind
	 * @generated
	 */
	EEnum getMessageResourceKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationKind <em>Notification Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Notification Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationKind
	 * @generated
	 */
	EEnum getNotificationKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResourceKind <em>Notification Resource Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Notification Resource Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResourceKind
	 * @generated
	 */
	EEnum getNotificationResourceKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MutualExclusionResourceKind <em>Mutual Exclusion Resource Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mutual Exclusion Resource Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MutualExclusionResourceKind
	 * @generated
	 */
	EEnum getMutualExclusionResourceKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.ConcurrentAccessProtocolKind <em>Concurrent Access Protocol Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Concurrent Access Protocol Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.ConcurrentAccessProtocolKind
	 * @generated
	 */
	EEnum getConcurrentAccessProtocolKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SW_InteractionFactory getSW_InteractionFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwInteractionResourceImpl <em>Sw Interaction Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwInteractionResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getSwInteractionResource()
		 * @generated
		 */
		EClass SW_INTERACTION_RESOURCE = eINSTANCE.getSwInteractionResource();

		/**
		 * The meta object literal for the '<em><b>Is Intra Memory Partition Interaction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SW_INTERACTION_RESOURCE__IS_INTRA_MEMORY_PARTITION_INTERACTION = eINSTANCE.getSwInteractionResource_IsIntraMemoryPartitionInteraction();

		/**
		 * The meta object literal for the '<em><b>Waiting Queue Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SW_INTERACTION_RESOURCE__WAITING_QUEUE_POLICY = eINSTANCE.getSwInteractionResource_WaitingQueuePolicy();

		/**
		 * The meta object literal for the '<em><b>Waiting Queue Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SW_INTERACTION_RESOURCE__WAITING_QUEUE_CAPACITY = eINSTANCE.getSwInteractionResource_WaitingQueueCapacity();

		/**
		 * The meta object literal for the '<em><b>Waiting Policy Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_INTERACTION_RESOURCE__WAITING_POLICY_ELEMENTS = eINSTANCE.getSwInteractionResource_WaitingPolicyElements();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwCommunicationResourceImpl <em>Sw Communication Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwCommunicationResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getSwCommunicationResource()
		 * @generated
		 */
		EClass SW_COMMUNICATION_RESOURCE = eINSTANCE.getSwCommunicationResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwSynchronizationResourceImpl <em>Sw Synchronization Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwSynchronizationResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getSwSynchronizationResource()
		 * @generated
		 */
		EClass SW_SYNCHRONIZATION_RESOURCE = eINSTANCE.getSwSynchronizationResource();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SharedDataComResourceImpl <em>Shared Data Com Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SharedDataComResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getSharedDataComResource()
		 * @generated
		 */
		EClass SHARED_DATA_COM_RESOURCE = eINSTANCE.getSharedDataComResource();

		/**
		 * The meta object literal for the '<em><b>Read Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHARED_DATA_COM_RESOURCE__READ_SERVICES = eINSTANCE.getSharedDataComResource_ReadServices();

		/**
		 * The meta object literal for the '<em><b>Write Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHARED_DATA_COM_RESOURCE__WRITE_SERVICES = eINSTANCE.getSharedDataComResource_WriteServices();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.MessageComResourceImpl <em>Message Com Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.MessageComResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getMessageComResource()
		 * @generated
		 */
		EClass MESSAGE_COM_RESOURCE = eINSTANCE.getMessageComResource();

		/**
		 * The meta object literal for the '<em><b>Is Fixed Message Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_COM_RESOURCE__IS_FIXED_MESSAGE_SIZE = eINSTANCE.getMessageComResource_IsFixedMessageSize();

		/**
		 * The meta object literal for the '<em><b>Mechanism</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_COM_RESOURCE__MECHANISM = eINSTANCE.getMessageComResource_Mechanism();

		/**
		 * The meta object literal for the '<em><b>Message Size Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_COM_RESOURCE__MESSAGE_SIZE_ELEMENTS = eINSTANCE.getMessageComResource_MessageSizeElements();

		/**
		 * The meta object literal for the '<em><b>Message Queue Capacity Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_CAPACITY_ELEMENTS = eINSTANCE.getMessageComResource_MessageQueueCapacityElements();

		/**
		 * The meta object literal for the '<em><b>Message Queue Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MESSAGE_COM_RESOURCE__MESSAGE_QUEUE_POLICY = eINSTANCE.getMessageComResource_MessageQueuePolicy();

		/**
		 * The meta object literal for the '<em><b>Send Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_COM_RESOURCE__SEND_SERVICES = eINSTANCE.getMessageComResource_SendServices();

		/**
		 * The meta object literal for the '<em><b>Receive Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MESSAGE_COM_RESOURCE__RECEIVE_SERVICES = eINSTANCE.getMessageComResource_ReceiveServices();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.NotificationResourceImpl <em>Notification Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.NotificationResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getNotificationResource()
		 * @generated
		 */
		EClass NOTIFICATION_RESOURCE = eINSTANCE.getNotificationResource();

		/**
		 * The meta object literal for the '<em><b>Occurence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_RESOURCE__OCCURENCE = eINSTANCE.getNotificationResource_Occurence();

		/**
		 * The meta object literal for the '<em><b>Mechanism</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NOTIFICATION_RESOURCE__MECHANISM = eINSTANCE.getNotificationResource_Mechanism();

		/**
		 * The meta object literal for the '<em><b>Occurence Count Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTIFICATION_RESOURCE__OCCURENCE_COUNT_ELEMENTS = eINSTANCE.getNotificationResource_OccurenceCountElements();

		/**
		 * The meta object literal for the '<em><b>Mask Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTIFICATION_RESOURCE__MASK_ELEMENTS = eINSTANCE.getNotificationResource_MaskElements();

		/**
		 * The meta object literal for the '<em><b>Flush Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTIFICATION_RESOURCE__FLUSH_SERVICES = eINSTANCE.getNotificationResource_FlushServices();

		/**
		 * The meta object literal for the '<em><b>Signal Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTIFICATION_RESOURCE__SIGNAL_SERVICES = eINSTANCE.getNotificationResource_SignalServices();

		/**
		 * The meta object literal for the '<em><b>Wait Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTIFICATION_RESOURCE__WAIT_SERVICES = eINSTANCE.getNotificationResource_WaitServices();

		/**
		 * The meta object literal for the '<em><b>Clear Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NOTIFICATION_RESOURCE__CLEAR_SERVICES = eINSTANCE.getNotificationResource_ClearServices();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl <em>Sw Mutual Exclusion Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SwMutualExclusionResourceImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getSwMutualExclusionResource()
		 * @generated
		 */
		EClass SW_MUTUAL_EXCLUSION_RESOURCE = eINSTANCE.getSwMutualExclusionResource();

		/**
		 * The meta object literal for the '<em><b>Mechanism</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SW_MUTUAL_EXCLUSION_RESOURCE__MECHANISM = eINSTANCE.getSwMutualExclusionResource_Mechanism();

		/**
		 * The meta object literal for the '<em><b>Concurrent Access Protocol</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SW_MUTUAL_EXCLUSION_RESOURCE__CONCURRENT_ACCESS_PROTOCOL = eINSTANCE.getSwMutualExclusionResource_ConcurrentAccessProtocol();

		/**
		 * The meta object literal for the '<em><b>Access Token Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_MUTUAL_EXCLUSION_RESOURCE__ACCESS_TOKEN_ELEMENTS = eINSTANCE.getSwMutualExclusionResource_AccessTokenElements();

		/**
		 * The meta object literal for the '<em><b>Release Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_MUTUAL_EXCLUSION_RESOURCE__RELEASE_SERVICES = eINSTANCE.getSwMutualExclusionResource_ReleaseServices();

		/**
		 * The meta object literal for the '<em><b>Acquire Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SW_MUTUAL_EXCLUSION_RESOURCE__ACQUIRE_SERVICES = eINSTANCE.getSwMutualExclusionResource_AcquireServices();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.QueuePolicyKind <em>Queue Policy Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.QueuePolicyKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getQueuePolicyKind()
		 * @generated
		 */
		EEnum QUEUE_POLICY_KIND = eINSTANCE.getQueuePolicyKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageResourceKind <em>Message Resource Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MessageResourceKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getMessageResourceKind()
		 * @generated
		 */
		EEnum MESSAGE_RESOURCE_KIND = eINSTANCE.getMessageResourceKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationKind <em>Notification Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getNotificationKind()
		 * @generated
		 */
		EEnum NOTIFICATION_KIND = eINSTANCE.getNotificationKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResourceKind <em>Notification Resource Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.NotificationResourceKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getNotificationResourceKind()
		 * @generated
		 */
		EEnum NOTIFICATION_RESOURCE_KIND = eINSTANCE.getNotificationResourceKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MutualExclusionResourceKind <em>Mutual Exclusion Resource Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.MutualExclusionResourceKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getMutualExclusionResourceKind()
		 * @generated
		 */
		EEnum MUTUAL_EXCLUSION_RESOURCE_KIND = eINSTANCE.getMutualExclusionResourceKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.ConcurrentAccessProtocolKind <em>Concurrent Access Protocol Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.ConcurrentAccessProtocolKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Interaction.impl.SW_InteractionPackageImpl#getConcurrentAccessProtocolKind()
		 * @generated
		 */
		EEnum CONCURRENT_ACCESS_PROTOCOL_KIND = eINSTANCE.getConcurrentAccessProtocolKind();

	}

} //SW_InteractionPackage
