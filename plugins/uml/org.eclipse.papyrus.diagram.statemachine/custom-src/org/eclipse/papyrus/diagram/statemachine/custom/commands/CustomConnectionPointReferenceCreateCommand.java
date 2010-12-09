package org.eclipse.papyrus.diagram.statemachine.custom.commands;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.statemachine.edit.commands.ConnectionPointReferenceCreateCommand;
import org.eclipse.uml2.uml.State;


public class CustomConnectionPointReferenceCreateCommand extends ConnectionPointReferenceCreateCommand {

	public CustomConnectionPointReferenceCreateCommand(CreateElementRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExecute() {
		State owner = (State)getElementToEdit();
		if(owner.getRegions().isEmpty() && (owner.getSubmachine() != null))
			return true;
		return false;
	}
}
