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

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.diagram.composite.edit.commands.ActivityCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.ActorCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.AnyReceiveEventCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.ArtifactCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.CallEventCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.ChangeEventCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.ClassClassifierCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.ClassCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.CollaborationCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.CommentCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.ComponentCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.ConstraintCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.CreationEventCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.DataTypeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.DeploymentSpecificationCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.DestructionEventCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.DeviceCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.DurationConstraintCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.DurationCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.DurationIntervalCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.DurationObservationCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.EnumerationCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.ExecutionEnvironmentCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.ExecutionEventCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.ExpressionCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.FunctionBehaviorCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.InformationItemCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.InstanceValueCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.InteractionCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.InteractionConstraintCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.InterfaceCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.IntervalConstraintCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.IntervalCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.LiteralBooleanCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.LiteralIntegerCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.LiteralNullCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.LiteralStringCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.LiteralUnlimitedNaturalCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.NodeCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.OpaqueBehaviorCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.OpaqueExpressionCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.PrimitiveTypeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.ProtocolStateMachineCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.SendOperationEventCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.SendSignalEventCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.SignalCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.SignalEventCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.StateMachineCompositeCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.StringExpressionCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.TimeConstraintCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.TimeEventCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.TimeExpressionCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.TimeIntervalCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.TimeObservationCreateCommand;
import org.eclipse.papyrus.diagram.composite.edit.commands.UseCaseCreateCommand;
import org.eclipse.papyrus.diagram.composite.providers.UMLElementTypes;

/**
 * @generated
 */
