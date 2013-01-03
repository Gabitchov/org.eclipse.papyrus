/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.edit.parts;

import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.LabelCellEditorLocator;
import org.eclipse.gmf.tooling.runtime.directedit.locator.TextCellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure;
import org.eclipse.papyrus.uml.diagram.timing.custom.LifelineVerticalLabelCellEditorLocator;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.LifelineVerticalLabel;
import org.eclipse.papyrus.uml.diagram.timing.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class UMLEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(final EditPart context, final Object model) {
		if (model instanceof View) {
			final View view = (View) model;
			switch (UMLVisualIDRegistry.getVisualID(view)) {

			case TimingDiagramEditPart.VISUAL_ID:
				return new TimingDiagramEditPart(view);

			case InteractionEditPartTN.VISUAL_ID:
				return new InteractionEditPartTN(view);

			case InteractionNameEditPart.VISUAL_ID:
				return new InteractionNameEditPart(view);

			case FullLifelineEditPartCN.VISUAL_ID:
				return new FullLifelineEditPartCN(view);

			case FullLifelineNameEditPart.VISUAL_ID:
				return new FullLifelineNameEditPart(view);

			case CompactLifelineEditPartCN.VISUAL_ID:
				return new CompactLifelineEditPartCN(view);

			case CompactLifelineNameEditPart.VISUAL_ID:
				return new CompactLifelineNameEditPart(view);

			case FullStateInvariantEditPartCN.VISUAL_ID:
				return new FullStateInvariantEditPartCN(view);

			case FullStateInvariantAppliedStereotypeEditPart.VISUAL_ID:
				return new FullStateInvariantAppliedStereotypeEditPart(view);

			case CompactStateInvariantEditPartCN.VISUAL_ID:
				return new CompactStateInvariantEditPartCN(view);

			case CompactStateInvariantNameEditPart.VISUAL_ID:
				return new CompactStateInvariantNameEditPart(view);

			case StateInvariantAppliedStereotypeEditPart.VISUAL_ID:
				return new StateInvariantAppliedStereotypeEditPart(view);

			case OccurrenceSpecificationEditPartCN.VISUAL_ID:
				return new OccurrenceSpecificationEditPartCN(view);

			case OccurrenceSpecificationLabelEditPart.VISUAL_ID:
				return new OccurrenceSpecificationLabelEditPart(view);

			case OccurrenceSpecificationAppliedStereotypeEditPart.VISUAL_ID:
				return new OccurrenceSpecificationAppliedStereotypeEditPart(view);

			case MessageOccurrenceSpecificationEditPartCN.VISUAL_ID:
				return new MessageOccurrenceSpecificationEditPartCN(view);

			case MessageOccurrenceSpecificationLabelEditPart.VISUAL_ID:
				return new MessageOccurrenceSpecificationLabelEditPart(view);

			case MessageOccurrenceSpecificationAppliedStereotypeEditPart.VISUAL_ID:
				return new MessageOccurrenceSpecificationAppliedStereotypeEditPart(view);

			case StateDefinitionEditPart.VISUAL_ID:
				return new StateDefinitionEditPart(view);

			case StateDefinitionLabelEditPart.VISUAL_ID:
				return new StateDefinitionLabelEditPart(view);

			case FullStateInvariantVerticalLineEditPart.VISUAL_ID:
				return new FullStateInvariantVerticalLineEditPart(view);

			case TimeConstraintEditPart.VISUAL_ID:
				return new TimeConstraintEditPart(view);

			case TimeConstraintSpecificationEditPart.VISUAL_ID:
				return new TimeConstraintSpecificationEditPart(view);

			case TimeConstraintAppliedStereotypeEditPart.VISUAL_ID:
				return new TimeConstraintAppliedStereotypeEditPart(view);

			case TimeObservationEditPart.VISUAL_ID:
				return new TimeObservationEditPart(view);

			case TimeObservationNameEditPart.VISUAL_ID:
				return new TimeObservationNameEditPart(view);

			case TimeObservationAppliedStereotypeEditPart.VISUAL_ID:
				return new TimeObservationAppliedStereotypeEditPart(view);

			case DurationConstraintEditPartCN.VISUAL_ID:
				return new DurationConstraintEditPartCN(view);

			case DurationConstraintSpecificationEditPart.VISUAL_ID:
				return new DurationConstraintSpecificationEditPart(view);

			case DurationObservationEditPartCN.VISUAL_ID:
				return new DurationObservationEditPartCN(view);

			case DurationObservationNameEditPart.VISUAL_ID:
				return new DurationObservationNameEditPart(view);

			case GeneralOrderingEditPart.VISUAL_ID:
				return new GeneralOrderingEditPart(view);

			case GeneralOrderingNameEditPart.VISUAL_ID:
				return new GeneralOrderingNameEditPart(view);

			case FreeTimingRulerEditPartCN.VISUAL_ID:
				return new FreeTimingRulerEditPartCN(view);

			case LinearTimingRulerEditPartCN.VISUAL_ID:
				return new LinearTimingRulerEditPartCN(view);

			case TickEditPart.VISUAL_ID:
				return new TickEditPart(view);

			case TickNameEditPart.VISUAL_ID:
				return new TickNameEditPart(view);

			case DestructionOccurrenceSpecificationEditPartCN.VISUAL_ID:
				return new DestructionOccurrenceSpecificationEditPartCN(view);

			case DestructionOccurrenceSpecificationLabelEditPart.VISUAL_ID:
				return new DestructionOccurrenceSpecificationLabelEditPart(view);

			case DestructionOccurrenceSpecificationAppliedStereotypeEditPart.VISUAL_ID:
				return new DestructionOccurrenceSpecificationAppliedStereotypeEditPart(view);

			case LifelineEditPart.VISUAL_ID:
				return new LifelineEditPart(view);

			case GateEditPart.VISUAL_ID:
				return new GateEditPart(view);

			case GateLabelEditPart.VISUAL_ID:
				return new GateLabelEditPart(view);

			case InteractionCompartmentEditPartTN.VISUAL_ID:
				return new InteractionCompartmentEditPartTN(view);

			case FullLifelineStateDefinitionCompartmentEditPartCN.VISUAL_ID:
				return new FullLifelineStateDefinitionCompartmentEditPartCN(view);

			case FullLifelineTimelineCompartmentEditPartCN.VISUAL_ID:
				return new FullLifelineTimelineCompartmentEditPartCN(view);

			case CompactLifelineCompartmentEditPartCN.VISUAL_ID:
				return new CompactLifelineCompartmentEditPartCN(view);

			case TimeRulerCompartmentEditPartCN.VISUAL_ID:
				return new TimeRulerCompartmentEditPartCN(view);

			case FullLifelineTimeRulerCompartmentEditPartCN.VISUAL_ID:
				return new FullLifelineTimeRulerCompartmentEditPartCN(view);

			case CompactLifelineTimeRulerCompartmentEditPartCN.VISUAL_ID:
				return new CompactLifelineTimeRulerCompartmentEditPartCN(view);

			case FreeTimeRulerCompartmentEditPart.VISUAL_ID:
				return new FreeTimeRulerCompartmentEditPart(view);

			case LinearTimeRulerCompartmentEditPart.VISUAL_ID:
				return new LinearTimeRulerCompartmentEditPart(view);

			case MessageSyncEditPart.VISUAL_ID:
				return new MessageSyncEditPart(view);

			case MessageSyncNameLabelEditPart.VISUAL_ID:
				return new MessageSyncNameLabelEditPart(view);

			case MessageSyncAppliedStereotypeEditPart.VISUAL_ID:
				return new MessageSyncAppliedStereotypeEditPart(view);

			case MessageAsyncEditPart.VISUAL_ID:
				return new MessageAsyncEditPart(view);

			case MessageAsyncNameLabelEditPart.VISUAL_ID:
				return new MessageAsyncNameLabelEditPart(view);

			case MessageAsyncAppliedStereotypeEditPart.VISUAL_ID:
				return new MessageAsyncAppliedStereotypeEditPart(view);

			case MessageReplyEditPart.VISUAL_ID:
				return new MessageReplyEditPart(view);

			case MessageReplyNameLabelEditPart.VISUAL_ID:
				return new MessageReplyNameLabelEditPart(view);

			case MessageReplyAppliedStereotypeEditPart.VISUAL_ID:
				return new MessageReplyAppliedStereotypeEditPart(view);

			case MessageCreateEditPart.VISUAL_ID:
				return new MessageCreateEditPart(view);

			case MessageCreateNameLabelEditPart.VISUAL_ID:
				return new MessageCreateNameLabelEditPart(view);

			case MessageCreateAppliedStereotypeEditPart.VISUAL_ID:
				return new MessageCreateAppliedStereotypeEditPart(view);

			case MessageDeleteEditPart.VISUAL_ID:
				return new MessageDeleteEditPart(view);

			case MessageDeleteNameLabelEditPart.VISUAL_ID:
				return new MessageDeleteNameLabelEditPart(view);

			case MessageDeleteAppliedStereotypeEditPart.VISUAL_ID:
				return new MessageDeleteAppliedStereotypeEditPart(view);

			case MessageLostEditPart.VISUAL_ID:
				return new MessageLostEditPart(view);

			case MessageLostNameLabelEditPart.VISUAL_ID:
				return new MessageLostNameLabelEditPart(view);

			case MessageLostAppliedStereotypeEditPart.VISUAL_ID:
				return new MessageLostAppliedStereotypeEditPart(view);

			case MessageFoundEditPart.VISUAL_ID:
				return new MessageFoundEditPart(view);

			case MessageFoundNameLabelEditPart.VISUAL_ID:
				return new MessageFoundNameLabelEditPart(view);

			case MessageFoundAppliedStereotypeEditPart.VISUAL_ID:
				return new MessageFoundAppliedStereotypeEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(final EditPart context, final Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated NOT
	 */
	public static CellEditorLocator getTextCellEditorLocator(final ITextAwareEditPart source) {
		if (source.getFigure() instanceof IMultilineEditableFigure) {
			return new MultilineCellEditorLocator((IMultilineEditableFigure) source.getFigure());
		} else if (source.getFigure() instanceof WrappingLabel) {
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		} else if (source.getFigure() instanceof LifelineVerticalLabel) {
			return new LifelineVerticalLabelCellEditorLocator((LifelineVerticalLabel) source.getFigure());
		} else {
			return new LabelCellEditorLocator((Label) source.getFigure());
		}
	}

	/**
	 * @generated
	 */
	static private class MultilineCellEditorLocator implements CellEditorLocator {

		/**
		 * @generated
		 */
		private final IMultilineEditableFigure multilineEditableFigure;

		/**
		 * @generated
		 */
		public MultilineCellEditorLocator(final IMultilineEditableFigure figure) {
			this.multilineEditableFigure = figure;
		}

		/**
		 * @generated
		 */
		public IMultilineEditableFigure getMultilineEditableFigure() {
			return this.multilineEditableFigure;
		}

		/**
		 * @generated
		 */
		public void relocate(final CellEditor celleditor) {
			final Text text = (Text) celleditor.getControl();
			final Rectangle rect = getMultilineEditableFigure().getBounds().getCopy();
			rect.x = getMultilineEditableFigure().getEditionLocation().x;
			rect.y = getMultilineEditableFigure().getEditionLocation().y;
			getMultilineEditableFigure().translateToAbsolute(rect);
			if (getMultilineEditableFigure().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
