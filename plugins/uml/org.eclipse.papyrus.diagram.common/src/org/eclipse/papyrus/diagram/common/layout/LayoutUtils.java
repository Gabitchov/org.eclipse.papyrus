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
import org.eclipse.gef.RootEditPart;

/**
 * This class provides utilities for the layout actions
 * 
 * 
 */
public class LayoutUtils {

	/** This rectangle is used to precise when the container is the diagram */
	public static final PrecisionRectangle diagramRect = new PrecisionRectangle(new Rectangle(0, 0, -1, -1));

	/**
	 * 
	 * A {@link Rectangle} with the absolute position from the {@link EditPart}
	 * 
	 * @param ep
	 *        the {@link EditPart} that we want the position
	 * @return
	 *         a {@link Rectangle} with the absolute position from the {@link EditPart}
	 *         <ul>
	 *         <li>
	 *         <li> {@link #diagramRect}</li> if the parent {@link EditPart} is the {@link RootEditPart};
	 */
	public static PrecisionRectangle getAbsolutePosition(EditPart ep) {
		GraphicalEditPart part = (GraphicalEditPart)ep;
		PrecisionRectangle rect = new PrecisionRectangle(part.getFigure().getBounds());
		part.getFigure().translateToAbsolute(rect);
		if(ep.getParent() instanceof RootEditPart) {
			rect = diagramRect;
		}
		return rect;
	}


}
