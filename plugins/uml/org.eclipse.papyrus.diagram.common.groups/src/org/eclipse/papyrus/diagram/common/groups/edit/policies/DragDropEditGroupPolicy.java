/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.papyrus.diagram.common.groups.commands.utlis.CommandsUtils;
import org.eclipse.papyrus.diagram.common.groups.core.groupcontainment.GroupContainmentRegistry;

/**
 * This class handle the DragAndDrop of Groups and elements related to groups (Nodes).
 * Most of the overriding code is on the getDropCommand
 * 
 * @author adaussy
 * 
 */
public class DragDropEditGroupPolicy extends DragDropEditPolicy {

	private List<IGraphicalEditPart> graphicalParents;

	private List<IGraphicalEditPart> modelParents;



	@Override
	protected Command getDragCommand(ChangeBoundsRequest request) {
		return super.getDragCommand(request);

	}

	/**
	 * Override the getDroCommand to make it work only if the editPart included in the request does not concern the groupFramework. If the belong to
	 * the group framework then it will be handled in the XYLayoutEditPolicy
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy#getDropCommand(org.eclipse.gef.requests.ChangeBoundsRequest)
	 * 
	 * @param request
	 * @return
	 */
	@Override
	protected Command getDropCommand(ChangeBoundsRequest request) {
		String label = "Mutiplexed Drop Command";
		/*
		 * If there is several edit part affected by the request multiplex the request
		 */
		Command multiplexor = CommandsUtils.requestEditPartMultiplexor(request, label, (IGraphicalEditPart)getHost());
		if(multiplexor != null) {
			return multiplexor;
		}
		List<EditPart> editParts = request.getEditParts();
		EditPart editPart = editParts.get(0);
		if(editPart instanceof IGraphicalEditPart) {
			IGraphicalEditPart iGraphicalEditPart = (IGraphicalEditPart)editPart;
			boolean isNodeConcerned = GroupContainmentRegistry.isNodeConcerned(iGraphicalEditPart);
			boolean isGroupConcerned = GroupContainmentRegistry.isContainerConcerned(iGraphicalEditPart);
			if(isGroupConcerned || isNodeConcerned) {
				return null;
			}
		}
		return super.getDropCommand(request);
	}





}
