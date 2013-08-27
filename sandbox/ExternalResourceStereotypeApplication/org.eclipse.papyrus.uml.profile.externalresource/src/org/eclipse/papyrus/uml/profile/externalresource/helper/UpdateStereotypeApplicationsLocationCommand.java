/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.profile.externalresource.helper;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.ProfileApplication;

/**
 * Command to update stereotype application locations when strategy is changed
 */
public class UpdateStereotypeApplicationsLocationCommand extends AbstractTransactionalCommand {

	protected ProfileApplication profileApplication;
	protected IStereotypeApplicationLocationStrategy oldStrategy;
	protected IStereotypeApplicationLocationStrategy newStrategy;

	/**
	 * Default Constructor
	 * @param profileApplication the profile application for which stereotype applications should be moved
	 * @param oldStrategy old strategy currently used to store stereotype applications
	 * @param newStrategy new strategy to use for stereotype application management
	 */
	public UpdateStereotypeApplicationsLocationCommand(ProfileApplication profileApplication, IStereotypeApplicationLocationStrategy oldStrategy, IStereotypeApplicationLocationStrategy newStrategy) {
		super(TransactionUtil.getEditingDomain(profileApplication), "Update Stereotype Applications Location", getWorkspaceFiles(profileApplication));
		this.profileApplication = profileApplication;
		this.oldStrategy = oldStrategy;
		this.newStrategy = newStrategy;
		
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		IStatus status = ExternalResourceProfileUtils.updateStereotypeApplicationsLocation(profileApplication, oldStrategy, newStrategy);
		return new CommandResult(status);
	}
	
}