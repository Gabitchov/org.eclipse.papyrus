/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 * 
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.statemachine.custom.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;
/**
 * Set visibility to true/false depending if empty or not
 * @author adaussy
 *
 */
public class HideShowCompartmentIfEmptyCommand extends AbstractTransactionalCommand{
	/**
	 * View of the compartment to hide/show
	 */
	private View view;

	public HideShowCompartmentIfEmptyCommand(TransactionalEditingDomain domain, String label, View compartment) {
		super(domain, label, null);
		this.view = compartment;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		EList children = view.getChildren();
		if (children == null || children.size() == 0){
			view.setVisible(false);
		} else {
			view.setVisible(true);
		}
		return CommandResult.newOKCommandResult();
	}

	@Override
	public boolean canExecute() {
		return view != null;
	}
}