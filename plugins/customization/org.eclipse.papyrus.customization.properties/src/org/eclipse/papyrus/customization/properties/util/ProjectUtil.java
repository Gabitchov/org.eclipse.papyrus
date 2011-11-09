/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.customization.properties.util;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.papyrus.customization.properties.Activator;
import org.eclipse.papyrus.views.properties.contexts.Context;
import org.eclipse.papyrus.views.properties.contexts.Section;

/**
 * The Eclipse Editors can only handle files from the workspace. However, when
 * customizing a Property view, we don't want to pollute the user's workspace.
 * The Customization Editor uses a hidden Project. The files are physically
 * stored in the plugin's preferences folder, in the workspace metadata.
 * These methods cannot be applied on contexts registered via plugin extensions,
 * as they are read-only. For such contexts, you need to first copy them,
 * and edit the copy.
 * 
 * @see CopyContextAction
 * 
 * @author Camille Letavernier
 */
public class ProjectUtil {

	/**
	 * The name of the customization's hidden project
	 */
	public static final String CUSTOM_PROJECT_NAME = "org.eclipse.papyrus.customization.properties.internal"; //$NON-NLS-1$

	/**
	 * 
	 * @param context
	 *        The context we want to edit
	 * @return
	 *         The IFile containing the given context. This IFile can be passed
	 *         to an Eclipse editor
	 * @throws CoreException
	 *         If an error occured
	 */
	public static IFile getContextFile(Context context) throws CoreException {
		IFolder projectFolder = getContextFolder(context);

		IFile contextFile = projectFolder.getFile(context.getName() + ".ctx"); //$NON-NLS-1$

		return contextFile;
	}

	/**
	 * @return the hidden IProject used by the customization plugin
	 * @throws CoreException
	 *         If an error occured
	 */
	public static IProject getContextProject() throws CoreException {
		IWorkspace workspace = ResourcesPlugin.getWorkspace();
		IProject custom = workspace.getRoot().getProject(CUSTOM_PROJECT_NAME);
		if(!custom.exists()) {
			IProjectDescription description = workspace.newProjectDescription(CUSTOM_PROJECT_NAME);
			IPath customProjectPath = Activator.getDefault().getPreferencesPath().append("/" + CUSTOM_PROJECT_NAME); //$NON-NLS-1$
			description.setLocation(customProjectPath);
			custom.create(description, null);
			custom.open(null);
		}

		if(!custom.isOpen()) {
			custom.open(null);
		}

		custom.setHidden(true);
		workspace.getRoot().refreshLocal(IResource.DEPTH_INFINITE, null);

		return custom;
	}

	/**
	 * Return the IFolder containing the given context
	 * 
	 * @param context
	 *        The context for which we want to get its IFolder
	 * @return
	 *         The IFolder containing the given context
	 * @throws CoreException
	 *         If an error occured
	 */
	public static IFolder getContextFolder(Context context) throws CoreException {
		IProject project = getContextProject();

		IFolder projectFolder = project.getFolder(context.getName());

		if(!projectFolder.exists()) {
			String referencedFolderPath = new File(context.eResource().getURI().toFileString()).getParent();
			projectFolder.createLink(new Path(referencedFolderPath), IResource.REPLACE, null);
		}

		return projectFolder;
	}

	/**
	 * Return the IFile containing the section's XWT Resource
	 * 
	 * @param section
	 *        The section we want to edit
	 * @return
	 *         The IFile containing the section's XWT Resource
	 * @throws CoreException
	 *         If an error occured
	 */
	public static IFile getSectionFile(Section section) throws CoreException {
		IFolder projectFolder = getContextFolder((Context)(section.eContainer()).eContainer());
		IFile sectionFile = projectFolder.getFile(section.getSectionFile());
		return sectionFile;
	}
}
