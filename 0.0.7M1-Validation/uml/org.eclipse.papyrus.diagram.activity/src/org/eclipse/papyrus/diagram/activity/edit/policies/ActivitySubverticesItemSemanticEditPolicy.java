package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.activity.edit.commands.AcceptEventActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityFinalNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityPartitionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CallBehaviorActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CallOperationActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.CreateObjectActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.DataStoreNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.DecisionNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.FlowFinalNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ForkNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.InitialNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.JoinNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.MergeNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.OpaqueActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.PinCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.SendObjectActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.SendSignalActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * @generated
 */
public class ActivitySubverticesItemSemanticEditPolicy extends
		UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {

		Diagram diagram = DiagramEditPartsUtil
				.findDiagramFromEditPart(getHost());
		if (diagram != null) {
			req.getParameters().put(MultiDiagramUtil.BelongToDiagramSource,
					diagram);
		}
		if (UMLElementTypes.SendObjectAction_2001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new SendObjectActionCreateCommand(req));
		}
		if (UMLElementTypes.SendSignalAction_2005 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new SendSignalActionCreateCommand(req));
		}
		if (UMLElementTypes.AcceptEventAction_2007 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new AcceptEventActionCreateCommand(req));
		}
		if (UMLElementTypes.ActivityFinalNode_2009 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new ActivityFinalNodeCreateCommand(req));
		}
		if (UMLElementTypes.DecisionNode_2010 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new DecisionNodeCreateCommand(req));
		}
		if (UMLElementTypes.MergeNode_2011 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new MergeNodeCreateCommand(req));
		}
		if (UMLElementTypes.InitialNode_2012 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new InitialNodeCreateCommand(req));
		}
		if (UMLElementTypes.DataStoreNode_2013 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new DataStoreNodeCreateCommand(req));
		}
		if (UMLElementTypes.OpaqueAction_2014 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new OpaqueActionCreateCommand(req));
		}
		if (UMLElementTypes.FlowFinalNode_2018 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new FlowFinalNodeCreateCommand(req));
		}
		if (UMLElementTypes.ForkNode_2019 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new ForkNodeCreateCommand(req));
		}
		if (UMLElementTypes.JoinNode_2020 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new JoinNodeCreateCommand(req));
		}
		if (UMLElementTypes.Pin_2021 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new PinCreateCommand(req));
		}
		if (UMLElementTypes.CreateObjectAction_2022 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new CreateObjectActionCreateCommand(req));
		}
		if (UMLElementTypes.CallBehaviorAction_2024 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new CallBehaviorActionCreateCommand(req));
		}
		if (UMLElementTypes.CallOperationAction_2027 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Node());
			}
			return getGEFWrapper(new CallOperationActionCreateCommand(req));
		}
		if (UMLElementTypes.ActivityPartition_2030 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE
						.getActivity_Group());
			}
			return getGEFWrapper(new ActivityPartitionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getHost().getParent().getCommand(
				new EditCommandRequestWrapper(req));
	}
}
