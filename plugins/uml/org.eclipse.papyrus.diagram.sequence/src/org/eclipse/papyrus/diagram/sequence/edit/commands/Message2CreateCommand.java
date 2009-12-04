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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.diagram.sequence.util.MessageDirection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionUse;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Signal;

/**
 * @generated
 */
public class Message2CreateCommand extends EditElementCommand {

	/**
	 * Title for dialog of no referenced interaction error
	 * 
	 * @generated NOT
	 */
	private static final String NO_REFERENCED_INTERACTION_DIALOG_TITLE = "No referenced interaction"; //$NON-NLS-1$

	/**
	 * Message for dialog of no referenced interaction error
	 * 
	 * @generated NOT
	 */
	private static final String NO_REFERENCED_INTERACTION_DIALOG_MSG = "Couldn't had message if there isn't referenced interaction"; //$NON-NLS-1$

	/**
	 * Message for wrong gate container type error
	 * 
	 * @generated NOT
	 */
	private static final String WRONG_GATE_CONTAINER_TYPE_ERROR_MSG = "Wrong element UML type for create a gate"; //$NON-NLS-1$

	/**
	 * Title for dialog of choose actual gate
	 * 
	 * @generated NOT
	 */
	private static final String CHOOSE_GATE_DIALOG_TITLE = "Actual gates of the interaction use"; //$NON-NLS-1$

	/**
	 * Message for dialog of choose actual gate
	 * 
	 * @generated NOT
	 */
	private static final String CHOOSE_GATE_DIALOG_MSG = "Choose the gate to attach the message"; //$NON-NLS-1$

	/**
	 * Message for create link error
	 * 
	 * @generated NOT
	 */
	private static final String CREATE_LINK_ERROR_MSG = "Invalid arguments in create link command"; //$NON-NLS-1$

