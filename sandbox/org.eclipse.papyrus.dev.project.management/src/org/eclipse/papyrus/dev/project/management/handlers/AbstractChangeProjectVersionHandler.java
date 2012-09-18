package org.eclipse.papyrus.dev.project.management.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.window.Window;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.dev.project.management.dialog.InputDialogWithCheckBox;
import org.eclipse.swt.widgets.Display;


public abstract class AbstractChangeProjectVersionHandler extends AbstractHandler {

	private static final String TITLE = "Enter the new version number for Papyrus plugin.";

	private static final String MESSAGE = "Enter the new version number.";

	private static final String INITIAL_VALUE = "0.0.0.qualifier";

	private static final String CHECKBOX_MESSAGE = "Only projects beginning with 'org.eclipse.papyrus.*'";

	private static final String WARNING_DIALOG_TITLE = "Change Version Name Report";

	private static final String WARNING_DIALOG_MESSAGE = "The following project were NOT managed : ";

	private static final String WARNING_DIALOG_MESSAGE2 = "Done.";

	private static final String PAPYRUS_NAME = "org.eclipse.papyrus";


	public Object execute(final ExecutionEvent event) throws ExecutionException {

		final IInputValidator validator = new IInputValidator() {

			public String isValid(final String newText) {
				final boolean match = newText.matches("[0-9]+\\.[0-9]+\\.[0-9]+\\.qualifier");
				if(!match) {
					return NLS.bind("The version number should be : something like this : {0}.", INITIAL_VALUE);
				}
				return null;
			}
		};


		final InputDialogWithCheckBox dialog = new InputDialogWithCheckBox(Display.getCurrent().getActiveShell(), TITLE, MESSAGE, INITIAL_VALUE, CHECKBOX_MESSAGE, true, validator);
		if(dialog.open() == Window.OK) {
			Job job = new Job("Update version numbers") {

				@Override
				protected IStatus run(IProgressMonitor monitor) {
					IStatus result = runAsJob(dialog.getValue(), dialog.isChecked(), monitor);
					return result;
				}

			};
			job.setUser(true);

			job.schedule();
		}
		return null;
	}

	protected IStatus runAsJob(final String newVersion, final boolean papyrusProjectsOnly, IProgressMonitor monitor) {
		String notManagedProjectNames = "";
		final IProject[] projects = ResourcesPlugin.getWorkspace().getRoot().getProjects();

		monitor.beginTask("Update version numbers", projects.length);

		for(final IProject current : projects) {
			final String name = current.getName();
			if(papyrusProjectsOnly) {
				if(name.startsWith(PAPYRUS_NAME)) {//we test the project name
					setVersionNumber(current, newVersion, notManagedProjectNames);
				} else {
					notManagedProjectNames += NLS.bind("- {0} \n", current.getName());
				}
			} else {
				setVersionNumber(current, newVersion, notManagedProjectNames);
			}

			monitor.worked(1);
		}

		if(notManagedProjectNames.equals("")) {
			final MessageDialog informationDialog = new MessageDialog(Display.getCurrent().getActiveShell(), WARNING_DIALOG_TITLE, null, WARNING_DIALOG_MESSAGE2, MessageDialog.INFORMATION, new String[]{ "OK" }, 0);
			informationDialog.open();
		} else {
			final MessageDialog informationDialog = new MessageDialog(Display.getCurrent().getActiveShell(), WARNING_DIALOG_TITLE, null, WARNING_DIALOG_MESSAGE + "\n" + notManagedProjectNames, MessageDialog.INFORMATION, new String[]{ "OK" }, 0);
			informationDialog.open();
		}

		return Status.OK_STATUS;
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
	protected abstract void setVersionNumber(final IProject project, final String newVersion, String notManagedProjectNames);



}
