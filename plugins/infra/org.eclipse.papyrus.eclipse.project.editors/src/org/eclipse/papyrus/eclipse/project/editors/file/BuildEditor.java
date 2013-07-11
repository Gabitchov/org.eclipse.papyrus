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
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.papyrus.eclipse.project.editors.Activator;
import org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor;
import org.eclipse.papyrus.infra.widgets.util.FileUtil;

public class BuildEditor extends AbstractFileEditor implements IBuildEditor {

	/** the build config */
	private Properties buildConfig;

	/** the buidl file */
	private File buildFile;

	/**
	 * The build key to edit
	 * Defaults to "bin.includes" (The eclipse standard binary build)
	 */
	private String buildKey = "bin.includes"; //$NON-NLS-1$


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
	 * Constructor.
	 * 
	 * @param project
	 *        the eclipse project
	 * @param buildKey
	 *        the build key to edit. If null, the "bin.includes" key will be used
	 * 
	 * @see IBuildEditor#BINARY_BUILD
	 * @see IBuildEditor#SOURCE_BUILD
	 */
	public BuildEditor(final IProject project, String buildKey) {
		super(project);
		if(buildKey != null) {
			this.buildKey = buildKey;
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.project.ProjectEditor#init()
	 * 
	 *      {@inheritDoc}
	 */
	@Override
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
		if(exists()) {
			String currentValue = this.buildConfig.getProperty(buildKey);
			if(Arrays.asList(getElementsInBuild()).contains(path)) {
				return;
			}
			if(currentValue == null || currentValue.trim().equals("")) { //$NON-NLS-1$
				this.buildConfig.setProperty(buildKey, path);
			} else {
				this.buildConfig.setProperty(buildKey, currentValue + "," + path); //$NON-NLS-1$
			}
		}
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#removeFromBuild(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void removeFromBuild(String path) {
		if(isRegisteredSourceFolder(path)) {
			//Get the files from the build
			List<String> allFiles = Arrays.asList(getElementsInBuild());

			//Clear the build
			this.buildConfig.setProperty(buildKey, "");

			//Recreate the build without the removed files
			for(String filePath : allFiles) {
				if(!filePath.equals(path)) {
					addToBuild(filePath);
				}
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
	public void save() {
		if(exists()) {
			try {
				this.buildConfig.store(new FileOutputStream(this.buildFile), "");
			} catch (FileNotFoundException ex) {
				Activator.log.error(ex);
			} catch (IOException ex) {
				Activator.log.error(ex);
			}
		}
	}


	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#registerSourceFolder(java.lang.String)
	 * 
	 *      {@inheritDoc}
	 */
	public void registerSourceFolder(final String path) {
		if(exists() && !isRegisteredSourceFolder(path)) {
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
	public boolean isRegisteredSourceFolder(final String path) {
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
			String currentValue = this.buildConfig.getProperty(SOURCE_FOLDER_KEY, "").replaceAll("\t|\r|\n", "").trim();
			String[] values = currentValue.split(","); //$NON-NLS-1$
			return values;
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

	/**
	 * 
	 * @see org.eclipse.papyrus.eclipse.project.editors.interfaces.IBuildEditor#getElementsInBuild()
	 * 
	 *      {@inheritDoc}
	 */
	public String[] getElementsInBuild() {
		String value = this.buildConfig.getProperty(buildKey);
		return splitValues(value);
	}

	private String[] splitValues(String value) {
		if(value == null) {
			return new String[0];
		}
		return value.replace("\t|\r|\n", "").split(","); //$NON-NLS-1$ //$NON-NLS-2$
	}

	public void registerBinFolder(String binFolder) {
		if(isRegisteredBinFolder(binFolder)) {
			return;
		}

		String value = this.buildConfig.getProperty(BIN_KEY, ""); //$NON-NLS-1$
		if(value.trim().equals("")) { //$NON-NLS-1$
			value = binFolder;
		} else {
			value = value + "," + binFolder;
		}
		this.buildConfig.setProperty(BIN_KEY, value);
	}

	public boolean isRegisteredBinFolder(String binFolder) {
		List<String> folders = Arrays.asList(splitValues(this.buildConfig.getProperty(BIN_KEY, ""))); //$NON-NLS-1$
		return folders.contains(binFolder);
	}
}
