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

import java.io.InputStream;
import java.util.List;


/**
 * Represents a resource within a plugin
 * @author Laurent Wouters
 */
public interface PluginEntry {
	/**
	 * Gets the parent plugin
	 * @return The parent plugin
	 */
	Plugin getPlugin();
	
	/**
	 * Gets the name of this entry
	 * @return The simple name of this entry
	 */
	String getName();
	
	/**
	 * Gets the String representation of the URI that can be used to access this resource.
	 * The returned URI is always prefixed by the <code>platform:/plugin/</code> scheme.
	 * @return The logical path to this entry
	 */
	String getLogicalPath();
	
	/**
	 * Gets the String representation of the physical path to the file represented by this entry.
	 * This path only exists for files already on disk, for embedded files this method should return <code>null</null>.
	 * @return The physical absolute path to the file
	 */
	String getPhysicalPath();
	
	/**
	 * Gets whether this entry has children (sub-entries), in which case this entry is a directory.
	 * @return <code>true</code> if this entry contains sub-entries
	 */
	boolean hasChildren();
	
	/**
	 * Gets the children of this entry (sub-entries)
	 * @return The children entries
	 */
	List<PluginEntry> children();
	
	/**
	 * Gets the child of this entry with the given name, or null if none is found
	 * @param name The name to lookup for
	 * @return The child entry with the given name
	 */
	PluginEntry getChild(String name);
	
	/**
	 * Gets an input stream on the resource represented by this entry
	 * @return An input stream on the resource
	 */
	InputStream getInputStream();
}
