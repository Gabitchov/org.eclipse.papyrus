/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.provider;

import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

/**
 * <pre>
 * This class provides graphical type id (used as View type) for
 * domain element according to their actual or expected graphical
 * container type.
 * </pre>
 */
public class GraphicalTypeRegistry implements IGraphicalTypeRegistry {

	/** A Set containing all known node graphical types */
	protected Set<String> knownNodes = new HashSet<String>();

	/** A Set containing all known edge graphical types */
	protected Set<String> knownEdges = new HashSet<String>();

	/** Default constructor */
	public GraphicalTypeRegistry() {

		// Fill known edges set
		knownEdges.add(ElementTypes.CONTROL_FLOW.getSemanticHint());
		knownEdges.add(ElementTypes.COMMENT_ANNOTATED_ELEMENT.getSemanticHint());

		// Fill known nodes set (primary nodes)
		knownNodes.add(ElementTypes.ACTIVITY_FINAL_NODE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.CALL_BEHAVIOR_ACTION_CN.getSemanticHint());
		knownNodes.add(ElementTypes.COMMENT_CN.getSemanticHint());
		knownNodes.add(ElementTypes.CONDITIONAL_NODE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.DECISION_NODE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.FLOW_FINAL_NODE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.FORK_NODE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.INITIAL_NODE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.JOIN_NODE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.LOOP_NODE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.MERGE_NODE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.SHAPE_NAMED_ELEMENT_CN.getSemanticHint());
		knownNodes.add(ElementTypes.ACTIVITY.getSemanticHint());
		knownNodes.add(ElementTypes.SEQUENCE_NODE_CN.getSemanticHint());
		knownNodes.add(ElementTypes.CONSTRAINT_CN.getSemanticHint());

		// Fill known nodes set (child label nodes)
		knownNodes.add(ElementTypes.ACTIVITY_PARAMETER_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.ACTIVITY_CONSTRAINT_CLN.getSemanticHint());
		knownNodes.add(ElementTypes.ACTIVITY_CONSTRAINT_CLN.getSemanticHint());
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEdgeGraphicalType(final EObject domainElement) {

		String graphicalType = UNDEFINED_TYPE;
		if(domainElement == null) {
			return UNDEFINED_TYPE;
		}
		if(domainElement instanceof org.eclipse.uml2.uml.ControlFlow) {
			graphicalType = ElementTypes.CONTROL_FLOW.getSemanticHint();
		}
		return graphicalType;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEdgeGraphicalType(final IElementType elementType) {
		if(elementType instanceof IHintedType) {
			final String semanticHint = ((IHintedType)elementType).getSemanticHint();
			return getEdgeGraphicalType(semanticHint);
		}

		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getEdgeGraphicalType(final String proposedType) {
		if(isKnownEdgeType(proposedType)) {
			return proposedType;
		}

		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getNodeGraphicalType(final EObject domainElement, final String containerType) {

		String graphicalType = UNDEFINED_TYPE;
		if((containerType == null) || (domainElement == null)) {
			return UNDEFINED_TYPE;
		}

		if(domainElement instanceof org.eclipse.uml2.uml.ActivityFinalNode) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // ActivityFinalNode ChildNode
				graphicalType = ElementTypes.ACTIVITY_FINAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // ActivityFinalNode ChildNode
				graphicalType = ElementTypes.ACTIVITY_FINAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // ActivityFinalNode ChildNode
				graphicalType = ElementTypes.ACTIVITY_FINAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // ActivityFinalNode ChildNode
				graphicalType = ElementTypes.ACTIVITY_FINAL_NODE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.CallBehaviorAction) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // CallBehaviorAction ChildNode
				graphicalType = ElementTypes.CALL_BEHAVIOR_ACTION_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // CallBehaviorAction ChildNode
				graphicalType = ElementTypes.CALL_BEHAVIOR_ACTION_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // CallBehaviorAction ChildNode
				graphicalType = ElementTypes.CALL_BEHAVIOR_ACTION_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // CallBehaviorAction ChildNode
				graphicalType = ElementTypes.CALL_BEHAVIOR_ACTION_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.Comment) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // Comment ChildNode
				graphicalType = ElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // Comment ChildNode
				graphicalType = ElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // Comment ChildNode
				graphicalType = ElementTypes.COMMENT_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // Comment ChildNode
				graphicalType = ElementTypes.COMMENT_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.ConditionalNode) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // ConditionalNode ChildNode
				graphicalType = ElementTypes.CONDITIONAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // ConditionalNode ChildNode
				graphicalType = ElementTypes.CONDITIONAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // ConditionalNode ChildNode
				graphicalType = ElementTypes.CONDITIONAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // ConditionalNode ChildNode
				graphicalType = ElementTypes.CONDITIONAL_NODE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.DecisionNode) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // DecisionNode ChildNode
				graphicalType = ElementTypes.DECISION_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // DecisionNode ChildNode
				graphicalType = ElementTypes.DECISION_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // DecisionNode ChildNode
				graphicalType = ElementTypes.DECISION_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // DecisionNode ChildNode
				graphicalType = ElementTypes.DECISION_NODE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.FlowFinalNode) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // FlowFinalNode ChildNode
				graphicalType = ElementTypes.FLOW_FINAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // FlowFinalNode ChildNode
				graphicalType = ElementTypes.FLOW_FINAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // FlowFinalNode ChildNode
				graphicalType = ElementTypes.FLOW_FINAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // FlowFinalNode ChildNode
				graphicalType = ElementTypes.FLOW_FINAL_NODE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.ForkNode) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // ForkNode ChildNode
				graphicalType = ElementTypes.FORK_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // ForkNode ChildNode
				graphicalType = ElementTypes.FORK_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // ForkNode ChildNode
				graphicalType = ElementTypes.FORK_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // ForkNode ChildNode
				graphicalType = ElementTypes.FORK_NODE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.InitialNode) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // InitialNode ChildNode
				graphicalType = ElementTypes.INITIAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // InitialNode ChildNode
				graphicalType = ElementTypes.INITIAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // InitialNode ChildNode
				graphicalType = ElementTypes.INITIAL_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // InitialNode ChildNode
				graphicalType = ElementTypes.INITIAL_NODE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.JoinNode) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // JoinNode ChildNode
				graphicalType = ElementTypes.JOIN_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // JoinNode ChildNode
				graphicalType = ElementTypes.JOIN_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // JoinNode ChildNode
				graphicalType = ElementTypes.JOIN_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // JoinNode ChildNode
				graphicalType = ElementTypes.JOIN_NODE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.LoopNode) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // LoopNode ChildNode
				graphicalType = ElementTypes.LOOP_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // LoopNode ChildNode
				graphicalType = ElementTypes.LOOP_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // LoopNode ChildNode
				graphicalType = ElementTypes.LOOP_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // LoopNode ChildNode
				graphicalType = ElementTypes.LOOP_NODE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.MergeNode) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // MergeNode ChildNode
				graphicalType = ElementTypes.MERGE_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // MergeNode ChildNode
				graphicalType = ElementTypes.MERGE_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // MergeNode ChildNode
				graphicalType = ElementTypes.MERGE_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // MergeNode ChildNode
				graphicalType = ElementTypes.MERGE_NODE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.NamedElement) {

		}

		if(domainElement instanceof org.eclipse.uml2.uml.Activity) {
			if(ElementTypes.DIAGRAM_ID.equals(containerType)) { // Activity
																// TopNode
				graphicalType = ElementTypes.ACTIVITY.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.SequenceNode) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // SequenceNode ChildNode
				graphicalType = ElementTypes.SEQUENCE_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // SequenceNode ChildNode
				graphicalType = ElementTypes.SEQUENCE_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // SequenceNode ChildNode
				graphicalType = ElementTypes.SEQUENCE_NODE_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // SequenceNode ChildNode
				graphicalType = ElementTypes.SEQUENCE_NODE_CN.getSemanticHint();
			}

		}

		if(domainElement instanceof org.eclipse.uml2.uml.Constraint) {
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT.equals(containerType)) { // Constraint ChildNode
				graphicalType = ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(ElementTypes.CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // Constraint ChildNode
				graphicalType = ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(ElementTypes.LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // Constraint ChildNode
				graphicalType = ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}
			if(ElementTypes.SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT.equals(containerType)) { // Constraint ChildNode
				graphicalType = ElementTypes.CONSTRAINT_CN.getSemanticHint();
			}

			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_PRECONDITION_HINT.equals(containerType)) { // Constraint ChildLabelNode
				graphicalType = ElementTypes.ACTIVITY_CONSTRAINT_CLN.getSemanticHint();
			}
			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_POST_CONDTION_HINT.equals(containerType)) { // Constraint ChildLabelNode
				graphicalType = ElementTypes.ACTIVITY_CONSTRAINT_CLN.getSemanticHint();
			}
		}

		if(domainElement instanceof org.eclipse.uml2.uml.Parameter) {

			if(ElementTypes.ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_PARAMETER_HINT.equals(containerType)) { // Parameter ChildLabelNode
				graphicalType = ElementTypes.ACTIVITY_PARAMETER_CLN.getSemanticHint();
			}
		}

		return graphicalType;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getNodeGraphicalType(final IElementType elementType, final String containerType) {
		if(elementType instanceof IHintedType) {
			final String semanticHint = ((IHintedType)elementType).getSemanticHint();
			return getNodeGraphicalType(semanticHint, containerType);
		}

		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	public String getNodeGraphicalType(final String proposedType, final String containerType) {
		if(isKnownNodeType(proposedType)) {
			return proposedType;
		}

		return UNDEFINED_TYPE;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isKnownEdgeType(final String type) {
		return knownEdges.contains(type);
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean isKnownNodeType(final String type) {
		return knownNodes.contains(type);
	}
}
