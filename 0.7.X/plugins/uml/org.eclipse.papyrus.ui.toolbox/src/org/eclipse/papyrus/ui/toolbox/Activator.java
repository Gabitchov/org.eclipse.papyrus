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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.ui.toolbox;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.ui.toolbox";

	// The shared instance
	private static Activator plugin;

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
	}

	/*
	 * (non-Javadoc)
	 * 
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
	public static Image getImage(String iconPath, String defaultPlugin) {
		// see if the path is using platform:/... to get icon in the fragment, if it is in a fragment 
		String key = defaultPlugin + iconPath;
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);

		if(image == null) {

			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(defaultPlugin, iconPath);
			registry.put(key, desc);
			image = registry.get(key);

		}
		return image;
	}


}
