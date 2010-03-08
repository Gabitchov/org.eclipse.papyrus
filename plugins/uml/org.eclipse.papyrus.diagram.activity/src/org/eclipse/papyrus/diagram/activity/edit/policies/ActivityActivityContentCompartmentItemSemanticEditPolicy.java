/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityFinalNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CallBehaviorActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CallOperationActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.DecisionNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.FlowFinalNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ForkNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.InitialNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.JoinNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.MergeNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.OpaqueActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */
public class ActivityActivityContentCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ActivityActivityContentCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Activity_2001);
	}

	/**
	 * @generated NOT (update at each gmf change) moved local conditions creation commands to {@link CreateActionLocalConditionEditPolicy}
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if(UMLElementTypes.InitialNode_3004 == req.getElementType()) {
			return getGEFWrapper(new InitialNodeCreateCommand(req));
		}
		if(UMLElementTypes.ActivityFinalNode_3005 == req.getElementType()) {
			return getGEFWrapper(new ActivityFinalNodeCreateCommand(req));
		}
		if(UMLElementTypes.FlowFinalNode_3006 == req.getElementType()) {
			return getGEFWrapper(new FlowFinalNodeCreateCommand(req));
		}
		if(UMLElementTypes.OpaqueAction_3007 == req.getElementType()) {
			return getGEFWrapper(new OpaqueActionCreateCommand(req));
		}
		if(UMLElementTypes.CallBehaviorAction_3008 == req.getElementType()) {
			return getGEFWrapper(new CallBehaviorActionCreateCommand(req));
		}
		if(UMLElementTypes.CallOperationAction_3010 == req.getElementType()) {
			return getGEFWrapper(new CallOperationActionCreateCommand(req));
		}
		//		if(UMLElementTypes.DurationConstraint_3034 == req.getElementType()) {
		//			return getGEFWrapper(new DurationConstraintAsLocalPrecondCreateCommand(req));
		//		}
		//		if(UMLElementTypes.DurationConstraint_3035 == req.getElementType()) {
		//			return getGEFWrapper(new DurationConstraintAsLocalPostcondCreateCommand(req));
		//		}
		//		if(UMLElementTypes.TimeConstraint_3036 == req.getElementType()) {
		//			return getGEFWrapper(new TimeConstraintAsLocalPrecondCreateCommand(req));
		//		}
		//		if(UMLElementTypes.TimeConstraint_3037 == req.getElementType()) {
		//			return getGEFWrapper(new TimeConstraintAsLocalPostcondCreateCommand(req));
		//		}
		//		if(UMLElementTypes.InteractionConstraint_3030 == req.getElementType()) {
		//			return getGEFWrapper(new InteractionConstraintAsLocalPrecondCreateCommand(req));
		//		}
		//		if(UMLElementTypes.InteractionConstraint_3031 == req.getElementType()) {
		//			return getGEFWrapper(new InteractionConstraintAsLocalPostcondCreateCommand(req));
		//		}
		//		if(UMLElementTypes.IntervalConstraint_3032 == req.getElementType()) {
		//			return getGEFWrapper(new IntervalConstraintAsLocalPrecondCreateCommand(req));
		//		}
		//		if(UMLElementTypes.IntervalConstraint_3033 == req.getElementType()) {
		//			return getGEFWrapper(new IntervalConstraintAsLocalPostcondCreateCommand(req));
		//		}
		//		if(UMLElementTypes.Constraint_3011 == req.getElementType()) {
		//			return getGEFWrapper(new ConstraintAsLocalPrecondCreateCommand(req));
		//		}
		//		if(UMLElementTypes.Constraint_3012 == req.getElementType()) {
		//			return getGEFWrapper(new ConstraintAsLocalPostcondCreateCommand(req));
		//		}
		if(UMLElementTypes.DecisionNode_3038 == req.getElementType()) {
			return getGEFWrapper(new DecisionNodeCreateCommand(req));
		}
		if(UMLElementTypes.MergeNode_3039 == req.getElementType()) {
			return getGEFWrapper(new MergeNodeCreateCommand(req));
		}
		if(UMLElementTypes.ForkNode_3040 == req.getElementType()) {
			return getGEFWrapper(new ForkNodeCreateCommand(req));
		}
		if(UMLElementTypes.JoinNode_3041 == req.getElementType()) {
			return getGEFWrapper(new JoinNodeCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
