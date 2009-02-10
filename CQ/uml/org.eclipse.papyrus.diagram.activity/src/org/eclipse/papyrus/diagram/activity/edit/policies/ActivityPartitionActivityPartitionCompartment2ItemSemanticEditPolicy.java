/*
 * Copyright (c) 2007 Borland Software Corporation and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Sergey Gribovsky (Borland) - initial API and implementation
 *  Francisco Javier Cano Mu�oz (Prodevelop)
 *  Marc Gil Sendra (Prodevelop)
 */
package org.eclipse.papyrus.diagram.activity.edit.policies;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.activity.edit.commands.AcceptEventAction2CreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.AcceptEventActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityFinalNodeCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.ActivityPartition2CreateCommand;
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
import org.eclipse.papyrus.diagram.activity.edit.commands.OpaqueAction2CreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.OpaqueActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.PinCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.SendObjectActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.edit.commands.SendSignalActionCreateCommand;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.common.commands.CreateElementAndInitializeFeatureCommand;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.uml2.uml.UMLPackage;


/**
 * @generated
 */
public class ActivityPartitionActivityPartitionCompartment2ItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * Modified to return a <Command> that created the element and initialies the InPartition feature.
	 * 
	 * @generated NOT
	 */
	@Override
	protected Command getCreateCommand(CreateElementRequest req) {
		Diagram diagram = DiagramEditPartsUtil.findDiagramFromEditPart(getHost());
		if (diagram != null) {
			req.getParameters().put(MultiDiagramUtil.BelongToDiagramSource, diagram);
		}
		EReference feature = UMLPackage.eINSTANCE.getActivityNode_InPartition();
		EObject value = req.getContainer();

		if (UMLElementTypes.ActivityPartition_2030 == req.getElementType() || UMLElementTypes.ActivityPartition_2031 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivityPartition_Subpartition());
			}
			return getGEFWrapper(new ActivityPartition2CreateCommand(req));
		}
		if (UMLElementTypes.OpaqueAction_2014 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new OpaqueAction2CreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new OpaqueAction2CreateCommand(req));
		}
		if (UMLElementTypes.OpaqueAction_2032 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new OpaqueActionCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new OpaqueActionCreateCommand(req));
		}
		if (UMLElementTypes.SendObjectAction_2001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new SendObjectActionCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new SendObjectActionCreateCommand(req));
		}
		if (UMLElementTypes.SendSignalAction_2005 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new SendSignalActionCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new SendSignalActionCreateCommand(req));
		}
		if (UMLElementTypes.AcceptEventAction_2007 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new AcceptEventActionCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new AcceptEventActionCreateCommand(req));
		}
		if (UMLElementTypes.AcceptEventAction_2033 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new AcceptEventAction2CreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new AcceptEventAction2CreateCommand(req));
		}
		if (UMLElementTypes.ActivityFinalNode_2009 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new ActivityFinalNodeCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new ActivityFinalNodeCreateCommand(req));
		}
		if (UMLElementTypes.DecisionNode_2010 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new DecisionNodeCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new DecisionNodeCreateCommand(req));
		}
		if (UMLElementTypes.MergeNode_2011 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new MergeNodeCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new MergeNodeCreateCommand(req));
		}
		if (UMLElementTypes.InitialNode_2012 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new InitialNodeCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new InitialNodeCreateCommand(req));
		}
		if (UMLElementTypes.DataStoreNode_2013 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new DataStoreNodeCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new DataStoreNodeCreateCommand(req));
		}
		if (UMLElementTypes.FlowFinalNode_2018 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new FlowFinalNodeCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new FlowFinalNodeCreateCommand(req));
		}
		if (UMLElementTypes.ForkNode_2019 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new ForkNodeCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new ForkNodeCreateCommand(req));
		}
		if (UMLElementTypes.JoinNode_2020 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new JoinNodeCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new JoinNodeCreateCommand(req));
		}
		if (UMLElementTypes.Pin_2021 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new PinCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new PinCreateCommand(req));
		}
		if (UMLElementTypes.CreateObjectAction_2022 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new CreateObjectActionCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new CreateObjectActionCreateCommand(req));
		}
		if (UMLElementTypes.CallBehaviorAction_2024 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new CallBehaviorActionCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new CallBehaviorActionCreateCommand(req));
		}
		if (UMLElementTypes.CallOperationAction_2027 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UMLPackage.eINSTANCE.getActivity_Node());
			}
			CreateElementCommand createCommand = new CallOperationActionCreateCommand(req);
			return new CreateElementAndInitializeFeatureCommand(createCommand, feature, value);
			// return getGEFWrapper(new CallOperationActionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getHost().getParent().getCommand(new EditCommandRequestWrapper(req));
	}
}
