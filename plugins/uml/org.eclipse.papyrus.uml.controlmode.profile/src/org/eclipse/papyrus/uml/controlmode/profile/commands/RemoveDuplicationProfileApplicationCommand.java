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
package org.eclipse.papyrus.uml.controlmode.profile.commands;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.commands.AbstractControlCommand;
import org.eclipse.papyrus.uml.controlmode.profile.helpers.ProfileApplicationHelper;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * Command to remove duplication profile applicaiton during uncontrol
 * 
 * @author adaussy
 * 
 */
public final class RemoveDuplicationProfileApplicationCommand extends AbstractControlCommand {

	public RemoveDuplicationProfileApplicationCommand(ControlModeRequest request) {
		super("Remove duplicated Profile Application", Collections.singletonList(WorkspaceSynchronizer.getFile(request.getTargetObject().eResource())), request);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		for(Profile profile : ((Package)getRequest().getTargetObject()).getAppliedProfiles()) {
			// profile is duplicated, unapply it
			ProfileApplicationHelper.removeProfileApplicationDuplication(((Package)getRequest().getTargetObject()), profile, true);
		}
		return CommandResult.newOKCommandResult();
	}
}