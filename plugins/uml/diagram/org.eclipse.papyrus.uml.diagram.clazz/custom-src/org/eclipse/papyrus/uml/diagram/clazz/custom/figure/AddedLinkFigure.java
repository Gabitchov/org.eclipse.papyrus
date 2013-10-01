/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;

/**
 * The Class AddedLinkFigure.
 */
public class AddedLinkFigure extends UMLEdgeFigure {

	/**
	 * Instantiates a new added link figure.
	 */
	public AddedLinkFigure() {
		this.setLineStyle(Graphics.LINE_SOLID);
		this.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
	}
}
