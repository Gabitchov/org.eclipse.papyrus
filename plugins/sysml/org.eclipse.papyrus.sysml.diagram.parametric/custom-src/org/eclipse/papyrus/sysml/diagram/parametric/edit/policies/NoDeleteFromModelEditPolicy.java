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
package org.eclipse.papyrus.sysml.diagram.parametric.edit.policies;

import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;

/**
 * This edit policy disables the graphical deletion of a diagram element.
 */
public class NoDeleteFromModelEditPolicy extends AbstractEditPolicy {

	/**
	 * Returns true when the request is a graphical delete
	 * 
	 * @see org.eclipse.gef.EditPolicy#understandsRequest(Request)
	 */
	@Override
	public boolean understandsRequest(Request req) {
		return RequestConstants.REQ_SEMANTIC_WRAPPER.equals(req.getType());
	}

	/**
	 * Returns an unexecutable command for graphical delete.
	 * 
	 * @see org.eclipse.gef.EditPolicy#getCommand(Request)
	 */
	@Override
	public Command getCommand(Request request) {
		if(RequestConstants.REQ_SEMANTIC_WRAPPER.equals(request.getType())) {
			return UnexecutableCommand.INSTANCE;
		}
		return super.getCommand(request);
	}
}
