/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	
 *		CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.pkg;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.uml.diagram.pkg.preferences.PackageDiagramPreferenceInitializer;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/** The activator class controls the plug-in life cycle */
public class Activator extends AbstractUIPlugin {

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.uml.diagram.pkg";

	/** The plug-in shared instance */
	private static Activator plugin;

	/** The logging helper */
	public static LogHelper log;

	/** The plug-in Preference store */
	public static final PreferencesHint DIAGRAM_PREFERENCES_HINT = new PreferencesHint(PLUGIN_ID);

	/** Default constructor */
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

		// register the login helper
		log = new LogHelper(plugin);

		// register the preference store
		PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT, getPreferenceStore());

		// Preferences initialization
		PackageDiagramPreferenceInitializer diagramPreferenceInitializer = new PackageDiagramPreferenceInitializer();
		diagramPreferenceInitializer.initializeDefaultPreferences();
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
	public static Activator getInstance() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given plug-in relative path.
	 * 
	 * @generated
	 * @param path
	 *        the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getBundledImageDescriptor(String path) {
		return AbstractUIPlugin.imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	/**
	 * 
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#getPreferenceStore()
	 * 
	 * @return Shared Preference Store.
	 */
	@Override
	public IPreferenceStore getPreferenceStore() {
		IPreferenceStore store = org.eclipse.papyrus.infra.gmfdiag.preferences.Activator.getDefault().getPreferenceStore();
		return store;
	}
}
