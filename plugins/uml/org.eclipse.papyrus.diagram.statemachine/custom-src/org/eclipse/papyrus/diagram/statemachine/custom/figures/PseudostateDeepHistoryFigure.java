package org.eclipse.papyrus.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class PseudostateDeepHistoryFigure extends PapyrusNodeFigure implements IPapyrusNodeUMLElementFigure{

	/**
	 * {@inheritDoc}
	 */
	protected Border getDefaultBorder(Color borderColor) {
		return null;
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		// TODO Auto-generated method stub
		return new Dimension(22,22);
	}
	/**
	 * {@inheritDoc}
	 */
	public Label getStereotypesLabel() {
		return new Label();
	}
	/**
	 * {@inheritDoc}
	 */
	public void paintFigure(Graphics graphics) {
		
		final int space = 5;
		Rectangle f = Rectangle.SINGLETON;
		//to be in adequation with the figure node plate
		Rectangle r = getBounds().getCopy().crop(new Insets(1,1,1,1));
		graphics.setBackgroundColor(getForegroundColor());
		graphics.setLineWidth(1);
		graphics.drawOval(r);
		
		// 'H' letter
		graphics.drawLine(bounds.getCenter().getTranslated((int)(-bounds.width * 0.25), (int)(-bounds.height * 0.25)), bounds.getCenter().getTranslated((int)(-bounds.width * 0.25), (int)(bounds.height * 0.25)));
		graphics.drawLine(bounds.getCenter().getTranslated((int)(bounds.width * 0.05), (int)(-bounds.height * 0.25)), bounds.getCenter().getTranslated((int)(bounds.width * 0.05), (int)(bounds.height * 0.25)));
		graphics.drawLine(bounds.getCenter().getTranslated((int)(-bounds.width * 0.25), 0), bounds.getCenter().getTranslated((int)(bounds.width * 0.05), 0));

		// '*' character
		graphics.drawLine(bounds.getCenter().getTranslated((int)(bounds.width * 0.25), (int)(-bounds.height * 0.25)), bounds.getCenter().getTranslated((int)(bounds.width * 0.25), (int)(-bounds.height * 0.05)));
		graphics.drawLine(bounds.getCenter().getTranslated((int)(bounds.width * 0.15), (int)(-bounds.height * 0.20)), bounds.getCenter().getTranslated((int)(bounds.width * 0.35), (int)(-bounds.height * 0.10)));
		graphics.drawLine(bounds.getCenter().getTranslated((int)(bounds.width * 0.35), (int)(-bounds.height * 0.20)), bounds.getCenter().getTranslated((int)(bounds.width * 0.15), (int)(-bounds.height * 0.10)));


	}
	/**
	 * {@inheritDoc}
	 */
	public void setStereotypeDisplay(String stereotypes, Image image) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * {@inheritDoc}
	 */
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * {@inheritDoc}
	 */
	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
		// TODO Auto-generated method stub
		
	}

}
