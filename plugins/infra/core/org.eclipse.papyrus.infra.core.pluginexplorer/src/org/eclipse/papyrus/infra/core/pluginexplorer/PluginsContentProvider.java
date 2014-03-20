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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

/**
 * Represents a provider of plugins their content
 * @author Laurent Wouters
 */
public class PluginsContentProvider implements ITreeContentProvider {
	
	/**
	 * The root of all plugins
	 */
	public static final Object treeRoot = new Object();
	
	/**
	 * The unfiltered list of loaded plugins
	 */
	private Plugin[] plugins;
	/**
	 * The current filter
	 */
	private String filter;
	
	/**
	 * Creates the provider with the given filter on plugins' names
	 * @param plugins The plugins to provide
	 * @param filter The filter used on plugins' names
	 */
	public PluginsContentProvider(Plugin[] plugins, String filter) {
		this.plugins = plugins;
		this.filter = filter;
		if (this.filter != null && this.filter.isEmpty())
			this.filter = null;
	}
	
	/**
	 * Gets the plugins to provide after the application of the filter
	 * @return The plugins to provide
	 */
	private Object[] getFilteredPlugins() {
		if (filter == null)
			return plugins;
		List<Plugin> list = new ArrayList<Plugin>();
		for (int i=0; i!=plugins.length; i++) {
			String name = plugins[i].getName();
			if (name.contains(filter))
				list.add(plugins[i]);
		}
		return list.toArray();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() { }
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) { }
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		return getFilteredPlugins();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	public Object[] getChildren(Object element) {
		if (element == treeRoot)
			return getFilteredPlugins();
		if (element instanceof Plugin)
			return ((Plugin)element).entries().toArray();
		else if (element instanceof PluginEntry)
			return ((PluginEntry)element).children().toArray();
		return new Object[0];
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	public Object getParent(Object element) {
		if (element == treeRoot)
			return null;
		if (element instanceof Plugin)
			return treeRoot;
		return null;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	public boolean hasChildren(Object element) {
		if (element == treeRoot)
			return true;
		if (element instanceof Plugin)
			return ((Plugin)element).hasEntries();
		else if (element instanceof PluginEntry)
			return ((PluginEntry)element).hasChildren();
		return false;
	}
}
