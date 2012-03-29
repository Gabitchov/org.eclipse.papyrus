package org.eclipse.papyrus.service.edit.commands;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.MoveRequest;

/**
 * This command should be used in composition with the real move command on any element.
 * it reports target and moved elements as edited elements so that getAffectedFiles works good and report
 * both files when moving from/to a controlled read-only resource for example.
 * 
 * @author mvelten
 *
 */
public class FakeMoveCommand extends EditElementCommand {

	private static class FakeMoveRequest extends MoveRequest {

		public FakeMoveRequest(MoveRequest moveRequest) {
			super(moveRequest.getTargetContainer(), moveRequest.getElementsToMove());
		}

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public List getElementsToEdit() {
			ArrayList l = new ArrayList();
			for (Object elementToMove : getElementsToMove().keySet()) {
				if (elementToMove instanceof EObject) {
					EObject parent = ((EObject)elementToMove).eContainer();
					if (parent != null) {
						l.add(parent);
					}
				}
			}
			l.add(getTargetContainer());
			return l;
		}
	}

	public FakeMoveCommand(MoveRequest request) {
		super("", request.getTargetContainer(), new FakeMoveRequest(request));
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		return CommandResult.newOKCommandResult();
	}

}
