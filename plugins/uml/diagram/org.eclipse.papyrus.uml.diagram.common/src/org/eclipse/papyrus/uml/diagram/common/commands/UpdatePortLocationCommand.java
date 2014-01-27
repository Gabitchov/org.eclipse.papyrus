/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.uml.diagram.common.Activator;
import org.eclipse.papyrus.uml.diagram.common.locator.PortPositionLocator;

/**
 * <pre>
 * This class is a command that updates the location of Port border items,
 * when the parent is resized.
 * This command is not generic (meaning valid for any IBorderItem) in the sense that 
 * the calculation of the new location is totally based on the way {@link PortPositionLocator}
 * behaves.
 * </pre>
 */
public class UpdatePortLocationCommand extends AbstractTransactionalCommand {

	/** The border item edit part (assumed to be a Port) */
	private IBorderItemEditPart borderItemEditPart;
	
	/** The parent edit part */
	private GraphicalEditPart parentEditPart;

	/** The Port side before parent resize */
	private final int borderItemSide;

	/**
	 * the move request;
	 */
	private ChangeBoundsRequest request;

	/**
	 * Constructor.
	 * 
	 * @param domain
	 *        the editing domain
	 * @param request
	 *        the move request
	 * @param parentEditPart
	 *        the parent edit part
	 * @param borderItemEditPart
	 *        the Port edit part
	 * @param borderItemSide
	 *        the side of Port on parent before resize
	 */
	public UpdatePortLocationCommand(TransactionalEditingDomain domain, ChangeBoundsRequest request, GraphicalEditPart parentEditPart, IBorderItemEditPart borderItemEditPart, int borderItemSide) {
		super(domain, "Update port location command", null); //$NON-NLS-1$
		this.borderItemEditPart = borderItemEditPart;
		this.parentEditPart = parentEditPart;
		this.borderItemSide = borderItemSide;
		this.request = request;
	}

	/**
	 * Set the new IBorderItemEditPart view bounds after a resize of its parent.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		// At this step the resized bounds of the parent should have been set.
		// Get the parent bounds.
		Shape parentShape = (Shape)parentEditPart.getNotationView();
		Bounds parentBounds = (Bounds)parentShape.getLayoutConstraint();

		// Retrieve borderItemBounds
		int borderItemOffset = 10; // see PortPositionLocator.

		Shape borderItemShape = (Shape)borderItemEditPart.getNotationView();
		Bounds borderItemBounds = (Bounds)borderItemShape.getLayoutConstraint();

		switch(borderItemSide) { // The borderItemSide is not supposed to
									// change during a parent resize.
		case PositionConstants.NORTH:
			borderItemBounds.setY(-borderItemOffset);
			break;
		case PositionConstants.NORTH_EAST:
			borderItemBounds.setX(parentBounds.getWidth() - borderItemOffset);
			borderItemBounds.setY(-borderItemOffset);
			break;
		case PositionConstants.EAST:
			borderItemBounds.setX(parentBounds.getWidth() - borderItemOffset);
			break;
		case PositionConstants.SOUTH_EAST:
			borderItemBounds.setX(parentBounds.getWidth() - borderItemOffset);
			borderItemBounds.setY(parentBounds.getHeight() - borderItemOffset);
			break;
		case PositionConstants.SOUTH:
			borderItemBounds.setY(parentBounds.getHeight() - borderItemOffset);
			break;
		case PositionConstants.SOUTH_WEST:
			borderItemBounds.setX(-borderItemOffset);
			borderItemBounds.setY(parentBounds.getHeight() - borderItemOffset);
			break;
		case PositionConstants.WEST:
			borderItemBounds.setX(-borderItemOffset);
			break;
		case PositionConstants.NORTH_WEST:
			borderItemBounds.setX(-borderItemOffset);
			borderItemBounds.setY(-borderItemOffset);
			break;

		default:
			Activator.log.warn("Unknown position value has been received"); //$NON-NLS-1$
			break;
		}


		final int resizeDirection = this.request.getResizeDirection();
		//if true, we don't move port (so we translate them in the opposite direction		
		if(this.request.isConstrainedResize()) {// see bug 424942 https://bugs.eclipse.org/bugs/show_bug.cgi?id=424942	
			final Point delta = request.getMoveDelta();
			if(resizeDirection == PositionConstants.NORTH) {
				switch(borderItemSide) {
				case PositionConstants.EAST:
				case PositionConstants.WEST:
					borderItemBounds.setY(borderItemBounds.getY() - delta.y);
					break;
				default:
					//nothing to do
					break;
				}
			} else if(resizeDirection == PositionConstants.WEST) {
				switch(borderItemSide) {
				case PositionConstants.SOUTH:
				case PositionConstants.NORTH:
					borderItemBounds.setX(borderItemBounds.getX() - delta.x);
					break;
				default:
					//nothing to do
					break;
				}
			} else if(resizeDirection == PositionConstants.NORTH_WEST) {
				switch(borderItemSide) {
				case PositionConstants.SOUTH:
				case PositionConstants.NORTH:
					borderItemBounds.setX(borderItemBounds.getX() - delta.x);
					break;
				case PositionConstants.EAST:
				case PositionConstants.WEST:
					borderItemBounds.setY(borderItemBounds.getY() - delta.y);
					break;
				default:
					//nothing to do
					break;
				}
			}
		}
		return CommandResult.newOKCommandResult();
	}
}
