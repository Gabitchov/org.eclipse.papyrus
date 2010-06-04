package org.eclipse.papyrus.diagram.activity.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.papyrus.diagram.common.draw2d.RoundedRectangleDashedBorder;
import org.eclipse.papyrus.diagram.common.figure.node.PapyrusNodeFigure;

/**
 * This figure handles a rounded dashed rectangle Papyrus node, with no displayed label.
 * 
 * @author vhemery
 */
public class InterruptibleActivityRegionFigure extends PapyrusNodeFigure implements IFigure {

	/** the size of the rounded corner */
	private static int ROUNDED_CORNER_SIZE = 8;

	/**
	 * Paint figure.
	 * 
	 * @see org.eclipse.papyrus.diagram.common.figure.node.PapyrusNodeFigure#paintFigure(org.eclipse.draw2d.Graphics)
	 * @param graphics
	 *        the graphics
	 */
	public void paintFigure(Graphics graphics) {
		paintBackground(graphics, getBounds());
		shadowborder.setColor(getForegroundColor());
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

}
