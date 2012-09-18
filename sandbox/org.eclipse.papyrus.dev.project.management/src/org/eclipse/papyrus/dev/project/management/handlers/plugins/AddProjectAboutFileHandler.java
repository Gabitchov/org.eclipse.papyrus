package org.eclipse.papyrus.dev.project.management.handlers.plugins;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.papyrus.dev.project.management.handlers.AbstractAddFileHandler;
import org.eclipse.papyrus.dev.project.management.utils.Utils;

//TODO should be covered with JUnit test
public class AddProjectAboutFileHandler extends AbstractAddFileHandler {

	public static final String ABOUT_HTML_SOURCE_PATH = "/resources/about.html.file"; //$NON-NLS-1$

	public static final String ABOUT_HTML_PATH = "about.html"; //$NON-NLS-1$

	@Override
	protected boolean isValidProject(IProject current) {
		try {
			return current.hasNature(Utils.PLUGIN_NATURE);
		} catch (CoreException ex) {
			Activator.log.error(ex);
		}
		return false;
	}

	@Override
	protected URL getSourceURL() {
		try {
			return new URL("platform:/plugin/" + Activator.PLUGIN_ID + ABOUT_HTML_SOURCE_PATH);
		} catch (MalformedURLException ex) {
			Activator.log.error(ex);
		}
		return null;
	}

	@Override
	protected String getTargetPath() {
		return ABOUT_HTML_PATH;
	}

	@Override
	protected String getJobName() {
		return "Add about.html file";
	}
}
