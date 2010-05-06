package org.eclipse.papyrus.diagram.statemachine.custom.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.diagram.common.locator.ExternalLabelPositionLocator;

public class CustomLabelInRegionCompartmentLocator extends ExternalLabelPositionLocator {

	/** the figure around which this label appears */
	protected IFigure parentFigure = null;

	/** the position constraint */
	protected Rectangle constraint = null;
	
	protected Rectangle regionRectangle= null;
	
	
	/** Constructor **/
	public CustomLabelInRegionCompartmentLocator(IFigure parentFigure, Rectangle rectangle) {
		super(parentFigure);
		this.parentFigure = parentFigure;
		this.constraint = rectangle;
		this.regionRectangle=rectangle;
	}
	
	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getValidLocation(org.eclipse.draw2d.geometry.Rectangle,
	 *      org.eclipse.draw2d.IFigure)
	 * 
	 * @param proposedLocation
	 * @param borderItem
	 * @return the valid location
	 */
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		//return new Rectangle(proposedLocation);
		Rectangle realLocation = new Rectangle(proposedLocation);

		if(realLocation.x < 0) {
			realLocation.x = 0;
		}

		if(realLocation.x > regionRectangle.width) {
			realLocation.x = regionRectangle.width;
		}

		if(realLocation.y > regionRectangle.height){
			realLocation.y = regionRectangle.height  ;
		}
		
		if(realLocation.y < 0){
			realLocation.y =0;
		} 
		return realLocation;
	}
}
