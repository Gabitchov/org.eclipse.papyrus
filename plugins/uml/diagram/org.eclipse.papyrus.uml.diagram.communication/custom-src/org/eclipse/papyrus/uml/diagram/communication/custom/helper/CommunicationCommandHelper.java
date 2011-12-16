/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib saadia.dhouib@cea.fr  - Adapted from Sequence Diagram
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.communication.custom.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.papyrus.uml.diagram.common.util.MessageDirection;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLFactory;





// TODO: Auto-generated Javadoc
/**
 * The Class CommunicationCommandHelper.
 */
public class CommunicationCommandHelper {

	/**
	 * Get the messageSort of a message if it doesn't exist yet depending of the messageSignature.
	 * If no messageSort exists, and if the signature is null, then return a MessageSort.ASYNCH_CALL_LITERAL
	 * 
	 * @param signature
	 *        the signature of the message or null
	 * @param messageSort
	 *        a messageSort or null
	 * @return the messageSort
	 */
	private static MessageSort getMessageSort(NamedElement signature, MessageSort messageSort) {
		if(messageSort == null) {
			if(signature instanceof Signal) {
				return MessageSort.ASYNCH_SIGNAL_LITERAL;
			} else {
				return MessageSort.ASYNCH_CALL_LITERAL;
			}
		}
		return messageSort;
	}




	/**
	 * Create a message. It also creates its message end, their corresponding events and updates the signature of the message.
	 * 
	 * @param container
	 *        the interaction containing the message.
	 * @param messageSort
	 *        the messageSort of the message, it can be null
	 * @param source
	 *        the source of the message, it can be null
	 * @param target
	 *        the target of the message, it can be null
	 * @return the created message
	 */
	public static Message doCreateMessage(Interaction container, MessageSort messageSort, Element source, Element target) {
		return doCreateMessage(container, messageSort, source, target, null, null);
	}


	/**
	 * Create a message. It also creates its message end (if not provided), their corresponding events and updates the signature of the message.
	 * 
	 * @param container
	 *        the interaction containing the message.
	 * @param messageSort
	 *        the messageSort of the message, it can be null
	 * @param source
	 *        the source of the message, it can be null
	 * @param target
	 *        the target of the message, it can be null
	 * @param sendMessageEnd
	 *        the existing Send MessageEnd of the message
	 * @param receiveMessageEnd
	 *        the existing Receive MessageEnd of the message
	 * @return the created message
	 */
	public static Message doCreateMessage(Interaction container, MessageSort messageSort, Element source, Element target, MessageEnd sendMessageEnd, MessageEnd receiveMessageEnd) {

		List<NamedElement> signatures = new ArrayList<NamedElement>();



		NamedElement signature = null;
		if(!signatures.isEmpty()) {
			signature = signatures.get(0);
		}

		// Get the correct MessageSort
		messageSort = getMessageSort(signature, messageSort);

		// Create the message
		Message message = doCreateMessage(container, messageSort, signature);

		// Create the two message ends
		if(sendMessageEnd == null && source != null) {
			sendMessageEnd = createMessageEnd(container, EventHelper.doCreateSendEvent(messageSort, container, signature), source, MessageDirection.OUT);
		}
		if(receiveMessageEnd == null && target != null) {
			receiveMessageEnd = createMessageEnd(container, EventHelper.doCreateReceiveEvent(messageSort, container, signature), target, MessageDirection.IN);
		}

		// Update the messages end with the message
		if(sendMessageEnd != null) {
			sendMessageEnd.setMessage(message);
			org.eclipse.papyrus.uml.diagram.communication.custom.providers.ElementInitializers.init_NamedElement(sendMessageEnd, "", message.getName(), "Send"); //$NON-NLS-1$ //$NON-NLS-2$
			// Update the message with the messages end
			message.setSendEvent(sendMessageEnd);
		}
		if(receiveMessageEnd != null) {
			receiveMessageEnd.setMessage(message);
			org.eclipse.papyrus.uml.diagram.communication.custom.providers.ElementInitializers.init_NamedElement(receiveMessageEnd, "", message.getName(), "Recv"); //$NON-NLS-1$ //$NON-NLS-2$
			// Update the message with the messages end
			message.setReceiveEvent(receiveMessageEnd);
		}

		return message;
	}

	/**
	 * Create a message on the given interaction. It only creates the message and not its messages end.
	 * 
	 * @param interaction
	 *        the containing interaction
	 * @param messageSort
	 *        the messageSort.
	 * @param signature
	 *        the signature
	 * @return the created message
	 */
	public static Message doCreateMessage(Interaction interaction, MessageSort messageSort, NamedElement signature) {
		Message message = interaction.createMessage(null);

		// Set the interaction that will contain the message
		message.setInteraction(interaction);

		// Set MessageSort
		message.setMessageSort(messageSort);

		// Init Name
		if(signature == null) {
			org.eclipse.papyrus.uml.diagram.communication.custom.providers.ElementInitializers.init_NamedElement(message);
		} else {
			message.setName(signature.getName());
			message.setSignature(signature);
		}

		return message;
	}

	/**
	 * Create message occurence specification.
	 * 
	 * @param fragment
	 *        the fragment
	 * @param event
	 *        The event to attach
	 * @param lifeline
	 *        the lifeline
	 * @return The message occurence specification
	 */
	public static MessageOccurrenceSpecification doCreateMessageOccurrence(InteractionFragment fragment, Event event, Lifeline lifeline) {

		// Create the MOS
		MessageOccurrenceSpecification mos = UMLFactory.eINSTANCE.createMessageOccurrenceSpecification();

		// Configure the MOS
		doConfigureOccurenceSpecification(mos, event, fragment, lifeline);

		return mos;
	}

	/**
	 * Configure an OccurrenceSpecification.
	 * 
	 * @param os
	 *        the occurrenceSpecification to configure
	 * @param event
	 *        the event to associated with the {@link OccurrenceSpecification}
	 * @param fragment
	 *        the fragment containing the {@link OccurrenceSpecification}. It can be an {@link Interaction} or an {@link InteractionOperand}
	 * @param lifeline
	 *        the covered lifeline
	 */
	private static void doConfigureOccurenceSpecification(OccurrenceSpecification os, Event event, InteractionFragment fragment, Lifeline lifeline) {

		// Set the Container of the OccurrenceSpecification
		if(fragment instanceof Interaction) {
			os.setEnclosingInteraction((Interaction)fragment);
		}

		// Set the covered lifeline
		os.getCovereds().add(lifeline);

		// Set the event of the OccurrenceSpecification
		//os.setEvent(event);

	}

	/**
	 * Create a MessageEnd.
	 * 
	 * @param interactionFragment
	 *        the interaction fragment
	 * @param event
	 *        the event
	 * @param element
	 *        The element
	 * @param direction
	 *        The message direction
	 * @return A MessageOccurrenceSpecification if element is ExecutionSpecification or Lifeline. A
	 *         Gate if element is Interaction or CombinedFragment or InteractionUse
	 */
	public static MessageEnd createMessageEnd(InteractionFragment interactionFragment, Event event, Element element, MessageDirection direction) {
		MessageEnd endMsg = null;
		if(element instanceof Lifeline) {
			endMsg = doCreateMessageOccurrence(interactionFragment, event, (Lifeline)element);
		}
		return endMsg;
	}


}
