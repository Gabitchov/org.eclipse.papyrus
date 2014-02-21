/*******************************************************************************
 * Copyright (c) 2011 Mia-Software.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - initial API and implementation
 *    Nicolas Bros (Mia-Software) - Bug 334116 - common tree view with columns
 *******************************************************************************/
package org.eclipse.papyrus.emf.facet.common.ui.internal.controls.wrappers;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * Implements {@link SortableWidget}'s unified API for the JFace {@link TreeViewer}.
 */
public class SortableTree implements SortableWidget {
	private final TreeViewer treeViewer;

	public SortableTree(final TreeViewer treeViewer) {
		this.treeViewer = treeViewer;
	}

	public void setSorter(final ViewerSorter viewerSorter) {
		this.treeViewer.setSorter(viewerSorter);
	}

	public int getSortDirection() {
		return this.treeViewer.getTree().getSortDirection();
	}

	public void setSortDirection(final int direction) {
		this.treeViewer.getTree().setSortDirection(direction);
	}

	public void setSortColumn(final Column column) {
		this.treeViewer.getTree().setSortColumn(
				(org.eclipse.swt.widgets.TreeColumn) column.getColumn());
	}

	public void refresh() {
		this.treeViewer.refresh();
	}
}