/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.edit.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.papyrus.uml.diagram.timing.custom.Messages;
import org.eclipse.papyrus.uml.diagram.timing.custom.utils.ModelValidationUtils;
import org.eclipse.swt.widgets.Display;
import org.eclipse.uml2.uml.Interaction;

public class ValidateInteractionCommand extends AbstractTransactionalCommand {

	private final Interaction interaction;
	private final boolean interactive;

	/**
	 * @param domain
	 *            the editing domain
	 * @param interaction
	 *            the interaction to validate
	 * @param interactive
	 *            whether to display notifications to the user, and ask for confirmation using dialog boxes
	 */
	public ValidateInteractionCommand(final TransactionalEditingDomain domain, final Interaction interaction, final boolean interactive) {
		super(domain, Messages.ValidateInteractionCommand_ValidateInteraction, null);
		this.interaction = interaction;
		this.interactive = interactive;
	}

	@Override
	protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, final IAdaptable info) throws ExecutionException {
		final boolean[] result = new boolean[1];
		Display.getDefault().syncExec(new Runnable() {
			public void run() {
				result[0] = validate();
			}
		});
		return result[0] ? CommandResult.newOKCommandResult() : CommandResult.newErrorCommandResult("Invalid model"); //$NON-NLS-1$
	}

	protected boolean validate() {
		return ModelValidationUtils.validate(this.interaction, true, this.interactive);
	}
}
