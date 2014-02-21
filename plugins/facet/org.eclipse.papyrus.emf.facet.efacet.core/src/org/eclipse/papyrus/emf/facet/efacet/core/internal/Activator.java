/**
 * Copyright (c) 2011 Mia-Software.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Nicolas Guyomar (Mia-Software) - Bug 333553 - The user has not to deal with two files to create a facet
 */
package org.eclipse.papyrus.emf.facet.efacet.core.internal;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

public class Activator extends Plugin {

	private static BundleContext context;

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

	// The shared instance
	private static Activator plugin;

	public static Plugin getDefault() {
		return Activator.plugin;
	}

}
