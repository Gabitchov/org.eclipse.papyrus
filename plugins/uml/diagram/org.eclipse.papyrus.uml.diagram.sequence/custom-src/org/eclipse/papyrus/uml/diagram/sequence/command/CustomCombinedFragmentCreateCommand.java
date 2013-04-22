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

import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.CombinedFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomCombinedFragmentCreateCommand extends CombinedFragmentCreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomCombinedFragmentCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req, eObject);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomCombinedFragmentCreateCommand(CreateElementRequest req) {
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
	@SuppressWarnings("unchecked")
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CombinedFragment newElement = UMLFactory.eINSTANCE.createCombinedFragment();
		// START GENERATED NOT CODE
		EObject elementToEdit = getElementToEdit();
		if(elementToEdit instanceof InteractionOperand) {
			((InteractionOperand)elementToEdit).getFragments().add(newElement);
		} else if(elementToEdit instanceof Interaction) {
			((Interaction)elementToEdit).getFragments().add(newElement);
		}
		ElementInitializers.getInstance().init_CombinedFragment_3004(newElement);
		Set<InteractionFragment> coveredInteractionFragments = (Set<InteractionFragment>)getRequest().getParameters().get(SequenceRequestConstant.COVERED_INTERACTIONFRAGMENTS);
		CustomInteractionOperandCreateCommand.createInteractionOperand(newElement, coveredInteractionFragments);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
