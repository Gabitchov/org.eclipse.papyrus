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
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr
 *
 *****************************************************************************/
package org.eclipse.papyrus.eclipse.project.editors.file;


import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.AssertionFailedException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IAccessRule;
import org.eclipse.jdt.core.IClasspathAttribute;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.ClasspathEntry;
import org.eclipse.papyrus.eclipse.project.editors.Activator;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IClasspathEditor;

/**
 * 
 * The editor for the classpath file
 * 
 */
public class ClasspathEditor extends AbstractFileEditor implements IClasspathEditor {

	/**
	 * the edited java project
	 */
	private final IJavaProject javaProject;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 */
	public ClasspathEditor(final IProject project) throws AssertionFailedException {
		super(project);
		this.javaProject = JavaCore.create(project);
	}

	/**
	 * 
	 * Constructor.
	 * 
	 * @param javaProject
	 *        a java project
	 */
	public ClasspathEditor(final IJavaProject javaProject) {
		super(javaProject.getProject());
		this.javaProject = javaProject;
	}

	@Override
	public void init() {
		//nothing to do here
	}

	/**
	 * save the modification
	 * 
	 * @throws Throwable
	 */
	public void save() {
		try {
			this.javaProject.save(new NullProgressMonitor(), true);
		} catch (JavaModelException ex) {
			Activator.log.error(ex);
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IClasspathEditor#addSourceFolderToClasspath(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void addSourceFolderToClasspath(final String folderPath) {

		if(exists() && !isSourceFolderRegistered(folderPath)) {

			//parameters for the new ClasspathEntry
			boolean isExported = false;
			IPath[] exclusionPatterns = new IPath[0];
			IPath sourceAttachmentPath = null;
			IPath specificOutputLocation = null;
			boolean combineAccessRules = false;
			IClasspathAttribute[] extraAttributes = new IClasspathAttribute[0];
			IPath sourceAttachmentRootPath = null;
			IAccessRule[] accessRules = null;
			int contentKind = IPackageFragmentRoot.K_SOURCE;
			IPath[] inclusionPatterns = new IPath[0];
			int entryKind = IClasspathEntry.CPE_SOURCE;
			IPath path2 = new Path(folderPath);

			IClasspathEntry[] classpathes = null;
			try {
				classpathes = this.javaProject.getRawClasspath();
			} catch (JavaModelException e) {
				e.printStackTrace();
			}

			IClasspathEntry[] entries = new IClasspathEntry[classpathes.length + 1];
			for(int i = 0; i < classpathes.length; i++) {
				entries[i] = classpathes[i];
			}
			entries[classpathes.length] = new ClasspathEntry(contentKind, entryKind, path2, inclusionPatterns, exclusionPatterns, sourceAttachmentPath, sourceAttachmentRootPath, specificOutputLocation, isExported, accessRules, combineAccessRules, extraAttributes);
			try {
				this.javaProject.setRawClasspath(entries, new NullProgressMonitor());
			} catch (JavaModelException e) {
				Activator.log.error(e);
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IClasspathEditor#isSourceFolderRegistered(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public boolean isSourceFolderRegistered(final String folderPath) {
		IClasspathEntry[] entries = null;
		try {
			entries = this.javaProject.getRawClasspath();
		} catch (JavaModelException e) {
			Activator.log.error(e);
		}

		for(int i = 0; i < entries.length; i++) {
			IClasspathEntry entry = entries[i];
			if(entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				if(entry.getPath().equals(new Path(folderPath))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Tests if the classpath file exists
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.AbstractProjectEditor.plugin.AbstractEditor#exists()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public boolean exists() {
		IFile classpath = getProject().getFile(CLASSPATH_FILE);
		return classpath.exists();
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
		IFile classpath = getProject().getFile(CLASSPATH_FILE);
		if(!classpath.exists()) {
			files.add(CLASSPATH_FILE);
		}
		return files;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#createFiles(Set)
	 * 
	 *      {@inheritDoc}
	 */
	public void createFiles(final Set<String> files) {
		if(files.contains(CLASSPATH_FILE)) {
			IFile classpath = getProject().getFile(CLASSPATH_FILE);
			if(!classpath.exists()) {
				InputStream is = getInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + "<?eclipse version=\"3.4\"?>\n" + "<classpath>\n" + "</classpath>\n"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$

				try {
					classpath.create(is, true, null);
				} catch (CoreException ex) {
					Activator.log.error(ex);
				}
			}
		}
	}

	public String[] getSourceFolders() {
		List<String> sourceFolders = new LinkedList<String>();
		IClasspathEntry[] entries = null;
		try {
			entries = this.javaProject.getRawClasspath();
		} catch (JavaModelException e) {
			Activator.log.error(e);
		}

		for(int i = 0; i < entries.length; i++) {
			IClasspathEntry entry = entries[i];
			if(entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				sourceFolders.add(entry.getPath().makeRelativeTo(javaProject.getPath()).toString());
			}
		}

		return sourceFolders.toArray(new String[sourceFolders.size()]);
	}

	public String[] getBinFolders() {
		List<String> binFolders = new LinkedList<String>();
		try {
			//General bin folder
			binFolders.add(javaProject.getOutputLocation().makeRelativeTo(javaProject.getPath()).toString());
		} catch (JavaModelException ex) {
			Activator.log.error(ex);
		}
		IClasspathEntry[] entries = null;
		try {
			entries = this.javaProject.getRawClasspath();
		} catch (JavaModelException e) {
			Activator.log.error(e);
		}

		for(int i = 0; i < entries.length; i++) {
			IClasspathEntry entry = entries[i];
			if(entry.getEntryKind() == IClasspathEntry.CPE_SOURCE) {
				if(entry.getOutputLocation() != null) {
					//Bin folder associated to each source folder
					binFolders.add(entry.getOutputLocation().makeRelativeTo(javaProject.getPath()).toString());
				}
			}
		}

		return binFolders.toArray(new String[binFolders.size()]);
	}
}
