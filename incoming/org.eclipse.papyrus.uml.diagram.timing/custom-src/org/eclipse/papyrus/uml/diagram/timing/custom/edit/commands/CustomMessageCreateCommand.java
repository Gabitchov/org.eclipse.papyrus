/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.EcoreUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.MessageUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.OccurrenceSpecificationUtils;
import org.eclipse.uml2.uml.DestructionOccurrenceSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageKind;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * Creates a Message between MessageOccurrenceSpecifications. Converts OccurrenceSpecifications to
 * MessageOccurrenceSpecifications if needed
 */
public class CustomMessageCreateCommand extends EditElementCommand {

	private final Interaction interaction;
	private final EObject source;
	private final EObject target;
	private final MessageKind messageKind;
	private final MessageSort messageSort;

	public CustomMessageCreateCommand(final CreateRelationshipRequest request) {
		super(request.getLabel(), null, request);
		this.source = request.getSource();
		this.target = request.getTarget();
		this.messageKind = MessageUtils.getMessageKind(request.getElementType());
		this.messageSort = MessageUtils.getMessageSort(request.getElementType());
		this.interaction = EcoreUtils.getContaining(this.source, Interaction.class);
	}

	@Override
	public boolean canExecute() {
		if (this.source == null && this.target == null) {
			return false;
		}

		// no create or destroy Message to a Gate
		if (this.target instanceof Gate && (this.messageSort == MessageSort.CREATE_MESSAGE_LITERAL || this.messageSort == MessageSort.DELETE_MESSAGE_LITERAL)) {
			return false;
		}
		// no create message can target a destruction
		if (this.messageSort == MessageSort.CREATE_MESSAGE_LITERAL && this.target instanceof DestructionOccurrenceSpecification) {
			return false;
		}

		if (this.messageKind == MessageKind.FOUND_LITERAL) {
			if (this.source != null && !(this.source instanceof Lifeline)) {
				return false;
			}
		} else if (this.source != null && !(MessageUtils.isPotentialMessageEnd(this.source))) {
			return false;
		}

		if (this.messageKind == MessageKind.LOST_LITERAL) {
			if (this.target != null && !(this.target instanceof Lifeline)) {
				return false;
			}
		} else if (this.target != null && !(MessageUtils.isPotentialMessageEnd(this.target))) {
			return false;
		}
		if (this.source == null) {
			return true; // link creation is in progress; source is not defined yet
		}
		if (this.interaction == null) {
			return false;
		}
		return true;
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in create link command"); //$NON-NLS-1$
		}

		final boolean destruction = this.messageSort == MessageSort.DELETE_MESSAGE_LITERAL;
		final boolean creation = this.messageSort == MessageSort.CREATE_MESSAGE_LITERAL;

		if (destruction) {
			OccurrenceSpecificationUtils.deleteEverythingAfter((OccurrenceSpecification) this.target, null);
		}
		if (creation) {
			OccurrenceSpecificationUtils.deleteEverythingBefore((OccurrenceSpecification) this.target, null);
		}

		// a "found" message comes from nowhere
		final MessageEnd messageSource = this.messageKind == MessageKind.FOUND_LITERAL ? null : MessageUtils.convertToMessageOccurrenceSpecification(
				this.source, false);
		// a "lost" message goes to nowhere
		final MessageEnd messageTarget = this.messageKind == MessageKind.LOST_LITERAL ? null : MessageUtils.convertToMessageOccurrenceSpecification(
				this.target, destruction);

		if (!MessageUtils.isValidMessage(this.messageSort, this.messageKind, messageSource, messageTarget)) {
			throw new ExecutionException("Invalid Message"); //$NON-NLS-1$
		}

		final Message newMessage = UMLFactory.eINSTANCE.createMessage();
		this.interaction.getMessages().add(newMessage);
		newMessage.setSendEvent(messageSource);
		newMessage.setReceiveEvent(messageTarget);
		newMessage.setMessageSort(this.messageSort);
		newMessage.setName(""); //$NON-NLS-1$

		((CreateElementRequest) getRequest()).setNewElement(newMessage);
		return CommandResult.newOKCommandResult(newMessage);

	}

}
