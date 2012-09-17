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
package org.eclipse.papyrus.uml.diagram.common.handlers;

import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CanonicalEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Command handler for delete from diagram
 */
public class DeleteFromDiagramCommandHandler extends GraphicalCommandHandler implements IHandler {

	/**
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.handlers.GraphicalCommandHandler#getCommand()
	 * 
	 * @return the deletion command
	 * @throws ExecutionException
	 */
	protected Command getCommand() throws ExecutionException {

		// Retrieve currently selected IGraphicalEditPart(s)
		List<IGraphicalEditPart> editParts = getSelectedElements();
		if(editParts.isEmpty()) {
			return UnexecutableCommand.INSTANCE;
		}

		if(!supportViews(editParts) || isCanonical(editParts)) {
			return UnexecutableCommand.INSTANCE;
		}

		CompoundCommand command = new CompoundCommand("Delete From Diagram");
		for(Iterator<IGraphicalEditPart> iter = editParts.iterator(); iter.hasNext();) {
			IGraphicalEditPart editPart = iter.next();
			/* Send the request to the edit part */
			command.add(editPart.getCommand(new GroupRequest(RequestConstants.REQ_DELETE)));
		}
		return command;
	}

	/**
	 * Copied from {@link DeleteFromDiagramAction}
	 */
	private boolean supportViews(List<IGraphicalEditPart> editParts) {
		for(Iterator<IGraphicalEditPart> iter = editParts.iterator(); iter.hasNext();) {
			IGraphicalEditPart object = iter.next();
			if(object instanceof GraphicalEditPart && !((GraphicalEditPart)object).hasNotationView()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Copied from {@link DeleteFromDiagramAction}
	 */
	protected boolean isCanonical(List<IGraphicalEditPart> editParts) {

		boolean isCanonical = false;
		if(!editParts.isEmpty()) {

			for(Iterator<IGraphicalEditPart> si = editParts.iterator(); si.hasNext() && !isCanonical;) {
				IGraphicalEditPart child = si.next();

				View view = (View)child.getAdapter(View.class);
				if(view == null || view.getElement() == null || view.getElement() instanceof View) {
					// If there is no element or the element is a view (e.g.
					// diagram
					// link) than we want to support delete from diagram. See
					// bugzilla#148453.
					isCanonical = false;
					continue;
				}

				if(child instanceof ConnectionEditPart) {
					ConnectionEditPart connection = (ConnectionEditPart)child;
					isCanonical = (!connection.isSemanticConnection() || (isCanonical(connection.getSource()) && isCanonical(connection.getTarget())));
				} else {
					isCanonical = isCanonical(child);
				}
			}
		}
		return isCanonical;
	}

	/**
	 * Copied from {@link DeleteFromDiagramAction}
	 */
	protected boolean isCanonical(EditPart ep) {
		EObject eObject = (EObject)ep.getAdapter(EObject.class);
		EditPart parent = ep.getParent();
		if(eObject != null && parent != null) { // sanity checks
			CanonicalEditPolicy cep = (CanonicalEditPolicy)parent.getEditPolicy(EditPolicyRoles.CANONICAL_ROLE);
			return cep != null && cep.isEnabled() && cep.canCreate(eObject);
		}
		return false;
	}
}
