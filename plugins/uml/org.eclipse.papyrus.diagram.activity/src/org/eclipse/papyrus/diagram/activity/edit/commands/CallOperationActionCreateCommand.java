/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.diagram.activity.edit.commands.util.CreateCommandUtil;
import org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateCallOperationActionDialog;
import org.eclipse.papyrus.diagram.activity.providers.ElementInitializers;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.CallOperationAction;
import org.eclipse.uml2.uml.Operation;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class CallOperationActionCreateCommand extends EditElementCommand {

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
	public CallOperationActionCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static CallOperationActionCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new CallOperationActionCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public CallOperationActionCreateCommand(CreateElementRequest req) {
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
	 * @generated NOT check that there is a correct model container.
	 */
	public boolean canExecute() {
		//check that there is a correct model container
		return CreateCommandUtil.canCreateNode(getRequest(), getElementToEdit());
	}

	/**
	 * @generated NOT use the initialization popup, set appropriate parents
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		// get the activity containing the new element
		Activity parentActivity = null;
		EObject parent = getElementToEdit();
		while(parent != null && parentActivity == null) {
			if(parent instanceof Activity) {
				parentActivity = (Activity)parent;
			}
			parent = parent.eContainer();
		}

		CallOperationAction newElement = UMLFactory.eINSTANCE.createCallOperationAction();

		CreateCallOperationActionDialog dialog = new CreateCallOperationActionDialog(Display.getDefault().getActiveShell(), parentActivity);
		if(IDialogConstants.OK_ID == dialog.open()) {
			// initialize the invoked element (no need to use a command, since action is being created)
			EObject operation = dialog.getSelectedInvoked();
			if(operation instanceof Operation) {
				newElement.setOperation((Operation)operation);
			}
			// initialize synchronous
			newElement.setIsSynchronous(dialog.getIsSynchronous());
		} else {
			return CommandResult.newCancelledCommandResult();
		}

		// set appropriate parents
		if(!CreateCommandUtil.setNodeParents(newElement, getRequest(), getElementToEdit())) {
			return CommandResult.newCancelledCommandResult();
		}
		//		Activity owner = (Activity)getElementToEdit();
		//		owner.getNodes().add(newElement);

		ElementInitializers.getInstance().init_CallOperationAction_3010(newElement);

		doConfigure(newElement, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(CallOperationAction newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
