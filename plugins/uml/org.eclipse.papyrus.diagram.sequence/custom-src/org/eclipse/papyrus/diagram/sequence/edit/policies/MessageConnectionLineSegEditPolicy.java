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

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.FigureCanvas;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gef.ui.parts.ScrollingGraphicalViewer;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.SetConnectionAnchorsCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionBendpointEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.diagram.ui.util.SelectInDiagramHelper;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.LineMode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.papyrus.diagram.sequence.draw2d.routers.MessageRouter.RouterKind;

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
		Connection connection = getConnection();
		Edge edge = (Edge)request.getSource().getModel();

		PointList points = connection.getPoints();
		Point sourcePoint = points.getFirstPoint().getCopy();
		Point targetPoint = points.getLastPoint().getCopy();

		Point relativeSourcePoint = sourcePoint.getCopy();
		Point relativeTargetPoint = targetPoint.getCopy();

		// calculate relative anchor positions.
		connection.getSourceAnchor().getOwner().translateToRelative(relativeSourcePoint);
		connection.getSourceAnchor().getOwner().translateToRelative(relativeTargetPoint);

		// convert into a precision point which is stored by the GMF model
		PrecisionPoint spp = BaseSlidableAnchor.getAnchorRelativeLocation(relativeSourcePoint, connection.getSourceAnchor().getOwner().getBounds());
		PrecisionPoint tpp = BaseSlidableAnchor.getAnchorRelativeLocation(relativeTargetPoint, connection.getTargetAnchor().getOwner().getBounds());

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart)getHost()).getEditingDomain();

		CompositeCommand compositeCommand = new CompositeCommand("");

		// set the new anchor position
		SetConnectionAnchorsCommand setAnchorsCommand = new SetConnectionAnchorsCommand(editingDomain, null);
		setAnchorsCommand.setNewSourceTerminal(composeTerminalString(spp));
		setAnchorsCommand.setNewTargetTerminal(composeTerminalString(tpp));
		setAnchorsCommand.setEdgeAdaptor(new EObjectAdapter(edge));

		compositeCommand.add(setAnchorsCommand);

		// update bendpoints according to the new anchor positions
		SetConnectionBendpointsCommand setBendpointsCommand = new SetConnectionBendpointsCommand(editingDomain);
		setBendpointsCommand.setEdgeAdapter(new EObjectAdapter(edge));
		setBendpointsCommand.setNewPointList(connection.getPoints(), sourcePoint, targetPoint);

		compositeCommand.add(setBendpointsCommand);

		return new ICommandProxy(compositeCommand);
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

		if (kind.equals(RouterKind.HORIZONTAL)) {
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
