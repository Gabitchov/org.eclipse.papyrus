/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.composite.part;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.composite.edit.parts.*;
import org.eclipse.uml2.uml.Package;

/**
 * @generated
 */
public class UMLDiagramContentInitializer {

	/**
	 * @generated
	 */
	private Map myDomain2NotationMap = new HashMap();

	/**
	 * @generated
	 */
	private Collection myLinkDescriptors = new LinkedList();

	/**
	 * @generated
	 */
	public void initDiagramContent(Diagram diagram) {
		if(!CompositeStructureDiagramEditPart.MODEL_ID.equals(diagram.getType())) {
			UMLDiagramEditorPlugin.getInstance().logError("Incorrect diagram passed as a parameter: " + diagram.getType());
			return;
		}
		if(false == diagram.getElement() instanceof Package) {
			UMLDiagramEditorPlugin.getInstance().logError("Incorrect diagram element specified: " + diagram.getElement() + " instead of Package");
			return;
		}
		createPackage_1000Children(diagram);
		createLinks(diagram);
	}

	/**
	 * @generated
	 */
	private void createPackage_1000Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getPackage_1000SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createActivity_2060Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getActivity_2060OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getActivity_2060SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createActivityStructure_7063Children(getCompartment(view, ActivityCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createInteraction_2061Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInteraction_2061OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getInteraction_2061SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createInteractionStructure_7064Children(getCompartment(view, InteractionCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createProtocolStateMachine_2062Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getProtocolStateMachine_2062OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getProtocolStateMachine_2062SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createProtocolStateMachineStructure_7065Children(getCompartment(view, ProtocolStateMachineCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createStateMachine_2063Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getStateMachine_2063OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getStateMachine_2063SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createStateMachineStructure_7066Children(getCompartment(view, StateMachineCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createFunctionBehavior_2064Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getFunctionBehavior_2064OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getFunctionBehavior_2064SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createFunctionBehaviorStructure_7067Children(getCompartment(view, FunctionBehaviorCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createOpaqueBehavior_2065Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getOpaqueBehavior_2065OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getOpaqueBehavior_2065SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createOpaqueBehaviorStructure_7068Children(getCompartment(view, OpaqueBehaviorCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createComponent_2069Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getComponent_2069OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getComponent_2069SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createComponentStructure_7069Children(getCompartment(view, ComponentCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createDevice_2070Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDevice_2070OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getDevice_2070SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createDeviceStructure_7070Children(getCompartment(view, DeviceCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createExecutionEnvironment_2071Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getExecutionEnvironment_2071OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getExecutionEnvironment_2071SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createExecutionEnvironmentStructure_7071Children(getCompartment(view, ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createNode_2072Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getNode_2072OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getNode_2072SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createNodeStructure_7072Children(getCompartment(view, NodeCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createClass_2073Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getClass_2073OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getClass_2073SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createClassStructure_7073Children(getCompartment(view, ClassCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createCollaboration_2075Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getCollaboration_2075OutgoingLinks(view));
		createCollaborationStructure_7075Children(getCompartment(view, CollaborationCompositeCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createInterface_2076Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInterface_2076OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createPrimitiveType_2066Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getPrimitiveType_2066OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createEnumeration_2067Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getEnumeration_2067OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getEnumeration_2067SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createEnumerationLiterals_7048Children(getCompartment(view, EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createDataType_2068Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDataType_2068OutgoingLinks(view));
		createDataTypeProperties_7033Children(getCompartment(view, DataTypeAttributeCompartmentEditPart.VISUAL_ID));
		createDataTypeOperations_7034Children(getCompartment(view, DataTypeOperationCompartmentEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createActor_2077Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getActor_2077OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createDeploymentSpecification_2078Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDeploymentSpecification_2078OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createArtifact_2079Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getArtifact_2079OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createInformationItem_2080Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInformationItem_2080OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createSignal_2081Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getSignal_2081OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createUseCase_2082Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getUseCase_2082OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createSignalEvent_2083Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getSignalEvent_2083OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createCallEvent_2084Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getCallEvent_2084OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createAnyReceiveEvent_2085Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getAnyReceiveEvent_2085OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createChangeEvent_2088Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getChangeEvent_2088OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createTimeEvent_2089Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getTimeEvent_2089OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createDurationObservation_2093Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDurationObservation_2093OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createTimeObservation_2094Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getTimeObservation_2094OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createLiteralBoolean_2095Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getLiteralBoolean_2095OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createLiteralInteger_2096Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getLiteralInteger_2096OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createLiteralNull_2097Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getLiteralNull_2097OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createLiteralString_2098Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getLiteralString_2098OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createLiteralUnlimitedNatural_2099Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getLiteralUnlimitedNatural_2099OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createStringExpression_2100Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getStringExpression_2100OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createOpaqueExpression_2101Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getOpaqueExpression_2101OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createTimeExpression_2102Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getTimeExpression_2102OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createExpression_2103Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getExpression_2103OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createDuration_2104Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDuration_2104OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createTimeInterval_2105Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getTimeInterval_2105OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createDurationInterval_2106Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDurationInterval_2106OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createInterval_2107Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInterval_2107OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createInstanceValue_2108Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInstanceValue_2108OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createComment_2109Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getComment_2109OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createDurationConstraint_2110Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDurationConstraint_2110OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createTimeConstraint_2111Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getTimeConstraint_2111OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createIntervalConstraint_2112Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getIntervalConstraint_2112OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createInteractionConstraint_2113Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInteractionConstraint_2113OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createConstraint_2114Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getConstraint_2114OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createPort_3069Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getPort_3069OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createParameter_3088Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getParameter_3088OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createProperty_3070Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getProperty_3070OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getProperty_3070SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createPropertyStructure_7077Children(getCompartment(view, PropertyPartCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createConnectableElement_3115Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getConnectableElement_3115OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createCollaborationUse_3071Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getCollaborationUse_3071OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createActivity_3072Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getActivity_3072OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getActivity_3072SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createActivityStructure_7050Children(getCompartment(view, ActivityCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createInteraction_3073Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInteraction_3073OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getInteraction_3073SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createInteractionStructure_7051Children(getCompartment(view, InteractionCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createProtocolStateMachine_3074Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getProtocolStateMachine_3074OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getProtocolStateMachine_3074SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createProtocolStateMachineStructure_7052Children(getCompartment(view, ProtocolStateMachineCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createStateMachine_3075Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getStateMachine_3075OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getStateMachine_3075SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createStateMachineStructure_7053Children(getCompartment(view, StateMachineCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createFunctionBehavior_3076Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getFunctionBehavior_3076OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getFunctionBehavior_3076SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createFunctionBehaviorStructure_7054Children(getCompartment(view, FunctionBehaviorCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createOpaqueBehavior_3077Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getOpaqueBehavior_3077OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getOpaqueBehavior_3077SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createOpaqueBehaviorStructure_7055Children(getCompartment(view, OpaqueBehaviorCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createComponent_3081Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getComponent_3081OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getComponent_3081SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createComponentStructure_7056Children(getCompartment(view, ComponentCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createDevice_3082Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDevice_3082OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getDevice_3082SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createDeviceStructure_7057Children(getCompartment(view, DeviceCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createExecutionEnvironment_3083Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getExecutionEnvironment_3083OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getExecutionEnvironment_3083SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createExecutionEnvironmentStructure_7058Children(getCompartment(view, ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createNode_3084Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getNode_3084OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getNode_3084SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createNodeStructure_7059Children(getCompartment(view, NodeCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createClass_3085Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getClass_3085OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getClass_3085SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createClassStructure_7060Children(getCompartment(view, ClassCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createCollaboration_3086Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getCollaboration_3086OutgoingLinks(view));
		createCollaborationStructure_7061Children(getCompartment(view, CollaborationCompositeCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createInterface_3087Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInterface_3087OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createPrimitiveType_3078Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getPrimitiveType_3078OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createEnumeration_3079Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getEnumeration_3079OutgoingLinks(view));
		Collection childNodeDescriptors = UMLDiagramUpdater.getEnumeration_3079SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
		createEnumerationLiterals_7049Children(getCompartment(view, EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createDataType_3080Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDataType_3080OutgoingLinks(view));
		createDataTypeProperties_7036Children(getCompartment(view, DataTypeAttributeCompartmentEditPartCN.VISUAL_ID));
		createDataTypeOperations_7037Children(getCompartment(view, DataTypeOperationCompartmentEditPartCN.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	private void createActor_3091Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getActor_3091OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createDeploymentSpecification_3092Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDeploymentSpecification_3092OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createArtifact_3093Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getArtifact_3093OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createInformationItem_3094Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInformationItem_3094OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createSignal_3095Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getSignal_3095OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createUseCase_3096Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getUseCase_3096OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createComment_3097Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getComment_3097OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createDurationConstraint_3116Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDurationConstraint_3116OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createTimeConstraint_3117Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getTimeConstraint_3117OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createIntervalConstraint_3118Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getIntervalConstraint_3118OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createInteractionConstraint_3119Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInteractionConstraint_3119OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createConstraint_3120Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getConstraint_3120OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createProperty_3101Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getProperty_3101OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createOperation_3102Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getOperation_3102OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createReception_3100Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getReception_3100OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createEnumerationLiteral_3066Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getEnumerationLiteral_3066OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createActivity_3103Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getActivity_3103OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createInteraction_3104Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInteraction_3104OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createProtocolStateMachine_3105Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getProtocolStateMachine_3105OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createStateMachine_3106Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getStateMachine_3106OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createFunctionBehavior_3107Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getFunctionBehavior_3107OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createOpaqueBehavior_3108Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getOpaqueBehavior_3108OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createCollaboration_3109Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getCollaboration_3109OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createInterface_3110Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getInterface_3110OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createEnumeration_3111Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getEnumeration_3111OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createPrimitiveType_3112Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getPrimitiveType_3112OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createDataType_3113Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getDataType_3113OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createClass_3114Children(View view) {
		myDomain2NotationMap.put(view.getElement(), view);
		myLinkDescriptors.addAll(UMLDiagramUpdater.getClass_3114OutgoingLinks(view));
	}

	/**
	 * @generated
	 */
	private void createDataTypeProperties_7033Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getDataTypeProperties_7033SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createDataTypeOperations_7034Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getDataTypeOperations_7034SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createDataTypeProperties_7036Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getDataTypeProperties_7036SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createDataTypeOperations_7037Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getDataTypeOperations_7037SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEnumerationLiterals_7048Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getEnumerationLiterals_7048SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createEnumerationLiterals_7049Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getEnumerationLiterals_7049SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createActivityStructure_7050Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getActivityStructure_7050SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createInteractionStructure_7051Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getInteractionStructure_7051SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createProtocolStateMachineStructure_7052Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getProtocolStateMachineStructure_7052SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createStateMachineStructure_7053Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getStateMachineStructure_7053SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createFunctionBehaviorStructure_7054Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getFunctionBehaviorStructure_7054SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createOpaqueBehaviorStructure_7055Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getOpaqueBehaviorStructure_7055SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createComponentStructure_7056Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getComponentStructure_7056SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createDeviceStructure_7057Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getDeviceStructure_7057SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createExecutionEnvironmentStructure_7058Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getExecutionEnvironmentStructure_7058SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createNodeStructure_7059Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getNodeStructure_7059SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createClassStructure_7060Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getClassStructure_7060SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createCollaborationStructure_7061Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getCollaborationStructure_7061SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createActivityStructure_7063Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getActivityStructure_7063SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createInteractionStructure_7064Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getInteractionStructure_7064SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createProtocolStateMachineStructure_7065Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getProtocolStateMachineStructure_7065SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createStateMachineStructure_7066Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getStateMachineStructure_7066SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createFunctionBehaviorStructure_7067Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getFunctionBehaviorStructure_7067SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createOpaqueBehaviorStructure_7068Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getOpaqueBehaviorStructure_7068SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createComponentStructure_7069Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getComponentStructure_7069SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createDeviceStructure_7070Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getDeviceStructure_7070SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createExecutionEnvironmentStructure_7071Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getExecutionEnvironmentStructure_7071SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createNodeStructure_7072Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getNodeStructure_7072SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createClassStructure_7073Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getClassStructure_7073SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createCollaborationStructure_7075Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getCollaborationStructure_7075SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createPropertyStructure_7077Children(View view) {
		Collection childNodeDescriptors = UMLDiagramUpdater.getPropertyStructure_7077SemanticChildren(view);
		for(Iterator it = childNodeDescriptors.iterator(); it.hasNext();) {
			createNode(view, (UMLNodeDescriptor)it.next());
		}
	}

	/**
	 * @generated
	 */
	private void createNode(View parentView, UMLNodeDescriptor nodeDescriptor) {
		final String nodeType = UMLVisualIDRegistry.getType(nodeDescriptor.getVisualID());
		Node node = ViewService.createNode(parentView, nodeDescriptor.getModelElement(), nodeType, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
		switch(nodeDescriptor.getVisualID()) {
		case ActivityCompositeEditPart.VISUAL_ID:
			createActivity_2060Children(node);
			return;
		case InteractionCompositeEditPart.VISUAL_ID:
			createInteraction_2061Children(node);
			return;
		case ProtocolStateMachineCompositeEditPart.VISUAL_ID:
			createProtocolStateMachine_2062Children(node);
			return;
		case StateMachineCompositeEditPart.VISUAL_ID:
			createStateMachine_2063Children(node);
			return;
		case FunctionBehaviorCompositeEditPart.VISUAL_ID:
			createFunctionBehavior_2064Children(node);
			return;
		case OpaqueBehaviorCompositeEditPart.VISUAL_ID:
			createOpaqueBehavior_2065Children(node);
			return;
		case ComponentCompositeEditPart.VISUAL_ID:
			createComponent_2069Children(node);
			return;
		case DeviceCompositeEditPart.VISUAL_ID:
			createDevice_2070Children(node);
			return;
		case ExecutionEnvironmentCompositeEditPart.VISUAL_ID:
			createExecutionEnvironment_2071Children(node);
			return;
		case NodeCompositeEditPart.VISUAL_ID:
			createNode_2072Children(node);
			return;
		case ClassCompositeEditPart.VISUAL_ID:
			createClass_2073Children(node);
			return;
		case CollaborationCompositeEditPart.VISUAL_ID:
			createCollaboration_2075Children(node);
			return;
		case InterfaceEditPart.VISUAL_ID:
			createInterface_2076Children(node);
			return;
		case PrimitiveTypeEditPart.VISUAL_ID:
			createPrimitiveType_2066Children(node);
			return;
		case EnumerationEditPart.VISUAL_ID:
			createEnumeration_2067Children(node);
			return;
		case DataTypeEditPart.VISUAL_ID:
			createDataType_2068Children(node);
			return;
		case ActorEditPart.VISUAL_ID:
			createActor_2077Children(node);
			return;
		case DeploymentSpecificationEditPart.VISUAL_ID:
			createDeploymentSpecification_2078Children(node);
			return;
		case ArtifactEditPart.VISUAL_ID:
			createArtifact_2079Children(node);
			return;
		case InformationItemEditPart.VISUAL_ID:
			createInformationItem_2080Children(node);
			return;
		case SignalEditPart.VISUAL_ID:
			createSignal_2081Children(node);
			return;
		case UseCaseEditPart.VISUAL_ID:
			createUseCase_2082Children(node);
			return;
		case SignalEventEditPart.VISUAL_ID:
			createSignalEvent_2083Children(node);
			return;
		case CallEventEditPart.VISUAL_ID:
			createCallEvent_2084Children(node);
			return;
		case AnyReceiveEventEditPart.VISUAL_ID:
			createAnyReceiveEvent_2085Children(node);
			return;
		case ChangeEventEditPart.VISUAL_ID:
			createChangeEvent_2088Children(node);
			return;
		case TimeEventEditPart.VISUAL_ID:
			createTimeEvent_2089Children(node);
			return;
		case DurationObservationEditPart.VISUAL_ID:
			createDurationObservation_2093Children(node);
			return;
		case TimeObservationEditPart.VISUAL_ID:
			createTimeObservation_2094Children(node);
			return;
		case LiteralBooleanEditPart.VISUAL_ID:
			createLiteralBoolean_2095Children(node);
			return;
		case LiteralIntegerEditPart.VISUAL_ID:
			createLiteralInteger_2096Children(node);
			return;
		case LiteralNullEditPart.VISUAL_ID:
			createLiteralNull_2097Children(node);
			return;
		case LiteralStringEditPart.VISUAL_ID:
			createLiteralString_2098Children(node);
			return;
		case LiteralUnlimitedNaturalEditPart.VISUAL_ID:
			createLiteralUnlimitedNatural_2099Children(node);
			return;
		case StringExpressionEditPart.VISUAL_ID:
			createStringExpression_2100Children(node);
			return;
		case OpaqueExpressionEditPart.VISUAL_ID:
			createOpaqueExpression_2101Children(node);
			return;
		case TimeExpressionEditPart.VISUAL_ID:
			createTimeExpression_2102Children(node);
			return;
		case ExpressionEditPart.VISUAL_ID:
			createExpression_2103Children(node);
			return;
		case DurationEditPart.VISUAL_ID:
			createDuration_2104Children(node);
			return;
		case TimeIntervalEditPart.VISUAL_ID:
			createTimeInterval_2105Children(node);
			return;
		case DurationIntervalEditPart.VISUAL_ID:
			createDurationInterval_2106Children(node);
			return;
		case IntervalEditPart.VISUAL_ID:
			createInterval_2107Children(node);
			return;
		case InstanceValueEditPart.VISUAL_ID:
			createInstanceValue_2108Children(node);
			return;
		case CommentEditPart.VISUAL_ID:
			createComment_2109Children(node);
			return;
		case DurationConstraintEditPart.VISUAL_ID:
			createDurationConstraint_2110Children(node);
			return;
		case TimeConstraintEditPart.VISUAL_ID:
			createTimeConstraint_2111Children(node);
			return;
		case IntervalConstraintEditPart.VISUAL_ID:
			createIntervalConstraint_2112Children(node);
			return;
		case InteractionConstraintEditPart.VISUAL_ID:
			createInteractionConstraint_2113Children(node);
			return;
		case ConstraintEditPart.VISUAL_ID:
			createConstraint_2114Children(node);
			return;
		case PortEditPart.VISUAL_ID:
			createPort_3069Children(node);
			return;
		case ParameterEditPart.VISUAL_ID:
			createParameter_3088Children(node);
			return;
		case PropertyPartEditPartCN.VISUAL_ID:
			createProperty_3070Children(node);
			return;
		case CollaborationRoleEditPartCN.VISUAL_ID:
			createConnectableElement_3115Children(node);
			return;
		case CollaborationUseEditPartCN.VISUAL_ID:
			createCollaborationUse_3071Children(node);
			return;
		case ActivityCompositeEditPartCN.VISUAL_ID:
			createActivity_3072Children(node);
			return;
		case InteractionCompositeEditPartCN.VISUAL_ID:
			createInteraction_3073Children(node);
			return;
		case ProtocolStateMachineCompositeEditPartCN.VISUAL_ID:
			createProtocolStateMachine_3074Children(node);
			return;
		case StateMachineCompositeEditPartCN.VISUAL_ID:
			createStateMachine_3075Children(node);
			return;
		case FunctionBehaviorCompositeEditPartCN.VISUAL_ID:
			createFunctionBehavior_3076Children(node);
			return;
		case OpaqueBehaviorCompositeEditPartCN.VISUAL_ID:
			createOpaqueBehavior_3077Children(node);
			return;
		case ComponentCompositeEditPartCN.VISUAL_ID:
			createComponent_3081Children(node);
			return;
		case DeviceCompositeEditPartCN.VISUAL_ID:
			createDevice_3082Children(node);
			return;
		case ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID:
			createExecutionEnvironment_3083Children(node);
			return;
		case NodeCompositeEditPartCN.VISUAL_ID:
			createNode_3084Children(node);
			return;
		case ClassCompositeEditPartCN.VISUAL_ID:
			createClass_3085Children(node);
			return;
		case CollaborationCompositeEditPartCN.VISUAL_ID:
			createCollaboration_3086Children(node);
			return;
		case InterfaceEditPartCN.VISUAL_ID:
			createInterface_3087Children(node);
			return;
		case PrimitiveTypeEditPartCN.VISUAL_ID:
			createPrimitiveType_3078Children(node);
			return;
		case EnumerationEditPartCN.VISUAL_ID:
			createEnumeration_3079Children(node);
			return;
		case DataTypeEditPartCN.VISUAL_ID:
			createDataType_3080Children(node);
			return;
		case ActorEditPartCN.VISUAL_ID:
			createActor_3091Children(node);
			return;
		case DeploymentSpecificationEditPartCN.VISUAL_ID:
			createDeploymentSpecification_3092Children(node);
			return;
		case ArtifactEditPartCN.VISUAL_ID:
			createArtifact_3093Children(node);
			return;
		case InformationItemEditPartCN.VISUAL_ID:
			createInformationItem_3094Children(node);
			return;
		case SignalEditPartCN.VISUAL_ID:
			createSignal_3095Children(node);
			return;
		case UseCaseEditPartCN.VISUAL_ID:
			createUseCase_3096Children(node);
			return;
		case CommentEditPartCN.VISUAL_ID:
			createComment_3097Children(node);
			return;
		case DurationConstraintEditPartCN.VISUAL_ID:
			createDurationConstraint_3116Children(node);
			return;
		case TimeConstraintEditPartCN.VISUAL_ID:
			createTimeConstraint_3117Children(node);
			return;
		case IntervalConstraintEditPartCN.VISUAL_ID:
			createIntervalConstraint_3118Children(node);
			return;
		case InteractionConstraintEditPartCN.VISUAL_ID:
			createInteractionConstraint_3119Children(node);
			return;
		case ConstraintEditPartCN.VISUAL_ID:
			createConstraint_3120Children(node);
			return;
		case PropertyEditPartCLN.VISUAL_ID:
			createProperty_3101Children(node);
			return;
		case OperationEditPartCLN.VISUAL_ID:
			createOperation_3102Children(node);
			return;
		case ReceptionEditPartCLN.VISUAL_ID:
			createReception_3100Children(node);
			return;
		case EnumerationLiteralEditPartCLN.VISUAL_ID:
			createEnumerationLiteral_3066Children(node);
			return;
		case ActivityEditPartCLN.VISUAL_ID:
			createActivity_3103Children(node);
			return;
		case InteractionEditPartCLN.VISUAL_ID:
			createInteraction_3104Children(node);
			return;
		case ProtocolStateMachineEditPartCLN.VISUAL_ID:
			createProtocolStateMachine_3105Children(node);
			return;
		case StateMachineEditPartCLN.VISUAL_ID:
			createStateMachine_3106Children(node);
			return;
		case FunctionBehaviorEditPartCLN.VISUAL_ID:
			createFunctionBehavior_3107Children(node);
			return;
		case OpaqueBehaviorEditPartCLN.VISUAL_ID:
			createOpaqueBehavior_3108Children(node);
			return;
		case CollaborationEditPartCLN.VISUAL_ID:
			createCollaboration_3109Children(node);
			return;
		case InterfaceEditPartCLN.VISUAL_ID:
			createInterface_3110Children(node);
			return;
		case EnumerationEditPartCLN.VISUAL_ID:
			createEnumeration_3111Children(node);
			return;
		case PrimitiveTypeEditPartCLN.VISUAL_ID:
			createPrimitiveType_3112Children(node);
			return;
		case DataTypeEditPartCLN.VISUAL_ID:
			createDataType_3113Children(node);
			return;
		case ClassEditPartCLN.VISUAL_ID:
			createClass_3114Children(node);
			return;
		}
	}

	/**
	 * @generated
	 */
	private void createLinks(Diagram diagram) {
		for(boolean continueLinkCreation = true; continueLinkCreation;) {
			continueLinkCreation = false;
			Collection additionalDescriptors = new LinkedList();
			for(Iterator it = myLinkDescriptors.iterator(); it.hasNext();) {
				UMLLinkDescriptor nextLinkDescriptor = (UMLLinkDescriptor)it.next();
				if(!myDomain2NotationMap.containsKey(nextLinkDescriptor.getSource()) || !myDomain2NotationMap.containsKey(nextLinkDescriptor.getDestination())) {
					continue;
				}
				final String linkType = UMLVisualIDRegistry.getType(nextLinkDescriptor.getVisualID());
				Edge edge = ViewService.getInstance().createEdge(nextLinkDescriptor.getSemanticAdapter(), diagram, linkType, ViewUtil.APPEND, true, UMLDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
				if(edge != null) {
					edge.setSource((View)myDomain2NotationMap.get(nextLinkDescriptor.getSource()));
					edge.setTarget((View)myDomain2NotationMap.get(nextLinkDescriptor.getDestination()));
					it.remove();
					if(nextLinkDescriptor.getModelElement() != null) {
						myDomain2NotationMap.put(nextLinkDescriptor.getModelElement(), edge);
					}
					continueLinkCreation = true;
					switch(nextLinkDescriptor.getVisualID()) {
					case ComponentRealizationEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getComponentRealization_4004OutgoingLinks(edge));
						break;
					case InterfaceRealizationEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getInterfaceRealization_4005OutgoingLinks(edge));
						break;
					case SubstitutionEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getSubstitution_4011OutgoingLinks(edge));
						break;
					case RealizationEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getRealization_4006OutgoingLinks(edge));
						break;
					case ManifestationEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getManifestation_4012OutgoingLinks(edge));
						break;
					case AbstractionEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getAbstraction_4007OutgoingLinks(edge));
						break;
					case UsageEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getUsage_4008OutgoingLinks(edge));
						break;
					case DeploymentEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getDeployment_4009OutgoingLinks(edge));
						break;
					case RoleBindingEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getDependency_4017OutgoingLinks(edge));
						break;
					case DependencyEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getDependency_4010OutgoingLinks(edge));
						break;
					case ConnectorEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getConnector_4013OutgoingLinks(edge));
						break;
					case GeneralizationEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getGeneralization_4015OutgoingLinks(edge));
						break;
					case InformationFlowEditPart.VISUAL_ID:
						additionalDescriptors.addAll(UMLDiagramUpdater.getInformationFlow_4021OutgoingLinks(edge));
						break;
					}
				}
			}
			myLinkDescriptors.addAll(additionalDescriptors);
		}
	}

	/**
	 * @generated
	 */
	private Node getCompartment(View node, int visualID) {
		String type = UMLVisualIDRegistry.getType(visualID);
		for(Iterator it = node.getChildren().iterator(); it.hasNext();) {
			View nextView = (View)it.next();
			if(nextView instanceof Node && type.equals(nextView.getType())) {
				return (Node)nextView;
			}
		}
		return null;
	}
}
