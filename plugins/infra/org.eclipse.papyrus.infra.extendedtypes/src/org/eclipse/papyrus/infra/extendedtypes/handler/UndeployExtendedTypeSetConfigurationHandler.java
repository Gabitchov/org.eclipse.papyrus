/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.extendedtypes.handler;

import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
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
import org.eclipse.papyrus.infra.extendedtypes.Activator;
import org.eclipse.papyrus.infra.extendedtypes.ElementTypeSetUtils;
import org.eclipse.papyrus.infra.extendedtypes.ExtendedElementTypeSetRegistry;
import org.eclipse.papyrus.infra.extendedtypes.preferences.ExtendedTypesPreferences;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.statushandlers.StatusManager;


/**
 * @author RS211865
 */
public class UndeployExtendedTypeSetConfigurationHandler extends AbstractHandler {

	/**
	 * {@inheritDoc}
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if(!(currentSelection instanceof IStructuredSelection) || currentSelection.isEmpty()) {
			return null;
		}

		final IStructuredSelection selection = (IStructuredSelection)currentSelection;

		final Shell activeShell = HandlerUtil.getActiveShell(event);

		Job job = new Job("Undeploy extended type set configuration") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Undeploying selected configurations", selection.size());

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

		MultiStatus result = new MultiStatus(Activator.PLUGIN_ID, IStatus.OK, "The extended types configuration has been successfully undeployed", null);

		while(selectionIterator.hasNext()) {
			Object selectedElement = selectionIterator.next();
			if(selectedElement instanceof IAdaptable) {
				IFile selectedFile = (IFile)((IAdaptable)selectedElement).getAdapter(IFile.class);
				if(selectedFile == null) {
					monitor.worked(1);
					result.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selected element is not a file"));
					continue;
				}

				
				String fileName = selectedFile.getFullPath().removeFileExtension().lastSegment();
				monitor.subTask("Deploy " + fileName);

				URI emfURI = null;
				if(selectedFile.getFullPath() != null) {
					emfURI = URI.createPlatformResourceURI(selectedFile.getFullPath().toString(), true);
				} else if(selectedFile.getRawLocation() != null) {
					emfURI = URI.createFileURI(selectedFile.getRawLocation().toString());
				}

				if(emfURI == null) {
					monitor.worked(1);
					result.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "The selected element is not a valid configuration file"));
					continue;
				}

				ExtendedTypesPreferences.unregisterWorkspaceDefinition(fileName);

				monitor.subTask("Reset Element Types Registry");
				ElementTypeSetUtils.resetRegistry();
				monitor.worked(1);
				
				// relaunch papyrus service
				ExtendedElementTypeSetRegistry.getInstance().reset();
				
				result.add(new Status(IStatus.OK, Activator.PLUGIN_ID, "The extended types configuration has been successfully undeployed"));
			}
		}

		if(result.getChildren().length == 1) {
			return result.getChildren()[0];
		} else { //Merge the result and specify an appropriate message based on the result
			if(result.isOK()) {
				return result;
			} else {
				MultiStatus actualResult = new MultiStatus(Activator.PLUGIN_ID, result.getCode(), "Some errors occurred during the undeployment", result.getException());
				actualResult.merge(result);
				return actualResult;
			}
		}
	}
}
