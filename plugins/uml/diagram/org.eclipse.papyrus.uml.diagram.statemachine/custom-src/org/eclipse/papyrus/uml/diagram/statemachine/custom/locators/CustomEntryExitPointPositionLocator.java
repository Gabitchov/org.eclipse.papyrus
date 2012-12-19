package org.eclipse.papyrus.uml.diagram.statemachine.custom.locators;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;



/**
 * This class is used to constrain the position of Entry/Exit points when they are added on a StateMachine
 * 
 */
public class CustomEntryExitPointPositionLocator implements IBorderItemLocator {

	/** the figure around which this border item appears */
	protected IFigure parentFigure = null;

	/** the width of the area surrounding the parent figure where border item can be put */
	protected int borderItemOffset = 10;

	/** the position constraint */
	protected Rectangle constraint = new Rectangle(0, 0, 0, 0);

	/** Constructor **/
	public CustomEntryExitPointPositionLocator(IFigure parentFigure, int preferredSide) {
		// The preferredSide parameter is not used, just kept here to ensure compatibility 
		// with GMF generated code.
		this.parentFigure = parentFigure;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getCurrentSideOfParent()
	 * 
	 * @return
	 *         the position of the port around its parent. This position can be
	 *         <ul>
	 *         <li>{@linkplain PositionConstants#NORTH}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH}</li>
	 *         <li> {@linkplain PositionConstants#EAST}</li>
	 *         <li> {@linkplain PositionConstants#WEST}</li>
	 *         <li> {@linkplain PositionConstants#NORTH_EAST}</li>
	 *         <li> {@linkplain PositionConstants#NORTH_WEST}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH_EAST}</li>
	 *         <li> {@linkplain PositionConstants#SOUTH_WEST}</li>
	 *         </ul>
	 */
	public int getCurrentSideOfParent() {
		int position = PositionConstants.NONE;

		//		System.out.println("parentsBounds = " + parentFigure.getBounds());

		//we are not on EAST, not on WEST, but we are on the NORTH
		if((constraint.x != parentFigure.getBounds().width - borderItemOffset) && (constraint.x != -this.borderItemOffset) && (constraint.y == -this.borderItemOffset)) {
			position = PositionConstants.NORTH;

			//we are not on the EAST and not on the WEST, but we are on the SOUTH			
		} else if((constraint.x != parentFigure.getBounds().width - borderItemOffset) && (constraint.x != -this.borderItemOffset) && (constraint.y == parentFigure.getBounds().height - borderItemOffset)) {
			position = PositionConstants.SOUTH;

			//we are on the EAST, but we are not on the NORTH and not on the SOUTH
		} else if((constraint.x == parentFigure.getBounds().width - borderItemOffset) && (constraint.y != -this.borderItemOffset) && (constraint.y != parentFigure.getBounds().height - borderItemOffset)) {
			position = PositionConstants.EAST;

			//we are on the WEST, but we are not on the on the NORTH and not on the SOUTH
		} else if((constraint.x == -this.borderItemOffset) && (constraint.y != -this.borderItemOffset) && (constraint.y != parentFigure.getBounds().height - borderItemOffset)) {
			position = PositionConstants.WEST;

			//we are on the NORTH and on the EAST
		} else if((constraint.x == parentFigure.getBounds().width - borderItemOffset) && (constraint.y == -this.borderItemOffset)) {
			position = PositionConstants.NORTH_EAST;

			//we are on the NORTH and on the WEST
		} else if((constraint.x == -this.borderItemOffset) && (constraint.y == -this.borderItemOffset)) {
			position = PositionConstants.NORTH_WEST;

			//we are on the EAST and on the SOUTH
		} else if((constraint.x == parentFigure.getBounds().width - borderItemOffset) && (constraint.y == parentFigure.getBounds().height - borderItemOffset)) {
			position = PositionConstants.SOUTH_EAST;

			//we are on the WEST and on the SOUTH
		} else if((constraint.x == -this.borderItemOffset) && (constraint.y == parentFigure.getBounds().height - borderItemOffset)) {
			position = PositionConstants.SOUTH_WEST;
		}

		return position;
	}

	/**
	 * get the parent figure
	 * 
	 * @return the parent figure
	 */
	public IFigure getParentFigure() {
		return parentFigure;
	}

	/**
	 * 
	 * @param proposedLocation
	 *        the proposed location
	 * @return a possible location on parent figure border
	 */
	public Rectangle getPreferredLocation(Rectangle proposedLocation) {

		// Initialize port location with proposed location
		// and resolve the bounds of it graphical parent
		Rectangle realLocation = new Rectangle(proposedLocation);

		Rectangle parentRec = getParentFigure().getBounds().getCopy();

		// Calculate Max position around the graphical parent (1/2 size or the port around
		// the graphical parent bounds.
		int xMin = parentRec.x - borderItemOffset;
		int xMax = parentRec.x - borderItemOffset + parentRec.width;
		int yMin = parentRec.y - borderItemOffset;
		int yMax = parentRec.y - borderItemOffset + parentRec.height;

		// Modify Port location if MAX X or Y are exceeded
		if(realLocation.x < xMin) {
			realLocation.x = xMin;
		}

		if(realLocation.x > xMax) {
			realLocation.x = xMax;
		}

		if(realLocation.y < yMin) {
			realLocation.y = yMin;
		}

		if(realLocation.y > yMax) {
			realLocation.y = yMax;
		}

		// Ensure the port is positioned on its parent borders and not in the middle.
		// Modify position if needed.
		if((realLocation.y != yMin) && (realLocation.y != yMax)) {
			if((realLocation.x != xMin) && (realLocation.x != xMax)) {

				if(realLocation.x <= (xMin + (parentRec.width / 2))) {
					realLocation.x = xMin;
				} else {
					realLocation.x = xMax;
				}
			}
		}

		// Return constrained location
		return realLocation;
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#getValidLocation(org.eclipse.draw2d.geometry.Rectangle,
	 *      org.eclipse.draw2d.IFigure)
	 * 
	 * @param proposedLocation
	 * @param borderItem
	 * @return a valid location
	 */
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		return getPreferredLocation(proposedLocation);
	}

	/**
	 * 
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 * 
	 * @param target
	 */
	public void relocate(IFigure target) {

		Rectangle proposedLocation = constraint.getCopy();
		proposedLocation.setLocation(constraint.getLocation().translate(parentFigure.getBounds().getTopLeft()));

		Point validLocation = getValidLocation(proposedLocation, target).getLocation();

		target.setBounds(new Rectangle(validLocation, target.getPreferredSize()));
	}

	/**
	 * 
	 * @see org.eclipse.gmf.runtime.draw2d.ui.figures.IBorderItemLocator#setConstraint(org.eclipse.draw2d.geometry.Rectangle)
	 * 
	 * @param constraint
	 */
	public void setConstraint(Rectangle constraint) {
		this.constraint = constraint;

	}
}
