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
import org.eclipse.swt.graphics.Color;

public class ManuallyDrawnShortcutDecorationFigure extends RectangleFigure {

	private RectangleFigure border = null;

	public ManuallyDrawnShortcutDecorationFigure() {
		setOpaque(true);
		setOutline(false);

		setSize(10, 10);
		setPreferredSize(10, 10);

		border = new RectangleFigure();
		border.setForegroundColor(ColorConstants.black);
		border.setBackgroundColor(ColorConstants.white);
		border.setSize(10, 10);
		border.setLocation(new Point(0, 0));
		this.add(border);

		Polygon arrow = new Polygon();
		arrow.setLocation(new Point(0, 0));
		arrow.setForegroundColor(ColorConstants.black);
		arrow.setBackgroundColor(ColorConstants.black);
		arrow.setFill(true);

		arrow.addPoint(new Point(7, 2));
		arrow.addPoint(new Point(7, 5));
		arrow.addPoint(new Point(7, 4));
		arrow.addPoint(new Point(5, 4));
		arrow.addPoint(new Point(5, 5));
		arrow.addPoint(new Point(3, 7));
		arrow.addPoint(new Point(4, 8));
		arrow.addPoint(new Point(3, 7));
		arrow.addPoint(new Point(3, 5));
		arrow.addPoint(new Point(5, 3));
		arrow.addPoint(new Point(5, 3));
		arrow.addPoint(new Point(4, 2));
		arrow.addPoint(new Point(7, 2));

		this.add(arrow);
	}
	
	public void setBackgroundColor(Color backgroundColor) {
		border.setBackgroundColor(backgroundColor);
	}

	@Override
	protected boolean useLocalCoordinates() {
		return true;
	}

}