	/**
	 * Message for no container error
	 * 
	 * @generated NOT
	 */
	private static final String NO_CONTAINER_ERROR_MSG = "There is now valid container for events"; //$NON-NLS-1$

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
		return UMLBaseItemSemanticEditPolicy.LinkConstraints.canCreateMessage_4004(getContainer(), getSource(),
				getTarget());
	}

	/**
	 * added code to create the gate , message occurence and event when a Async message is created.
	 * 
	 * @generated NOT
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException(CREATE_LINK_ERROR_MSG);
		}

		// Retrieve container of call event which is an instance of Package
		Package eventContainer = CommandHelper.getEventContainer(container.getOwner());
		if(eventContainer != null) {
			// Create the Async Message
			Message message = container.createMessage("");

			// Add the message to the interaction
			container.getMessages().add(message);

			// Get the corresponding operation or signal
			Element signature = CommandHelper.getSignature(message, false);

			Event sendEvent = null;
			Event receiveEvent = null;

			if(signature instanceof Operation) {
				sendEvent = CommandHelper.createSendOperationEvent(eventContainer, (Operation)signature);
				receiveEvent = CommandHelper.createReceiveOperationEvent(eventContainer, (Operation)signature);
				message.setMessageSort(MessageSort.ASYNCH_CALL_LITERAL);

			} else if(signature instanceof Signal) {
				sendEvent = CommandHelper.createSendSignalEvent(eventContainer, (Signal)signature);
				receiveEvent = CommandHelper.createReceiveSignalEvent(eventContainer, (Signal)signature);
				message.setMessageSort(MessageSort.ASYNCH_SIGNAL_LITERAL);
			} else {
				sendEvent = CommandHelper.createCallEvent(eventContainer);
				receiveEvent = CommandHelper.createCallEvent(eventContainer);
				message.setMessageSort(MessageSort.ASYNCH_CALL_LITERAL);
			}

			MessageEnd startMsg = createMessageEnd(container, sendEvent, getSource(), MessageDirection.OUT);

			MessageEnd endMsg = createMessageEnd(container, receiveEvent, getTarget(), MessageDirection.IN);

			setCoveredLifeline(getSource(), startMsg);
			setCoveredLifeline(getTarget(), endMsg);

			if(startMsg != null && endMsg != null) {
				message.setSendEvent(startMsg);
				message.setReceiveEvent(endMsg);
				endMsg.setMessage(message);
				startMsg.setMessage(message);

				ElementInitializers.init_Message_4004(message);
				doConfigure(message, monitor, info);
				((CreateElementRequest)getRequest()).setNewElement(message);
				return CommandResult.newOKCommandResult(message);
			} else {
				return CommandResult.newCancelledCommandResult();
			}
		}
		return CommandResult.newErrorCommandResult(NO_CONTAINER_ERROR_MSG);
	}

	/**
	 * @genereated NOT
	 * @param element
	 * @param messageEnd
	 */
	private void setCoveredLifeline(Element element, MessageEnd messageEnd) {
		if(messageEnd instanceof MessageOccurrenceSpecification) {
			Lifeline sourceLL = null;
			if(element instanceof ExecutionSpecification) {
				sourceLL = ((ExecutionSpecification)element).getCovereds().get(0);
			} else if(element instanceof Lifeline) {
				sourceLL = (Lifeline)element;
			}

			CommandHelper.setSingleCovered(sourceLL, (MessageOccurrenceSpecification)messageEnd);
		}
	}

	/**
	 * Create a MessageEnd
	 * 
	 * @genereated NOT
	 * @param interaction
	 *        The Interaction
	 * @param callEvent
	 *        The call event
	 * @param element
	 *        The element
	 * @param direction
	 *        The message direction
	 * @return A MessageOccurrenceSpecification if element is ExecutionSpecification or Lifeline. A
	 *         Gate if element is Interaction or CombinedFragment or InteractionUse
	 */
	private static MessageEnd createMessageEnd(Interaction interaction, Event event, Element element,
			MessageDirection direction) {
		MessageEnd endMsg = null;
		if(element instanceof ExecutionSpecification || element instanceof Lifeline) {
			endMsg = CommandHelper.doCreateMessageOccurrence(interaction, event);
		} else if(element instanceof Interaction || element instanceof CombinedFragment
				|| element instanceof InteractionUse) {
			endMsg = doCreateGate(element, direction);
		}
		return endMsg;
	}

	/**
	 * Create gate if element is a Interaction, a Combined Fragment or a Interaction Use
	 * 
	 * @generated NOT
	 * @param element
	 *        The element
	 * @param direction
	 *        The message direction
	 * @return The gate
	 * @throws IllegalArgumentException
	 *         if the element is not a right element type
	 */
	private static Gate doCreateGate(Element element, MessageDirection direction) {
		Gate gate = null;

		if(element instanceof Interaction) {
			gate = ((Interaction)element).createFormalGate("");
		} else if(element instanceof CombinedFragment) {
			gate = ((CombinedFragment)element).createCfragmentGate("");
		} else if(element instanceof InteractionUse) {
			Shell shell = Display.getCurrent().getActiveShell();
			InteractionUse interactionUse = (InteractionUse)element;

			if(interactionUse.getRefersTo() == null) {
				MessageDialog.openError(shell, NO_REFERENCED_INTERACTION_DIALOG_TITLE,
						NO_REFERENCED_INTERACTION_DIALOG_MSG);
				return null;
			}

			ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance()
					.getItemProvidersAdapterFactory());
			ElementListSelectionDialog dialog = new ElementListSelectionDialog(shell, labelProvider);
			dialog.setTitle(CHOOSE_GATE_DIALOG_TITLE);
			dialog.setMessage(CHOOSE_GATE_DIALOG_MSG);
			dialog.setMultipleSelection(false);

			List<Gate> gates = new ArrayList<Gate>();
			for(Gate actualGate : ((InteractionUse)element).getActualGates()) {
				if(actualGate.getName().startsWith(direction.getName())) {
					gates.add(actualGate);
				}
			}
			dialog.setElements(gates.toArray());
			if(dialog.open() == Window.OK) {
				gate = (Gate)dialog.getFirstResult();
			}
		} else {
			throw new IllegalArgumentException(WRONG_GATE_CONTAINER_TYPE_ERROR_MSG);
		}

		if(gate != null) {
			ElementInitializers.init_NamedElement(gate, direction.toString().toLowerCase() + "_");
		}

		return gate;
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
