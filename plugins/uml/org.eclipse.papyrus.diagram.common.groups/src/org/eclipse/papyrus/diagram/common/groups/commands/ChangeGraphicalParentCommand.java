/*****************************************************************************
 * Copyright (c) 2011 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.groups.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

/**
 * This command updates the graphical parent of an edit part
 * 
 * @author adaussy
 *         TODO complete this command
 */
public class ChangeGraphicalParentCommand extends AbstractTransactionalCommand {

	/** child part */
	private EditPart child;

	/** parent part */
	private EditPart parent;

	/**
	 * 
	 * Command constructor.
	 * 
	 * @param domain
	 *        editing domain
	 * @param label
	 *        command label
	 * @param parent
	 *        new parent edit part
	 * @param child
	 *        child edit part to reroute parent
	 */
	public ChangeGraphicalParentCommand(TransactionalEditingDomain domain, String label, EditPart parent, EditPart child) {
		super(domain, label, null);
		this.parent = parent;
		this.child = child;
	}

	/**
	 * @see org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor arg0, IAdaptable arg1) throws ExecutionException {
		child.setParent(parent);
		return CommandResult.newOKCommandResult();
	}

}
