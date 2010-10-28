package org.eclipse.papyrus.uml.service.types.helper.advice;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyDependentsRequest;
import org.eclipse.uml2.uml.MessageEnd;


public class MessageEndHelperAdvice extends AbstractEditHelperAdvice {

	protected ICommand getBeforeDestroyDependentsCommand(DestroyDependentsRequest request) {
		MessageEnd me = (MessageEnd)request.getElementToDestroy();

		// Destroy the associated message
		if(me.getMessage() != null) {
			return request.getDestroyDependentCommand(me.getMessage());
		}

		return null;
	}
}
