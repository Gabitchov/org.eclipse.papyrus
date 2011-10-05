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
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Rewrite of setMessageSignature
 *  
 *****************************************************************************/
package org.eclipse.papyrus.umlutils;

import java.util.LinkedList;
import java.util.List;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.command.UnexecutableCommand;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.core.utils.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.core.utils.PapyrusEcoreUtils;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLPackage;

public class MessageUtil {

	/**
	 * Sets the signature for a Message. As the signature is a derived property, calling this
	 * method may lead to a refactoring of the model. When changing from an operation to another
	 * operation, this method changes the operation associated to the send and receive events
	 * associated to the message.
	 * 
	 * However, when changing from a Signal to an Operation (This should be possible only in the case
	 * of an AsynchSignal message), an important refactoring is needed.
	 * The following changes occur :
	 * 
	 * - The SendSignalEvent is transformed to a SendOperationEvent
	 * - The ReceiveSignalEvent is transformed to a ReceiveSignalEvent
	 * - The SendSignalEvent and ReceiveSignalEvent are destroyed, if and only if they are not referenced by any other element
	 * - The operation is assigned to both the SendOperationEvent and ReceiveOperationEvent
	 * - The Message#messageSort is changed from AsynchSignal to AsynchCall
	 * 
	 * If one of the SignalEvents is missing, the corresponding OperationEvent is *not* created.
	 * If none of the events exist, then only the messageSort is changed.
	 * 
	 * All these changes are executed in a single Command, executed on the given editing domain.
	 * The Command is obtained through the Papyrus Service Edit
	 * 
	 * @param message
	 *        The message to edit
	 * @param newOperation
	 *        The operation to assign to the message's signature
	 * @param domain
	 *        The message's TransactionalEditingDomain
	 */
	public static void setMessageSignature(Message message, Operation newOperation, TransactionalEditingDomain domain) {
		setMessageSignature(message, newOperation, domain, UMLPackage.eINSTANCE.getSendSignalEvent(), UMLPackage.eINSTANCE.getSendOperationEvent(), UMLPackage.eINSTANCE.getSendOperationEvent_Operation(), UMLPackage.eINSTANCE.getReceiveSignalEvent(), UMLPackage.eINSTANCE.getReceiveOperationEvent(), UMLPackage.eINSTANCE.getReceiveOperationEvent_Operation(), MessageSort.ASYNCH_SIGNAL_LITERAL, MessageSort.ASYNCH_CALL_LITERAL);
	}

	/**
	 * Sets the signature for a Message. As the signature is a derived property, calling this
	 * method may lead to a refactoring of the model. When changing from a signal to another
	 * signal, this method changes the signal associated to the send and receive events
	 * associated to the message.
	 * 
	 * However, when changing from an Operation to a Signal (This should be possible only in the case
	 * of an AsynchCall message), an important refactoring is needed.
	 * The following changes occur :
	 * 
	 * - The SendOperationEvent is transformed to a SendSignalEvent
	 * - The ReceiveOperationEvent is transformed to a ReceiveSignalEvent
	 * - The SendOperationEvent and ReceiveOperationEvent are destroyed, if and only if they are not referenced by any other element
	 * - The signal is assigned to both the SendSignalEvent and ReceiveSignalEvent
	 * - The Message#messageSort is changed from AsynchCall to AsynchSignal
	 * 
	 * If one of the OperationEvents is missing, the corresponding SignalEvent is *not* created.
	 * If none of the events exist, then only the messageSort is changed.
	 * 
	 * All these changes are executed in a single Command, executed on the given editing domain.
	 * The Command is obtained through the Papyrus Service Edit
	 * 
	 * @param message
	 *        The message to edit
	 * @param newOperation
	 *        The operation to assign to the message's signature
	 * @param domain
	 *        The message's TransactionalEditingDomain
	 */
	public static void setMessageSignature(Message message, Signal newSignal, TransactionalEditingDomain domain) {
		setMessageSignature(message, newSignal, domain, UMLPackage.eINSTANCE.getSendOperationEvent(), UMLPackage.eINSTANCE.getSendSignalEvent(), UMLPackage.eINSTANCE.getSendSignalEvent_Signal(), UMLPackage.eINSTANCE.getReceiveOperationEvent(), UMLPackage.eINSTANCE.getReceiveSignalEvent(), UMLPackage.eINSTANCE.getReceiveSignalEvent_Signal(), MessageSort.ASYNCH_CALL_LITERAL, MessageSort.ASYNCH_SIGNAL_LITERAL);
	}

