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
package org.eclipse.papyrus.diagram.activity.edit.policies;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ViewComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.uml2.uml.Action;

/**
 * This edit policy deletes linked local conditions view when an action view is deleted.
 */
public class DeleteActionViewEditPolicy extends ViewComponentEditPolicy {

	/**
	 * Returns true when the request is a graphical delete
	 * 
	 * @see org.eclipse.gef.EditPolicy#understandsRequest(Request)
	 * @return true for a graphical delete request
	 */
	@Override
	public boolean understandsRequest(Request req) {
		return RequestConstants.REQ_DELETE.equals(req.getType());
	}

	/**
	 * Returns a command for graphical delete (with local conditions also deleted).
	 * 
	 * @see org.eclipse.gef.EditPolicy#getCommand(Request)
	 * @return the command or null
	 */
	@Override
	public Command getCommand(Request request) {
		if(RequestConstants.REQ_DELETE.equals(request.getType())) {
			if(request instanceof GroupRequest) {
				// List of parts from the request is not up to date. Consider the host only.
				List<?> parts = Collections.singletonList(getHost());
				((GroupRequest)request).setEditParts(getHost());
				// inspect the list of parts to add linked local conditions
				List<EditPart> partsToAdd = getListOfLinkedLocalConditionsParts(parts);
				((GroupRequest)request).getEditParts().addAll(partsToAdd);
				return getDeleteCommand((GroupRequest)request);
			}
		}
		return null;
	}

	/**
	 * Get the list of local condition parts linked to a part of the list
	 * 
	 * @param partsToExplore
	 *        list of parts to explore
	 * @return list of local condition parts
	 */
	private List<EditPart> getListOfLinkedLocalConditionsParts(List<?> partsToExplore) {
		List<EditPart> result = new LinkedList<EditPart>();
		for(Object part : partsToExplore) {
			if(part instanceof AbstractBorderedShapeEditPart) {
				EObject element = ((AbstractBorderedShapeEditPart)part).resolveSemanticElement();
				if(element instanceof Action) {
					Action action = (Action)element;
					List<?> connections = ((AbstractBorderedShapeEditPart)part).getSourceConnections();
					if(connections != null) {
						for(Object connection : connections) {
							if(connection instanceof ConnectionNodeEditPart) {
								EditPart target = ((ConnectionNodeEditPart)connection).getTarget();
								if(target instanceof ShapeNodeEditPart) {
									EObject linkedElement = ((ShapeNodeEditPart)target).resolveSemanticElement();
									if(action.getLocalPreconditions().contains(linkedElement) || action.getLocalPostconditions().contains(linkedElement)) {
										result.add(target);
									}
								}
							}
						}
					}
				}
			}
		}
		return result;
	}
}
