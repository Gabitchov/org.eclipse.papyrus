/*******************************************************************************
 * Copyright (c) 2008 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.extensionpoints.editors;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.log.LogHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.extensionpoints.editors";

	// The shared instance
	private static Activator plugin;

	/** Logging helper */
    public static LogHelper log;
    
    /**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		// register the login helper
        log = new LogHelper(plugin);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		log = null;
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

	/**
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by its key.<BR>
	 * By default, it returns a default image. This image is the image placed in the directory <em>resources/icons/default.gif</em>
	 * 
	 * @param key
	 *        the key of the image
	 * @return the Image
	 */
	public static Image getImage(String key) {
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);
		if(image == null) {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, key);
			registry.put(key, desc);
			image = registry.get(key);
		}
		return image;
	}

	/**
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by its key and its owning
	 * plugin.<BR>
	 * 
	 * @param pluginID
	 *        the plugin id where to retrieve the image
	 * @param key
	 *        the key of the image
	 * @return the Image
	 */
	public static Image getImage(String pluginID, String key) {
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);
		if(image == null) {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(pluginID, key);
			registry.put(key, desc);
			image = registry.get(key);
		}
		return image;
	}

	/**
	 * Log a message and an exception in the plugin's log.
	 * 
	 * @param message
	 *        the message to log
	 * @param e
	 *        the exception to log
	 */
	public static void log(String message, Exception e) {
		getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK, message, e));
	}

	/**
	 * Log a message in the plugin's log.
	 * 
	 * @param message
	 *        the message to log
	 */
	public static void log(String message) {
		getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK, message, null));
	}

	/**
	 * Log a message in the plugin's log.
	 * 
	 * @param message
	 *        the message to log
	 */
	public static void log(Exception e) {
		getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.OK, e.getLocalizedMessage(), e));
	}

	/**
	 * Log a message in the plugin's log.
	 * 
	 * @param message
	 *        the message to log
	 */
	public static void debug(String message) {
		getDefault().getLog().log(new Status(IStatus.INFO, Activator.PLUGIN_ID, IStatus.OK, message, null));
	}

}
