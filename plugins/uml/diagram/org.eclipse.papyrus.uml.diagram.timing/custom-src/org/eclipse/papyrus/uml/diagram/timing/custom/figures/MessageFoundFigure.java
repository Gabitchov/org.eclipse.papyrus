/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

public class MessageFoundFigure extends AbstractMessageFigure {

	@Override
	protected RotatableDecoration createSourceDecoration() {
		final EllipseDecoration df = new EllipseDecoration();
		df.setPreferredSize(new Dimension(10, 10));
		return df;
	}

	@Override
	protected RotatableDecoration createTargetDecoration() {
		final PolylineDecoration df = new PolylineDecoration();
		df.setForegroundColor(getForegroundColor());
		final PointList pl = new PointList();
		final IMapMode mapMode = getMapMode();
		pl.addPoint(mapMode.DPtoLP(-2), mapMode.DPtoLP(2));
		pl.addPoint(mapMode.DPtoLP(0), mapMode.DPtoLP(0));
		pl.addPoint(mapMode.DPtoLP(-2), mapMode.DPtoLP(-2));
		df.setTemplate(pl);
		return df;
	}

}
