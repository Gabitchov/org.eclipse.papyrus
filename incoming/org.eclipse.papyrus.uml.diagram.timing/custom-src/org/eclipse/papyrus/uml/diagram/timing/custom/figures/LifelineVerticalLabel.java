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
import org.eclipse.papyrus.uml.diagram.common.figure.node.ILabelFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

public class LifelineVerticalLabel extends VerticalLabel implements ILabelFigure {

	private boolean selected;
	private boolean focus;

	@Override
	public Color getBackgroundColor() {
		if (this.selected) {
			return Display.getDefault().getSystemColor(SWT.COLOR_LIST_SELECTION);
		}
		// the transparency color for the label
		return ColorConstants.white;
	}

	@Override
	public Color getForegroundColor() {
		if (this.selected) {
			return Display.getDefault().getSystemColor(SWT.COLOR_LIST_SELECTION_TEXT);
		}
		return super.getForegroundColor();
	}

	@Override
	public String getText() {
		final String text = super.getText();
		// vertical label triggers IllegalArgumentException if text is empty
		return text == null || "".equals(text) ? " " : text; //$NON-NLS-1$//$NON-NLS-2$
	}

	public void setIcon(final Image icon) {
		// no icon
	}

	public Image getIcon() {
		return null;
	}

	public void setSelected(final boolean value) {
		this.selected = value;
		// display the blue background when the figure is selected
		setOpaque(value);
		updateImage();
	}

	public void setFocus(final boolean value) {
		this.focus = value;
		repaint();
	}

	@Override
	protected void paintFigure(final Graphics graphics) {
		super.paintFigure(graphics);
		if (this.focus) {
			graphics.drawFocus(getBounds().getResized(-1, -1));
		}
	}
}
