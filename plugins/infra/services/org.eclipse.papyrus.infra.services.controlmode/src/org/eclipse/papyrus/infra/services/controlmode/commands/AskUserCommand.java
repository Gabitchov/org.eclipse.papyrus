/*******************************************************************************
 * Copyright (c) 2013 Atos.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Arthur Daussy <a href="mailto:arthur.daussy@atos.net"> - initial API and implementation
 ******************************************************************************/
package org.eclipse.papyrus.infra.services.controlmode.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.infra.services.controlmode.ui.OptionalMessageDialog;
import org.eclipse.swt.widgets.Display;

/**
 * Command to ask the user something. If it selected cancel then the all transaction will be canceled
 * 
 * @author adaussy
 * 
 */
public class AskUserCommand extends AbstractTransactionalCommand {

	/**
	 * Message to display
	 */
	private String message;

	/**
	 * Title of the dialog
	 */
	private String title;

	/**
	 * Set to true if the message has the check box preventing this dialog to be displayed each time
	 */
	private boolean optional;


	private String id;

	/**
	 * @param domain
	 * @param message
	 * @param title
	 */
	public AskUserCommand(TransactionalEditingDomain domain, String message, String title) {
		super(domain, "Ask user validation", null);
		this.message = message;
		this.title = title;
	}

	/**
	 * @param domain
	 * @param message
	 * @param title
	 * @param optional
	 * @param id
	 */
	public AskUserCommand(TransactionalEditingDomain domain, String message, String title, boolean optional, String id) {
		super(domain, "Ask user validation", null);
		this.message = message;
		this.title = title;
		this.optional = optional;
		this.id = id;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		boolean confirm = false;
		if(optional) {
			int returnButton = OptionalMessageDialog.open(this.id, Display.getDefault().getActiveShell(), this.title, null, message, MessageDialog.WARNING, new String[]{ "Ok", "Cancel" }, 0);
			confirm = returnButton == 0 || OptionalMessageDialog.NOT_SHOWN == returnButton;
		} else {
			confirm = MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), title, message);
		}
		if(confirm) {
			return CommandResult.newOKCommandResult();
		} else {
			return CommandResult.newCancelledCommandResult();
		}
	}
}
