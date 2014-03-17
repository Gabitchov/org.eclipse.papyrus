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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.eclipse.core.runtime.FileLocator;
import org.osgi.framework.Bundle;

/**
 * Represents an Eclipse plugin that can be introspected
 * @author Laurent Wouters
 */
public class Plugin {
	
	/**
	 * Gets an array of all the currently loaded plugins
	 * @return The currently loaded plugins
	 */
	public static Plugin[] getLoadedPlugins() {
		Bundle[] loaded = Activator.getDefault().getContext().getBundles();
		Plugin[] plugins = new Plugin[loaded.length];
		for (int i=0; i!=loaded.length; i++)
			plugins[i] = new Plugin(loaded[i]);
		return plugins;
	}
	
	/**
	 * The Eclipse bundle represented by this object
	 */
	private Bundle bundle;
	/**
	 * The list of entries at the plugin's root
	 */
	private List<PluginEntry> entries;
	/**
	 * The physical file represented by this object.
	 * It may be a jar file, or a folder.
	 */
	private File physicalLocation;
	
	/**
	 * Gets the corresponding Eclipse bundle
	 * @return The Eclipse bundle represented by this object
	 */
	public Bundle getBundle() { return bundle; }
	
	/**
	 * Gets whether this plugin contains resources
	 * @return <code>true</code> if this plugin contains resources
	 */
	public boolean hasEntries() { return (!entries.isEmpty()); }
	
	/**
	 * Gets the top entries within this plugin
	 * @return The top entries
	 */
	public List<PluginEntry> entries() { return entries; }
	
	/**
	 * Gets the qualified name of this plugin.
	 * This is the symbolic name of the represented bundle
	 * @return The plugin's name
	 */
	public String getName() { return bundle.getSymbolicName(); }
	
	/**
	 * Initializes this plugin with the given Eclipse bundle
	 * @param bundle The Eclipse bundle to represent
	 */
	public Plugin(Bundle bundle) {
		this.bundle = bundle;
		this.entries = new ArrayList<PluginEntry>();
		try { physicalLocation = FileLocator.getBundleFile(bundle); }
		catch (IOException e) {
			Activator.getDefault().getPapyrusLog().error("Failed to locate the plugin " + bundle.getSymbolicName(), e);
		}
		if (physicalLocation == null)
			return;
		if (physicalLocation.isDirectory())
			buildFromDirectory();
		else
			buildFromJar();
	}
	
	/**
	 * Gets the absolute physical path to this plugin
	 * @return The absolute path to this plugin
	 */
	public String getPhysicalPath() {
		if (physicalLocation == null)
			return null;
		return physicalLocation.getAbsolutePath();
	}
	
	/**
	 * Gets the entry corresponding to the given path, or <code>null</code> if none is found.
	 * Paths shall be of the form <code>part1/part2/part3</code>, etc.
	 * @param path The path to lookup for an entry
	 * @return The corresponding entry or <code>null</code> if none is found
	 */
	public PluginEntry getEntry(String path) {
		// sanitize
		int start = (path.startsWith("/") ? 1 : 0);
		int end = (path.endsWith("/") ? path.length() - 1 : path.length());
		path = path.substring(start, end);
		// split into the path elements
		String[] parts = path.split("/");
		PluginEntry current = null;
		for (PluginEntry e : entries) {
			if (e.getName().equals(parts[0])) {
				current = e;
				break;
			}
		}
		if (current == null)
			return null;
		for (int i=1; i!=parts.length; i++) {
			current = current.getChild(parts[i]);
			if (current == null)
				return null;
		}
		return current;
	}
	
	/**
	 * Builds this plugin from a physical directory
	 */
	private void buildFromDirectory() {
		File[] content = physicalLocation.listFiles();
		if (content == null || content.length == 0)
			return;
		for (int i=0; i!=content.length; i++)
			entries.add(new PhysicalFile(this, content[i]));
	}
	
	/**
	 * Builds this plugin from a Jar file
	 */
	private void buildFromJar() {
		try {
			JarFile jar = new JarFile(physicalLocation);
			List<JarEntry> content = new ArrayList<JarEntry>();
			Enumeration<JarEntry> e = jar.entries();
			while (e.hasMoreElements())
				content.add(e.nextElement());
			Collections.sort(content, new Comparator<JarEntry>() {
				public int compare(JarEntry arg0, JarEntry arg1) {
					return arg0.getName().compareTo(arg1.getName());
				}
			});
			int next = 0;
			while (next < content.size()) {
				EmbeddedFile child = new EmbeddedFile(this, content.get(next).getName());
				next = buildChildren(child, content, next + 1);
				entries.add(child);
			}
			jar.close();
		}
		catch (IOException e) { }
	}
	
	/**
	 * Builds the given embedded file with the given data
	 * @param parent The parent embedded directory
	 * @param content The sorted list of all the jar entries
	 * @param index The current index in the list of jar entries
	 * @return The final index within the jar entries
	 */
	private int buildChildren(EmbeddedFile parent, List<JarEntry> content, int index) {
		if (index >= content.size())
			return index;
		int next = index;
		while (next < content.size() && content.get(next).getName().startsWith(parent.getEntry())) {
			EmbeddedFile child = new EmbeddedFile(this, content.get(next).getName(), parent.getEntry());
			next = buildChildren(child, content, next + 1);
			parent.children().add(child);
		}
		return next;
	}
	
	InputStream getStreamInJar(String localPath) {
		try {
			final JarFile jar = new JarFile(physicalLocation);
			final JarEntry entry = jar.getJarEntry(localPath);
			return new InputStream() {
				private InputStream  inner = jar.getInputStream(entry);
				@Override
				public int read() throws IOException {
					return inner.read();
				}
				@Override
				public void close() {
					try {
						inner.close();
						jar.close();
					}
					catch (IOException e) { }
				}
			};
		}
		catch (IOException e) {
			return null;
		}
	}
}
