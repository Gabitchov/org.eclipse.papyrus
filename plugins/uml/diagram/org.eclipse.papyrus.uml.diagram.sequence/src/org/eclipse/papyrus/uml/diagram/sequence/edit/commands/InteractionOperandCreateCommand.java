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
import org.eclipse.emf.common.util.EList;
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
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.InteractionConstraint;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.InteractionOperand;
import org.eclipse.uml2.uml.LiteralInteger;
import org.eclipse.uml2.uml.LiteralString;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class InteractionOperandCreateCommand extends EditElementCommand {

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
	public InteractionOperandCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static InteractionOperandCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new InteractionOperandCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public InteractionOperandCreateCommand(CreateElementRequest req) {
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
	 * @generated
	 */
	public boolean canExecute() {

		return true;

	}

	/**
	 * Generated not for add combined fragment's covered lifelines on interaction operand
	 * 
	 * @generated NOT
	 */
	@SuppressWarnings({ "unchecked" })
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		CombinedFragment owner = (CombinedFragment)getElementToEdit();
		Set<InteractionFragment> coveredInteractionFragments = (Set<InteractionFragment>)getRequest().getParameters().get(SequenceRequestConstant.COVERED_INTERACTIONFRAGMENTS);

		InteractionOperand newElement = createInteractionOperand(owner, coveredInteractionFragments);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(InteractionOperand newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public static InteractionOperand createInteractionOperand(CombinedFragment cf, Set<InteractionFragment> coveredInteractionFragments) {
		InteractionOperand newIO = UMLFactory.eINSTANCE.createInteractionOperand();
		cf.getOperands().add(newIO);

		// we don't use ElementInitializers.init_NamedElement here because the standard algo using namespace is not suitable
		String base = newIO.eClass().getName();
		String name = ElementInitializers.getNextNumberedName((EList)cf.getOperands(), base);
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
