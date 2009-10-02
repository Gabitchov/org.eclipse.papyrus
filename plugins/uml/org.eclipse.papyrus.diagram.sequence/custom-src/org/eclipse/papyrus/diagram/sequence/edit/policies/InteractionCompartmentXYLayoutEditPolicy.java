/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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

import java.util.List;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.papyrus.diagram.sequence.edit.parts.ActionExecutionSpecificationEditPart;
import org.eclipse.papyrus.diagram.sequence.edit.parts.BehaviorExecutionSpecificationEditPart;

public class InteractionCompartmentXYLayoutEditPolicy extends XYLayoutEditPolicy {

	@Override
	public Command getAddCommand(Request request) {
		if (request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest cbr = (ChangeBoundsRequest) request;
			for (EditPart ep : (List<EditPart>) cbr.getEditParts()) {
				if (ep instanceof BehaviorExecutionSpecificationEditPart
						|| ep instanceof ActionExecutionSpecificationEditPart) {
					// Prevent added BES on InteractionCompartmentEditPart
					return UnexecutableCommand.INSTANCE;
				}
			}
		}

		return super.getAddCommand(request);
	}

}
