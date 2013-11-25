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
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Connector;
import org.eclipse.uml2.uml.Feature;
import org.eclipse.uml2.uml.InstanceSpecification;
import org.eclipse.uml2.uml.NamedElement;
import org.eclipse.uml2.uml.Property;

/**
 * Implementation class for ClassAction action
 */
public class ConfigureInstanceHandler extends CmdHandler {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		updateSelectedEObject();
		if((selectedEObject instanceof Class) ||
			(selectedEObject instanceof Connector) ||
			(selectedEObject instanceof Property) ||
			(selectedEObject instanceof InstanceSpecification)) {
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
		final ExecutionEvent from = event;
		
		// 1. select possible connectors according to port types
		// (only show compatible connectors check-box?)
		// 2. select implementation group according to connector type

		if(element instanceof Class) {
			// container dialog: either extension, rule or interceptor
			// how-to select? which? (and how-to add/remove?) - is standard dialog sufficient?
			CommandSupport.exec("Configure associated component instance", event, new RunnableWithResult() { //$NON-NLS-1$

				public CommandResult run() {
					ConfigureInstanceDialog configureInstanceDialog =
						new ConfigureInstanceDialog(shell);
					if (configureInstanceDialog.init((Class)element, from)) {
						configureInstanceDialog.setTitle("Configure instance"); //$NON-NLS-1$
						configureInstanceDialog.setMessage("Configure instance for component " + element.getName()); //$NON-NLS-1$
						configureInstanceDialog.open();
						if(configureInstanceDialog.getReturnCode() == IDialogConstants.OK_ID) {
							return CommandResult.newOKCommandResult();
						}
					}
					return CommandResult.newCancelledCommandResult();
				}
			});
		} else if(element instanceof Feature) {
			CommandSupport.exec("Configure associated instance", event, new RunnableWithResult() { //$NON-NLS-1$

				public CommandResult run() {
					ConfigureInstanceDialog configureInstanceDialog =
						new ConfigureInstanceDialog(shell);
					if (configureInstanceDialog.init((Feature)element, from)) {
						configureInstanceDialog.setTitle("Configure instance"); //$NON-NLS-1$
						configureInstanceDialog.setMessage("Configure instance for property/connector " + element.getName()); //$NON-NLS-1$
						configureInstanceDialog.open();
						if(configureInstanceDialog.getReturnCode() == IDialogConstants.OK_ID) {
							return CommandResult.newOKCommandResult();
						}
					}
					return CommandResult.newCancelledCommandResult();
				}
			});

			
		} else if(element instanceof InstanceSpecification) {

			CommandSupport.exec("Configure instance", event, new RunnableWithResult() { //$NON-NLS-1$

				public CommandResult run() {
					ConfigureInstanceDialog configureInstanceDialog =
						new ConfigureInstanceDialog(shell);
					if (configureInstanceDialog.init((InstanceSpecification)element, from)) {
						configureInstanceDialog.setMessage("Configure instance " + element.getName()); //$NON-NLS-1$
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
