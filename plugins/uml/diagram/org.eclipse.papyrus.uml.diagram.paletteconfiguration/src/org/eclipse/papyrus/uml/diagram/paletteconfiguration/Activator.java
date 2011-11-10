/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) remi.schnekenburger@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.paletteconfiguration;

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

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.uml.diagram.paletteconfiguration"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/** Logging helper */
	public static LogHelper log;

	/** Default image. */
	public static final String DEFAULT_IMAGE = "icons/papyrus/PapyrusLogo16x16.gif";

	/**
	 * The constructor
	 */
	public Activator() {
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// register the login helper
		log = new LogHelper(plugin);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
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

	public static Image getImage(String key) {
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);

		if(image == null) { // Image not yet in registry
			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, key);
			registry.put(key, desc);
			image = registry.get(key);
		}

		if((image == null) && !DEFAULT_IMAGE.equals(key)) {
			image = getImage(DEFAULT_IMAGE);
		}

		return image;
	}

	/**
	 * This method returns an <code>org.eclipse.swt.graphics.Image</code> identified by its pluginId and iconPath.<BR>
	 * 
	 * By default, it returns a default image. This image is the image placed in
	 * the directory <em>resources/icons/default.gif</em>
	 * 
	 * @param pluginId
	 *        id of plugin
	 * @param iconpPath
	 *        the path of the icon image relative to the plugin
	 * @return the Image
	 */
	public static Image getPluginIconImage(String pluginId, String iconPath) {
		String key = pluginId + iconPath;
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);

		if(image == null) {

			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(pluginId, iconPath);

			registry.put(key, desc);
			image = registry.get(key);

		}
		if((image == null) && !iconPath.equals(DEFAULT_IMAGE)) {
			image = getImage(DEFAULT_IMAGE);
		}

		return image;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path.
	 * 
	 * @param path
	 *        the path for the image file
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * This method returns an <code>org.eclipse.swt.graphics.Image</code> identified by its pluginId and image Descriptor.<BR>
	 * 
	 * By default, it returns a default image. This image is the image placed in
	 * the directory <em>resources/icons/default.gif</em>
	 * 
	 * @param pluginId
	 *        id of plugin
	 * @param descriptor
	 *        the image descriptor of the image
	 * @return the Image
	 */
	public static Image getPluginIconImage(String pluginId, ImageDescriptor descriptor) {
		String key = pluginId + descriptor;
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);

		if(image == null) {

			registry.put(key, descriptor);
			image = registry.get(key);

		}
		return image;
	}

}
