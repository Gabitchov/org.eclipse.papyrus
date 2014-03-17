/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
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
package org.eclipse.papyrus.uml.diagram.common.figure.edge;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;

/**
 * Code of the CInterfaceRealizationFigure
 **/
public class InterfaceRealizationFigure extends DashedEdgeFigure {

	public InterfaceRealizationFigure() {
		PolygonDecoration dec = new PolygonDecoration();
		dec.setScale(15, 5);
		dec.setBackgroundColor(ColorConstants.white);
		dec.setLineWidth(1);
		setTargetDecoration(dec); // arrow at target endpoint

		setForegroundColor(ColorConstants.black);

		this.setLineStyle(Graphics.LINE_CUSTOM); // line drawing style

	}

	@Override
	public void resetStyle() {
		super.resetStyle();
		PolygonDecoration dec = new PolygonDecoration();
		dec.setScale(15, 5);
		dec.setBackgroundColor(ColorConstants.white);
		dec.setLineWidth(1);
		setTargetDecoration(dec); // arrow at target endpoint
	}
}
