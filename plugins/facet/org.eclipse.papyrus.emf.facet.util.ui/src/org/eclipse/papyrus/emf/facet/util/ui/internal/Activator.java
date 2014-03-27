/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.ui.internal;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

@SuppressWarnings("PMD.UseSingleton")
// @SuppressWarnings("PMD.UseSingleton") We cannot conforms to this rule because
// this class is an Eclipse plug-in activator which will be instantiated by the
// Eclipse framework.
public class Activator extends Plugin {

	private static Activator plugin;

	@Override
	@SuppressWarnings("PMD.SignatureDeclareThrowsException")
	// @SuppressWarnings("PMD.SignatureDeclareThrowsException") We have to use
	// this signature because this is an override of an Eclipse framework's
	// method.
	public void start(final BundleContext bundleContext) throws Exception {
		super.start(bundleContext);
		Activator.plugin = this;
	}

	@Override
	@SuppressWarnings({ "PMD.SignatureDeclareThrowsException",
			"PMD.NullAssignment" })
	// @SuppressWarnings("PMD.SignatureDeclareThrowsException") We have to use
	// this signature because this is an override of an Eclipse framework's
	// method.
	// @SuppressWarnings("PMD.NullAssignment")
	// No choice to right it in another way : this is an Eclipse pattern.
	public void stop(final BundleContext bundleContext) throws Exception {
		Activator.plugin = null;
		super.stop(bundleContext);
	}

	public static Plugin getDefault() {
		return Activator.plugin;
	}

}
