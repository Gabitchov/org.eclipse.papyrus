/*****************************************************************************
 * Copyright (c) 2011 Nicolas Deblock & Cedric Dumoulin & Manuel Giles.
 *
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Nicolas Deblock  nico.deblock@gmail.com  - Initial transformation and implementation 
 * 	Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial transformation and implementation 
 * 	Manuel Giles	 giles.manu@live.fr		 - Initial transformation and implementation 
 *
 *****************************************************************************/ 

package org.eclipse.papyrus.java.generator.transfo.umltojdt;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class UmltojdtActivator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.java.generator.transfo.umltojdt";
	public static final String PATH_QVT_FILE = "/transforms/uml/uml2jdt2.qvto";

	// The shared instance
	private static UmltojdtActivator plugin;
	
	/**
	 * The constructor
	 */
	public UmltojdtActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static UmltojdtActivator getDefault() {
		return plugin;
	}

}
