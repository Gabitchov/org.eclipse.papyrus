/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.layout;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.SetAllBendpointRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;

/**
 * 
 * This class is used to represent a link, to allow an alignment action. Its
 * provides fields to store the sources and the target and methods to do the
 * needed action to align the link extremities.
 * 
 * This alignment align the two anchors of a link. To do this, only one {@link EditPart} can moves.
 * 
 * TODO should be merge with LinkRepresentationForLayoutAction
 */
public class LinkRepresentation {

	/** the alignment */
	private final int align;

	/** the represented link */
	private final EditPart link;

	/** the representation of the source for the {@link #link} */
	private final EditPartRepresentation target;

	/** the representation of the target for the {@link #link} */
	private final EditPartRepresentation source;

	/** the {@link EditPartRepresentation} for the fixed {@link EditPart} */
	private EditPartRepresentation fixedEditPart = null;

	/** the {@link EditPartRepresentation} for the mowing {@link EditPart} */
	private EditPartRepresentation movedEditPart = null;

	/** the reference point for this action (this point will not move) */
	private Point referencePoint;

	/** the point which moves to do the action */
	private Point movedPoint;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param link
	 *        the represented link
	 * @param source
	 *        the representation of the source of the link
	 * @param target
	 *        the representation of the target of the link
	 * @param alignment
	 *        the alignment
	 */
	public LinkRepresentation(EditPart link, EditPartRepresentation source, EditPartRepresentation target, int alignment) {
		this.link = link;
		this.target = target;
		this.source = source;
		this.align = alignment;
	}

	/**
	 * Getter for {@link #link}
	 * 
	 * @return {@link #link}
	 */
	public EditPart getLink() {
		return this.link;
	}

	/**
	 * Getter for {@link #source}
	 * 
	 * @return {@link #source}
	 */
	public EditPartRepresentation getSource() {
		return this.source;
	}

	/**
	 * Getter for {@link #target}
	 * 
	 * @return {@link #target}
	 */
	public EditPartRepresentation getTarget() {
		return this.target;
	}

	/**
	 * Returns the command to align the node with a common link
	 * 
	 * @return the command to align the node with a common link
	 */
	public Command getCommand() {
		initializeReferences();
		buildRequest();
		CompoundCommand command = new CompoundCommand("Align with a link"); //$NON-NLS-1$
		Command cmd;

		// the command to align the node
		cmd = movedEditPart.getCommand();
		if(cmd != null && cmd.canExecute()) {
			command.add(cmd);
		}

		// the command to reset the anchor location
		cmd = preserveAnchorLocationCommand();
		if(cmd.canExecute()) {
			command.add(cmd);
		}

		// we want zero bendpoint, and keep the current source and target
		Request onlyTwoBendpoints = new SetAllBendpointRequest(org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants.REQ_SET_ALL_BENDPOINT, new PointList(), null, null);
		command.add(link.getCommand(onlyTwoBendpoints));

		return command;
	}

