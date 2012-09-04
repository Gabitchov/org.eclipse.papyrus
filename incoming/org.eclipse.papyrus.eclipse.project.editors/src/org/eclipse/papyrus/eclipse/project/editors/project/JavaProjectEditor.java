/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.eclipse.project.editors.project;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.papyrus.eclipse.project.editors.Activator;
import org.eclipse.papyrus.eclipse.project.editors.file.BuildEditor;
import org.eclipse.papyrus.eclipse.project.editors.file.ClasspathEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IClasspathEditor;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IJavaProjectEditor;

/**
 * 
 * This editor allows to manage a JavaProject
 * 
 */
public class JavaProjectEditor extends ProjectEditor implements IJavaProjectEditor {


	/** the java project */
	private final IJavaProject javaProject;

	/** the classpath editor */
	private final IClasspathEditor classpathEditor;

	/** the build editor */
	private final IBuildEditor buildEditor;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 *        the eclipse project
	 * @throws CoreException
	 */
	public JavaProjectEditor(final IProject project) throws CoreException {
		super(project);
		this.javaProject = JavaCore.create(project);
		this.buildEditor = new BuildEditor(project);
		this.classpathEditor = new ClasspathEditor(this.javaProject);
	}

	/**
	 * 
	 * @return
	 *         <code>true</code> if the project is a java project :
	 * 
	 */
	@Override
	public boolean exists() {
		return super.exists() && this.javaProject.exists();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#getMissingFiles()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingFiles() {
		Set<String> files = super.getMissingFiles();
		files.addAll(this.classpathEditor.getMissingFiles());
		files.addAll(this.buildEditor.getMissingFiles());
		return files;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.AbstractProjectEditor#getMissingNature()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingNature() {
		Set<String> natures = super.getMissingNature();
		if(!hasNature(JAVA_NATURE)) {
			natures.add(JAVA_NATURE);
		}
		return natures;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		this.classpathEditor.init();
		this.buildEditor.init();
	}

	@Override
	public void createFiles(final Set<String> files) {
		super.createFiles(files);
		this.classpathEditor.createFiles(files);
		this.buildEditor.createFiles(files);
	}



	/**
	 * save the modification
	 * 
	 * @throws Throwable
	 */
	@Override
	public void save() {
		super.save();
		try {
			this.javaProject.save(new NullProgressMonitor(), true);
		} catch (JavaModelException ex) {
			Activator.log.error(ex);
		}
		this.classpathEditor.save();
		this.buildEditor.save();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IJavaProjectEditor#addJavaSourceFolder(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void addJavaSourceFolder(final String path) {
		if(exists()) {
			//we add this source folder to the class path
			//		String classPath = "/" + this.project.getName()+"/" + path;
			String classPath = path;
			this.classpathEditor.addSourceFolderToClasspath(classPath);

			//we add this source folder in the build file
			this.buildEditor.registerSourceFolder(path + "/"); //$NON-NLS-1$
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#registerSourceFolder(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void registerSourceFolder(final String string) {
		this.buildEditor.registerSourceFolder(string);

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#addToBuild(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void addToBuild(final String path) {
		this.buildEditor.addToBuild(path);

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#isRegistred(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public boolean isRegisteredSourceFolder(final String path) {
		return this.buildEditor.isRegisteredSourceFolder(path);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#getSourceFolders()
	 * 
	 *      {@inheritDoc}
	 */
	public String[] getSourceFolders() {
		return this.buildEditor.getSourceFolders();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.file.AbstractFileEditor#getMissingBuildCommand()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingBuildCommand() {
		Set<String> buildCommand = super.getMissingBuildCommand();
		if(!hasBuildCommand(IJavaProjectEditor.JAVA_BUILD_COMMAND)) {
			buildCommand.add(IJavaProjectEditor.JAVA_BUILD_COMMAND);
		}
		return buildCommand;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#removeFromBuild(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void removeFromBuild(String path) {
		buildEditor.removeFromBuild(path);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#getElementsInBuild()
	 * 
	 *      {@inheritDoc}
	 */
	public String[] getElementsInBuild() {
		return buildEditor.getElementsInBuild();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#registerBinFolder(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void registerBinFolder(String binFolder) {
		buildEditor.registerBinFolder(binFolder);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#isRegisteredBinFolder(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public boolean isRegisteredBinFolder(String binFolder) {
		return buildEditor.isRegisteredBinFolder(binFolder);
	}
}
