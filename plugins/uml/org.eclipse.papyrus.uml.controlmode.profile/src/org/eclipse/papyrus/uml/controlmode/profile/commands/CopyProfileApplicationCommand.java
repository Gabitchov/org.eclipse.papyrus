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

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.papyrus.infra.services.controlmode.ControlModeRequest;
import org.eclipse.papyrus.infra.services.controlmode.commands.AbstractControlCommand;
import org.eclipse.papyrus.uml.controlmode.profile.helpers.ProfileApplicationHelper;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * Command used to copy profile application when controling an UML model
 * 
 * @author adaussy
 * 
 */
public final class CopyProfileApplicationCommand extends AbstractControlCommand {


	public CopyProfileApplicationCommand(ControlModeRequest request) {
		super("Copy Profile Application to new control resource", null, request);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		duplicateAppliedProfiles(getRequest().getTargetObject());
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Duplicate all applied profiles from the package on the root element of the controlled resource
	 * 
	 * @param selection
	 */
	private void duplicateAppliedProfiles(final EObject selection) {
		Package _package = (Package)selection;
		for(Profile profile : _package.getAllAppliedProfiles()) {
			ProfileApplicationHelper.duplicateProfileApplication(_package, profile);
		}
	}
}