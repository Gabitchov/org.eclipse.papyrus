/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.RobotML;

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
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.papyrus.RobotML.RobotMLFactory
 * @model kind="package"
 * @generated
 */
public interface RobotMLPackage extends EPackage {

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNAME = "RobotML";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_URI = "http://Papyrus/RobotML/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	String eNS_PREFIX = "RobotML";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	RobotMLPackage eINSTANCE = org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.TransitionImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION__BASE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GUARD = 1;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EFFECT = 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.AlgorithmImpl <em>Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.AlgorithmImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAlgorithm()
	 * @generated
	 */
	int ALGORITHM = 1;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__BASE_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Is External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__IS_EXTERNAL = 1;

	/**
	 * The feature id for the '<em><b>Ext Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__EXT_FUNCTION_NAME = 2;

	/**
	 * The feature id for the '<em><b>Lib Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__LIB_PATH = 3;

	/**
	 * The feature id for the '<em><b>Lib File Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__LIB_FILE_FORMAT = 4;

	/**
	 * The number of structural features of the '<em>Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_FEATURE_COUNT = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.SystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 3;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NATIVE = 1;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM__LIBRARY_PATH = 2;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM__LIBRARY_COMPONENT_NAME = 3;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PhysicalObjectImpl <em>Physical Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.PhysicalObjectImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPhysicalObject()
	 * @generated
	 */
	int PHYSICAL_OBJECT = 5;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__EVELOVES_IN = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__HAS_SURFACE = SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Physical Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.AgentImpl <em>Agent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.AgentImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAgent()
	 * @generated
	 */
	int AGENT = 4;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AGENT__BASE_CLASS = PHYSICAL_OBJECT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AGENT__NATIVE = PHYSICAL_OBJECT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AGENT__LIBRARY_PATH = PHYSICAL_OBJECT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AGENT__LIBRARY_COMPONENT_NAME = PHYSICAL_OBJECT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AGENT__EVELOVES_IN = PHYSICAL_OBJECT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AGENT__HAS_SURFACE = PHYSICAL_OBJECT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Moves Over</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AGENT__MOVES_OVER = PHYSICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int AGENT_FEATURE_COUNT = PHYSICAL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.RobotImpl <em>Robot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.RobotImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRobot()
	 * @generated
	 */
	int ROBOT = 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT__BASE_CLASS = AGENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT__NATIVE = AGENT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT__LIBRARY_PATH = AGENT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT__LIBRARY_COMPONENT_NAME = AGENT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT__EVELOVES_IN = AGENT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT__HAS_SURFACE = AGENT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Moves Over</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT__MOVES_OVER = AGENT__MOVES_OVER;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT__KIND = AGENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT__MASS = AGENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT__WIDTH = AGENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Ugv Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT__UGV_KIND = AGENT_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Robot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOT_FEATURE_COUNT = AGENT_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.EnvironmentImpl <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.EnvironmentImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getEnvironment()
	 * @generated
	 */
	int ENVIRONMENT = 6;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The number of structural features of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SurfaceImpl <em>Surface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.SurfaceImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSurface()
	 * @generated
	 */
	int SURFACE = 7;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SURFACE__BASE_CLASS = PHYSICAL_OBJECT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SURFACE__NATIVE = PHYSICAL_OBJECT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SURFACE__LIBRARY_PATH = PHYSICAL_OBJECT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SURFACE__LIBRARY_COMPONENT_NAME = PHYSICAL_OBJECT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SURFACE__EVELOVES_IN = PHYSICAL_OBJECT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SURFACE__HAS_SURFACE = PHYSICAL_OBJECT__HAS_SURFACE;

	/**
	 * The number of structural features of the '<em>Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SURFACE_FEATURE_COUNT = PHYSICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.PortImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 9;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__BASE_PORT = 0;

	/**
	 * The feature id for the '<em><b>Synchronization Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT__SYNCHRONIZATION_POLICY = 1;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.DataFlowPortImpl <em>Data Flow Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.DataFlowPortImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDataFlowPort()
	 * @generated
	 */
	int DATA_FLOW_PORT = 8;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_PORT__BASE_PORT = PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Synchronization Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_PORT__SYNCHRONIZATION_POLICY = PORT__SYNCHRONIZATION_POLICY;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_PORT__DIRECTION = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_PORT__BUFFER_SIZE = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Flow Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ServicePortImpl <em>Service Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.ServicePortImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getServicePort()
	 * @generated
	 */
	int SERVICE_PORT = 10;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE_PORT__BASE_PORT = PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Synchronization Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE_PORT__SYNCHRONIZATION_POLICY = PORT__SYNCHRONIZATION_POLICY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE_PORT__KIND = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Service Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SERVICE_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticSystemImpl <em>Robotic System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.RoboticSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticSystem()
	 * @generated
	 */
	int ROBOTIC_SYSTEM = 12;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__LOCAL_POSITION = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__LOCAL_ORIENTATION = SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Robotic System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ActuatorSystemImpl <em>Actuator System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.ActuatorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getActuatorSystem()
	 * @generated
	 */
	int ACTUATOR_SYSTEM = 11;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__BASE_CLASS = ROBOTIC_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__NATIVE = ROBOTIC_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__LIBRARY_PATH = ROBOTIC_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__LIBRARY_COMPONENT_NAME = ROBOTIC_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__LOCAL_POSITION = ROBOTIC_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__LOCAL_ORIENTATION = ROBOTIC_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The number of structural features of the '<em>Actuator System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM_FEATURE_COUNT = ROBOTIC_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SensorSystemImpl <em>Sensor System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.SensorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSensorSystem()
	 * @generated
	 */
	int SENSOR_SYSTEM = 13;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__BASE_CLASS = ROBOTIC_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__NATIVE = ROBOTIC_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__LIBRARY_PATH = ROBOTIC_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME = ROBOTIC_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__LOCAL_POSITION = ROBOTIC_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__LOCAL_ORIENTATION = ROBOTIC_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__FREQUENCY = ROBOTIC_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__IDENTIFIER = ROBOTIC_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM_FEATURE_COUNT = ROBOTIC_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.HardwareImpl <em>Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.HardwareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getHardware()
	 * @generated
	 */
	int HARDWARE = 14;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The number of structural features of the '<em>Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SoftwareImpl <em>Software</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.SoftwareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSoftware()
	 * @generated
	 */
	int SOFTWARE = 15;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Is Periodic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__IS_PERIODIC = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__PERIOD = SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__PRIORITY = SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__DEADLINE = SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Wcet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__WCET = SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Software</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.DataTypeImpl <em>Data Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.DataTypeImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDataType()
	 * @generated
	 */
	int DATA_TYPE = 17;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__BASE_DATA_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__NATIVE = 1;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE__LIBRARY_PATH = 2;

	/**
	 * The number of structural features of the '<em>Data Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PrimitiveDataImpl <em>Primitive Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.PrimitiveDataImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPrimitiveData()
	 * @generated
	 */
	int PRIMITIVE_DATA = 16;

	/**
	 * The feature id for the '<em><b>Base Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA__BASE_DATA_TYPE = DATA_TYPE__BASE_DATA_TYPE;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA__NATIVE = DATA_TYPE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA__LIBRARY_PATH = DATA_TYPE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Base Primitive Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA__BASE_PRIMITIVE_TYPE = DATA_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_DATA_FEATURE_COUNT = DATA_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.EngineSystemImpl <em>Engine System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.EngineSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getEngineSystem()
	 * @generated
	 */
	int ENGINE_SYSTEM = 18;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__BASE_CLASS = ACTUATOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__NATIVE = ACTUATOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__LIBRARY_PATH = ACTUATOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__LIBRARY_COMPONENT_NAME = ACTUATOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__LOCAL_POSITION = ACTUATOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__LOCAL_ORIENTATION = ACTUATOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Vehicle Traction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__VEHICLE_TRACTION = ACTUATOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Engine Force</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__MAX_ENGINE_FORCE = ACTUATOR_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Breaking Force</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__MAX_BREAKING_FORCE = ACTUATOR_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Allowed Steering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__MAX_ALLOWED_STEERING = ACTUATOR_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Max Allowed Velocity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__MAX_ALLOWED_VELOCITY = ACTUATOR_SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Gear ration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__GEAR_RATION = ACTUATOR_SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Engine System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM_FEATURE_COUNT = ACTUATOR_SYSTEM_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.WheelSystemImpl <em>Wheel System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.WheelSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getWheelSystem()
	 * @generated
	 */
	int WHEEL_SYSTEM = 19;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__BASE_CLASS = ACTUATOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__NATIVE = ACTUATOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__LIBRARY_PATH = ACTUATOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__LIBRARY_COMPONENT_NAME = ACTUATOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__LOCAL_POSITION = ACTUATOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__LOCAL_ORIENTATION = ACTUATOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Wheel Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__WHEEL_RADIUS = ACTUATOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Wheel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__WHEEL_WIDTH = ACTUATOR_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Suspension Rest Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__SUSPENSION_REST_LENGTH = ACTUATOR_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Wheel Connection Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT = ACTUATOR_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type Of Wheel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__TYPE_OF_WHEEL = ACTUATOR_SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Wheel Velocity PI Dkp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP = ACTUATOR_SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wheel Velocity PI Dki</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI = ACTUATOR_SYSTEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wheel Velocity PI Dkd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD = ACTUATOR_SYSTEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Wheel Steering PI Dkp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP = ACTUATOR_SYSTEM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Wheel Steering PI Dkd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD = ACTUATOR_SYSTEM_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Wheel Friction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__WHEEL_FRICTION = ACTUATOR_SYSTEM_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Suspension Stiffness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__SUSPENSION_STIFFNESS = ACTUATOR_SYSTEM_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Suspension Damping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__SUSPENSION_DAMPING = ACTUATOR_SYSTEM_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Suspension Compression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__SUSPENSION_COMPRESSION = ACTUATOR_SYSTEM_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Wheel Velocity PI Dmax Sum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM = ACTUATOR_SYSTEM_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Wheel Velocity PI Dmax Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL = ACTUATOR_SYSTEM_FEATURE_COUNT + 15;

