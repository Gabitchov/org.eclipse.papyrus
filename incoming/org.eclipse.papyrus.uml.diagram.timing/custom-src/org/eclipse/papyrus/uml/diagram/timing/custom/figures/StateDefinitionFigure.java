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
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;

public class StateDefinitionFigure extends NodeNamedElementFigure {

	private boolean selected;

	public StateDefinitionFigure() {
		super();
		setShadow(false);
		setBorder(null);
	}

	public void setSelected(final boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return this.selected;
	}

	@Override
	public void paintFigure(final Graphics graphics) {
		paintClientArea(graphics);
		paintFocusRectangle(graphics);
	}

	@Override
	protected void paintClientArea(final Graphics graphics) {
		super.paintClientArea(graphics);
	}

	private void paintFocusRectangle(final Graphics g) {
		if (isSelected()) {
			g.pushState();
			g.setXORMode(true);
			g.setForegroundColor(ColorConstants.menuBackgroundSelected);
			g.setBackgroundColor(ColorConstants.menuForegroundSelected);
			final Rectangle b = getBounds();
			final Rectangle focusRect = new Rectangle(b.x, b.y, b.width - 1, b.height - 1);
			g.setLineWidth(1);
			g.drawFocus(focusRect);
			g.popState();
		}
	}

	@Override
	protected void paintBorder(final Graphics graphics) {
		// no border
	}
}
