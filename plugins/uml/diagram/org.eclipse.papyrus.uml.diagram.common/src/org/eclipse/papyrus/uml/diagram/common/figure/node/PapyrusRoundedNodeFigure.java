/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.AbstractBackground;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.draw2d.ui.figures.RoundedRectangleBorder;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.swt.graphics.Color;
/**
 * this class is used to display a rounded rectangle with gradient and intherits
 * from the hierarchy of papyrus nodes
 *
 */

public class PapyrusRoundedNodeFigure extends NodeNamedElementFigure {

	public PapyrusRoundedNodeFigure(){
		super();
		corner=15;
		this.shadowborder= new RoundedRectangleBorder(corner, corner);
		setBorder(this.shadowborder);
	}
	public int corner=15;
	
	@Override
	protected Border getDefaultBorder(Color borderColor) {
		return new RoundedRectangleBorder(corner, corner);
	}
	/**
	 * Paint figure.
	 * 
	 * @param graphics
	 *        the graphics
	 */
	@Override
	public void paintFigure(Graphics graphics) {
		if (isOpaque() && getBorder() != null) {
			Rectangle tempRect = new Rectangle(getBounds());
			tempRect.crop(getBorder().getInsets(this));
			graphics.fillRoundRectangle(tempRect, corner, corner);
			return;
		}
		if (isOpaque())
			graphics.fillRoundRectangle(getBounds(), corner, corner);

		if (getBorder() instanceof AbstractBackground)
			((AbstractBackground) getBorder()).paintBackground(this, graphics,
				NO_INSETS);

		paintBackground(graphics, getBounds());

		shadowborder.setColor(getForegroundColor());

	}

	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		if(isUsingGradient()) {
			applyTransparency(graphics);
			boolean isVertical = (getGradientStyle() == GradientStyle.VERTICAL) ? true : false;
			if(isVertical && rectangle.height>((3*corner)/2)){
				Rectangle rect1= new Rectangle(rectangle.getLocation(),new Dimension(rectangle.width,corner));
				Rectangle rect2= new Rectangle(rectangle.x,rectangle.y+rectangle.height-corner,rectangle.width,corner);;
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				graphics.fillRoundRectangle(rect1,corner,corner);
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.fillRoundRectangle(rect2,corner,corner);

				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.setForegroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				Rectangle rect= new Rectangle(rectangle.x,rectangle.y+corner/2,rectangle.width,rectangle.height-corner);
				graphics.fillGradient(rect, true);
			}
			else if(!isVertical && rectangle.width>((3*corner)/2)){
				Rectangle rect1= new Rectangle(rectangle.getLocation(),new Dimension(corner,rectangle.height));
				Rectangle rect2= new Rectangle(rectangle.x+rectangle.width-corner,rectangle.y,corner,rectangle.height);
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				graphics.fillRoundRectangle(rect1,corner,corner);
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.fillRoundRectangle(rect2,corner,corner);

				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.setForegroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				Rectangle rect= new Rectangle(rectangle.x+corner/2, rectangle.y,rectangle.width-corner,rectangle.height);
				graphics.fillGradient(rect, false);
			}
			else{
				graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
				graphics.setForegroundColor(FigureUtilities.integerToColor(getGradientColor2()));
				graphics.fillRoundRectangle(rectangle,corner,corner);
			}
		}
		else {
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.setForegroundColor(getForegroundColor());
			graphics.fillRoundRectangle(rectangle,corner,corner);
		}
	}

}
