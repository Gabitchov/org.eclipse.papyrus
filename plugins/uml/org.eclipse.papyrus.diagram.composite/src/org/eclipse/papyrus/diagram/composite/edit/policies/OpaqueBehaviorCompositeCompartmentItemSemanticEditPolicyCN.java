/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
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
package org.eclipse.papyrus.diagram.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.composite.edit.commands.ActivityCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.ActorCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.ArtifactCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.ClassCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.CollaborationCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.CollaborationUseCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.ComponentCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.DataTypeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.DeploymentSpecificationCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.DeviceCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.EnumerationCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.ExecutionEnvironmentCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.FunctionBehaviorCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.InformationItemCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.InteractionCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.InterfaceCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.NodeCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.OpaqueBehaviorCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.PrimitiveTypeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.PropertyPartCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.ProtocolStateMachineCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.SignalCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.StateMachineCompositeCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.edit.commands.UseCaseCreateCommandCN;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class OpaqueBehaviorCompositeCompartmentItemSemanticEditPolicyCN extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public OpaqueBehaviorCompositeCompartmentItemSemanticEditPolicyCN() {
		super(UMLElementTypes.OpaqueBehavior_3077);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Property_3070 == req.getElementType()) {
			return getGEFWrapper(new PropertyPartCreateCommandCN(req));
		}
		if (UMLElementTypes.CollaborationUse_3071 == req.getElementType()) {
			return getGEFWrapper(new CollaborationUseCreateCommandCN(req));
		}
		if (UMLElementTypes.Activity_3072 == req.getElementType()) {
			return getGEFWrapper(new ActivityCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.Interaction_3073 == req.getElementType()) {
			return getGEFWrapper(new InteractionCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.ProtocolStateMachine_3074 == req.getElementType()) {
			return getGEFWrapper(new ProtocolStateMachineCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.StateMachine_3075 == req.getElementType()) {
			return getGEFWrapper(new StateMachineCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.FunctionBehavior_3076 == req.getElementType()) {
			return getGEFWrapper(new FunctionBehaviorCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.OpaqueBehavior_3077 == req.getElementType()) {
			return getGEFWrapper(new OpaqueBehaviorCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.Component_3081 == req.getElementType()) {
			return getGEFWrapper(new ComponentCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.Device_3082 == req.getElementType()) {
			return getGEFWrapper(new DeviceCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.ExecutionEnvironment_3083 == req.getElementType()) {
			return getGEFWrapper(new ExecutionEnvironmentCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.Node_3084 == req.getElementType()) {
			return getGEFWrapper(new NodeCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.Class_3085 == req.getElementType()) {
			return getGEFWrapper(new ClassCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.Collaboration_3086 == req.getElementType()) {
			return getGEFWrapper(new CollaborationCompositeCreateCommandCN(req));
		}
		if (UMLElementTypes.Interface_3087 == req.getElementType()) {
			return getGEFWrapper(new InterfaceCreateCommandCN(req));
		}
		if (UMLElementTypes.PrimitiveType_3078 == req.getElementType()) {
			return getGEFWrapper(new PrimitiveTypeCreateCommandCN(req));
		}
		if (UMLElementTypes.Enumeration_3079 == req.getElementType()) {
			return getGEFWrapper(new EnumerationCreateCommandCN(req));
		}
		if (UMLElementTypes.DataType_3080 == req.getElementType()) {
			return getGEFWrapper(new DataTypeCreateCommandCN(req));
		}
		if (UMLElementTypes.Actor_3091 == req.getElementType()) {
			return getGEFWrapper(new ActorCreateCommandCN(req));
		}
		if (UMLElementTypes.DeploymentSpecification_3092 == req.getElementType()) {
			return getGEFWrapper(new DeploymentSpecificationCreateCommandCN(req));
		}
		if (UMLElementTypes.Artifact_3093 == req.getElementType()) {
			return getGEFWrapper(new ArtifactCreateCommandCN(req));
		}
		if (UMLElementTypes.InformationItem_3094 == req.getElementType()) {
			return getGEFWrapper(new InformationItemCreateCommandCN(req));
		}
		if (UMLElementTypes.Signal_3095 == req.getElementType()) {
			return getGEFWrapper(new SignalCreateCommandCN(req));
		}
		if (UMLElementTypes.UseCase_3096 == req.getElementType()) {
			return getGEFWrapper(new UseCaseCreateCommandCN(req));
		}
		if (UMLElementTypes.Comment_3097 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommandCN(req));
		}
		return super.getCreateCommand(req);
	}

}
