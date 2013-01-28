/*******************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are property of the CEA, their use is subject to specific agreement 
 * with the CEA.
 * 
 * Contributors:
 *    CEA LIST - initial API and implementation
 *******************************************************************************/

package org.eclipse.papyrus.qompass.designer.core.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Package;

import FCM.DeploymentPlan;

import org.eclipse.papyrus.qompass.designer.core.CommandSupport;
import org.eclipse.papyrus.qompass.designer.core.RunnableWithResult;
import org.eclipse.papyrus.qompass.designer.core.StUtils;
import org.eclipse.papyrus.qompass.designer.core.deployment.DepUtils;
import org.eclipse.papyrus.qompass.designer.core.dialogs.AllocationDialog;

/**
 * Implementation class for ClassAction action
 */
public class AllocateHandler extends CmdHandler {

	/**
	 * {@inheritDoc}
	 */
	public boolean isEnabled() {
		updateSelectedEObject();
		EObject selectedObj = getSelectedEObject();
		if(selectedObj instanceof Package) {
			return (StUtils.isApplied((Package)selectedObj, DeploymentPlan.class));
		}
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event)
		throws ExecutionException {
		if(!(getSelectedEObject() instanceof Package)) {
			return null;
		}

		final Package cdp = (Package)getSelectedEObject();
		final Shell shell = new Shell();

		// org.eclipse.papyrus.qompass.designer.vsl.ParseVSL.test();
		if(DepUtils.getMainInstance(cdp) == null) {
			MessageDialog.openInformation(shell, "Error",
				"Deployment plan has no main instance (check stereotype attribute mainInstance)");
			return null;
		}

		// 1. select possible connectors according to port types
		// (only show compatible connectors check-box?)
		// 2. select implementation group according to connector type

		// container dialog: either extension, rule or interceptor
		// howto select? which? (and howto add/remove?) - Std - dialog is good?
		CommandSupport.exec("Instance allocation", new RunnableWithResult() {

			public CommandResult run() {
				AllocationDialog allocDialog =
					new AllocationDialog(shell, cdp);
				allocDialog.setTitle("Allocate instances");
				allocDialog.open();
				if(allocDialog.getReturnCode() == IDialogConstants.OK_ID) {
					return CommandResult.newOKCommandResult();
				}
				else {
					return CommandResult.newCancelledCommandResult();
				}
			}
		});

		return null;
	}
}
