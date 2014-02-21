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
package org.eclipse.emf.facet.common.ui.internal.controls.wrappers;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerSorter;

/**
 * Implements {@link SortableWidget}'s unified API for the JFace {@link TableViewer}.
 */
public class SortableTable implements SortableWidget {
	private final TableViewer tableViewer;

	public SortableTable(final TableViewer tableViewer) {
		this.tableViewer = tableViewer;
	}

	public void setSorter(final ViewerSorter viewerSorter) {
		this.tableViewer.setSorter(viewerSorter);
	}

	public int getSortDirection() {
		return this.tableViewer.getTable().getSortDirection();
	}

	public void setSortDirection(final int direction) {
		this.tableViewer.getTable().setSortDirection(direction);
	}

	public void setSortColumn(final Column column) {
		this.tableViewer.getTable().setSortColumn(
				(org.eclipse.swt.widgets.TableColumn) column.getColumn());
	}

	public void refresh() {
		this.tableViewer.refresh();
	}
}