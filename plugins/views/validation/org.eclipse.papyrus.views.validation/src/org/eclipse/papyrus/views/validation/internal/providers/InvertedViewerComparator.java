/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.validation.internal.providers;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.swt.SWT;

/**
 * This is the InvertedViewerComparator type. Enjoy.
 */
public class InvertedViewerComparator
		extends ViewerComparator {

	private final ViewerComparator comparator;

	private InvertedViewerComparator(ViewerComparator comparator) {
		this.comparator = comparator;
	}

	public static ViewerComparator invert(ViewerComparator comparator) {
		return (comparator instanceof InvertedViewerComparator)
			? ((InvertedViewerComparator) comparator).comparator
			: new InvertedViewerComparator(comparator);
	}

	public static ViewerComparator unwrap(ViewerComparator comparator) {
		return (comparator instanceof InvertedViewerComparator)
			? ((InvertedViewerComparator) comparator).comparator
			: comparator;
	}
	
	public static int direction(ViewerComparator comparator) {
		return (comparator instanceof InvertedViewerComparator)
			? SWT.DOWN
			: SWT.UP;
	}

	@Override
	public boolean isSorterProperty(Object element, String property) {
		return comparator.isSorterProperty(element, property);
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		return -comparator.compare(viewer, e1, e2);
	}

	@Override
	public int category(Object element) {
		return comparator.category(element);
	}

	@Override
	public int hashCode() {
		return -comparator.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof InvertedViewerComparator)
			&& ((InvertedViewerComparator) obj).comparator.equals(comparator);
	}
}
