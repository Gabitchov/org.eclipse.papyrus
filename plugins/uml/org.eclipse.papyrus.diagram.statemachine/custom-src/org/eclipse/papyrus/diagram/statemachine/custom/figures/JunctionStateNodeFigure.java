package org.eclipse.papyrus.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;

public class JunctionStateNodeFigure extends Ellipse {

	protected void fillShape(Graphics graphics) {
		graphics.pushState();
		graphics.setBackgroundColor(ColorConstants.black);
		graphics.fillOval(getBounds());
		graphics.popState();
	}
}
