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

/**
 * 
 * Editor for the build.properties
 * 
 */
public interface IBuildEditor extends IFileEditor {

	/** key for the bin */
	public final static String BUILD_KEY = "bin.includes"; //$NON-NLS-1$

	/** key for the source */
	public final static String SOURCE_FOLDER_KEY = "source.."; //$NON-NLS-1$

	/** name of the file build.properties */
	public static final String BUILD_PROPERTIES_FILE = "build.properties"; //$NON-NLS-1$

	/** the method to register a new source */
	void registerSourceFolder(String string);

	/** the method to add an element to the build */
	public void addToBuild(final String path);

	/**
	 * Returns <code>true</code> if the folder is registred
	 * 
	 * @param path
	 *        the path of a source folder
	 * @return
	 *         <code>true</code> if the folder is registered
	 */
	public boolean isRegistred(final String path);

	/**
	 * Returns all the registered source folders
	 * 
	 * @return
	 *         all the registered source folders
	 */
	public String[] getSourceFolders();
}
