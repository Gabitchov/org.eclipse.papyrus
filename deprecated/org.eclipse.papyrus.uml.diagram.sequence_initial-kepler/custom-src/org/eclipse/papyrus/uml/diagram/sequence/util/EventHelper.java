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
package org.eclipse.papyrus.uml.diagram.sequence.util;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * An utility class to create event elements.
 * 
 */
public class EventHelper {

	/**
	 * Create an event
	 * 
	 * @param eventContainer
	 *        the container
	 * @return the event
	 */
	public static Event doCreateEvent(Package eventContainer, EClass eClass) {
		Event event = (Event)eventContainer.createPackagedElement(null, eClass);
		ElementInitializers.init_NamedElement(event);
		return event;
	}

	/**
	 * Create an event
	 * 
	 * @param eventContainer
	 *        the container
	 * @return the event
	 */
	public static CallEvent doCreateCallEvent(Package eventContainer, Operation operation) {
		CallEvent event = (CallEvent)doCreateEvent(eventContainer, UMLPackage.eINSTANCE.getCallEvent());
		event.setOperation(operation);
		return event;
	}


	/**
	 * Create a SendOperation event and initializes its name
	 * 
	 * @param eventContainer
	 *        the container
	 * @param operation
	 *        the operation of the event. Can't be null
	 * @return the sendOperation event
	 */
	// Does not exist anymore in UML 2.4		
	//	public static SendOperationEvent doCreateSendOperationEvent(Package eventContainer, Operation operation) {
	//		SendOperationEvent sendOperationEvent = (SendOperationEvent)doCreateEvent(eventContainer, UMLPackage.eINSTANCE.getSendOperationEvent());
	//		sendOperationEvent.setOperation(operation);
	//		return sendOperationEvent;
	//	}

	/**
	 * Create a ReceiveOperation event and initializes its name
	 * 
	 * @param eventContainer
	 *        the container
	 * @param operation
	 *        the operation of the event. Can't be null
	 * @return the receiveOperation event
	 */
	// Does not exist anymore in UML 2.4	
	//	public static ReceiveOperationEvent doCreateReceiveOperationEvent(Package eventContainer, Operation operation) {
	//		ReceiveOperationEvent receiveOperationEvent = (ReceiveOperationEvent)doCreateEvent(eventContainer, UMLPackage.eINSTANCE.getReceiveOperationEvent());
	//		receiveOperationEvent.setOperation(operation);
	//		return receiveOperationEvent;
	//	}

	/**
	 * Create a send signal event and initializes its name
	 * 
	 * @param eventContainer
	 *        the container
	 * @param signal
	 *        the signal of the event. Can't be null
	 * @return the send signal event
	 */
	// Does not exist anymore in UML 2.4	
	//	public static SendSignalEvent doCreateSendSignalEvent(Package eventContainer, Signal signal) {
	//		SendSignalEvent sendSignalEvent = (SendSignalEvent)doCreateEvent(eventContainer, UMLPackage.eINSTANCE.getSendSignalEvent());
	//		sendSignalEvent.setSignal(signal);
	//		return sendSignalEvent;
	//	}

	/**
	 * Create a ReceiveSignal event and initializes its name
	 * 
	 * @param eventContainer
	 *        the container
	 * @param signal
	 *        the signal of the event. Can't be null
	 * @return the ReceiveSignal event
	 */
	// Does not exist anymore in UML 2.4	
	//	public static ReceiveSignalEvent doCreateReceiveSignalEvent(Package eventContainer, Signal signal) {
	//		ReceiveSignalEvent receiveSignalEvent = (ReceiveSignalEvent)doCreateEvent(eventContainer, UMLPackage.eINSTANCE.getReceiveSignalEvent());
	//		receiveSignalEvent.setSignal(signal);
	//		return receiveSignalEvent;
	//	}

