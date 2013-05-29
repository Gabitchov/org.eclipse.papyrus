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
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.MessageReorientCommand;
import org.eclipse.papyrus.uml.diagram.sequence.edit.policies.UMLBaseItemSemanticEditPolicy;
import org.eclipse.papyrus.uml.diagram.sequence.util.MessageConnectionHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.ReconnectMessageHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomMessageReorientCommand extends MessageReorientCommand {

	/**
	 * Constructor.
	 * 
	 * @param request
	 */
	public CustomMessageReorientCommand(ReorientRelationshipRequest request) {
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
		boolean canExistMessage = UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistMessage_4003(container, getLink(), getNewSource(), getOldTarget());
		if(!canExistMessage) {
			return false;
		}
		//Fixed bug about reconnect messages.
		if(!(getNewSource() instanceof ExecutionSpecification)) {
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
		if(!UMLBaseItemSemanticEditPolicy.getLinkConstraints().canExistMessage_4003(container, getLink(), source, getNewTarget())) {
			return false;
		}
		//Fixed bug about reconnect messages.
		if(!(getNewTarget() instanceof ExecutionSpecification)) {
			return false;
		}
		return MessageConnectionHelper.canReorientTarget(getLink(), getNewTarget());
	}

	/**
	 * @Override
	 */
	@Override
	protected CommandResult reorientSource() throws ExecutionException {
		MessageEnd sendEvent = getLink().getSendEvent();
		ReconnectMessageHelper.updateMessageEnd(sendEvent, getOldSource(), getNewSource());
		//Update Execution Ends after message reconnecte, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=402975
		if(getOldSource() instanceof ExecutionSpecification && sendEvent == (((ExecutionSpecification)getOldSource()).getStart())) {
			OccurrenceSpecificationHelper.resetExecutionStart((ExecutionSpecification)getOldSource(), UMLFactory.eINSTANCE.createExecutionOccurrenceSpecification());
		}
		return CommandResult.newOKCommandResult(getLink());
	}

	/**
	 * @Override
	 */
	@Override
	protected CommandResult reorientTarget() throws ExecutionException {
		MessageEnd receiveEvent = getLink().getReceiveEvent();
		ReconnectMessageHelper.updateMessageEnd(receiveEvent, getOldTarget(), getNewTarget());
		ReconnectMessageHelper.updateMessage(getLink());
		//Update Execution Ends after message reconnecte, see https://bugs.eclipse.org/bugs/show_bug.cgi?id=402975
		if(getOldTarget() instanceof ExecutionSpecification && receiveEvent == (((ExecutionSpecification)getOldTarget()).getStart())) {
			OccurrenceSpecificationHelper.resetExecutionStart((ExecutionSpecification)getOldTarget(), UMLFactory.eINSTANCE.createExecutionOccurrenceSpecification());
		}
		if(getNewTarget() instanceof ExecutionSpecification && receiveEvent instanceof MessageOccurrenceSpecification) {
			OccurrenceSpecificationHelper.resetExecutionStart((ExecutionSpecification)getNewTarget(), receiveEvent);
		}
		return CommandResult.newOKCommandResult(getLink());
	}
}
