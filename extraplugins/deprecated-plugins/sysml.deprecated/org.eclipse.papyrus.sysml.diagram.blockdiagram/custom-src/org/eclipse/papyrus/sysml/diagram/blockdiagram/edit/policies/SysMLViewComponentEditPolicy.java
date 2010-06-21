/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.sysml.diagram.blockdiagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.papyrus.diagram.clazz.custom.policies.CustomViewComponentEditPolicy;


public class SysMLViewComponentEditPolicy extends CustomViewComponentEditPolicy {

	/**
	 * Return a command to delete the host's view. The host's primary view is deleted if {@link GroupRequest#getEditParts()} returns a <tt>null</tt>
	 * or empty list; otherwise each
	 * editpart's view is deleted.
	 * 
	 * @param deleteRequest
	 *        the original delete request.
	 * @return Command
	 */
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		// TODO : refactor the deleteViewCommand
		return UnexecutableCommand.INSTANCE;
	}

}
