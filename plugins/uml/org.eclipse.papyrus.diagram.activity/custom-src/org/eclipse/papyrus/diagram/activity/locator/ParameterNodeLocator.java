/*****************************************************************************
 * Copyright (c) 2009-2010 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Yann Tanguy (CEA LIST) yann.tanguy@cea.fr - Initial API and implementation
 *  Vincent Lorenzo(CEA-List) vincent.lorenzo@cea.fr - getCurrentSideOfParent()
 *****************************************************************************/
package org.eclipse.papyrus.diagram.activity.locator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.IBorderItemLocator;
import org.eclipse.papyrus.diagram.common.locator.PortPositionLocator;

/**
* locator for parameter nodes
 */
public class ParameterNodeLocator extends PortPositionLocator {


	/** Constructor **/
	public ParameterNodeLocator(IFigure parentFigure, int preferredSide) {
		super(parentFigure, preferredSide);
		setBorderItemOffset(20);
	}

}
