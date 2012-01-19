/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA-LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr 
 *
 *****************************************************************************/
package org.eclipse.papyrus.plugin.management.handler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.osgi.util.NLS;
import org.eclipse.papyrus.eclipse.project.editors.file.BuildEditor;
import org.eclipse.papyrus.eclipse.project.editors.file.ClasspathEditor;
import org.eclipse.papyrus.eclipse.project.editors.file.ManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IClasspathEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IJavaProjectEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IManifestEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IPluginProjectEditor;
import org.eclipse.papyrus.plugin.management.Activator;
import org.eclipse.papyrus.plugin.management.helper.AbstractProjectManagementHelper;
import org.eclipse.papyrus.plugin.management.helper.FeatureManagementHelper;
import org.eclipse.papyrus.plugin.management.helper.PluginManagmentHelper;
import org.eclipse.papyrus.plugin.management.ui.ParameterDialog;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.internal.misc.StringMatcher;


public class RefactoringHandler extends AbstractHandler {


	private String pluginPattern;

	private StringMatcher matcher;

	private IFile aboutHtmlFile;

	private IFile eplHtmlFile;

	private IFile licenseHTMLFile;

	private String version;

	private String provider;

	private boolean testAboutHTML = true;

	private boolean testIncubation = true;

	public static final String ABOUT_HTML_SOURCE_PATH = "/resources/about.html.file"; //$NON-NLS-1$

	public static final String ABOUT_HTML_PATH = "about.html"; //$NON-NLS-1$


	/**
	 * 
	 * Constructor.
	 * 
	 */
	public RefactoringHandler() {
		//nothing to do
	}

