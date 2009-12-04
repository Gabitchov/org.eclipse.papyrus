package org.eclipse.papyrus.diagram.statemachine.edit.parts;

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
import org.eclipse.papyrus.diagram.common.edit.policies.ShowViewEditPolicy;
import org.eclipse.papyrus.diagram.statemachine.part.UMLVisualIDRegistry;
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
			EditPart ep = null;
			switch(UMLVisualIDRegistry.getVisualID(view)) {

			case StateMachineEditPart.VISUAL_ID:
				ep = new StateMachineEditPart(view);
				break;

			case StateMachine2EditPart.VISUAL_ID:
				ep = new StateMachine2EditPart(view);
				break;

			case StateMachineNameEditPart.VISUAL_ID:
				ep = new StateMachineNameEditPart(view);
				break;

			case StateMachineName2EditPart.VISUAL_ID:
				ep = new StateMachineName2EditPart(view);
				break;

			case CommentEditPart.VISUAL_ID:
				ep = new CommentEditPart(view);
				break;

			case CommentBodyEditPart.VISUAL_ID:
				ep = new CommentBodyEditPart(view);
				break;

			case RegionEditPart.VISUAL_ID:
				ep = new RegionEditPart(view);
				break;

			case StateEditPart.VISUAL_ID:
				ep = new StateEditPart(view);
				break;

			case StateNameEditPart.VISUAL_ID:
				ep = new StateNameEditPart(view);
				break;

			case StateName2EditPart.VISUAL_ID:
				ep = new StateName2EditPart(view);
				break;

			case State2EditPart.VISUAL_ID:
				ep = new State2EditPart(view);
				break;

			case StateName3EditPart.VISUAL_ID:
				ep = new StateName3EditPart(view);
				break;

			case StateName4EditPart.VISUAL_ID:
				ep = new StateName4EditPart(view);
				break;

			case Region2EditPart.VISUAL_ID:
				ep = new Region2EditPart(view);
				break;

			case State3EditPart.VISUAL_ID:
				ep = new State3EditPart(view);
				break;

			case StateName5EditPart.VISUAL_ID:
				ep = new StateName5EditPart(view);
				break;

			case StateName6EditPart.VISUAL_ID:
				ep = new StateName6EditPart(view);
				break;

			case ConnectionPointReferenceEditPart.VISUAL_ID:
				ep = new ConnectionPointReferenceEditPart(view);
				break;

			case ConnectionPointReferenceNameEditPart.VISUAL_ID:
				ep = new ConnectionPointReferenceNameEditPart(view);
				break;

			case ConnectionPointReference2EditPart.VISUAL_ID:
				ep = new ConnectionPointReference2EditPart(view);
				break;

			case ConnectionPointReferenceName2EditPart.VISUAL_ID:
				ep = new ConnectionPointReferenceName2EditPart(view);
				break;

			case FinalStateEditPart.VISUAL_ID:
				ep = new FinalStateEditPart(view);
				break;

			case PseudostateEditPart.VISUAL_ID:
				ep = new PseudostateEditPart(view);
				break;

			case Pseudostate2EditPart.VISUAL_ID:
				ep = new Pseudostate2EditPart(view);
				break;

			case Pseudostate3EditPart.VISUAL_ID:
				ep = new Pseudostate3EditPart(view);
				break;

			case Pseudostate4EditPart.VISUAL_ID:
				ep = new Pseudostate4EditPart(view);
				break;

			case Pseudostate5EditPart.VISUAL_ID:
				ep = new Pseudostate5EditPart(view);
				break;

			case Pseudostate6EditPart.VISUAL_ID:
				ep = new Pseudostate6EditPart(view);
				break;

			case Pseudostate7EditPart.VISUAL_ID:
				ep = new Pseudostate7EditPart(view);
				break;

			case PseudostateName7EditPart.VISUAL_ID:
				ep = new PseudostateName7EditPart(view);
				break;

			case Pseudostate8EditPart.VISUAL_ID:
				ep = new Pseudostate8EditPart(view);
				break;

			case State4EditPart.VISUAL_ID:
				ep = new State4EditPart(view);
				break;

			case StateName7EditPart.VISUAL_ID:
				ep = new StateName7EditPart(view);
				break;

			case StateName8EditPart.VISUAL_ID:
				ep = new StateName8EditPart(view);
				break;

			case Pseudostate9EditPart.VISUAL_ID:
				ep = new Pseudostate9EditPart(view);
				break;

			case PseudostateNameEditPart.VISUAL_ID:
				ep = new PseudostateNameEditPart(view);
				break;

			case Pseudostate10EditPart.VISUAL_ID:
				ep = new Pseudostate10EditPart(view);
				break;

			case PseudostateName2EditPart.VISUAL_ID:
				ep = new PseudostateName2EditPart(view);
				break;

			case Pseudostate11EditPart.VISUAL_ID:
				ep = new Pseudostate11EditPart(view);
				break;

			case PseudostateName3EditPart.VISUAL_ID:
				ep = new PseudostateName3EditPart(view);
				break;

			case Pseudostate12EditPart.VISUAL_ID:
				ep = new Pseudostate12EditPart(view);
				break;

			case PseudostateName4EditPart.VISUAL_ID:
				ep = new PseudostateName4EditPart(view);
				break;

			case Pseudostate13EditPart.VISUAL_ID:
				ep = new Pseudostate13EditPart(view);
				break;

			case PseudostateName5EditPart.VISUAL_ID:
				ep = new PseudostateName5EditPart(view);
				break;

			case Pseudostate14EditPart.VISUAL_ID:
				ep = new Pseudostate14EditPart(view);
				break;

			case PseudostateName6EditPart.VISUAL_ID:
				ep = new PseudostateName6EditPart(view);
				break;

			case RegionSubverticesEditPart.VISUAL_ID:
				ep = new RegionSubverticesEditPart(view);
				break;

			case RegionSubvertices2EditPart.VISUAL_ID:
				ep = new RegionSubvertices2EditPart(view);
				break;

			case TransitionEditPart.VISUAL_ID:
				ep = new TransitionEditPart(view);
				break;

			case TransitionNameEditPart.VISUAL_ID:
				ep = new TransitionNameEditPart(view);
				break;

			case TransitionName2EditPart.VISUAL_ID:
				ep = new TransitionName2EditPart(view);
				break;

			case ElementOwnedCommentEditPart.VISUAL_ID:
				ep = new ElementOwnedCommentEditPart(view);
				break;

			case CommentAnnotatedElementEditPart.VISUAL_ID:
				ep = new CommentAnnotatedElementEditPart(view);
				break;
			}
			if(ep != null) {
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
			if(getWrapLabel().isTextWrapOn()
					&& getWrapLabel().getText().length() > 0) {
				rect.setSize(new Dimension(text.computeSize(rect.width,
						SWT.DEFAULT)));
			} else {
				int avr = FigureUtilities.getFontMetrics(text.getFont())
						.getAverageCharWidth();
				rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
						SWT.DEFAULT)).expand(avr * 2, 0));
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
			int avr = FigureUtilities.getFontMetrics(text.getFont())
					.getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT,
					SWT.DEFAULT)).expand(avr * 2, 0));
			if(!rect.equals(new Rectangle(text.getBounds()))) {
				text.setBounds(rect.x, rect.y, rect.width, rect.height);
			}
		}
	}
}
