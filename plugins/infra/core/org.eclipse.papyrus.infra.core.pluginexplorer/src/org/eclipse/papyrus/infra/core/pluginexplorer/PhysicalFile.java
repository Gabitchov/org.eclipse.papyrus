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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

/**
 * Represents a physical file (on disk) as a resource within a plugin
 * @author Laurent Wouters
 */
public class PhysicalFile implements PluginEntry {
	/**
	 * A constant empty list of entries
	 */
	private static final List<PluginEntry> empty = new ArrayList<PluginEntry>(0);
	
	/**
	 * The parent plugin
	 */
	private Plugin plugin;
	/**
	 * The physical file represented by this object
	 */
	private File file;
	/**
	 * The cache of children
	 */
	private List<PluginEntry> cache;
	
	/**
	 * Creates the representation of a physical file as a plugin entry
	 * @param plugin The parent plugin
	 * @param file The represented physical file
	 */
	public PhysicalFile(Plugin plugin, File file) {
		this.plugin = plugin;
		this.file = file;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getPlugin()
	 */
	public Plugin getPlugin() { return plugin; }

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getName()
	 */
	public String getName() { return file.getName(); }

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getLogicalPath()
	 */
	public String getLogicalPath() {
		IPath pp = new Path(plugin.getPhysicalPath());
		IPath physical = new Path(file.getAbsolutePath());
		return "platform:/plugin/" + plugin.getName() + "/" + physical.makeRelativeTo(pp).toString();
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getPhysicalPath()
	 */
	public String getPhysicalPath() { return file.getAbsolutePath(); }

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#hasChildren()
	 */
	public boolean hasChildren() {
		if (file.isDirectory()) {
			File[] content = file.listFiles();
			return (content != null && content.length > 0);
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#children()
	 */
	public List<PluginEntry> children() {
		if (cache != null)
			return cache;
		if (!file.isDirectory()) {
			cache = empty;
			return empty;
		}
		buildCache();
		return cache;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getChild(java.lang.String)
	 */
	public PluginEntry getChild(String name) {
		if (cache == null)
			buildCache();
		for (PluginEntry entry : cache)
			if (entry.getName().equals(name))
				return entry;
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.papyrus.infra.core.pluginexplorer.PluginEntry#getInputStream()
	 */
	public InputStream getInputStream() {
		try {
			return new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// Cannot happen, unless the file has been deleted after the lookup
			// in which case, too bad
			return null;
		}
	}
	
	/**
	 * Builds the cache of children entries
	 */
	private void buildCache() {
		File[] content = file.listFiles();
		if (content == null || content.length == 0) {
			cache = empty;
		} else {
			cache = new ArrayList<PluginEntry>(content.length);
			for (int i=0; i!=content.length; i++)
				cache.add(new PhysicalFile(plugin, content[i]));
		}
	}
}
