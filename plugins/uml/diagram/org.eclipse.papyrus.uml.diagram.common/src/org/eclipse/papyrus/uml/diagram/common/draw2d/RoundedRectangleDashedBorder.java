/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.draw2d;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;
import org.eclipse.swt.SWT;

/**
 * This class provides a border drawn as a dashed rounded rectangle.
 * 
 * @author vhemery
 */
public class RoundedRectangleDashedBorder extends RoundedRectangleBorder {

	/**
	 * Creates an instance of this class with the given arc width and arc height
	 * in pixels
	 * 
	 * @param arcWidth
	 *        The width of the corner arc
	 * @param arcHeight
	 *        The height of the corner arc
	 */
	public RoundedRectangleDashedBorder(int arcWidth, int arcHeight) {
		super(arcWidth, arcHeight);
	}

	/**
	 * Get the dashed style
	 * 
	 * @see org.eclipse.draw2d.LineBorder#getStyle()
	 * @return dashed style
	 */
	@Override
	public int getStyle() {
		return SWT.LINE_DASH;
	}

	/**
	 * Paints rounded rectangular dashed border taking into account arcWidth,
	 * arcHeight, line width and line style
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder#paint(org.eclipse.draw2d.IFigure, org.eclipse.draw2d.Graphics,
	 *      org.eclipse.draw2d.geometry.Insets)
	 * 
	 * @param figure
	 *        Figure for which the paintable rectangle is needed
	 * @param graphics
	 *        the graphics
	 * @param insets
	 *        the insets
	 */
	@Override
	public void paint(IFigure figure, Graphics graphics, Insets insets) {
		graphics.setLineStyle(SWT.LINE_DASH);
		super.paint(figure, graphics, insets);
	}
}
