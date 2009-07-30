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
 *  Remi Schnekenburger (CEA LIST) Remi.Schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.parsers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class PapyrusParsersPlugin extends AbstractUIPlugin {

	// The plug-in ID
	/**
	 * 
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.classdiagram.parsers";

	// path to the default image
	/**
     * 
     */
	public static final String DEFAULT_IMAGE = "resources/icons/default.gif";

	// The shared instance
	/**
	 * 
	 */
	private static PapyrusParsersPlugin plugin;

	/**
	 * The constructor.
	 */
	public PapyrusParsersPlugin() {
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
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
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
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
	public static PapyrusParsersPlugin getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 * 
	 * @param path
	 *            the path
	 * 
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by its key.<BR>
	 * By default, it returns a default image. This image is the image placed in the directory
	 * <em>resources/icons/default.gif</em>
	 * 
	 * @param key
	 *            the key of the image
	 * 
	 * @return the Image
	 */
	public static Image getImage(String key) {
		ImageRegistry registry = PapyrusParsersPlugin.getDefault().getImageRegistry();
		Image image = registry.get(key);
		if (image == null) {
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(PapyrusParsersPlugin.PLUGIN_ID, key);
			registry.put(key, desc);
			image = registry.get(key);
		}
		if ((image == null) && !key.equals(DEFAULT_IMAGE)) {
			image = getImage(DEFAULT_IMAGE);
		}
		return image;
	}

	/**
	 * Logs an error message in the Plugin's Log
	 * 
	 * @param message
	 *            the message to log
	 */
	public static void logError(String message) {
		getDefault().getLog().log(new Status(IStatus.ERROR, PLUGIN_ID, message));
	}

	/**
	 * Logs a warning message in the Plugin's Log
	 * 
	 * @param message
	 *            the message to log
	 */
	public static void logWarning(String message) {
		getDefault().getLog().log(new Status(IStatus.WARNING, PLUGIN_ID, message));
	}

	/**
	 * Logs an information message in the Plugin's Log
	 * 
	 * @param message
	 *            the message to log
	 */
	public static void logInfo(String message) {
		getDefault().getLog().log(new Status(IStatus.INFO, PLUGIN_ID, message));
	}

	/**
	 * Logs an exception in the Plugin's Log
	 * 
	 * @param message
	 *            the message to log
	 */
	public static void logException(Exception e) {
		getDefault().getLog().log(new Status(IStatus.INFO, PLUGIN_ID, e.getLocalizedMessage(), e));
	}
}
