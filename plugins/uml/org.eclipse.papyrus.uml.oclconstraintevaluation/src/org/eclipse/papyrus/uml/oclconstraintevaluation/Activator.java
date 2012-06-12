/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.oclconstraintevaluation;

import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.internal.console.ConsoleManager;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * the ID of the plugin ocl constraint evaluation
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.uml.oclconstraintevaluation"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	private IConsoleManager fConsoleManager;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	
	/**
	 * Returns the console manager. The manager will be created lazily on 
	 * the first access.
	 * 
	 * @return IConsoleManager
	 */
	public IConsoleManager getConsoleManager() {
		if (fConsoleManager == null) {
			fConsoleManager = new ConsoleManager();
		}
		return fConsoleManager;
	}
	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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
	public static Activator getDefault() {
		return plugin;
	}

}
