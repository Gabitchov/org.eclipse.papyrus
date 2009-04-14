package org.eclipse.papyrus.diagram.common.figure.node;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;

public class StereotypePropertiesCompartment extends RectangleFigure {

	public void paint(Graphics graphics) {
		paintChildren(graphics);
		graphics.setForegroundColor(getForegroundColor());
		for (int i = 0; i < getChildren().size(); i++) {
			graphics.drawLine(((IFigure) getChildren().get(i)).getBounds().getTopLeft(), ((IFigure) getChildren().get(i)).getBounds().getTopRight());
		}
	}

}
