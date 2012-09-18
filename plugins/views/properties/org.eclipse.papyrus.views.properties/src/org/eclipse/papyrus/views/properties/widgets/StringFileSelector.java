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
package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.swt.widgets.Composite;

/**
 * A Widget for selecting Files on the workspace or on the file system.
 * The widgets only edits String values : it uses the path of the files
 * 
 * @author Camille Letavernier
 */
public class StringFileSelector extends AbstractPropertyEditor {

	/**
	 * The StringFileSelector widget used by this property editor
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.StringFileSelector selector;

	/**
	 * The filtered extensions
	 * This should be a 1-1 mapping with {@link #filterNames}
	 */
	protected String[] filterExtensions;

	/**
	 * The name of the filters.
	 * This should be a 1-1 mapping with {@link #filterExtensions}
	 */
	protected String[] filterNames;

	/**
	 * Enables the "browse workspace" feature
	 */
	protected boolean allowWorkspace = true;

	/**
	 * Enables the "browse file system" feature
	 */
	protected boolean allowFileSystem = true;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 */
	public StringFileSelector(Composite parent, int style) {
		selector = createSelector(parent, style);
		super.setEditor(selector);
	}

	/**
	 * Creates the selector
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the selector
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.StringFileSelector createSelector(Composite parent, int style) {
		return new org.eclipse.papyrus.infra.widgets.editors.StringFileSelector(parent, style);
	}

	/**
	 * 
	 * @param filterExtensions
	 */
	public void setFilterExtensions(String[] filterExtensions) {
		this.filterExtensions = filterExtensions;
		checkFilters();
	}

	public String[] getFilterExtensions() {
		return this.filterExtensions;
	}

	/**
	 * 
	 * @param filterNames
	 */
	public void setFilterNames(String[] filterNames) {
		this.filterNames = filterNames;
		checkFilters();
	}

	public String[] getFilterNames() {
		return this.filterNames;
	}

	/**
	 * Checks if the filters are valid
	 */
	protected void checkFilters() {
		if(filterExtensions != null && filterNames != null) {
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
