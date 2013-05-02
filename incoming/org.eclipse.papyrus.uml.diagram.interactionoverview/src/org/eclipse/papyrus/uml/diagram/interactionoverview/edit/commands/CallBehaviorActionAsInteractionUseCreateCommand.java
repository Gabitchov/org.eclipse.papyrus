/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.uml.diagram.activity.edit.commands.CallBehaviorActionCreateCommand;
import org.eclipse.papyrus.uml.diagram.activity.providers.ElementInitializers;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.dialogs.CreateInteractionUseDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.CallBehaviorAction;
import org.eclipse.uml2.uml.UMLFactory;


public class CallBehaviorActionAsInteractionUseCreateCommand extends CallBehaviorActionCreateCommand {


	public CallBehaviorActionAsInteractionUseCreateCommand(final CreateElementRequest req) {
		super(req);
	}

	public CallBehaviorActionAsInteractionUseCreateCommand(final CreateElementRequest req, final EObject eObject) {
		super(req, eObject);
	}

	public static CallBehaviorActionAsInteractionUseCreateCommand create(final CreateElementRequest req, final EObject eObject) {
		return new CallBehaviorActionAsInteractionUseCreateCommand(req, eObject);
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		// get the activity containing the new element
		Activity parentActivity = null;
		EObject parent = getElementToEdit();
		while(parent != null && parentActivity == null) {
			if(parent instanceof Activity) {
				parentActivity = (Activity)parent;
			}
			parent = parent.eContainer();
		}
		final CallBehaviorAction newElement = UMLFactory.eINSTANCE.createCallBehaviorAction();
		final CreateInteractionUseDialog dialog = new CreateInteractionUseDialog(Display.getDefault().getActiveShell(), parentActivity, newElement);
		if(IDialogConstants.OK_ID == dialog.open()) {
			// initialize the invoked element (no need to use a command, since action is being created)
			final EObject behavior = dialog.getSelectedInvoked();
			if(behavior instanceof Behavior) {
				newElement.setBehavior((Behavior)behavior);
			}
		} else {
			return CommandResult.newCancelledCommandResult();
		}
		initAndExecuteEmfCommand(newElement);
		//		Activity owner = (Activity)getElementToEdit();
		//		owner.getNodes().add(newElement);
		ElementInitializers.getInstance().init_CallBehaviorAction_3008(newElement);
		doConfigure(newElement, monitor, info);
		((CreateElementRequest)getRequest()).setNewElement(newElement);
		return CommandResult.newOKCommandResult(newElement);
	}
}
