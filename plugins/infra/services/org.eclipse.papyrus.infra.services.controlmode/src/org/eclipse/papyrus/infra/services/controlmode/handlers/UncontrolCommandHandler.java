/*****************************************************************************
 * Copyright (c) 2013 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Arthur Daussy (Atos) arthur.daussy@atos.net - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.handlers;

import java.util.List;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.commands.wrappers.GMFtoEMFCommandWrapper;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeManager;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.IControlModeManager;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;
import org.eclipse.papyrus.views.modelexplorer.handler.AbstractModelExplorerHandler;

/**
 * Handler use to uncontrol an element
 * 
 * @author adaussy
 * 
 */
public class UncontrolCommandHandler extends AbstractModelExplorerHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		List<EObject> selection = getCurrentSelectionAdaptedToType(event, EObject.class);
		if(selection == null || selection.isEmpty() || selection.size() > 1) {
			NotificationBuilder.createInfoPopup("Nothing to Uncontrol").run();
			return null;
		}
		EObject eObjectToControl = selection.get(0);
		ControlModeRequest controlRequest = ControlModeRequest.createUIUncontrolModelRequest(getEditingDomain(), eObjectToControl);
		IControlModeManager controlMng = ControlModeManager.getInstance();
		ICommand controlCommand = controlMng.getUncontrolCommand(controlRequest);
		getEditingDomain().getCommandStack().execute(new GMFtoEMFCommandWrapper(controlCommand));
		return null;
	}
}
