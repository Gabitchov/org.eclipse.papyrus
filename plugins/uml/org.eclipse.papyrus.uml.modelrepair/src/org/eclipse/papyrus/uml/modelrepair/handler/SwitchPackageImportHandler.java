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

import java.io.IOException;
import java.util.Set;

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
import org.eclipse.papyrus.infra.core.lifecycleevents.ISaveAndDirtyService;
import org.eclipse.papyrus.infra.core.resource.ModelSet;
import org.eclipse.papyrus.infra.core.services.ServiceException;
import org.eclipse.papyrus.infra.emf.utils.EMFHelper;
import org.eclipse.papyrus.infra.emf.utils.ServiceUtilsForEObject;
import org.eclipse.papyrus.uml.modelrepair.Activator;
import org.eclipse.papyrus.uml.modelrepair.ui.SwitchPackageImportDialog;
import org.eclipse.papyrus.uml.tools.util.LibraryHelper;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageImport;

/**
 * A Handler to switch libraries referenced by Package imports (e.g. Local to Registered version)
 * 
 */
public class SwitchPackageImportHandler extends AbstractHandler {

	public Object execute(final ExecutionEvent event) throws ExecutionException {

		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection.isEmpty() || !(currentSelection instanceof IStructuredSelection)) {
			return null;
		}

		IStructuredSelection selection = (IStructuredSelection) currentSelection;

		EObject selectedAdapter = EMFHelper.getEObject(selection.getFirstElement());

		final Shell activeShell = HandlerUtil.getActiveShell(event);

		if (activeShell == null) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Impossible to find the active shell for switch package import");
		}

		if (selectedAdapter instanceof Package) {
			final Package selectedPackage = (Package) selectedAdapter;

			// Load the model in background and add a user information
			Job openDialogJob = new Job("Switch package imports") {

				protected IStatus status = Status.OK_STATUS;
				
				protected boolean needSave = false;

				@Override
				protected IStatus run(final IProgressMonitor monitor) {
					monitor.beginTask("Analyzing model", IProgressMonitor.UNKNOWN);

					try {
						// Try first to have a model which is not dirty.
						// In order not to have inconsistency, this is better that the model is not dirty. For example, the package import to switch should not be dirty
						final ModelSet modelSet = ServiceUtilsForEObject.getInstance().getModelSet(selectedPackage);
						final TransactionalEditingDomain editingDomain = modelSet.getTransactionalEditingDomain();

						final ISaveAndDirtyService saveAndDirtyService = ServiceUtilsForEObject.getInstance().getService(ISaveAndDirtyService.class, selectedPackage);

						if (saveAndDirtyService.isDirty()) {
							needSave = true;
							activeShell.getDisplay().syncExec(new Runnable() {

								public void run() {
									// pop-up a message to check if save should be performed or if action should be cancelled
									boolean openQuestion = MessageDialog
											.openQuestion(activeShell, "Switch package import", "Model should be saved before switching package imports. Would you like to save it now? \nOperation will be cancelled if you press no.");
									if (!openQuestion) {
										status = Status.CANCEL_STATUS;
									}
								}
							});

						}

						if (!status.isOK()) {
							return status;
						}
						
						if(needSave) {
							saveAndDirtyService.doSave(monitor);
						}

						switchLibrariesForModelSet(selectedPackage, modelSet, editingDomain, activeShell, monitor);
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

	public void switchLibrariesForModelSet(final Package profiledPackage, final ModelSet modelSet, final TransactionalEditingDomain editingDomain, final Shell activeShell, final IProgressMonitor monitor) {
		monitor.subTask("Resolve all proxies...");
		EcoreUtil.resolveAll(modelSet);
		monitor.subTask("Open package import management dialog...");

		final Set<PackageImport> allImportedPackages = LibraryHelper.getAllImportedPackages(modelSet);


		// Go back to the UI thread and open a dialog
		activeShell.getDisplay().asyncExec(new Runnable() {

			public void run() {
				if (allImportedPackages.isEmpty()) {
					MessageDialog.openInformation(activeShell, "Switch Libraries", "The selected model has no Package Imports.");
					return;
				}

				try {
					SwitchPackageImportDialog dialog = new SwitchPackageImportDialog(activeShell, modelSet, editingDomain);
					dialog.open();
				} catch (ServiceException e) {
					StatusManager.getManager().handle(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Failed to open package import switching dialog.", e), StatusManager.SHOW);
				}
			}
		});

	}


}
