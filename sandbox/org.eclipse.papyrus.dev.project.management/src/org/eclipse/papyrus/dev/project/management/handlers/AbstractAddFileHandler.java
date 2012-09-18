package org.eclipse.papyrus.dev.project.management.handlers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor;
import org.eclipse.swt.widgets.Display;


public abstract class AbstractAddFileHandler extends AbstractHandler {


	public Object execute(final ExecutionEvent event) {

		Job job = new Job(getJobName()) {

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				return runAsJob(monitor);
			}

		};

		job.setUser(true);
		job.schedule();

		return null;
	}

	protected IStatus runAsJob(IProgressMonitor monitor) {
		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

		URL sourceURL = getSourceURL();
		if(sourceURL == null) {
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Cannot find the source file", "The source file is invalid");
		}
		String targetPath = getTargetPath();

		monitor.beginTask(getJobName(), projects.length);

		for(final IProject current : projects) {
			if(current.isOpen() && isValidProject(current)) {
				try {
					if(isValidProject(current)) {
						addFile(current, sourceURL, targetPath);
					}
				} catch (final CoreException e) {
					Activator.log.error(e);
				} catch (final MalformedURLException e) {
					Activator.log.error(e);
				} catch (final IOException e) {
					Activator.log.error(e);
				}
			}

			monitor.worked(1);
		}

		MessageDialog.openInformation(Display.getCurrent().getActiveShell(), getJobName(), "Done.");
		return null;
	}

	//Subclasses should override this
	protected String getJobName() {
		return "Add files";
	}

	protected abstract boolean isValidProject(IProject current);

	protected abstract URL getSourceURL();

	protected abstract String getTargetPath();

	/**
	 * 
	 * @param project
	 *        the project
	 * @param file
	 *        the file to add
	 * @param fileDestinationPath
	 *        the path where add the file
	 * @throws CoreException
	 * @throws IOException
	 */
	protected void addFile(final IProject project, final URL url, final String fileDestinationPath) throws CoreException, IOException {
		Assert.isNotNull(url);
		Assert.isNotNull(fileDestinationPath);
		Assert.isNotNull(project);

		final IProjectEditor editor = new ProjectEditor(project);
		editor.init();
		editor.addFile(url, fileDestinationPath, true);
		editor.save();

	}
}
