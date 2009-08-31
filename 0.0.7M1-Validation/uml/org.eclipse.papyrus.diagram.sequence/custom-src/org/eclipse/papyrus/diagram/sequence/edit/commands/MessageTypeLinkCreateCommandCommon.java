/*******************************************************************************
 * Copyright (c) 2007 Conselleria de Infraestructuras y Transporte, Generalitat 
 * de la Comunitat Valenciana . All rights reserved. This program
 * and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Gabriel Merin Cubero (Prodevelop) – Sequence Diagram Implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.sequence.edit.commands;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.CreationEvent;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.SendOperationEvent;
import org.eclipse.uml2.uml.SendSignalEvent;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.UMLPackage;

import org.eclipse.papyrus.diagram.common.util.MultiDiagramUtil;
import org.eclipse.papyrus.diagram.common.actions.LabelHelper;

/**
 * @generated
 */
public class MessageTypeLinkCreateCommandCommon extends CreateElementCommand {

	/**
	 * @generated
	 */
	public MessageTypeLinkCreateCommandCommon(CreateRelationshipRequest req) {
		super(req);
	}

	private Package getPackageFromInteraction(Interaction myContainer) {
		Package interactionPackage = myContainer.getPackage();
		while (interactionPackage == null) {
			if (myContainer.getPackage() == null
					&& myContainer.getEnclosingInteraction() != null)
				return getPackageFromInteraction(myContainer
						.getEnclosingInteraction());
			else
				return null;
		}

		return interactionPackage;
	}

	/**
	 * Main method
	 * 
	 * @param myContainer
	 * @param mySource
	 * @param myTarget
	 * @param newMessage
	 * @generated NOT
	 */
	protected void doDefaultMessageInitialize(Interaction myContainer,
			Element mySource, Element myTarget, Message newMessage) {
		// Events
		Event sourceEvent = null;
		Event targetEvent = null;

		// Package where the interaction is contained. Remeber that an
		// interaction may be contained withind another interaction.
		Package interactionPackage = getPackageFromInteraction(myContainer);

		switch (newMessage.getMessageSort().getValue()) {
		case MessageSort.SYNCH_CALL:
		case MessageSort.ASYNCH_CALL:
			// Create the SendOperationEvent
			sourceEvent = (SendOperationEvent) interactionPackage
					.createPackagedElement("SendOperationEvent",
							UMLPackage.eINSTANCE.getSendOperationEvent());
			LabelHelper.INSTANCE.initName(interactionPackage, sourceEvent);

			// Create the CallEvent
			targetEvent = (CallEvent) interactionPackage.createPackagedElement(
					"CallEvent", UMLPackage.eINSTANCE.getCallEvent());
			LabelHelper.INSTANCE.initName(interactionPackage, targetEvent);
			break;

		case MessageSort.REPLY:
			sourceEvent = null;
			targetEvent = null;
			break;

		case MessageSort.ASYNCH_SIGNAL:
			// Create the SendSignalEvent
			sourceEvent = (SendSignalEvent) interactionPackage
					.createPackagedElement("SendSignalEvent",
							UMLPackage.eINSTANCE.getSendSignalEvent());
			LabelHelper.INSTANCE.initName(interactionPackage, sourceEvent);

			// create the SignalEvent (equal to RecieveSignalEvent)
			targetEvent = (SignalEvent) interactionPackage
					.createPackagedElement("SignalEvent", UMLPackage.eINSTANCE
							.getSignalEvent());
			LabelHelper.INSTANCE.initName(interactionPackage, targetEvent);
			break;

		case MessageSort.DELETE_MESSAGE:
			// create the SignalEvent (equal to RecieveSignalEvent)
			targetEvent = (DestructionEvent) interactionPackage
					.createPackagedElement("DestructionEvent",
							UMLPackage.eINSTANCE.getDestructionEvent());
			LabelHelper.INSTANCE.initName(interactionPackage, targetEvent);
			break;

		case MessageSort.CREATE_MESSAGE:
			// Create the CreationEvent
			targetEvent = (CreationEvent) interactionPackage
					.createPackagedElement("CreationEvent",
							UMLPackage.eINSTANCE.getCreationEvent());
			LabelHelper.INSTANCE.initName(interactionPackage, targetEvent);
			break;
		}

		// Create the 2 MessageOcurrenceSpecification
		MessageOccurrenceSpecification msgSend = (MessageOccurrenceSpecification) myContainer
				.createFragment("MessageOccurrenceSpecification",
						UMLPackage.eINSTANCE
								.getMessageOccurrenceSpecification());
		LabelHelper.INSTANCE.initName(myContainer, msgSend);

		MessageOccurrenceSpecification msgReceive = (MessageOccurrenceSpecification) myContainer
				.createFragment("MessageOccurrenceSpecification",
						UMLPackage.eINSTANCE
								.getMessageOccurrenceSpecification());
		LabelHelper.INSTANCE.initName(myContainer, msgReceive);

		// Initialization of the Message
		newMessage.setSendEvent(msgSend);
		newMessage.setReceiveEvent(msgReceive);

		// Initialization of the MessageOccurrenceSpecifications

		// msgSend
		if (sourceEvent != null)
			msgSend.setEvent(sourceEvent);
		msgSend.setMessage(newMessage);
		// Initialize the covered reference
		Lifeline lifeLine = null;
		if (mySource instanceof BehaviorExecutionSpecification) {
			BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) mySource;
			if (bes.getCovereds().size() > 0) {
				lifeLine = bes.getCovereds().get(0);
				msgSend.getCovereds().add(lifeLine);
			}
		} else {
			lifeLine = (Lifeline) mySource;
			msgSend.getCovereds().add(lifeLine);
		}

		// msgReceive
		if (targetEvent != null)
			msgReceive.setEvent(targetEvent);
		msgReceive.setMessage(newMessage);
		// Initialize the covered reference
		lifeLine = null;
		if (myTarget instanceof BehaviorExecutionSpecification) {
			BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) myTarget;
			if (bes.getCovereds().size() > 0) {
				lifeLine = bes.getCovereds().get(0);
				msgReceive.getCovereds().add(lifeLine);
			}
		} else {
			lifeLine = (Lifeline) myTarget;
			msgReceive.getCovereds().add(lifeLine);
		}

		// NOT DONE HERE ANYMORE - Now is responsibility of MessageOrderCommand
		// Initialization of the BehaviorExecutionSpecifications
		// BehaviorExecutionSpecification bes;
		// if (mySource instanceof BehaviorExecutionSpecification) {
		// bes = (BehaviorExecutionSpecification) mySource;
		// if (bes.getStart() == null)
		// bes.setStart(msgSend);
		//
		// bes.setFinish(msgSend);
		// }
		//
		// if (myTarget instanceof BehaviorExecutionSpecification) {
		// bes = (BehaviorExecutionSpecification) myTarget;
		// if (bes.getStart() == null)
		// bes.setStart(msgReceive);
		//
		// bes.setFinish(msgReceive);
		// }

	}

	/**
	 * @generated
	 * 
	 * @author fjcano
	 */
	protected Diagram getDiagramFromRequest() {
		// used in doDefaultElementCreation()
		if (getRequest().getParameters().get(
				MultiDiagramUtil.BelongToDiagramSource) != null) {
			Object parameter = getRequest().getParameters().get(
					MultiDiagramUtil.BelongToDiagramSource);
			if (parameter instanceof Diagram) {
				return (Diagram) parameter;
			}
		}
		return null;
	}

}
