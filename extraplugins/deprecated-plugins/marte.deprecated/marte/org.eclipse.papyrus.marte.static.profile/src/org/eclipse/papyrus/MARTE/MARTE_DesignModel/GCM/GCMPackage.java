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
package org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMFactory
 * @model kind="package"
 * @generated
 */
public interface GCMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "GCM";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/GCM/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "GCM";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GCMPackage eINSTANCE = org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowPropertyImpl <em>Flow Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowPropertyImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getFlowProperty()
	 * @generated
	 */
	int FLOW_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_PROPERTY__DIRECTION = 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_PROPERTY__BASE_PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Flow Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowPortImpl <em>Flow Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowPortImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getFlowPort()
	 * @generated
	 */
	int FLOW_PORT = 1;

	/**
	 * The feature id for the '<em><b>Is Atomic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT__IS_ATOMIC = 0;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT__DIRECTION = 1;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT__BASE_PORT = 2;

	/**
	 * The number of structural features of the '<em>Flow Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_PORT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerPortImpl <em>Client Server Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerPortImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getClientServerPort()
	 * @generated
	 */
	int CLIENT_SERVER_PORT = 2;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_PORT__BASE_PORT = 0;

	/**
	 * The feature id for the '<em><b>Specification Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_PORT__SPECIFICATION_KIND = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_PORT__KIND = 2;

	/**
	 * The feature id for the '<em><b>Prov Interface</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_PORT__PROV_INTERFACE = 3;

	/**
	 * The feature id for the '<em><b>Req Interface</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_PORT__REQ_INTERFACE = 4;

	/**
	 * The feature id for the '<em><b>Features Spec</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_PORT__FEATURES_SPEC = 5;

	/**
	 * The number of structural features of the '<em>Client Server Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_PORT_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerSpecificationImpl <em>Client Server Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerSpecificationImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getClientServerSpecification()
	 * @generated
	 */
	int CLIENT_SERVER_SPECIFICATION = 3;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_SPECIFICATION__BASE_INTERFACE = 0;

	/**
	 * The number of structural features of the '<em>Client Server Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_SPECIFICATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowSpecificationImpl <em>Flow Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowSpecificationImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getFlowSpecification()
	 * @generated
	 */
	int FLOW_SPECIFICATION = 4;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION__BASE_INTERFACE = 0;

	/**
	 * The number of structural features of the '<em>Flow Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOW_SPECIFICATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerFeatureImpl <em>Client Server Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerFeatureImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getClientServerFeature()
	 * @generated
	 */
	int CLIENT_SERVER_FEATURE = 5;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_FEATURE__KIND = 0;

	/**
	 * The feature id for the '<em><b>Base Behavioral Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_FEATURE__BASE_BEHAVIORAL_FEATURE = 1;

	/**
	 * The number of structural features of the '<em>Client Server Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLIENT_SERVER_FEATURE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMTriggerImpl <em>Trigger</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMTriggerImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getGCMTrigger()
	 * @generated
	 */
	int GCM_TRIGGER = 6;

	/**
	 * The feature id for the '<em><b>Base Trigger</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCM_TRIGGER__BASE_TRIGGER = 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCM_TRIGGER__FEATURE = 1;

	/**
	 * The number of structural features of the '<em>Trigger</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCM_TRIGGER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocationActionImpl <em>Invocation Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocationActionImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getGCMInvocationAction()
	 * @generated
	 */
	int GCM_INVOCATION_ACTION = 7;

	/**
	 * The feature id for the '<em><b>Base Invocation Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCM_INVOCATION_ACTION__BASE_INVOCATION_ACTION = 0;

	/**
	 * The feature id for the '<em><b>On Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCM_INVOCATION_ACTION__ON_FEATURE = 1;

	/**
	 * The number of structural features of the '<em>Invocation Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCM_INVOCATION_ACTION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.DataEventImpl <em>Data Event</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.DataEventImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getDataEvent()
	 * @generated
	 */
	int DATA_EVENT = 8;

	/**
	 * The feature id for the '<em><b>Base Any Receive Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EVENT__BASE_ANY_RECEIVE_EVENT = 0;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EVENT__CLASSIFIER = 1;

	/**
	 * The number of structural features of the '<em>Data Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_EVENT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.DataPoolImpl <em>Data Pool</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.DataPoolImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getDataPool()
	 * @generated
	 */
	int DATA_POOL = 9;

	/**
	 * The feature id for the '<em><b>Ordering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_POOL__ORDERING = 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_POOL__BASE_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Insertion</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_POOL__INSERTION = 2;

	/**
	 * The feature id for the '<em><b>Selection</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_POOL__SELECTION = 3;

	/**
	 * The number of structural features of the '<em>Data Pool</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_POOL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocatingBehaviorImpl <em>Invocating Behavior</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocatingBehaviorImpl
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getGCMInvocatingBehavior()
	 * @generated
	 */
	int GCM_INVOCATING_BEHAVIOR = 10;

	/**
	 * The feature id for the '<em><b>Base Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCM_INVOCATING_BEHAVIOR__BASE_BEHAVIOR = 0;

	/**
	 * The feature id for the '<em><b>On Ports</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCM_INVOCATING_BEHAVIOR__ON_PORTS = 1;

	/**
	 * The feature id for the '<em><b>On Features</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCM_INVOCATING_BEHAVIOR__ON_FEATURES = 2;

	/**
	 * The feature id for the '<em><b>Invocations</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCM_INVOCATING_BEHAVIOR__INVOCATIONS = 3;

	/**
	 * The number of structural features of the '<em>Invocating Behavior</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GCM_INVOCATING_BEHAVIOR_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowDirectionKind <em>Flow Direction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowDirectionKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getFlowDirectionKind()
	 * @generated
	 */
	int FLOW_DIRECTION_KIND = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.PortSpecificationKind <em>Port Specification Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.PortSpecificationKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getPortSpecificationKind()
	 * @generated
	 */
	int PORT_SPECIFICATION_KIND = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind <em>Client Server Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getClientServerKind()
	 * @generated
	 */
	int CLIENT_SERVER_KIND = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPoolOrderingKind <em>Data Pool Ordering Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPoolOrderingKind
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getDataPoolOrderingKind()
	 * @generated
	 */
	int DATA_POOL_ORDERING_KIND = 14;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowProperty <em>Flow Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Property</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowProperty
	 * @generated
	 */
	EClass getFlowProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowProperty#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowProperty#getDirection()
	 * @see #getFlowProperty()
	 * @generated
	 */
	EAttribute getFlowProperty_Direction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowProperty#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowProperty#getBase_Property()
	 * @see #getFlowProperty()
	 * @generated
	 */
	EReference getFlowProperty_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort <em>Flow Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Port</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort
	 * @generated
	 */
	EClass getFlowPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort#isIsAtomic <em>Is Atomic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Atomic</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort#isIsAtomic()
	 * @see #getFlowPort()
	 * @generated
	 */
	EAttribute getFlowPort_IsAtomic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort#getDirection()
	 * @see #getFlowPort()
	 * @generated
	 */
	EAttribute getFlowPort_Direction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowPort#getBase_Port()
	 * @see #getFlowPort()
	 * @generated
	 */
	EReference getFlowPort_Base_Port();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort <em>Client Server Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Client Server Port</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort
	 * @generated
	 */
	EClass getClientServerPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getBase_Port()
	 * @see #getClientServerPort()
	 * @generated
	 */
	EReference getClientServerPort_Base_Port();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getSpecificationKind <em>Specification Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Specification Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getSpecificationKind()
	 * @see #getClientServerPort()
	 * @generated
	 */
	EAttribute getClientServerPort_SpecificationKind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getKind()
	 * @see #getClientServerPort()
	 * @generated
	 */
	EAttribute getClientServerPort_Kind();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getProvInterface <em>Prov Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Prov Interface</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getProvInterface()
	 * @see #getClientServerPort()
	 * @generated
	 */
	EReference getClientServerPort_ProvInterface();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getReqInterface <em>Req Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Req Interface</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getReqInterface()
	 * @see #getClientServerPort()
	 * @generated
	 */
	EReference getClientServerPort_ReqInterface();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getFeaturesSpec <em>Features Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Features Spec</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerPort#getFeaturesSpec()
	 * @see #getClientServerPort()
	 * @generated
	 */
	EReference getClientServerPort_FeaturesSpec();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerSpecification <em>Client Server Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Client Server Specification</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerSpecification
	 * @generated
	 */
	EClass getClientServerSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerSpecification#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerSpecification#getBase_Interface()
	 * @see #getClientServerSpecification()
	 * @generated
	 */
	EReference getClientServerSpecification_Base_Interface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowSpecification <em>Flow Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Flow Specification</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowSpecification
	 * @generated
	 */
	EClass getFlowSpecification();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowSpecification#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowSpecification#getBase_Interface()
	 * @see #getFlowSpecification()
	 * @generated
	 */
	EReference getFlowSpecification_Base_Interface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerFeature <em>Client Server Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Client Server Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerFeature
	 * @generated
	 */
	EClass getClientServerFeature();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerFeature#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerFeature#getKind()
	 * @see #getClientServerFeature()
	 * @generated
	 */
	EAttribute getClientServerFeature_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerFeature#getBase_BehavioralFeature <em>Base Behavioral Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavioral Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerFeature#getBase_BehavioralFeature()
	 * @see #getClientServerFeature()
	 * @generated
	 */
	EReference getClientServerFeature_Base_BehavioralFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMTrigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Trigger</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMTrigger
	 * @generated
	 */
	EClass getGCMTrigger();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMTrigger#getBase_Trigger <em>Base Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Trigger</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMTrigger#getBase_Trigger()
	 * @see #getGCMTrigger()
	 * @generated
	 */
	EReference getGCMTrigger_Base_Trigger();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMTrigger#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMTrigger#getFeature()
	 * @see #getGCMTrigger()
	 * @generated
	 */
	EReference getGCMTrigger_Feature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocationAction <em>Invocation Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invocation Action</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocationAction
	 * @generated
	 */
	EClass getGCMInvocationAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocationAction#getBase_InvocationAction <em>Base Invocation Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Invocation Action</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocationAction#getBase_InvocationAction()
	 * @see #getGCMInvocationAction()
	 * @generated
	 */
	EReference getGCMInvocationAction_Base_InvocationAction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocationAction#getOnFeature <em>On Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>On Feature</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocationAction#getOnFeature()
	 * @see #getGCMInvocationAction()
	 * @generated
	 */
	EReference getGCMInvocationAction_OnFeature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataEvent <em>Data Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Event</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataEvent
	 * @generated
	 */
	EClass getDataEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataEvent#getBase_AnyReceiveEvent <em>Base Any Receive Event</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Any Receive Event</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataEvent#getBase_AnyReceiveEvent()
	 * @see #getDataEvent()
	 * @generated
	 */
	EReference getDataEvent_Base_AnyReceiveEvent();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataEvent#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Classifier</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataEvent#getClassifier()
	 * @see #getDataEvent()
	 * @generated
	 */
	EReference getDataEvent_Classifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPool <em>Data Pool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Pool</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPool
	 * @generated
	 */
	EClass getDataPool();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPool#getOrdering <em>Ordering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ordering</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPool#getOrdering()
	 * @see #getDataPool()
	 * @generated
	 */
	EAttribute getDataPool_Ordering();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPool#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPool#getBase_Property()
	 * @see #getDataPool()
	 * @generated
	 */
	EReference getDataPool_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPool#getInsertion <em>Insertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Insertion</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPool#getInsertion()
	 * @see #getDataPool()
	 * @generated
	 */
	EReference getDataPool_Insertion();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPool#getSelection <em>Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Selection</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPool#getSelection()
	 * @see #getDataPool()
	 * @generated
	 */
	EReference getDataPool_Selection();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior <em>Invocating Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Invocating Behavior</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior
	 * @generated
	 */
	EClass getGCMInvocatingBehavior();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior#getBase_Behavior <em>Base Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Behavior</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior#getBase_Behavior()
	 * @see #getGCMInvocatingBehavior()
	 * @generated
	 */
	EReference getGCMInvocatingBehavior_Base_Behavior();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior#getOnPorts <em>On Ports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Ports</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior#getOnPorts()
	 * @see #getGCMInvocatingBehavior()
	 * @generated
	 */
	EReference getGCMInvocatingBehavior_OnPorts();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior#getOnFeatures <em>On Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>On Features</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior#getOnFeatures()
	 * @see #getGCMInvocatingBehavior()
	 * @generated
	 */
	EReference getGCMInvocatingBehavior_OnFeatures();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior#getInvocations <em>Invocations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Invocations</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.GCMInvocatingBehavior#getInvocations()
	 * @see #getGCMInvocatingBehavior()
	 * @generated
	 */
	EReference getGCMInvocatingBehavior_Invocations();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowDirectionKind <em>Flow Direction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Flow Direction Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowDirectionKind
	 * @generated
	 */
	EEnum getFlowDirectionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.PortSpecificationKind <em>Port Specification Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Port Specification Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.PortSpecificationKind
	 * @generated
	 */
	EEnum getPortSpecificationKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind <em>Client Server Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Client Server Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind
	 * @generated
	 */
	EEnum getClientServerKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPoolOrderingKind <em>Data Pool Ordering Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Pool Ordering Kind</em>'.
	 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPoolOrderingKind
	 * @generated
	 */
	EEnum getDataPoolOrderingKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GCMFactory getGCMFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowPropertyImpl <em>Flow Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowPropertyImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getFlowProperty()
		 * @generated
		 */
		EClass FLOW_PROPERTY = eINSTANCE.getFlowProperty();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW_PROPERTY__DIRECTION = eINSTANCE.getFlowProperty_Direction();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_PROPERTY__BASE_PROPERTY = eINSTANCE.getFlowProperty_Base_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowPortImpl <em>Flow Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowPortImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getFlowPort()
		 * @generated
		 */
		EClass FLOW_PORT = eINSTANCE.getFlowPort();

		/**
		 * The meta object literal for the '<em><b>Is Atomic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW_PORT__IS_ATOMIC = eINSTANCE.getFlowPort_IsAtomic();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FLOW_PORT__DIRECTION = eINSTANCE.getFlowPort_Direction();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_PORT__BASE_PORT = eINSTANCE.getFlowPort_Base_Port();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerPortImpl <em>Client Server Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerPortImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getClientServerPort()
		 * @generated
		 */
		EClass CLIENT_SERVER_PORT = eINSTANCE.getClientServerPort();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLIENT_SERVER_PORT__BASE_PORT = eINSTANCE.getClientServerPort_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Specification Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIENT_SERVER_PORT__SPECIFICATION_KIND = eINSTANCE.getClientServerPort_SpecificationKind();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIENT_SERVER_PORT__KIND = eINSTANCE.getClientServerPort_Kind();

		/**
		 * The meta object literal for the '<em><b>Prov Interface</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLIENT_SERVER_PORT__PROV_INTERFACE = eINSTANCE.getClientServerPort_ProvInterface();

		/**
		 * The meta object literal for the '<em><b>Req Interface</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLIENT_SERVER_PORT__REQ_INTERFACE = eINSTANCE.getClientServerPort_ReqInterface();

		/**
		 * The meta object literal for the '<em><b>Features Spec</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLIENT_SERVER_PORT__FEATURES_SPEC = eINSTANCE.getClientServerPort_FeaturesSpec();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerSpecificationImpl <em>Client Server Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerSpecificationImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getClientServerSpecification()
		 * @generated
		 */
		EClass CLIENT_SERVER_SPECIFICATION = eINSTANCE.getClientServerSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLIENT_SERVER_SPECIFICATION__BASE_INTERFACE = eINSTANCE.getClientServerSpecification_Base_Interface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowSpecificationImpl <em>Flow Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.FlowSpecificationImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getFlowSpecification()
		 * @generated
		 */
		EClass FLOW_SPECIFICATION = eINSTANCE.getFlowSpecification();

		/**
		 * The meta object literal for the '<em><b>Base Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FLOW_SPECIFICATION__BASE_INTERFACE = eINSTANCE.getFlowSpecification_Base_Interface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerFeatureImpl <em>Client Server Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.ClientServerFeatureImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getClientServerFeature()
		 * @generated
		 */
		EClass CLIENT_SERVER_FEATURE = eINSTANCE.getClientServerFeature();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CLIENT_SERVER_FEATURE__KIND = eINSTANCE.getClientServerFeature_Kind();

		/**
		 * The meta object literal for the '<em><b>Base Behavioral Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CLIENT_SERVER_FEATURE__BASE_BEHAVIORAL_FEATURE = eINSTANCE.getClientServerFeature_Base_BehavioralFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMTriggerImpl <em>Trigger</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMTriggerImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getGCMTrigger()
		 * @generated
		 */
		EClass GCM_TRIGGER = eINSTANCE.getGCMTrigger();

		/**
		 * The meta object literal for the '<em><b>Base Trigger</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GCM_TRIGGER__BASE_TRIGGER = eINSTANCE.getGCMTrigger_Base_Trigger();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GCM_TRIGGER__FEATURE = eINSTANCE.getGCMTrigger_Feature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocationActionImpl <em>Invocation Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocationActionImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getGCMInvocationAction()
		 * @generated
		 */
		EClass GCM_INVOCATION_ACTION = eINSTANCE.getGCMInvocationAction();

		/**
		 * The meta object literal for the '<em><b>Base Invocation Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GCM_INVOCATION_ACTION__BASE_INVOCATION_ACTION = eINSTANCE.getGCMInvocationAction_Base_InvocationAction();

		/**
		 * The meta object literal for the '<em><b>On Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GCM_INVOCATION_ACTION__ON_FEATURE = eINSTANCE.getGCMInvocationAction_OnFeature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.DataEventImpl <em>Data Event</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.DataEventImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getDataEvent()
		 * @generated
		 */
		EClass DATA_EVENT = eINSTANCE.getDataEvent();

		/**
		 * The meta object literal for the '<em><b>Base Any Receive Event</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_EVENT__BASE_ANY_RECEIVE_EVENT = eINSTANCE.getDataEvent_Base_AnyReceiveEvent();

		/**
		 * The meta object literal for the '<em><b>Classifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_EVENT__CLASSIFIER = eINSTANCE.getDataEvent_Classifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.DataPoolImpl <em>Data Pool</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.DataPoolImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getDataPool()
		 * @generated
		 */
		EClass DATA_POOL = eINSTANCE.getDataPool();

		/**
		 * The meta object literal for the '<em><b>Ordering</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_POOL__ORDERING = eINSTANCE.getDataPool_Ordering();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_POOL__BASE_PROPERTY = eINSTANCE.getDataPool_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Insertion</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_POOL__INSERTION = eINSTANCE.getDataPool_Insertion();

		/**
		 * The meta object literal for the '<em><b>Selection</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_POOL__SELECTION = eINSTANCE.getDataPool_Selection();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocatingBehaviorImpl <em>Invocating Behavior</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMInvocatingBehaviorImpl
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getGCMInvocatingBehavior()
		 * @generated
		 */
		EClass GCM_INVOCATING_BEHAVIOR = eINSTANCE.getGCMInvocatingBehavior();

		/**
		 * The meta object literal for the '<em><b>Base Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GCM_INVOCATING_BEHAVIOR__BASE_BEHAVIOR = eINSTANCE.getGCMInvocatingBehavior_Base_Behavior();

		/**
		 * The meta object literal for the '<em><b>On Ports</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GCM_INVOCATING_BEHAVIOR__ON_PORTS = eINSTANCE.getGCMInvocatingBehavior_OnPorts();

		/**
		 * The meta object literal for the '<em><b>On Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GCM_INVOCATING_BEHAVIOR__ON_FEATURES = eINSTANCE.getGCMInvocatingBehavior_OnFeatures();

		/**
		 * The meta object literal for the '<em><b>Invocations</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GCM_INVOCATING_BEHAVIOR__INVOCATIONS = eINSTANCE.getGCMInvocatingBehavior_Invocations();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowDirectionKind <em>Flow Direction Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.FlowDirectionKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getFlowDirectionKind()
		 * @generated
		 */
		EEnum FLOW_DIRECTION_KIND = eINSTANCE.getFlowDirectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.PortSpecificationKind <em>Port Specification Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.PortSpecificationKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getPortSpecificationKind()
		 * @generated
		 */
		EEnum PORT_SPECIFICATION_KIND = eINSTANCE.getPortSpecificationKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind <em>Client Server Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.ClientServerKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getClientServerKind()
		 * @generated
		 */
		EEnum CLIENT_SERVER_KIND = eINSTANCE.getClientServerKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPoolOrderingKind <em>Data Pool Ordering Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.DataPoolOrderingKind
		 * @see org.eclipse.papyrus.MARTE.MARTE_DesignModel.GCM.impl.GCMPackageImpl#getDataPoolOrderingKind()
		 * @generated
		 */
		EEnum DATA_POOL_ORDERING_KIND = eINSTANCE.getDataPoolOrderingKind();

	}

} //GCMPackage
