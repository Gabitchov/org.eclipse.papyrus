/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Laurent Wouters laurent.wouters@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.infra.core.pluginexplorer;

import java.net.URL;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.papyrus.infra.core.pluginexplorer"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;
	
	// the plugin's context
	private BundleContext context;
	
	// The log for this plugin
	private LogHelper log;
	
	/**
	 * Gets the context of this plugin
	 * @return The plugin's context
	 */
	public BundleContext getContext() {
		return context;
	}
	
	/**
	 * Gets the Papyrus log associated with this plugin
	 * @return The Papyrus log for this plugin
	 */
	public LogHelper getPapyrusLog() {
		return log;
	}
	
	/**
	 * The constructor
	 */
	public Activator() {
		this.log = new LogHelper(this);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		this.context = context;
		ImageRegistry registry = getImageRegistry();
		registry.put("plugin", ImageDescriptor.createFromURL(new URL("platform:/plugin/" + PLUGIN_ID + "/icons/plugin_obj.gif")));
		registry.put("folder", ImageDescriptor.createFromURL(new URL("platform:/plugin/" + PLUGIN_ID + "/icons/packagefolder_obj.gif")));
		registry.put("class", ImageDescriptor.createFromURL(new URL("platform:/plugin/" + PLUGIN_ID + "/icons/classf_obj.gif")));
		registry.put("file", ImageDescriptor.createFromURL(new URL("platform:/plugin/" + PLUGIN_ID + "/icons/file_obj.gif")));
		registry.put("jar", ImageDescriptor.createFromURL(new URL("platform:/plugin/" + PLUGIN_ID + "/icons/jar_obj.gif")));
		plugin = this;
	}

	/*
	 * (non-Javadoc)
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

}
