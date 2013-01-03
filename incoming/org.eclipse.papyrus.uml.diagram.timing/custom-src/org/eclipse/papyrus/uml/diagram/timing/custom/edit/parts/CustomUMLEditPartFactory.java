/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.parts;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactLifelineTimeRulerCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.CompactStateInvariantNameEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DestructionOccurrenceSpecificationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationConstraintEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.DurationObservationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FreeTimeRulerCompartmentEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FreeTimingRulerEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineStateDefinitionCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimeRulerCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullLifelineTimelineCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.FullStateInvariantVerticalLineEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GateEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.GeneralOrderingEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionCompartmentEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageFoundEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageLostEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.MessageOccurrenceSpecificationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.OccurrenceSpecificationLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.StateDefinitionLabelEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TickEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeConstraintEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeObservationEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimeRulerCompartmentEditPartCN;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.TimingDiagramEditPart;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.UMLEditPartFactory;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;

public class CustomUMLEditPartFactory extends UMLEditPartFactory {
	@Override
	public EditPart createEditPart(final EditPart context, final Object model) {
		if (model instanceof View) {
			final View view = (View) model;
			final int visualID = UMLVisualIDRegistry.getVisualID(view);
			switch (visualID) {
			case TimingDiagramEditPart.VISUAL_ID:// 1
				return new CustomTimingDiagramEditPart(view);
			case InteractionEditPartTN.VISUAL_ID:// 2
				return new CustomInteractionEditPartTN(view);
			case InteractionCompartmentEditPartTN.VISUAL_ID:// 5
				return new CustomInteractionCompartmentEditPartTN(view);
			case FullLifelineStateDefinitionCompartmentEditPartCN.VISUAL_ID: // 7
				return new CustomFullLifelineStateDefinitionCompartmentEditPartCN(view);
			case FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID: // 8
				return new CustomFullLifelineTimelineCompartmentEditPartCN(view);
			case StateDefinitionEditPart.VISUAL_ID:// 9
				return new CustomStateDefinitionEditPart(view);
			case OccurrenceSpecificationLabelEditPart.VISUAL_ID: // 10
				return new CustomOccurrenceSpecificationLabelEditPart(view);
			case FullStateInvariantEditPartCN.VISUAL_ID: // 11
				return new CustomFullStateInvariantEditPartCN(view);
			case OccurrenceSpecificationEditPartCN.VISUAL_ID: // 12
				return new CustomOccurrenceSpecificationEditPartCN(view);
			case MessageOccurrenceSpecificationEditPartCN.VISUAL_ID: // 13
				return new CustomMessageOccurrenceSpecificationEditPartCN(view);
			case MessageOccurrenceSpecificationLabelEditPart.VISUAL_ID: // 14
				return new CustomMessageOccurrenceSpecificationLabelEditPart(view);
			case TimeConstraintEditPart.VISUAL_ID: // 15
				return new CustomTimeConstraintEditPart(view);
			case TimeObservationEditPart.VISUAL_ID: // 16
				return new CustomTimeObservationEditPart(view);
			case DurationObservationEditPartCN.VISUAL_ID: // 17
				return new CustomDurationObservationEditPart(view);
			case DurationConstraintEditPartCN.VISUAL_ID: // 18
				return new CustomDurationConstraintEditPart(view);
			case FullLifelineEditPartCN.VISUAL_ID:// 19
				return new CustomFullLifelineEditPartCN(view);
			case CompactLifelineEditPartCN.VISUAL_ID:// 20
				return new CustomCompactLifelineEditPartCN(view);
			case CompactLifelineCompartmentEditPartCN.VISUAL_ID:// 23
				return new CustomCompactLifelineCompartmentEditPart(view);
			case FreeTimingRulerEditPartCN.VISUAL_ID: // 24
				return new CustomFreeTimingRulerEditPart(view);
			case TickEditPart.VISUAL_ID: // 26
				return new CustomTickEditPart(view);
			case DestructionOccurrenceSpecificationEditPartCN.VISUAL_ID: // 27
				return new CustomDestructionOccurrenceSpecificationEditPartCN(view);
			case CompactStateInvariantEditPartCN.VISUAL_ID:// 28
				return new CustomCompactStateInvariantEditPartCN(view);
			case TimeRulerCompartmentEditPartCN.VISUAL_ID: // 29
				return new CustomTimeRulerCompartmentEditPartCN(view);
			case CompactStateInvariantNameEditPart.VISUAL_ID:// 31
				return new CustomCompactStateInvariantNameEditPart(view);
			case DestructionOccurrenceSpecificationLabelEditPart.VISUAL_ID: // 32
				return new CustomDestructionOccurrenceSpecificationLabelEditPart(view);
			case StateDefinitionLabelEditPart.VISUAL_ID:// 38
				return new CustomStateDefinitionLabelEditPart(view);
			case FullStateInvariantVerticalLineEditPart.VISUAL_ID:// 39
				return new CustomFullStateInvariantVerticalLineEditPart(view);
			case MessageLostEditPart.VISUAL_ID: // 50
				return new CustomMessageLostEditPart(view);
			case MessageFoundEditPart.VISUAL_ID: // 53
				return new CustomMessageFoundEditPart(view);
			case GeneralOrderingEditPart.VISUAL_ID: // 67
				return new CustomGeneralOrderingEditPart(view);
			case GateEditPart.VISUAL_ID: // 69
				return new CustomGateEditPart(view);
			case FreeTimeRulerCompartmentEditPart.VISUAL_ID: // 80
				return new CustomFreeTimeRulerCompartmentEditPart(view);
			case FullLifelineTimeRulerCompartmentEditPartCN.VISUAL_ID: // 82
				return new CustomFullLifelineTimeRulerCompartmentEditPartCN(view);
			case CompactLifelineTimeRulerCompartmentEditPartCN.VISUAL_ID: // 83
				return new CustomCompactLifelineTimeRulerCompartmentEditPartCN(view);
			default:
				// when adding cases to this switch, also add the corresponding IDs in the extension
				// org.eclipse.gmf.runtime.diagram.ui.editpartProviders
			}
		}
		return super.createEditPart(context, model);
	}

	// getTextCellEditorLocator is modified in the super class instead of overridden because it is static
}
