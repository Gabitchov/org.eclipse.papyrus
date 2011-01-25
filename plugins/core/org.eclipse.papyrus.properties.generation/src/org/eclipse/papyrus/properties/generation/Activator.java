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
package org.eclipse.papyrus.properties.generation;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.log.LogHelper;
import org.eclipse.papyrus.properties.generation.extensionpoint.GeneratorExtensionPoint;
import org.eclipse.papyrus.properties.generation.extensionpoint.LayoutExtensionPoint;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/** The activator class controls the plug-in life cycle */
public class Activator extends AbstractUIPlugin {

	public static LogHelper log;

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.properties.generation"; //$NON-NLS-1$

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

	public Image getImage(String path) {
		final ImageRegistry registry = getImageRegistry();
		Image image = registry.get(path);
		if(image == null) {
			registry.put(path, AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path));
			image = registry.get(path);
		}
		return image;
	}
}
