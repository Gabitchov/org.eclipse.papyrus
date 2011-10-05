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
 *  Saadia Dhouib saadia.dhouib@cea.fr  - Adapted from Composite Structure Diagram
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.diagram.communication.custom.helper.ReconnectMessageHelper;
import org.eclipse.papyrus.diagram.communication.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.diagram.communication.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;


// TODO: Auto-generated Javadoc
/**
 * The Class CustomMessageReorientCommand permits to reorient a UML message.
 */
public class CustomMessageReorientCommand extends MessageReorientCommand {

	/** the new end. */
	protected EObject newEnd;

	/** the old end. */
	protected EObject oldEnd;

	/** the end to reconnect. */
	protected int reorientDirection;


	/** The anchor id. */
	protected String anchorId;


	/**
	 * Constructor.
	 * 
	 * @param req
	 *        the req
	 */
	public CustomMessageReorientCommand(ReorientRelationshipRequest req) {
		super(req);
		this.reorientDirection = req.getDirection();
		this.oldEnd = req.getOldRelationshipEnd();
		this.newEnd = req.getNewRelationshipEnd();
	}

	/**
	 * @see org.eclipse.papyrus.diagram.communication.edit.commands.MessageReorientCommand#canReorientSource()
	 * 
	 * @return
	 */

	@Override
	protected boolean canReorientSource() {
		if(!(oldEnd instanceof Element && newEnd instanceof Element)) {
			return false;
		}
		if(!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}
		Interaction container = (Interaction)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistMessage_8009(container, getLink(), getNewSource(), getOldTarget());
	}

	/**
	 * @see org.eclipse.papyrus.diagram.communication.edit.commands.MessageReorientCommand#canReorientTarget()
	 * 
	 * @return
	 */

	@Override
	protected boolean canReorientTarget() {
		if(!(oldEnd instanceof Element && newEnd instanceof Element)) {
			return false;
		}

		if(!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}
		Interaction container = (Interaction)getLink().eContainer();
		return UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistMessage_8009(container, getLink(), getOldSource(), getNewTarget());
	}

	/**
	 * @see org.eclipse.papyrus.diagram.communication.edit.commands.MessageReorientCommand#reorientSource()
	 * 
	 * @return
	 * @throws ExecutionException
	 */

	@Override
	protected CommandResult reorientSource() throws ExecutionException {
		//System.out.println("ReorientSource");
		ReconnectMessageHelper.updateMessageEnd(getLink().getSendEvent(), getOldSource(), getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @see org.eclipse.papyrus.diagram.communication.edit.commands.MessageReorientCommand#reorientTarget()
	 * 
	 * @return
	 * @throws ExecutionException
	 */

	@Override
	protected CommandResult reorientTarget() throws ExecutionException {
		//System.out.println("ReorientTarget");
		ReconnectMessageHelper.updateMessageEnd(getLink().getReceiveEvent(), getOldTarget(), getNewTarget());
		ReconnectMessageHelper.updateMessage(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}

}
