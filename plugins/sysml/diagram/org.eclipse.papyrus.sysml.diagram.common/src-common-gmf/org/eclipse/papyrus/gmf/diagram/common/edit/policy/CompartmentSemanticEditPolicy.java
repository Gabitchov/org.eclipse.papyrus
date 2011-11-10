package org.eclipse.papyrus.gmf.diagram.common.edit.policy;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;

public class CompartmentSemanticEditPolicy extends DefaultSemanticEditPolicy {

	protected Command getCreateCommand(CreateElementRequest req) {

		IElementEditService commandService = ElementEditServiceUtils.getCommandProvider(req.getContainer());
		if(commandService == null) {
			return UnexecutableCommand.INSTANCE;
		}

		CreateElementRequest createRequest = new CreateElementRequest(req.getContainer(), req.getElementType());
		createRequest.addParameters(req.getParameters());
		Command semanticCreateCommand = new ICommandProxy(commandService.getEditCommand(createRequest));

		if((semanticCreateCommand != null) && (semanticCreateCommand.canExecute())) {
			return semanticCreateCommand;
		} // else

		return UnexecutableCommand.INSTANCE;
	}
}
