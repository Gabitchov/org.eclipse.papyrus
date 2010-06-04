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
package org.eclipse.papyrus.diagram.common.groups.edit.policies;

import java.util.List;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;
import org.eclipse.papyrus.diagram.common.groups.core.utils.Utils;
import org.eclipse.papyrus.diagram.common.util.DiagramEditPartsUtil;

/**
 * This Edit Policy applies on a group which owns its elements by reference. It enables to recover the correct model container in order to create the
 * element at the right place in the model, before linking it to the referencing group.
 * 
 * @author vhemery
 */
public class CreateInReferencingGroupEditPolicy extends AbstractEditPolicy {

	/**
	 * Constructor of creation edit policy.
	 */
	public CreateInReferencingGroupEditPolicy() {
		super();
	}

	/**
	 * Get the command to create a group referenced child and create it in the appropriate place.
	 * 
	 * @see org.eclipse.gef.editpolicies.AbstractEditPolicy#getCommand(org.eclipse.gef.Request)
	 * @param request
	 *        the creation request
	 * @return the creation command or null;
	 */
	@Override
	public Command getCommand(Request request) {
		if(RequestConstants.REQ_CREATE.equals(request.getType()) && request instanceof CreateUnspecifiedTypeRequest) {
			CreateUnspecifiedTypeRequest creationRequest = (CreateUnspecifiedTypeRequest)request;
			if(getHost() instanceof IGraphicalEditPart) {
				IGraphicalEditPart groupPart = (IGraphicalEditPart)getHost();
				if(GroupContainmentRegistry.isContainerConcerned(groupPart) && !GroupContainmentRegistry.isContainerModel(groupPart)) {
					Rectangle bounds = new Rectangle(creationRequest.getLocation(), creationRequest.getSize());
					DiagramEditPart diagramPart = DiagramEditPartsUtil.getDiagramEditPart(getHost());
					List<IGraphicalEditPart> parents = Utils.findPossibleParents(bounds, diagramPart);
					// TODO make the command
				}
			}
		}
		return super.getCommand(request);
	}
}
