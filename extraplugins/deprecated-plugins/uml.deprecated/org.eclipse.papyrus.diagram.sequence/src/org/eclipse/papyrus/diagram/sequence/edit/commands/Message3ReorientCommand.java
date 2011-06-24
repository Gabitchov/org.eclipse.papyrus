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
package org.eclipse.papyrus.diagram.sequence.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.uml2.uml.BehaviorExecutionSpecification;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

import org.eclipse.papyrus.diagram.common.ids.ReorientLinkIDs;
import org.eclipse.papyrus.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.diagram.sequence.util.MessageCommonUtil;

/**
 * @generated
 */
public class Message3ReorientCommand extends EditElementCommand {

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
	private View node;

	/**
	 * @generated
	 */
	private View link;

	/**
	 * @generated
	 */
	public Message3ReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();

		if (request.getParameter(ReorientLinkIDs.nodeEditPart) != null) {
			node = (View) request.getParameter(ReorientLinkIDs.nodeEditPart);
		}
		if (request.getParameter(ReorientLinkIDs.linkEditPart) != null) {
			link = (View) request.getParameter(ReorientLinkIDs.linkEditPart);
		}
	}

	/**
	 * @generated
	 */
	@Override
	public boolean canExecute() {
		if (false == getElementToEdit() instanceof Message) {
			return false;
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientSource() {
		if (!(oldEnd instanceof Element && newEnd instanceof Element)) {
			return false;
		}
		//		if (getLink().getOwnedElements().size() != 1) {
		//			return false;
		//		}
		//		Element target = (Element) getLink().getOwnedElements().get(0);
		if (!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}

		// Added code
		if (!(getLink().getReceiveEvent() instanceof MessageOccurrenceSpecification)) {
			return false;
		}
		MessageOccurrenceSpecification mosTarget = (MessageOccurrenceSpecification) getLink()
				.getReceiveEvent();

		// Get target element
		Element target = MessageCommonUtil.getMessageDst(getLink());

		// End added code

		Interaction container = (Interaction) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canExistMessage_3003(container, getNewSource(), target);
	}

	/**
	 * @generated NOT
	 */
	protected boolean canReorientTarget() {
		if (!(oldEnd instanceof Element && newEnd instanceof Element)) {
			return false;
		}
		//		Element source = getLink().getOwner();
		if (!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}

		// Added code
		if (!(getLink().getSendEvent() instanceof MessageOccurrenceSpecification)) {
			return false;
		}
		MessageOccurrenceSpecification mosSource = (MessageOccurrenceSpecification) getLink()
				.getSendEvent();

		// Get source element
		Element source = MessageCommonUtil.getMessageSrc(getLink());

		// End added code

		Interaction container = (Interaction) getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.LinkConstraints
				.canExistMessage_3003(container, source, getNewTarget());
	}

	/**
	 * @generated
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		if (!canExecute()) {
			throw new ExecutionException(
					"Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if (reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		//		getLink().setOwner(getNewSource());

		// Added code
		if (getLink().getSendEvent() instanceof MessageOccurrenceSpecification) {
			MessageOccurrenceSpecification mosSource = (MessageOccurrenceSpecification) getLink()
					.getSendEvent();

			mosSource.getCovereds().clear();

			if (getNewSource() instanceof Lifeline) {
				mosSource.getCovereds().add((Lifeline) getNewSource());
			} else if (getNewSource() instanceof BehaviorExecutionSpecification) {
				BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) getNewSource();
				mosSource.getCovereds().add(bes.getCovereds().get(0));
			}
		}
		// End added code		

		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @generated NOT
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		//		getLink().getOwnedElements().remove(getOldTarget());
		//		getLink().getOwnedElements().add(getNewTarget());

		// Added code
		if (getLink().getReceiveEvent() instanceof MessageOccurrenceSpecification) {
			MessageOccurrenceSpecification mosTarget = (MessageOccurrenceSpecification) getLink()
					.getReceiveEvent();

			mosTarget.getCovereds().clear();

			if (getNewTarget() instanceof Lifeline) {
				mosTarget.getCovereds().add((Lifeline) getNewTarget());
			} else if (getNewTarget() instanceof BehaviorExecutionSpecification) {
				BehaviorExecutionSpecification bes = (BehaviorExecutionSpecification) getNewSource();
				mosTarget.getCovereds().add(bes.getCovereds().get(0));
			}
		}
		// End added code

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
	protected Element getOldSource() {
		return (Element) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Element getNewSource() {
		return (Element) newEnd;
	}

	/**
	 * @generated
	 */
	protected Element getOldTarget() {
		return (Element) oldEnd;
	}

	/**
	 * @generated
	 */
	protected Element getNewTarget() {
		return (Element) newEnd;
	}
}