	/**
	 * The number of structural features of the '<em>Wheel System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WHEEL_SYSTEM_FEATURE_COUNT = ACTUATOR_SYSTEM_FEATURE_COUNT + 16;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ImageSensorSystemImpl <em>Image Sensor System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.ImageSensorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getImageSensorSystem()
	 * @generated
	 */
	int IMAGE_SENSOR_SYSTEM = 20;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Image Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl <em>Camera System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.CameraSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCameraSystem()
	 * @generated
	 */
	int CAMERA_SYSTEM = 21;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__BASE_CLASS = IMAGE_SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__NATIVE = IMAGE_SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__LIBRARY_PATH = IMAGE_SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__LIBRARY_COMPONENT_NAME = IMAGE_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__LOCAL_POSITION = IMAGE_SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__LOCAL_ORIENTATION = IMAGE_SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__FREQUENCY = IMAGE_SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__IDENTIFIER = IMAGE_SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__WIDTH = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__HEIGHT = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alpha u</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__ALPHA_U = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Alpha v</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__ALPHA_V = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>U0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__U0 = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>V0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__V0 = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Color format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__COLOR_FORMAT = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Translate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__TRANSLATE = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Rotate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__ROTATE = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Camera System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM_FEATURE_COUNT = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ObjectDetectionSensorSystemImpl <em>Object Detection Sensor System</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.ObjectDetectionSensorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getObjectDetectionSensorSystem()
	 * @generated
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM = 22;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Object Detection Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ObjectTrackingSensorSystemImpl <em>Object Tracking Sensor System</em>}'
	 * class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.ObjectTrackingSensorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getObjectTrackingSensorSystem()
	 * @generated
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM = 23;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Object Tracking Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl <em>Lidar System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.LidarSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLidarSystem()
	 * @generated
	 */
	int LIDAR_SYSTEM = 24;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__BASE_CLASS = OBJECT_DETECTION_SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__NATIVE = OBJECT_DETECTION_SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LIBRARY_PATH = OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LIBRARY_COMPONENT_NAME = OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LOCAL_POSITION = OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LOCAL_ORIENTATION = OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__FREQUENCY = OBJECT_DETECTION_SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__IDENTIFIER = OBJECT_DETECTION_SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Nb Layers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__NB_LAYERS = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Layer Angle Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LAYER_ANGLE_MIN = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Layer Angle Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LAYER_ANGLE_STEP = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Noise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__NOISE = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sigma Noise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__SIGMA_NOISE = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Angle min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__ANGLE_MIN = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Angle max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__ANGLE_MAX = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Time increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__TIME_INCREMENT = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Scan time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__SCAN_TIME = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Range min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__RANGE_MIN = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Range max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__RANGE_MAX = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Nb Rays</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__NB_RAYS = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Lidar System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM_FEATURE_COUNT = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.LocalizationSensorSystemImpl <em>Localization Sensor System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.LocalizationSensorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLocalizationSensorSystem()
	 * @generated
	 */
	int LOCALIZATION_SENSOR_SYSTEM = 25;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Localization Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.GPSSystemImpl <em>GPS System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.GPSSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGPSSystem()
	 * @generated
	 */
	int GPS_SYSTEM = 26;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__BASE_CLASS = LOCALIZATION_SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__NATIVE = LOCALIZATION_SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__LIBRARY_PATH = LOCALIZATION_SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__LIBRARY_COMPONENT_NAME = LOCALIZATION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__LOCAL_POSITION = LOCALIZATION_SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__LOCAL_ORIENTATION = LOCALIZATION_SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__FREQUENCY = LOCALIZATION_SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__IDENTIFIER = LOCALIZATION_SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Origin Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__ORIGIN_POSITION = LOCALIZATION_SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>GPS System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM_FEATURE_COUNT = LOCALIZATION_SENSOR_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SimulatedSystemImpl <em>Simulated System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.SimulatedSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSimulatedSystem()
	 * @generated
	 */
	int SIMULATED_SYSTEM = 27;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM__BASE_CLASS = SOFTWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM__NATIVE = SOFTWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM__LIBRARY_PATH = SOFTWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM__LIBRARY_COMPONENT_NAME = SOFTWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Is Periodic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM__IS_PERIODIC = SOFTWARE__IS_PERIODIC;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM__PERIOD = SOFTWARE__PERIOD;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM__PRIORITY = SOFTWARE__PRIORITY;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM__DEADLINE = SOFTWARE__DEADLINE;

	/**
	 * The feature id for the '<em><b>Wcet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM__WCET = SOFTWARE__WCET;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM__BASE_PROPERTY = SOFTWARE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mesh</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM__MESH = SOFTWARE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simulated System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SIMULATED_SYSTEM_FEATURE_COUNT = SOFTWARE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.AlgorithmLibraryImpl <em>Algorithm Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.AlgorithmLibraryImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAlgorithmLibrary()
	 * @generated
	 */
	int ALGORITHM_LIBRARY = 28;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_LIBRARY__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_LIBRARY__PATH = 1;

	/**
	 * The number of structural features of the '<em>Algorithm Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_LIBRARY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.StateImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getState()
	 * @generated
	 */
	int STATE = 29;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE__BASE_STATE = 0;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE__OPERATION = 1;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE__ARGUMENTS = 2;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SensorDriverImpl <em>Sensor Driver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.SensorDriverImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSensorDriver()
	 * @generated
	 */
	int SENSOR_DRIVER = 30;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__BASE_CLASS = SOFTWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__NATIVE = SOFTWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__LIBRARY_PATH = SOFTWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__LIBRARY_COMPONENT_NAME = SOFTWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Is Periodic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__IS_PERIODIC = SOFTWARE__IS_PERIODIC;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__PERIOD = SOFTWARE__PERIOD;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__PRIORITY = SOFTWARE__PRIORITY;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__DEADLINE = SOFTWARE__DEADLINE;

	/**
	 * The feature id for the '<em><b>Wcet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__WCET = SOFTWARE__WCET;

	/**
	 * The number of structural features of the '<em>Sensor Driver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER_FEATURE_COUNT = SOFTWARE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.BuildingImpl <em>Building</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.BuildingImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getBuilding()
	 * @generated
	 */
	int BUILDING = 31;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUILDING__BASE_CLASS = PHYSICAL_OBJECT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUILDING__NATIVE = PHYSICAL_OBJECT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUILDING__LIBRARY_PATH = PHYSICAL_OBJECT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUILDING__LIBRARY_COMPONENT_NAME = PHYSICAL_OBJECT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUILDING__EVELOVES_IN = PHYSICAL_OBJECT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUILDING__HAS_SURFACE = PHYSICAL_OBJECT__HAS_SURFACE;

	/**
	 * The number of structural features of the '<em>Building</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BUILDING_FEATURE_COUNT = PHYSICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PlanetImpl <em>Planet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.PlanetImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPlanet()
	 * @generated
	 */
	int PLANET = 32;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLANET__BASE_CLASS = PHYSICAL_OBJECT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLANET__NATIVE = PHYSICAL_OBJECT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLANET__LIBRARY_PATH = PHYSICAL_OBJECT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLANET__LIBRARY_COMPONENT_NAME = PHYSICAL_OBJECT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLANET__EVELOVES_IN = PHYSICAL_OBJECT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLANET__HAS_SURFACE = PHYSICAL_OBJECT__HAS_SURFACE;

	/**
	 * The number of structural features of the '<em>Planet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLANET_FEATURE_COUNT = PHYSICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.GroundImpl <em>Ground</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.GroundImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGround()
	 * @generated
	 */
	int GROUND = 34;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUND__BASE_CLASS = SURFACE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUND__NATIVE = SURFACE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUND__LIBRARY_PATH = SURFACE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUND__LIBRARY_COMPONENT_NAME = SURFACE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUND__EVELOVES_IN = SURFACE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUND__HAS_SURFACE = SURFACE__HAS_SURFACE;

	/**
	 * The number of structural features of the '<em>Ground</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GROUND_FEATURE_COUNT = SURFACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.LandSurfaceImpl <em>Land Surface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.LandSurfaceImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLandSurface()
	 * @generated
	 */
	int LAND_SURFACE = 33;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__BASE_CLASS = GROUND__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__NATIVE = GROUND__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__LIBRARY_PATH = GROUND__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__LIBRARY_COMPONENT_NAME = GROUND__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__EVELOVES_IN = GROUND__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__HAS_SURFACE = GROUND__HAS_SURFACE;

	/**
	 * The number of structural features of the '<em>Land Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE_FEATURE_COUNT = GROUND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.FloorImpl <em>Floor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.FloorImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getFloor()
	 * @generated
	 */
	int FLOOR = 35;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOOR__BASE_CLASS = GROUND__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOOR__NATIVE = GROUND__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOOR__LIBRARY_PATH = GROUND__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOOR__LIBRARY_COMPONENT_NAME = GROUND__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOOR__EVELOVES_IN = GROUND__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOOR__HAS_SURFACE = GROUND__HAS_SURFACE;

	/**
	 * The number of structural features of the '<em>Floor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int FLOOR_FEATURE_COUNT = GROUND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.WaterSurfaceImpl <em>Water Surface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.WaterSurfaceImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getWaterSurface()
	 * @generated
	 */
	int WATER_SURFACE = 36;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__BASE_CLASS = SURFACE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__NATIVE = SURFACE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__LIBRARY_PATH = SURFACE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__LIBRARY_COMPONENT_NAME = SURFACE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__EVELOVES_IN = SURFACE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__HAS_SURFACE = SURFACE__HAS_SURFACE;

	/**
	 * The number of structural features of the '<em>Water Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE_FEATURE_COUNT = SURFACE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.HumanImpl <em>Human</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.HumanImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getHuman()
	 * @generated
	 */
	int HUMAN = 37;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HUMAN__BASE_CLASS = AGENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HUMAN__NATIVE = AGENT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HUMAN__LIBRARY_PATH = AGENT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HUMAN__LIBRARY_COMPONENT_NAME = AGENT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HUMAN__EVELOVES_IN = AGENT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HUMAN__HAS_SURFACE = AGENT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Moves Over</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HUMAN__MOVES_OVER = AGENT__MOVES_OVER;

	/**
	 * The number of structural features of the '<em>Human</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int HUMAN_FEATURE_COUNT = AGENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PedestrianImpl <em>Pedestrian</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.PedestrianImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPedestrian()
	 * @generated
	 */
	int PEDESTRIAN = 38;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__BASE_CLASS = HUMAN__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__NATIVE = HUMAN__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__LIBRARY_PATH = HUMAN__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__LIBRARY_COMPONENT_NAME = HUMAN__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__EVELOVES_IN = HUMAN__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__HAS_SURFACE = HUMAN__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Moves Over</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__MOVES_OVER = HUMAN__MOVES_OVER;

	/**
	 * The number of structural features of the '<em>Pedestrian</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN_FEATURE_COUNT = HUMAN_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.StairsImpl <em>Stairs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.StairsImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getStairs()
	 * @generated
	 */
	int STAIRS = 39;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STAIRS__BASE_CLASS = GROUND__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STAIRS__NATIVE = GROUND__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STAIRS__LIBRARY_PATH = GROUND__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STAIRS__LIBRARY_COMPONENT_NAME = GROUND__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STAIRS__EVELOVES_IN = GROUND__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STAIRS__HAS_SURFACE = GROUND__HAS_SURFACE;

	/**
	 * The number of structural features of the '<em>Stairs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STAIRS_FEATURE_COUNT = GROUND_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PlatformImpl <em>Platform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.PlatformImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPlatform()
	 * @generated
	 */
	int PLATFORM = 40;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLATFORM__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLATFORM__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLATFORM__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLATFORM__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLATFORM__BASE_NODE = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int PLATFORM_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticMiddlewareImpl <em>Robotic Middleware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.RoboticMiddlewareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticMiddleware()
	 * @generated
	 */
	int ROBOTIC_MIDDLEWARE = 41;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__BASE_CLASS = PLATFORM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__NATIVE = PLATFORM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__LIBRARY_PATH = PLATFORM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__LIBRARY_COMPONENT_NAME = PLATFORM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__BASE_NODE = PLATFORM__BASE_NODE;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__KIND = PLATFORM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Robotic Middleware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE_FEATURE_COUNT = PLATFORM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticSimulatorImpl <em>Robotic Simulator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.RoboticSimulatorImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticSimulator()
	 * @generated
	 */
	int ROBOTIC_SIMULATOR = 42;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR__BASE_CLASS = PLATFORM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR__NATIVE = PLATFORM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR__LIBRARY_PATH = PLATFORM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR__LIBRARY_COMPONENT_NAME = PLATFORM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR__BASE_NODE = PLATFORM__BASE_NODE;

	/**
	 * The number of structural features of the '<em>Robotic Simulator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR_FEATURE_COUNT = PLATFORM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.CycabTKImpl <em>Cycab TK</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.CycabTKImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCycabTK()
	 * @generated
	 */
	int CYCAB_TK = 43;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__BASE_CLASS = ROBOTIC_SIMULATOR__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__NATIVE = ROBOTIC_SIMULATOR__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__LIBRARY_PATH = ROBOTIC_SIMULATOR__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__LIBRARY_COMPONENT_NAME = ROBOTIC_SIMULATOR__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__BASE_NODE = ROBOTIC_SIMULATOR__BASE_NODE;

	/**
	 * The feature id for the '<em><b>Use Real Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__USE_REAL_TIME = ROBOTIC_SIMULATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__TIME_STEP = ROBOTIC_SIMULATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Time Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__TIME_FACTOR = ROBOTIC_SIMULATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Cycab TK</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK_FEATURE_COUNT = ROBOTIC_SIMULATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl <em>Blender Morse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getBlenderMorse()
	 * @generated
	 */
	int BLENDER_MORSE = 44;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__BASE_CLASS = ROBOTIC_SIMULATOR__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__NATIVE = ROBOTIC_SIMULATOR__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__LIBRARY_PATH = ROBOTIC_SIMULATOR__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__LIBRARY_COMPONENT_NAME = ROBOTIC_SIMULATOR__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__BASE_NODE = ROBOTIC_SIMULATOR__BASE_NODE;

	/**
	 * The feature id for the '<em><b>Debug Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__DEBUG_MODE = ROBOTIC_SIMULATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Debug Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__DEBUG_DISPLAY = ROBOTIC_SIMULATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gravity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__GRAVITY = ROBOTIC_SIMULATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>viewport shade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__VIEWPORT_SHADE = ROBOTIC_SIMULATOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Blender Morse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE_FEATURE_COUNT = ROBOTIC_SIMULATOR_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.OnPortImpl <em>On Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.OnPortImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOnPort()
	 * @generated
	 */
	int ON_PORT = 45;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ON_PORT__PORT = 0;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ON_PORT__BASE_PARAMETER = 1;

	/**
	 * The number of structural features of the '<em>On Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ON_PORT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.AllocateImpl <em>Allocate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.AllocateImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAllocate()
	 * @generated
	 */
	int ALLOCATE = 46;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATE__BASE_ABSTRACTION = 0;

	/**
	 * The number of structural features of the '<em>Allocate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.InertialMeasurementUnitSystemImpl
	 * <em>Inertial Measurement Unit System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.InertialMeasurementUnitSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInertialMeasurementUnitSystem()
	 * @generated
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM = 47;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Inertial Measurement Unit System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.InertialNavigationSystemImpl <em>Inertial Navigation System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.InertialNavigationSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInertialNavigationSystem()
	 * @generated
	 */
	int INERTIAL_NAVIGATION_SYSTEM = 48;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__BASE_CLASS = GPS_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__NATIVE = GPS_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__LIBRARY_PATH = GPS_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__LIBRARY_COMPONENT_NAME = GPS_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__LOCAL_POSITION = GPS_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__LOCAL_ORIENTATION = GPS_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__FREQUENCY = GPS_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__IDENTIFIER = GPS_SYSTEM__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Origin Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__ORIGIN_POSITION = GPS_SYSTEM__ORIGIN_POSITION;

	/**
	 * The number of structural features of the '<em>Inertial Navigation System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM_FEATURE_COUNT = GPS_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.OdometrySystemImpl <em>Odometry System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.OdometrySystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOdometrySystem()
	 * @generated
	 */
	int ODOMETRY_SYSTEM = 49;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__BASE_CLASS = LOCALIZATION_SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__NATIVE = LOCALIZATION_SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__LIBRARY_PATH = LOCALIZATION_SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__LIBRARY_COMPONENT_NAME = LOCALIZATION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__LOCAL_POSITION = LOCALIZATION_SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__LOCAL_ORIENTATION = LOCALIZATION_SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__FREQUENCY = LOCALIZATION_SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__IDENTIFIER = LOCALIZATION_SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Odometry System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM_FEATURE_COUNT = LOCALIZATION_SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.InfraRedProximetrySystemImpl <em>Infra Red Proximetry System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.InfraRedProximetrySystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInfraRedProximetrySystem()
	 * @generated
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM = 50;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__BASE_CLASS = OBJECT_DETECTION_SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__NATIVE = OBJECT_DETECTION_SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__LIBRARY_PATH = OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__LIBRARY_COMPONENT_NAME = OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__LOCAL_POSITION = OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__LOCAL_ORIENTATION = OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__FREQUENCY = OBJECT_DETECTION_SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__IDENTIFIER = OBJECT_DETECTION_SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Infra Red Proximetry System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM_FEATURE_COUNT = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.DeploymentPlanImpl <em>Deployment Plan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.DeploymentPlanImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDeploymentPlan()
	 * @generated
	 */
	int DEPLOYMENT_PLAN = 51;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__BASE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Main Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__MAIN_INSTANCE = 1;

	/**
	 * The number of structural features of the '<em>Deployment Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.GyroscopeImpl <em>Gyroscope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.impl.GyroscopeImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGyroscope()
	 * @generated
	 */
	int GYROSCOPE = 52;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Gyroscope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.RobotKind <em>Robot Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.RobotKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRobotKind()
	 * @generated
	 */
	int ROBOT_KIND = 53;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.UGVKind <em>UGV Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.UGVKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getUGVKind()
	 * @generated
	 */
	int UGV_KIND = 54;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.SynchronizationKind <em>Synchronization Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.SynchronizationKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSynchronizationKind()
	 * @generated
	 */
	int SYNCHRONIZATION_KIND = 55;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.DataFlowDirectionKind <em>Data Flow Direction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.DataFlowDirectionKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDataFlowDirectionKind()
	 * @generated
	 */
	int DATA_FLOW_DIRECTION_KIND = 56;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.ServiceFlowKind <em>Service Flow Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.ServiceFlowKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getServiceFlowKind()
	 * @generated
	 */
	int SERVICE_FLOW_KIND = 57;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.RoboticMiddlewareKind <em>Robotic Middleware Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.RoboticMiddlewareKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticMiddlewareKind()
	 * @generated
	 */
	int ROBOTIC_MIDDLEWARE_KIND = 58;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.Shade <em>Shade</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.papyrus.RobotML.Shade
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getShade()
	 * @generated
	 */
	int SHADE = 59;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.eclipse.papyrus.RobotML.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Transition#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Transition</em>'.
	 * @see org.eclipse.papyrus.RobotML.Transition#getBase_Transition()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Base_Transition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Transition#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Guard</em>'.
	 * @see org.eclipse.papyrus.RobotML.Transition#getGuard()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Guard();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Transition#getEffect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Effect</em>'.
	 * @see org.eclipse.papyrus.RobotML.Transition#getEffect()
	 * @see #getTransition()
	 * @generated
	 */
	EReference getTransition_Effect();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Algorithm <em>Algorithm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Algorithm</em>'.
	 * @see org.eclipse.papyrus.RobotML.Algorithm
	 * @generated
	 */
	EClass getAlgorithm();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Algorithm#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.eclipse.papyrus.RobotML.Algorithm#getBase_Operation()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EReference getAlgorithm_Base_Operation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Algorithm#isIsExternal <em>Is External</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is External</em>'.
	 * @see org.eclipse.papyrus.RobotML.Algorithm#isIsExternal()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EAttribute getAlgorithm_IsExternal();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Algorithm#getExtFunctionName <em>Ext Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Ext Function Name</em>'.
	 * @see org.eclipse.papyrus.RobotML.Algorithm#getExtFunctionName()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EAttribute getAlgorithm_ExtFunctionName();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Algorithm#getLibPath <em>Lib Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Lib Path</em>'.
	 * @see org.eclipse.papyrus.RobotML.Algorithm#getLibPath()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EAttribute getAlgorithm_LibPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Algorithm#getLibFileFormat <em>Lib File Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Lib File Format</em>'.
	 * @see org.eclipse.papyrus.RobotML.Algorithm#getLibFileFormat()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EAttribute getAlgorithm_LibFileFormat();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Robot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Robot</em>'.
	 * @see org.eclipse.papyrus.RobotML.Robot
	 * @generated
	 */
	EClass getRobot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Robot#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.Robot#getKind()
	 * @see #getRobot()
	 * @generated
	 */
	EAttribute getRobot_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Robot#getMass <em>Mass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Mass</em>'.
	 * @see org.eclipse.papyrus.RobotML.Robot#getMass()
	 * @see #getRobot()
	 * @generated
	 */
	EAttribute getRobot_Mass();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Robot#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.papyrus.RobotML.Robot#getWidth()
	 * @see #getRobot()
	 * @generated
	 */
	EAttribute getRobot_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Robot#getUgvKind <em>Ugv Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Ugv Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.Robot#getUgvKind()
	 * @see #getRobot()
	 * @generated
	 */
	EAttribute getRobot_UgvKind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>System</em>'.
	 * @see org.eclipse.papyrus.RobotML.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.System#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.RobotML.System#getBase_Class()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.System#isNative <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see org.eclipse.papyrus.RobotML.System#isNative()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_Native();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.System#getLibraryPath <em>Library Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Library Path</em>'.
	 * @see org.eclipse.papyrus.RobotML.System#getLibraryPath()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_LibraryPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.System#getLibraryComponentName <em>Library Component Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Library Component Name</em>'.
	 * @see org.eclipse.papyrus.RobotML.System#getLibraryComponentName()
	 * @see #getSystem()
	 * @generated
	 */
	EAttribute getSystem_LibraryComponentName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Agent <em>Agent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Agent</em>'.
	 * @see org.eclipse.papyrus.RobotML.Agent
	 * @generated
	 */
	EClass getAgent();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.RobotML.Agent#getMovesOver <em>Moves Over</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Moves Over</em>'.
	 * @see org.eclipse.papyrus.RobotML.Agent#getMovesOver()
	 * @see #getAgent()
	 * @generated
	 */
	EReference getAgent_MovesOver();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.PhysicalObject <em>Physical Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Physical Object</em>'.
	 * @see org.eclipse.papyrus.RobotML.PhysicalObject
	 * @generated
	 */
	EClass getPhysicalObject();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.RobotML.PhysicalObject#getEvelovesIn <em>Eveloves In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Eveloves In</em>'.
	 * @see org.eclipse.papyrus.RobotML.PhysicalObject#getEvelovesIn()
	 * @see #getPhysicalObject()
	 * @generated
	 */
	EReference getPhysicalObject_EvelovesIn();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.PhysicalObject#getHasSurface <em>Has Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Has Surface</em>'.
	 * @see org.eclipse.papyrus.RobotML.PhysicalObject#getHasSurface()
	 * @see #getPhysicalObject()
	 * @generated
	 */
	EReference getPhysicalObject_HasSurface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Environment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see org.eclipse.papyrus.RobotML.Environment
	 * @generated
	 */
	EClass getEnvironment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Surface <em>Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Surface</em>'.
	 * @see org.eclipse.papyrus.RobotML.Surface
	 * @generated
	 */
	EClass getSurface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.DataFlowPort <em>Data Flow Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Data Flow Port</em>'.
	 * @see org.eclipse.papyrus.RobotML.DataFlowPort
	 * @generated
	 */
	EClass getDataFlowPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.DataFlowPort#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Direction</em>'.
	 * @see org.eclipse.papyrus.RobotML.DataFlowPort#getDirection()
	 * @see #getDataFlowPort()
	 * @generated
	 */
	EAttribute getDataFlowPort_Direction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.DataFlowPort#getBufferSize <em>Buffer Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Buffer Size</em>'.
	 * @see org.eclipse.papyrus.RobotML.DataFlowPort#getBufferSize()
	 * @see #getDataFlowPort()
	 * @generated
	 */
	EAttribute getDataFlowPort_BufferSize();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.eclipse.papyrus.RobotML.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Port#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.RobotML.Port#getBase_Port()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Base_Port();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Port#getSynchronizationPolicy <em>Synchronization Policy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Synchronization Policy</em>'.
	 * @see org.eclipse.papyrus.RobotML.Port#getSynchronizationPolicy()
	 * @see #getPort()
	 * @generated
	 */
	EAttribute getPort_SynchronizationPolicy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ServicePort <em>Service Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Service Port</em>'.
	 * @see org.eclipse.papyrus.RobotML.ServicePort
	 * @generated
	 */
	EClass getServicePort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.ServicePort#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.ServicePort#getKind()
	 * @see #getServicePort()
	 * @generated
	 */
	EAttribute getServicePort_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ActuatorSystem <em>Actuator System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Actuator System</em>'.
	 * @see org.eclipse.papyrus.RobotML.ActuatorSystem
	 * @generated
	 */
	EClass getActuatorSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.RoboticSystem <em>Robotic System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Robotic System</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticSystem
	 * @generated
	 */
	EClass getRoboticSystem();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotML.RoboticSystem#getLocalPosition
	 * <em>Local Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Local Position</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticSystem#getLocalPosition()
	 * @see #getRoboticSystem()
	 * @generated
	 */
	EReference getRoboticSystem_LocalPosition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotML.RoboticSystem#getLocalOrientation
	 * <em>Local Orientation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Local Orientation</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticSystem#getLocalOrientation()
	 * @see #getRoboticSystem()
	 * @generated
	 */
	EReference getRoboticSystem_LocalOrientation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.SensorSystem <em>Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Sensor System</em>'.
	 * @see org.eclipse.papyrus.RobotML.SensorSystem
	 * @generated
	 */
	EClass getSensorSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SensorSystem#getFrequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Frequency</em>'.
	 * @see org.eclipse.papyrus.RobotML.SensorSystem#getFrequency()
	 * @see #getSensorSystem()
	 * @generated
	 */
	EAttribute getSensorSystem_Frequency();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SensorSystem#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.papyrus.RobotML.SensorSystem#getIdentifier()
	 * @see #getSensorSystem()
	 * @generated
	 */
	EAttribute getSensorSystem_Identifier();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Hardware <em>Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Hardware</em>'.
	 * @see org.eclipse.papyrus.RobotML.Hardware
	 * @generated
	 */
	EClass getHardware();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Software <em>Software</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Software</em>'.
	 * @see org.eclipse.papyrus.RobotML.Software
	 * @generated
	 */
	EClass getSoftware();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Software#isIsPeriodic <em>Is Periodic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Is Periodic</em>'.
	 * @see org.eclipse.papyrus.RobotML.Software#isIsPeriodic()
	 * @see #getSoftware()
	 * @generated
	 */
	EAttribute getSoftware_IsPeriodic();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Software#getPeriod <em>Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Period</em>'.
	 * @see org.eclipse.papyrus.RobotML.Software#getPeriod()
	 * @see #getSoftware()
	 * @generated
	 */
	EAttribute getSoftware_Period();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Software#getPriority <em>Priority</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Priority</em>'.
	 * @see org.eclipse.papyrus.RobotML.Software#getPriority()
	 * @see #getSoftware()
	 * @generated
	 */
	EAttribute getSoftware_Priority();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Software#getDeadline <em>Deadline</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Deadline</em>'.
	 * @see org.eclipse.papyrus.RobotML.Software#getDeadline()
	 * @see #getSoftware()
	 * @generated
	 */
	EAttribute getSoftware_Deadline();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Software#getWcet <em>Wcet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wcet</em>'.
	 * @see org.eclipse.papyrus.RobotML.Software#getWcet()
	 * @see #getSoftware()
	 * @generated
	 */
	EAttribute getSoftware_Wcet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.PrimitiveData <em>Primitive Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Primitive Data</em>'.
	 * @see org.eclipse.papyrus.RobotML.PrimitiveData
	 * @generated
	 */
	EClass getPrimitiveData();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.PrimitiveData#getBase_PrimitiveType <em>Base Primitive Type</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Primitive Type</em>'.
	 * @see org.eclipse.papyrus.RobotML.PrimitiveData#getBase_PrimitiveType()
	 * @see #getPrimitiveData()
	 * @generated
	 */
	EReference getPrimitiveData_Base_PrimitiveType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.DataType <em>Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Data Type</em>'.
	 * @see org.eclipse.papyrus.RobotML.DataType
	 * @generated
	 */
	EClass getDataType();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.DataType#getBase_DataType <em>Base Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Data Type</em>'.
	 * @see org.eclipse.papyrus.RobotML.DataType#getBase_DataType()
	 * @see #getDataType()
	 * @generated
	 */
	EReference getDataType_Base_DataType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.DataType#isNative <em>Native</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Native</em>'.
	 * @see org.eclipse.papyrus.RobotML.DataType#isNative()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_Native();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.DataType#getLibraryPath <em>Library Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Library Path</em>'.
	 * @see org.eclipse.papyrus.RobotML.DataType#getLibraryPath()
	 * @see #getDataType()
	 * @generated
	 */
	EAttribute getDataType_LibraryPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.EngineSystem <em>Engine System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Engine System</em>'.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem
	 * @generated
	 */
	EClass getEngineSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.EngineSystem#getVehicleTraction <em>Vehicle Traction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Vehicle Traction</em>'.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem#getVehicleTraction()
	 * @see #getEngineSystem()
	 * @generated
	 */
	EAttribute getEngineSystem_VehicleTraction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxEngineForce <em>Max Engine Force</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max Engine Force</em>'.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem#getMaxEngineForce()
	 * @see #getEngineSystem()
	 * @generated
	 */
	EAttribute getEngineSystem_MaxEngineForce();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxBreakingForce <em>Max Breaking Force</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max Breaking Force</em>'.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem#getMaxBreakingForce()
	 * @see #getEngineSystem()
	 * @generated
	 */
	EAttribute getEngineSystem_MaxBreakingForce();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxAllowedSteering <em>Max Allowed Steering</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max Allowed Steering</em>'.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem#getMaxAllowedSteering()
	 * @see #getEngineSystem()
	 * @generated
	 */
	EAttribute getEngineSystem_MaxAllowedSteering();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxAllowedVelocity <em>Max Allowed Velocity</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Max Allowed Velocity</em>'.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem#getMaxAllowedVelocity()
	 * @see #getEngineSystem()
	 * @generated
	 */
	EAttribute getEngineSystem_MaxAllowedVelocity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.EngineSystem#getGear_ration <em>Gear ration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Gear ration</em>'.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem#getGear_ration()
	 * @see #getEngineSystem()
	 * @generated
	 */
	EAttribute getEngineSystem_Gear_ration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.WheelSystem <em>Wheel System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Wheel System</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem
	 * @generated
	 */
	EClass getWheelSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getWheelRadius <em>Wheel Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wheel Radius</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getWheelRadius()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_WheelRadius();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getWheelWidth <em>Wheel Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wheel Width</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getWheelWidth()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_WheelWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getSuspensionRestLength
	 * <em>Suspension Rest Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Suspension Rest Length</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getSuspensionRestLength()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_SuspensionRestLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getWheelConnectionHeight
	 * <em>Wheel Connection Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wheel Connection Height</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getWheelConnectionHeight()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_WheelConnectionHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getTypeOfWheel <em>Type Of Wheel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Type Of Wheel</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getTypeOfWheel()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_TypeOfWheel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getWheelVelocityPIDkp <em>Wheel Velocity PI Dkp</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wheel Velocity PI Dkp</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getWheelVelocityPIDkp()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_WheelVelocityPIDkp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getWheelVelocityPIDki <em>Wheel Velocity PI Dki</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wheel Velocity PI Dki</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getWheelVelocityPIDki()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_WheelVelocityPIDki();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getWheelVelocityPIDkd <em>Wheel Velocity PI Dkd</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wheel Velocity PI Dkd</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getWheelVelocityPIDkd()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_WheelVelocityPIDkd();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getWheelSteeringPIDkp <em>Wheel Steering PI Dkp</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wheel Steering PI Dkp</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getWheelSteeringPIDkp()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_WheelSteeringPIDkp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getWheelSteeringPIDkd <em>Wheel Steering PI Dkd</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wheel Steering PI Dkd</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getWheelSteeringPIDkd()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_WheelSteeringPIDkd();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getWheelFriction <em>Wheel Friction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wheel Friction</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getWheelFriction()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_WheelFriction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getSuspensionStiffness <em>Suspension Stiffness</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Suspension Stiffness</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getSuspensionStiffness()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_SuspensionStiffness();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getSuspensionDamping <em>Suspension Damping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Suspension Damping</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getSuspensionDamping()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_SuspensionDamping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getSuspensionCompression
	 * <em>Suspension Compression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Suspension Compression</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getSuspensionCompression()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_SuspensionCompression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getWheelVelocityPIDmaxSum
	 * <em>Wheel Velocity PI Dmax Sum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wheel Velocity PI Dmax Sum</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getWheelVelocityPIDmaxSum()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_WheelVelocityPIDmaxSum();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.WheelSystem#getWheelVelocityPIDmaxVal
	 * <em>Wheel Velocity PI Dmax Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Wheel Velocity PI Dmax Val</em>'.
	 * @see org.eclipse.papyrus.RobotML.WheelSystem#getWheelVelocityPIDmaxVal()
	 * @see #getWheelSystem()
	 * @generated
	 */
	EAttribute getWheelSystem_WheelVelocityPIDmaxVal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ImageSensorSystem <em>Image Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Image Sensor System</em>'.
	 * @see org.eclipse.papyrus.RobotML.ImageSensorSystem
	 * @generated
	 */
	EClass getImageSensorSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.CameraSystem <em>Camera System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Camera System</em>'.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem
	 * @generated
	 */
	EClass getCameraSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CameraSystem#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem#getWidth()
	 * @see #getCameraSystem()
	 * @generated
	 */
	EAttribute getCameraSystem_Width();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CameraSystem#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem#getHeight()
	 * @see #getCameraSystem()
	 * @generated
	 */
	EAttribute getCameraSystem_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CameraSystem#getAlpha_u <em>Alpha u</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Alpha u</em>'.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem#getAlpha_u()
	 * @see #getCameraSystem()
	 * @generated
	 */
	EAttribute getCameraSystem_Alpha_u();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CameraSystem#getAlpha_v <em>Alpha v</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Alpha v</em>'.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem#getAlpha_v()
	 * @see #getCameraSystem()
	 * @generated
	 */
	EAttribute getCameraSystem_Alpha_v();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CameraSystem#getU0 <em>U0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>U0</em>'.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem#getU0()
	 * @see #getCameraSystem()
	 * @generated
	 */
	EAttribute getCameraSystem_U0();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CameraSystem#getV0 <em>V0</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>V0</em>'.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem#getV0()
	 * @see #getCameraSystem()
	 * @generated
	 */
	EAttribute getCameraSystem_V0();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CameraSystem#getColor_format <em>Color format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Color format</em>'.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem#getColor_format()
	 * @see #getCameraSystem()
	 * @generated
	 */
	EAttribute getCameraSystem_Color_format();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotML.CameraSystem#getTranslate <em>Translate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Translate</em>'.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem#getTranslate()
	 * @see #getCameraSystem()
	 * @generated
	 */
	EReference getCameraSystem_Translate();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotML.CameraSystem#getRotate <em>Rotate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Rotate</em>'.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem#getRotate()
	 * @see #getCameraSystem()
	 * @generated
	 */
	EReference getCameraSystem_Rotate();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ObjectDetectionSensorSystem <em>Object Detection Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Object Detection Sensor System</em>'.
	 * @see org.eclipse.papyrus.RobotML.ObjectDetectionSensorSystem
	 * @generated
	 */
	EClass getObjectDetectionSensorSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ObjectTrackingSensorSystem <em>Object Tracking Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Object Tracking Sensor System</em>'.
	 * @see org.eclipse.papyrus.RobotML.ObjectTrackingSensorSystem
	 * @generated
	 */
	EClass getObjectTrackingSensorSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.LidarSystem <em>Lidar System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Lidar System</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem
	 * @generated
	 */
	EClass getLidarSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getNbLayers <em>Nb Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Nb Layers</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#getNbLayers()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_NbLayers();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getLayerAngleMin <em>Layer Angle Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Layer Angle Min</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#getLayerAngleMin()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_LayerAngleMin();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getLayerAngleStep <em>Layer Angle Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Layer Angle Step</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#getLayerAngleStep()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_LayerAngleStep();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#isNoise <em>Noise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Noise</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#isNoise()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_Noise();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getSigmaNoise <em>Sigma Noise</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Sigma Noise</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#getSigmaNoise()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_SigmaNoise();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getAngle_min <em>Angle min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Angle min</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#getAngle_min()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_Angle_min();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getAngle_max <em>Angle max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Angle max</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#getAngle_max()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_Angle_max();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getTime_increment <em>Time increment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Time increment</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#getTime_increment()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_Time_increment();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getScan_time <em>Scan time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Scan time</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#getScan_time()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_Scan_time();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getRange_min <em>Range min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Range min</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#getRange_min()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_Range_min();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getRange_max <em>Range max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Range max</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#getRange_max()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_Range_max();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getNbRays <em>Nb Rays</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Nb Rays</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem#getNbRays()
	 * @see #getLidarSystem()
	 * @generated
	 */
	EAttribute getLidarSystem_NbRays();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.LocalizationSensorSystem <em>Localization Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Localization Sensor System</em>'.
	 * @see org.eclipse.papyrus.RobotML.LocalizationSensorSystem
	 * @generated
	 */
	EClass getLocalizationSensorSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.GPSSystem <em>GPS System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>GPS System</em>'.
	 * @see org.eclipse.papyrus.RobotML.GPSSystem
	 * @generated
	 */
	EClass getGPSSystem();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotML.GPSSystem#getOriginPosition <em>Origin Position</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the containment reference '<em>Origin Position</em>'.
	 * @see org.eclipse.papyrus.RobotML.GPSSystem#getOriginPosition()
	 * @see #getGPSSystem()
	 * @generated
	 */
	EReference getGPSSystem_OriginPosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.SimulatedSystem <em>Simulated System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Simulated System</em>'.
	 * @see org.eclipse.papyrus.RobotML.SimulatedSystem
	 * @generated
	 */
	EClass getSimulatedSystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.SimulatedSystem#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.RobotML.SimulatedSystem#getBase_Property()
	 * @see #getSimulatedSystem()
	 * @generated
	 */
	EReference getSimulatedSystem_Base_Property();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.RobotML.SimulatedSystem#getMesh <em>Mesh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute list '<em>Mesh</em>'.
	 * @see org.eclipse.papyrus.RobotML.SimulatedSystem#getMesh()
	 * @see #getSimulatedSystem()
	 * @generated
	 */
	EAttribute getSimulatedSystem_Mesh();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.AlgorithmLibrary <em>Algorithm Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Algorithm Library</em>'.
	 * @see org.eclipse.papyrus.RobotML.AlgorithmLibrary
	 * @generated
	 */
	EClass getAlgorithmLibrary();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.AlgorithmLibrary#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.RobotML.AlgorithmLibrary#getBase_Class()
	 * @see #getAlgorithmLibrary()
	 * @generated
	 */
	EReference getAlgorithmLibrary_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.AlgorithmLibrary#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.papyrus.RobotML.AlgorithmLibrary#getPath()
	 * @see #getAlgorithmLibrary()
	 * @generated
	 */
	EAttribute getAlgorithmLibrary_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.eclipse.papyrus.RobotML.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.State#getBase_State <em>Base State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base State</em>'.
	 * @see org.eclipse.papyrus.RobotML.State#getBase_State()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Base_State();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.State#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Operation</em>'.
	 * @see org.eclipse.papyrus.RobotML.State#getOperation()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Operation();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.RobotML.State#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>Arguments</em>'.
	 * @see org.eclipse.papyrus.RobotML.State#getArguments()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.SensorDriver <em>Sensor Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Sensor Driver</em>'.
	 * @see org.eclipse.papyrus.RobotML.SensorDriver
	 * @generated
	 */
	EClass getSensorDriver();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Building <em>Building</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Building</em>'.
	 * @see org.eclipse.papyrus.RobotML.Building
	 * @generated
	 */
	EClass getBuilding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Planet <em>Planet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Planet</em>'.
	 * @see org.eclipse.papyrus.RobotML.Planet
	 * @generated
	 */
	EClass getPlanet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.LandSurface <em>Land Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Land Surface</em>'.
	 * @see org.eclipse.papyrus.RobotML.LandSurface
	 * @generated
	 */
	EClass getLandSurface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Ground <em>Ground</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Ground</em>'.
	 * @see org.eclipse.papyrus.RobotML.Ground
	 * @generated
	 */
	EClass getGround();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Floor <em>Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Floor</em>'.
	 * @see org.eclipse.papyrus.RobotML.Floor
	 * @generated
	 */
	EClass getFloor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.WaterSurface <em>Water Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Water Surface</em>'.
	 * @see org.eclipse.papyrus.RobotML.WaterSurface
	 * @generated
	 */
	EClass getWaterSurface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Human <em>Human</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Human</em>'.
	 * @see org.eclipse.papyrus.RobotML.Human
	 * @generated
	 */
	EClass getHuman();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Pedestrian <em>Pedestrian</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Pedestrian</em>'.
	 * @see org.eclipse.papyrus.RobotML.Pedestrian
	 * @generated
	 */
	EClass getPedestrian();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Stairs <em>Stairs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Stairs</em>'.
	 * @see org.eclipse.papyrus.RobotML.Stairs
	 * @generated
	 */
	EClass getStairs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Platform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Platform</em>'.
	 * @see org.eclipse.papyrus.RobotML.Platform
	 * @generated
	 */
	EClass getPlatform();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Platform#getBase_Node <em>Base Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Node</em>'.
	 * @see org.eclipse.papyrus.RobotML.Platform#getBase_Node()
	 * @see #getPlatform()
	 * @generated
	 */
	EReference getPlatform_Base_Node();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.RoboticMiddleware <em>Robotic Middleware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Robotic Middleware</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticMiddleware
	 * @generated
	 */
	EClass getRoboticMiddleware();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.RoboticMiddleware#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticMiddleware#getKind()
	 * @see #getRoboticMiddleware()
	 * @generated
	 */
	EAttribute getRoboticMiddleware_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.RoboticSimulator <em>Robotic Simulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Robotic Simulator</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticSimulator
	 * @generated
	 */
	EClass getRoboticSimulator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.CycabTK <em>Cycab TK</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Cycab TK</em>'.
	 * @see org.eclipse.papyrus.RobotML.CycabTK
	 * @generated
	 */
	EClass getCycabTK();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CycabTK#isUseRealTime <em>Use Real Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Use Real Time</em>'.
	 * @see org.eclipse.papyrus.RobotML.CycabTK#isUseRealTime()
	 * @see #getCycabTK()
	 * @generated
	 */
	EAttribute getCycabTK_UseRealTime();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CycabTK#getTimeStep <em>Time Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Time Step</em>'.
	 * @see org.eclipse.papyrus.RobotML.CycabTK#getTimeStep()
	 * @see #getCycabTK()
	 * @generated
	 */
	EAttribute getCycabTK_TimeStep();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CycabTK#getTimeFactor <em>Time Factor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Time Factor</em>'.
	 * @see org.eclipse.papyrus.RobotML.CycabTK#getTimeFactor()
	 * @see #getCycabTK()
	 * @generated
	 */
	EAttribute getCycabTK_TimeFactor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.BlenderMorse <em>Blender Morse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Blender Morse</em>'.
	 * @see org.eclipse.papyrus.RobotML.BlenderMorse
	 * @generated
	 */
	EClass getBlenderMorse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.BlenderMorse#isDebugMode <em>Debug Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Debug Mode</em>'.
	 * @see org.eclipse.papyrus.RobotML.BlenderMorse#isDebugMode()
	 * @see #getBlenderMorse()
	 * @generated
	 */
	EAttribute getBlenderMorse_DebugMode();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.BlenderMorse#isDebugDisplay <em>Debug Display</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Debug Display</em>'.
	 * @see org.eclipse.papyrus.RobotML.BlenderMorse#isDebugDisplay()
	 * @see #getBlenderMorse()
	 * @generated
	 */
	EAttribute getBlenderMorse_DebugDisplay();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.BlenderMorse#getGravity <em>Gravity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Gravity</em>'.
	 * @see org.eclipse.papyrus.RobotML.BlenderMorse#getGravity()
	 * @see #getBlenderMorse()
	 * @generated
	 */
	EAttribute getBlenderMorse_Gravity();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.BlenderMorse#get_viewport_shade <em>viewport shade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>viewport shade</em>'.
	 * @see org.eclipse.papyrus.RobotML.BlenderMorse#get_viewport_shade()
	 * @see #getBlenderMorse()
	 * @generated
	 */
	EAttribute getBlenderMorse__viewport_shade();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.OnPort <em>On Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>On Port</em>'.
	 * @see org.eclipse.papyrus.RobotML.OnPort
	 * @generated
	 */
	EClass getOnPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.OnPort#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Port</em>'.
	 * @see org.eclipse.papyrus.RobotML.OnPort#getPort()
	 * @see #getOnPort()
	 * @generated
	 */
	EReference getOnPort_Port();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.OnPort#getBase_Parameter <em>Base Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Parameter</em>'.
	 * @see org.eclipse.papyrus.RobotML.OnPort#getBase_Parameter()
	 * @see #getOnPort()
	 * @generated
	 */
	EReference getOnPort_Base_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Allocate <em>Allocate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Allocate</em>'.
	 * @see org.eclipse.papyrus.RobotML.Allocate
	 * @generated
	 */
	EClass getAllocate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Allocate#getBase_Abstraction <em>Base Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Abstraction</em>'.
	 * @see org.eclipse.papyrus.RobotML.Allocate#getBase_Abstraction()
	 * @see #getAllocate()
	 * @generated
	 */
	EReference getAllocate_Base_Abstraction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.InertialMeasurementUnitSystem <em>Inertial Measurement Unit System</em>}
	 * '.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Inertial Measurement Unit System</em>'.
	 * @see org.eclipse.papyrus.RobotML.InertialMeasurementUnitSystem
	 * @generated
	 */
	EClass getInertialMeasurementUnitSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.InertialNavigationSystem <em>Inertial Navigation System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Inertial Navigation System</em>'.
	 * @see org.eclipse.papyrus.RobotML.InertialNavigationSystem
	 * @generated
	 */
	EClass getInertialNavigationSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.OdometrySystem <em>Odometry System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Odometry System</em>'.
	 * @see org.eclipse.papyrus.RobotML.OdometrySystem
	 * @generated
	 */
	EClass getOdometrySystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.InfraRedProximetrySystem <em>Infra Red Proximetry System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Infra Red Proximetry System</em>'.
	 * @see org.eclipse.papyrus.RobotML.InfraRedProximetrySystem
	 * @generated
	 */
	EClass getInfraRedProximetrySystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.DeploymentPlan <em>Deployment Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Deployment Plan</em>'.
	 * @see org.eclipse.papyrus.RobotML.DeploymentPlan
	 * @generated
	 */
	EClass getDeploymentPlan();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.DeploymentPlan#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.RobotML.DeploymentPlan#getBase_Package()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EReference getDeploymentPlan_Base_Package();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.DeploymentPlan#getMainInstance <em>Main Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference '<em>Main Instance</em>'.
	 * @see org.eclipse.papyrus.RobotML.DeploymentPlan#getMainInstance()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EReference getDeploymentPlan_MainInstance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Gyroscope <em>Gyroscope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>Gyroscope</em>'.
	 * @see org.eclipse.papyrus.RobotML.Gyroscope
	 * @generated
	 */
	EClass getGyroscope();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.RobotKind <em>Robot Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Robot Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.RobotKind
	 * @generated
	 */
	EEnum getRobotKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.UGVKind <em>UGV Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>UGV Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.UGVKind
	 * @generated
	 */
	EEnum getUGVKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.SynchronizationKind <em>Synchronization Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Synchronization Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.SynchronizationKind
	 * @generated
	 */
	EEnum getSynchronizationKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.DataFlowDirectionKind <em>Data Flow Direction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Data Flow Direction Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.DataFlowDirectionKind
	 * @generated
	 */
	EEnum getDataFlowDirectionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.ServiceFlowKind <em>Service Flow Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Service Flow Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.ServiceFlowKind
	 * @generated
	 */
	EEnum getServiceFlowKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.RoboticMiddlewareKind <em>Robotic Middleware Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Robotic Middleware Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticMiddlewareKind
	 * @generated
	 */
	EEnum getRoboticMiddlewareKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.Shade <em>Shade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the meta object for enum '<em>Shade</em>'.
	 * @see org.eclipse.papyrus.RobotML.Shade
	 * @generated
	 */
	EEnum getShade();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RobotMLFactory getRobotMLFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.TransitionImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSITION__BASE_TRANSITION = eINSTANCE.getTransition_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference TRANSITION__EFFECT = eINSTANCE.getTransition_Effect();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.AlgorithmImpl <em>Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.AlgorithmImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAlgorithm()
		 * @generated
		 */
		EClass ALGORITHM = eINSTANCE.getAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALGORITHM__BASE_OPERATION = eINSTANCE.getAlgorithm_Base_Operation();

		/**
		 * The meta object literal for the '<em><b>Is External</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ALGORITHM__IS_EXTERNAL = eINSTANCE.getAlgorithm_IsExternal();

		/**
		 * The meta object literal for the '<em><b>Ext Function Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ALGORITHM__EXT_FUNCTION_NAME = eINSTANCE.getAlgorithm_ExtFunctionName();

		/**
		 * The meta object literal for the '<em><b>Lib Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ALGORITHM__LIB_PATH = eINSTANCE.getAlgorithm_LibPath();

		/**
		 * The meta object literal for the '<em><b>Lib File Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ALGORITHM__LIB_FILE_FORMAT = eINSTANCE.getAlgorithm_LibFileFormat();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.RobotImpl <em>Robot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.RobotImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRobot()
		 * @generated
		 */
		EClass ROBOT = eINSTANCE.getRobot();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ROBOT__KIND = eINSTANCE.getRobot_Kind();

		/**
		 * The meta object literal for the '<em><b>Mass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ROBOT__MASS = eINSTANCE.getRobot_Mass();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ROBOT__WIDTH = eINSTANCE.getRobot_Width();

		/**
		 * The meta object literal for the '<em><b>Ugv Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ROBOT__UGV_KIND = eINSTANCE.getRobot_UgvKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.SystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SYSTEM__BASE_CLASS = eINSTANCE.getSystem_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Native</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SYSTEM__NATIVE = eINSTANCE.getSystem_Native();

		/**
		 * The meta object literal for the '<em><b>Library Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SYSTEM__LIBRARY_PATH = eINSTANCE.getSystem_LibraryPath();

		/**
		 * The meta object literal for the '<em><b>Library Component Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SYSTEM__LIBRARY_COMPONENT_NAME = eINSTANCE.getSystem_LibraryComponentName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.AgentImpl <em>Agent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.AgentImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAgent()
		 * @generated
		 */
		EClass AGENT = eINSTANCE.getAgent();

		/**
		 * The meta object literal for the '<em><b>Moves Over</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference AGENT__MOVES_OVER = eINSTANCE.getAgent_MovesOver();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PhysicalObjectImpl <em>Physical Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.PhysicalObjectImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPhysicalObject()
		 * @generated
		 */
		EClass PHYSICAL_OBJECT = eINSTANCE.getPhysicalObject();

		/**
		 * The meta object literal for the '<em><b>Eveloves In</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PHYSICAL_OBJECT__EVELOVES_IN = eINSTANCE.getPhysicalObject_EvelovesIn();

		/**
		 * The meta object literal for the '<em><b>Has Surface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PHYSICAL_OBJECT__HAS_SURFACE = eINSTANCE.getPhysicalObject_HasSurface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.EnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.EnvironmentImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getEnvironment()
		 * @generated
		 */
		EClass ENVIRONMENT = eINSTANCE.getEnvironment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SurfaceImpl <em>Surface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.SurfaceImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSurface()
		 * @generated
		 */
		EClass SURFACE = eINSTANCE.getSurface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.DataFlowPortImpl <em>Data Flow Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.DataFlowPortImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDataFlowPort()
		 * @generated
		 */
		EClass DATA_FLOW_PORT = eINSTANCE.getDataFlowPort();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DATA_FLOW_PORT__DIRECTION = eINSTANCE.getDataFlowPort_Direction();

		/**
		 * The meta object literal for the '<em><b>Buffer Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DATA_FLOW_PORT__BUFFER_SIZE = eINSTANCE.getDataFlowPort_BufferSize();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.PortImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PORT__BASE_PORT = eINSTANCE.getPort_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Synchronization Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute PORT__SYNCHRONIZATION_POLICY = eINSTANCE.getPort_SynchronizationPolicy();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ServicePortImpl <em>Service Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.ServicePortImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getServicePort()
		 * @generated
		 */
		EClass SERVICE_PORT = eINSTANCE.getServicePort();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SERVICE_PORT__KIND = eINSTANCE.getServicePort_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ActuatorSystemImpl <em>Actuator System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.ActuatorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getActuatorSystem()
		 * @generated
		 */
		EClass ACTUATOR_SYSTEM = eINSTANCE.getActuatorSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticSystemImpl <em>Robotic System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.RoboticSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticSystem()
		 * @generated
		 */
		EClass ROBOTIC_SYSTEM = eINSTANCE.getRoboticSystem();

		/**
		 * The meta object literal for the '<em><b>Local Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ROBOTIC_SYSTEM__LOCAL_POSITION = eINSTANCE.getRoboticSystem_LocalPosition();

		/**
		 * The meta object literal for the '<em><b>Local Orientation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ROBOTIC_SYSTEM__LOCAL_ORIENTATION = eINSTANCE.getRoboticSystem_LocalOrientation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SensorSystemImpl <em>Sensor System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.SensorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSensorSystem()
		 * @generated
		 */
		EClass SENSOR_SYSTEM = eINSTANCE.getSensorSystem();

		/**
		 * The meta object literal for the '<em><b>Frequency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SENSOR_SYSTEM__FREQUENCY = eINSTANCE.getSensorSystem_Frequency();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SENSOR_SYSTEM__IDENTIFIER = eINSTANCE.getSensorSystem_Identifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.HardwareImpl <em>Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.HardwareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getHardware()
		 * @generated
		 */
		EClass HARDWARE = eINSTANCE.getHardware();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SoftwareImpl <em>Software</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.SoftwareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSoftware()
		 * @generated
		 */
		EClass SOFTWARE = eINSTANCE.getSoftware();

		/**
		 * The meta object literal for the '<em><b>Is Periodic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SOFTWARE__IS_PERIODIC = eINSTANCE.getSoftware_IsPeriodic();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SOFTWARE__PERIOD = eINSTANCE.getSoftware_Period();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SOFTWARE__PRIORITY = eINSTANCE.getSoftware_Priority();

		/**
		 * The meta object literal for the '<em><b>Deadline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SOFTWARE__DEADLINE = eINSTANCE.getSoftware_Deadline();

		/**
		 * The meta object literal for the '<em><b>Wcet</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SOFTWARE__WCET = eINSTANCE.getSoftware_Wcet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PrimitiveDataImpl <em>Primitive Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.PrimitiveDataImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPrimitiveData()
		 * @generated
		 */
		EClass PRIMITIVE_DATA = eINSTANCE.getPrimitiveData();

		/**
		 * The meta object literal for the '<em><b>Base Primitive Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PRIMITIVE_DATA__BASE_PRIMITIVE_TYPE = eINSTANCE.getPrimitiveData_Base_PrimitiveType();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.DataTypeImpl <em>Data Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.DataTypeImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDataType()
		 * @generated
		 */
		EClass DATA_TYPE = eINSTANCE.getDataType();

		/**
		 * The meta object literal for the '<em><b>Base Data Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DATA_TYPE__BASE_DATA_TYPE = eINSTANCE.getDataType_Base_DataType();

		/**
		 * The meta object literal for the '<em><b>Native</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DATA_TYPE__NATIVE = eINSTANCE.getDataType_Native();

		/**
		 * The meta object literal for the '<em><b>Library Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute DATA_TYPE__LIBRARY_PATH = eINSTANCE.getDataType_LibraryPath();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.EngineSystemImpl <em>Engine System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.EngineSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getEngineSystem()
		 * @generated
		 */
		EClass ENGINE_SYSTEM = eINSTANCE.getEngineSystem();

		/**
		 * The meta object literal for the '<em><b>Vehicle Traction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__VEHICLE_TRACTION = eINSTANCE.getEngineSystem_VehicleTraction();

		/**
		 * The meta object literal for the '<em><b>Max Engine Force</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__MAX_ENGINE_FORCE = eINSTANCE.getEngineSystem_MaxEngineForce();

		/**
		 * The meta object literal for the '<em><b>Max Breaking Force</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__MAX_BREAKING_FORCE = eINSTANCE.getEngineSystem_MaxBreakingForce();

		/**
		 * The meta object literal for the '<em><b>Max Allowed Steering</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__MAX_ALLOWED_STEERING = eINSTANCE.getEngineSystem_MaxAllowedSteering();

		/**
		 * The meta object literal for the '<em><b>Max Allowed Velocity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__MAX_ALLOWED_VELOCITY = eINSTANCE.getEngineSystem_MaxAllowedVelocity();

		/**
		 * The meta object literal for the '<em><b>Gear ration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__GEAR_RATION = eINSTANCE.getEngineSystem_Gear_ration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.WheelSystemImpl <em>Wheel System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.WheelSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getWheelSystem()
		 * @generated
		 */
		EClass WHEEL_SYSTEM = eINSTANCE.getWheelSystem();

		/**
		 * The meta object literal for the '<em><b>Wheel Radius</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__WHEEL_RADIUS = eINSTANCE.getWheelSystem_WheelRadius();

		/**
		 * The meta object literal for the '<em><b>Wheel Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__WHEEL_WIDTH = eINSTANCE.getWheelSystem_WheelWidth();

		/**
		 * The meta object literal for the '<em><b>Suspension Rest Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__SUSPENSION_REST_LENGTH = eINSTANCE.getWheelSystem_SuspensionRestLength();

		/**
		 * The meta object literal for the '<em><b>Wheel Connection Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT = eINSTANCE.getWheelSystem_WheelConnectionHeight();

		/**
		 * The meta object literal for the '<em><b>Type Of Wheel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__TYPE_OF_WHEEL = eINSTANCE.getWheelSystem_TypeOfWheel();

		/**
		 * The meta object literal for the '<em><b>Wheel Velocity PI Dkp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP = eINSTANCE.getWheelSystem_WheelVelocityPIDkp();

		/**
		 * The meta object literal for the '<em><b>Wheel Velocity PI Dki</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI = eINSTANCE.getWheelSystem_WheelVelocityPIDki();

		/**
		 * The meta object literal for the '<em><b>Wheel Velocity PI Dkd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD = eINSTANCE.getWheelSystem_WheelVelocityPIDkd();

		/**
		 * The meta object literal for the '<em><b>Wheel Steering PI Dkp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP = eINSTANCE.getWheelSystem_WheelSteeringPIDkp();

		/**
		 * The meta object literal for the '<em><b>Wheel Steering PI Dkd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD = eINSTANCE.getWheelSystem_WheelSteeringPIDkd();

		/**
		 * The meta object literal for the '<em><b>Wheel Friction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__WHEEL_FRICTION = eINSTANCE.getWheelSystem_WheelFriction();

		/**
		 * The meta object literal for the '<em><b>Suspension Stiffness</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__SUSPENSION_STIFFNESS = eINSTANCE.getWheelSystem_SuspensionStiffness();

		/**
		 * The meta object literal for the '<em><b>Suspension Damping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__SUSPENSION_DAMPING = eINSTANCE.getWheelSystem_SuspensionDamping();

		/**
		 * The meta object literal for the '<em><b>Suspension Compression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__SUSPENSION_COMPRESSION = eINSTANCE.getWheelSystem_SuspensionCompression();

		/**
		 * The meta object literal for the '<em><b>Wheel Velocity PI Dmax Sum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM = eINSTANCE.getWheelSystem_WheelVelocityPIDmaxSum();

		/**
		 * The meta object literal for the '<em><b>Wheel Velocity PI Dmax Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL = eINSTANCE.getWheelSystem_WheelVelocityPIDmaxVal();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ImageSensorSystemImpl <em>Image Sensor System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.ImageSensorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getImageSensorSystem()
		 * @generated
		 */
		EClass IMAGE_SENSOR_SYSTEM = eINSTANCE.getImageSensorSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl <em>Camera System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.CameraSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCameraSystem()
		 * @generated
		 */
		EClass CAMERA_SYSTEM = eINSTANCE.getCameraSystem();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__WIDTH = eINSTANCE.getCameraSystem_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__HEIGHT = eINSTANCE.getCameraSystem_Height();

		/**
		 * The meta object literal for the '<em><b>Alpha u</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__ALPHA_U = eINSTANCE.getCameraSystem_Alpha_u();

		/**
		 * The meta object literal for the '<em><b>Alpha v</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__ALPHA_V = eINSTANCE.getCameraSystem_Alpha_v();

		/**
		 * The meta object literal for the '<em><b>U0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__U0 = eINSTANCE.getCameraSystem_U0();

		/**
		 * The meta object literal for the '<em><b>V0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__V0 = eINSTANCE.getCameraSystem_V0();

		/**
		 * The meta object literal for the '<em><b>Color format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__COLOR_FORMAT = eINSTANCE.getCameraSystem_Color_format();

		/**
		 * The meta object literal for the '<em><b>Translate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CAMERA_SYSTEM__TRANSLATE = eINSTANCE.getCameraSystem_Translate();

		/**
		 * The meta object literal for the '<em><b>Rotate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CAMERA_SYSTEM__ROTATE = eINSTANCE.getCameraSystem_Rotate();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ObjectDetectionSensorSystemImpl
		 * <em>Object Detection Sensor System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.ObjectDetectionSensorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getObjectDetectionSensorSystem()
		 * @generated
		 */
		EClass OBJECT_DETECTION_SENSOR_SYSTEM = eINSTANCE.getObjectDetectionSensorSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ObjectTrackingSensorSystemImpl
		 * <em>Object Tracking Sensor System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.ObjectTrackingSensorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getObjectTrackingSensorSystem()
		 * @generated
		 */
		EClass OBJECT_TRACKING_SENSOR_SYSTEM = eINSTANCE.getObjectTrackingSensorSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl <em>Lidar System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.LidarSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLidarSystem()
		 * @generated
		 */
		EClass LIDAR_SYSTEM = eINSTANCE.getLidarSystem();

		/**
		 * The meta object literal for the '<em><b>Nb Layers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__NB_LAYERS = eINSTANCE.getLidarSystem_NbLayers();

		/**
		 * The meta object literal for the '<em><b>Layer Angle Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__LAYER_ANGLE_MIN = eINSTANCE.getLidarSystem_LayerAngleMin();

		/**
		 * The meta object literal for the '<em><b>Layer Angle Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__LAYER_ANGLE_STEP = eINSTANCE.getLidarSystem_LayerAngleStep();

		/**
		 * The meta object literal for the '<em><b>Noise</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__NOISE = eINSTANCE.getLidarSystem_Noise();

		/**
		 * The meta object literal for the '<em><b>Sigma Noise</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__SIGMA_NOISE = eINSTANCE.getLidarSystem_SigmaNoise();

		/**
		 * The meta object literal for the '<em><b>Angle min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__ANGLE_MIN = eINSTANCE.getLidarSystem_Angle_min();

		/**
		 * The meta object literal for the '<em><b>Angle max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__ANGLE_MAX = eINSTANCE.getLidarSystem_Angle_max();

		/**
		 * The meta object literal for the '<em><b>Time increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__TIME_INCREMENT = eINSTANCE.getLidarSystem_Time_increment();

		/**
		 * The meta object literal for the '<em><b>Scan time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__SCAN_TIME = eINSTANCE.getLidarSystem_Scan_time();

		/**
		 * The meta object literal for the '<em><b>Range min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__RANGE_MIN = eINSTANCE.getLidarSystem_Range_min();

		/**
		 * The meta object literal for the '<em><b>Range max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__RANGE_MAX = eINSTANCE.getLidarSystem_Range_max();

		/**
		 * The meta object literal for the '<em><b>Nb Rays</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__NB_RAYS = eINSTANCE.getLidarSystem_NbRays();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.LocalizationSensorSystemImpl <em>Localization Sensor System</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.LocalizationSensorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLocalizationSensorSystem()
		 * @generated
		 */
		EClass LOCALIZATION_SENSOR_SYSTEM = eINSTANCE.getLocalizationSensorSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.GPSSystemImpl <em>GPS System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.GPSSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGPSSystem()
		 * @generated
		 */
		EClass GPS_SYSTEM = eINSTANCE.getGPSSystem();

		/**
		 * The meta object literal for the '<em><b>Origin Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference GPS_SYSTEM__ORIGIN_POSITION = eINSTANCE.getGPSSystem_OriginPosition();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SimulatedSystemImpl <em>Simulated System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.SimulatedSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSimulatedSystem()
		 * @generated
		 */
		EClass SIMULATED_SYSTEM = eINSTANCE.getSimulatedSystem();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference SIMULATED_SYSTEM__BASE_PROPERTY = eINSTANCE.getSimulatedSystem_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Mesh</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute SIMULATED_SYSTEM__MESH = eINSTANCE.getSimulatedSystem_Mesh();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.AlgorithmLibraryImpl <em>Algorithm Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.AlgorithmLibraryImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAlgorithmLibrary()
		 * @generated
		 */
		EClass ALGORITHM_LIBRARY = eINSTANCE.getAlgorithmLibrary();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALGORITHM_LIBRARY__BASE_CLASS = eINSTANCE.getAlgorithmLibrary_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ALGORITHM_LIBRARY__PATH = eINSTANCE.getAlgorithmLibrary_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.StateImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Base State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STATE__BASE_STATE = eINSTANCE.getState_Base_State();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STATE__OPERATION = eINSTANCE.getState_Operation();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference STATE__ARGUMENTS = eINSTANCE.getState_Arguments();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SensorDriverImpl <em>Sensor Driver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.SensorDriverImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSensorDriver()
		 * @generated
		 */
		EClass SENSOR_DRIVER = eINSTANCE.getSensorDriver();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.BuildingImpl <em>Building</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.BuildingImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getBuilding()
		 * @generated
		 */
		EClass BUILDING = eINSTANCE.getBuilding();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PlanetImpl <em>Planet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.PlanetImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPlanet()
		 * @generated
		 */
		EClass PLANET = eINSTANCE.getPlanet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.LandSurfaceImpl <em>Land Surface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.LandSurfaceImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLandSurface()
		 * @generated
		 */
		EClass LAND_SURFACE = eINSTANCE.getLandSurface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.GroundImpl <em>Ground</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.GroundImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGround()
		 * @generated
		 */
		EClass GROUND = eINSTANCE.getGround();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.FloorImpl <em>Floor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.FloorImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getFloor()
		 * @generated
		 */
		EClass FLOOR = eINSTANCE.getFloor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.WaterSurfaceImpl <em>Water Surface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.WaterSurfaceImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getWaterSurface()
		 * @generated
		 */
		EClass WATER_SURFACE = eINSTANCE.getWaterSurface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.HumanImpl <em>Human</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.HumanImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getHuman()
		 * @generated
		 */
		EClass HUMAN = eINSTANCE.getHuman();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PedestrianImpl <em>Pedestrian</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.PedestrianImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPedestrian()
		 * @generated
		 */
		EClass PEDESTRIAN = eINSTANCE.getPedestrian();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.StairsImpl <em>Stairs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.StairsImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getStairs()
		 * @generated
		 */
		EClass STAIRS = eINSTANCE.getStairs();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PlatformImpl <em>Platform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.PlatformImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPlatform()
		 * @generated
		 */
		EClass PLATFORM = eINSTANCE.getPlatform();

		/**
		 * The meta object literal for the '<em><b>Base Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference PLATFORM__BASE_NODE = eINSTANCE.getPlatform_Base_Node();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticMiddlewareImpl <em>Robotic Middleware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.RoboticMiddlewareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticMiddleware()
		 * @generated
		 */
		EClass ROBOTIC_MIDDLEWARE = eINSTANCE.getRoboticMiddleware();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute ROBOTIC_MIDDLEWARE__KIND = eINSTANCE.getRoboticMiddleware_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticSimulatorImpl <em>Robotic Simulator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.RoboticSimulatorImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticSimulator()
		 * @generated
		 */
		EClass ROBOTIC_SIMULATOR = eINSTANCE.getRoboticSimulator();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.CycabTKImpl <em>Cycab TK</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.CycabTKImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCycabTK()
		 * @generated
		 */
		EClass CYCAB_TK = eINSTANCE.getCycabTK();

		/**
		 * The meta object literal for the '<em><b>Use Real Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CYCAB_TK__USE_REAL_TIME = eINSTANCE.getCycabTK_UseRealTime();

		/**
		 * The meta object literal for the '<em><b>Time Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CYCAB_TK__TIME_STEP = eINSTANCE.getCycabTK_TimeStep();

		/**
		 * The meta object literal for the '<em><b>Time Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute CYCAB_TK__TIME_FACTOR = eINSTANCE.getCycabTK_TimeFactor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl <em>Blender Morse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getBlenderMorse()
		 * @generated
		 */
		EClass BLENDER_MORSE = eINSTANCE.getBlenderMorse();

		/**
		 * The meta object literal for the '<em><b>Debug Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BLENDER_MORSE__DEBUG_MODE = eINSTANCE.getBlenderMorse_DebugMode();

		/**
		 * The meta object literal for the '<em><b>Debug Display</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BLENDER_MORSE__DEBUG_DISPLAY = eINSTANCE.getBlenderMorse_DebugDisplay();

		/**
		 * The meta object literal for the '<em><b>Gravity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BLENDER_MORSE__GRAVITY = eINSTANCE.getBlenderMorse_Gravity();

		/**
		 * The meta object literal for the '<em><b>viewport shade</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EAttribute BLENDER_MORSE__VIEWPORT_SHADE = eINSTANCE.getBlenderMorse__viewport_shade();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.OnPortImpl <em>On Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.OnPortImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOnPort()
		 * @generated
		 */
		EClass ON_PORT = eINSTANCE.getOnPort();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ON_PORT__PORT = eINSTANCE.getOnPort_Port();

		/**
		 * The meta object literal for the '<em><b>Base Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ON_PORT__BASE_PARAMETER = eINSTANCE.getOnPort_Base_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.AllocateImpl <em>Allocate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.AllocateImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAllocate()
		 * @generated
		 */
		EClass ALLOCATE = eINSTANCE.getAllocate();

		/**
		 * The meta object literal for the '<em><b>Base Abstraction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference ALLOCATE__BASE_ABSTRACTION = eINSTANCE.getAllocate_Base_Abstraction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.InertialMeasurementUnitSystemImpl
		 * <em>Inertial Measurement Unit System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.InertialMeasurementUnitSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInertialMeasurementUnitSystem()
		 * @generated
		 */
		EClass INERTIAL_MEASUREMENT_UNIT_SYSTEM = eINSTANCE.getInertialMeasurementUnitSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.InertialNavigationSystemImpl <em>Inertial Navigation System</em>}'
		 * class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.InertialNavigationSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInertialNavigationSystem()
		 * @generated
		 */
		EClass INERTIAL_NAVIGATION_SYSTEM = eINSTANCE.getInertialNavigationSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.OdometrySystemImpl <em>Odometry System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.OdometrySystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOdometrySystem()
		 * @generated
		 */
		EClass ODOMETRY_SYSTEM = eINSTANCE.getOdometrySystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.InfraRedProximetrySystemImpl <em>Infra Red Proximetry System</em>}
		 * ' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.InfraRedProximetrySystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInfraRedProximetrySystem()
		 * @generated
		 */
		EClass INFRA_RED_PROXIMETRY_SYSTEM = eINSTANCE.getInfraRedProximetrySystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.DeploymentPlanImpl <em>Deployment Plan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.DeploymentPlanImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDeploymentPlan()
		 * @generated
		 */
		EClass DEPLOYMENT_PLAN = eINSTANCE.getDeploymentPlan();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPLOYMENT_PLAN__BASE_PACKAGE = eINSTANCE.getDeploymentPlan_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Main Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference DEPLOYMENT_PLAN__MAIN_INSTANCE = eINSTANCE.getDeploymentPlan_MainInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.GyroscopeImpl <em>Gyroscope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.impl.GyroscopeImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGyroscope()
		 * @generated
		 */
		EClass GYROSCOPE = eINSTANCE.getGyroscope();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.RobotKind <em>Robot Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.RobotKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRobotKind()
		 * @generated
		 */
		EEnum ROBOT_KIND = eINSTANCE.getRobotKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.UGVKind <em>UGV Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.UGVKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getUGVKind()
		 * @generated
		 */
		EEnum UGV_KIND = eINSTANCE.getUGVKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.SynchronizationKind <em>Synchronization Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.SynchronizationKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSynchronizationKind()
		 * @generated
		 */
		EEnum SYNCHRONIZATION_KIND = eINSTANCE.getSynchronizationKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.DataFlowDirectionKind <em>Data Flow Direction Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.DataFlowDirectionKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDataFlowDirectionKind()
		 * @generated
		 */
		EEnum DATA_FLOW_DIRECTION_KIND = eINSTANCE.getDataFlowDirectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.ServiceFlowKind <em>Service Flow Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.ServiceFlowKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getServiceFlowKind()
		 * @generated
		 */
		EEnum SERVICE_FLOW_KIND = eINSTANCE.getServiceFlowKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.RoboticMiddlewareKind <em>Robotic Middleware Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.RoboticMiddlewareKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticMiddlewareKind()
		 * @generated
		 */
		EEnum ROBOTIC_MIDDLEWARE_KIND = eINSTANCE.getRoboticMiddlewareKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.Shade <em>Shade</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * 
		 * @see org.eclipse.papyrus.RobotML.Shade
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getShade()
		 * @generated
		 */
		EEnum SHADE = eINSTANCE.getShade();

	}

} //RobotMLPackage
