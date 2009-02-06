/*
 * Copyright (c) 2006 Borland Software Corporation
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Michael Golubev (Borland) - initial API and implementation
 */

package org.eclipse.papyrus.diagram.common.draw2d;

import java.util.List;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;

public class CenterLayout extends StackLayout {

	private static final Rectangle RECTANGLE = new Rectangle();

	@Override
	public void layout(IFigure figure) {
		Rectangle r = figure.getClientArea();
		final int centerX = r.x + r.width / 2;
		final int centerY = r.y + r.height / 2;
		List children = figure.getChildren();
		IFigure child;
		for (int i = 0; i < children.size(); i++) {
			child = (IFigure) children.get(i);
			Dimension prefSize = child.getPreferredSize(r.width, r.height);
			RECTANGLE.x = centerX - prefSize.width / 2;
			RECTANGLE.y = centerY - prefSize.height / 2;
			RECTANGLE.width = prefSize.width;
			RECTANGLE.height = prefSize.height;
			// Workaround for 209648
			child.setBounds(RECTANGLE);
		}
	}
}
