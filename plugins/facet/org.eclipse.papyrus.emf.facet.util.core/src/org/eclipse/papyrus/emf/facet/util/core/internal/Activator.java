/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	 Gregoire Dupe (Mia-Software) - Bug 338811 - A model registration method in the interface ICatalogSetManager
 *   Nicolas Bros (Mia-Software) - Bug 340031 - NPE in org.eclipse.papyrus.emf.facet.util.core.Logger#log
 *   Nicolas Guyomar (Mia-Software) - Bug 340339 - Need some Utils class for Folder/File/Project management
 */
package org.eclipse.papyrus.emf.facet.util.core.internal;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

	public static final String PLUGIN_ID = "org.eclipse.papyrus.emf.facet.util.core"; //$NON-NLS-1$
	private static BundleContext context;
	private static Activator plugin;

	public static Plugin getDefault() {
		return Activator.plugin;
	}

	static BundleContext getContext() {
		return Activator.context;
	}

	@Override
	public void start(final BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		Activator.context = bundleContext;
		Activator.plugin = this;
	}

	@Override
	public void stop(final BundleContext bundleContext) throws Exception {
		Activator.context = null;
		Activator.plugin = null;
		super.stop(bundleContext);
	}

}
