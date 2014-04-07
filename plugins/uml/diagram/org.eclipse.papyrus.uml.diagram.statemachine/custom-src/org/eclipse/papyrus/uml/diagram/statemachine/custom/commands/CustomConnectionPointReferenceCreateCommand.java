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

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.statemachine.edit.commands.ConnectionPointReferenceCreateCommand;
import org.eclipse.uml2.uml.State;


public class CustomConnectionPointReferenceCreateCommand extends ConnectionPointReferenceCreateCommand {

	public CustomConnectionPointReferenceCreateCommand(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
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