	/**
	 * 
	 * @see org.eclipse.core.commands.AbstractHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 * 
	 * @param event
	 * @return
	 * @throws ExecutionException
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//OLD CODE



		//		//TODO open a dialog with the plugin to edit
		//		//		MessageDialog messageDialog = new MessageDialog(Display.getCurrent().getActiveShell(), "Information", null, "Warning : the modifications will be done on all opened project in the workspace", , new String[]{"OK", "CANCEL"}}, 0);
		//		if(!MessageDialog.openQuestion(Display.getCurrent().getActiveShell(), "Information", "Warning : the modifications will be done on all opened project in the workspace. Are your sure ?")) {
		//			return null;
		//		}
		//		//we open a dialog to ask for the parameters : 
		//		ParameterDialog parameterDialog = new ParameterDialog(Display.getCurrent().getActiveShell());
		//		int value = parameterDialog.open();
		//		parameterDialog.getReturnCode();
		//		if(value != org.eclipse.jface.dialogs.Dialog.OK) {
		//			return null;
		//		}
		//		//initialize the fields with the result of the dialog
		//		this.provider = parameterDialog.getProviderName();
		//		this.pluginPattern = parameterDialog.getPluginNamePattern();
		//		this.version = parameterDialog.getVersionNumber();
		//		this.testIncubation = parameterDialog.isCheckIncubation();
		//		this.testAboutHTML = parameterDialog.isCheckHTMLFile();
		//		matcher = new StringMatcher(pluginPattern, true, false);
		//		List<IProject> projectsToHandle = Arrays.asList(ResourcesPlugin.getWorkspace().getRoot().getProjects());
		//		for(IProject project : ResourcesPlugin.getWorkspace().getRoot().getProjects()) {
		//			if(project.isOpen()) {
		//				try {
		//					if(project.getNature(IPluginProjectEditor.PLUGIN_NATURE) != null) {
		//						if(matcher.match(project.getName())) {
		//							handleProject(project);
		//							//							projectsToHandle.add(project);
		//						} else {
		//							//							Activator.log.warn(String.format("The plugin %1$s doesn't match the pattern %2$s", project.getName(), pluginPattern)); //$NON-NLS-1$
		//						}
		//					} else {
		//						Activator.log.warn(String.format("The project %s is not a plug-in project", project.getName())); //$NON-NLS-1$
		//						//						project.close(new NullProgressMonitor());
		//					}
		//					ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IWorkspaceRoot.DEPTH_INFINITE, new NullProgressMonitor());
		//				} catch (CoreException e) {
		//					Activator.log.error(e);
		//				} catch (IOException e) {
		//					Activator.log.error(e);
		//				} catch (Throwable e) {
		//					Activator.log.error(e);
		//				}
		//			}
		//		}
		//		//		}
		//
		//
		//		return null;

		//-----------------NEW CODE-----------------------
		//TODO open a dialog with the plugin to edit
		//		MessageDialog messageDialog = new MessageDialog(Display.getCurrent().getActiveShell(), "Information", null, "Warning : the modifications will be done on all opened project in the workspace", , new String[]{"OK", "CANCEL"}}, 0);

		//we ask to the user the project to edit
		Shell parentShell = Display.getCurrent().getActiveShell();
		Object input = Arrays.asList(ResourcesPlugin.getWorkspace().getRoot().getProjects());
		ISelection currentSelection = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getSelectionService().getSelection();
		Iterator<?> iterator = ((IStructuredSelection)currentSelection).iterator();
		
		List<IProject> selectedElements = new ArrayList<IProject>();
		while(iterator.hasNext()){
			Object current = iterator.next();
			if(current instanceof IProject){
				selectedElements.add((IProject)current);
			}
		}
		ListSelectionDialog projectDialog = new ListSelectionDialog(parentShell, input, new ProjectContentProvider(), new ProjectLabelProvider(), SELECT_PROJECT_MESSAGE);
		
		projectDialog.setInitialElementSelections(selectedElements);
		if(projectDialog.open() == org.eclipse.jface.dialogs.Dialog.OK) {
			Object[] selection = projectDialog.getResult();


			//we open a dialog to ask for the parameters : 
			ParameterDialog parameterDialog = new ParameterDialog(Display.getCurrent().getActiveShell());
			int value = parameterDialog.open();
			parameterDialog.getReturnCode();
			if(value != org.eclipse.jface.dialogs.Dialog.OK) {
				return null;
			}
			//initialize the fields with the result of the dialog
			this.provider = parameterDialog.getProviderName();
			this.pluginPattern = parameterDialog.getPluginNamePattern();
			this.version = parameterDialog.getVersionNumber();
			this.testIncubation = parameterDialog.isCheckIncubation();
			this.testAboutHTML = parameterDialog.isCheckHTMLFile();
			matcher = new StringMatcher(pluginPattern, true, false);

			AbstractProjectManagementHelper pluginHelper = new PluginManagmentHelper(version, provider, testIncubation);
			AbstractProjectManagementHelper featureHelper = new FeatureManagementHelper(version, provider, testIncubation);
			for(Object current : selection) {
				IProject project = (IProject)current;
				if(project.isOpen()) {
					try {
						if(matcher.match(project.getName())) {
							if(project.getNature(IPluginProjectEditor.PLUGIN_NATURE) != null) {
								//							pluginHelper.execute(project);
							} else if(project.getNature("org.eclipse.pde.FeatureNature") != null) {
								featureHelper.execute(project);
							}
						}
						ResourcesPlugin.getWorkspace().getRoot().refreshLocal(IWorkspaceRoot.DEPTH_INFINITE, new NullProgressMonitor());
					} catch (CoreException e) {
						Activator.log.error(e);
					} catch (IOException e) {
						Activator.log.error(e);
					} catch (Throwable e) {
						Activator.log.error(e);
					}
				}
			}
		}
		return null;
	}

	private static final String SELECT_PROJECT_MESSAGE = "Select the projects to edit.";

	protected void handleProject(IProject project) throws CoreException, IOException, Throwable {
		if(this.testAboutHTML) {
			checkAboutHtmlFile(project);
		}
		if(this.testIncubation) {
			checkIncubation(project);
		}
		checkProviderAndVersion(project);
		checkClasspath(project);
		project.refreshLocal(IProject.DEPTH_INFINITE, new NullProgressMonitor());
	}

	protected void checkIncubation(IProject project) {
		String name = project.getName();
		if(!name.endsWith("(Incubation)")) {
			//			InputDialog dialog = new InputDialog(Display.getCurrent().getActiveShell(), "Edit the plugin name", "This plugin doesn't contains the String '(Incubation)' in its name", project.getName(), new IInputValidator() {
			//				
			//				public String isValid(String newText) {
			//					if(!newText.endsWith("(Incubation)")){
			//						return "The name of the plugin should be end with '(Incubation')";
			//					}
			//					return null;
			//				}
			//			});
			//			while(dialog.open()!=org.eclipse.jface.dialogs.Dialog.OK);
			//			String newName = dialog.getValue();
			//TODO : use the manifest editor to change the project name
			Activator.log.warn(NLS.bind("The project {0} doesn't contain (Incubation) in its name", project.getName()));
		}
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
		if(this.aboutHtmlFile == null) {
			URL url = new URL("platform:/plugin/" + Activator.PLUGIN_ID + ABOUT_HTML_SOURCE_PATH); //$NON-NLS-1$
			is = url.openStream();
		} else {
			is = aboutHtmlFile.getContents();
		}

		targetFile.create(is, false, new NullProgressMonitor());
		is.close();
		targetFile.refreshLocal(IFile.DEPTH_ZERO, new NullProgressMonitor());
	}


	protected void checkedHTMLFile(IProject project, final String sourcePath, final String targetPath) throws CoreException, IOException {
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

	/**
	 * 
	 * This content provider returns IProject
	 * 
	 */
	private class ProjectContentProvider implements IStructuredContentProvider {

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
		 * 
		 */
		public void dispose() {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
		 * 
		 * @param viewer
		 * @param oldInput
		 * @param newInput
		 */
		public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
		 * 
		 * @param inputElement
		 * @return
		 */
		public Object[] getElements(Object inputElement) {

			if(inputElement instanceof List<?>) {
				List<?> input = (List<?>)inputElement;
				List<IProject> editableProject = new ArrayList<IProject>();
				for(Object current : input) {
					if(current instanceof IProject) {
						if(((IProject)current).isOpen()) {
							editableProject.add((IProject)current);
						}
					}
				}
				return editableProject.toArray();

			}
			return new Object[0];
		}

	}

	/**
	 * 
	 * This class provides label and icons for IProject
	 * 
	 */
	private class ProjectLabelProvider implements ILabelProvider {

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 * 
		 * @param listener
		 */
		public void addListener(ILabelProviderListener listener) {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
		 * 
		 */
		public void dispose() {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
		 * 
		 * @param element
		 * @param property
		 * @return
		 */
		public boolean isLabelProperty(Object element, String property) {
			//nothing to do
			return false;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
		 * 
		 * @param listener
		 */
		public void removeListener(ILabelProviderListener listener) {
			//nothing to do
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getImage(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public Image getImage(Object element) {
			// TODO Auto-generated method stub
			return null;
		}

		/**
		 * 
		 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
		 * 
		 * @param element
		 * @return
		 */
		public String getText(Object element) {
			if(element instanceof IProject) {
				return ((IProject)element).getName();
			}
			return "";
		}

	}
}
