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

package org.eclipse.papyrus.eastadl.utils;

/**
 * Stereotype ids (QualifiedName) Useful to retrieve applicable or applied stereotypes
 * 
 */
public interface EASTResource {

	public static String ACTUATOR_ID = "EAST-ADL2::Structure::HardwareModeling::Actuator";

	public static String AGETIMINGCONSTRAINT_ID = "EAST-ADL2::Timing::TimingConstraints::AgeTimingConstraint";

	public static String ALLOCATEABLEELEMENT_ID = "EAST-ADL2::Structure::FunctionModeling::AllocateableElement";

	public static String ALLOCATION_ID = "EAST-ADL2::Structure::FunctionModeling::Allocation";

	public static String ALLOCATIONTARGET_ID = "EAST-ADL2::Structure::HardwareModeling::AllocationTarget";

	public static String ANALYSISFUNCTIONPROTOTYPE_ID = "EAST-ADL2::Structure::FunctionModeling::AnalysisFunctionPrototype";

	public static String ANALYSISFUNCTIONTYPE_ID = "EAST-ADL2::Structure::FunctionModeling::AnalysisFunctionType";

	public static String ANALYSISLEVEL_ID = "EAST-ADL2::Structure::SystemModeling::AnalysisLevel";

	public static String ANOMALY_ID = "EAST-ADL2::Dependability::ErrorModel::Anomaly";

	public static String ARBITRARYEVENTCONSTRAINT_ID = "EAST-ADL2::Timing::TimingConstraints::ArbitraryEventConstraint";

	public static String ARCHITECTURALDESCRIPTION_ID = "EAST-ADL2::Annex::Needs::ArchitecturalDescription";

	public static String ARCHITECTURALMODEL_ID = "EAST-ADL2::Annex::Needs::ArchitecturalModel";

	public static String ARCHITECTURE_ID = "EAST-ADL2::Annex::Needs::Architecture";

	public static String BASICSOFTWAREFUNCTIONTYPE_ID = "EAST-ADL2::Structure::FunctionModeling::BasicSoftwareFunctionType";

	public static String BINDINGTIME_ID = "EAST-ADL2::Structure::FeatureModeling::BindingTime";

	public static String BUSINESSOPPORTUNITY_ID = "EAST-ADL2::Annex::Needs::BusinessOpportunity";

	public static String CLAIM_ID = "EAST-ADL2::Dependability::SafetyCase::Claim";

	public static String CLAMPCONNECTOR_ID = "EAST-ADL2::Environment::ClampConnector";

	public static String COMMUNICATIONHARDWAREPIN_ID = "EAST-ADL2::Structure::HardwareModeling::CommunicationHardwarePin";

	public static String COMPOSITEDATATYPE_ID = "EAST-ADL2::Infrastructure::Datatypes::CompositeDatatype";

	public static String CONCEPT_ID = "EAST-ADL2::Annex::Needs::Concept";

	public static String CONFIGURABLECONTAINER_ID = "EAST-ADL2::Variability::ConfigurableContainer";

	public static String CONFIGURATIONDECISION_ID = "EAST-ADL2::Variability::ConfigurationDecision";

	public static String CONFIGURATIONDECISIONFOLDER_ID = "EAST-ADL2::Variability::ConfigurationDecisionFolder";

	public static String CONFIGURATIONDECISIONMODEL_ID = "EAST-ADL2::Variability::ConfigurationDecisionModel";

	public static String CONFIGURATIONDECISIONMODELENTRY_ID = "EAST-ADL2::Variability::ConfigurationDecisionModelEntry";

	public static String CONTAINERCONFIGURATION_ID = "EAST-ADL2::Variability::ContainerConfiguration";

	public static String CONTEXT_ID = "EAST-ADL2::Infrastructure::Elements::Context";

	public static String DELAYCONSTRAINT_ID = "EAST-ADL2::Timing::TimingConstraints::DelayConstraint";

	public static String DERIVEREQUIREMENT_ID = "EAST-ADL2::Requirements::DeriveRequirement";

	public static String DESIGNFUNCTIONPROTOTYPE_ID = "EAST-ADL2::Structure::FunctionModeling::DesignFunctionPrototype";

	public static String DESIGNFUNCTIONTYPE_ID = "EAST-ADL2::Structure::FunctionModeling::DesignFunctionType";

	public static String DESIGNLEVEL_ID = "EAST-ADL2::Structure::SystemModeling::DesignLevel";

