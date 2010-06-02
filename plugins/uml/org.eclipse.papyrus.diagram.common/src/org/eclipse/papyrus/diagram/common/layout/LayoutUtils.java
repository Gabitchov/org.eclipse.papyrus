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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.layout;

import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;

/**
 * This class provides utilities for the layout actions
 * 
 * 
 */
public class LayoutUtils {

	/**
	 * the shift to avoid the scrollbar
	 * If there is no scrollBar, set scrollBarSize to 0.0!
	 */
	public static final double scrollBarSize = 6;

	/**
	 * 
	 * A {@link Rectangle} with the absolute position from the {@link EditPart}
	 * 
	 * @param ep
	 *        the {@link EditPart} that we want the position
	 * @return
	 *         a {@link Rectangle} with the absolute position from the {@link EditPart}
	 * 
	 */
	public static PrecisionRectangle getAbsolutePosition(EditPart ep) {
		GraphicalEditPart part = (GraphicalEditPart)ep;
		PrecisionRectangle rect = new PrecisionRectangle(part.getFigure().getBounds());
		part.getFigure().translateToAbsolute(rect);
		return rect;
	}


}
