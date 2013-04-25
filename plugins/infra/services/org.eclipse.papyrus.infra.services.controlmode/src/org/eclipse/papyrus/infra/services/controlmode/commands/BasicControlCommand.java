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
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;

/**
 * This command do the basic operation of the control. That is to say move the semantic element to a new resource previously created.
 * This resource id got thanks to the request.
 * 
 * @author adaussy
 * 
 */
public class BasicControlCommand extends AbstractControlCommand {


	/**
	 * @param request
	 */
	public BasicControlCommand(ControlModeRequest request) {
		super("Control command", Collections.singletonList(WorkspaceSynchronizer.getFile(request.getTargetObject().eResource())), request);
	}

	@Override
	public boolean canExecute() {
		return super.canExecute() && getObjectToControl() != null && !getObjectToControl().eIsProxy();
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ResourceSet currentResourceSet = getRequest().getModelSet();
		Resource resource = currentResourceSet.getResource(getNewURI(), false);
		if(resource == null) {
			throw new ExecutionException("The resource was not created");
		}
		resource.getContents().add(getObjectToControl());
		return CommandResult.newOKCommandResult(resource);
	}


	/**
	 * @return the object being controled
	 */
	public EObject getObjectToControl() {
		return getRequest().getTargetObject();
	}

	/**
	 * @return
	 */
	public URI getNewURI() {
		return getRequest().getNewURI();
	}
}
