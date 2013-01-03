/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.layouts;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class FillLayout extends AbstractLayout {
	public void layout(final IFigure container) {
		final Rectangle clientArea = container.getClientArea();
		final List<?> children = container.getChildren();
		for (int i = 0; i < children.size(); i++) {
			final IFigure child = (IFigure) children.get(i);
			child.setBounds(clientArea);
			if (child instanceof FreeformLayer) {
				final FreeformLayer freeformLayer = (FreeformLayer) child;
				freeformLayer.setFreeformBounds(clientArea);
			}
		}
	}

	@Override
	protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
		return new Dimension(-1, -1);
	}
}
