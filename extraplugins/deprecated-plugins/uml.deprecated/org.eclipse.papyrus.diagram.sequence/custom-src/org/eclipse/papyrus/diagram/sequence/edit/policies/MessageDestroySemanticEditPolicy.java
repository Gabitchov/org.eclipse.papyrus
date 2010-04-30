/***************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.policies;

import java.util.Iterator;

import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.GeneralOrdering;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

import org.eclipse.papyrus.diagram.sequence.edit.commands.MessageOrderCommand;

public class MessageDestroySemanticEditPolicy extends UMLBaseItemSemanticEditPolicy {
	@Override
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		/*
		 * Destroy all the elements that are created when a message is created the first time:
		 * 1.- The Send Event
		 * 2.- The Receive Event
		 * 3.- The 2 Message Occurrence Specifications
		 * 4.- The message
		 * 
		 * To accomplish this, will build a compound command
		 */

		CompoundCommand compoundCmd = new CompoundCommand();

		if (req.getElementToDestroy() instanceof Message) {
			Message msg = (Message) req.getElementToDestroy();

			// Obtain the elements to destroy
			MessageOccurrenceSpecification msgSend = null;
			MessageOccurrenceSpecification msgRecieve = null;
			Event sendEvent = null;
			Event receiveEvent = null;

			if (msg.getSendEvent() instanceof MessageOccurrenceSpecification)
				msgSend = (MessageOccurrenceSpecification) msg.getSendEvent();

			if (msg.getReceiveEvent() instanceof MessageOccurrenceSpecification)
				msgRecieve = (MessageOccurrenceSpecification) msg
						.getReceiveEvent();

			if (msgSend != null)
				sendEvent = msgSend.getEvent();
			if (msgRecieve != null)
				receiveEvent = msgRecieve.getEvent();
			
			// Update ordering
			compoundCmd.add(new MessageOrderCommand(req));

			// Create and compound the Destroy Element Commands
			if (sendEvent != null) {
				DestroyElementRequest reqSendEvent = new DestroyElementRequest(req
						.getEditingDomain(), sendEvent, false);
				compoundCmd
						.add(getGEFWrapper(new DestroyElementCommand(reqSendEvent)));
			}

			if (receiveEvent != null) {
				DestroyElementRequest reqReceiveEvent = new DestroyElementRequest(req
						.getEditingDomain(), receiveEvent, false);
				compoundCmd
						.add(getGEFWrapper(new DestroyElementCommand(reqReceiveEvent)));
			}

			if (msgSend != null) {
				// Destroy first its general ordering
				for (Iterator<GeneralOrdering> i = msgSend.getGeneralOrderings().iterator(); i.hasNext();) {
					DestroyElementRequest reqGenOrd = new DestroyElementRequest(req.getEditingDomain(), i.next(), false);
					compoundCmd.add(getGEFWrapper(new DestroyElementCommand(
							reqGenOrd)));
				}
				
				// Destroy the MessageOccurrenceSpecification
				DestroyElementRequest reqMsgSend = new DestroyElementRequest(
						req.getEditingDomain(), msgSend, false);
				compoundCmd.add(getGEFWrapper(new DestroyElementCommand(
						reqMsgSend)));
			}

			if (msgRecieve != null) {
				// Destroy first its general ordering
				for (Iterator<GeneralOrdering> i = msgRecieve.getGeneralOrderings().iterator(); i.hasNext();) {
					DestroyElementRequest reqGenOrd = new DestroyElementRequest(req.getEditingDomain(), i.next(), false);
					compoundCmd.add(getGEFWrapper(new DestroyElementCommand(
							reqGenOrd)));
				}
				
				// Destroy the MessageOccurrenceSpecification
				DestroyElementRequest reqMsgReceive = new DestroyElementRequest(
						req.getEditingDomain(), msgRecieve, false);
				compoundCmd.add(getGEFWrapper(new DestroyElementCommand(
						reqMsgReceive)));
			}

		}

		compoundCmd.add(getGEFWrapper(new DestroyElementCommand(req)));

		return compoundCmd;
	}

}
