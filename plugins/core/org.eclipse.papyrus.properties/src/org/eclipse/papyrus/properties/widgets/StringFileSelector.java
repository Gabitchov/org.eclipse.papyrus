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


public class StringFileSelector extends AbstractPropertyEditor {

	protected org.eclipse.papyrus.widgets.editors.StringFileSelector selector;

	protected String[] filterExtensions, filterNames;

	protected boolean allowWorkspace = true, allowFileSystem = true;

	public StringFileSelector(Composite parent, int style) {
		selector = new org.eclipse.papyrus.widgets.editors.StringFileSelector(parent, style);
		super.setEditor(selector);
	}

	public void setFilterExtensions(String[] filterExtensions) {
		this.filterExtensions = filterExtensions;
		checkFilters();
	}

	public void setFilterNames(String[] filterNames) {
		this.filterNames = filterNames;
		checkFilters();
	}

	protected void checkFilters() {
		if(filterExtensions != null && filterNames != null) {

		}
	}

	public void setAllowWorkspace(boolean allowWorkspace) {
		this.allowWorkspace = allowWorkspace;
		selector.setAllowWorkspace(allowWorkspace);
	}

	public boolean getAllowWorkspace() {
		return allowWorkspace;
	}

	public void setAllowFileSystem(boolean allowFileSystem) {
		this.allowFileSystem = allowFileSystem;
		selector.setAllowFileSystem(allowFileSystem);
	}

	public boolean getAllowFileSystem() {
		return allowFileSystem;
	}
}
