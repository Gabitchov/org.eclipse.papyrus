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

import java.util.Collections;
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
import org.eclipse.papyrus.uml.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.uml.diagram.sequence.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.papyrus.uml.diagram.sequence.util.SequenceUtil;
import org.eclipse.uml2.uml.DurationConstraint;
import org.eclipse.uml2.uml.Namespace;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class DurationConstraintCreateCommand extends EditElementCommand {

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
	public DurationConstraintCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static DurationConstraintCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new DurationConstraintCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public DurationConstraintCreateCommand(CreateElementRequest req) {
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
	 * @generated NOT enable only if there is occurrence specifications
	 */
	public boolean canExecute() {
		// check first occurrence specification
		if(!getRequest().getParameters().containsKey(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION)) {
			return true; // duration creation is in progress; source is not defined yet
		}
		Object paramOccurrence1 = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
		List<OccurrenceSpecification> occ1List = SequenceUtil.getAsOccSpecList(paramOccurrence1);
		if(occ1List.isEmpty()) {
			return false;
		}
		// check second occurrence specification
		if(!getRequest().getParameters().containsKey(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2)) {
			return true; // duration creation is in progress; target is not defined yet
		}
		Object paramOccurrence2 = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2);
		List<OccurrenceSpecification> occ2List = SequenceUtil.getAsOccSpecList(paramOccurrence2);
		if(occ2List.isEmpty()) {
			return false;
		}
		// disable duration constraint on a same event
		if(!Collections.disjoint(occ1List, occ2List)) {
			return false;
		}
		// enable duration constraint only on a same lifeline or on message
		OccurrenceSpecification[] pair = SequenceUtil.getPairOfCorrespondingOccSpec(occ1List, occ2List);
		if(pair != null && pair.length > 1) {
			boolean enabled = DurationConstraintHelper.coversSameLifeline(pair[0], pair[1]);
			// handle creation on message
			enabled |= DurationConstraintHelper.endsOfSameMessage(pair[0], pair[1]);
			return enabled;
		}
		return false;
	}

	/**
	 * @generated NOT get the Lifeline parent as owner, assign the occurrence specifications
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		DurationConstraint newElement = UMLFactory.eINSTANCE.createDurationConstraint();
		// get the Lifeline parent as owner
		Namespace owner = (Namespace)getElementToEdit().eContainer();
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

	/**
	 * @generated
	 */
	protected void doConfigure(DurationConstraint newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
