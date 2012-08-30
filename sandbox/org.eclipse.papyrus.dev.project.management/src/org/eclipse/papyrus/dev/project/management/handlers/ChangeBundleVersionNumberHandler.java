package org.eclipse.papyrus.dev.project.management.handlers;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.papyrus.dev.project.management.dialog.InputDialogWithCheckBox;
import org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IFeatureProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.project.FeatureProjectEditor;
import org.eclipse.swt.widgets.Display;
import org.xml.sax.SAXException;

public class ChangeBundleVersionNumberHandler extends AbstractHandler {

	private static final String TITLE = "Enter the new version number for Papyrus plugin.";

	private static final String MESSAGE = "Enter the new version number. This action works for : \n - plugin\n - fragment";

	private static final String INITIAL_VALUE = "0.0.0.qualifier";

	private static final String CHECKBOX_MESSAGE = "Only projects beginning with 'org.eclipse.papyrus.*'";

	private static final String WARNING_DIALOG_TITLE = "Change Version Name Report";

	private static final String WARNING_DIALOG_MESSAGE = "The following project were NOT managed : ";

	private static final String WARNING_DIALOG_MESSAGE2 = "Done.";

	private static final String PAPYRUS_NAME = "org.eclipse.papyrus";

	private static final String FEATURE_NATURE = "org.eclipse.pde.FeatureNature";

	private static final String PLUGIN_NATURE = "org.eclipse.pde.PluginNature";

	//TODO : the same thing for the feature
	//TODO : tests the projects name
	public Object execute(ExecutionEvent event) throws ExecutionException {

		IInputValidator validator = new IInputValidator() {

			public String isValid(String newText) {
				boolean match = newText.matches("[0-9]+\\.[0-9]+\\.[0-9]+\\.qualifier");
				if(!match) {
					return NLS.bind("The version number should be : something like this : {0}.", INITIAL_VALUE);
				}
				return null;
			}
		};


		InputDialogWithCheckBox dialog = new InputDialogWithCheckBox(Display.getCurrent().getActiveShell(), TITLE, MESSAGE, INITIAL_VALUE, CHECKBOX_MESSAGE, true, validator);
		if(dialog.open() == Window.OK) {
			String notManagedProjectNames = "";
			final String newVersion = dialog.getValue();
			final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();
			for(IProject current : projects) {
				final String name = current.getName();
				if(dialog.isChecked()) {
					if(name.startsWith(PAPYRUS_NAME)) {//we test the project name
						setVersionNumber(current, newVersion, notManagedProjectNames);
					} else {
						notManagedProjectNames += NLS.bind("- {0} \n", current.getName());
					}
				} else {
					setVersionNumber(current, newVersion, notManagedProjectNames);
				}
			}
			if(notManagedProjectNames.equals("")) {
				MessageDialog informationDialog = new MessageDialog(Display.getCurrent().getActiveShell(), WARNING_DIALOG_TITLE, null, WARNING_DIALOG_MESSAGE2, MessageDialog.INFORMATION, new String[]{ "OK" }, 0);
				informationDialog.open();
			} else {
				MessageDialog informationDialog = new MessageDialog(Display.getCurrent().getActiveShell(), WARNING_DIALOG_TITLE, null, WARNING_DIALOG_MESSAGE + "\n" + notManagedProjectNames, MessageDialog.INFORMATION, new String[]{ "OK" }, 0);
				informationDialog.open();
			}
		}
		return null;
	}

	/**
	 * 
	 * @param project
	 *        the project to manage
	 * @param newVersion
	 *        the new version for the project
	 * @param notManagedProjectNames
	 *        a String used to build the message with the not managed projects
	 */
	private void setVersionNumber(final IProject project, final String newVersion, String notManagedProjectNames) {
		if(project.isOpen()) {
			try {
				boolean pluginnature = project.hasNature(PLUGIN_NATURE);
				if(pluginnature) {
					try {
						IManifestEditor editor = new ManifestEditor(project);
						editor.init();
						editor.setBundleVersion(newVersion);
						editor.save();
					} catch (IOException e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					} catch (Throwable e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					}

				} else if(project.hasNature(FEATURE_NATURE)) {//for features
					try {
						IFeatureProjectEditor editor = new FeatureProjectEditor(project);
						editor.init();
						editor.setVersion(newVersion);
						editor.save();
					} catch (ParserConfigurationException e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					} catch (SAXException e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					} catch (IOException e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					} catch (Throwable e) {
						Activator.log.error(e);
						notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
					}

				}
			} catch (CoreException e) {
				Activator.log.error(e);
			}
		} else {
			notManagedProjectNames += NLS.bind("- {0} \n", project.getName());
		}
	}
}
