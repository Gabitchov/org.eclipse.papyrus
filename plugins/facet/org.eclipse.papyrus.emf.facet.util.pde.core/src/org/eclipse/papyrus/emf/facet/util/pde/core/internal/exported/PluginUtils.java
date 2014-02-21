/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  Grégoire Dupé (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.pde.core.internal.exported;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.papyrus.emf.facet.util.core.internal.exported.IFilter;
import org.osgi.framework.Bundle;

/**
 * @since 0.4
 */
public final class PluginUtils {

	private PluginUtils() {
		// Must not be used.
	}

	public static boolean isInPluginProject(final IPath path)
			throws CoreException {
		return org.eclipse.papyrus.emf.facet.util.pde.core.internal.PluginUtils
				.isInPluginProject(path);
	}

	public static void register(final IFile file,
			final String extensionPointId, final String elementName) {
		org.eclipse.papyrus.emf.facet.util.pde.core.internal.PluginUtils.register(file,
				extensionPointId, elementName);
	}

	public static boolean isRegistered(final IFile iFile,
			final String extensionPointId) {
		return org.eclipse.papyrus.emf.facet.util.pde.core.internal.PluginUtils
				.isRegistered(iFile, extensionPointId);
	}

	public static void configureAsPluginProject(final IProject project)
			throws CoreException, IOException {
		org.eclipse.papyrus.emf.facet.util.pde.core.internal.PluginUtils
				.configureAsPluginProject(project);
	}

	public static boolean isPluginProject(final IProject project)
			throws CoreException {
		return org.eclipse.papyrus.emf.facet.util.pde.core.internal.PluginUtils
				.isPluginProject(project);
	}

	public static IProject importPlugin(final Bundle bundle,
			final IFilter<String> filter) throws CoreException {
		return org.eclipse.papyrus.emf.facet.util.pde.core.internal.PluginUtils
				.importPlugin(bundle, filter);
	}

	public static IProject importPlugin(final Bundle bundle)
			throws CoreException {
		return org.eclipse.papyrus.emf.facet.util.pde.core.internal.PluginUtils
				.importPlugin(bundle);
	}
}
