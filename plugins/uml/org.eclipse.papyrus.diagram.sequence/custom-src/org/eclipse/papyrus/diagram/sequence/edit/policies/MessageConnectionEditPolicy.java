package org.eclipse.papyrus.diagram.sequence.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.editpolicies.ConnectionEditPolicy;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;

/**
 * This edit policy also deletes time/duration edit parts which are linked with the deleted edit part.
 */
public class MessageConnectionEditPolicy extends ConnectionEditPolicy {

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
			SequenceUtil.completeDeleteMessageViewCommand(deleteViewsCommand, editingDomain, getHost());
		}
		return deleteViewsCommand;
	}
}
