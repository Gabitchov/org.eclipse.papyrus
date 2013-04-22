/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Soyatec - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.Message5ReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.MessageConnectionHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.ReconnectMessageHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.Interaction;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessage5ReorientCommand extends Message5ReorientCommand {

	/**
	 * Constructor.
	 * 
	 * @param request
	 */
	public CustomMessage5ReorientCommand(ReorientRelationshipRequest request) {
		super(request);
	}

	/**
	 * @Override
	 */
	@Override
	protected boolean canReorientSource() {
		if(!(getOldSource() instanceof Element && getNewSource() instanceof Element)) {
			return false;
		}
		if(!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}
		Interaction container = (Interaction)getLink().eContainer();
		if(!UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistMessage_4007(container, getLink(), getNewSource(), getOldTarget())) {
			return false;
		}
		return MessageConnectionHelper.canReorientSource(getLink(), getNewSource());
	}

	/**
	 * @Override
	 */
	@Override
	protected boolean canReorientTarget() {
		if(!(getOldTarget() instanceof Element && getNewTarget() instanceof Element)) {
			return false;
		}
		Element source = getLink().getOwner();
		if(!(getLink().eContainer() instanceof Interaction)) {
			return false;
		}
		Interaction container = (Interaction)getLink().eContainer();
		if(!UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistMessage_4007(container, getLink(), source, getNewTarget())) {
			return false;
		}
		return MessageConnectionHelper.canReorientTarget(getLink(), getNewTarget());
	}

	/**
	 * @Override
	 */
	@Override
	protected CommandResult reorientSource() throws ExecutionException {
		ReconnectMessageHelper.updateMessageEnd(getLink().getSendEvent(), getOldSource(), getNewSource());
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @Override
	 */
	@Override
	protected CommandResult reorientTarget() throws ExecutionException {
		ReconnectMessageHelper.updateMessageEnd(getLink().getReceiveEvent(), getOldTarget(), getNewTarget());
		ReconnectMessageHelper.updateMessage(getLink());
		return CommandResult.newOKCommandResult(getLink());
	}
}
