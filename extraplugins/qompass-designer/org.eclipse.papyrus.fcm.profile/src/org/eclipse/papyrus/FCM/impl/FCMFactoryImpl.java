/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.FCM.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.papyrus.FCM.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FCMFactoryImpl extends EFactoryImpl implements FCMFactory {

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static FCMFactory init() {
		try {
			FCMFactory theFCMFactory = (FCMFactory)EPackage.Registry.INSTANCE.getEFactory(FCMPackage.eNS_URI);
			if (theFCMFactory != null) {
				return theFCMFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new FCMFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FCMFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case FCMPackage.TEMPLATE: return createTemplate();
			case FCMPackage.CONFIGURATION_PROPERTY: return createConfigurationProperty();
			case FCMPackage.IMPLEMENTATION_GROUP: return createImplementationGroup();
			case FCMPackage.RULE_APPLICATION: return createRuleApplication();
			case FCMPackage.CONTAINER_RULE: return createContainerRule();
			case FCMPackage.CONFIG_OPTION: return createConfigOption();
			case FCMPackage.SINGLETON: return createSingleton();
			case FCMPackage.INTERACTION_COMPONENT: return createInteractionComponent();
			case FCMPackage.PORT_KIND: return createPortKind();
			case FCMPackage.PORT: return createPort();
			case FCMPackage.CONNECTOR: return createConnector();
			case FCMPackage.DEPLOYMENT_PLAN: return createDeploymentPlan();
			case FCMPackage.DERIVED_ELEMENT: return createDerivedElement();
			case FCMPackage.COMP_IMPL_TEMPLATE: return createCompImplTemplate();
			case FCMPackage.CPP_LIBRARY: return createCppLibrary();
			case FCMPackage.EXTERNAL_LIBRARY: return createExternalLibrary();
			case FCMPackage.JAVA_LIBRARY: return createJavaLibrary();
			case FCMPackage.IMPLEMENTATION_PROPERTIES: return createImplementationProperties();
			case FCMPackage.OPERATING_SYSTEM: return createOperatingSystem();
			case FCMPackage.TARGET_ARCHITECTURE: return createTargetArchitecture();
			case FCMPackage.CONFIGURATION: return createConfiguration();
			case FCMPackage.INTERCEPTION_RULE: return createInterceptionRule();
			case FCMPackage.TARGET: return createTarget();
			case FCMPackage.PART: return createPart();
			case FCMPackage.COPY_ATTRIBUTE_VALUE: return createCopyAttributeValue();
			case FCMPackage.AUTO_INDEX: return createAutoIndex();
			case FCMPackage.AUTO_INDEX_PER_NODE: return createAutoIndexPerNode();
			case FCMPackage.INIT_PRECEDENCE: return createInitPrecedence();
			case FCMPackage.CONNECTOR_CONFIGURATION: return createConnectorConfiguration();
			case FCMPackage.EXTENDED_SIGNATURE: return createExtendedSignature();
			case FCMPackage.CONTAINER_PORT: return createContainerPort();
			case FCMPackage.USE_INSTANCE_CONFIGURATOR: return createUseInstanceConfigurator();
			case FCMPackage.INSTANCE_CONFIGURATOR: return createInstanceConfigurator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case FCMPackage.TEMPLATE_KIND:
				return createTemplateKindFromString(eDataType, initialValue);
			case FCMPackage.ACTUAL_CHOICE:
				return createActualChoiceFromString(eDataType, initialValue);
			case FCMPackage.CONTAINER_RULE_KIND:
				return createContainerRuleKindFromString(eDataType, initialValue);
			case FCMPackage.INTERCEPTION_KIND:
				return createInterceptionKindFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case FCMPackage.TEMPLATE_KIND:
				return convertTemplateKindToString(eDataType, instanceValue);
			case FCMPackage.ACTUAL_CHOICE:
				return convertActualChoiceToString(eDataType, instanceValue);
			case FCMPackage.CONTAINER_RULE_KIND:
				return convertContainerRuleKindToString(eDataType, instanceValue);
			case FCMPackage.INTERCEPTION_KIND:
				return convertInterceptionKindToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Template createTemplate() {
		TemplateImpl template = new TemplateImpl();
		return template;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerRule createContainerRule() {
		ContainerRuleImpl containerRule = new ContainerRuleImpl();
		return containerRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Port createPort() {
		PortImpl port = new PortImpl();
		return port;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PortKind createPortKind() {
		PortKindImpl portKind = new PortKindImpl();
		return portKind;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompImplTemplate createCompImplTemplate() {
		CompImplTemplateImpl compImplTemplate = new CompImplTemplateImpl();
		return compImplTemplate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigOption createConfigOption() {
		ConfigOptionImpl configOption = new ConfigOptionImpl();
		return configOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Singleton createSingleton() {
		SingletonImpl singleton = new SingletonImpl();
		return singleton;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InteractionComponent createInteractionComponent() {
		InteractionComponentImpl interactionComponent = new InteractionComponentImpl();
		return interactionComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Connector createConnector() {
		ConnectorImpl connector = new ConnectorImpl();
		return connector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationProperty createConfigurationProperty() {
		ConfigurationPropertyImpl configurationProperty = new ConfigurationPropertyImpl();
		return configurationProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPlan createDeploymentPlan() {
		DeploymentPlanImpl deploymentPlan = new DeploymentPlanImpl();
		return deploymentPlan;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DerivedElement createDerivedElement() {
		DerivedElementImpl derivedElement = new DerivedElementImpl();
		return derivedElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CppLibrary createCppLibrary() {
		CppLibraryImpl cppLibrary = new CppLibraryImpl();
		return cppLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalLibrary createExternalLibrary() {
		ExternalLibraryImpl externalLibrary = new ExternalLibraryImpl();
		return externalLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationGroup createImplementationGroup() {
		ImplementationGroupImpl implementationGroup = new ImplementationGroupImpl();
		return implementationGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleApplication createRuleApplication() {
		RuleApplicationImpl ruleApplication = new RuleApplicationImpl();
		return ruleApplication;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JavaLibrary createJavaLibrary() {
		JavaLibraryImpl javaLibrary = new JavaLibraryImpl();
		return javaLibrary;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImplementationProperties createImplementationProperties() {
		ImplementationPropertiesImpl implementationProperties = new ImplementationPropertiesImpl();
		return implementationProperties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingSystem createOperatingSystem() {
		OperatingSystemImpl operatingSystem = new OperatingSystemImpl();
		return operatingSystem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetArchitecture createTargetArchitecture() {
		TargetArchitectureImpl targetArchitecture = new TargetArchitectureImpl();
		return targetArchitecture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Target createTarget() {
		TargetImpl target = new TargetImpl();
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Part createPart() {
		PartImpl part = new PartImpl();
		return part;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CopyAttributeValue createCopyAttributeValue() {
		CopyAttributeValueImpl copyAttributeValue = new CopyAttributeValueImpl();
		return copyAttributeValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutoIndex createAutoIndex() {
		AutoIndexImpl autoIndex = new AutoIndexImpl();
		return autoIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AutoIndexPerNode createAutoIndexPerNode() {
		AutoIndexPerNodeImpl autoIndexPerNode = new AutoIndexPerNodeImpl();
		return autoIndexPerNode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InitPrecedence createInitPrecedence() {
		InitPrecedenceImpl initPrecedence = new InitPrecedenceImpl();
		return initPrecedence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConnectorConfiguration createConnectorConfiguration() {
		ConnectorConfigurationImpl connectorConfiguration = new ConnectorConfigurationImpl();
		return connectorConfiguration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtendedSignature createExtendedSignature() {
		ExtendedSignatureImpl extendedSignature = new ExtendedSignatureImpl();
		return extendedSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerPort createContainerPort() {
		ContainerPortImpl containerPort = new ContainerPortImpl();
		return containerPort;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseInstanceConfigurator createUseInstanceConfigurator() {
		UseInstanceConfiguratorImpl useInstanceConfigurator = new UseInstanceConfiguratorImpl();
		return useInstanceConfigurator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstanceConfigurator createInstanceConfigurator() {
		InstanceConfiguratorImpl instanceConfigurator = new InstanceConfiguratorImpl();
		return instanceConfigurator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterceptionRule createInterceptionRule() {
		InterceptionRuleImpl interceptionRule = new InterceptionRuleImpl();
		return interceptionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TemplateKind createTemplateKindFromString(EDataType eDataType, String initialValue) {
		TemplateKind result = TemplateKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTemplateKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActualChoice createActualChoiceFromString(EDataType eDataType, String initialValue) {
		ActualChoice result = ActualChoice.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertActualChoiceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContainerRuleKind createContainerRuleKindFromString(EDataType eDataType, String initialValue) {
		ContainerRuleKind result = ContainerRuleKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertContainerRuleKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InterceptionKind createInterceptionKindFromString(EDataType eDataType, String initialValue) {
		InterceptionKind result = InterceptionKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInterceptionKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FCMPackage getFCMPackage() {
		return (FCMPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static FCMPackage getPackage() {
		return FCMPackage.eINSTANCE;
	}

} //FCMFactoryImpl
