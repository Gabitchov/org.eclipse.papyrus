/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi SCHNEKENBURGER (CEA LIST) Remi.schnekenburger@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.uml.tools.utils;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.core.runtime.Status;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends Plugin {

	// The plug-in ID
	/**
	 * 
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.uml.tools.utils";

	// The shared instance
	/**
	 * 
	 */
	private static Activator plugin;

	// Resource bundle.
	/**
	 * 
	 */
	private ResourceBundle resourceBundle;
	
	public static LogHelper log;

	/**
	 * The constructor.
	 */
	public Activator() {
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle("com.cea.papyrus.umlutils.PluginManagerResources");
		} catch (MissingResourceException x) {
			resourceBundle = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	/**
	 * 
	 * 
	 * @param context
	 * 
	 * @throws Exception
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		log = new LogHelper(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	/**
	 * 
	 * 
	 * @param context
	 * 
	 * @throws Exception
	 */
	@Override
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
	 * Returns the string from the plugin's resource bundle, or 'key' if not found.
	 * 
	 * @param key
	 * 
	 * @return
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = Activator.getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,.
	 * 
	 * @return
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/**
	 * Logs a warning message in the plugin log
	 * 
	 * @param message
	 *        the message to log
	 */
	public static void logWarning(String message) {
		getDefault().getLog().log(new Status(IStatus.WARNING, Activator.PLUGIN_ID, message));
	}

	/**
	 * Logs an error message in the plugin log
	 * 
	 * @param message
	 *        the message to log
	 */
	public static void logError(String message) {
		getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, message));
	}

	/**
	 * Logs an information message in the plugin log
	 * 
	 * @param message
	 *        the message to log
	 */
	public static void logInfo(String message) {
		getDefault().getLog().log(new Status(IStatus.INFO, Activator.PLUGIN_ID, message));
	}

	/**
	 * Logs an error message in the plugin log
	 * 
	 * @param exception
	 *        the exception to log
	 */
	public static void logException(Exception exception) {
		getDefault().getLog().log(
				new Status(IStatus.ERROR, Activator.PLUGIN_ID, exception.getLocalizedMessage(), exception));
	}
}
