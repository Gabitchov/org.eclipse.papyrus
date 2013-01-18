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
package org.eclipse.papyrus.uml.diagram.sequence.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationMoveHelper;

/**
 * Edit policy to restrict border item movement. This edit policy moves the related events when a Time/Duration Observation/Constraint is moved.
 */
public class TimeRelatedSelectionEditPolicy extends BorderItemSelectionEditPolicy {

	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		// Prepare request
		if(getHost() instanceof IBorderItemEditPart) {
			OccurrenceSpecificationMoveHelper.prepareTimeRelatedElementMoveRequest(request, (IBorderItemEditPart)getHost());
		}
		Command command = super.getMoveCommand(request);
		if(command != null) {
			command = OccurrenceSpecificationMoveHelper.completeMoveTimeRelatedElementCommand(command, request, getHost(), getHostFigure());
		}
		return command;
	}

	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		if(getHost() instanceof IBorderItemEditPart) {
			OccurrenceSpecificationMoveHelper.prepareTimeRelatedElementMoveRequest(request, (IBorderItemEditPart)getHost());
		}
		super.showChangeBoundsFeedback(request);
	}
}
