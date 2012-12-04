package org.eclipse.papyrus.uml.diagram.statemachine.edit.parts;

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
import org.eclipse.papyrus.uml.diagram.statemachine.part.UMLVisualIDRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

/**
 * @generated
 */
public class UMLEditPartFactory implements EditPartFactory {

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
	public EditPart createEditPart(EditPart context, Object model) {
		if(model instanceof View) {
			View view = (View)model;
			switch(UMLVisualIDRegistry.getVisualID(view)) {
			case PackageEditPart.VISUAL_ID:
				return new PackageEditPart(view);
			case StateMachineEditPart.VISUAL_ID:
				return new StateMachineEditPart(view);
			case StateMachineNameEditPart.VISUAL_ID:
				return new StateMachineNameEditPart(view);
			case RegionEditPart.VISUAL_ID:
				return new RegionEditPart(view);
			case FinalStateEditPart.VISUAL_ID:
				return new FinalStateEditPart(view);
			case FinalStateNameEditPart.VISUAL_ID:
				return new FinalStateNameEditPart(view);
			case FinalStateStereotypeEditPart.VISUAL_ID:
				return new FinalStateStereotypeEditPart(view);
			case StateEditPart.VISUAL_ID:
				return new StateEditPart(view);
			case StateNameEditPart.VISUAL_ID:
				return new StateNameEditPart(view);
			case PseudostateInitialEditPart.VISUAL_ID:
				return new PseudostateInitialEditPart(view);
			case PseudostateInitialNameEditPart.VISUAL_ID:
				return new PseudostateInitialNameEditPart(view);
			case PseudostateInitialStereotypeEditPart.VISUAL_ID:
				return new PseudostateInitialStereotypeEditPart(view);
			case PseudostateJoinEditPart.VISUAL_ID:
				return new PseudostateJoinEditPart(view);
			case PseudostateJoinNameEditPart.VISUAL_ID:
				return new PseudostateJoinNameEditPart(view);
			case PseudostateJoinStereotypeEditPart.VISUAL_ID:
				return new PseudostateJoinStereotypeEditPart(view);
			case PseudostateForkEditPart.VISUAL_ID:
				return new PseudostateForkEditPart(view);
			case PseudostateForkNameEditPart.VISUAL_ID:
				return new PseudostateForkNameEditPart(view);
			case PseudostateForkStereotypeEditPart.VISUAL_ID:
				return new PseudostateForkStereotypeEditPart(view);
			case PseudostateChoiceEditPart.VISUAL_ID:
				return new PseudostateChoiceEditPart(view);
			case PseudostateChoiceNameEditPart.VISUAL_ID:
				return new PseudostateChoiceNameEditPart(view);
			case PseudostateChoiceStereotypeEditPart.VISUAL_ID:
				return new PseudostateChoiceStereotypeEditPart(view);
			case PseudostateJunctionEditPart.VISUAL_ID:
				return new PseudostateJunctionEditPart(view);
			case PseudostateJunctionNameEditPart.VISUAL_ID:
				return new PseudostateJunctionNameEditPart(view);
			case PseudostateJunctionStereotypeEditPart.VISUAL_ID:
				return new PseudostateJunctionStereotypeEditPart(view);
			case PseudostateShallowHistoryEditPart.VISUAL_ID:
				return new PseudostateShallowHistoryEditPart(view);
			case PseudostateShallowHistoryNameEditPart.VISUAL_ID:
				return new PseudostateShallowHistoryNameEditPart(view);
			case PseudostateShallowHistoryStereotypeEditPart.VISUAL_ID:
				return new PseudostateShallowHistoryStereotypeEditPart(view);
			case PseudostateDeepHistoryEditPart.VISUAL_ID:
				return new PseudostateDeepHistoryEditPart(view);
			case PseudostateDeepHistoryNameEditPart.VISUAL_ID:
				return new PseudostateDeepHistoryNameEditPart(view);
			case PseudostateDeepHistoryStereotypeEditPart.VISUAL_ID:
				return new PseudostateDeepHistoryStereotypeEditPart(view);
			case PseudostateTerminateEditPart.VISUAL_ID:
				return new PseudostateTerminateEditPart(view);
			case PseudostateTerminateNameEditPart.VISUAL_ID:
				return new PseudostateTerminateNameEditPart(view);
			case PseudostateTerminateStereotypeEditPart.VISUAL_ID:
				return new PseudostateTerminateStereotypeEditPart(view);
			case PseudostateEntryPointEditPart.VISUAL_ID:
				return new PseudostateEntryPointEditPart(view);
			case PseudostateEntryPointNameEditPart.VISUAL_ID:
				return new PseudostateEntryPointNameEditPart(view);
			case PseudostateEntryPointStereotypeEditPart.VISUAL_ID:
				return new PseudostateEntryPointStereotypeEditPart(view);
			case PseudostateExitPointEditPart.VISUAL_ID:
				return new PseudostateExitPointEditPart(view);
			case PseudostateExitPointNameEditPart.VISUAL_ID:
				return new PseudostateExitPointNameEditPart(view);
			case PseudostateExitPointStereotypeEditPart.VISUAL_ID:
				return new PseudostateExitPointStereotypeEditPart(view);
			case ConnectionPointReferenceEditPart.VISUAL_ID:
				return new ConnectionPointReferenceEditPart(view);
			case ConnectionPointReferenceNameEditPart.VISUAL_ID:
				return new ConnectionPointReferenceNameEditPart(view);
			case ConnectionPointReferenceStereotypeEditPart.VISUAL_ID:
				return new ConnectionPointReferenceStereotypeEditPart(view);
			case CommentEditPart.VISUAL_ID:
				return new CommentEditPart(view);
			case CommentBodyEditPart.VISUAL_ID:
				return new CommentBodyEditPart(view);
			case ConstraintEditPart.VISUAL_ID:
				return new ConstraintEditPart(view);
			case ConstraintNameLabelEditPart.VISUAL_ID:
				return new ConstraintNameLabelEditPart(view);
			case ConstraintBodyEditPart.VISUAL_ID:
				return new ConstraintBodyEditPart(view);
			case InternalTransitionEditPart.VISUAL_ID:
				return new InternalTransitionEditPart(view);
			case EntryStateBehaviorEditPart.VISUAL_ID:
				return new EntryStateBehaviorEditPart(view);
			case DoActivityStateBehaviorStateEditPart.VISUAL_ID:
				return new DoActivityStateBehaviorStateEditPart(view);
			case ExitStateBehaviorEditPart.VISUAL_ID:
				return new ExitStateBehaviorEditPart(view);
			case RegionCompartmentEditPart.VISUAL_ID:
				return new RegionCompartmentEditPart(view);
			case StateMachineCompartmentEditPart.VISUAL_ID:
				return new StateMachineCompartmentEditPart(view);
			case StateCompartmentEditPart.VISUAL_ID:
				return new StateCompartmentEditPart(view);
			case TransitionEditPart.VISUAL_ID:
				return new TransitionEditPart(view);
			case TransitionNameEditPart.VISUAL_ID:
				return new TransitionNameEditPart(view);
			case TransitionGuardEditPart.VISUAL_ID:
				return new TransitionGuardEditPart(view);
			case TransitionStereotypeEditPart.VISUAL_ID:
				return new TransitionStereotypeEditPart(view);
			case GeneralizationEditPart.VISUAL_ID:
				return new GeneralizationEditPart(view);
			case GeneralizationStereotypeEditPart.VISUAL_ID:
				return new GeneralizationStereotypeEditPart(view);
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
}
