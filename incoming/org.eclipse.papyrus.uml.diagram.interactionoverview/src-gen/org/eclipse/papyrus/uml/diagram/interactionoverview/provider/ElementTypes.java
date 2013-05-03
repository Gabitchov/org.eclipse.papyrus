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

import org.eclipse.gmf.runtime.emf.type.core.AbstractElementTypeEnumerator;
import org.eclipse.gmf.runtime.emf.type.core.IHintedType;

public class ElementTypes extends AbstractElementTypeEnumerator {

	/** ********************************************************* */
	/** Interaction Overview Diagram specific elements **************** */
	/** ********************************************************* */

	/** Interaction Overview Diagram :: Diagram */
	public static final String DIAGRAM_ID = "InteractionOverviewDiagram"; //$NON-NLS-1$

	/** ********************************************************* */
	/** Interaction Overview Diagram - ActivityDiagram related elements */
	/** ********************************************************* */

	/** ActivityDiagram :: ACTIVITY_FINAL_NODE_CN */
	public static final IHintedType ACTIVITY_FINAL_NODE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.ActivityFinalNode_3005"); //$NON-NLS-1$

	public static final String ACTIVITY_FINAL_NODE_CN_LABEL_APPLIED_STEREOTYPE_HINT = "5081"; //$NON-NLS-1$

	/** ActivityDiagram :: CALL_BEHAVIOR_ACTION_CN */
	public static final IHintedType CALL_BEHAVIOR_ACTION_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.CallBehaviorAction_3008"); //$NON-NLS-1$

	public static final String CALL_BEHAVIOR_ACTION_CN_LABEL_NAME_HINT = "5004"; //$NON-NLS-1$

	/** ActivityDiagram :: COMMENT_CN */
	public static final IHintedType COMMENT_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.Comment_3080"); //$NON-NLS-1$

	public static final String COMMENT_CN_LABEL_BODY_LABEL_HINT = "5138"; //$NON-NLS-1$

	/** ActivityDiagram :: CONDITIONAL_NODE_CN */
	public static final IHintedType CONDITIONAL_NODE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.ConditionalNode_3069"); //$NON-NLS-1$

	public static final String CONDITIONAL_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT = "7008"; //$NON-NLS-1$

	public static final String CONDITIONAL_NODE_CN_LABEL_KEYWORD_HINT = "5119"; //$NON-NLS-1$

	/** ActivityDiagram :: DECISION_NODE_CN */
	public static final IHintedType DECISION_NODE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.DecisionNode_3038"); //$NON-NLS-1$

	public static final String DECISION_NODE_CN_LABEL_DECISION_INPUT_HINT = "5043"; //$NON-NLS-1$

	public static final String DECISION_NODE_CN_LABEL_APPLIED_STEREOTYPE_HINT = "5098"; //$NON-NLS-1$

	/** ActivityDiagram :: FLOW_FINAL_NODE_CN */
	public static final IHintedType FLOW_FINAL_NODE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.FlowFinalNode_3006"); //$NON-NLS-1$

	public static final String FLOW_FINAL_NODE_CN_LABEL_APPLIED_STEREOTYPE_HINT = "5082"; //$NON-NLS-1$

	/** ActivityDiagram :: FORK_NODE_CN */
	public static final IHintedType FORK_NODE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.ForkNode_3040"); //$NON-NLS-1$

	public static final String FORK_NODE_CN_LABEL_APPLIED_STEREOTYPE_HINT = "5100"; //$NON-NLS-1$

	/** ActivityDiagram :: INITIAL_NODE_CN */
	public static final IHintedType INITIAL_NODE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.InitialNode_3004"); //$NON-NLS-1$

	public static final String INITIAL_NODE_CN_LABEL_APPLIED_STEREOTYPE_HINT = "5080"; //$NON-NLS-1$

	/** ActivityDiagram :: JOIN_NODE_CN */
	public static final IHintedType JOIN_NODE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.JoinNode_3041"); //$NON-NLS-1$

	public static final String JOIN_NODE_CN_LABEL_JOIN_SPEC_HINT = "5042"; //$NON-NLS-1$

	public static final String JOIN_NODE_CN_LABEL_APPLIED_STEREOTYPE_HINT = "5101"; //$NON-NLS-1$

