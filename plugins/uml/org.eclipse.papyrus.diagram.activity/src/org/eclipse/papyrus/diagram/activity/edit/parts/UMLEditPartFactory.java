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
package org.eclipse.papyrus.diagram.activity.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure;
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

			case ActivityDiagramEditPart.VISUAL_ID:
				return new ActivityDiagramEditPart(view);

			case ActivityEditPart.VISUAL_ID:
				return new ActivityEditPart(view);

			case ActivityNameEditPart.VISUAL_ID:
				return new ActivityNameEditPart(view);

			case ActivityIsSingleExecutionEditPart.VISUAL_ID:
				return new ActivityIsSingleExecutionEditPart(view);

			case ParameterEditPart.VISUAL_ID:
				return new ParameterEditPart(view);

			case ConstraintInActivityAsPrecondEditPart.VISUAL_ID:
				return new ConstraintInActivityAsPrecondEditPart(view);

			case ConstraintInActivityAsPostcondEditPart.VISUAL_ID:
				return new ConstraintInActivityAsPostcondEditPart(view);

			case InitialNodeEditPart.VISUAL_ID:
				return new InitialNodeEditPart(view);

			case InitialNodeAppliedStereotypeEditPart.VISUAL_ID:
				return new InitialNodeAppliedStereotypeEditPart(view);

			case ActivityFinalNodeEditPart.VISUAL_ID:
				return new ActivityFinalNodeEditPart(view);

			case ActivityFinalNodeAppliedStereotypeEditPart.VISUAL_ID:
				return new ActivityFinalNodeAppliedStereotypeEditPart(view);

			case FlowFinalNodeEditPart.VISUAL_ID:
				return new FlowFinalNodeEditPart(view);

			case FlowFinalNodeAppliedStereotypeEditPart.VISUAL_ID:
				return new FlowFinalNodeAppliedStereotypeEditPart(view);

			case OpaqueActionEditPart.VISUAL_ID:
				return new OpaqueActionEditPart(view);

			case OpaqueActionNameEditPart.VISUAL_ID:
				return new OpaqueActionNameEditPart(view);

			case ValuePinInOpaqueActEditPart.VISUAL_ID:
				return new ValuePinInOpaqueActEditPart(view);

			case ValuePinInOActLabelEditPart.VISUAL_ID:
				return new ValuePinInOActLabelEditPart(view);

			case ValuePinInOActValueEditPart.VISUAL_ID:
				return new ValuePinInOActValueEditPart(view);

			case ValuePinInOActAppliedStereotypeEditPart.VISUAL_ID:
				return new ValuePinInOActAppliedStereotypeEditPart(view);

			case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
				return new ActionInputPinInOpaqueActEditPart(view);

			case ActionInputPinInOActLabelEditPart.VISUAL_ID:
				return new ActionInputPinInOActLabelEditPart(view);

			case ActionInputPinInOActValueEditPart.VISUAL_ID:
				return new ActionInputPinInOActValueEditPart(view);

			case ActionInputPinInOActAppliedStereotypeEditPart.VISUAL_ID:
				return new ActionInputPinInOActAppliedStereotypeEditPart(view);

			case InputPinInOpaqueActEditPart.VISUAL_ID:
				return new InputPinInOpaqueActEditPart(view);

			case InputPinInOActLabelEditPart.VISUAL_ID:
				return new InputPinInOActLabelEditPart(view);

			case InputPinInOActAppliedStereotypeEditPart.VISUAL_ID:
				return new InputPinInOActAppliedStereotypeEditPart(view);

			case OutputPinInOpaqueActEditPart.VISUAL_ID:
				return new OutputPinInOpaqueActEditPart(view);

			case OutputPinInOActLabelEditPart.VISUAL_ID:
				return new OutputPinInOActLabelEditPart(view);

			case OutputPinInOActAppliedStereotypeEditPart.VISUAL_ID:
				return new OutputPinInOActAppliedStereotypeEditPart(view);

			case CallBehaviorActionEditPart.VISUAL_ID:
				return new CallBehaviorActionEditPart(view);

			case CallBehaviorActionNameEditPart.VISUAL_ID:
				return new CallBehaviorActionNameEditPart(view);

			case ValuePinInCallBeActEditPart.VISUAL_ID:
				return new ValuePinInCallBeActEditPart(view);

			case ValuePinInCBActLabelEditPart.VISUAL_ID:
				return new ValuePinInCBActLabelEditPart(view);

			case ValuePinInCBActValueEditPart.VISUAL_ID:
				return new ValuePinInCBActValueEditPart(view);

			case ValuePinInCBActAppliedStereotypeEditPart.VISUAL_ID:
				return new ValuePinInCBActAppliedStereotypeEditPart(view);

			case ActionInputPinInCallBeActEditPart.VISUAL_ID:
				return new ActionInputPinInCallBeActEditPart(view);

			case ActionInputPinInCBActLabelEditPart.VISUAL_ID:
				return new ActionInputPinInCBActLabelEditPart(view);

			case ActionInputPinInCBActValueEditPart.VISUAL_ID:
				return new ActionInputPinInCBActValueEditPart(view);

			case ActionInputPinInCBActAppliedStereotypeEditPart.VISUAL_ID:
				return new ActionInputPinInCBActAppliedStereotypeEditPart(view);

			case InputPinInCallBeActEditPart.VISUAL_ID:
				return new InputPinInCallBeActEditPart(view);

			case InputPinInCBActLabelEditPart.VISUAL_ID:
				return new InputPinInCBActLabelEditPart(view);

			case InputPinInCBActAppliedStereotypeEditPart.VISUAL_ID:
				return new InputPinInCBActAppliedStereotypeEditPart(view);

			case OutputPinInCallBeActEditPart.VISUAL_ID:
				return new OutputPinInCallBeActEditPart(view);

			case OutputPinInCBActLabelEditPart.VISUAL_ID:
				return new OutputPinInCBActLabelEditPart(view);

			case OutputPinInCBActAppliedStereotypeEditPart.VISUAL_ID:
				return new OutputPinInCBActAppliedStereotypeEditPart(view);

			case CallOperationActionEditPart.VISUAL_ID:
				return new CallOperationActionEditPart(view);

			case CallOperationActionNameEditPart.VISUAL_ID:
				return new CallOperationActionNameEditPart(view);

			case ActionInputPinInCallOpActEditPart.VISUAL_ID:
				return new ActionInputPinInCallOpActEditPart(view);

			case ActionInputPinInCOActLabelEditPart.VISUAL_ID:
				return new ActionInputPinInCOActLabelEditPart(view);

			case ActionInputPinInCOActValueEditPart.VISUAL_ID:
				return new ActionInputPinInCOActValueEditPart(view);

			case ActionInputPinInCOActAppliedStereotypeEditPart.VISUAL_ID:
				return new ActionInputPinInCOActAppliedStereotypeEditPart(view);

			case ValuePinInCallOpActEditPart.VISUAL_ID:
				return new ValuePinInCallOpActEditPart(view);

			case ValuePinInCOActLabelEditPart.VISUAL_ID:
				return new ValuePinInCOActLabelEditPart(view);

			case ValuePinInCOActValueEditPart.VISUAL_ID:
				return new ValuePinInCOActValueEditPart(view);

			case ValuePinInCOActAppliedStereotypeEditPart.VISUAL_ID:
				return new ValuePinInCOActAppliedStereotypeEditPart(view);

			case InputPinInCallOpActEditPart.VISUAL_ID:
				return new InputPinInCallOpActEditPart(view);

			case InputPinInCOActLabelEditPart.VISUAL_ID:
				return new InputPinInCOActLabelEditPart(view);

			case InputPinInCOActAppliedStereotypeEditPart.VISUAL_ID:
				return new InputPinInCOActAppliedStereotypeEditPart(view);

			case OutputPinInCallOpActEditPart.VISUAL_ID:
				return new OutputPinInCallOpActEditPart(view);

			case OutputPinInCOActLabelEditPart.VISUAL_ID:
				return new OutputPinInCOActLabelEditPart(view);

			case OutputPinInCOActAppliedStereotypeEditPart.VISUAL_ID:
				return new OutputPinInCOActAppliedStereotypeEditPart(view);

			case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
				return new ValuePinInCallOpActAsTargetEditPart(view);

			case ValuePinInCOActAsTargetLabelEditPart.VISUAL_ID:
				return new ValuePinInCOActAsTargetLabelEditPart(view);

			case ValuePinInCOActAsTargetValueEditPart.VISUAL_ID:
				return new ValuePinInCOActAsTargetValueEditPart(view);

			case ValuePinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
				return new ValuePinInCOActAsTargetAppliedStereotypeEditPart(view);

			case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
				return new ActionInputPinInCallOpActAsTargetEditPart(view);

			case ActionInputPinInCOActAsTargetLabelEditPart.VISUAL_ID:
				return new ActionInputPinInCOActAsTargetLabelEditPart(view);

			case ActionInputPinInCOActAsTargetValueEditPart.VISUAL_ID:
				return new ActionInputPinInCOActAsTargetValueEditPart(view);

			case ActionInputPinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
				return new ActionInputPinInCOActAsTargetAppliedStereotypeEditPart(view);

			case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
				return new InputPinInCallOpActAsTargetEditPart(view);

			case InputPinInCOActAsTargetLabelEditPart.VISUAL_ID:
				return new InputPinInCOActAsTargetLabelEditPart(view);

			case InputPinInCOActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
				return new InputPinInCOActAsTargetAppliedStereotypeEditPart(view);

			case DurationConstraintAsLocalPrecondEditPart.VISUAL_ID:
				return new DurationConstraintAsLocalPrecondEditPart(view);

			case DurationConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
				return new DurationConstraintAsLocalPrecondNameEditPart(view);

			case DurationConstraintAsLocalPostcondEditPart.VISUAL_ID:
				return new DurationConstraintAsLocalPostcondEditPart(view);

			case DurationConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
				return new DurationConstraintAsLocalPostcondNameEditPart(view);

			case TimeConstraintAsLocalPrecondEditPart.VISUAL_ID:
				return new TimeConstraintAsLocalPrecondEditPart(view);

			case TimeConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
				return new TimeConstraintAsLocalPrecondNameEditPart(view);

			case TimeConstraintAsLocalPostcondEditPart.VISUAL_ID:
				return new TimeConstraintAsLocalPostcondEditPart(view);

			case TimeConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
				return new TimeConstraintAsLocalPostcondNameEditPart(view);

			case InteractionConstraintAsLocalPrecondEditPart.VISUAL_ID:
				return new InteractionConstraintAsLocalPrecondEditPart(view);

			case InteractionConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
				return new InteractionConstraintAsLocalPrecondNameEditPart(view);

			case InteractionConstraintAsLocalPostcondEditPart.VISUAL_ID:
				return new InteractionConstraintAsLocalPostcondEditPart(view);

			case InteractionConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
				return new InteractionConstraintAsLocalPostcondNameEditPart(view);

			case IntervalConstraintAsLocalPrecondEditPart.VISUAL_ID:
				return new IntervalConstraintAsLocalPrecondEditPart(view);

			case IntervalConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
				return new IntervalConstraintAsLocalPrecondNameEditPart(view);

			case IntervalConstraintAsLocalPostcondEditPart.VISUAL_ID:
				return new IntervalConstraintAsLocalPostcondEditPart(view);

			case IntervalConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
				return new IntervalConstraintAsLocalPostcondNameEditPart(view);

			case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
				return new ConstraintAsLocalPrecondEditPart(view);

			case ConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
				return new ConstraintAsLocalPrecondNameEditPart(view);

			case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
				return new ConstraintAsLocalPostcondEditPart(view);

			case ConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
				return new ConstraintAsLocalPostcondNameEditPart(view);

			case DecisionNodeEditPart.VISUAL_ID:
				return new DecisionNodeEditPart(view);

			case DecisionInputEditPart.VISUAL_ID:
				return new DecisionInputEditPart(view);

			case DecisionNodeAppliedStereotypeEditPart.VISUAL_ID:
				return new DecisionNodeAppliedStereotypeEditPart(view);

			case MergeNodeEditPart.VISUAL_ID:
				return new MergeNodeEditPart(view);

			case MergeNodeAppliedStereotypeEditPart.VISUAL_ID:
				return new MergeNodeAppliedStereotypeEditPart(view);

			case ForkNodeEditPart.VISUAL_ID:
				return new ForkNodeEditPart(view);

			case ForkNodeAppliedStereotypeEditPart.VISUAL_ID:
				return new ForkNodeAppliedStereotypeEditPart(view);

			case JoinNodeEditPart.VISUAL_ID:
				return new JoinNodeEditPart(view);

			case JoinSpecEditPart.VISUAL_ID:
				return new JoinSpecEditPart(view);

			case JoinNodeAppliedStereotypeEditPart.VISUAL_ID:
				return new JoinNodeAppliedStereotypeEditPart(view);

			case SendObjectActionEditPart.VISUAL_ID:
				return new SendObjectActionEditPart(view);

			case SendObjectActionNameEditPart.VISUAL_ID:
				return new SendObjectActionNameEditPart(view);

			case ValuePinInSendObjActAsReqEditPart.VISUAL_ID:
				return new ValuePinInSendObjActAsReqEditPart(view);

			case ValuePinInSendObjActAsReqLabelEditPart.VISUAL_ID:
				return new ValuePinInSendObjActAsReqLabelEditPart(view);

			case ValuePinInSendObjActAsReqValueEditPart.VISUAL_ID:
				return new ValuePinInSendObjActAsReqValueEditPart(view);

			case ValuePinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID:
				return new ValuePinInSendObjActAsReqAppliedStereotypeEditPart(view);

			case ActionInputPinInSendObjActAsReqEditPart.VISUAL_ID:
				return new ActionInputPinInSendObjActAsReqEditPart(view);

			case ActionInputPinInSendObjActAsReqLabelEditPart.VISUAL_ID:
				return new ActionInputPinInSendObjActAsReqLabelEditPart(view);

			case ActionInputPinInSendObjActAsReqValueEditPart.VISUAL_ID:
				return new ActionInputPinInSendObjActAsReqValueEditPart(view);

			case ActionInputPinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID:
				return new ActionInputPinInSendObjActAsReqAppliedStereotypeEditPart(view);

			case InputPinInSendObjActAsReqEditPart.VISUAL_ID:
				return new InputPinInSendObjActAsReqEditPart(view);

			case InputPinInSendObjActAsReqLabelEditPart.VISUAL_ID:
				return new InputPinInSendObjActAsReqLabelEditPart(view);

			case InputPinInSendObjActAsReqAppliedStereotypeEditPart.VISUAL_ID:
				return new InputPinInSendObjActAsReqAppliedStereotypeEditPart(view);

			case ValuePinInSendObjActAsTargetEditPart.VISUAL_ID:
				return new ValuePinInSendObjActAsTargetEditPart(view);

			case ValuePinInSendObjActAsTargetLabelEditPart.VISUAL_ID:
				return new ValuePinInSendObjActAsTargetLabelEditPart(view);

			case ValuePinInSendObjActAsTargetValueEditPart.VISUAL_ID:
				return new ValuePinInSendObjActAsTargetValueEditPart(view);

			case ValuePinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
				return new ValuePinInSendObjActAsTargetAppliedStereotypeEditPart(view);

			case ActionInputPinInSendObjActAsTargetEditPart.VISUAL_ID:
				return new ActionInputPinInSendObjActAsTargetEditPart(view);

			case ActionInputPinInSendObjActAsTargetLabelEditPart.VISUAL_ID:
				return new ActionInputPinInSendObjActAsTargetLabelEditPart(view);

			case ActionInputPinInSendObjActAsTargetValueEditPart.VISUAL_ID:
				return new ActionInputPinInSendObjActAsTargetValueEditPart(view);

			case ActionInputPinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
				return new ActionInputPinInSendObjActAsTargetAppliedStereotypeEditPart(view);

			case InputPinInSendObjActAsTargetEditPart.VISUAL_ID:
				return new InputPinInSendObjActAsTargetEditPart(view);

			case InputPinInSendObjActAsTargetLabelEditPart.VISUAL_ID:
				return new InputPinInSendObjActAsTargetLabelEditPart(view);

			case InputPinInSendObjActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
				return new InputPinInSendObjActAsTargetAppliedStereotypeEditPart(view);

			case SendSignalActionEditPart.VISUAL_ID:
				return new SendSignalActionEditPart(view);

			case SendSignalActionNameEditPart.VISUAL_ID:
				return new SendSignalActionNameEditPart(view);

			case ActionInputPinInSendSigActEditPart.VISUAL_ID:
				return new ActionInputPinInSendSigActEditPart(view);

			case ActionInputPinInSendSigActLabelEditPart.VISUAL_ID:
				return new ActionInputPinInSendSigActLabelEditPart(view);

			case ActionInputPinInSendSigActValueEditPart.VISUAL_ID:
				return new ActionInputPinInSendSigActValueEditPart(view);

			case ActionInputPinInSendSigActAppliedStereotypeEditPart.VISUAL_ID:
				return new ActionInputPinInSendSigActAppliedStereotypeEditPart(view);

			case ValuePinInSendSigActEditPart.VISUAL_ID:
				return new ValuePinInSendSigActEditPart(view);

			case ValuePinInSendSigActLabelEditPart.VISUAL_ID:
				return new ValuePinInSendSigActLabelEditPart(view);

			case ValuePinInSendSigActValueEditPart.VISUAL_ID:
				return new ValuePinInSendSigActValueEditPart(view);

			case ValuePinInSendSigActAppliedStereotypeEditPart.VISUAL_ID:
				return new ValuePinInSendSigActAppliedStereotypeEditPart(view);

			case InputPinInSendSigActEditPart.VISUAL_ID:
				return new InputPinInSendSigActEditPart(view);

			case InputPinInSendSigActLabelEditPart.VISUAL_ID:
				return new InputPinInSendSigActLabelEditPart(view);

			case InputPinInSendSigActAppliedStereotypeEditPart.VISUAL_ID:
				return new InputPinInSendSigActAppliedStereotypeEditPart(view);

			case ValuePinInSendSigActAsTargetEditPart.VISUAL_ID:
				return new ValuePinInSendSigActAsTargetEditPart(view);

			case ValuePinInSendSigActAsTargetLabelEditPart.VISUAL_ID:
				return new ValuePinInSendSigActAsTargetLabelEditPart(view);

			case ValuePinInSendSigActAsTargetValueEditPart.VISUAL_ID:
				return new ValuePinInSendSigActAsTargetValueEditPart(view);

			case ValuePinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
				return new ValuePinInSendSigActAsTargetAppliedStereotypeEditPart(view);

			case ActionInputPinInSendSigActAsTargetEditPart.VISUAL_ID:
				return new ActionInputPinInSendSigActAsTargetEditPart(view);

			case ActionInputPinInSendSigActAsTargetLabelEditPart.VISUAL_ID:
				return new ActionInputPinInSendSigActAsTargetLabelEditPart(view);

			case ActionInputPinInSendSigActAsTargetValueEditPart.VISUAL_ID:
				return new ActionInputPinInSendSigActAsTargetValueEditPart(view);

			case ActionInputPinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
				return new ActionInputPinInSendSigActAsTargetAppliedStereotypeEditPart(view);

			case InputPinInSendSigActAsTargetEditPart.VISUAL_ID:
				return new InputPinInSendSigActAsTargetEditPart(view);

			case InputPinInSendSigActAsTargetLabelEditPart.VISUAL_ID:
				return new InputPinInSendSigActAsTargetLabelEditPart(view);

			case InputPinInSendSigActAsTargetAppliedStereotypeEditPart.VISUAL_ID:
				return new InputPinInSendSigActAsTargetAppliedStereotypeEditPart(view);

			case ActivityParameterNodeEditPart.VISUAL_ID:
				return new ActivityParameterNodeEditPart(view);

			case CenteredWrappedLabelEditPart.VISUAL_ID:
				return new CenteredWrappedLabelEditPart(view);

			case AcceptEventActionEditPart.VISUAL_ID:
				return new AcceptEventActionEditPart(view);

			case AcceptEventActionLabelEditPart.VISUAL_ID:
				return new AcceptEventActionLabelEditPart(view);

			case AcceptTimeEventActionLabelEditPart.VISUAL_ID:
				return new AcceptTimeEventActionLabelEditPart(view);

			case AcceptTimeEventActionAppliedStereotypeEditPart.VISUAL_ID:
				return new AcceptTimeEventActionAppliedStereotypeEditPart(view);

			case OutputPinInAcceptEventActionEditPart.VISUAL_ID:
				return new OutputPinInAcceptEventActionEditPart(view);

			case OutputPinInAcceptEventActionLabelEditPart.VISUAL_ID:
				return new OutputPinInAcceptEventActionLabelEditPart(view);

			case OutputPinInAcceptEventActionAppliedStereotypeEditPart.VISUAL_ID:
				return new OutputPinInAcceptEventActionAppliedStereotypeEditPart(view);

			case ConditionalNodeEditPart.VISUAL_ID:
				return new ConditionalNodeEditPart(view);

			case ConditionalNodeKeywordEditPart.VISUAL_ID:
				return new ConditionalNodeKeywordEditPart(view);

			case ExpansionRegionEditPart.VISUAL_ID:
				return new ExpansionRegionEditPart(view);

			case ExpansionRegionKeywordEditPart.VISUAL_ID:
				return new ExpansionRegionKeywordEditPart(view);

			case ExpansionNodeAsInEditPart.VISUAL_ID:
				return new ExpansionNodeAsInEditPart(view);

			case ExpansionNodeAsOutEditPart.VISUAL_ID:
				return new ExpansionNodeAsOutEditPart(view);

			case LoopNodeEditPart.VISUAL_ID:
				return new LoopNodeEditPart(view);

			case LoopNodeKeywordEditPart.VISUAL_ID:
				return new LoopNodeKeywordEditPart(view);

			case SequenceNodeEditPart.VISUAL_ID:
				return new SequenceNodeEditPart(view);

			case SequenceNodeKeywordEditPart.VISUAL_ID:
				return new SequenceNodeKeywordEditPart(view);

			case StructuredActivityNodeEditPart.VISUAL_ID:
				return new StructuredActivityNodeEditPart(view);

			case StructuredActivityNodeKeywordEditPart.VISUAL_ID:
				return new StructuredActivityNodeKeywordEditPart(view);

			case ActivityPartitionEditPart.VISUAL_ID:
				return new ActivityPartitionEditPart(view);

			case ActivityPartitionNameEditPart.VISUAL_ID:
				return new ActivityPartitionNameEditPart(view);

			case InterruptibleActivityRegionEditPart.VISUAL_ID:
				return new InterruptibleActivityRegionEditPart(view);

			case InitialNodeInIAREditPart.VISUAL_ID:
				return new InitialNodeInIAREditPart(view);

			case AppliedStereotypeWrappingLabelEditPart.VISUAL_ID:
				return new AppliedStereotypeWrappingLabelEditPart(view);

			case ActivityFinalNodeInIAREditPart.VISUAL_ID:
				return new ActivityFinalNodeInIAREditPart(view);

			case ActivityFinalNodeInIARAppliedStereotypeEditPart.VISUAL_ID:
				return new ActivityFinalNodeInIARAppliedStereotypeEditPart(view);

			case FlowFinalNodeInIAREditPart.VISUAL_ID:
				return new FlowFinalNodeInIAREditPart(view);

			case FlowFinalNodeInIARAppliedStereotypeEditPart.VISUAL_ID:
				return new FlowFinalNodeInIARAppliedStereotypeEditPart(view);

			case OpaqueActionInIAREditPart.VISUAL_ID:
				return new OpaqueActionInIAREditPart(view);

			case OpaqueActionInIARNameEditPart.VISUAL_ID:
				return new OpaqueActionInIARNameEditPart(view);

			case CallBehaviorActionInIAREditPart.VISUAL_ID:
				return new CallBehaviorActionInIAREditPart(view);

			case CallBehaviorActionInIARNameEditPart.VISUAL_ID:
				return new CallBehaviorActionInIARNameEditPart(view);

			case CallOperationActionInIAREditPart.VISUAL_ID:
				return new CallOperationActionInIAREditPart(view);

			case CallOperationActionInIARNameEditPart.VISUAL_ID:
				return new CallOperationActionInIARNameEditPart(view);

			case SendObjectActionInIAREditPart.VISUAL_ID:
				return new SendObjectActionInIAREditPart(view);

			case SendObjectActionInIARNameEditPart.VISUAL_ID:
				return new SendObjectActionInIARNameEditPart(view);

			case SendSignalActionInIAREditPart.VISUAL_ID:
				return new SendSignalActionInIAREditPart(view);

			case SendSignalActionInIARNameEditPart.VISUAL_ID:
				return new SendSignalActionInIARNameEditPart(view);

			case AcceptEventActionInIAREditPart.VISUAL_ID:
				return new AcceptEventActionInIAREditPart(view);

			case AcceptEventActionInIARLabelEditPart.VISUAL_ID:
				return new AcceptEventActionInIARLabelEditPart(view);

			case AcceptTimeEventActionInIARLabelEditPart.VISUAL_ID:
				return new AcceptTimeEventActionInIARLabelEditPart(view);

			case AcceptTimeEventActionInIARAppliedStereotypeEditPart.VISUAL_ID:
				return new AcceptTimeEventActionInIARAppliedStereotypeEditPart(view);

			case ValueSpecificationActionInIAREditPart.VISUAL_ID:
				return new ValueSpecificationActionInIAREditPart(view);

			case ValueSpecificationActionInIARNameEditPart.VISUAL_ID:
				return new ValueSpecificationActionInIARNameEditPart(view);

			case OutputPinInValSpecActEditPart.VISUAL_ID:
				return new OutputPinInValSpecActEditPart(view);

			case OutputPinInValSpecActLabelEditPart.VISUAL_ID:
				return new OutputPinInValSpecActLabelEditPart(view);

			case OutputPinInValSpecActAppliedStereotypeEditPart.VISUAL_ID:
				return new OutputPinInValSpecActAppliedStereotypeEditPart(view);

			case DecisionNodeInIAREditPart.VISUAL_ID:
				return new DecisionNodeInIAREditPart(view);

			case DecisionInputInIAREditPart.VISUAL_ID:
				return new DecisionInputInIAREditPart(view);

			case DecisionNodeInIARAppliedStereotypeEditPart.VISUAL_ID:
				return new DecisionNodeInIARAppliedStereotypeEditPart(view);

			case MergeNodeInIAREditPart.VISUAL_ID:
				return new MergeNodeInIAREditPart(view);

			case MergeNodeInIARAppliedStereotypeEditPart.VISUAL_ID:
				return new MergeNodeInIARAppliedStereotypeEditPart(view);

			case ForkNodeInIAREditPart.VISUAL_ID:
				return new ForkNodeInIAREditPart(view);

			case ForkNodeInIARAppliedStereotypeEditPart.VISUAL_ID:
				return new ForkNodeInIARAppliedStereotypeEditPart(view);

			case JoinNodeInIAREditPart.VISUAL_ID:
				return new JoinNodeInIAREditPart(view);

			case JoinSpecInIAREditPart.VISUAL_ID:
				return new JoinSpecInIAREditPart(view);

			case JoinNodeInIARAppliedStereotypeEditPart.VISUAL_ID:
				return new JoinNodeInIARAppliedStereotypeEditPart(view);

			case DataStoreNodeInIAREditPart.VISUAL_ID:
				return new DataStoreNodeInIAREditPart(view);

			case DataStoreNodeInIARLabelEditPart.VISUAL_ID:
				return new DataStoreNodeInIARLabelEditPart(view);

			case DataStoreInIARSelectionEditPart.VISUAL_ID:
				return new DataStoreInIARSelectionEditPart(view);

			case ValueSpecificationActionEditPart.VISUAL_ID:
				return new ValueSpecificationActionEditPart(view);

			case ValueSpecificationActionNameEditPart.VISUAL_ID:
				return new ValueSpecificationActionNameEditPart(view);

			case DataStoreNodeEditPart.VISUAL_ID:
				return new DataStoreNodeEditPart(view);

			case DataStoreNodeLabelEditPart.VISUAL_ID:
				return new DataStoreNodeLabelEditPart(view);

			case DataStoreSelectionEditPart.VISUAL_ID:
				return new DataStoreSelectionEditPart(view);

			case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
				return new ActivityActivityParametersCompartmentEditPart(view);

			case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
				return new ActivityActivityPreConditionsCompartmentEditPart(view);

			case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
				return new ActivityActivityPostConditionsCompartmentEditPart(view);

			case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
				return new ActivityActivityContentCompartmentEditPart(view);

			case ConditionalNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
				return new ConditionalNodeStructuredActivityNodeContentCompartmentEditPart(view);

			case ExpansionRegionStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
				return new ExpansionRegionStructuredActivityNodeContentCompartmentEditPart(view);

			case LoopNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
				return new LoopNodeStructuredActivityNodeContentCompartmentEditPart(view);

			case SequenceNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
				return new SequenceNodeStructuredActivityNodeContentCompartmentEditPart(view);

			case StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart.VISUAL_ID:
				return new StructuredActivityNodeStructuredActivityNodeContentCompartmentEditPart(view);

			case ActivityPartitionActivityPartitionContentCompartmentEditPart.VISUAL_ID:
				return new ActivityPartitionActivityPartitionContentCompartmentEditPart(view);

			case InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart.VISUAL_ID:
				return new InterruptibleActivityRegionInterruptibleActivityRegionContentCompartmentEditPart(view);

			case ActionLocalPreconditionEditPart.VISUAL_ID:
				return new ActionLocalPreconditionEditPart(view);


			case ActionLocalPostconditionEditPart.VISUAL_ID:
				return new ActionLocalPostconditionEditPart(view);


			case ObjectFlowEditPart.VISUAL_ID:
				return new ObjectFlowEditPart(view);

			case ObjectFlowNameEditPart.VISUAL_ID:
				return new ObjectFlowNameEditPart(view);

			case ObjectFlowWeightEditPart.VISUAL_ID:
				return new ObjectFlowWeightEditPart(view);

			case ObjectFlowSelectionEditPart.VISUAL_ID:
				return new ObjectFlowSelectionEditPart(view);

			case ObjectFlowTransformationEditPart.VISUAL_ID:
				return new ObjectFlowTransformationEditPart(view);

			case DecisionInputFlowEditPart.VISUAL_ID:
				return new DecisionInputFlowEditPart(view);

			case ObjectFlowGuardEditPart.VISUAL_ID:
				return new ObjectFlowGuardEditPart(view);

			case ObjectFlowAppliedStereotypeEditPart.VISUAL_ID:
				return new ObjectFlowAppliedStereotypeEditPart(view);


			case ControlFlowEditPart.VISUAL_ID:
				return new ControlFlowEditPart(view);

			case ControlFlowNameEditPart.VISUAL_ID:
				return new ControlFlowNameEditPart(view);

			case ControlFlowWeightEditPart.VISUAL_ID:
				return new ControlFlowWeightEditPart(view);

			case ControlFlowGuardEditPart.VISUAL_ID:
				return new ControlFlowGuardEditPart(view);

			case ControlFlowAppliedStereotypeEditPart.VISUAL_ID:
				return new ControlFlowAppliedStereotypeEditPart(view);


			case ExceptionHandlerEditPart.VISUAL_ID:
				return new ExceptionHandlerEditPart(view);

			case ExceptionHandlerTypeEditPart.VISUAL_ID:
				return new ExceptionHandlerTypeEditPart(view);

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
	 * @generated NOT handle LinkAndCornerBentWithTextFigure
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		if(source.getFigure() instanceof HTMLCornerBentFigure)
			return new CommentCellEditorLocator((HTMLCornerBentFigure)source.getFigure());
		else if(source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel)source.getFigure());
		else if(source.getFigure() instanceof DecisionInputEditPart.LinkAndCornerBentWithTextFigure) {
			return new TextCellEditorLocator(((DecisionInputEditPart.LinkAndCornerBentWithTextFigure)source.getFigure()).getCornerBentContent());
		} else if(source.getFigure() instanceof ObjectFlowSelectionEditPart.LinkAndCornerBentWithTextFigure) {
			return new TextCellEditorLocator(((ObjectFlowSelectionEditPart.LinkAndCornerBentWithTextFigure)source.getFigure()).getCornerBentContent());
		} else if(source.getFigure() instanceof ObjectFlowTransformationEditPart.LinkAndCornerBentWithTextFigure) {
			return new TextCellEditorLocator(((ObjectFlowTransformationEditPart.LinkAndCornerBentWithTextFigure)source.getFigure()).getCornerBentContent());
		} else {
			return new LabelCellEditorLocator((Label)source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class CommentCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private HTMLCornerBentFigure commentFigure;

		/**
		 * @generated
		 */
		public CommentCellEditorLocator(HTMLCornerBentFigure commentFigure) {
			this.commentFigure = commentFigure;
		}

		/**
		 * @generated
		 */
		public HTMLCornerBentFigure getCommentFigure() {
			return commentFigure;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getCommentFigure().getBounds().getCopy();
			getCommentFigure().translateToAbsolute(rect);
			if(getCommentFigure().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			}
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	static private class TextCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private WrappingLabel wrapLabel;

		/**
		 * @generated
		 */
		public TextCellEditorLocator(WrappingLabel wrapLabel) {
			this.wrapLabel = wrapLabel;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getWrapLabel() {
			return wrapLabel;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if(!text.getFont().isDisposed()) {
				if(getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
					rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
				} else {
					int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
					rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
				}
			}
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}

	/**
	 * @generated
	 */
	private static class LabelCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private Label label;

		/**
		 * @generated
		 */
		public LabelCellEditorLocator(Label label) {
			this.label = label;
		}

		/**
		 * @generated
		 */
		public Label getLabel() {
			return label;
		}

		/**
		 * @generated
		 */
		public void relocate(CellEditor celleditor) {
			Text text = (Text)celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			if(!text.getFont().isDisposed()) {
				int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
