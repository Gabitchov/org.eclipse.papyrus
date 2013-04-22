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
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.InteractionOperandCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomInteractionOperandCreateCommand extends InteractionOperandCreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomInteractionOperandCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req, eObject);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomInteractionOperandCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * Generated not for add combined fragment's covered lifelines on interaction operand
	 * 
	 * @Override
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CombinedFragment owner = (CombinedFragment)getElementToEdit();
		Set<InteractionFragment> coveredInteractionFragments = (Set<InteractionFragment>)getRequest().getParameters().get(SequenceRequestConstant.COVERED_INTERACTIONFRAGMENTS);
		InteractionOperand newElement = createInteractionOperand(owner, coveredInteractionFragments);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	@SuppressWarnings({ "rawtypes" })
	public static InteractionOperand createInteractionOperand(CombinedFragment cf, Set<InteractionFragment> coveredInteractionFragments) {
		InteractionOperand newIO = UMLFactory.eINSTANCE.createInteractionOperand();
		cf.getOperands().add(newIO);
		// we don't use ElementInitializers.init_NamedElement here because the standard algo using namespace is not suitable
		String base = newIO.eClass().getName();
		String name = ElementInitializers.getNextNumberedName(cf.getOperands(), base);
		newIO.setName(name);
		// Add all combined fragment's covered lifelines on interaction operand
		for(InteractionOperand operand : cf.getOperands()) {
			operand.getCovereds().addAll(cf.getCovereds());
		}
		// create guard
		InteractionConstraint guard = UMLFactory.eINSTANCE.createInteractionConstraint();
		newIO.setGuard(guard);
		LiteralString literalString = UMLFactory.eINSTANCE.createLiteralString();
		literalString.setValue("undefined");
		guard.setSpecification(literalString);
		LiteralInteger min = UMLFactory.eINSTANCE.createLiteralInteger();
		min.setValue(0);
		guard.setMinint(min);
		LiteralInteger max = UMLFactory.eINSTANCE.createLiteralInteger();
		max.setValue(1);
		guard.setMaxint(max);
		if(coveredInteractionFragments != null) {
			InteractionFragment cfOwner = null;
			if(cf.getEnclosingOperand() != null) {
				cfOwner = cf.getEnclosingOperand();
			} else if(cf.getEnclosingInteraction() != null) {
				cfOwner = cf.getEnclosingInteraction();
			}
			if(cfOwner != null) {
				// set the enclosing operand to the newly created one if the current enclosing interaction is the enclosing interaction
				// of the new operand.
				// => the interaction fragment that are inside an other container (like an enclosed CF) are not modified
				for(InteractionFragment ift : coveredInteractionFragments) {
					if(cfOwner.equals(ift.getEnclosingOperand()) || cfOwner.equals(ift.getEnclosingInteraction())) {
						ift.setEnclosingInteraction(null);
						ift.setEnclosingOperand(newIO);
					}
				}
			}
		}
		return newIO;
	}
}
