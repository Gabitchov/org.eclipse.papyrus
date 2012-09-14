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

import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.MultipleStringFileEditor;
import org.eclipse.swt.widgets.Composite;


public class MultiStringFile extends AbstractPropertyEditor {

	public MultipleStringFileEditor editor;

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

	public MultiStringFile(Composite parent, int style) {
		editor = createMultipleStringFileEditor(parent, style);
		setEditor(editor);
	}

	/**
	 * Creates the multiple string file editor
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the multiple string file editor.
	 */
	protected MultipleStringFileEditor createMultipleStringFileEditor(Composite parent, int style) {
		return new MultipleStringFileEditor(parent, style);
	}

	@Override
	protected void doBinding() {
		editor.setOrdered(input.isOrdered(propertyPath));
		editor.setUnique(input.isUnique(propertyPath));

		if(getInputObservableList() instanceof ICommitListener) {
			editor.addCommitListener((ICommitListener)getInputObservableList());
		}

		super.doBinding();
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
			editor.setFilters(filterExtensions, filterNames);
		}
	}
}
