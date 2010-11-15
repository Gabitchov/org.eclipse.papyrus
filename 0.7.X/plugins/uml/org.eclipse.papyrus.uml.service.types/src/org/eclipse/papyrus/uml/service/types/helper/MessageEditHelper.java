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
 * 
 * 		Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.helper;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.papyrus.service.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.service.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.service.types.command.MessageAsyncReorientCommand;
import org.eclipse.papyrus.uml.service.types.command.MessageCreateReorientCommand;
import org.eclipse.papyrus.uml.service.types.command.MessageDeleteReorientCommand;
import org.eclipse.papyrus.uml.service.types.command.MessageFoundReorientCommand;
import org.eclipse.papyrus.uml.service.types.command.MessageLostReorientCommand;
import org.eclipse.papyrus.uml.service.types.command.MessageReplyReorientCommand;
import org.eclipse.papyrus.uml.service.types.command.MessageSyncReorientCommand;
import org.eclipse.papyrus.umlutils.ExecutionSpecificationUtil;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageKind;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * <pre>
 * 
 * This helper provides edit commands for UML {@link Message}.
 * 
 * </pre>
 */
public class MessageEditHelper extends DefaultUMLEditHelper {

	/**
	 * <pre>
	 * This method build a re-orient command depending on the kind of Message,
	 * and compose this basic command with another which updates the MessageEnd.
	 * </pre>
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelper#getReorientRelationshipCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest)
	 * 
	 * @param req
	 *        the re-orient request
	 * @return the re-orient command
	 */
	@Override
	protected ICommand getReorientRelationshipCommand(ReorientRelationshipRequest req) {
		ICommand reorientCommand = null;

		// Build the initial re-orient command depending on the kind of Message
		Message msgToReorient = (Message)req.getRelationship();

		if(msgToReorient.getMessageKind() == MessageKind.LOST_LITERAL) {
			reorientCommand = new MessageLostReorientCommand(req);

		} else if(msgToReorient.getMessageKind() == MessageKind.FOUND_LITERAL) {
			reorientCommand = new MessageFoundReorientCommand(req);

		} else if(msgToReorient.getMessageSort() == MessageSort.SYNCH_CALL_LITERAL) {
			reorientCommand = new MessageSyncReorientCommand(req);

		} else if(msgToReorient.getMessageSort() == MessageSort.ASYNCH_CALL_LITERAL) {
			reorientCommand = new MessageAsyncReorientCommand(req);

		} else if(msgToReorient.getMessageSort() == MessageSort.ASYNCH_SIGNAL_LITERAL) {
			reorientCommand = new MessageAsyncReorientCommand(req);

		} else if(msgToReorient.getMessageSort() == MessageSort.REPLY_LITERAL) {
			reorientCommand = new MessageReplyReorientCommand(req);

		} else if(msgToReorient.getMessageSort() == MessageSort.CREATE_MESSAGE_LITERAL) {
			reorientCommand = new MessageCreateReorientCommand(req);

		} else if(msgToReorient.getMessageSort() == MessageSort.DELETE_MESSAGE_LITERAL) {
			// Forbid the target re-orient command of delete Message.
			// The re-orient command is provided but the MessageEnd update is not correctly implemented.
			if(req.getDirection() == ReorientRelationshipRequest.REORIENT_SOURCE) {
				reorientCommand = new MessageDeleteReorientCommand(req);

			} else if(req.getDirection() == ReorientRelationshipRequest.REORIENT_TARGET) {
				// Not correctly implemented - Forbid this kind of re-orient for now.
				reorientCommand = UnexecutableCommand.INSTANCE;
			}
		}

		// Build the command that will update the message end
		ICommand updateMessageEndCommand = null;

		MessageEnd msgEndToUpdate = null;
		if(req.getDirection() == ReorientRelationshipRequest.REORIENT_SOURCE) {
			msgEndToUpdate = msgToReorient.getSendEvent();
		} else if(req.getDirection() == ReorientRelationshipRequest.REORIENT_TARGET) {
			msgEndToUpdate = msgToReorient.getReceiveEvent();
		}

		updateMessageEndCommand = getUpdateMessageEndCommand(msgEndToUpdate, (Element)req.getOldRelationshipEnd(), (Element)req.getNewRelationshipEnd());

		// Compose both commands
		reorientCommand = CompositeCommand.compose(reorientCommand, updateMessageEndCommand);

		return reorientCommand.reduce();
	}

