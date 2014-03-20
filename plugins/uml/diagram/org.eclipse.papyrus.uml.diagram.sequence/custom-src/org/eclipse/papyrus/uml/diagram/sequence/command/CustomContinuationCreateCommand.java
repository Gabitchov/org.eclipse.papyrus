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
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.ContinuationCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Continuation;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.InteractionOperatorKind;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomContinuationCreateCommand extends ContinuationCreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomContinuationCreateCommand(CreateElementRequest req, EObject eObject, Diagram diagram) {
		super(req, eObject, diagram);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomContinuationCreateCommand(CreateElementRequest req, Diagram diagram) {
		super(req, diagram);
	}

	/**
	 * @Override
	 */
	@Override
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
	 * @Override
	 */
	@Override
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
}
