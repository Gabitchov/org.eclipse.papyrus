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
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Shape;
import org.eclipse.papyrus.uml.diagram.common.locator.PortPositionLocatorUtils;

/**
 * <pre>
 * This class is a command supposed to fixed the location of a Port.
 * It verifies if the current location (in the notation model) is correct,
 * and correct if if needed.
 * </pre>
 */
public class FixPortLocationCommand extends AbstractTransactionalCommand {

	/** The proposed (or current) location */
	private final Rectangle proposedLocation;
	
	/** The most adapted valid location */
	private final Rectangle validLocation;
	
	/** The shape of the borderItem */
	private Shape borderItemShape;
	
	/** The border item bounds */
	private Bounds borderItemBounds;
		
	/**
	 * Constructor for the command.
	 * 
	 * @param domain
	 *        the editing domain.
	 * @param borderItemEP
	 *        assumed to be a Port due to the use of {@link PortPositionLocatorUtils} to calculate the correct
	 *        location.
	 * @param parentEP
	 *        the edit part of the graphical parent of borderItemEP.
	 */
	public FixPortLocationCommand(TransactionalEditingDomain domain, IBorderItemEditPart borderItemEditPart, GraphicalEditPart parentEditPart) {
		super(domain, "Fix port location command", null);
			
		borderItemShape = (Shape) borderItemEditPart.getNotationView();
		borderItemBounds = (Bounds)borderItemShape.getLayoutConstraint();
			
		proposedLocation = new Rectangle(borderItemBounds.getX(), borderItemBounds.getY(), borderItemBounds.getWidth(), borderItemBounds.getHeight());
		
		validLocation = PortPositionLocatorUtils.getBorderLocation(parentEditPart.getFigure().getBounds().getCopy(), proposedLocation, 10);
	}

	/**
	 * Only allow fix action when there is something to fix...
	 */
	@Override
	public boolean canExecute() {
		return (proposedLocation.equals(validLocation)) ? false : true;
	}
	
	/**
	 * Set the IBorderItemEditPart view bounds with a corrected location.
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		borderItemBounds.setX(validLocation.x);
		borderItemBounds.setY(validLocation.y);
		
		return CommandResult.newOKCommandResult();
	}

}
