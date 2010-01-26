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

			case ActivityFinalNodeEditPart.VISUAL_ID:
				return new ActivityFinalNodeEditPart(view);

			case FlowFinalNodeEditPart.VISUAL_ID:
				return new FlowFinalNodeEditPart(view);

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

			case ActionInputPinInOpaqueActEditPart.VISUAL_ID:
				return new ActionInputPinInOpaqueActEditPart(view);

			case ActionInputPinInOActLabelEditPart.VISUAL_ID:
				return new ActionInputPinInOActLabelEditPart(view);

			case ActionInputPinInOActValueEditPart.VISUAL_ID:
				return new ActionInputPinInOActValueEditPart(view);

			case InputPinInOpaqueActEditPart.VISUAL_ID:
				return new InputPinInOpaqueActEditPart(view);

			case InputPinInOActLabelEditPart.VISUAL_ID:
				return new InputPinInOActLabelEditPart(view);

			case OutputPinInOpaqueActEditPart.VISUAL_ID:
				return new OutputPinInOpaqueActEditPart(view);

			case OutputPinInOActLabelEditPart.VISUAL_ID:
				return new OutputPinInOActLabelEditPart(view);

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

			case ActionInputPinInCallBeActEditPart.VISUAL_ID:
				return new ActionInputPinInCallBeActEditPart(view);

			case ActionInputPinInCBActLabelEditPart.VISUAL_ID:
				return new ActionInputPinInCBActLabelEditPart(view);

			case ActionInputPinInCBActValueEditPart.VISUAL_ID:
				return new ActionInputPinInCBActValueEditPart(view);

			case InputPinInCallBeActEditPart.VISUAL_ID:
				return new InputPinInCallBeActEditPart(view);

			case InputPinInCBActLabelEditPart.VISUAL_ID:
				return new InputPinInCBActLabelEditPart(view);

			case OutputPinInCallBeActEditPart.VISUAL_ID:
				return new OutputPinInCallBeActEditPart(view);

			case OutputPinInCBActLabelEditPart.VISUAL_ID:
				return new OutputPinInCBActLabelEditPart(view);

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

			case ValuePinInCallOpActEditPart.VISUAL_ID:
				return new ValuePinInCallOpActEditPart(view);

			case ValuePinInCOActLabelEditPart.VISUAL_ID:
				return new ValuePinInCOActLabelEditPart(view);

			case ValuePinInCOActValueEditPart.VISUAL_ID:
				return new ValuePinInCOActValueEditPart(view);

			case InputPinInCallOpActEditPart.VISUAL_ID:
				return new InputPinInCallOpActEditPart(view);

			case InputPinInCOActLabelEditPart.VISUAL_ID:
				return new InputPinInCOActLabelEditPart(view);

			case OutputPinInCallOpActEditPart.VISUAL_ID:
				return new OutputPinInCallOpActEditPart(view);

			case OutputPinInCOActLabelEditPart.VISUAL_ID:
				return new OutputPinInCOActLabelEditPart(view);

			case ValuePinInCallOpActAsTargetEditPart.VISUAL_ID:
				return new ValuePinInCallOpActAsTargetEditPart(view);

			case ValuePinInCOActAsTargetLabelEditPart.VISUAL_ID:
				return new ValuePinInCOActAsTargetLabelEditPart(view);

			case ValuePinInCOActAsTargetValueEditPart.VISUAL_ID:
				return new ValuePinInCOActAsTargetValueEditPart(view);

			case ActionInputPinInCallOpActAsTargetEditPart.VISUAL_ID:
				return new ActionInputPinInCallOpActAsTargetEditPart(view);

			case ActionInputPinInCOActAsTargetLabelEditPart.VISUAL_ID:
				return new ActionInputPinInCOActAsTargetLabelEditPart(view);

			case ActionInputPinInCOActAsTargetValueEditPart.VISUAL_ID:
				return new ActionInputPinInCOActAsTargetValueEditPart(view);

			case InputPinInCallOpActAsTargetEditPart.VISUAL_ID:
				return new InputPinInCallOpActAsTargetEditPart(view);

			case InputPinInCOActAsTargetLabelEditPart.VISUAL_ID:
				return new InputPinInCOActAsTargetLabelEditPart(view);

			case ConstraintAsLocalPrecondEditPart.VISUAL_ID:
				return new ConstraintAsLocalPrecondEditPart(view);

			case ConstraintAsLocalPrecondNameEditPart.VISUAL_ID:
				return new ConstraintAsLocalPrecondNameEditPart(view);

			case ConstraintAsLocalPostcondEditPart.VISUAL_ID:
				return new ConstraintAsLocalPostcondEditPart(view);

			case ConstraintAsLocalPostcondNameEditPart.VISUAL_ID:
				return new ConstraintAsLocalPostcondNameEditPart(view);

			case ActivityAsSelectionEditPart.VISUAL_ID:
				return new ActivityAsSelectionEditPart(view);

			case ActivityAsSelectionNameEditPart.VISUAL_ID:
				return new ActivityAsSelectionNameEditPart(view);

			case ActivityAsTransformationEditPart.VISUAL_ID:
				return new ActivityAsTransformationEditPart(view);

			case ActivityAsTransformationNameEditPart.VISUAL_ID:
				return new ActivityAsTransformationNameEditPart(view);

			case ActivityActivityParametersCompartmentEditPart.VISUAL_ID:
				return new ActivityActivityParametersCompartmentEditPart(view);

			case ActivityActivityPreConditionsCompartmentEditPart.VISUAL_ID:
				return new ActivityActivityPreConditionsCompartmentEditPart(view);

			case ActivityActivityPostConditionsCompartmentEditPart.VISUAL_ID:
				return new ActivityActivityPostConditionsCompartmentEditPart(view);

			case ActivityActivityContentCompartmentEditPart.VISUAL_ID:
				return new ActivityActivityContentCompartmentEditPart(view);

			case ActionLocalPreconditionEditPart.VISUAL_ID:
				return new ActionLocalPreconditionEditPart(view);


			case ActionLocalPostconditionEditPart.VISUAL_ID:
				return new ActionLocalPostconditionEditPart(view);


			case ObjectFlowSelectionEditPart.VISUAL_ID:
				return new ObjectFlowSelectionEditPart(view);


			case ObjectFlowTransformationEditPart.VISUAL_ID:
				return new ObjectFlowTransformationEditPart(view);


			case ObjectFlowEditPart.VISUAL_ID:
				return new ObjectFlowEditPart(view);

			case ObjectFlowNameEditPart.VISUAL_ID:
				return new ObjectFlowNameEditPart(view);

			case ObjectFlowWeightEditPart.VISUAL_ID:
				return new ObjectFlowWeightEditPart(view);


			case ControlFlowEditPart.VISUAL_ID:
				return new ControlFlowEditPart(view);

			case ControlFlowNameEditPart.VISUAL_ID:
				return new ControlFlowNameEditPart(view);

			case ControlFlowWeightEditPart.VISUAL_ID:
				return new ControlFlowWeightEditPart(view);

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
		if(source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel)source.getFigure());
		else {
			return new LabelCellEditorLocator((Label)source.getFigure());
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
			if(getWrapLabel().isTextWrapOn() && getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width, SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
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
			int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
