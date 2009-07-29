/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/

package org.eclipse.papyrus.diagram.common.commands;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.papyrus.diagram.common.actions.LabelHelper;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.InstanceValue;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageEvent;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.PrimitiveType;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.ReceiveOperationEvent;
import org.eclipse.uml2.uml.ReceiveSignalEvent;
import org.eclipse.uml2.uml.SendOperationEvent;
import org.eclipse.uml2.uml.SendSignalEvent;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.SignalEvent;
import org.eclipse.uml2.uml.TypedElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.ValueSpecification;

/**
 * Command for updating the Signature associated with a Message
 * 
 * Creation 14 juin 06
 * 
 * @author jlescot
 */
public class UpdateMessageSignatureCommand extends Command {

	/** The Message to update */
	private Message message;

	private String oldMessageName;

	private String newMessageName;

	private boolean createMessageEvent;

	/** The new NamedElement that represents the Signature of the Message */
	private NamedElement newSignature;

	/** The old NamedElement that represents the Signature of the Message */
	private NamedElement oldSignature;

	/** The MessageEvent that will be associated with the Signature */
	private MessageEvent messageEvent;

	private List<ValueSpecification> oldArguments;

	private List<ValueSpecification> newArguments;

	/**
	 * Create a command for updating the Signature of a given Message
	 * 
	 * @param message
	 *            the current message object
	 * @param newSignature
	 *            the new namedElement that represents the signature of the message
	 * @param domain
	 *            the edit domain
	 */
	public UpdateMessageSignatureCommand(Message message, NamedElement newSignature) {
		this.message = message;
		this.newSignature = newSignature;
	}

	/**
	 * Store the old Property associated with the represents property of the Lifeline and then make
	 * the redo
	 * 
	 * @see org.eclipse.gef.commands.Command#execute()
	 */
	@Override
	public void execute() {
		oldSignature = message.getSignature();

		// The oldMessageName is the name of the message before it is modified
		oldMessageName = message.getName();

		// The newMessageName is the name of the newSignature or the empty
		// String if the signature is null
		newMessageName = newSignature == null ? "" : newSignature.getName();

		// get the arguments associated with the Signatures
		oldArguments = new ArrayList<ValueSpecification>(message.getArguments());
		newArguments = initializeArguments(newSignature);

		messageEvent = getMessageEvent(message);
		createMessageEvent = messageEvent == null;

		if (createMessageEvent) {
			// We need to create the MessageEvent and associate it with the
			// Message
			if (isSignal(message)) {
				messageEvent = UMLFactory.eINSTANCE.createSignalEvent();
			} else {
				messageEvent = UMLFactory.eINSTANCE.createCallEvent();
			}

			LabelHelper.INSTANCE.initName(message.getNearestPackage(), messageEvent);
		}

		redo();
	}

	/**
	 * Update the message parameters
	 * 
	 * @see org.eclipse.gef.commands.Command#redo()
	 */
	@Override
	public void redo() {
		if (createMessageEvent) {
			// We add the message that was created in the execute() method
			message.getNearestPackage().getPackagedElements().add(messageEvent);
		}

		// Update the Signature of the MessageEvent
		setMessageEventSignature(messageEvent, newSignature);

		// Update the arguments of the Message
		message.getArguments().clear();
		message.getArguments().addAll(newArguments);

		// Update the name of the Message
		message.setName(newMessageName);
	}

	/**
	 * Undo the update
	 * 
	 * @see org.eclipse.gef.commands.Command#undo()
	 */
	@Override
	public void undo() {
		setMessageEventSignature(messageEvent, oldSignature);

		if (createMessageEvent) {
			message.getNearestPackage().getPackagedElements().remove(messageEvent);
		}

		// Update the arguments of the Message
		message.getArguments().clear();
		message.getArguments().addAll(oldArguments);

		// update the name of the Message
		message.setName(oldMessageName);
	}

