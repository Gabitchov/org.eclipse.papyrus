/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Rectangle;

public class TimeRulerFigure extends InvisibleRectangleFigure {

	@Override
	protected void outlineShape(final Graphics graphics) {
		final Rectangle bounds = getBounds();
		graphics.setForegroundColor(ColorConstants.gray);
		graphics.drawLine(bounds.getTopLeft(), bounds.getTopRight());
	}
}
