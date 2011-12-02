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
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.util;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.papyrus.infra.widgets.Activator;

/**
 * A helper class for resolving files and path, either in the workspace or
 * on the File system
 * 
 * @author Camille Letavernier
 * @see StringFileSelector
 */
public class FileUtil {

	/**
	 * Returns the path to the IFile. If absolute is true, returns the path
	 * from the FileSystem. Otherwise, returns the path from the workspace.
	 * 
	 * @param file
	 * @param absolute
	 * @return
	 */
	public static String getPath(IFile file, boolean absolute) {
		if(absolute) {
			return file.getLocation().toString();
		}
		return file.getFullPath().toString();
	}

	/**
	 * Returns the IFile (Workspace file) from the given location.
	 * The location may be either absolute (From the FileSystem) or
	 * relative to the workspace root.
	 * 
	 * @param location
	 * @return
	 */
	public static IFile getIFile(String location) {
		//Search the file in the workspace
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		IPath path = new Path(location);
		IFile currentFile = null;
		try {
			currentFile = workspace.getFile(path);
		} catch (IllegalArgumentException ex) {
			//Ignore
		}

		//Then search it on the disk
		if(currentFile == null || !currentFile.exists()) {
			currentFile = workspace.getFileForLocation(path);
		}

		return currentFile;
	}

	/**
	 * Returns the Java File from the given location.
	 * The location may be either absolute (From the FileSystem) or
	 * relative to the workspace root.
	 * 
	 * @param location
	 * @return
	 */
	public static File getFile(String location) {
		IFile iFile = getIFile(location);
		if(iFile == null || !iFile.exists()) {
			return new File(location);
		}

		return new File(iFile.getLocationURI());
	}

	/**
	 * Returns the Java File from the given location.
	 * The location is relative to the workspace root.
	 * 
	 * @param location
	 * @return
	 */
	public static File getWorkspaceFile(String location) {
		IWorkspaceRoot workspace = ResourcesPlugin.getWorkspace().getRoot();
		IPath path = new Path(location);
		IFile currentFile = null;
		try {
			currentFile = workspace.getFile(path);
		} catch (IllegalArgumentException ex) {
			Activator.log.error(ex);
			return null;
		}

		return currentFile.getLocation().toFile();
	}
}
