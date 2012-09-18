package org.eclipse.papyrus.dev.project.management.handlers.features;

import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.papyrus.dev.project.management.handlers.AbstractAddFileHandler;
import org.eclipse.papyrus.dev.project.management.utils.Utils;


public class AddFEPLFileHandler extends AbstractAddFileHandler {

	public static final String EPL_HTML_SOURCE_PATH = "/resources/epl-v10.html.file"; //$NON-NLS-1$

	public static final String EPL_HTML_PATH = "epl-v10.html"; //$NON-NLS-1$

	@Override
	protected boolean isValidProject(IProject current) {
		try {
			return current.hasNature(Utils.FEATURE_NATURE);
		} catch (CoreException ex) {
			Activator.log.error(ex);
		}
		return false;
	}

	@Override
	protected URL getSourceURL() {
		try {
			return new URL("platform:/plugin/" + Activator.PLUGIN_ID + EPL_HTML_SOURCE_PATH); //$NON-NLS-1$
		} catch (MalformedURLException ex) {
			Activator.log.error(ex);
		}
		return null;
	}

	@Override
	protected String getTargetPath() {
		return EPL_HTML_PATH;
	}

	@Override
	protected String getJobName() {
		return "Add EPL file";
	}
}
