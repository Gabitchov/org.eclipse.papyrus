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
 *  Cedric Dumoulin  Cedric.dumoulin@lifl.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.tabbedproperties.core;

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
	public static final String PLUGIN_ID = "org.eclipse.papyrus.tabbedproperties.core";

	/** Papyrus icone path */
	public static final String PAPYRUS_ICONS_16x16 = "icons/papyrus/16x16/";

	/** Default image. */
	public static final String DEFAULT_IMAGE = "icons/papyrus/Papyrus.gif";

	// The shared instance
	private static Activator plugin;

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
	}

	/**
	 * {@inheritDoc}
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
	 * Returns an <code>org.eclipse.swt.graphics.Image</code> identified by its key.<BR>
	 * By default, it returns a default image. This image is the image placed in the directory <em>resources/icons/default.gif</em>
	 * 
	 * @param key
	 *            the key of the image
	 * @return the Image
	 */
	public static Image getImage(String key) {
		ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(key);

		if (image == null) {

			ImageDescriptor desc = AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, key);

			registry.put(key, desc);
			image = registry.get(key);

		}
		if ((image == null) && !DEFAULT_IMAGE.equals(key)) {
			image = getImage(DEFAULT_IMAGE);
		}

		return image;
	}
}
