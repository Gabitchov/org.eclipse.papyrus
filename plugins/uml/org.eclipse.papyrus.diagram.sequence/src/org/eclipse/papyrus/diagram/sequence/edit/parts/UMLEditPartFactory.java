/*****************************************************************************
 * Copyright (c) 2009 CEA
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
package org.eclipse.papyrus.diagram.sequence.edit.parts;

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
import org.eclipse.papyrus.diagram.common.figure.node.HTMLCornerBentFigure;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;
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

			case PackageEditPart.VISUAL_ID:
				return new PackageEditPart(view);

			case InteractionEditPart.VISUAL_ID:
				return new InteractionEditPart(view);

			case InteractionNameEditPart.VISUAL_ID:
				return new InteractionNameEditPart(view);

			case ConsiderIgnoreFragmentEditPart.VISUAL_ID:
				return new ConsiderIgnoreFragmentEditPart(view);

			case CombinedFragmentEditPart.VISUAL_ID:
				return new CombinedFragmentEditPart(view);

			case InteractionOperandEditPart.VISUAL_ID:
				return new InteractionOperandEditPart(view);

			case InteractionUseEditPart.VISUAL_ID:
				return new InteractionUseEditPart(view);

			case InteractionUseNameEditPart.VISUAL_ID:
				return new InteractionUseNameEditPart(view);

			case InteractionUseName2EditPart.VISUAL_ID:
				return new InteractionUseName2EditPart(view);

			case ContinuationEditPart.VISUAL_ID:
				return new ContinuationEditPart(view);

			case ContinuationNameEditPart.VISUAL_ID:
				return new ContinuationNameEditPart(view);

			case LifelineEditPart.VISUAL_ID:
				return new LifelineEditPart(view);

			case LifelineNameEditPart.VISUAL_ID:
				return new LifelineNameEditPart(view);

			case ActionExecutionSpecificationEditPart.VISUAL_ID:
				return new ActionExecutionSpecificationEditPart(view);

			case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
				return new BehaviorExecutionSpecificationEditPart(view);

			case StateInvariantEditPart.VISUAL_ID:
				return new StateInvariantEditPart(view);

			case StateInvariantNameEditPart.VISUAL_ID:
				return new StateInvariantNameEditPart(view);

			case CombinedFragment2EditPart.VISUAL_ID:
				return new CombinedFragment2EditPart(view);

			case TimeConstraintEditPart.VISUAL_ID:
				return new TimeConstraintEditPart(view);

			case TimeConstraintLabelEditPart.VISUAL_ID:
				return new TimeConstraintLabelEditPart(view);

			case TimeObservationEditPart.VISUAL_ID:
				return new TimeObservationEditPart(view);

			case TimeObservationLabelEditPart.VISUAL_ID:
				return new TimeObservationLabelEditPart(view);

			case DurationConstraintEditPart.VISUAL_ID:
				return new DurationConstraintEditPart(view);

			case DurationConstraintLabelEditPart.VISUAL_ID:
				return new DurationConstraintLabelEditPart(view);

			case DestructionEventEditPart.VISUAL_ID:
				return new DestructionEventEditPart(view);

			case ConstraintEditPart.VISUAL_ID:
				return new ConstraintEditPart(view);

			case ConstraintNameEditPart.VISUAL_ID:
				return new ConstraintNameEditPart(view);

			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);

			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);

			case DurationConstraintInMessageEditPart.VISUAL_ID:
				return new DurationConstraintInMessageEditPart(view);

			case DurationObservationEditPart.VISUAL_ID:
				return new DurationObservationEditPart(view);

			case InteractionInteractionCompartmentEditPart.VISUAL_ID:
				return new InteractionInteractionCompartmentEditPart(view);

			case CombinedFragmentCombinedFragmentCompartmentEditPart.VISUAL_ID:
				return new CombinedFragmentCombinedFragmentCompartmentEditPart(view);

			case MessageEditPart.VISUAL_ID:
				return new MessageEditPart(view);

			case MessageNameEditPart.VISUAL_ID:
				return new MessageNameEditPart(view);


			case Message2EditPart.VISUAL_ID:
				return new Message2EditPart(view);

			case MessageName2EditPart.VISUAL_ID:
				return new MessageName2EditPart(view);


			case Message3EditPart.VISUAL_ID:
				return new Message3EditPart(view);

			case MessageName3EditPart.VISUAL_ID:
				return new MessageName3EditPart(view);


			case Message4EditPart.VISUAL_ID:
				return new Message4EditPart(view);

			case MessageName4EditPart.VISUAL_ID:
				return new MessageName4EditPart(view);


			case Message5EditPart.VISUAL_ID:
				return new Message5EditPart(view);

			case MessageName5EditPart.VISUAL_ID:
				return new MessageName5EditPart(view);


			case Message6EditPart.VISUAL_ID:
				return new Message6EditPart(view);

			case MessageName6EditPart.VISUAL_ID:
				return new MessageName6EditPart(view);


			case Message7EditPart.VISUAL_ID:
				return new Message7EditPart(view);

			case MessageName7EditPart.VISUAL_ID:
				return new MessageName7EditPart(view);


			case CommentAnnotatedElementEditPart.VISUAL_ID:
				return new CommentAnnotatedElementEditPart(view);


			case ConstraintConstrainedElementEditPart.VISUAL_ID:
				return new ConstraintConstrainedElementEditPart(view);

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
		if(source.getFigure() instanceof HTMLCornerBentFigure)
			return new CommentCellEditorLocator((HTMLCornerBentFigure)source.getFigure());
		else if(source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel)source.getFigure());
		else {
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
