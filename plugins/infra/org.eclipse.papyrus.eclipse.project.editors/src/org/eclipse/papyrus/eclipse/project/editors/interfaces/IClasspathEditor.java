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
package org.eclipse.papyrus.eclipse.project.editors.interfaces;


/**
 * 
 * This interface for the file .classpath
 * 
 */
public interface IClasspathEditor extends IFileEditor {

	/** the classpath file */
	public static final String CLASSPATH_FILE = ".classpath"; //$NON-NLS-1$

	/**
	 * add a source folder to the class path
	 * @param folderPath
	 */
	public void addSourceFolderToClasspath(final String folderPath);

	/**
	 * Tests if a folder is already registered in the classpath
	 * 
	 * @param folderPath
	 *        a folder path
	 * @return
	 *         <code>true</code> if the folderPath is already registered
	 */
	public boolean isSourceFolderRegistered(final String folderPath);

	/**
	 * 
	 * @return the source folders for this classpath
	 */
	public String[] getSourceFolders();

	/**
	 * 
	 * @return the bin folders for this classpath
	 */
	public String[] getBinFolders();
}
