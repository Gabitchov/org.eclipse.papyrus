/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.ReceiveOperationEvent;
import org.eclipse.uml2.uml.ReceiveSignalEvent;
import org.eclipse.uml2.uml.SendOperationEvent;
import org.eclipse.uml2.uml.SendSignalEvent;
import org.eclipse.uml2.uml.Signal;

public class MessageUtil {

	// @unused
	public static Operation getMessageOperation(Message message) {

		NamedElement signature = message.getSignature();
		if (signature instanceof Operation) {
			return (Operation) signature;
		} else {
			return null;
		}
	}

	// @unused
	public static void setMessageOperation(Message message, Operation newOperation) {

		if (message == null) {
			return;
		}

		MessageEnd recvEnd = message.getReceiveEvent();
		MessageEnd sendEnd = message.getSendEvent();

		if ((recvEnd != null) && (recvEnd instanceof MessageOccurrenceSpecification)) {
			MessageOccurrenceSpecification recvOS = (MessageOccurrenceSpecification) recvEnd;
			Event recvEvent = recvOS.getEvent();

			if ((recvEvent != null) && (recvEvent instanceof ReceiveOperationEvent)) {
				((ReceiveOperationEvent) recvEvent).setOperation(newOperation);
			}
		}

		if ((sendEnd != null) && (sendEnd instanceof MessageOccurrenceSpecification)) {
			MessageOccurrenceSpecification sendOS = (MessageOccurrenceSpecification) sendEnd;
			Event sendEvent = sendOS.getEvent();

			if ((sendEvent != null) && (sendEvent instanceof SendOperationEvent)) {
				((SendOperationEvent) sendEvent).setOperation(newOperation);
			}
		}
	}

	// @unused
	public static Signal getMessageSignal(Message message) {

		NamedElement signature = message.getSignature();
		if (signature instanceof Signal) {
			return (Signal) signature;
		} else {
			return null;
		}
	}

	// @unused
	public static void setMessageSignal(Message message, Signal newSignal) {

		if (message == null) {
			return;
		}

		MessageEnd recvEnd = message.getReceiveEvent();
		MessageEnd sendEnd = message.getSendEvent();

		if ((recvEnd != null) && (recvEnd instanceof MessageOccurrenceSpecification)) {
			MessageOccurrenceSpecification recvOS = (MessageOccurrenceSpecification) recvEnd;
			Event recvEvent = recvOS.getEvent();

			if ((recvEvent != null) && (recvEvent instanceof ReceiveSignalEvent)) {
				((ReceiveSignalEvent) recvEvent).setSignal(newSignal);
			}
		}

		if ((sendEnd != null) && (sendEnd instanceof MessageOccurrenceSpecification)) {
			MessageOccurrenceSpecification sendOS = (MessageOccurrenceSpecification) sendEnd;
			Event sendEvent = sendOS.getEvent();

			if ((sendEvent != null) && (sendEvent instanceof SendSignalEvent)) {
				((SendSignalEvent) sendEvent).setSignal(newSignal);
			}
		}
	}
}
