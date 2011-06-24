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
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.service.types.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Gate;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;

/**
 * <pre>
 * This re-orient command is adapted from re-orient command generated
 * for {@link Message} in the Communication Diagram.
 * </pre>
 * 
 * @generated
 */
public abstract class MessageAbstractReorientCommand extends EditElementCommand {

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
	public MessageAbstractReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		reorientDirection = request.getDirection();
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @generated
	 */
	public boolean canExecute() {
		if(false == getElementToEdit() instanceof Message) {
			return false;
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return canReorientSource();
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return canReorientTarget();
		}
		return false;
	}

	/**
	 * <pre>
	 * This method test if the Message can be re-oriented to a new source.
	 * It is assumed here that the possible (graphical) element used as Message source
	 * is either a {@link Lifeline} or an {@link InteractionFragment}.
	 * It is also assumed that a re-orient that would require the {@link MessageEnd} to be 
	 * converted from {@link Gate} to {@link MessageOccurrenceSpecification} (or the contrary)
	 * is not allowed.
	 * </pre>
	 * 
	 * @return true if the link end can be re-oriented to a new source
	 */
	protected boolean canReorientSource() {
		// Verify possible type of new source
		if(!((getNewSource() instanceof InteractionFragment) || (getNewSource() instanceof Lifeline))) {
			return false;
		}

		// Avoid re-orient from Gate to MOS source (not currently supported)
		if(getLink().getSendEvent() instanceof Gate) {
			if((getNewSource() instanceof Lifeline) || (getNewSource() instanceof ExecutionSpecification)) {
				return false;
			}
		}
		// Avoid re-orient from MOS to Gate source (not currently supported)
		if(getLink().getSendEvent() instanceof MessageOccurrenceSpecification) {
			if(!(getNewSource() instanceof Lifeline) && !(getNewSource() instanceof ExecutionSpecification)) {
				return false;
			}
		}

		// Ensure the message owner is an interaction
		if(!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}

		return true;
	}

	/**
	 * <pre>
	 * This method test if the Message can be re-oriented to a new target.
	 * It is assumed here that the possible (graphical) element used as Message target
	 * is either a {@link Lifeline} or an {@link InteractionFragment}.
	 * It is also assumed that a re-orient that would require the {@link MessageEnd} to be 
	 * converted from {@link Gate} to {@link MessageOccurrenceSpecification} (or the contrary)
	 * is not allowed.
	 * </pre>
	 * 
	 * @return true if the link end can be re-oriented to a new target
	 */
	protected boolean canReorientTarget() {

		// Verify possible type of new target
		if(!((getNewTarget() instanceof InteractionFragment) || (getNewTarget() instanceof Lifeline))) {
			return false;
		}

		// Avoid re-orient from Gate to MOS target (not currently supported)
		if(getLink().getReceiveEvent() instanceof Gate) {
			if((getNewTarget() instanceof Lifeline) || (getNewTarget() instanceof ExecutionSpecification)) {
				return false;
			}
		}
		// Avoid re-orient from MOS to Gate target (not currently supported)
		if(getLink().getReceiveEvent() instanceof MessageOccurrenceSpecification) {
			if(!(getNewTarget() instanceof Lifeline) && !(getNewTarget() instanceof ExecutionSpecification)) {
				return false;
			}
		}

		// Ensure the message owner is an interaction
		if(!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}

		return true;
	}

	/**
	 * @generated
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_SOURCE) {
			return reorientSource();
		}
		if(reorientDirection == ReorientRelationshipRequest.REORIENT_TARGET) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientSource() throws ExecutionException {
		// Nothing to do here on the message itself, the message end (MessageOccurenceSpecification) remains
		// the same but its covered element may change (other Lifeline or ExecutionSpecification)
		return CommandResult.newOKCommandResult();
	}

	/**
	 * @generated
	 */
	protected CommandResult reorientTarget() throws ExecutionException {
		// Nothing to do here on the message itself, the message end (MessageOccurenceSpecification) remains
		// the same but its covered element may change (other Lifeline or ExecutionSpecification)
		return CommandResult.newOKCommandResult();
	}

	/**
	 * @generated
	 */
	protected Message getLink() {
		return (Message)getElementToEdit();
	}

	/**
	 * @generated
	 */
	protected Element getOldSource() {
		return (Element)oldEnd;
	}

	/**
	 * @generated
	 */
	protected Element getNewSource() {
		return (Element)newEnd;
	}

	/**
	 * @generated
	 */
	protected Element getOldTarget() {
		return (Element)oldEnd;
	}

	/**
	 * @generated
	 */
	protected Element getNewTarget() {
		return (Element)newEnd;
	}
}
