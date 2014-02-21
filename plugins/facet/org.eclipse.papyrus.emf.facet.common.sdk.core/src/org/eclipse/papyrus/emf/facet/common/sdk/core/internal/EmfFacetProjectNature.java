/*******************************************************************************
 * Copyright (c) 2009-2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Fabien Giquel (Mia-Software)
 *    Nicolas Bros (Mia-Software) - Bug 375054 - Add validation warning for overlay on EClass
 *******************************************************************************/
package org.eclipse.emf.facet.common.sdk.core.internal;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IProjectNature;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.facet.common.sdk.core.internal.exported.CommonConstants;

/** The implementation of the EMF Facet project nature. */
public class EmfFacetProjectNature implements IProjectNature {

	/** The platform project this <code>IJavaProject</code> is based on */
	private IProject project;

	/** @see org.eclipse.core.resources.IProjectNature#configure() */
	public void configure() throws CoreException {
		// Add nature-specific information
		// for the project, such as adding a builder
		// to a project's build spec.
		final IProjectDescription projectDescription = this.project.getDescription();
		final ICommand[] oldBuildSpec = this.project.getDescription().getBuildSpec();
		final ICommand[] newBuildSpec = new ICommand[oldBuildSpec.length + 1];
		System.arraycopy(oldBuildSpec, 0, newBuildSpec, 0, oldBuildSpec.length);
		final ICommand command = this.project.getDescription().newCommand();
		command.setBuilderName(CommonConstants.BUILDER_NAME);
		newBuildSpec[oldBuildSpec.length] = command;
		projectDescription.setBuildSpec(newBuildSpec);
		this.project.setDescription(projectDescription, new NullProgressMonitor());
	}

	/** @see org.eclipse.core.resources.IProjectNature#deconfigure() */
	public void deconfigure() throws CoreException {
		// Remove the nature-specific information here.
	}

	/** @see org.eclipse.core.resources.IProjectNature#getProject() */
	public IProject getProject() {
		return this.project;
	}

	/** @see org.eclipse.core.resources.IProjectNature#setProject(org.eclipse.core.resources.IProject) */
	public void setProject(final IProject value) {
		this.project = value;
	}

}
