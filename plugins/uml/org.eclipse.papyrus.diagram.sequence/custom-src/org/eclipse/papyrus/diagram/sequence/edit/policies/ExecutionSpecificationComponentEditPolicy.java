package org.eclipse.papyrus.diagram.sequence.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ComponentEditPolicy;
import org.eclipse.papyrus.diagram.sequence.util.SequenceUtil;

/**
 * This edit policy also deletes time/duration edit parts which are linked with the deleted edit part.
 */
public class ExecutionSpecificationComponentEditPolicy extends ComponentEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command createDeleteViewCommand(GroupRequest deleteRequest) {
		CompoundCommand deleteViewsCommand = new CompoundCommand();
		Command deleteViewCommand = super.createDeleteViewCommand(deleteRequest);
		deleteViewsCommand.add(deleteViewCommand);
		if(getHost() instanceof ShapeNodeEditPart) {
			TransactionalEditingDomain editingDomain = ((ShapeNodeEditPart)getHost()).getEditingDomain();
			SequenceUtil.completeDeleteExecutionSpecificationViewCommand(deleteViewsCommand, editingDomain, getHost());
		}
		return deleteViewsCommand;
	}
}
