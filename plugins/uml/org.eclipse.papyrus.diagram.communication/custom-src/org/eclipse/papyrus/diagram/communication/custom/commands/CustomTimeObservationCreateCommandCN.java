/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.diagram.communication.edit.commands.TimeObservationCreateCommandCN;
import org.eclipse.papyrus.diagram.communication.providers.UMLElementTypes;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.TimeObservation;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * 
 * This is for creating time observation
 * 
 */
public class CustomTimeObservationCreateCommandCN extends TimeObservationCreateCommandCN {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomTimeObservationCreateCommandCN(CreateElementRequest req) {
		super(req);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		TimeObservation newElement = UMLFactory.eINSTANCE.createTimeObservation();

		Interaction owner = (Interaction)getElementToEdit();
		owner.getNearestPackage().getPackagedElements().add(newElement);

		UMLElementTypes.init_TimeObservation_3004(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}



}
