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
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class Message2CreateCommand extends EditElementCommand {

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
	public Message2CreateCommand(CreateRelationshipRequest request, EObject source, EObject target) {
		super(request.getLabel(), null, request);
		this.source = source;
		this.target = target;
		container = deduceContainer(source, target);
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if (source == null && target == null) {
			return false;
		}
		if (source != null && false == source instanceof Element) {
			return false;
		}
		if (target != null && false == target instanceof Element) {
			return false;
		}
		if (getSource() == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		// target may be null here but it's possible to check constraint
		if (getContainer() == null) {
			return false;
		}
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canCreateMessage_4004(getContainer(), getSource(),
				getTarget());
	}

	private static CallEvent doCreateEvent()// create the callevent associated to the
	// MessageOccurenceSpecification

	{
		CallEvent result = UMLFactory.eINSTANCE.createCallEvent();

		return result;

	}

	private static MessageOccurrenceSpecification doCreateMessageOccurrence(Interaction interaction) {
		MessageOccurrenceSpecification result = UMLFactory.eINSTANCE.createMessageOccurrenceSpecification();

		result.setEnclosingInteraction(interaction);
		return result;
	}

	private void setupBehaviorSpec(BehaviorExecutionSpecification spec, MessageOccurrenceSpecification start,
			MessageOccurrenceSpecification finish, Lifeline lifeline) {

		setSingleCovered(spec, lifeline);

		if (start != null) {
			setSingleCovered(start, lifeline);
			spec.setStart(start);

		}

		if (finish != null) {
			setSingleCovered(finish, lifeline);
			spec.setFinish(finish);

		}

	}

	private void setupMesssageOccu(MessageOccurrenceSpecification start, MessageOccurrenceSpecification finish,
			Lifeline lifeline) {
		if (start != null) {
			setSingleCovered(start, lifeline);

		}

		if (finish != null) {
			setSingleCovered(finish, lifeline);
		}
	}

	private void setSingleCovered(InteractionFragment fragment, Lifeline lifeline) {
		if (!fragment.getCovereds().contains(lifeline)) {
			fragment.getCovereds().add(lifeline);
		}
	}

	/**
	 * added code to create the gate , message occurence and event when a Async message is created .
	 * 
	 * @generated-Not
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}
		// added code
		Message newElement = null;

		Interaction interaction = getContainer();

		Element diagramSource = getSource();
		Element diagramTarget = getTarget();
		MessageEnd domainSource;
		MessageEnd domainTarget;

		BehaviorExecutionSpecification sourceInvocation = null;
		BehaviorExecutionSpecification targetExecution = null;

		CallEvent callevent = doCreateEvent();

		PackageableElement newCallevent = ((Model) (interaction.getOwner())).createPackagedElement("", callevent
				.eClass());

		ElementInitializers.init_CallEvent_4003((CallEvent) newCallevent);

		MessageOccurrenceSpecification msgOccurenceInvocationStart = null;

		MessageOccurrenceSpecification msgOccurenceInvocationEnd = null;

		Gate endGate = null;

		newElement = interaction.createMessage("");
		newElement.setMessageSort(MessageSort.ASYNCH_CALL_LITERAL);

		interaction.getMessages().add(newElement);

		if (diagramSource instanceof BehaviorExecutionSpecification
				&& diagramTarget instanceof BehaviorExecutionSpecification) {

			BehaviorExecutionSpecification start = (BehaviorExecutionSpecification) diagramSource;

			BehaviorExecutionSpecification end = (BehaviorExecutionSpecification) diagramTarget;

			msgOccurenceInvocationStart = doCreateMessageOccurrence(interaction);
			msgOccurenceInvocationEnd = doCreateMessageOccurrence(interaction);

			msgOccurenceInvocationEnd.setEvent((CallEvent) newCallevent);
			msgOccurenceInvocationStart.setEvent((CallEvent) newCallevent);

			ElementInitializers.init_MessageSpecificationOccurence_4003(msgOccurenceInvocationStart);
			ElementInitializers.init_MessageSpecificationOccurence_4003(msgOccurenceInvocationEnd);

			Lifeline sourceLL = start.getCovereds().get(0);
			Lifeline targetLL = end.getCovereds().get(0);

			setupBehaviorSpec(start, msgOccurenceInvocationStart, msgOccurenceInvocationEnd, sourceLL);
			setupBehaviorSpec(end, msgOccurenceInvocationEnd, msgOccurenceInvocationStart, targetLL);

			domainSource = (MessageOccurrenceSpecification) start.getStart();
			domainTarget = (MessageOccurrenceSpecification) end.getStart();

			if (domainSource != null && domainTarget != null) {

				newElement.setSendEvent(domainSource);
				newElement.setReceiveEvent(domainTarget);

				domainSource.setMessage(newElement);
				domainTarget.setMessage(newElement);
			}

		}

		if (diagramSource instanceof Lifeline && diagramTarget instanceof Lifeline) {

			Lifeline start = (Lifeline) diagramSource;
			Lifeline end = (Lifeline) diagramTarget;

			msgOccurenceInvocationStart = doCreateMessageOccurrence(interaction);
			msgOccurenceInvocationEnd = doCreateMessageOccurrence(interaction);

			msgOccurenceInvocationEnd.setEvent((CallEvent) newCallevent);
			msgOccurenceInvocationStart.setEvent((CallEvent) newCallevent);

			ElementInitializers.init_MessageSpecificationOccurence_4003(msgOccurenceInvocationStart);
			ElementInitializers.init_MessageSpecificationOccurence_4003(msgOccurenceInvocationEnd);

			setupMesssageOccu(msgOccurenceInvocationStart, msgOccurenceInvocationEnd, start);// create
			// the
			// relationship
			// betwen
			// the
			// messageOccurence
			// and
			// the
			// source

			setupMesssageOccu(msgOccurenceInvocationEnd, msgOccurenceInvocationStart, start);

			if (msgOccurenceInvocationEnd != null && msgOccurenceInvocationStart != null) {

				newElement.setSendEvent(msgOccurenceInvocationStart);
				newElement.setReceiveEvent(msgOccurenceInvocationEnd);

				msgOccurenceInvocationStart.setMessage(newElement);
				msgOccurenceInvocationEnd.setMessage(newElement);
			}

		}

		if (diagramSource instanceof BehaviorExecutionSpecification && diagramTarget instanceof Interaction) {

			BehaviorExecutionSpecification start = (BehaviorExecutionSpecification) diagramSource;
			Interaction end = (Interaction) diagramTarget;
			Lifeline sourcell = start.getCovereds().get(0);// get the lifeline associated to the
															// BehaviorExecutionSpecification

			msgOccurenceInvocationStart = doCreateMessageOccurrence(interaction);
			endGate = end.createFormalGate("");
			ElementInitializers.init_Gate_4003(endGate);
			msgOccurenceInvocationStart.setEvent((CallEvent) newCallevent);
			ElementInitializers.init_MessageSpecificationOccurence_4003(msgOccurenceInvocationStart);

			setupBehaviorSpec(start, msgOccurenceInvocationStart, msgOccurenceInvocationEnd, sourcell);// set
																										// the
																										// relationship
																										// between
																										// the
																										// messageOccurence
																										// specificaition
																										// ,
																										// the
																										// BehaviorExecutionSpecification
																										// and
																										// the
																										// lifeline

			if (msgOccurenceInvocationStart != null && endGate != null) {

				newElement.setSendEvent(msgOccurenceInvocationStart);
				newElement.setReceiveEvent(endGate);
				endGate.setMessage(newElement);
				msgOccurenceInvocationStart.setMessage(newElement);

			}

		}

		if (diagramSource instanceof Lifeline && diagramTarget instanceof Interaction) {

			Lifeline start = (Lifeline) diagramSource;
			Interaction end = (Interaction) diagramTarget;

			msgOccurenceInvocationStart = doCreateMessageOccurrence(interaction);
			endGate = end.createFormalGate("");
			ElementInitializers.init_Gate_4003(endGate);
			msgOccurenceInvocationStart.setEvent((CallEvent) newCallevent);
			ElementInitializers.init_MessageSpecificationOccurence_4003(msgOccurenceInvocationStart);

			setupMesssageOccu(msgOccurenceInvocationStart, msgOccurenceInvocationEnd, start);

			if (msgOccurenceInvocationStart != null && endGate != null) {

				newElement.setSendEvent(msgOccurenceInvocationStart);
				newElement.setReceiveEvent(endGate);
				endGate.setMessage(newElement);
				msgOccurenceInvocationStart.setMessage(newElement);

			}

		}

		ElementInitializers.init_Message_4003(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest) getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
		// end added code
	}

	/**
	 * @generated
	 */
	protected void doConfigure(Message newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest) getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest) getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, getSource());
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, getTarget());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if (configureCommand != null && configureCommand.canExecute()) {
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
		return (Element) source;
	}

	/**
	 * @generated
	 */
	protected Element getTarget() {
		return (Element) target;
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
		for (EObject element = source; element != null; element = element.eContainer()) {
			if (element instanceof Interaction) {
				return (Interaction) element;
			}
		}
		return null;
	}

}
