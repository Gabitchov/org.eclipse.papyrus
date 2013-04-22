/*****************************************************************************
 * Copyright (c) 2010 CEA
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.internal.figures.BorderItemContainerFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.papyrus.uml.diagram.sequence.figures.DestructionEventFigure;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineDotLineCustomFigure;
import org.eclipse.papyrus.uml.diagram.sequence.figures.LifelineFigure;

public class CenterLocator extends BorderItemLocator {

	/**
	 * The LifelineDotLineFigure. It must be access through the method {@link #getLifelineDotLineFigure()}
	 */
	private LifelineDotLineCustomFigure lifelineDotLineFigure = null;

	/**
	 * The BorderItemContainerFigure. It must be access through the method {@link #getBorderItemContainerFigure()}
	 */
	private BorderItemContainerFigure borderItemContainerFigure = null;

	/**
	 * The DestructionEventFigure.
	 * 
	 * It must be access through the method {@link #getDestructionEventFigure()}
	 */
	private DestructionEventFigure destructionEventFigure = null;

	/**
	 * Constructor
	 * 
	 * @param parentFigure
	 *        the parent figure
	 * @param location
	 *        ContinuationLocator.TOP or ContinuationLocator.BOTTOM
	 */
	public CenterLocator(IFigure parentFigure, int location) {
		super(parentFigure, location);
	}

	/**
	 * Get the LifelineDotLineFigure
	 * 
	 * @return the lifelineDotLineFigure or null
	 */
	private LifelineDotLineCustomFigure getLifelineDotLineFigure() {
		if(lifelineDotLineFigure == null) {
			for(Object childFig : getParentFigure().getChildren()) {
				if(childFig instanceof LifelineFigure) {
					lifelineDotLineFigure = ((LifelineFigure)childFig).getFigureLifelineDotLineFigure();
					return lifelineDotLineFigure;
				}
			}
		}
		return lifelineDotLineFigure;
	}

	/**
	 * Get the BorderItemContainerFigure
	 * 
	 * @return the borderItemContainerFigure or null
	 */
	private BorderItemContainerFigure getBorderItemContainerFigure() {
		if(borderItemContainerFigure == null) {
			IFigure figure = getParentFigure().getParent();
			for(Object object : figure.getChildren()) {
				if(object instanceof BorderItemContainerFigure) {
					borderItemContainerFigure = (BorderItemContainerFigure)object;
					return borderItemContainerFigure;
				}
			}
		}
		return borderItemContainerFigure;
	}

	/**
	 * Get the DestructionEventFigure of the lifeline, if it is drawn.
	 * 
	 * @return the DestructionEventFigure or null
	 */
	private DestructionEventFigure getDestructionEventFigure() {
		if(destructionEventFigure == null) {
			BorderItemContainerFigure borderItemContainerFigure = getBorderItemContainerFigure();
			if(borderItemContainerFigure != null) {
				for(Object child : borderItemContainerFigure.getChildren()) {
					if(child instanceof DefaultSizeNodeFigure) {
						for(Object figure : ((DefaultSizeNodeFigure)child).getChildren()) {
							if(figure instanceof DestructionEventFigure) {
								destructionEventFigure = (DestructionEventFigure)figure;
								return destructionEventFigure;
							}
						}
					}
				}
			}
		}
		return destructionEventFigure;
	}

	/**
	 * Overrides :
	 * - the destructionEventFigure is always drawn at the end of the figure
	 * 
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 */
	@Override
	public void relocate(IFigure borderItem) {
		if(getDestructionEventFigure() != null) {
			if(borderItem.equals(getDestructionEventFigure().getParent())) {
				borderItem.setLocation(new Point(getHorizontalPosition(borderItem), getParentBorder().y + getParentBorder().height - borderItem.getBounds().height / 2));
				return;
			}
		}
		super.relocate(borderItem);
	}

	@Override
	public Rectangle getValidLocation(Rectangle proposedLocation, IFigure borderItem) {
		if(getDestructionEventFigure() != null) {
			if(borderItem.equals(getDestructionEventFigure().getParent())) {
				Rectangle realLocation = new Rectangle(proposedLocation);
				Point point = new Point(getParentBorder().getCenter().x - realLocation.getSize().width / 2, getParentBorder().y + getParentBorder().height - realLocation.height / 2);
				realLocation.setLocation(point);
				return realLocation;
			}
		}
		return super.getValidLocation(proposedLocation, borderItem);
	}

	/**
	 * Get the parent dotLine border
	 * 
	 * @return <code>Rectangle</code> that is the bounds of the parent dot line.
	 */
	protected Rectangle getParentDotLineBorder() {
		LifelineDotLineCustomFigure dotline = getLifelineDotLineFigure();
		if(dotline != null) {
			return dotline.getBounds().getCopy();
		}
		return super.getParentBorder();
	}

	/**
	 * Locate the figure on its parent
	 * 
	 * @param suggestedLocation
	 * @param suggestedSide
	 * @return point
	 */
	@Override
	protected Point locateOnParent(Point suggestedLocation, int suggestedSide, IFigure borderItem) {
		Dimension borderItemSize = getSize(borderItem);
		int y = getVerticalPosition(suggestedLocation.y, borderItemSize.height);
		int x = getHorizontalPosition(borderItem);
		return new Point(x, y);
	}

	/**
	 * Get the vertical position of the itemBorder
	 * 
	 * @param y
	 *        the suggested location
	 * @param height
	 *        the border item height
	 * @return the vertical position of the item border on the lifeline
	 */
	private int getVerticalPosition(int y, int height) {
		int validY = y;
		Rectangle parentDotLineBorder = getParentDotLineBorder();
		int maxY = parentDotLineBorder.y + parentDotLineBorder.height - getSouthInsets();
		if(y + height > maxY) {
			validY = maxY - height;
		} else if(y < parentDotLineBorder.y) {
			validY = parentDotLineBorder.y;
		}
		return validY;
	}

	/**
	 * Get the horizontal position of the borderItem drawn on a lifeline.
	 * Those elements are drawn at the center of the lifeline, ie on the dot line.
	 * 
	 * @param borderItem
	 *        the borderItem
	 * @return the horizontal position of the border item
	 */
	private int getHorizontalPosition(IFigure borderItem) {
		return getParentBorder().getCenter().x - borderItem.getSize().width / 2;
	}

	/**
	 * Get the insets to use at the bottom of the figure.
	 * It is used to prevent others borderItems to be drawn on or below the destructionEventFigure
	 * 
	 * @return If a destructionEventFigure is drawn, it returns the height of its figure, otherwise it returns 0
	 */
	private int getSouthInsets() {
		DestructionEventFigure destructionEventFigure = getDestructionEventFigure();
		if(destructionEventFigure != null) {
			return destructionEventFigure.getBounds().height;
		}
		return 0;
	}
}
