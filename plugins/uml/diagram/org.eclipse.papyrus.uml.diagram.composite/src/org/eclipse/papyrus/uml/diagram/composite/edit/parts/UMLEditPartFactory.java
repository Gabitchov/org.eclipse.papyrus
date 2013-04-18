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
package org.eclipse.papyrus.uml.diagram.composite.edit.parts;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure;
import org.eclipse.papyrus.uml.diagram.composite.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

/**
 * @generated
 */
public class UMLEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof View) {
			View view = (View)model;
			switch(UMLVisualIDRegistry.getVisualID(view)) {
			case CompositeStructureDiagramEditPart.VISUAL_ID:
				return new CompositeStructureDiagramEditPart(view);
			case ActivityCompositeEditPart.VISUAL_ID:
				return new ActivityCompositeEditPart(view);
			case ActivityCompositeNameEditPart.VISUAL_ID:
				return new ActivityCompositeNameEditPart(view);
			case InteractionCompositeEditPart.VISUAL_ID:
				return new InteractionCompositeEditPart(view);
			case InteractionCompositeNameEditPart.VISUAL_ID:
				return new InteractionCompositeNameEditPart(view);
			case ProtocolStateMachineCompositeEditPart.VISUAL_ID:
				return new ProtocolStateMachineCompositeEditPart(view);
			case ProtocolStateMachineCompositeNameEditPart.VISUAL_ID:
				return new ProtocolStateMachineCompositeNameEditPart(view);
			case StateMachineCompositeEditPart.VISUAL_ID:
				return new StateMachineCompositeEditPart(view);
			case StateMachineCompositeNameEditPart.VISUAL_ID:
				return new StateMachineCompositeNameEditPart(view);
			case FunctionBehaviorCompositeEditPart.VISUAL_ID:
				return new FunctionBehaviorCompositeEditPart(view);
			case FunctionBehaviorCompositeNameEditPart.VISUAL_ID:
				return new FunctionBehaviorCompositeNameEditPart(view);
			case OpaqueBehaviorCompositeEditPart.VISUAL_ID:
				return new OpaqueBehaviorCompositeEditPart(view);
			case OpaqueBehaviorCompositeNameEditPart.VISUAL_ID:
				return new OpaqueBehaviorCompositeNameEditPart(view);
			case ComponentCompositeEditPart.VISUAL_ID:
				return new ComponentCompositeEditPart(view);
			case ComponentCompositeNameEditPart.VISUAL_ID:
				return new ComponentCompositeNameEditPart(view);
			case DeviceCompositeEditPart.VISUAL_ID:
				return new DeviceCompositeEditPart(view);
			case DeviceCompositeNameEditPart.VISUAL_ID:
				return new DeviceCompositeNameEditPart(view);
			case ExecutionEnvironmentCompositeEditPart.VISUAL_ID:
				return new ExecutionEnvironmentCompositeEditPart(view);
			case ExecutionEnvironmentCompositeNameEditPart.VISUAL_ID:
				return new ExecutionEnvironmentCompositeNameEditPart(view);
			case NodeCompositeEditPart.VISUAL_ID:
				return new NodeCompositeEditPart(view);
			case NodeCompositeNameEditPart.VISUAL_ID:
				return new NodeCompositeNameEditPart(view);
			case ClassCompositeEditPart.VISUAL_ID:
				return new ClassCompositeEditPart(view);
			case ClassCompositeNameEditPart.VISUAL_ID:
				return new ClassCompositeNameEditPart(view);
			case CollaborationCompositeEditPart.VISUAL_ID:
				return new CollaborationCompositeEditPart(view);
			case CollaborationCompositeNameEditPart.VISUAL_ID:
				return new CollaborationCompositeNameEditPart(view);
			case InterfaceEditPart.VISUAL_ID:
				return new InterfaceEditPart(view);
			case InterfaceNameEditPart.VISUAL_ID:
				return new InterfaceNameEditPart(view);
			case PrimitiveTypeEditPart.VISUAL_ID:
				return new PrimitiveTypeEditPart(view);
			case PrimitiveTypeNameEditPart.VISUAL_ID:
				return new PrimitiveTypeNameEditPart(view);
			case EnumerationEditPart.VISUAL_ID:
				return new EnumerationEditPart(view);
			case EnumerationNameEditPart.VISUAL_ID:
				return new EnumerationNameEditPart(view);
			case DataTypeEditPart.VISUAL_ID:
				return new DataTypeEditPart(view);
			case DataTypeNameEditPart.VISUAL_ID:
				return new DataTypeNameEditPart(view);
			case ActorEditPart.VISUAL_ID:
				return new ActorEditPart(view);
			case ActorNameEditPart.VISUAL_ID:
				return new ActorNameEditPart(view);
			case DeploymentSpecificationEditPart.VISUAL_ID:
				return new DeploymentSpecificationEditPart(view);
			case DeploymentSpecificationNameEditPart.VISUAL_ID:
				return new DeploymentSpecificationNameEditPart(view);
			case ArtifactEditPart.VISUAL_ID:
				return new ArtifactEditPart(view);
			case ArtifactNameEditPart.VISUAL_ID:
				return new ArtifactNameEditPart(view);
			case InformationItemEditPart.VISUAL_ID:
				return new InformationItemEditPart(view);
			case InformationItemNameEditPart.VISUAL_ID:
				return new InformationItemNameEditPart(view);
			case SignalEditPart.VISUAL_ID:
				return new SignalEditPart(view);
			case SignalNameEditPart.VISUAL_ID:
				return new SignalNameEditPart(view);
			case UseCaseEditPart.VISUAL_ID:
				return new UseCaseEditPart(view);
			case UseCaseNameEditPart.VISUAL_ID:
				return new UseCaseNameEditPart(view);
			case SignalEventEditPart.VISUAL_ID:
				return new SignalEventEditPart(view);
			case SignalEventNameEditPart.VISUAL_ID:
				return new SignalEventNameEditPart(view);
			case CallEventEditPart.VISUAL_ID:
				return new CallEventEditPart(view);
			case CallEventNameEditPart.VISUAL_ID:
				return new CallEventNameEditPart(view);
			case AnyReceiveEventEditPart.VISUAL_ID:
				return new AnyReceiveEventEditPart(view);
			case AnyReceiveEventNameEditPart.VISUAL_ID:
				return new AnyReceiveEventNameEditPart(view);
			case ChangeEventEditPart.VISUAL_ID:
				return new ChangeEventEditPart(view);
			case ChangeEventNameEditPart.VISUAL_ID:
				return new ChangeEventNameEditPart(view);
			case TimeEventEditPart.VISUAL_ID:
				return new TimeEventEditPart(view);
			case TimeEventNameEditPart.VISUAL_ID:
				return new TimeEventNameEditPart(view);
			case DurationObservationEditPart.VISUAL_ID:
				return new DurationObservationEditPart(view);
			case DurationObservationNameEditPart.VISUAL_ID:
				return new DurationObservationNameEditPart(view);
			case DurationObservationStereotypeLabelEditPart.VISUAL_ID:
				return new DurationObservationStereotypeLabelEditPart(view);
			case TimeObservationEditPart.VISUAL_ID:
				return new TimeObservationEditPart(view);
			case TimeObservationNameEditPart.VISUAL_ID:
				return new TimeObservationNameEditPart(view);
			case TimeObservationStereotypeLabelEditPart.VISUAL_ID:
				return new TimeObservationStereotypeLabelEditPart(view);
			case LiteralBooleanEditPart.VISUAL_ID:
				return new LiteralBooleanEditPart(view);
			case LiteralBooleanNameEditPart.VISUAL_ID:
				return new LiteralBooleanNameEditPart(view);
			case LiteralIntegerEditPart.VISUAL_ID:
				return new LiteralIntegerEditPart(view);
			case LiteralIntegerNameEditPart.VISUAL_ID:
				return new LiteralIntegerNameEditPart(view);
			case LiteralNullEditPart.VISUAL_ID:
				return new LiteralNullEditPart(view);
			case LiteralNullNameEditPart.VISUAL_ID:
				return new LiteralNullNameEditPart(view);
			case LiteralStringEditPart.VISUAL_ID:
				return new LiteralStringEditPart(view);
			case LiteralStringNameEditPart.VISUAL_ID:
				return new LiteralStringNameEditPart(view);
			case LiteralUnlimitedNaturalEditPart.VISUAL_ID:
				return new LiteralUnlimitedNaturalEditPart(view);
			case LiteralUnlimitedNaturalNameEditPart.VISUAL_ID:
				return new LiteralUnlimitedNaturalNameEditPart(view);
			case StringExpressionEditPart.VISUAL_ID:
				return new StringExpressionEditPart(view);
			case StringExpressionNameEditPart.VISUAL_ID:
				return new StringExpressionNameEditPart(view);
			case OpaqueExpressionEditPart.VISUAL_ID:
				return new OpaqueExpressionEditPart(view);
			case OpaqueExpressionNameEditPart.VISUAL_ID:
				return new OpaqueExpressionNameEditPart(view);
			case TimeExpressionEditPart.VISUAL_ID:
				return new TimeExpressionEditPart(view);
			case TimeExpressionNameEditPart.VISUAL_ID:
				return new TimeExpressionNameEditPart(view);
			case ExpressionEditPart.VISUAL_ID:
				return new ExpressionEditPart(view);
			case ExpressionNameEditPart.VISUAL_ID:
				return new ExpressionNameEditPart(view);
			case DurationEditPart.VISUAL_ID:
				return new DurationEditPart(view);
			case DurationNameEditPart.VISUAL_ID:
				return new DurationNameEditPart(view);
			case TimeIntervalEditPart.VISUAL_ID:
				return new TimeIntervalEditPart(view);
			case TimeIntervalNameEditPart.VISUAL_ID:
				return new TimeIntervalNameEditPart(view);
			case DurationIntervalEditPart.VISUAL_ID:
				return new DurationIntervalEditPart(view);
			case DurationIntervalNameEditPart.VISUAL_ID:
				return new DurationIntervalNameEditPart(view);
			case IntervalEditPart.VISUAL_ID:
				return new IntervalEditPart(view);
			case IntervalNameEditPart.VISUAL_ID:
				return new IntervalNameEditPart(view);
			case InstanceValueEditPart.VISUAL_ID:
				return new InstanceValueEditPart(view);
			case InstanceValueNameEditPart.VISUAL_ID:
				return new InstanceValueNameEditPart(view);
			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);
			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);
			case DurationConstraintEditPart.VISUAL_ID:
				return new DurationConstraintEditPart(view);
			case DurationConstraintNameEditPart.VISUAL_ID:
				return new DurationConstraintNameEditPart(view);
			case DurationConstraintSpecificationEditPart.VISUAL_ID:
				return new DurationConstraintSpecificationEditPart(view);
			case TimeConstraintEditPart.VISUAL_ID:
				return new TimeConstraintEditPart(view);
			case TimeConstraintNameEditPart.VISUAL_ID:
				return new TimeConstraintNameEditPart(view);
			case TimeConstraintSpecificationEditPart.VISUAL_ID:
				return new TimeConstraintSpecificationEditPart(view);
			case IntervalConstraintEditPart.VISUAL_ID:
				return new IntervalConstraintEditPart(view);
			case IntervalConstraintNameEditPart.VISUAL_ID:
				return new IntervalConstraintNameEditPart(view);
			case IntervalConstraintSpecificationEditPart.VISUAL_ID:
				return new IntervalConstraintSpecificationEditPart(view);
			case InteractionConstraintEditPart.VISUAL_ID:
				return new InteractionConstraintEditPart(view);
			case InteractionConstraintNameEditPart.VISUAL_ID:
				return new InteractionConstraintNameEditPart(view);
			case InteractionConstraintSpecificationEditPart.VISUAL_ID:
				return new InteractionConstraintSpecificationEditPart(view);
			case ConstraintEditPart.VISUAL_ID:
				return new ConstraintEditPart(view);
			case ConstraintNameEditPart.VISUAL_ID:
				return new ConstraintNameEditPart(view);
			case ConstraintSpecificationEditPart.VISUAL_ID:
				return new ConstraintSpecificationEditPart(view);
			case BehaviorPortEditPart.VISUAL_ID:
				return new BehaviorPortEditPart(view);
			case PortEditPart.VISUAL_ID:
				return new PortEditPart(view);
			case PortNameEditPart.VISUAL_ID:
				return new PortNameEditPart(view);
			case PortAppliedStereotypeEditPart.VISUAL_ID:
				return new PortAppliedStereotypeEditPart(view);
			case ParameterEditPart.VISUAL_ID:
				return new ParameterEditPart(view);
			case ParameterNameEditPart.VISUAL_ID:
				return new ParameterNameEditPart(view);
			case ParameterAppliedStereotypeEditPart.VISUAL_ID:
				return new ParameterAppliedStereotypeEditPart(view);
			case PropertyPartEditPartCN.VISUAL_ID:
				return new PropertyPartEditPartCN(view);
			case PropertyPartNameEditPartCN.VISUAL_ID:
				return new PropertyPartNameEditPartCN(view);
			case CollaborationRoleEditPartCN.VISUAL_ID:
				return new CollaborationRoleEditPartCN(view);
			case CollaborationRoleNameEditPartCN.VISUAL_ID:
				return new CollaborationRoleNameEditPartCN(view);
			case CollaborationUseEditPartCN.VISUAL_ID:
				return new CollaborationUseEditPartCN(view);
			case CollaborationUseNameEditPart.VISUAL_ID:
				return new CollaborationUseNameEditPart(view);
			case ActivityCompositeEditPartCN.VISUAL_ID:
				return new ActivityCompositeEditPartCN(view);
			case ActivityCompositeNameEditPartCN.VISUAL_ID:
				return new ActivityCompositeNameEditPartCN(view);
			case InteractionCompositeEditPartCN.VISUAL_ID:
				return new InteractionCompositeEditPartCN(view);
			case InteractionCompositeNameEditPartCN.VISUAL_ID:
				return new InteractionCompositeNameEditPartCN(view);
			case ProtocolStateMachineCompositeEditPartCN.VISUAL_ID:
				return new ProtocolStateMachineCompositeEditPartCN(view);
			case ProtocolStateMachineCompositeNameEditPartCN.VISUAL_ID:
				return new ProtocolStateMachineCompositeNameEditPartCN(view);
			case StateMachineCompositeEditPartCN.VISUAL_ID:
				return new StateMachineCompositeEditPartCN(view);
			case StateMachineCompositeNameEditPartCN.VISUAL_ID:
				return new StateMachineCompositeNameEditPartCN(view);
			case FunctionBehaviorCompositeEditPartCN.VISUAL_ID:
				return new FunctionBehaviorCompositeEditPartCN(view);
			case FunctionBehaviorCompositeNameEditPartCN.VISUAL_ID:
				return new FunctionBehaviorCompositeNameEditPartCN(view);
			case OpaqueBehaviorCompositeEditPartCN.VISUAL_ID:
				return new OpaqueBehaviorCompositeEditPartCN(view);
			case OpaqueBehaviorCompositeNameEditPartCN.VISUAL_ID:
				return new OpaqueBehaviorCompositeNameEditPartCN(view);
			case ComponentCompositeEditPartCN.VISUAL_ID:
				return new ComponentCompositeEditPartCN(view);
			case ComponentCompositeNameEditPartCN.VISUAL_ID:
				return new ComponentCompositeNameEditPartCN(view);
			case DeviceCompositeEditPartCN.VISUAL_ID:
				return new DeviceCompositeEditPartCN(view);
			case DeviceCompositeNameEditPartCN.VISUAL_ID:
				return new DeviceCompositeNameEditPartCN(view);
			case ExecutionEnvironmentCompositeEditPartCN.VISUAL_ID:
				return new ExecutionEnvironmentCompositeEditPartCN(view);
			case ExecutionEnvironmentCompositeNameEditPartCN.VISUAL_ID:
				return new ExecutionEnvironmentCompositeNameEditPartCN(view);
			case NodeCompositeEditPartCN.VISUAL_ID:
				return new NodeCompositeEditPartCN(view);
			case NodeCompositeNameEditPartCN.VISUAL_ID:
				return new NodeCompositeNameEditPartCN(view);
			case ClassCompositeEditPartCN.VISUAL_ID:
				return new ClassCompositeEditPartCN(view);
			case ClassCompositeNameEditPartCN.VISUAL_ID:
				return new ClassCompositeNameEditPartCN(view);
			case CollaborationCompositeEditPartCN.VISUAL_ID:
				return new CollaborationCompositeEditPartCN(view);
			case CollaborationCompositeNameEditPartCN.VISUAL_ID:
				return new CollaborationCompositeNameEditPartCN(view);
			case InterfaceEditPartCN.VISUAL_ID:
				return new InterfaceEditPartCN(view);
			case InterfaceNameEditPartCN.VISUAL_ID:
				return new InterfaceNameEditPartCN(view);
			case PrimitiveTypeEditPartCN.VISUAL_ID:
				return new PrimitiveTypeEditPartCN(view);
			case PrimitiveTypeNameEditPartCN.VISUAL_ID:
				return new PrimitiveTypeNameEditPartCN(view);
			case EnumerationEditPartCN.VISUAL_ID:
				return new EnumerationEditPartCN(view);
			case EnumerationNameEditPartCN.VISUAL_ID:
				return new EnumerationNameEditPartCN(view);
			case DataTypeEditPartCN.VISUAL_ID:
				return new DataTypeEditPartCN(view);
			case DataTypeNameEditPartCN.VISUAL_ID:
				return new DataTypeNameEditPartCN(view);
			case ActorEditPartCN.VISUAL_ID:
				return new ActorEditPartCN(view);
			case ActorNameEditPartCN.VISUAL_ID:
				return new ActorNameEditPartCN(view);
			case DeploymentSpecificationEditPartCN.VISUAL_ID:
				return new DeploymentSpecificationEditPartCN(view);
			case DeploymentSpecificationNameEditPartCN.VISUAL_ID:
				return new DeploymentSpecificationNameEditPartCN(view);
			case ArtifactEditPartCN.VISUAL_ID:
				return new ArtifactEditPartCN(view);
			case ArtifactNameEditPartCN.VISUAL_ID:
				return new ArtifactNameEditPartCN(view);
			case InformationItemEditPartCN.VISUAL_ID:
				return new InformationItemEditPartCN(view);
			case InformationItemNameEditPartCN.VISUAL_ID:
				return new InformationItemNameEditPartCN(view);
			case SignalEditPartCN.VISUAL_ID:
				return new SignalEditPartCN(view);
			case SignalNameEditPartCN.VISUAL_ID:
				return new SignalNameEditPartCN(view);
			case UseCaseEditPartCN.VISUAL_ID:
				return new UseCaseEditPartCN(view);
			case UseCaseNameEditPartCN.VISUAL_ID:
				return new UseCaseNameEditPartCN(view);
			case CommentEditPartCN.VISUAL_ID:
				return new CommentEditPartCN(view);
			case CommentBodyEditPartCN.VISUAL_ID:
				return new CommentBodyEditPartCN(view);
			case DurationConstraintEditPartCN.VISUAL_ID:
				return new DurationConstraintEditPartCN(view);
			case DurationConstraintNameEditPartCN.VISUAL_ID:
				return new DurationConstraintNameEditPartCN(view);
			case DurationConstraintSpecificationEditPartCN.VISUAL_ID:
				return new DurationConstraintSpecificationEditPartCN(view);
			case TimeConstraintEditPartCN.VISUAL_ID:
				return new TimeConstraintEditPartCN(view);
			case TimeConstraintNameEditPartCN.VISUAL_ID:
				return new TimeConstraintNameEditPartCN(view);
			case TimeConstraintSpecificationEditPartCN.VISUAL_ID:
				return new TimeConstraintSpecificationEditPartCN(view);
			case IntervalConstraintEditPartCN.VISUAL_ID:
				return new IntervalConstraintEditPartCN(view);
			case IntervalConstraintNameEditPartCN.VISUAL_ID:
				return new IntervalConstraintNameEditPartCN(view);
			case IntervalConstraintSpecificationEditPartCN.VISUAL_ID:
				return new IntervalConstraintSpecificationEditPartCN(view);
			case InteractionConstraintEditPartCN.VISUAL_ID:
				return new InteractionConstraintEditPartCN(view);
			case InteractionConstraintNameEditPartCN.VISUAL_ID:
				return new InteractionConstraintNameEditPartCN(view);
			case InteractionConstraintSpecificationEditPartCN.VISUAL_ID:
				return new InteractionConstraintSpecificationEditPartCN(view);
			case ConstraintEditPartCN.VISUAL_ID:
				return new ConstraintEditPartCN(view);
			case ConstraintNameEditPartCN.VISUAL_ID:
				return new ConstraintNameEditPartCN(view);
			case ConstraintSpecificationEditPartCN.VISUAL_ID:
				return new ConstraintSpecificationEditPartCN(view);
			case PropertyEditPartCLN.VISUAL_ID:
				return new PropertyEditPartCLN(view);
			case OperationEditPartCLN.VISUAL_ID:
				return new OperationEditPartCLN(view);
			case ReceptionEditPartCLN.VISUAL_ID:
				return new ReceptionEditPartCLN(view);
			case EnumerationLiteralEditPartCLN.VISUAL_ID:
				return new EnumerationLiteralEditPartCLN(view);
			case ActivityEditPartCLN.VISUAL_ID:
				return new ActivityEditPartCLN(view);
			case InteractionEditPartCLN.VISUAL_ID:
				return new InteractionEditPartCLN(view);
			case ProtocolStateMachineEditPartCLN.VISUAL_ID:
				return new ProtocolStateMachineEditPartCLN(view);
			case StateMachineEditPartCLN.VISUAL_ID:
				return new StateMachineEditPartCLN(view);
			case FunctionBehaviorEditPartCLN.VISUAL_ID:
				return new FunctionBehaviorEditPartCLN(view);
			case OpaqueBehaviorEditPartCLN.VISUAL_ID:
				return new OpaqueBehaviorEditPartCLN(view);
			case CollaborationEditPartCLN.VISUAL_ID:
				return new CollaborationEditPartCLN(view);
			case InterfaceEditPartCLN.VISUAL_ID:
				return new InterfaceEditPartCLN(view);
			case EnumerationEditPartCLN.VISUAL_ID:
				return new EnumerationEditPartCLN(view);
			case PrimitiveTypeEditPartCLN.VISUAL_ID:
				return new PrimitiveTypeEditPartCLN(view);
			case DataTypeEditPartCLN.VISUAL_ID:
				return new DataTypeEditPartCLN(view);
			case ClassEditPartCLN.VISUAL_ID:
				return new ClassEditPartCLN(view);
			case DataTypeAttributeCompartmentEditPart.VISUAL_ID:
				return new DataTypeAttributeCompartmentEditPart(view);
			case DataTypeOperationCompartmentEditPart.VISUAL_ID:
				return new DataTypeOperationCompartmentEditPart(view);
			case DataTypeAttributeCompartmentEditPartCN.VISUAL_ID:
				return new DataTypeAttributeCompartmentEditPartCN(view);
			case DataTypeOperationCompartmentEditPartCN.VISUAL_ID:
				return new DataTypeOperationCompartmentEditPartCN(view);
			case EnumerationEnumerationLiteralCompartmentEditPart.VISUAL_ID:
				return new EnumerationEnumerationLiteralCompartmentEditPart(view);
			case EnumerationEnumerationLiteralCompartmentEditPartCN.VISUAL_ID:
				return new EnumerationEnumerationLiteralCompartmentEditPartCN(view);
			case ActivityCompositeCompartmentEditPartCN.VISUAL_ID:
				return new ActivityCompositeCompartmentEditPartCN(view);
			case InteractionCompositeCompartmentEditPartCN.VISUAL_ID:
				return new InteractionCompositeCompartmentEditPartCN(view);
			case ProtocolStateMachineCompositeCompartmentEditPartCN.VISUAL_ID:
				return new ProtocolStateMachineCompositeCompartmentEditPartCN(view);
			case StateMachineCompositeCompartmentEditPartCN.VISUAL_ID:
				return new StateMachineCompositeCompartmentEditPartCN(view);
			case FunctionBehaviorCompositeCompartmentEditPartCN.VISUAL_ID:
				return new FunctionBehaviorCompositeCompartmentEditPartCN(view);
			case OpaqueBehaviorCompositeCompartmentEditPartCN.VISUAL_ID:
				return new OpaqueBehaviorCompositeCompartmentEditPartCN(view);
			case ComponentCompositeCompartmentEditPartCN.VISUAL_ID:
				return new ComponentCompositeCompartmentEditPartCN(view);
			case DeviceCompositeCompartmentEditPartCN.VISUAL_ID:
				return new DeviceCompositeCompartmentEditPartCN(view);
			case ExecutionEnvironmentCompositeCompartmentEditPartCN.VISUAL_ID:
				return new ExecutionEnvironmentCompositeCompartmentEditPartCN(view);
			case NodeCompositeCompartmentEditPartCN.VISUAL_ID:
				return new NodeCompositeCompartmentEditPartCN(view);
			case ClassCompositeCompartmentEditPartCN.VISUAL_ID:
				return new ClassCompositeCompartmentEditPartCN(view);
			case CollaborationCompositeCompartmentEditPartCN.VISUAL_ID:
				return new CollaborationCompositeCompartmentEditPartCN(view);
			case ActivityCompositeCompartmentEditPart.VISUAL_ID:
				return new ActivityCompositeCompartmentEditPart(view);
			case InteractionCompositeCompartmentEditPart.VISUAL_ID:
				return new InteractionCompositeCompartmentEditPart(view);
			case ProtocolStateMachineCompositeCompartmentEditPart.VISUAL_ID:
				return new ProtocolStateMachineCompositeCompartmentEditPart(view);
			case StateMachineCompositeCompartmentEditPart.VISUAL_ID:
				return new StateMachineCompositeCompartmentEditPart(view);
			case FunctionBehaviorCompositeCompartmentEditPart.VISUAL_ID:
				return new FunctionBehaviorCompositeCompartmentEditPart(view);
			case OpaqueBehaviorCompositeCompartmentEditPart.VISUAL_ID:
				return new OpaqueBehaviorCompositeCompartmentEditPart(view);
			case ComponentCompositeCompartmentEditPart.VISUAL_ID:
				return new ComponentCompositeCompartmentEditPart(view);
			case DeviceCompositeCompartmentEditPart.VISUAL_ID:
				return new DeviceCompositeCompartmentEditPart(view);
			case ExecutionEnvironmentCompositeCompartmentEditPart.VISUAL_ID:
				return new ExecutionEnvironmentCompositeCompartmentEditPart(view);
			case NodeCompositeCompartmentEditPart.VISUAL_ID:
				return new NodeCompositeCompartmentEditPart(view);
			case ClassCompositeCompartmentEditPart.VISUAL_ID:
				return new ClassCompositeCompartmentEditPart(view);
			case CollaborationCompositeCompartmentEditPart.VISUAL_ID:
				return new CollaborationCompositeCompartmentEditPart(view);
			case PropertyPartCompartmentEditPartCN.VISUAL_ID:
				return new PropertyPartCompartmentEditPartCN(view);
			case BehaviorPortLinkEditPart.VISUAL_ID:
				return new BehaviorPortLinkEditPart(view);
			case LinkDescriptorEditPart.VISUAL_ID:
				return new LinkDescriptorEditPart(view);
			case CommentAnnotatedElementEditPart.VISUAL_ID:
				return new CommentAnnotatedElementEditPart(view);
			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new ConstraintConstrainedElementEditPart(view);
			case ComponentRealizationEditPart.VISUAL_ID:
				return new ComponentRealizationEditPart(view);
			case ComponentRealizationNameEditPart.VISUAL_ID:
				return new ComponentRealizationNameEditPart(view);
			case ComponentRealizationAppliedStereotypeEditPart.VISUAL_ID:
				return new ComponentRealizationAppliedStereotypeEditPart(view);
			case InterfaceRealizationEditPart.VISUAL_ID:
				return new InterfaceRealizationEditPart(view);
			case InterfaceRealizationNameEditPart.VISUAL_ID:
				return new InterfaceRealizationNameEditPart(view);
			case InterfaceRealizationAppliedStereotypeEditPart.VISUAL_ID:
				return new InterfaceRealizationAppliedStereotypeEditPart(view);
			case SubstitutionEditPart.VISUAL_ID:
				return new SubstitutionEditPart(view);
			case SubstitutionNameEditPart.VISUAL_ID:
				return new SubstitutionNameEditPart(view);
			case SubstitutionAppliedStereotypeEditPart.VISUAL_ID:
				return new SubstitutionAppliedStereotypeEditPart(view);
			case RealizationEditPart.VISUAL_ID:
				return new RealizationEditPart(view);
			case RealizationNameEditPart.VISUAL_ID:
				return new RealizationNameEditPart(view);
			case RealizationAppliedStereotypeEditPart.VISUAL_ID:
				return new RealizationAppliedStereotypeEditPart(view);
			case ManifestationEditPart.VISUAL_ID:
				return new ManifestationEditPart(view);
			case ManifestationNameEditPart.VISUAL_ID:
				return new ManifestationNameEditPart(view);
			case ManifestationAppliedStereotypeEditPart.VISUAL_ID:
				return new ManifestationAppliedStereotypeEditPart(view);
			case AbstractionEditPart.VISUAL_ID:
				return new AbstractionEditPart(view);
			case AbstractionNameEditPart.VISUAL_ID:
				return new AbstractionNameEditPart(view);
			case AbstractionAppliedStereotypeEditPart.VISUAL_ID:
				return new AbstractionAppliedStereotypeEditPart(view);
			case UsageEditPart.VISUAL_ID:
				return new UsageEditPart(view);
			case UsageNameEditPart.VISUAL_ID:
				return new UsageNameEditPart(view);
			case UsageAppliedStereotypeEditPart.VISUAL_ID:
				return new UsageAppliedStereotypeEditPart(view);
			case DeploymentEditPart.VISUAL_ID:
				return new DeploymentEditPart(view);
			case DeploymentNameEditPart.VISUAL_ID:
				return new DeploymentNameEditPart(view);
			case DeploymentAppliedStereotypeEditPart.VISUAL_ID:
				return new DeploymentAppliedStereotypeEditPart(view);
			case RoleBindingEditPart.VISUAL_ID:
				return new RoleBindingEditPart(view);
			case RoleBindingRoleNameEditPart.VISUAL_ID:
				return new RoleBindingRoleNameEditPart(view);
			case RoleBindingAppliedStereotypeEditPart.VISUAL_ID:
				return new RoleBindingAppliedStereotypeEditPart(view);
			case DependencyEditPart.VISUAL_ID:
				return new DependencyEditPart(view);
			case DependencyNameEditPart.VISUAL_ID:
				return new DependencyNameEditPart(view);
			case DependencyAppliedStereotypeEditPart.VISUAL_ID:
				return new DependencyAppliedStereotypeEditPart(view);
			case ConnectorEditPart.VISUAL_ID:
				return new ConnectorEditPart(view);
			case ConnectorAppliedStereotypeEditPart.VISUAL_ID:
				return new ConnectorAppliedStereotypeEditPart(view);
			case ConnectorNameEditPart.VISUAL_ID:
				return new ConnectorNameEditPart(view);
			case ConnectorMultiplicitySourceEditPart.VISUAL_ID:
				return new ConnectorMultiplicitySourceEditPart(view);
			case ConnectorMultiplicityTargetEditPart.VISUAL_ID:
				return new ConnectorMultiplicityTargetEditPart(view);
			case GeneralizationEditPart.VISUAL_ID:
				return new GeneralizationEditPart(view);
			case GeneralizationAppliedStereotypeEditPart.VISUAL_ID:
				return new GeneralizationAppliedStereotypeEditPart(view);
			case TimeObservationEventEditPart.VISUAL_ID:
				return new TimeObservationEventEditPart(view);
			case DurationObservationEventEditPart.VISUAL_ID:
				return new DurationObservationEventEditPart(view);
			case RepresentationEditPart.VISUAL_ID:
				return new RepresentationEditPart(view);
			case RepresentationTagLabelEditPart.VISUAL_ID:
				return new RepresentationTagLabelEditPart(view);
			case InformationFlowEditPart.VISUAL_ID:
				return new InformationFlowEditPart(view);
			case InformationFlowConveyedLabelEditPart.VISUAL_ID:
				return new InformationFlowConveyedLabelEditPart(view);
			case InformationFlowAppliedStereotypeEditPart.VISUAL_ID:
				return new InformationFlowAppliedStereotypeEditPart(view);
			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if(source.getFigure() instanceof IMultilineEditableFigure) {
			return new MultilineCellEditorLocator((IMultilineEditableFigure)source.getFigure());
		} else {
			return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
		}
	}

	/**
	 * @generated
	 */
	static private class MultilineCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private IMultilineEditableFigure multilineEditableFigure;

		/**
		 * @generated
		 */
		public MultilineCellEditorLocator(IMultilineEditableFigure figure) {
			this.multilineEditableFigure = figure;
		}

		/**
		 * @generated
		 */
		public IMultilineEditableFigure getMultilineEditableFigure() {
			return multilineEditableFigure;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getMultilineEditableFigure().getBounds().getCopy();
			rect.x = getMultilineEditableFigure().getEditionLocation().x;
			rect.y = getMultilineEditableFigure().getEditionLocation().y;
			getMultilineEditableFigure().translateToAbsolute(rect);
			if(getMultilineEditableFigure().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			}
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
