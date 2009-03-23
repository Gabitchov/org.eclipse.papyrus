/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package com.cea.papyrus.profile;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	/**
	 * 
	 */
	public static final String PLUGIN_ID = "com.cea.papyrus.profile";

	// The shared instance
	/**
	 * 
	 */
	private static Activator plugin;
	
	/**
	 * The constructor.
	 */
	public Activator() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	/**
	 * 
	 * 
	 * @param context 
	 * 
	 * @throws Exception 
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	/**
	 * 
	 * 
	 * @param context 
	 * 
	 * @throws Exception 
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}
	
	/**
	 * Logs an error into the plugin's log
	 * @param string the message of the error
	 */
	public static void logWarning(String string) {
		getDefault().getLog().log(new Status(
				IStatus.WARNING,
				PLUGIN_ID,
				string));
	}

	
	/**
	 * Logs an error into the plugin's log
	 * @param string the message of the error
	 */
	public static void logError(String string) {
		getDefault().getLog().log(new Status(
				IStatus.ERROR,
				PLUGIN_ID,
				string));
	}

}
