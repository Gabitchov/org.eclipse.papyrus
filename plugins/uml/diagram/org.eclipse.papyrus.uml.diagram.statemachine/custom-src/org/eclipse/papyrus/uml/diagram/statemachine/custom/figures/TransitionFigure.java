/*****************************************************************************
 * Copyright (c) 2014 CEA.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.statemachine.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure;

public class TransitionFigure extends DashedEdgeFigure {

	/**
	 * use to if the arrow will be displayed
	 */
	protected boolean arrow = true;

	/**
	 * Creates a new UMLEdgeFigure.
	 */
	public TransitionFigure() {
		super();
		setupDefaultStyle();
	}

	/**
	 * @see org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure#resetStyle()
	 */
	@Override
	public void resetStyle() {
		PolylineDecoration dec = new PolylineDecoration();
		dec.setScale(15, 5);
		dec.setLineWidth(1);
		if(arrow) {
			this.setTargetDecoration(dec);
		} else {
			this.setTargetDecoration(null);
		}// arrow at target endpoint
		this.setLineStyle(Graphics.LINE_CUSTOM); // line drawing style
	}
}
