/*
 * Copyright (c) 2007 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Sergey Gribovsky (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.statemachine.part;

import java.util.Collections;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateUnspecifiedTypeRequest;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.diagram.statemachine.edit.helpers.StateEditHelper;
import org.eclipse.papyrus.diagram.statemachine.edit.helpers.StateEditHelper.StateMachineWrapper;
import org.eclipse.papyrus.diagram.statemachine.providers.UMLElementTypes;
import org.eclipse.swt.widgets.Display;


public class CreateSubmachineStateTool extends UnspecifiedTypeCreationTool {
	public CreateSubmachineStateTool() {
		super(Collections.singletonList(UMLElementTypes.State_2005));
		myStateMachineWrapper = new StateMachineWrapper();
	}
	
	@Override
	protected Request createTargetRequest() {
		CreateUnspecifiedTypeRequest request = (CreateUnspecifiedTypeRequest) super.createTargetRequest();
		
		//below is the only way to propagate extended data into IEditCommandRequest#parameters  
		HashMap extendedData = new HashMap();
		extendedData.putAll(request.getExtendedData());
		extendedData.put(StateEditHelper.PARAMETER_CONFIGURE_SUBMACHINE, myStateMachineWrapper);
		request.setExtendedData(extendedData);
		return request;
	}
	
	@Override
	protected void executeCurrentCommand() {
		Command currentCommand = getCurrentCommand();
		if (currentCommand == null || !currentCommand.canExecute()) {
			return;
		}
		
		SelectStateMachineDialog selectDialog = new SelectStateMachineDialog(Display.getCurrent().getActiveShell());
		if (selectDialog.open() == Window.OK && selectDialog.getSelectedModelElementURI() != null) {
			URI selectedModelElementURI = selectDialog.getSelectedModelElementURI();
			myStateMachineWrapper.setStateMachineURI(selectedModelElementURI); 
			super.executeCurrentCommand();
		}
	}
	
	private StateMachineWrapper myStateMachineWrapper;
}
