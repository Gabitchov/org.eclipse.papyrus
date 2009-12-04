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
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.DeleteCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

public class InteractionOperandComponentEditPolicy extends ComponentEditPolicy {

	/**
	 * Delete Combined fragment and child from the view. Also delete message if user wants. {@inheritDoc}
	 */
	@Override
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		CompositeCommand cmd = new CompositeCommand("Delete interaction operand view");
		cmd.add(new CommandProxy(super.createDeleteViewCommand(deleteRequest)));

		// Delete parent CombinedFragment if no InteractionOperand left after this delete
		EditPart compartmentEditPart = getHost().getParent();
		if(compartmentEditPart.getChildren().size() == 1) {
			GraphicalEditPart combinedFragmentEditPart = (GraphicalEditPart)compartmentEditPart.getParent();
			View model = (View)combinedFragmentEditPart.getModel();
			cmd.add(new DeleteCommand(combinedFragmentEditPart.getEditingDomain(), model));
		}

		return new ICommandProxy(cmd);
	}

}
