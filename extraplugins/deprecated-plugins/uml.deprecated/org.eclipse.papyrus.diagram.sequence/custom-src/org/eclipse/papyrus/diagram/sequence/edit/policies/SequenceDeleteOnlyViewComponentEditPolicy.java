/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano Muñoz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;

import org.eclipse.papyrus.diagram.common.editpolicies.DeleteOnlyViewComponentEditPolicy;

public class SequenceDeleteOnlyViewComponentEditPolicy extends
		DeleteOnlyViewComponentEditPolicy {

	@Override
	protected Command getDeleteCommand(GroupRequest request) {
		// The following elements should not allow the deletion of their views
		IGraphicalEditPart ep = getGraphicalHost();

		// Message
		if (ep.resolveSemanticElement() instanceof Message)
			return UnexecutableCommand.INSTANCE;

		// Lifeline
		if (ep.resolveSemanticElement() instanceof Lifeline)
			return UnexecutableCommand.INSTANCE;

		// BES
		if (ep.resolveSemanticElement() instanceof BehaviorExecutionSpecification)
			return UnexecutableCommand.INSTANCE;

		// For the rest, return the parent command
		return super.getDeleteCommand(request);
	}
	
}