	public static String DEVIATIONATTRIBUTESET_ID = "EAST-ADL2::Structure::VehicleFeatureModeling::DeviationAttributeSet";

	public static String EADATATYPE_ID = "EAST-ADL2::Infrastructure::Datatypes::EADatatype";

	public static String EAFLOAT_ID = "EAST-ADL2::Infrastructure::Datatypes::EAFloat";

	public static String EAINTEGER_ID = "EAST-ADL2::Infrastructure::Datatypes::EAInteger";

	public static String EABOOLEAN_ID = "EAST-ADL2::Infrastructure::Datatypes::EABoolean";

	public static String EASTRING_ID = "EAST-ADL2::Infrastructure::Datatypes::EAString";

	public static String EADATATYPEPROTOTYPE_ID = "EAST-ADL2::Infrastructure::Datatypes::EADatatypePrototype";

	public static String EAELEMENT_ID = "EAST-ADL2::Infrastructure::Elements::EAElement";

	public static String EAST_PROFILE_URI = "pathmap://EAST-ADL2_PROFILES/eastadl.profile.uml";

	public static String ENUMERATIONVALUETYPE_ID = "EAST-ADL2::Infrastructure::Datatypes::EnumerationValueType";

	public static String ENVIRONMENT_ID = "EAST-ADL2::Environment::Environment";

	public static String ERRORBEHAVIOR_ID = "EAST-ADL2::Dependability::ErrorModel::ErrorBehavior";

	public static String ERRORMODELPROTOTYPE_ID = "EAST-ADL2::Dependability::ErrorModel::ErrorModelPrototype";

	public static String ERRORMODELTYPE_ID = "EAST-ADL2::Dependability::ErrorModel::ErrorModelType";

	public static String EVENT_ID = "EAST-ADL2::Timing::Event";

	public static String EVENTCHAIN_ID = "EAST-ADL2::Timing::EventChain";

	public static String EVENTCONSTRAINT_ID = "EAST-ADL2::Timing::TimingConstraints::EventConstraint";

	public static String EVENTFUNCTION_ID = "EAST-ADL2::Timing::Events::EventFunction";

	public static String EVENTFUNCTIONCLIENTSERVERPORT_ID = "EAST-ADL2::Timing::Events::EventFunctionClientServerPort";

	public static String EVENTFUNCTIONFLOWPORT_ID = "EAST-ADL2::Timing::Events::EventFunctionFlowPort";

	public static String EXECUTIONTIMECONSTRAINT_ID = "EAST-ADL2::Timing::ExecutionTimeConstraint";

	public static String FAILUREOUTPORT_ID = "EAST-ADL2::Dependability::ErrorModel::FailureOutPort";

	public static String FAULTFAILURE_ID = "EAST-ADL2::Dependability::SafetyConstraints::FaultFailure";

	public static String FAULTFAILUREPROPAGATIONLINK_ID = "EAST-ADL2::Dependability::ErrorModel::FaultFailurePropagationLink";

	public static String FAULTINPORT_ID = "EAST-ADL2::Dependability::ErrorModel::FaultInPort";

	public static String FAULTFAILUREPORT_ID = "EAST-ADL2::Dependability::ErrorModel::FaultFailurePort";

	public static String FEATURE_ID = "EAST-ADL2::Structure::FeatureModeling::Feature";

	public static String FEATURECONFIGURATION_ID = "EAST-ADL2::Variability::FeatureConfiguration";

	public static String FEATURECONSTRAINT_ID = "EAST-ADL2::Structure::FeatureModeling::FeatureConstraint";

	public static String FEATUREFLAW_ID = "EAST-ADL2::Dependability::FeatureFlaw";

	public static String DEPENDABILITY_ID = "EAST-ADL2::Dependability::Dependability";

	public static String FEATUREGROUP_ID = "EAST-ADL2::Structure::FeatureModeling::FeatureGroup";

	public static String FEATURELINK_ID = "EAST-ADL2::Structure::FeatureModeling::FeatureLink";

	public static String FEATUREMODEL_ID = "EAST-ADL2::Structure::FeatureModeling::FeatureModel";

	public static String FEATURETREENODE_ID = "EAST-ADL2::Structure::FeatureModeling::FeatureTreeNode";

	public static String FUNCTIONALDEVICE_ID = "EAST-ADL2::Structure::FunctionModeling::FunctionalDevice";

