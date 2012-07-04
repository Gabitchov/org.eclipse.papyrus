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

import java.util.Set;

import org.eclipse.core.resources.IProject;

/**
 * 
 * Interface to edit file
 * 
 */
public interface IFileEditor {

	/** test if all the required elements exist for the editor */
	public boolean exists();


	/** create the required elements for the editor */
	public abstract void create();

	/**
	 * a method to initialize the field of the editors
	 * This method should be called by the programmer AFTER the construciton of the element
	 */
	public abstract void init();

	/**
	 * 
	 * @return
	 *         the missing files for the project
	 */
	public Set<String> getMissingFiles();

	/**
	 * 
	 * @param files
	 *        create the required files
	 */
	public void createFiles(final Set<String> files);


	//TODO : Remove that "Throwable" exception...
	/** save the modification on the editor */
	public void save();

	/**
	 * 
	 * @return
	 *         the eclipse project
	 */
	public IProject getProject();

}
