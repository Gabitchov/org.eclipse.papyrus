/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.StateInvariantCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.StateInvariant;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomStateInvariantCreateCommand extends StateInvariantCreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomStateInvariantCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req, eObject);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomStateInvariantCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * The StateInvariant is created on the lifeline and not on its container
	 * 
	 * @Override
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// Get the model container
		Object modelContainer = ((CreateElementRequest)getRequest()).getParameters().get(SequenceRequestConstant.INTERACTIONFRAGMENT_CONTAINER);
		// Create the stateInvariant
		StateInvariant stateInvariant = CommandHelper.doCreateStateInvariant((Lifeline)getElementToEdit(), modelContainer);
		doConfigure(stateInvariant, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(stateInvariant);
		return CommandResult.newOKCommandResult(stateInvariant);
	}
}
