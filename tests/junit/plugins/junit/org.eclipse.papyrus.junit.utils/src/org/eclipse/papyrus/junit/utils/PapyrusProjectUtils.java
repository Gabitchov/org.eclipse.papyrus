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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.papyrus.infra.core.resource.sasheditor.SashModel;
import org.eclipse.papyrus.infra.gmfdiag.common.model.NotationModel;
import org.eclipse.papyrus.uml.tools.model.UmlModel;
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
		final IFile emptyModel_di = project.getFile(fileRootName + "." + SashModel.MODEL_FILE_EXTENSION);
		final IFile emptyModel_no = project.getFile(fileRootName + "." + NotationModel.NOTATION_FILE_EXTENSION);
		final IFile emptyModel_uml = project.getFile(fileRootName + "." + UmlModel.UML_FILE_EXTENSION);

		emptyModel_di.create(bundle.getResource(sourcePath + fileRootName + "." + SashModel.MODEL_FILE_EXTENSION).openStream(), true, new NullProgressMonitor());
		emptyModel_no.create(bundle.getResource(sourcePath + fileRootName + "." + NotationModel.NOTATION_FILE_EXTENSION).openStream(), true, new NullProgressMonitor());
		emptyModel_uml.create(bundle.getResource(sourcePath + fileRootName + "." + UmlModel.UML_FILE_EXTENSION).openStream(), true, new NullProgressMonitor());

		return emptyModel_di;
	}
}