	/**
	 * <pre>
	 * This method provides a command to update the {@link MessageEnd} concerned by a re-orient request.
	 * </pre>
	 * 
	 * @param messageEnd
	 *        the {@link MessageEnd} concerned by the re-orient command
	 * @param oldElement
	 *        the old {@link Element} graphically attached to the {@link Message}
	 * @param newElement
	 *        the new {@link Element} graphically attached to the {@link Message}
	 * @return the update command
	 */
	private ICommand getUpdateMessageEndCommand(MessageEnd messageEnd, Element oldElement, Element newElement) {

		ICommand updateCommand = null;

		if(messageEnd instanceof MessageOccurrenceSpecification) {
			updateCommand = getUpdateMessageOccurenceSpecificationCommand((MessageOccurrenceSpecification)messageEnd, oldElement, newElement);
		} else if(messageEnd instanceof Gate) { // Gate case is not currently implemented
			updateCommand = getUpdateGateCommand((Gate)messageEnd, oldElement, newElement);
		}

		return updateCommand;
	}

	/**
	 * <pre>
	 * This method provides a command to update the {@link MessageOccurrenceSpecification} concerned by a re-orient request.
	 * </pre>
	 * 
	 * @param messageEnd
	 *        the {@link MessageOccurrenceSpecification} concerned by the re-orient command
	 * @param oldElement
	 *        the old {@link Element} graphically attached to the {@link Message}
	 * @param newElement
	 *        the new {@link Element} graphically attached to the {@link Message}
	 * @return the update command
	 */
	private ICommand getUpdateMessageOccurenceSpecificationCommand(MessageOccurrenceSpecification messageEnd, Element oldElement, Element newElement) {

		ICommand updateCommand = null;

		if(newElement instanceof Lifeline) {
			updateCommand = getUpdateOccurenceSpecificationCommand(messageEnd, (Lifeline)newElement);

		} else if(newElement instanceof ExecutionSpecification) {
			Lifeline lifeline = ExecutionSpecificationUtil.getExecutionSpecificationLifeline((ExecutionSpecification)newElement);
			if(lifeline != null) {
				updateCommand = getUpdateOccurenceSpecificationCommand(messageEnd, lifeline);
			}

		}

		return updateCommand;
	}

	/**
	 * <pre>
	 * This method provides a command to update the {@link OccurrenceSpecification} concerned by a re-orient request.
	 * </pre>
	 * 
	 * @param os
	 *        the {@link OccurrenceSpecification} concerned by the re-orient command
	 * @param newLifeline
	 *        the new {@link Lifeline} graphically covered by the {@link OccurrenceSpecification}
	 * @return the update command
	 */
	private ICommand getUpdateOccurenceSpecificationCommand(OccurrenceSpecification os, Lifeline newLifeline) {

		ICommand updateCommand = null;

		List<Lifeline> covereds = new ArrayList<Lifeline>();
		covereds.add(newLifeline);

		IElementEditService provider = ElementEditServiceUtils.getCommandProvider(os);
		if(provider != null) {

			// Create a command the set the OccurenceSpecification covered EReference with the newLifeline
			SetRequest setCoveredRequest = new SetRequest(os, UMLPackage.eINSTANCE.getInteractionFragment_Covered(), covereds);
			updateCommand = provider.getEditCommand(setCoveredRequest);

		}

		return updateCommand;
	}

	/**
	 * <pre>
	 * This method provides a command to update the {@link Gate} concerned by a re-orient request.
	 * 
	 * TODO : Not currently implemented.
	 * </pre>
	 * 
	 * @param gate
	 *        the {@link Gate} concerned by the re-orient command
	 * @param oldElement
	 *        the old {@link Element} graphically attached to the {@link Message}
	 * @param newElement
	 *        the new {@link Element} graphically attached to the {@link Message}
	 * @return the update command
	 */
	private ICommand getUpdateGateCommand(Gate gate, Element oldElement, Element newElement) {
		return null;
	}
}
