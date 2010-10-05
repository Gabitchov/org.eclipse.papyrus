package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.activity.edit.commands.AcceptEventActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityCreateCommandCN;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityFinalNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityPartitionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CallBehaviorActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CallOperationActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ConditionalNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.DecisionNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ExpansionRegionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.FlowFinalNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ForkNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.InitialNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.InterruptibleActivityRegionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.JoinNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.LoopNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.MergeNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.OpaqueActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ReadSelfActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.SendObjectActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.SendSignalActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.SequenceNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ShapeNamedElementCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ValueSpecificationActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;

/**
 * @generated
 */
public class ActivityCNContentCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public ActivityCNContentCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Activity_3083);
	}

	/**
	 * @generated
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
		if(UMLElementTypes.SendObjectAction_3042 == req.getElementType()) {
			return getGEFWrapper(new SendObjectActionCreateCommand(req));
		}
		if(UMLElementTypes.SendSignalAction_3052 == req.getElementType()) {
			return getGEFWrapper(new SendSignalActionCreateCommand(req));
		}
		if(UMLElementTypes.AcceptEventAction_3063 == req.getElementType()) {
			return getGEFWrapper(new AcceptEventActionCreateCommand(req));
		}
		if(UMLElementTypes.ValueSpecificationAction_3076 == req.getElementType()) {
			return getGEFWrapper(new ValueSpecificationActionCreateCommand(req));
		}
		if(UMLElementTypes.ConditionalNode_3069 == req.getElementType()) {
			return getGEFWrapper(new ConditionalNodeCreateCommand(req));
		}
		if(UMLElementTypes.ExpansionRegion_3070 == req.getElementType()) {
			return getGEFWrapper(new ExpansionRegionCreateCommand(req));
		}
		if(UMLElementTypes.LoopNode_3071 == req.getElementType()) {
			return getGEFWrapper(new LoopNodeCreateCommand(req));
		}
		if(UMLElementTypes.SequenceNode_3073 == req.getElementType()) {
			return getGEFWrapper(new SequenceNodeCreateCommand(req));
		}
		if(UMLElementTypes.ActivityPartition_3067 == req.getElementType()) {
			return getGEFWrapper(new ActivityPartitionCreateCommand(req));
		}
		if(UMLElementTypes.InterruptibleActivityRegion_3068 == req.getElementType()) {
			return getGEFWrapper(new InterruptibleActivityRegionCreateCommand(req));
		}
		if(UMLElementTypes.NamedElement_3079 == req.getElementType()) {
			return getGEFWrapper(new ShapeNamedElementCreateCommand(req));
		}
		if(UMLElementTypes.ReadSelfAction_3081 == req.getElementType()) {
			return getGEFWrapper(new ReadSelfActionCreateCommand(req));
		}
		if(UMLElementTypes.Activity_3083 == req.getElementType()) {
			return getGEFWrapper(new ActivityCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}

}
