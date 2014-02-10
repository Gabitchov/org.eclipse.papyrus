/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Nicolas Bros (Mia-Software) - Bug 372732 - [Facet] Rewrite the catalog views for 0.2
 *******************************************************************************/
package org.eclipse.emf.facet.common.ui.internal.exported.views;

import org.eclipse.jface.viewers.ColumnLabelProvider;

/**
 * Contains the data necessary to create a column in a view created by
 * {@link IElementsViewFactory#createElementsView(java.util.Collection, org.eclipse.jface.viewers.ITreeContentProvider, Object, String, org.eclipse.swt.graphics.Image, org.eclipse.jface.viewers.IOpenListener) IElementsViewFactory#createElementsView}
 */
public interface IColumnDescription {
	/** The column's label */
	String getTitle();

	/** A unique id for the column */
	String getUniqueID();

	/** The default width that will be used the first time the column is displayed */
	int getDefaultWidth();

	/**
	 * A label provider that returns the text (and optionally image and other font attributes) for each element in this
	 * column
	 */
	ColumnLabelProvider getColumnLabelProvider();
}