	/**
	 * This method create all the necessary arguments that will match a given signature
	 * 
	 * @param signature
	 *            the Signature
	 * @return a List containing all the ValueSpecifications that will represent the function
	 *         signature
	 */
	private List initializeArguments(NamedElement signature) {
		List arguments = new ArrayList<ValueSpecification>();
		List attributes = new ArrayList<EObject>();

		// Retrieve the Properties or Parameters from the Signature
		if (signature instanceof Operation) {
			attributes = ((Operation) signature).getOwnedParameters();
		} else if (signature instanceof Signal) {
			attributes = ((Signal) signature).getOwnedAttributes();
		}

		// Iterates on all the Properties or Parameters and create the
		// representative Argument
		Iterator<TypedElement> itAttributes = attributes.iterator();
		while (itAttributes.hasNext()) {
			TypedElement attribute = itAttributes.next();

			// Manage the Primitive types
			if (attribute.getType() instanceof PrimitiveType) {
				if (attribute.getType().getName().equals("Boolean")) {
					if (attribute instanceof Property) {
						arguments.add(((Property) attribute).createDefaultValue(attribute.getName(), attribute
								.getType(), UMLPackage.Literals.LITERAL_BOOLEAN));
					} else if (attribute instanceof Parameter) {
						arguments.add(((Parameter) attribute).createDefaultValue(attribute.getName(), attribute
								.getType(), UMLPackage.Literals.LITERAL_BOOLEAN));
					}
				} else if (attribute.getType().getName().equals("Integer")) {
					if (attribute instanceof Property) {
						arguments.add(((Property) attribute).createDefaultValue(attribute.getName(), attribute
								.getType(), UMLPackage.Literals.LITERAL_INTEGER));
					} else if (attribute instanceof Parameter) {
						arguments.add(((Parameter) attribute).createDefaultValue(attribute.getName(), attribute
								.getType(), UMLPackage.Literals.LITERAL_INTEGER));
					}
				} else if (attribute.getType().getName().equals("String")) {
					if (attribute instanceof Property) {
						arguments.add(((Property) attribute).createDefaultValue(attribute.getName(), attribute
								.getType(), UMLPackage.Literals.LITERAL_STRING));
					} else if (attribute instanceof Parameter) {
						arguments.add(((Parameter) attribute).createDefaultValue(attribute.getName(), attribute
								.getType(), UMLPackage.Literals.LITERAL_STRING));
					}
				}
				// -RFU- traitement des autres types primitifs comme String Literal
				else {
					if (attribute instanceof Property) {
						arguments.add(((Property) attribute).createDefaultValue(attribute.getName(), attribute
								.getType(), UMLPackage.Literals.LITERAL_STRING));
					} else if (attribute instanceof Parameter) {
						arguments.add(((Parameter) attribute).createDefaultValue(attribute.getName(), attribute
								.getType(), UMLPackage.Literals.LITERAL_STRING));
					}
				}
			}

			// -RFU- Manage the Enumeration types
			else if (attribute.getType() instanceof org.eclipse.uml2.uml.Enumeration) {
				InstanceValue instanceValue = UMLFactory.eINSTANCE.createInstanceValue();
				instanceValue.setName(attribute.getName());
				instanceValue.setType(attribute.getType());
				arguments.add(instanceValue);
			}
			// Manage the Class types
			else if (attribute.getType() instanceof org.eclipse.uml2.uml.Class) {
				InstanceValue instanceValue = UMLFactory.eINSTANCE.createInstanceValue();
				// -RFU- rajout du nom
				instanceValue.setName(attribute.getName());

				instanceValue.setType(attribute.getType());
				arguments.add(instanceValue);
			}

			// Manage any other type
			// -RFU- traiter les autres types comme des String Literal
			else {
				if (attribute instanceof Property) {
					// arguments.add(((Property) attribute).createDefaultValue(null, null,
					// UMLPackage.Literals.LITERAL_NULL));
					arguments.add(((Property) attribute).createDefaultValue(attribute.getName(), attribute.getType(),
							UMLPackage.Literals.LITERAL_STRING));
				} else if (attribute instanceof Parameter) {
					arguments.add(((Parameter) attribute).createDefaultValue(attribute.getName(), attribute.getType(),
							UMLPackage.Literals.LITERAL_STRING));
				}
			}
		}

		return arguments;
	}

	/**
	 * Get the MessageEvent associated with a Message. The MessageEvent will be associated with the
	 * Signature of the Message. So we first search the SendEvent and then the ReceiveEvent in the
	 * case of the SendEvent does not exist.
	 * 
	 * @param msg
	 *            the Message
	 * @return the MessageEvent that will be associated with the Signature of the Message
	 */
	private static MessageEvent getMessageEvent(Message msg) {
		MessageEvent msgEvent = null;

		MessageEnd sendEvent = msg.getSendEvent();

		if (sendEvent instanceof MessageOccurrenceSpecification) {
			Event event = ((MessageOccurrenceSpecification) sendEvent).getEvent();

			if (event instanceof MessageEvent) {
				msgEvent = (MessageEvent) event;
			}
		}

		if (msgEvent == null) {
			MessageEnd receiveEvent = msg.getReceiveEvent();

			if (receiveEvent instanceof MessageOccurrenceSpecification) {
				Event event = ((MessageOccurrenceSpecification) receiveEvent).getEvent();

				if (event instanceof MessageEvent) {
					msgEvent = (MessageEvent) event;
				}
			}
		}

		return msgEvent;
	}

	/**
	 * Return true if the message is a Signal Message
	 * 
	 * @param message
	 *            the message to check
	 * @return true if the message is a Signal Message
	 */
	private static boolean isSignal(Message message) {
		return message.getMessageSort().getValue() == MessageSort.ASYNCH_SIGNAL;
	}

	/**
	 * This method is used to set the signature of a MessageEvent
	 * 
	 * @param messEvent
	 *            the MessageEvent
	 * @param signature
	 *            the newSignature. This may be a null Signature.
	 */
	public static void setMessageEventSignature(MessageEvent messEvent, NamedElement signature) {
		if (messEvent instanceof CallEvent) {
			((CallEvent) messEvent).setOperation((Operation) signature);
		} else if (messEvent instanceof ReceiveOperationEvent) {
			((ReceiveOperationEvent) messEvent).setOperation((Operation) signature);
		} else if (messEvent instanceof SendOperationEvent) {
			((SendOperationEvent) messEvent).setOperation((Operation) signature);
		} else if (messEvent instanceof SignalEvent) {
			((SignalEvent) messEvent).setSignal((Signal) signature);
		} else if (messEvent instanceof ReceiveSignalEvent) {
			((ReceiveSignalEvent) messEvent).setSignal((Signal) signature);
		} else if (messEvent instanceof SendSignalEvent) {
			((SendSignalEvent) messEvent).setSignal((Signal) signature);
		}
	}
}
