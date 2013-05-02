/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.interactionoverview;

import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.papyrus.infra.core.log.LogHelper;
import org.eclipse.papyrus.uml.diagram.interactionoverview.preferences.InteractionOverviewDiagramPreferenceInitializer;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/** The activator class controls the plug-in life cycle */
public class Activator extends AbstractUIPlugin {

	/** The plug-in ID */
	public static final String PLUGIN_ID = "org.eclipse.papyrus.uml.diagram.interactionoverview";

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
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void start(final BundleContext context) throws Exception {
		super.start(context);
		plugin = this;

		// register the login helper
		log = new LogHelper(plugin);

		// register the preference store
		PreferencesHint.registerPreferenceStore(DIAGRAM_PREFERENCES_HINT, getPreferenceStore());

		// Preferences initialization
		final InteractionOverviewDiagramPreferenceInitializer diagramPreferenceInitializer = new InteractionOverviewDiagramPreferenceInitializer();
		diagramPreferenceInitializer.initializeDefaultPreferences();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
	 * )
	 */
	@Override
	public void stop(final BundleContext context) throws Exception {
		log = null;
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
	 * Returns an image descriptor for the image file at the given plug-in
	 * relative path.
	 * 
	 * @generated
	 * @param path
	 *        the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getBundledImageDescriptor(final String path) {
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
		final IPreferenceStore store = org.eclipse.papyrus.infra.gmfdiag.preferences.Activator.getDefault().getPreferenceStore();
		return store;
	}
}
