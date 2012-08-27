/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.part;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class UMLDomainModelElementTester extends PropertyTester {

	/**
	 * @generated
	 */
	public boolean test(Object receiver, String method, Object[] args,
			Object expectedValue) {
		if (false == receiver instanceof EObject) {
			return false;
		}
		EObject eObject = (EObject) receiver;
		EClass eClass = eObject.eClass();
		if (eClass == UMLPackage.eINSTANCE.getComment()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getElement()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getPackage()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getPackageableElement()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getNamedElement()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDependency()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDirectedRelationship()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getRelationship()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getNamespace()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getElementImport()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getPackageImport()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getConstraint()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getValueSpecification()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTypedElement()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getType()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getAssociation()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getClassifier()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getRedefinableElement()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTemplateableElement()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTemplateBinding()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTemplateSignature()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTemplateParameter()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getParameterableElement()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTemplateParameterSubstitution()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getGeneralization()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getGeneralizationSet()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getFeature()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getSubstitution()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getRealization()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getAbstraction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getOpaqueExpression()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getParameter()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getMultiplicityElement()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getConnectableElement()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE
				.getConnectableElementTemplateParameter()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getConnectorEnd()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getProperty()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDeploymentTarget()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDeployment()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDeployedArtifact()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDeploymentSpecification()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getArtifact()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getManifestation()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getOperation()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getBehavioralFeature()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getBehavior()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getClass_()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getBehavioredClassifier()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInterfaceRealization()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInterface()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReception()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getSignal()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getProtocolStateMachine()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getStateMachine()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getRegion()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getVertex()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTransition()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTrigger()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getPort()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getState()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getConnectionPointReference()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getPseudostate()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getProtocolConformance()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getEncapsulatedClassifier()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getStructuredClassifier()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getConnector()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExtension()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExtensionEnd()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getStereotype()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getImage()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getProfile()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getModel()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getParameterSet()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDataType()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getOperationTemplateParameter()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getStructuralFeature()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCollaborationUse()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCollaboration()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getUseCase()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInclude()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExtend()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExtensionPoint()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getRedefinableTemplateSignature()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getClassifierTemplateParameter()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getStringExpression()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExpression()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getUsage()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getPackageMerge()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getProfileApplication()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getEnumeration()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getEnumerationLiteral()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInstanceSpecification()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getSlot()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getPrimitiveType()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLiteralSpecification()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLiteralInteger()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLiteralString()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLiteralBoolean()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLiteralNull()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInstanceValue()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLiteralUnlimitedNatural()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getOpaqueBehavior()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getFunctionBehavior()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getOpaqueAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExecutableNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getActivityNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getStructuredActivityNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getActivityGroup()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getActivity()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getVariable()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getActivityEdge()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getActivityPartition()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInterruptibleActivityRegion()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExceptionHandler()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getObjectNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getOutputPin()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getPin()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInputPin()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCallAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInvocationAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getSendSignalAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCallOperationAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCallBehaviorAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getSequenceNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getControlNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getControlFlow()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInitialNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getActivityParameterNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getValuePin()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getMessage()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getMessageEnd()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInteraction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInteractionFragment()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLifeline()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getPartDecomposition()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInteractionUse()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getGate()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getGeneralOrdering()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getOccurrenceSpecification()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInteractionOperand()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInteractionConstraint()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExecutionSpecification()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getStateInvariant()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getActionExecutionSpecification()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getBehaviorExecutionSpecification()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExecutionEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCreationEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDestructionEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getSendOperationEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getMessageEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getSendSignalEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getMessageOccurrenceSpecification()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE
				.getExecutionOccurrenceSpecification()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReceiveOperationEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReceiveSignalEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getActor()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCallEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getChangeEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getSignalEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getAnyReceiveEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getForkNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getFlowFinalNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getFinalNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCentralBufferNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getMergeNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDecisionNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getActivityFinalNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getComponentRealization()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getComponent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCommunicationPath()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDevice()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExecutionEnvironment()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCombinedFragment()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getContinuation()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getConsiderIgnoreFragment()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCreateObjectAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDestroyObjectAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTestIdentityAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReadSelfAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getStructuralFeatureAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReadStructuralFeatureAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getWriteStructuralFeatureAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getClearStructuralFeatureAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE
				.getRemoveStructuralFeatureValueAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getAddStructuralFeatureValueAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLinkAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLinkEndData()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getQualifierValue()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReadLinkAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLinkEndCreationData()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCreateLinkAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getWriteLinkAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDestroyLinkAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLinkEndDestructionData()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getClearAssociationAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getBroadcastSignalAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getSendObjectAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getValueSpecificationAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTimeExpression()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getObservation()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDuration()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDurationInterval()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInterval()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTimeConstraint()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getIntervalConstraint()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTimeInterval()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDurationConstraint()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTimeObservation()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDurationObservation()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getFinalState()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getTimeEvent()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getVariableAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReadVariableAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getWriteVariableAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getClearVariableAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getAddVariableValueAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getRemoveVariableValueAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getRaiseExceptionAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getActionInputPin()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInformationItem()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getInformationFlow()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReadExtentAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReclassifyObjectAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReadIsClassifiedObjectAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getStartClassifierBehaviorAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReadLinkObjectEndAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE
				.getReadLinkObjectEndQualifierAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getCreateLinkObjectAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getAcceptEventAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getAcceptCallAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReplyAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getUnmarshallAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getReduceAction()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getJoinNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getDataStoreNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getObjectFlow()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getConditionalNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getClause()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getLoopNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExpansionNode()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getExpansionRegion()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getProtocolTransition()) {
			return true;
		}
		if (eClass == UMLPackage.eINSTANCE.getAssociationClass()) {
			return true;
		}
		return false;
	}

}
