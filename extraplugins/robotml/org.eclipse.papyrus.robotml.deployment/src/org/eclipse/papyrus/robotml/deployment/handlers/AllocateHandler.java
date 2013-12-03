/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Saadia Dhouib (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *****************************************************************************/

package org.eclipse.papyrus.robotml.deployment.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.uml2.uml.Package;
import org.eclipse.papyrus.RobotML.DeploymentPlan;
import org.eclipse.papyrus.robotml.deployment.CommandSupport;
import org.eclipse.papyrus.robotml.deployment.DepUtils;
import org.eclipse.papyrus.robotml.deployment.RunnableWithResult;
import org.eclipse.papyrus.robotml.deployment.StUtils;
import org.eclipse.papyrus.robotml.deployment.dialog.AllocationDialog;

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
	public Object execute(ExecutionEvent event) {
		if(!(getSelectedEObject() instanceof Package)) {
			return null;
		}

		final Package cdp = (Package)getSelectedEObject();
		final Shell shell = new Shell();

		// com.cea.ec3m.vsl.ParseVSL.test();
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
