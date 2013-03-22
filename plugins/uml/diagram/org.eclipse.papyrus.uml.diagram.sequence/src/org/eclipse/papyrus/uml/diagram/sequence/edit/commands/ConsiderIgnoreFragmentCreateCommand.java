/*****************************************************************************
 * Copyright (c) 2009 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.commands;

import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.ConsiderIgnoreFragment;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class ConsiderIgnoreFragmentCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private EClass eClass = null;

	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated
	 */
	public ConsiderIgnoreFragmentCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static ConsiderIgnoreFragmentCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new ConsiderIgnoreFragmentCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public ConsiderIgnoreFragmentCreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * 
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest)getRequest()).getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
			return container;
		}
		return eObject;
	}

	/**
	 * The creation command can only be executed if the elementToEdit (i.e the container) is an Interaction or an InteractionOperand
	 * 
	 * @generated NOT
	 */
	public boolean canExecute() {
		return getElementToEdit() instanceof Interaction || getElementToEdit() instanceof InteractionOperand;
	}

	/**
	 * Handle creation on InteractionOperand
	 * 
	 * @generated NOT
	 */
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

	/**
	 * @generated
	 */
	protected void doConfigure(ConsiderIgnoreFragment newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}
}
