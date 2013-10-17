/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Régis CHEVREL: chevrel.regis <at> gmail.com
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.sysml.diagram.parametric.commands.switchrepresentation;

import java.util.List;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.papyrus.sysml.diagram.parametric.edit.part.CustomConstraintBlockPropertyCompositeEditPart;
import org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler;

public class ShowHideConstraintExpressionCommandHandler  extends GraphicalCommandHandler {

	@Override
	protected Command getCommand() {
		CompoundCommand command = new CompoundCommand("Show/Hide ConstraintProperty Constraint Expression");
		final List<IGraphicalEditPart> selectedElements = getSelectedElements();
		for(final IGraphicalEditPart selectedElement : selectedElements) {
			if(selectedElement instanceof CustomConstraintBlockPropertyCompositeEditPart) {
				command.add(new ShowHideConstraintExpressionCommand((GraphicalEditPart)selectedElement));
			}
		}
		return command;
	}
}