	/**
	 * Builds the requests for this {@link LinkRepresentation}
	 */
	protected void buildRequest() {
		int shift = 0;
		PrecisionRectangle absolutePosition = movedEditPart.getPosition();
		PrecisionPoint oldLocation = new PrecisionPoint(absolutePosition.getTopLeft());
		PrecisionPoint newLocation = new PrecisionPoint(oldLocation);

		/* we calculate the shift for the editpart */
		switch(this.align) {
		case PositionConstants.LEFT:// it's the left figure we move
			shift = referencePoint.y - movedPoint.y;
			movedPoint.y += shift;
			newLocation.setLocation(newLocation.x, newLocation.y + shift);
			break;
		case PositionConstants.RIGHT:// it's the right figure we move
			shift = referencePoint.y - movedPoint.y;
			movedPoint.y += shift;
			newLocation.setLocation(newLocation.x, newLocation.y + shift);
			break;

		case PositionConstants.TOP:// it's the top figure we move
			shift = referencePoint.x - movedPoint.x;
			movedPoint.x += shift;
			newLocation.setLocation(newLocation.x + shift, newLocation.y);
			break;
		case PositionConstants.BOTTOM:// it's the bottom figure we move
			shift = referencePoint.x - movedPoint.x;
			movedPoint.x += shift;
			newLocation.setLocation(newLocation.x + shift, newLocation.y);
			break;
		}

		// we correct the location to avoid the scrollbar!
		// the parent bounds
		PrecisionRectangle parentBounds = LayoutUtils.getAbsolutePosition(movedEditPart.getRepresentedEditPart().getParent());
		if(this.align == PositionConstants.LEFT || this.align == PositionConstants.RIGHT) {
			if((newLocation.y < (parentBounds.y + LayoutUtils.scrollBarSize)) && (shift < 0)) {
				newLocation.setLocation(newLocation.x, parentBounds.y + (int)LayoutUtils.scrollBarSize);
			} else if(((newLocation.y + absolutePosition.height) > parentBounds.getBottomLeft().y) && (shift > 0)) {
				newLocation.setLocation(newLocation.x, parentBounds.getBottomLeft().y - ((int)LayoutUtils.scrollBarSize + absolutePosition.height));
			}
		} else if(this.align == PositionConstants.TOP || this.align == PositionConstants.BOTTOM) {
			if((newLocation.x < (parentBounds.x + LayoutUtils.scrollBarSize)) && (shift < 0)) {
				newLocation.setLocation(parentBounds.x + (int)LayoutUtils.scrollBarSize, newLocation.y);
			} else if(((newLocation.x + absolutePosition.width) > parentBounds.getBottomRight().x) && (shift > 0)) {
				newLocation.setLocation(parentBounds.getBottomRight().x - ((int)LayoutUtils.scrollBarSize + absolutePosition.width), newLocation.y);
			}
		}

		// request creation
		ChangeBoundsRequest req = new ChangeBoundsRequest(RequestConstants.REQ_MOVE);
		req.setEditParts(movedEditPart.getRepresentedEditPart());

		Dimension delta = newLocation.getDifference(oldLocation);
		req.setMoveDelta(new Point(delta.width, delta.height));
		req.setSizeDelta(new Dimension(0, 0));
		movedEditPart.setRequest(req);
		movedEditPart.setMoveDelta(delta);
	}

	/**
	 * This method initializes the following fields :
	 * <ul>
	 * <li> {@link #fixedEditPart}</li>
	 * <li> {@link #movedEditPart}</li>
	 * <li> {@link #referencePoint}</li>
	 * <li> {@link #movedPoint}</li>
	 * </ul>
	 * 
	 * It determines the reference point and the reference editpart for the
	 * alignment
	 */
	protected void initializeReferences() {
		PrecisionRectangle absolutePositionSource = LayoutUtils.getAbsolutePosition(source.getRepresentedEditPart());
		PrecisionRectangle absolutePositionTarget = LayoutUtils.getAbsolutePosition(target.getRepresentedEditPart());

		switch(this.align) {
		case PositionConstants.LEFT:
			if(absolutePositionSource.preciseX < absolutePositionTarget.preciseX) {// the
																					// left
																					// node
																					// moves
				fixedEditPart = target;
			} else {
				fixedEditPart = source;
			}
			break;
		case PositionConstants.RIGHT:
			if(absolutePositionSource.preciseX > absolutePositionTarget.preciseX) {// the
																					// right
																					// node
																					// moves
				fixedEditPart = target;
			} else {
				fixedEditPart = source;
			}
			break;
		case PositionConstants.TOP:
			if(absolutePositionSource.preciseY < absolutePositionTarget.preciseY) {// the
																					// top
																					// node
																					// moves
				fixedEditPart = target;
			} else {
				fixedEditPart = source;
			}
			break;
		case PositionConstants.BOTTOM:
			if(absolutePositionSource.preciseY > absolutePositionTarget.preciseY) {// the
																					// bottom
																					// node
																					// moves
				fixedEditPart = target;
			} else {
				fixedEditPart = source;
			}
			break;
		}
		assert (fixedEditPart != null);
		movedEditPart = (source == fixedEditPart) ? target : source;

		PolylineConnectionEx figure = (PolylineConnectionEx)((AbstractConnectionEditPart)link).getFigure();

		if(fixedEditPart == source) {
			referencePoint = figure.getStart();
			movedPoint = figure.getEnd();
		} else {
			referencePoint = figure.getEnd();
			movedPoint = figure.getStart();
		}

		// we move the reference point with its delta. This delta comes from
		// another shift, were the editpart was the moved editpart and not the
		// reference
		Dimension delta = fixedEditPart.getMoveDelta();
		referencePoint.translate(delta);

		figure.translateToAbsolute(referencePoint);
		figure.translateToAbsolute(movedPoint);
	}

