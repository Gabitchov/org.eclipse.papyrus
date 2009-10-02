/*****************************************************************************
 * Copyright (c) 2009 CEA.
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

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;

/**
 * The customn DragDropEditPolicy for InteractionOperandEditPart.
 */
public class InteractionOperandDragDropEditPolicy extends ResizableEditPolicy {

	/**
	 * Disable drag and allow only south resize. {@inheritDoc}
	 */
	public InteractionOperandDragDropEditPolicy() {
		super();
		setResizeDirections(PositionConstants.SOUTH);
		setDragAllowed(false);
	}

	/**
	 * Handle resize InteractionOperand {@inheritDoc}
	 */
	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		return getHost().getParent().getParent().getCommand(request);
	}

}
