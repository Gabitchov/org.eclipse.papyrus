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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.papyrus.uml.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.uml.diagram.sequence.util.CommandHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.OccurrenceSpecificationHelper;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.ExecutionOccurrenceSpecification;
import org.eclipse.uml2.uml.ExecutionSpecification;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.InteractionFragment;
import org.eclipse.uml2.uml.Lifeline;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.OccurrenceSpecification;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class ExecutionOccurrenceSpecificationMessageCreateCommand extends EditElementCommand {

	private EObject source;

	private EObject target;

	/**
	 * Constructor.
	 * 
	 * @param label
	 * @param elementToEdit
	 * @param request
	 */
	public ExecutionOccurrenceSpecificationMessageCreateCommand(CreateRelationshipRequest request) {
		super(request.getLabel(), null, request);
		source = request.getSource();
		target = request.getTarget();
	}

	protected CreateRelationshipRequest getRequest() {
		return (CreateRelationshipRequest)super.getRequest();
	}

	public boolean canExecute() {
		if(source != null && target != null) {
			if(source == target) {
				return false;
			}
		}
		return super.canExecute();
	}

	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = getRequest().getElementType();
		MessageSort messageSort = null;
		if(UMLElementTypes.Message_4003 == elementType) {
			messageSort = MessageSort.SYNCH_CALL_LITERAL;
		} else if(UMLElementTypes.Message_4004 == elementType) {
			messageSort = MessageSort.ASYNCH_CALL_LITERAL;
		} else if(UMLElementTypes.Message_4005 == elementType) {
			messageSort = MessageSort.REPLY_LITERAL;
		} else {
			return CommandResult.newCancelledCommandResult();
		}
		Lifeline sourceLifeline = deduceLifeline(source);
		Lifeline targetLifeline = deduceLifeline(target);
		InteractionFragment sourceContainer = (InteractionFragment)getRequest().getParameters().get(SequenceRequestConstant.SOURCE_MODEL_CONTAINER);
		InteractionFragment targetContainer = (InteractionFragment)getRequest().getParameters().get(SequenceRequestConstant.TARGET_MODEL_CONTAINER);
		Message message = CommandHelper.doCreateMessage(deduceContainer(source, target), messageSort, sourceLifeline, targetLifeline, sourceContainer, targetContainer);
		if(message != null) {
			//Reset the finish of target ExecutionSpecification to message end. See https://bugs.eclipse.org/bugs/show_bug.cgi?id=402975F
			if(source instanceof ExecutionOccurrenceSpecification && ((ExecutionOccurrenceSpecification)source).getExecution() != null) {
				ExecutionSpecification execution = ((ExecutionOccurrenceSpecification)source).getExecution();
				if(source == execution.getStart()) {
					OccurrenceSpecificationHelper.resetExecutionStart(execution, message.getSendEvent());
				} else if(source == execution.getFinish()) {
					OccurrenceSpecificationHelper.resetExecutionFinish(execution, message.getSendEvent());
				}
			}
			if(target instanceof ExecutionOccurrenceSpecification && ((ExecutionOccurrenceSpecification)target).getExecution() != null) {
				ExecutionSpecification execution = ((ExecutionOccurrenceSpecification)target).getExecution();
				if(target == execution.getStart()) {
					OccurrenceSpecificationHelper.resetExecutionStart(execution, message.getReceiveEvent());
				} else if(target == execution.getFinish()) {
					OccurrenceSpecificationHelper.resetExecutionFinish(execution, message.getReceiveEvent());
				}
			}
			doConfigure(message, monitor, info);
			((CreateElementRequest)getRequest()).setNewElement(message);
			return CommandResult.newOKCommandResult(message);
		}
		return CommandResult.newErrorCommandResult("There is now valid container for events"); //$NON-NLS-1$
	}

	protected void doConfigure(Message newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		configureRequest.setParameter(CreateRelationshipRequest.SOURCE, deduceLifeline(source));
		configureRequest.setParameter(CreateRelationshipRequest.TARGET, deduceLifeline(target));
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}

	private Lifeline deduceLifeline(EObject eObject) {
		if(eObject instanceof Lifeline) {
			return (Lifeline)eObject;
		} else if(eObject instanceof ExecutionSpecification) {
			ExecutionSpecification execution = (ExecutionSpecification)eObject;
			if(execution.getStart() != null) {
				return deduceLifeline(execution.getStart());
			} else if(execution.getFinish() != null) {
				return deduceLifeline(execution.getFinish());
			}
		} else if(eObject instanceof OccurrenceSpecification) {
			OccurrenceSpecification occ = (OccurrenceSpecification)eObject;
			return occ.getCovered();
		}
		if(eObject instanceof InteractionFragment) {
			EList<Lifeline> covereds = ((InteractionFragment)eObject).getCovereds();
			if(!covereds.isEmpty()) {
				return covereds.get(0);
			}
		}
		return null;
	}

	protected Interaction deduceContainer(EObject source, EObject target) {
		// Find container element for the new link.
		// Climb up by containment hierarchy starting from the source
		// and return the first element that is instance of the container class.
		for(EObject element = source; element != null; element = element.eContainer()) {
			if(element instanceof Interaction) {
				return (Interaction)element;
			}
		}
		return null;
	}
}