	/**
	 * Returns the side on which the anchor is on the {@link #source}
	 * 
	 * @return the side on which the anchor is on the {@link #source}
	 */
	public int getLinkSideOnSource() {

		PolylineConnectionEx figure = (PolylineConnectionEx)((AbstractConnectionEditPart)link).getFigure();
		Point sourcePoint = figure.getStart();
		figure.translateToAbsolute(sourcePoint);
		return LayoutUtils.getAnchorPosition(source.getRepresentedEditPart(), sourcePoint);
	}

	/**
	 * Returns the side on which the anchor is on the {@link #target}
	 * 
	 * @return the side on which the anchor is on the {@link #target}
	 */
	public int getLinkSideOnTarget() {

		PolylineConnectionEx figure = (PolylineConnectionEx)((AbstractConnectionEditPart)link).getFigure();
		Point targetPoint = figure.getEnd();
		figure.translateToAbsolute(targetPoint);
		return LayoutUtils.getAnchorPosition(target.getRepresentedEditPart(), targetPoint);
	}

	/**
	 * Creates and returns the command to reset the connection anchors after
	 * alignment to their initial location
	 * 
	 * 
	 * 
	 * @return the command to reset the connection anchors to their initial
	 *         location after the node shifting
	 * 
	 */
	protected Command preserveAnchorLocationCommand() {
		CompoundCommand command = new CompoundCommand("Preserve Anchor"); //$NON-NLS-1$

		Command cmd;
		if(movedEditPart == source) {
			// the moved editpart is the source
			ReconnectRequest reconnectRequest = new ReconnectRequest();
			reconnectRequest.setType(GraphicalNodeEditPolicy.REQ_RECONNECT_SOURCE);
			reconnectRequest.setConnectionEditPart((ConnectionEditPart)this.link);
			reconnectRequest.setTargetEditPart(source.getRepresentedEditPart());
			reconnectRequest.setLocation(movedPoint.getTranslated(-movedEditPart.getMoveDelta().width, -movedEditPart.getMoveDelta().height));
			cmd = source.getRepresentedEditPart().getCommand(reconnectRequest);
			command.add(cmd);

			// the fixed editpart is the target
			ReconnectRequest reconnectRequestTarget = new ReconnectRequest();
			reconnectRequestTarget.setType(GraphicalNodeEditPolicy.REQ_RECONNECT_TARGET);
			reconnectRequestTarget.setConnectionEditPart((ConnectionEditPart)this.link);
			reconnectRequestTarget.setTargetEditPart(target.getRepresentedEditPart());
			reconnectRequestTarget.setLocation(referencePoint.getTranslated(-fixedEditPart.getMoveDelta().width, -fixedEditPart.getMoveDelta().height));
			cmd = target.getRepresentedEditPart().getCommand(reconnectRequestTarget);
			command.add(cmd);
		} else {
			// the moved editpart is the target
			ReconnectRequest reconnectRequest = new ReconnectRequest();
			reconnectRequest.setType(GraphicalNodeEditPolicy.REQ_RECONNECT_TARGET);
			reconnectRequest.setConnectionEditPart((ConnectionEditPart)this.link);
			reconnectRequest.setTargetEditPart(target.getRepresentedEditPart());
			reconnectRequest.setLocation(movedPoint.getTranslated(-movedEditPart.getMoveDelta().width, -movedEditPart.getMoveDelta().height));
			cmd = target.getRepresentedEditPart().getCommand(reconnectRequest);
			command.add(cmd);

			// the fixed editpart is the source
			ReconnectRequest reconnectRequestTarget = new ReconnectRequest();
			reconnectRequestTarget.setType(GraphicalNodeEditPolicy.REQ_RECONNECT_SOURCE);
			reconnectRequestTarget.setConnectionEditPart((ConnectionEditPart)this.link);
			reconnectRequestTarget.setTargetEditPart(source.getRepresentedEditPart());
			reconnectRequestTarget.setLocation(referencePoint.getTranslated(-fixedEditPart.getMoveDelta().width, -fixedEditPart.getMoveDelta().height));
			cmd = source.getRepresentedEditPart().getCommand(reconnectRequestTarget);
			command.add(cmd);
		}
		return command;
	}
}
