/*****************************************************************************
 * Copyright (c) 2009 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.DropRequest;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.draw2d.anchors.LifelineAnchor;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;

public class LifelineMessageCreateHelper {

	public static class ComponentEditPolicyEx extends ComponentEditPolicy {

		@Override
		protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
			Command command = super.createDeleteViewCommand(deleteRequest);
			if(command != null && getHost() instanceof LifelineEditPart)
				command = moveLifelineUp(command, (LifelineEditPart)getHost());
			return command;
		}
	}
	
	public static ConnectionAnchor getCreateMessageAnchor(LifelineEditPart part, Request request, Point location) {
		IFigure fig = part.getPrimaryShape().getFigureLifelineNameContainerFigure();
		fig.translateToRelative(location);
		if(fig.containsPoint(location)) {// move to header
			return new LifelineAnchor(part.getPrimaryShape().getFigureLifelineNameContainerFigure());
		}
		// move to dash line
		return getTargetConnectionAnchor(part, request);
	}
	
	static ConnectionAnchor getTargetConnectionAnchor(LifelineEditPart part, Request request) {
		if (request instanceof ReconnectRequest) {
			if (((DropRequest) request).getLocation() == null) {
				return part.getNodeFigure().getTargetConnectionAnchorAt(null);
			}
			Point pt = ((DropRequest) request).getLocation().getCopy();
			return part.getNodeFigure().getTargetConnectionAnchorAt(pt);
		}
		else if (request instanceof DropRequest){
			return part.getNodeFigure().getTargetConnectionAnchorAt(
				((DropRequest) request).getLocation());
		}
		return part.getNodeFigure().getTargetConnectionAnchorAt(null);
	}

	public static Command moveLifelineUp(Command command, LifelineEditPart part) {
		List list = part.getSourceConnections();
		if(list != null && list.size() > 0) {
			for(Object l : list)
				if(l instanceof Message4EditPart) {
					EditPart target = ((Message4EditPart)l).getTarget();
					if(target instanceof LifelineEditPart && getIncomingMessageCreate(target).size() == 1) {
						LifelineEditPart lp = (LifelineEditPart)target;
						ICommand boundsCommand = new SetBoundsCommand(lp.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(lp.getNotationView()), new Point(lp.getPrimaryShape().getBounds().x, SequenceUtil.LIFELINE_VERTICAL_OFFSET));
						command = command.chain(new ICommandProxy(boundsCommand));
					}
				}
		}
		return command;
	}

	public static boolean hasMessageCreate(GraphicalEditPart sourceEditPart, EditPart targetEditPart) {
		List list = sourceEditPart.getSourceConnections();
		for(Object o : list)
			if(o instanceof Message4EditPart && targetEditPart.equals(((Message4EditPart)o).getTarget())){
				return true;
			}
		return false;
	}
	
	public static boolean hasIncomingMessageCreate(EditPart target) {
		return getIncomingMessageCreate(target).size() > 0;
	}

	public static List getIncomingMessageCreate(EditPart target) {
		List create = new ArrayList();
		if(target instanceof LifelineEditPart) {
			List list = ((LifelineEditPart)target).getTargetConnections();
			if(list != null && list.size() > 0) {
				for(Object l : list)
					if(l instanceof Message4EditPart) {
						create.add(l);
					}
			}
		}
		return create;
	}
	
	public static boolean canReconnectMessageCreate(ReconnectRequest request){
		Message4EditPart connPart = (Message4EditPart)request.getConnectionEditPart();
		if(request.isMovingStartAnchor()){  // reconnect source
			if( hasMessageCreate( (GraphicalEditPart)request.getTarget(), (GraphicalEditPart)connPart.getTarget()))
				return false;
		}else{  // reconnect target
			if( hasMessageCreate((GraphicalEditPart)connPart.getSource(), request.getTarget()))
				return false;
		}
		return true;
	}

	public static Command reconnectMessageCreate(ReconnectRequest request, Command command) {
		LifelineEditPart oldTarget = (LifelineEditPart)request.getConnectionEditPart().getTarget();
		LifelineEditPart source = (LifelineEditPart)request.getConnectionEditPart().getSource();
		LifelineEditPart newTarget = (LifelineEditPart)request.getTarget();
		// move up the original connection target lifeline, it has only one create message, which will be removed
		if(getIncomingMessageCreate(oldTarget).size() == 1) {
			ICommand boundsCommand = new SetBoundsCommand(oldTarget.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(oldTarget.getNotationView()), new Point(oldTarget.getPrimaryShape().getBounds().x, SequenceUtil.LIFELINE_VERTICAL_OFFSET));
			command = command.chain(new ICommandProxy(boundsCommand));
		}

		//move down the new connection target lifeline
		command = moveLifelineDown(command, newTarget, source.getFigure().getBounds().getLocation().getCopy());
		return command;
	}

	public static Command moveLifelineDown(Command command, LifelineEditPart part, Point sourcePointCopy) {
		View targetView = part.getNotationView();
		Rectangle bounds = part.getFigure().getBounds();
		int centerHeight = part.getPrimaryShape().getFigureLifelineNameContainerFigure().getBounds().getSize().height / 2 + 5;
		Point location = new Point(bounds.x, Math.max(bounds.y, sourcePointCopy.y() + centerHeight));
		if(location.y != bounds.y) {
			ICommand boundsCommand = new SetBoundsCommand(part.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(targetView), location);
			command = command.chain(new ICommandProxy(boundsCommand));

			List list = part.getSourceConnections();
			if(list != null && list.size() > 0) {
				for(Object l : list)
					if(l instanceof Message4EditPart) {
						EditPart target = ((Message4EditPart)l).getTarget();
						if(target instanceof LifelineEditPart) {
							moveLifelineDown(command, (LifelineEditPart)target, location.getCopy());
						}
					}
			}
		}

		return command;
	}

	public static boolean canMoveLifelineVertical(LifelineEditPart child, Rectangle newBounds) {
		int halfHeight = child.getPrimaryShape().getFigureLifelineNameContainerFigure().getBounds().height / 2;
		// check outgoing links
		List list = child.getSourceConnections();
		if(list != null && list.size() > 0) {
			for(Object l : list)
				if(l instanceof Message4EditPart && ((Message4EditPart)l).getTarget() instanceof LifelineEditPart) {
					LifelineEditPart lowPart = (LifelineEditPart)((Message4EditPart)l).getTarget();
					Rectangle outBounds = lowPart.getFigure().getBounds();
					if(outBounds.y - newBounds.y < halfHeight)
						return false;
				}
		}
		// check incoming links
		list = child.getTargetConnections();
		if(list != null && list.size() > 0) {
			for(Object l : list)
				if(l instanceof Message4EditPart && ((Message4EditPart)l).getSource() instanceof LifelineEditPart) {
					LifelineEditPart highPart = (LifelineEditPart)((Message4EditPart)l).getSource();
					Rectangle inBounds = highPart.getFigure().getBounds();
					if(newBounds.y - inBounds.y < halfHeight)
						return false;

					if(newBounds.y > inBounds.getBottom().y - halfHeight)
						return false;
				}
		}

		return true;
	}
}
