/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.papyrus.uml.diagram.common.Activator;

/**
 * Provider for Palette that uses a XML file for palette definition, located in the workspace.
 */
public class WorkspacePaletteProvider extends LocalPaletteProvider {

	/**
	 * Returns the file using the specified path in the plugin state location
	 * 
	 * @param path
	 *        the path to the file
	 * @return the file using the specified path in the plugin state location,
	 *         even if it does not exists. In the latter case, the method {@link File#exists()} returns <code>false</code>.
	 */
	@Override
	public InputStream getXmlFile(String path) throws IOException {
		// create the platform URI from this path
		IPath fullPath = ResourcesPlugin.getWorkspace().getRoot().getFullPath().append(path);
		 IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(fullPath);
		 try {
			 if(file!=null && file.exists()) {
				 return file.getContents();	 
			 }
		} catch (CoreException e) {
			Activator.log.error(e);
		}
		 return null;
	}

}
