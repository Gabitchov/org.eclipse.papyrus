package org.eclipse.papyrus.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

public class JoinForkNodeFigure extends RectangleFigure{

	
	protected void fillShape(Graphics graphics) {

		graphics.pushState();
		graphics.setBackgroundColor(ColorConstants.black);
		graphics.fillRectangle(getBounds());
		graphics.popState();
		
	}
	
}
