/*******************************************************************************
 * Copyright (c) 2006 - 2010 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA LIST - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.views.cpp;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.views.cpp";

	// The shared instance
	private static Activator plugin;

	//	Resource bundle.
	public static final Font VIEW_FONT = new Font(null, "Bitstream Vera Sans Mono", 10, SWT.NORMAL);

	private static final String RESOURCE_NAME = PLUGIN_ID + ".Activator";

	public static final String ICONS_PATH = "resources/icons/";

	public static final String DEFAULT_IMAGE = ICONS_PATH + "default.gif";

	public static final String SAVE_IMAGE = ICONS_PATH + "save_edit.gif";

	public static final String UNDO_IMAGE = ICONS_PATH + "undo_edit.gif";

	public static final String WARNING_IMAGE = ICONS_PATH + "warning.gif";

	private ResourceBundle resourceBundle;

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * The constructor
	 */
	public Activator() {
		plugin = this;
		try {
			resourceBundle = ResourceBundle.getBundle(RESOURCE_NAME);
		} catch (MissingResourceException mre) {
			//Log.exception(mre);
			resourceBundle = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the string from the plugin's resource bundle, or 'key' if not
	 * found.
	 */
	public static String getResourceString(String key) {
		ResourceBundle bundle = getDefault().getResourceBundle();
		try {
			return (bundle != null) ? bundle.getString(key) : key;
		} catch (MissingResourceException e) {
			return key;
		}
	}

	/**
	 * Returns the plugin's resource bundle,
	 */
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	/**
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by
	 * its key. <BR>
	 * By default, it returns a default image. This image is the image placed in
	 * the directory <em>resources/icons/default.gif</em>
	 * 
	 * @param key
	 *        the key of the image
	 * @return the Image
	 */
	public static Image getImage(String key) {
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);
		if(image == null) {
			ImageDescriptor desc = AbstractUIPlugin
				.imageDescriptorFromPlugin(PLUGIN_ID, key);
			registry.put(key, desc);
			image = registry.get(key);
		}
		if(image == null && !key.equals(DEFAULT_IMAGE)) {
			image = getImage(DEFAULT_IMAGE);
		}

		return image;
	}

	/**
	 * Log the given exception into the plugin log.
	 * 
	 * @param e
	 *        the exception to log
	 */
	public static void log(Exception e) {
		getDefault().getLog().log(new Status(
			IStatus.ERROR,
			PLUGIN_ID,
			IStatus.OK,
			"exception caught: " + e.getMessage(),
			e));
	}
}
