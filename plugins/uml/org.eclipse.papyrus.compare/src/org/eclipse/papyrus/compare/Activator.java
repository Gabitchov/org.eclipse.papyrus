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
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.compare;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 */
public class Activator extends AbstractUIPlugin {

	/**
	 * The plug-in ID.
	 */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.compare"; //$NON-NLS-1$

	/**
	 * The shared instance.
	 */
	private static Activator plugin;


	/**
	 * The constructor.
	 */
	public Activator() {
	}

	/**
	 * Start.
	 *
	 * @param context the context
	 * @throws Exception the exception
	 * {@inheritDoc}
	 * @see org.eclipse.core.runtime.Plugin#start(org.osgi.framework.BundleContext)
	 * @generated
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/**
	 * Stop.
	 *
	 * @param context the context
	 * @throws Exception the exception
	 * {@inheritDoc}
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 * @generated
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance.
	 * 
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * Returns the image from the given path.
	 *
	 * @param path the path the image to be displayed
	 * @return the image found
	 */
	public static Image getImage(String path) {
		final ImageRegistry registry = getDefault().getImageRegistry();
		Image image = registry.get(path);
		if(image == null) {
			registry.put(path, Activator.imageDescriptorFromPlugin(PLUGIN_ID, path));
			image = registry.get(path);
		}
		return image;

	}

	/**
	 * Log error.
	 *
	 * @param e the e
	 */
	public static void logError(Throwable e) {
		logError(Messages.Activator_log_error_message, e);
	}

	/**
	 * Log error.
	 *
	 * @param message the message
	 * @param e the e
	 */
	public static void logError(String message, Throwable e) {
		IStatus status = new Status(IStatus.ERROR, PLUGIN_ID, message, e);
		getDefault().getLog().log(status);
	}

	/**
	 * Log info.
	 *
	 * @param message the message
	 */
	public static void logInfo(String message) {
		IStatus status = new Status(IStatus.INFO, PLUGIN_ID, message);
		getDefault().getLog().log(status);
	}

}
