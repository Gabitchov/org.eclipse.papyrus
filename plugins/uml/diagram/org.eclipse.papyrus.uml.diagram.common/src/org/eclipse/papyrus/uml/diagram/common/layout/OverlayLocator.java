/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http.equals(this.position)){//www.eclipse.org/legal/epl-v10.html
 *
 * Contributors.equals(this.position)){
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.layout;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Locator;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget;
import org.eclipse.gmf.runtime.diagram.ui.services.decorator.IDecoratorTarget.Direction;

/**
 * 
 * A locator to add an overlay to an IFigure. The Overlay can be located
 * following theses value :
 * <ul>
 * <li> {@link Direction#NORTH}</li>
 * <li> {@link Direction#NORTH_EAST}</li>
 * <li> {@link Direction#NORTH_WEST}</li>
 * <li> {@link Direction#EAST}</li>
 * <li> {@link Direction#WEST}</li>
 * <li> {@link Direction#SOUTH}</li>
 * <li> {@link Direction#SOUTH_EAST}</li>
 * <li> {@link Direction#SOUTH_WEST}</li>
 * <li> {@link Direction#CENTER}</li>
 * </ul>
 * 
 */

public class OverlayLocator implements Locator {

	/** the reference figure */
	private IFigure reference;

	/** the Overlay Position */
	private Direction position = null;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param reference
	 *        the reference figure
	 * @param position
	 *        the overlay position
	 */
	public OverlayLocator(IFigure reference, IDecoratorTarget.Direction position) {
		assert reference != null;
		this.reference = reference;
		this.position = position;
	}

	/**
	 * 
	 * @see org.eclipse.draw2d.Locator#relocate(org.eclipse.draw2d.IFigure)
	 * 
	 * @param target
	 *        the overlay figure to locate
	 */
	public void relocate(IFigure target) {
		Rectangle bounds = reference instanceof HandleBounds ? new PrecisionRectangle(((HandleBounds)reference).getHandleBounds()) : new PrecisionRectangle(reference.getBounds());

		reference.translateToAbsolute(bounds);
		target.translateToRelative(bounds);

		int width = target.getBounds().width;
		int halfWidth = width / 2;

		int height = target.getBounds().height;
		int halfHeight = height / 2;

		if(Direction.NORTH_WEST.equals(this.position)) {
			target.setLocation(bounds.getTopLeft().getTranslated(-halfWidth, -halfHeight));
		} else if(Direction.NORTH.equals(this.position)) {
			target.setLocation(bounds.getTop().getTranslated(-halfWidth, -halfHeight));
		} else if(Direction.NORTH_EAST.equals(this.position)) {
			target.setLocation(bounds.getTopRight().getTranslated(-halfWidth, -halfHeight));
		} else if(Direction.SOUTH_WEST.equals(this.position)) {
			target.setLocation(bounds.getBottomLeft().getTranslated(-halfWidth, -halfHeight));
		} else if(Direction.SOUTH.equals(this.position)) {
			target.setLocation(bounds.getBottom().getTranslated(-halfWidth, -halfHeight));
		} else if(Direction.SOUTH_EAST.equals(this.position)) {
			target.setLocation(bounds.getBottomRight().getTranslated(-halfWidth, -halfHeight));
		} else if(Direction.WEST.equals(this.position)) {
			target.setLocation(bounds.getLeft().getTranslated(-halfWidth, -halfHeight));
		} else if(Direction.EAST.equals(this.position)) {
			target.setLocation(bounds.getRight().getTranslated(-halfWidth, -halfHeight));
		} else if(Direction.CENTER.equals(this.position)) {
			target.setLocation(bounds.getCenter().getTranslated(-halfWidth, -halfHeight));
		}
	}
}
