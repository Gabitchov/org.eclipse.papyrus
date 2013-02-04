/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;

/** A rectangle that is not painted: useful for simplifying layouts */
public class InvisibleRectangleFigure extends RectangleFigure {

	/**
	 * Creates a RectangleFigure.
	 */
	public InvisibleRectangleFigure() {
	}

	/**
	 * @see Shape#fillShape(Graphics)
	 */
	@Override
	protected void fillShape(final Graphics graphics) {
		// don't fill
	}

	/**
	 * @see Shape#outlineShape(Graphics)
	 */
	@Override
	protected void outlineShape(final Graphics graphics) {
		// don't draw an outline
	}
}
