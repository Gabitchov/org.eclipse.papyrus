/*******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.qompass.designer.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.papyrus.qompass.designer.core.CommandSupport;
import org.eclipse.papyrus.qompass.designer.core.RunnableWithResult;
import org.eclipse.papyrus.qompass.designer.ui.Messages;
import org.eclipse.papyrus.qompass.designer.ui.dialogs.ConfigurePortDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Port;

/**
 * Implementation class for ClassAction action
 */
public class ConfigurePortHandler extends CmdHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		if((selectedEObject instanceof Class) ||
			(selectedEObject instanceof Port)) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.IActionDelegate#run(org.eclipse.jface.action.IAction)
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		if(!(selectedEObject instanceof NamedElement)) {
			return null;
		}

		final NamedElement element = (NamedElement)selectedEObject;
		final Shell shell = new Shell();

		// 1. select possible connectors according to port types
		// (only show compatible connectors check-box?)
		// 2. select implementation group according to connector type

		if(element instanceof Class) {
			CommandSupport.exec(Messages.ConfigurePortHandler_ConfigurePorts, event, new RunnableWithResult() {

				public CommandResult run() {
					ConfigurePortDialog configurePortDialog =
						new ConfigurePortDialog(shell);
					if (configurePortDialog.init((Class)element)) {
						configurePortDialog.setTitle(Messages.ConfigurePortHandler_ConfigurePorts);
						configurePortDialog.setMessage(Messages.ConfigurePortHandler_ConfigurePortsOfComponent + " " + element.getName()); //$NON-NLS-1$
						configurePortDialog.open();
						if(configurePortDialog.getReturnCode() == IDialogConstants.OK_ID) {
							return CommandResult.newOKCommandResult();
						}
					}
					return CommandResult.newCancelledCommandResult();
				}
			});
		} else if(element instanceof Port) {
			CommandSupport.exec(Messages.ConfigurePortHandler_ConfigurePorts, event, new RunnableWithResult() {

				public CommandResult run() {
					ConfigurePortDialog configurePortDialog =
						new ConfigurePortDialog(shell);
					if (configurePortDialog.init((Port)element)) {
						configurePortDialog.setTitle(Messages.ConfigurePortHandler_ConfigurePorts);
						configurePortDialog.setMessage(Messages.ConfigurePortHandler_ConfigurePorts + " " + element.getName()); //$NON-NLS-1$
						configurePortDialog.open();
						if(configurePortDialog.getReturnCode() == IDialogConstants.OK_ID) {
							return CommandResult.newOKCommandResult();
						}
					}
					return CommandResult.newCancelledCommandResult();
				}
			});
		}
		return null;
	}
}
