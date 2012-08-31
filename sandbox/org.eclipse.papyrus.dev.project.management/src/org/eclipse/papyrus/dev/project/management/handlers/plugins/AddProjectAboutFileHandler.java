package org.eclipse.papyrus.dev.project.management.handlers.plugins;

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

//TODO should be covered with JUnit test
public class AddProjectAboutFileHandler extends AbstractAddFileHandler {

	public static final String ABOUT_HTML_SOURCE_PATH = "/resources/about.html.file"; //$NON-NLS-1$

	public static final String ABOUT_HTML_PATH = "about.html"; //$NON-NLS-1$

	private static URL about_url;

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
		for(final IProject current : projects) {
			if(current.isOpen()) {
				try {
					if(current.hasNature(Utils.PLUGIN_NATURE)) {
						if(about_url == null) {
							about_url = new URL("platform:/plugin/" + Activator.PLUGIN_ID + ABOUT_HTML_SOURCE_PATH); //$NON-NLS-1$
						}
						addFile(current, about_url, ABOUT_HTML_PATH);

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
