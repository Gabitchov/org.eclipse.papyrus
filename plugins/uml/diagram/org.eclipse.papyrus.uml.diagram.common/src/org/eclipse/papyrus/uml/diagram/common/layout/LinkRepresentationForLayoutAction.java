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
package org.eclipse.papyrus.uml.diagram.common.layout;

import org.eclipse.core.runtime.Assert;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.emf.common.command.IdentityCommand;
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
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.commands.wrappers.EMFtoGEFCommandWrapper;
import org.eclipse.papyrus.uml.diagram.common.Activator;

/**
 * 
 * This class allow to represent easily a link for the Layout Action
 * 
 */
public class LinkRepresentationForLayoutAction {

	/** the source of the link */
	private EditPart source = null;

	/** the target of the link */
	private EditPart target = null;

	/** new source position */
	private Point newSourcePosition = null;

	/** old source position */
	private Point oldSourcePosition = null;

	/** new target position */
	private Point newTargetPosition = null;

	/** old target position */
	private Point oldTargetPosition = null;

	/** the link represented by this class */
	private ConnectionEditPart link;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param link
	 *        the represented link
	 * 
	 */
	public LinkRepresentationForLayoutAction(ConnectionEditPart link) {
		this.link = link;
		this.source = link.getSource();
		this.target = link.getTarget();
		IFigure fig = ((AbstractConnectionEditPart)link).getFigure();
		Assert.isTrue(fig instanceof PolylineConnectionEx);
		PolylineConnectionEx linkFigure = (PolylineConnectionEx)fig;

		Point start = linkFigure.getStart();// source
		Point end = linkFigure.getEnd();// target
		linkFigure.translateToAbsolute(start);
		linkFigure.translateToAbsolute(end);
		oldSourcePosition = start;
		oldTargetPosition = end;
	}

	/**
	 * 
	 * @see java.lang.Object#toString()
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		return ((View)(link.getModel())).getElement().toString();
	}

	/**
	 * Return the command to move this link, following {@link #newSourcePosition} and {@link #newTargetPosition}
	 * 
	 * @return the command to move this link, following {@link #newSourcePosition} and {@link #newTargetPosition}
	 */
	public Command getCommand() {
		/*
		 * Sometimes, the anchors of the link move on the diagram, even if the
		 * location is the same! see GMF bug 324208
		 */
		if((newSourcePosition == null && newTargetPosition == null) || (oldSourcePosition.equals(newSourcePosition)) && oldTargetPosition.equals(newTargetPosition)) {
			return new EMFtoGEFCommandWrapper(new IdentityCommand());
		} else {
			CompoundCommand command = new CompoundCommand();
			command.add(source.getCommand(getRequestForSource()));
			command.add(target.getCommand(getRequestForTarget()));
			return command.canExecute() ? command : UnexecutableCommand.INSTANCE;
		}
	}

	/**
	 * Returns the request to move the source anchor.
	 * 
	 * @return the request to move the source anchor.
	 */
	public Request getRequestForSource() {
		ReconnectRequest request = new ReconnectRequest(GraphicalNodeEditPolicy.REQ_RECONNECT_SOURCE);
		request.setConnectionEditPart(this.link);
		request.setTargetEditPart(this.source);
		request.setLocation(getNewSourceLocation());
		return request;
	}

	/**
	 * Return the source location to move this link
	 * 
	 * @return the source location to move this link
	 *         <ul>
	 *         <li> {@link #newSourcePosition} if not <code>null</code></li>
	 *         <li>{@link #oldSourcePosition} if {@link #newSourcePosition} is <code>null</code></li>
	 *         </ul>
	 */
	protected Point getNewSourceLocation() {
		if(this.newSourcePosition != null) {
			return this.newSourcePosition;
		} else {
			return this.oldSourcePosition;
		}
	}

