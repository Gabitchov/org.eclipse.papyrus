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
package org.eclipse.papyrus.infra.psf.handler;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.AbstractOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.infra.psf.Activator;
import org.eclipse.papyrus.infra.psf.runtime.ImportResult;
import org.eclipse.papyrus.infra.psf.runtime.ProjectSetImporter;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;


public class ImportPSF extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		final Shell activeShell = HandlerUtil.getActiveShell(event);
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);

		if(currentSelection instanceof IStructuredSelection) {
			IStructuredSelection selection = (IStructuredSelection)currentSelection;
			if(selection.isEmpty()) {
				return null;
			}

			Iterator<?> selectionIterator = selection.iterator();
			while(selectionIterator.hasNext()) {
				Object selectedElement = selectionIterator.next();
				IFile file = (IFile)Platform.getAdapterManager().getAdapter(selectedElement, IFile.class);
				if(file != null && "psf".equals(file.getLocation().getFileExtension())) {
					final String fileName = file.getLocation().toString();

					Job job = new Job("Import " + file.getName()) {

						@Override
						protected IStatus run(IProgressMonitor monitor) {
							AbstractOperation operation = new ImportProjectSetOperation(getName(), fileName, activeShell);

							try {
								IStatus result = OperationHistoryFactory.getOperationHistory().execute(operation, monitor, null);

								if(monitor.isCanceled() || result.getSeverity() == IStatus.CANCEL) {
									//TODO
								}

								if(result.isOK()) {
									return result;
								}

								if(result.getSeverity() == IStatus.WARNING) {
									//TODO
								}

								if(result.getSeverity() == IStatus.ERROR) {
									//TODO
								}

								return result;
							} catch (ExecutionException ex) {
								Activator.log.error(ex);
								return new Status(IStatus.ERROR, Activator.PLUGIN_ID, ex.getMessage(), ex);
							}
						}
					};

					job.setUser(true);
					job.schedule();

					job.setPriority(Job.LONG);

				}
			}
		}

		return null;
	}

	public static class ImportProjectSetOperation extends AbstractOperation {

		private String psfFileName;

		private IProject[] importedProjects;

		private Shell shell;

		public ImportProjectSetOperation(String name, String psfFileName, Shell shell) {
			super(name);
			this.psfFileName = psfFileName;
			this.shell = shell;
		}

		@Override
		public IStatus undo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			if(importedProjects == null || importedProjects.length == 0) {
				return Status.OK_STATUS;
			}
			for(IProject project : importedProjects) {
				try {
					project.delete(false, true, monitor);
				} catch (CoreException e) {
					throw new ExecutionException(e.getMessage(), e);
				}
			}
			return Status.OK_STATUS;
		}

		@Override
		public IStatus redo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			return execute(monitor, info);
		}

		@Override
		public IStatus execute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
			try {
				ImportResult result = ProjectSetImporter.importProjectSet(psfFileName, shell, monitor);
				importedProjects = result.getImportedProjects();
				return Status.OK_STATUS;
			} catch (InvocationTargetException ex) {
				Activator.log.error(ex);
				//Report
			}
			return Status.OK_STATUS;
		}
	}
}
