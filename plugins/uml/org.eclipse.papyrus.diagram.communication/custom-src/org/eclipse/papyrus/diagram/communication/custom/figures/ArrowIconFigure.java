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
 *  Saadia DHOUIB (CEA LIST) saadia.dhouib@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.communication.custom.figures;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

/**
 * This class is used to create an Arrow IconFigure the implements
 * a RotatableDecoration
 * 
 */
public class ArrowIconFigure extends Figure implements RotatableDecoration {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ArrowIconFigure() {
		setPreferredSize(new Dimension(5, 5));
	}

	@Override
	public void setLocation(Point p) {

	}

	public void setReferencePoint(Point p) {
	}

}
