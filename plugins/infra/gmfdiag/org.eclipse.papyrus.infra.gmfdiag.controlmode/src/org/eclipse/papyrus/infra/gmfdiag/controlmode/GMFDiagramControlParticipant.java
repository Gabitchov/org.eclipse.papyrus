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
package org.eclipse.papyrus.infra.gmfdiag.controlmode;


import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.common.core.command.UnexecutableCommand;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.commands.CreateControlResource;
import org.eclipse.papyrus.infra.services.controlmode.commands.RemoveControlResourceCommand;
import org.eclipse.papyrus.infra.services.controlmode.participants.IControlCommandParticipant;
import org.eclipse.papyrus.infra.services.controlmode.participants.IUncontrolCommandParticipant;

/**
 * Particiant that will and diagram control
 * @author adaussy
 *
 */
public class GMFDiagramControlParticipant implements IControlCommandParticipant, IUncontrolCommandParticipant {

	/**
	 * Init target request to have the DIModel resource references
	 * 
	 * @param request
	 */
	private boolean setNotationTargetRequest(ControlModeRequest request) {
		URI notationURI = request.getNewURI().trimFileExtension().appendFileExtension(NotationModel.NOTATION_FILE_EXTENSION);
		ModelSet modelSet = request.getModelSet();
		if(modelSet != null) {
			Resource diResource = modelSet.getResource(notationURI, false);
			if(diResource == null) {
				return false;
			}
			request.setTargetResource(diResource, NotationModel.NOTATION_FILE_EXTENSION);
			//Nothing to do but everything is ok
			return true;
		}
		return false;
	}

	public String getID() {
		return "org.eclipse.papyrus.infra.gmfdiag.controlmode.GMFDiagramControlParticipant";////$NON-NLS-0$
	}

	public ICommand getPostControlCommand(ControlModeRequest request) {
		return new ControlDiagramsCommand(request);
	}

	public ICommand getPostUncontrolCommand(ControlModeRequest request) {
		return new RemoveControlResourceCommand(request, NotationModel.NOTATION_FILE_EXTENSION);
	}

	public ICommand getPreControlCommand(ControlModeRequest request) {
		//Create notation resource
		return new CreateControlResource(request, NotationModel.NOTATION_FILE_EXTENSION);
	}

	public ICommand getPreUncontrolCommand(ControlModeRequest request) {
		boolean result = setNotationTargetRequest(request);
		if (result) {
			return new ControlDiagramsCommand(request);
		}
		return UnexecutableCommand.INSTANCE;
	}

	public int getPriority() {
		return 60;
	}

	public boolean provideControlCommand(ControlModeRequest request) {
		return request.getTargetObject() instanceof EObject;
	}

	public boolean provideUnControlCommand(ControlModeRequest request) {
		return request.getTargetObject() instanceof EObject;
	}
}
