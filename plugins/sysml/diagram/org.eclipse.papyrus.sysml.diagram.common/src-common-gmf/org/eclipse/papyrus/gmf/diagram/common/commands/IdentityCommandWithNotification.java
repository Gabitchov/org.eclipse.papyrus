/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.gmf.diagram.common.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.gmf.runtime.common.core.command.AbstractCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.Type;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.CombinedPopupAndViewBuilder;
import org.eclipse.papyrus.infra.widgets.toolbox.notification.builders.NotificationBuilder;

/**
 * A command that is always executable, undoable and redoable, but does nothing.
 * It always returns the same OK command result.
 * 
 * @author ldamus
 */
public class IdentityCommandWithNotification extends AbstractCommand {

	protected String title = "Papyrus notification";

	protected String message = "No message.";

	protected Type type = Type.INFO;

	/**
	 * Public constructor.
	 */
	public IdentityCommandWithNotification(String message) {
		this();
		this.message = message;
	}

	/**
	 * Public constructor.
	 */
	public IdentityCommandWithNotification(String title, String message, Type type) {
		this(message);
		this.title = title;
		this.type = type;
	}

	/**
	 * Private constructor.
	 */
	private IdentityCommandWithNotification() {
		super(StringStatics.BLANK, null);
		setResult(CommandResult.newOKCommandResult());
	}

	/**
	 * Does nothing and returns an OK command result.
	 */
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		new NotificationBuilder().setBuilderClass(CombinedPopupAndViewBuilder.class).setType(type).setTitle(title).setMessage(message).run();

		return getCommandResult();
	}

	/**
	 * Does nothing and returns an OK command result.
	 */
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		return getCommandResult();
	}

	/**
	 * Does nothing and returns an OK command result.
	 */
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		return getCommandResult();
	}

}
