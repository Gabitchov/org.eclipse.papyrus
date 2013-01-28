/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package FCM;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see FCM.FCMPackage
 * @generated
 */
public interface FCMFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	FCMFactory eINSTANCE = FCM.impl.FCMFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Template</em>'.
	 * @generated
	 */
	Template createTemplate();

	/**
	 * Returns a new object of class '<em>Container Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container Rule</em>'.
	 * @generated
	 */
	ContainerRule createContainerRule();

	/**
	 * Returns a new object of class '<em>Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port</em>'.
	 * @generated
	 */
	Port createPort();

	/**
	 * Returns a new object of class '<em>Port Kind</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Port Kind</em>'.
	 * @generated
	 */
	PortKind createPortKind();

	/**
	 * Returns a new object of class '<em>Comp Impl Template</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comp Impl Template</em>'.
	 * @generated
	 */
	CompImplTemplate createCompImplTemplate();

	/**
	 * Returns a new object of class '<em>Config Option</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Config Option</em>'.
	 * @generated
	 */
	ConfigOption createConfigOption();

	/**
	 * Returns a new object of class '<em>Singleton</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Singleton</em>'.
	 * @generated
	 */
	Singleton createSingleton();

	/**
	 * Returns a new object of class '<em>Interaction Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interaction Component</em>'.
	 * @generated
	 */
	InteractionComponent createInteractionComponent();

	/**
	 * Returns a new object of class '<em>Connector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector</em>'.
	 * @generated
	 */
	Connector createConnector();

	/**
	 * Returns a new object of class '<em>Configuration Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration Property</em>'.
	 * @generated
	 */
	ConfigurationProperty createConfigurationProperty();

	/**
	 * Returns a new object of class '<em>Deployment Plan</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment Plan</em>'.
	 * @generated
	 */
	DeploymentPlan createDeploymentPlan();

	/**
	 * Returns a new object of class '<em>Derived Element</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Derived Element</em>'.
	 * @generated
	 */
	DerivedElement createDerivedElement();

	/**
	 * Returns a new object of class '<em>Cpp Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cpp Library</em>'.
	 * @generated
	 */
	CppLibrary createCppLibrary();

	/**
	 * Returns a new object of class '<em>External Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Library</em>'.
	 * @generated
	 */
	ExternalLibrary createExternalLibrary();

	/**
	 * Returns a new object of class '<em>Implementation Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implementation Group</em>'.
	 * @generated
	 */
	ImplementationGroup createImplementationGroup();

	/**
	 * Returns a new object of class '<em>Rule Application</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Rule Application</em>'.
	 * @generated
	 */
	RuleApplication createRuleApplication();

	/**
	 * Returns a new object of class '<em>Java Library</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Java Library</em>'.
	 * @generated
	 */
	JavaLibrary createJavaLibrary();

	/**
	 * Returns a new object of class '<em>Implementation Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implementation Properties</em>'.
	 * @generated
	 */
	ImplementationProperties createImplementationProperties();

	/**
	 * Returns a new object of class '<em>Operating System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operating System</em>'.
	 * @generated
	 */
	OperatingSystem createOperatingSystem();

	/**
	 * Returns a new object of class '<em>Target Architecture</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Architecture</em>'.
	 * @generated
	 */
	TargetArchitecture createTargetArchitecture();

	/**
	 * Returns a new object of class '<em>Target</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target</em>'.
	 * @generated
	 */
	Target createTarget();

	/**
	 * Returns a new object of class '<em>Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Part</em>'.
	 * @generated
	 */
	Part createPart();

	/**
	 * Returns a new object of class '<em>Copy Attribute Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Copy Attribute Value</em>'.
	 * @generated
	 */
	CopyAttributeValue createCopyAttributeValue();

	/**
	 * Returns a new object of class '<em>Auto Index</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Auto Index</em>'.
	 * @generated
	 */
	AutoIndex createAutoIndex();

	/**
	 * Returns a new object of class '<em>Auto Index Per Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Auto Index Per Node</em>'.
	 * @generated
	 */
	AutoIndexPerNode createAutoIndexPerNode();

	/**
	 * Returns a new object of class '<em>Init Precedence</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Init Precedence</em>'.
	 * @generated
	 */
	InitPrecedence createInitPrecedence();

	/**
	 * Returns a new object of class '<em>Connector Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Configuration</em>'.
	 * @generated
	 */
	ConnectorConfiguration createConnectorConfiguration();

	/**
	 * Returns a new object of class '<em>Extended Signature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Extended Signature</em>'.
	 * @generated
	 */
	ExtendedSignature createExtendedSignature();

	/**
	 * Returns a new object of class '<em>Container Port</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Container Port</em>'.
	 * @generated
	 */
	ContainerPort createContainerPort();

	/**
	 * Returns a new object of class '<em>Use Instance Configurator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Use Instance Configurator</em>'.
	 * @generated
	 */
	UseInstanceConfigurator createUseInstanceConfigurator();

	/**
	 * Returns a new object of class '<em>Instance Configurator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Instance Configurator</em>'.
	 * @generated
	 */
	InstanceConfigurator createInstanceConfigurator();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns a new object of class '<em>Interception Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interception Rule</em>'.
	 * @generated
	 */
	InterceptionRule createInterceptionRule();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	FCMPackage getFCMPackage();

} //FCMFactory
