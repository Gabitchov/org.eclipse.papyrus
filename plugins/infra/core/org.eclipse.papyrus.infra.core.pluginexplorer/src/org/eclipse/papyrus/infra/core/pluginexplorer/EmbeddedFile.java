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
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a file embedded in a Jar container that is a plugin loaded by Eclipse
 * @author Laurent Wouters
 */
public class EmbeddedFile implements PluginEntry {
	/**
	 * The parent plugin
	 */
	private Plugin plugin;
	/**
	 * The relative path to this file within the plugin
	 */
	private String relativePath;
	/**
	 * The name of this file
	 */
	private String name;
	/**
	 * The children list
	 */
	private List<PluginEntry> children;
	
	/**
	 * Gets the Jar entry as a String corresponding to this file
	 * @return The Jar entry for this file as a String
	 */
	public String getEntry() { return relativePath; }
	
	
	/**
	 * Creates the representation of a Jar entry as a plugin entry
	 * @param plugin The parent plugin
	 * @param entryName The Jar entry as a String
	 */
	public EmbeddedFile(Plugin plugin, String entryName) {
		this.plugin = plugin;
		this.relativePath = entryName;
		if (entryName.endsWith("/"))
			this.relativePath = entryName.substring(0, entryName.length() - 1);
		this.name = this.relativePath;
		this.children = new ArrayList<PluginEntry>();
	}
	
	/**
	 * Creates the representation of a Jar entry as a plugin entry
	 * @param plugin The parent plugin
	 * @param entryName The Jar entry as a String
	 * @param parentEntry The parent Jar entry as a String
	 */
	public EmbeddedFile(Plugin plugin, String entryName, String parentEntry) {
		this.plugin = plugin;
		this.relativePath = entryName;
		if (entryName.endsWith("/"))
			this.relativePath = entryName.substring(0, entryName.length() - 1);
		this.name = relativePath.substring(parentEntry.length() + 1);
		this.children = new ArrayList<PluginEntry>();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getPlugin()
	 */
	public Plugin getPlugin() { return plugin; }
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getName()
	 */
	public String getName() { return name; }
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getLogicalPath()
	 */
	public String getLogicalPath() { return "platform:/plugin/" + plugin.getName() + "/" + relativePath; }
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getPhysicalPath()
	 */
	public String getPhysicalPath() { return null; }
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#hasChildren()
	 */
	public boolean hasChildren() { return (!children.isEmpty()); }
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#children()
	 */
	public List<PluginEntry> children() { return children; }
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getChild(java.lang.String)
	 */
	public PluginEntry getChild(String name) {
		for (PluginEntry entry : children)
			if (entry.getName().equals(name))
				return entry;
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getInputStream()
	 */
	public InputStream getInputStream() {
		return plugin.getStreamInJar(relativePath);
	}
}
