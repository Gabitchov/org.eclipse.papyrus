/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.StateDefinitionUtils;
import org.eclipse.uml2.uml.Lifeline;

/**
 * This command removes the "semantic" part of a StateDefinition : the EAnnotation on the Lifeline.
 */
public class DeleteStateDefinitionCommand extends AbstractTransactionalCommand {

	private final String id;
	private final Lifeline lifeline;

	/**
	 * @param id
	 *            the id of the state definition to delete
	 * @param lifeline
	 *            the lifeline
	 * @param domain
	 *            the editing domain
	 */
	public DeleteStateDefinitionCommand(final String id, final Lifeline lifeline, final TransactionalEditingDomain domain) {
		super(domain, Messages.DeleteStateDefinitionCommand_DeleteStateDefinition, null);
		this.id = id;
		this.lifeline = lifeline;
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		StateDefinitionUtils.removeStateDefinitionEAnnotationFromLifeline(this.id, this.lifeline);
		return CommandResult.newOKCommandResult();
	}
}
