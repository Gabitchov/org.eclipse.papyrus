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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ConsiderIgnoreFragmentCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomConsiderIgnoreFragmentCreateCommand extends ConsiderIgnoreFragmentCreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomConsiderIgnoreFragmentCreateCommand(CreateElementRequest req, EObject eObject, Diagram diagram) {
		super(req, eObject, diagram);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomConsiderIgnoreFragmentCreateCommand(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
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
		ConsiderIgnoreFragment newElement = UMLFactory.eINSTANCE.createConsiderIgnoreFragment();
		ElementInitializers.getInstance().init_ConsiderIgnoreFragment_3007(newElement);
		// START GENERATED NOT CODE
		EObject elementToEdit = getElementToEdit();
		InteractionFragment owner = null;
		if(elementToEdit instanceof InteractionOperand) {
			InteractionOperand io = (InteractionOperand)elementToEdit;
			owner = io;
			io.getFragments().add(newElement);
		} else {
			Interaction i = (Interaction)elementToEdit;
			owner = i;
			i.getFragments().add(newElement);
		}
		newElement.setInteractionOperator(InteractionOperatorKind.CONSIDER_LITERAL);
		// Create an interaction operand with the ConsiderIgnoreFragment (multiplicy 1...*)
		InteractionOperand createInteractionOperand = UMLFactory.eINSTANCE.createInteractionOperand();
		newElement.getOperands().add(createInteractionOperand);
		Set<InteractionFragment> coveredInteractionFragments = (Set<InteractionFragment>)getRequest().getParameters().get(SequenceRequestConstant.COVERED_INTERACTIONFRAGMENTS);
		if(coveredInteractionFragments != null) {
			// set the enclosing operand to the newly created one if the current enclosing interaction is the enclosing interaction
			// of the new operand.
			// => the interaction fragment that are inside an other container (like an enclosed CF) are not modified
			for(InteractionFragment ift : coveredInteractionFragments) {
				if(owner.equals(ift.getEnclosingOperand()) || owner.equals(ift.getEnclosingInteraction())) {
					ift.setEnclosingInteraction(null);
					ift.setEnclosingOperand(createInteractionOperand);
				}
			}
		}
		// END GENERATED NOT CODE
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