	/**
	 * A generic method to edit the message's signature
	 * 
	 * @param message
	 *        The message being edited
	 * @param signature
	 *        The new signature
	 * @param domain
	 *        The EditingDomain on which the command is executed
	 * @param fromSendClass
	 *        If the current event is an instance of this class, a refactoring is needed
	 * @param toSendClass
	 *        The EClass corresponding to the expected SendEvent. This class will be instantiated when a refactoring is needed
	 *        The new instance will be created in the same package as the previous event.
	 * @param toSendFeature
	 *        The EStructuralFeature on which the new value will be set
	 * @param fromReceiveClass
	 *        If the current event is an instance of this class, a refactoring is needed
	 * @param toReceiveClass
	 *        The EClass corresponding to the expected ReceiveEvent. This class will be instantiated when a refactoring is needed.
	 *        The new instance will be created in the same package as the previous event.
	 * @param toReceiveFeature
	 *        The EStructuralFeature on which the new value will be set
	 * @param fromSort
	 *        If the current MessageSort is equal to this value, the MessageSort will be changed
	 * @param toSort
	 *        The new MessageSort to set if the current MessageSort is equal to fromSort
	 */
	private static void setMessageSignature(Message message, Element signature, TransactionalEditingDomain domain, EClass fromSendClass, EClass toSendClass, EStructuralFeature toSendFeature, EClass fromReceiveClass, EClass toReceiveClass, EStructuralFeature toReceiveFeature, MessageSort fromSort, MessageSort toSort) {

		if(message == null) {
			return;
		}

		MessageEnd receiveEnd = message.getReceiveEvent();
		MessageEnd sendEnd = message.getSendEvent();

		CompoundCommand command = new CompoundCommand(""); //$NON-NLS-1$

		List<Element> receiveElementsToAdd = new LinkedList<Element>(); //out argument
		List<Element> receiveElementsToRemove = new LinkedList<Element>(); //out argument
		Package receiveEventParent = refactor(receiveEnd, fromReceiveClass, toReceiveClass, toReceiveFeature, signature, command, domain, receiveElementsToAdd, receiveElementsToRemove);

		List<Element> sendElementsToAdd = new LinkedList<Element>(); //out argument
		List<Element> sendElementsToRemove = new LinkedList<Element>(); //out argument
		Package sendEventParent = refactor(sendEnd, fromSendClass, toSendClass, toSendFeature, signature, command, domain, sendElementsToAdd, sendElementsToRemove);

		//All elements are added/removed at the same time to avoid a SetCommand to override another one
		if(sendEventParent != null && receiveEventParent == sendEventParent) {
			List<Element> ownedElements = new BasicEList<Element>(sendEventParent.getPackagedElements());
			ownedElements.addAll(sendElementsToAdd);
			ownedElements.addAll(receiveElementsToAdd);
			ownedElements.removeAll(sendElementsToRemove);
			ownedElements.removeAll(receiveElementsToRemove);
			command.append(setValueToElement(sendEventParent, UMLPackage.eINSTANCE.getPackage_PackagedElement(), ownedElements, domain));
		} else {
			if(sendEventParent != null) {
				List<Element> ownedElements = new BasicEList<Element>(sendEventParent.getPackagedElements());
				ownedElements.addAll(sendElementsToAdd);
				ownedElements.remove(sendElementsToRemove);
				command.append(setValueToElement(sendEventParent, UMLPackage.eINSTANCE.getPackage_PackagedElement(), ownedElements, domain));
			}
			if(receiveEventParent != null) {
				List<Element> ownedElements = new BasicEList<Element>(receiveEventParent.getPackagedElements());
				ownedElements.addAll(receiveElementsToAdd);
				ownedElements.remove(receiveElementsToRemove);
				command.append(setValueToElement(receiveEventParent, UMLPackage.eINSTANCE.getPackage_PackagedElement(), ownedElements, domain));
			}
		}

		if(fromSort != null && message.getMessageSort() == fromSort) {
			MessageSort messageSort = toSort;
			command.append(setValueToElement(message, UMLPackage.eINSTANCE.getMessage_MessageSort(), messageSort, domain));
		}

		domain.getCommandStack().execute(command);
	}


