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

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.papyrus.infra.gmfdiag.common.utils.DiagramUtils;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ActivityCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ActorCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.AnyReceiveEventCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ArtifactCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CallEventCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ChangeEventCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ClassCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CollaborationCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ComponentCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DataTypeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DeploymentSpecificationCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DeviceCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DurationConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DurationCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DurationIntervalCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.DurationObservationCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.EnumerationCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ExecutionEnvironmentCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ExpressionCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.FunctionBehaviorCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InformationItemCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InstanceValueCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InteractionCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InteractionConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.InterfaceCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.IntervalConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.IntervalCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.LiteralBooleanCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.LiteralIntegerCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.LiteralNullCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.LiteralStringCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.LiteralUnlimitedNaturalCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.NodeCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.OpaqueBehaviorCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.OpaqueExpressionCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.PrimitiveTypeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.ProtocolStateMachineCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.SignalCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.SignalEventCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.StateMachineCompositeCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.StringExpressionCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.TimeConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.TimeEventCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.TimeExpressionCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.TimeIntervalCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.TimeObservationCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.edit.commands.UseCaseCreateCommand;
import org.eclipse.papyrus.uml.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class CompositeStructureDiagramItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {
	/**
	 * @generated
	 */
	public CompositeStructureDiagramItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		IElementType requestElementType = req.getElementType();
		if (requestElementType == null) {
			return super.getCreateCommand(req);
		}
		if (UMLElementTypes.Activity_2060 == requestElementType) {
			return getGEFWrapper(new ActivityCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Interaction_2061 == requestElementType) {
			return getGEFWrapper(new InteractionCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.ProtocolStateMachine_2062 == requestElementType) {
			return getGEFWrapper(new ProtocolStateMachineCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.StateMachine_2063 == requestElementType) {
			return getGEFWrapper(new StateMachineCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.FunctionBehavior_2064 == requestElementType) {
			return getGEFWrapper(new FunctionBehaviorCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.OpaqueBehavior_2065 == requestElementType) {
			return getGEFWrapper(new OpaqueBehaviorCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Component_2069 == requestElementType) {
			return getGEFWrapper(new ComponentCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Device_2070 == requestElementType) {
			return getGEFWrapper(new DeviceCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.ExecutionEnvironment_2071 == requestElementType) {
			return getGEFWrapper(new ExecutionEnvironmentCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Node_2072 == requestElementType) {
			return getGEFWrapper(new NodeCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Class_2073 == requestElementType) {
			return getGEFWrapper(new ClassCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Collaboration_2075 == requestElementType) {
			return getGEFWrapper(new CollaborationCompositeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Interface_2076 == requestElementType) {
			return getGEFWrapper(new InterfaceCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.PrimitiveType_2066 == requestElementType) {
			return getGEFWrapper(new PrimitiveTypeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Enumeration_2067 == requestElementType) {
			return getGEFWrapper(new EnumerationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DataType_2068 == requestElementType) {
			return getGEFWrapper(new DataTypeCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Actor_2077 == requestElementType) {
			return getGEFWrapper(new ActorCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DeploymentSpecification_2078 == requestElementType) {
			return getGEFWrapper(new DeploymentSpecificationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Artifact_2079 == requestElementType) {
			return getGEFWrapper(new ArtifactCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.InformationItem_2080 == requestElementType) {
			return getGEFWrapper(new InformationItemCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Signal_2081 == requestElementType) {
			return getGEFWrapper(new SignalCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.UseCase_2082 == requestElementType) {
			return getGEFWrapper(new UseCaseCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.SignalEvent_2083 == requestElementType) {
			return getGEFWrapper(new SignalEventCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.CallEvent_2084 == requestElementType) {
			return getGEFWrapper(new CallEventCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.AnyReceiveEvent_2085 == requestElementType) {
			return getGEFWrapper(new AnyReceiveEventCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.ChangeEvent_2088 == requestElementType) {
			return getGEFWrapper(new ChangeEventCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.TimeEvent_2089 == requestElementType) {
			return getGEFWrapper(new TimeEventCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DurationObservation_2093 == requestElementType) {
			return getGEFWrapper(new DurationObservationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.TimeObservation_2094 == requestElementType) {
			return getGEFWrapper(new TimeObservationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.LiteralBoolean_2095 == requestElementType) {
			return getGEFWrapper(new LiteralBooleanCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.LiteralInteger_2096 == requestElementType) {
			return getGEFWrapper(new LiteralIntegerCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.LiteralNull_2097 == requestElementType) {
			return getGEFWrapper(new LiteralNullCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.LiteralString_2098 == requestElementType) {
			return getGEFWrapper(new LiteralStringCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.LiteralUnlimitedNatural_2099 == requestElementType) {
			return getGEFWrapper(new LiteralUnlimitedNaturalCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.StringExpression_2100 == requestElementType) {
			return getGEFWrapper(new StringExpressionCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.OpaqueExpression_2101 == requestElementType) {
			return getGEFWrapper(new OpaqueExpressionCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.TimeExpression_2102 == requestElementType) {
			return getGEFWrapper(new TimeExpressionCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Expression_2103 == requestElementType) {
			return getGEFWrapper(new ExpressionCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Duration_2104 == requestElementType) {
			return getGEFWrapper(new DurationCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.TimeInterval_2105 == requestElementType) {
			return getGEFWrapper(new TimeIntervalCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DurationInterval_2106 == requestElementType) {
			return getGEFWrapper(new DurationIntervalCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Interval_2107 == requestElementType) {
			return getGEFWrapper(new IntervalCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.InstanceValue_2108 == requestElementType) {
			return getGEFWrapper(new InstanceValueCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Comment_2109 == requestElementType) {
			return getGEFWrapper(new CommentCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.DurationConstraint_2110 == requestElementType) {
			return getGEFWrapper(new DurationConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.TimeConstraint_2111 == requestElementType) {
			return getGEFWrapper(new TimeConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.IntervalConstraint_2112 == requestElementType) {
			return getGEFWrapper(new IntervalConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.InteractionConstraint_2113 == requestElementType) {
			return getGEFWrapper(new InteractionConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		if (UMLElementTypes.Constraint_2114 == requestElementType) {
			return getGEFWrapper(new ConstraintCreateCommand(req, DiagramUtils.getDiagramFrom(getHost())));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {
		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
		}
	}
}