	/**
	 * Return the target location to move this link
	 * 
	 * @return the target location to move this link
	 *         <ul>
	 *         <li> {@link #newTargetPosition} if not <code>null</code></li>
	 *         <li>{@link #oldTargetPosition} if {@link #newTargetPosition} is <code>null</code></li>
	 *         </ul>
	 */
	protected Point getNewTargetLocation() {
		if(this.newTargetPosition != null) {
			return this.newTargetPosition;
		} else {
			return this.oldTargetPosition;
		}
	}

	/**
	 * Setter for {@link #newSourcePosition} and {@link #newTargetPosition}
	 * 
	 * @param node
	 *        a node, should be the source or the target of the link
	 * @param location
	 *        the neuw location on this node
	 */
	public void setNewLocationFor(EditPart node, Point location) {
		if(source == node) {
			newSourcePosition = location;
		} else if(target == node) {
			newTargetPosition = location;
		} else {
			Activator.log.error("Can't find the EditPart " + node + " (from " + this.getClass().getName() + ")", null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
	}

	/**
	 * Returns the request to relocate the fixed anchor.
	 * 
	 * @return The request to locate the fixed anchor.
	 */
	public Request getRequestForTarget() {
		ReconnectRequest request = new ReconnectRequest(GraphicalNodeEditPolicy.REQ_RECONNECT_TARGET);
		request.setConnectionEditPart(this.link);
		request.setTargetEditPart(this.target);
		request.setLocation(getNewTargetLocation());
		return request;
	}

	/**
	 * Return the current position of the link on the node
	 * 
	 * @param node
	 *        node should be the source or the target of the link
	 * @return
	 * @see LayoutUtils#getAnchorPosition(EditPart, Point)
	 */
	public int getCurrentSideOn(EditPart node) {
		if(node == source) {
			return LayoutUtils.getAnchorPosition(source, oldSourcePosition);
		} else if(node == target) {
			return LayoutUtils.getAnchorPosition(target, oldTargetPosition);
		} else {
			Activator.log.error("Can't find the EditPart " + node + " (from " + this.getClass().getName() + ")", null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return 0;
	}

	/**
	 * Gets the represented link.
	 * 
	 * @return the represented link
	 */
	public ConnectionEditPart getRepresentedLink() {
		return this.link;
	}

	/**
	 * Return a PrecisionRectangle representing the current position of the
	 * anchor on this node (with width=height=1)
	 * 
	 * @param node
	 *        node should be the source or the target of the link
	 * @return A PrecisionRectangle representing the current position of the
	 *         anchor on this node (with width=height=1)
	 */
	public PrecisionRectangle getAbsolutePositionOn(EditPart node) {
		PrecisionRectangle rect = new PrecisionRectangle();
		rect.setSize(new Dimension(1, 1));
		if(source == node) {
			rect.setX(oldSourcePosition.x);
			rect.setY(oldSourcePosition.y);
		} else if(target == node) {
			rect.setX(oldTargetPosition.x);
			rect.setY(oldTargetPosition.y);
		} else {
			Activator.log.error("Can't find the EditPart " + node + " (from " + this.getClass().getName() + ")", null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return rect;
	}

	/**
	 * Return the current absolute location of the anchor on this node
	 * 
	 * @param node
	 *        node should be the source or the target of the link
	 * @return the current absolute location of the anchor on this node
	 */
	public Point getAbsoluteLocationOn(EditPart node) {
		if(source == node) {
			return oldSourcePosition;
		} else if(target == node) {
			return oldTargetPosition;
		} else {
			Activator.log.error("Can't find the EditPart " + node + " (from " + this.getClass().getName() + ")", null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
		}
		return new Point();
	}

	/**
	 * Gets the side on source.
	 * 
	 * @return the side on source
	 */
	public int getSideOnSource() {
		return getCurrentSideOn(source);
	}

	/**
	 * Gets the side on target.
	 * 
	 * @return the side on target
	 */
	public int getSideOnTarget() {
		return getCurrentSideOn(target);
	}
}
