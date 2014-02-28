/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Vincent Lorenzo - CEA LIST
 *
 *****************************************************************************/
package org.eclipse.papyrus.infra.gmfdiag.common.snap;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.SnapToHelper;

/**
 * 
 * Snap Helper with default behavior for BorderNode (snap only on the center of the figrue
 * TODO PapyrusDragBorderNodeEditPartTrackerEx should use me
 */
public class BorderNodeSnapHelper extends NodeSnapHelper {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param helper
	 * @param figureToSnapBounds
	 */
	public BorderNodeSnapHelper(SnapToHelper helper, Rectangle figureToSnapBounds) {
		super(helper, figureToSnapBounds, false, false, true);
	}

}
