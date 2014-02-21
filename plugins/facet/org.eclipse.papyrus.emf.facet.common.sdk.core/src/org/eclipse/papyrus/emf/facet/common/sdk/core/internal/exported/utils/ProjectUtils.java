/*******************************************************************************
 * Copyright (c) 2010, 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software)
 *    Fabien Giquel (Mia-Software)
 *    Nicolas Bros (Mia-Software)
 *    Nicolas Bros (Mia-Software) - Bug 375054 - Add validation warning for overlay on EClass
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.common.sdk.core.internal.exported.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.FileUtils;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.FolderUtils;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaConventions;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.papyrus.emf.facet.common.sdk.core.internal.Activator;
import org.eclipse.papyrus.emf.facet.common.sdk.core.internal.Messages;
import org.eclipse.papyrus.emf.facet.common.sdk.core.internal.exported.CommonConstants;

import com.ibm.icu.lang.UCharacter;

/**
 * @author Gregoire Dupe (Mia-Software), Fabien Giquel (Mia-Software)
 * 
 */
public final class ProjectUtils {

	private ProjectUtils() {
		// Nothing
	}

	private static final String JAVA_VERSION = "J2SE-1.5"; //$NON-NLS-1$

	public static void addPdeClassPath(final IProject project) throws JavaModelException {
		final IJavaProject javaProject = JavaCore.create(project);
		final IClasspathEntry[] oldClassPath = javaProject.getRawClasspath();
		for (final IClasspathEntry classpathEntry : oldClassPath) {
			if (classpathEntry.getPath().equals(new Path("org.eclipse.pde.core.requiredPlugins"))) { //$NON-NLS-1$
				return;
			}
		}
		final IClasspathEntry[] newClassPath = new IClasspathEntry[oldClassPath.length + 1];
		System.arraycopy(oldClassPath, 0, newClassPath, 0, oldClassPath.length);
		newClassPath[oldClassPath.length] = JavaCore.newContainerEntry(new Path("org.eclipse.pde.core.requiredPlugins")); //$NON-NLS-1$
		javaProject.setRawClasspath(newClassPath, new NullProgressMonitor());
	}

	/**
	 * @author Gregoire Dupe (Mia-Software) - Removing "Require-Bundle" statement
	 */
	public static void createManifest(final IProject project) throws CoreException {
		final IFolder folder = project.getFolder("META-INF"); //$NON-NLS-1$
		if (!folder.exists()) {
			folder.create(true, true, new NullProgressMonitor());
		}
		final IFile manifestFile = folder.getFile("MANIFEST.MF"); //$NON-NLS-1$
		if (!manifestFile.exists()) {
			final StringBuffer manifestSB = new StringBuffer();
			manifestSB.append("Manifest-Version: 1.0\n"); //$NON-NLS-1$
			manifestSB.append("Bundle-ManifestVersion: 2\n"); //$NON-NLS-1$
			manifestSB.append("Bundle-Name: " + project.getName() + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
			final String packageName = ProjectUtils.packageName(project.getName());
			manifestSB.append("Bundle-SymbolicName: " + packageName //$NON-NLS-1$
					+ ";singleton:=true\n"); //$NON-NLS-1$
			manifestSB.append("Bundle-Version: 0.0.1.qualifier\n"); //$NON-NLS-1$
			manifestSB
					.append("Bundle-Activator: " + ProjectUtils.bundleActivatorQualifiedName(packageName) + "\n"); //$NON-NLS-1$ //$NON-NLS-2$
			//manifestSB.append("Bundle-Vendor: bundle vendor\n"); //$NON-NLS-1$
			manifestSB.append("Require-Bundle: org.eclipse.core.runtime,\n"); //$NON-NLS-1$
			manifestSB.append(" org.eclipse.papyrus.emf.facet.util.core\n"); //$NON-NLS-1$
			manifestSB.append("Bundle-RequiredExecutionEnvironment: " //$NON-NLS-1$
					+ ProjectUtils.JAVA_VERSION + "\n"); //$NON-NLS-1$
			manifestSB.append("Bundle-ActivationPolicy: lazy\n"); //$NON-NLS-1$
			manifestSB.append("Bundle-ClassPath: .,bin\n"); //$NON-NLS-1$
			final InputStream source = new ByteArrayInputStream(manifestSB.toString().getBytes());
			manifestFile.create(source, true, new NullProgressMonitor());
		}
	}

	private static String bundleActivatorQualifiedName(final String packageName) {
		return packageName + ".Activator"; //$NON-NLS-1$
	}

	private static void createActivator(final IProject project) throws CoreException {
		final String packageName = ProjectUtils.packageName(project.getName());
		final String qualifiedName = ProjectUtils.bundleActivatorQualifiedName(packageName);
		final String path = qualifiedName.replaceAll("\\.", "/"); //$NON-NLS-1$ //$NON-NLS-2$
		final IFile activatorFile = project
				.getFile(new Path("src").append(path).addFileExtension("java")); //$NON-NLS-1$ //$NON-NLS-2$
		FolderUtils.createFolder((IFolder) activatorFile.getParent());
		if (!activatorFile.exists()) {
			try {
				final String template = FileUtils.getFileContents(Activator.getDefault()
						.getBundle(), "resources/Activator.java.template"); //$NON-NLS-1$
				final String activatorContents = template.replace("{0}", packageName); //$NON-NLS-1$
				final InputStream source = new ByteArrayInputStream(activatorContents.getBytes());
				activatorFile.create(source, true, new NullProgressMonitor());
			} catch (final IOException e) {
				Logger.logError(e, "Couldn't create Activator", Activator //$NON-NLS-1$
						.getDefault());
			}
		}
	}

	/** Transform the given name into a valid package and bundle name */
	public static String packageName(final String name) {
		final StringBuilder builder = new StringBuilder();
		char prev = ' ';
		for (int i = 0; i < name.length(); i++) {
			final char c = name.charAt(i);
			if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c == '_') {
				builder.append(c);
				prev = c;
			} else if (c >= '0' && c <= '9') {
				if (builder.length() == 0 || prev == '.') {
					builder.append("_"); //$NON-NLS-1$
				}
				builder.append(c);
				prev = c;
			} else if (c == '.') {
				if (prev == '.') {
					continue;
				}
				if (builder.length() == 0 || prev >= '0' && prev <= '9') {
					builder.append("_"); //$NON-NLS-1$
				}
				builder.append(c);
				prev = c;
			} else {
				builder.append("_"); //$NON-NLS-1$
			}
		}

		String result = builder.toString();
		// first letter to lowercase
		if (result.length() > 0 && UCharacter.isUpperCase(result.charAt(0))) {
			result = UCharacter.toLowerCase(result.charAt(0)) + result.substring(1);
		}

		final IStatus status = JavaConventions.validatePackageName(result, JavaCore.VERSION_1_5,
				JavaCore.VERSION_1_5);
		if (!status.isOK()) {
			Logger.logWarning("Couldn't make valid package name from project name: " //$NON-NLS-1$
					+ status.getMessage(), Activator.getDefault());
			return name;
		}
		return result;
	}

