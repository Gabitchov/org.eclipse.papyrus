package org.eclipse.papyrus.uml.diagram.component.custom.figure.nodes;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;

/**
 * Figure for Required interface. It draws an half circle.
 */
public class LollipopInterfaceFigure  extends PapyrusNodeFigure implements IPapyrusNodeUMLElementFigure{

	/** sets the beginning of the arc */
	protected int arcStarting = 0;

	protected boolean isRequired=false;
	protected boolean isProvided=false;

	/**
	 * display the Interface as Required
	 * @param required true if required 
	 */
	public void setRequired(boolean required){
		this.isRequired=required;
	}
	/**
	 * 
	 * Constructor.
	 *
	 */
	public LollipopInterfaceFigure() {
	setShadow(false);
	setBorder(null);
	}

	/**
	 * display it as provided
	 * @param provided true if the display has to be provided
	 */
	public void setProvided(boolean provided){
		this.isProvided=provided;
	}
	/**
	 * Sets the orientation of the arc
	 * 
	 * @param positionConstants
	 *            position of the interface compared to the port
	 * @see PositionConstants
	 */
	public void setOrientation(int positionConstants) {
		if (positionConstants == PositionConstants.SOUTH) {
			arcStarting = 180;
		}
		if (positionConstants == PositionConstants.SOUTH_EAST) {
			arcStarting = 225;
		}
		if (positionConstants == PositionConstants.EAST) {
			arcStarting = 270;
		}
		if (positionConstants == PositionConstants.NORTH_EAST) {
			arcStarting = 315;
		}
		if (positionConstants == PositionConstants.NORTH) {
			arcStarting = 0;
		}
		if (positionConstants == PositionConstants.NORTH_WEST) {
			arcStarting = 45;
		}
		if (positionConstants == PositionConstants.WEST) {
			arcStarting = 90;
		}
		if (positionConstants == PositionConstants.SOUTH_WEST) {
			arcStarting = 135;
		}
		this.repaint();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cea.papyrus.diagram.composite.figure.ProvidedInterfaceFigure#paintFigure(org.eclipse.
	 * draw2d.Graphics)
	 */
	@Override
	public void paintFigure(Graphics graphics) {
		if(isRequired && !isProvided){
			graphics.pushState();
			graphics.setAntialias(SWT.ON);
			Rectangle area = getBounds();
			graphics.setLineWidth(1);
			graphics.drawArc(area.x , area.y, area.width-1, area.height-1, arcStarting, 180);
			graphics.popState();
		}
		else if(!isRequired&& isProvided ){
			graphics.pushState();
			graphics.setAntialias(SWT.ON);
			graphics.setLineWidth(1);
			Rectangle area = getBounds();

			graphics.drawOval(area.x , area.y , area.width-1, area.height-1);
			graphics.popState();

		}
		else if(isRequired && isProvided){
			graphics.pushState();
			graphics.setAntialias(SWT.ON);
			graphics.setLineWidth(1);
			Rectangle area = getBounds();
			graphics.drawOval(area.x + 2, area.y + 2, area.width - 5, area.height - 5);
			graphics.drawArc(area.x , area.y , area.width-1 , area.height-1 , arcStarting, 180);
			graphics.popState();

		}
		else {
			graphics.pushState();
			graphics.setAntialias(SWT.ON);
			graphics.setLineWidth(1);
			Rectangle area = getBounds();

			graphics.drawOval(area.x , area.y , area.width-1 , area.height-1 );
			graphics.popState();

		}
		

	}

	@Override
	public void setStereotypeDisplay(String stereotypes, Image image) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
		// TODO Auto-generated method stub

	}

	@Override
	public Label getStereotypesLabel() {
		// TODO Auto-generated method stub
		return null;
	}

}
