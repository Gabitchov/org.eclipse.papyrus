/****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Ansgar Radermacher (CEA LIST) - Initial API and implementation
 *	
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;

/**
 * A label in which the added icon is scaled to the height of the
 * text font. Only bigger icons are scaled, smaller remain unchanged.
 * 
 */
public class LabelWithScalableIcons extends Label {

	@Override
	public void paintFigure(Graphics graphics) {
		if(isOpaque()) {
			// super.paintFigure(graphics);
		}
		Rectangle bounds = getBounds();
		graphics.translate(bounds.x, bounds.y);
		if(getIcon() != null) {
			paintScaledIcon(graphics);
		}
		if(!isEnabled()) {
			graphics.translate(1, 1);
			graphics.setForegroundColor(ColorConstants.buttonLightest);
			graphics.drawText(getSubStringText(), getTextLocation());
			graphics.translate(-1, -1);
			graphics.setForegroundColor(ColorConstants.buttonDarker);
		}
		graphics.drawText(getSubStringText(), getTextLocation());
		graphics.translate(-bounds.x, -bounds.y);
	}

	@Override
	protected Dimension getIconSize() {
		int width = 0;
		if(getFont() == null) {
			return new Dimension(0, 16);
		}

		int height = getTextSize().height;
		Image icon = getIcon();
		if(icon != null) {
			org.eclipse.swt.graphics.Rectangle bounds = icon.getBounds();
			double scale = (double)(height - 2) / bounds.height;
			if(scale > 1) {
				scale = 1;
			}
			width = (int)(bounds.width * scale);
		}
		return new Dimension(width, height);
	}

	/**
	 * Paints the icon(s)
	 * 
	 * @param graphics
	 *        The graphics context
	 */
	private void paintScaledIcon(Graphics graphics) {
		Point p = getIconLocation();
		if(p != null) {
			int height = getTextSize().height;
			Image icon = getIcon();
			if(icon != null) {
				org.eclipse.swt.graphics.Rectangle bounds = icon.getBounds();
				double scale = (double)(height - 2) / bounds.height;
				if(scale > 1) {
					scale = 1;
				}
				graphics.drawImage(icon, 0, 0, bounds.width, bounds.height, p.x, p.y, (int)(bounds.width * scale), (int)(bounds.height * scale));
			}
		}
	}
}
