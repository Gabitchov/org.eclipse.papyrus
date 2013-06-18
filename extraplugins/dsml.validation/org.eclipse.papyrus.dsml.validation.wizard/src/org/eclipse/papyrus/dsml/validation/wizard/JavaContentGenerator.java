/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Ernest Wozniak (CEA LIST) ernest.wozniak@cea.fr - Initial API and implementation
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - modification
 *****************************************************************************/
package org.eclipse.papyrus.dsml.validation.wizard;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.PlatformUI;
import org.eclipse.uml2.uml.Profile;

/**
 *this class generate java classes in the project 
 *
 */
public class JavaContentGenerator {

	/**
	 * Selected model files.
	 */
	protected List<IFile> files;

	protected Profile umlProfile;

	private IProject project;

	/** 
	 * 
	 * Constructor.
	 *
	 * @param project the content has to be filled in the given project
	 * @param umlProfile the uml profile
	 */
	public JavaContentGenerator(IProject project, Profile umlProfile) {
		this.project = project;
		this.umlProfile = umlProfile;
	}

	/**
	 * launch the generation of the content
	 */
	public void run() {
		IRunnableWithProgress operation = new IRunnableWithProgress() {
			public void run(IProgressMonitor monitor) {

				URI modelURI = umlProfile.eResource().getURI();

				try {
					IContainer target = project.getFolder("src");
					ClassesGenerator generator = new ClassesGenerator(modelURI,	target, getArguments());
					generator.doGenerate(monitor);
				} catch (IOException e) {
					IStatus status = new Status(IStatus.ERROR,Activator.PLUGIN_ID, e.getMessage(), e);
					Activator.getDefault().getLog().log(status);
				}
			}
		};
		try {
			PlatformUI.getWorkbench().getProgressService().run(true, true, operation);
		} catch (InvocationTargetException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,	e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		} catch (InterruptedException e) {
			IStatus status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,	e.getMessage(), e);
			Activator.getDefault().getLog().log(status);
		}
	}

	protected List<? extends Object> getArguments() {
		return new ArrayList<String>();
	}

}
