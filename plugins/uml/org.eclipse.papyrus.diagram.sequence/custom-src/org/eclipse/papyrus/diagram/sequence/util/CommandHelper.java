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
package org.eclipse.papyrus.diagram.sequence.util;

import java.util.LinkedList;

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.diagram.sequence.part.UMLDiagramEditorPlugin;
import org.eclipse.papyrus.diagram.sequence.providers.ElementInitializers;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.uml2.uml.CallEvent;
import org.eclipse.uml2.uml.CreationEvent;
import org.eclipse.uml2.uml.DestructionEvent;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Event;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.ReceiveOperationEvent;
import org.eclipse.uml2.uml.ReceiveSignalEvent;
import org.eclipse.uml2.uml.SendOperationEvent;
import org.eclipse.uml2.uml.SendSignalEvent;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * A helper class for the message command.
 * 
 */
public class CommandHelper {

	/**
	 * Retrieve the event container. A recursive method that test if a given element is a Package.
	 * 
	 * @param element
	 *        the element
	 * @return the first package found in the hierarchy or null if nothing has been found
	 */
	public static Package getEventContainer(Element element) {
		Package container = null;
		if(element instanceof Package) {
			container = (Package)element;
		} else if(element != null) {
			container = getEventContainer(element.getOwner());
		}
		return container;
	}

	/**
	 * @param interaction
	 * @param newCallevent
	 * @return
	 */
	public static MessageOccurrenceSpecification doCreateMessageOccurrence(Interaction interaction, Event event) {
		MessageOccurrenceSpecification result = UMLFactory.eINSTANCE.createMessageOccurrenceSpecification();
		ElementInitializers.init_NamedElement(result);
		result.setEnclosingInteraction(interaction);
		result.setEvent(event);
		return result;
	}

	/**
	 * Attach an Interaction on a Lifeline
	 * 
	 * @param lifeline
	 *        The lifeline
	 * @param fragment
	 *        The interaction fragment
	 */
	public static void setSingleCovered(Lifeline lifeline, InteractionFragment fragment) {
		if(!fragment.getCovereds().contains(lifeline)) {
			fragment.getCovereds().add(lifeline);
		}
	}

	/**
	 * Create a call event
	 * 
	 * @param eventContainer
	 *        the container
	 * @return the call event
	 */
	public static CallEvent createCallEvent(Package eventContainer) {
		CallEvent callevent = (CallEvent)eventContainer.createPackagedElement("", UMLPackage.eINSTANCE.getCallEvent()); //$NON-NLS-1$
		ElementInitializers.init_NamedElement(callevent);
		return callevent;
	}

	/**
	 * Create a SendOperation event and initializes its name
	 * 
	 * @param eventContainer
	 *        the container
	 * @param operation
	 *        the operation of the event
	 * @return the sendOperation event
	 */
	public static SendOperationEvent createSendOperationEvent(Package eventContainer, Operation operation) {
		SendOperationEvent sendOperationEvent = (SendOperationEvent)eventContainer.createPackagedElement("", UMLPackage.eINSTANCE.getSendOperationEvent()); //$NON-NLS-1$
		ElementInitializers.init_NamedElement(sendOperationEvent);
		if(operation != null) {
			sendOperationEvent.setOperation(operation);
		}
		return sendOperationEvent;
	}

	/**
	 * Create a ReceiveOperation event and initializes its name
	 * 
	 * @param eventContainer
	 *        the container
	 * @return the receiveOperation event
	 */
	public static ReceiveOperationEvent createReceiveOperationEvent(Package eventContainer, Operation operation) {
		ReceiveOperationEvent receiveOperationEvent = (ReceiveOperationEvent)eventContainer.createPackagedElement("", UMLPackage.eINSTANCE.getReceiveOperationEvent()); //$NON-NLS-1$
		ElementInitializers.init_NamedElement(receiveOperationEvent);
		if(operation != null) {
			receiveOperationEvent.setOperation(operation);
		}
		return receiveOperationEvent;
	}

