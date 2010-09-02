/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.layout;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.editparts.AbstractConnectionEditPart;
import org.eclipse.gef.editpolicies.GraphicalNodeEditPolicy;
import org.eclipse.gef.requests.ReconnectRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;


/**
 * 
 * This class allows to represent a ConnectionEditPart for the layout actions.
 * Often, we want move an anchor of the link and fixed the other.
 * This class provides methods and command do to that easily.
 * 
 */
public abstract class LinkRepresentationForLayoutAction {

	/** the represented link */
	protected ConnectionEditPart link;

	/** the link figure */
	protected PolylineConnectionEx linkFigure;

	/** the fixed anchor */
	protected Point fixedAnchor;

	/** the editpart owning the fixed anchor */
	protected EditPart fixedEP;

	/** the request type's for the fixed anchor */
	protected String fixedType;

	/** the request type's for the moved anchor */
	protected String movedType;

	/** the moved anchor */
	protected Point movedAnchor;

	/** the editpart owning the moved anchor */
	protected EditPart movedEP;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param link
	 *        the represented link
	 */
	public LinkRepresentationForLayoutAction(ConnectionEditPart link) {
		this.link = link;
	}

	/**
	 * This method initializes the following fields :
	 * <ul>
	 * <li> {@link #linkFigure}</li>
	 * <li> {@link #fixedAnchor}</li>
	 * <li> {@link #fixedEP}</li>
	 * <li> {@link #fixedType}</li>
	 * <li> {@link #movedAnchor}</li>
	 * <li> {@link #movedEP}</li>
	 * <li> {@link #movedType}</li>
	 * <li></li>
	 * 
	 * </ul>
	 */
	protected void init() {
		IFigure fig = ((AbstractConnectionEditPart)link).getFigure();
		Assert.isTrue(fig instanceof PolylineConnectionEx);
		linkFigure = (PolylineConnectionEx)fig;

		Point start = linkFigure.getStart();
		Point end = linkFigure.getEnd();
		linkFigure.translateToAbsolute(start);
		linkFigure.translateToAbsolute(end);

		this.movedAnchor = findMovedAnchor(start, end);
		//find fixed anchor
		this.fixedAnchor = ((this.movedAnchor == end) ? start : end);
		//detemines fixedEP and movedEP
		if(this.fixedAnchor == start) {
			this.fixedEP = link.getSource();
			this.movedEP = link.getTarget();
			this.movedType = GraphicalNodeEditPolicy.REQ_RECONNECT_TARGET;
			this.fixedType = GraphicalNodeEditPolicy.REQ_RECONNECT_SOURCE;

		} else {
			this.fixedEP = link.getTarget();
			this.movedEP = link.getSource();
			this.movedType = GraphicalNodeEditPolicy.REQ_RECONNECT_SOURCE;
			this.fixedType = GraphicalNodeEditPolicy.REQ_RECONNECT_TARGET;
		}

	}

	/**
	 * 
	 * Returns the moving Anchor
	 * 
	 * @param start
	 *        the Point representing the source of the link
	 * @param end
	 *        the Point representing the target of the link
	 * @return
	 *         the moving Anchor
	 */
	abstract protected Point findMovedAnchor(Point start, Point end);

	/**
	 * Returns the shift for the anchor which moves
	 * 
	 * @return
	 *         the shift for the anchor which moves
	 */
	protected abstract Point getDelta();

	public Command getCommand() {
		init();
		CompoundCommand command = new CompoundCommand();
		command.add(movedEP.getCommand(getRequestForMovedEditPart()));
		command.add(fixedEP.getCommand(getRequestForFixedEditPart()));
		return command.canExecute() ? command : UnexecutableCommand.INSTANCE;
	}

	/**
	 * Returns the request to relocate the moved anchor.
	 * 
	 * @return
	 *         The request to locate the moved anchor.
	 */
	public Request getRequestForMovedEditPart() {
		Point delta = getDelta();
		ReconnectRequest request = new ReconnectRequest(movedType);
		request.setConnectionEditPart(this.link);
		request.setTargetEditPart(this.movedEP);
		request.setLocation(movedAnchor.getTranslated(delta.x, delta.y));
		return request;
	}

	/**
	 * Returns the request to relocate the fixed anchor.
	 * 
	 * @return
	 *         The request to locate the fixed anchor.
	 */
	public Request getRequestForFixedEditPart() {
		ReconnectRequest request = new ReconnectRequest(fixedType);
		request.setConnectionEditPart(this.link);
		request.setTargetEditPart(this.fixedEP);
		request.setLocation(fixedAnchor);
		return request;
	}

	/**
	 * Returns the side on which is located the moving on the figure
	 * 
	 * @return
	 *         the side on which is located the moving on the figure
	 *         <ul>
	 *         <li>{@linkplain PositionConstants#NONE}
	 *         <ul>
	 *         <li>if the figure is not not known. (This algorithm depends on the figure form).</li>
	 *         <li>Maybe you forgot to translate the anchor in absolute coordinate or the anchor is not attached to the figure</li>
	 *         </ul>
	 *         </li>
	 *         <li>{@linkplain PositionConstants#NORTH}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH}</li>
	 *         <li>
	 *         {@linkplain PositionConstants#EAST}</li>
	 *         <li> {@linkplain PositionConstants#WEST}</li>
	 *         <li>
	 *         {@linkplain PositionConstants#NORTH_EAST}</li>
	 *         <li> {@linkplain PositionConstants#NORTH_WEST}</li>
	 *         <li>
	 *         {@linkplain PositionConstants#SOUTH_EAST}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH_WEST}</li>
	 *         </ul>
	 */
	public int getCurrentSideOnMovingNode() {
		return LayoutUtils.getAnchorPosition(this.movedEP, movedAnchor);
	}

	/**
	 * Getter for {@link #link}
	 * 
	 * @return
	 *         the represented link
	 */
	public ConnectionEditPart getRepresentedLink() {
		return this.link;
	}

	/**
	 * Gets the fixed anchor.
	 * 
	 * @return the fixed anchor
	 */
	public Point getFixedAnchor() {
		return this.fixedAnchor;
	}

	/**
	 * Gets the moved anchor.
	 * 
	 * @return the moved anchor
	 */
	public Point getMovedAnchor() {
		return this.movedAnchor;
	}

	public Command getMovingCommand() {
		return movedEP.getCommand(getRequestForMovedEditPart());
	}
}
