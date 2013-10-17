/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Tatiana Fesenko (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PackageNodePlateFigure;

/**
 * The Class ContainmentCircleOnPackageLocator.
 */
public class ContainmentCircleOnPackageLocator extends BorderItemLocator {

	/** The Constant DEFAULT_BORDER_ITEM_OFFSET. */
	private static final Dimension DEFAULT_BORDER_ITEM_OFFSET = new Dimension(1, 1);

	/** The Constant DEFAULT_SIZE. */
	private static final Dimension DEFAULT_SIZE = new Dimension(20, 20);

	private Dimension originalBorderItemOffset = DEFAULT_BORDER_ITEM_OFFSET;

	/**
	 * Instantiates a new containment circle on package locator.
	 * 
	 * @param parentFigure
	 *        the parent figure
	 */
	public ContainmentCircleOnPackageLocator(IFigure parentFigure) {
		super(parentFigure);
	}

	/**
	 * Instantiates a new containment circle on package locator.
	 * 
	 * @param borderItem
	 *        the border item
	 * @param parentFigure
	 *        the parent figure
	 * @param constraint
	 *        the constraint
	 */
	public ContainmentCircleOnPackageLocator(IFigure borderItem, IFigure parentFigure, Rectangle constraint) {
		super(borderItem, parentFigure, constraint);
	}

	/**
	 * Instantiates a new containment circle on package locator.
	 * 
	 * @param parentFigure
	 *        the parent figure
	 * @param preferredSide
	 *        the preferred side
	 */
	public ContainmentCircleOnPackageLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
		setConstraint(new Rectangle(new Point(0, 0), DEFAULT_SIZE));
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator#setConstraint(org.eclipse.draw2d.geometry.Rectangle)
	 * 
	 * @param theConstraint
	 */
	@Override
	public void setConstraint(Rectangle theConstraint) {
		super.setConstraint(new Rectangle(theConstraint.getTopLeft(), DEFAULT_SIZE));
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator#locateOnParent(org.eclipse.draw2d.geometry.Point, int,
	 *      org.eclipse.draw2d.IFigure)
	 * 
	 * @param suggestedLocation
	 * @param suggestedSide
	 * @param borderItem
	 * @return
	 */
	@Override
	protected Point locateOnParent(Point suggestedLocation, int suggestedSide, IFigure borderItem) {
		PackageNodePlateFigure parent = (PackageNodePlateFigure)getParentFigure();
		Rectangle headerBounds = parent.getPackageFigure().getHeader();
		if(suggestedSide == PositionConstants.NORTH && !isOnHeader(suggestedLocation, headerBounds)) {
			setBorderItemOffset(new Dimension(originalBorderItemOffset.width, headerBounds.height));
		} else {
			setBorderItemOffset(originalBorderItemOffset);
		}
		Point result = super.locateOnParent(suggestedLocation, suggestedSide, borderItem);
		setBorderItemOffset(originalBorderItemOffset);
		return result;
	}

	/**
	 * Checks if is on header.
	 * 
	 * @param p
	 *        the p
	 * @param headerBounds
	 *        the header bounds
	 * @return true, if is on header
	 */
	private boolean isOnHeader(Point p, Rectangle headerBounds) {
		return p.x < headerBounds.getTopRight().x;
	}
}
