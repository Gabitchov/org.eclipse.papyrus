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
import org.eclipse.gmf.runtime.diagram.ui.requests.EditCommandRequestWrapper;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;

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
		if(RequestConstants.REQ_SEMANTIC_WRAPPER.equals(req.getType()) && req instanceof EditCommandRequestWrapper){
			IEditCommandRequest wrappedRequest = ((EditCommandRequestWrapper)req).getEditCommandRequest();
			if(wrappedRequest instanceof DestroyElementRequest){
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns an unexecutable command for graphical delete.
	 * 
	 * @see org.eclipse.gef.EditPolicy#getCommand(Request)
	 */
	@Override
	public Command getCommand(Request request) {
		if(RequestConstants.REQ_SEMANTIC_WRAPPER.equals(request.getType()) && request instanceof EditCommandRequestWrapper){
			IEditCommandRequest wrappedRequest = ((EditCommandRequestWrapper)request).getEditCommandRequest();
			if(wrappedRequest instanceof DestroyElementRequest){
				return UnexecutableCommand.INSTANCE;
			}
		}
		return super.getCommand(request);
	}
}
