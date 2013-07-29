package org.eclipse.papyrus.sysml.diagram.parametric.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ReconnectRequest;
// Start of user code custom imports	
// End of user code
import org.eclipse.papyrus.sysml.diagram.parametric.policies.CustomDefaultSemanticEditPolicy;

public class DiagramSemanticEditPolicy extends CustomDefaultSemanticEditPolicy {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRelationshipSourceCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRelationshipTargetCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRefRelationshipSourceCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Command getReorientRefRelationshipTargetCommand(ReconnectRequest request) {
		return UnexecutableCommand.INSTANCE;
	}	
}
