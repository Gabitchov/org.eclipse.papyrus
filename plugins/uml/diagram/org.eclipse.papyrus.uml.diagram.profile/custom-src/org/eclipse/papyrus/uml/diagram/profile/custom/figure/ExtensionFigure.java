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

package org.eclipse.papyrus.uml.diagram.profile.custom.figure;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;

/**
 * ExtensionFigure
 **/
public class ExtensionFigure extends UMLEdgeFigure {

	/**
	 * 
	 * Constructor.
	 * 
	 */
	public ExtensionFigure() {
		super();
		PolygonDecoration dec = new PolygonDecoration();
		dec.setScale(15, 5);
		dec.setBackgroundColor(ColorConstants.black);
		dec.setLineWidth(1);
		setTargetDecoration(dec); // arrow at target endpoint
		setLineStyle(Graphics.LINE_SOLID); // line drawing style
		setLineWidth(2);
		setForegroundColor(ColorConstants.black);

	}

	@Override
	public void resetStyle() {
		super.resetStyle();
		PolygonDecoration dec = new PolygonDecoration();
		dec.setScale(15, 5);
		dec.setBackgroundColor(ColorConstants.black);
		dec.setLineWidth(1);
		setTargetDecoration(dec); // arrow at target endpoint
	}
}
