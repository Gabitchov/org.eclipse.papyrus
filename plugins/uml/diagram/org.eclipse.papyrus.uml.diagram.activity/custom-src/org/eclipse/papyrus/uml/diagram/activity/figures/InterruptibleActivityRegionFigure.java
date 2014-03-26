/*****************************************************************************
 * Copyright (c) 2010, 2014 Atos Origin, CEA, and others.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *   Christian W. Damus (CEA) - bug 392301
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.graphics.ColorRegistry;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.papyrus.uml.diagram.common.draw2d.RoundedRectangleDashedBorder;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.RoundedRectangleDashedShadowBorder;
import org.eclipse.swt.graphics.Image;

/**
 * This figure handles a rounded dashed rectangle Papyrus node, with no
 * displayed label.
 * 
 * @author vhemery
 */
public class InterruptibleActivityRegionFigure extends PapyrusNodeFigure implements IPapyrusNodeUMLElementFigure, IFigure {

	/** the size of the rounded corner */
	private static int ROUNDED_CORNER_SIZE = 8;

	/** the size of the rounded corner */
	private static int BORDER_SIZE = 3;

	/**
	 * Default Constructor.
	 */
	public InterruptibleActivityRegionFigure() {
		shadowborder = new RoundedRectangleDashedShadowBorder(BORDER_SIZE, getForegroundColor(), ROUNDED_CORNER_SIZE, ROUNDED_CORNER_SIZE);
		setBorder(shadowborder);
	}

	/**
	 * Paint figure.
	 * 
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 * @param graphics
	 *        the graphics
	 */
	public void paintFigure(Graphics graphics) {
		paintBackground(graphics, getBounds());
		shadowborder.setColor(getForegroundColor());
	}

	/**
	 * Paint the background of the figure. If this figure uses gradient, then it
	 * will paint the background with the gradient informations. Otherwise it
	 * will use the background color.
	 * 
	 * @param graphics
	 *        the graphics
	 * @param rectangle
	 *        the rectangle where the background needs to be fill.
	 */
	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		if(isUsingGradient()) {
			applyTransparency(graphics);
			boolean isVertical = (getGradientStyle() == GradientStyle.VERTICAL) ? true : false;
			graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));
			graphics.setForegroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
			graphics.fillGradient(rectangle, isVertical);
		} else {
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.setForegroundColor(getForegroundColor());
			// let the figure unfilled to see behind it
			// graphics.fillRectangle(rectangle);
		}
	}

	/**
	 * set the shadow
	 * 
	 * @param shadow
	 *        a boolean true if we want to display the shadow
	 */
	public void setShadow(boolean shadow) {
		super.setShadow(shadow);
		if(!shadow) {
			RoundedRectangleDashedBorder bord = new RoundedRectangleDashedBorder(ROUNDED_CORNER_SIZE, ROUNDED_CORNER_SIZE);
			this.setBorder(bord);
		}
	}

	public void setStereotypeDisplay(String stereotypes, Image image) {
		// TODO Auto-generated method stub
	}

	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		// TODO Auto-generated method stub
	}

	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
		// TODO Auto-generated method stub
	}

	public Label getStereotypesLabel() {
		// TODO Auto-generated method stub
		return null;
	}
}
