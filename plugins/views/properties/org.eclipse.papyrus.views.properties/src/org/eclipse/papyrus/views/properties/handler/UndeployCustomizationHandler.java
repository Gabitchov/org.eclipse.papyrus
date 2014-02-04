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
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.IJobChangeEvent;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.JobChangeAdapter;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.views.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.runtime.ConfigurationManager;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;


public class UndeployCustomizationHandler extends AbstractHandler implements IHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {

		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if(!(currentSelection instanceof IStructuredSelection) || currentSelection.isEmpty()) {
			return null;
		}

		final IStructuredSelection selection = (IStructuredSelection)currentSelection;

		final Shell activeShell = HandlerUtil.getActiveShell(event);


		Job undeploy = new Job("Disabling properties view configuration") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				IStatus result = doExecute(selection, monitor);
				if(result.isOK()) {
					monitor.subTask("Refreshing properties view configuration");
					ConfigurationManager.getInstance().update();
				}
				return result;
			};

		};

		undeploy.addJobChangeListener(new JobChangeAdapter() {

			@Override
			public void done(final IJobChangeEvent event) {
				activeShell.getDisplay().asyncExec(new Runnable() {

					public void run() {
						if(event.getResult().isOK()) {
							MessageDialog.openInformation(activeShell, "Success", event.getResult().getMessage());
						} else {
							MessageDialog.openWarning(activeShell, "Error", event.getResult().getMessage());
						}
					}
				});
			}
		});


		undeploy.setUser(true);
		undeploy.schedule();

		return null;
	}

	protected IStatus doExecute(IStructuredSelection selection, IProgressMonitor monitor) {
		Iterator<?> selectionIterator = selection.iterator();

		//Update is a long running task. Do it only once, in a job, at the end of the action.
		boolean needsUpdate = false;

		monitor.beginTask("Disabling configurations", selection.size());

		while(selectionIterator.hasNext()) {
			Object selectedElement = selectionIterator.next();
			if(selectedElement instanceof IAdaptable) {
				IFile selectedFile = (IFile)((IAdaptable)selectedElement).getAdapter(IFile.class);
				if(selectedFile == null) {
					monitor.worked(1);
					continue;
				}

				monitor.subTask("Disable " + selectedFile.getFullPath().removeFileExtension().lastSegment());

				URI emfURI = null;
				if(selectedFile.getFullPath() != null) {
					emfURI = URI.createPlatformResourceURI(selectedFile.getFullPath().toString(), true);
				} else if(selectedFile.getRawLocation() != null) {
					emfURI = URI.createFileURI(selectedFile.getRawLocation().toString());
				}

				if(emfURI == null) {
					monitor.worked(1);
					continue;
				}

				try {

					for(Context deployedContext : ConfigurationManager.getInstance().getContexts()) {
						if(ConfigurationManager.getInstance().isCustomizable(deployedContext)) { //Should always be true
							if(EcoreUtil.getURI(deployedContext).trimFragment().equals(emfURI)) {
								ConfigurationManager.getInstance().deleteContext(deployedContext, false);
								needsUpdate = true;
								break;
							}
						}
					}

					monitor.worked(1);
				} catch (Exception ex) {
					Activator.log.error(ex);
				}
			}
		}

		if(needsUpdate) {
			return new Status(IStatus.OK, Activator.PLUGIN_ID, "The selected properties view configuration has been successfully disabled");
		} else {
			return new Status(IStatus.WARNING, Activator.PLUGIN_ID, "The selected properties view configuration is not deployed");
		}
	}

}