	/**
	 * A generic method to refactor the SendEvent and ReceiveEvent when needed.
	 * This method does *not* execute the commands. Instead, the generated commands
	 * are appended to the given CompoundCommand.
	 * 
	 * This method outputs 3 elements :
	 * 
	 * - elementsToAdd (out) : The elements to add to the returned package
	 * - elementsToRemove (out) : The elements to remove from the returned package
	 * - package (return) : The package in which the elements are added or from which they are removed
	 * 
	 * @param messageEnd
	 *        The messageEnd that may need a refactoring
	 * @param fromClass
	 *        If the current event is an instance of this class, a refactoring is needed
	 * @param toClass
	 *        The EClass corresponding to the expected event. This class will be instantiated when a refactoring is needed
	 * @param toFeature
	 *        The EStructuralFeature on which the new value will be set
	 * @param elementToSet
	 *        The value to assign to the new event
	 * @param command
	 *        The edition commands will be appended to this CompoundCommand
	 * @param domain
	 *        The TransactionalEditingDomain on which the commands will be executed
	 * @param elementsToAdd
	 *        The elements to add to the returned package
	 * @param elementsToRemove
	 *        The elements to remove from the returned package
	 * @return
	 *         The package in which the elements are added or from which they are removed.
	 *         This method doesn't execute any change directly, nor returns
	 *         any command affecting the package's content. The reason is that when chaining commands
	 *         (With "SetRequest" or "SetCommand") on multiple-reference features, the full list of element is needed.
	 *         Thus, when we have two consecutive SetRequests applied on the same element, the second one overrides the first one.
	 *         The best solution would be to have an "AddRequest" and a "RemoveRequest", but none of these requests exist. The "RemoveRequest"
	 *         can be replaced by a "DestroyElementRequest", but this is still not compatible with the SetRequest used to add new elements
	 *         to the package, which will override it (And restore the deleted element).
	 */
	private static Package refactor(MessageEnd messageEnd, EClass fromClass, EClass toClass, EStructuralFeature toFeature, Element elementToSet, CompoundCommand command, TransactionalEditingDomain domain, List<Element> elementsToAdd, List<Element> elementsToRemove) {

		Package messageEventParent = null;

		if((messageEnd != null) && (messageEnd instanceof MessageOccurrenceSpecification)) {
			MessageOccurrenceSpecification messageOccSpec = (MessageOccurrenceSpecification)messageEnd;
			Event event = messageOccSpec.getEvent();

			if(event != null) {
				if(fromClass.isInstance(event)) {
					//Delete the previous event if it isn't used anymore
					if(PapyrusEcoreUtils.isOnlyUsage(event, messageOccSpec)) {
						elementsToRemove.add(event);
					}

					//Create the new event
					messageEventParent = event.getNearestPackage();
					event = (Event)UMLPackage.eINSTANCE.getEFactoryInstance().create(toClass);
					elementsToAdd.add(event);
					command.append(setValueToElement(messageOccSpec, UMLPackage.eINSTANCE.getOccurrenceSpecification_Event(), event, domain));
				}

				if(toClass.isInstance(event)) {
					command.append(setValueToElement(event, toFeature, elementToSet, domain));
				}
			}
		}

		return messageEventParent;
	}

	/**
	 * Return an EMF Command from the given GMF Request.
	 * The EMF Command is obtained via the Papyrus Service Edit.
	 * 
	 * @param source
	 *        The source EObject on which the command applies
	 * @param request
	 *        The Request used to generate the command
	 * @return
	 *         The EMF Command corresponding to the given request.
	 *         May be an UnexecutableCommand if an error occurs.
	 */
	private static Command getCommandFromRequest(Element source, IEditCommandRequest request) {
		try {
			IElementEditService provider = ElementEditServiceUtils.getCommandProvider(source);

			if(provider != null) {
				ICommand createGMFCommand = provider.getEditCommand(request);

				Command emfCommand = new GMFtoEMFCommandWrapper(createGMFCommand);

				return emfCommand;
			}
		} catch (Exception ex) {
			Activator.logException(ex);
		}

		return UnexecutableCommand.INSTANCE;
	}

	/**
	 * Creates and returns an EMF Command to handle a model change.
	 * The command uses the Papyrus Service Edit.
	 * 
	 * @param source
	 *        The EObject being edited
	 * @param feature
	 *        The source's structural feature being edited
	 * @param value
	 *        The new value to set
	 * @param domain
	 *        The editing domain on which the command should be executed
	 * @return
	 *         The EMF Command
	 */
	private static Command setValueToElement(Element source, EStructuralFeature feature, Object value, TransactionalEditingDomain domain) {
		SetRequest request = new SetRequest(domain, source, feature, value);
		return getCommandFromRequest(source, request);
	}

	// @unused
	public static Operation getMessageOperation(Message message) {

		NamedElement signature = message.getSignature();
		if(signature instanceof Operation) {
			return (Operation)signature;
		} else {
			return null;
		}
	}

	// @unused
	public static Signal getMessageSignal(Message message) {

		NamedElement signature = message.getSignature();
		if(signature instanceof Signal) {
			return (Signal)signature;
		} else {
			return null;
		}
	}
}
