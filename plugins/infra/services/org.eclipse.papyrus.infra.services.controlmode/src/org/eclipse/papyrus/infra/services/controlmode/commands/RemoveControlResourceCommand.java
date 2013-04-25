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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;


/**
 * Basic command to remove a controlled resource.
 * It handles removal of the resource from resource set (deletion on save of the resources back end).
 * It also handle correctly undo and redo
 * 
 * @author adaussy
 * 
 */
public class RemoveControlResourceCommand extends AbstractControlResourceCommand {

	/**
	 * @param request
	 */
	public RemoveControlResourceCommand(ControlModeRequest request) {
		super(request, "Uncontrol command", Collections.singletonList(WorkspaceSynchronizer.getFile(request.getTargetObject().eResource())));
	}

	/**
	 * @param request
	 * @param fileExtension
	 *        file extension of the resource you want to handle
	 */
	public RemoveControlResourceCommand(ControlModeRequest request, String fileExtension) {
		super(request, fileExtension, "Uncontrol command", Collections.singletonList(WorkspaceSynchronizer.getFile(request.getTargetObject().eResource())));
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		EObject objectToControl = getRequest().getTargetObject();
		if(objectToControl == null) {
			return CommandResult.newErrorCommandResult("The object to uncontrol is null");
		}
		ModelSet modelSet = getRequest().getModelSet();
		if(modelSet == null) {
			return CommandResult.newErrorCommandResult("The resource is not contained in any resource set");
		}
		Resource resource = modelSet.getResource(getSourceUri(), false);
		if(resource == null) {
			return CommandResult.newErrorCommandResult("The resource is null");
		}
		//Delete resource backend on save
		modelSet.getResourcesToDeleteOnSave().add(resource.getURI());
		//Save source and target resource
		Resource targetResource = getTargetResource(objectToControl);
		if(targetResource == null) {
			return CommandResult.newErrorCommandResult("unable to retreive the target resource for the extension" + getFileExtension());
		}
		getRequest().setTargetResource(targetResource, getFileExtension());
		getRequest().setSourceResource(resource, getFileExtension());
		//remove resource set
		modelSet.getResources().remove(resource);

		return CommandResult.newOKCommandResult();
	}

	/**
	 * @param objectToControl
	 *        get the target resource of uncontrol command
	 * @return
	 */
	protected Resource getTargetResource(EObject objectToControl) {
		return getRequest().getModelSet().getAssociatedResource(objectToControl, getFileExtension(), false);
	}

	@Override
	protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus superStatus = super.doUndo(monitor, info);
		ModelSet modelSet = getRequest().getModelSet();
		if(modelSet == null) {
			return CommandResult.newErrorCommandResult("The resource is not contained in any resource set").getStatus();
		}
		Resource resource = getRequest().getSourceResource(getFileExtension());
		if(resource == null) {
			return CommandResult.newErrorCommandResult("The resource is null").getStatus();
		}
		modelSet.getResources().add(resource);
		//Notify the model set that the back ed of this resource should not be deleted on save
		modelSet.getResourcesToDeleteOnSave().remove(resource.getURI());
		return superStatus;
	}

	@Override
	protected IStatus doRedo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus superStatus = super.doRedo(monitor, info);
		Resource resource = getRequest().getSourceResource(getFileExtension());
		if(resource == null) {
			return CommandResult.newErrorCommandResult("Unable to find previous resource").getStatus();
		}
		ModelSet modelSet = getRequest().getModelSet();
		if(modelSet == null) {
			return CommandResult.newErrorCommandResult("The resource is not contained in any resource set").getStatus();
		}
		modelSet.getResources().remove(resource);
		//Notify the model set that the back end of this resource should be deleted on save
		modelSet.getResourcesToDeleteOnSave().add(resource.getURI());
		return superStatus;
	}
}