	/** ActivityDiagram :: LOOP_NODE_CN */
	public static final IHintedType LOOP_NODE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.LoopNode_3071"); //$NON-NLS-1$

	public static final String LOOP_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT = "7010"; //$NON-NLS-1$

	public static final String LOOP_NODE_CN_LABEL_KEYWORD_HINT = "5121"; //$NON-NLS-1$

	/** ActivityDiagram :: MERGE_NODE_CN */
	public static final IHintedType MERGE_NODE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.MergeNode_3039"); //$NON-NLS-1$

	public static final String MERGE_NODE_CN_LABEL_APPLIED_STEREOTYPE_HINT = "5099"; //$NON-NLS-1$

	/** ActivityDiagram :: SHAPE_NAMED_ELEMENT_CN */
	public static final IHintedType SHAPE_NAMED_ELEMENT_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.NamedElement_3085"); //$NON-NLS-1$

	public static final String SHAPE_NAMED_ELEMENT_CN_LABEL_NAME_HINT = "5129"; //$NON-NLS-1$

	/** ActivityDiagram :: ACTIVITY */
	public static final IHintedType ACTIVITY = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.Activity_2001"); //$NON-NLS-1$

	public static final String ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_PARAMETER_HINT = "7001"; //$NON-NLS-1$

	public static final String ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_PRECONDITION_HINT = "7002"; //$NON-NLS-1$

	public static final String ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_POST_CONDTION_HINT = "7003"; //$NON-NLS-1$

	public static final String ACTIVITY_COMPARTMENT_ACTIVITY_FIGURE_CONTENT_HINT = "7004"; //$NON-NLS-1$

	public static final String ACTIVITY_LABEL_NAME_HINT = "5001"; //$NON-NLS-1$

	public static final String ACTIVITY_LABEL_IS_SINGLE_EXECUTION_HINT = "5002"; //$NON-NLS-1$

	/** ActivityDiagram :: SEQUENCE_NODE_CN */
	public static final IHintedType SEQUENCE_NODE_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.SequenceNode_3073"); //$NON-NLS-1$

	public static final String SEQUENCE_NODE_CN_COMPARTMENT_STRUCTURED_ACTIVITY_NODE_CONTENT_HINT = "7012"; //$NON-NLS-1$

	public static final String SEQUENCE_NODE_CN_LABEL_KEYWORD_HINT = "5123"; //$NON-NLS-1$

	/** ActivityDiagram :: CONSTRAINT_CN */
	public static final IHintedType CONSTRAINT_CN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.Constraint_3112"); //$NON-NLS-1$

	public static final String CONSTRAINT_CN_LABEL_NAME_HINT = "5189"; //$NON-NLS-1$

	public static final String CONSTRAINT_CN_LABEL_BODY_HINT = "5190"; //$NON-NLS-1$

	/** ActivityDiagram :: COMMENT_ANNOTATED_ELEMENT */
	public static final IHintedType COMMENT_ANNOTATED_ELEMENT = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.CommentAnnotatedElement_4006"); //$NON-NLS-1$

	/** ActivityDiagram :: CONTROL_FLOW */
	public static final IHintedType CONTROL_FLOW = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.ControlFlow_4004"); //$NON-NLS-1$

	public static final String CONTROL_FLOW_LABEL_NAME_HINT = "6003"; //$NON-NLS-1$

	public static final String CONTROL_FLOW_LABEL_WEIGHT_HINT = "6004"; //$NON-NLS-1$

	public static final String CONTROL_FLOW_LABEL_GUARD_HINT = "6009"; //$NON-NLS-1$

	public static final String CONTROL_FLOW_LABEL_APPLIED_STEREOTYPE_HINT = "6011"; //$NON-NLS-1$

	public static final String CONTROL_FLOW_LABEL_INTERRUPTIBLE_ICON_HINT = "6013"; //$NON-NLS-1$

	/** ActivityDiagram :: ChildLabelNodes */
	public static final IHintedType ACTIVITY_PARAMETER_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.Parameter_3001"); //$NON-NLS-1$

	public static final IHintedType ACTIVITY_CONSTRAINT_CLN = (IHintedType)getElementType("org.eclipse.papyrus.uml.diagram.activity.Constraint_3002"); //$NON-NLS-1$

}
