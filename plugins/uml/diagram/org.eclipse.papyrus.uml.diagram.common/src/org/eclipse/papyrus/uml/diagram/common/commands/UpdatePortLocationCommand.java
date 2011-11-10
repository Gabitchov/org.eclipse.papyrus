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
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Shape;

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
	 * Constructor.
	 * @param domain the editing domain
	 * @param parentEditPart the parent edit part
	 * @param borderItemEditPart the Port edit part
	 * @param borderItemSide the side of Port on parent before resize
	 */
	public UpdatePortLocationCommand(TransactionalEditingDomain domain, GraphicalEditPart parentEditPart, IBorderItemEditPart borderItemEditPart, int borderItemSide) {
		super(domain, "Update port location command", null);
		this.borderItemEditPart = borderItemEditPart;
		this.parentEditPart = parentEditPart;
		this.borderItemSide = borderItemSide;
	}

	/**
	 * Set the new IBorderItemEditPart view bounds after a resize of its parent.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		
		// At this step the resized bounds of the parent should have been set.
		// Get the parent bounds.
		Shape parentShape = (Shape) parentEditPart.getNotationView();
		Bounds parentBounds = (Bounds) parentShape.getLayoutConstraint();
		
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
			// TODO : Add log here, this case should not be possible anymore.
			break;
		}

		return CommandResult.newOKCommandResult();		
	}

}
