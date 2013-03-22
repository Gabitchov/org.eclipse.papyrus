/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
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
package org.eclipse.papyrus.uml.diagram.sequence.command;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

/**
 * ZOrder command with a custom index
 */
public class CustomZOrderCommand extends AbstractTransactionalCommand {

	protected View view;

	protected View containerView;

	private int index;

	/**
	 * @param editingDomain
	 *        the editing domain through which model changes are made
	 * @param label
	 * @param view
	 */
	public CustomZOrderCommand(TransactionalEditingDomain editingDomain, View view, int index) {
		super(editingDomain, "change ZOrder", getWorkspaceFiles(view));

		this.view = view;
		this.index = index;
		containerView = ViewUtil.getContainerView(view);

	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		ViewUtil.repositionChildAt(containerView, view, index);
		return CommandResult.newOKCommandResult();
	}

}
