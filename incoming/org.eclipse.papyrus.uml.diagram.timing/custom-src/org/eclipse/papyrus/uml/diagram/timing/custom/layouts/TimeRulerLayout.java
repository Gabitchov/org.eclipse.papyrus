/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.layouts;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class TimeRulerLayout extends AbstractLayout {

	public void layout(final IFigure container) {
		// reset the layout so that the BorderItemsAwareFreeFormLayer fills its parent FreeformViewport
		// if (!(container.getParent().getLayoutManager() instanceof FillLayout)) {
		// container.getParent().setLayoutManager(new FillLayout());
		// }

		// The grand-parent is a FreeformViewport, which lets its child expand outside of its clientArea, and
		// constantly resets the bounds (in org.eclipse.draw2d.FreeformViewport#readjustScrollBars)
		// So, layout based on the grand-parent's clientArea.
		final Rectangle clientArea = container.getParent().getClientArea();
		@SuppressWarnings("unchecked")
		final List<IFigure> children = container.getChildren();
		for (int i = 0; i < children.size(); i++) {
			final IFigure child = children.get(i);
			child.setBounds(clientArea);
		}

	}

	@Override
	protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
		return new Dimension(-1, -1);
	}

}
