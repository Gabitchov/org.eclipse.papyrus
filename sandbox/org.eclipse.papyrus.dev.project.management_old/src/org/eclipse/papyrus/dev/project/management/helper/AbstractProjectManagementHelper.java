package org.eclipse.papyrus.dev.project.management.helper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.papyrus.eclipse.project.editors.file.BuildEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor;
import org.eclipse.swt.widgets.Display;


public abstract class AbstractProjectManagementHelper {

	public static final String INCUBATION = "(Incubation)";

	final protected String version;

	final protected String provider;

	final protected boolean testMarkIncubation;

	final private String projectNature;

	public AbstractProjectManagementHelper(final String projectNature, final String version, final String provider, final boolean testMarkIncubation) {
		this.projectNature = projectNature;
		this.version = version;
		this.provider = provider;
		this.testMarkIncubation = testMarkIncubation;
	}


	public final void execute(final IProject project) throws Throwable {
		if(project.isOpen()) {
			Assert.isTrue(project.getNature(this.projectNature) != null);
			handleProject(project);
		}
		project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
	}

	protected abstract void handleProject(IProject project) throws CoreException, IOException, Throwable;


	/**
	 * Add the file to the project if it doesn't exists
	 * 
	 * @param project
	 *        the project to edit
	 * @param sourcePath
	 *        the sourcePath for the file
	 * @param targetPath
	 *        the target Path for the file
	 * @throws CoreException
	 * @throws IOException
	 */
	protected void checkFile(final IProject project, final String sourcePath, final String targetPath) throws CoreException, IOException {
		IFile targetFile = project.getFile(new Path(targetPath));
		if(targetFile.exists()) {
			return;
		}

		InputStream is;
		URL url = new URL("platform:/plugin/" + Activator.PLUGIN_ID + sourcePath); //$NON-NLS-1$
		is = url.openStream();
		targetFile.create(is, false, new NullProgressMonitor());
		is.close();
		targetFile.refreshLocal(IFile.DEPTH_ZERO, new NullProgressMonitor());
	}

	protected IBuildEditor getBuildEditor(IProject project, String buildKey) {
		IBuildEditor editor = new BuildEditor(project, buildKey);
		editor.init();
		if(!editor.exists()) {
			editor.create();
		}
		return editor;
	}

	protected abstract void checkIncubation(final IProject project) throws IOException, CoreException, Throwable;

	protected String askNewName(final String label) {
		InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Edit the name", "The name should be ended by : " + INCUBATION, label, new AbstractProjectManagementHelper.IncubationValidator());
		dialog.open();
		//TODO the user can cancel the modification
		String newLabel = dialog.getValue();
		return newLabel;
	}

	public class IncubationValidator implements IInputValidator {

		public String isValid(String newText) {
			
			if(newText==null || newText.equals("") || !newText.endsWith(INCUBATION)) {
				return "The current name is not correct";
			}
			return null;
		}
	}
}
