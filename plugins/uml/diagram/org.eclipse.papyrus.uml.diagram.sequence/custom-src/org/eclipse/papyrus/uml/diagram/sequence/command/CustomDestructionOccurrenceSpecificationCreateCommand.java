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
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.DestructionOccurrenceSpecificationCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomDestructionOccurrenceSpecificationCreateCommand extends DestructionOccurrenceSpecificationCreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomDestructionOccurrenceSpecificationCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req, eObject);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomDestructionOccurrenceSpecificationCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * A DestructionEvent on a lifeline can only be created if it doesn't exist yet a destructionEvent on that lifeline.
	 * 
	 * @Override
	 */
	@Override
	public boolean canExecute() {
		// Get the lifeline
		Lifeline lifeline = (Lifeline)getElementToEdit();
		for(InteractionFragment ift : lifeline.getCoveredBys()) {
			if(ift instanceof DestructionOccurrenceSpecification) {
				// For each occurenceSpecification which covered the lifeline, check the associated event.
				return false;
			}
		}
		return true;
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		// Get the model container
		Object modelContainer = ((CreateElementRequest)getRequest()).getParameters().get(SequenceRequestConstant.INTERACTIONFRAGMENT_CONTAINER);
		DestructionOccurrenceSpecification destructionSpecification = (DestructionOccurrenceSpecification)CommandHelper.doCreateDestructionOccurrenceSpecification((Lifeline)getElementToEdit(), modelContainer);
		ElementInitializers.getInstance().init_DestructionOccurrenceSpecification_3022(destructionSpecification);
		doConfigure(destructionSpecification, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(destructionSpecification);
		return CommandResult.newOKCommandResult(destructionSpecification);
	}
}
