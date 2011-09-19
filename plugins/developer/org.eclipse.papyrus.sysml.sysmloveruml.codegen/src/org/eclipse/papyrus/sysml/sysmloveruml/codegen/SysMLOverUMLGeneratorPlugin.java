/**
 *  Copyright (c) 2011 Atos.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *  
 *  Contributors:
 *  Atos - Initial API and implementation
 * 
 */
package org.eclipse.papyrus.sysml.sysmloveruml.codegen;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * The activator class controls the plug-in life cycle
 */
public class SysMLOverUMLGeneratorPlugin extends EMFPlugin {

	/**
	 * The singleton instance of the plugin.
	 */
	public static final SysMLOverUMLGeneratorPlugin INSTANCE = new SysMLOverUMLGeneratorPlugin();

	// The plug-in ID
	public static final String ID = "org.eclipse.papyrus.sysml.sysmloveruml.codegen"; //$NON-NLS-1$

	/**
	 * The shared instance.
	 */
	private static Implementation plugin;

	/**
	 * Creates the singleton instance.
	 */
	private SysMLOverUMLGeneratorPlugin() {
		super(new ResourceLocator[]{});
	}

	/*
	 * Javadoc copied from base class.
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * 
	 * @return the singleton instance.
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 */
	public static class Implementation extends EclipsePlugin {

		/**
		 * Creates an instance.
		 */
		public Implementation() {
			super();
			// Remember the static instance.
			//
			plugin = this;
		}
	}
}
