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
package org.eclipse.papyrus.eastadl.timing.events;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.papyrus.eastadl.timing.TimingPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * <!-- begin-model-doc -->
 * This section describes the concept of events for EAST-ADL2.
 * <!-- end-model-doc -->
 * 
 * @see org.eclipse.papyrus.eastadl.timing.events.EventsFactory
 * @model kind="package"
 * @generated
 */
public interface EventsPackage extends EPackage {

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	interface Literals {

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionFlowPortImpl
		 * <em>Event Function Flow Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionFlowPortImpl
		 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventsPackageImpl#getEventFunctionFlowPort()
		 * @generated
		 */
		EClass EVENT_FUNCTION_FLOW_PORT = eINSTANCE.getEventFunctionFlowPort();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EVENT_FUNCTION_FLOW_PORT__PORT = eINSTANCE.getEventFunctionFlowPort_Port();

		/**
		 * The meta object literal for the '<em><b>Port path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EVENT_FUNCTION_FLOW_PORT__PORT_PATH = eINSTANCE.getEventFunctionFlowPort_Port_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionClientServerPortImpl
		 * <em>Event Function Client Server Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionClientServerPortImpl
		 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventsPackageImpl#getEventFunctionClientServerPort()
		 * @generated
		 */
		EClass EVENT_FUNCTION_CLIENT_SERVER_PORT = eINSTANCE.getEventFunctionClientServerPort();

		/**
		 * The meta object literal for the '<em><b>Event Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute EVENT_FUNCTION_CLIENT_SERVER_PORT__EVENT_KIND = eINSTANCE.getEventFunctionClientServerPort_EventKind();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT = eINSTANCE.getEventFunctionClientServerPort_Port();

		/**
		 * The meta object literal for the '<em><b>Port path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT_PATH = eINSTANCE.getEventFunctionClientServerPort_Port_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionImpl <em>Event Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionImpl
		 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventsPackageImpl#getEventFunction()
		 * @generated
		 */
		EClass EVENT_FUNCTION = eINSTANCE.getEventFunction();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EVENT_FUNCTION__FUNCTION = eINSTANCE.getEventFunction_Function();

		/**
		 * The meta object literal for the '<em><b>Function Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EVENT_FUNCTION__FUNCTION_TYPE = eINSTANCE.getEventFunction_FunctionType();

		/**
		 * The meta object literal for the '<em><b>Function path</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference EVENT_FUNCTION__FUNCTION_PATH = eINSTANCE.getEventFunction_Function_path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPortKind
		 * <em>Event Function Client Server Port Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPortKind
		 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventsPackageImpl#getEventFunctionClientServerPortKind()
		 * @generated
		 */
		EEnum EVENT_FUNCTION_CLIENT_SERVER_PORT_KIND = eINSTANCE.getEventFunctionClientServerPortKind();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "events";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://www.papyrusuml.org/EAST-ADL2/Timing/Events/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "Events";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	EventsPackage eINSTANCE = org.eclipse.papyrus.eastadl.timing.events.impl.EventsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionFlowPortImpl <em>Event Function Flow Port</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionFlowPortImpl
	 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventsPackageImpl#getEventFunctionFlowPort()
	 * @generated
	 */
	int EVENT_FUNCTION_FLOW_PORT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_FLOW_PORT__NAME = TimingPackage.EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_FLOW_PORT__BASE_NAMED_ELEMENT = TimingPackage.EVENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_FLOW_PORT__OWNED_COMMENT = TimingPackage.EVENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_FLOW_PORT__BASE_CLASS = TimingPackage.EVENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Is State Changed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_FLOW_PORT__IS_STATE_CHANGED = TimingPackage.EVENT__IS_STATE_CHANGED;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_FLOW_PORT__PORT = TimingPackage.EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_FLOW_PORT__PORT_PATH = TimingPackage.EVENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event Function Flow Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_FLOW_PORT_FEATURE_COUNT = TimingPackage.EVENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionClientServerPortImpl
	 * <em>Event Function Client Server Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionClientServerPortImpl
	 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventsPackageImpl#getEventFunctionClientServerPort()
	 * @generated
	 */
	int EVENT_FUNCTION_CLIENT_SERVER_PORT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_CLIENT_SERVER_PORT__NAME = TimingPackage.EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_CLIENT_SERVER_PORT__BASE_NAMED_ELEMENT = TimingPackage.EVENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_CLIENT_SERVER_PORT__OWNED_COMMENT = TimingPackage.EVENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_CLIENT_SERVER_PORT__BASE_CLASS = TimingPackage.EVENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Is State Changed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_CLIENT_SERVER_PORT__IS_STATE_CHANGED = TimingPackage.EVENT__IS_STATE_CHANGED;

	/**
	 * The feature id for the '<em><b>Event Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_CLIENT_SERVER_PORT__EVENT_KIND = TimingPackage.EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT = TimingPackage.EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Port path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_CLIENT_SERVER_PORT__PORT_PATH = TimingPackage.EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Event Function Client Server Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_CLIENT_SERVER_PORT_FEATURE_COUNT = TimingPackage.EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionImpl <em>Event Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventFunctionImpl
	 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventsPackageImpl#getEventFunction()
	 * @generated
	 */
	int EVENT_FUNCTION = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION__NAME = TimingPackage.EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Base Named Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION__BASE_NAMED_ELEMENT = TimingPackage.EVENT__BASE_NAMED_ELEMENT;

	/**
	 * The feature id for the '<em><b>Owned Comment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION__OWNED_COMMENT = TimingPackage.EVENT__OWNED_COMMENT;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION__BASE_CLASS = TimingPackage.EVENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Is State Changed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION__IS_STATE_CHANGED = TimingPackage.EVENT__IS_STATE_CHANGED;

	/**
	 * The feature id for the '<em><b>Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION__FUNCTION = TimingPackage.EVENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION__FUNCTION_TYPE = TimingPackage.EVENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Function path</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION__FUNCTION_PATH = TimingPackage.EVENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Event Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int EVENT_FUNCTION_FEATURE_COUNT = TimingPackage.EVENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPortKind
	 * <em>Event Function Client Server Port Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPortKind
	 * @see org.eclipse.papyrus.eastadl.timing.events.impl.EventsPackageImpl#getEventFunctionClientServerPortKind()
	 * @generated
	 */
	int EVENT_FUNCTION_CLIENT_SERVER_PORT_KIND = 3;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunction <em>Event Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Event Function</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunction
	 * @generated
	 */
	EClass getEventFunction();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunction#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Function</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunction#getFunction()
	 * @see #getEventFunction()
	 * @generated
	 */
	EReference getEventFunction_Function();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunction#getFunctionType
	 * <em>Function Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Function Type</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunction#getFunctionType()
	 * @see #getEventFunction()
	 * @generated
	 */
	EReference getEventFunction_FunctionType();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunction#getFunction_path
	 * <em>Function path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Function path</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunction#getFunction_path()
	 * @see #getEventFunction()
	 * @generated
	 */
	EReference getEventFunction_Function_path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPort
	 * <em>Event Function Client Server Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Event Function Client Server Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPort
	 * @generated
	 */
	EClass getEventFunctionClientServerPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPort#getEventKind
	 * <em>Event Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Event Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPort#getEventKind()
	 * @see #getEventFunctionClientServerPort()
	 * @generated
	 */
	EAttribute getEventFunctionClientServerPort_EventKind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPort#getPort
	 * <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPort#getPort()
	 * @see #getEventFunctionClientServerPort()
	 * @generated
	 */
	EReference getEventFunctionClientServerPort_Port();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPort#getPort_path
	 * <em>Port path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port path</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPort#getPort_path()
	 * @see #getEventFunctionClientServerPort()
	 * @generated
	 */
	EReference getEventFunctionClientServerPort_Port_path();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPortKind
	 * <em>Event Function Client Server Port Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Event Function Client Server Port Kind</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunctionClientServerPortKind
	 * @generated
	 */
	EEnum getEventFunctionClientServerPortKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionFlowPort <em>Event Function Flow Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Event Function Flow Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunctionFlowPort
	 * @generated
	 */
	EClass getEventFunctionFlowPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionFlowPort#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunctionFlowPort#getPort()
	 * @see #getEventFunctionFlowPort()
	 * @generated
	 */
	EReference getEventFunctionFlowPort_Port();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.eastadl.timing.events.EventFunctionFlowPort#getPort_path
	 * <em>Port path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Port path</em>'.
	 * @see org.eclipse.papyrus.eastadl.timing.events.EventFunctionFlowPort#getPort_path()
	 * @see #getEventFunctionFlowPort()
	 * @generated
	 */
	EReference getEventFunctionFlowPort_Port_path();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EventsFactory getEventsFactory();

} //EventsPackage
