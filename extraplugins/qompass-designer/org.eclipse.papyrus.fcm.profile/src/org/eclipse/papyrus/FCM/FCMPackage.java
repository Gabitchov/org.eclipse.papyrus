/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.FCM;

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
 * @see org.eclipse.papyrus.FCM.FCMFactory
 * @model kind="package"
 * @generated
 */
public interface FCMPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "FCM";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/papyrus/FCM/1";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "FCM";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FCMPackage eINSTANCE = org.eclipse.papyrus.FCM.impl.FCMPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.TemplateImpl <em>Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.TemplateImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getTemplate()
	 * @generated
	 */
	int TEMPLATE = 0;

	/**
	 * The feature id for the '<em><b>Template Params</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__TEMPLATE_PARAMS = 0;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__BASE_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__KIND = 2;

	/**
	 * The feature id for the '<em><b>Actual Choice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE__ACTUAL_CHOICE = 3;

	/**
	 * The number of structural features of the '<em>Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ContainerRuleImpl <em>Container Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ContainerRuleImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getContainerRule()
	 * @generated
	 */
	int CONTAINER_RULE = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ConfigurableElementInstanceImpl <em>Configurable Element Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ConfigurableElementInstanceImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConfigurableElementInstance()
	 * @generated
	 */
	int CONFIGURABLE_ELEMENT_INSTANCE = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.PortImpl <em>Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.PortImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getPort()
	 * @generated
	 */
	int PORT = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.PortKindImpl <em>Port Kind</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.PortKindImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getPortKind()
	 * @generated
	 */
	int PORT_KIND = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.CompImplTemplateImpl <em>Comp Impl Template</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.CompImplTemplateImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getCompImplTemplate()
	 * @generated
	 */
	int COMP_IMPL_TEMPLATE = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ConfigOptionImpl <em>Config Option</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ConfigOptionImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConfigOption()
	 * @generated
	 */
	int CONFIG_OPTION = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ConnectorImpl <em>Connector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ConnectorImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConnector()
	 * @generated
	 */
	int CONNECTOR = 11;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ConfigurationPropertyImpl <em>Configuration Property</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ConfigurationPropertyImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConfigurationProperty()
	 * @generated
	 */
	int CONFIGURATION_PROPERTY = 1;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_PROPERTY__BASE_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Configuration Property</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_PROPERTY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.RuleApplicationImpl <em>Rule Application</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.RuleApplicationImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getRuleApplication()
	 * @generated
	 */
	int RULE_APPLICATION = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.DeploymentPlanImpl <em>Deployment Plan</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.DeploymentPlanImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getDeploymentPlan()
	 * @generated
	 */
	int DEPLOYMENT_PLAN = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.DerivedElementImpl <em>Derived Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.DerivedElementImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getDerivedElement()
	 * @generated
	 */
	int DERIVED_ELEMENT = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ExternalLibraryImpl <em>External Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ExternalLibraryImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getExternalLibrary()
	 * @generated
	 */
	int EXTERNAL_LIBRARY = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.CppLibraryImpl <em>Cpp Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.CppLibraryImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getCppLibrary()
	 * @generated
	 */
	int CPP_LIBRARY = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ImplementationGroupImpl <em>Implementation Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ImplementationGroupImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getImplementationGroup()
	 * @generated
	 */
	int IMPLEMENTATION_GROUP = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.JavaLibraryImpl <em>Java Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.JavaLibraryImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getJavaLibrary()
	 * @generated
	 */
	int JAVA_LIBRARY = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ImplementationPropertiesImpl <em>Implementation Properties</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ImplementationPropertiesImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getImplementationProperties()
	 * @generated
	 */
	int IMPLEMENTATION_PROPERTIES = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.OperatingSystemImpl <em>Operating System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.OperatingSystemImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getOperatingSystem()
	 * @generated
	 */
	int OPERATING_SYSTEM = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.TargetArchitectureImpl <em>Target Architecture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.TargetArchitectureImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getTargetArchitecture()
	 * @generated
	 */
	int TARGET_ARCHITECTURE = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.TargetImpl <em>Target</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.TargetImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getTarget()
	 * @generated
	 */
	int TARGET = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ConfigurationImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.InterceptionRuleImpl <em>Interception Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.InterceptionRuleImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getInterceptionRule()
	 * @generated
	 */
	int INTERCEPTION_RULE = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.SingletonImpl <em>Singleton</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.SingletonImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getSingleton()
	 * @generated
	 */
	int SINGLETON = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.InteractionComponentImpl <em>Interaction Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.InteractionComponentImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getInteractionComponent()
	 * @generated
	 */
	int INTERACTION_COMPONENT = 7;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_GROUP__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Implementation Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_GROUP_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_APPLICATION__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Container Rule</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_APPLICATION__CONTAINER_RULE = 1;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_APPLICATION__BASE_PACKAGE = 2;

	/**
	 * The number of structural features of the '<em>Rule Application</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RULE_APPLICATION_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_RULE__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>For Config</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_RULE__FOR_CONFIG = 1;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_RULE__KIND = 2;

	/**
	 * The number of structural features of the '<em>Container Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_RULE_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_OPTION__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Config Option</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIG_OPTION_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Singleton</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SINGLETON_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>For Distribution</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_COMPONENT__FOR_DISTRIBUTION = 0;

	/**
	 * The feature id for the '<em><b>Connection Pattern</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_COMPONENT__CONNECTION_PATTERN = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_COMPONENT__BASE_CLASS = 2;

	/**
	 * The number of structural features of the '<em>Interaction Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERACTION_COMPONENT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_KIND__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_KIND__PROVIDED_INTERFACE = 1;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_KIND__REQUIRED_INTERFACE = 2;

	/**
	 * The feature id for the '<em><b>Extended Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_KIND__EXTENDED_PORT = 3;

	/**
	 * The number of structural features of the '<em>Port Kind</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_KIND_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_ELEMENT_INSTANCE__CONFIGURATION = 0;

	/**
	 * The number of structural features of the '<em>Configurable Element Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURABLE_ELEMENT_INSTANCE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__CONFIGURATION = CONFIGURABLE_ELEMENT_INSTANCE__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__BASE_PORT = CONFIGURABLE_ELEMENT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__KIND = CONFIGURABLE_ELEMENT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__PROVIDED_INTERFACE = CONFIGURABLE_ELEMENT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT__REQUIRED_INTERFACE = CONFIGURABLE_ELEMENT_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PORT_FEATURE_COUNT = CONFIGURABLE_ELEMENT_INSTANCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__CONFIGURATION = CONFIGURABLE_ELEMENT_INSTANCE__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Base Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__BASE_CONNECTOR = CONFIGURABLE_ELEMENT_INSTANCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Ic</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__IC = CONFIGURABLE_ELEMENT_INSTANCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR__BASE_PROPERTY = CONFIGURABLE_ELEMENT_INSTANCE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Connector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_FEATURE_COUNT = CONFIGURABLE_ELEMENT_INSTANCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Main Instance</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__MAIN_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN__BASE_PACKAGE = 1;

	/**
	 * The number of structural features of the '<em>Deployment Plan</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPLOYMENT_PLAN_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Base Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_ELEMENT__BASE_ELEMENT = 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_ELEMENT__SOURCE = 1;

	/**
	 * The number of structural features of the '<em>Derived Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVED_ELEMENT_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Template Defs</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMP_IMPL_TEMPLATE__TEMPLATE_DEFS = 0;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMP_IMPL_TEMPLATE__BASE_CLASS = 1;

	/**
	 * The number of structural features of the '<em>Comp Impl Template</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMP_IMPL_TEMPLATE_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_LIBRARY__BASE_PACKAGE = 0;

	/**
	 * The number of structural features of the '<em>External Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_LIBRARY_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_LIBRARY__BASE_PACKAGE = EXTERNAL_LIBRARY__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Macros</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_LIBRARY__MACROS = EXTERNAL_LIBRARY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Libs</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_LIBRARY__LIBS = EXTERNAL_LIBRARY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Lib Paths</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_LIBRARY__LIB_PATHS = EXTERNAL_LIBRARY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Include Paths</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_LIBRARY__INCLUDE_PATHS = EXTERNAL_LIBRARY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Cpp Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPP_LIBRARY_FEATURE_COUNT = EXTERNAL_LIBRARY_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Base Package</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_LIBRARY__BASE_PACKAGE = EXTERNAL_LIBRARY__BASE_PACKAGE;

	/**
	 * The feature id for the '<em><b>Class Path</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_LIBRARY__CLASS_PATH = EXTERNAL_LIBRARY_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Java Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int JAVA_LIBRARY_FEATURE_COUNT = EXTERNAL_LIBRARY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Size RAM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_PROPERTIES__SIZE_RAM = 0;

	/**
	 * The feature id for the '<em><b>Supported OS</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_PROPERTIES__SUPPORTED_OS = 1;

	/**
	 * The feature id for the '<em><b>Arch</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_PROPERTIES__ARCH = 2;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_PROPERTIES__BASE_CLASS = 3;

	/**
	 * The feature id for the '<em><b>Size ROM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_PROPERTIES__SIZE_ROM = 4;

	/**
	 * The feature id for the '<em><b>Supported Target Arch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_PROPERTIES__SUPPORTED_TARGET_ARCH = 5;

	/**
	 * The number of structural features of the '<em>Implementation Properties</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLEMENTATION_PROPERTIES_FEATURE_COUNT = 6;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Operating System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATING_SYSTEM_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ARCHITECTURE__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Target Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_ARCHITECTURE_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Config Options</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__CONFIG_OPTIONS = 1;

	/**
	 * The feature id for the '<em><b>Deployment Plan</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__DEPLOYMENT_PLAN = 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Interception Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCEPTION_RULE__INTERCEPTION_KIND = 0;

	/**
	 * The feature id for the '<em><b>Interception Set</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCEPTION_RULE__INTERCEPTION_SET = 1;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCEPTION_RULE__BASE_PROPERTY = 2;

	/**
	 * The feature id for the '<em><b>Base Operation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCEPTION_RULE__BASE_OPERATION = 3;

	/**
	 * The number of structural features of the '<em>Interception Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERCEPTION_RULE_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Target Arch</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__TARGET_ARCH = 0;

	/**
	 * The feature id for the '<em><b>Options</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__OPTIONS = 1;

	/**
	 * The feature id for the '<em><b>Base Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__BASE_NODE = 2;

	/**
	 * The feature id for the '<em><b>Used OS</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__USED_OS = 3;

	/**
	 * The feature id for the '<em><b>Avail RAM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__AVAIL_RAM = 4;

	/**
	 * The feature id for the '<em><b>Avail ROM</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET__AVAIL_ROM = 5;

	/**
	 * The number of structural features of the '<em>Target</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TARGET_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.PartImpl <em>Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.PartImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getPart()
	 * @generated
	 */
	int PART = 24;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__BASE_PROPERTY = 0;

	/**
	 * The feature id for the '<em><b>Colocate With Port</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART__COLOCATE_WITH_PORT = 1;

	/**
	 * The number of structural features of the '<em>Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PART_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.CopyAttributeValueImpl <em>Copy Attribute Value</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.CopyAttributeValueImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getCopyAttributeValue()
	 * @generated
	 */
	int COPY_ATTRIBUTE_VALUE = 25;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_ATTRIBUTE_VALUE__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_ATTRIBUTE_VALUE__BASE_PROPERTY = 1;

	/**
	 * The number of structural features of the '<em>Copy Attribute Value</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COPY_ATTRIBUTE_VALUE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.AutoIndexImpl <em>Auto Index</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.AutoIndexImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getAutoIndex()
	 * @generated
	 */
	int AUTO_INDEX = 26;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_INDEX__BASE_PROPERTY = 0;

	/**
	 * The number of structural features of the '<em>Auto Index</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_INDEX_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.AutoIndexPerNodeImpl <em>Auto Index Per Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.AutoIndexPerNodeImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getAutoIndexPerNode()
	 * @generated
	 */
	int AUTO_INDEX_PER_NODE = 27;

	/**
	 * The feature id for the '<em><b>Base Property</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_INDEX_PER_NODE__BASE_PROPERTY = AUTO_INDEX__BASE_PROPERTY;

	/**
	 * The number of structural features of the '<em>Auto Index Per Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AUTO_INDEX_PER_NODE_FEATURE_COUNT = AUTO_INDEX_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.InitPrecedenceImpl <em>Init Precedence</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.InitPrecedenceImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getInitPrecedence()
	 * @generated
	 */
	int INIT_PRECEDENCE = 28;

	/**
	 * The feature id for the '<em><b>Invoke After</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PRECEDENCE__INVOKE_AFTER = 0;

	/**
	 * The feature id for the '<em><b>Invoke Before</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PRECEDENCE__INVOKE_BEFORE = 1;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PRECEDENCE__BASE_CLASS = 2;

	/**
	 * The number of structural features of the '<em>Init Precedence</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INIT_PRECEDENCE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ConnectorConfigurationImpl <em>Connector Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ConnectorConfigurationImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConnectorConfiguration()
	 * @generated
	 */
	int CONNECTOR_CONFIGURATION = 29;

	/**
	 * The feature id for the '<em><b>Base Slot</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_CONFIGURATION__BASE_SLOT = 0;

	/**
	 * The feature id for the '<em><b>Connector</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_CONFIGURATION__CONNECTOR = 1;

	/**
	 * The number of structural features of the '<em>Connector Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONNECTOR_CONFIGURATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ExtendedSignatureImpl <em>Extended Signature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ExtendedSignatureImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getExtendedSignature()
	 * @generated
	 */
	int EXTENDED_SIGNATURE = 30;

	/**
	 * The feature id for the '<em><b>Base Template Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_SIGNATURE__BASE_TEMPLATE_SIGNATURE = 0;

	/**
	 * The feature id for the '<em><b>Base Signature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_SIGNATURE__BASE_SIGNATURE = 1;

	/**
	 * The number of structural features of the '<em>Extended Signature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTENDED_SIGNATURE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.ContainerPortImpl <em>Container Port</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.ContainerPortImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getContainerPort()
	 * @generated
	 */
	int CONTAINER_PORT = 31;

	/**
	 * The feature id for the '<em><b>Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PORT__CONFIGURATION = PORT__CONFIGURATION;

	/**
	 * The feature id for the '<em><b>Base Port</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PORT__BASE_PORT = PORT__BASE_PORT;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PORT__KIND = PORT__KIND;

	/**
	 * The feature id for the '<em><b>Provided Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PORT__PROVIDED_INTERFACE = PORT__PROVIDED_INTERFACE;

	/**
	 * The feature id for the '<em><b>Required Interface</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PORT__REQUIRED_INTERFACE = PORT__REQUIRED_INTERFACE;

	/**
	 * The number of structural features of the '<em>Container Port</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTAINER_PORT_FEATURE_COUNT = PORT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.UseInstanceConfiguratorImpl <em>Use Instance Configurator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.UseInstanceConfiguratorImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getUseInstanceConfigurator()
	 * @generated
	 */
	int USE_INSTANCE_CONFIGURATOR = 32;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_INSTANCE_CONFIGURATOR__BASE_CLASS = 0;

	/**
	 * The feature id for the '<em><b>Configurator</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_INSTANCE_CONFIGURATOR__CONFIGURATOR = 1;

	/**
	 * The number of structural features of the '<em>Use Instance Configurator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_INSTANCE_CONFIGURATOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.impl.InstanceConfiguratorImpl <em>Instance Configurator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.impl.InstanceConfiguratorImpl
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getInstanceConfigurator()
	 * @generated
	 */
	int INSTANCE_CONFIGURATOR = 33;

	/**
	 * The feature id for the '<em><b>Base Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATOR__BASE_CLASS = 0;

	/**
	 * The number of structural features of the '<em>Instance Configurator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_CONFIGURATOR_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.TemplateKind <em>Template Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.TemplateKind
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getTemplateKind()
	 * @generated
	 */
	int TEMPLATE_KIND = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.ActualChoice <em>Actual Choice</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.ActualChoice
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getActualChoice()
	 * @generated
	 */
	int ACTUAL_CHOICE = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.ContainerRuleKind <em>Container Rule Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.ContainerRuleKind
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getContainerRuleKind()
	 * @generated
	 */
	int CONTAINER_RULE_KIND = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.papyrus.FCM.InterceptionKind <em>Interception Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.papyrus.FCM.InterceptionKind
	 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getInterceptionKind()
	 * @generated
	 */
	int INTERCEPTION_KIND = 37;

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.Template <em>Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template</em>'.
	 * @see org.eclipse.papyrus.FCM.Template
	 * @generated
	 */
	EClass getTemplate();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.FCM.Template#getTemplateParams <em>Template Params</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Template Params</em>'.
	 * @see org.eclipse.papyrus.FCM.Template#getTemplateParams()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_TemplateParams();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Template#getBase_Element <em>Base Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Element</em>'.
	 * @see org.eclipse.papyrus.FCM.Template#getBase_Element()
	 * @see #getTemplate()
	 * @generated
	 */
	EReference getTemplate_Base_Element();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.FCM.Template#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.FCM.Template#getKind()
	 * @see #getTemplate()
	 * @generated
	 */
	EAttribute getTemplate_Kind();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.FCM.Template#getActualChoice <em>Actual Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Actual Choice</em>'.
	 * @see org.eclipse.papyrus.FCM.Template#getActualChoice()
	 * @see #getTemplate()
	 * @generated
	 */
	EAttribute getTemplate_ActualChoice();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.ContainerRule <em>Container Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Rule</em>'.
	 * @see org.eclipse.papyrus.FCM.ContainerRule
	 * @generated
	 */
	EClass getContainerRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ContainerRule#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.ContainerRule#getBase_Class()
	 * @see #getContainerRule()
	 * @generated
	 */
	EReference getContainerRule_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.FCM.ContainerRule#getForConfig <em>For Config</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>For Config</em>'.
	 * @see org.eclipse.papyrus.FCM.ContainerRule#getForConfig()
	 * @see #getContainerRule()
	 * @generated
	 */
	EReference getContainerRule_ForConfig();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.FCM.ContainerRule#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.FCM.ContainerRule#getKind()
	 * @see #getContainerRule()
	 * @generated
	 */
	EAttribute getContainerRule_Kind();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.Port <em>Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port</em>'.
	 * @see org.eclipse.papyrus.FCM.Port
	 * @generated
	 */
	EClass getPort();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Port#getBase_Port <em>Base Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Port</em>'.
	 * @see org.eclipse.papyrus.FCM.Port#getBase_Port()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Base_Port();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Port#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Kind</em>'.
	 * @see org.eclipse.papyrus.FCM.Port#getKind()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_Kind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Port#getProvidedInterface <em>Provided Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Interface</em>'.
	 * @see org.eclipse.papyrus.FCM.Port#getProvidedInterface()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_ProvidedInterface();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Port#getRequiredInterface <em>Required Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Interface</em>'.
	 * @see org.eclipse.papyrus.FCM.Port#getRequiredInterface()
	 * @see #getPort()
	 * @generated
	 */
	EReference getPort_RequiredInterface();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.ConfigurableElementInstance <em>Configurable Element Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configurable Element Instance</em>'.
	 * @see org.eclipse.papyrus.FCM.ConfigurableElementInstance
	 * @generated
	 */
	EClass getConfigurableElementInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ConfigurableElementInstance#getConfiguration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Configuration</em>'.
	 * @see org.eclipse.papyrus.FCM.ConfigurableElementInstance#getConfiguration()
	 * @see #getConfigurableElementInstance()
	 * @generated
	 */
	EReference getConfigurableElementInstance_Configuration();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.PortKind <em>Port Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Port Kind</em>'.
	 * @see org.eclipse.papyrus.FCM.PortKind
	 * @generated
	 */
	EClass getPortKind();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.PortKind#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.PortKind#getBase_Class()
	 * @see #getPortKind()
	 * @generated
	 */
	EReference getPortKind_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.PortKind#getProvidedInterface <em>Provided Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Interface</em>'.
	 * @see org.eclipse.papyrus.FCM.PortKind#getProvidedInterface()
	 * @see #getPortKind()
	 * @generated
	 */
	EReference getPortKind_ProvidedInterface();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.PortKind#getRequiredInterface <em>Required Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Required Interface</em>'.
	 * @see org.eclipse.papyrus.FCM.PortKind#getRequiredInterface()
	 * @see #getPortKind()
	 * @generated
	 */
	EReference getPortKind_RequiredInterface();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.FCM.PortKind#isExtendedPort <em>Extended Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extended Port</em>'.
	 * @see org.eclipse.papyrus.FCM.PortKind#isExtendedPort()
	 * @see #getPortKind()
	 * @generated
	 */
	EAttribute getPortKind_ExtendedPort();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.CompImplTemplate <em>Comp Impl Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comp Impl Template</em>'.
	 * @see org.eclipse.papyrus.FCM.CompImplTemplate
	 * @generated
	 */
	EClass getCompImplTemplate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.FCM.CompImplTemplate#getTemplateDefs <em>Template Defs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Template Defs</em>'.
	 * @see org.eclipse.papyrus.FCM.CompImplTemplate#getTemplateDefs()
	 * @see #getCompImplTemplate()
	 * @generated
	 */
	EAttribute getCompImplTemplate_TemplateDefs();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.CompImplTemplate#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.CompImplTemplate#getBase_Class()
	 * @see #getCompImplTemplate()
	 * @generated
	 */
	EReference getCompImplTemplate_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.ConfigOption <em>Config Option</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Config Option</em>'.
	 * @see org.eclipse.papyrus.FCM.ConfigOption
	 * @generated
	 */
	EClass getConfigOption();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ConfigOption#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.ConfigOption#getBase_Class()
	 * @see #getConfigOption()
	 * @generated
	 */
	EReference getConfigOption_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.Singleton <em>Singleton</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Singleton</em>'.
	 * @see org.eclipse.papyrus.FCM.Singleton
	 * @generated
	 */
	EClass getSingleton();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Singleton#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.Singleton#getBase_Class()
	 * @see #getSingleton()
	 * @generated
	 */
	EReference getSingleton_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.InteractionComponent <em>Interaction Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interaction Component</em>'.
	 * @see org.eclipse.papyrus.FCM.InteractionComponent
	 * @generated
	 */
	EClass getInteractionComponent();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.FCM.InteractionComponent#isForDistribution <em>For Distribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>For Distribution</em>'.
	 * @see org.eclipse.papyrus.FCM.InteractionComponent#isForDistribution()
	 * @see #getInteractionComponent()
	 * @generated
	 */
	EAttribute getInteractionComponent_ForDistribution();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.InteractionComponent#getConnectionPattern <em>Connection Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connection Pattern</em>'.
	 * @see org.eclipse.papyrus.FCM.InteractionComponent#getConnectionPattern()
	 * @see #getInteractionComponent()
	 * @generated
	 */
	EReference getInteractionComponent_ConnectionPattern();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.InteractionComponent#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.InteractionComponent#getBase_Class()
	 * @see #getInteractionComponent()
	 * @generated
	 */
	EReference getInteractionComponent_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.Connector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector</em>'.
	 * @see org.eclipse.papyrus.FCM.Connector
	 * @generated
	 */
	EClass getConnector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Connector#getBase_Connector <em>Base Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Connector</em>'.
	 * @see org.eclipse.papyrus.FCM.Connector#getBase_Connector()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_Base_Connector();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Connector#getIc <em>Ic</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ic</em>'.
	 * @see org.eclipse.papyrus.FCM.Connector#getIc()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_Ic();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Connector#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.FCM.Connector#getBase_Property()
	 * @see #getConnector()
	 * @generated
	 */
	EReference getConnector_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.ConfigurationProperty <em>Configuration Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration Property</em>'.
	 * @see org.eclipse.papyrus.FCM.ConfigurationProperty
	 * @generated
	 */
	EClass getConfigurationProperty();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ConfigurationProperty#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.FCM.ConfigurationProperty#getBase_Property()
	 * @see #getConfigurationProperty()
	 * @generated
	 */
	EReference getConfigurationProperty_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.DeploymentPlan <em>Deployment Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Deployment Plan</em>'.
	 * @see org.eclipse.papyrus.FCM.DeploymentPlan
	 * @generated
	 */
	EClass getDeploymentPlan();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.DeploymentPlan#getMainInstance <em>Main Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Main Instance</em>'.
	 * @see org.eclipse.papyrus.FCM.DeploymentPlan#getMainInstance()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EReference getDeploymentPlan_MainInstance();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.DeploymentPlan#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.FCM.DeploymentPlan#getBase_Package()
	 * @see #getDeploymentPlan()
	 * @generated
	 */
	EReference getDeploymentPlan_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.DerivedElement <em>Derived Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derived Element</em>'.
	 * @see org.eclipse.papyrus.FCM.DerivedElement
	 * @generated
	 */
	EClass getDerivedElement();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.DerivedElement#getBase_Element <em>Base Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Element</em>'.
	 * @see org.eclipse.papyrus.FCM.DerivedElement#getBase_Element()
	 * @see #getDerivedElement()
	 * @generated
	 */
	EReference getDerivedElement_Base_Element();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.DerivedElement#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.papyrus.FCM.DerivedElement#getSource()
	 * @see #getDerivedElement()
	 * @generated
	 */
	EReference getDerivedElement_Source();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.CppLibrary <em>Cpp Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Cpp Library</em>'.
	 * @see org.eclipse.papyrus.FCM.CppLibrary
	 * @generated
	 */
	EClass getCppLibrary();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.FCM.CppLibrary#getMacros <em>Macros</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Macros</em>'.
	 * @see org.eclipse.papyrus.FCM.CppLibrary#getMacros()
	 * @see #getCppLibrary()
	 * @generated
	 */
	EAttribute getCppLibrary_Macros();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.FCM.CppLibrary#getLibs <em>Libs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Libs</em>'.
	 * @see org.eclipse.papyrus.FCM.CppLibrary#getLibs()
	 * @see #getCppLibrary()
	 * @generated
	 */
	EAttribute getCppLibrary_Libs();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.FCM.CppLibrary#getLibPaths <em>Lib Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Lib Paths</em>'.
	 * @see org.eclipse.papyrus.FCM.CppLibrary#getLibPaths()
	 * @see #getCppLibrary()
	 * @generated
	 */
	EAttribute getCppLibrary_LibPaths();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.FCM.CppLibrary#getIncludePaths <em>Include Paths</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Include Paths</em>'.
	 * @see org.eclipse.papyrus.FCM.CppLibrary#getIncludePaths()
	 * @see #getCppLibrary()
	 * @generated
	 */
	EAttribute getCppLibrary_IncludePaths();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.ExternalLibrary <em>External Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Library</em>'.
	 * @see org.eclipse.papyrus.FCM.ExternalLibrary
	 * @generated
	 */
	EClass getExternalLibrary();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ExternalLibrary#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.FCM.ExternalLibrary#getBase_Package()
	 * @see #getExternalLibrary()
	 * @generated
	 */
	EReference getExternalLibrary_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.ImplementationGroup <em>Implementation Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation Group</em>'.
	 * @see org.eclipse.papyrus.FCM.ImplementationGroup
	 * @generated
	 */
	EClass getImplementationGroup();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ImplementationGroup#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.ImplementationGroup#getBase_Class()
	 * @see #getImplementationGroup()
	 * @generated
	 */
	EReference getImplementationGroup_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.RuleApplication <em>Rule Application</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Application</em>'.
	 * @see org.eclipse.papyrus.FCM.RuleApplication
	 * @generated
	 */
	EClass getRuleApplication();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.RuleApplication#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.RuleApplication#getBase_Class()
	 * @see #getRuleApplication()
	 * @generated
	 */
	EReference getRuleApplication_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.FCM.RuleApplication#getContainerRule <em>Container Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Container Rule</em>'.
	 * @see org.eclipse.papyrus.FCM.RuleApplication#getContainerRule()
	 * @see #getRuleApplication()
	 * @generated
	 */
	EReference getRuleApplication_ContainerRule();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.RuleApplication#getBase_Package <em>Base Package</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Package</em>'.
	 * @see org.eclipse.papyrus.FCM.RuleApplication#getBase_Package()
	 * @see #getRuleApplication()
	 * @generated
	 */
	EReference getRuleApplication_Base_Package();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.JavaLibrary <em>Java Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Java Library</em>'.
	 * @see org.eclipse.papyrus.FCM.JavaLibrary
	 * @generated
	 */
	EClass getJavaLibrary();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.papyrus.FCM.JavaLibrary#getClassPath <em>Class Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Class Path</em>'.
	 * @see org.eclipse.papyrus.FCM.JavaLibrary#getClassPath()
	 * @see #getJavaLibrary()
	 * @generated
	 */
	EAttribute getJavaLibrary_ClassPath();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.ImplementationProperties <em>Implementation Properties</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implementation Properties</em>'.
	 * @see org.eclipse.papyrus.FCM.ImplementationProperties
	 * @generated
	 */
	EClass getImplementationProperties();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.FCM.ImplementationProperties#getSizeRAM <em>Size RAM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size RAM</em>'.
	 * @see org.eclipse.papyrus.FCM.ImplementationProperties#getSizeRAM()
	 * @see #getImplementationProperties()
	 * @generated
	 */
	EAttribute getImplementationProperties_SizeRAM();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.FCM.ImplementationProperties#getSupportedOS <em>Supported OS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Supported OS</em>'.
	 * @see org.eclipse.papyrus.FCM.ImplementationProperties#getSupportedOS()
	 * @see #getImplementationProperties()
	 * @generated
	 */
	EReference getImplementationProperties_SupportedOS();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.FCM.ImplementationProperties#getArch <em>Arch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arch</em>'.
	 * @see org.eclipse.papyrus.FCM.ImplementationProperties#getArch()
	 * @see #getImplementationProperties()
	 * @generated
	 */
	EReference getImplementationProperties_Arch();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ImplementationProperties#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.ImplementationProperties#getBase_Class()
	 * @see #getImplementationProperties()
	 * @generated
	 */
	EReference getImplementationProperties_Base_Class();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.FCM.ImplementationProperties#getSizeROM <em>Size ROM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size ROM</em>'.
	 * @see org.eclipse.papyrus.FCM.ImplementationProperties#getSizeROM()
	 * @see #getImplementationProperties()
	 * @generated
	 */
	EAttribute getImplementationProperties_SizeROM();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ImplementationProperties#getSupportedTargetArch <em>Supported Target Arch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Supported Target Arch</em>'.
	 * @see org.eclipse.papyrus.FCM.ImplementationProperties#getSupportedTargetArch()
	 * @see #getImplementationProperties()
	 * @generated
	 */
	EReference getImplementationProperties_SupportedTargetArch();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.OperatingSystem <em>Operating System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operating System</em>'.
	 * @see org.eclipse.papyrus.FCM.OperatingSystem
	 * @generated
	 */
	EClass getOperatingSystem();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.OperatingSystem#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.OperatingSystem#getBase_Class()
	 * @see #getOperatingSystem()
	 * @generated
	 */
	EReference getOperatingSystem_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.TargetArchitecture <em>Target Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target Architecture</em>'.
	 * @see org.eclipse.papyrus.FCM.TargetArchitecture
	 * @generated
	 */
	EClass getTargetArchitecture();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.TargetArchitecture#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.TargetArchitecture#getBase_Class()
	 * @see #getTargetArchitecture()
	 * @generated
	 */
	EReference getTargetArchitecture_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.Target <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Target</em>'.
	 * @see org.eclipse.papyrus.FCM.Target
	 * @generated
	 */
	EClass getTarget();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Target#getTargetArch <em>Target Arch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target Arch</em>'.
	 * @see org.eclipse.papyrus.FCM.Target#getTargetArch()
	 * @see #getTarget()
	 * @generated
	 */
	EReference getTarget_TargetArch();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.FCM.Target#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Options</em>'.
	 * @see org.eclipse.papyrus.FCM.Target#getOptions()
	 * @see #getTarget()
	 * @generated
	 */
	EReference getTarget_Options();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Target#getBase_Node <em>Base Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Node</em>'.
	 * @see org.eclipse.papyrus.FCM.Target#getBase_Node()
	 * @see #getTarget()
	 * @generated
	 */
	EReference getTarget_Base_Node();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Target#getUsedOS <em>Used OS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Used OS</em>'.
	 * @see org.eclipse.papyrus.FCM.Target#getUsedOS()
	 * @see #getTarget()
	 * @generated
	 */
	EReference getTarget_UsedOS();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.FCM.Target#getAvailRAM <em>Avail RAM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Avail RAM</em>'.
	 * @see org.eclipse.papyrus.FCM.Target#getAvailRAM()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_AvailRAM();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.FCM.Target#getAvailROM <em>Avail ROM</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Avail ROM</em>'.
	 * @see org.eclipse.papyrus.FCM.Target#getAvailROM()
	 * @see #getTarget()
	 * @generated
	 */
	EAttribute getTarget_AvailROM();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.Part <em>Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Part</em>'.
	 * @see org.eclipse.papyrus.FCM.Part
	 * @generated
	 */
	EClass getPart();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Part#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.FCM.Part#getBase_Property()
	 * @see #getPart()
	 * @generated
	 */
	EReference getPart_Base_Property();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.FCM.Part#getColocateWithPort <em>Colocate With Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Colocate With Port</em>'.
	 * @see org.eclipse.papyrus.FCM.Part#getColocateWithPort()
	 * @see #getPart()
	 * @generated
	 */
	EReference getPart_ColocateWithPort();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.CopyAttributeValue <em>Copy Attribute Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Copy Attribute Value</em>'.
	 * @see org.eclipse.papyrus.FCM.CopyAttributeValue
	 * @generated
	 */
	EClass getCopyAttributeValue();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.CopyAttributeValue#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see org.eclipse.papyrus.FCM.CopyAttributeValue#getSource()
	 * @see #getCopyAttributeValue()
	 * @generated
	 */
	EReference getCopyAttributeValue_Source();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.CopyAttributeValue#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.FCM.CopyAttributeValue#getBase_Property()
	 * @see #getCopyAttributeValue()
	 * @generated
	 */
	EReference getCopyAttributeValue_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.AutoIndex <em>Auto Index</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Auto Index</em>'.
	 * @see org.eclipse.papyrus.FCM.AutoIndex
	 * @generated
	 */
	EClass getAutoIndex();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.AutoIndex#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.FCM.AutoIndex#getBase_Property()
	 * @see #getAutoIndex()
	 * @generated
	 */
	EReference getAutoIndex_Base_Property();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.AutoIndexPerNode <em>Auto Index Per Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Auto Index Per Node</em>'.
	 * @see org.eclipse.papyrus.FCM.AutoIndexPerNode
	 * @generated
	 */
	EClass getAutoIndexPerNode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.InitPrecedence <em>Init Precedence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Init Precedence</em>'.
	 * @see org.eclipse.papyrus.FCM.InitPrecedence
	 * @generated
	 */
	EClass getInitPrecedence();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.FCM.InitPrecedence#getInvokeAfter <em>Invoke After</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Invoke After</em>'.
	 * @see org.eclipse.papyrus.FCM.InitPrecedence#getInvokeAfter()
	 * @see #getInitPrecedence()
	 * @generated
	 */
	EReference getInitPrecedence_InvokeAfter();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.FCM.InitPrecedence#getInvokeBefore <em>Invoke Before</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Invoke Before</em>'.
	 * @see org.eclipse.papyrus.FCM.InitPrecedence#getInvokeBefore()
	 * @see #getInitPrecedence()
	 * @generated
	 */
	EReference getInitPrecedence_InvokeBefore();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.InitPrecedence#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.InitPrecedence#getBase_Class()
	 * @see #getInitPrecedence()
	 * @generated
	 */
	EReference getInitPrecedence_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.ConnectorConfiguration <em>Connector Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Connector Configuration</em>'.
	 * @see org.eclipse.papyrus.FCM.ConnectorConfiguration
	 * @generated
	 */
	EClass getConnectorConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ConnectorConfiguration#getBase_Slot <em>Base Slot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Slot</em>'.
	 * @see org.eclipse.papyrus.FCM.ConnectorConfiguration#getBase_Slot()
	 * @see #getConnectorConfiguration()
	 * @generated
	 */
	EReference getConnectorConfiguration_Base_Slot();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ConnectorConfiguration#getConnector <em>Connector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Connector</em>'.
	 * @see org.eclipse.papyrus.FCM.ConnectorConfiguration#getConnector()
	 * @see #getConnectorConfiguration()
	 * @generated
	 */
	EReference getConnectorConfiguration_Connector();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.ExtendedSignature <em>Extended Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Extended Signature</em>'.
	 * @see org.eclipse.papyrus.FCM.ExtendedSignature
	 * @generated
	 */
	EClass getExtendedSignature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ExtendedSignature#getBase_TemplateSignature <em>Base Template Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Template Signature</em>'.
	 * @see org.eclipse.papyrus.FCM.ExtendedSignature#getBase_TemplateSignature()
	 * @see #getExtendedSignature()
	 * @generated
	 */
	EReference getExtendedSignature_Base_TemplateSignature();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.ExtendedSignature#getBaseSignature <em>Base Signature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Signature</em>'.
	 * @see org.eclipse.papyrus.FCM.ExtendedSignature#getBaseSignature()
	 * @see #getExtendedSignature()
	 * @generated
	 */
	EReference getExtendedSignature_BaseSignature();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.ContainerPort <em>Container Port</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Container Port</em>'.
	 * @see org.eclipse.papyrus.FCM.ContainerPort
	 * @generated
	 */
	EClass getContainerPort();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.UseInstanceConfigurator <em>Use Instance Configurator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Instance Configurator</em>'.
	 * @see org.eclipse.papyrus.FCM.UseInstanceConfigurator
	 * @generated
	 */
	EClass getUseInstanceConfigurator();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.UseInstanceConfigurator#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.UseInstanceConfigurator#getBase_Class()
	 * @see #getUseInstanceConfigurator()
	 * @generated
	 */
	EReference getUseInstanceConfigurator_Base_Class();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.UseInstanceConfigurator#getConfigurator <em>Configurator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Configurator</em>'.
	 * @see org.eclipse.papyrus.FCM.UseInstanceConfigurator#getConfigurator()
	 * @see #getUseInstanceConfigurator()
	 * @generated
	 */
	EReference getUseInstanceConfigurator_Configurator();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.InstanceConfigurator <em>Instance Configurator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance Configurator</em>'.
	 * @see org.eclipse.papyrus.FCM.InstanceConfigurator
	 * @generated
	 */
	EClass getInstanceConfigurator();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.InstanceConfigurator#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.InstanceConfigurator#getBase_Class()
	 * @see #getInstanceConfigurator()
	 * @generated
	 */
	EReference getInstanceConfigurator_Base_Class();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.papyrus.FCM.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Configuration#getBase_Class <em>Base Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Class</em>'.
	 * @see org.eclipse.papyrus.FCM.Configuration#getBase_Class()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_Base_Class();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.FCM.Configuration#getConfigOptions <em>Config Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Config Options</em>'.
	 * @see org.eclipse.papyrus.FCM.Configuration#getConfigOptions()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_ConfigOptions();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.Configuration#getDeploymentPlan <em>Deployment Plan</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Deployment Plan</em>'.
	 * @see org.eclipse.papyrus.FCM.Configuration#getDeploymentPlan()
	 * @see #getConfiguration()
	 * @generated
	 */
	EReference getConfiguration_DeploymentPlan();

	/**
	 * Returns the meta object for class '{@link org.eclipse.papyrus.FCM.InterceptionRule <em>Interception Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interception Rule</em>'.
	 * @see org.eclipse.papyrus.FCM.InterceptionRule
	 * @generated
	 */
	EClass getInterceptionRule();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.papyrus.FCM.InterceptionRule#getInterceptionKind <em>Interception Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Interception Kind</em>'.
	 * @see org.eclipse.papyrus.FCM.InterceptionRule#getInterceptionKind()
	 * @see #getInterceptionRule()
	 * @generated
	 */
	EAttribute getInterceptionRule_InterceptionKind();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.papyrus.FCM.InterceptionRule#getInterceptionSet <em>Interception Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Interception Set</em>'.
	 * @see org.eclipse.papyrus.FCM.InterceptionRule#getInterceptionSet()
	 * @see #getInterceptionRule()
	 * @generated
	 */
	EReference getInterceptionRule_InterceptionSet();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.InterceptionRule#getBase_Property <em>Base Property</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Property</em>'.
	 * @see org.eclipse.papyrus.FCM.InterceptionRule#getBase_Property()
	 * @see #getInterceptionRule()
	 * @generated
	 */
	EReference getInterceptionRule_Base_Property();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.papyrus.FCM.InterceptionRule#getBase_Operation <em>Base Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Base Operation</em>'.
	 * @see org.eclipse.papyrus.FCM.InterceptionRule#getBase_Operation()
	 * @see #getInterceptionRule()
	 * @generated
	 */
	EReference getInterceptionRule_Base_Operation();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.FCM.TemplateKind <em>Template Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Template Kind</em>'.
	 * @see org.eclipse.papyrus.FCM.TemplateKind
	 * @generated
	 */
	EEnum getTemplateKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.FCM.ActualChoice <em>Actual Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Actual Choice</em>'.
	 * @see org.eclipse.papyrus.FCM.ActualChoice
	 * @generated
	 */
	EEnum getActualChoice();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.FCM.ContainerRuleKind <em>Container Rule Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Container Rule Kind</em>'.
	 * @see org.eclipse.papyrus.FCM.ContainerRuleKind
	 * @generated
	 */
	EEnum getContainerRuleKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.papyrus.FCM.InterceptionKind <em>Interception Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Interception Kind</em>'.
	 * @see org.eclipse.papyrus.FCM.InterceptionKind
	 * @generated
	 */
	EEnum getInterceptionKind();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	FCMFactory getFCMFactory();

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
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.TemplateImpl <em>Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.TemplateImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getTemplate()
		 * @generated
		 */
		EClass TEMPLATE = eINSTANCE.getTemplate();

		/**
		 * The meta object literal for the '<em><b>Template Params</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__TEMPLATE_PARAMS = eINSTANCE.getTemplate_TemplateParams();

		/**
		 * The meta object literal for the '<em><b>Base Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEMPLATE__BASE_ELEMENT = eINSTANCE.getTemplate_Base_Element();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE__KIND = eINSTANCE.getTemplate_Kind();

		/**
		 * The meta object literal for the '<em><b>Actual Choice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEMPLATE__ACTUAL_CHOICE = eINSTANCE.getTemplate_ActualChoice();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ContainerRuleImpl <em>Container Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ContainerRuleImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getContainerRule()
		 * @generated
		 */
		EClass CONTAINER_RULE = eINSTANCE.getContainerRule();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_RULE__BASE_CLASS = eINSTANCE.getContainerRule_Base_Class();

		/**
		 * The meta object literal for the '<em><b>For Config</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTAINER_RULE__FOR_CONFIG = eINSTANCE.getContainerRule_ForConfig();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTAINER_RULE__KIND = eINSTANCE.getContainerRule_Kind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.PortImpl <em>Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.PortImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getPort()
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
		 * The meta object literal for the '<em><b>Kind</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__KIND = eINSTANCE.getPort_Kind();

		/**
		 * The meta object literal for the '<em><b>Provided Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__PROVIDED_INTERFACE = eINSTANCE.getPort_ProvidedInterface();

		/**
		 * The meta object literal for the '<em><b>Required Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT__REQUIRED_INTERFACE = eINSTANCE.getPort_RequiredInterface();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ConfigurableElementInstanceImpl <em>Configurable Element Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ConfigurableElementInstanceImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConfigurableElementInstance()
		 * @generated
		 */
		EClass CONFIGURABLE_ELEMENT_INSTANCE = eINSTANCE.getConfigurableElementInstance();

		/**
		 * The meta object literal for the '<em><b>Configuration</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURABLE_ELEMENT_INSTANCE__CONFIGURATION = eINSTANCE.getConfigurableElementInstance_Configuration();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.PortKindImpl <em>Port Kind</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.PortKindImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getPortKind()
		 * @generated
		 */
		EClass PORT_KIND = eINSTANCE.getPortKind();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_KIND__BASE_CLASS = eINSTANCE.getPortKind_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Provided Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_KIND__PROVIDED_INTERFACE = eINSTANCE.getPortKind_ProvidedInterface();

		/**
		 * The meta object literal for the '<em><b>Required Interface</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PORT_KIND__REQUIRED_INTERFACE = eINSTANCE.getPortKind_RequiredInterface();

		/**
		 * The meta object literal for the '<em><b>Extended Port</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PORT_KIND__EXTENDED_PORT = eINSTANCE.getPortKind_ExtendedPort();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.CompImplTemplateImpl <em>Comp Impl Template</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.CompImplTemplateImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getCompImplTemplate()
		 * @generated
		 */
		EClass COMP_IMPL_TEMPLATE = eINSTANCE.getCompImplTemplate();

		/**
		 * The meta object literal for the '<em><b>Template Defs</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMP_IMPL_TEMPLATE__TEMPLATE_DEFS = eINSTANCE.getCompImplTemplate_TemplateDefs();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMP_IMPL_TEMPLATE__BASE_CLASS = eINSTANCE.getCompImplTemplate_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ConfigOptionImpl <em>Config Option</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ConfigOptionImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConfigOption()
		 * @generated
		 */
		EClass CONFIG_OPTION = eINSTANCE.getConfigOption();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIG_OPTION__BASE_CLASS = eINSTANCE.getConfigOption_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.SingletonImpl <em>Singleton</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.SingletonImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getSingleton()
		 * @generated
		 */
		EClass SINGLETON = eINSTANCE.getSingleton();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SINGLETON__BASE_CLASS = eINSTANCE.getSingleton_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.InteractionComponentImpl <em>Interaction Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.InteractionComponentImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getInteractionComponent()
		 * @generated
		 */
		EClass INTERACTION_COMPONENT = eINSTANCE.getInteractionComponent();

		/**
		 * The meta object literal for the '<em><b>For Distribution</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERACTION_COMPONENT__FOR_DISTRIBUTION = eINSTANCE.getInteractionComponent_ForDistribution();

		/**
		 * The meta object literal for the '<em><b>Connection Pattern</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION_COMPONENT__CONNECTION_PATTERN = eINSTANCE.getInteractionComponent_ConnectionPattern();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERACTION_COMPONENT__BASE_CLASS = eINSTANCE.getInteractionComponent_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ConnectorImpl <em>Connector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ConnectorImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConnector()
		 * @generated
		 */
		EClass CONNECTOR = eINSTANCE.getConnector();

		/**
		 * The meta object literal for the '<em><b>Base Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__BASE_CONNECTOR = eINSTANCE.getConnector_Base_Connector();

		/**
		 * The meta object literal for the '<em><b>Ic</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__IC = eINSTANCE.getConnector_Ic();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR__BASE_PROPERTY = eINSTANCE.getConnector_Base_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ConfigurationPropertyImpl <em>Configuration Property</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ConfigurationPropertyImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConfigurationProperty()
		 * @generated
		 */
		EClass CONFIGURATION_PROPERTY = eINSTANCE.getConfigurationProperty();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION_PROPERTY__BASE_PROPERTY = eINSTANCE.getConfigurationProperty_Base_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.DeploymentPlanImpl <em>Deployment Plan</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.DeploymentPlanImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getDeploymentPlan()
		 * @generated
		 */
		EClass DEPLOYMENT_PLAN = eINSTANCE.getDeploymentPlan();

		/**
		 * The meta object literal for the '<em><b>Main Instance</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PLAN__MAIN_INSTANCE = eINSTANCE.getDeploymentPlan_MainInstance();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPLOYMENT_PLAN__BASE_PACKAGE = eINSTANCE.getDeploymentPlan_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.DerivedElementImpl <em>Derived Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.DerivedElementImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getDerivedElement()
		 * @generated
		 */
		EClass DERIVED_ELEMENT = eINSTANCE.getDerivedElement();

		/**
		 * The meta object literal for the '<em><b>Base Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVED_ELEMENT__BASE_ELEMENT = eINSTANCE.getDerivedElement_Base_Element();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVED_ELEMENT__SOURCE = eINSTANCE.getDerivedElement_Source();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.CppLibraryImpl <em>Cpp Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.CppLibraryImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getCppLibrary()
		 * @generated
		 */
		EClass CPP_LIBRARY = eINSTANCE.getCppLibrary();

		/**
		 * The meta object literal for the '<em><b>Macros</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_LIBRARY__MACROS = eINSTANCE.getCppLibrary_Macros();

		/**
		 * The meta object literal for the '<em><b>Libs</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_LIBRARY__LIBS = eINSTANCE.getCppLibrary_Libs();

		/**
		 * The meta object literal for the '<em><b>Lib Paths</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_LIBRARY__LIB_PATHS = eINSTANCE.getCppLibrary_LibPaths();

		/**
		 * The meta object literal for the '<em><b>Include Paths</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPP_LIBRARY__INCLUDE_PATHS = eINSTANCE.getCppLibrary_IncludePaths();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ExternalLibraryImpl <em>External Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ExternalLibraryImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getExternalLibrary()
		 * @generated
		 */
		EClass EXTERNAL_LIBRARY = eINSTANCE.getExternalLibrary();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_LIBRARY__BASE_PACKAGE = eINSTANCE.getExternalLibrary_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ImplementationGroupImpl <em>Implementation Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ImplementationGroupImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getImplementationGroup()
		 * @generated
		 */
		EClass IMPLEMENTATION_GROUP = eINSTANCE.getImplementationGroup();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_GROUP__BASE_CLASS = eINSTANCE.getImplementationGroup_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.RuleApplicationImpl <em>Rule Application</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.RuleApplicationImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getRuleApplication()
		 * @generated
		 */
		EClass RULE_APPLICATION = eINSTANCE.getRuleApplication();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_APPLICATION__BASE_CLASS = eINSTANCE.getRuleApplication_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Container Rule</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_APPLICATION__CONTAINER_RULE = eINSTANCE.getRuleApplication_ContainerRule();

		/**
		 * The meta object literal for the '<em><b>Base Package</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RULE_APPLICATION__BASE_PACKAGE = eINSTANCE.getRuleApplication_Base_Package();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.JavaLibraryImpl <em>Java Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.JavaLibraryImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getJavaLibrary()
		 * @generated
		 */
		EClass JAVA_LIBRARY = eINSTANCE.getJavaLibrary();

		/**
		 * The meta object literal for the '<em><b>Class Path</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute JAVA_LIBRARY__CLASS_PATH = eINSTANCE.getJavaLibrary_ClassPath();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ImplementationPropertiesImpl <em>Implementation Properties</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ImplementationPropertiesImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getImplementationProperties()
		 * @generated
		 */
		EClass IMPLEMENTATION_PROPERTIES = eINSTANCE.getImplementationProperties();

		/**
		 * The meta object literal for the '<em><b>Size RAM</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPLEMENTATION_PROPERTIES__SIZE_RAM = eINSTANCE.getImplementationProperties_SizeRAM();

		/**
		 * The meta object literal for the '<em><b>Supported OS</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_PROPERTIES__SUPPORTED_OS = eINSTANCE.getImplementationProperties_SupportedOS();

		/**
		 * The meta object literal for the '<em><b>Arch</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_PROPERTIES__ARCH = eINSTANCE.getImplementationProperties_Arch();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_PROPERTIES__BASE_CLASS = eINSTANCE.getImplementationProperties_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Size ROM</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPLEMENTATION_PROPERTIES__SIZE_ROM = eINSTANCE.getImplementationProperties_SizeROM();

		/**
		 * The meta object literal for the '<em><b>Supported Target Arch</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLEMENTATION_PROPERTIES__SUPPORTED_TARGET_ARCH = eINSTANCE.getImplementationProperties_SupportedTargetArch();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.OperatingSystemImpl <em>Operating System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.OperatingSystemImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getOperatingSystem()
		 * @generated
		 */
		EClass OPERATING_SYSTEM = eINSTANCE.getOperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OPERATING_SYSTEM__BASE_CLASS = eINSTANCE.getOperatingSystem_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.TargetArchitectureImpl <em>Target Architecture</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.TargetArchitectureImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getTargetArchitecture()
		 * @generated
		 */
		EClass TARGET_ARCHITECTURE = eINSTANCE.getTargetArchitecture();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET_ARCHITECTURE__BASE_CLASS = eINSTANCE.getTargetArchitecture_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.TargetImpl <em>Target</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.TargetImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getTarget()
		 * @generated
		 */
		EClass TARGET = eINSTANCE.getTarget();

		/**
		 * The meta object literal for the '<em><b>Target Arch</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET__TARGET_ARCH = eINSTANCE.getTarget_TargetArch();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET__OPTIONS = eINSTANCE.getTarget_Options();

		/**
		 * The meta object literal for the '<em><b>Base Node</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET__BASE_NODE = eINSTANCE.getTarget_Base_Node();

		/**
		 * The meta object literal for the '<em><b>Used OS</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TARGET__USED_OS = eINSTANCE.getTarget_UsedOS();

		/**
		 * The meta object literal for the '<em><b>Avail RAM</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__AVAIL_RAM = eINSTANCE.getTarget_AvailRAM();

		/**
		 * The meta object literal for the '<em><b>Avail ROM</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TARGET__AVAIL_ROM = eINSTANCE.getTarget_AvailROM();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.PartImpl <em>Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.PartImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getPart()
		 * @generated
		 */
		EClass PART = eINSTANCE.getPart();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART__BASE_PROPERTY = eINSTANCE.getPart_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Colocate With Port</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PART__COLOCATE_WITH_PORT = eINSTANCE.getPart_ColocateWithPort();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.CopyAttributeValueImpl <em>Copy Attribute Value</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.CopyAttributeValueImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getCopyAttributeValue()
		 * @generated
		 */
		EClass COPY_ATTRIBUTE_VALUE = eINSTANCE.getCopyAttributeValue();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COPY_ATTRIBUTE_VALUE__SOURCE = eINSTANCE.getCopyAttributeValue_Source();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COPY_ATTRIBUTE_VALUE__BASE_PROPERTY = eINSTANCE.getCopyAttributeValue_Base_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.AutoIndexImpl <em>Auto Index</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.AutoIndexImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getAutoIndex()
		 * @generated
		 */
		EClass AUTO_INDEX = eINSTANCE.getAutoIndex();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AUTO_INDEX__BASE_PROPERTY = eINSTANCE.getAutoIndex_Base_Property();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.AutoIndexPerNodeImpl <em>Auto Index Per Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.AutoIndexPerNodeImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getAutoIndexPerNode()
		 * @generated
		 */
		EClass AUTO_INDEX_PER_NODE = eINSTANCE.getAutoIndexPerNode();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.InitPrecedenceImpl <em>Init Precedence</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.InitPrecedenceImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getInitPrecedence()
		 * @generated
		 */
		EClass INIT_PRECEDENCE = eINSTANCE.getInitPrecedence();

		/**
		 * The meta object literal for the '<em><b>Invoke After</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INIT_PRECEDENCE__INVOKE_AFTER = eINSTANCE.getInitPrecedence_InvokeAfter();

		/**
		 * The meta object literal for the '<em><b>Invoke Before</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INIT_PRECEDENCE__INVOKE_BEFORE = eINSTANCE.getInitPrecedence_InvokeBefore();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INIT_PRECEDENCE__BASE_CLASS = eINSTANCE.getInitPrecedence_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ConnectorConfigurationImpl <em>Connector Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ConnectorConfigurationImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConnectorConfiguration()
		 * @generated
		 */
		EClass CONNECTOR_CONFIGURATION = eINSTANCE.getConnectorConfiguration();

		/**
		 * The meta object literal for the '<em><b>Base Slot</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_CONFIGURATION__BASE_SLOT = eINSTANCE.getConnectorConfiguration_Base_Slot();

		/**
		 * The meta object literal for the '<em><b>Connector</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONNECTOR_CONFIGURATION__CONNECTOR = eINSTANCE.getConnectorConfiguration_Connector();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ExtendedSignatureImpl <em>Extended Signature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ExtendedSignatureImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getExtendedSignature()
		 * @generated
		 */
		EClass EXTENDED_SIGNATURE = eINSTANCE.getExtendedSignature();

		/**
		 * The meta object literal for the '<em><b>Base Template Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_SIGNATURE__BASE_TEMPLATE_SIGNATURE = eINSTANCE.getExtendedSignature_Base_TemplateSignature();

		/**
		 * The meta object literal for the '<em><b>Base Signature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTENDED_SIGNATURE__BASE_SIGNATURE = eINSTANCE.getExtendedSignature_BaseSignature();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ContainerPortImpl <em>Container Port</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ContainerPortImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getContainerPort()
		 * @generated
		 */
		EClass CONTAINER_PORT = eINSTANCE.getContainerPort();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.UseInstanceConfiguratorImpl <em>Use Instance Configurator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.UseInstanceConfiguratorImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getUseInstanceConfigurator()
		 * @generated
		 */
		EClass USE_INSTANCE_CONFIGURATOR = eINSTANCE.getUseInstanceConfigurator();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_INSTANCE_CONFIGURATOR__BASE_CLASS = eINSTANCE.getUseInstanceConfigurator_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Configurator</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_INSTANCE_CONFIGURATOR__CONFIGURATOR = eINSTANCE.getUseInstanceConfigurator_Configurator();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.InstanceConfiguratorImpl <em>Instance Configurator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.InstanceConfiguratorImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getInstanceConfigurator()
		 * @generated
		 */
		EClass INSTANCE_CONFIGURATOR = eINSTANCE.getInstanceConfigurator();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE_CONFIGURATOR__BASE_CLASS = eINSTANCE.getInstanceConfigurator_Base_Class();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.ConfigurationImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Base Class</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__BASE_CLASS = eINSTANCE.getConfiguration_Base_Class();

		/**
		 * The meta object literal for the '<em><b>Config Options</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__CONFIG_OPTIONS = eINSTANCE.getConfiguration_ConfigOptions();

		/**
		 * The meta object literal for the '<em><b>Deployment Plan</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONFIGURATION__DEPLOYMENT_PLAN = eINSTANCE.getConfiguration_DeploymentPlan();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.impl.InterceptionRuleImpl <em>Interception Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.impl.InterceptionRuleImpl
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getInterceptionRule()
		 * @generated
		 */
		EClass INTERCEPTION_RULE = eINSTANCE.getInterceptionRule();

		/**
		 * The meta object literal for the '<em><b>Interception Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERCEPTION_RULE__INTERCEPTION_KIND = eINSTANCE.getInterceptionRule_InterceptionKind();

		/**
		 * The meta object literal for the '<em><b>Interception Set</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERCEPTION_RULE__INTERCEPTION_SET = eINSTANCE.getInterceptionRule_InterceptionSet();

		/**
		 * The meta object literal for the '<em><b>Base Property</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERCEPTION_RULE__BASE_PROPERTY = eINSTANCE.getInterceptionRule_Base_Property();

		/**
		 * The meta object literal for the '<em><b>Base Operation</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERCEPTION_RULE__BASE_OPERATION = eINSTANCE.getInterceptionRule_Base_Operation();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.TemplateKind <em>Template Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.TemplateKind
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getTemplateKind()
		 * @generated
		 */
		EEnum TEMPLATE_KIND = eINSTANCE.getTemplateKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.ActualChoice <em>Actual Choice</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.ActualChoice
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getActualChoice()
		 * @generated
		 */
		EEnum ACTUAL_CHOICE = eINSTANCE.getActualChoice();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.ContainerRuleKind <em>Container Rule Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.ContainerRuleKind
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getContainerRuleKind()
		 * @generated
		 */
		EEnum CONTAINER_RULE_KIND = eINSTANCE.getContainerRuleKind();

		/**
		 * The meta object literal for the '{@link org.eclipse.papyrus.FCM.InterceptionKind <em>Interception Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.papyrus.FCM.InterceptionKind
		 * @see org.eclipse.papyrus.FCM.impl.FCMPackageImpl#getInterceptionKind()
		 * @generated
		 */
		EEnum INTERCEPTION_KIND = eINSTANCE.getInterceptionKind();

	}

} //FCMPackage
