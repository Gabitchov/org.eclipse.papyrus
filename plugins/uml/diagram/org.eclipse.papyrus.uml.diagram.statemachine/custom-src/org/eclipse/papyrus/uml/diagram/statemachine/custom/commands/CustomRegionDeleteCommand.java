package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.View;

public class CustomRegionDeleteCommand extends CustomRegionPreDeleteCommand {

	public CustomRegionDeleteCommand(TransactionalEditingDomain editingDomain, View view) {
		super(editingDomain, view);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Essentially performs a resize of the region to be removed so that
	 * neighbouring regions are updated accordingly, then resets the zone of
	 * neighbouring regions and finally remove the region
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		// get the region to delete
		super.doExecuteWithResult(progressMonitor, info);
		View region = getView();
		ViewUtil.destroy(region);
		return CommandResult.newOKCommandResult();
	}
}
