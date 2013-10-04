package org.eclipse.papyrus.sysml.diagram.parametric.commands.switchrepresentation;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.sysml.diagram.common.figure.ConstraintBlockPropertyCompositeFigure;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.CustomConstraintBlockPropertyCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.common.edit.part.ConstraintNodeLabelEditPart;

public class ShowHideConstraintExpressionCommand  extends Command {

	private final GraphicalEditPart editPartToSwitch;

	public GraphicalEditPart getEditPartToSwitch() {
		return editPartToSwitch;
	}

	public ShowHideConstraintExpressionCommand(final GraphicalEditPart editPartToRefresh) {
		this.editPartToSwitch = editPartToRefresh;
	}

	@Override
	public void execute() {
		if (this.getEditPartToSwitch() instanceof CustomConstraintBlockPropertyCompositeEditPart) {
			CustomConstraintBlockPropertyCompositeEditPart constraintBlockPropertyCompositeEditPart = (CustomConstraintBlockPropertyCompositeEditPart)this.getEditPartToSwitch();
			WrappingLabel constraintLabel = ((ConstraintBlockPropertyCompositeFigure)constraintBlockPropertyCompositeEditPart.getPrimaryShape()).getConstraintLabel();
			ConstraintNodeLabelEditPart constraintNodeLabelEditPart = null;
			for (Object currentEditPart : constraintBlockPropertyCompositeEditPart.getChildren()) {
				if (currentEditPart instanceof ConstraintNodeLabelEditPart) {
					if (((ConstraintNodeLabelEditPart) currentEditPart).getFigure() == constraintLabel) {
						constraintNodeLabelEditPart = (ConstraintNodeLabelEditPart)currentEditPart;
					}
				}
			}
			
			if (constraintNodeLabelEditPart != null) {
				View constraintLabelView = (View)constraintNodeLabelEditPart.getModel();
				constraintLabelView.setVisible(!constraintLabelView.isVisible());
			}
		}
	}

	@Override
	public void undo() {
		execute();
	}
	
	@Override
	public void redo() {
		execute();
	}
	
}
