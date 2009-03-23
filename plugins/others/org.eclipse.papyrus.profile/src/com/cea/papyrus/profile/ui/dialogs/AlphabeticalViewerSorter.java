/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package com.cea.papyrus.profile.ui.dialogs;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;

// TODO: Auto-generated Javadoc
/**
 * Sorter for the TableViewer for assisted dialogs.
 */
public class AlphabeticalViewerSorter extends ViewerSorter {

	// Criteria that the instance uses 
	/**
	 * The column index.
	 */
	private int columnIndex;

	/**
	 * Creates a resource sorter that will use the given sort criteria.
	 * 
	 * @param columnIndex the index of the column used to sort elements
	 */
	public AlphabeticalViewerSorter(int columnIndex) {
		super();
		this.columnIndex = columnIndex;
	}

	/* (non-Javadoc)
	 * Method declared on ViewerSorter.
	 */
	/**
	 * Compare.
	 * 
	 * @param viewer the viewer
	 * @param o2 the o2
	 * @param o1 the o1
	 * 
	 * @return the int
	 */
	@Override
	public int compare(Viewer viewer, Object o1, Object o2) {
		Assert.isTrue(viewer instanceof TableViewer);
		IBaseLabelProvider provider = ((TableViewer)viewer).getLabelProvider();
		Assert.isTrue(provider instanceof ITableLabelProvider);
		
		String s1 = ((ITableLabelProvider)provider).getColumnText(o1, columnIndex);
		String s2 = ((ITableLabelProvider)provider).getColumnText(o2, columnIndex);
		return collator.compare(s1, s2);
	}

}
