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

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableShapeEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;

/**
 * The customn LayoutEditPolicy for InteractionOperandEditPart.
 */
public class InteractionOperandLayoutEditPolicy extends XYLayoutEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected EditPolicy createChildEditPolicy(EditPart child) {
		EditPolicy result = super.createChildEditPolicy(child);
		if (result == null) {
			return new ResizableShapeEditPolicy();
		}
		return result;
	}

	/**
	 * Handle create InteractionOperand hover InteractionOperand {@inheritDoc}
	 */
	@Override
	public Command getCommand(Request request) {
		if (REQ_CREATE.equals(request.getType())) {
			return getHost().getParent().getCommand(request);
		}
		return super.getCommand(request);
	}
}
