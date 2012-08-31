package org.eclipse.papyrus.dev.project.management.handlers;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor;


public abstract class AbstractAddFileHandler extends AbstractHandler {

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
