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

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Polyline;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionBendpointEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.util.SelectInDiagramHelper;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.LineMode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.papyrus.diagram.sequence.draw2d.routers.MessageRouter.RouterKind;
import org.eclipse.papyrus.diagram.sequence.edit.parts.LifelineEditPart;
import org.eclipse.papyrus.diagram.sequence.util.OccurrenceSpecificationMoveHelper;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.OccurrenceSpecification;

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
		if(isHorizontal()) {
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
					int y = request.getLocation().y;
					List<EditPart> empty = Collections.emptyList();
					Command srcCmd = OccurrenceSpecificationMoveHelper.getMoveOccurrenceSpecificationsCommand((OccurrenceSpecification)send, null, y, -1, srcLifelinePart, empty);
					Command tgtCmd = OccurrenceSpecificationMoveHelper.getMoveOccurrenceSpecificationsCommand((OccurrenceSpecification)rcv, null, y, -1, tgtLifelinePart, empty);
					CompoundCommand compoudCmd = new CompoundCommand();
					/*
					 * Take care of the order of commands, to make sure target is always bellow the source.
					 * Otherwise, moving the target above the source would cause order conflict with existing CF.
					 */
					Point oldLocation = SequenceUtil.getAbsoluteEdgeExtremity(connectionPart, true);
					if(oldLocation != null) {
						int oldY = oldLocation.y;
						if(oldY < y) {
							tgtCmd.setLabel("target from " + oldY + " to " + y);
							compoudCmd.add(tgtCmd);
							compoudCmd.add(srcCmd);
						} else {
							srcCmd.setLabel("source from " + oldY + " to " + y);
							compoudCmd.add(srcCmd);
							compoudCmd.add(tgtCmd);
						}
						return compoudCmd;
					}
				}
			}
		}
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * don't show feedback if the drag is forbidden (message not horizontal).
	 */
	@Override
	public void showSourceFeedback(Request request) {
		if(request instanceof BendpointRequest) {
			if(isHorizontal()) {
				super.showSourceFeedback(request);
			}
		}
	}

	private boolean isHorizontal() {
		Connection connection = getConnection();
		RouterKind kind = RouterKind.getKind(connection, connection.getPoints());

		if(kind.equals(RouterKind.HORIZONTAL)) {
			return true;
		}
		return false;
	}

	final private static char TERMINAL_START_CHAR = '(';

	final private static char TERMINAL_DELIMITER_CHAR = ',';

	final private static char TERMINAL_END_CHAR = ')';

	private static String composeTerminalString(PrecisionPoint p) {
		StringBuffer s = new StringBuffer(24);
		s.append(TERMINAL_START_CHAR); // 1 char
		s.append(p.preciseX); // 10 chars
		s.append(TERMINAL_DELIMITER_CHAR); // 1 char
		s.append(p.preciseY); // 10 chars
		s.append(TERMINAL_END_CHAR); // 1 char
		return s.toString(); // 24 chars max (+1 for safety, i.e. for string termination)
	}


}
