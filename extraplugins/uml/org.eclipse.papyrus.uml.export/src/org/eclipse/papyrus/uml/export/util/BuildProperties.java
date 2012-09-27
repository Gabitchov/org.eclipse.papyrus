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
 *  Saadia DHOUIB (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.export.util;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;
import org.eclipse.pde.internal.core.build.WorkspaceBuildModel;

// TODO: Auto-generated Javadoc
/**
 * The Class BuildProperties.
 */
@SuppressWarnings("restriction")
public class BuildProperties {

	/** The Constant OVERWRITE_BUILD_PROPERTY. */
	public static final String OVERWRITE_BUILD_PROPERTY = "overwrite build property?";

	/** The Constant NL. */
	public static final String NL = System.getProperty("line.separator");

	/** The project. */
	private final IProject project;

	/** The its build model. */
	private IBuildModel itsBuildModel;

	/**
	 * Instantiates a new builds the properties.
	 * 
	 * @param project
	 *        the project
	 */
	public BuildProperties(IProject project) {
		this.project = project;
	}

	/**
	 * adds or overwrites an entry in the 'build.properties'.<br>
	 * returns <b>true</b> if adding was successful,<br>
	 * <b>false</b> is dialog did not confirm adding
	 * 
	 * @param key
	 *        the build property's name
	 * @param value
	 *        the build property's value
	 * @return <b>true</b> if adding was successful,<br>
	 *         <b>false</b> is dialog did not confirm adding
	 * @throws CoreException
	 *         the core exception
	 */
	public boolean addBuildEntry(String key, String value) throws CoreException {
		Assert.isNotNull(key);
		Assert.isNotNull(value);
		boolean writeEntry = true;
		if(hasBuildEntry(key)) {
			if(getBuild().getEntry(key).contains(value)) {
				return true;
			}


			removeExistingBuildEntry(key);

		}

		if(writeEntry) {
			IBuildModel buildModel = getBuildModel();
			IBuildEntry buildEntry = buildModel.getFactory().createEntry(key);
			buildEntry.addToken(value);
			getBuild().add(buildEntry);

			((WorkspaceBuildModel)buildModel).save();
		}
		return writeEntry;
	}



	/**
	 * removes an entry with the given name from the 'build.properties'
	 * 
	 * @param key
	 *        the build property's name
	 * @throws CoreException
	 *         the core exception
	 */
	public void removeExistingBuildEntry(String key) throws CoreException {
		IBuildEntry entry = getBuild().getEntry(key);
		if(entry != null) {
			getBuild().remove(entry);
		}
	}

	/**
	 * returns whether an entry exists for the given key.
	 * 
	 * @param key
	 *        the build property's name
	 * @return true, if successful
	 */
	public boolean hasBuildEntry(final String key) {
		return getBuild().getEntry(key) != null;
	}



	/**
	 * Gets the builds the.
	 * 
	 * @return the builds the
	 */
	private IBuild getBuild() {
		IBuildModel buildModel = getBuildModel();
		if(buildModel == null) {
			return null;
		}
		return buildModel.getBuild();
	}


	/**
	 * Gets the properties.
	 * 
	 * @param key
	 *        the key
	 * @return the properties
	 */
	public String[] getProperties(String key) {
		return getBuild().getEntry(key).getTokens();
	}



	/**
	 * returns the Eclipse BuildModel.
	 * 
	 * @return the Eclipse BuildModel
	 */
	private IBuildModel getBuildModel() {
		if(itsBuildModel == null) {
			IPluginModelBase pluginModel = PluginRegistry.findModel(this.project);
			itsBuildModel = createBuildModel(pluginModel);
		}
		return itsBuildModel;
	}


	/**
	 * see org.eclipse.pde.internal.core.ClasspathUtilCore.getBuild
	 * 
	 * @param model
	 *        the model
	 * @return the i build model
	 */
	private IBuildModel createBuildModel(final IPluginModelBase model) {
		IProject project = model.getUnderlyingResource().getProject();
		IFile buildFile = project.getFile("build.properties"); //$NON-NLS-1$
		if(!buildFile.exists()) {
			return null;
		}
		WorkspaceBuildModel buildModel = new WorkspaceBuildModel(buildFile);
		buildModel.load();
		return buildModel;
	}

}
