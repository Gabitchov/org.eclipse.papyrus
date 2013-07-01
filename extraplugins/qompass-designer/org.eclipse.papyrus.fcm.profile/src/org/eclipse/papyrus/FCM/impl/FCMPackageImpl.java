/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.papyrus.FCM.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.papyrus.FCM.ActualChoice;
import org.eclipse.papyrus.FCM.Assembly;
import org.eclipse.papyrus.FCM.AutoIndex;
import org.eclipse.papyrus.FCM.AutoIndexPerNode;
import org.eclipse.papyrus.FCM.CodeGenOptions;
import org.eclipse.papyrus.FCM.CompImplTemplate;
import org.eclipse.papyrus.FCM.CompToOOmapping;
import org.eclipse.papyrus.FCM.CompilerChain;
import org.eclipse.papyrus.FCM.ConfigOption;
import org.eclipse.papyrus.FCM.ConfigurableElementInstance;
import org.eclipse.papyrus.FCM.Configuration;
import org.eclipse.papyrus.FCM.ConfigurationProperty;
import org.eclipse.papyrus.FCM.Connector;
import org.eclipse.papyrus.FCM.ConnectorConfiguration;
import org.eclipse.papyrus.FCM.ContainerRule;
import org.eclipse.papyrus.FCM.ContainerRuleKind;
import org.eclipse.papyrus.FCM.CopyAttributeValue;
import org.eclipse.papyrus.FCM.DeploymentPlan;
import org.eclipse.papyrus.FCM.DerivedElement;
import org.eclipse.papyrus.FCM.ExtendedSignature;
import org.eclipse.papyrus.FCM.FCMFactory;
import org.eclipse.papyrus.FCM.FCMPackage;
import org.eclipse.papyrus.FCM.Flatten;
import org.eclipse.papyrus.FCM.Fragment;
import org.eclipse.papyrus.FCM.ImplementationGroup;
import org.eclipse.papyrus.FCM.ImplementationProperties;
import org.eclipse.papyrus.FCM.InitPrecedence;
import org.eclipse.papyrus.FCM.InstanceConfigurator;
import org.eclipse.papyrus.FCM.InteractionComponent;
import org.eclipse.papyrus.FCM.InterceptionKind;
import org.eclipse.papyrus.FCM.InterceptionRule;
import org.eclipse.papyrus.FCM.OperatingSystem;
import org.eclipse.papyrus.FCM.Port;
import org.eclipse.papyrus.FCM.PortKind;
import org.eclipse.papyrus.FCM.ProgLanguage;
import org.eclipse.papyrus.FCM.RuleApplication;
import org.eclipse.papyrus.FCM.Singleton;
import org.eclipse.papyrus.FCM.Target;
import org.eclipse.papyrus.FCM.TargetArchitecture;
import org.eclipse.papyrus.FCM.Template;
import org.eclipse.papyrus.FCM.TemplateKind;
import org.eclipse.papyrus.FCM.TemplatePort;
import org.eclipse.papyrus.FCM.UseInstanceConfigurator;
import org.eclipse.uml2.types.TypesPackage;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class FCMPackageImpl extends EPackageImpl implements FCMPackage {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass containerRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurableElementInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass portKindEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compImplTemplateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configOptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass templatePortEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass singletonEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interactionComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deploymentPlanEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass derivedElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass assemblyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass flattenEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compToOOmappingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass progLanguageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass codeGenOptionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleApplicationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass implementationPropertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass operatingSystemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetArchitectureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass targetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compilerChainEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass copyAttributeValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autoIndexEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autoIndexPerNodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass initPrecedenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass connectorConfigurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedSignatureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass useInstanceConfiguratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass instanceConfiguratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interceptionRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum templateKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum actualChoiceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum containerRuleKindEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum interceptionKindEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.papyrus.FCM.FCMPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private FCMPackageImpl() {
		super(eNS_URI, FCMFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link FCMPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static FCMPackage init() {
		if (isInited) return (FCMPackage)EPackage.Registry.INSTANCE.getEPackage(FCMPackage.eNS_URI);

		// Obtain or create and register package
		FCMPackageImpl theFCMPackage = (FCMPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof FCMPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new FCMPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		UMLPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theFCMPackage.createPackageContents();

		// Initialize created meta-data
		theFCMPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theFCMPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(FCMPackage.eNS_URI, theFCMPackage);
		return theFCMPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplate() {
		return templateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplate_TemplateParams() {
		return (EReference)templateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplate_Base_Element() {
		return (EReference)templateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplate_Kind() {
		return (EAttribute)templateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTemplate_ActualChoice() {
		return (EAttribute)templateEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getContainerRule() {
		return containerRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainerRule_Base_Class() {
		return (EReference)containerRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getContainerRule_ForConfig() {
		return (EReference)containerRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getContainerRule_Kind() {
		return (EAttribute)containerRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPort() {
		return portEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_Base_Port() {
		return (EReference)portEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_Kind() {
		return (EReference)portEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_ProvidedInterface() {
		return (EReference)portEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPort_RequiredInterface() {
		return (EReference)portEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurableElementInstance() {
		return configurableElementInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurableElementInstance_Configuration() {
		return (EReference)configurableElementInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPortKind() {
		return portKindEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortKind_Base_Class() {
		return (EReference)portKindEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortKind_ProvidedInterface() {
		return (EReference)portKindEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPortKind_RequiredInterface() {
		return (EReference)portKindEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPortKind_ExtendedPort() {
		return (EAttribute)portKindEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompImplTemplate() {
		return compImplTemplateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCompImplTemplate_TemplateDefs() {
		return (EAttribute)compImplTemplateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompImplTemplate_Base_Class() {
		return (EReference)compImplTemplateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigOption() {
		return configOptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigOption_Base_Class() {
		return (EReference)configOptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTemplatePort() {
		return templatePortEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTemplatePort_BoundType() {
		return (EReference)templatePortEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSingleton() {
		return singletonEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSingleton_Base_Class() {
		return (EReference)singletonEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInteractionComponent() {
		return interactionComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInteractionComponent_ForDistribution() {
		return (EAttribute)interactionComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteractionComponent_ConnectionPattern() {
		return (EReference)interactionComponentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInteractionComponent_Base_Class() {
		return (EReference)interactionComponentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnector() {
		return connectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnector_Base_Connector() {
		return (EReference)connectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnector_Ic() {
		return (EReference)connectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnector_Base_Property() {
		return (EReference)connectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfigurationProperty() {
		return configurationPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfigurationProperty_Base_Property() {
		return (EReference)configurationPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeploymentPlan() {
		return deploymentPlanEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeploymentPlan_MainInstance() {
		return (EReference)deploymentPlanEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDeploymentPlan_Base_Package() {
		return (EReference)deploymentPlanEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDerivedElement() {
		return derivedElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerivedElement_Base_Element() {
		return (EReference)derivedElementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDerivedElement_Source() {
		return (EReference)derivedElementEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationGroup() {
		return implementationGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationGroup_Base_Class() {
		return (EReference)implementationGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAssembly() {
		return assemblyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAssembly_Base_Class() {
		return (EReference)assemblyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFlatten() {
		return flattenEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFlatten_Base_Class() {
		return (EReference)flattenEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompToOOmapping() {
		return compToOOmappingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompToOOmapping_Base_Class() {
		return (EReference)compToOOmappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProgLanguage() {
		return progLanguageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgLanguage_Base_Class() {
		return (EReference)progLanguageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCodeGenOptions() {
		return codeGenOptionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeGenOptions_Base_Package() {
		return (EReference)codeGenOptionsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeGenOptions_CompToOOmapping() {
		return (EReference)codeGenOptionsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCodeGenOptions_ProgLanguage() {
		return (EReference)codeGenOptionsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRuleApplication() {
		return ruleApplicationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleApplication_Base_Class() {
		return (EReference)ruleApplicationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleApplication_ContainerRule() {
		return (EReference)ruleApplicationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRuleApplication_Base_Package() {
		return (EReference)ruleApplicationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getImplementationProperties() {
		return implementationPropertiesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImplementationProperties_SizeRAM() {
		return (EAttribute)implementationPropertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationProperties_SupportedOS() {
		return (EReference)implementationPropertiesEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationProperties_Arch() {
		return (EReference)implementationPropertiesEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationProperties_Base_Class() {
		return (EReference)implementationPropertiesEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getImplementationProperties_SizeROM() {
		return (EAttribute)implementationPropertiesEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getImplementationProperties_SupportedTargetArch() {
		return (EReference)implementationPropertiesEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOperatingSystem() {
		return operatingSystemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getOperatingSystem_Base_Class() {
		return (EReference)operatingSystemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTargetArchitecture() {
		return targetArchitectureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTargetArchitecture_Base_Class() {
		return (EReference)targetArchitectureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTarget() {
		return targetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_TargetArch() {
		return (EReference)targetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Options() {
		return (EReference)targetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Base_Node() {
		return (EReference)targetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_UsedOS() {
		return (EReference)targetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_AvailRAM() {
		return (EAttribute)targetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTarget_AvailROM() {
		return (EAttribute)targetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTarget_Compiler() {
		return (EReference)targetEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompilerChain() {
		return compilerChainEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompilerChain_Base_Class() {
		return (EReference)compilerChainEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFragment() {
		return fragmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFragment_Base_Class() {
		return (EReference)fragmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCopyAttributeValue() {
		return copyAttributeValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCopyAttributeValue_Source() {
		return (EReference)copyAttributeValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCopyAttributeValue_Base_Property() {
		return (EReference)copyAttributeValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutoIndex() {
		return autoIndexEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAutoIndex_Base_Property() {
		return (EReference)autoIndexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutoIndexPerNode() {
		return autoIndexPerNodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInitPrecedence() {
		return initPrecedenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitPrecedence_InvokeAfter() {
		return (EReference)initPrecedenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitPrecedence_InvokeBefore() {
		return (EReference)initPrecedenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInitPrecedence_Base_Class() {
		return (EReference)initPrecedenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConnectorConfiguration() {
		return connectorConfigurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorConfiguration_Base_Slot() {
		return (EReference)connectorConfigurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConnectorConfiguration_Connector() {
		return (EReference)connectorConfigurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedSignature() {
		return extendedSignatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedSignature_Base_TemplateSignature() {
		return (EReference)extendedSignatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedSignature_BaseSignature() {
		return (EReference)extendedSignatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUseInstanceConfigurator() {
		return useInstanceConfiguratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseInstanceConfigurator_Base_Class() {
		return (EReference)useInstanceConfiguratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUseInstanceConfigurator_Configurator() {
		return (EReference)useInstanceConfiguratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInstanceConfigurator() {
		return instanceConfiguratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInstanceConfigurator_Base_Class() {
		return (EReference)instanceConfiguratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_Base_Class() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_ConfigOptions() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConfiguration_DeploymentPlan() {
		return (EReference)configurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterceptionRule() {
		return interceptionRuleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInterceptionRule_InterceptionKind() {
		return (EAttribute)interceptionRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterceptionRule_InterceptionSet() {
		return (EReference)interceptionRuleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterceptionRule_Base_Property() {
		return (EReference)interceptionRuleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterceptionRule_Base_Operation() {
		return (EReference)interceptionRuleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getTemplateKind() {
		return templateKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getActualChoice() {
		return actualChoiceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getContainerRuleKind() {
		return containerRuleKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getInterceptionKind() {
		return interceptionKindEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FCMFactory getFCMFactory() {
		return (FCMFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		templateEClass = createEClass(TEMPLATE);
		createEReference(templateEClass, TEMPLATE__TEMPLATE_PARAMS);
		createEReference(templateEClass, TEMPLATE__BASE_ELEMENT);
		createEAttribute(templateEClass, TEMPLATE__KIND);
		createEAttribute(templateEClass, TEMPLATE__ACTUAL_CHOICE);

		configurationPropertyEClass = createEClass(CONFIGURATION_PROPERTY);
		createEReference(configurationPropertyEClass, CONFIGURATION_PROPERTY__BASE_PROPERTY);

		implementationGroupEClass = createEClass(IMPLEMENTATION_GROUP);
		createEReference(implementationGroupEClass, IMPLEMENTATION_GROUP__BASE_CLASS);

		assemblyEClass = createEClass(ASSEMBLY);
		createEReference(assemblyEClass, ASSEMBLY__BASE_CLASS);

		flattenEClass = createEClass(FLATTEN);
		createEReference(flattenEClass, FLATTEN__BASE_CLASS);

		compToOOmappingEClass = createEClass(COMP_TO_OOMAPPING);
		createEReference(compToOOmappingEClass, COMP_TO_OOMAPPING__BASE_CLASS);

		progLanguageEClass = createEClass(PROG_LANGUAGE);
		createEReference(progLanguageEClass, PROG_LANGUAGE__BASE_CLASS);

		codeGenOptionsEClass = createEClass(CODE_GEN_OPTIONS);
		createEReference(codeGenOptionsEClass, CODE_GEN_OPTIONS__BASE_PACKAGE);
		createEReference(codeGenOptionsEClass, CODE_GEN_OPTIONS__COMP_TO_OOMAPPING);
		createEReference(codeGenOptionsEClass, CODE_GEN_OPTIONS__PROG_LANGUAGE);

		interactionComponentEClass = createEClass(INTERACTION_COMPONENT);
		createEAttribute(interactionComponentEClass, INTERACTION_COMPONENT__FOR_DISTRIBUTION);
		createEReference(interactionComponentEClass, INTERACTION_COMPONENT__CONNECTION_PATTERN);
		createEReference(interactionComponentEClass, INTERACTION_COMPONENT__BASE_CLASS);

		singletonEClass = createEClass(SINGLETON);
		createEReference(singletonEClass, SINGLETON__BASE_CLASS);

		connectorEClass = createEClass(CONNECTOR);
		createEReference(connectorEClass, CONNECTOR__BASE_CONNECTOR);
		createEReference(connectorEClass, CONNECTOR__IC);
		createEReference(connectorEClass, CONNECTOR__BASE_PROPERTY);

		configurableElementInstanceEClass = createEClass(CONFIGURABLE_ELEMENT_INSTANCE);
		createEReference(configurableElementInstanceEClass, CONFIGURABLE_ELEMENT_INSTANCE__CONFIGURATION);

		useInstanceConfiguratorEClass = createEClass(USE_INSTANCE_CONFIGURATOR);
		createEReference(useInstanceConfiguratorEClass, USE_INSTANCE_CONFIGURATOR__BASE_CLASS);
		createEReference(useInstanceConfiguratorEClass, USE_INSTANCE_CONFIGURATOR__CONFIGURATOR);

		instanceConfiguratorEClass = createEClass(INSTANCE_CONFIGURATOR);
		createEReference(instanceConfiguratorEClass, INSTANCE_CONFIGURATOR__BASE_CLASS);

		ruleApplicationEClass = createEClass(RULE_APPLICATION);
		createEReference(ruleApplicationEClass, RULE_APPLICATION__BASE_CLASS);
		createEReference(ruleApplicationEClass, RULE_APPLICATION__CONTAINER_RULE);
		createEReference(ruleApplicationEClass, RULE_APPLICATION__BASE_PACKAGE);

		containerRuleEClass = createEClass(CONTAINER_RULE);
		createEReference(containerRuleEClass, CONTAINER_RULE__BASE_CLASS);
		createEReference(containerRuleEClass, CONTAINER_RULE__FOR_CONFIG);
		createEAttribute(containerRuleEClass, CONTAINER_RULE__KIND);

		configOptionEClass = createEClass(CONFIG_OPTION);
		createEReference(configOptionEClass, CONFIG_OPTION__BASE_CLASS);

		templatePortEClass = createEClass(TEMPLATE_PORT);
		createEReference(templatePortEClass, TEMPLATE_PORT__BOUND_TYPE);

		portEClass = createEClass(PORT);
		createEReference(portEClass, PORT__BASE_PORT);
		createEReference(portEClass, PORT__KIND);
		createEReference(portEClass, PORT__PROVIDED_INTERFACE);
		createEReference(portEClass, PORT__REQUIRED_INTERFACE);

		portKindEClass = createEClass(PORT_KIND);
		createEReference(portKindEClass, PORT_KIND__BASE_CLASS);
		createEReference(portKindEClass, PORT_KIND__PROVIDED_INTERFACE);
		createEReference(portKindEClass, PORT_KIND__REQUIRED_INTERFACE);
		createEAttribute(portKindEClass, PORT_KIND__EXTENDED_PORT);

		deploymentPlanEClass = createEClass(DEPLOYMENT_PLAN);
		createEReference(deploymentPlanEClass, DEPLOYMENT_PLAN__MAIN_INSTANCE);
		createEReference(deploymentPlanEClass, DEPLOYMENT_PLAN__BASE_PACKAGE);

		derivedElementEClass = createEClass(DERIVED_ELEMENT);
		createEReference(derivedElementEClass, DERIVED_ELEMENT__BASE_ELEMENT);
		createEReference(derivedElementEClass, DERIVED_ELEMENT__SOURCE);

		compImplTemplateEClass = createEClass(COMP_IMPL_TEMPLATE);
		createEAttribute(compImplTemplateEClass, COMP_IMPL_TEMPLATE__TEMPLATE_DEFS);
		createEReference(compImplTemplateEClass, COMP_IMPL_TEMPLATE__BASE_CLASS);

		implementationPropertiesEClass = createEClass(IMPLEMENTATION_PROPERTIES);
		createEAttribute(implementationPropertiesEClass, IMPLEMENTATION_PROPERTIES__SIZE_RAM);
		createEReference(implementationPropertiesEClass, IMPLEMENTATION_PROPERTIES__SUPPORTED_OS);
		createEReference(implementationPropertiesEClass, IMPLEMENTATION_PROPERTIES__ARCH);
		createEReference(implementationPropertiesEClass, IMPLEMENTATION_PROPERTIES__BASE_CLASS);
		createEAttribute(implementationPropertiesEClass, IMPLEMENTATION_PROPERTIES__SIZE_ROM);
		createEReference(implementationPropertiesEClass, IMPLEMENTATION_PROPERTIES__SUPPORTED_TARGET_ARCH);

		operatingSystemEClass = createEClass(OPERATING_SYSTEM);
		createEReference(operatingSystemEClass, OPERATING_SYSTEM__BASE_CLASS);

		targetArchitectureEClass = createEClass(TARGET_ARCHITECTURE);
		createEReference(targetArchitectureEClass, TARGET_ARCHITECTURE__BASE_CLASS);

		configurationEClass = createEClass(CONFIGURATION);
		createEReference(configurationEClass, CONFIGURATION__BASE_CLASS);
		createEReference(configurationEClass, CONFIGURATION__CONFIG_OPTIONS);
		createEReference(configurationEClass, CONFIGURATION__DEPLOYMENT_PLAN);

		interceptionRuleEClass = createEClass(INTERCEPTION_RULE);
		createEAttribute(interceptionRuleEClass, INTERCEPTION_RULE__INTERCEPTION_KIND);
		createEReference(interceptionRuleEClass, INTERCEPTION_RULE__INTERCEPTION_SET);
		createEReference(interceptionRuleEClass, INTERCEPTION_RULE__BASE_PROPERTY);
		createEReference(interceptionRuleEClass, INTERCEPTION_RULE__BASE_OPERATION);

		targetEClass = createEClass(TARGET);
		createEReference(targetEClass, TARGET__TARGET_ARCH);
		createEReference(targetEClass, TARGET__OPTIONS);
		createEReference(targetEClass, TARGET__BASE_NODE);
		createEReference(targetEClass, TARGET__USED_OS);
		createEAttribute(targetEClass, TARGET__AVAIL_RAM);
		createEAttribute(targetEClass, TARGET__AVAIL_ROM);
		createEReference(targetEClass, TARGET__COMPILER);

		compilerChainEClass = createEClass(COMPILER_CHAIN);
		createEReference(compilerChainEClass, COMPILER_CHAIN__BASE_CLASS);

		fragmentEClass = createEClass(FRAGMENT);
		createEReference(fragmentEClass, FRAGMENT__BASE_CLASS);

		copyAttributeValueEClass = createEClass(COPY_ATTRIBUTE_VALUE);
		createEReference(copyAttributeValueEClass, COPY_ATTRIBUTE_VALUE__SOURCE);
		createEReference(copyAttributeValueEClass, COPY_ATTRIBUTE_VALUE__BASE_PROPERTY);

		autoIndexEClass = createEClass(AUTO_INDEX);
		createEReference(autoIndexEClass, AUTO_INDEX__BASE_PROPERTY);

		autoIndexPerNodeEClass = createEClass(AUTO_INDEX_PER_NODE);

		initPrecedenceEClass = createEClass(INIT_PRECEDENCE);
		createEReference(initPrecedenceEClass, INIT_PRECEDENCE__INVOKE_AFTER);
		createEReference(initPrecedenceEClass, INIT_PRECEDENCE__INVOKE_BEFORE);
		createEReference(initPrecedenceEClass, INIT_PRECEDENCE__BASE_CLASS);

		connectorConfigurationEClass = createEClass(CONNECTOR_CONFIGURATION);
		createEReference(connectorConfigurationEClass, CONNECTOR_CONFIGURATION__BASE_SLOT);
		createEReference(connectorConfigurationEClass, CONNECTOR_CONFIGURATION__CONNECTOR);

		extendedSignatureEClass = createEClass(EXTENDED_SIGNATURE);
		createEReference(extendedSignatureEClass, EXTENDED_SIGNATURE__BASE_TEMPLATE_SIGNATURE);
		createEReference(extendedSignatureEClass, EXTENDED_SIGNATURE__BASE_SIGNATURE);

		// Create enums
		templateKindEEnum = createEEnum(TEMPLATE_KIND);
		actualChoiceEEnum = createEEnum(ACTUAL_CHOICE);
		containerRuleKindEEnum = createEEnum(CONTAINER_RULE_KIND);
		interceptionKindEEnum = createEEnum(INTERCEPTION_KIND);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UMLPackage theUMLPackage = (UMLPackage)EPackage.Registry.INSTANCE.getEPackage(UMLPackage.eNS_URI);
		TypesPackage theTypesPackage = (TypesPackage)EPackage.Registry.INSTANCE.getEPackage(TypesPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		connectorEClass.getESuperTypes().add(this.getConfigurableElementInstance());
		templatePortEClass.getESuperTypes().add(this.getPort());
		portEClass.getESuperTypes().add(this.getConfigurableElementInstance());
		autoIndexPerNodeEClass.getESuperTypes().add(this.getAutoIndex());

		// Initialize classes and features; add operations and parameters
		initEClass(templateEClass, Template.class, "Template", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplate_TemplateParams(), theUMLPackage.getClassifier(), null, "templateParams", null, 0, -1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTemplate_Base_Element(), theUMLPackage.getElement(), null, "base_Element", null, 1, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTemplate_Kind(), this.getTemplateKind(), "kind", null, 1, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTemplate_ActualChoice(), this.getActualChoice(), "actualChoice", null, 0, 1, Template.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(configurationPropertyEClass, ConfigurationProperty.class, "ConfigurationProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigurationProperty_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, ConfigurationProperty.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(implementationGroupEClass, ImplementationGroup.class, "ImplementationGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getImplementationGroup_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, ImplementationGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(assemblyEClass, Assembly.class, "Assembly", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAssembly_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, Assembly.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(flattenEClass, Flatten.class, "Flatten", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFlatten_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, Flatten.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(compToOOmappingEClass, CompToOOmapping.class, "CompToOOmapping", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompToOOmapping_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, CompToOOmapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(progLanguageEClass, ProgLanguage.class, "ProgLanguage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProgLanguage_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, ProgLanguage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(codeGenOptionsEClass, CodeGenOptions.class, "CodeGenOptions", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCodeGenOptions_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, CodeGenOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCodeGenOptions_CompToOOmapping(), this.getCompToOOmapping(), null, "compToOOmapping", null, 1, 1, CodeGenOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCodeGenOptions_ProgLanguage(), this.getProgLanguage(), null, "progLanguage", null, 1, 1, CodeGenOptions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(interactionComponentEClass, InteractionComponent.class, "InteractionComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInteractionComponent_ForDistribution(), theTypesPackage.getBoolean(), "forDistribution", "false", 1, 1, InteractionComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInteractionComponent_ConnectionPattern(), theUMLPackage.getCollaboration(), null, "connectionPattern", null, 0, 1, InteractionComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInteractionComponent_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, InteractionComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(singletonEClass, Singleton.class, "Singleton", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSingleton_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, Singleton.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(connectorEClass, Connector.class, "Connector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnector_Base_Connector(), theUMLPackage.getConnector(), null, "base_Connector", null, 1, 1, Connector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConnector_Ic(), this.getInteractionComponent(), null, "ic", null, 0, 1, Connector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConnector_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, Connector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(configurableElementInstanceEClass, ConfigurableElementInstance.class, "ConfigurableElementInstance", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigurableElementInstance_Configuration(), theUMLPackage.getInstanceSpecification(), null, "configuration", null, 0, 1, ConfigurableElementInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(useInstanceConfiguratorEClass, UseInstanceConfigurator.class, "UseInstanceConfigurator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUseInstanceConfigurator_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, UseInstanceConfigurator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getUseInstanceConfigurator_Configurator(), this.getInstanceConfigurator(), null, "configurator", null, 1, 1, UseInstanceConfigurator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(instanceConfiguratorEClass, InstanceConfigurator.class, "InstanceConfigurator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstanceConfigurator_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, InstanceConfigurator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(ruleApplicationEClass, RuleApplication.class, "RuleApplication", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRuleApplication_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, RuleApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRuleApplication_ContainerRule(), this.getContainerRule(), null, "containerRule", null, 0, -1, RuleApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRuleApplication_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, RuleApplication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(containerRuleEClass, ContainerRule.class, "ContainerRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContainerRule_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, ContainerRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getContainerRule_ForConfig(), this.getConfigOption(), null, "forConfig", null, 0, -1, ContainerRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getContainerRule_Kind(), this.getContainerRuleKind(), "kind", null, 1, 1, ContainerRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(configOptionEClass, ConfigOption.class, "ConfigOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfigOption_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, ConfigOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(templatePortEClass, TemplatePort.class, "TemplatePort", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTemplatePort_BoundType(), this.getPortKind(), null, "boundType", null, 0, 1, TemplatePort.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(portEClass, Port.class, "Port", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPort_Base_Port(), theUMLPackage.getPort(), null, "base_Port", null, 1, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPort_Kind(), this.getPortKind(), null, "kind", null, 0, 1, Port.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPort_ProvidedInterface(), theUMLPackage.getInterface(), null, "providedInterface", null, 0, 1, Port.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getPort_RequiredInterface(), theUMLPackage.getInterface(), null, "requiredInterface", null, 0, 1, Port.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, !IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(portKindEClass, PortKind.class, "PortKind", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPortKind_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, PortKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPortKind_ProvidedInterface(), theUMLPackage.getInterface(), null, "providedInterface", null, 0, 1, PortKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPortKind_RequiredInterface(), theUMLPackage.getInterface(), null, "requiredInterface", null, 0, 1, PortKind.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPortKind_ExtendedPort(), theTypesPackage.getBoolean(), "extendedPort", null, 1, 1, PortKind.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(deploymentPlanEClass, DeploymentPlan.class, "DeploymentPlan", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDeploymentPlan_MainInstance(), theUMLPackage.getInstanceSpecification(), null, "mainInstance", null, 1, 1, DeploymentPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDeploymentPlan_Base_Package(), theUMLPackage.getPackage(), null, "base_Package", null, 1, 1, DeploymentPlan.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(derivedElementEClass, DerivedElement.class, "DerivedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDerivedElement_Base_Element(), theUMLPackage.getElement(), null, "base_Element", null, 1, 1, DerivedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getDerivedElement_Source(), theUMLPackage.getElement(), null, "source", null, 1, 1, DerivedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(compImplTemplateEClass, CompImplTemplate.class, "CompImplTemplate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCompImplTemplate_TemplateDefs(), theTypesPackage.getString(), "templateDefs", null, 0, 1, CompImplTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCompImplTemplate_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, CompImplTemplate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(implementationPropertiesEClass, ImplementationProperties.class, "ImplementationProperties", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImplementationProperties_SizeRAM(), theTypesPackage.getInteger(), "sizeRAM", null, 1, 1, ImplementationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getImplementationProperties_SupportedOS(), this.getOperatingSystem(), null, "supportedOS", null, 0, -1, ImplementationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getImplementationProperties_Arch(), this.getTargetArchitecture(), null, "arch", null, 0, -1, ImplementationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getImplementationProperties_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, ImplementationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getImplementationProperties_SizeROM(), theTypesPackage.getInteger(), "sizeROM", null, 1, 1, ImplementationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getImplementationProperties_SupportedTargetArch(), this.getTargetArchitecture(), null, "supportedTargetArch", null, 1, 1, ImplementationProperties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(operatingSystemEClass, OperatingSystem.class, "OperatingSystem", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getOperatingSystem_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, OperatingSystem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(targetArchitectureEClass, TargetArchitecture.class, "TargetArchitecture", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTargetArchitecture_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, TargetArchitecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConfiguration_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConfiguration_ConfigOptions(), this.getConfigOption(), null, "configOptions", null, 0, -1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConfiguration_DeploymentPlan(), this.getDeploymentPlan(), null, "deploymentPlan", null, 1, 1, Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(interceptionRuleEClass, InterceptionRule.class, "InterceptionRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInterceptionRule_InterceptionKind(), this.getInterceptionKind(), "interceptionKind", null, 1, 1, InterceptionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInterceptionRule_InterceptionSet(), theUMLPackage.getFeature(), null, "interceptionSet", null, 0, -1, InterceptionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInterceptionRule_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, InterceptionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInterceptionRule_Base_Operation(), theUMLPackage.getOperation(), null, "base_Operation", null, 1, 1, InterceptionRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(targetEClass, Target.class, "Target", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTarget_TargetArch(), this.getTargetArchitecture(), null, "targetArch", null, 1, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTarget_Options(), this.getConfigOption(), null, "options", null, 0, -1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTarget_Base_Node(), theUMLPackage.getNode(), null, "base_Node", null, 1, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTarget_UsedOS(), this.getOperatingSystem(), null, "usedOS", null, 1, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTarget_AvailRAM(), theTypesPackage.getInteger(), "availRAM", null, 1, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getTarget_AvailROM(), theTypesPackage.getInteger(), "availROM", null, 1, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getTarget_Compiler(), this.getCompilerChain(), null, "compiler", null, 1, 1, Target.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(compilerChainEClass, CompilerChain.class, "CompilerChain", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompilerChain_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, CompilerChain.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fragmentEClass, Fragment.class, "Fragment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragment_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, Fragment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(copyAttributeValueEClass, CopyAttributeValue.class, "CopyAttributeValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCopyAttributeValue_Source(), theUMLPackage.getProperty(), null, "source", null, 1, 1, CopyAttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCopyAttributeValue_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, CopyAttributeValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(autoIndexEClass, AutoIndex.class, "AutoIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAutoIndex_Base_Property(), theUMLPackage.getProperty(), null, "base_Property", null, 1, 1, AutoIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(autoIndexPerNodeEClass, AutoIndexPerNode.class, "AutoIndexPerNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(initPrecedenceEClass, InitPrecedence.class, "InitPrecedence", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInitPrecedence_InvokeAfter(), theUMLPackage.getClass_(), null, "invokeAfter", null, 0, -1, InitPrecedence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInitPrecedence_InvokeBefore(), theUMLPackage.getClass_(), null, "invokeBefore", null, 0, -1, InitPrecedence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getInitPrecedence_Base_Class(), theUMLPackage.getClass_(), null, "base_Class", null, 1, 1, InitPrecedence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(connectorConfigurationEClass, ConnectorConfiguration.class, "ConnectorConfiguration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getConnectorConfiguration_Base_Slot(), theUMLPackage.getSlot(), null, "base_Slot", null, 1, 1, ConnectorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getConnectorConfiguration_Connector(), this.getConnector(), null, "connector", null, 1, 1, ConnectorConfiguration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(extendedSignatureEClass, ExtendedSignature.class, "ExtendedSignature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExtendedSignature_Base_TemplateSignature(), theUMLPackage.getTemplateSignature(), null, "base_TemplateSignature", null, 1, 1, ExtendedSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getExtendedSignature_BaseSignature(), theUMLPackage.getTemplateSignature(), null, "baseSignature", null, 1, 1, ExtendedSignature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(templateKindEEnum, TemplateKind.class, "TemplateKind");
		addEEnumLiteral(templateKindEEnum, TemplateKind.PASS_FORMAL);
		addEEnumLiteral(templateKindEEnum, TemplateKind.LOOP_OPERATIONS);
		addEEnumLiteral(templateKindEEnum, TemplateKind.LOOP_PROPERTY);
		addEEnumLiteral(templateKindEEnum, TemplateKind.ACCUMULATE);
		addEEnumLiteral(templateKindEEnum, TemplateKind.LOOP_LITERALS);
		addEEnumLiteral(templateKindEEnum, TemplateKind.LATE_EVALUATION);
		addEEnumLiteral(templateKindEEnum, TemplateKind.LOOP_PORTS);
		addEEnumLiteral(templateKindEEnum, TemplateKind.PASS_CLASSIFIER);

		initEEnum(actualChoiceEEnum, ActualChoice.class, "ActualChoice");
		addEEnumLiteral(actualChoiceEEnum, ActualChoice.PASS_ACTUAL);
		addEEnumLiteral(actualChoiceEEnum, ActualChoice.INTERFACE_OF_PPORT);
		addEEnumLiteral(actualChoiceEEnum, ActualChoice.INTERFACE_OF_RPORT);

		initEEnum(containerRuleKindEEnum, ContainerRuleKind.class, "ContainerRuleKind");
		addEEnumLiteral(containerRuleKindEEnum, ContainerRuleKind.COMPONENT_RULE);
		addEEnumLiteral(containerRuleKindEEnum, ContainerRuleKind.LIGHT_WEIGHT_OO_RULE);

		initEEnum(interceptionKindEEnum, InterceptionKind.class, "InterceptionKind");
		addEEnumLiteral(interceptionKindEEnum, InterceptionKind.INTERCEPT_SOME);
		addEEnumLiteral(interceptionKindEEnum, InterceptionKind.INTERCEPT_ALL);
		addEEnumLiteral(interceptionKindEEnum, InterceptionKind.INTERCEPT_ALL_OUT);
		addEEnumLiteral(interceptionKindEEnum, InterceptionKind.INTERCEPT_ALL_IN);

		// Create resource
		createResource(eNS_URI);
	}

} //FCMPackageImpl
