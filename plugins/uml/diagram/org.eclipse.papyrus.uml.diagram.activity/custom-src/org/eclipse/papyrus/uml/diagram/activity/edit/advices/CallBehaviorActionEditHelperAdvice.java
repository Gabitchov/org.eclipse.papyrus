/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.edit.advices;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.infra.services.edit.service.ElementEditServiceUtils;
import org.eclipse.papyrus.infra.services.edit.service.IElementEditService;
import org.eclipse.papyrus.uml.diagram.activity.edit.dialogs.CreateCallBehaviorActionDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Activity;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.InvocationAction;
import org.eclipse.uml2.uml.UMLPackage;

/**
 * Edit helper advice for Call Behavior Action, that pops up a dialog during creation
 */
public class CallBehaviorActionEditHelperAdvice extends AbstractEditHelperAdvice {

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		// get the activity containing the new element
		Activity parentActivity = null;
		EObject parent = request.getElementToConfigure();
		while(parent != null && parentActivity == null) {
			if(parent instanceof Activity) {
				parentActivity = (Activity)parent;
			}
			parent = parent.eContainer();
		}
		CreateCallBehaviorActionDialog dialog = new CreateCallBehaviorActionDialog(Display.getDefault().getActiveShell(), parentActivity, (InvocationAction)request.getElementToConfigure());
		if(IDialogConstants.OK_ID == dialog.open()) {
			// initialize the invoked element (no need to use a command, since action is being created)
			CompositeCommand command = new CompositeCommand("Configure created element");
			IElementEditService service = ElementEditServiceUtils.getCommandProvider(request.getElementToConfigure());
			EObject behavior = dialog.getSelectedInvoked();
			if(behavior instanceof Behavior) {
				SetRequest setBehaviorRequest = new SetRequest(request.getElementToConfigure(), UMLPackage.eINSTANCE.getCallBehaviorAction_Behavior(), (Behavior)behavior);
				command.add(service.getEditCommand(setBehaviorRequest));
			}
			// initialize synchronous
			SetRequest setSynchronousReqest = new SetRequest(request.getElementToConfigure(), UMLPackage.eINSTANCE.getCallAction_IsSynchronous(), dialog.getIsSynchronous());
			command.add(service.getEditCommand(setSynchronousReqest));
			return command;
		} 
		return null;
	}
}
