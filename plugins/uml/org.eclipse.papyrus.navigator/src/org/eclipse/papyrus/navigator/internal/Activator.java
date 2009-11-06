/*******************************************************************************
 * Copyright (c) 2009 Obeo.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     Obeo - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.navigator.internal;

import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.jface.resource.ImageDescriptor;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @author <a href="mailto:thomas.szadel@atosorigin.com">Thomas Szadel</a>: Create
 *         Plugin/Implementation (see EMF conventions).
 */
public class Activator extends EMFPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.navigator";

	// The shared instance
	public static final Activator INSTANCE = new Activator();

	/**
	 * The one instance of this class.
	 */
	private static Implementation plugin;

	/**
	 * The constructor
	 */
	public Activator() {
		super(new ResourceLocator[] {});
	}

	/**
	 * Overrides getPluginResourceLocator.
	 * 
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.common.EMFPlugin#getPluginResourceLocator()
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Is the platform in debug mode?
	 * 
	 * @return True if debug is enabled.
	 */
	public boolean isDebugEnabled() {
		return Platform.inDebugMode();
	}

	/**
	 * Add a debug log.
	 * 
	 * @param message
	 *            The message.
	 */
	public void debug(String message) {
		if (isDebugEnabled()) {
			log(new Status(IStatus.INFO, "[DEBUG] " + message, null));
		}
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 */
	public static class Implementation extends EclipsePlugin {

		public Implementation() {
			super();
			// Remember the static instance.
			plugin = this;
		}

		/**
		 * get the image descriptor from a string path
		 * 
		 * @param pathString
		 *            path of the image
		 * @return the image descriptor
		 */
		public static ImageDescriptor getImageDescriptor(String pathString) {
			IPath path = new Path(pathString);
			URL uri = FileLocator.find(plugin.getBundle(), path, null);
			if (uri == null) {
				return null;
			}
			return ImageDescriptor.createFromURL(uri);
		}
	}
}
