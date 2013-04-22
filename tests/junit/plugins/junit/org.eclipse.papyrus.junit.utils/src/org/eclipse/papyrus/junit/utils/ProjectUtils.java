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

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Assert;

/**
 * 
 * Useful methods for projects
 * 
 */
public class ProjectUtils {

	private ProjectUtils() {
		// to prevent instanciation
	}

	/**
	 * 
	 * @param projectName
	 *        the name of the projecy
	 * @return
	 *         the created project
	 * @throws CoreException
	 */
	public static final IProject createProject(final String projectName) throws CoreException {
		final IWorkspace workspace = ResourcesPlugin.getWorkspace();
		final IProject testProject = workspace.getRoot().getProject(projectName);

		if(testProject.exists()) {
			testProject.delete(true, new NullProgressMonitor());
		}
		testProject.create(new NullProgressMonitor());
		testProject.open(new NullProgressMonitor());

		Assert.assertNotNull(testProject);
		return testProject;
	}


}
