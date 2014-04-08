/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.PseudostateExitPointCreateCommand;
import org.eclipse.papyrus.uml.diagram.statemachine.providers.ElementInitializers;
import org.eclipse.uml2.uml.Pseudostate;
import org.eclipse.uml2.uml.State;
import org.eclipse.uml2.uml.UMLFactory;


public class CustomPseudostateExitPointCreateCommand extends PseudostateExitPointCreateCommand {

	public CustomPseudostateExitPointCreateCommand(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canExecute() {
		State owner = (State)getElementToEdit();
		if(owner.getRegions().isEmpty())
			return false;
		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Pseudostate newElement = UMLFactory.eINSTANCE.createPseudostate();

		State owner = (State)getElementToEdit();
		owner.getConnectionPoints().add(newElement);
		ElementInitializers.getInstance().init_Pseudostate_17000(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
