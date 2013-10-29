/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.providers;

import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Connector;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.*;
import org.eclipse.papyrus.uml.diagram.sequence.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomEditPartProvider extends UMLEditPartProvider {

	@Override
	protected IGraphicalEditPart createEditPart(View view) {
		IGraphicalEditPart customEditPart = createCustomEditPart(view);
		if(customEditPart != null) {
			return customEditPart;
		}
		return super.createEditPart(view);
	}

	protected IGraphicalEditPart createCustomEditPart(View view) {
		if(GateEditPart.GATE_TYPE.equals(view.getType())) {
			return new GateEditPart(view);
		} else if(GateNameEditPart.GATE_NAME_TYPE.equals(view.getType())) {
			return new GateNameEditPart(view);
		} else if(InteractionOperandGuardEditPart.GUARD_TYPE.equals(view.getType())) {
			return new InteractionOperandGuardEditPart(view);
		} else if(BehaviorExecutionSpecificationBehaviorEditPart.BEHAVIOR_TYPE.equals(view.getType())) {
			return new BehaviorExecutionSpecificationBehaviorEditPart(view);
		}
		if(view instanceof Connector) {
			if(((Connector)view).getType().equals(SequenceUtil.OBSERVATION_LINK_TYPE))
				return new ObservationLinkEditPart((View)view);
		}
		switch(UMLVisualIDRegistry.getVisualID(view)) {
		case PackageEditPart.VISUAL_ID:
			return new CustomPackageEditPart(view);
		case InteractionEditPart.VISUAL_ID:
			return new CustomInteractionEditPart(view);
		case InteractionNameEditPart.VISUAL_ID:
			return new CustomInteractionNameEditPart(view);
		case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
			return new CustomConsiderIgnoreFragmentEditPart(view);
		case CombinedFragmentEditPart.VISUAL_ID:
			return new CustomCombinedFragmentEditPart(view);
		case InteractionOperandEditPart.VISUAL_ID:
			return new CustomInteractionOperandEditPart(view);
		case InteractionUseEditPart.VISUAL_ID:
			return new CustomInteractionUseEditPart(view);
		case InteractionUseNameEditPart.VISUAL_ID:
			return new CustomInteractionUseNameEditPart(view);
		case InteractionUseName2EditPart.VISUAL_ID:
			return new CustomInteractionUseName2EditPart(view);
		case ContinuationEditPart.VISUAL_ID:
			return new CustomContinuationEditPart(view);
		case LifelineEditPart.VISUAL_ID:
			return new CustomLifelineEditPart(view);
		case LifelineNameEditPart.VISUAL_ID:
			return new CustomLifelineNameEditPart(view);
		case ActionExecutionSpecificationEditPart.VISUAL_ID:
			return new CustomActionExecutionSpecificationEditPart(view);
		case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
			return new CustomBehaviorExecutionSpecificationEditPart(view);
		case StateInvariantEditPart.VISUAL_ID:
			return new CustomStateInvariantEditPart(view);
		case CombinedFragment2EditPart.VISUAL_ID:
			return new CustomCombinedFragment2EditPart(view);
		case TimeConstraintEditPart.VISUAL_ID:
			return new CustomTimeConstraintEditPart(view);
		case TimeConstraintAppliedStereotypeEditPart.VISUAL_ID:
			return new CustomTimeConstraintAppliedStereotypeEditPart(view);
		case TimeObservationEditPart.VISUAL_ID:
			return new CustomTimeObservationEditPart(view);
		case TimeObservationLabelEditPart.VISUAL_ID:
			return new CustomTimeObservationLabelEditPart(view);
		case TimeObservationAppliedStereotypeEditPart.VISUAL_ID:
			return new CustomTimeObservationAppliedStereotypeEditPart(view);
		case DurationConstraintEditPart.VISUAL_ID:
			return new CustomDurationConstraintEditPart(view);
		case DurationConstraintAppliedStereotypeEditPart.VISUAL_ID:
			return new CustomDurationConstraintAppliedStereotypeEditPart(view);
		case DestructionOccurrenceSpecificationEditPart.VISUAL_ID:
			return new CustomDestructionOccurrenceSpecificationEditPart(view);
		case ConstraintEditPart.VISUAL_ID:
			return new CustomConstraintEditPart(view);
		case Constraint2EditPart.VISUAL_ID:
			return new CustomConstraint2EditPart(view);
		case CommentEditPart.VISUAL_ID:
			return new CustomCommentEditPart(view);
		case CommentBodyEditPart.VISUAL_ID:
			return new CustomCommentBodyEditPart(view);
		case DurationConstraintInMessageEditPart.VISUAL_ID:
			return new CustomDurationConstraintInMessageEditPart(view);
		case DurationConstraintInMessageAppliedStereotypeEditPart.VISUAL_ID:
			return new CustomDurationConstraintInMessageAppliedStereotypeEditPart(view);
		case DurationObservationEditPart.VISUAL_ID:
			return new CustomDurationObservationEditPart(view);
		case DurationObservationAppliedStereotypeEditPart.VISUAL_ID:
			return new CustomDurationObservationAppliedStereotypeEditPart(view);
		case InteractionInteractionCompartmentEditPart.VISUAL_ID:
			return new CustomInteractionInteractionCompartmentEditPart(view);
		case CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID:
			return new CustomCombinedFragmentCombinedFragmentCompartmentEditPart(view);
		case MessageEditPart.VISUAL_ID:
			return new CustomMessageEditPart(view);
		case MessageNameEditPart.VISUAL_ID:
			return new CustomMessageNameEditPart(view);
		case Message2EditPart.VISUAL_ID:
			return new CustomMessage2EditPart(view);
		case MessageName2EditPart.VISUAL_ID:
			return new CustomMessageName2EditPart(view);
		case Message3EditPart.VISUAL_ID:
			return new CustomMessage3EditPart(view);
		case MessageName3EditPart.VISUAL_ID:
			return new CustomMessageName3EditPart(view);
		case Message4EditPart.VISUAL_ID:
			return new CustomMessage4EditPart(view);
		case MessageName4EditPart.VISUAL_ID:
			return new CustomMessageName4EditPart(view);
		case Message5EditPart.VISUAL_ID:
			return new CustomMessage5EditPart(view);
		case MessageName5EditPart.VISUAL_ID:
			return new CustomMessageName5EditPart(view);
		case Message6EditPart.VISUAL_ID:
			return new CustomMessage6EditPart(view);
		case MessageName6EditPart.VISUAL_ID:
			return new CustomMessageName6EditPart(view);
		case Message7EditPart.VISUAL_ID:
			return new CustomMessage7EditPart(view);
		case MessageName7EditPart.VISUAL_ID:
			return new CustomMessageName7EditPart(view);
		case CommentAnnotatedElementEditPart.VISUAL_ID:
			return new CustomCommentAnnotatedElementEditPart(view);
		case ConstraintConstrainedElementEditPart.VISUAL_ID:
			return new CustomConstraintConstrainedElementEditPart(view);
		case GeneralOrderingEditPart.VISUAL_ID:
			return new CustomGeneralOrderingEditPart(view);
		case ExecutionSpecificationEndEditPart.VISUAL_ID:
			return new ExecutionSpecificationEndEditPart(view);
		case MessageEndEditPart.VISUAL_ID:
			return new MessageEndEditPart(view);
		}
		return null;
	}
}
