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
package org.eclipse.papyrus.uml.diagram.communication.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.communication.edit.commands.DurationObservationCreateCommandCN;
import org.eclipse.papyrus.uml.diagram.communication.providers.ElementInitializers;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * 
 * Command to create a duration observation
 * 
 */

public class CustomDurationObservationCreateCommandCN extends DurationObservationCreateCommandCN {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomDurationObservationCreateCommandCN(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @generated
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		DurationObservation newElement = UMLFactory.eINSTANCE.createDurationObservation();
		// The owner of the duration observation is an Interaction
		Interaction owner = (Interaction)getElementToEdit();
		owner.getNearestPackage().getPackagedElements().add(newElement);

		ElementInitializers.getInstance().init_DurationObservation_8007(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
