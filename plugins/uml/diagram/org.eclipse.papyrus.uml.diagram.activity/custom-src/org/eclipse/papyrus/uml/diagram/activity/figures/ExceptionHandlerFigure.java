/*****************************************************************************
 * Copyright (c) 2011 Atos.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos - Initial API and implementation
 *   Bug 366159 - [ActivityDiagram] Activity Diagram should be able to handle correctly Interruptible Edge
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.figures;

import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.util.MeasurementUnitHelper;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.swt.graphics.LineAttributes;

/**
 * Figure for {@link ExceptionHandler}
 * 
 * @author arthur daussy
 * 
 */
public class ExceptionHandlerFigure extends PolylineConnectionEx {

	/**
	 * Since the Activity diagram is using Pixel unit we can use this as constant
	 */
	private static IMapMode mapNode = MeasurementUnitHelper.getMapMode(MeasurementUnit.PIXEL_LITERAL);

	/**
	 * @generated
	 */
	public ExceptionHandlerFigure() {
		setTargetDecoration(createTargetDecoration());
		setLineAttributes(new LineAttributes(2));
	}

	/**
	 * @generated
	 */
	private RotatableDecoration createTargetDecoration() {
		PolylineDecoration df = new PolylineDecoration();
		PointList pl = new PointList();
		pl.addPoint(mapNode.DPtoLP(-2), mapNode.DPtoLP(2));
		pl.addPoint(mapNode.DPtoLP(0), mapNode.DPtoLP(0));
		pl.addPoint(mapNode.DPtoLP(-2), mapNode.DPtoLP(-2));
		df.setTemplate(pl);
		df.setScale(mapNode.DPtoLP(7), mapNode.DPtoLP(3));
		df.setLineAttributes(new LineAttributes(2));
		return df;
	}
}
