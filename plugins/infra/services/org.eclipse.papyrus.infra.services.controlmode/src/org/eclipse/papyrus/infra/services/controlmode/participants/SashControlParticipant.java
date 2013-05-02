/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Arthur Daussy <a href="mailto:arthur.daussy@atos.net"> - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.participants;

import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.commands.AbstractControlCommand;
import org.eclipse.papyrus.infra.services.controlmode.commands.CreateControlResource;
import org.eclipse.papyrus.infra.services.controlmode.commands.InitializeSashCommand;
import org.eclipse.papyrus.infra.services.controlmode.commands.RemoveControlResourceCommand;


/**
 * Control participant in charge of controling the di resources.
 * It move page ref to control resources
 * 
 * @author adaussy
 * 
 */
public class SashControlParticipant implements IControlCommandParticipant, IUncontrolCommandParticipant {

	public String getID() {
		return "org.eclipse.papyrus.infra.services.controlmode.participants.SashControlParticipant";////$NON-NLS-0$
	}

	public int getPriority() {
		return 80;
	}

	public boolean provideControlCommand(ControlModeRequest request) {
		EObject objectBeingControl = request.getTargetObject();
		return objectBeingControl != null;
	}

	public ICommand getPreControlCommand(ControlModeRequest request) {
		return new CreateControlResource(request, SashModel.MODEL_FILE_EXTENSION);
	}

	public ICommand getPostControlCommand(ControlModeRequest request) {
		return new InitializeSashCommand(request);
	}

	public boolean provideUnControlCommand(ControlModeRequest request) {
		EObject objectBeingControl = request.getTargetObject();
		return objectBeingControl != null;
	}

	public ICommand getPreUncontrolCommand(ControlModeRequest request) {
		boolean result = setDiTargetRequest(request);
		if(result) {
			return getClearDiCommand(request);
		}
		return UnexecutableCommand.INSTANCE;
	}

	protected ICommand getClearDiCommand(final ControlModeRequest request) {
		ModelSet modelSet = request.getModelSet();
		IFile affectedFiles = WorkspaceSynchronizer.getFile(modelSet.getAssociatedResource(request.getTargetObject(), SashModel.MODEL_FILE_EXTENSION, true));
		return new ClearDiCommand(Collections.singletonList(affectedFiles), request);
	}

	public class ClearDiCommand extends AbstractControlCommand {

		public ClearDiCommand(@SuppressWarnings("rawtypes") List affectedFiles, ControlModeRequest request) {
			super("Clear di command", affectedFiles, request);
		}

		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			ModelSet modelSet = getRequest().getModelSet();
			if (modelSet == null){
				return CommandResult.newErrorCommandResult("Unable to retrieve resource set");
			}
			Resource oldDiresource = modelSet.getAssociatedResource(getRequest().getTargetObject(), SashModel.MODEL_FILE_EXTENSION, true);
			if (oldDiresource == null) {
				return CommandResult.newErrorCommandResult("Unable to retrieve old di resource");
			}
			oldDiresource.getContents().clear();
			return CommandResult.newOKCommandResult();
		}
	}

	protected boolean setDiTargetRequest(ControlModeRequest request) {
		URI diURI = request.getNewURI().trimFileExtension().appendFileExtension(SashModel.MODEL_FILE_EXTENSION);
		ModelSet modelSet = request.getModelSet();
		if(modelSet != null) {
			Resource diResource = null;
			try {
				diResource = modelSet.getResource(diURI, true);
			} catch (Exception e) {
				diResource = null;
			}
			if(diResource == null) {
				return false;
			}
			request.setTargetResource(diResource, SashModel.MODEL_FILE_EXTENSION);
			//Nothing to do but everything is ok
			return true;
		}
		return false;
	}

	public ICommand getPostUncontrolCommand(ControlModeRequest request) {
		return new RemoveControlResourceCommand(request, SashModel.MODEL_FILE_EXTENSION);
	}
}
