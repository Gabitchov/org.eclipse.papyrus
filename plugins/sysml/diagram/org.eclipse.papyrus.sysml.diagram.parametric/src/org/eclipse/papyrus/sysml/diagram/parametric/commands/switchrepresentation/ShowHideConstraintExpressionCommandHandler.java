package org.eclipse.papyrus.sysml.diagram.parametric.commands.switchrepresentation;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.CustomConstraintBlockPropertyCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler;

public class ShowHideConstraintExpressionCommandHandler  extends GraphicalCommandHandler {

	@Override
	protected Command getCommand() {
		final List<IGraphicalEditPart> selectedElements = getSelectedElements();
		for(final IGraphicalEditPart selectedElement : selectedElements) {
			if(selectedElement instanceof CustomConstraintBlockPropertyCompositeEditPart) {
				return new ShowHideConstraintExpressionCommand((GraphicalEditPart)selectedElement);
			}
		}
		return UnexecutableCommand.INSTANCE;
	}
}

