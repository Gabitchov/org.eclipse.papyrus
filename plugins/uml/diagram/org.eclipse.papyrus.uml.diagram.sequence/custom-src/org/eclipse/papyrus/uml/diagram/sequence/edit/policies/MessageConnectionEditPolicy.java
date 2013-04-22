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

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.LifelineMessageCreateHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceDeleteHelper;

/**
 * This edit policy also deletes time/duration edit parts which are linked with the deleted edit part.
 */
public class MessageConnectionEditPolicy extends ConnectionEditPolicy {

	@Override
	protected Command createDeleteSemanticCommand(GroupRequest deleteRequest) {
		CompoundCommand deleteSemanticsCommand = new CompoundCommand();
		Command deleteSemanticCommand = super.createDeleteSemanticCommand(deleteRequest);
		deleteSemanticsCommand.add(deleteSemanticCommand);
		return LifelineMessageCreateHelper.restoreLifelineOnMessageDelete(deleteSemanticsCommand, getHost());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		CompoundCommand deleteViewsCommand = new CompoundCommand();
		Command deleteViewCommand = super.createDeleteViewCommand(deleteRequest);
		deleteViewsCommand.add(deleteViewCommand);
		if(getHost() instanceof ConnectionNodeEditPart) {
			TransactionalEditingDomain editingDomain = ((ConnectionNodeEditPart)getHost()).getEditingDomain();
			SequenceDeleteHelper.completeDeleteMessageViewCommand(deleteViewsCommand, editingDomain, getHost());
		}
		return LifelineMessageCreateHelper.restoreLifelineOnMessageDelete(deleteViewsCommand, getHost());
	}
}