	public static String FUNCTIONALLOCATION_ID = "EAST-ADL2::Structure::FunctionModeling::FunctionAllocation";

	public static String FUNCTIONALSAFETYCONCEPT_ID = "EAST-ADL2::Dependability::SafetyRequirement::FunctionalSafetyConcept";

	public static String FUNCTIONBEHAVIOR_ID = "EAST-ADL2::Behavior::FunctionBehavior";

	public static String FUNCTIONCLIENTSERVERINTERFACE_ID = "EAST-ADL2::Structure::FunctionModeling::FunctionClientServerInterface";

	public static String FUNCTIONCLIENTSERVERPORT_ID = "EAST-ADL2::Structure::FunctionModeling::FunctionClientServerPort";

	public static String FUNCTIONCONNECTOR_ID = "EAST-ADL2::Structure::FunctionModeling::FunctionConnector";

	public static String FUNCTIONFLOWPORT_ID = "EAST-ADL2::Structure::FunctionModeling::FunctionFlowPort";

	public static String FUNCTIONPORT_ID = "EAST-ADL2::Structure::FunctionModeling::FunctionPort";

	public static String FUNCTIONPOWERPORT_ID = "EAST-ADL2::Structure::FunctionModeling::FunctionPowerPort";

	public static String FUNCTIONPROTOTYPE_ID = "EAST-ADL2::Structure::FunctionModeling::FunctionPrototype";

	public static String FUNCTIONTRIGGER_ID = "EAST-ADL2::Behavior::FunctionTrigger";

	public static String FUNCTIONTYPE_ID = "EAST-ADL2::Structure::FunctionModeling::FunctionType";

	public static String GENERICCONSTRAINT_ID = "EAST-ADL2::GenericConstraints::GenericConstraint";

	public static String TAKERATECONSTRAINT_ID = "EAST-ADL2::GenericConstraints::TakeRateConstraint";

	public static String GENERICCONSTRAINTSET_ID = "EAST-ADL2::GenericConstraints::GenericConstraintSet";

	public static String GROUND_ID = "EAST-ADL2::Dependability::SafetyCase::Ground";

	public static String HARDWARECOMPONENTPROTOTYPE_ID = "EAST-ADL2::Structure::HardwareModeling::HardwareComponentPrototype";

	public static String HARDWARECOMPONENTTYPE_ID = "EAST-ADL2::Structure::HardwareModeling::HardwareComponentType";

	public static String HARDWARECONNECTOR_ID = "EAST-ADL2::Structure::HardwareModeling::HardwareConnector";

	public static String HARDWAREFUNCTIONTYPE_ID = "EAST-ADL2::Structure::FunctionModeling::HardwareFunctionType";

	public static String HARDWAREPIN_ID = "EAST-ADL2::Structure::HardwareModeling::HardwarePin";

	public static String HARDWAREPINGROUP_ID = "EAST-ADL2::Structure::HardwareModeling::HardwarePinGroup";

	public static String HAZARD_ID = "EAST-ADL2::Dependability::Hazard";

	public static String HAZARDOUSEVENT_ID = "EAST-ADL2::Dependability::HazardousEvent";

	public static String IMPLEMENTATIONLEVEL_ID = "EAST-ADL2::Structure::SystemModeling::ImplementationLevel";

	public static String INPUTSYNCHRONIZATIONCONSTRAINT_ID = "EAST-ADL2::Timing::TimingConstraints::InputSynchronizationConstraint";

	public static String INTERNALBINDING_ID = "EAST-ADL2::Variability::InternalBinding";

	public static String INTERNALFAULTPROTOTYPE_ID = "EAST-ADL2::Dependability::ErrorModel::InternalFaultPrototype";

	public static String IOHARDWAREPIN_ID = "EAST-ADL2::Structure::HardwareModeling::IOHardwarePin";

	public static String ITEM_ID = "EAST-ADL2::Dependability::Item";

	public static String LOCALDEVICEMANAGER_ID = "EAST-ADL2::Structure::FunctionModeling::LocalDeviceManager";

	public static String LOGICALBUS_ID = "EAST-ADL2::Structure::HardwareModeling::LogicalBus";

	public static String MISSION_ID = "EAST-ADL2::Annex::Needs::Mission";

	public static String MODE_ID = "EAST-ADL2::Behavior::Mode";

	public static String MODEGROUP_ID = "EAST-ADL2::Behavior::ModeGroup";

