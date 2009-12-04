/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.diagram.sequence.util.CommandHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;

/**
 * @generated
 */
public class MessageCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final EObject source;

	/**
	 * @generated
	 */
	private final EObject target;

	/**
	 * @generated
	 */
	private final Interaction container;

	/**
	 * @generated
	 */
	public MessageCreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
		container = deduceContainer(source, target);
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if(source == null && target == null) {
			return false;
		}
		if(source != null && false == source instanceof Element) {
			return false;
		}
		if(target != null && false == target instanceof Element) {
			return false;
		}
		if(getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if(getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canCreateMessage_4003(getContainer(), getSource(),
				getTarget());
	}

	/**
	 * Create a MessageOccurenceSpecification and the call event when a message is created
	 * 
	 * @generated NOT
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		// Retrieve container of call event which is an instance of Package
		Package eventContainer = CommandHelper.getEventContainer(container.getOwner());
		if(eventContainer != null) {
			Message newElement = container.createMessage("");
			newElement.setMessageSort(MessageSort.SYNCH_CALL_LITERAL);
			ElementInitializers.init_Message_4003(newElement);

			// add the message to the interaction
			container.getMessages().add(newElement);

			Element signature = CommandHelper.getSignature(newElement);

			Event sendEvent = null;
			Event receiveEvent = null;

			if(signature instanceof Operation) {
				sendEvent = CommandHelper.createSendOperationEvent(eventContainer, (Operation)signature);
				receiveEvent = CommandHelper.createReceiveOperationEvent(eventContainer, (Operation)signature);
			} else {
				sendEvent = CommandHelper.createCallEvent(eventContainer);
				receiveEvent = CommandHelper.createCallEvent(eventContainer);
			}

			MessageOccurrenceSpecification msgOccurenceInvocationStart = CommandHelper.doCreateMessageOccurrence(
					container, sendEvent);
			msgOccurenceInvocationStart.setMessage(newElement);
			newElement.setSendEvent(msgOccurenceInvocationStart);
			ExecutionSpecification diagramSource = (ExecutionSpecification)getSource();
			Lifeline sourceLL = diagramSource.getCovereds().get(0);
			CommandHelper.setSingleCovered(sourceLL, msgOccurenceInvocationStart);

			MessageOccurrenceSpecification msgOccurenceInvocationEnd = CommandHelper.doCreateMessageOccurrence(
					container, receiveEvent);
			msgOccurenceInvocationEnd.setMessage(newElement);
			newElement.setReceiveEvent(msgOccurenceInvocationEnd);
			ExecutionSpecification diagramTarget = (ExecutionSpecification)getTarget();
			diagramTarget.setStart(msgOccurenceInvocationEnd);
			Lifeline targetLL = diagramTarget.getCovereds().get(0);
			CommandHelper.setSingleCovered(targetLL, msgOccurenceInvocationEnd);

			doConfigure(newElement, monitor, info);
			((CreateElementRequest)getRequest()).setNewElement(newElement);
			return CommandResult.newOKCommandResult(newElement);
		}

		return CommandResult.newErrorCommandResult("There is now valid container for events"); //$NON-NLS-1$
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Message newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	/**
	 * @generated
	 */
	protected void setElementToEdit(EObject element) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @generated
	 */
	protected Element getSource() {
		return (Element)source;
	}

	/**
	 * @generated
	 */
	protected Element getTarget() {
		return (Element)target;
	}

	/**
	 * @generated
	 */
	public Interaction getContainer() {
		return container;
	}

	/**
	 * Default approach is to traverse ancestors of the source to find instance of container. Modify
	 * with appropriate logic.
	 * 
	 * @generated
	 */
	private static Interaction deduceContainer(EObject source, EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null; element = element.eContainer()) {
			if(element instanceof Interaction) {
				return (Interaction)element;
			}
		}
		return null;
	}

}
