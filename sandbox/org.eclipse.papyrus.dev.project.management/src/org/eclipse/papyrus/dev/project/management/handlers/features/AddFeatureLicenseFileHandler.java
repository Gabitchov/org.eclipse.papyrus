package org.eclipse.papyrus.dev.project.management.handlers.features;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.papyrus.dev.project.management.handlers.AbstractAddFileHandler;
import org.eclipse.papyrus.dev.project.management.utils.Utils;
import org.eclipse.swt.widgets.Display;


public class AddFeatureLicenseFileHandler extends AbstractAddFileHandler {

	public static final String LICENSE_HTML_SOURCE_PATH = "/resources/license.html.file"; //$NON-NLS-1$

	public static final String LICENSE_HTML_PATH = "license.html"; //$NON-NLS-1$

	private static URL license_url;

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for(final IProject current : projects) {
			if(current.isOpen()) {
				try {
					if(current.hasNature(Utils.FEATURE_NATURE)) {
						if(license_url == null) {
							license_url = new URL("platform:/plugin/" + Activator.PLUGIN_ID + LICENSE_HTML_SOURCE_PATH); //$NON-NLS-1$
						}
						addFile(current, license_url, LICENSE_HTML_PATH);

					}
				} catch (final CoreException e) {
					Activator.log.error(e);
				} catch (final MalformedURLException e) {
					Activator.log.error(e);
				} catch (final IOException e) {
					Activator.log.error(e);
				}
			}
		}
		new MessageDialog(Display.getCurrent().getActiveShell(), "Add about.html file", null, "Done.", MessageDialog.INFORMATION, new String[]{ "OK" }, 0).open();
		return null;
	}
}
