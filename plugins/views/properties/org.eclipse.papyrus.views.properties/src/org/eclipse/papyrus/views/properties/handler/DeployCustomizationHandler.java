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
package org.eclipse.papyrus.views.properties.handler;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;


/**
 * Handles the Deploy Properties View Configuration command
 * 
 * Deploys the selected Properties view configuration (*.ctx file) into the current workspace
 * 
 * @author Camille Letavernier
 * 
 */
public class DeployCustomizationHandler extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if(!(currentSelection instanceof IStructuredSelection) || currentSelection.isEmpty()) {
			return null;
		}

		final IStructuredSelection selection = (IStructuredSelection)currentSelection;

		final Shell activeShell = HandlerUtil.getActiveShell(event);

		Job job = new Job("Deploy properties view configuration") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Deploying selected configurations", selection.size());

				return doExecute(selection, monitor);
			}
		};

		job.addJobChangeListener(new JobChangeAdapter() {

			@Override
			public void done(final IJobChangeEvent event) {
				activeShell.getDisplay().asyncExec(new Runnable() {

					public void run() {
						if(event.getResult().isOK()) {
							MessageDialog.openInformation(activeShell, "Success", event.getResult().getMessage());
						} else if(event.getResult().getSeverity() < IStatus.ERROR) { //Errors are already logged
							StatusManager.getManager().handle(event.getResult(), StatusManager.SHOW);
						}
					}
				});
			}
		});

		job.setUser(true);
		job.schedule();

		return null;
	}

	protected IStatus doExecute(IStructuredSelection selection, IProgressMonitor monitor) {
		Iterator<?> selectionIterator = selection.iterator();

		MultiStatus result = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, "The properties view configuration has been successfully deployed and activated", null);

		while(selectionIterator.hasNext()) {
			Object selectedElement = selectionIterator.next();
			if(selectedElement instanceof IAdaptable) {
				IFile selectedFile = (IFile)((IAdaptable)selectedElement).getAdapter(IFile.class);
				if(selectedFile == null) {
					monitor.worked(1);
					result.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selected element is not a file"));
					continue;
				}

				monitor.subTask("Deploy " + selectedFile.getFullPath().removeFileExtension().lastSegment());

				URI emfURI = null;
				if(selectedFile.getFullPath() != null) {
					emfURI = URI.createPlatformResourceURI(selectedFile.getFullPath().toString(), true);
				} else if(selectedFile.getRawLocation() != null) {
					emfURI = URI.createFileURI(selectedFile.getRawLocation().toString());
				}

				if(emfURI == null) {
					monitor.worked(1);
					result.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selected element is not a valid properties view configuration"));
					continue;
				}

				try {
					Context context = ConfigurationManager.getInstance().getContext(emfURI);
					if(context == null) {
						monitor.worked(1);
						result.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selected element doesn't contain a valid Properties view configuration"));
						continue;
					}

					if(ConfigurationManager.getInstance().getContexts().contains(context)) {
						monitor.worked(1);
						result.add(new Status(IStatus.WARNING, Activator.PLUGIN_ID, "The selected configuration is already deployed"));
						continue;
					}

					ConfigurationManager.getInstance().addContext(context, true, true);
				} catch (Exception ex) {
					result.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "An error occurred during the deployment", ex));
					monitor.worked(1);
					continue;
				}

				monitor.worked(1);
				result.add(new Status(IStatus.OK, Activator.PLUGIN_ID, "The properties view configuration has been successfully deployed and activated"));
			}
		}

		if(result.getChildren().length == 1) {
			return result.getChildren()[0];
		} else { //Merge the result and specify an appropriate message based on the result
			if(result.isOK()) {
				return result;
			} else {
				MultiStatus actualResult = new MultiStatus(Activator.PLUGIN_ID, result.getCode(), "Some errors occurred during the deployment", result.getException());
				actualResult.merge(result);
				return actualResult;
			}
		}
	}
}
