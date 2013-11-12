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
import org.eclipse.papyrus.qompass.designer.ui.dialogs.ConfigureInstanceDialog;
import org.eclipse.papyrus.qompass.designer.ui.dialogs.ConfigurePortDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.InstanceSpecification;
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
			CommandSupport.exec("Configure ports", event, new RunnableWithResult() {

				public CommandResult run() {
					ConfigurePortDialog configureInstanceDialog =
						new ConfigurePortDialog(shell);
					if (configureInstanceDialog.init((Class)element)) {
						configureInstanceDialog.setTitle("Configure ports");
						configureInstanceDialog.setMessage("Configure ports of component " + element.getName());
						configureInstanceDialog.open();
						if(configureInstanceDialog.getReturnCode() == IDialogConstants.OK_ID) {
							return CommandResult.newOKCommandResult();
						}
					}
					return CommandResult.newCancelledCommandResult();
				}
			});
		} else if(element instanceof Port) {
			CommandSupport.exec("Configure ports", event, new RunnableWithResult() {

				public CommandResult run() {
					ConfigurePortDialog configurePortDialog =
						new ConfigurePortDialog(shell);
					if (configurePortDialog.init((Port)element)) {
						configurePortDialog.setTitle("Configure ports");
						configurePortDialog.setMessage("Configure port " + element.getName());
						configurePortDialog.open();
						if(configurePortDialog.getReturnCode() == IDialogConstants.OK_ID) {
							return CommandResult.newOKCommandResult();
						}
					}
					return CommandResult.newCancelledCommandResult();
				}
			});

			
		} else if(element instanceof InstanceSpecification) {

			CommandSupport.exec("Configure instance", event, new RunnableWithResult() {

				public CommandResult run() {
					ConfigureInstanceDialog configureInstanceDialog =
						new ConfigureInstanceDialog(shell);
					if (configureInstanceDialog.init((InstanceSpecification)element)) {
						configureInstanceDialog.setMessage("Configure instance " + element.getName());
						configureInstanceDialog.open();
						if(configureInstanceDialog.getReturnCode() == IDialogConstants.OK_ID) {
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
