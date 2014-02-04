/*****************************************************************************
 * Copyright (c) 2013 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.AbstractMessageEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.util.FragmentsOrdererHelper;

/**
 * Ordering fragments after moving, resizing for Shapes and reconnect for message occurrence specifications.
 * See https://bugs.eclipse.org/bugs/show_bug.cgi?id=403233
 * 
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class InteractionFragmentsOrderingEditPolicy extends GraphicalEditPolicy {

	public static final String ORDERING_ROLE = "Ordering Interaction Fragments";

	/**
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#understandsRequest(org.eclipse.gef.Request)
	 * 
	 * @param req
	 * @return
	 */
	@Override
	public boolean understandsRequest(Request req) {
		Object type = req.getType();
		if(REQ_MOVE.equals(type) || REQ_RESIZE.equals(type)) {//Correct mistake(also fix bug: https://bugs.eclipse.org/bugs/show_bug.cgi?id=417375)
			return true;
		} else if(getHost() instanceof AbstractMessageEditPart) {
			return REQ_RECONNECT_SOURCE.equals(type) || REQ_RECONNECT_TARGET.equals(type) || REQ_CREATE_BENDPOINT.equals(type) || REQ_MOVE_BENDPOINT.equals(type);
		}
		return false;
	}

	@Override
	public EditPart getTargetEditPart(Request request) {
		if(understandsRequest(request)) {
			return getHost();
		}
		return null;
	}

	@Override
	public Command getCommand(Request request) {
		if(understandsRequest(request)) {
			AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(getEditingDomain(), "", null) {

				@Override
				protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
					FragmentsOrdererHelper.orderingFragments(getHost(), null);
					return CommandResult.newOKCommandResult();
				}
			};
			return new ICommandProxy(cmd);
		}
		return null;
	}

	private TransactionalEditingDomain getEditingDomain() {
		EditPart host = getHost();
		if(host instanceof IGraphicalEditPart) {
			return ((IGraphicalEditPart)host).getEditingDomain();
		}
		return null;
	}
}
