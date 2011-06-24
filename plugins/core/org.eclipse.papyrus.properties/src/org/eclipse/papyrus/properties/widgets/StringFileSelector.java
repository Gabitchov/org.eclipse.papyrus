/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.widgets;

import org.eclipse.swt.widgets.Composite;

/**
 * A Widget for selecting Files on the workspace or on the file system.
 * The widgets only edits String values : it uses the path of the files
 * 
 * @author Camille Letavernier
 */
public class StringFileSelector extends AbstractPropertyEditor {

	protected org.eclipse.papyrus.widgets.editors.StringFileSelector selector;

	protected String[] filterExtensions, filterNames;

	protected boolean allowWorkspace = true, allowFileSystem = true;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 */
	public StringFileSelector(Composite parent, int style) {
		selector = new org.eclipse.papyrus.widgets.editors.StringFileSelector(parent, style);
		super.setEditor(selector);
	}

	/**
	 * 
	 * @param filterExtensions
	 */
	public void setFilterExtensions(String[] filterExtensions) {
		this.filterExtensions = filterExtensions;
		checkFilters();
	}

	/**
	 * 
	 * @param filterNames
	 */
	public void setFilterNames(String[] filterNames) {
		this.filterNames = filterNames;
		checkFilters();
	}

	protected void checkFilters() {
		if(filterExtensions != null && filterNames != null) {
			//TODO
			selector.setFilters(filterExtensions, filterNames);
		}
	}

	/**
	 * Indicates whether the editor should allow browsing the workspace or not
	 * 
	 * @param allowWorkspace
	 */
	public void setAllowWorkspace(boolean allowWorkspace) {
		this.allowWorkspace = allowWorkspace;
		selector.setAllowWorkspace(allowWorkspace);
	}

	/**
	 * 
	 * @return true if the editor can browse the workspace
	 */
	public boolean getAllowWorkspace() {
		return allowWorkspace;
	}

	/**
	 * Indicates whether the editor should allow browsing the file system or not
	 * 
	 * @param allowFileSystem
	 */
	public void setAllowFileSystem(boolean allowFileSystem) {
		this.allowFileSystem = allowFileSystem;
		selector.setAllowFileSystem(allowFileSystem);
	}

	/**
	 * 
	 * @return true if the editor can browse the fileSystem
	 */
	public boolean getAllowFileSystem() {
		return allowFileSystem;
	}
}
