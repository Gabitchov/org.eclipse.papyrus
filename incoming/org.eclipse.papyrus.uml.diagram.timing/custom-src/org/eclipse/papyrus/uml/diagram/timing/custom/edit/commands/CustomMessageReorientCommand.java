/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.common.util.DiagramEditPartsUtil;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.DropUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.MessageUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.OccurrenceSpecificationUtils;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ViewUtils;
import org.eclipse.papyrus.uml.diagram.timing.edit.parts.InteractionEditPartTN;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageKind;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;

public class CustomMessageReorientCommand extends EditElementCommand {

	private final int reorientDirection;

	private final EObject newEnd;

	private final EditPartViewer viewer;

	public CustomMessageReorientCommand(final ReorientRelationshipRequest request, final EditPartViewer viewer) {
		super(request.getLabel(), request.getRelationship(), request);
		this.viewer = viewer;
		this.reorientDirection = request.getDirection();
		this.newEnd = request.getNewRelationshipEnd();
	}

	@Override
	public boolean canExecute() {
		if(!(getElementToEdit() instanceof Message)) {
			return false;
		}
		final Message message = (Message)getElementToEdit();

		final EObject source;
		final EObject target;
		if(this.reorientDirection == ReorientRequest.REORIENT_SOURCE) {
			source = this.newEnd;
			target = message.getReceiveEvent();
		} else {
			source = message.getSendEvent();
			target = this.newEnd;
		}
		final MessageSort messageSort = message.getMessageSort();
		final MessageKind messageKind = message.getMessageKind();
		return MessageUtils.isValidMessage(messageSort, messageKind, source, target);
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		if(!canExecute()) {
			throw new ExecutionException("Invalid arguments in reorient link command"); //$NON-NLS-1$
		}

		final boolean reorientSource = this.reorientDirection == ReorientRequest.REORIENT_SOURCE;
		final boolean reorientTarget = this.reorientDirection == ReorientRequest.REORIENT_TARGET;

		final Message message = (Message)getElementToEdit();
		final boolean destruction = reorientTarget && message.getMessageSort() == MessageSort.DELETE_MESSAGE_LITERAL;
		final boolean creation = reorientTarget && message.getMessageSort() == MessageSort.CREATE_MESSAGE_LITERAL;

		final MessageEnd newMessageEnd = MessageUtils.convertToMessageOccurrenceSpecification(this.newEnd, destruction);
		if(reorientSource) {
			message.setSendEvent(newMessageEnd);
		} else if(reorientTarget) {
			message.setReceiveEvent(newMessageEnd);
		}

		if(destruction || creation) {
			// save the parent View while the message is still in it
			final Set<View> parentInteractionViews = findParentInteractionViews(newMessageEnd);
			// destroying the old target of the message will also delete the Message View
			if(destruction) {
				OccurrenceSpecificationUtils.deleteEverythingAfter((OccurrenceSpecification)newMessageEnd, null);
			}
			if(creation) {
				OccurrenceSpecificationUtils.deleteEverythingBefore((OccurrenceSpecification)newMessageEnd, null);
			}
			// re-create the Message View that was deleted by GMF
			for(final View parentInteractionView : parentInteractionViews) {
				DropUtils.getDropMessageCommand(message, parentInteractionView, this.viewer).execute(new NullProgressMonitor(), null);
			}
		}

		return CommandResult.newOKCommandResult(message);
	}

	private Set<View> findParentInteractionViews(final EObject eObject) {
		final List<View> views = DiagramEditPartsUtil.findViews(eObject, this.viewer);
		final Set<View> interactionViews = new HashSet<View>();
		for(final View view : views) {
			final View interactionView = ViewUtils.findSuperViewWithId(view, InteractionEditPartTN.VISUAL_ID);
			if(interactionView != null) {
				interactionViews.add(interactionView);
			}
		}
		return interactionViews;
	}
}