	public static String MULTILEVELREFERENCE_ID = "EAST-ADL2::Infrastructure::Elements::MultiLevelReference";

	public static String NODE_ID = "EAST-ADL2::Structure::HardwareModeling::Node";

	public static String OPERATION_ID = "EAST-ADL2::Structure::FunctionModeling::Operation";

	public static String OUTPUTSYNCHRONISATIONCONSTRAINT_ID = "EAST-ADL2::Timing::TimingConstraints::OutputSynchronisationConstraint";

	public static String PERIODICEVENTCONSTRAINT_ID = "EAST-ADL2::Timing::TimingConstraints::PeriodicEventConstraint";

	public static String PORTGROUP_ID = "EAST-ADL2::Structure::FunctionModeling::PortGroup";

	public static String POWERHARDWAREPIN_ID = "EAST-ADL2::Structure::HardwareModeling::PowerHardwarePin";

	public static String POWERSUPPLY_ID = "EAST-ADL2::Structure::HardwareModeling::PowerSupply";

	public static String PRECEDENCECONSTRAINT_ID = "EAST-ADL2::Timing::PrecedenceConstraint";

	// Stereotypes ids
	public static String PRIVATECONTENT_ID = "EAST-ADL2::Variability::PrivateContent";

	public static String PROBLEMSTATEMENT_ID = "EAST-ADL2::Annex::Needs::ProblemStatement";

	public static String PROCESSFAULTPROTOTYPE_ID = "EAST-ADL2::Dependability::ErrorModel::ProcessFaultPrototype";

	public static String PRODUCTPOSITIONING_ID = "EAST-ADL2::Annex::Needs::ProductPositioning";

	public static String QUALITYREQUIREMENT_ID = "EAST-ADL2::Requirements::QualityRequirement";

	public static String QUANTITATIVESAFETYCONSTRAINT_ID = "EAST-ADL2::Dependability::SafetyConstraints::QuantitativeSafetyConstraint";

	public static String RANGEABLEDATATYPE_ID = "EAST-ADL2::Infrastructure::Datatypes::RangeableDatatype";

	public static String RANGEABLEVALUETYPE_ID = "EAST-ADL2::Infrastructure::Datatypes::RangeableValueType";

	public static String REACTIONCONSTRAINT_ID = "EAST-ADL2::Timing::TimingConstraints::ReactionConstraint";

	public static String REALIZATION_ID = "EAST-ADL2::Infrastructure::Elements::Realization";

	public static String REFINE_ID = "EAST-ADL2::Requirements::Refine";

	public static String RELATIONSHIP_ID = "EAST-ADL2::Infrastructure::Elements::Relationship";

	public static String REQUIREMENT_ID = "EAST-ADL2::Requirements::Requirement";

	public static String REQUIREMENTSCONTAINER_ID = "EAST-ADL2::Requirements::RequirementsContainer";

	public static String REQUIREMENTSLINK_ID = "EAST-ADL2::Requirements::RequirementsLink";

	public static String REQUIREMENTSMODEL_ID = "EAST-ADL2::Requirements::RequirementsModel";

	public static String REQUIREMENTSPECIFICATIONOBJECT_ID = "EAST-ADL2::Requirements::RequirementSpecificationObject";

	public static String REQUIREMENTSRELATEDINFORMATION_ID = "EAST-ADL2::Requirements::RequirementsRelatedInformation";

	public static String REQUIREMENTSRELATIONGROUP_ID = "EAST-ADL2::Requirements::RequirementsRelationGroup";

	public static String REQUIREMENTSRELATIONSHIP_ID = "EAST-ADL2::Requirements::RequirementsRelationship";

	public static String REUSEMETAINFORMATION_ID = "EAST-ADL2::Variability::ReuseMetaInformation";

	public static String RIFAREA_ID = "EAST-ADL2::Interchange::RIFArea";

	public static String RIFEXPORTAREA_ID = "EAST-ADL2::Interchange::RIFExportArea";

	public static String RIFIMPORTAREA_ID = "EAST-ADL2::Interchange::RIFImportArea";

	public static String SAFETYCASE_ID = "EAST-ADL2::Dependability::SafetyCase::SafetyCase";

	public static String SAFETYCONSTRAINT_ID = "EAST-ADL2::Dependability::SafetyConstraints::SafetyConstraint";

