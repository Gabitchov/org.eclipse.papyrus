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
package org.eclipse.papyrus.infra.services.controlmode.commands;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;

/**
 * Basic action to uncontrol an element
 * 
 * @author adaussy
 * 
 */
public class BasicUncontrolCommand extends AbstractControlCommand {


	/**
	 * @param request
	 */
	public BasicUncontrolCommand(ControlModeRequest request) {
		super("Basic uncontrol files", Collections.singletonList(WorkspaceSynchronizer.getFile(request.getTargetObject().eResource())), request);
	}

	@Override
	public boolean canExecute() {
		return getRequest().getTargetObject().eResource() != null;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		EObject uncontroledObject = getRequest().getTargetObject();
		Resource resource = uncontroledObject.eResource();
		if(resource != null) {
			resource.getContents().remove(uncontroledObject);
			return CommandResult.newOKCommandResult();
		}
		return CommandResult.newErrorCommandResult("The object is not contained in a resource");
	}
}
