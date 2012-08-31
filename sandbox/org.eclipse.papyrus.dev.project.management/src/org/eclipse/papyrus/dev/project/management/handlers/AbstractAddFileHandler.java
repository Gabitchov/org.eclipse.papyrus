package org.eclipse.papyrus.dev.project.management.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;


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

		final IFile targetFile = project.getFile(new Path(fileDestinationPath)); //TODO add the possibility to erase the file
		if(targetFile.exists()) {
			return;
		}

		final InputStream is = url.openStream();;

		targetFile.create(is, false, new NullProgressMonitor());
		is.close();
		targetFile.refreshLocal(IResource.DEPTH_ZERO, new NullProgressMonitor());
	}
}