	public static String SAFETYGOAL_ID = "EAST-ADL2::Dependability::SafetyRequirement::SafetyGoal";

	public static String SATISFY_ID = "EAST-ADL2::Requirements::Satisfy";

	public static String SELECTIONCRITERION_ID = "EAST-ADL2::Variability::SelectionCriterion";

	public static String SENSOR_ID = "EAST-ADL2::Structure::HardwareModeling::Sensor";

	public static String SPORADICEVENTCONSTRAINT_ID = "EAST-ADL2::Timing::TimingConstraints::SporadicEventConstraint";

	public static String STAKEHOLDER_ID = "EAST-ADL2::Annex::Needs::Stakeholder";

	public static String STAKEHOLDERNEED_ID = "EAST-ADL2::Annex::Needs::StakeholderNeed";

	public static String VEHICLESYSTEM_ID = "EAST-ADL2::Annex::Needs::VehicleSystem";

	public static String SYSTEMMODEL_ID = "EAST-ADL2::Structure::SystemModeling::SystemModel";

	public static String TECHNICALSAFETYCONCEPT_ID = "EAST-ADL2::Dependability::SafetyRequirement::TechnicalSafetyConcept";

	public static String TIMEDURATION_ID = "EAST-ADL2::Timing::TimeDuration";

	public static String TIMING_ID = "EAST-ADL2::Timing::Timing";

	public static String TIMINGCONSTRAINT_ID = "EAST-ADL2::Timing::TimingConstraint";

	public static String TIMINGDESCRIPTION_ID = "EAST-ADL2::Timing::TimingDescription";

	public static String TRACEABLESPECIFICATION_ID = "EAST-ADL2::Infrastructure::Elements::TraceableSpecification";

	public static String OPERATIONALSITUATION_ID = "EAST-ADL2::Requirements::OperationalSituation";

	public static String USERATTRIBUTEABLEELEMENT_ID = "EAST-ADL2::Infrastructure::UserAttributes::UserAttributeableElement";

	public static String USERATTRIBUTEDEFINITION_ID = "EAST-ADL2::Infrastructure::UserAttributes::UserAttributeDefinition";

	public static String USERATTRIBUTEELEMENTTYPE_ID = "EAST-ADL2::Infrastructure::UserAttributes::UserAttributeElementType";

	public static String USERATTRIBUTEVALUE_ID = "EAST-ADL2::Infrastructure::UserAttributes::UserAttributeValue";

	public static String VALUETYPE_ID = "EAST-ADL2::Infrastructure::Datatypes::ValueType";

	public static String VARIABILITY_ID = "EAST-ADL2::Variability::Variability";

	public static String VARIABLEELEMENT_ID = "EAST-ADL2::Variability::VariableElement";

	public static String VARIATIONGROUP_ID = "EAST-ADL2::Variability::VariationGroup";

	public static String VEHICLEFEATURE_ID = "EAST-ADL2::Structure::VehicleFeatureModeling::VehicleFeature";

	public static String VEHICLELEVEL_ID = "EAST-ADL2::Structure::SystemModeling::VehicleLevel";

	public static String VEHICLELEVELCONFIGURATIONDECISIONMODEL_ID = "EAST-ADL2::Variability::VehicleLevelConfigurationDecisionModel";

	public static String VERIFICATIONVALIDATION_ID = "EAST-ADL2::Requirements::VerificationValidation::VerificationValidation";

	public static String VERIFY_ID = "EAST-ADL2::Requirements::VerificationValidation::Verify";

	public static String VVACTUALOUTCOME_ID = "EAST-ADL2::Requirements::VerificationValidation::VVActualOutcome";

	public static String VVCASE_ID = "EAST-ADL2::Requirements::VerificationValidation::VVCase";

	public static String VVINTENDEDOUTCOME_ID = "EAST-ADL2::Requirements::VerificationValidation::VVIntendedOutcome";

	public static String VVLOG_ID = "EAST-ADL2::Requirements::VerificationValidation::VVLog";

	public static String VVPROCEDURE_ID = "EAST-ADL2::Requirements::VerificationValidation::VVProcedure";

	public static String VVSTIMULI_ID = "EAST-ADL2::Requirements::VerificationValidation::VVStimuli";

	public static String VVTARGET_ID = "EAST-ADL2::Requirements::VerificationValidation::VVTarget";

	public static String WARRANT_ID = "EAST-ADL2::Dependability::SafetyCase::Warrant";

}
