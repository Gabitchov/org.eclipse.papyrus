/*
 * Copyright (c) 2014 CEA and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Christian W. Damus (CEA) - Initial API and implementation
 *
 */
package org.eclipse.papyrus.uml.modelrepair.internal.validation;

import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.window.Window;
import org.eclipse.papyrus.uml.modelrepair.Activator;
import org.eclipse.papyrus.uml.modelrepair.validation.IProfileSwitchPrecondition;
import org.eclipse.papyrus.uml.modelrepair.validation.ProfileSwitchContext;
import org.eclipse.swt.widgets.Composite;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;


/**
 * This is the ProfileSwitchValidator type. Enjoy.
 */
public class ProfileSwitchValidator {

	private static final String EXT_PT = "profileSwitchPreconditions"; //$NON-NLS-1$

	private static final String E_PRECONDITION = "precondition"; //$NON-NLS-1$

	private static final String A_CLASS = "class"; //$NON-NLS-1$

	private final List<IProfileSwitchPrecondition> preconditions;

	public ProfileSwitchValidator() {
		super();

		preconditions = loadPreconditions();
	}

	public boolean validate(final ProfileSwitchContext ctx) {
		final boolean[] result = { true };

		if(!preconditions.isEmpty()) {
			List<IStatus> statuses = Lists.newArrayListWithCapacity(preconditions.size());

			for(IProfileSwitchPrecondition next : preconditions) {
				try {
					IStatus status = next.validateProfileSwitch(ctx);

					if((status != null) && !status.isOK()) {
						statuses.add(status);
					}
				} catch (Exception e) {
					Activator.log.error("Uncaught exception in profile switch pre-condition.", e); //$NON-NLS-1$
				}
			}

			final IStatus status = statuses.isEmpty() ? Status.OK_STATUS : (statuses.size() == 1) ? statuses.get(0) : new MultiStatus(Activator.PLUGIN_ID, 0, Iterables.toArray(statuses, IStatus.class), "Problems in profile switch initial conditions check.", null);

			switch(status.getSeverity()) {
			case IStatus.OK:
			case IStatus.INFO:
				// All's well.  Don't bother the user.
				break;
			case IStatus.WARNING:
				// Get confirmation before proceeding
				final ErrorDialog dlg = new ErrorDialog(ctx.getShell(), "Profile Switch", "Profile switch initial conditions check found problems in the model that may cause the switch to fail or be incomplete.  Are you sure you want to proceed?", status, IStatus.INFO | IStatus.WARNING) {

					@Override
					protected void createButtonsForButtonBar(Composite parent) {
						createDetailsButton(parent);
						createButton(parent, IDialogConstants.YES_ID, IDialogConstants.YES_LABEL, false);
						createButton(parent, IDialogConstants.NO_ID, IDialogConstants.NO_LABEL, true);
					}

					@Override
					protected void buttonPressed(int id) {
						switch(id) {
						case IDialogConstants.YES_ID:
							setReturnCode(OK);
							close();
							break;
						case IDialogConstants.NO_ID:
							setReturnCode(CANCEL);
							close();
							break;
						default:
							super.buttonPressed(id);
							break;
						}
					}
				};

				ctx.getShell().getDisplay().syncExec(new Runnable() {

					public void run() {
						result[0] = dlg.open() == Window.OK;
					}
				});
				break;
			default:
				// Errors.  Don't proceed
				ctx.getShell().getDisplay().syncExec(new Runnable() {

					public void run() {
						result[0] = false;
						ErrorDialog.openError(ctx.getShell(), "Profile Switch", "Profile switch cannot be performed until problems in the model are corrected.", status);
					}
				});
				break;
			}
		}

		return result[0];
	}

	private static List<IProfileSwitchPrecondition> loadPreconditions() {
		List<IProfileSwitchPrecondition> result = Lists.newArrayList();

		for(IConfigurationElement next : Platform.getExtensionRegistry().getConfigurationElementsFor(Activator.PLUGIN_ID, EXT_PT)) {
			if(E_PRECONDITION.equals(next.getName())) {
				try {
					result.add((IProfileSwitchPrecondition)next.createExecutableExtension(A_CLASS));
				} catch (Exception e) {
					Activator.log.error("Invalid profile switch precondition extension in bundle " + next.getContributor().getName(), e); //$NON-NLS-1$
				}
			}
		}

		return result;
	}
}
