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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.swt.graphics.Color;

/**
 * This is a custom figure to represents a default edge. This code was used in
 * Papyrus 1. This edge figure is painted using dashes. This is the base figure
 * for dependencies, for example
 */
public class DashedEdgeFigure extends UMLEdgeFigure {

	/**
	 * Dashes used to paint line.
	 */
	private final int[] dashes = new int[10];

	/**
	 * use to if the arrow will be displayed
	 */
	protected boolean arrow = true;

	private WrappingLabel nameLabel;

	/**
	 * Creates a new DashEdgeFigure.
	 */
	public DashedEdgeFigure() {
		super();
		setStyle();
	}

	/**
	 * @generated
	 */
	public WrappingLabel getNameLabel() {
		return nameLabel;
	}

	/**
	 * This is the constructor
	 * 
	 * @param arrow
	 *        true if the arrow of the edge is displayed
	 */
	public DashedEdgeFigure(Boolean arrow) {
		super();
		this.arrow = arrow;
		setStyle();
		createContents();
	}

	/**
	 * use to display the arrow of the edge
	 * 
	 * @param arrow
	 *        true if the arrow will be displayed
	 */
	public void setArrow(Boolean arrow) {
		this.arrow = arrow;
		setStyle();
	}

	/**
	 * @generated
	 */
	@Override
	protected void createContents() {
		super.createContents();
		nameLabel = new WrappingLabel();
		nameLabel.setText("");

		this.add(nameLabel);

	}

	/**
	 * Sets initial Style for the figure. It does not give any special Color for
	 * Background and Foreground. This is the style used for classic arrows:
	 * ------>
	 */
	protected void setStyle() {
		PolylineDecoration dec = new PolylineDecoration();
		dec.setScale(15, 5);
		dec.setLineWidth(1);
		if(arrow) {
			this.setTargetDecoration(dec);
		} else {
			this.setTargetDecoration(null);
		}// arrow at target endpoint
		this.setLineStyle(Graphics.LINE_CUSTOM); // line drawing style

		// set dashes
		for(int i = 0; i < 10; i++) {
			dashes[i] = 5;
		}
		setLineDash(dashes);

	}

	/**
	 * Sets initial style for this figure. This is the style used for full
	 * arrows: ------|>
	 * 
	 * @param lineWidth
	 *        the width of the link
	 */
	// @unused
	protected void setStyle(int lineWidth) {
		setStyle();
		// set link appearence
		setLineWidth(lineWidth);
	}

	/**
	 * Sets initial style for this figure. This is the style used for full
	 * arrows: ------|>
	 * 
	 * @param lineWidth
	 *        the width of the link
	 * @param foregroundColor
	 *        the foreground color of the link
	 * @param backgroundColor
	 *        the background color of the link
	 */
	// @unused
	protected void setStyle(Color backgroundColor, Color foregroundColor, int lineWidth) {
		// set the target arrow style
		PolygonDecoration dec = new PolygonDecoration();
		dec.setScale(15, 5);
		dec.setBackgroundColor(backgroundColor);
		dec.setLineWidth(1);
		if(arrow) {
			setTargetDecoration(dec);
		}
		// set link appearence
		setLineWidth(lineWidth);
		setLineStyle(Graphics.LINE_CUSTOM); // line drawing style
		setForegroundColor(foregroundColor);

		// set dashes
		for(int i = 0; i < 10; i++) {
			dashes[i] = 5;
		}
		setLineDash(dashes);
	}

}
