/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.uml.modelrepair.handler;

import java.util.Collection;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.core.resource.ModelMultiException;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.utils.DiResourceSet;
import org.eclipse.papyrus.uml.modelrepair.Activator;
import org.eclipse.papyrus.uml.modelrepair.ui.SwitchProfileDialog;
import org.eclipse.papyrus.uml.tools.util.ProfileHelper;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
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

		Object selectedElement = selection.getFirstElement();

		Object selectedAdapter = Platform.getAdapterManager().getAdapter(selectedElement, IFile.class);

		final Shell activeShell = HandlerUtil.getActiveShell(event);

		if(selectedAdapter instanceof IFile) {
			final IFile selectedFile = (IFile)selectedAdapter;

			//Load the model in background and add a user information
			Job openDialogJob = new Job("Switch profile") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					monitor.beginTask("Analyzing model...", IProgressMonitor.UNKNOWN);
					ModelSet modelSet = new DiResourceSet();
					TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain(modelSet);

					IPath workspacePath = selectedFile.getFullPath();

					URI workspaceURI = URI.createPlatformResourceURI(workspacePath.toString(), true);

					try {
						modelSet.loadModels(workspaceURI);

						switchProfilesForModelSet(modelSet, editingDomain, activeShell);
					} catch (ModelMultiException e) {
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

	public void switchProfilesForModelSet(final ModelSet modelSet, final TransactionalEditingDomain editingDomain, final Shell activeShell) {
		EcoreUtil.resolveAll(modelSet);

		final Collection<Profile> allAppliedProfiles = ProfileHelper.getAllAppliedProfiles(modelSet);


		//Go back to the UI thread and open a dialog
		activeShell.getDisplay().asyncExec(new Runnable() {

			public void run() {
				if(allAppliedProfiles.isEmpty()) {
					MessageDialog.openInformation(activeShell, "This model isn't profiled", "The selected model doesn't have any applied profile");
					return;
				}

				SwitchProfileDialog dialog = new SwitchProfileDialog(activeShell, modelSet, editingDomain);
				dialog.open();

				modelSet.unload();
			}
		});

	}


}
