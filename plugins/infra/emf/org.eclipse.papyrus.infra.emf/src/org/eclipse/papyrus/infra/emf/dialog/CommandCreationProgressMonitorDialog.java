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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.emf.dialog;

import org.eclipse.emf.common.command.Command;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.swt.widgets.Shell;


/**
 * 
 * This dialog allows to create a command using a progress bar dialog
 * Typical usage is:
 * 
 * <pre>
 * CreationCommandProgressMonitorDialog commandCreationDialog = new CreationCommandProgressMonitorDialog(Display.getShell());
 * 
 * try {
 * 		commandCreationDialog.run(true, true, new IRunnableWithProgress() {
 * 
 * 			public void run(final IProgressMonitor cancelProvider) throws InvocationTargetException, InterruptedException {
 * 				final Command cmd = commandProvider.getCommand();
 * 				commandCreationDialog.setCreatedCommand(cmd);
 * 			}
 * 		});
 * } catch (final InvocationTargetException e) {
 * 		Activator.log.error(e);
 * } catch (final InterruptedException e) {
 * 		Activator.log.error(e);
 * }
 * final int returnCode = commandCreationDialog.getReturnCode();
 * if(returnCode == Window.OK) {
 * final Command createdCommand = commandCreationDialog.getCreatedCommand();
 * ...
 * }
 * </pre>
 */
public class CommandCreationProgressMonitorDialog extends ProgressMonitorDialog {

	/** the created command */
	private Command createdCommand = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 */
	public CommandCreationProgressMonitorDialog(final Shell parent) {
		super(parent);

	}

	/**
	 * Setter for {@link #createdCommand}
	 * 
	 * @param cmd
	 *        the created command
	 */
	public void setCreatedCommand(final Command cmd) {
		this.createdCommand = cmd;
	}

	/**
	 * Getter for {@link #createdCommand}
	 * 
	 * @return
	 *         the created command
	 */
	public Command getCreatedCommand() {
		return this.createdCommand;
	}

}
