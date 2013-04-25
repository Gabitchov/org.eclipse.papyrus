/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Mathieu Velten <a href="mailto:mathieu.velten@atos.net"> - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.uml.profilefacet.controlmode;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.participants.IControlCommandParticipant;
import org.eclipse.papyrus.infra.services.controlmode.participants.IUncontrolCommandParticipant;
import org.eclipse.papyrus.uml.profilefacet.utils.ProfileFacetSetMoveHelper;


public class ProfileFacetSetControlParticipant implements IControlCommandParticipant, IUncontrolCommandParticipant {

	public String getID() {
		return "org.eclipse.papyrus.uml.profilefacet.controlmode.ProfileFacetSetControlParticipant";
	}

	public int getPriority() {
		return 20;
	}

	public boolean provideUnControlCommand(ControlModeRequest request) {
		return request.getTargetObject() instanceof EObject;
	}

	public boolean provideControlCommand(ControlModeRequest request) {
		return request.getTargetObject() instanceof EObject;
	}

	public ICommand getPreUncontrolCommand(ControlModeRequest request) {
		return ProfileFacetSetMoveHelper.getMoveAllFacetSetsCommand(request.getEditingDomain(), request.getTargetObject(), request.getSourceResource(SashModel.MODEL_FILE_EXTENSION), request.getTargetResource(SashModel.MODEL_FILE_EXTENSION));

	}

	public ICommand getPostUncontrolCommand(ControlModeRequest request) {
		return null;
	}

	public ICommand getPreControlCommand(ControlModeRequest request) {
		return null;
	}

	public ICommand getPostControlCommand(ControlModeRequest request) {
		return ProfileFacetSetMoveHelper.getMoveAllFacetSetsCommand(request.getEditingDomain(), request.getTargetObject(), request.getSourceResource(SashModel.MODEL_FILE_EXTENSION), request.getTargetResource(SashModel.MODEL_FILE_EXTENSION));
	}

}
