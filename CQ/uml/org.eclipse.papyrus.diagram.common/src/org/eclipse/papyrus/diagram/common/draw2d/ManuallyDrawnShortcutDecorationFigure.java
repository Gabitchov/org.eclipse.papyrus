/*******************************************************************************
 * Copyright (c) 2008 Conselleria de Infraestructuras y Transporte,
 * Generalitat de la Comunitat Valenciana .
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Francisco Javier Cano MuÃ±oz (Prodevelop) - initial API implementation
 *
 ******************************************************************************/
package org.eclipse.papyrus.diagram.common.draw2d;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Polygon;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;

public class ManuallyDrawnShortcutDecorationFigure extends RectangleFigure {

	public ManuallyDrawnShortcutDecorationFigure() {
		setOpaque(true);
		setOutline(false);

		setSize(16, 16);
		setPreferredSize(16, 16);

		RectangleFigure border = new RectangleFigure();
		border.setForegroundColor(ColorConstants.black);
		border.setBackgroundColor(ColorConstants.white);
		border.setSize(10, 10);
		border.setLocation(new Point(2, 2));
		this.add(border);

		Polygon arrow = new Polygon();
		arrow.setLocation(new Point(0, 0));
		arrow.setForegroundColor(ColorConstants.black);
		arrow.setBackgroundColor(ColorConstants.black);
		arrow.setFill(true);

		arrow.addPoint(new Point(9, 4));
		arrow.addPoint(new Point(9, 7));
		arrow.addPoint(new Point(9, 6));
		arrow.addPoint(new Point(7, 6));
		arrow.addPoint(new Point(7, 7));
		arrow.addPoint(new Point(5, 9));
		arrow.addPoint(new Point(6, 10));
		arrow.addPoint(new Point(5, 9));
		arrow.addPoint(new Point(5, 7));
		arrow.addPoint(new Point(7, 5));
		arrow.addPoint(new Point(7, 5));
		arrow.addPoint(new Point(6, 4));
		arrow.addPoint(new Point(9, 4));

		this.add(arrow);
	}

	@Override
	protected boolean useLocalCoordinates() {
		return true;
	}

}
