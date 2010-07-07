package org.eclipse.papyrus.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeFigure;
import org.eclipse.papyrus.diagram.common.figure.node.NodeNamedElementFigure;

public class StateFigure extends NodeNamedElementFigure implements IPapyrusNodeFigure {

	protected int roundedBorderSize = 20;

	/**
	 * Default Constructor
	 */
	public StateFigure() {
		shadowborder = new RoundedShadowBorder(getForegroundColor());
		setBorder(shadowborder);
	}

	public void paintFigure(Graphics graphics) {
		paintBackground(graphics, getBounds());
		shadowborder.setColor(getForegroundColor());
	}

	public void setShadow(boolean shadow) {
		super.setShadow(shadow);
		if(!shadow) {
			RoundedBorder bord = new RoundedBorder(roundedBorderSize, roundedBorderSize);
			this.setBorder(bord);
		}
	}

}
