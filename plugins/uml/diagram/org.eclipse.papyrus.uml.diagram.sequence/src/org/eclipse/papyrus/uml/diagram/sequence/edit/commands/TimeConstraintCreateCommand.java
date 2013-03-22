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
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.edit.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.commands.EditElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.Message;
import org.eclipse.uml2.uml.MessageOccurrenceSpecification;
import org.eclipse.uml2.uml.MessageSort;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.TimeConstraint;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class TimeConstraintCreateCommand extends EditElementCommand {

	/**
	 * @generated
	 */
	private EClass eClass = null;

	/**
	 * @generated
	 */
	private EObject eObject = null;

	/**
	 * @generated
	 */
	public TimeConstraintCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static TimeConstraintCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new TimeConstraintCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public TimeConstraintCreateCommand(CreateElementRequest req) {
		super(req.getLabel(), null, req);
	}

	/**
	 * FIXME: replace with setElementToEdit()
	 * 
	 * @generated
	 */
	protected EObject getElementToEdit() {
		EObject container = ((CreateElementRequest)getRequest()).getContainer();
		if(container instanceof View) {
			container = ((View)container).getElement();
		}
		if(container != null) {
			return container;
		}
		return eObject;
	}

	/**
	 * @generated NOT enable only if there is an occurrence specification
	 */
	public boolean canExecute() {
		Object paramOccurrence = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
		List<OccurrenceSpecification> occList = SequenceUtil.getAsOccSpecList(paramOccurrence);
		if(!occList.isEmpty()) {
			for(OccurrenceSpecification occurrence : occList) {
				if(occurrence instanceof MessageOccurrenceSpecification) {
					Message mess = ((MessageOccurrenceSpecification)occurrence).getMessage();
					if(mess != null && occurrence.equals(mess.getReceiveEvent()) && MessageSort.SYNCH_CALL_LITERAL.equals(mess.getMessageSort())) {
						// filter receive event, we prefer the corresponding start event at the same location
						continue;
					}
				}
				return true;
			}
		}
		return false;
	}

	/**
	 * @generated NOT get the Lifeline parent as owner, assign the occurrence specification
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		TimeConstraint newElement = UMLFactory.eINSTANCE.createTimeConstraint();
		// get the Lifeline parent as owner
		Namespace owner = (Namespace)getElementToEdit().eContainer();
		owner.getOwnedRules().add(newElement);
		ElementInitializers.getInstance().init_TimeConstraint_3019(newElement);
		// assign the occurrence specification
		Object paramOccurrence = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
		List<OccurrenceSpecification> occList = SequenceUtil.getAsOccSpecList(paramOccurrence);
		if(!occList.isEmpty()) {
			for(OccurrenceSpecification occurrence : occList) {
				if(occurrence instanceof MessageOccurrenceSpecification) {
					Message mess = ((MessageOccurrenceSpecification)occurrence).getMessage();
					if(mess != null && occurrence.equals(mess.getReceiveEvent()) && MessageSort.SYNCH_CALL_LITERAL.equals(mess.getMessageSort())) {
						// filter receive event, we prefer the corresponding start event at the same location
						continue;
					}
				}
				// otherwise, first occ is just fine
				newElement.getConstrainedElements().add(occurrence);
				break;
			}
		}
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(TimeConstraint newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IElementType elementType = ((CreateElementRequest)getRequest()).getElementType();
		ConfigureRequest configureRequest = new ConfigureRequest(getEditingDomain(), newElement, elementType);
		configureRequest.setClientContext(((CreateElementRequest)getRequest()).getClientContext());
		configureRequest.addParameters(getRequest().getParameters());
		ICommand configureCommand = elementType.getEditCommand(configureRequest);
		if(configureCommand != null && configureCommand.canExecute()) {
			configureCommand.execute(monitor, info);
		}
	}
}
