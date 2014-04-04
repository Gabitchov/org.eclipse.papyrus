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
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * this figure is fill circle
 */
public class DependencyNodeFigure extends PapyrusNodeFigure {

	/**
	 * {@inheritDoc}
	 */
	public void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		graphics.setBackgroundColor(getForegroundColor());
		graphics.fillOval(r);
	}

}