	public static void addPdeNature(final IProject project) throws CoreException {
		final String pluginNature = "org.eclipse.pde.PluginNature"; //$NON-NLS-1$
		final IProjectDescription description = project.getDescription();
		final String[] natures = description.getNatureIds();
		if (!Arrays.asList(natures).contains(pluginNature)) {
			final String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 0, natures.length);
			newNatures[natures.length] = pluginNature;
			description.setNatureIds(newNatures);
			project.setDescription(description, new NullProgressMonitor());
		}
	}

	public static void addPdeBuilder(final IProject project) throws CoreException {
		final IProjectDescription projectDescription = project.getDescription();
		final ICommand[] oldBuildSpec = project.getDescription().getBuildSpec();
		for (final ICommand command : oldBuildSpec) {
			if ("org.eclipse.pde.ManifestBuilder".equals(command.getBuilderName())) { //$NON-NLS-1$
				return;
			}
		}
		final ICommand[] newBuildSpec = new ICommand[oldBuildSpec.length + 2];
		System.arraycopy(oldBuildSpec, 0, newBuildSpec, 0, oldBuildSpec.length);
		final ICommand command1 = project.getDescription().newCommand();
		command1.setBuilderName("org.eclipse.pde.ManifestBuilder"); //$NON-NLS-1$
		final ICommand command2 = project.getDescription().newCommand();
		command2.setBuilderName("org.eclipse.pde.SchemaBuilder"); //$NON-NLS-1$
		newBuildSpec[oldBuildSpec.length] = command1;
		newBuildSpec[oldBuildSpec.length + 1] = command2;
		projectDescription.setBuildSpec(newBuildSpec);
		project.setDescription(projectDescription, new NullProgressMonitor());
	}

	/**
	 * @author Gregoire Dupe (Mia-Software) - classpath entries modification
	 */
	public static void configureAsJavaProject(final IProject project, final IProgressMonitor monitor)
			throws CoreException {
		ProjectUtils.addNature(project, monitor, JavaCore.NATURE_ID);
		final IJavaProject javaProject = JavaCore.create(project);
		// Set output folder
		final IPath path = project.getFullPath().append("bin"); //$NON-NLS-1$
		javaProject.setOutputLocation(path, null);
		final List<IClasspathEntry> classpathEntries = new ArrayList<IClasspathEntry>();
		// Set source folder
		final IFolder sourceFolder = project.getFolder("src"); //$NON-NLS-1$
		if (!sourceFolder.exists()) {
			sourceFolder.create(false, true, monitor);
			classpathEntries.add(JavaCore.newSourceEntry(javaProject.getPath().append(
					new Path("src")))); //$NON-NLS-1$
		}
		final Path jrePath = new Path(JavaRuntime.JRE_CONTAINER
				+ "/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/" //$NON-NLS-1$
				+ ProjectUtils.JAVA_VERSION);
		boolean hasJrePath = false;
		final IClasspathEntry[] existingClassPath = javaProject.getRawClasspath();
		for (final IClasspathEntry classpathEntry : existingClassPath) {
			if (jrePath.equals(classpathEntry.getPath())) {
				hasJrePath = true;
			}
		}
		if (!hasJrePath) {
			// add the jre api to the classpath
			classpathEntries.add(JavaCore.newContainerEntry(jrePath));
			javaProject.setRawClasspath(classpathEntries.toArray(new IClasspathEntry[0]), monitor);
		}
	}

	public static void configureAsPluginProject(final IProject project) throws CoreException {
		// TODO PDE Operations would be useful here but they are internal in PDE
		ProjectUtils.addPdeNature(project);
		// PDE builders are automatically added when the PDE nature is added
		// ProjectUtils.addPdeBuilder(project);
		ProjectUtils.addPdeClassPath(project);
		ProjectUtils.createManifest(project);
		ProjectUtils.createActivator(project);
	}

	public static void addNature(final IProject project, final IProgressMonitor monitor,
			final String natureId) throws CoreException {
		final IProjectDescription description = project.getDescription();
		final String[] natures = description.getNatureIds();
		if (!Arrays.asList(natures).contains(natureId)) {
			final String[] newNatures = new String[natures.length + 1];
			System.arraycopy(natures, 0, newNatures, 1, natures.length);
			newNatures[0] = natureId;
			description.setNatureIds(newNatures);
			project.setDescription(description, monitor);
		}
	}

	/**
	 * @author Gregoire Dupe (Mia-Software) - initial implementation
	 */
	public static void createBuildProperties(final IProject project) throws CoreException {
		final IFile buildFile = project.getFile("build.properties"); //$NON-NLS-1$
		if (!buildFile.exists()) {
			final StringBuffer buildSB = new StringBuffer();
			buildSB.append("source.. = src/\n"); //$NON-NLS-1$
			buildSB.append("output.. = bin/\n"); //$NON-NLS-1$
			buildSB.append("bin.includes = META-INF/,\\\n"); //$NON-NLS-1$
			buildSB.append("               .\n"); //$NON-NLS-1$
			final InputStream source = new ByteArrayInputStream(buildSB.toString().getBytes());
			buildFile.create(source, true, new NullProgressMonitor());
		}
	}

	/**
	 * Create an EMF Facet project
	 * 
	 * @param project
	 *            a reference to the project to create (it must not already exist)
	 * @param projectLocation 
	 * @param monitor
	 *            a progress monitor
	 * @throws CoreException
	 *             in case of error
	 */
	public static void createEmfFacetProject(final IProject project, final IPath projectLocation, final IProgressMonitor monitor)
			throws CoreException {
		ProjectUtils.createPluginProject(project, projectLocation, monitor, false);
		ProjectUtils.addNature(project, monitor, CommonConstants.NATURE_ID);
		monitor.done();
	}

	public static void createPluginProject(final IProject project, final IPath projectLocation, final IProgressMonitor monitor,
			final boolean monitorDone) throws CoreException {
		monitor.beginTask(Messages.ProjectUtils_createPluginProject, IProgressMonitor.UNKNOWN);
		if (!project.exists()) {
			final IProjectDescription description = project.getWorkspace().newProjectDescription(
					project.getName());
			if (!Platform.getLocation().equals(projectLocation)) {
				description.setLocation(projectLocation);
			}
			project.create(description, monitor);
			project.open(monitor);
			ProjectUtils.configureAsJavaProject(project, monitor);
			ProjectUtils.configureAsPluginProject(project);
			ProjectUtils.createBuildProperties(project);
		} else {
			throw new CoreException(new Status(IStatus.ERROR, Activator.getDefault().getBundle().getSymbolicName(), "The project already exists")); //$NON-NLS-1$
		}
		if (monitorDone) {
			monitor.done();
		}
	}

	public static boolean isEmfFacetProject(final IProject project) {
		try {
			if (!project.isAccessible()) {
				return false;
			}
			return project.getNature(CommonConstants.NATURE_ID) != null;
		} catch (final CoreException e) {
			Logger.logError(e, Activator.getDefault());
			return false;
		}
	}

	public static boolean isInEmfFacetProject(final IPath path) {
		final IProject project = getProject(path);
		return isEmfFacetProject(project);
	}

	public static IProject getProject(final IPath path) {
		final IProject project;
		if (path.segmentCount() == 1) {
			project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(path.segment(0));
		} else {
			final IFolder folder = ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
			project = folder.getProject();
		}
		return project;
	}
}
