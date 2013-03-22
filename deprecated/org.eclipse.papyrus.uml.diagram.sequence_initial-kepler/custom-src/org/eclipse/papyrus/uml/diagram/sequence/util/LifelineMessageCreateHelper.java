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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.impl.ShapeImpl;
import org.eclipse.papyrus.uml.diagram.common.draw2d.anchors.LifelineAnchor;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message4EditPart;

public class LifelineMessageCreateHelper {

	public static class ComponentEditPolicyEx extends ComponentEditPolicy {

		@Override
		protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
			Command command = super.createDeleteViewCommand(deleteRequest);
			if(command != null && getHost() instanceof LifelineEditPart)
				command = restoreLifelineOnDelete(command, (LifelineEditPart)getHost());
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
	
	//when a create message is deleted, move its target lifelines up
	public static Command restoreLifelineOnMessageDelete(Command commands, EditPart editPart){
		if(editPart instanceof Message4EditPart) {
			Message4EditPart part = (Message4EditPart)editPart;
			if(part.getTarget() instanceof LifelineEditPart && LifelineMessageCreateHelper.getIncomingMessageCreate(part.getTarget()).size() == 1){
				LifelineEditPart target = (LifelineEditPart)part.getTarget();
				if(target.getModel() instanceof Shape){
					Shape view = (ShapeImpl) target.getModel();
					if(view.getLayoutConstraint() instanceof Bounds){
						Bounds bounds = (Bounds) view.getLayoutConstraint();
						ICommand boundsCommand = new SetBoundsCommand(
								target.getEditingDomain(),
								DiagramUIMessages.SetLocationCommand_Label_Resize,
								new EObjectAdapter(view), new Point(bounds.getX(),SequenceUtil.LIFELINE_VERTICAL_OFFSET));
						commands = commands.chain(new ICommandProxy(boundsCommand));
						int dy = SequenceUtil.LIFELINE_VERTICAL_OFFSET - bounds.getY();
						commands = moveCascadeLifeline(target, commands, dy);
					}
				}
			}
		}
		return commands;
	}

	// when a lifleine is deleted, move its created lifelines up
	public static Command restoreLifelineOnDelete(Command command, LifelineEditPart part) {
		List list = part.getSourceConnections();
		if(list != null && list.size() > 0) {
			for(Object l : list)
				if(l instanceof Message4EditPart) {
					EditPart target = ((Message4EditPart)l).getTarget();
					if(target instanceof LifelineEditPart && getIncomingMessageCreate(target).size() == 1) {
						LifelineEditPart lp = (LifelineEditPart)target;
						Rectangle bounds = lp.getPrimaryShape().getBounds();
						Point location = new Point(bounds.x, SequenceUtil.LIFELINE_VERTICAL_OFFSET);
						int dy = location.y - bounds.y;
						ICommand boundsCommand = new SetBoundsCommand(lp.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(lp.getNotationView()), location);
						command = command.chain(new ICommandProxy(boundsCommand));
						command = moveCascadeLifeline(lp, command, dy);
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

	public static Command reconnectMessageCreateTarget(ReconnectRequest request, Command command) {
		LifelineEditPart oldTarget = (LifelineEditPart)request.getConnectionEditPart().getTarget();
		LifelineEditPart source = (LifelineEditPart)request.getConnectionEditPart().getSource();
		LifelineEditPart newTarget = (LifelineEditPart)request.getTarget();
		// move up the original connection target lifeline, it has only one create message, which will be removed
		if(getIncomingMessageCreate(oldTarget).size() == 1) {
			Rectangle bounds = oldTarget.getPrimaryShape().getBounds();
			Point location = new Point(bounds.x, SequenceUtil.LIFELINE_VERTICAL_OFFSET);
			int dy = location.y - bounds.y;
			ICommand boundsCommand = new SetBoundsCommand(oldTarget.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(oldTarget.getNotationView()), location);
			command = command.chain(new ICommandProxy(boundsCommand));
			command = moveCascadeLifeline(oldTarget, command, dy);
		}

		//move down the new connection target lifeline
		command = moveLifelineDown(command, newTarget, request.getLocation().getCopy());
		return command;
	}

	public static Command moveLifelineDown(Command command, LifelineEditPart part, Point sourcePointCopy) {
		IFigure fig = part.getFigure();
		Rectangle bounds = fig.getBounds().getCopy();
		fig.translateToAbsolute(bounds);
		int height = part.getPrimaryShape().getFigureLifelineNameContainerFigure().getBounds().height;
		Point location = new Point(bounds.x, Math.max(bounds.y, sourcePointCopy.y() - height / 2));
		
		View targetView = part.getNotationView();
		if(location.y != bounds.y) {
			int dy = location.y - bounds.y;
			fig.translateToRelative(location);
			fig.translateToParent(location);
			
			ICommand boundsCommand = new SetBoundsCommand(part.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(targetView), location);
			command = command.chain(new ICommandProxy(boundsCommand));
			command = moveCascadeLifeline(part, command, dy);
		}

		return command;
	}

	// move all lifelines which has incoming create link from part
	public static Command moveCascadeLifeline(LifelineEditPart part, Command command, int dy) {
		List list = part.getSourceConnections();
		if(list != null && list.size() > 0) {
			for(Object l : list)
				if(l instanceof Message4EditPart) {
					EditPart target = ((Message4EditPart)l).getTarget();
					if(target instanceof LifelineEditPart) {
						LifelineEditPart lp = (LifelineEditPart)target;
						Rectangle bounds = lp.getFigure().getBounds().getCopy();
						View targetView = lp.getNotationView();
						Point location = bounds.getLocation().getCopy().translate(0, dy);
						Command boundsCommand = new ICommandProxy(new SetBoundsCommand(part.getEditingDomain(), DiagramUIMessages.SetLocationCommand_Label_Resize, new EObjectAdapter(targetView), location));
						// Take care of the order of commands, to make sure target is always bellow the source.
						if(dy < 0){ // move up
							command = command == null? boundsCommand: command.chain(boundsCommand);
							command = moveCascadeLifeline(lp, command, dy); 
						}else{ // move down
							command = moveCascadeLifeline(lp, command, dy);
							command = command == null? boundsCommand: command.chain(boundsCommand);
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
