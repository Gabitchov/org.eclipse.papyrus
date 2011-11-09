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
package org.eclipse.papyrus.customization.properties.generation;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.customization.properties.generation.extensionpoint.GeneratorExtensionPoint;
import org.eclipse.papyrus.customization.properties.generation.extensionpoint.LayoutExtensionPoint;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/** The activator class controls the plug-in life cycle */
public class Activator extends AbstractUIPlugin {

	/** the plug-in's logger */
	public static LogHelper log;

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.customization.properties.generation"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		Activator.plugin = this;
		log = new LogHelper(plugin);

		new GeneratorExtensionPoint();
		new LayoutExtensionPoint();
	}

	@Override
	public void stop(final BundleContext context) throws Exception {
		Activator.plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return Activator.plugin;
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
	 * Returns the image descriptor at the given path from this plugin
	 * 
	 * @param path
	 *        the path of the image to be displayed
	 * @return The Image Descriptor at the given location, or null if it couldn't be found
	 */
	public ImageDescriptor getImageDescriptor(String path) {
		final ImageRegistry registry = getImageRegistry();
		String key = PLUGIN_ID + "/" + path; //$NON-NLS-1$
		ImageDescriptor descriptor = registry.getDescriptor(key);
		if(descriptor == null) {
			registry.put(key, AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path));
			descriptor = registry.getDescriptor(key);
		}
		return descriptor;
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
}
