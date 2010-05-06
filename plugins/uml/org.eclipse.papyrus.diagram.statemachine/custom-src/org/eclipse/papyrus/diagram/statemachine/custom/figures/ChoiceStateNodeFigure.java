package org.eclipse.papyrus.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.ui.internal.layout.LayoutUtil;

public class ChoiceStateNodeFigure extends Shape{

	/**
	 * Does nothing.
	 * 
	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void fillShape(Graphics graphics) {
	}

	/**
	 * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		Rectangle f = Rectangle.SINGLETON;
		Rectangle r = getBounds();
		f.x = r.x + lineWidth / 2;
		f.y = r.y + lineWidth / 2;
		f.width = r.width - lineWidth;
		f.height = r.height - lineWidth;

		PointList pl = new PointList();
		pl.addPoint(f.getTop());
		pl.addPoint(f.getRight());
		pl.addPoint(f.getBottom());
		pl.addPoint(f.getLeft());

		graphics.drawPolygon(pl);

	}


}
