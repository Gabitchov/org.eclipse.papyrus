/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
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
package org.eclipse.papyrus.diagram.activity.edit.commands;

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
import org.eclipse.papyrus.diagram.activity.providers.ElementInitializers;
import org.eclipse.papyrus.diagram.common.groups.utils.GroupRequestConstants;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.StructuredActivityNode;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.ValueSpecificationAction;

/**
 * @generated
 */
public class ValueSpecificationActionInIARCreateCommand extends EditElementCommand {

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
	public ValueSpecificationActionInIARCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static ValueSpecificationActionInIARCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new ValueSpecificationActionInIARCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public ValueSpecificationActionInIARCreateCommand(CreateElementRequest req) {
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
	 * @generated NOT check that there is a model container.
	 */
	public boolean canExecute() {
		//check that there is a model container.
		return getRequest().getParameter(GroupRequestConstants.MODEL_CONTAINER) != null;
	}

	/**
	 * @generated NOT create in appropriate model container
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {



		ValueSpecificationAction newElement = UMLFactory.eINSTANCE.createValueSpecificationAction();

		// create in appropriate model container
		Object owner = getRequest().getParameter(GroupRequestConstants.MODEL_CONTAINER);
		if(owner instanceof Activity) {
			((Activity)owner).getNodes().add(newElement);
		} else if(owner instanceof StructuredActivityNode) {
			((StructuredActivityNode)owner).getNodes().add(newElement);
		} else {
			return CommandResult.newCancelledCommandResult();
		}
		//		Activity owner = (Activity)getElementToEdit();
		//		owner.getNodes().add(newElement);


		ElementInitializers.getInstance().init_ValueSpecificationAction_3088(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}




	/**
	 * @generated
	 */
	protected void doConfigure(ValueSpecificationAction newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
