package org.eclipse.papyrus.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.*;
import org.eclipse.draw2d.geometry.Dimension;

public class InitialNodeFigure extends Ellipse {
	/**
	 * Fills the circle.
	 * 
	 * @param graphics
	 *        the graphics
	 * 
	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	 */
	protected void fillShape(Graphics graphics) {
		graphics.pushState();
		graphics.setBackgroundColor(ColorConstants.black);
		graphics.fillOval(getBounds());
		graphics.popState();

	}
}
