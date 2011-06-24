/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.handlers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.emf.commands.core.command.CompositeTransactionalCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;

/**
 * Command handler for delete from diagram
 */
public class DeleteFromModelCommandHandler extends GraphicalCommandHandler implements IHandler {

	protected Command getCommand() throws ExecutionException {

		// Retrieve currently selected IGraphicalEditPart(s)
		List<IGraphicalEditPart> editParts = getSelectedElements();
		if(editParts.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		// Iterate over selection and retrieve the deletion command from each edit part
		// Add each returned command to the composite command
		CompositeTransactionalCommand command = new CompositeTransactionalCommand(getEditingDomain(), "Delete From Model");

		Iterator<IGraphicalEditPart> it = editParts.iterator();
		while(it.hasNext()) {
			IGraphicalEditPart editPart = it.next();

			if(!(editPart instanceof DiagramEditPart)) {
				// Look for the GMF deletion command
				Command curCommand = editPart.getCommand(new EditCommandRequestWrapper(new DestroyElementRequest(false)));
				if(curCommand != null) {
					command.compose(new CommandProxy(curCommand));
				}
			}
		}

		if(command.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		return new ICommandProxy(command);
	}
}
