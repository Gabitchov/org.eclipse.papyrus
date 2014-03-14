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

package org.eclipse.papyrus.emf.facet.common.ui.internal.exported.views;

import java.util.Collection;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.papyrus.emf.facet.common.ui.internal.views.ElementsViewFactory;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.part.ViewPart;

/**
 * Creates Eclipse views to display lists of elements. To be able to register this view in a non-RCP Eclipse, you will
 * have to register an IExecutableExtensionFactory that will do the actual instantiation.
 */
public interface IElementsViewFactory {
	IElementsViewFactory DEFAULT = new ElementsViewFactory();

	/**
	 * Creates a view with columns. Each column has a default width, and memorizes its width once resized.
	 * 
	 * @param columnDescriptions
	 *            describes the columns
	 * @param contentProvider
	 *            provides the content from the input
	 * @param input
	 *            the view's input
	 * @param title
	 *            the part's label
	 * @param titleImage
	 *            the part's image
	 * @param openListener
	 *            a listener called when hitting Enter or double-clicking on an element in the view
	 * @return the view part
	 */
	ViewPart createElementsView(Collection<? extends IColumnDescription> columnDescriptions,
			ITreeContentProvider contentProvider, Object input, String title, Image titleImage, IOpenListener openListener);

	/**
	 * Creates a column description for
	 * {@link IElementsViewFactory#createElementsView(Collection, ITreeContentProvider, Object, String, Image, IOpenListener)
	 * createElementsView}
	 * 
	 * @param title
	 *            the column label
	 * @param uniqueID
	 *            a unique ID that will identify the column (used for serialization)
	 * @param defaultWidth
	 *            the initial width of the column, before the user resizes it
	 * @param columnLabelProvider
	 *            A label provider that returns the text (and optionally image and other font attributes) for each
	 *            element in this column
	 * @return a column description
	 */
	IColumnDescription createColumnDescription(String title, String uniqueID,
			int defaultWidth, ColumnLabelProvider columnLabelProvider);
}
