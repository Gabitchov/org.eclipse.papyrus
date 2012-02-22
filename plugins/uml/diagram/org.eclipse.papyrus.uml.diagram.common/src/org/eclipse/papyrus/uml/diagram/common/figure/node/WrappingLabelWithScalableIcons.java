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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Image;

/**
 * A wrapped label in which icons are scaled to the height of the text font. As for the
 * superclass WrappingLabel, multiple icons are supported and aligned horizontally.
 * Only bigger icons are scaled, smaller remain unchanged.
 * 
 */
public class WrappingLabelWithScalableIcons extends WrappingLabel {

	/**
	 * Width between icons (and between icons & text)
	 */
	public final static int GAP_WIDTH = 4;

	@Override
	public void paintFigure(Graphics graphics) {
		if(hasIcons()) {
			paintScaledIcons(graphics);
		}
	}

	@Override
	protected Dimension getTotalIconSize() {
		int num = getNumberofIcons();
		if(num == 0) {
			return new Dimension(0, 0);
		}
		Rectangle r = getTextBounds();
		int width = 0;
		for(int i = 0; i < num; i++) {
			Image icon = getIcon(i);
			if(icon != null) {
				org.eclipse.swt.graphics.Rectangle bounds = icon.getBounds();
				double scale = (double)(r.height - 2) / bounds.height;
				if(scale > 1) {
					scale = 1;
				}
				width += GAP_WIDTH + (int)(bounds.width * scale);
			}
		}
		return new Dimension(width, r.height);
	}

	/**
	 * Paints the icon(s)
	 * 
	 * @param graphics
	 *        The graphics context
	 */
	private void paintScaledIcons(Graphics graphics) {

		if(getIconLocation() != null) {
			Point p = Point.SINGLETON;
			p.setLocation(getIconLocation());

			Rectangle figBounds = getBounds();
			p.x += figBounds.x;
			p.y += figBounds.y;

			Rectangle r = getTextBounds();

			int num = getNumberofIcons();
			for(int i = 0; i < num; i++) {
				Image icon = getIcon(i);
				if(icon != null) {
					org.eclipse.swt.graphics.Rectangle bounds = icon.getBounds();
					double scale = (double)(r.height - 2) / bounds.height;
					if(scale > 1) {
						scale = 1;
					}
					graphics.drawImage(icon, 0, 0, bounds.width, bounds.height,
						p.x, p.y, (int)(bounds.width * scale), (int)(bounds.height * scale));
					p.x += GAP_WIDTH + (int)(bounds.width * scale);;
				}
			}
		}
	}
}
