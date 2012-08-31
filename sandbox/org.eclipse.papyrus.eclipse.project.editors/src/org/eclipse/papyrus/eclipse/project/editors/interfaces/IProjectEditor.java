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
package org.eclipse.papyrus.eclipse.project.editors.interfaces;

import java.net.URL;
import java.util.Set;

/**
 * 
 * This interface defines the methods for the ProjectEditor
 * 
 */
public interface IProjectEditor extends IFileEditor {

	/** the node buildSpec */
	public static final String BUILD_SPEC = "buildSpec"; //$NON-NLS-1$

	/** the node comment */
	public static final String COMMENT = "comment"; //$NON-NLS-1$

	/** the node name */
	public static final String NAME = "name"; //$NON-NLS-1$

	/** the node nature */
	public static final String NATURE = "nature"; //$NON-NLS-1$

	/** the node project description */
	public static final String PROJECT_DESCRIPTION = "projectDescription"; //$NON-NLS-1$

	/** the name of the project file */
	public static final String PROJECT_FILE = ".project"; //$NON-NLS-1$



	/**
	 * 
	 * @return
	 *         the missing nature for the project
	 */
	public Set<String> getMissingNature();

	/**
	 * 
	 * @param nature
	 *        a nature
	 * @return
	 *         <code>true</code> if the project has this nature
	 */
	public boolean hasNature(final String nature);

	/**
	 * 
	 * @return
	 *         the missing build command
	 */
	public Set<String> getMissingBuildCommand();

	/**
	 * 
	 * @param commands
	 *        the command to add
	 */
	public void addBuildCommands(Set<String> commands);

	/**
	 * 
	 * @param command
	 *        a build command
	 * @return
	 *         <code>true</code> if the project has the build command
	 */
	public boolean hasBuildCommand(String command);

	/**
	 * 
	 * @param url
	 *        the url of the file to copy
	 * @param fileDestinationPath
	 *        the destination path for the added file
	 */
	public void addFile(final URL url, final String fileDestinationPath, final boolean eraseExistingFile);
}
