/*****************************************************************************
 * Copyright (c) 2010 CEA.
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
package org.eclipse.papyrus.diagram.sequence.edit.commands;

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
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class DestructionEventCreateCommand extends EditElementCommand {

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
	public DestructionEventCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static DestructionEventCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new DestructionEventCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public DestructionEventCreateCommand(CreateElementRequest req) {
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
	 * A DestructionEvent on a lifeline can only be created if it doesn't exist yet a destructionEvent on that lifeline.
	 * 
	 * @generated NOT
	 */
	public boolean canExecute() {

		// Get the lifeline
		Lifeline lifeline = (Lifeline)getElementToEdit();

		for(InteractionFragment ift : lifeline.getCoveredBys()) {
			if(ift instanceof OccurrenceSpecification) {
				// For each occurenceSpecification which covered the lifeline, check the associated event.
				OccurrenceSpecification os = (OccurrenceSpecification)ift;
				if(os.getEvent() instanceof DestructionEvent) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		// Get the model container
		Object modelContainer = ((CreateElementRequest)getRequest()).getParameters().get(SequenceRequestConstant.INTERACTIONFRAGMENT_CONTAINER);


		DestructionEvent destructionEvent = UMLFactory.eINSTANCE.createDestructionEvent();
		Lifeline lifeline = (Lifeline)getElementToEdit();
		Package pack = lifeline.getNearestPackage();

		CommandHelper.doCreateDestructionEvent(destructionEvent, lifeline, modelContainer);

		pack.getPackagedElements().add(destructionEvent);


		UMLElementTypes.init_DestructionEvent_3022(destructionEvent);

		doConfigure(destructionEvent, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(destructionEvent);
		return CommandResult.newOKCommandResult(destructionEvent);
	}




	/**
	 * @generated
	 */
	protected void doConfigure(DestructionEvent newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
