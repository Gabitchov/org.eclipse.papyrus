/*****************************************************************************
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.draw2d;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeNamedElementFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * The Class StickMan. This class comes from org.eclipse.uml2.diagram.usecase.draw2d provided by
 * Eclipse.org
 */
public class StickMan extends ShadowShape implements IPapyrusNodeNamedElementFigure, IPapyrusNodeFigure {

	private static final float BASE_W = 31 - 1;

	private static final float BASE_H = 50 - 1;

	private static final float FACTOR1 = 16f / BASE_H;

	private static final float FACTOR2 = 22f / BASE_H;

	private static final int P_NUM = 20;

	private int ovalX;

	private int ovalY;

	private int ovalD;

	public StickMan() {
		this(false, ColorConstants.white, ColorConstants.black);
	}

	public StickMan(boolean is3D, Color backgroundColor, Color foregroundColor) {
		super(is3D, backgroundColor, foregroundColor);
		setKeepingProportions(true);
		setW2HRatio(BASE_W / BASE_H);
	}

	/**
	 * Outlines the ellipse.
	 */
	protected void outlineShape(Graphics graphics, Rectangle bounds) {
		PointList pl = setupPoints(bounds);
		graphics.drawPolygon(pl);
		int add = graphics.getLineWidth() / 2;
		graphics.drawOval(new Rectangle(ovalX, ovalY, ovalD + add, ovalD + add));
	}

	/**
	 * {@inheritDoc}
	 */
	public Dimension getPreferredSize(int wHint, int hHint) {
		Dimension size = new Dimension(-1, -1);
		if (wHint < BASE_W) {
			size.width = (int) BASE_W;
		}
		if (hHint < BASE_H) {
			size.height = (int) BASE_H;
		}
		if(is3D()) {
			size.expand(SHADOW_SIZE, SHADOW_SIZE);
		}
		return size;
	}

	/**
	 * Fills the ellipse.
	 */
	protected void fillShape(Graphics graphics, Rectangle bounds) {
		PointList pl = setupPoints(bounds);
		graphics.fillPolygon(pl);
		int add = graphics.getLineWidth() / 2;
		graphics.fillOval(new Rectangle(ovalX, ovalY, ovalD + add, ovalD + add));
	}

	/**
	 * Setup the points to draw the stickMan figure.
	 * 
	 * @param rectangle
	 *        the specified rectangle
	 * 
	 * @return the point list
	 */
	protected PointList setupPoints(Rectangle rectangle) {
		int[] xPoints = new int[P_NUM];
		int[] yPoints = new int[P_NUM];
		PointList pl = new PointList(10);
		int W = (rectangle.width / 2) * 2;
		int H = rectangle.height;
		int X1 = W / 2;
		int Y1 = (Math.round(H * FACTOR1) / 2) * 2;
		int Y2 = Math.round(H * FACTOR2);
		int Y3 = H - (X1 - 1);
		int STEP = Math.round(W / BASE_W);
		if(STEP < 1) {
			STEP = 1;
		}
		// set positive points. (0...9)
		xPoints[0] = STEP;
		yPoints[0] = Y1;
		xPoints[1] = STEP;
		yPoints[1] = Y2 - STEP;
		xPoints[2] = X1;
		yPoints[2] = Y2 - STEP;
		xPoints[3] = X1;
		yPoints[3] = Y2 + STEP;
		xPoints[4] = STEP;
		yPoints[4] = Y2 + STEP;
		xPoints[5] = STEP;
		yPoints[5] = Y3 - STEP;
		xPoints[6] = X1;
		yPoints[6] = H - STEP;
		xPoints[7] = X1;
		yPoints[7] = H;
		xPoints[8] = X1 - 2 * STEP;
		yPoints[8] = H;
		xPoints[9] = 0;
		yPoints[9] = Y3 + STEP;
		// reflect points 0..8
		for(int i = 0; i <= 8; i++) {
			xPoints[18 - i] = -xPoints[i];
			yPoints[18 - i] = yPoints[i];
		}
		// close polyline.
		xPoints[19] = xPoints[0];
		yPoints[19] = yPoints[0];
		// shift all points and copy to integer.
		for(int i = 0; i < P_NUM; i++) {
			xPoints[i] += X1;
			xPoints[i] += rectangle.x;
			yPoints[i] += rectangle.y;
		}
		for(int i = 0; i < xPoints.length; i++) {
			pl.addPoint(xPoints[i], yPoints[i]);
		}
		// head-oval
		ovalD = Y1;
		ovalX = X1 - ovalD / 2 + rectangle.x;
		ovalY = rectangle.y;
		return pl;
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

	public void setStereotypeDisplay(String stereotypes, Image image) {
		// TODO Auto-generated method stub
	}

	public void setQualifiedName(String qualifiedName) {
		// TODO Auto-generated method stub
	}

	public Label getQualifiedNameLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public Label getTaggedLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setDepth(int depth) {
		// TODO Auto-generated method stub
	}

	public WrappingLabel getNameLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setNameLabelIcon(boolean displayNameLabelIcon) {
		// TODO Auto-generated method stub
	}

	public Color getBorderColor() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isShadow() {
		// TODO Auto-generated method stub
		return false;
	}

	public void setBorderColor(Color borderColor) {
		// TODO Auto-generated method stub
		
	}

	public void setShadow(boolean shadow) {
		// TODO Auto-generated method stub
		
	}

	public void setTransparency(int transparency) {
		// TODO Auto-generated method stub
		
	}

	public void setGradientData(int gradientColor1, int gradientColor2, int gradientStyle) {
		// TODO Auto-generated method stub
		
	}

	public void setIsUsingGradient(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
