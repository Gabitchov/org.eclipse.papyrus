/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import org.eclipse.papyrus.diagram.common.editpolicies.ShowViewEditPolicy;
import org.eclipse.papyrus.diagram.sequence.part.UMLVisualIDRegistry;

/**
 * @generated
 */
public class UMLEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			EditPart ep = null;
			switch (UMLVisualIDRegistry.getVisualID(view)) {

			case PackageEditPart.VISUAL_ID:
				ep = new PackageEditPart(view);
				break;

			case InteractionEditPart.VISUAL_ID:
				ep = new InteractionEditPart(view);
				break;

			case InteractionNameEditPart.VISUAL_ID:
				ep = new InteractionNameEditPart(view);
				break;

			case CommentEditPart.VISUAL_ID:
				ep = new CommentEditPart(view);
				break;

			case CommentBodyEditPart.VISUAL_ID:
				ep = new CommentBodyEditPart(view);
				break;

			case Interaction2EditPart.VISUAL_ID:
				ep = new Interaction2EditPart(view);
				break;

			case InteractionName2EditPart.VISUAL_ID:
				ep = new InteractionName2EditPart(view);
				break;

			case LifelineEditPart.VISUAL_ID:
				ep = new LifelineEditPart(view);
				break;

			case LifelineNameEditPart.VISUAL_ID:
				ep = new LifelineNameEditPart(view);
				break;

			case BehaviorExecutionSpecificationEditPart.VISUAL_ID:
				ep = new BehaviorExecutionSpecificationEditPart(view);
				break;

			case CombinedFragmentEditPart.VISUAL_ID:
				ep = new CombinedFragmentEditPart(view);
				break;

			case CombinedFragmentInteractionOperatorEditPart.VISUAL_ID:
				ep = new CombinedFragmentInteractionOperatorEditPart(view);
				break;

			case InteractionInteractionCompartmentEditPart.VISUAL_ID:
				ep = new InteractionInteractionCompartmentEditPart(view);
				break;

			case InteractionInteractionCompartment2EditPart.VISUAL_ID:
				ep = new InteractionInteractionCompartment2EditPart(view);
				break;

			case MessageEditPart.VISUAL_ID:
				ep = new MessageEditPart(view);
				break;

			case MessageNameEditPart.VISUAL_ID:
				ep = new MessageNameEditPart(view);
				break;

			case Message2EditPart.VISUAL_ID:
				ep = new Message2EditPart(view);
				break;

			case MessageName2EditPart.VISUAL_ID:
				ep = new MessageName2EditPart(view);
				break;

			case Message3EditPart.VISUAL_ID:
				ep = new Message3EditPart(view);
				break;

			case MessageName3EditPart.VISUAL_ID:
				ep = new MessageName3EditPart(view);
				break;

			case Message4EditPart.VISUAL_ID:
				ep = new Message4EditPart(view);
				break;

			case MessageName4EditPart.VISUAL_ID:
				ep = new MessageName4EditPart(view);
				break;

			case Message5EditPart.VISUAL_ID:
				ep = new Message5EditPart(view);
				break;

			case MessageName5EditPart.VISUAL_ID:
				ep = new MessageName5EditPart(view);
				break;

			case Message6EditPart.VISUAL_ID:
				ep = new Message6EditPart(view);
				break;

			case MessageName6EditPart.VISUAL_ID:
				ep = new MessageName6EditPart(view);
				break;

			case ElementOwnedCommentEditPart.VISUAL_ID:
				ep = new ElementOwnedCommentEditPart(view);
				break;

			case CommentAnnotatedElementEditPart.VISUAL_ID:
				ep = new CommentAnnotatedElementEditPart(view);
				break;
			}
			if (ep != null) {
				ep.installEditPolicy(EditPolicyRoles.OPEN_ROLE,
						ShowViewEditPolicy.createOpenEditPolicy());
				return ep;
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
	public static CellEditorLocator getTextCellEditorLocator(
			ITextAwareEditPart source) {
		if (source.getFigure() instanceof WrappingLabel)
			return new TextCellEditorLocator((WrappingLabel) source.getFigure());
		else {
			return new LabelCellEditorLocator((Label) source.getFigure());
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
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getWrapLabel().getTextBounds().getCopy();
			getWrapLabel().translateToAbsolute(rect);
			if (getWrapLabel().isTextWrapOn()
					&& getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width,
						SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
			}
			if (!rect.equals(new Rectangle(text.getBounds()))) {
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
			Text text = (Text) celleditor.getControl();
			Rectangle rect = getLabel().getTextBounds().getCopy();
			getLabel().translateToAbsolute(rect);
			int avr = FigureUtilities.getFontMetrics(text.getFont())
					.getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
					SWT.DEFAULT)).expand(avr * 2, 0));
			if (!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
