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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering;

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
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.SW_BrokeringFactory
 * @model kind="package"
 * @generated
 */
public interface SW_BrokeringPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "SW_Brokering";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/SW_Brokering/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SW_Brokering";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SW_BrokeringPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.SW_BrokeringPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl <em>Device Broker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.SW_BrokeringPackageImpl#getDeviceBroker()
	 * @generated
	 */
	int DEVICE_BROKER = 0;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__RES_MULT = SW_ResourceCorePackage.SW_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__IS_PROTECTED = SW_ResourceCorePackage.SW_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__IS_ACTIVE = SW_ResourceCorePackage.SW_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__BASE_PROPERTY = SW_ResourceCorePackage.SW_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__BASE_INSTANCE_SPECIFICATION = SW_ResourceCorePackage.SW_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__BASE_CLASSIFIER = SW_ResourceCorePackage.SW_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__BASE_LIFELINE = SW_ResourceCorePackage.SW_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__BASE_CONNECTABLE_ELEMENT = SW_ResourceCorePackage.SW_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__IDENTIFIER_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__STATE_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__MEMORY_SIZE_FOOTPRINT = SW_ResourceCorePackage.SW_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__CREATE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__DELETE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__INITIALIZE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Access Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__ACCESS_POLICY = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Is Buffered</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__IS_BUFFERED = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Devices</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__DEVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Close Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__CLOSE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Control Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__CONTROL_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Open Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__OPEN_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Read Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__READ_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Write Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER__WRITE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Device Broker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_BROKER_FEATURE_COUNT = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl <em>Memory Broker</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.SW_BrokeringPackageImpl#getMemoryBroker()
	 * @generated
	 */
	int MEMORY_BROKER = 1;

	/**
	 * The feature id for the '<em><b>Res Mult</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__RES_MULT = SW_ResourceCorePackage.SW_RESOURCE__RES_MULT;

	/**
	 * The feature id for the '<em><b>Is Protected</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__IS_PROTECTED = SW_ResourceCorePackage.SW_RESOURCE__IS_PROTECTED;

	/**
	 * The feature id for the '<em><b>Is Active</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__IS_ACTIVE = SW_ResourceCorePackage.SW_RESOURCE__IS_ACTIVE;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__BASE_PROPERTY = SW_ResourceCorePackage.SW_RESOURCE__BASE_PROPERTY;

	/**
	 * The feature id for the '<em><b>Base Instance Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__BASE_INSTANCE_SPECIFICATION = SW_ResourceCorePackage.SW_RESOURCE__BASE_INSTANCE_SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Base Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__BASE_CLASSIFIER = SW_ResourceCorePackage.SW_RESOURCE__BASE_CLASSIFIER;

	/**
	 * The feature id for the '<em><b>Base Lifeline</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__BASE_LIFELINE = SW_ResourceCorePackage.SW_RESOURCE__BASE_LIFELINE;

	/**
	 * The feature id for the '<em><b>Base Connectable Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__BASE_CONNECTABLE_ELEMENT = SW_ResourceCorePackage.SW_RESOURCE__BASE_CONNECTABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Identifier Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__IDENTIFIER_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE__IDENTIFIER_ELEMENTS;

	/**
	 * The feature id for the '<em><b>State Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__STATE_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE__STATE_ELEMENTS;

	/**
	 * The feature id for the '<em><b>Memory Size Footprint</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__MEMORY_SIZE_FOOTPRINT = SW_ResourceCorePackage.SW_RESOURCE__MEMORY_SIZE_FOOTPRINT;

	/**
	 * The feature id for the '<em><b>Create Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__CREATE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__CREATE_SERVICES;

	/**
	 * The feature id for the '<em><b>Delete Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__DELETE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__DELETE_SERVICES;

	/**
	 * The feature id for the '<em><b>Initialize Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__INITIALIZE_SERVICES = SW_ResourceCorePackage.SW_RESOURCE__INITIALIZE_SERVICES;

	/**
	 * The feature id for the '<em><b>Access Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__ACCESS_POLICY = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Memories</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__MEMORIES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Memory Block Adress Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__MEMORY_BLOCK_ADRESS_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Memory Block Size Elements</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__MEMORY_BLOCK_SIZE_ELEMENTS = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Lock Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__LOCK_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Unlock Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__UNLOCK_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Map Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__MAP_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Un Map Services</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER__UN_MAP_SERVICES = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Memory Broker</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMORY_BROKER_FEATURE_COUNT = SW_ResourceCorePackage.SW_RESOURCE_FEATURE_COUNT + 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.AccessPolicyKind <em>Access Policy Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.AccessPolicyKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.SW_BrokeringPackageImpl#getAccessPolicyKind()
	 * @generated
	 */
	int ACCESS_POLICY_KIND = 2;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker <em>Device Broker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Broker</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker
	 * @generated
	 */
	EClass getDeviceBroker();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getAccessPolicy <em>Access Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Policy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getAccessPolicy()
	 * @see #getDeviceBroker()
	 * @generated
	 */
	EAttribute getDeviceBroker_AccessPolicy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#isIsBuffered <em>Is Buffered</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Buffered</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#isIsBuffered()
	 * @see #getDeviceBroker()
	 * @generated
	 */
	EAttribute getDeviceBroker_IsBuffered();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getDevices <em>Devices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Devices</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getDevices()
	 * @see #getDeviceBroker()
	 * @generated
	 */
	EReference getDeviceBroker_Devices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getCloseServices <em>Close Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Close Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getCloseServices()
	 * @see #getDeviceBroker()
	 * @generated
	 */
	EReference getDeviceBroker_CloseServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getControlServices <em>Control Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Control Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getControlServices()
	 * @see #getDeviceBroker()
	 * @generated
	 */
	EReference getDeviceBroker_ControlServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getOpenServices <em>Open Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Open Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getOpenServices()
	 * @see #getDeviceBroker()
	 * @generated
	 */
	EReference getDeviceBroker_OpenServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getReadServices <em>Read Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Read Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getReadServices()
	 * @see #getDeviceBroker()
	 * @generated
	 */
	EReference getDeviceBroker_ReadServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getWriteServices <em>Write Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Write Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.DeviceBroker#getWriteServices()
	 * @see #getDeviceBroker()
	 * @generated
	 */
	EReference getDeviceBroker_WriteServices();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker <em>Memory Broker</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Memory Broker</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker
	 * @generated
	 */
	EClass getMemoryBroker();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getAccessPolicy <em>Access Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Access Policy</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getAccessPolicy()
	 * @see #getMemoryBroker()
	 * @generated
	 */
	EAttribute getMemoryBroker_AccessPolicy();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMemories <em>Memories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Memories</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMemories()
	 * @see #getMemoryBroker()
	 * @generated
	 */
	EReference getMemoryBroker_Memories();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMemoryBlockAdressElements <em>Memory Block Adress Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Memory Block Adress Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMemoryBlockAdressElements()
	 * @see #getMemoryBroker()
	 * @generated
	 */
	EReference getMemoryBroker_MemoryBlockAdressElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMemoryBlockSizeElements <em>Memory Block Size Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Memory Block Size Elements</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMemoryBlockSizeElements()
	 * @see #getMemoryBroker()
	 * @generated
	 */
	EReference getMemoryBroker_MemoryBlockSizeElements();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getLockServices <em>Lock Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Lock Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getLockServices()
	 * @see #getMemoryBroker()
	 * @generated
	 */
	EReference getMemoryBroker_LockServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getUnlockServices <em>Unlock Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Unlock Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getUnlockServices()
	 * @see #getMemoryBroker()
	 * @generated
	 */
	EReference getMemoryBroker_UnlockServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMapServices <em>Map Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Map Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getMapServices()
	 * @see #getMemoryBroker()
	 * @generated
	 */
	EReference getMemoryBroker_MapServices();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getUnMapServices <em>Un Map Services</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Un Map Services</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.MemoryBroker#getUnMapServices()
	 * @see #getMemoryBroker()
	 * @generated
	 */
	EReference getMemoryBroker_UnMapServices();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.AccessPolicyKind <em>Access Policy Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Access Policy Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.AccessPolicyKind
	 * @generated
	 */
	EEnum getAccessPolicyKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SW_BrokeringFactory getSW_BrokeringFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl <em>Device Broker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.DeviceBrokerImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.SW_BrokeringPackageImpl#getDeviceBroker()
		 * @generated
		 */
		EClass DEVICE_BROKER = eINSTANCE.getDeviceBroker();

		/**
		 * The meta object literal for the '<em><b>Access Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE_BROKER__ACCESS_POLICY = eINSTANCE.getDeviceBroker_AccessPolicy();

		/**
		 * The meta object literal for the '<em><b>Is Buffered</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEVICE_BROKER__IS_BUFFERED = eINSTANCE.getDeviceBroker_IsBuffered();

		/**
		 * The meta object literal for the '<em><b>Devices</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_BROKER__DEVICES = eINSTANCE.getDeviceBroker_Devices();

		/**
		 * The meta object literal for the '<em><b>Close Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_BROKER__CLOSE_SERVICES = eINSTANCE.getDeviceBroker_CloseServices();

		/**
		 * The meta object literal for the '<em><b>Control Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_BROKER__CONTROL_SERVICES = eINSTANCE.getDeviceBroker_ControlServices();

		/**
		 * The meta object literal for the '<em><b>Open Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_BROKER__OPEN_SERVICES = eINSTANCE.getDeviceBroker_OpenServices();

		/**
		 * The meta object literal for the '<em><b>Read Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_BROKER__READ_SERVICES = eINSTANCE.getDeviceBroker_ReadServices();

		/**
		 * The meta object literal for the '<em><b>Write Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEVICE_BROKER__WRITE_SERVICES = eINSTANCE.getDeviceBroker_WriteServices();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl <em>Memory Broker</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.MemoryBrokerImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.SW_BrokeringPackageImpl#getMemoryBroker()
		 * @generated
		 */
		EClass MEMORY_BROKER = eINSTANCE.getMemoryBroker();

		/**
		 * The meta object literal for the '<em><b>Access Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MEMORY_BROKER__ACCESS_POLICY = eINSTANCE.getMemoryBroker_AccessPolicy();

		/**
		 * The meta object literal for the '<em><b>Memories</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_BROKER__MEMORIES = eINSTANCE.getMemoryBroker_Memories();

		/**
		 * The meta object literal for the '<em><b>Memory Block Adress Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_BROKER__MEMORY_BLOCK_ADRESS_ELEMENTS = eINSTANCE.getMemoryBroker_MemoryBlockAdressElements();

		/**
		 * The meta object literal for the '<em><b>Memory Block Size Elements</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_BROKER__MEMORY_BLOCK_SIZE_ELEMENTS = eINSTANCE.getMemoryBroker_MemoryBlockSizeElements();

		/**
		 * The meta object literal for the '<em><b>Lock Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_BROKER__LOCK_SERVICES = eINSTANCE.getMemoryBroker_LockServices();

		/**
		 * The meta object literal for the '<em><b>Unlock Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_BROKER__UNLOCK_SERVICES = eINSTANCE.getMemoryBroker_UnlockServices();

		/**
		 * The meta object literal for the '<em><b>Map Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_BROKER__MAP_SERVICES = eINSTANCE.getMemoryBroker_MapServices();

		/**
		 * The meta object literal for the '<em><b>Un Map Services</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMORY_BROKER__UN_MAP_SERVICES = eINSTANCE.getMemoryBroker_UnMapServices();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.AccessPolicyKind <em>Access Policy Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.AccessPolicyKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.SRM.SW_Brokering.impl.SW_BrokeringPackageImpl#getAccessPolicyKind()
		 * @generated
		 */
		EEnum ACCESS_POLICY_KIND = eINSTANCE.getAccessPolicyKind();

	}

} //SW_BrokeringPackage
