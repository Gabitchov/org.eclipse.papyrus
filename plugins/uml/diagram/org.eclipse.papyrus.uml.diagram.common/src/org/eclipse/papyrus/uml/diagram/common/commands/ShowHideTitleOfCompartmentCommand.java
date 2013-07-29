/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.commands.SetPropertyCommand;
import org.eclipse.gmf.runtime.diagram.ui.internal.properties.Properties;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * This command allows to show/hide the compartment title
 * 
 * 
 */
public class ShowHideTitleOfCompartmentCommand extends SetPropertyCommand {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param view
	 *        the compartment view
	 * @param visibility
	 *        the visibility of the title
	 */
	public ShowHideTitleOfCompartmentCommand(TransactionalEditingDomain domain, View view, boolean visibility) {
		super(domain, new EObjectAdapter(view), Properties.ID_SHOWCOMPARTMENTTITLE, "Show/Hide Compartment Title", Boolean.valueOf(visibility)); //$NON-NLS-1$
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.diagram.core.commands.SetPropertyCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor,
	 *      org.eclipse.core.runtime.IAdaptable)
	 * 
	 * @param progressMonitor
	 * @param info
	 * @return
	 * @throws ExecutionException
	 */
	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {
		return super.doExecuteWithResult(progressMonitor, info);
	}
}
