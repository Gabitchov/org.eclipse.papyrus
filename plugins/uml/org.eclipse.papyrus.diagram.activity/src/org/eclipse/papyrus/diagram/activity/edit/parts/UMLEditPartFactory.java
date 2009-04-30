package org.eclipse.papyrus.diagram.activity.edit.parts;

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
import org.eclipse.papyrus.diagram.activity.part.UMLVisualIDRegistry;
import org.eclipse.papyrus.diagram.common.edit.policies.ShowViewEditPolicy;
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
		if (model instanceof View) {
			View view = (View) model;
			EditPart ep = null;
			switch (UMLVisualIDRegistry.getVisualID(view)) {

			case PackageEditPart.VISUAL_ID:
				ep = new PackageEditPart(view);
				break;

			case ActivityEditPart.VISUAL_ID:
				ep = new ActivityEditPart(view);
				break;

			case ActivityNameEditPart.VISUAL_ID:
				ep = new ActivityNameEditPart(view);
				break;

			case CommentEditPart.VISUAL_ID:
				ep = new CommentEditPart(view);
				break;

			case CommentBodyEditPart.VISUAL_ID:
				ep = new CommentBodyEditPart(view);
				break;

			case SendObjectActionEditPart.VISUAL_ID:
				ep = new SendObjectActionEditPart(view);
				break;

			case SendObjectActionNameEditPart.VISUAL_ID:
				ep = new SendObjectActionNameEditPart(view);
				break;

			case SendObjectActionName2EditPart.VISUAL_ID:
				ep = new SendObjectActionName2EditPart(view);
				break;

			case InputPinEditPart.VISUAL_ID:
				ep = new InputPinEditPart(view);
				break;

			case InputPinNameEditPart.VISUAL_ID:
				ep = new InputPinNameEditPart(view);
				break;

			case InputPin2EditPart.VISUAL_ID:
				ep = new InputPin2EditPart(view);
				break;

			case InputPinName2EditPart.VISUAL_ID:
				ep = new InputPinName2EditPart(view);
				break;

			case ValuePinEditPart.VISUAL_ID:
				ep = new ValuePinEditPart(view);
				break;

			case ValuePinNameEditPart.VISUAL_ID:
				ep = new ValuePinNameEditPart(view);
				break;

			case SendSignalActionEditPart.VISUAL_ID:
				ep = new SendSignalActionEditPart(view);
				break;

			case SendSignalActionNameEditPart.VISUAL_ID:
				ep = new SendSignalActionNameEditPart(view);
				break;

			case SendSignalActionName2EditPart.VISUAL_ID:
				ep = new SendSignalActionName2EditPart(view);
				break;

			case InputPin3EditPart.VISUAL_ID:
				ep = new InputPin3EditPart(view);
				break;

			case InputPinName3EditPart.VISUAL_ID:
				ep = new InputPinName3EditPart(view);
				break;

			case AcceptEventActionEditPart.VISUAL_ID:
				ep = new AcceptEventActionEditPart(view);
				break;

			case AcceptEventActionNameEditPart.VISUAL_ID:
				ep = new AcceptEventActionNameEditPart(view);
				break;

			case AcceptEventActionName2EditPart.VISUAL_ID:
				ep = new AcceptEventActionName2EditPart(view);
				break;

			case OutputPinEditPart.VISUAL_ID:
				ep = new OutputPinEditPart(view);
				break;

			case OutputPinNameEditPart.VISUAL_ID:
				ep = new OutputPinNameEditPart(view);
				break;

			case ActivityFinalNodeEditPart.VISUAL_ID:
				ep = new ActivityFinalNodeEditPart(view);
				break;

			case ActivityFinalNodeNameEditPart.VISUAL_ID:
				ep = new ActivityFinalNodeNameEditPart(view);
				break;

			case DecisionNodeEditPart.VISUAL_ID:
				ep = new DecisionNodeEditPart(view);
				break;

			case DecisionNodeNameEditPart.VISUAL_ID:
				ep = new DecisionNodeNameEditPart(view);
				break;

			case MergeNodeEditPart.VISUAL_ID:
				ep = new MergeNodeEditPart(view);
				break;

			case MergeNodeNameEditPart.VISUAL_ID:
				ep = new MergeNodeNameEditPart(view);
				break;

			case InitialNodeEditPart.VISUAL_ID:
				ep = new InitialNodeEditPart(view);
				break;

			case InitialNodeNameEditPart.VISUAL_ID:
				ep = new InitialNodeNameEditPart(view);
				break;

			case DataStoreNodeEditPart.VISUAL_ID:
				ep = new DataStoreNodeEditPart(view);
				break;

			case DataStoreNodeNameEditPart.VISUAL_ID:
				ep = new DataStoreNodeNameEditPart(view);
				break;

			case OpaqueActionEditPart.VISUAL_ID:
				ep = new OpaqueActionEditPart(view);
				break;

			case OpaqueActionNameEditPart.VISUAL_ID:
				ep = new OpaqueActionNameEditPart(view);
				break;

			case OpaqueActionName2EditPart.VISUAL_ID:
				ep = new OpaqueActionName2EditPart(view);
				break;

			case OutputPin2EditPart.VISUAL_ID:
				ep = new OutputPin2EditPart(view);
				break;

			case OutputPinName2EditPart.VISUAL_ID:
				ep = new OutputPinName2EditPart(view);
				break;

			case InputPin4EditPart.VISUAL_ID:
				ep = new InputPin4EditPart(view);
				break;

			case InputPinName4EditPart.VISUAL_ID:
				ep = new InputPinName4EditPart(view);
				break;

			case ValuePin2EditPart.VISUAL_ID:
				ep = new ValuePin2EditPart(view);
				break;

			case ValuePinName2EditPart.VISUAL_ID:
				ep = new ValuePinName2EditPart(view);
				break;

			case FlowFinalNodeEditPart.VISUAL_ID:
				ep = new FlowFinalNodeEditPart(view);
				break;

			case FlowFinalNodeNameEditPart.VISUAL_ID:
				ep = new FlowFinalNodeNameEditPart(view);
				break;

			case ForkNodeEditPart.VISUAL_ID:
				ep = new ForkNodeEditPart(view);
				break;

			case JoinNodeEditPart.VISUAL_ID:
				ep = new JoinNodeEditPart(view);
				break;

			case PinEditPart.VISUAL_ID:
				ep = new PinEditPart(view);
				break;

			case PinNameEditPart.VISUAL_ID:
				ep = new PinNameEditPart(view);
				break;

			case CreateObjectActionEditPart.VISUAL_ID:
				ep = new CreateObjectActionEditPart(view);
				break;

			case CreateObjectActionNameEditPart.VISUAL_ID:
				ep = new CreateObjectActionNameEditPart(view);
				break;

			case CreateObjectActionName2EditPart.VISUAL_ID:
				ep = new CreateObjectActionName2EditPart(view);
				break;

			case OutputPin3EditPart.VISUAL_ID:
				ep = new OutputPin3EditPart(view);
				break;

			case OutputPinName3EditPart.VISUAL_ID:
				ep = new OutputPinName3EditPart(view);
				break;

			case CallBehaviorActionEditPart.VISUAL_ID:
				ep = new CallBehaviorActionEditPart(view);
				break;

			case CallBehaviorActionNameEditPart.VISUAL_ID:
				ep = new CallBehaviorActionNameEditPart(view);
				break;

			case CallBehaviorActionName2EditPart.VISUAL_ID:
				ep = new CallBehaviorActionName2EditPart(view);
				break;

			case OutputPin4EditPart.VISUAL_ID:
				ep = new OutputPin4EditPart(view);
				break;

			case OutputPinName4EditPart.VISUAL_ID:
				ep = new OutputPinName4EditPart(view);
				break;

			case InputPin5EditPart.VISUAL_ID:
				ep = new InputPin5EditPart(view);
				break;

			case InputPinName5EditPart.VISUAL_ID:
				ep = new InputPinName5EditPart(view);
				break;

			case CallOperationActionEditPart.VISUAL_ID:
				ep = new CallOperationActionEditPart(view);
				break;

			case CallOperationActionNameEditPart.VISUAL_ID:
				ep = new CallOperationActionNameEditPart(view);
				break;

			case CallOperationActionName2EditPart.VISUAL_ID:
				ep = new CallOperationActionName2EditPart(view);
				break;

			case InputPin6EditPart.VISUAL_ID:
				ep = new InputPin6EditPart(view);
				break;

			case InputPinName6EditPart.VISUAL_ID:
				ep = new InputPinName6EditPart(view);
				break;

			case ActivityParameterNodeEditPart.VISUAL_ID:
				ep = new ActivityParameterNodeEditPart(view);
				break;

			case ActivityParameterNodeNameEditPart.VISUAL_ID:
				ep = new ActivityParameterNodeNameEditPart(view);
				break;

			case ActivityPartitionEditPart.VISUAL_ID:
				ep = new ActivityPartitionEditPart(view);
				break;

			case ActivityPartitionNameEditPart.VISUAL_ID:
				ep = new ActivityPartitionNameEditPart(view);
				break;

			case ActivityPartition2EditPart.VISUAL_ID:
				ep = new ActivityPartition2EditPart(view);
				break;

			case ActivityPartitionName2EditPart.VISUAL_ID:
				ep = new ActivityPartitionName2EditPart(view);
				break;

			case OpaqueAction2EditPart.VISUAL_ID:
				ep = new OpaqueAction2EditPart(view);
				break;

			case OpaqueActionName3EditPart.VISUAL_ID:
				ep = new OpaqueActionName3EditPart(view);
				break;

			case OpaqueActionName4EditPart.VISUAL_ID:
				ep = new OpaqueActionName4EditPart(view);
				break;

			case AcceptEventAction2EditPart.VISUAL_ID:
				ep = new AcceptEventAction2EditPart(view);
				break;

			case AcceptEventActionName3EditPart.VISUAL_ID:
				ep = new AcceptEventActionName3EditPart(view);
				break;

			case AcceptEventActionName4EditPart.VISUAL_ID:
				ep = new AcceptEventActionName4EditPart(view);
				break;

			case ActivitySubverticesEditPart.VISUAL_ID:
				ep = new ActivitySubverticesEditPart(view);
				break;

			case ActivityPartitionActivityPartitionCompartmentEditPart.VISUAL_ID:
				ep = new ActivityPartitionActivityPartitionCompartmentEditPart(
						view);
				break;

			case ActivityPartitionActivityPartitionCompartment2EditPart.VISUAL_ID:
				ep = new ActivityPartitionActivityPartitionCompartment2EditPart(
						view);
				break;

			case ControlFlowEditPart.VISUAL_ID:
				ep = new ControlFlowEditPart(view);
				break;

			case ControlFlowNameEditPart.VISUAL_ID:
				ep = new ControlFlowNameEditPart(view);
				break;

			case ObjectFlowEditPart.VISUAL_ID:
				ep = new ObjectFlowEditPart(view);
				break;

			case ObjectFlowNameEditPart.VISUAL_ID:
				ep = new ObjectFlowNameEditPart(view);
				break;

			case ObjectNodeSelectionEditPart.VISUAL_ID:
				ep = new ObjectNodeSelectionEditPart(view);
				break;

			case ExceptionHandlerEditPart.VISUAL_ID:
				ep = new ExceptionHandlerEditPart(view);
				break;

			case ZigZagLabelEditPart.VISUAL_ID:
				ep = new ZigZagLabelEditPart(view);
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
