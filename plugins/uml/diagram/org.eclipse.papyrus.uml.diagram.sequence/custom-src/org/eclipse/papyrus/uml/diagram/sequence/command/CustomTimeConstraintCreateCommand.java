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

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.TimeConstraintCreateCommand;
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
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomTimeConstraintCreateCommand extends TimeConstraintCreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomTimeConstraintCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req, eObject);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomTimeConstraintCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @Override enable only if there is an occurrence specification
	 */
	@Override
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
	 * @Override get the Lifeline parent as owner, assign the occurrence specification
	 */
	@Override
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
}
