/*****************************************************************************
 * Copyright (c) 2010 CEA
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
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.Iterator;

import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.CreateConnectionRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.papyrus.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Message;


/**
 * A specific policy to handle the message :
 * - Message cannot be uphill.
 * - Message Occurrence Specification which are created along the message may have a different container than the message.
 * 
 */
public class SequenceGraphicalNodeEditPolicy extends GraphicalNodeEditPolicy {

	/**
	 * Overrides to disable uphill message
	 */
	@SuppressWarnings({ "unchecked", "restriction" })
	@Override
	protected Command getConnectionCompleteCommand(CreateConnectionRequest request) {
		Command command = super.getConnectionCompleteCommand(request);
		if(command == null) {
			return null;
		}
		ICommandProxy proxy = (ICommandProxy)request.getStartCommand();
		CompositeCommand cc = (CompositeCommand)proxy.getICommand();
		Iterator<?> commandItr = cc.iterator();
		while(commandItr.hasNext()) {
			Object obj = commandItr.next();
			if(obj instanceof SetConnectionBendpointsCommand) {
				SetConnectionBendpointsCommand sbbCommand = (SetConnectionBendpointsCommand)obj;
				final PointList pointList = sbbCommand.getNewPointList();
				if(pointList.getFirstPoint().y >= pointList.getLastPoint().y) {
					return null;
				}
				request.getExtendedData().put(SequenceRequestConstant.SOURCE_MODEL_CONTAINER, SequenceUtil.findInteractionFragmentAt(pointList.getFirstPoint(), getHost()));
				request.getExtendedData().put(SequenceRequestConstant.TARGET_MODEL_CONTAINER, SequenceUtil.findInteractionFragmentAt(pointList.getLastPoint(), getHost()));

			}
		}

		return command;
	}

	/**
	 * Override to disable uphill message
	 */
	@Override
	protected Command getReconnectSourceCommand(ReconnectRequest request) {
		if(isUphillMessage(request)) {
			return null;
		}
		return super.getReconnectSourceCommand(request);
	}

	/**
	 * Override to disable uphill message
	 */
	@Override
	protected Command getReconnectTargetCommand(ReconnectRequest request) {
		if(isUphillMessage(request)) {
			return null;
		}
		return super.getReconnectTargetCommand(request);
	}

	/**
	 * Check that a message doesn't have its target point above its source point
	 * 
	 * @param request
	 *        the ReconnectRequest
	 * @return true if the target point is above the source point
	 */
	protected boolean isUphillMessage(ReconnectRequest request) {
		ConnectionEditPart connectionEditPart = request.getConnectionEditPart();
		if(connectionEditPart.getModel() instanceof Edge) {
			Edge edge = (Edge)connectionEditPart.getModel();
			if(edge.getElement() instanceof Message) {
				if(connectionEditPart.getFigure() instanceof Polyline) {
					Polyline polyline = (Polyline)connectionEditPart.getFigure();
					return polyline.getPoints().getFirstPoint().y >= polyline.getPoints().getLastPoint().y;
				}
			}
		}
		return false;
	}


}
