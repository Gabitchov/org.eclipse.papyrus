/*****************************************************************************
 * Copyright (c) 2010 CEA
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
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import java.util.List;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

public class CoRegionCombinedFragmentFigure extends RectangleFigure {

	// The area (to the left,right, top and bottom) near the border of the Coregion that is sensible to the mouse
	private static final int COREGION_HIT_WIDTH = 6;

	private static final int BRACKET_HEIGHT = 7;

	private static final int BRACKET_LINE_WIDTH = 3;

	/** The DashLine figure where elements will be attached */
	private NodeFigure centralVerticalLine;

	/**
	 * Constructor
	 * 
	 * @generated
	 */
	public CoRegionCombinedFragmentFigure() {
		super();
		// Init centralVerticalLine
		centralVerticalLine = new NodeFigure();
		centralVerticalLine.setParent(this);
		setLineWidth(BRACKET_LINE_WIDTH);
	}

	/**
	 * Draw the vertical bracket
	 * 
	 * @see org.eclipse.draw2d.Shape#paintFigure(org.eclipse.draw2d.Graphics)
	 */
	@Override
	public void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		graphics.setBackgroundColor(this.getBackgroundColor());
		graphics.setForegroundColor(this.getForegroundColor());
		graphics.setLineWidth(getLineWidth());
		graphics.drawLine(r.x, r.y, r.right() - 1, r.y);
		graphics.drawLine(r.x, r.bottom() - 1, r.right() - 1, r.bottom() - 1);
		graphics.drawLine(r.x, r.y, r.x, r.y + BRACKET_HEIGHT);
		graphics.drawLine(r.right() - 1, r.y + BRACKET_HEIGHT, r.right() - 1, r.y);
		graphics.drawLine(r.right() - 1, r.bottom() - 1, r.right() - 1, r.bottom() - 1 - BRACKET_HEIGHT);
		graphics.drawLine(r.x, r.bottom() - 1, r.x, r.bottom() - 1 - BRACKET_HEIGHT);
		// Refresh the line
		int endY = r.height + r.y;//fixed a issue on height.
		Point pStart = new Point(r.x + r.width / 2, r.y + 1);
		centralVerticalLine.setSize(1, endY - pStart.y);
		centralVerticalLine.setLocation(pStart);
	}

	/**
	 * @see org.eclipse.draw2d.Figure#containsPoint(int, int)
	 */
	@Override
	public boolean containsPoint(int x, int y) {
		Rectangle rect = getBounds();
		// check if point is at the topline of the figure
		if(x > rect.x && x < rect.x + rect.width) {
			if(y > rect.y - COREGION_HIT_WIDTH && y < rect.y + COREGION_HIT_WIDTH) {
				return true;
			}
		}
		// check if point is at the bottom line of the figure
		if(x > rect.x && x < rect.x + rect.width) {
			if(y > rect.y + rect.height - COREGION_HIT_WIDTH && y < rect.y + rect.height + COREGION_HIT_WIDTH) {
				return true;
			}
		}
		// check if point is at the left line of the figure
		if(x > rect.x - COREGION_HIT_WIDTH && x < rect.x + COREGION_HIT_WIDTH) {
			if(y > rect.y && y < rect.y + rect.height) {
				return true;
			}
		}
		// check if point is at the right line of the figure
		if(x > rect.x + rect.width - COREGION_HIT_WIDTH && x < rect.x + rect.width + COREGION_HIT_WIDTH) {
			if(y > rect.y && y < rect.y + rect.height) {
				return true;
			}
		}
		for(IFigure child : (List<IFigure>)getChildren()) {
			Point local = new Point(x, y);
			translateFromParent(local);
			if(child.containsPoint(local)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Get a rectangleFigure representing a central vertical line
	 */
	public NodeFigure getCentralVerticalLine() {
		return centralVerticalLine;
	}
}
