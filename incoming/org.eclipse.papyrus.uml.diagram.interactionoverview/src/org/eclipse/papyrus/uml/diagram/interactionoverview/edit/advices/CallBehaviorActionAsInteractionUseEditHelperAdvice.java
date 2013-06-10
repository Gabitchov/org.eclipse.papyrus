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
package org.eclipse.papyrus.uml.diagram.interactionoverview.edit.advices;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.IEditCommandRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.activity.edit.advices.CallBehaviorActionEditHelperAdvice;
import org.eclipse.papyrus.uml.diagram.interactionoverview.edit.dialogs.CreateInteractionUseDialog;
import org.eclipse.papyrus.uml.diagram.interactionoverview.part.Messages;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.UMLPackage;


public class CallBehaviorActionAsInteractionUseEditHelperAdvice extends AbstractEditHelperAdvice {

	public static String CALL_BEHAVIOR_ACTION_AS_INTERACTION_USE = "CallBehaviorActionAsInteractionUse";

	@Override
	protected ICommand getBeforeConfigureCommand(final ConfigureRequest request) {
		// get the activity containing the new element
		Activity parentActivity = null;
		EObject parent = request.getElementToConfigure();
		while(parent != null && parentActivity == null) {
			if(parent instanceof Activity) {
				parentActivity = (Activity)parent;
			}
			parent = parent.eContainer();
		}
		if(CALL_BEHAVIOR_ACTION_AS_INTERACTION_USE.equals(request.getParameter(CallBehaviorActionEditHelperAdvice.POPUP_TYPE))) {
			final CreateInteractionUseDialog dialog = new CreateInteractionUseDialog(Display.getDefault().getActiveShell(), parentActivity, (InvocationAction)request.getElementToConfigure());
			if(IDialogConstants.OK_ID == dialog.open()) {
				// initialize the invoked element (no need to use a command, since action is being created)
				final CompositeCommand command = new CompositeCommand(Messages.CallBehaviorActionAsInteractionUseEditHelperAdvice_ConfigureCreatedInteraction);
				final IElementEditService service = ElementEditServiceUtils.getCommandProvider(request.getElementToConfigure());
				final EObject behavior = dialog.getSelectedInvoked();
				if(behavior instanceof Behavior) {
					final SetRequest setBehaviorRequest = new SetRequest(request.getElementToConfigure(), UMLPackage.eINSTANCE.getCallBehaviorAction_Behavior(), behavior);
					command.add(service.getEditCommand(setBehaviorRequest));
				}
				// initialize synchronous
				return command;
			}
		}
		return null;
	}

	@Override
	public void configureRequest(final IEditCommandRequest request) {
		request.getParameters().put(CallBehaviorActionEditHelperAdvice.POPUP_TYPE, CALL_BEHAVIOR_ACTION_AS_INTERACTION_USE);
	}
}