	/**
	 * Create a send signal event and initializes its name
	 * 
	 * @param eventContainer
	 *        the container
	 * @return the send signal event
	 */
	public static SendSignalEvent createSendSignalEvent(Package eventContainer, Signal signal) {
		SendSignalEvent sendSignalEvent = (SendSignalEvent)eventContainer.createPackagedElement("", UMLPackage.eINSTANCE.getSendSignalEvent()); //$NON-NLS-1$
		ElementInitializers.init_NamedElement(sendSignalEvent);
		if(signal != null) {
			sendSignalEvent.setSignal(signal);
		}
		return sendSignalEvent;
	}

	/**
	 * Create a ReceiveSignal event and initializes its name
	 * 
	 * @param eventContainer
	 *        the container
	 * @return the ReceiveSignal event
	 */
	public static ReceiveSignalEvent createReceiveSignalEvent(Package eventContainer, Signal signal) {
		ReceiveSignalEvent receiveSignalEvent = (ReceiveSignalEvent)eventContainer.createPackagedElement("", UMLPackage.eINSTANCE.getReceiveSignalEvent()); //$NON-NLS-1$
		ElementInitializers.init_NamedElement(receiveSignalEvent);
		if(signal != null) {
			receiveSignalEvent.setSignal(signal);
		}
		return receiveSignalEvent;
	}

	/**
	 * Create a receive signal event
	 * 
	 * @param eventContainer
	 *        the container
	 * @return the receive signal event
	 */
	public static CreationEvent createCreationEvent(Package eventContainer) {
		CreationEvent creationEvent = UMLFactory.eINSTANCE.createCreationEvent();
		creationEvent = (CreationEvent)eventContainer.createPackagedElement("", creationEvent.eClass()); //$NON-NLS-1$
		ElementInitializers.init_NamedElement(creationEvent);
		return creationEvent;
	}

	/**
	 * Create a destruction event
	 * 
	 * @param eventContainer
	 *        the container
	 * @return the destruction event
	 */
	public static DestructionEvent createDestructionEvent(Package eventContainer) {
		DestructionEvent destructionEvent = UMLFactory.eINSTANCE.createDestructionEvent();
		destructionEvent = (DestructionEvent)eventContainer.createPackagedElement("", destructionEvent.eClass()); //$NON-NLS-1$
		ElementInitializers.init_NamedElement(destructionEvent);
		return destructionEvent;
	}

	public static Element getSignature(Message message) {
		return getSignature(message, true);
	}

	/**
	 * 
	 * @param message
	 * @return
	 */
	public static Element getSignature(Message message, boolean hasMessageSort) {

		if(message == null) {
			return null;
		}

		ILabelProvider labelProvider = new AdapterFactoryLabelProvider(UMLDiagramEditorPlugin.getInstance()
				.getItemProvidersAdapterFactory());
		ElementListSelectionDialog dialog = new ElementListSelectionDialog(Display.getCurrent().getActiveShell(),
				labelProvider);
		dialog.setTitle("Signature Selection");
		dialog.setMessage("Select a signature (* = any string, ? = any char):");

		LinkedList<Object> result = new LinkedList<Object>();

		result.add("");

		if(!hasMessageSort) {
			result.addAll(ItemPropertyDescriptor
					.getReachableObjectsOfType(message, UMLPackage.eINSTANCE.getOperation()));
			result.addAll(ItemPropertyDescriptor.getReachableObjectsOfType(message, UMLPackage.eINSTANCE.getSignal()));
		} else if(MessageSort.SYNCH_CALL_LITERAL.equals(message.getMessageSort())
				|| MessageSort.ASYNCH_CALL_LITERAL.equals(message.getMessageSort())
				|| MessageSort.REPLY_LITERAL.equals(message.getMessageSort())) {
			result.addAll(ItemPropertyDescriptor
					.getReachableObjectsOfType(message, UMLPackage.eINSTANCE.getOperation()));
		} else if(MessageSort.ASYNCH_SIGNAL_LITERAL.equals(message.getMessageSort())) {
			result.addAll(ItemPropertyDescriptor.getReachableObjectsOfType(message, UMLPackage.eINSTANCE.getSignal()));
		}

		result.remove(null);
		dialog.setElements(result.toArray());

		Element signature = null;
		if(dialog.open() == Dialog.OK) {
			if(!"".equals(dialog.getFirstResult())) {
				signature = (Element)dialog.getFirstResult();
			}
		}
		return signature;
	}

}
