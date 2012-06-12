/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.model.migration.handler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.papyrus.views.properties.model.migration.Activator;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;


public class MigrationHandler extends AbstractHandler {

	public static final String ContextExtension = "ctx";

	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench == null) {
			return null;
		}

		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		if(window == null) {
			return null;
		}

		ISelection selection = window.getSelectionService().getSelection();
		if(!(selection instanceof IStructuredSelection)) {
			return null;
		}

		final IStructuredSelection structuredSelection = (IStructuredSelection)selection;

		Job migrationJob = new Job("Migrate selected files") {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask(getName(), structuredSelection.size());

				Iterator<?> iterator = structuredSelection.iterator();
				while(iterator.hasNext()) {
					Object selectedElement = iterator.next();
					if(selectedElement instanceof IFile) {
						IFile selectedFile = (IFile)selectedElement;
						monitor.subTask("Migrating " + selectedFile.getName());

						if(ContextExtension.equals(selectedFile.getFileExtension())) {
							migrateFile(selectedFile);
						}
					}
					monitor.worked(1);
				}

				monitor.done();
				return Status.OK_STATUS;
			}
		};

		migrationJob.setUser(true);
		migrationJob.schedule();

		return null;
	}

	private static void migrateFile(IFile file) {
		//Ctx files weight between 4 and 400 kB, so it's probably ok to read their contents into a String
		try {
			InputStream stream = file.getContents();
			String charset = file.getContentDescription().getCharset();

			InputStreamReader reader = new InputStreamReader(stream, charset);

			StringBuilder builder = new StringBuilder();
			char[] buffer = new char[4096];

			int result;
			while((result = reader.read(buffer)) != -1) {
				builder.append(buffer, 0, result);
			}

			String contents = builder.toString();

			contents = contents.replaceAll("xmlns:contexts=\"http://www.eclipse.org/papyrus/properties/contexts\"", "xmlns:contexts=\"http://www.eclipse.org/papyrus/properties/contexts/0.9\"");

			contents = contents.replaceAll("contexts:CompositeConstraint", "constraints:CompositeConstraint");
			contents = contents.replaceAll("contexts:SimpleConstraint", "constraints:SimpleConstraint");
			contents = contents.replaceAll("contexts:ValueProperty", "constraints:ValueProperty");
			contents = contents.replaceAll("contexts:ReferenceProperty", "constraints:ReferenceProperty");

			if(!contents.contains("xmlns:constraints=")) {
				String source = "xmlns:contexts=\"http://www.eclipse.org/papyrus/properties/contexts/0.9\"";
				String target = source + "\n\txmlns:constraints=\"http://www.eclipse.org/papyrus/constraints/0.9\"";
				contents = contents.replace(source, target);
			}

			file.setContents(new ByteArrayInputStream(contents.getBytes(charset)), true, true, new NullProgressMonitor());
		} catch (IOException ex) {
			Activator.log.error(ex);
		} catch (CoreException ex) {
			Activator.log.error(ex);
		}
	}
}
