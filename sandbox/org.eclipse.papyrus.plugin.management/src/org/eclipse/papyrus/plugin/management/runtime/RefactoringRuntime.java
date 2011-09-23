package org.eclipse.papyrus.plugin.management.runtime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.papyrus.eclipse.project.editors.file.BuildEditor;
import org.eclipse.papyrus.eclipse.project.editors.file.ClasspathEditor;
import org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IClasspathEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IJavaProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginProjectEditor;
import org.eclipse.papyrus.plugin.management.Activator;
import org.eclipse.ui.internal.misc.StringMatcher;

/**
 * A class for refactoring a set of Eclipse Plug-ins
 * 
 * This class handles the following elements :
 * 
 * - Plugins filtered by name
 * - Add a about.html file
 * - Sets the version and provider of the plug-in
 * - Adds the required files to the binary build
 * - Adds the source folders to the source build
 * 
 * TODO :
 * - Copy the /OSGI-INF/l10n/bundle.properties file to /plugin.properties
 * - Handle the externalized strings for Manifest
 * 
 * @author Camille Letavernier
 * 
 */
//USAGE :
//RefactoringRuntime runtime = new RefactoringRuntime();
//runtime.setProvider("Eclipse Modeling Project"); //Or null if the provider should not change
//runtime.setVersion("0.9.1"); //Or null if the version should not change
//runtime.setPluginPattern("org.eclipse.papyrus.*");
//try {
//	runtime.run();
//} catch (Throwable e) {
//	Activator.log.error(e);
//}
public class RefactoringRuntime {

	private String pluginPattern = "*"; //$NON-NLS-1$

	private StringMatcher matcher = new StringMatcher(pluginPattern, true, false);

	private IFile aboutHtmlFile;

	private String version = "0.0.0.qualified"; //$NON-NLS-1$

	private String provider = "www.eclipse.org"; //$NON-NLS-1$

	public static final String ABOUT_HTML_SOURCE_PATH = "/resources/about.html.file"; //$NON-NLS-1$

	public static final String ABOUT_HTML_PATH = "about.html"; //$NON-NLS-1$

	public RefactoringRuntime() {

	}

	public void setPluginPattern(String pattern) {
		this.pluginPattern = pattern;
		matcher = new StringMatcher(pattern, true, false);
	}

	public void setAboutHtmlFile(IFile file) {
		this.aboutHtmlFile = file;
	}

	public void setProvider(String providerName) {
		this.provider = providerName;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public void run() throws CoreException, IOException, Throwable {
		List<IProject> projectsToHandle = new LinkedList<IProject>();
		for(IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
			if(project.isOpen()) {
				if(project.getNature(IPluginProjectEditor.PLUGIN_NATURE) != null) {
					if(matcher.match(project.getName())) {
						handleProject(project);
						projectsToHandle.add(project);
					} else {
						Activator.log.warn(String.format("The plugin %1$s doesn't match the pattern %2$s", project.getName(), pluginPattern)); //$NON-NLS-1$
					}
				} else {
					Activator.log.warn(String.format("The project %s is not a plug-in project", project.getName())); //$NON-NLS-1$
					project.close(new NullProgressMonitor());
				}
			}
		}

		ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IWorkspaceRoot.DEPTH_INFINITE, new NullProgressMonitor());
		//		GetNonExternalizedStringsAction externalizeAction = new GetNonExternalizedStringsAction();
		//		externalizeAction.selectionChanged(null, new StructuredSelection(projectsToHandle));
		//		externalizeAction.setExternalizeSelectedPluginsOnly(true);
		//		externalizeAction.run(null);
		//		ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IWorkspaceRoot.DEPTH_INFINITE, new NullProgressMonitor());
		//
		//		for(IProject project : projectsToHandle) {
		//			checkBinaryBuild(project);
		//			checkSourceBuild(project);
		//			project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
		//		}
	}

	protected void handleProject(IProject project) throws CoreException, IOException, Throwable {
		Activator.log.warn("Handle " + project.getName());
		checkAboutHtmlFile(project);
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

	protected void checkAboutHtmlFile(IProject project) throws CoreException, IOException {
		IFile targetFile = project.getFile(new Path(ABOUT_HTML_PATH));
		if(targetFile.exists()) {
			return;
		}

		InputStream is;
		if(aboutHtmlFile == null) {
			URL url = new URL("platform:/plugin/" + Activator.PLUGIN_ID + ABOUT_HTML_SOURCE_PATH); //$NON-NLS-1$
			is = url.openStream();
		} else {
			is = aboutHtmlFile.getContents();
		}

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
}
