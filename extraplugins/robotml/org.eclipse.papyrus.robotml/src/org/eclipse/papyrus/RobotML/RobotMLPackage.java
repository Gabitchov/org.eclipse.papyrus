/**
 */
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
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.papyrus.RobotML.RobotMLFactory
 * @model kind="package"
 * @generated
 */
public interface RobotMLPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "RobotML";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://Papyrus/RobotML/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "RobotML";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	RobotMLPackage eINSTANCE = org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.TransitionImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Base Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__BASE_TRANSITION = 0;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GUARD = 1;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__EFFECT = 2;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.AlgorithmImpl <em>Algorithm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.AlgorithmImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAlgorithm()
	 * @generated
	 */
	int ALGORITHM = 1;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__BASE_OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Is External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__IS_EXTERNAL = 1;

	/**
	 * The feature id for the '<em><b>Ext Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__EXT_FUNCTION_NAME = 2;

	/**
	 * The feature id for the '<em><b>Lib Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__LIB_PATH = 3;

	/**
	 * The feature id for the '<em><b>Lib File Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM__LIB_FILE_FORMAT = 4;

	/**
	 * The number of structural features of the '<em>Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Algorithm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.StateImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getState()
	 * @generated
	 */
	int STATE = 2;

	/**
	 * The feature id for the '<em><b>Base State</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__BASE_STATE = 0;

	/**
	 * The feature id for the '<em><b>Behavior</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE__BEHAVIOR = 1;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>State</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.JointImpl <em>Joint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.JointImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getJoint()
	 * @generated
	 */
	int JOINT = 4;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOINT__BASE_CONNECTOR = 0;

	/**
	 * The number of structural features of the '<em>Joint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOINT_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Joint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOINT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ActuatedJointImpl <em>Actuated Joint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ActuatedJointImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getActuatedJoint()
	 * @generated
	 */
	int ACTUATED_JOINT = 3;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATED_JOINT__BASE_CONNECTOR = JOINT__BASE_CONNECTOR;

	/**
	 * The number of structural features of the '<em>Actuated Joint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATED_JOINT_FEATURE_COUNT = JOINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Actuated Joint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATED_JOINT_OPERATION_COUNT = JOINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.CompleteBondingImpl <em>Complete Bonding</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.CompleteBondingImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCompleteBonding()
	 * @generated
	 */
	int COMPLETE_BONDING = 5;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_BONDING__BASE_CONNECTOR = JOINT__BASE_CONNECTOR;

	/**
	 * The number of structural features of the '<em>Complete Bonding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_BONDING_FEATURE_COUNT = JOINT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Complete Bonding</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETE_BONDING_OPERATION_COUNT = JOINT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.SystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 7;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__NATIVE = 1;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__LIBRARY_PATH = 2;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__LIBRARY_COMPONENT_NAME = 3;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PhysicalObjectImpl <em>Physical Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.PhysicalObjectImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPhysicalObject()
	 * @generated
	 */
	int PHYSICAL_OBJECT = 9;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__EVELOVES_IN = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__HAS_SURFACE = SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__HEIGHT = SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT__MASS = SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Physical Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Physical Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PHYSICAL_OBJECT_OPERATION_COUNT = SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.AgentImpl <em>Agent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.AgentImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAgent()
	 * @generated
	 */
	int AGENT = 8;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__BASE_CLASS = PHYSICAL_OBJECT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__NATIVE = PHYSICAL_OBJECT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__LIBRARY_PATH = PHYSICAL_OBJECT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__LIBRARY_COMPONENT_NAME = PHYSICAL_OBJECT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__EVELOVES_IN = PHYSICAL_OBJECT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__HAS_SURFACE = PHYSICAL_OBJECT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__HEIGHT = PHYSICAL_OBJECT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__MASS = PHYSICAL_OBJECT__MASS;

	/**
	 * The feature id for the '<em><b>Moves Over</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT__MOVES_OVER = PHYSICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_FEATURE_COUNT = PHYSICAL_OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Agent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGENT_OPERATION_COUNT = PHYSICAL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.RobotImpl <em>Robot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.RobotImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRobot()
	 * @generated
	 */
	int ROBOT = 6;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__BASE_CLASS = AGENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__NATIVE = AGENT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__LIBRARY_PATH = AGENT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__LIBRARY_COMPONENT_NAME = AGENT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__EVELOVES_IN = AGENT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__HAS_SURFACE = AGENT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__HEIGHT = AGENT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__MASS = AGENT__MASS;

	/**
	 * The feature id for the '<em><b>Moves Over</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__MOVES_OVER = AGENT__MOVES_OVER;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT__WIDTH = AGENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Robot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_FEATURE_COUNT = AGENT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Robot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOT_OPERATION_COUNT = AGENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.EnvironmentImpl <em>Environment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.EnvironmentImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getEnvironment()
	 * @generated
	 */
	int ENVIRONMENT = 10;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The number of structural features of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Environment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENVIRONMENT_OPERATION_COUNT = SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SurfaceImpl <em>Surface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.SurfaceImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSurface()
	 * @generated
	 */
	int SURFACE = 11;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE__BASE_CLASS = PHYSICAL_OBJECT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE__NATIVE = PHYSICAL_OBJECT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE__LIBRARY_PATH = PHYSICAL_OBJECT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE__LIBRARY_COMPONENT_NAME = PHYSICAL_OBJECT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE__EVELOVES_IN = PHYSICAL_OBJECT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE__HAS_SURFACE = PHYSICAL_OBJECT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE__HEIGHT = PHYSICAL_OBJECT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE__MASS = PHYSICAL_OBJECT__MASS;

	/**
	 * The number of structural features of the '<em>Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE_FEATURE_COUNT = PHYSICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SURFACE_OPERATION_COUNT = PHYSICAL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.PortImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 13;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__BASE_PORT = 0;

	/**
	 * The feature id for the '<em><b>Synchronization Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__SYNCHRONIZATION_POLICY = 1;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.DataFlowPortImpl <em>Data Flow Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.DataFlowPortImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDataFlowPort()
	 * @generated
	 */
	int DATA_FLOW_PORT = 12;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_PORT__BASE_PORT = PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Synchronization Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_PORT__SYNCHRONIZATION_POLICY = PORT__SYNCHRONIZATION_POLICY;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_PORT__DIRECTION = PORT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Buffer Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_PORT__BUFFER_SIZE = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Data Flow Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Data Flow Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FLOW_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ServicePortImpl <em>Service Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ServicePortImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getServicePort()
	 * @generated
	 */
	int SERVICE_PORT = 14;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PORT__BASE_PORT = PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Synchronization Policy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PORT__SYNCHRONIZATION_POLICY = PORT__SYNCHRONIZATION_POLICY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PORT__KIND = PORT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Service Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Service Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_PORT_OPERATION_COUNT = PORT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticSystemImpl <em>Robotic System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.RoboticSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticSystem()
	 * @generated
	 */
	int ROBOTIC_SYSTEM = 16;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__LOCAL_POSITION = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM__LOCAL_ORIENTATION = SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Robotic System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Robotic System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SYSTEM_OPERATION_COUNT = SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ActuatorSystemImpl <em>Actuator System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ActuatorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getActuatorSystem()
	 * @generated
	 */
	int ACTUATOR_SYSTEM = 15;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__BASE_CLASS = ROBOTIC_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__NATIVE = ROBOTIC_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__LIBRARY_PATH = ROBOTIC_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__LIBRARY_COMPONENT_NAME = ROBOTIC_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__LOCAL_POSITION = ROBOTIC_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM__LOCAL_ORIENTATION = ROBOTIC_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The number of structural features of the '<em>Actuator System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM_FEATURE_COUNT = ROBOTIC_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Actuator System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_SYSTEM_OPERATION_COUNT = ROBOTIC_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.CyberPhysicalSystemImpl <em>Cyber Physical System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.CyberPhysicalSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCyberPhysicalSystem()
	 * @generated
	 */
	int CYBER_PHYSICAL_SYSTEM = 17;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The number of structural features of the '<em>Cyber Physical System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Cyber Physical System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYBER_PHYSICAL_SYSTEM_OPERATION_COUNT = SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SensorSystemImpl <em>Sensor System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.SensorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSensorSystem()
	 * @generated
	 */
	int SENSOR_SYSTEM = 18;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__BASE_CLASS = ROBOTIC_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__NATIVE = ROBOTIC_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__LIBRARY_PATH = ROBOTIC_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME = ROBOTIC_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__LOCAL_POSITION = ROBOTIC_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__LOCAL_ORIENTATION = ROBOTIC_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__FREQUENCY = ROBOTIC_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM__IDENTIFIER = ROBOTIC_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM_FEATURE_COUNT = ROBOTIC_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_SYSTEM_OPERATION_COUNT = ROBOTIC_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.HardwareImpl <em>Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.HardwareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getHardware()
	 * @generated
	 */
	int HARDWARE = 19;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__BASE_CLASS = PHYSICAL_OBJECT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__NATIVE = PHYSICAL_OBJECT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__LIBRARY_PATH = PHYSICAL_OBJECT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__LIBRARY_COMPONENT_NAME = PHYSICAL_OBJECT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__EVELOVES_IN = PHYSICAL_OBJECT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__HAS_SURFACE = PHYSICAL_OBJECT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__HEIGHT = PHYSICAL_OBJECT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE__MASS = PHYSICAL_OBJECT__MASS;

	/**
	 * The number of structural features of the '<em>Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_FEATURE_COUNT = PHYSICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HARDWARE_OPERATION_COUNT = PHYSICAL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SoftwareImpl <em>Software</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.SoftwareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSoftware()
	 * @generated
	 */
	int SOFTWARE = 20;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Is Periodic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__IS_PERIODIC = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__PERIOD = SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__PRIORITY = SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__DEADLINE = SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Wcet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE__WCET = SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Software</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Software</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOFTWARE_OPERATION_COUNT = SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.EngineSystemImpl <em>Engine System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.EngineSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getEngineSystem()
	 * @generated
	 */
	int ENGINE_SYSTEM = 21;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__BASE_CLASS = ACTUATOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__NATIVE = ACTUATOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__LIBRARY_PATH = ACTUATOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__LIBRARY_COMPONENT_NAME = ACTUATOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__LOCAL_POSITION = ACTUATOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__LOCAL_ORIENTATION = ACTUATOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Vehicle Traction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__VEHICLE_TRACTION = ACTUATOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max Engine Force</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__MAX_ENGINE_FORCE = ACTUATOR_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Breaking Force</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__MAX_BREAKING_FORCE = ACTUATOR_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Allowed Steering</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__MAX_ALLOWED_STEERING = ACTUATOR_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Max Allowed Velocity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__MAX_ALLOWED_VELOCITY = ACTUATOR_SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Gear ration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM__GEAR_RATION = ACTUATOR_SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Engine System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM_FEATURE_COUNT = ACTUATOR_SYSTEM_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Engine System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENGINE_SYSTEM_OPERATION_COUNT = ACTUATOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.LocomotionSystemImpl <em>Locomotion System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.LocomotionSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLocomotionSystem()
	 * @generated
	 */
	int LOCOMOTION_SYSTEM = 23;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_SYSTEM__BASE_CLASS = ACTUATOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_SYSTEM__NATIVE = ACTUATOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_SYSTEM__LIBRARY_PATH = ACTUATOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_SYSTEM__LIBRARY_COMPONENT_NAME = ACTUATOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_SYSTEM__LOCAL_POSITION = ACTUATOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_SYSTEM__LOCAL_ORIENTATION = ACTUATOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The number of structural features of the '<em>Locomotion System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_SYSTEM_FEATURE_COUNT = ACTUATOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Locomotion System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_SYSTEM_OPERATION_COUNT = ACTUATOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl <em>Steered Wheel System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSteeredWheelSystem()
	 * @generated
	 */
	int STEERED_WHEEL_SYSTEM = 22;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__BASE_CLASS = LOCOMOTION_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__NATIVE = LOCOMOTION_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__LIBRARY_PATH = LOCOMOTION_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__LIBRARY_COMPONENT_NAME = LOCOMOTION_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__LOCAL_POSITION = LOCOMOTION_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__LOCAL_ORIENTATION = LOCOMOTION_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Wheel Radius</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__WHEEL_RADIUS = LOCOMOTION_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Wheel Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__WHEEL_WIDTH = LOCOMOTION_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Suspension Rest Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH = LOCOMOTION_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Wheel Connection Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT = LOCOMOTION_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Type Of Wheel</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL = LOCOMOTION_SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Wheel Velocity PI Dkp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP = LOCOMOTION_SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Wheel Velocity PI Dki</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI = LOCOMOTION_SYSTEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Wheel Velocity PI Dkd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD = LOCOMOTION_SYSTEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Wheel Steering PI Dkp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP = LOCOMOTION_SYSTEM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Wheel Steering PI Dkd</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD = LOCOMOTION_SYSTEM_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Wheel Friction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__WHEEL_FRICTION = LOCOMOTION_SYSTEM_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Suspension Stiffness</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS = LOCOMOTION_SYSTEM_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Suspension Damping</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING = LOCOMOTION_SYSTEM_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Suspension Compression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION = LOCOMOTION_SYSTEM_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Wheel Velocity PI Dmax Sum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM = LOCOMOTION_SYSTEM_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Wheel Velocity PI Dmax Val</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL = LOCOMOTION_SYSTEM_FEATURE_COUNT + 15;

	/**
	 * The number of structural features of the '<em>Steered Wheel System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM_FEATURE_COUNT = LOCOMOTION_SYSTEM_FEATURE_COUNT + 16;

	/**
	 * The number of operations of the '<em>Steered Wheel System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_SYSTEM_OPERATION_COUNT = LOCOMOTION_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ImageSensorSystemImpl <em>Image Sensor System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ImageSensorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getImageSensorSystem()
	 * @generated
	 */
	int IMAGE_SENSOR_SYSTEM = 24;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Image Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Image Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMAGE_SENSOR_SYSTEM_OPERATION_COUNT = SENSOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl <em>Camera System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.CameraSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCameraSystem()
	 * @generated
	 */
	int CAMERA_SYSTEM = 25;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__BASE_CLASS = IMAGE_SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__NATIVE = IMAGE_SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__LIBRARY_PATH = IMAGE_SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__LIBRARY_COMPONENT_NAME = IMAGE_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__LOCAL_POSITION = IMAGE_SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__LOCAL_ORIENTATION = IMAGE_SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__FREQUENCY = IMAGE_SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__IDENTIFIER = IMAGE_SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__WIDTH = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__HEIGHT = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Alpha u</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__ALPHA_U = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Alpha v</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__ALPHA_V = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>U0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__U0 = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>V0</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__V0 = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Color format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__COLOR_FORMAT = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Translate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__TRANSLATE = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Rotate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM__ROTATE = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Camera System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM_FEATURE_COUNT = IMAGE_SENSOR_SYSTEM_FEATURE_COUNT + 9;

	/**
	 * The number of operations of the '<em>Camera System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAMERA_SYSTEM_OPERATION_COUNT = IMAGE_SENSOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ObjectDetectionSensorSystemImpl <em>Object Detection Sensor System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ObjectDetectionSensorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getObjectDetectionSensorSystem()
	 * @generated
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM = 26;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Object Detection Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Object Detection Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_DETECTION_SENSOR_SYSTEM_OPERATION_COUNT = SENSOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ObjectTrackingSensorSystemImpl <em>Object Tracking Sensor System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ObjectTrackingSensorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getObjectTrackingSensorSystem()
	 * @generated
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM = 27;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Object Tracking Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Object Tracking Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_TRACKING_SENSOR_SYSTEM_OPERATION_COUNT = SENSOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl <em>Lidar System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.LidarSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLidarSystem()
	 * @generated
	 */
	int LIDAR_SYSTEM = 28;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__BASE_CLASS = OBJECT_DETECTION_SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__NATIVE = OBJECT_DETECTION_SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LIBRARY_PATH = OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LIBRARY_COMPONENT_NAME = OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LOCAL_POSITION = OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LOCAL_ORIENTATION = OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__FREQUENCY = OBJECT_DETECTION_SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__IDENTIFIER = OBJECT_DETECTION_SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Nb Layers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__NB_LAYERS = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Layer Angle Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LAYER_ANGLE_MIN = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Layer Angle Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__LAYER_ANGLE_STEP = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Noise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__NOISE = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Sigma Noise</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__SIGMA_NOISE = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Angle min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__ANGLE_MIN = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Angle max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__ANGLE_MAX = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Time increment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__TIME_INCREMENT = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Scan time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__SCAN_TIME = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Range min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__RANGE_MIN = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Range max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__RANGE_MAX = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Nb Rays</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM__NB_RAYS = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 11;

	/**
	 * The number of structural features of the '<em>Lidar System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM_FEATURE_COUNT = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 12;

	/**
	 * The number of operations of the '<em>Lidar System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIDAR_SYSTEM_OPERATION_COUNT = OBJECT_DETECTION_SENSOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.LocalizationSensorSystemImpl <em>Localization Sensor System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.LocalizationSensorSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLocalizationSensorSystem()
	 * @generated
	 */
	int LOCALIZATION_SENSOR_SYSTEM = 29;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Localization Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Localization Sensor System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCALIZATION_SENSOR_SYSTEM_OPERATION_COUNT = SENSOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.GPSSystemImpl <em>GPS System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.GPSSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGPSSystem()
	 * @generated
	 */
	int GPS_SYSTEM = 30;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__BASE_CLASS = LOCALIZATION_SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__NATIVE = LOCALIZATION_SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__LIBRARY_PATH = LOCALIZATION_SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__LIBRARY_COMPONENT_NAME = LOCALIZATION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__LOCAL_POSITION = LOCALIZATION_SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__LOCAL_ORIENTATION = LOCALIZATION_SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__FREQUENCY = LOCALIZATION_SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__IDENTIFIER = LOCALIZATION_SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Origin Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM__ORIGIN_POSITION = LOCALIZATION_SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>GPS System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM_FEATURE_COUNT = LOCALIZATION_SENSOR_SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>GPS System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GPS_SYSTEM_OPERATION_COUNT = LOCALIZATION_SENSOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.AlgorithmLibraryImpl <em>Algorithm Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.AlgorithmLibraryImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAlgorithmLibrary()
	 * @generated
	 */
	int ALGORITHM_LIBRARY = 31;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_LIBRARY__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_LIBRARY__PATH = 1;

	/**
	 * The number of structural features of the '<em>Algorithm Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_LIBRARY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Algorithm Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_LIBRARY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SensorDriverImpl <em>Sensor Driver</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.SensorDriverImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSensorDriver()
	 * @generated
	 */
	int SENSOR_DRIVER = 32;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__BASE_CLASS = SOFTWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__NATIVE = SOFTWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__LIBRARY_PATH = SOFTWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__LIBRARY_COMPONENT_NAME = SOFTWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Is Periodic</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__IS_PERIODIC = SOFTWARE__IS_PERIODIC;

	/**
	 * The feature id for the '<em><b>Period</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__PERIOD = SOFTWARE__PERIOD;

	/**
	 * The feature id for the '<em><b>Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__PRIORITY = SOFTWARE__PRIORITY;

	/**
	 * The feature id for the '<em><b>Deadline</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__DEADLINE = SOFTWARE__DEADLINE;

	/**
	 * The feature id for the '<em><b>Wcet</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER__WCET = SOFTWARE__WCET;

	/**
	 * The number of structural features of the '<em>Sensor Driver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER_FEATURE_COUNT = SOFTWARE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sensor Driver</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_DRIVER_OPERATION_COUNT = SOFTWARE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.BuildingImpl <em>Building</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.BuildingImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getBuilding()
	 * @generated
	 */
	int BUILDING = 33;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__BASE_CLASS = PHYSICAL_OBJECT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__NATIVE = PHYSICAL_OBJECT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__LIBRARY_PATH = PHYSICAL_OBJECT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__LIBRARY_COMPONENT_NAME = PHYSICAL_OBJECT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__EVELOVES_IN = PHYSICAL_OBJECT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__HAS_SURFACE = PHYSICAL_OBJECT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__HEIGHT = PHYSICAL_OBJECT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING__MASS = PHYSICAL_OBJECT__MASS;

	/**
	 * The number of structural features of the '<em>Building</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_FEATURE_COUNT = PHYSICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Building</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILDING_OPERATION_COUNT = PHYSICAL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PlanetImpl <em>Planet</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.PlanetImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPlanet()
	 * @generated
	 */
	int PLANET = 34;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANET__BASE_CLASS = PHYSICAL_OBJECT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANET__NATIVE = PHYSICAL_OBJECT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANET__LIBRARY_PATH = PHYSICAL_OBJECT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANET__LIBRARY_COMPONENT_NAME = PHYSICAL_OBJECT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANET__EVELOVES_IN = PHYSICAL_OBJECT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANET__HAS_SURFACE = PHYSICAL_OBJECT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANET__HEIGHT = PHYSICAL_OBJECT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANET__MASS = PHYSICAL_OBJECT__MASS;

	/**
	 * The number of structural features of the '<em>Planet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANET_FEATURE_COUNT = PHYSICAL_OBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Planet</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLANET_OPERATION_COUNT = PHYSICAL_OBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.GroundImpl <em>Ground</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.GroundImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGround()
	 * @generated
	 */
	int GROUND = 36;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__BASE_CLASS = SURFACE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__NATIVE = SURFACE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__LIBRARY_PATH = SURFACE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__LIBRARY_COMPONENT_NAME = SURFACE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__EVELOVES_IN = SURFACE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__HAS_SURFACE = SURFACE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__HEIGHT = SURFACE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND__MASS = SURFACE__MASS;

	/**
	 * The number of structural features of the '<em>Ground</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_FEATURE_COUNT = SURFACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Ground</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GROUND_OPERATION_COUNT = SURFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.LandSurfaceImpl <em>Land Surface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.LandSurfaceImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLandSurface()
	 * @generated
	 */
	int LAND_SURFACE = 35;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__BASE_CLASS = GROUND__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__NATIVE = GROUND__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__LIBRARY_PATH = GROUND__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__LIBRARY_COMPONENT_NAME = GROUND__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__EVELOVES_IN = GROUND__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__HAS_SURFACE = GROUND__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__HEIGHT = GROUND__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE__MASS = GROUND__MASS;

	/**
	 * The number of structural features of the '<em>Land Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE_FEATURE_COUNT = GROUND_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Land Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LAND_SURFACE_OPERATION_COUNT = GROUND_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.FloorImpl <em>Floor</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.FloorImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getFloor()
	 * @generated
	 */
	int FLOOR = 37;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__BASE_CLASS = GROUND__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__NATIVE = GROUND__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__LIBRARY_PATH = GROUND__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__LIBRARY_COMPONENT_NAME = GROUND__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__EVELOVES_IN = GROUND__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__HAS_SURFACE = GROUND__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__HEIGHT = GROUND__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR__MASS = GROUND__MASS;

	/**
	 * The number of structural features of the '<em>Floor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR_FEATURE_COUNT = GROUND_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Floor</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FLOOR_OPERATION_COUNT = GROUND_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.WaterSurfaceImpl <em>Water Surface</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.WaterSurfaceImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getWaterSurface()
	 * @generated
	 */
	int WATER_SURFACE = 38;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__BASE_CLASS = SURFACE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__NATIVE = SURFACE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__LIBRARY_PATH = SURFACE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__LIBRARY_COMPONENT_NAME = SURFACE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__EVELOVES_IN = SURFACE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__HAS_SURFACE = SURFACE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__HEIGHT = SURFACE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE__MASS = SURFACE__MASS;

	/**
	 * The number of structural features of the '<em>Water Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE_FEATURE_COUNT = SURFACE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Water Surface</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WATER_SURFACE_OPERATION_COUNT = SURFACE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.HumanImpl <em>Human</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.HumanImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getHuman()
	 * @generated
	 */
	int HUMAN = 39;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__BASE_CLASS = AGENT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__NATIVE = AGENT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__LIBRARY_PATH = AGENT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__LIBRARY_COMPONENT_NAME = AGENT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__EVELOVES_IN = AGENT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__HAS_SURFACE = AGENT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__HEIGHT = AGENT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__MASS = AGENT__MASS;

	/**
	 * The feature id for the '<em><b>Moves Over</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN__MOVES_OVER = AGENT__MOVES_OVER;

	/**
	 * The number of structural features of the '<em>Human</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_FEATURE_COUNT = AGENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Human</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HUMAN_OPERATION_COUNT = AGENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PedestrianImpl <em>Pedestrian</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.PedestrianImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPedestrian()
	 * @generated
	 */
	int PEDESTRIAN = 40;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__BASE_CLASS = HUMAN__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__NATIVE = HUMAN__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__LIBRARY_PATH = HUMAN__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__LIBRARY_COMPONENT_NAME = HUMAN__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__EVELOVES_IN = HUMAN__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__HAS_SURFACE = HUMAN__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__HEIGHT = HUMAN__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__MASS = HUMAN__MASS;

	/**
	 * The feature id for the '<em><b>Moves Over</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN__MOVES_OVER = HUMAN__MOVES_OVER;

	/**
	 * The number of structural features of the '<em>Pedestrian</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN_FEATURE_COUNT = HUMAN_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Pedestrian</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PEDESTRIAN_OPERATION_COUNT = HUMAN_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.StairsImpl <em>Stairs</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.StairsImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getStairs()
	 * @generated
	 */
	int STAIRS = 41;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAIRS__BASE_CLASS = GROUND__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAIRS__NATIVE = GROUND__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAIRS__LIBRARY_PATH = GROUND__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAIRS__LIBRARY_COMPONENT_NAME = GROUND__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAIRS__EVELOVES_IN = GROUND__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAIRS__HAS_SURFACE = GROUND__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAIRS__HEIGHT = GROUND__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAIRS__MASS = GROUND__MASS;

	/**
	 * The number of structural features of the '<em>Stairs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAIRS_FEATURE_COUNT = GROUND_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Stairs</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STAIRS_OPERATION_COUNT = GROUND_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PlatformImpl <em>Platform</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.PlatformImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPlatform()
	 * @generated
	 */
	int PLATFORM = 42;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__BASE_CLASS = SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__NATIVE = SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__LIBRARY_PATH = SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__LIBRARY_COMPONENT_NAME = SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__BASE_NODE = SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Library</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM__LIBRARY = SYSTEM_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_FEATURE_COUNT = SYSTEM_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Platform</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLATFORM_OPERATION_COUNT = SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ExternalLibraryImpl <em>External Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ExternalLibraryImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getExternalLibrary()
	 * @generated
	 */
	int EXTERNAL_LIBRARY = 43;

	/**
	 * The feature id for the '<em><b>Lib Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_LIBRARY__LIB_PATH = 0;

	/**
	 * The feature id for the '<em><b>Lib File Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_LIBRARY__LIB_FILE_FORMAT = 1;

	/**
	 * The feature id for the '<em><b>Base Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_LIBRARY__BASE_INTERFACE = 2;

	/**
	 * The number of structural features of the '<em>External Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_LIBRARY_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>External Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_LIBRARY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticMiddlewareImpl <em>Robotic Middleware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.RoboticMiddlewareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticMiddleware()
	 * @generated
	 */
	int ROBOTIC_MIDDLEWARE = 44;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__BASE_CLASS = PLATFORM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__NATIVE = PLATFORM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__LIBRARY_PATH = PLATFORM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__LIBRARY_COMPONENT_NAME = PLATFORM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__BASE_NODE = PLATFORM__BASE_NODE;

	/**
	 * The feature id for the '<em><b>Library</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__LIBRARY = PLATFORM__LIBRARY;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE__KIND = PLATFORM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Robotic Middleware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE_FEATURE_COUNT = PLATFORM_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Robotic Middleware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_MIDDLEWARE_OPERATION_COUNT = PLATFORM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticSimulatorImpl <em>Robotic Simulator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.RoboticSimulatorImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticSimulator()
	 * @generated
	 */
	int ROBOTIC_SIMULATOR = 45;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR__BASE_CLASS = PLATFORM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR__NATIVE = PLATFORM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR__LIBRARY_PATH = PLATFORM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR__LIBRARY_COMPONENT_NAME = PLATFORM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR__BASE_NODE = PLATFORM__BASE_NODE;

	/**
	 * The feature id for the '<em><b>Library</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR__LIBRARY = PLATFORM__LIBRARY;

	/**
	 * The number of structural features of the '<em>Robotic Simulator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR_FEATURE_COUNT = PLATFORM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Robotic Simulator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_SIMULATOR_OPERATION_COUNT = PLATFORM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.CycabTKImpl <em>Cycab TK</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.CycabTKImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCycabTK()
	 * @generated
	 */
	int CYCAB_TK = 46;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__BASE_CLASS = ROBOTIC_SIMULATOR__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__NATIVE = ROBOTIC_SIMULATOR__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__LIBRARY_PATH = ROBOTIC_SIMULATOR__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__LIBRARY_COMPONENT_NAME = ROBOTIC_SIMULATOR__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__BASE_NODE = ROBOTIC_SIMULATOR__BASE_NODE;

	/**
	 * The feature id for the '<em><b>Library</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__LIBRARY = ROBOTIC_SIMULATOR__LIBRARY;

	/**
	 * The feature id for the '<em><b>Use Real Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__USE_REAL_TIME = ROBOTIC_SIMULATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Time Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__TIME_STEP = ROBOTIC_SIMULATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Time Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK__TIME_FACTOR = ROBOTIC_SIMULATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Cycab TK</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK_FEATURE_COUNT = ROBOTIC_SIMULATOR_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Cycab TK</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CYCAB_TK_OPERATION_COUNT = ROBOTIC_SIMULATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl <em>Blender Morse</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getBlenderMorse()
	 * @generated
	 */
	int BLENDER_MORSE = 47;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__BASE_CLASS = ROBOTIC_SIMULATOR__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__NATIVE = ROBOTIC_SIMULATOR__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__LIBRARY_PATH = ROBOTIC_SIMULATOR__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__LIBRARY_COMPONENT_NAME = ROBOTIC_SIMULATOR__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__BASE_NODE = ROBOTIC_SIMULATOR__BASE_NODE;

	/**
	 * The feature id for the '<em><b>Library</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__LIBRARY = ROBOTIC_SIMULATOR__LIBRARY;

	/**
	 * The feature id for the '<em><b>Debug Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__DEBUG_MODE = ROBOTIC_SIMULATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Debug Display</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__DEBUG_DISPLAY = ROBOTIC_SIMULATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Gravity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__GRAVITY = ROBOTIC_SIMULATOR_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>viewport shade</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE__VIEWPORT_SHADE = ROBOTIC_SIMULATOR_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Blender Morse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE_FEATURE_COUNT = ROBOTIC_SIMULATOR_FEATURE_COUNT + 4;

	/**
	 * The number of operations of the '<em>Blender Morse</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLENDER_MORSE_OPERATION_COUNT = ROBOTIC_SIMULATOR_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.OnPortImpl <em>On Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.OnPortImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOnPort()
	 * @generated
	 */
	int ON_PORT = 48;

	/**
	 * The feature id for the '<em><b>Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_PORT__PORT = 0;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_PORT__BASE_PARAMETER = 1;

	/**
	 * The number of structural features of the '<em>On Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_PORT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>On Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_PORT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.AllocateImpl <em>Allocate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.AllocateImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAllocate()
	 * @generated
	 */
	int ALLOCATE = 49;

	/**
	 * The feature id for the '<em><b>Base Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE__BASE_ABSTRACTION = 0;

	/**
	 * The number of structural features of the '<em>Allocate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Allocate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALLOCATE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.InertialMeasurementUnitSystemImpl <em>Inertial Measurement Unit System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.InertialMeasurementUnitSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInertialMeasurementUnitSystem()
	 * @generated
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM = 50;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Inertial Measurement Unit System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Inertial Measurement Unit System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_MEASUREMENT_UNIT_SYSTEM_OPERATION_COUNT = SENSOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.InertialNavigationSystemImpl <em>Inertial Navigation System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.InertialNavigationSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInertialNavigationSystem()
	 * @generated
	 */
	int INERTIAL_NAVIGATION_SYSTEM = 51;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__BASE_CLASS = GPS_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__NATIVE = GPS_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__LIBRARY_PATH = GPS_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__LIBRARY_COMPONENT_NAME = GPS_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__LOCAL_POSITION = GPS_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__LOCAL_ORIENTATION = GPS_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__FREQUENCY = GPS_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__IDENTIFIER = GPS_SYSTEM__IDENTIFIER;

	/**
	 * The feature id for the '<em><b>Origin Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM__ORIGIN_POSITION = GPS_SYSTEM__ORIGIN_POSITION;

	/**
	 * The number of structural features of the '<em>Inertial Navigation System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM_FEATURE_COUNT = GPS_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Inertial Navigation System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INERTIAL_NAVIGATION_SYSTEM_OPERATION_COUNT = GPS_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.OdometrySystemImpl <em>Odometry System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.OdometrySystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOdometrySystem()
	 * @generated
	 */
	int ODOMETRY_SYSTEM = 52;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__BASE_CLASS = LOCALIZATION_SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__NATIVE = LOCALIZATION_SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__LIBRARY_PATH = LOCALIZATION_SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__LIBRARY_COMPONENT_NAME = LOCALIZATION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__LOCAL_POSITION = LOCALIZATION_SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__LOCAL_ORIENTATION = LOCALIZATION_SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__FREQUENCY = LOCALIZATION_SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM__IDENTIFIER = LOCALIZATION_SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Odometry System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM_FEATURE_COUNT = LOCALIZATION_SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Odometry System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ODOMETRY_SYSTEM_OPERATION_COUNT = LOCALIZATION_SENSOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.InfraRedProximetrySystemImpl <em>Infra Red Proximetry System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.InfraRedProximetrySystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInfraRedProximetrySystem()
	 * @generated
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM = 53;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__BASE_CLASS = OBJECT_DETECTION_SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__NATIVE = OBJECT_DETECTION_SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__LIBRARY_PATH = OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__LIBRARY_COMPONENT_NAME = OBJECT_DETECTION_SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__LOCAL_POSITION = OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__LOCAL_ORIENTATION = OBJECT_DETECTION_SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__FREQUENCY = OBJECT_DETECTION_SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM__IDENTIFIER = OBJECT_DETECTION_SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Infra Red Proximetry System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM_FEATURE_COUNT = OBJECT_DETECTION_SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Infra Red Proximetry System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRA_RED_PROXIMETRY_SYSTEM_OPERATION_COUNT = OBJECT_DETECTION_SENSOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.DeploymentPlanImpl <em>Deployment Plan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.DeploymentPlanImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDeploymentPlan()
	 * @generated
	 */
	int DEPLOYMENT_PLAN = 54;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__BASE_PACKAGE = 0;

	/**
	 * The feature id for the '<em><b>Main Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__MAIN_INSTANCE = 1;

	/**
	 * The number of structural features of the '<em>Deployment Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Deployment Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.GyroscopeImpl <em>Gyroscope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.GyroscopeImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGyroscope()
	 * @generated
	 */
	int GYROSCOPE = 55;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__BASE_CLASS = SENSOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__NATIVE = SENSOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__LIBRARY_PATH = SENSOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__LIBRARY_COMPONENT_NAME = SENSOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__LOCAL_POSITION = SENSOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__LOCAL_ORIENTATION = SENSOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The feature id for the '<em><b>Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__FREQUENCY = SENSOR_SYSTEM__FREQUENCY;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE__IDENTIFIER = SENSOR_SYSTEM__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Gyroscope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE_FEATURE_COUNT = SENSOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Gyroscope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GYROSCOPE_OPERATION_COUNT = SENSOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.OnPropertyImpl <em>On Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.OnPropertyImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOnProperty()
	 * @generated
	 */
	int ON_PROPERTY = 56;

	/**
	 * The feature id for the '<em><b>Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_PROPERTY__PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Base Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_PROPERTY__BASE_PARAMETER = 1;

	/**
	 * The number of structural features of the '<em>On Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_PROPERTY_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>On Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ON_PROPERTY_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SupportingStructureImpl <em>Supporting Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.SupportingStructureImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSupportingStructure()
	 * @generated
	 */
	int SUPPORTING_STRUCTURE = 58;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_STRUCTURE__BASE_CLASS = HARDWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_STRUCTURE__NATIVE = HARDWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_STRUCTURE__LIBRARY_PATH = HARDWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_STRUCTURE__LIBRARY_COMPONENT_NAME = HARDWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_STRUCTURE__EVELOVES_IN = HARDWARE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_STRUCTURE__HAS_SURFACE = HARDWARE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_STRUCTURE__HEIGHT = HARDWARE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_STRUCTURE__MASS = HARDWARE__MASS;

	/**
	 * The number of structural features of the '<em>Supporting Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_STRUCTURE_FEATURE_COUNT = HARDWARE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Supporting Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUPPORTING_STRUCTURE_OPERATION_COUNT = HARDWARE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ChassisImpl <em>Chassis</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ChassisImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getChassis()
	 * @generated
	 */
	int CHASSIS = 57;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHASSIS__BASE_CLASS = SUPPORTING_STRUCTURE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHASSIS__NATIVE = SUPPORTING_STRUCTURE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHASSIS__LIBRARY_PATH = SUPPORTING_STRUCTURE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHASSIS__LIBRARY_COMPONENT_NAME = SUPPORTING_STRUCTURE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHASSIS__EVELOVES_IN = SUPPORTING_STRUCTURE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHASSIS__HAS_SURFACE = SUPPORTING_STRUCTURE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHASSIS__HEIGHT = SUPPORTING_STRUCTURE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHASSIS__MASS = SUPPORTING_STRUCTURE__MASS;

	/**
	 * The number of structural features of the '<em>Chassis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHASSIS_FEATURE_COUNT = SUPPORTING_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Chassis</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHASSIS_OPERATION_COUNT = SUPPORTING_STRUCTURE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.MechanicalLinkageImpl <em>Mechanical Linkage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.MechanicalLinkageImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getMechanicalLinkage()
	 * @generated
	 */
	int MECHANICAL_LINKAGE = 59;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MECHANICAL_LINKAGE__BASE_CLASS = HARDWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MECHANICAL_LINKAGE__NATIVE = HARDWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MECHANICAL_LINKAGE__LIBRARY_PATH = HARDWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MECHANICAL_LINKAGE__LIBRARY_COMPONENT_NAME = HARDWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MECHANICAL_LINKAGE__EVELOVES_IN = HARDWARE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MECHANICAL_LINKAGE__HAS_SURFACE = HARDWARE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MECHANICAL_LINKAGE__HEIGHT = HARDWARE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MECHANICAL_LINKAGE__MASS = HARDWARE__MASS;

	/**
	 * The number of structural features of the '<em>Mechanical Linkage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MECHANICAL_LINKAGE_FEATURE_COUNT = HARDWARE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Mechanical Linkage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MECHANICAL_LINKAGE_OPERATION_COUNT = HARDWARE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ActuatorHardwareImpl <em>Actuator Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ActuatorHardwareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getActuatorHardware()
	 * @generated
	 */
	int ACTUATOR_HARDWARE = 62;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_HARDWARE__BASE_CLASS = HARDWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_HARDWARE__NATIVE = HARDWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_HARDWARE__LIBRARY_PATH = HARDWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_HARDWARE__LIBRARY_COMPONENT_NAME = HARDWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_HARDWARE__EVELOVES_IN = HARDWARE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_HARDWARE__HAS_SURFACE = HARDWARE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_HARDWARE__HEIGHT = HARDWARE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_HARDWARE__MASS = HARDWARE__MASS;

	/**
	 * The number of structural features of the '<em>Actuator Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_HARDWARE_FEATURE_COUNT = HARDWARE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Actuator Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUATOR_HARDWARE_OPERATION_COUNT = HARDWARE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.LocomotionHardwareImpl <em>Locomotion Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.LocomotionHardwareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLocomotionHardware()
	 * @generated
	 */
	int LOCOMOTION_HARDWARE = 61;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_HARDWARE__BASE_CLASS = ACTUATOR_HARDWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_HARDWARE__NATIVE = ACTUATOR_HARDWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_HARDWARE__LIBRARY_PATH = ACTUATOR_HARDWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_HARDWARE__LIBRARY_COMPONENT_NAME = ACTUATOR_HARDWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_HARDWARE__EVELOVES_IN = ACTUATOR_HARDWARE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_HARDWARE__HAS_SURFACE = ACTUATOR_HARDWARE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_HARDWARE__HEIGHT = ACTUATOR_HARDWARE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_HARDWARE__MASS = ACTUATOR_HARDWARE__MASS;

	/**
	 * The number of structural features of the '<em>Locomotion Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_HARDWARE_FEATURE_COUNT = ACTUATOR_HARDWARE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Locomotion Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCOMOTION_HARDWARE_OPERATION_COUNT = ACTUATOR_HARDWARE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.LegImpl <em>Leg</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.LegImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLeg()
	 * @generated
	 */
	int LEG = 60;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__BASE_CLASS = LOCOMOTION_HARDWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__NATIVE = LOCOMOTION_HARDWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__LIBRARY_PATH = LOCOMOTION_HARDWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__LIBRARY_COMPONENT_NAME = LOCOMOTION_HARDWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__EVELOVES_IN = LOCOMOTION_HARDWARE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__HAS_SURFACE = LOCOMOTION_HARDWARE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__HEIGHT = LOCOMOTION_HARDWARE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG__MASS = LOCOMOTION_HARDWARE__MASS;

	/**
	 * The number of structural features of the '<em>Leg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_FEATURE_COUNT = LOCOMOTION_HARDWARE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Leg</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_OPERATION_COUNT = LOCOMOTION_HARDWARE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.MobileRobotImpl <em>Mobile Robot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.MobileRobotImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getMobileRobot()
	 * @generated
	 */
	int MOBILE_ROBOT = 63;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT__BASE_CLASS = ROBOT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT__NATIVE = ROBOT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT__LIBRARY_PATH = ROBOT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT__LIBRARY_COMPONENT_NAME = ROBOT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT__EVELOVES_IN = ROBOT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT__HAS_SURFACE = ROBOT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT__HEIGHT = ROBOT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT__MASS = ROBOT__MASS;

	/**
	 * The feature id for the '<em><b>Moves Over</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT__MOVES_OVER = ROBOT__MOVES_OVER;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT__WIDTH = ROBOT__WIDTH;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT__KIND = ROBOT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Mobile Robot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT_FEATURE_COUNT = ROBOT_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Mobile Robot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MOBILE_ROBOT_OPERATION_COUNT = ROBOT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ManipulatorImpl <em>Manipulator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ManipulatorImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getManipulator()
	 * @generated
	 */
	int MANIPULATOR = 64;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR__BASE_CLASS = ROBOT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR__NATIVE = ROBOT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR__LIBRARY_PATH = ROBOT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR__LIBRARY_COMPONENT_NAME = ROBOT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR__EVELOVES_IN = ROBOT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR__HAS_SURFACE = ROBOT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR__HEIGHT = ROBOT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR__MASS = ROBOT__MASS;

	/**
	 * The feature id for the '<em><b>Moves Over</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR__MOVES_OVER = ROBOT__MOVES_OVER;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR__WIDTH = ROBOT__WIDTH;

	/**
	 * The number of structural features of the '<em>Manipulator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR_FEATURE_COUNT = ROBOT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Manipulator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MANIPULATOR_OPERATION_COUNT = ROBOT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PilotedSystemImpl <em>Piloted System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.PilotedSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPilotedSystem()
	 * @generated
	 */
	int PILOTED_SYSTEM = 65;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM__BASE_CLASS = ROBOT__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM__NATIVE = ROBOT__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM__LIBRARY_PATH = ROBOT__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM__LIBRARY_COMPONENT_NAME = ROBOT__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM__EVELOVES_IN = ROBOT__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM__HAS_SURFACE = ROBOT__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM__HEIGHT = ROBOT__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM__MASS = ROBOT__MASS;

	/**
	 * The feature id for the '<em><b>Moves Over</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM__MOVES_OVER = ROBOT__MOVES_OVER;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM__WIDTH = ROBOT__WIDTH;

	/**
	 * The number of structural features of the '<em>Piloted System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM_FEATURE_COUNT = ROBOT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Piloted System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PILOTED_SYSTEM_OPERATION_COUNT = ROBOT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.PowerHardwareImpl <em>Power Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.PowerHardwareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPowerHardware()
	 * @generated
	 */
	int POWER_HARDWARE = 66;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE__BASE_CLASS = HARDWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE__NATIVE = HARDWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE__LIBRARY_PATH = HARDWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE__LIBRARY_COMPONENT_NAME = HARDWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE__EVELOVES_IN = HARDWARE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE__HAS_SURFACE = HARDWARE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE__HEIGHT = HARDWARE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE__MASS = HARDWARE__MASS;

	/**
	 * The number of structural features of the '<em>Power Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_FEATURE_COUNT = HARDWARE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Power Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_HARDWARE_OPERATION_COUNT = HARDWARE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SensorHardwareImpl <em>Sensor Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.SensorHardwareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSensorHardware()
	 * @generated
	 */
	int SENSOR_HARDWARE = 67;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_HARDWARE__BASE_CLASS = HARDWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_HARDWARE__NATIVE = HARDWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_HARDWARE__LIBRARY_PATH = HARDWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_HARDWARE__LIBRARY_COMPONENT_NAME = HARDWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_HARDWARE__EVELOVES_IN = HARDWARE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_HARDWARE__HAS_SURFACE = HARDWARE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_HARDWARE__HEIGHT = HARDWARE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_HARDWARE__MASS = HARDWARE__MASS;

	/**
	 * The number of structural features of the '<em>Sensor Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_HARDWARE_FEATURE_COUNT = HARDWARE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Sensor Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SENSOR_HARDWARE_OPERATION_COUNT = HARDWARE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.GraspingHardwareImpl <em>Grasping Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.GraspingHardwareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGraspingHardware()
	 * @generated
	 */
	int GRASPING_HARDWARE = 68;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_HARDWARE__BASE_CLASS = ACTUATOR_HARDWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_HARDWARE__NATIVE = ACTUATOR_HARDWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_HARDWARE__LIBRARY_PATH = ACTUATOR_HARDWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_HARDWARE__LIBRARY_COMPONENT_NAME = ACTUATOR_HARDWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_HARDWARE__EVELOVES_IN = ACTUATOR_HARDWARE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_HARDWARE__HAS_SURFACE = ACTUATOR_HARDWARE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_HARDWARE__HEIGHT = ACTUATOR_HARDWARE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_HARDWARE__MASS = ACTUATOR_HARDWARE__MASS;

	/**
	 * The number of structural features of the '<em>Grasping Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_HARDWARE_FEATURE_COUNT = ACTUATOR_HARDWARE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Grasping Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_HARDWARE_OPERATION_COUNT = ACTUATOR_HARDWARE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelHardwareImpl <em>Steered Wheel Hardware</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.SteeredWheelHardwareImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSteeredWheelHardware()
	 * @generated
	 */
	int STEERED_WHEEL_HARDWARE = 69;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_HARDWARE__BASE_CLASS = LOCOMOTION_HARDWARE__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_HARDWARE__NATIVE = LOCOMOTION_HARDWARE__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_HARDWARE__LIBRARY_PATH = LOCOMOTION_HARDWARE__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_HARDWARE__LIBRARY_COMPONENT_NAME = LOCOMOTION_HARDWARE__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Eveloves In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_HARDWARE__EVELOVES_IN = LOCOMOTION_HARDWARE__EVELOVES_IN;

	/**
	 * The feature id for the '<em><b>Has Surface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_HARDWARE__HAS_SURFACE = LOCOMOTION_HARDWARE__HAS_SURFACE;

	/**
	 * The feature id for the '<em><b>Height</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_HARDWARE__HEIGHT = LOCOMOTION_HARDWARE__HEIGHT;

	/**
	 * The feature id for the '<em><b>Mass</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_HARDWARE__MASS = LOCOMOTION_HARDWARE__MASS;

	/**
	 * The number of structural features of the '<em>Steered Wheel Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_HARDWARE_FEATURE_COUNT = LOCOMOTION_HARDWARE_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Steered Wheel Hardware</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEERED_WHEEL_HARDWARE_OPERATION_COUNT = LOCOMOTION_HARDWARE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ArmImpl <em>Arm</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ArmImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getArm()
	 * @generated
	 */
	int ARM = 70;

	/**
	 * The number of structural features of the '<em>Arm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARM_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Arm</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.LegSystemImpl <em>Leg System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.LegSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLegSystem()
	 * @generated
	 */
	int LEG_SYSTEM = 71;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_SYSTEM__BASE_CLASS = LOCOMOTION_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_SYSTEM__NATIVE = LOCOMOTION_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_SYSTEM__LIBRARY_PATH = LOCOMOTION_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_SYSTEM__LIBRARY_COMPONENT_NAME = LOCOMOTION_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_SYSTEM__LOCAL_POSITION = LOCOMOTION_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_SYSTEM__LOCAL_ORIENTATION = LOCOMOTION_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The number of structural features of the '<em>Leg System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_SYSTEM_FEATURE_COUNT = LOCOMOTION_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Leg System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LEG_SYSTEM_OPERATION_COUNT = LOCOMOTION_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.GraspingSystemImpl <em>Grasping System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.GraspingSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGraspingSystem()
	 * @generated
	 */
	int GRASPING_SYSTEM = 72;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_SYSTEM__BASE_CLASS = ACTUATOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_SYSTEM__NATIVE = ACTUATOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_SYSTEM__LIBRARY_PATH = ACTUATOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_SYSTEM__LIBRARY_COMPONENT_NAME = ACTUATOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_SYSTEM__LOCAL_POSITION = ACTUATOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_SYSTEM__LOCAL_ORIENTATION = ACTUATOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The number of structural features of the '<em>Grasping System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_SYSTEM_FEATURE_COUNT = ACTUATOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Grasping System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRASPING_SYSTEM_OPERATION_COUNT = ACTUATOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.WeaponSystemImpl <em>Weapon System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.WeaponSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getWeaponSystem()
	 * @generated
	 */
	int WEAPON_SYSTEM = 73;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAPON_SYSTEM__BASE_CLASS = ACTUATOR_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAPON_SYSTEM__NATIVE = ACTUATOR_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAPON_SYSTEM__LIBRARY_PATH = ACTUATOR_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAPON_SYSTEM__LIBRARY_COMPONENT_NAME = ACTUATOR_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The feature id for the '<em><b>Local Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAPON_SYSTEM__LOCAL_POSITION = ACTUATOR_SYSTEM__LOCAL_POSITION;

	/**
	 * The feature id for the '<em><b>Local Orientation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAPON_SYSTEM__LOCAL_ORIENTATION = ACTUATOR_SYSTEM__LOCAL_ORIENTATION;

	/**
	 * The number of structural features of the '<em>Weapon System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAPON_SYSTEM_FEATURE_COUNT = ACTUATOR_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Weapon System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAPON_SYSTEM_OPERATION_COUNT = ACTUATOR_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ManMachineInterfaceSystemImpl <em>Man Machine Interface System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ManMachineInterfaceSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getManMachineInterfaceSystem()
	 * @generated
	 */
	int MAN_MACHINE_INTERFACE_SYSTEM = 74;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAN_MACHINE_INTERFACE_SYSTEM__BASE_CLASS = CYBER_PHYSICAL_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAN_MACHINE_INTERFACE_SYSTEM__NATIVE = CYBER_PHYSICAL_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAN_MACHINE_INTERFACE_SYSTEM__LIBRARY_PATH = CYBER_PHYSICAL_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAN_MACHINE_INTERFACE_SYSTEM__LIBRARY_COMPONENT_NAME = CYBER_PHYSICAL_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The number of structural features of the '<em>Man Machine Interface System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAN_MACHINE_INTERFACE_SYSTEM_FEATURE_COUNT = CYBER_PHYSICAL_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Man Machine Interface System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAN_MACHINE_INTERFACE_SYSTEM_OPERATION_COUNT = CYBER_PHYSICAL_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.ClosedLoopControlSystemImpl <em>Closed Loop Control System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.ClosedLoopControlSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getClosedLoopControlSystem()
	 * @generated
	 */
	int CLOSED_LOOP_CONTROL_SYSTEM = 75;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSED_LOOP_CONTROL_SYSTEM__BASE_CLASS = CYBER_PHYSICAL_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSED_LOOP_CONTROL_SYSTEM__NATIVE = CYBER_PHYSICAL_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSED_LOOP_CONTROL_SYSTEM__LIBRARY_PATH = CYBER_PHYSICAL_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSED_LOOP_CONTROL_SYSTEM__LIBRARY_COMPONENT_NAME = CYBER_PHYSICAL_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The number of structural features of the '<em>Closed Loop Control System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSED_LOOP_CONTROL_SYSTEM_FEATURE_COUNT = CYBER_PHYSICAL_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Closed Loop Control System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CLOSED_LOOP_CONTROL_SYSTEM_OPERATION_COUNT = CYBER_PHYSICAL_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.OpenLoopControlSystemImpl <em>Open Loop Control System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.OpenLoopControlSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOpenLoopControlSystem()
	 * @generated
	 */
	int OPEN_LOOP_CONTROL_SYSTEM = 76;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_LOOP_CONTROL_SYSTEM__BASE_CLASS = CYBER_PHYSICAL_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_LOOP_CONTROL_SYSTEM__NATIVE = CYBER_PHYSICAL_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_LOOP_CONTROL_SYSTEM__LIBRARY_PATH = CYBER_PHYSICAL_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_LOOP_CONTROL_SYSTEM__LIBRARY_COMPONENT_NAME = CYBER_PHYSICAL_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The number of structural features of the '<em>Open Loop Control System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_LOOP_CONTROL_SYSTEM_FEATURE_COUNT = CYBER_PHYSICAL_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Open Loop Control System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPEN_LOOP_CONTROL_SYSTEM_OPERATION_COUNT = CYBER_PHYSICAL_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticHeadImpl <em>Robotic Head</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.RoboticHeadImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticHead()
	 * @generated
	 */
	int ROBOTIC_HEAD = 77;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_HEAD__BASE_CLASS = MAN_MACHINE_INTERFACE_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_HEAD__NATIVE = MAN_MACHINE_INTERFACE_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_HEAD__LIBRARY_PATH = MAN_MACHINE_INTERFACE_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_HEAD__LIBRARY_COMPONENT_NAME = MAN_MACHINE_INTERFACE_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The number of structural features of the '<em>Robotic Head</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_HEAD_FEATURE_COUNT = MAN_MACHINE_INTERFACE_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Robotic Head</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROBOTIC_HEAD_OPERATION_COUNT = MAN_MACHINE_INTERFACE_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.NavigationCommandSystemImpl <em>Navigation Command System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.NavigationCommandSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getNavigationCommandSystem()
	 * @generated
	 */
	int NAVIGATION_COMMAND_SYSTEM = 78;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_COMMAND_SYSTEM__BASE_CLASS = MAN_MACHINE_INTERFACE_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_COMMAND_SYSTEM__NATIVE = MAN_MACHINE_INTERFACE_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_COMMAND_SYSTEM__LIBRARY_PATH = MAN_MACHINE_INTERFACE_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_COMMAND_SYSTEM__LIBRARY_COMPONENT_NAME = MAN_MACHINE_INTERFACE_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The number of structural features of the '<em>Navigation Command System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_COMMAND_SYSTEM_FEATURE_COUNT = MAN_MACHINE_INTERFACE_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Navigation Command System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAVIGATION_COMMAND_SYSTEM_OPERATION_COUNT = MAN_MACHINE_INTERFACE_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.impl.JoysticNavigationSystemImpl <em>Joystic Navigation System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.impl.JoysticNavigationSystemImpl
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getJoysticNavigationSystem()
	 * @generated
	 */
	int JOYSTIC_NAVIGATION_SYSTEM = 79;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOYSTIC_NAVIGATION_SYSTEM__BASE_CLASS = NAVIGATION_COMMAND_SYSTEM__BASE_CLASS;

	/**
	 * The feature id for the '<em><b>Native</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOYSTIC_NAVIGATION_SYSTEM__NATIVE = NAVIGATION_COMMAND_SYSTEM__NATIVE;

	/**
	 * The feature id for the '<em><b>Library Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOYSTIC_NAVIGATION_SYSTEM__LIBRARY_PATH = NAVIGATION_COMMAND_SYSTEM__LIBRARY_PATH;

	/**
	 * The feature id for the '<em><b>Library Component Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOYSTIC_NAVIGATION_SYSTEM__LIBRARY_COMPONENT_NAME = NAVIGATION_COMMAND_SYSTEM__LIBRARY_COMPONENT_NAME;

	/**
	 * The number of structural features of the '<em>Joystic Navigation System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOYSTIC_NAVIGATION_SYSTEM_FEATURE_COUNT = NAVIGATION_COMMAND_SYSTEM_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Joystic Navigation System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JOYSTIC_NAVIGATION_SYSTEM_OPERATION_COUNT = NAVIGATION_COMMAND_SYSTEM_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.SynchronizationKind <em>Synchronization Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.SynchronizationKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSynchronizationKind()
	 * @generated
	 */
	int SYNCHRONIZATION_KIND = 80;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.DataFlowDirectionKind <em>Data Flow Direction Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.DataFlowDirectionKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDataFlowDirectionKind()
	 * @generated
	 */
	int DATA_FLOW_DIRECTION_KIND = 81;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.ServiceFlowKind <em>Service Flow Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.ServiceFlowKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getServiceFlowKind()
	 * @generated
	 */
	int SERVICE_FLOW_KIND = 82;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.UGVKind <em>UGV Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.UGVKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getUGVKind()
	 * @generated
	 */
	int UGV_KIND = 83;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.RoboticMiddlewareKind <em>Robotic Middleware Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.RoboticMiddlewareKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticMiddlewareKind()
	 * @generated
	 */
	int ROBOTIC_MIDDLEWARE_KIND = 84;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.Shade <em>Shade</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.Shade
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getShade()
	 * @generated
	 */
	int SHADE = 85;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.RobotML.MobileRobotKind <em>Mobile Robot Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.RobotML.MobileRobotKind
	 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getMobileRobotKind()
	 * @generated
	 */
	int MOBILE_ROBOT_KIND = 86;


	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see org.eclipse.papyrus.RobotML.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Transition#getBase_Transition <em>Base Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Algorithm</em>'.
	 * @see org.eclipse.papyrus.RobotML.Algorithm
	 * @generated
	 */
	EClass getAlgorithm();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Algorithm#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for the attribute '<em>Lib File Format</em>'.
	 * @see org.eclipse.papyrus.RobotML.Algorithm#getLibFileFormat()
	 * @see #getAlgorithm()
	 * @generated
	 */
	EAttribute getAlgorithm_LibFileFormat();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.State <em>State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see org.eclipse.papyrus.RobotML.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.State#getBase_State <em>Base State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base State</em>'.
	 * @see org.eclipse.papyrus.RobotML.State#getBase_State()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Base_State();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.State#getBehavior <em>Behavior</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Behavior</em>'.
	 * @see org.eclipse.papyrus.RobotML.State#getBehavior()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_Behavior();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ActuatedJoint <em>Actuated Joint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actuated Joint</em>'.
	 * @see org.eclipse.papyrus.RobotML.ActuatedJoint
	 * @generated
	 */
	EClass getActuatedJoint();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Joint <em>Joint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Joint</em>'.
	 * @see org.eclipse.papyrus.RobotML.Joint
	 * @generated
	 */
	EClass getJoint();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Joint#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.eclipse.papyrus.RobotML.Joint#getBase_Connector()
	 * @see #getJoint()
	 * @generated
	 */
	EReference getJoint_Base_Connector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.CompleteBonding <em>Complete Bonding</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Complete Bonding</em>'.
	 * @see org.eclipse.papyrus.RobotML.CompleteBonding
	 * @generated
	 */
	EClass getCompleteBonding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Robot <em>Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Robot</em>'.
	 * @see org.eclipse.papyrus.RobotML.Robot
	 * @generated
	 */
	EClass getRobot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Robot#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see org.eclipse.papyrus.RobotML.Robot#getWidth()
	 * @see #getRobot()
	 * @generated
	 */
	EAttribute getRobot_Width();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see org.eclipse.papyrus.RobotML.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.System#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Agent</em>'.
	 * @see org.eclipse.papyrus.RobotML.Agent
	 * @generated
	 */
	EClass getAgent();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.RobotML.Agent#getMovesOver <em>Moves Over</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Physical Object</em>'.
	 * @see org.eclipse.papyrus.RobotML.PhysicalObject
	 * @generated
	 */
	EClass getPhysicalObject();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.RobotML.PhysicalObject#getEvelovesIn <em>Eveloves In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for the reference '<em>Has Surface</em>'.
	 * @see org.eclipse.papyrus.RobotML.PhysicalObject#getHasSurface()
	 * @see #getPhysicalObject()
	 * @generated
	 */
	EReference getPhysicalObject_HasSurface();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.PhysicalObject#getHeight <em>Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Height</em>'.
	 * @see org.eclipse.papyrus.RobotML.PhysicalObject#getHeight()
	 * @see #getPhysicalObject()
	 * @generated
	 */
	EAttribute getPhysicalObject_Height();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.PhysicalObject#getMass <em>Mass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mass</em>'.
	 * @see org.eclipse.papyrus.RobotML.PhysicalObject#getMass()
	 * @see #getPhysicalObject()
	 * @generated
	 */
	EAttribute getPhysicalObject_Mass();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Environment <em>Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Environment</em>'.
	 * @see org.eclipse.papyrus.RobotML.Environment
	 * @generated
	 */
	EClass getEnvironment();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Surface <em>Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Surface</em>'.
	 * @see org.eclipse.papyrus.RobotML.Surface
	 * @generated
	 */
	EClass getSurface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.DataFlowPort <em>Data Flow Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Flow Port</em>'.
	 * @see org.eclipse.papyrus.RobotML.DataFlowPort
	 * @generated
	 */
	EClass getDataFlowPort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.DataFlowPort#getDirection <em>Direction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.eclipse.papyrus.RobotML.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Port#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Service Port</em>'.
	 * @see org.eclipse.papyrus.RobotML.ServicePort
	 * @generated
	 */
	EClass getServicePort();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.ServicePort#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Actuator System</em>'.
	 * @see org.eclipse.papyrus.RobotML.ActuatorSystem
	 * @generated
	 */
	EClass getActuatorSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.RoboticSystem <em>Robotic System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Robotic System</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticSystem
	 * @generated
	 */
	EClass getRoboticSystem();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotML.RoboticSystem#getLocalPosition <em>Local Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Position</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticSystem#getLocalPosition()
	 * @see #getRoboticSystem()
	 * @generated
	 */
	EReference getRoboticSystem_LocalPosition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotML.RoboticSystem#getLocalOrientation <em>Local Orientation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Local Orientation</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticSystem#getLocalOrientation()
	 * @see #getRoboticSystem()
	 * @generated
	 */
	EReference getRoboticSystem_LocalOrientation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.CyberPhysicalSystem <em>Cyber Physical System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cyber Physical System</em>'.
	 * @see org.eclipse.papyrus.RobotML.CyberPhysicalSystem
	 * @generated
	 */
	EClass getCyberPhysicalSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.SensorSystem <em>Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor System</em>'.
	 * @see org.eclipse.papyrus.RobotML.SensorSystem
	 * @generated
	 */
	EClass getSensorSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SensorSystem#getFrequency <em>Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Hardware</em>'.
	 * @see org.eclipse.papyrus.RobotML.Hardware
	 * @generated
	 */
	EClass getHardware();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Software <em>Software</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Software</em>'.
	 * @see org.eclipse.papyrus.RobotML.Software
	 * @generated
	 */
	EClass getSoftware();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.Software#isIsPeriodic <em>Is Periodic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for the attribute '<em>Wcet</em>'.
	 * @see org.eclipse.papyrus.RobotML.Software#getWcet()
	 * @see #getSoftware()
	 * @generated
	 */
	EAttribute getSoftware_Wcet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.EngineSystem <em>Engine System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Engine System</em>'.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem
	 * @generated
	 */
	EClass getEngineSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.EngineSystem#getVehicleTraction <em>Vehicle Traction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for the attribute '<em>Max Breaking Force</em>'.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem#getMaxBreakingForce()
	 * @see #getEngineSystem()
	 * @generated
	 */
	EAttribute getEngineSystem_MaxBreakingForce();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxAllowedSteering <em>Max Allowed Steering</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Allowed Steering</em>'.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem#getMaxAllowedSteering()
	 * @see #getEngineSystem()
	 * @generated
	 */
	EAttribute getEngineSystem_MaxAllowedSteering();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.EngineSystem#getMaxAllowedVelocity <em>Max Allowed Velocity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for the attribute '<em>Gear ration</em>'.
	 * @see org.eclipse.papyrus.RobotML.EngineSystem#getGear_ration()
	 * @see #getEngineSystem()
	 * @generated
	 */
	EAttribute getEngineSystem_Gear_ration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem <em>Steered Wheel System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Steered Wheel System</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem
	 * @generated
	 */
	EClass getSteeredWheelSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelRadius <em>Wheel Radius</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wheel Radius</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelRadius()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_WheelRadius();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelWidth <em>Wheel Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wheel Width</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelWidth()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_WheelWidth();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionRestLength <em>Suspension Rest Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suspension Rest Length</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionRestLength()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_SuspensionRestLength();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelConnectionHeight <em>Wheel Connection Height</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wheel Connection Height</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelConnectionHeight()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_WheelConnectionHeight();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getTypeOfWheel <em>Type Of Wheel</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Of Wheel</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getTypeOfWheel()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_TypeOfWheel();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkp <em>Wheel Velocity PI Dkp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wheel Velocity PI Dkp</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkp()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_WheelVelocityPIDkp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDki <em>Wheel Velocity PI Dki</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wheel Velocity PI Dki</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDki()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_WheelVelocityPIDki();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkd <em>Wheel Velocity PI Dkd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wheel Velocity PI Dkd</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDkd()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_WheelVelocityPIDkd();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkp <em>Wheel Steering PI Dkp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wheel Steering PI Dkp</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkp()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_WheelSteeringPIDkp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkd <em>Wheel Steering PI Dkd</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wheel Steering PI Dkd</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelSteeringPIDkd()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_WheelSteeringPIDkd();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelFriction <em>Wheel Friction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wheel Friction</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelFriction()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_WheelFriction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionStiffness <em>Suspension Stiffness</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suspension Stiffness</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionStiffness()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_SuspensionStiffness();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionDamping <em>Suspension Damping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suspension Damping</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionDamping()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_SuspensionDamping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionCompression <em>Suspension Compression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Suspension Compression</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getSuspensionCompression()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_SuspensionCompression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxSum <em>Wheel Velocity PI Dmax Sum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wheel Velocity PI Dmax Sum</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxSum()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_WheelVelocityPIDmaxSum();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxVal <em>Wheel Velocity PI Dmax Val</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wheel Velocity PI Dmax Val</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelSystem#getWheelVelocityPIDmaxVal()
	 * @see #getSteeredWheelSystem()
	 * @generated
	 */
	EAttribute getSteeredWheelSystem_WheelVelocityPIDmaxVal();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.LocomotionSystem <em>Locomotion System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Locomotion System</em>'.
	 * @see org.eclipse.papyrus.RobotML.LocomotionSystem
	 * @generated
	 */
	EClass getLocomotionSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ImageSensorSystem <em>Image Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Image Sensor System</em>'.
	 * @see org.eclipse.papyrus.RobotML.ImageSensorSystem
	 * @generated
	 */
	EClass getImageSensorSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.CameraSystem <em>Camera System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Camera System</em>'.
	 * @see org.eclipse.papyrus.RobotML.CameraSystem
	 * @generated
	 */
	EClass getCameraSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CameraSystem#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Object Detection Sensor System</em>'.
	 * @see org.eclipse.papyrus.RobotML.ObjectDetectionSensorSystem
	 * @generated
	 */
	EClass getObjectDetectionSensorSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ObjectTrackingSensorSystem <em>Object Tracking Sensor System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object Tracking Sensor System</em>'.
	 * @see org.eclipse.papyrus.RobotML.ObjectTrackingSensorSystem
	 * @generated
	 */
	EClass getObjectTrackingSensorSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.LidarSystem <em>Lidar System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Lidar System</em>'.
	 * @see org.eclipse.papyrus.RobotML.LidarSystem
	 * @generated
	 */
	EClass getLidarSystem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.LidarSystem#getNbLayers <em>Nb Layers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Localization Sensor System</em>'.
	 * @see org.eclipse.papyrus.RobotML.LocalizationSensorSystem
	 * @generated
	 */
	EClass getLocalizationSensorSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.GPSSystem <em>GPS System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>GPS System</em>'.
	 * @see org.eclipse.papyrus.RobotML.GPSSystem
	 * @generated
	 */
	EClass getGPSSystem();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.papyrus.RobotML.GPSSystem#getOriginPosition <em>Origin Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Origin Position</em>'.
	 * @see org.eclipse.papyrus.RobotML.GPSSystem#getOriginPosition()
	 * @see #getGPSSystem()
	 * @generated
	 */
	EReference getGPSSystem_OriginPosition();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.AlgorithmLibrary <em>Algorithm Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Algorithm Library</em>'.
	 * @see org.eclipse.papyrus.RobotML.AlgorithmLibrary
	 * @generated
	 */
	EClass getAlgorithmLibrary();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.AlgorithmLibrary#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see org.eclipse.papyrus.RobotML.AlgorithmLibrary#getPath()
	 * @see #getAlgorithmLibrary()
	 * @generated
	 */
	EAttribute getAlgorithmLibrary_Path();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.SensorDriver <em>Sensor Driver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor Driver</em>'.
	 * @see org.eclipse.papyrus.RobotML.SensorDriver
	 * @generated
	 */
	EClass getSensorDriver();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Building <em>Building</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Building</em>'.
	 * @see org.eclipse.papyrus.RobotML.Building
	 * @generated
	 */
	EClass getBuilding();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Planet <em>Planet</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Planet</em>'.
	 * @see org.eclipse.papyrus.RobotML.Planet
	 * @generated
	 */
	EClass getPlanet();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.LandSurface <em>Land Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Land Surface</em>'.
	 * @see org.eclipse.papyrus.RobotML.LandSurface
	 * @generated
	 */
	EClass getLandSurface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Ground <em>Ground</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ground</em>'.
	 * @see org.eclipse.papyrus.RobotML.Ground
	 * @generated
	 */
	EClass getGround();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Floor <em>Floor</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Floor</em>'.
	 * @see org.eclipse.papyrus.RobotML.Floor
	 * @generated
	 */
	EClass getFloor();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.WaterSurface <em>Water Surface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Water Surface</em>'.
	 * @see org.eclipse.papyrus.RobotML.WaterSurface
	 * @generated
	 */
	EClass getWaterSurface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Human <em>Human</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Human</em>'.
	 * @see org.eclipse.papyrus.RobotML.Human
	 * @generated
	 */
	EClass getHuman();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Pedestrian <em>Pedestrian</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Pedestrian</em>'.
	 * @see org.eclipse.papyrus.RobotML.Pedestrian
	 * @generated
	 */
	EClass getPedestrian();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Stairs <em>Stairs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stairs</em>'.
	 * @see org.eclipse.papyrus.RobotML.Stairs
	 * @generated
	 */
	EClass getStairs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Platform <em>Platform</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Platform</em>'.
	 * @see org.eclipse.papyrus.RobotML.Platform
	 * @generated
	 */
	EClass getPlatform();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Platform#getBase_Node <em>Base Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Node</em>'.
	 * @see org.eclipse.papyrus.RobotML.Platform#getBase_Node()
	 * @see #getPlatform()
	 * @generated
	 */
	EReference getPlatform_Base_Node();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.RobotML.Platform#getLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Library</em>'.
	 * @see org.eclipse.papyrus.RobotML.Platform#getLibrary()
	 * @see #getPlatform()
	 * @generated
	 */
	EReference getPlatform_Library();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ExternalLibrary <em>External Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Library</em>'.
	 * @see org.eclipse.papyrus.RobotML.ExternalLibrary
	 * @generated
	 */
	EClass getExternalLibrary();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.ExternalLibrary#getLibPath <em>Lib Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lib Path</em>'.
	 * @see org.eclipse.papyrus.RobotML.ExternalLibrary#getLibPath()
	 * @see #getExternalLibrary()
	 * @generated
	 */
	EAttribute getExternalLibrary_LibPath();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.ExternalLibrary#getLibFileFormat <em>Lib File Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lib File Format</em>'.
	 * @see org.eclipse.papyrus.RobotML.ExternalLibrary#getLibFileFormat()
	 * @see #getExternalLibrary()
	 * @generated
	 */
	EAttribute getExternalLibrary_LibFileFormat();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.ExternalLibrary#getBase_Interface <em>Base Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Interface</em>'.
	 * @see org.eclipse.papyrus.RobotML.ExternalLibrary#getBase_Interface()
	 * @see #getExternalLibrary()
	 * @generated
	 */
	EReference getExternalLibrary_Base_Interface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.RoboticMiddleware <em>Robotic Middleware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Robotic Middleware</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticMiddleware
	 * @generated
	 */
	EClass getRoboticMiddleware();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.RoboticMiddleware#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Robotic Simulator</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticSimulator
	 * @generated
	 */
	EClass getRoboticSimulator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.CycabTK <em>Cycab TK</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cycab TK</em>'.
	 * @see org.eclipse.papyrus.RobotML.CycabTK
	 * @generated
	 */
	EClass getCycabTK();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.CycabTK#isUseRealTime <em>Use Real Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Blender Morse</em>'.
	 * @see org.eclipse.papyrus.RobotML.BlenderMorse
	 * @generated
	 */
	EClass getBlenderMorse();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.BlenderMorse#isDebugMode <em>Debug Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>On Port</em>'.
	 * @see org.eclipse.papyrus.RobotML.OnPort
	 * @generated
	 */
	EClass getOnPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.OnPort#getPort <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Allocate</em>'.
	 * @see org.eclipse.papyrus.RobotML.Allocate
	 * @generated
	 */
	EClass getAllocate();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.Allocate#getBase_Abstraction <em>Base Abstraction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Abstraction</em>'.
	 * @see org.eclipse.papyrus.RobotML.Allocate#getBase_Abstraction()
	 * @see #getAllocate()
	 * @generated
	 */
	EReference getAllocate_Base_Abstraction();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.InertialMeasurementUnitSystem <em>Inertial Measurement Unit System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inertial Measurement Unit System</em>'.
	 * @see org.eclipse.papyrus.RobotML.InertialMeasurementUnitSystem
	 * @generated
	 */
	EClass getInertialMeasurementUnitSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.InertialNavigationSystem <em>Inertial Navigation System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Inertial Navigation System</em>'.
	 * @see org.eclipse.papyrus.RobotML.InertialNavigationSystem
	 * @generated
	 */
	EClass getInertialNavigationSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.OdometrySystem <em>Odometry System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Odometry System</em>'.
	 * @see org.eclipse.papyrus.RobotML.OdometrySystem
	 * @generated
	 */
	EClass getOdometrySystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.InfraRedProximetrySystem <em>Infra Red Proximetry System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infra Red Proximetry System</em>'.
	 * @see org.eclipse.papyrus.RobotML.InfraRedProximetrySystem
	 * @generated
	 */
	EClass getInfraRedProximetrySystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.DeploymentPlan <em>Deployment Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Plan</em>'.
	 * @see org.eclipse.papyrus.RobotML.DeploymentPlan
	 * @generated
	 */
	EClass getDeploymentPlan();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.DeploymentPlan#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * @return the meta object for class '<em>Gyroscope</em>'.
	 * @see org.eclipse.papyrus.RobotML.Gyroscope
	 * @generated
	 */
	EClass getGyroscope();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.OnProperty <em>On Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>On Property</em>'.
	 * @see org.eclipse.papyrus.RobotML.OnProperty
	 * @generated
	 */
	EClass getOnProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.OnProperty#getProperty <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Property</em>'.
	 * @see org.eclipse.papyrus.RobotML.OnProperty#getProperty()
	 * @see #getOnProperty()
	 * @generated
	 */
	EReference getOnProperty_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.RobotML.OnProperty#getBase_Parameter <em>Base Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Parameter</em>'.
	 * @see org.eclipse.papyrus.RobotML.OnProperty#getBase_Parameter()
	 * @see #getOnProperty()
	 * @generated
	 */
	EReference getOnProperty_Base_Parameter();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Chassis <em>Chassis</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Chassis</em>'.
	 * @see org.eclipse.papyrus.RobotML.Chassis
	 * @generated
	 */
	EClass getChassis();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.SupportingStructure <em>Supporting Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Supporting Structure</em>'.
	 * @see org.eclipse.papyrus.RobotML.SupportingStructure
	 * @generated
	 */
	EClass getSupportingStructure();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.MechanicalLinkage <em>Mechanical Linkage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mechanical Linkage</em>'.
	 * @see org.eclipse.papyrus.RobotML.MechanicalLinkage
	 * @generated
	 */
	EClass getMechanicalLinkage();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Leg <em>Leg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leg</em>'.
	 * @see org.eclipse.papyrus.RobotML.Leg
	 * @generated
	 */
	EClass getLeg();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.LocomotionHardware <em>Locomotion Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Locomotion Hardware</em>'.
	 * @see org.eclipse.papyrus.RobotML.LocomotionHardware
	 * @generated
	 */
	EClass getLocomotionHardware();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ActuatorHardware <em>Actuator Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actuator Hardware</em>'.
	 * @see org.eclipse.papyrus.RobotML.ActuatorHardware
	 * @generated
	 */
	EClass getActuatorHardware();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.MobileRobot <em>Mobile Robot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mobile Robot</em>'.
	 * @see org.eclipse.papyrus.RobotML.MobileRobot
	 * @generated
	 */
	EClass getMobileRobot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.RobotML.MobileRobot#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.MobileRobot#getKind()
	 * @see #getMobileRobot()
	 * @generated
	 */
	EAttribute getMobileRobot_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Manipulator <em>Manipulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Manipulator</em>'.
	 * @see org.eclipse.papyrus.RobotML.Manipulator
	 * @generated
	 */
	EClass getManipulator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.PilotedSystem <em>Piloted System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Piloted System</em>'.
	 * @see org.eclipse.papyrus.RobotML.PilotedSystem
	 * @generated
	 */
	EClass getPilotedSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.PowerHardware <em>Power Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power Hardware</em>'.
	 * @see org.eclipse.papyrus.RobotML.PowerHardware
	 * @generated
	 */
	EClass getPowerHardware();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.SensorHardware <em>Sensor Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Sensor Hardware</em>'.
	 * @see org.eclipse.papyrus.RobotML.SensorHardware
	 * @generated
	 */
	EClass getSensorHardware();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.GraspingHardware <em>Grasping Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grasping Hardware</em>'.
	 * @see org.eclipse.papyrus.RobotML.GraspingHardware
	 * @generated
	 */
	EClass getGraspingHardware();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.SteeredWheelHardware <em>Steered Wheel Hardware</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Steered Wheel Hardware</em>'.
	 * @see org.eclipse.papyrus.RobotML.SteeredWheelHardware
	 * @generated
	 */
	EClass getSteeredWheelHardware();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.Arm <em>Arm</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arm</em>'.
	 * @see org.eclipse.papyrus.RobotML.Arm
	 * @generated
	 */
	EClass getArm();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.LegSystem <em>Leg System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Leg System</em>'.
	 * @see org.eclipse.papyrus.RobotML.LegSystem
	 * @generated
	 */
	EClass getLegSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.GraspingSystem <em>Grasping System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Grasping System</em>'.
	 * @see org.eclipse.papyrus.RobotML.GraspingSystem
	 * @generated
	 */
	EClass getGraspingSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.WeaponSystem <em>Weapon System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Weapon System</em>'.
	 * @see org.eclipse.papyrus.RobotML.WeaponSystem
	 * @generated
	 */
	EClass getWeaponSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ManMachineInterfaceSystem <em>Man Machine Interface System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Man Machine Interface System</em>'.
	 * @see org.eclipse.papyrus.RobotML.ManMachineInterfaceSystem
	 * @generated
	 */
	EClass getManMachineInterfaceSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.ClosedLoopControlSystem <em>Closed Loop Control System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Closed Loop Control System</em>'.
	 * @see org.eclipse.papyrus.RobotML.ClosedLoopControlSystem
	 * @generated
	 */
	EClass getClosedLoopControlSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.OpenLoopControlSystem <em>Open Loop Control System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Open Loop Control System</em>'.
	 * @see org.eclipse.papyrus.RobotML.OpenLoopControlSystem
	 * @generated
	 */
	EClass getOpenLoopControlSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.RoboticHead <em>Robotic Head</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Robotic Head</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticHead
	 * @generated
	 */
	EClass getRoboticHead();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.NavigationCommandSystem <em>Navigation Command System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Navigation Command System</em>'.
	 * @see org.eclipse.papyrus.RobotML.NavigationCommandSystem
	 * @generated
	 */
	EClass getNavigationCommandSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.RobotML.JoysticNavigationSystem <em>Joystic Navigation System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Joystic Navigation System</em>'.
	 * @see org.eclipse.papyrus.RobotML.JoysticNavigationSystem
	 * @generated
	 */
	EClass getJoysticNavigationSystem();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.SynchronizationKind <em>Synchronization Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Synchronization Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.SynchronizationKind
	 * @generated
	 */
	EEnum getSynchronizationKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.DataFlowDirectionKind <em>Data Flow Direction Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Data Flow Direction Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.DataFlowDirectionKind
	 * @generated
	 */
	EEnum getDataFlowDirectionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.ServiceFlowKind <em>Service Flow Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Service Flow Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.ServiceFlowKind
	 * @generated
	 */
	EEnum getServiceFlowKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.UGVKind <em>UGV Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>UGV Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.UGVKind
	 * @generated
	 */
	EEnum getUGVKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.RoboticMiddlewareKind <em>Robotic Middleware Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Robotic Middleware Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.RoboticMiddlewareKind
	 * @generated
	 */
	EEnum getRoboticMiddlewareKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.Shade <em>Shade</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Shade</em>'.
	 * @see org.eclipse.papyrus.RobotML.Shade
	 * @generated
	 */
	EEnum getShade();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.RobotML.MobileRobotKind <em>Mobile Robot Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Mobile Robot Kind</em>'.
	 * @see org.eclipse.papyrus.RobotML.MobileRobotKind
	 * @generated
	 */
	EEnum getMobileRobotKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	RobotMLFactory getRobotMLFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.TransitionImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '<em><b>Base Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__BASE_TRANSITION = eINSTANCE.getTransition_Base_Transition();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__GUARD = eINSTANCE.getTransition_Guard();

		/**
		 * The meta object literal for the '<em><b>Effect</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TRANSITION__EFFECT = eINSTANCE.getTransition_Effect();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.AlgorithmImpl <em>Algorithm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.AlgorithmImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAlgorithm()
		 * @generated
		 */
		EClass ALGORITHM = eINSTANCE.getAlgorithm();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHM__BASE_OPERATION = eINSTANCE.getAlgorithm_Base_Operation();

		/**
		 * The meta object literal for the '<em><b>Is External</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHM__IS_EXTERNAL = eINSTANCE.getAlgorithm_IsExternal();

		/**
		 * The meta object literal for the '<em><b>Ext Function Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHM__EXT_FUNCTION_NAME = eINSTANCE.getAlgorithm_ExtFunctionName();

		/**
		 * The meta object literal for the '<em><b>Lib Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHM__LIB_PATH = eINSTANCE.getAlgorithm_LibPath();

		/**
		 * The meta object literal for the '<em><b>Lib File Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHM__LIB_FILE_FORMAT = eINSTANCE.getAlgorithm_LibFileFormat();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.StateImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>Base State</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__BASE_STATE = eINSTANCE.getState_Base_State();

		/**
		 * The meta object literal for the '<em><b>Behavior</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__BEHAVIOR = eINSTANCE.getState_Behavior();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ActuatedJointImpl <em>Actuated Joint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ActuatedJointImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getActuatedJoint()
		 * @generated
		 */
		EClass ACTUATED_JOINT = eINSTANCE.getActuatedJoint();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.JointImpl <em>Joint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.JointImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getJoint()
		 * @generated
		 */
		EClass JOINT = eINSTANCE.getJoint();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference JOINT__BASE_CONNECTOR = eINSTANCE.getJoint_Base_Connector();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.CompleteBondingImpl <em>Complete Bonding</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.CompleteBondingImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCompleteBonding()
		 * @generated
		 */
		EClass COMPLETE_BONDING = eINSTANCE.getCompleteBonding();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.RobotImpl <em>Robot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.RobotImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRobot()
		 * @generated
		 */
		EClass ROBOT = eINSTANCE.getRobot();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOT__WIDTH = eINSTANCE.getRobot_Width();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.SystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__BASE_CLASS = eINSTANCE.getSystem_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Native</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__NATIVE = eINSTANCE.getSystem_Native();

		/**
		 * The meta object literal for the '<em><b>Library Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__LIBRARY_PATH = eINSTANCE.getSystem_LibraryPath();

		/**
		 * The meta object literal for the '<em><b>Library Component Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SYSTEM__LIBRARY_COMPONENT_NAME = eINSTANCE.getSystem_LibraryComponentName();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.AgentImpl <em>Agent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.AgentImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAgent()
		 * @generated
		 */
		EClass AGENT = eINSTANCE.getAgent();

		/**
		 * The meta object literal for the '<em><b>Moves Over</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGENT__MOVES_OVER = eINSTANCE.getAgent_MovesOver();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PhysicalObjectImpl <em>Physical Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.PhysicalObjectImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPhysicalObject()
		 * @generated
		 */
		EClass PHYSICAL_OBJECT = eINSTANCE.getPhysicalObject();

		/**
		 * The meta object literal for the '<em><b>Eveloves In</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSICAL_OBJECT__EVELOVES_IN = eINSTANCE.getPhysicalObject_EvelovesIn();

		/**
		 * The meta object literal for the '<em><b>Has Surface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PHYSICAL_OBJECT__HAS_SURFACE = eINSTANCE.getPhysicalObject_HasSurface();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_OBJECT__HEIGHT = eINSTANCE.getPhysicalObject_Height();

		/**
		 * The meta object literal for the '<em><b>Mass</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PHYSICAL_OBJECT__MASS = eINSTANCE.getPhysicalObject_Mass();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.EnvironmentImpl <em>Environment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.EnvironmentImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getEnvironment()
		 * @generated
		 */
		EClass ENVIRONMENT = eINSTANCE.getEnvironment();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SurfaceImpl <em>Surface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.SurfaceImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSurface()
		 * @generated
		 */
		EClass SURFACE = eINSTANCE.getSurface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.DataFlowPortImpl <em>Data Flow Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.DataFlowPortImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDataFlowPort()
		 * @generated
		 */
		EClass DATA_FLOW_PORT = eINSTANCE.getDataFlowPort();

		/**
		 * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_FLOW_PORT__DIRECTION = eINSTANCE.getDataFlowPort_Direction();

		/**
		 * The meta object literal for the '<em><b>Buffer Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_FLOW_PORT__BUFFER_SIZE = eINSTANCE.getDataFlowPort_BufferSize();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.PortImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPort()
		 * @generated
		 */
		EClass PORT = eINSTANCE.getPort();

		/**
		 * The meta object literal for the '<em><b>Base Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__BASE_PORT = eINSTANCE.getPort_Base_Port();

		/**
		 * The meta object literal for the '<em><b>Synchronization Policy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT__SYNCHRONIZATION_POLICY = eINSTANCE.getPort_SynchronizationPolicy();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ServicePortImpl <em>Service Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ServicePortImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getServicePort()
		 * @generated
		 */
		EClass SERVICE_PORT = eINSTANCE.getServicePort();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_PORT__KIND = eINSTANCE.getServicePort_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ActuatorSystemImpl <em>Actuator System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ActuatorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getActuatorSystem()
		 * @generated
		 */
		EClass ACTUATOR_SYSTEM = eINSTANCE.getActuatorSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticSystemImpl <em>Robotic System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.RoboticSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticSystem()
		 * @generated
		 */
		EClass ROBOTIC_SYSTEM = eINSTANCE.getRoboticSystem();

		/**
		 * The meta object literal for the '<em><b>Local Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOTIC_SYSTEM__LOCAL_POSITION = eINSTANCE.getRoboticSystem_LocalPosition();

		/**
		 * The meta object literal for the '<em><b>Local Orientation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROBOTIC_SYSTEM__LOCAL_ORIENTATION = eINSTANCE.getRoboticSystem_LocalOrientation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.CyberPhysicalSystemImpl <em>Cyber Physical System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.CyberPhysicalSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCyberPhysicalSystem()
		 * @generated
		 */
		EClass CYBER_PHYSICAL_SYSTEM = eINSTANCE.getCyberPhysicalSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SensorSystemImpl <em>Sensor System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.SensorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSensorSystem()
		 * @generated
		 */
		EClass SENSOR_SYSTEM = eINSTANCE.getSensorSystem();

		/**
		 * The meta object literal for the '<em><b>Frequency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR_SYSTEM__FREQUENCY = eINSTANCE.getSensorSystem_Frequency();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SENSOR_SYSTEM__IDENTIFIER = eINSTANCE.getSensorSystem_Identifier();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.HardwareImpl <em>Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.HardwareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getHardware()
		 * @generated
		 */
		EClass HARDWARE = eINSTANCE.getHardware();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SoftwareImpl <em>Software</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.SoftwareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSoftware()
		 * @generated
		 */
		EClass SOFTWARE = eINSTANCE.getSoftware();

		/**
		 * The meta object literal for the '<em><b>Is Periodic</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFTWARE__IS_PERIODIC = eINSTANCE.getSoftware_IsPeriodic();

		/**
		 * The meta object literal for the '<em><b>Period</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFTWARE__PERIOD = eINSTANCE.getSoftware_Period();

		/**
		 * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFTWARE__PRIORITY = eINSTANCE.getSoftware_Priority();

		/**
		 * The meta object literal for the '<em><b>Deadline</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFTWARE__DEADLINE = eINSTANCE.getSoftware_Deadline();

		/**
		 * The meta object literal for the '<em><b>Wcet</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOFTWARE__WCET = eINSTANCE.getSoftware_Wcet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.EngineSystemImpl <em>Engine System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.EngineSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getEngineSystem()
		 * @generated
		 */
		EClass ENGINE_SYSTEM = eINSTANCE.getEngineSystem();

		/**
		 * The meta object literal for the '<em><b>Vehicle Traction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__VEHICLE_TRACTION = eINSTANCE.getEngineSystem_VehicleTraction();

		/**
		 * The meta object literal for the '<em><b>Max Engine Force</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__MAX_ENGINE_FORCE = eINSTANCE.getEngineSystem_MaxEngineForce();

		/**
		 * The meta object literal for the '<em><b>Max Breaking Force</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__MAX_BREAKING_FORCE = eINSTANCE.getEngineSystem_MaxBreakingForce();

		/**
		 * The meta object literal for the '<em><b>Max Allowed Steering</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__MAX_ALLOWED_STEERING = eINSTANCE.getEngineSystem_MaxAllowedSteering();

		/**
		 * The meta object literal for the '<em><b>Max Allowed Velocity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__MAX_ALLOWED_VELOCITY = eINSTANCE.getEngineSystem_MaxAllowedVelocity();

		/**
		 * The meta object literal for the '<em><b>Gear ration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENGINE_SYSTEM__GEAR_RATION = eINSTANCE.getEngineSystem_Gear_ration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl <em>Steered Wheel System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.SteeredWheelSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSteeredWheelSystem()
		 * @generated
		 */
		EClass STEERED_WHEEL_SYSTEM = eINSTANCE.getSteeredWheelSystem();

		/**
		 * The meta object literal for the '<em><b>Wheel Radius</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__WHEEL_RADIUS = eINSTANCE.getSteeredWheelSystem_WheelRadius();

		/**
		 * The meta object literal for the '<em><b>Wheel Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__WHEEL_WIDTH = eINSTANCE.getSteeredWheelSystem_WheelWidth();

		/**
		 * The meta object literal for the '<em><b>Suspension Rest Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__SUSPENSION_REST_LENGTH = eINSTANCE.getSteeredWheelSystem_SuspensionRestLength();

		/**
		 * The meta object literal for the '<em><b>Wheel Connection Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__WHEEL_CONNECTION_HEIGHT = eINSTANCE.getSteeredWheelSystem_WheelConnectionHeight();

		/**
		 * The meta object literal for the '<em><b>Type Of Wheel</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__TYPE_OF_WHEEL = eINSTANCE.getSteeredWheelSystem_TypeOfWheel();

		/**
		 * The meta object literal for the '<em><b>Wheel Velocity PI Dkp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKP = eINSTANCE.getSteeredWheelSystem_WheelVelocityPIDkp();

		/**
		 * The meta object literal for the '<em><b>Wheel Velocity PI Dki</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKI = eINSTANCE.getSteeredWheelSystem_WheelVelocityPIDki();

		/**
		 * The meta object literal for the '<em><b>Wheel Velocity PI Dkd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DKD = eINSTANCE.getSteeredWheelSystem_WheelVelocityPIDkd();

		/**
		 * The meta object literal for the '<em><b>Wheel Steering PI Dkp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKP = eINSTANCE.getSteeredWheelSystem_WheelSteeringPIDkp();

		/**
		 * The meta object literal for the '<em><b>Wheel Steering PI Dkd</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__WHEEL_STEERING_PI_DKD = eINSTANCE.getSteeredWheelSystem_WheelSteeringPIDkd();

		/**
		 * The meta object literal for the '<em><b>Wheel Friction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__WHEEL_FRICTION = eINSTANCE.getSteeredWheelSystem_WheelFriction();

		/**
		 * The meta object literal for the '<em><b>Suspension Stiffness</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__SUSPENSION_STIFFNESS = eINSTANCE.getSteeredWheelSystem_SuspensionStiffness();

		/**
		 * The meta object literal for the '<em><b>Suspension Damping</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__SUSPENSION_DAMPING = eINSTANCE.getSteeredWheelSystem_SuspensionDamping();

		/**
		 * The meta object literal for the '<em><b>Suspension Compression</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__SUSPENSION_COMPRESSION = eINSTANCE.getSteeredWheelSystem_SuspensionCompression();

		/**
		 * The meta object literal for the '<em><b>Wheel Velocity PI Dmax Sum</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_SUM = eINSTANCE.getSteeredWheelSystem_WheelVelocityPIDmaxSum();

		/**
		 * The meta object literal for the '<em><b>Wheel Velocity PI Dmax Val</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEERED_WHEEL_SYSTEM__WHEEL_VELOCITY_PI_DMAX_VAL = eINSTANCE.getSteeredWheelSystem_WheelVelocityPIDmaxVal();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.LocomotionSystemImpl <em>Locomotion System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.LocomotionSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLocomotionSystem()
		 * @generated
		 */
		EClass LOCOMOTION_SYSTEM = eINSTANCE.getLocomotionSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ImageSensorSystemImpl <em>Image Sensor System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ImageSensorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getImageSensorSystem()
		 * @generated
		 */
		EClass IMAGE_SENSOR_SYSTEM = eINSTANCE.getImageSensorSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.CameraSystemImpl <em>Camera System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.CameraSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCameraSystem()
		 * @generated
		 */
		EClass CAMERA_SYSTEM = eINSTANCE.getCameraSystem();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__WIDTH = eINSTANCE.getCameraSystem_Width();

		/**
		 * The meta object literal for the '<em><b>Height</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__HEIGHT = eINSTANCE.getCameraSystem_Height();

		/**
		 * The meta object literal for the '<em><b>Alpha u</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__ALPHA_U = eINSTANCE.getCameraSystem_Alpha_u();

		/**
		 * The meta object literal for the '<em><b>Alpha v</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__ALPHA_V = eINSTANCE.getCameraSystem_Alpha_v();

		/**
		 * The meta object literal for the '<em><b>U0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__U0 = eINSTANCE.getCameraSystem_U0();

		/**
		 * The meta object literal for the '<em><b>V0</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__V0 = eINSTANCE.getCameraSystem_V0();

		/**
		 * The meta object literal for the '<em><b>Color format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAMERA_SYSTEM__COLOR_FORMAT = eINSTANCE.getCameraSystem_Color_format();

		/**
		 * The meta object literal for the '<em><b>Translate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAMERA_SYSTEM__TRANSLATE = eINSTANCE.getCameraSystem_Translate();

		/**
		 * The meta object literal for the '<em><b>Rotate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAMERA_SYSTEM__ROTATE = eINSTANCE.getCameraSystem_Rotate();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ObjectDetectionSensorSystemImpl <em>Object Detection Sensor System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ObjectDetectionSensorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getObjectDetectionSensorSystem()
		 * @generated
		 */
		EClass OBJECT_DETECTION_SENSOR_SYSTEM = eINSTANCE.getObjectDetectionSensorSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ObjectTrackingSensorSystemImpl <em>Object Tracking Sensor System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ObjectTrackingSensorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getObjectTrackingSensorSystem()
		 * @generated
		 */
		EClass OBJECT_TRACKING_SENSOR_SYSTEM = eINSTANCE.getObjectTrackingSensorSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.LidarSystemImpl <em>Lidar System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.LidarSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLidarSystem()
		 * @generated
		 */
		EClass LIDAR_SYSTEM = eINSTANCE.getLidarSystem();

		/**
		 * The meta object literal for the '<em><b>Nb Layers</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__NB_LAYERS = eINSTANCE.getLidarSystem_NbLayers();

		/**
		 * The meta object literal for the '<em><b>Layer Angle Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__LAYER_ANGLE_MIN = eINSTANCE.getLidarSystem_LayerAngleMin();

		/**
		 * The meta object literal for the '<em><b>Layer Angle Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__LAYER_ANGLE_STEP = eINSTANCE.getLidarSystem_LayerAngleStep();

		/**
		 * The meta object literal for the '<em><b>Noise</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__NOISE = eINSTANCE.getLidarSystem_Noise();

		/**
		 * The meta object literal for the '<em><b>Sigma Noise</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__SIGMA_NOISE = eINSTANCE.getLidarSystem_SigmaNoise();

		/**
		 * The meta object literal for the '<em><b>Angle min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__ANGLE_MIN = eINSTANCE.getLidarSystem_Angle_min();

		/**
		 * The meta object literal for the '<em><b>Angle max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__ANGLE_MAX = eINSTANCE.getLidarSystem_Angle_max();

		/**
		 * The meta object literal for the '<em><b>Time increment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__TIME_INCREMENT = eINSTANCE.getLidarSystem_Time_increment();

		/**
		 * The meta object literal for the '<em><b>Scan time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__SCAN_TIME = eINSTANCE.getLidarSystem_Scan_time();

		/**
		 * The meta object literal for the '<em><b>Range min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__RANGE_MIN = eINSTANCE.getLidarSystem_Range_min();

		/**
		 * The meta object literal for the '<em><b>Range max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__RANGE_MAX = eINSTANCE.getLidarSystem_Range_max();

		/**
		 * The meta object literal for the '<em><b>Nb Rays</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LIDAR_SYSTEM__NB_RAYS = eINSTANCE.getLidarSystem_NbRays();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.LocalizationSensorSystemImpl <em>Localization Sensor System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.LocalizationSensorSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLocalizationSensorSystem()
		 * @generated
		 */
		EClass LOCALIZATION_SENSOR_SYSTEM = eINSTANCE.getLocalizationSensorSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.GPSSystemImpl <em>GPS System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.GPSSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGPSSystem()
		 * @generated
		 */
		EClass GPS_SYSTEM = eINSTANCE.getGPSSystem();

		/**
		 * The meta object literal for the '<em><b>Origin Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GPS_SYSTEM__ORIGIN_POSITION = eINSTANCE.getGPSSystem_OriginPosition();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.AlgorithmLibraryImpl <em>Algorithm Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.AlgorithmLibraryImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAlgorithmLibrary()
		 * @generated
		 */
		EClass ALGORITHM_LIBRARY = eINSTANCE.getAlgorithmLibrary();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHM_LIBRARY__BASE_CLASS = eINSTANCE.getAlgorithmLibrary_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ALGORITHM_LIBRARY__PATH = eINSTANCE.getAlgorithmLibrary_Path();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SensorDriverImpl <em>Sensor Driver</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.SensorDriverImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSensorDriver()
		 * @generated
		 */
		EClass SENSOR_DRIVER = eINSTANCE.getSensorDriver();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.BuildingImpl <em>Building</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.BuildingImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getBuilding()
		 * @generated
		 */
		EClass BUILDING = eINSTANCE.getBuilding();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PlanetImpl <em>Planet</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.PlanetImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPlanet()
		 * @generated
		 */
		EClass PLANET = eINSTANCE.getPlanet();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.LandSurfaceImpl <em>Land Surface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.LandSurfaceImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLandSurface()
		 * @generated
		 */
		EClass LAND_SURFACE = eINSTANCE.getLandSurface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.GroundImpl <em>Ground</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.GroundImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGround()
		 * @generated
		 */
		EClass GROUND = eINSTANCE.getGround();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.FloorImpl <em>Floor</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.FloorImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getFloor()
		 * @generated
		 */
		EClass FLOOR = eINSTANCE.getFloor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.WaterSurfaceImpl <em>Water Surface</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.WaterSurfaceImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getWaterSurface()
		 * @generated
		 */
		EClass WATER_SURFACE = eINSTANCE.getWaterSurface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.HumanImpl <em>Human</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.HumanImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getHuman()
		 * @generated
		 */
		EClass HUMAN = eINSTANCE.getHuman();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PedestrianImpl <em>Pedestrian</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.PedestrianImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPedestrian()
		 * @generated
		 */
		EClass PEDESTRIAN = eINSTANCE.getPedestrian();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.StairsImpl <em>Stairs</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.StairsImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getStairs()
		 * @generated
		 */
		EClass STAIRS = eINSTANCE.getStairs();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PlatformImpl <em>Platform</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.PlatformImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPlatform()
		 * @generated
		 */
		EClass PLATFORM = eINSTANCE.getPlatform();

		/**
		 * The meta object literal for the '<em><b>Base Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLATFORM__BASE_NODE = eINSTANCE.getPlatform_Base_Node();

		/**
		 * The meta object literal for the '<em><b>Library</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLATFORM__LIBRARY = eINSTANCE.getPlatform_Library();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ExternalLibraryImpl <em>External Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ExternalLibraryImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getExternalLibrary()
		 * @generated
		 */
		EClass EXTERNAL_LIBRARY = eINSTANCE.getExternalLibrary();

		/**
		 * The meta object literal for the '<em><b>Lib Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_LIBRARY__LIB_PATH = eINSTANCE.getExternalLibrary_LibPath();

		/**
		 * The meta object literal for the '<em><b>Lib File Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_LIBRARY__LIB_FILE_FORMAT = eINSTANCE.getExternalLibrary_LibFileFormat();

		/**
		 * The meta object literal for the '<em><b>Base Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_LIBRARY__BASE_INTERFACE = eINSTANCE.getExternalLibrary_Base_Interface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticMiddlewareImpl <em>Robotic Middleware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.RoboticMiddlewareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticMiddleware()
		 * @generated
		 */
		EClass ROBOTIC_MIDDLEWARE = eINSTANCE.getRoboticMiddleware();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROBOTIC_MIDDLEWARE__KIND = eINSTANCE.getRoboticMiddleware_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticSimulatorImpl <em>Robotic Simulator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.RoboticSimulatorImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticSimulator()
		 * @generated
		 */
		EClass ROBOTIC_SIMULATOR = eINSTANCE.getRoboticSimulator();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.CycabTKImpl <em>Cycab TK</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.CycabTKImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getCycabTK()
		 * @generated
		 */
		EClass CYCAB_TK = eINSTANCE.getCycabTK();

		/**
		 * The meta object literal for the '<em><b>Use Real Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CYCAB_TK__USE_REAL_TIME = eINSTANCE.getCycabTK_UseRealTime();

		/**
		 * The meta object literal for the '<em><b>Time Step</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CYCAB_TK__TIME_STEP = eINSTANCE.getCycabTK_TimeStep();

		/**
		 * The meta object literal for the '<em><b>Time Factor</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CYCAB_TK__TIME_FACTOR = eINSTANCE.getCycabTK_TimeFactor();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl <em>Blender Morse</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.BlenderMorseImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getBlenderMorse()
		 * @generated
		 */
		EClass BLENDER_MORSE = eINSTANCE.getBlenderMorse();

		/**
		 * The meta object literal for the '<em><b>Debug Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLENDER_MORSE__DEBUG_MODE = eINSTANCE.getBlenderMorse_DebugMode();

		/**
		 * The meta object literal for the '<em><b>Debug Display</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLENDER_MORSE__DEBUG_DISPLAY = eINSTANCE.getBlenderMorse_DebugDisplay();

		/**
		 * The meta object literal for the '<em><b>Gravity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLENDER_MORSE__GRAVITY = eINSTANCE.getBlenderMorse_Gravity();

		/**
		 * The meta object literal for the '<em><b>viewport shade</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLENDER_MORSE__VIEWPORT_SHADE = eINSTANCE.getBlenderMorse__viewport_shade();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.OnPortImpl <em>On Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.OnPortImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOnPort()
		 * @generated
		 */
		EClass ON_PORT = eINSTANCE.getOnPort();

		/**
		 * The meta object literal for the '<em><b>Port</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ON_PORT__PORT = eINSTANCE.getOnPort_Port();

		/**
		 * The meta object literal for the '<em><b>Base Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ON_PORT__BASE_PARAMETER = eINSTANCE.getOnPort_Base_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.AllocateImpl <em>Allocate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.AllocateImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getAllocate()
		 * @generated
		 */
		EClass ALLOCATE = eINSTANCE.getAllocate();

		/**
		 * The meta object literal for the '<em><b>Base Abstraction</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALLOCATE__BASE_ABSTRACTION = eINSTANCE.getAllocate_Base_Abstraction();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.InertialMeasurementUnitSystemImpl <em>Inertial Measurement Unit System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.InertialMeasurementUnitSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInertialMeasurementUnitSystem()
		 * @generated
		 */
		EClass INERTIAL_MEASUREMENT_UNIT_SYSTEM = eINSTANCE.getInertialMeasurementUnitSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.InertialNavigationSystemImpl <em>Inertial Navigation System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.InertialNavigationSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInertialNavigationSystem()
		 * @generated
		 */
		EClass INERTIAL_NAVIGATION_SYSTEM = eINSTANCE.getInertialNavigationSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.OdometrySystemImpl <em>Odometry System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.OdometrySystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOdometrySystem()
		 * @generated
		 */
		EClass ODOMETRY_SYSTEM = eINSTANCE.getOdometrySystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.InfraRedProximetrySystemImpl <em>Infra Red Proximetry System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.InfraRedProximetrySystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getInfraRedProximetrySystem()
		 * @generated
		 */
		EClass INFRA_RED_PROXIMETRY_SYSTEM = eINSTANCE.getInfraRedProximetrySystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.DeploymentPlanImpl <em>Deployment Plan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.DeploymentPlanImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDeploymentPlan()
		 * @generated
		 */
		EClass DEPLOYMENT_PLAN = eINSTANCE.getDeploymentPlan();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PLAN__BASE_PACKAGE = eINSTANCE.getDeploymentPlan_Base_Package();

		/**
		 * The meta object literal for the '<em><b>Main Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PLAN__MAIN_INSTANCE = eINSTANCE.getDeploymentPlan_MainInstance();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.GyroscopeImpl <em>Gyroscope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.GyroscopeImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGyroscope()
		 * @generated
		 */
		EClass GYROSCOPE = eINSTANCE.getGyroscope();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.OnPropertyImpl <em>On Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.OnPropertyImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOnProperty()
		 * @generated
		 */
		EClass ON_PROPERTY = eINSTANCE.getOnProperty();

		/**
		 * The meta object literal for the '<em><b>Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ON_PROPERTY__PROPERTY = eINSTANCE.getOnProperty_Property();

		/**
		 * The meta object literal for the '<em><b>Base Parameter</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ON_PROPERTY__BASE_PARAMETER = eINSTANCE.getOnProperty_Base_Parameter();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ChassisImpl <em>Chassis</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ChassisImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getChassis()
		 * @generated
		 */
		EClass CHASSIS = eINSTANCE.getChassis();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SupportingStructureImpl <em>Supporting Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.SupportingStructureImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSupportingStructure()
		 * @generated
		 */
		EClass SUPPORTING_STRUCTURE = eINSTANCE.getSupportingStructure();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.MechanicalLinkageImpl <em>Mechanical Linkage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.MechanicalLinkageImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getMechanicalLinkage()
		 * @generated
		 */
		EClass MECHANICAL_LINKAGE = eINSTANCE.getMechanicalLinkage();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.LegImpl <em>Leg</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.LegImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLeg()
		 * @generated
		 */
		EClass LEG = eINSTANCE.getLeg();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.LocomotionHardwareImpl <em>Locomotion Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.LocomotionHardwareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLocomotionHardware()
		 * @generated
		 */
		EClass LOCOMOTION_HARDWARE = eINSTANCE.getLocomotionHardware();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ActuatorHardwareImpl <em>Actuator Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ActuatorHardwareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getActuatorHardware()
		 * @generated
		 */
		EClass ACTUATOR_HARDWARE = eINSTANCE.getActuatorHardware();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.MobileRobotImpl <em>Mobile Robot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.MobileRobotImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getMobileRobot()
		 * @generated
		 */
		EClass MOBILE_ROBOT = eINSTANCE.getMobileRobot();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MOBILE_ROBOT__KIND = eINSTANCE.getMobileRobot_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ManipulatorImpl <em>Manipulator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ManipulatorImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getManipulator()
		 * @generated
		 */
		EClass MANIPULATOR = eINSTANCE.getManipulator();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PilotedSystemImpl <em>Piloted System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.PilotedSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPilotedSystem()
		 * @generated
		 */
		EClass PILOTED_SYSTEM = eINSTANCE.getPilotedSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.PowerHardwareImpl <em>Power Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.PowerHardwareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getPowerHardware()
		 * @generated
		 */
		EClass POWER_HARDWARE = eINSTANCE.getPowerHardware();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SensorHardwareImpl <em>Sensor Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.SensorHardwareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSensorHardware()
		 * @generated
		 */
		EClass SENSOR_HARDWARE = eINSTANCE.getSensorHardware();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.GraspingHardwareImpl <em>Grasping Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.GraspingHardwareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGraspingHardware()
		 * @generated
		 */
		EClass GRASPING_HARDWARE = eINSTANCE.getGraspingHardware();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.SteeredWheelHardwareImpl <em>Steered Wheel Hardware</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.SteeredWheelHardwareImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSteeredWheelHardware()
		 * @generated
		 */
		EClass STEERED_WHEEL_HARDWARE = eINSTANCE.getSteeredWheelHardware();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ArmImpl <em>Arm</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ArmImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getArm()
		 * @generated
		 */
		EClass ARM = eINSTANCE.getArm();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.LegSystemImpl <em>Leg System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.LegSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getLegSystem()
		 * @generated
		 */
		EClass LEG_SYSTEM = eINSTANCE.getLegSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.GraspingSystemImpl <em>Grasping System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.GraspingSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getGraspingSystem()
		 * @generated
		 */
		EClass GRASPING_SYSTEM = eINSTANCE.getGraspingSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.WeaponSystemImpl <em>Weapon System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.WeaponSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getWeaponSystem()
		 * @generated
		 */
		EClass WEAPON_SYSTEM = eINSTANCE.getWeaponSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ManMachineInterfaceSystemImpl <em>Man Machine Interface System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ManMachineInterfaceSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getManMachineInterfaceSystem()
		 * @generated
		 */
		EClass MAN_MACHINE_INTERFACE_SYSTEM = eINSTANCE.getManMachineInterfaceSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.ClosedLoopControlSystemImpl <em>Closed Loop Control System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.ClosedLoopControlSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getClosedLoopControlSystem()
		 * @generated
		 */
		EClass CLOSED_LOOP_CONTROL_SYSTEM = eINSTANCE.getClosedLoopControlSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.OpenLoopControlSystemImpl <em>Open Loop Control System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.OpenLoopControlSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getOpenLoopControlSystem()
		 * @generated
		 */
		EClass OPEN_LOOP_CONTROL_SYSTEM = eINSTANCE.getOpenLoopControlSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.RoboticHeadImpl <em>Robotic Head</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.RoboticHeadImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticHead()
		 * @generated
		 */
		EClass ROBOTIC_HEAD = eINSTANCE.getRoboticHead();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.NavigationCommandSystemImpl <em>Navigation Command System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.NavigationCommandSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getNavigationCommandSystem()
		 * @generated
		 */
		EClass NAVIGATION_COMMAND_SYSTEM = eINSTANCE.getNavigationCommandSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.impl.JoysticNavigationSystemImpl <em>Joystic Navigation System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.impl.JoysticNavigationSystemImpl
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getJoysticNavigationSystem()
		 * @generated
		 */
		EClass JOYSTIC_NAVIGATION_SYSTEM = eINSTANCE.getJoysticNavigationSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.SynchronizationKind <em>Synchronization Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.SynchronizationKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getSynchronizationKind()
		 * @generated
		 */
		EEnum SYNCHRONIZATION_KIND = eINSTANCE.getSynchronizationKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.DataFlowDirectionKind <em>Data Flow Direction Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.DataFlowDirectionKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getDataFlowDirectionKind()
		 * @generated
		 */
		EEnum DATA_FLOW_DIRECTION_KIND = eINSTANCE.getDataFlowDirectionKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.ServiceFlowKind <em>Service Flow Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.ServiceFlowKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getServiceFlowKind()
		 * @generated
		 */
		EEnum SERVICE_FLOW_KIND = eINSTANCE.getServiceFlowKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.UGVKind <em>UGV Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.UGVKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getUGVKind()
		 * @generated
		 */
		EEnum UGV_KIND = eINSTANCE.getUGVKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.RoboticMiddlewareKind <em>Robotic Middleware Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.RoboticMiddlewareKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getRoboticMiddlewareKind()
		 * @generated
		 */
		EEnum ROBOTIC_MIDDLEWARE_KIND = eINSTANCE.getRoboticMiddlewareKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.Shade <em>Shade</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.Shade
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getShade()
		 * @generated
		 */
		EEnum SHADE = eINSTANCE.getShade();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.RobotML.MobileRobotKind <em>Mobile Robot Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.RobotML.MobileRobotKind
		 * @see org.eclipse.papyrus.RobotML.impl.RobotMLPackageImpl#getMobileRobotKind()
		 * @generated
		 */
		EEnum MOBILE_ROBOT_KIND = eINSTANCE.getMobileRobotKind();

	}

} //RobotMLPackage
