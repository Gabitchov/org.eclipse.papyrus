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

/**
 * Validates the selection of a resource in a plugin
 * @author Laurent Wouters
 */
public interface PluginsContentSelectionValidator {
	/**
	 * Determines whether the given plugin is a valid selection
	 * @param plugin The plugin
	 * @return <code>true</code> if the plugin is a valid selection
	 */
	boolean isValid(Plugin plugin);
	/**
	 * Determines whether the given plugin entry is a valid selection
	 * @param entry The plugin entry
	 * @return <code>true</code> if the plugin entry is a valid selection
	 */
	boolean isValid(PluginEntry entry);
}
