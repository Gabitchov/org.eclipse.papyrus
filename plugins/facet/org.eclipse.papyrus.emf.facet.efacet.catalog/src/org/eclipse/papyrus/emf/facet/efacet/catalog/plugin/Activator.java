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
package org.eclipse.papyrus.emf.facet.efacet.catalog.plugin;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @deprecated cf. https://bugs.eclipse.org/bugs/show_bug.cgi?id=373672
 */
@Deprecated
public class Activator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return Activator.context;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext)
	 */
	public void start(final BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
	}

	/*
	 * (non-Javadoc)
	 * @see org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(final BundleContext bundleContext) throws Exception {
		Activator.context = null;
	}

}
