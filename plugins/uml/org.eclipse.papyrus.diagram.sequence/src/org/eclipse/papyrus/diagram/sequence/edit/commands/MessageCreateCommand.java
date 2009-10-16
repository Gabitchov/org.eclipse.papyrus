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
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;

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
	 * @generated-not
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
		// added code
		if (getTarget() == getSource())// the source must be different from the target
		{
			return false;
		}
		// end added code
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canCreateMessage_4003(getContainer(), getSource(),
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
		setSingleCovered(start, lifeline);
		setSingleCovered(finish, lifeline);

		spec.setStart(start);
		spec.setFinish(finish);
	}

	private void setSingleCovered(InteractionFragment fragment, Lifeline lifeline) {
		if (!fragment.getCovereds().contains(lifeline)) {
			fragment.getCovereds().add(lifeline);
		}
	}

	/**
	 * the Method create a MessageOccurenceSpecification and the call event when a message is
	 * created
	 * 
	 * @generated-not
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

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

			Lifeline sourceLL = start.getCovereds().get(0);// get the lifeline which contain
			// BehaviorExecutionSpecification
			Lifeline targetLL = end.getCovereds().get(0);// get the lifeline which
			// BehaviorExecutionSpecification

			setupBehaviorSpec(start, msgOccurenceInvocationStart, msgOccurenceInvocationEnd, sourceLL);
			setupBehaviorSpec(end, msgOccurenceInvocationEnd, msgOccurenceInvocationStart, targetLL);

			domainSource = (MessageOccurrenceSpecification) start.getStart();
			domainTarget = (MessageOccurrenceSpecification) end.getStart();

			if (domainSource != null && domainTarget != null) {
				newElement = interaction.createMessage("");
				interaction.getMessages().add(newElement);// add the message to the interaction
				newElement.setSendEvent(domainSource);
				newElement.setReceiveEvent(domainTarget);

				domainSource.setMessage(newElement);// built the relationship
				// messsageoccurencespecification and the
				// message
				domainTarget.setMessage(newElement);
			}

			ElementInitializers.init_Message_4003(newElement);
			doConfigure(newElement, monitor, info);
			((CreateElementRequest) getRequest()).setNewElement(newElement);

		}

		return CommandResult.newOKCommandResult(newElement);

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
