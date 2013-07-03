/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Boutheina Bannour (CEA LIST) boutheina.bannour@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure;

/**
 * Create an {@link CustomContextLinkFigure} with the tag <code>&laquo context &raquo</code>
 * 
 */
public class CustomContextLinkFigure extends DashedEdgeFigure {

	/* label of context link does not contain information for the moment */
	private WrappingLabel conveyedLabel;

	public WrappingLabel getConveyedLabel() {
		return conveyedLabel;
	}

	@Override
	protected void createContents() {
		super.createContents();
		conveyedLabel = new WrappingLabel();
		conveyedLabel.setOpaque(false);
		conveyedLabel.setForegroundColor(getNameLabel().getForegroundColor());
		conveyedLabel.setFont(getNameLabel().getFont());
		add(conveyedLabel, 0);
	}

	protected void setStyle() {
		PolylineDecoration dec = new PolylineDecoration();
		dec.setScale(15, 5);
		dec.setLineWidth(1);

		this.setTargetDecoration(null);
		this.setLineStyle(Graphics.LINE_DASHDOT); // line drawing style
	}

}
