/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/


package org.eclipse.papyrus.diagram.profile.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.uml2.uml.Extension;
import org.eclipse.uml2.uml.Stereotype;



/**
 * This class allows to change the extensionName if the stereotype's name is changed
 * 
 * @author VL222926
 * 
 */
public class ChangeExtensionNameCommand extends AbstractTransactionalCommand {

	/**
	 * the extension
	 */
	private Extension extension = null;

	/**
	 * the extended stereotype
	 */
	private Stereotype stereotype = null;

	/**
	 * the new name for the extension
	 */
	private String newName = ""; //$NON-NLS-1$

	public ChangeExtensionNameCommand(TransactionalEditingDomain domain, Extension extension, Stereotype stereotype, String name) {
		super(domain, "ChangeExtensionNameCommand", null); //$NON-NLS-1$
		this.stereotype = stereotype;
		this.extension = extension;
		this.newName = name;
	}


	@Override
	public boolean canExecute() {
		boolean rep = false;
		if(extension != null && stereotype != null)
			rep = super.canExecute();
		return rep;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		extension.setName(newName);
		return CommandResult.newOKCommandResult();
	}


}
