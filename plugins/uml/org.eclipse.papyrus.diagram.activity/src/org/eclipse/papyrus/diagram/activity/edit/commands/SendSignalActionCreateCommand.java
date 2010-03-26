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
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.diagram.activity.edit.dialogs.CreateSendSignalActionDialog;
import org.eclipse.papyrus.diagram.activity.providers.UMLElementTypes;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated
 */
public class SendSignalActionCreateCommand extends EditElementCommand {

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
	public SendSignalActionCreateCommand(CreateElementRequest req, EObject eObject) {
		super(req.getLabel(), null, req);
		this.eObject = eObject;
		this.eClass = eObject != null ? eObject.eClass() : null;
	}

	/**
	 * @generated
	 */
	public static SendSignalActionCreateCommand create(CreateElementRequest req, EObject eObject) {
		return new SendSignalActionCreateCommand(req, eObject);
	}

	/**
	 * @generated
	 */
	public SendSignalActionCreateCommand(CreateElementRequest req) {
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
	 * @generated
	 */
	public boolean canExecute() {


		return true;



	}

	/**
	 * @generated NOT use the initialization popup
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		Activity owner = (Activity)getElementToEdit();

		SendSignalAction newElement = UMLFactory.eINSTANCE.createSendSignalAction();

		CreateSendSignalActionDialog dialog = new CreateSendSignalActionDialog(Display.getDefault().getActiveShell(), owner);
		if(IDialogConstants.OK_ID == dialog.open()) {
			// initialize the invoked element (no need to use a command, since action is being created)
			EObject signal = dialog.getSelectedInvoked();
			if(signal instanceof Signal) {
				newElement.setSignal((Signal)signal);
				// initialize the action name with the signal
				newElement.setName("Send".concat(((Signal)signal).getName()));
			}
		} else {
			return CommandResult.newCancelledCommandResult();
		}

		owner.getNodes().add(newElement);

		if(newElement.getName() == null || newElement.getName().length() == 0) {
			// initialize name if it is not yet 
			UMLElementTypes.init_SendSignalAction_3052(newElement);
		}

		doConfigure(newElement, monitor, info);

		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}

	/**
	 * @generated
	 */
	protected void doConfigure(SendSignalAction newElement, IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
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
