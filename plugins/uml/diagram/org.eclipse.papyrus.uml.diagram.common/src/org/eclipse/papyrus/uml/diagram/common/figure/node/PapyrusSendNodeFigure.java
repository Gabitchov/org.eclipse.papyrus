/*****************************************************************************
 * Copyright (c) 2010, 2014 CEA LIST and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) patrick.tessier@cea.fr - Initial API and implementation
 *  Christian W. Damus (CEA) - bug 392301
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.AbstractBackground;
import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.graphics.ColorRegistry;
import org.eclipse.swt.graphics.Color;
/**
 * this class is used to display a sendNodeFigure, the gradient can be only
 * horizontal
 *
 */

public class PapyrusSendNodeFigure extends NodeNamedElementFigure {

	public PapyrusSendNodeFigure(){
		super();
		widthArrow=15;
		this.shadowborder=new PapyrusSendNodeShadowBorder(1, getBorderColor(),widthArrow);
		setBorder(this.shadowborder);
	}
	public int widthArrow=15;
	
	@Override
	protected Border getDefaultBorder(Color borderColor) {
		return new PapyrusSendNodeShadowBorder(1, borderColor,widthArrow);
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
			graphics.fillRoundRectangle(tempRect, widthArrow, widthArrow);
			return;
		}
		if (isOpaque())
			graphics.fillRoundRectangle(getBounds(), widthArrow, widthArrow);

		if (getBorder() instanceof AbstractBackground)
			((AbstractBackground) getBorder()).paintBackground(this, graphics,
				NO_INSETS);

		paintBackground(graphics, getBounds());

		shadowborder.setColor(getForegroundColor());

	}

	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		PointList ptList= new PointList();
		ptList.addPoint(getBounds().getLocation());
		ptList.addPoint(getBounds().x+getBounds().width-widthArrow, getBounds().y);
		ptList.addPoint(getBounds().x+getBounds().width, getBounds().y+(getBounds().height/2));
		ptList.addPoint(getBounds().x+getBounds().width-widthArrow, getBounds().y+(getBounds().height));
		ptList.addPoint(getBounds().getBottomLeft());
		if(isUsingGradient()) {
			applyTransparency(graphics);
			graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));
			graphics.setForegroundColor(getForegroundColor());
			graphics.fillPolygon(ptList);
			
			Rectangle rect1= new Rectangle(rectangle.getLocation(),new Dimension(getBounds().width-widthArrow,rectangle.height));
			graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));
			graphics.setForegroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
			graphics.fillGradient(rect1, false);
			
		}
		else{
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.setForegroundColor(getForegroundColor());
			graphics.fillPolygon(ptList);
		}
	}

}
