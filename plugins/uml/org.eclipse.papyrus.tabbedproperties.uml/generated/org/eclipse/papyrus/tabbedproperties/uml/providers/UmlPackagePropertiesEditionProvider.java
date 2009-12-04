/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.tabbedproperties.uml.providers;

import org.eclipse.emf.eef.runtime.impl.providers.ComposedPropertiesEditionProvider;

/**
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class UmlPackagePropertiesEditionProvider extends ComposedPropertiesEditionProvider {

	/**
	 * Default Constructor
	 */
	public UmlPackagePropertiesEditionProvider() {
		super();
		append(createClass_PropertiesEditionProvider());
		append(createAssociationClassPropertiesEditionProvider());
		append(createLiteralUnlimitedNaturalPropertiesEditionProvider());
		append(createInstanceValuePropertiesEditionProvider());
		append(createLiteralNullPropertiesEditionProvider());
		append(createLiteralBooleanPropertiesEditionProvider());
		append(createLiteralStringPropertiesEditionProvider());
		append(createLiteralIntegerPropertiesEditionProvider());
		append(createPrimitiveTypePropertiesEditionProvider());
		append(createInstanceSpecificationPropertiesEditionProvider());
		append(createSlotPropertiesEditionProvider());
		append(createEnumerationLiteralPropertiesEditionProvider());
		append(createEnumerationPropertiesEditionProvider());
		append(createPackageMergePropertiesEditionProvider());
		append(createUsagePropertiesEditionProvider());
		append(createExpressionPropertiesEditionProvider());
		append(createStringExpressionPropertiesEditionProvider());
		append(createInterfaceRealizationPropertiesEditionProvider());
		append(createOperationPropertiesEditionProvider());
		append(createPropertyPropertiesEditionProvider());
		append(createParameterPropertiesEditionProvider());
		append(createOpaqueExpressionPropertiesEditionProvider());
		append(createGeneralizationPropertiesEditionProvider());
		append(createGeneralizationSetPropertiesEditionProvider());
		append(createSubstitutionPropertiesEditionProvider());
		append(createRealizationPropertiesEditionProvider());
		append(createAbstractionPropertiesEditionProvider());
		append(createCommentPropertiesEditionProvider());
		append(createPackage_PropertiesEditionProvider());
		append(createDependencyPropertiesEditionProvider());
		append(createElementImportPropertiesEditionProvider());
		append(createPackageImportPropertiesEditionProvider());
		append(createConstraintPropertiesEditionProvider());
		append(createAssociationPropertiesEditionProvider());
		append(createComponentPropertiesEditionProvider());
		append(createComponentRealizationPropertiesEditionProvider());
		append(createConnectorPropertiesEditionProvider());
		append(createPortPropertiesEditionProvider());
		append(createTriggerPropertiesEditionProvider());
		append(createConnectorEndPropertiesEditionProvider());
		append(createExecutionEnvironmentPropertiesEditionProvider());
		append(createDevicePropertiesEditionProvider());
		append(createCommunicationPathPropertiesEditionProvider());
		append(createNodePropertiesEditionProvider());
		append(createDeploymentPropertiesEditionProvider());
		append(createDeploymentSpecificationPropertiesEditionProvider());
		append(createArtifactPropertiesEditionProvider());
		append(createManifestationPropertiesEditionProvider());
		append(createReduceActionPropertiesEditionProvider());
		append(createUnmarshallActionPropertiesEditionProvider());
		append(createAcceptCallActionPropertiesEditionProvider());
		append(createReplyActionPropertiesEditionProvider());
		append(createAcceptEventActionPropertiesEditionProvider());
		append(createCreateLinkObjectActionPropertiesEditionProvider());
		append(createReadLinkObjectEndQualifierActionPropertiesEditionProvider());
		append(createReadLinkObjectEndActionPropertiesEditionProvider());
		append(createStartClassifierBehaviorActionPropertiesEditionProvider());
		append(createReadIsClassifiedObjectActionPropertiesEditionProvider());
		append(createReclassifyObjectActionPropertiesEditionProvider());
		append(createReadExtentActionPropertiesEditionProvider());
		append(createRaiseExceptionActionPropertiesEditionProvider());
		append(createRemoveVariableValueActionPropertiesEditionProvider());
		append(createAddVariableValueActionPropertiesEditionProvider());
		append(createClearVariableActionPropertiesEditionProvider());
		append(createReadVariableActionPropertiesEditionProvider());
		append(createValueSpecificationActionPropertiesEditionProvider());
		append(createCreateObjectActionPropertiesEditionProvider());
		append(createDestroyObjectActionPropertiesEditionProvider());
		append(createTestIdentityActionPropertiesEditionProvider());
		append(createReadSelfActionPropertiesEditionProvider());
		append(createReadStructuralFeatureActionPropertiesEditionProvider());
		append(createClearStructuralFeatureActionPropertiesEditionProvider());
		append(createRemoveStructuralFeatureValueActionPropertiesEditionProvider());
		append(createAddStructuralFeatureValueActionPropertiesEditionProvider());
		append(createLinkEndDataPropertiesEditionProvider());
		append(createQualifierValuePropertiesEditionProvider());
		append(createReadLinkActionPropertiesEditionProvider());
		append(createLinkEndCreationDataPropertiesEditionProvider());
		append(createCreateLinkActionPropertiesEditionProvider());
		append(createDestroyLinkActionPropertiesEditionProvider());
		append(createLinkEndDestructionDataPropertiesEditionProvider());
		append(createClearAssociationActionPropertiesEditionProvider());
		append(createBroadcastSignalActionPropertiesEditionProvider());
		append(createSendObjectActionPropertiesEditionProvider());
		append(createValuePinPropertiesEditionProvider());
		append(createCallBehaviorActionPropertiesEditionProvider());
		append(createCallOperationActionPropertiesEditionProvider());
		append(createSendSignalActionPropertiesEditionProvider());
		append(createOpaqueActionPropertiesEditionProvider());
		append(createExpansionRegionPropertiesEditionProvider());
		append(createExpansionNodePropertiesEditionProvider());
		append(createLoopNodePropertiesEditionProvider());
		append(createClausePropertiesEditionProvider());
		append(createConditionalNodePropertiesEditionProvider());
		append(createObjectFlowPropertiesEditionProvider());
		append(createDataStoreNodePropertiesEditionProvider());
		append(createJoinNodePropertiesEditionProvider());
		append(createActionInputPinPropertiesEditionProvider());
		append(createActivityFinalNodePropertiesEditionProvider());
		append(createDecisionNodePropertiesEditionProvider());
		append(createMergeNodePropertiesEditionProvider());
		append(createCentralBufferNodePropertiesEditionProvider());
		append(createFlowFinalNodePropertiesEditionProvider());
		append(createForkNodePropertiesEditionProvider());
		append(createAnyReceiveEventPropertiesEditionProvider());
		append(createActivityParameterNodePropertiesEditionProvider());
		append(createInitialNodePropertiesEditionProvider());
		append(createControlFlowPropertiesEditionProvider());
		append(createSequenceNodePropertiesEditionProvider());
		append(createInputPinPropertiesEditionProvider());
		append(createPinPropertiesEditionProvider());
		append(createOutputPinPropertiesEditionProvider());
		append(createExceptionHandlerPropertiesEditionProvider());
		append(createInterruptibleActivityRegionPropertiesEditionProvider());
		append(createActivityPartitionPropertiesEditionProvider());
		append(createVariablePropertiesEditionProvider());
		append(createActivityPropertiesEditionProvider());
		append(createStructuredActivityNodePropertiesEditionProvider());
		append(createDataTypePropertiesEditionProvider());
		append(createParameterSetPropertiesEditionProvider());
		append(createDurationObservationPropertiesEditionProvider());
		append(createTimeObservationPropertiesEditionProvider());
		append(createDurationConstraintPropertiesEditionProvider());
		append(createTimeIntervalPropertiesEditionProvider());
		append(createIntervalConstraintPropertiesEditionProvider());
		append(createTimeConstraintPropertiesEditionProvider());
		append(createIntervalPropertiesEditionProvider());
		append(createDurationIntervalPropertiesEditionProvider());
		append(createDurationPropertiesEditionProvider());
		append(createTimeExpressionPropertiesEditionProvider());
		append(createSignalEventPropertiesEditionProvider());
		append(createChangeEventPropertiesEditionProvider());
		append(createCallEventPropertiesEditionProvider());
		append(createFunctionBehaviorPropertiesEditionProvider());
		append(createOpaqueBehaviorPropertiesEditionProvider());
		append(createSignalPropertiesEditionProvider());
		append(createReceptionPropertiesEditionProvider());
		append(createInterface_PropertiesEditionProvider());
		append(createConsiderIgnoreFragmentPropertiesEditionProvider());
		append(createContinuationPropertiesEditionProvider());
		append(createCombinedFragmentPropertiesEditionProvider());
		append(createReceiveSignalEventPropertiesEditionProvider());
		append(createReceiveOperationEventPropertiesEditionProvider());
		append(createExecutionOccurrenceSpecificationPropertiesEditionProvider());
		append(createMessageOccurrenceSpecificationPropertiesEditionProvider());
		append(createSendSignalEventPropertiesEditionProvider());
		append(createSendOperationEventPropertiesEditionProvider());
		append(createDestructionEventPropertiesEditionProvider());
		append(createCreationEventPropertiesEditionProvider());
		append(createExecutionEventPropertiesEditionProvider());
		append(createBehaviorExecutionSpecificationPropertiesEditionProvider());
		append(createActionExecutionSpecificationPropertiesEditionProvider());
		append(createStateInvariantPropertiesEditionProvider());
		append(createInteractionConstraintPropertiesEditionProvider());
		append(createInteractionOperandPropertiesEditionProvider());
		append(createOccurrenceSpecificationPropertiesEditionProvider());
		append(createGeneralOrderingPropertiesEditionProvider());
		append(createGatePropertiesEditionProvider());
		append(createInteractionUsePropertiesEditionProvider());
		append(createPartDecompositionPropertiesEditionProvider());
		append(createLifelinePropertiesEditionProvider());
		append(createInteractionPropertiesEditionProvider());
		append(createMessagePropertiesEditionProvider());
		append(createProtocolTransitionPropertiesEditionProvider());
		append(createTimeEventPropertiesEditionProvider());
		append(createFinalStatePropertiesEditionProvider());
		append(createProtocolConformancePropertiesEditionProvider());
		append(createStatePropertiesEditionProvider());
		append(createConnectionPointReferencePropertiesEditionProvider());
		append(createPseudostatePropertiesEditionProvider());
		append(createProtocolStateMachinePropertiesEditionProvider());
		append(createStateMachinePropertiesEditionProvider());
		append(createRegionPropertiesEditionProvider());
		append(createTransitionPropertiesEditionProvider());
		append(createActorPropertiesEditionProvider());
		append(createExtensionPointPropertiesEditionProvider());
		append(createCollaborationUsePropertiesEditionProvider());
		append(createCollaborationPropertiesEditionProvider());
		append(createUseCasePropertiesEditionProvider());
		append(createIncludePropertiesEditionProvider());
		append(createExtendPropertiesEditionProvider());
		append(createInformationFlowPropertiesEditionProvider());
		append(createInformationItemPropertiesEditionProvider());
		append(createClassifierTemplateParameterPropertiesEditionProvider());
		append(createRedefinableTemplateSignaturePropertiesEditionProvider());
		append(createOperationTemplateParameterPropertiesEditionProvider());
		append(createModelPropertiesEditionProvider());
		append(createConnectableElementTemplateParameterPropertiesEditionProvider());
		append(createTemplateBindingPropertiesEditionProvider());
		append(createTemplateSignaturePropertiesEditionProvider());
		append(createTemplateParameterPropertiesEditionProvider());
		append(createTemplateParameterSubstitutionPropertiesEditionProvider());
		append(createProfileApplicationPropertiesEditionProvider());
		append(createProfilePropertiesEditionProvider());
		append(createImagePropertiesEditionProvider());
		append(createExtensionPropertiesEditionProvider());
		append(createExtensionEndPropertiesEditionProvider());
		append(createStereotypePropertiesEditionProvider());
		append(createElementPropertiesEditionProvider());
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Class instances.
	 */
	protected Class_PropertiesEditionProvider class_PropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Class
	 */
	public Class_PropertiesEditionProvider createClass_PropertiesEditionProvider() {
		if(class_PropertiesEditionProvider == null)
			class_PropertiesEditionProvider = new Class_PropertiesEditionProvider();
		return class_PropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * AssociationClass instances.
	 */
	protected AssociationClassPropertiesEditionProvider associationClassPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a AssociationClass
	 */
	public AssociationClassPropertiesEditionProvider createAssociationClassPropertiesEditionProvider() {
		if(associationClassPropertiesEditionProvider == null)
			associationClassPropertiesEditionProvider = new AssociationClassPropertiesEditionProvider();
		return associationClassPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * LiteralUnlimitedNatural instances.
	 */
	protected LiteralUnlimitedNaturalPropertiesEditionProvider literalUnlimitedNaturalPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a LiteralUnlimitedNatural
	 */
	public LiteralUnlimitedNaturalPropertiesEditionProvider createLiteralUnlimitedNaturalPropertiesEditionProvider() {
		if(literalUnlimitedNaturalPropertiesEditionProvider == null)
			literalUnlimitedNaturalPropertiesEditionProvider = new LiteralUnlimitedNaturalPropertiesEditionProvider();
		return literalUnlimitedNaturalPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * InstanceValue instances.
	 */
	protected InstanceValuePropertiesEditionProvider instanceValuePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a InstanceValue
	 */
	public InstanceValuePropertiesEditionProvider createInstanceValuePropertiesEditionProvider() {
		if(instanceValuePropertiesEditionProvider == null)
			instanceValuePropertiesEditionProvider = new InstanceValuePropertiesEditionProvider();
		return instanceValuePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * LiteralNull instances.
	 */
	protected LiteralNullPropertiesEditionProvider literalNullPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a LiteralNull
	 */
	public LiteralNullPropertiesEditionProvider createLiteralNullPropertiesEditionProvider() {
		if(literalNullPropertiesEditionProvider == null)
			literalNullPropertiesEditionProvider = new LiteralNullPropertiesEditionProvider();
		return literalNullPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * LiteralBoolean instances.
	 */
	protected LiteralBooleanPropertiesEditionProvider literalBooleanPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a LiteralBoolean
	 */
	public LiteralBooleanPropertiesEditionProvider createLiteralBooleanPropertiesEditionProvider() {
		if(literalBooleanPropertiesEditionProvider == null)
			literalBooleanPropertiesEditionProvider = new LiteralBooleanPropertiesEditionProvider();
		return literalBooleanPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * LiteralString instances.
	 */
	protected LiteralStringPropertiesEditionProvider literalStringPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a LiteralString
	 */
	public LiteralStringPropertiesEditionProvider createLiteralStringPropertiesEditionProvider() {
		if(literalStringPropertiesEditionProvider == null)
			literalStringPropertiesEditionProvider = new LiteralStringPropertiesEditionProvider();
		return literalStringPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * LiteralInteger instances.
	 */
	protected LiteralIntegerPropertiesEditionProvider literalIntegerPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a LiteralInteger
	 */
	public LiteralIntegerPropertiesEditionProvider createLiteralIntegerPropertiesEditionProvider() {
		if(literalIntegerPropertiesEditionProvider == null)
			literalIntegerPropertiesEditionProvider = new LiteralIntegerPropertiesEditionProvider();
		return literalIntegerPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * PrimitiveType instances.
	 */
	protected PrimitiveTypePropertiesEditionProvider primitiveTypePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a PrimitiveType
	 */
	public PrimitiveTypePropertiesEditionProvider createPrimitiveTypePropertiesEditionProvider() {
		if(primitiveTypePropertiesEditionProvider == null)
			primitiveTypePropertiesEditionProvider = new PrimitiveTypePropertiesEditionProvider();
		return primitiveTypePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * InstanceSpecification instances.
	 */
	protected InstanceSpecificationPropertiesEditionProvider instanceSpecificationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a InstanceSpecification
	 */
	public InstanceSpecificationPropertiesEditionProvider createInstanceSpecificationPropertiesEditionProvider() {
		if(instanceSpecificationPropertiesEditionProvider == null)
			instanceSpecificationPropertiesEditionProvider = new InstanceSpecificationPropertiesEditionProvider();
		return instanceSpecificationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Slot instances.
	 */
	protected SlotPropertiesEditionProvider slotPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Slot
	 */
	public SlotPropertiesEditionProvider createSlotPropertiesEditionProvider() {
		if(slotPropertiesEditionProvider == null)
			slotPropertiesEditionProvider = new SlotPropertiesEditionProvider();
		return slotPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * EnumerationLiteral instances.
	 */
	protected EnumerationLiteralPropertiesEditionProvider enumerationLiteralPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a EnumerationLiteral
	 */
	public EnumerationLiteralPropertiesEditionProvider createEnumerationLiteralPropertiesEditionProvider() {
		if(enumerationLiteralPropertiesEditionProvider == null)
			enumerationLiteralPropertiesEditionProvider = new EnumerationLiteralPropertiesEditionProvider();
		return enumerationLiteralPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Enumeration instances.
	 */
	protected EnumerationPropertiesEditionProvider enumerationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Enumeration
	 */
	public EnumerationPropertiesEditionProvider createEnumerationPropertiesEditionProvider() {
		if(enumerationPropertiesEditionProvider == null)
			enumerationPropertiesEditionProvider = new EnumerationPropertiesEditionProvider();
		return enumerationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * PackageMerge instances.
	 */
	protected PackageMergePropertiesEditionProvider packageMergePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a PackageMerge
	 */
	public PackageMergePropertiesEditionProvider createPackageMergePropertiesEditionProvider() {
		if(packageMergePropertiesEditionProvider == null)
			packageMergePropertiesEditionProvider = new PackageMergePropertiesEditionProvider();
		return packageMergePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Usage instances.
	 */
	protected UsagePropertiesEditionProvider usagePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Usage
	 */
	public UsagePropertiesEditionProvider createUsagePropertiesEditionProvider() {
		if(usagePropertiesEditionProvider == null)
			usagePropertiesEditionProvider = new UsagePropertiesEditionProvider();
		return usagePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Expression instances.
	 */
	protected ExpressionPropertiesEditionProvider expressionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Expression
	 */
	public ExpressionPropertiesEditionProvider createExpressionPropertiesEditionProvider() {
		if(expressionPropertiesEditionProvider == null)
			expressionPropertiesEditionProvider = new ExpressionPropertiesEditionProvider();
		return expressionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * StringExpression instances.
	 */
	protected StringExpressionPropertiesEditionProvider stringExpressionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a StringExpression
	 */
	public StringExpressionPropertiesEditionProvider createStringExpressionPropertiesEditionProvider() {
		if(stringExpressionPropertiesEditionProvider == null)
			stringExpressionPropertiesEditionProvider = new StringExpressionPropertiesEditionProvider();
		return stringExpressionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * InterfaceRealization instances.
	 */
	protected InterfaceRealizationPropertiesEditionProvider interfaceRealizationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a InterfaceRealization
	 */
	public InterfaceRealizationPropertiesEditionProvider createInterfaceRealizationPropertiesEditionProvider() {
		if(interfaceRealizationPropertiesEditionProvider == null)
			interfaceRealizationPropertiesEditionProvider = new InterfaceRealizationPropertiesEditionProvider();
		return interfaceRealizationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Operation instances.
	 */
	protected OperationPropertiesEditionProvider operationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Operation
	 */
	public OperationPropertiesEditionProvider createOperationPropertiesEditionProvider() {
		if(operationPropertiesEditionProvider == null)
			operationPropertiesEditionProvider = new OperationPropertiesEditionProvider();
		return operationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Property instances.
	 */
	protected PropertyPropertiesEditionProvider propertyPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Property
	 */
	public PropertyPropertiesEditionProvider createPropertyPropertiesEditionProvider() {
		if(propertyPropertiesEditionProvider == null)
			propertyPropertiesEditionProvider = new PropertyPropertiesEditionProvider();
		return propertyPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Parameter instances.
	 */
	protected ParameterPropertiesEditionProvider parameterPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Parameter
	 */
	public ParameterPropertiesEditionProvider createParameterPropertiesEditionProvider() {
		if(parameterPropertiesEditionProvider == null)
			parameterPropertiesEditionProvider = new ParameterPropertiesEditionProvider();
		return parameterPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * OpaqueExpression instances.
	 */
	protected OpaqueExpressionPropertiesEditionProvider opaqueExpressionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a OpaqueExpression
	 */
	public OpaqueExpressionPropertiesEditionProvider createOpaqueExpressionPropertiesEditionProvider() {
		if(opaqueExpressionPropertiesEditionProvider == null)
			opaqueExpressionPropertiesEditionProvider = new OpaqueExpressionPropertiesEditionProvider();
		return opaqueExpressionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Generalization instances.
	 */
	protected GeneralizationPropertiesEditionProvider generalizationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Generalization
	 */
	public GeneralizationPropertiesEditionProvider createGeneralizationPropertiesEditionProvider() {
		if(generalizationPropertiesEditionProvider == null)
			generalizationPropertiesEditionProvider = new GeneralizationPropertiesEditionProvider();
		return generalizationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * GeneralizationSet instances.
	 */
	protected GeneralizationSetPropertiesEditionProvider generalizationSetPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a GeneralizationSet
	 */
	public GeneralizationSetPropertiesEditionProvider createGeneralizationSetPropertiesEditionProvider() {
		if(generalizationSetPropertiesEditionProvider == null)
			generalizationSetPropertiesEditionProvider = new GeneralizationSetPropertiesEditionProvider();
		return generalizationSetPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Substitution instances.
	 */
	protected SubstitutionPropertiesEditionProvider substitutionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Substitution
	 */
	public SubstitutionPropertiesEditionProvider createSubstitutionPropertiesEditionProvider() {
		if(substitutionPropertiesEditionProvider == null)
			substitutionPropertiesEditionProvider = new SubstitutionPropertiesEditionProvider();
		return substitutionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Realization instances.
	 */
	protected RealizationPropertiesEditionProvider realizationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Realization
	 */
	public RealizationPropertiesEditionProvider createRealizationPropertiesEditionProvider() {
		if(realizationPropertiesEditionProvider == null)
			realizationPropertiesEditionProvider = new RealizationPropertiesEditionProvider();
		return realizationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Abstraction instances.
	 */
	protected AbstractionPropertiesEditionProvider abstractionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Abstraction
	 */
	public AbstractionPropertiesEditionProvider createAbstractionPropertiesEditionProvider() {
		if(abstractionPropertiesEditionProvider == null)
			abstractionPropertiesEditionProvider = new AbstractionPropertiesEditionProvider();
		return abstractionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Comment instances.
	 */
	protected CommentPropertiesEditionProvider commentPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Comment
	 */
	public CommentPropertiesEditionProvider createCommentPropertiesEditionProvider() {
		if(commentPropertiesEditionProvider == null)
			commentPropertiesEditionProvider = new CommentPropertiesEditionProvider();
		return commentPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Package instances.
	 */
	protected Package_PropertiesEditionProvider package_PropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Package
	 */
	public Package_PropertiesEditionProvider createPackage_PropertiesEditionProvider() {
		if(package_PropertiesEditionProvider == null)
			package_PropertiesEditionProvider = new Package_PropertiesEditionProvider();
		return package_PropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Dependency instances.
	 */
	protected DependencyPropertiesEditionProvider dependencyPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Dependency
	 */
	public DependencyPropertiesEditionProvider createDependencyPropertiesEditionProvider() {
		if(dependencyPropertiesEditionProvider == null)
			dependencyPropertiesEditionProvider = new DependencyPropertiesEditionProvider();
		return dependencyPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ElementImport instances.
	 */
	protected ElementImportPropertiesEditionProvider elementImportPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ElementImport
	 */
	public ElementImportPropertiesEditionProvider createElementImportPropertiesEditionProvider() {
		if(elementImportPropertiesEditionProvider == null)
			elementImportPropertiesEditionProvider = new ElementImportPropertiesEditionProvider();
		return elementImportPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * PackageImport instances.
	 */
	protected PackageImportPropertiesEditionProvider packageImportPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a PackageImport
	 */
	public PackageImportPropertiesEditionProvider createPackageImportPropertiesEditionProvider() {
		if(packageImportPropertiesEditionProvider == null)
			packageImportPropertiesEditionProvider = new PackageImportPropertiesEditionProvider();
		return packageImportPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Constraint instances.
	 */
	protected ConstraintPropertiesEditionProvider constraintPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Constraint
	 */
	public ConstraintPropertiesEditionProvider createConstraintPropertiesEditionProvider() {
		if(constraintPropertiesEditionProvider == null)
			constraintPropertiesEditionProvider = new ConstraintPropertiesEditionProvider();
		return constraintPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Association instances.
	 */
	protected AssociationPropertiesEditionProvider associationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Association
	 */
	public AssociationPropertiesEditionProvider createAssociationPropertiesEditionProvider() {
		if(associationPropertiesEditionProvider == null)
			associationPropertiesEditionProvider = new AssociationPropertiesEditionProvider();
		return associationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Component instances.
	 */
	protected ComponentPropertiesEditionProvider componentPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Component
	 */
	public ComponentPropertiesEditionProvider createComponentPropertiesEditionProvider() {
		if(componentPropertiesEditionProvider == null)
			componentPropertiesEditionProvider = new ComponentPropertiesEditionProvider();
		return componentPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ComponentRealization instances.
	 */
	protected ComponentRealizationPropertiesEditionProvider componentRealizationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ComponentRealization
	 */
	public ComponentRealizationPropertiesEditionProvider createComponentRealizationPropertiesEditionProvider() {
		if(componentRealizationPropertiesEditionProvider == null)
			componentRealizationPropertiesEditionProvider = new ComponentRealizationPropertiesEditionProvider();
		return componentRealizationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Connector instances.
	 */
	protected ConnectorPropertiesEditionProvider connectorPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Connector
	 */
	public ConnectorPropertiesEditionProvider createConnectorPropertiesEditionProvider() {
		if(connectorPropertiesEditionProvider == null)
			connectorPropertiesEditionProvider = new ConnectorPropertiesEditionProvider();
		return connectorPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Port instances.
	 */
	protected PortPropertiesEditionProvider portPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Port
	 */
	public PortPropertiesEditionProvider createPortPropertiesEditionProvider() {
		if(portPropertiesEditionProvider == null)
			portPropertiesEditionProvider = new PortPropertiesEditionProvider();
		return portPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Trigger instances.
	 */
	protected TriggerPropertiesEditionProvider triggerPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Trigger
	 */
	public TriggerPropertiesEditionProvider createTriggerPropertiesEditionProvider() {
		if(triggerPropertiesEditionProvider == null)
			triggerPropertiesEditionProvider = new TriggerPropertiesEditionProvider();
		return triggerPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ConnectorEnd instances.
	 */
	protected ConnectorEndPropertiesEditionProvider connectorEndPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ConnectorEnd
	 */
	public ConnectorEndPropertiesEditionProvider createConnectorEndPropertiesEditionProvider() {
		if(connectorEndPropertiesEditionProvider == null)
			connectorEndPropertiesEditionProvider = new ConnectorEndPropertiesEditionProvider();
		return connectorEndPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ExecutionEnvironment instances.
	 */
	protected ExecutionEnvironmentPropertiesEditionProvider executionEnvironmentPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ExecutionEnvironment
	 */
	public ExecutionEnvironmentPropertiesEditionProvider createExecutionEnvironmentPropertiesEditionProvider() {
		if(executionEnvironmentPropertiesEditionProvider == null)
			executionEnvironmentPropertiesEditionProvider = new ExecutionEnvironmentPropertiesEditionProvider();
		return executionEnvironmentPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Device instances.
	 */
	protected DevicePropertiesEditionProvider devicePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Device
	 */
	public DevicePropertiesEditionProvider createDevicePropertiesEditionProvider() {
		if(devicePropertiesEditionProvider == null)
			devicePropertiesEditionProvider = new DevicePropertiesEditionProvider();
		return devicePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CommunicationPath instances.
	 */
	protected CommunicationPathPropertiesEditionProvider communicationPathPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CommunicationPath
	 */
	public CommunicationPathPropertiesEditionProvider createCommunicationPathPropertiesEditionProvider() {
		if(communicationPathPropertiesEditionProvider == null)
			communicationPathPropertiesEditionProvider = new CommunicationPathPropertiesEditionProvider();
		return communicationPathPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Node instances.
	 */
	protected NodePropertiesEditionProvider nodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Node
	 */
	public NodePropertiesEditionProvider createNodePropertiesEditionProvider() {
		if(nodePropertiesEditionProvider == null)
			nodePropertiesEditionProvider = new NodePropertiesEditionProvider();
		return nodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Deployment instances.
	 */
	protected DeploymentPropertiesEditionProvider deploymentPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Deployment
	 */
	public DeploymentPropertiesEditionProvider createDeploymentPropertiesEditionProvider() {
		if(deploymentPropertiesEditionProvider == null)
			deploymentPropertiesEditionProvider = new DeploymentPropertiesEditionProvider();
		return deploymentPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DeploymentSpecification instances.
	 */
	protected DeploymentSpecificationPropertiesEditionProvider deploymentSpecificationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DeploymentSpecification
	 */
	public DeploymentSpecificationPropertiesEditionProvider createDeploymentSpecificationPropertiesEditionProvider() {
		if(deploymentSpecificationPropertiesEditionProvider == null)
			deploymentSpecificationPropertiesEditionProvider = new DeploymentSpecificationPropertiesEditionProvider();
		return deploymentSpecificationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Artifact instances.
	 */
	protected ArtifactPropertiesEditionProvider artifactPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Artifact
	 */
	public ArtifactPropertiesEditionProvider createArtifactPropertiesEditionProvider() {
		if(artifactPropertiesEditionProvider == null)
			artifactPropertiesEditionProvider = new ArtifactPropertiesEditionProvider();
		return artifactPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Manifestation instances.
	 */
	protected ManifestationPropertiesEditionProvider manifestationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Manifestation
	 */
	public ManifestationPropertiesEditionProvider createManifestationPropertiesEditionProvider() {
		if(manifestationPropertiesEditionProvider == null)
			manifestationPropertiesEditionProvider = new ManifestationPropertiesEditionProvider();
		return manifestationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReduceAction instances.
	 */
	protected ReduceActionPropertiesEditionProvider reduceActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReduceAction
	 */
	public ReduceActionPropertiesEditionProvider createReduceActionPropertiesEditionProvider() {
		if(reduceActionPropertiesEditionProvider == null)
			reduceActionPropertiesEditionProvider = new ReduceActionPropertiesEditionProvider();
		return reduceActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * UnmarshallAction instances.
	 */
	protected UnmarshallActionPropertiesEditionProvider unmarshallActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a UnmarshallAction
	 */
	public UnmarshallActionPropertiesEditionProvider createUnmarshallActionPropertiesEditionProvider() {
		if(unmarshallActionPropertiesEditionProvider == null)
			unmarshallActionPropertiesEditionProvider = new UnmarshallActionPropertiesEditionProvider();
		return unmarshallActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * AcceptCallAction instances.
	 */
	protected AcceptCallActionPropertiesEditionProvider acceptCallActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a AcceptCallAction
	 */
	public AcceptCallActionPropertiesEditionProvider createAcceptCallActionPropertiesEditionProvider() {
		if(acceptCallActionPropertiesEditionProvider == null)
			acceptCallActionPropertiesEditionProvider = new AcceptCallActionPropertiesEditionProvider();
		return acceptCallActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReplyAction instances.
	 */
	protected ReplyActionPropertiesEditionProvider replyActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReplyAction
	 */
	public ReplyActionPropertiesEditionProvider createReplyActionPropertiesEditionProvider() {
		if(replyActionPropertiesEditionProvider == null)
			replyActionPropertiesEditionProvider = new ReplyActionPropertiesEditionProvider();
		return replyActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * AcceptEventAction instances.
	 */
	protected AcceptEventActionPropertiesEditionProvider acceptEventActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a AcceptEventAction
	 */
	public AcceptEventActionPropertiesEditionProvider createAcceptEventActionPropertiesEditionProvider() {
		if(acceptEventActionPropertiesEditionProvider == null)
			acceptEventActionPropertiesEditionProvider = new AcceptEventActionPropertiesEditionProvider();
		return acceptEventActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CreateLinkObjectAction instances.
	 */
	protected CreateLinkObjectActionPropertiesEditionProvider createLinkObjectActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CreateLinkObjectAction
	 */
	public CreateLinkObjectActionPropertiesEditionProvider createCreateLinkObjectActionPropertiesEditionProvider() {
		if(createLinkObjectActionPropertiesEditionProvider == null)
			createLinkObjectActionPropertiesEditionProvider = new CreateLinkObjectActionPropertiesEditionProvider();
		return createLinkObjectActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReadLinkObjectEndQualifierAction instances.
	 */
	protected ReadLinkObjectEndQualifierActionPropertiesEditionProvider readLinkObjectEndQualifierActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReadLinkObjectEndQualifierAction
	 */
	public ReadLinkObjectEndQualifierActionPropertiesEditionProvider createReadLinkObjectEndQualifierActionPropertiesEditionProvider() {
		if(readLinkObjectEndQualifierActionPropertiesEditionProvider == null)
			readLinkObjectEndQualifierActionPropertiesEditionProvider = new ReadLinkObjectEndQualifierActionPropertiesEditionProvider();
		return readLinkObjectEndQualifierActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReadLinkObjectEndAction instances.
	 */
	protected ReadLinkObjectEndActionPropertiesEditionProvider readLinkObjectEndActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReadLinkObjectEndAction
	 */
	public ReadLinkObjectEndActionPropertiesEditionProvider createReadLinkObjectEndActionPropertiesEditionProvider() {
		if(readLinkObjectEndActionPropertiesEditionProvider == null)
			readLinkObjectEndActionPropertiesEditionProvider = new ReadLinkObjectEndActionPropertiesEditionProvider();
		return readLinkObjectEndActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * StartClassifierBehaviorAction instances.
	 */
	protected StartClassifierBehaviorActionPropertiesEditionProvider startClassifierBehaviorActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a StartClassifierBehaviorAction
	 */
	public StartClassifierBehaviorActionPropertiesEditionProvider createStartClassifierBehaviorActionPropertiesEditionProvider() {
		if(startClassifierBehaviorActionPropertiesEditionProvider == null)
			startClassifierBehaviorActionPropertiesEditionProvider = new StartClassifierBehaviorActionPropertiesEditionProvider();
		return startClassifierBehaviorActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReadIsClassifiedObjectAction instances.
	 */
	protected ReadIsClassifiedObjectActionPropertiesEditionProvider readIsClassifiedObjectActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReadIsClassifiedObjectAction
	 */
	public ReadIsClassifiedObjectActionPropertiesEditionProvider createReadIsClassifiedObjectActionPropertiesEditionProvider() {
		if(readIsClassifiedObjectActionPropertiesEditionProvider == null)
			readIsClassifiedObjectActionPropertiesEditionProvider = new ReadIsClassifiedObjectActionPropertiesEditionProvider();
		return readIsClassifiedObjectActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReclassifyObjectAction instances.
	 */
	protected ReclassifyObjectActionPropertiesEditionProvider reclassifyObjectActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReclassifyObjectAction
	 */
	public ReclassifyObjectActionPropertiesEditionProvider createReclassifyObjectActionPropertiesEditionProvider() {
		if(reclassifyObjectActionPropertiesEditionProvider == null)
			reclassifyObjectActionPropertiesEditionProvider = new ReclassifyObjectActionPropertiesEditionProvider();
		return reclassifyObjectActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReadExtentAction instances.
	 */
	protected ReadExtentActionPropertiesEditionProvider readExtentActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReadExtentAction
	 */
	public ReadExtentActionPropertiesEditionProvider createReadExtentActionPropertiesEditionProvider() {
		if(readExtentActionPropertiesEditionProvider == null)
			readExtentActionPropertiesEditionProvider = new ReadExtentActionPropertiesEditionProvider();
		return readExtentActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * RaiseExceptionAction instances.
	 */
	protected RaiseExceptionActionPropertiesEditionProvider raiseExceptionActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a RaiseExceptionAction
	 */
	public RaiseExceptionActionPropertiesEditionProvider createRaiseExceptionActionPropertiesEditionProvider() {
		if(raiseExceptionActionPropertiesEditionProvider == null)
			raiseExceptionActionPropertiesEditionProvider = new RaiseExceptionActionPropertiesEditionProvider();
		return raiseExceptionActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * RemoveVariableValueAction instances.
	 */
	protected RemoveVariableValueActionPropertiesEditionProvider removeVariableValueActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a RemoveVariableValueAction
	 */
	public RemoveVariableValueActionPropertiesEditionProvider createRemoveVariableValueActionPropertiesEditionProvider() {
		if(removeVariableValueActionPropertiesEditionProvider == null)
			removeVariableValueActionPropertiesEditionProvider = new RemoveVariableValueActionPropertiesEditionProvider();
		return removeVariableValueActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * AddVariableValueAction instances.
	 */
	protected AddVariableValueActionPropertiesEditionProvider addVariableValueActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a AddVariableValueAction
	 */
	public AddVariableValueActionPropertiesEditionProvider createAddVariableValueActionPropertiesEditionProvider() {
		if(addVariableValueActionPropertiesEditionProvider == null)
			addVariableValueActionPropertiesEditionProvider = new AddVariableValueActionPropertiesEditionProvider();
		return addVariableValueActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ClearVariableAction instances.
	 */
	protected ClearVariableActionPropertiesEditionProvider clearVariableActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ClearVariableAction
	 */
	public ClearVariableActionPropertiesEditionProvider createClearVariableActionPropertiesEditionProvider() {
		if(clearVariableActionPropertiesEditionProvider == null)
			clearVariableActionPropertiesEditionProvider = new ClearVariableActionPropertiesEditionProvider();
		return clearVariableActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReadVariableAction instances.
	 */
	protected ReadVariableActionPropertiesEditionProvider readVariableActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReadVariableAction
	 */
	public ReadVariableActionPropertiesEditionProvider createReadVariableActionPropertiesEditionProvider() {
		if(readVariableActionPropertiesEditionProvider == null)
			readVariableActionPropertiesEditionProvider = new ReadVariableActionPropertiesEditionProvider();
		return readVariableActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ValueSpecificationAction instances.
	 */
	protected ValueSpecificationActionPropertiesEditionProvider valueSpecificationActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ValueSpecificationAction
	 */
	public ValueSpecificationActionPropertiesEditionProvider createValueSpecificationActionPropertiesEditionProvider() {
		if(valueSpecificationActionPropertiesEditionProvider == null)
			valueSpecificationActionPropertiesEditionProvider = new ValueSpecificationActionPropertiesEditionProvider();
		return valueSpecificationActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CreateObjectAction instances.
	 */
	protected CreateObjectActionPropertiesEditionProvider createObjectActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CreateObjectAction
	 */
	public CreateObjectActionPropertiesEditionProvider createCreateObjectActionPropertiesEditionProvider() {
		if(createObjectActionPropertiesEditionProvider == null)
			createObjectActionPropertiesEditionProvider = new CreateObjectActionPropertiesEditionProvider();
		return createObjectActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DestroyObjectAction instances.
	 */
	protected DestroyObjectActionPropertiesEditionProvider destroyObjectActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DestroyObjectAction
	 */
	public DestroyObjectActionPropertiesEditionProvider createDestroyObjectActionPropertiesEditionProvider() {
		if(destroyObjectActionPropertiesEditionProvider == null)
			destroyObjectActionPropertiesEditionProvider = new DestroyObjectActionPropertiesEditionProvider();
		return destroyObjectActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TestIdentityAction instances.
	 */
	protected TestIdentityActionPropertiesEditionProvider testIdentityActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TestIdentityAction
	 */
	public TestIdentityActionPropertiesEditionProvider createTestIdentityActionPropertiesEditionProvider() {
		if(testIdentityActionPropertiesEditionProvider == null)
			testIdentityActionPropertiesEditionProvider = new TestIdentityActionPropertiesEditionProvider();
		return testIdentityActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReadSelfAction instances.
	 */
	protected ReadSelfActionPropertiesEditionProvider readSelfActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReadSelfAction
	 */
	public ReadSelfActionPropertiesEditionProvider createReadSelfActionPropertiesEditionProvider() {
		if(readSelfActionPropertiesEditionProvider == null)
			readSelfActionPropertiesEditionProvider = new ReadSelfActionPropertiesEditionProvider();
		return readSelfActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReadStructuralFeatureAction instances.
	 */
	protected ReadStructuralFeatureActionPropertiesEditionProvider readStructuralFeatureActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReadStructuralFeatureAction
	 */
	public ReadStructuralFeatureActionPropertiesEditionProvider createReadStructuralFeatureActionPropertiesEditionProvider() {
		if(readStructuralFeatureActionPropertiesEditionProvider == null)
			readStructuralFeatureActionPropertiesEditionProvider = new ReadStructuralFeatureActionPropertiesEditionProvider();
		return readStructuralFeatureActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ClearStructuralFeatureAction instances.
	 */
	protected ClearStructuralFeatureActionPropertiesEditionProvider clearStructuralFeatureActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ClearStructuralFeatureAction
	 */
	public ClearStructuralFeatureActionPropertiesEditionProvider createClearStructuralFeatureActionPropertiesEditionProvider() {
		if(clearStructuralFeatureActionPropertiesEditionProvider == null)
			clearStructuralFeatureActionPropertiesEditionProvider = new ClearStructuralFeatureActionPropertiesEditionProvider();
		return clearStructuralFeatureActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * RemoveStructuralFeatureValueAction instances.
	 */
	protected RemoveStructuralFeatureValueActionPropertiesEditionProvider removeStructuralFeatureValueActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a RemoveStructuralFeatureValueAction
	 */
	public RemoveStructuralFeatureValueActionPropertiesEditionProvider createRemoveStructuralFeatureValueActionPropertiesEditionProvider() {
		if(removeStructuralFeatureValueActionPropertiesEditionProvider == null)
			removeStructuralFeatureValueActionPropertiesEditionProvider = new RemoveStructuralFeatureValueActionPropertiesEditionProvider();
		return removeStructuralFeatureValueActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * AddStructuralFeatureValueAction instances.
	 */
	protected AddStructuralFeatureValueActionPropertiesEditionProvider addStructuralFeatureValueActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a AddStructuralFeatureValueAction
	 */
	public AddStructuralFeatureValueActionPropertiesEditionProvider createAddStructuralFeatureValueActionPropertiesEditionProvider() {
		if(addStructuralFeatureValueActionPropertiesEditionProvider == null)
			addStructuralFeatureValueActionPropertiesEditionProvider = new AddStructuralFeatureValueActionPropertiesEditionProvider();
		return addStructuralFeatureValueActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * LinkEndData instances.
	 */
	protected LinkEndDataPropertiesEditionProvider linkEndDataPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a LinkEndData
	 */
	public LinkEndDataPropertiesEditionProvider createLinkEndDataPropertiesEditionProvider() {
		if(linkEndDataPropertiesEditionProvider == null)
			linkEndDataPropertiesEditionProvider = new LinkEndDataPropertiesEditionProvider();
		return linkEndDataPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * QualifierValue instances.
	 */
	protected QualifierValuePropertiesEditionProvider qualifierValuePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a QualifierValue
	 */
	public QualifierValuePropertiesEditionProvider createQualifierValuePropertiesEditionProvider() {
		if(qualifierValuePropertiesEditionProvider == null)
			qualifierValuePropertiesEditionProvider = new QualifierValuePropertiesEditionProvider();
		return qualifierValuePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReadLinkAction instances.
	 */
	protected ReadLinkActionPropertiesEditionProvider readLinkActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReadLinkAction
	 */
	public ReadLinkActionPropertiesEditionProvider createReadLinkActionPropertiesEditionProvider() {
		if(readLinkActionPropertiesEditionProvider == null)
			readLinkActionPropertiesEditionProvider = new ReadLinkActionPropertiesEditionProvider();
		return readLinkActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * LinkEndCreationData instances.
	 */
	protected LinkEndCreationDataPropertiesEditionProvider linkEndCreationDataPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a LinkEndCreationData
	 */
	public LinkEndCreationDataPropertiesEditionProvider createLinkEndCreationDataPropertiesEditionProvider() {
		if(linkEndCreationDataPropertiesEditionProvider == null)
			linkEndCreationDataPropertiesEditionProvider = new LinkEndCreationDataPropertiesEditionProvider();
		return linkEndCreationDataPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CreateLinkAction instances.
	 */
	protected CreateLinkActionPropertiesEditionProvider createLinkActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CreateLinkAction
	 */
	public CreateLinkActionPropertiesEditionProvider createCreateLinkActionPropertiesEditionProvider() {
		if(createLinkActionPropertiesEditionProvider == null)
			createLinkActionPropertiesEditionProvider = new CreateLinkActionPropertiesEditionProvider();
		return createLinkActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DestroyLinkAction instances.
	 */
	protected DestroyLinkActionPropertiesEditionProvider destroyLinkActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DestroyLinkAction
	 */
	public DestroyLinkActionPropertiesEditionProvider createDestroyLinkActionPropertiesEditionProvider() {
		if(destroyLinkActionPropertiesEditionProvider == null)
			destroyLinkActionPropertiesEditionProvider = new DestroyLinkActionPropertiesEditionProvider();
		return destroyLinkActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * LinkEndDestructionData instances.
	 */
	protected LinkEndDestructionDataPropertiesEditionProvider linkEndDestructionDataPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a LinkEndDestructionData
	 */
	public LinkEndDestructionDataPropertiesEditionProvider createLinkEndDestructionDataPropertiesEditionProvider() {
		if(linkEndDestructionDataPropertiesEditionProvider == null)
			linkEndDestructionDataPropertiesEditionProvider = new LinkEndDestructionDataPropertiesEditionProvider();
		return linkEndDestructionDataPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ClearAssociationAction instances.
	 */
	protected ClearAssociationActionPropertiesEditionProvider clearAssociationActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ClearAssociationAction
	 */
	public ClearAssociationActionPropertiesEditionProvider createClearAssociationActionPropertiesEditionProvider() {
		if(clearAssociationActionPropertiesEditionProvider == null)
			clearAssociationActionPropertiesEditionProvider = new ClearAssociationActionPropertiesEditionProvider();
		return clearAssociationActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * BroadcastSignalAction instances.
	 */
	protected BroadcastSignalActionPropertiesEditionProvider broadcastSignalActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a BroadcastSignalAction
	 */
	public BroadcastSignalActionPropertiesEditionProvider createBroadcastSignalActionPropertiesEditionProvider() {
		if(broadcastSignalActionPropertiesEditionProvider == null)
			broadcastSignalActionPropertiesEditionProvider = new BroadcastSignalActionPropertiesEditionProvider();
		return broadcastSignalActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * SendObjectAction instances.
	 */
	protected SendObjectActionPropertiesEditionProvider sendObjectActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a SendObjectAction
	 */
	public SendObjectActionPropertiesEditionProvider createSendObjectActionPropertiesEditionProvider() {
		if(sendObjectActionPropertiesEditionProvider == null)
			sendObjectActionPropertiesEditionProvider = new SendObjectActionPropertiesEditionProvider();
		return sendObjectActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ValuePin instances.
	 */
	protected ValuePinPropertiesEditionProvider valuePinPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ValuePin
	 */
	public ValuePinPropertiesEditionProvider createValuePinPropertiesEditionProvider() {
		if(valuePinPropertiesEditionProvider == null)
			valuePinPropertiesEditionProvider = new ValuePinPropertiesEditionProvider();
		return valuePinPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CallBehaviorAction instances.
	 */
	protected CallBehaviorActionPropertiesEditionProvider callBehaviorActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CallBehaviorAction
	 */
	public CallBehaviorActionPropertiesEditionProvider createCallBehaviorActionPropertiesEditionProvider() {
		if(callBehaviorActionPropertiesEditionProvider == null)
			callBehaviorActionPropertiesEditionProvider = new CallBehaviorActionPropertiesEditionProvider();
		return callBehaviorActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CallOperationAction instances.
	 */
	protected CallOperationActionPropertiesEditionProvider callOperationActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CallOperationAction
	 */
	public CallOperationActionPropertiesEditionProvider createCallOperationActionPropertiesEditionProvider() {
		if(callOperationActionPropertiesEditionProvider == null)
			callOperationActionPropertiesEditionProvider = new CallOperationActionPropertiesEditionProvider();
		return callOperationActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * SendSignalAction instances.
	 */
	protected SendSignalActionPropertiesEditionProvider sendSignalActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a SendSignalAction
	 */
	public SendSignalActionPropertiesEditionProvider createSendSignalActionPropertiesEditionProvider() {
		if(sendSignalActionPropertiesEditionProvider == null)
			sendSignalActionPropertiesEditionProvider = new SendSignalActionPropertiesEditionProvider();
		return sendSignalActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * OpaqueAction instances.
	 */
	protected OpaqueActionPropertiesEditionProvider opaqueActionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a OpaqueAction
	 */
	public OpaqueActionPropertiesEditionProvider createOpaqueActionPropertiesEditionProvider() {
		if(opaqueActionPropertiesEditionProvider == null)
			opaqueActionPropertiesEditionProvider = new OpaqueActionPropertiesEditionProvider();
		return opaqueActionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ExpansionRegion instances.
	 */
	protected ExpansionRegionPropertiesEditionProvider expansionRegionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ExpansionRegion
	 */
	public ExpansionRegionPropertiesEditionProvider createExpansionRegionPropertiesEditionProvider() {
		if(expansionRegionPropertiesEditionProvider == null)
			expansionRegionPropertiesEditionProvider = new ExpansionRegionPropertiesEditionProvider();
		return expansionRegionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ExpansionNode instances.
	 */
	protected ExpansionNodePropertiesEditionProvider expansionNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ExpansionNode
	 */
	public ExpansionNodePropertiesEditionProvider createExpansionNodePropertiesEditionProvider() {
		if(expansionNodePropertiesEditionProvider == null)
			expansionNodePropertiesEditionProvider = new ExpansionNodePropertiesEditionProvider();
		return expansionNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * LoopNode instances.
	 */
	protected LoopNodePropertiesEditionProvider loopNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a LoopNode
	 */
	public LoopNodePropertiesEditionProvider createLoopNodePropertiesEditionProvider() {
		if(loopNodePropertiesEditionProvider == null)
			loopNodePropertiesEditionProvider = new LoopNodePropertiesEditionProvider();
		return loopNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Clause instances.
	 */
	protected ClausePropertiesEditionProvider clausePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Clause
	 */
	public ClausePropertiesEditionProvider createClausePropertiesEditionProvider() {
		if(clausePropertiesEditionProvider == null)
			clausePropertiesEditionProvider = new ClausePropertiesEditionProvider();
		return clausePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ConditionalNode instances.
	 */
	protected ConditionalNodePropertiesEditionProvider conditionalNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ConditionalNode
	 */
	public ConditionalNodePropertiesEditionProvider createConditionalNodePropertiesEditionProvider() {
		if(conditionalNodePropertiesEditionProvider == null)
			conditionalNodePropertiesEditionProvider = new ConditionalNodePropertiesEditionProvider();
		return conditionalNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ObjectFlow instances.
	 */
	protected ObjectFlowPropertiesEditionProvider objectFlowPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ObjectFlow
	 */
	public ObjectFlowPropertiesEditionProvider createObjectFlowPropertiesEditionProvider() {
		if(objectFlowPropertiesEditionProvider == null)
			objectFlowPropertiesEditionProvider = new ObjectFlowPropertiesEditionProvider();
		return objectFlowPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DataStoreNode instances.
	 */
	protected DataStoreNodePropertiesEditionProvider dataStoreNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DataStoreNode
	 */
	public DataStoreNodePropertiesEditionProvider createDataStoreNodePropertiesEditionProvider() {
		if(dataStoreNodePropertiesEditionProvider == null)
			dataStoreNodePropertiesEditionProvider = new DataStoreNodePropertiesEditionProvider();
		return dataStoreNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * JoinNode instances.
	 */
	protected JoinNodePropertiesEditionProvider joinNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a JoinNode
	 */
	public JoinNodePropertiesEditionProvider createJoinNodePropertiesEditionProvider() {
		if(joinNodePropertiesEditionProvider == null)
			joinNodePropertiesEditionProvider = new JoinNodePropertiesEditionProvider();
		return joinNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ActionInputPin instances.
	 */
	protected ActionInputPinPropertiesEditionProvider actionInputPinPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ActionInputPin
	 */
	public ActionInputPinPropertiesEditionProvider createActionInputPinPropertiesEditionProvider() {
		if(actionInputPinPropertiesEditionProvider == null)
			actionInputPinPropertiesEditionProvider = new ActionInputPinPropertiesEditionProvider();
		return actionInputPinPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ActivityFinalNode instances.
	 */
	protected ActivityFinalNodePropertiesEditionProvider activityFinalNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ActivityFinalNode
	 */
	public ActivityFinalNodePropertiesEditionProvider createActivityFinalNodePropertiesEditionProvider() {
		if(activityFinalNodePropertiesEditionProvider == null)
			activityFinalNodePropertiesEditionProvider = new ActivityFinalNodePropertiesEditionProvider();
		return activityFinalNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DecisionNode instances.
	 */
	protected DecisionNodePropertiesEditionProvider decisionNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DecisionNode
	 */
	public DecisionNodePropertiesEditionProvider createDecisionNodePropertiesEditionProvider() {
		if(decisionNodePropertiesEditionProvider == null)
			decisionNodePropertiesEditionProvider = new DecisionNodePropertiesEditionProvider();
		return decisionNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * MergeNode instances.
	 */
	protected MergeNodePropertiesEditionProvider mergeNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a MergeNode
	 */
	public MergeNodePropertiesEditionProvider createMergeNodePropertiesEditionProvider() {
		if(mergeNodePropertiesEditionProvider == null)
			mergeNodePropertiesEditionProvider = new MergeNodePropertiesEditionProvider();
		return mergeNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CentralBufferNode instances.
	 */
	protected CentralBufferNodePropertiesEditionProvider centralBufferNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CentralBufferNode
	 */
	public CentralBufferNodePropertiesEditionProvider createCentralBufferNodePropertiesEditionProvider() {
		if(centralBufferNodePropertiesEditionProvider == null)
			centralBufferNodePropertiesEditionProvider = new CentralBufferNodePropertiesEditionProvider();
		return centralBufferNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * FlowFinalNode instances.
	 */
	protected FlowFinalNodePropertiesEditionProvider flowFinalNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a FlowFinalNode
	 */
	public FlowFinalNodePropertiesEditionProvider createFlowFinalNodePropertiesEditionProvider() {
		if(flowFinalNodePropertiesEditionProvider == null)
			flowFinalNodePropertiesEditionProvider = new FlowFinalNodePropertiesEditionProvider();
		return flowFinalNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ForkNode instances.
	 */
	protected ForkNodePropertiesEditionProvider forkNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ForkNode
	 */
	public ForkNodePropertiesEditionProvider createForkNodePropertiesEditionProvider() {
		if(forkNodePropertiesEditionProvider == null)
			forkNodePropertiesEditionProvider = new ForkNodePropertiesEditionProvider();
		return forkNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * AnyReceiveEvent instances.
	 */
	protected AnyReceiveEventPropertiesEditionProvider anyReceiveEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a AnyReceiveEvent
	 */
	public AnyReceiveEventPropertiesEditionProvider createAnyReceiveEventPropertiesEditionProvider() {
		if(anyReceiveEventPropertiesEditionProvider == null)
			anyReceiveEventPropertiesEditionProvider = new AnyReceiveEventPropertiesEditionProvider();
		return anyReceiveEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ActivityParameterNode instances.
	 */
	protected ActivityParameterNodePropertiesEditionProvider activityParameterNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ActivityParameterNode
	 */
	public ActivityParameterNodePropertiesEditionProvider createActivityParameterNodePropertiesEditionProvider() {
		if(activityParameterNodePropertiesEditionProvider == null)
			activityParameterNodePropertiesEditionProvider = new ActivityParameterNodePropertiesEditionProvider();
		return activityParameterNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * InitialNode instances.
	 */
	protected InitialNodePropertiesEditionProvider initialNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a InitialNode
	 */
	public InitialNodePropertiesEditionProvider createInitialNodePropertiesEditionProvider() {
		if(initialNodePropertiesEditionProvider == null)
			initialNodePropertiesEditionProvider = new InitialNodePropertiesEditionProvider();
		return initialNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ControlFlow instances.
	 */
	protected ControlFlowPropertiesEditionProvider controlFlowPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ControlFlow
	 */
	public ControlFlowPropertiesEditionProvider createControlFlowPropertiesEditionProvider() {
		if(controlFlowPropertiesEditionProvider == null)
			controlFlowPropertiesEditionProvider = new ControlFlowPropertiesEditionProvider();
		return controlFlowPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * SequenceNode instances.
	 */
	protected SequenceNodePropertiesEditionProvider sequenceNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a SequenceNode
	 */
	public SequenceNodePropertiesEditionProvider createSequenceNodePropertiesEditionProvider() {
		if(sequenceNodePropertiesEditionProvider == null)
			sequenceNodePropertiesEditionProvider = new SequenceNodePropertiesEditionProvider();
		return sequenceNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * InputPin instances.
	 */
	protected InputPinPropertiesEditionProvider inputPinPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a InputPin
	 */
	public InputPinPropertiesEditionProvider createInputPinPropertiesEditionProvider() {
		if(inputPinPropertiesEditionProvider == null)
			inputPinPropertiesEditionProvider = new InputPinPropertiesEditionProvider();
		return inputPinPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Pin instances.
	 */
	protected PinPropertiesEditionProvider pinPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Pin
	 */
	public PinPropertiesEditionProvider createPinPropertiesEditionProvider() {
		if(pinPropertiesEditionProvider == null)
			pinPropertiesEditionProvider = new PinPropertiesEditionProvider();
		return pinPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * OutputPin instances.
	 */
	protected OutputPinPropertiesEditionProvider outputPinPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a OutputPin
	 */
	public OutputPinPropertiesEditionProvider createOutputPinPropertiesEditionProvider() {
		if(outputPinPropertiesEditionProvider == null)
			outputPinPropertiesEditionProvider = new OutputPinPropertiesEditionProvider();
		return outputPinPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ExceptionHandler instances.
	 */
	protected ExceptionHandlerPropertiesEditionProvider exceptionHandlerPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ExceptionHandler
	 */
	public ExceptionHandlerPropertiesEditionProvider createExceptionHandlerPropertiesEditionProvider() {
		if(exceptionHandlerPropertiesEditionProvider == null)
			exceptionHandlerPropertiesEditionProvider = new ExceptionHandlerPropertiesEditionProvider();
		return exceptionHandlerPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * InterruptibleActivityRegion instances.
	 */
	protected InterruptibleActivityRegionPropertiesEditionProvider interruptibleActivityRegionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a InterruptibleActivityRegion
	 */
	public InterruptibleActivityRegionPropertiesEditionProvider createInterruptibleActivityRegionPropertiesEditionProvider() {
		if(interruptibleActivityRegionPropertiesEditionProvider == null)
			interruptibleActivityRegionPropertiesEditionProvider = new InterruptibleActivityRegionPropertiesEditionProvider();
		return interruptibleActivityRegionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ActivityPartition instances.
	 */
	protected ActivityPartitionPropertiesEditionProvider activityPartitionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ActivityPartition
	 */
	public ActivityPartitionPropertiesEditionProvider createActivityPartitionPropertiesEditionProvider() {
		if(activityPartitionPropertiesEditionProvider == null)
			activityPartitionPropertiesEditionProvider = new ActivityPartitionPropertiesEditionProvider();
		return activityPartitionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Variable instances.
	 */
	protected VariablePropertiesEditionProvider variablePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Variable
	 */
	public VariablePropertiesEditionProvider createVariablePropertiesEditionProvider() {
		if(variablePropertiesEditionProvider == null)
			variablePropertiesEditionProvider = new VariablePropertiesEditionProvider();
		return variablePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Activity instances.
	 */
	protected ActivityPropertiesEditionProvider activityPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Activity
	 */
	public ActivityPropertiesEditionProvider createActivityPropertiesEditionProvider() {
		if(activityPropertiesEditionProvider == null)
			activityPropertiesEditionProvider = new ActivityPropertiesEditionProvider();
		return activityPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * StructuredActivityNode instances.
	 */
	protected StructuredActivityNodePropertiesEditionProvider structuredActivityNodePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a StructuredActivityNode
	 */
	public StructuredActivityNodePropertiesEditionProvider createStructuredActivityNodePropertiesEditionProvider() {
		if(structuredActivityNodePropertiesEditionProvider == null)
			structuredActivityNodePropertiesEditionProvider = new StructuredActivityNodePropertiesEditionProvider();
		return structuredActivityNodePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DataType instances.
	 */
	protected DataTypePropertiesEditionProvider dataTypePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DataType
	 */
	public DataTypePropertiesEditionProvider createDataTypePropertiesEditionProvider() {
		if(dataTypePropertiesEditionProvider == null)
			dataTypePropertiesEditionProvider = new DataTypePropertiesEditionProvider();
		return dataTypePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ParameterSet instances.
	 */
	protected ParameterSetPropertiesEditionProvider parameterSetPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ParameterSet
	 */
	public ParameterSetPropertiesEditionProvider createParameterSetPropertiesEditionProvider() {
		if(parameterSetPropertiesEditionProvider == null)
			parameterSetPropertiesEditionProvider = new ParameterSetPropertiesEditionProvider();
		return parameterSetPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DurationObservation instances.
	 */
	protected DurationObservationPropertiesEditionProvider durationObservationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DurationObservation
	 */
	public DurationObservationPropertiesEditionProvider createDurationObservationPropertiesEditionProvider() {
		if(durationObservationPropertiesEditionProvider == null)
			durationObservationPropertiesEditionProvider = new DurationObservationPropertiesEditionProvider();
		return durationObservationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TimeObservation instances.
	 */
	protected TimeObservationPropertiesEditionProvider timeObservationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TimeObservation
	 */
	public TimeObservationPropertiesEditionProvider createTimeObservationPropertiesEditionProvider() {
		if(timeObservationPropertiesEditionProvider == null)
			timeObservationPropertiesEditionProvider = new TimeObservationPropertiesEditionProvider();
		return timeObservationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DurationConstraint instances.
	 */
	protected DurationConstraintPropertiesEditionProvider durationConstraintPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DurationConstraint
	 */
	public DurationConstraintPropertiesEditionProvider createDurationConstraintPropertiesEditionProvider() {
		if(durationConstraintPropertiesEditionProvider == null)
			durationConstraintPropertiesEditionProvider = new DurationConstraintPropertiesEditionProvider();
		return durationConstraintPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TimeInterval instances.
	 */
	protected TimeIntervalPropertiesEditionProvider timeIntervalPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TimeInterval
	 */
	public TimeIntervalPropertiesEditionProvider createTimeIntervalPropertiesEditionProvider() {
		if(timeIntervalPropertiesEditionProvider == null)
			timeIntervalPropertiesEditionProvider = new TimeIntervalPropertiesEditionProvider();
		return timeIntervalPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * IntervalConstraint instances.
	 */
	protected IntervalConstraintPropertiesEditionProvider intervalConstraintPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a IntervalConstraint
	 */
	public IntervalConstraintPropertiesEditionProvider createIntervalConstraintPropertiesEditionProvider() {
		if(intervalConstraintPropertiesEditionProvider == null)
			intervalConstraintPropertiesEditionProvider = new IntervalConstraintPropertiesEditionProvider();
		return intervalConstraintPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TimeConstraint instances.
	 */
	protected TimeConstraintPropertiesEditionProvider timeConstraintPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TimeConstraint
	 */
	public TimeConstraintPropertiesEditionProvider createTimeConstraintPropertiesEditionProvider() {
		if(timeConstraintPropertiesEditionProvider == null)
			timeConstraintPropertiesEditionProvider = new TimeConstraintPropertiesEditionProvider();
		return timeConstraintPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Interval instances.
	 */
	protected IntervalPropertiesEditionProvider intervalPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Interval
	 */
	public IntervalPropertiesEditionProvider createIntervalPropertiesEditionProvider() {
		if(intervalPropertiesEditionProvider == null)
			intervalPropertiesEditionProvider = new IntervalPropertiesEditionProvider();
		return intervalPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DurationInterval instances.
	 */
	protected DurationIntervalPropertiesEditionProvider durationIntervalPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DurationInterval
	 */
	public DurationIntervalPropertiesEditionProvider createDurationIntervalPropertiesEditionProvider() {
		if(durationIntervalPropertiesEditionProvider == null)
			durationIntervalPropertiesEditionProvider = new DurationIntervalPropertiesEditionProvider();
		return durationIntervalPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Duration instances.
	 */
	protected DurationPropertiesEditionProvider durationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Duration
	 */
	public DurationPropertiesEditionProvider createDurationPropertiesEditionProvider() {
		if(durationPropertiesEditionProvider == null)
			durationPropertiesEditionProvider = new DurationPropertiesEditionProvider();
		return durationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TimeExpression instances.
	 */
	protected TimeExpressionPropertiesEditionProvider timeExpressionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TimeExpression
	 */
	public TimeExpressionPropertiesEditionProvider createTimeExpressionPropertiesEditionProvider() {
		if(timeExpressionPropertiesEditionProvider == null)
			timeExpressionPropertiesEditionProvider = new TimeExpressionPropertiesEditionProvider();
		return timeExpressionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * SignalEvent instances.
	 */
	protected SignalEventPropertiesEditionProvider signalEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a SignalEvent
	 */
	public SignalEventPropertiesEditionProvider createSignalEventPropertiesEditionProvider() {
		if(signalEventPropertiesEditionProvider == null)
			signalEventPropertiesEditionProvider = new SignalEventPropertiesEditionProvider();
		return signalEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ChangeEvent instances.
	 */
	protected ChangeEventPropertiesEditionProvider changeEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ChangeEvent
	 */
	public ChangeEventPropertiesEditionProvider createChangeEventPropertiesEditionProvider() {
		if(changeEventPropertiesEditionProvider == null)
			changeEventPropertiesEditionProvider = new ChangeEventPropertiesEditionProvider();
		return changeEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CallEvent instances.
	 */
	protected CallEventPropertiesEditionProvider callEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CallEvent
	 */
	public CallEventPropertiesEditionProvider createCallEventPropertiesEditionProvider() {
		if(callEventPropertiesEditionProvider == null)
			callEventPropertiesEditionProvider = new CallEventPropertiesEditionProvider();
		return callEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * FunctionBehavior instances.
	 */
	protected FunctionBehaviorPropertiesEditionProvider functionBehaviorPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a FunctionBehavior
	 */
	public FunctionBehaviorPropertiesEditionProvider createFunctionBehaviorPropertiesEditionProvider() {
		if(functionBehaviorPropertiesEditionProvider == null)
			functionBehaviorPropertiesEditionProvider = new FunctionBehaviorPropertiesEditionProvider();
		return functionBehaviorPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * OpaqueBehavior instances.
	 */
	protected OpaqueBehaviorPropertiesEditionProvider opaqueBehaviorPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a OpaqueBehavior
	 */
	public OpaqueBehaviorPropertiesEditionProvider createOpaqueBehaviorPropertiesEditionProvider() {
		if(opaqueBehaviorPropertiesEditionProvider == null)
			opaqueBehaviorPropertiesEditionProvider = new OpaqueBehaviorPropertiesEditionProvider();
		return opaqueBehaviorPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Signal instances.
	 */
	protected SignalPropertiesEditionProvider signalPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Signal
	 */
	public SignalPropertiesEditionProvider createSignalPropertiesEditionProvider() {
		if(signalPropertiesEditionProvider == null)
			signalPropertiesEditionProvider = new SignalPropertiesEditionProvider();
		return signalPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Reception instances.
	 */
	protected ReceptionPropertiesEditionProvider receptionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Reception
	 */
	public ReceptionPropertiesEditionProvider createReceptionPropertiesEditionProvider() {
		if(receptionPropertiesEditionProvider == null)
			receptionPropertiesEditionProvider = new ReceptionPropertiesEditionProvider();
		return receptionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Interface instances.
	 */
	protected Interface_PropertiesEditionProvider interface_PropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Interface
	 */
	public Interface_PropertiesEditionProvider createInterface_PropertiesEditionProvider() {
		if(interface_PropertiesEditionProvider == null)
			interface_PropertiesEditionProvider = new Interface_PropertiesEditionProvider();
		return interface_PropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ConsiderIgnoreFragment instances.
	 */
	protected ConsiderIgnoreFragmentPropertiesEditionProvider considerIgnoreFragmentPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ConsiderIgnoreFragment
	 */
	public ConsiderIgnoreFragmentPropertiesEditionProvider createConsiderIgnoreFragmentPropertiesEditionProvider() {
		if(considerIgnoreFragmentPropertiesEditionProvider == null)
			considerIgnoreFragmentPropertiesEditionProvider = new ConsiderIgnoreFragmentPropertiesEditionProvider();
		return considerIgnoreFragmentPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Continuation instances.
	 */
	protected ContinuationPropertiesEditionProvider continuationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Continuation
	 */
	public ContinuationPropertiesEditionProvider createContinuationPropertiesEditionProvider() {
		if(continuationPropertiesEditionProvider == null)
			continuationPropertiesEditionProvider = new ContinuationPropertiesEditionProvider();
		return continuationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CombinedFragment instances.
	 */
	protected CombinedFragmentPropertiesEditionProvider combinedFragmentPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CombinedFragment
	 */
	public CombinedFragmentPropertiesEditionProvider createCombinedFragmentPropertiesEditionProvider() {
		if(combinedFragmentPropertiesEditionProvider == null)
			combinedFragmentPropertiesEditionProvider = new CombinedFragmentPropertiesEditionProvider();
		return combinedFragmentPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReceiveSignalEvent instances.
	 */
	protected ReceiveSignalEventPropertiesEditionProvider receiveSignalEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReceiveSignalEvent
	 */
	public ReceiveSignalEventPropertiesEditionProvider createReceiveSignalEventPropertiesEditionProvider() {
		if(receiveSignalEventPropertiesEditionProvider == null)
			receiveSignalEventPropertiesEditionProvider = new ReceiveSignalEventPropertiesEditionProvider();
		return receiveSignalEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ReceiveOperationEvent instances.
	 */
	protected ReceiveOperationEventPropertiesEditionProvider receiveOperationEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ReceiveOperationEvent
	 */
	public ReceiveOperationEventPropertiesEditionProvider createReceiveOperationEventPropertiesEditionProvider() {
		if(receiveOperationEventPropertiesEditionProvider == null)
			receiveOperationEventPropertiesEditionProvider = new ReceiveOperationEventPropertiesEditionProvider();
		return receiveOperationEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ExecutionOccurrenceSpecification instances.
	 */
	protected ExecutionOccurrenceSpecificationPropertiesEditionProvider executionOccurrenceSpecificationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ExecutionOccurrenceSpecification
	 */
	public ExecutionOccurrenceSpecificationPropertiesEditionProvider createExecutionOccurrenceSpecificationPropertiesEditionProvider() {
		if(executionOccurrenceSpecificationPropertiesEditionProvider == null)
			executionOccurrenceSpecificationPropertiesEditionProvider = new ExecutionOccurrenceSpecificationPropertiesEditionProvider();
		return executionOccurrenceSpecificationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * MessageOccurrenceSpecification instances.
	 */
	protected MessageOccurrenceSpecificationPropertiesEditionProvider messageOccurrenceSpecificationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a MessageOccurrenceSpecification
	 */
	public MessageOccurrenceSpecificationPropertiesEditionProvider createMessageOccurrenceSpecificationPropertiesEditionProvider() {
		if(messageOccurrenceSpecificationPropertiesEditionProvider == null)
			messageOccurrenceSpecificationPropertiesEditionProvider = new MessageOccurrenceSpecificationPropertiesEditionProvider();
		return messageOccurrenceSpecificationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * SendSignalEvent instances.
	 */
	protected SendSignalEventPropertiesEditionProvider sendSignalEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a SendSignalEvent
	 */
	public SendSignalEventPropertiesEditionProvider createSendSignalEventPropertiesEditionProvider() {
		if(sendSignalEventPropertiesEditionProvider == null)
			sendSignalEventPropertiesEditionProvider = new SendSignalEventPropertiesEditionProvider();
		return sendSignalEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * SendOperationEvent instances.
	 */
	protected SendOperationEventPropertiesEditionProvider sendOperationEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a SendOperationEvent
	 */
	public SendOperationEventPropertiesEditionProvider createSendOperationEventPropertiesEditionProvider() {
		if(sendOperationEventPropertiesEditionProvider == null)
			sendOperationEventPropertiesEditionProvider = new SendOperationEventPropertiesEditionProvider();
		return sendOperationEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * DestructionEvent instances.
	 */
	protected DestructionEventPropertiesEditionProvider destructionEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a DestructionEvent
	 */
	public DestructionEventPropertiesEditionProvider createDestructionEventPropertiesEditionProvider() {
		if(destructionEventPropertiesEditionProvider == null)
			destructionEventPropertiesEditionProvider = new DestructionEventPropertiesEditionProvider();
		return destructionEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CreationEvent instances.
	 */
	protected CreationEventPropertiesEditionProvider creationEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CreationEvent
	 */
	public CreationEventPropertiesEditionProvider createCreationEventPropertiesEditionProvider() {
		if(creationEventPropertiesEditionProvider == null)
			creationEventPropertiesEditionProvider = new CreationEventPropertiesEditionProvider();
		return creationEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ExecutionEvent instances.
	 */
	protected ExecutionEventPropertiesEditionProvider executionEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ExecutionEvent
	 */
	public ExecutionEventPropertiesEditionProvider createExecutionEventPropertiesEditionProvider() {
		if(executionEventPropertiesEditionProvider == null)
			executionEventPropertiesEditionProvider = new ExecutionEventPropertiesEditionProvider();
		return executionEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * BehaviorExecutionSpecification instances.
	 */
	protected BehaviorExecutionSpecificationPropertiesEditionProvider behaviorExecutionSpecificationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a BehaviorExecutionSpecification
	 */
	public BehaviorExecutionSpecificationPropertiesEditionProvider createBehaviorExecutionSpecificationPropertiesEditionProvider() {
		if(behaviorExecutionSpecificationPropertiesEditionProvider == null)
			behaviorExecutionSpecificationPropertiesEditionProvider = new BehaviorExecutionSpecificationPropertiesEditionProvider();
		return behaviorExecutionSpecificationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ActionExecutionSpecification instances.
	 */
	protected ActionExecutionSpecificationPropertiesEditionProvider actionExecutionSpecificationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ActionExecutionSpecification
	 */
	public ActionExecutionSpecificationPropertiesEditionProvider createActionExecutionSpecificationPropertiesEditionProvider() {
		if(actionExecutionSpecificationPropertiesEditionProvider == null)
			actionExecutionSpecificationPropertiesEditionProvider = new ActionExecutionSpecificationPropertiesEditionProvider();
		return actionExecutionSpecificationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * StateInvariant instances.
	 */
	protected StateInvariantPropertiesEditionProvider stateInvariantPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a StateInvariant
	 */
	public StateInvariantPropertiesEditionProvider createStateInvariantPropertiesEditionProvider() {
		if(stateInvariantPropertiesEditionProvider == null)
			stateInvariantPropertiesEditionProvider = new StateInvariantPropertiesEditionProvider();
		return stateInvariantPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * InteractionConstraint instances.
	 */
	protected InteractionConstraintPropertiesEditionProvider interactionConstraintPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a InteractionConstraint
	 */
	public InteractionConstraintPropertiesEditionProvider createInteractionConstraintPropertiesEditionProvider() {
		if(interactionConstraintPropertiesEditionProvider == null)
			interactionConstraintPropertiesEditionProvider = new InteractionConstraintPropertiesEditionProvider();
		return interactionConstraintPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * InteractionOperand instances.
	 */
	protected InteractionOperandPropertiesEditionProvider interactionOperandPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a InteractionOperand
	 */
	public InteractionOperandPropertiesEditionProvider createInteractionOperandPropertiesEditionProvider() {
		if(interactionOperandPropertiesEditionProvider == null)
			interactionOperandPropertiesEditionProvider = new InteractionOperandPropertiesEditionProvider();
		return interactionOperandPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * OccurrenceSpecification instances.
	 */
	protected OccurrenceSpecificationPropertiesEditionProvider occurrenceSpecificationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a OccurrenceSpecification
	 */
	public OccurrenceSpecificationPropertiesEditionProvider createOccurrenceSpecificationPropertiesEditionProvider() {
		if(occurrenceSpecificationPropertiesEditionProvider == null)
			occurrenceSpecificationPropertiesEditionProvider = new OccurrenceSpecificationPropertiesEditionProvider();
		return occurrenceSpecificationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * GeneralOrdering instances.
	 */
	protected GeneralOrderingPropertiesEditionProvider generalOrderingPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a GeneralOrdering
	 */
	public GeneralOrderingPropertiesEditionProvider createGeneralOrderingPropertiesEditionProvider() {
		if(generalOrderingPropertiesEditionProvider == null)
			generalOrderingPropertiesEditionProvider = new GeneralOrderingPropertiesEditionProvider();
		return generalOrderingPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Gate instances.
	 */
	protected GatePropertiesEditionProvider gatePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Gate
	 */
	public GatePropertiesEditionProvider createGatePropertiesEditionProvider() {
		if(gatePropertiesEditionProvider == null)
			gatePropertiesEditionProvider = new GatePropertiesEditionProvider();
		return gatePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * InteractionUse instances.
	 */
	protected InteractionUsePropertiesEditionProvider interactionUsePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a InteractionUse
	 */
	public InteractionUsePropertiesEditionProvider createInteractionUsePropertiesEditionProvider() {
		if(interactionUsePropertiesEditionProvider == null)
			interactionUsePropertiesEditionProvider = new InteractionUsePropertiesEditionProvider();
		return interactionUsePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * PartDecomposition instances.
	 */
	protected PartDecompositionPropertiesEditionProvider partDecompositionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a PartDecomposition
	 */
	public PartDecompositionPropertiesEditionProvider createPartDecompositionPropertiesEditionProvider() {
		if(partDecompositionPropertiesEditionProvider == null)
			partDecompositionPropertiesEditionProvider = new PartDecompositionPropertiesEditionProvider();
		return partDecompositionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Lifeline instances.
	 */
	protected LifelinePropertiesEditionProvider lifelinePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Lifeline
	 */
	public LifelinePropertiesEditionProvider createLifelinePropertiesEditionProvider() {
		if(lifelinePropertiesEditionProvider == null)
			lifelinePropertiesEditionProvider = new LifelinePropertiesEditionProvider();
		return lifelinePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Interaction instances.
	 */
	protected InteractionPropertiesEditionProvider interactionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Interaction
	 */
	public InteractionPropertiesEditionProvider createInteractionPropertiesEditionProvider() {
		if(interactionPropertiesEditionProvider == null)
			interactionPropertiesEditionProvider = new InteractionPropertiesEditionProvider();
		return interactionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Message instances.
	 */
	protected MessagePropertiesEditionProvider messagePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Message
	 */
	public MessagePropertiesEditionProvider createMessagePropertiesEditionProvider() {
		if(messagePropertiesEditionProvider == null)
			messagePropertiesEditionProvider = new MessagePropertiesEditionProvider();
		return messagePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ProtocolTransition instances.
	 */
	protected ProtocolTransitionPropertiesEditionProvider protocolTransitionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ProtocolTransition
	 */
	public ProtocolTransitionPropertiesEditionProvider createProtocolTransitionPropertiesEditionProvider() {
		if(protocolTransitionPropertiesEditionProvider == null)
			protocolTransitionPropertiesEditionProvider = new ProtocolTransitionPropertiesEditionProvider();
		return protocolTransitionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TimeEvent instances.
	 */
	protected TimeEventPropertiesEditionProvider timeEventPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TimeEvent
	 */
	public TimeEventPropertiesEditionProvider createTimeEventPropertiesEditionProvider() {
		if(timeEventPropertiesEditionProvider == null)
			timeEventPropertiesEditionProvider = new TimeEventPropertiesEditionProvider();
		return timeEventPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * FinalState instances.
	 */
	protected FinalStatePropertiesEditionProvider finalStatePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a FinalState
	 */
	public FinalStatePropertiesEditionProvider createFinalStatePropertiesEditionProvider() {
		if(finalStatePropertiesEditionProvider == null)
			finalStatePropertiesEditionProvider = new FinalStatePropertiesEditionProvider();
		return finalStatePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ProtocolConformance instances.
	 */
	protected ProtocolConformancePropertiesEditionProvider protocolConformancePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ProtocolConformance
	 */
	public ProtocolConformancePropertiesEditionProvider createProtocolConformancePropertiesEditionProvider() {
		if(protocolConformancePropertiesEditionProvider == null)
			protocolConformancePropertiesEditionProvider = new ProtocolConformancePropertiesEditionProvider();
		return protocolConformancePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * State instances.
	 */
	protected StatePropertiesEditionProvider statePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a State
	 */
	public StatePropertiesEditionProvider createStatePropertiesEditionProvider() {
		if(statePropertiesEditionProvider == null)
			statePropertiesEditionProvider = new StatePropertiesEditionProvider();
		return statePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ConnectionPointReference instances.
	 */
	protected ConnectionPointReferencePropertiesEditionProvider connectionPointReferencePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ConnectionPointReference
	 */
	public ConnectionPointReferencePropertiesEditionProvider createConnectionPointReferencePropertiesEditionProvider() {
		if(connectionPointReferencePropertiesEditionProvider == null)
			connectionPointReferencePropertiesEditionProvider = new ConnectionPointReferencePropertiesEditionProvider();
		return connectionPointReferencePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Pseudostate instances.
	 */
	protected PseudostatePropertiesEditionProvider pseudostatePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Pseudostate
	 */
	public PseudostatePropertiesEditionProvider createPseudostatePropertiesEditionProvider() {
		if(pseudostatePropertiesEditionProvider == null)
			pseudostatePropertiesEditionProvider = new PseudostatePropertiesEditionProvider();
		return pseudostatePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ProtocolStateMachine instances.
	 */
	protected ProtocolStateMachinePropertiesEditionProvider protocolStateMachinePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ProtocolStateMachine
	 */
	public ProtocolStateMachinePropertiesEditionProvider createProtocolStateMachinePropertiesEditionProvider() {
		if(protocolStateMachinePropertiesEditionProvider == null)
			protocolStateMachinePropertiesEditionProvider = new ProtocolStateMachinePropertiesEditionProvider();
		return protocolStateMachinePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * StateMachine instances.
	 */
	protected StateMachinePropertiesEditionProvider stateMachinePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a StateMachine
	 */
	public StateMachinePropertiesEditionProvider createStateMachinePropertiesEditionProvider() {
		if(stateMachinePropertiesEditionProvider == null)
			stateMachinePropertiesEditionProvider = new StateMachinePropertiesEditionProvider();
		return stateMachinePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Region instances.
	 */
	protected RegionPropertiesEditionProvider regionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Region
	 */
	public RegionPropertiesEditionProvider createRegionPropertiesEditionProvider() {
		if(regionPropertiesEditionProvider == null)
			regionPropertiesEditionProvider = new RegionPropertiesEditionProvider();
		return regionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Transition instances.
	 */
	protected TransitionPropertiesEditionProvider transitionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Transition
	 */
	public TransitionPropertiesEditionProvider createTransitionPropertiesEditionProvider() {
		if(transitionPropertiesEditionProvider == null)
			transitionPropertiesEditionProvider = new TransitionPropertiesEditionProvider();
		return transitionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Actor instances.
	 */
	protected ActorPropertiesEditionProvider actorPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Actor
	 */
	public ActorPropertiesEditionProvider createActorPropertiesEditionProvider() {
		if(actorPropertiesEditionProvider == null)
			actorPropertiesEditionProvider = new ActorPropertiesEditionProvider();
		return actorPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ExtensionPoint instances.
	 */
	protected ExtensionPointPropertiesEditionProvider extensionPointPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ExtensionPoint
	 */
	public ExtensionPointPropertiesEditionProvider createExtensionPointPropertiesEditionProvider() {
		if(extensionPointPropertiesEditionProvider == null)
			extensionPointPropertiesEditionProvider = new ExtensionPointPropertiesEditionProvider();
		return extensionPointPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * CollaborationUse instances.
	 */
	protected CollaborationUsePropertiesEditionProvider collaborationUsePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a CollaborationUse
	 */
	public CollaborationUsePropertiesEditionProvider createCollaborationUsePropertiesEditionProvider() {
		if(collaborationUsePropertiesEditionProvider == null)
			collaborationUsePropertiesEditionProvider = new CollaborationUsePropertiesEditionProvider();
		return collaborationUsePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Collaboration instances.
	 */
	protected CollaborationPropertiesEditionProvider collaborationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Collaboration
	 */
	public CollaborationPropertiesEditionProvider createCollaborationPropertiesEditionProvider() {
		if(collaborationPropertiesEditionProvider == null)
			collaborationPropertiesEditionProvider = new CollaborationPropertiesEditionProvider();
		return collaborationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * UseCase instances.
	 */
	protected UseCasePropertiesEditionProvider useCasePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a UseCase
	 */
	public UseCasePropertiesEditionProvider createUseCasePropertiesEditionProvider() {
		if(useCasePropertiesEditionProvider == null)
			useCasePropertiesEditionProvider = new UseCasePropertiesEditionProvider();
		return useCasePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Include instances.
	 */
	protected IncludePropertiesEditionProvider includePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Include
	 */
	public IncludePropertiesEditionProvider createIncludePropertiesEditionProvider() {
		if(includePropertiesEditionProvider == null)
			includePropertiesEditionProvider = new IncludePropertiesEditionProvider();
		return includePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Extend instances.
	 */
	protected ExtendPropertiesEditionProvider extendPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Extend
	 */
	public ExtendPropertiesEditionProvider createExtendPropertiesEditionProvider() {
		if(extendPropertiesEditionProvider == null)
			extendPropertiesEditionProvider = new ExtendPropertiesEditionProvider();
		return extendPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * InformationFlow instances.
	 */
	protected InformationFlowPropertiesEditionProvider informationFlowPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a InformationFlow
	 */
	public InformationFlowPropertiesEditionProvider createInformationFlowPropertiesEditionProvider() {
		if(informationFlowPropertiesEditionProvider == null)
			informationFlowPropertiesEditionProvider = new InformationFlowPropertiesEditionProvider();
		return informationFlowPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * InformationItem instances.
	 */
	protected InformationItemPropertiesEditionProvider informationItemPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a InformationItem
	 */
	public InformationItemPropertiesEditionProvider createInformationItemPropertiesEditionProvider() {
		if(informationItemPropertiesEditionProvider == null)
			informationItemPropertiesEditionProvider = new InformationItemPropertiesEditionProvider();
		return informationItemPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ClassifierTemplateParameter instances.
	 */
	protected ClassifierTemplateParameterPropertiesEditionProvider classifierTemplateParameterPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ClassifierTemplateParameter
	 */
	public ClassifierTemplateParameterPropertiesEditionProvider createClassifierTemplateParameterPropertiesEditionProvider() {
		if(classifierTemplateParameterPropertiesEditionProvider == null)
			classifierTemplateParameterPropertiesEditionProvider = new ClassifierTemplateParameterPropertiesEditionProvider();
		return classifierTemplateParameterPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * RedefinableTemplateSignature instances.
	 */
	protected RedefinableTemplateSignaturePropertiesEditionProvider redefinableTemplateSignaturePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a RedefinableTemplateSignature
	 */
	public RedefinableTemplateSignaturePropertiesEditionProvider createRedefinableTemplateSignaturePropertiesEditionProvider() {
		if(redefinableTemplateSignaturePropertiesEditionProvider == null)
			redefinableTemplateSignaturePropertiesEditionProvider = new RedefinableTemplateSignaturePropertiesEditionProvider();
		return redefinableTemplateSignaturePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * OperationTemplateParameter instances.
	 */
	protected OperationTemplateParameterPropertiesEditionProvider operationTemplateParameterPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a OperationTemplateParameter
	 */
	public OperationTemplateParameterPropertiesEditionProvider createOperationTemplateParameterPropertiesEditionProvider() {
		if(operationTemplateParameterPropertiesEditionProvider == null)
			operationTemplateParameterPropertiesEditionProvider = new OperationTemplateParameterPropertiesEditionProvider();
		return operationTemplateParameterPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Model instances.
	 */
	protected ModelPropertiesEditionProvider modelPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Model
	 */
	public ModelPropertiesEditionProvider createModelPropertiesEditionProvider() {
		if(modelPropertiesEditionProvider == null)
			modelPropertiesEditionProvider = new ModelPropertiesEditionProvider();
		return modelPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ConnectableElementTemplateParameter instances.
	 */
	protected ConnectableElementTemplateParameterPropertiesEditionProvider connectableElementTemplateParameterPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ConnectableElementTemplateParameter
	 */
	public ConnectableElementTemplateParameterPropertiesEditionProvider createConnectableElementTemplateParameterPropertiesEditionProvider() {
		if(connectableElementTemplateParameterPropertiesEditionProvider == null)
			connectableElementTemplateParameterPropertiesEditionProvider = new ConnectableElementTemplateParameterPropertiesEditionProvider();
		return connectableElementTemplateParameterPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TemplateBinding instances.
	 */
	protected TemplateBindingPropertiesEditionProvider templateBindingPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TemplateBinding
	 */
	public TemplateBindingPropertiesEditionProvider createTemplateBindingPropertiesEditionProvider() {
		if(templateBindingPropertiesEditionProvider == null)
			templateBindingPropertiesEditionProvider = new TemplateBindingPropertiesEditionProvider();
		return templateBindingPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TemplateSignature instances.
	 */
	protected TemplateSignaturePropertiesEditionProvider templateSignaturePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TemplateSignature
	 */
	public TemplateSignaturePropertiesEditionProvider createTemplateSignaturePropertiesEditionProvider() {
		if(templateSignaturePropertiesEditionProvider == null)
			templateSignaturePropertiesEditionProvider = new TemplateSignaturePropertiesEditionProvider();
		return templateSignaturePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TemplateParameter instances.
	 */
	protected TemplateParameterPropertiesEditionProvider templateParameterPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TemplateParameter
	 */
	public TemplateParameterPropertiesEditionProvider createTemplateParameterPropertiesEditionProvider() {
		if(templateParameterPropertiesEditionProvider == null)
			templateParameterPropertiesEditionProvider = new TemplateParameterPropertiesEditionProvider();
		return templateParameterPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * TemplateParameterSubstitution instances.
	 */
	protected TemplateParameterSubstitutionPropertiesEditionProvider templateParameterSubstitutionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a TemplateParameterSubstitution
	 */
	public TemplateParameterSubstitutionPropertiesEditionProvider createTemplateParameterSubstitutionPropertiesEditionProvider() {
		if(templateParameterSubstitutionPropertiesEditionProvider == null)
			templateParameterSubstitutionPropertiesEditionProvider = new TemplateParameterSubstitutionPropertiesEditionProvider();
		return templateParameterSubstitutionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ProfileApplication instances.
	 */
	protected ProfileApplicationPropertiesEditionProvider profileApplicationPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ProfileApplication
	 */
	public ProfileApplicationPropertiesEditionProvider createProfileApplicationPropertiesEditionProvider() {
		if(profileApplicationPropertiesEditionProvider == null)
			profileApplicationPropertiesEditionProvider = new ProfileApplicationPropertiesEditionProvider();
		return profileApplicationPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Profile instances.
	 */
	protected ProfilePropertiesEditionProvider profilePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Profile
	 */
	public ProfilePropertiesEditionProvider createProfilePropertiesEditionProvider() {
		if(profilePropertiesEditionProvider == null)
			profilePropertiesEditionProvider = new ProfilePropertiesEditionProvider();
		return profilePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Image instances.
	 */
	protected ImagePropertiesEditionProvider imagePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Image
	 */
	public ImagePropertiesEditionProvider createImagePropertiesEditionProvider() {
		if(imagePropertiesEditionProvider == null)
			imagePropertiesEditionProvider = new ImagePropertiesEditionProvider();
		return imagePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Extension instances.
	 */
	protected ExtensionPropertiesEditionProvider extensionPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Extension
	 */
	public ExtensionPropertiesEditionProvider createExtensionPropertiesEditionProvider() {
		if(extensionPropertiesEditionProvider == null)
			extensionPropertiesEditionProvider = new ExtensionPropertiesEditionProvider();
		return extensionPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * ExtensionEnd instances.
	 */
	protected ExtensionEndPropertiesEditionProvider extensionEndPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a ExtensionEnd
	 */
	public ExtensionEndPropertiesEditionProvider createExtensionEndPropertiesEditionProvider() {
		if(extensionEndPropertiesEditionProvider == null)
			extensionEndPropertiesEditionProvider = new ExtensionEndPropertiesEditionProvider();
		return extensionEndPropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Stereotype instances.
	 */
	protected StereotypePropertiesEditionProvider stereotypePropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Stereotype
	 */
	public StereotypePropertiesEditionProvider createStereotypePropertiesEditionProvider() {
		if(stereotypePropertiesEditionProvider == null)
			stereotypePropertiesEditionProvider = new StereotypePropertiesEditionProvider();
		return stereotypePropertiesEditionProvider;
	}

	/**
	 * This keeps track of the one PropertiesEditionProvider used for all
	 * Element instances.
	 */
	protected ElementPropertiesEditionProvider elementPropertiesEditionProvider;

	/**
	 * This creates an PropertiesEditionProvider for a Element
	 */
	public ElementPropertiesEditionProvider createElementPropertiesEditionProvider() {
		if(elementPropertiesEditionProvider == null)
			elementPropertiesEditionProvider = new ElementPropertiesEditionProvider();
		return elementPropertiesEditionProvider;
	}

}
