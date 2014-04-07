/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.composite.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ActivityCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ActorCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ArtifactCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ClassCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CollaborationCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CollaborationUseCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CommentCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ComponentCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DataTypeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DeploymentSpecificationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DeviceCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DurationConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.EnumerationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ExecutionEnvironmentCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.FunctionBehaviorCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InformationItemCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InteractionCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InteractionConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InterfaceCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.IntervalConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.NodeCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.OpaqueBehaviorCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ParameterCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.PrimitiveTypeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.PropertyPartCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ProtocolStateMachineCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.SignalCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.StateMachineCompositeCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.TimeConstraintCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.UseCaseCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class InteractionCompositeCompartmentItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {
	/**
	 * @generated
	 */
	public InteractionCompositeCompartmentItemSemanticEditPolicy() {
		super(UMLElementTypes.Interaction_2061);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if (UMLElementTypes.Parameter_3088 == requestElementType) {
			return getGEFWrapper(new ParameterCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Property_3070 == requestElementType) {
			return getGEFWrapper(new PropertyPartCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.CollaborationUse_3071 == requestElementType) {
			return getGEFWrapper(new CollaborationUseCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Activity_3072 == requestElementType) {
			return getGEFWrapper(new ActivityCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Interaction_3073 == requestElementType) {
			return getGEFWrapper(new InteractionCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.ProtocolStateMachine_3074 == requestElementType) {
			return getGEFWrapper(new ProtocolStateMachineCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.StateMachine_3075 == requestElementType) {
			return getGEFWrapper(new StateMachineCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.FunctionBehavior_3076 == requestElementType) {
			return getGEFWrapper(new FunctionBehaviorCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.OpaqueBehavior_3077 == requestElementType) {
			return getGEFWrapper(new OpaqueBehaviorCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Component_3081 == requestElementType) {
			return getGEFWrapper(new ComponentCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Device_3082 == requestElementType) {
			return getGEFWrapper(new DeviceCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.ExecutionEnvironment_3083 == requestElementType) {
			return getGEFWrapper(new ExecutionEnvironmentCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Node_3084 == requestElementType) {
			return getGEFWrapper(new NodeCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Class_3085 == requestElementType) {
			return getGEFWrapper(new ClassCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Collaboration_3086 == requestElementType) {
			return getGEFWrapper(new CollaborationCompositeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Interface_3087 == requestElementType) {
			return getGEFWrapper(new InterfaceCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.PrimitiveType_3078 == requestElementType) {
			return getGEFWrapper(new PrimitiveTypeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Enumeration_3079 == requestElementType) {
			return getGEFWrapper(new EnumerationCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DataType_3080 == requestElementType) {
			return getGEFWrapper(new DataTypeCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Actor_3091 == requestElementType) {
			return getGEFWrapper(new ActorCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DeploymentSpecification_3092 == requestElementType) {
			return getGEFWrapper(new DeploymentSpecificationCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Artifact_3093 == requestElementType) {
			return getGEFWrapper(new ArtifactCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.InformationItem_3094 == requestElementType) {
			return getGEFWrapper(new InformationItemCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Signal_3095 == requestElementType) {
			return getGEFWrapper(new SignalCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.UseCase_3096 == requestElementType) {
			return getGEFWrapper(new UseCaseCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Comment_3097 == requestElementType) {
			return getGEFWrapper(new CommentCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DurationConstraint_3116 == requestElementType) {
			return getGEFWrapper(new DurationConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.TimeConstraint_3117 == requestElementType) {
			return getGEFWrapper(new TimeConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.IntervalConstraint_3118 == requestElementType) {
			return getGEFWrapper(new IntervalConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.InteractionConstraint_3119 == requestElementType) {
			return getGEFWrapper(new InteractionConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Constraint_3120 == requestElementType) {
			return getGEFWrapper(new ConstraintCreateCommandCN(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}
}
