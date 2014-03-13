/*******************************************************************************
 * Copyright (c) 2010-2013 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 339991 - don't use internal APIs in org.eclipse.papyrus.emf.facet.util.core.internal.BuildPropertiesUtils
 *    Laurent Pichierri (Soft-Maint) - Bug 371204 - Compatibility with Helios
 *    Gregoire Dupe (Mia-Software) - Bug 371204 - Compatibility with Helios
 *    Gregoire Dupe (Mia-Software) - Bug 417789 - org.eclipse.papyrus.emf.facet.util.core should not so much dependencies
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.util.pde.core.internal;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Method;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.papyrus.emf.facet.util.core.Logger;
import org.eclipse.papyrus.emf.facet.util.pde.core.internal.exception.PdeCoreUtilsRuntimeException;
import org.eclipse.pde.core.IEditableModel;
import org.eclipse.pde.core.build.IBuild;
import org.eclipse.pde.core.build.IBuildEntry;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginModelBase;
import org.eclipse.pde.core.plugin.PluginRegistry;

public final class BuildPropertiesUtils {

	// This class has been copied from org.eclipse.papyrus.emf.facet.infra.common.core.internal.utils.BuildPropertiesUtils
	
	private BuildPropertiesUtils() {
		// utilities class
	}

	/**
	 * Get the build model of an Eclipse plug-in
	 * 
	 * @param model
	 *            a plug-in's PDE model
	 * @return a build model or <code>null</code> if the build.properties file
	 *         does not exist
	 * @throws CoreException
	 */
	public static IBuildModel getBuildModel(final IPluginModelBase model) throws CoreException {
		final IProject project = model.getUnderlyingResource().getProject();
		final IPluginModelBase pluginModelBase = PluginRegistry.findModel(project);
		//Here we use a reflexive call to be able to build against an Helios platform.
		//This method will build with Helios, but will fail at runtime.
		//We do not have a better solution. Otherwise we would have to use an internal API.
		//We prefer some loose of functionality with Helios that to use internal API.
		IBuildModel buildModel  = null;
		try {
			final Class<? extends IPluginModelBase> class1 = pluginModelBase.getClass();
			final Method method = class1.getMethod("getBuildModel"); //$NON-NLS-1$
			if (method != null) {
				buildModel = (IBuildModel) method.invoke(pluginModelBase);
			}
		} catch (Exception e) {
			Logger.logError(e, Activator.getDefault());
		}
		return buildModel;
	}

	/**
	 * @param project
	 *            the project for which to get a build model top level object
	 * @return a build model top level object or <code>null</code> if the
	 *         build.properties file does not exist
	 * @throws CoreException
	 */
	public static IBuild getBuild(final IProject project) throws CoreException {
		IBuild result = null; 
		final IPluginModelBase pluginModel = PluginRegistry.findModel(project);
		if (pluginModel != null) {
			final IBuildModel buildModel = getBuildModel(pluginModel);
			if (buildModel != null) {
				result = buildModel.getBuild();
			}
		}
		return result;
	}

	/**
	 * @param elementFile
	 *            the file whose presence in the build.properties is being
	 *            tested
	 * @return whether the file is in the build.properties (<code>false</code>
	 *         if the build.properties file does not exist)
	 * @throws CoreException
	 */
	public static boolean isInBuild(final IFile elementFile) throws CoreException {
		final IProject project = elementFile.getProject();
		final IPath filePath = elementFile.getFullPath().removeFirstSegments(1);
		final IBuild build = getBuild(project);
		boolean result = false;
		if (build != null) {
			final IBuildEntry entry = build.getEntry(IBuildEntry.BIN_INCLUDES);
			if (entry != null) {
				final String[] tokens = entry.getTokens();
				for (String token : tokens) {
					final IPath path = new Path(token);
					// if "abc/" is included, then "abc/def/" is too
					if (path.isPrefixOf(filePath)) {
						result = true;
					}
				}
			}
		}
		return result;
	}

	public static void addToBuild(final IFile elementFile) throws CoreException {
		final IProject project = elementFile.getProject();
		if (isInBuild(elementFile)) {
			return;
		}
		final IPath filePath = elementFile.getFullPath().removeFirstSegments(1);
		final IPluginModelBase pluginModel = PluginRegistry.findModel(project);
		final IFile buildProperties = elementFile.getProject().getFile("build.properties"); //$NON-NLS-1$
		if (!buildProperties.exists()) {
			buildProperties.create(new ByteArrayInputStream(new byte[0]), true,
					new NullProgressMonitor());
		}
		final IBuildModel buildModel = getBuildModel(pluginModel);
		if (buildModel == null) {
			throw new PdeCoreUtilsRuntimeException("Couldn't get build model"); //$NON-NLS-1$
		}
		final IBuild build = buildModel.getBuild();
		IBuildEntry entry = build.getEntry(IBuildEntry.BIN_INCLUDES);
		// if entry "bin.includes" does not exist, then create it
		if (entry == null) {
			entry = buildModel.getFactory().createEntry(IBuildEntry.BIN_INCLUDES);
			build.add(entry);
		}
		entry.addToken(filePath.toPortableString());
		((IEditableModel) buildModel).save();
	}
}
