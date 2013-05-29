/*****************************************************************************
 * Copyright (c) 2013 CEA
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
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ReorientRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.ReconnectMessageHelper;
import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageEnd;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class ExecutionOccurrenceSpecificationMessageReorientCommand extends EditElementCommand {

	private final EObject oldEnd;

	private final EObject newEnd;

	/**
	 * Constructor.
	 * 
	 * @param label
	 * @param elementToEdit
	 * @param request
	 */
	public ExecutionOccurrenceSpecificationMessageReorientCommand(ReorientRelationshipRequest request) {
		super(request.getLabel(), request.getRelationship(), request);
		oldEnd = request.getOldRelationshipEnd();
		newEnd = request.getNewRelationshipEnd();
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand#canExecute()
	 * 
	 * @return
	 */
	@Override
	public boolean canExecute() {
		Message link = getLink();
		if(link == null) {
			return false;
		}
		MessageSort messageSort = link.getMessageSort();
		return MessageSort.SYNCH_CALL_LITERAL == messageSort || MessageSort.ASYNCH_CALL_LITERAL == messageSort || MessageSort.REPLY_LITERAL == messageSort;
	}

	protected Message getLink() {
		return (Message)getRequest().getRelationship();
	}

	@Override
	protected ReorientRelationshipRequest getRequest() {
		return (ReorientRelationshipRequest)super.getRequest();
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		int direction = getRequest().getDirection();
		if(ReorientRelationshipRequest.REORIENT_SOURCE == direction) {
			return reorientSource();
		} else if(ReorientRelationshipRequest.REORIENT_TARGET == direction) {
			return reorientTarget();
		}
		throw new IllegalStateException();
	}

	protected Element getOldSource() {
		return (Element)oldEnd;
	}

	protected Element getNewSource() {
		return (Element)newEnd;
	}

	protected Element getOldTarget() {
		return (Element)oldEnd;
	}

	protected Element getNewTarget() {
		return (Element)newEnd;
	}

	protected ExecutionSpecification getExecution(Element element, boolean isSource) {
		if(element instanceof ExecutionSpecification) {
			return (ExecutionSpecification)element;
		} else if(element instanceof OccurrenceSpecification) {
			return OccurrenceSpecificationHelper.findExecutionWith((OccurrenceSpecification)element, isSource);
		}
		return null;
	}

	protected CommandResult reorientTarget() {
		ExecutionSpecification oldExecution = getExecution(getOldTarget(), false);
		ExecutionSpecification newExecution = getExecution(getNewTarget(), false);
		MessageEnd receiveEvent = getLink().getReceiveEvent();
		ReconnectMessageHelper.updateMessageEnd(receiveEvent, oldExecution, newExecution);
		ReconnectMessageHelper.updateMessage(getLink());
		if(oldExecution != null && receiveEvent != null) {
			if(receiveEvent == oldExecution.getStart()) {
				OccurrenceSpecificationHelper.resetExecutionStart(oldExecution, UMLFactory.eINSTANCE.createExecutionOccurrenceSpecification());
			} else if(receiveEvent == oldExecution.getFinish()) {
				OccurrenceSpecificationHelper.resetExecutionFinish(oldExecution, UMLFactory.eINSTANCE.createExecutionOccurrenceSpecification());
			}
		}
		if(newExecution != null && receiveEvent instanceof MessageOccurrenceSpecification) {
			if(getNewTarget() == newExecution.getStart()) {
				OccurrenceSpecificationHelper.resetExecutionStart(newExecution, receiveEvent);
			} else if(getNewTarget() == newExecution.getFinish()) {
				OccurrenceSpecificationHelper.resetExecutionFinish(newExecution, receiveEvent);
			}
		}
		return CommandResult.newOKCommandResult(getLink());
	}

	protected CommandResult reorientSource() {
		ExecutionSpecification oldExecution = getExecution(getOldTarget(), false);
		ExecutionSpecification newExecution = getExecution(getNewTarget(), false);
		MessageEnd sendEvent = getLink().getSendEvent();
		ReconnectMessageHelper.updateMessageEnd(sendEvent, oldExecution, newExecution);
		if(oldExecution != null && sendEvent instanceof MessageOccurrenceSpecification) {
			if(sendEvent == oldExecution.getStart()) {
				OccurrenceSpecificationHelper.resetExecutionStart(oldExecution, UMLFactory.eINSTANCE.createExecutionOccurrenceSpecification());
			} else if(sendEvent == oldExecution.getFinish()) {
				OccurrenceSpecificationHelper.resetExecutionFinish(oldExecution, UMLFactory.eINSTANCE.createExecutionOccurrenceSpecification());
			}
		}
		if(newExecution != null && sendEvent instanceof MessageOccurrenceSpecification) {
			if(getNewTarget() == newExecution.getStart()) {
				OccurrenceSpecificationHelper.resetExecutionStart(newExecution, sendEvent);
			} else if(getNewTarget() == newExecution.getFinish()) {
				OccurrenceSpecificationHelper.resetExecutionFinish(newExecution, sendEvent);
			}
		}
		return CommandResult.newOKCommandResult(getLink());
	}
}
