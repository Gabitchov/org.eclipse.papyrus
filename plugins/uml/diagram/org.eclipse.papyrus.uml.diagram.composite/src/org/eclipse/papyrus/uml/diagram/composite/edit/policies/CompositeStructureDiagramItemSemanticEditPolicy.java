/*****************************************************************************
 * Copyright (c) 2009-2011 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.composite.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.infra.extendedtypes.types.IExtendedHintedElementType;
import org.eclipse.papyrus.infra.extendedtypes.util.ElementTypeUtils;
import org.eclipse.papyrus.uml.diagram.common.commands.DuplicateNamedElementCommand;
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
		if(requestElementType == null) {
			return super.getCreateCommand(req);
		}
		IElementType baseElementType = requestElementType;
		boolean isExtendedType = false;
		if(requestElementType instanceof IExtendedHintedElementType) {
			baseElementType = ElementTypeUtils.getClosestDiagramType(requestElementType);
			if(baseElementType != null) {
				isExtendedType = true;
			} else {
				// no reference element type ID. using the closest super element type to give more opportunities, but can lead to bugs.
				baseElementType = ElementTypeUtils.findClosestNonExtendedElementType((IExtendedHintedElementType)requestElementType);
				isExtendedType = true;
			}
		}
		if(UMLElementTypes.Activity_2060 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ActivityCompositeCreateCommand(req));
		}
		if(UMLElementTypes.Interaction_2061 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new InteractionCompositeCreateCommand(req));
		}
		if(UMLElementTypes.ProtocolStateMachine_2062 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ProtocolStateMachineCompositeCreateCommand(req));
		}
		if(UMLElementTypes.StateMachine_2063 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new StateMachineCompositeCreateCommand(req));
		}
		if(UMLElementTypes.FunctionBehavior_2064 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new FunctionBehaviorCompositeCreateCommand(req));
		}
		if(UMLElementTypes.OpaqueBehavior_2065 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new OpaqueBehaviorCompositeCreateCommand(req));
		}
		if(UMLElementTypes.Component_2069 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ComponentCompositeCreateCommand(req));
		}
		if(UMLElementTypes.Device_2070 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DeviceCompositeCreateCommand(req));
		}
		if(UMLElementTypes.ExecutionEnvironment_2071 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ExecutionEnvironmentCompositeCreateCommand(req));
		}
		if(UMLElementTypes.Node_2072 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new NodeCompositeCreateCommand(req));
		}
		if(UMLElementTypes.Class_2073 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ClassCompositeCreateCommand(req));
		}
		if(UMLElementTypes.Collaboration_2075 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CollaborationCompositeCreateCommand(req));
		}
		if(UMLElementTypes.Interface_2076 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new InterfaceCreateCommand(req));
		}
		if(UMLElementTypes.PrimitiveType_2066 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new PrimitiveTypeCreateCommand(req));
		}
		if(UMLElementTypes.Enumeration_2067 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new EnumerationCreateCommand(req));
		}
		if(UMLElementTypes.DataType_2068 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DataTypeCreateCommand(req));
		}
		if(UMLElementTypes.Actor_2077 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ActorCreateCommand(req));
		}
		if(UMLElementTypes.DeploymentSpecification_2078 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DeploymentSpecificationCreateCommand(req));
		}
		if(UMLElementTypes.Artifact_2079 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ArtifactCreateCommand(req));
		}
		if(UMLElementTypes.InformationItem_2080 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new InformationItemCreateCommand(req));
		}
		if(UMLElementTypes.Signal_2081 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new SignalCreateCommand(req));
		}
		if(UMLElementTypes.UseCase_2082 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new UseCaseCreateCommand(req));
		}
		if(UMLElementTypes.SignalEvent_2083 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new SignalEventCreateCommand(req));
		}
		if(UMLElementTypes.CallEvent_2084 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CallEventCreateCommand(req));
		}
		if(UMLElementTypes.AnyReceiveEvent_2085 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new AnyReceiveEventCreateCommand(req));
		}
		if(UMLElementTypes.ChangeEvent_2088 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ChangeEventCreateCommand(req));
		}
		if(UMLElementTypes.TimeEvent_2089 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new TimeEventCreateCommand(req));
		}
		if(UMLElementTypes.DurationObservation_2093 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DurationObservationCreateCommand(req));
		}
		if(UMLElementTypes.TimeObservation_2094 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new TimeObservationCreateCommand(req));
		}
		if(UMLElementTypes.LiteralBoolean_2095 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new LiteralBooleanCreateCommand(req));
		}
		if(UMLElementTypes.LiteralInteger_2096 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new LiteralIntegerCreateCommand(req));
		}
		if(UMLElementTypes.LiteralNull_2097 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new LiteralNullCreateCommand(req));
		}
		if(UMLElementTypes.LiteralString_2098 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new LiteralStringCreateCommand(req));
		}
		if(UMLElementTypes.LiteralUnlimitedNatural_2099 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new LiteralUnlimitedNaturalCreateCommand(req));
		}
		if(UMLElementTypes.StringExpression_2100 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new StringExpressionCreateCommand(req));
		}
		if(UMLElementTypes.OpaqueExpression_2101 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new OpaqueExpressionCreateCommand(req));
		}
		if(UMLElementTypes.TimeExpression_2102 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new TimeExpressionCreateCommand(req));
		}
		if(UMLElementTypes.Expression_2103 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ExpressionCreateCommand(req));
		}
		if(UMLElementTypes.Duration_2104 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DurationCreateCommand(req));
		}
		if(UMLElementTypes.TimeInterval_2105 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new TimeIntervalCreateCommand(req));
		}
		if(UMLElementTypes.DurationInterval_2106 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DurationIntervalCreateCommand(req));
		}
		if(UMLElementTypes.Interval_2107 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new IntervalCreateCommand(req));
		}
		if(UMLElementTypes.InstanceValue_2108 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new InstanceValueCreateCommand(req));
		}
		if(UMLElementTypes.Comment_2109 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new CommentCreateCommand(req));
		}
		if(UMLElementTypes.DurationConstraint_2110 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new DurationConstraintCreateCommand(req));
		}
		if(UMLElementTypes.TimeConstraint_2111 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new TimeConstraintCreateCommand(req));
		}
		if(UMLElementTypes.IntervalConstraint_2112 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new IntervalConstraintCreateCommand(req));
		}
		if(UMLElementTypes.InteractionConstraint_2113 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new InteractionConstraintCreateCommand(req));
		}
		if(UMLElementTypes.Constraint_2114 == baseElementType) {
			if(isExtendedType) {
				return getExtendedTypeCreationCommand(req, (IExtendedHintedElementType)requestElementType);
			}
			return getGEFWrapper(new ConstraintCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();
		Diagram currentDiagram = null;
		if(getHost() instanceof IGraphicalEditPart) {
			currentDiagram = ((IGraphicalEditPart)getHost()).getNotationView().getDiagram();
		}
		return getGEFWrapper(new DuplicateAnythingCommand(editingDomain, req, currentDiagram));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends DuplicateNamedElementCommand {

		/**
		 * @generated
		 */
		private Diagram diagram;

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(TransactionalEditingDomain editingDomain, DuplicateElementsRequest req, Diagram currentDiagram) {
			super(editingDomain, req.getLabel(), req.getElementsToBeDuplicated(), req.getAllDuplicatedElementsMap(), currentDiagram);
			this.diagram = currentDiagram;
		}
	}
}