public class PackageItemSemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	public PackageItemSemanticEditPolicy() {
		super(UMLElementTypes.Package_1000);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (UMLElementTypes.Activity_2060 == req.getElementType()) {
			return getGEFWrapper(new ActivityCompositeCreateCommand(req));
		}
		if (UMLElementTypes.Interaction_2061 == req.getElementType()) {
			return getGEFWrapper(new InteractionCompositeCreateCommand(req));
		}
		if (UMLElementTypes.ProtocolStateMachine_2062 == req.getElementType()) {
			return getGEFWrapper(new ProtocolStateMachineCompositeCreateCommand(req));
		}
		if (UMLElementTypes.StateMachine_2063 == req.getElementType()) {
			return getGEFWrapper(new StateMachineCompositeCreateCommand(req));
		}
		if (UMLElementTypes.FunctionBehavior_2064 == req.getElementType()) {
			return getGEFWrapper(new FunctionBehaviorCompositeCreateCommand(req));
		}
		if (UMLElementTypes.OpaqueBehavior_2065 == req.getElementType()) {
			return getGEFWrapper(new OpaqueBehaviorCompositeCreateCommand(req));
		}
		if (UMLElementTypes.Component_2069 == req.getElementType()) {
			return getGEFWrapper(new ComponentCompositeCreateCommand(req));
		}
		if (UMLElementTypes.Device_2070 == req.getElementType()) {
			return getGEFWrapper(new DeviceCompositeCreateCommand(req));
		}
		if (UMLElementTypes.ExecutionEnvironment_2071 == req.getElementType()) {
			return getGEFWrapper(new ExecutionEnvironmentCompositeCreateCommand(req));
		}
		if (UMLElementTypes.Node_2072 == req.getElementType()) {
			return getGEFWrapper(new NodeCompositeCreateCommand(req));
		}
		if (UMLElementTypes.Class_2073 == req.getElementType()) {
			return getGEFWrapper(new ClassCompositeCreateCommand(req));
		}
		if (UMLElementTypes.Class_2074 == req.getElementType()) {
			return getGEFWrapper(new ClassClassifierCreateCommand(req));
		}
		if (UMLElementTypes.Collaboration_2075 == req.getElementType()) {
			return getGEFWrapper(new CollaborationCompositeCreateCommand(req));
		}
		if (UMLElementTypes.Interface_2076 == req.getElementType()) {
			return getGEFWrapper(new InterfaceCreateCommand(req));
		}
		if (UMLElementTypes.PrimitiveType_2066 == req.getElementType()) {
			return getGEFWrapper(new PrimitiveTypeCreateCommand(req));
		}
		if (UMLElementTypes.Enumeration_2067 == req.getElementType()) {
			return getGEFWrapper(new EnumerationCreateCommand(req));
		}
		if (UMLElementTypes.DataType_2068 == req.getElementType()) {
			return getGEFWrapper(new DataTypeCreateCommand(req));
		}
		if (UMLElementTypes.Actor_2077 == req.getElementType()) {
			return getGEFWrapper(new ActorCreateCommand(req));
		}
		if (UMLElementTypes.DeploymentSpecification_2078 == req.getElementType()) {
			return getGEFWrapper(new DeploymentSpecificationCreateCommand(req));
		}
		if (UMLElementTypes.Artifact_2079 == req.getElementType()) {
			return getGEFWrapper(new ArtifactCreateCommand(req));
		}
		if (UMLElementTypes.InformationItem_2080 == req.getElementType()) {
			return getGEFWrapper(new InformationItemCreateCommand(req));
		}
		if (UMLElementTypes.Signal_2081 == req.getElementType()) {
			return getGEFWrapper(new SignalCreateCommand(req));
		}
		if (UMLElementTypes.UseCase_2082 == req.getElementType()) {
			return getGEFWrapper(new UseCaseCreateCommand(req));
		}
		if (UMLElementTypes.SignalEvent_2083 == req.getElementType()) {
			return getGEFWrapper(new SignalEventCreateCommand(req));
		}
		if (UMLElementTypes.CallEvent_2084 == req.getElementType()) {
			return getGEFWrapper(new CallEventCreateCommand(req));
		}
		if (UMLElementTypes.AnyReceiveEvent_2085 == req.getElementType()) {
			return getGEFWrapper(new AnyReceiveEventCreateCommand(req));
		}
		if (UMLElementTypes.SendSignalEvent_2086 == req.getElementType()) {
			return getGEFWrapper(new SendSignalEventCreateCommand(req));
		}
		if (UMLElementTypes.SendOperationEvent_2087 == req.getElementType()) {
			return getGEFWrapper(new SendOperationEventCreateCommand(req));
		}
		if (UMLElementTypes.ChangeEvent_2088 == req.getElementType()) {
			return getGEFWrapper(new ChangeEventCreateCommand(req));
		}
		if (UMLElementTypes.TimeEvent_2089 == req.getElementType()) {
			return getGEFWrapper(new TimeEventCreateCommand(req));
		}
		if (UMLElementTypes.CreationEvent_2090 == req.getElementType()) {
			return getGEFWrapper(new CreationEventCreateCommand(req));
		}
		if (UMLElementTypes.DestructionEvent_2091 == req.getElementType()) {
			return getGEFWrapper(new DestructionEventCreateCommand(req));
		}
		if (UMLElementTypes.ExecutionEvent_2092 == req.getElementType()) {
			return getGEFWrapper(new ExecutionEventCreateCommand(req));
		}
		if (UMLElementTypes.DurationObservation_2093 == req.getElementType()) {
			return getGEFWrapper(new DurationObservationCreateCommand(req));
		}
		if (UMLElementTypes.TimeObservation_2094 == req.getElementType()) {
			return getGEFWrapper(new TimeObservationCreateCommand(req));
		}
		if (UMLElementTypes.LiteralBoolean_2095 == req.getElementType()) {
			return getGEFWrapper(new LiteralBooleanCreateCommand(req));
		}
		if (UMLElementTypes.LiteralInteger_2096 == req.getElementType()) {
			return getGEFWrapper(new LiteralIntegerCreateCommand(req));
		}
		if (UMLElementTypes.LiteralNull_2097 == req.getElementType()) {
			return getGEFWrapper(new LiteralNullCreateCommand(req));
		}
		if (UMLElementTypes.LiteralString_2098 == req.getElementType()) {
			return getGEFWrapper(new LiteralStringCreateCommand(req));
		}
		if (UMLElementTypes.LiteralUnlimitedNatural_2099 == req.getElementType()) {
			return getGEFWrapper(new LiteralUnlimitedNaturalCreateCommand(req));
		}
		if (UMLElementTypes.StringExpression_2100 == req.getElementType()) {
			return getGEFWrapper(new StringExpressionCreateCommand(req));
		}
		if (UMLElementTypes.OpaqueExpression_2101 == req.getElementType()) {
			return getGEFWrapper(new OpaqueExpressionCreateCommand(req));
		}
		if (UMLElementTypes.TimeExpression_2102 == req.getElementType()) {
			return getGEFWrapper(new TimeExpressionCreateCommand(req));
		}
		if (UMLElementTypes.Expression_2103 == req.getElementType()) {
			return getGEFWrapper(new ExpressionCreateCommand(req));
		}
		if (UMLElementTypes.Duration_2104 == req.getElementType()) {
			return getGEFWrapper(new DurationCreateCommand(req));
		}
		if (UMLElementTypes.TimeInterval_2105 == req.getElementType()) {
			return getGEFWrapper(new TimeIntervalCreateCommand(req));
		}
		if (UMLElementTypes.DurationInterval_2106 == req.getElementType()) {
			return getGEFWrapper(new DurationIntervalCreateCommand(req));
		}
		if (UMLElementTypes.Interval_2107 == req.getElementType()) {
			return getGEFWrapper(new IntervalCreateCommand(req));
		}
		if (UMLElementTypes.InstanceValue_2108 == req.getElementType()) {
			return getGEFWrapper(new InstanceValueCreateCommand(req));
		}
		if (UMLElementTypes.Comment_2109 == req.getElementType()) {
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		if (UMLElementTypes.DurationConstraint_2110 == req.getElementType()) {
			return getGEFWrapper(new DurationConstraintCreateCommand(req));
		}
		if (UMLElementTypes.TimeConstraint_2111 == req.getElementType()) {
			return getGEFWrapper(new TimeConstraintCreateCommand(req));
		}
		if (UMLElementTypes.IntervalConstraint_2112 == req.getElementType()) {
			return getGEFWrapper(new IntervalConstraintCreateCommand(req));
		}
		if (UMLElementTypes.InteractionConstraint_2113 == req.getElementType()) {
			return getGEFWrapper(new InteractionConstraintCreateCommand(req));
		}
		if (UMLElementTypes.Constraint_2114 == req.getElementType()) {
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();
		Diagram currentDiagram = null;
		if (getHost() instanceof IGraphicalEditPart) {
			currentDiagram = ((IGraphicalEditPart) getHost()).getNotationView().getDiagram();
		}
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req, currentDiagram));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateEObjectsCommand {

		private Diagram diagram;

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req,
				Diagram currentDiagram) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap());
			this.diagram = currentDiagram;
		}
	}

}
