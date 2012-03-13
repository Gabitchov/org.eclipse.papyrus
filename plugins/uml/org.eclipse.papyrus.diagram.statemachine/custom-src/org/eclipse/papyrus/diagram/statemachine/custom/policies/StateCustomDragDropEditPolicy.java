/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 * 
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.custom.policies;

import java.util.Set;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.requests.DropObjectsRequest;
import org.eclipse.papyrus.diagram.statemachine.edit.parts.StateDeferredTriggerEditPart;
import org.eclipse.uml2.uml.Element;

/**
 * Custom DnD edit policy in order to refresh layout after each drop
 * 
 * @author adaussy
 * 
 */
public class StateCustomDragDropEditPolicy extends CustomStateMachineDiagramDragDropEditPolicy {

	@Override
	public Command getDropObjectsCommand(DropObjectsRequest dropRequest) {
		Command dropObjectsCommand = super.getDropObjectsCommand(dropRequest);
		/**
		 * Add refresh layout
		 */
		ChangeBoundsRequest chReq = new ChangeBoundsRequest(org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_REFRESH);
		chReq.setEditParts(getHost());
		chReq.setMoveDelta(new Point(0, 0));
		Command refreshLayout = getHost().getCommand(chReq);
		if(refreshLayout != null && dropObjectsCommand != null) {
			CompositeCommand cc = new CompositeCommand(dropObjectsCommand.getLabel());
			cc.compose(new CommandProxy(dropObjectsCommand));
			cc.compose(new CommandProxy(refreshLayout));
			return new ICommandProxy(cc);
		}
		return dropObjectsCommand;
	}

	@Override
	protected Set<Integer> getDroppableElementVisualId() {
		Set<Integer> superSpecificID = super.getDroppableElementVisualId();
		superSpecificID.add(StateDeferredTriggerEditPart.VISUAL_ID);
		return superSpecificID;
	}

	@Override
	protected Command getSpecificDropCommand(DropObjectsRequest dropRequest, Element semanticElement, int nodeVISUALID, int linkVISUALID) {
		switch(nodeVISUALID) {
		case StateDeferredTriggerEditPart.VISUAL_ID:
			return new ICommandProxy(super.getDefaultDropNodeCommand(nodeVISUALID, dropRequest.getLocation().getCopy(), semanticElement));
		default:
			return super.getSpecificDropCommand(dropRequest, semanticElement, nodeVISUALID, linkVISUALID);
		}
	}
	
	
	
	
}
