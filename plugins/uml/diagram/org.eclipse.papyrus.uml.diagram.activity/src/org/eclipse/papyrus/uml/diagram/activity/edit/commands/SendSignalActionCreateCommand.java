/*****************************************************************************
 * Copyright (c) 2012 Atos Origin and CEA LIST
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *   Patrick Tessier (CEA LIST) - modification
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.util.CreateCommandUtil;
import org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.CreateSendSignalActionDialog;
import org.eclipse.papyrus.uml.diagram.activity.providers.ElementInitializers;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.SendSignalAction;
import org.eclipse.uml2.uml.Signal;
import org.eclipse.uml2.uml.UMLFactory;

/**
 * @generated not
 */
public class SendSignalActionCreateCommand extends ActivityNodeCreateCommand {

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
		SendSignalAction newElement = UMLFactory.eINSTANCE.createSendSignalAction();
		CreateSendSignalActionDialog dialog = new CreateSendSignalActionDialog(Display.getDefault().getActiveShell(), parentActivity, newElement);
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
		initAndExecuteEmfCommand(newElement);
		if(newElement.getName() == null || newElement.getName().length() == 0) {
			// initialize name if it is not yet 
			ElementInitializers.getInstance().init_SendSignalAction_3052(newElement);
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
