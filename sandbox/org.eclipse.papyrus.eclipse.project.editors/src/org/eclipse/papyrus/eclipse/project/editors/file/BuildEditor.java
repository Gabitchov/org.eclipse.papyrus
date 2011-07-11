/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *  Vincent Lorenzo (CEA-LIST) vincent.lorenzo@cea.fr
 *****************************************************************************/
package org.eclipse.papyrus.eclipse.project.editors.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.papyrus.eclipse.project.editors.Activator;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor;
import org.eclipse.papyrus.widgets.util.FileUtil;

public class BuildEditor extends AbstractFileEditor implements IBuildEditor {

	/** the build config */
	private Properties buildConfig;

	/** the buidl file */
	private File buildFile;


	/**
	 * 
	 * Constructor.
	 * 
	 * @param project
	 *        the eclipse project
	 */
	public BuildEditor(final IProject project) {
		super(project);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#init()
	 * 
	 *      {@inheritDoc}
	 */
	public void init() {
		this.buildConfig = new Properties();
		this.buildFile = getBuildProperties();
		if(this.buildFile != null && this.buildFile.exists()) {
			try {
				this.buildConfig.load(new FileInputStream(this.buildFile));
			} catch (FileNotFoundException e) {
				Activator.log.error(e);
			} catch (IOException e) {
				Activator.log.error(e);
			}
		}
	}


	private File getBuildProperties() {
		return this.buildFile = FileUtil.getWorkspaceFile("/" + getProject().getName() + "/" + BUILD_PROPERTIES_FILE); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#addToBuild(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void addToBuild(final String path) {
		if(exists() && !isRegistred(path)) {
			String currentValue = this.buildConfig.getProperty(BUILD_KEY);
			if(currentValue == null || currentValue.trim().equals("")) { //$NON-NLS-1$
				this.buildConfig.setProperty(BUILD_KEY, path);
			} else {
				this.buildConfig.setProperty(BUILD_KEY, currentValue + "," + path); //$NON-NLS-1$
			}
		}
	}

	/**
	 * 
	 * @throws Throwable
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#save()
	 * 
	 *      {@inheritDoc}
	 */
	public void save() throws Throwable {
		if(exists()) {
			this.buildConfig.store(new FileOutputStream(this.buildFile), ""); //$NON-NLS-1$
		}
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#registerSourceFolder(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void registerSourceFolder(final String path) {
		if(exists() && !isRegistred(path)) {
			String currentValue = this.buildConfig.getProperty(SOURCE_FOLDER_KEY);
			if(currentValue == null || currentValue.trim().equals("")) { //$NON-NLS-1$
				this.buildConfig.setProperty(SOURCE_FOLDER_KEY, path);
			} else {
				this.buildConfig.setProperty(SOURCE_FOLDER_KEY, currentValue + "," + path); //$NON-NLS-1$
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#isRegistred(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public boolean isRegistred(final String path) {
		return Arrays.asList(getSourceFolders()).contains(path);
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.file.AbstractFileEditor#getMissingFiles()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public Set<String> getMissingFiles() {
		Set<String> files = super.getMissingFiles();
		if(!getBuildProperties().exists()) {
			files.add(BUILD_PROPERTIES_FILE);
		}
		return files;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#getSourceFolders()
	 * 
	 *      {@inheritDoc}
	 */
	public String[] getSourceFolders() {
		if(exists()) {
			String currentValue = this.buildConfig.getProperty(SOURCE_FOLDER_KEY);
			if(currentValue != null) {
				String[] values = currentValue.split(","); //$NON-NLS-1$
				return values;
			}
		}
		return new String[0];

	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.AbstractProjectEditor#exists()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
	public boolean exists() {
		return this.buildFile.getParentFile().exists() && this.buildFile.exists() && super.exists();
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#createFiles(Set)
	 * 
	 *      {@inheritDoc}
	 */
	public void createFiles(final Set<String> files) {
		if(files.contains(BUILD_PROPERTIES_FILE)) {
			if(!this.buildFile.exists()) {
				if(!this.buildFile.getParentFile().exists()) {
					this.buildFile.getParentFile().mkdirs();
				}
				try {
					this.buildFile.createNewFile();
					init();
				} catch (IOException e) {
					Activator.log.error(e);
				}
			}
		}
	}
}
