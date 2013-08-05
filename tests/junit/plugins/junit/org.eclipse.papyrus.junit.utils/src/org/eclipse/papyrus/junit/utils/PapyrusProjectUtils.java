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
import java.io.InputStream;
import java.net.URL;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
import org.junit.Assert;
import org.osgi.framework.Bundle;

public class PapyrusProjectUtils {

	private PapyrusProjectUtils() {
		//to prevent instanciation
	}

	/**
	 * 
	 * @param project
	 * @param bundle
	 * @param sourcePath
	 *        should be something like /model/
	 * @param fileRootName
	 * @throws IOException
	 * @throws CoreException
	 */
	public static final IFile copyPapyrusModel(final IProject project, final Bundle bundle, final String sourcePath, final String fileRootName) throws CoreException, IOException {

		String diSourcePath = sourcePath + fileRootName + "." + SashModel.MODEL_FILE_EXTENSION;
		String notationSourcePath = sourcePath + fileRootName + "." + NotationModel.NOTATION_FILE_EXTENSION;
		String umlSourcePath = sourcePath + fileRootName + "." + UmlModel.UML_FILE_EXTENSION;

		final IFile emptyModel_di = copyIFile(diSourcePath, bundle, project, fileRootName + "." + SashModel.MODEL_FILE_EXTENSION);
		copyIFile(notationSourcePath, bundle, project, fileRootName + "." + NotationModel.NOTATION_FILE_EXTENSION);
		copyIFile(umlSourcePath, bundle, project, fileRootName + "." + UmlModel.UML_FILE_EXTENSION);

		return emptyModel_di;
	}

	public static IFile copyIFile(String sourcePath, Bundle sourceBundle, IProject targetProject, String targetFileName) throws CoreException, IOException {
		final IFile createdFile = targetProject.getFile(targetFileName);
		if(createdFile.getParent() instanceof IFolder) {
			createRecursiveFolder((IFolder)createdFile.getParent());
		}
		URL bundleResource = sourceBundle.getResource(sourcePath);
		Assert.assertNotNull("Cannot find bundle resource: " + sourcePath, bundleResource);
		InputStream bundleResourceStream = bundleResource.openStream();
		createdFile.create(bundleResourceStream, true, new NullProgressMonitor());
		return createdFile;
	}

	public static void createRecursiveFolder(IFolder folderToCreate) throws CoreException {
		if(folderToCreate.exists()) {
			return;
		}

		if(folderToCreate.getParent() instanceof IFolder) {
			createRecursiveFolder((IFolder)folderToCreate.getParent());
		}
		folderToCreate.create(true, true, new NullProgressMonitor());
	}
}
