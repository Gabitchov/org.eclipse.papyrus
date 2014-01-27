package org.eclipse.papyrus.qompass.designer.core;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.papyrus.qompass.designer.core.messages"; //$NON-NLS-1$
	
	public static String BootLoaderGen_AtLeastOneBlockingCall;

	public static String BootLoaderGen_CannotRetrieveTemplate;

	public static String CommandSupport_NoEditingDomain;
	public static String CommandSupport_ErrorDuringCmdExec;
	public static String ConfigUtils_RuleWithoutBaseClass;
	public static String DepCreation_CannotFindImplementation;

	public static String DepCreation_CircularReference;

	public static String DepCreation_DefiningFeatureNull;

	public static String DepCreation_FCMconnectorWithoutBaseClass;

	public static String DepCreation_InfoCreateDepPlan;

	public static String DepCreation_TypeInAttributeUndefined;

	public static String Deploy_0;

	public static String Description_NoAvail;
	
	public static String LWContainerTrafo_CannotApplyRule;
	
	public static String ConnectorBinding_CannotFindBinding;
	public static String ConnectorBinding_CannotFindBindingForPort;
	public static String ConnectorBinding_CannotFindConsistentBinding;
	public static String ConnectorBinding_ConnectorsPort;
	public static String ConnectorBinding_FormalAlreadyBound;
	public static String ConnectorBinding_InfoActualReturnIntfIs;
	public static String ConnectorBinding_InfoConnPortConnectedVia;
	public static String ConnectorBinding_InfoConnectsPort;
	public static String ConnectorBinding_InfoCreateBoundPackage;

	public static String ConnectorBinding_InfoMatchOtherEnd;

	public static String ConnectorBinding_InfoProvidedPortTypeMatches;
	public static String ConnectorBinding_NoTemplateSignature;

	public static String ConnectorReification_CannotFindMatchingPort;
	public static String ConnectorReification_CouldNotBind;
	public static String ConnectorReification_CouldNotConnectPort;
	public static String ConnectorReification_CouldNotConnectPortOfType;
	public static String ConnectorReification_InfoAddConnectorPart;
	public static String ConnectorReification_InfoPortTypes;
	public static String ConnectorReification_RequiresUseOfPorts;
	public static String ConnectorReification_TemplateTypeNotClass;

	public static String GenerateCode_CouldNotDeleteOldCode;
	public static String GenerateCode_GeneratingCodeForNode;
	public static String GenerateCode_GeneratingCode;

	public static String LanguageSupport_LanguageNotSupported;

	public static String TemplateUtils_InfoCreateBoundPackage;
	public static String TemplateUtils_InfoGetActualFrom;
	public static String TemplateUtils_NoTemplateSignature;
	
	public static String TemplateInstantiation_TemplateIsNull;
	public static String TemplateInstantiationListener_TrafoException;

	public static String CompImplTrafos_CannotFindType;
	public static String CompImplTrafos_IntfNotImplemented;
	public static String CompTypeTrafos_CannotFindType;

	public static String ContainerTrafo_CannotApplyRule;
	public static String ContainerTrafo_CannotFindDelegationConn;
	public static String ContainerTrafo_InterceptionRuleButNoInterceptor;
	
	public static String InstanceConfigurator_InvalidPluginExtension;

	public static String InstantiateDepPlan_AcceleoErrors;
	public static String InstantiateDepPlan_AcceleoErrorsCheckLog;
	public static String InstantiateDepPlan_CannotGenModel;
	public static String InstantiateDepPlan_CheckInputImportPkg;
	public static String InstantiateDepPlan_CheckInputImportPkgNoRes;
	public static String InstantiateDepPlan_CheckInputModelProfile3;
	public static String InstantiateDepPlan_CheckInputModelProfileNoRes;
	public static String InstantiateDepPlan_CheckInputModelProfileNoResNoName;
	public static String InstantiateDepPlan_ConsultConsole;
	public static String InstantiateDepPlan_DepPlanStereotypeNotInitialized;
	public static String InstantiateDepPlan_ErrorsDuringTransformation;
	public static String InstantiateDepPlan_IllegalArgumentDuringCopy;
	public static String InstantiateDepPlan_InfoApplyProfile;
	public static String InstantiateDepPlan_InfoDeployingForNode;
	public static String InstantiateDepPlan_InfoExpandingConnectors;
	public static String InstantiateDepPlan_InfoGeneratingModel;
	public static String InstantiateDepPlan_InfoImportPackage;
	public static String InstantiateDepPlan_InfoNoneAllocated;
	public static String InstantiateDepPlan_TransformationException;
	public static String LWContainerTrafo_0;
	public static String LWContainerTrafo_1;
	public static String MainModelTrafo_ChangePartType;
	public static String MainModelTrafo_NoDefiningFeature;
	public static String MainModelTrafo_NoInstanceAssociated;

	public static String CompImplSync_InfoSyncIntf;
	public static String CompImplSync_InfoSyncViaImpl;
	public static String CompImplSync_InfoSyncViaType;

	public static String DepPlanUtils_CannotFindAttribute;
	public static String DepPlanUtils_ConfigOfPropertyFailed;

	public static String UpdateUtils_CannotApplyFCMstereo;
	
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
