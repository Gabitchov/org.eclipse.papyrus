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
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.InteractionUseCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionUseCreateCommand extends InteractionUseCreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomInteractionUseCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req, eObject);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomInteractionUseCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * The creation command can only be executed if the elementToEdit (i.e the container) is an Interaction or an InteractionOperand
	 * 
	 * @Override
	 */
	@Override
	public boolean canExecute() {
		return getElementToEdit() instanceof Interaction || getElementToEdit() instanceof InteractionOperand;
	}

	/**
	 * Handle creation on InteractionOperand
	 * 
	 * @Override
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		InteractionUse newElement = UMLFactory.eINSTANCE.createInteractionUse();
		EObject elementToEdit = getElementToEdit();
		if(elementToEdit instanceof InteractionOperand) {
			InteractionOperand owner = (InteractionOperand)elementToEdit;
			owner.getFragments().add(newElement);
		} else {
			Interaction owner = (Interaction)elementToEdit;
			owner.getFragments().add(newElement);
		}
		ElementInitializers.getInstance().init_InteractionUse_3002(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
