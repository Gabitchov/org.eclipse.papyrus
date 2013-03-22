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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.commands;

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
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Continuation;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class ContinuationCreateCommand extends EditElementCommand {

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
	public ContinuationCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static ContinuationCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new ContinuationCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public ContinuationCreateCommand(CreateElementRequest req) {
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
	 * @generated NOT
	 */
	public boolean canExecute() {
		if(getElementToEdit() instanceof InteractionOperand) {
			InteractionOperand interactionOperand = (InteractionOperand)getElementToEdit();
			CombinedFragment combinedFragment = getEnclosingCombinedFragment(interactionOperand);
			if(combinedFragment != null) {
				if(combinedFragment.getInteractionOperator() == InteractionOperatorKind.ALT_LITERAL) {
					return true;
				}
			}
		}
		return false;
	}

	private CombinedFragment getEnclosingCombinedFragment(InteractionFragment interactionFragment) {
		if(interactionFragment.eContainer() instanceof CombinedFragment) {
			return (CombinedFragment)interactionFragment.eContainer();
		} else if(interactionFragment.eContainer() instanceof InteractionFragment) {
			return getEnclosingCombinedFragment((InteractionFragment)interactionFragment.eContainer());
		}
		return null;
	}

	/**
	 * Generated not to handle the constraint on covered lifelines.
	 * 
	 * @generated NOT
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		Continuation newElement = UMLFactory.eINSTANCE.createContinuation();
		InteractionOperand owner = (InteractionOperand)getElementToEdit();
		owner.getFragments().add(newElement);
		// Continuations are always global in the enclosing InteractionFragment 
		//(e.g., it always covers all Lifelines covered by the enclosing InteractionFragment)
		newElement.getCovereds().addAll(owner.getCovereds());
		ElementInitializers.getInstance().init_Continuation_3016(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Continuation newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
