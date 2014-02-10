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

package org.eclipse.emf.facet.common.ui.internal.views;

import java.util.Collection;

import org.eclipse.emf.facet.common.ui.internal.exported.views.IColumnDescription;
import org.eclipse.emf.facet.common.ui.internal.exported.views.IElementsViewFactory;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.IOpenListener;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.part.ViewPart;

public class ElementsViewFactory implements IElementsViewFactory {

	public ViewPart createElementsView(final Collection<? extends IColumnDescription> columns,
			final ITreeContentProvider contentProvider, final Object input, final String title, final Image titleImage, final IOpenListener openListener) {
		return new ElementsView(columns, contentProvider, input, title, titleImage, openListener);
	}

	public IColumnDescription createColumnDescription(final String columnText,
			final String uniqueID, final int defaultWidth,
			final ColumnLabelProvider columnLabelProvider) {
		return new IColumnDescription() {
			public String getUniqueID() {
				return uniqueID;
			}

			public int getDefaultWidth() {
				return defaultWidth;
			}

			public String getTitle() {
				return columnText;
			}

			public ColumnLabelProvider getColumnLabelProvider() {
				return columnLabelProvider;
			}
		};
	}
}
