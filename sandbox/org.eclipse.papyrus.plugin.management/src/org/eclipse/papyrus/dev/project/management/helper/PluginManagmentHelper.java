package org.eclipse.papyrus.dev.project.management.helper;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.papyrus.dev.project.management.Activator;
import org.eclipse.papyrus.eclipse.project.editors.file.BuildEditor;
import org.eclipse.papyrus.eclipse.project.editors.file.BundlePropertiesEditor;
import org.eclipse.papyrus.eclipse.project.editors.file.ClasspathEditor;
import org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IClasspathEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IJavaProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginProjectEditor;
import org.eclipse.swt.widgets.Display;


public class PluginManagmentHelper extends AbstractProjectManagementHelper {

	public static final String ABOUT_HTML_SOURCE_PATH = "/resources/about.html.file"; //$NON-NLS-1$

	public static final String ABOUT_HTML_PATH = "about.html"; //$NON-NLS-1$

	public PluginManagmentHelper(final String version, final String provider, final boolean testMarkIncubation)  {
		super(IPluginProjectEditor.PLUGIN_NATURE, version, provider, testMarkIncubation);
	}
	
	protected void handleProject(IProject project) throws CoreException, IOException, Throwable {
		checkFile(project, ABOUT_HTML_SOURCE_PATH, ABOUT_HTML_PATH);
		if(testMarkIncubation) {
			checkIncubation(project);
		}
		checkProviderAndVersion(project);
		checkClasspath(project);
		project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
	}
	
	protected void checkClasspath(IProject project) throws Throwable {
		if(!project.hasNature(IJavaProjectEditor.JAVA_NATURE)) {
			return;
		}

		IClasspathEditor editor = new ClasspathEditor(project);
		if(!editor.exists()) {
			return;
		}

		//Adds the classpath entries to the build (source.. and output..)
		IBuildEditor buildEditor = getBuildEditor(project, null);
		for(String sourceFolder : editor.getSourceFolders()) {
			buildEditor.registerSourceFolder(sourceFolder + "/");
		}
		for(String binFolder : editor.getBinFolders()) {
			buildEditor.registerBinFolder(binFolder + "/");
		}

		buildEditor.save();
	}
	
	protected void checkProviderAndVersion(IProject project) throws CoreException, IOException, Throwable {
		IManifestEditor manifest = new ManifestEditor(project);
		manifest.init();
		boolean manifestChange = false;

		if(!manifest.exists()) {
			manifest.create();
			manifestChange = true;
		}

		if(provider != null) {
			//TODO : If the string is already externalized, edit the *.properties language file
			//(Can be either plugin.properties or bundle.properties ; see Bundle-localization to find it)
			String bundleVendor = manifest.getBundleVendor();
			if(!provider.equals(bundleVendor)) {
				if(bundleVendor == null || !bundleVendor.startsWith("%")) { //Undefined or not externalized String
					manifest.setBundleVendor(provider);
					manifestChange = true;
				}
			}
		}
		if(version != null) {
			String currentVersion = manifest.getBundleVersion();
			if(!version.equals(currentVersion)) {
				manifest.setBundleVersion(version);
				manifestChange = true;
			}
		}

		//test the name of the project
		String name = manifest.getBundleName();
		final String INCUBATION = "(Incubation)";
		IInputValidator validator = new IInputValidator() {
			
			public String isValid(String newText) {
				if(!newText.endsWith(INCUBATION)){
				return "The current name is not correct";
				}
				return null;
			}
		};
		
		
		if(!name.endsWith(INCUBATION)){
			InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Change the name of the bundle", "The bundle's name should be ended by : " + INCUBATION, name, validator);
			dialog.open();
			name = dialog.getValue();
			manifest.setBundleName(name);
			manifestChange = true;

		}

		if(manifestChange) {
			manifest.save();
		}
	}

	protected void checkSourceBuild(IProject project) throws Throwable {
		IBuildEditor sourceEditor = getBuildEditor(project, IBuildEditor.SOURCE_BUILD);
		IBuildEditor binEditor = getBuildEditor(project, IBuildEditor.BINARY_BUILD);

		//Copy the binary build
		for(String binaryBuildElement : binEditor.getElementsInBuild()) {
			sourceEditor.addToBuild(binaryBuildElement);
		}

		//Add the source folders to the build
		//Fix : the source folders are automatically added to source builds
		//for(String sourceFolder : sourceEditor.getSourceFolders()) {
		//		sourceEditor.addToBuild(sourceFolder);
		//}
		sourceEditor.save();
		project.getFile(IBuildEditor.BUILD_PROPERTIES_FILE).refreshLocal(IFile.DEPTH_ZERO, new NullProgressMonitor());
	}

	protected void checkBinaryBuild(IProject project) throws Throwable {
		IBuildEditor editor = getBuildEditor(project, IBuildEditor.BINARY_BUILD);
		addToBuildIfExists(editor, ABOUT_HTML_PATH);
		addToBuildIfExists(editor, IManifestEditor.META_INF_PATH);
		addToBuildIfExists(editor, IPluginProjectEditor.PLUGIN_XML_FILE);
		addToBuildIfExists(editor, "plugin.properties"); //$NON-NLS-1$
		addToBuildIfExists(editor, "OSGI-INF/"); //$NON-NLS-1$
		editor.save();
		project.getFile(IBuildEditor.BUILD_PROPERTIES_FILE).refreshLocal(IFile.DEPTH_ZERO, new NullProgressMonitor());
	}

	protected void addToBuildIfExists(IBuildEditor editor, String file) {
		if(editor.getProject().getFile(file).exists()) {
			editor.addToBuild(file);
		}
	}

	@Override
	protected void checkIncubation(final IProject project) throws Throwable {
		IManifestEditor manifest = new ManifestEditor(project);
		manifest.init();
		boolean manifestChange = false;

		if(!manifest.exists()) {
			manifest.create();
			manifestChange = true;
		}

		//tests the name of the project
		String name = manifest.getBundleName();
		if(name.startsWith("%")){
			String localization = manifest.getBundleLocalization();
			if(localization==null){
				//TODO log an error
				return;
			}
			BundlePropertiesEditor editor = getBundlePropertiesEditor(project, localization);
			String value = editor.getValue(name.substring(1));
			int i=0;
			i++;
			
		}else if(!name.endsWith(INCUBATION)){
			InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Change the name of the bundle", "The bundle's name should be ended by : " + INCUBATION, name, new AbstractProjectManagementHelper.IncubationValidator());
			dialog.open();
			name = dialog.getValue();
			manifest.setBundleName(name);
			manifestChange = true;

		}

		if(manifestChange) {
			manifest.save();
		}		
	}
	protected BundlePropertiesEditor getBundlePropertiesEditor(IProject project, String filePath) {
		BundlePropertiesEditor editor = new BundlePropertiesEditor(project, filePath
			);
		editor.init();
		if(!editor.exists()) {
			editor.create();
		}
		return editor;
	}
}
