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

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Tree;

/**
 * A factory to obtain a {@link SortableWidget}, that provides a unified API over both SWT
 * {@link Tree} and {@link Table}.
 */
public final class SortableWidgetFactory {

	private SortableWidgetFactory() {
		// utility class
	}

	/**
	 * Get a {@link SortableWidget} for the given {@link Viewer}, that can be either a
	 * {@link TreeViewer} or a {@link TableViewer}.
	 * 
	 * @param viewer
	 *            a {@link TreeViewer} or a {@link TableViewer}
	 * @return a {@link SortableWidget} that delegates to the given viewer
	 */
	public static SortableWidget createSortableWidget(final Viewer viewer) {
		if (viewer instanceof TreeViewer) {
			TreeViewer treeViewer = (TreeViewer) viewer;
			return new SortableTree(treeViewer);
		} else if (viewer instanceof TableViewer) {
			TableViewer tableViewer = (TableViewer) viewer;
			return new SortableTable(tableViewer);
		}
		throw new IllegalArgumentException();
	}
}