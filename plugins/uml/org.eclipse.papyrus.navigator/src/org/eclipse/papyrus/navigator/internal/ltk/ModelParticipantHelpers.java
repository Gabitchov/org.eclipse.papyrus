/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a> - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.navigator.internal.ltk;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.papyrus.core.utils.DiResourceSet;

public class ModelParticipantHelpers {

	public static List<IFile> getRelatedFiles(IFile file) {

		List<IFile> relatedFiles = new ArrayList<IFile>();

		IContainer parent = file.getParent();
		IPath resourcePath = file.getFullPath().removeFileExtension();
		IFile diFile = parent.getFile(resourcePath.addFileExtension(DiResourceSet.DI_FILE_EXTENSION).makeRelativeTo(parent.getFullPath()));

		if(diFile.exists()) {
			try {
				for(IResource r : parent.members()) {
					IPath path = r.getFullPath();
					if(path.removeFileExtension().equals(resourcePath)) {
						// Only add the change if the resource exists
						IFile childFile = parent.getFile(path.makeRelativeTo(parent.getFullPath()));
						if(childFile.exists()) {
							relatedFiles.add(childFile);
						}
					}
				}
			} catch (CoreException e) {
			}
		}
		return relatedFiles;
	}
}
