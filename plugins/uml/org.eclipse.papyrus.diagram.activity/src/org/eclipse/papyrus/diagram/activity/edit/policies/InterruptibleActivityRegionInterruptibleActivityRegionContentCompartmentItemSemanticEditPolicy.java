/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.activity.edit.commands.AcceptEventActionInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityFinalNodeInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CallBehaviorActionInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CallOperationActionInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.DataStoreNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.DecisionNodeInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.DurationConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.DurationConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.FlowFinalNodeInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ForkNodeInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.InitialNodeInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.InteractionConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.InteractionConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.IntervalConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.IntervalConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.JoinNodeInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.MergeNodeInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.OpaqueActionInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.SendObjectActionInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.SendSignalActionInIARCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.TimeConstraintAsLocalPostcondCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.TimeConstraintAsLocalPrecondCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ValueSpecificationActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */
public class InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.InterruptibleActivityRegion_3068);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.InitialNode_3079 == req.getElementType()) {
			return getGEFWrapper(new InitialNodeInIARCreateCommand(req));
		}
		if(UMLElementTypes.ActivityFinalNode_3080 == req.getElementType()) {
			return getGEFWrapper(new ActivityFinalNodeInIARCreateCommand(req));
		}
		if(UMLElementTypes.FlowFinalNode_3081 == req.getElementType()) {
			return getGEFWrapper(new FlowFinalNodeInIARCreateCommand(req));
		}
		if(UMLElementTypes.Constraint_3011 == req.getElementType()) {
			return getGEFWrapper(new ConstraintAsLocalPrecondCreateCommand(req));
		}
		if(UMLElementTypes.Constraint_3012 == req.getElementType()) {
			return getGEFWrapper(new ConstraintAsLocalPostcondCreateCommand(req));
		}
		if(UMLElementTypes.DurationConstraint_3034 == req.getElementType()) {
			return getGEFWrapper(new DurationConstraintAsLocalPrecondCreateCommand(req));
		}
		if(UMLElementTypes.DurationConstraint_3035 == req.getElementType()) {
			return getGEFWrapper(new DurationConstraintAsLocalPostcondCreateCommand(req));
		}
		if(UMLElementTypes.InteractionConstraint_3030 == req.getElementType()) {
			return getGEFWrapper(new InteractionConstraintAsLocalPrecondCreateCommand(req));
		}
		if(UMLElementTypes.InteractionConstraint_3031 == req.getElementType()) {
			return getGEFWrapper(new InteractionConstraintAsLocalPostcondCreateCommand(req));
		}
		if(UMLElementTypes.IntervalConstraint_3032 == req.getElementType()) {
			return getGEFWrapper(new IntervalConstraintAsLocalPrecondCreateCommand(req));
		}
		if(UMLElementTypes.IntervalConstraint_3033 == req.getElementType()) {
			return getGEFWrapper(new IntervalConstraintAsLocalPostcondCreateCommand(req));
		}
		if(UMLElementTypes.TimeConstraint_3036 == req.getElementType()) {
			return getGEFWrapper(new TimeConstraintAsLocalPrecondCreateCommand(req));
		}
		if(UMLElementTypes.TimeConstraint_3037 == req.getElementType()) {
			return getGEFWrapper(new TimeConstraintAsLocalPostcondCreateCommand(req));
		}
		if(UMLElementTypes.OpaqueAction_3082 == req.getElementType()) {
			return getGEFWrapper(new OpaqueActionInIARCreateCommand(req));
		}
		if(UMLElementTypes.CallBehaviorAction_3083 == req.getElementType()) {
			return getGEFWrapper(new CallBehaviorActionInIARCreateCommand(req));
		}
		if(UMLElementTypes.CallOperationAction_3084 == req.getElementType()) {
			return getGEFWrapper(new CallOperationActionInIARCreateCommand(req));
		}
		if(UMLElementTypes.SendObjectAction_3085 == req.getElementType()) {
			return getGEFWrapper(new SendObjectActionInIARCreateCommand(req));
		}
		if(UMLElementTypes.SendSignalAction_3086 == req.getElementType()) {
			return getGEFWrapper(new SendSignalActionInIARCreateCommand(req));
		}
		if(UMLElementTypes.AcceptEventAction_3087 == req.getElementType()) {
			return getGEFWrapper(new AcceptEventActionInIARCreateCommand(req));
		}
		if(UMLElementTypes.ValueSpecificationAction_3076 == req.getElementType()) {
			return getGEFWrapper(new ValueSpecificationActionCreateCommand(req));
		}
		if(UMLElementTypes.DecisionNode_3089 == req.getElementType()) {
			return getGEFWrapper(new DecisionNodeInIARCreateCommand(req));
		}
		if(UMLElementTypes.MergeNode_3090 == req.getElementType()) {
			return getGEFWrapper(new MergeNodeInIARCreateCommand(req));
		}
		if(UMLElementTypes.ForkNode_3091 == req.getElementType()) {
			return getGEFWrapper(new ForkNodeInIARCreateCommand(req));
		}
		if(UMLElementTypes.JoinNode_3092 == req.getElementType()) {
			return getGEFWrapper(new JoinNodeInIARCreateCommand(req));
		}
		if(UMLElementTypes.DataStoreNode_3078 == req.getElementType()) {
			return getGEFWrapper(new DataStoreNodeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}


}
