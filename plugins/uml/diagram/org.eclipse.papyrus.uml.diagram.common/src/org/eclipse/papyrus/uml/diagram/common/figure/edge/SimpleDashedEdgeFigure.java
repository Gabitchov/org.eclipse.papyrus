/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.edge;

import org.eclipse.draw2d.Graphics;

/**
 * This is a custom figure to represents a default edge. This edge figure is painted using dots.
 */
public class SimpleDashedEdgeFigure extends UMLEdgeFigure {

	/**
	 * Creates a new DashEdgeFigure.
	 */
	public SimpleDashedEdgeFigure() {
		super();
		setupDefaultStyle();
		createContents();
	}

	/**
	 * @generated
	 */
	@Override
	protected void createContents() {
		super.createContents();
	}

	/**
	 * Resets the style of this figure to its default implementation
	 */
	@Override
	public void resetStyle() {
		setupDefaultStyle();
	}

	protected void setupDefaultStyle() {

		this.setTargetDecoration(null);
		this.setSourceDecoration(null);

		this.setLineStyle(Graphics.LINE_DASH);
	}
}