	// Does not exist anymore in UML 2.4	
	//	/**
	//	 * Create a receive signal event
	//	 * 
	//	 * @param eventContainer
	//	 *        the container
	//	 * @return the receive signal event
	//	 */
	//	public static CreationEvent doCreateCreationEvent(Package eventContainer) {
	//		return (CreationEvent)doCreateEvent(eventContainer, UMLPackage.eINSTANCE.getCreationEvent());
	//	}
	//
	//	/**
	//	 * Create a destruction event
	//	 * 
	//	 * @param eventContainer
	//	 *        the container
	//	 * @return the destruction event
	//	 */
	//	public static DestructionEvent doCreateDestructionEvent(Package eventContainer) {
	//		return (DestructionEvent)doCreateEvent(eventContainer, UMLPackage.eINSTANCE.getDestructionEvent());
	//	}
	//
	//	/**
	//	 * Create an execution event
	//	 * 
	//	 * @param eventContainer
	//	 *        the container
	//	 * @return the executionEvent
	//	 */
	//	public static ExecutionEvent doCreateExecutionEvent(Package eventContainer) {
	//		return (ExecutionEvent)doCreateEvent(eventContainer, UMLPackage.eINSTANCE.getExecutionEvent());
	//	}


	/**
	 * Create a receive event in the package containing the interaction
	 * If the messageSort is ASYNCH_SIGNAL, it creates a ReceiveSignalEvent
	 * If the messageSort is ASYNCH_CALL or SYNCH_CALL or REPLY_LITERAL, it creates a ReceiveOperationEvent
	 * If the messageSort is CREATE_MESSAGE, it creates a CreationEvent.
	 * If the messageSort is DELETE_MESSAGE, it creates a DestructionEvent.
	 * 
	 * @param messageSort
	 *        the messageSort
	 * @param interaction
	 *        the interaction
	 * @param signature
	 *        the signature of the message
	 * @return the created receive event or null
	 */
	public static Event doCreateReceiveEvent(MessageSort messageSort, Interaction interaction, NamedElement signature) {
		Package eventContainer = interaction.getNearestPackage();
		Event event = null;

		switch(messageSort) {
		case ASYNCH_SIGNAL_LITERAL:
			//event = doCreateReceiveSignalEvent(eventContainer, (Signal)signature);
			break;
		case ASYNCH_CALL_LITERAL:
		case SYNCH_CALL_LITERAL:
		case REPLY_LITERAL:
			//event = doCreateReceiveOperationEvent(eventContainer, (Operation)signature);
			break;
		case CREATE_MESSAGE_LITERAL:
			//event = doCreateCreationEvent(eventContainer);
			break;
		case DELETE_MESSAGE_LITERAL:
			//event = doCreateDestructionEvent(eventContainer);
			break;
		default:
			break;

		}
		return event;
	}

	/**
	 * Create a sending event in the package containing the interaction.
	 * If the messageSort is ASYNCH_SIGNAL, CREATE_MESSAGE, DELETE_MESSAGE, it creates a SendSignalEvent
	 * If the messageSort is ASYNCH_CALL, SYNCH_CALL, REPLY_LITERAL, it creates a SendOperationEvent.
	 * 
	 * @param messageSort
	 *        the messageSort
	 * @param interaction
	 *        the interaction
	 * @param signature
	 *        the signature of the message
	 * @return the created send event or null
	 */
	public static Event doCreateSendEvent(MessageSort messageSort, Interaction interaction, NamedElement signature) {
		Package eventContainer = interaction.getNearestPackage();
		Event event = null;
		switch(messageSort) {
		case ASYNCH_SIGNAL_LITERAL:
		case CREATE_MESSAGE_LITERAL:
		case DELETE_MESSAGE_LITERAL:
			//event = doCreateSendSignalEvent(eventContainer, (Signal)signature);
			break;
		case ASYNCH_CALL_LITERAL:
		case SYNCH_CALL_LITERAL:
		case REPLY_LITERAL:
			//event = doCreateSendOperationEvent(eventContainer, (Operation)signature);
			break;
		default:
			break;

		}
		return event;
	}

}
