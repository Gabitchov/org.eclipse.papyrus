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
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;


/**
 * An image that can be scaled (respecting the aspect ratio).
 * See also GMF ScalableImageFigure (which does not work well for an unknown reason)
 * 
 */
public class ScaledImageFigure extends ImageFigure {

	@Override
	protected void paintFigure(Graphics graphics) {
		Image img = getImage();
		if(img == null) {
			return;
		}
		Rectangle area = getBounds().getShrinked(getInsets());
		int x = (area.width - (int)(size.width * scale)) / 2 + area.x;
		int y = (area.height - (int)(size.height * scale)) / 2 + area.y;

		graphics.drawImage(getImage(), 0, 0, size.width, size.height,
			x, y, (int)(size.width * scale), (int)(size.height * scale));
	}

	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension d = super.getPreferredSize(wHint, hHint).getCopy();
		d.scale(scale);
		return d;
	}

	@Override
	public void setImage(Image image) {
		if(image != null)
			size = new Rectangle(image.getBounds()).getSize();
		else
			size = new Dimension();
		super.setImage(image);
	}

	/**
	 * set the scale factor.
	 * 
	 * @param scale
	 *        the scale factor. 0 < scale <= 1
	 */
	public void setScale(double scale) {
		this.scale = scale;
	}

	private double scale = 1;

	private Dimension size;
}
