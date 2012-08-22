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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.AbstractRouter;
import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.ConnectionRouter;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.PolylineConnection;
import org.eclipse.draw2d.RoutingListener;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionBendpointEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.util.SelectInDiagramHelper;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.LineMode;
import org.eclipse.papyrus.uml.diagram.sequence.draw2d.routers.MessageRouter.RouterKind;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.uml.diagram.sequence.part.Messages;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationMoveHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.papyrus.uml.diagram.sequence.edit.parts.Message2EditPart;

/**
 * This bendpoint edit policy is used to allow drag of horizontal messages and forbid drag otherwise.
 * 
 * @author mvelten
 * 
 */
@SuppressWarnings("restriction")
public class MessageConnectionLineSegEditPolicy extends ConnectionBendpointEditPolicy {

	public MessageConnectionLineSegEditPolicy() {
		super(LineMode.ORTHOGONAL_FREE);
	}

	@Override
	public Command getCommand(Request request) {		
		RouterKind kind = RouterKind.getKind(getConnection(), getConnection().getPoints());
		if(kind == RouterKind.SELF || kind == RouterKind.HORIZONTAL){
			return super.getCommand(request);
		}
		return null;
	}

	/**
	 * Move the anchors along with the line and update bendpoints accordingly.
	 */
	@Override
	protected Command getBendpointsChangedCommand(BendpointRequest request) {
		if((getHost().getViewer() instanceof ScrollingGraphicalViewer) && (getHost().getViewer().getControl() instanceof FigureCanvas)) {
			SelectInDiagramHelper.exposeLocation((FigureCanvas)getHost().getViewer().getControl(), request.getLocation().getCopy());
		}

		if(getHost() instanceof ConnectionNodeEditPart) {
			ConnectionNodeEditPart connectionPart = (ConnectionNodeEditPart)getHost();
			EObject message = connectionPart.resolveSemanticElement();
			if(message instanceof Message) {
				MessageEnd send = ((Message)message).getSendEvent();
				MessageEnd rcv = ((Message)message).getReceiveEvent();
				EditPart srcPart = connectionPart.getSource();
				LifelineEditPart srcLifelinePart = SequenceUtil.getParentLifelinePart(srcPart);
				EditPart tgtPart = connectionPart.getTarget();
				LifelineEditPart tgtLifelinePart = SequenceUtil.getParentLifelinePart(tgtPart);
				if(send instanceof OccurrenceSpecification && rcv instanceof OccurrenceSpecification && srcLifelinePart != null && tgtLifelinePart != null) {
					RouterKind kind = RouterKind.getKind(getConnection(), getConnection().getPoints());
					if(getHost() instanceof Message2EditPart && kind == RouterKind.SELF){	
						return getSelfLinkMoveCommand(request, connectionPart, send, rcv, srcLifelinePart);
					}else{
						int y = request.getLocation().y;
						List<EditPart> empty = Collections.emptyList();
						Command srcCmd = OccurrenceSpecificationMoveHelper.getMoveOccurrenceSpecificationsCommand((OccurrenceSpecification)send, null, y, -1, srcLifelinePart, empty);
						Command tgtCmd = OccurrenceSpecificationMoveHelper.getMoveOccurrenceSpecificationsCommand((OccurrenceSpecification)rcv, null, y, -1, tgtLifelinePart, empty);
						CompoundCommand compoudCmd = new CompoundCommand(Messages.MoveMessageCommand_Label);
						/*
						 * Take care of the order of commands, to make sure target is always bellow the source.
						 * Otherwise, moving the target above the source would cause order conflict with existing CF.
						 */
						Point oldLocation = SequenceUtil.getAbsoluteEdgeExtremity(connectionPart, true);
						if(oldLocation != null) {
							int oldY = oldLocation.y;
							if(oldY < y) {
								compoudCmd.add(tgtCmd);
								compoudCmd.add(srcCmd);
							} else {
								compoudCmd.add(srcCmd);
								compoudCmd.add(tgtCmd);
							}
							return compoudCmd;
						}
					}
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected Command getSelfLinkMoveCommand(BendpointRequest request, ConnectionNodeEditPart connectionPart, MessageEnd send, MessageEnd rcv, LifelineEditPart srcLifelinePart) {
		CompoundCommand compoudCmd = new CompoundCommand(Messages.MoveMessageCommand_Label);
		PointList points = getConnection().getPoints();
		Point sourceRefPoint = points.getFirstPoint();;
		Point targetRefPoint = points.getLastPoint();;
		getConnection().translateToAbsolute(sourceRefPoint);
		getConnection().translateToAbsolute(targetRefPoint);
		
		Point oldSourcePoint = SequenceUtil.findLocationOfEvent(srcLifelinePart, (OccurrenceSpecification)send);
		int dy = sourceRefPoint.y - oldSourcePoint.y;
		int dx = request.getLocation().x > sourceRefPoint.x ? 3 : -3;
		
		// check bounds
		NodeFigure fig = srcLifelinePart.getPrimaryShape().getFigureLifelineDotLineFigure().getDashLineRectangle();
		Rectangle bounds = fig.getBounds().getCopy();
		fig.translateToAbsolute(bounds);
		
		bounds.expand(6, 0);
		if(!bounds.contains(sourceRefPoint) || !bounds.contains(targetRefPoint)){
			return UnexecutableCommand.INSTANCE; // cannot move outside lifeline part
		}
		sourceRefPoint = sourceRefPoint.translate(dx, 0);
		targetRefPoint = targetRefPoint.translate(dx, 0);
		Command srcCmd = getReconnectCommand(connectionPart, srcLifelinePart, sourceRefPoint, RequestConstants.REQ_RECONNECT_SOURCE);
		Command tgtCmd = getReconnectCommand(connectionPart, srcLifelinePart, targetRefPoint, RequestConstants.REQ_RECONNECT_TARGET);
		
		if(dy < 0){  // move up
			compoudCmd.add(srcCmd);
			compoudCmd.add(tgtCmd);
		}else{      // move down
			compoudCmd.add(tgtCmd);
			compoudCmd.add(srcCmd);
		}
		return compoudCmd;
	}

	protected Command getReconnectCommand(ConnectionNodeEditPart connectionPart, LifelineEditPart targetPart, Point location, String requestType) {
		// Create and set the properties of the request
		ReconnectRequest reconnReq = new ReconnectRequest();
		reconnReq.setConnectionEditPart(connectionPart);
		reconnReq.setLocation(location);
		reconnReq.setTargetEditPart(targetPart);
		reconnReq.setType(requestType);
		// add a parameter to bypass the move impact to avoid infinite loop
		reconnReq.getExtendedData().put(SequenceRequestConstant.DO_NOT_MOVE_EDIT_PARTS, true);
		Command cmd = targetPart.getCommand(reconnReq);
		return cmd;
	}

	/**
	 * don't show feedback if the drag is forbidden (message not horizontal).
	 */
	@Override
	public void showSourceFeedback(Request request) {		
		if(request instanceof BendpointRequest) {
			RouterKind kind = RouterKind.getKind(getConnection(), getConnection().getPoints());
			if(kind == RouterKind.SELF || kind == RouterKind.HORIZONTAL){
				super.showSourceFeedback(request);
			}
		}		
	}

	private ConnectionRouter router;
	
	static class DummyRouter extends AbstractRouter {

		public void route(Connection conn) {
		}
	}
	
	protected void showMoveLineSegFeedback(BendpointRequest request) {				
		RouterKind kind = RouterKind.getKind(getConnection(), getConnection().getPoints());
		if(getHost() instanceof Message2EditPart && kind == RouterKind.SELF ){
			if(router == null){
				router = getConnection().getConnectionRouter();
				getConnection().setConnectionRouter( new DummyRouter()); 
			}
			PointList linkPoints = getConnection().getPoints().getCopy();
	
			Point ptLoc = new Point(request.getLocation());
			getConnection().translateToRelative(ptLoc);
			int dy = 0;
			if(request.getIndex() == 0)
				dy =  ptLoc.y - linkPoints.getFirstPoint().y;
			else if(request.getIndex() == 2)
				dy =  ptLoc.y - linkPoints.getLastPoint().y;
			
			// move each point on link
			int size = linkPoints.size();
			for(int i = 0; i < size; i ++){
				Point p = linkPoints.getPoint(i).translate(0, dy);
				linkPoints.setPoint(p, i);
			}						
			
			// link should not exceed lifeline bounds  
			if(checkBounds(linkPoints)){
				getConnection().setPoints(linkPoints);
				getConnection().getLayoutManager().layout(getConnection());
			}
			return;
		}
		super.showMoveLineSegFeedback(request);
	}

	protected boolean checkBounds(PointList linkPoints) {
		EditPart sourcePart = ((ConnectionNodeEditPart)getHost()).getSource();
		if(sourcePart instanceof LifelineEditPart){
			LifelineEditPart lep = (LifelineEditPart)sourcePart;
			NodeFigure fig = lep.getPrimaryShape().getFigureLifelineDotLineFigure().getDashLineRectangle();
			Rectangle bounds = fig.getBounds().getCopy();
			fig.translateToAbsolute(bounds);
			
			Rectangle conBounds = linkPoints.getBounds();
			getConnection().translateToAbsolute(conBounds);
			// check top and bottom y limit
			if(conBounds.y <= bounds.y || conBounds.getBottom().y >= bounds.getBottom().y)
				return false;
		}
		return true;
	}
	
	@Override
	protected void eraseConnectionFeedback(BendpointRequest request, boolean removeFeedbackFigure) {
		getConnection().setVisible(true);
		super.eraseConnectionFeedback(request, removeFeedbackFigure);

		if(router != null)
			getConnection().setConnectionRouter(router);
		router = null;		
	}

//	private boolean isHorizontal() {
//		Connection connection = getConnection();
//		RouterKind kind = RouterKind.getKind(connection, connection.getPoints());
//
//		if(kind.equals(RouterKind.HORIZONTAL)) {
//			return true;
//		}
//		return false;
//	}
//
//	final private static char TERMINAL_START_CHAR = '(';
//
//	final private static char TERMINAL_DELIMITER_CHAR = ',';
//
//	final private static char TERMINAL_END_CHAR = ')';
//
//	private static String composeTerminalString(PrecisionPoint p) {
//		StringBuffer s = new StringBuffer(24);
//		s.append(TERMINAL_START_CHAR); // 1 char
//		s.append(p.preciseX); // 10 chars
//		s.append(TERMINAL_DELIMITER_CHAR); // 1 char
//		s.append(p.preciseY); // 10 chars
//		s.append(TERMINAL_END_CHAR); // 1 char
//		return s.toString(); // 24 chars max (+1 for safety, i.e. for string termination)
//	}
}
