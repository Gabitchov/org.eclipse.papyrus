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
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.search.ui;

import org.eclipse.jface.viewers.CheckboxTreeViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

/**
 * 
 * An custom FilteredTree that provides Checkboxes for items
 * 
 */
public class CheckBoxFilteredTree extends FilteredTree {

	public CheckBoxFilteredTree(Composite parent, int style, PatternFilter filter, boolean useNewLook) {
		super(parent, style, filter, useNewLook);
	}

	/**
	 * Override to create a CheckBoxTreeViewer instead
	 * 
	 * @see org.eclipse.ui.dialogs.FilteredTree#doCreateTreeViewer(org.eclipse.swt.widgets.Composite, int)
	 * 
	 * @param parent
	 * @param style
	 * @return
	 */
	@Override
	protected TreeViewer doCreateTreeViewer(Composite parent, int style) {
		return new CheckboxTreeViewer(parent, style);
	}

	/**
	 * Give an access to the viewer with appropriate typing
	 * 
	 * @return the CheckBoxTreeViewer
	 */
	public CheckboxTreeViewer getCheckboxTreeViewer() {
		return (CheckboxTreeViewer)getViewer();
	}
}
