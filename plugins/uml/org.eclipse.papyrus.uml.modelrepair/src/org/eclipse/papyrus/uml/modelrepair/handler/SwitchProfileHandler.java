/*****************************************************************************
 * Copyright (c) 2013, 2014 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 408491
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelrepair.handler;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.modelrepair.Activator;
import org.eclipse.papyrus.uml.modelrepair.ui.SwitchProfileDialog;
import org.eclipse.papyrus.uml.tools.util.ProfileHelper;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.Profile;

/**
 * A Handler to switch for profile versions (e.g. Local to Registered version)
 * 
 * @author Camille Letavernier
 * 
 */
public class SwitchProfileHandler extends AbstractHandler {

	public Object execute(final ExecutionEvent event) throws ExecutionException {

		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if(currentSelection.isEmpty() || !(currentSelection instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection selection = (IStructuredSelection)currentSelection;

		EObject selectedAdapter = EMFHelper.getEObject(selection.getFirstElement());

		final Shell activeShell = HandlerUtil.getActiveShell(event);

		if(selectedAdapter instanceof Package) {
			final Package selectedPackage = (Package)selectedAdapter;

			//Load the model in background and add a user information
			Job openDialogJob = new Job("Switch profiles") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					monitor.beginTask("Analyzing model...", IProgressMonitor.UNKNOWN);

					try {
						final ModelSet modelSet = ServiceUtilsForEObject.getInstance().getModelSet(selectedPackage);
						final TransactionalEditingDomain editingDomain = modelSet.getTransactionalEditingDomain();

						switchProfilesForModelSet(selectedPackage, modelSet, editingDomain, activeShell);
					} catch (ServiceException e) {
						Activator.log.error(e);
						return new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e);
					}

					return Status.OK_STATUS;
				}
			};

			openDialogJob.setUser(true);

			openDialogJob.schedule();
		}

		return null;
	}

	public void switchProfilesForModelSet(final Package profiledPackage, final ModelSet modelSet, final TransactionalEditingDomain editingDomain, final Shell activeShell) {
		EcoreUtil.resolveAll(modelSet);

		final Collection<Profile> allAppliedProfiles = ProfileHelper.getAllAppliedProfiles(modelSet);


		//Go back to the UI thread and open a dialog
		activeShell.getDisplay().asyncExec(new Runnable() {

			public void run() {
				if(allAppliedProfiles.isEmpty()) {
					MessageDialog.openInformation(activeShell, "Switch Profiles", "The selected model has no profiles applied.");
					return;
				}

				try {
					SwitchProfileDialog dialog = new SwitchProfileDialog(activeShell, modelSet, editingDomain);
					dialog.open();
				} catch (ServiceException e) {
					StatusManager.getManager().handle(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to open profile switching dialog.", e), StatusManager.SHOW);
				}
			}
		});

	}


}
