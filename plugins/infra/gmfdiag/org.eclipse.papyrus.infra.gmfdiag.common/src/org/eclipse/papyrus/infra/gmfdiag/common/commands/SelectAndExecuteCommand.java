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
package org.eclipse.papyrus.infra.gmfdiag.common.commands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.commands.CommandUtilities;
import org.eclipse.gmf.runtime.diagram.ui.commands.PopupMenuCommand;
import org.eclipse.gmf.runtime.diagram.ui.menus.PopupMenu;
import org.eclipse.gmf.runtime.diagram.ui.menus.PopupMenu.CascadingMenu;
import org.eclipse.papyrus.infra.gmfdiag.common.Activator;
import org.eclipse.swt.widgets.Shell;

/**
 * This class opens a dialog to select and execute a command in a given list.
 */
public class SelectAndExecuteCommand extends PopupMenuCommand {

	/** Selected command kept here for undo / re-do purpose */
	private Command _selectedCmd;

	/** An object to handle the selection of a default command. May be null. */
	private DefaultActionHandler defaultHandler;

	/**
	 * The default label provider for the the menu items (Commands) used in this command.
	 */
	static public class CommandLabelProvider extends org.eclipse.jface.viewers.LabelProvider {

		/**
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 */
		@Override
		public String getText(Object object) {
			String text = super.getText(object);
			if(object instanceof Command) {
				String commandLabel = ((Command)object).getLabel();
				if(commandLabel != null) {
					text = commandLabel;
				}
			}
			return text;
		}
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param label
	 *        the command label
	 * @param parentShell
	 *        the parent shell
	 * @param content
	 *        the list of available commands proposed for user selection
	 *        (List<org.eclipse.gef.commands.Command> expected here)
	 */
	public SelectAndExecuteCommand(String label, Shell parentShell, List<Command> content) {
		this(label, parentShell, content, null);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param label
	 *        the command label
	 * @param parentShell
	 *        the parent shell
	 * @param content
	 *        the list of available commands proposed for user selection
	 *        (List<org.eclipse.gef.commands.Command> expected here)
	 * @param handler
	 *        an object to handle the "default action" case
	 */
	public SelectAndExecuteCommand(String label, Shell parentShell, List<Command> content, DefaultActionHandler handler) {
		super(label, parentShell);

		this.defaultHandler = handler;
		createPopupMenu(content);
	}

	/**
	 * Adds a submenu to the popup menu, to handle the "Select default" case
	 * 
	 * @param menu
	 */
	protected void createPopupMenu(List<Command> content) {
		PopupMenu popupMenu;

		if(defaultHandler != null) {
			//Contains a list of commands + a Default item
			List<Object> menuContents = new LinkedList<Object>(content);

			PopupMenu submenu = new PopupMenu(convertToDefault(content), new CommandLabelProvider());

			CascadingMenu cascadingMenu = new CascadingMenu(defaultHandler.getLabel(), submenu);
			menuContents.add(cascadingMenu);

			popupMenu = new PopupMenu(menuContents, new CommandLabelProvider());
		} else {
			popupMenu = new PopupMenu(content, new CommandLabelProvider());
		}

		setPopupMenu(popupMenu);
	}

	/**
	 * Adds a "Set as default" behavior to a list of commands
	 * 
	 * @param commands
	 * @return
	 */
	protected List<Command> convertToDefault(List<Command> commands) {
		List<Command> result = new ArrayList<Command>(commands.size());
		for(Command command : commands) {
			final Command commandToExecute = command;
			CompoundCommand compound = new CompoundCommand(commandToExecute.getLabel());
			compound.add(commandToExecute);
			compound.add(new Command("Set default drop behavior") {

				@Override
				public void execute() {
					defaultHandler.defaultActionSelected(commandToExecute);
				}

			});

			result.add(compound);
		}
		return result;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor progressMonitor, org.eclipse.core.runtime.IAdaptable info) throws ExecutionException {
		CommandResult cmdResult = super.doExecuteWithResult(progressMonitor, info);
		if(!cmdResult.getStatus().isOK()) {
			if(cmdResult.getStatus().getSeverity() != IStatus.CANCEL) {
				Activator.log.error(cmdResult.getStatus().getException());
			}
			return cmdResult;
		}

		Object returnValue = cmdResult.getReturnValue();
		if(returnValue instanceof List<?>) {
			_selectedCmd = (Command)((List<?>)returnValue).get(((List<?>)returnValue).size() - 1); //Returns the last command
		} else {
			_selectedCmd = (Command)cmdResult.getReturnValue();
		}
		Assert.isTrue(_selectedCmd != null && _selectedCmd.canExecute());
		_selectedCmd.execute();

		return CommandResult.newOKCommandResult();
	}

	@Override
	protected CommandResult doUndoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		if(_selectedCmd != null && _selectedCmd.canUndo()) {
			_selectedCmd.undo();
		}
		return super.doUndoWithResult(progressMonitor, info);
	}

	@Override
	protected CommandResult doRedoWithResult(IProgressMonitor progressMonitor, IAdaptable info) throws ExecutionException {

		if(_selectedCmd != null && CommandUtilities.canRedo(_selectedCmd)) {
			_selectedCmd.redo();
		}
		return super.doRedoWithResult(progressMonitor, info);
	}
}
