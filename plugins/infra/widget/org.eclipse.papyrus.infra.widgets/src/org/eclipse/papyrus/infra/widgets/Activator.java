/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.widgets"; //$NON-NLS-1$

	/**
	 * The shared instance
	 */
	private static Activator plugin;

	/**
	 * The logger for this plugin
	 */
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
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		log = new LogHelper(plugin);
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
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns the image at the given path from this plugin
	 * 
	 * @param path
	 *        the path of the image to be displayed
	 * @return The Image at the given location, or null if it couldn't be found
	 */
	public Image getImage(String path) {
		return getImage(PLUGIN_ID, path);
	}

	/**
	 * Returns the image from the given image descriptor
	 * 
	 * @param pluginId
	 *        The plugin in which the image is located
	 * @param path
	 *        The path to the image from the plugin
	 * @return
	 *         The Image at the given location, or null if it couldn't be found
	 */
	public Image getImage(String pluginId, String path) {
		final ImageRegistry registry = getImageRegistry();
		String key = pluginId + "/" + path; //$NON-NLS-1$
		Image image = registry.get(key);
		if(image == null) {
			registry.put(key, AbstractUIPlugin.imageDescriptorFromPlugin(pluginId, path));
			image = registry.get(key);
		}
		return image;
	}

	/**
	 * Returns the image from the given image location
	 * 
	 * @param pluginId
	 *        The plugin in which the image is located
	 * @param path
	 *        The path to the image from the plugin
	 * @return
	 *         The Image Descriptor at the given location, or null if it
	 *         couldn't be found
	 */
	public ImageDescriptor getImageDescriptor(String pluginId, String path){
		final ImageRegistry registry = getImageRegistry();
		String key = pluginId + "/" + path; //$NON-NLS-1$
		ImageDescriptor descriptor = registry.getDescriptor(key);
		if(descriptor == null) {
			registry.put(key, AbstractUIPlugin.imageDescriptorFromPlugin(pluginId, path));
			descriptor = registry.getDescriptor(key);
		}
		return descriptor;
	}

	/**
	 * Returns the image descriptor at the given path from this plugin
	 * 
	 * @param path
	 *        the path of the image to be displayed
	 * @return The ImageDescriptor at the given location, or null if it couldn't be found
	 */
	public ImageDescriptor getImageDescriptor(String path) {
		return getImageDescriptor(PLUGIN_ID, path);
	}

	/**
	 * Returns the image from the given path
	 * 
	 * @param imagePath
	 *        The path of the image, in the form /<plug-in ID>/<path to the image>
	 * @return
	 *         The Image at the given location, or null if none was found
	 */
	public Image getImageFromPlugin(String imagePath) {
		if(imagePath.startsWith("/")) { //$NON-NLS-1$
			String pluginId, path;
			imagePath = imagePath.substring(1, imagePath.length());
			pluginId = imagePath.substring(0, imagePath.indexOf("/")); //$NON-NLS-1$
			path = imagePath.substring(imagePath.indexOf("/"), imagePath.length()); //$NON-NLS-1$
			return getImage(pluginId, path);
		} else {
			return getImage(imagePath);
		}
	}

}
