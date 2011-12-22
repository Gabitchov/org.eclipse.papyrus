/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.properties.tabbedproperties.core;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	/** Plugin id */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.views.properties.tabbedproperties.core"; //$NON-NLS-1$

	/**
	 * singleton instance of this plugin.
	 */
	private static Activator plugin;

	/**
	 * Creates a new Activator.
	 */
	public Activator() {
		plugin = this;
	}

	/**
	 * {@inheritDoc}
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
	}

	/**
	 * {@inheritDoc}
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
	 * 
	 * @param string
	 *        the message of the error
	 */
	public static void logWarning(String string) {
		getDefault().getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, string));
	}

	/**
	 * Logs an error into the plugin's log
	 * 
	 * @param string
	 *        the message of the error
	 */
	public static void logError(String string) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, string));
	}

	/**
	 * Logs an exception into the plugin's log
	 * 
	 * @param exception
	 *        the exception to log
	 */
	public static void logException(Exception exception) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, exception.getLocalizedMessage(), exception));
	}

}
