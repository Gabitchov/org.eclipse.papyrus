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
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.junit.utils;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;

/**
 * 
 * Useful methods to manipulate files
 * 
 */
public class FilesUtils {

	/**
	 * 
	 * @param testProject
	 *        the destination projecr
	 * @param newFilename
	 *        the new name of the copied file
	 * @param fileURL
	 *        the URl of the file to copy
	 * @throws IOException
	 * @throws CoreException
	 */
	public static final void copyFiles(final IProject testProject, final String newFilename, final URL fileURL) throws CoreException, IOException {
		// Copy EmptyModel from bundle to the test project
		final IFile emptyModel = testProject.getFile(newFilename);
		emptyModel.create(fileURL.openStream(), true, new NullProgressMonitor());

	}
}
