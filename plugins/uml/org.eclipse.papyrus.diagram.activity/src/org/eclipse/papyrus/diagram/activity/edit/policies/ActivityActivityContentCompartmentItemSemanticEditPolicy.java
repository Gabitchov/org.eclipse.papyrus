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
import org.eclipse.papyrus.diagram.activity.edit.commands.FlowFinalNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.InitialNodeCreateCommand;
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
	 * @generated NOT moved local conditions creation commands to {@link CreateActionLocalConditionEditPolicy} moved transformation and selection
	 *            creation commands to {@link CreateObjectFlowBehaviorEditPolicy}
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
		//		if(UMLElementTypes.Constraint_3011 == req.getElementType()) {
		//			return getGEFWrapper(new ConstraintAsLocalPrecondCreateCommand(req));
		//		}
		//		if(UMLElementTypes.Constraint_3012 == req.getElementType()) {
		//			return getGEFWrapper(new ConstraintAsLocalPostcondCreateCommand(req));
		//		}
		//		if(UMLElementTypes.Activity_3028 == req.getElementType()) {
		//			return getGEFWrapper(new ActivityAsSelectionCreateCommand(req));
		//		}
		//		if(UMLElementTypes.Activity_3029 == req.getElementType()) {
		//			return getGEFWrapper(new ActivityAsTransformationCreateCommand(req));
		//		}
		return super.getCreateCommand(req);
	}

}
