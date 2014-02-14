/*******************************************************************************
 * Copyright (c) 2012 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Gregoire Dupe (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 *******************************************************************************/
package org.eclipse.emf.facet.util.pde.core.internal.exported;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.pde.core.build.IBuildModel;
import org.eclipse.pde.core.plugin.IPluginModelBase;

/**
 * @since 0.3
 */
public final class BuildPropertiesUtils {

	private BuildPropertiesUtils() {
		// Must not be used
	}

	public static void addToBuild(final IFile file) throws CoreException {
		org.eclipse.emf.facet.util.pde.core.internal.BuildPropertiesUtils
				.addToBuild(file);
	}

	public static IBuildModel getBuildModel(final IPluginModelBase model)
			throws CoreException {
		return org.eclipse.emf.facet.util.pde.core.internal.BuildPropertiesUtils
				.getBuildModel(model);
	}
}
