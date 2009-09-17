/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.clazz.custom.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.papyrus.ui.toolbox.LookForElement;
import org.eclipse.uml2.uml.Association;

/**
 * This is the command in charge to supress the association and associated properties
 * 
 * @author Patrick Tessier
 */
public class DestroyAssociationCommand extends DestroyElementCommand {

	/**
	 * constructor of theis command
	 * 
	 * @param request
	 *            see {@link DestroyElementRequest}
	 */
	public DestroyAssociationCommand(DestroyElementRequest request) {
		super(request);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {

		Association association = (Association) getElementToDestroy();
		DestroyElementRequest request = new DestroyElementRequest(getEditingDomain(), association.getMemberEnds()
				.get(1), true);
		DestroyElementCommand c = new DestroyElementCommand(request);
		LookForElement.getCommandStack().execute(new ICommandProxy(c));
		request = new DestroyElementRequest(getEditingDomain(), association.getMemberEnds().get(0), true);
		c = new DestroyElementCommand(request);
		LookForElement.getCommandStack().execute(new ICommandProxy(c));
		request = new DestroyElementRequest(getEditingDomain(), association, true);
		c = new DestroyElementCommand(request);
		LookForElement.getCommandStack().execute(new ICommandProxy(c));
		return CommandResult.newOKCommandResult();
	}
}
