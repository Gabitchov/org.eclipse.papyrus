/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;

public class MessageSyncFigure extends AbstractMessageFigure {

	@Override
	protected RotatableDecoration createTargetDecoration() {
		final PolygonDecoration df = new PolygonDecoration() {
			@Override
			protected void outlineShape(final Graphics g) {
				// no outline: this is a filled arrow
			}
		};
		df.setFill(true);
		df.setForegroundColor(getForegroundColor());
		df.setBackgroundColor(getForegroundColor());
		final PointList pl = new PointList();
		final IMapMode mapMode = getMapMode();
		pl.addPoint(mapMode.DPtoLP(-2), mapMode.DPtoLP(2));
		pl.addPoint(mapMode.DPtoLP(0), mapMode.DPtoLP(0));
		pl.addPoint(mapMode.DPtoLP(-2), mapMode.DPtoLP(-2));
		pl.addPoint(mapMode.DPtoLP(-2), mapMode.DPtoLP(2));
		df.setTemplate(pl);
		return df;
	}
}
