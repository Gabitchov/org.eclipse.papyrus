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
package org.eclipse.papyrus.diagram.common.draw2d.decoration;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.diagram.common.draw2d.RequiredInterfaceDecoration;

public class DotDecoration extends RequiredInterfaceDecoration implements ComposableRotatableDecoration {

	public Point getBoundPoint() {
		Rectangle bounds = getBounds();
		return new Point(bounds.x + bounds.width / 2, bounds.y + bounds.height / 2);
	}

	@Override
	public void setRadius(int radius) {
		super.setRadius(radius);
		setTemplate(new PointList(new int[] { radius, 0 }));
	}

	@Override
	protected void outlineShape(Graphics g) {
		g.drawOval(getBounds());
	}

	@Override
	protected void fillShape(Graphics g) {
		g.fillOval(getBounds());
	}
}
