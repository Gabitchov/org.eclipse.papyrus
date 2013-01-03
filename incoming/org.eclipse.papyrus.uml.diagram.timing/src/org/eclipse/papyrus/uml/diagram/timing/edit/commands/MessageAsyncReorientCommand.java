/*
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.papyrus.uml.diagram.timing.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.papyrus.uml.diagram.timing.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;

/**
 * @generated
 */
@SuppressWarnings("all")
// disable warnings on generated code
public class MessageAsyncReorientCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private final int reorientDirection;

	/**
	 * @generated
	 */
	private final EObject oldEnd;

	/**
	 * @generated
	 */
	private final EObject newEnd;

	/**
	 * @generated
	 */
	public MessageAsyncReorientCommand(final ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		this.reorientDirection = request.getDirection();
		this.oldEnd = request.getOldRelationshipEnd();
		this.newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	@Override
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Message) {
			return false;
		}
		if (this.reorientDirection == ReorientRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (this.reorientDirection == ReorientRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean canReorientSource() {
		if (!(this.oldEnd instanceof MessageEnd && this.newEnd instanceof MessageEnd)) {
			return false;
		}
		final MessageEnd target = getLink().getSendEvent();
		if (!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}
		final Interaction container = (Interaction) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistMessage_4(container, getLink(), getNewSource(), target);
	}

	/**
	 * @generated
	 */
	protected boolean canReorientTarget() {
		if (!(this.oldEnd instanceof MessageEnd && this.newEnd instanceof MessageEnd)) {
			return false;
		}
		final MessageEnd source = getLink().getReceiveEvent();
		if (!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}
		final Interaction container = (Interaction) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistMessage_4(container, getLink(), source, getNewTarget());
	}

	/**
	 * @generated
	 */
	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (this.reorientDirection == ReorientRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (this.reorientDirection == ReorientRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		getLink().setReceiveEvent(getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		getLink().setSendEvent(getNewTarget());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated
	 */
	protected Message getLink() {
		return (Message) getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected MessageEnd getOldSource() {
		return (MessageEnd) this.oldEnd;
	}

	/**
	 * @generated
	 */
	protected MessageEnd getNewSource() {
		return (MessageEnd) this.newEnd;
	}

	/**
	 * @generated
	 */
	protected MessageEnd getOldTarget() {
		return (MessageEnd) this.oldEnd;
	}

	/**
	 * @generated
	 */
	protected MessageEnd getNewTarget() {
		return (MessageEnd) this.newEnd;
	}
}
