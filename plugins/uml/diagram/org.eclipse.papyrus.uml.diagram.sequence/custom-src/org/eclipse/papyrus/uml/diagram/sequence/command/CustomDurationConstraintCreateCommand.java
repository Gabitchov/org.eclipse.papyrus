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
import org.eclipse.papyrus.uml.diagram.sequence.edit.commands.DurationConstraintCreateCommand;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.CombinedFragment;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @author Jin Liu (jin.liu@soyatec.com)
 */
public class CustomDurationConstraintCreateCommand extends DurationConstraintCreateCommand {

	/**
	 * Constructor.
	 * 
	 * @param req
	 * @param eObject
	 */
	public CustomDurationConstraintCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req, eObject);
	}

	/**
	 * Constructor.
	 * 
	 * @param req
	 */
	public CustomDurationConstraintCreateCommand(CreateElementRequest req) {
		super(req);
	}

	/**
	 * @Override enable only if there is occurrence specifications
	 */
	@Override
	public boolean canExecute() {
		/*
		 * // check first occurrence specification
		 * if(!getRequest().getParameters().containsKey(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION)) {
		 * return true; // duration creation is in progress; source is not defined yet
		 * }
		 * Object paramOccurrence1 = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
		 * List<OccurrenceSpecification> occ1List = SequenceUtil.getAsOccSpecList(paramOccurrence1);
		 * if(occ1List.isEmpty()) {
		 * return false;
		 * }
		 * // check second occurrence specification
		 * if(!getRequest().getParameters().containsKey(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2)) {
		 * return true; // duration creation is in progress; target is not defined yet
		 * }
		 * Object paramOccurrence2 = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2);
		 * List<OccurrenceSpecification> occ2List = SequenceUtil.getAsOccSpecList(paramOccurrence2);
		 * if(occ2List.isEmpty()) {
		 * return false;
		 * }
		 * // disable duration constraint on a same event
		 * if(!Collections.disjoint(occ1List, occ2List)) {
		 * return false;
		 * }
		 * // enable duration constraint only on a same lifeline or on message
		 * OccurrenceSpecification[] pair = SequenceUtil.getPairOfCorrespondingOccSpec(occ1List, occ2List);
		 * if(pair != null && pair.length > 1) {
		 * boolean enabled = DurationConstraintHelper.coversSameLifeline(pair[0], pair[1]);
		 * // handle creation on message
		 * enabled |= DurationConstraintHelper.endsOfSameMessage(pair[0], pair[1]);
		 * return enabled;
		 * }
		 * return false;
		 */
		return true;
	}

	/**
	 * @Override get the Lifeline parent as owner, assign the occurrence specifications
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		DurationConstraint newElement = UMLFactory.eINSTANCE.createDurationConstraint();
		// get the Lifeline parent as owner
		Namespace owner = getNamespace(getElementToEdit().eContainer());
		owner.getOwnedRules().add(newElement);
		ElementInitializers.getInstance().init_DurationConstraint_3021(newElement);
		// assign the occurrence specification
		Object paramOccurrence1 = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
		List<OccurrenceSpecification> occ1List = SequenceUtil.getAsOccSpecList(paramOccurrence1);
		Object paramOccurrence2 = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2);
		List<OccurrenceSpecification> occ2List = SequenceUtil.getAsOccSpecList(paramOccurrence2);
		OccurrenceSpecification[] pair = SequenceUtil.getPairOfCorrespondingOccSpec(occ1List, occ2List);
		if(pair != null && pair.length > 1) {
			newElement.getConstrainedElements().add(pair[0]);
			newElement.getConstrainedElements().add(pair[1]);
		}
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	protected Namespace getNamespace(EObject element) {
		if(element instanceof Namespace) {
			return (Namespace)element;
		}
		if(element instanceof CombinedFragment) {
			return ((CombinedFragment)element).getNamespace();
		}
		return null;
	}
}
