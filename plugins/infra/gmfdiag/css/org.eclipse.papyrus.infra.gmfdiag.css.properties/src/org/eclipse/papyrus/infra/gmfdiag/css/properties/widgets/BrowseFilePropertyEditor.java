/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Gabriel Pascual (ALL4TEC) gabriel.pascual@all4tec.net - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.css.properties.widgets;

import org.eclipse.papyrus.views.properties.widgets.AbstractPropertyEditor;
import org.eclipse.swt.widgets.Composite;


/**
 * Property editor for attribute that need a file selection.
 * Its display have unique button with an associated menu to choice where file comes frome.
 */
public class BrowseFilePropertyEditor extends AbstractPropertyEditor {

	/** The browse file editor. */
	private BrowseFileEditor browseFileEditor = null;

	/** The filtered extensions This should be a 1-1 mapping with {@link #filterNames}. */
	protected String[] filterExtensions = null;

	/**
	 * The name of the filters.
	 * This should be a 1-1 mapping with {@link #filterExtensions}
	 */
	protected String[] filterNames = null;

	/** Enables the "browse workspace" feature. */
	protected boolean allowWorkspace = true;

	/** Enables the "browse file system" feature. */
	protected boolean allowFileSystem = true;

	/**
	 * Instantiates a new browse file property editor.
	 *
	 * @param parent
	 *        the parent
	 * @param style
	 *        the style
	 */
	public BrowseFilePropertyEditor(Composite parent, int style) {
		browseFileEditor = createBrowseFileEditor(parent, style);
		super.setEditor(browseFileEditor);
	}

	/**
	 * Creates the browse file editor.
	 *
	 * @param parent
	 *        the parent
	 * @param style
	 *        the style
	 * @return the browse file editor
	 */
	private BrowseFileEditor createBrowseFileEditor(Composite parent, int style) {

		return new BrowseFileEditor(parent, style);
	}

	/**
	 * Sets the filter extensions.
	 *
	 * @param filterExtensions
	 *        the new filter extensions
	 */
	public void setFilterExtensions(String[] filterExtensions) {
		this.filterExtensions = filterExtensions;
		checkFilters();
	}

	/**
	 * Gets the filter extensions.
	 *
	 * @return the filter extensions
	 */
	public String[] getFilterExtensions() {
		return this.filterExtensions;
	}

	/**
	 * Sets the filter names.
	 *
	 * @param filterNames
	 *        the new filter names
	 */
	public void setFilterNames(String[] filterNames) {
		this.filterNames = filterNames;
		checkFilters();
	}

	/**
	 * Gets the filter names.
	 *
	 * @return the filter names
	 */
	public String[] getFilterNames() {
		return this.filterNames;
	}

	/**
	 * Checks if the filters are valid.
	 */
	protected void checkFilters() {
		if(filterExtensions != null && filterNames != null) {
			browseFileEditor.setFilters(filterExtensions, filterNames);
		}
	}

	/**
	 * Indicates whether the editor should allow browsing the workspace or not.
	 *
	 * @param allowWorkspace
	 *        the new allow workspace
	 */
	public void setAllowWorkspace(boolean allowWorkspace) {
		this.allowWorkspace = allowWorkspace;
		browseFileEditor.setAllowWorkspace(allowWorkspace);
	}

	/**
	 * Gets the allow workspace.
	 *
	 * @return true if the editor can browse the workspace
	 */
	public boolean getAllowWorkspace() {
		return allowWorkspace;
	}

	/**
	 * Indicates whether the editor should allow browsing the file system or not.
	 *
	 * @param allowFileSystem
	 *        the new allow file system
	 */
	public void setAllowFileSystem(boolean allowFileSystem) {
		this.allowFileSystem = allowFileSystem;
		browseFileEditor.setAllowFileSystem(allowFileSystem);
	}

	/**
	 * Gets the allow file system.
	 *
	 * @return true if the editor can browse the fileSystem
	 */
	public boolean getAllowFileSystem() {
		return allowFileSystem;
	}
}
