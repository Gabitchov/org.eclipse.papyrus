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
package org.eclipse.papyrus.diagram.sequence.edit.commands;

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
import org.eclipse.papyrus.diagram.common.helper.DurationConstraintHelper;
import org.eclipse.papyrus.diagram.sequence.providers.UMLElementTypes;
import org.eclipse.papyrus.diagram.sequence.util.SequenceRequestConstant;
import org.eclipse.uml2.uml.DurationObservation;
import org.eclipse.uml2.uml.OccurrenceSpecification;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class DurationObservationCreateCommand extends EditElementCommand {

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
	public DurationObservationCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static DurationObservationCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new DurationObservationCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public DurationObservationCreateCommand(CreateElementRequest req) {
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
		Object occurrence = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
		if(!(occurrence instanceof OccurrenceSpecification)) {
			return false;
		}
		// check second occurrence specification
		if(!getRequest().getParameters().containsKey(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2)) {
			return true; // duration creation is in progress; target is not defined yet
		}
		Object occurrence2 = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2);
		if(!(occurrence2 instanceof OccurrenceSpecification)) {
			return false;
		}
		// disable duration observation on a same event
		if(occurrence.equals(occurrence2)) {
			return false;
		}
		// enable duration observation only on a message
		return DurationConstraintHelper.endsOfSameMessage((OccurrenceSpecification)occurrence, (OccurrenceSpecification)occurrence2);
	}

	/**
	 * @generated NOT get the parent package as owner, assign the occurrence specifications
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {



		DurationObservation newElement = UMLFactory.eINSTANCE.createDurationObservation();

		// get the parent package as owner
		EObject container = getElementToEdit();
		while(container != null && !(container instanceof Package)) {
			container = container.eContainer();
		}
		if(container == null) {
			return CommandResult.newCancelledCommandResult();
		}
		Package owner = (Package)container;
		owner.getPackagedElements().add(newElement);


		UMLElementTypes.init_DurationObservation_3024(newElement);

		// assign the occurrence specification
		Object occurrence1 = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION);
		Object occurrence2 = getRequest().getParameter(SequenceRequestConstant.NEAREST_OCCURRENCE_SPECIFICATION_2);
		if(occurrence1 instanceof OccurrenceSpecification) {
			newElement.getEvents().add((OccurrenceSpecification)occurrence1);
			if(occurrence2 instanceof OccurrenceSpecification) {
				newElement.getEvents().add((OccurrenceSpecification)occurrence2);
			}
		}

		doConfigure(newElement, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}




	/**
	 * @generated
	 */
	protected void doConfigure(DurationObservation newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
