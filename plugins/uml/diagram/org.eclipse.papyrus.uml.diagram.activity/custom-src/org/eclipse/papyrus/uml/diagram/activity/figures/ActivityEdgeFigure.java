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
 *   Arthur Daussy
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.activity.figures;

import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.util.MeasurementUnitHelper;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.gmf.runtime.notation.MeasurementUnit;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.UMLEdgeFigure;

/**
 * Basic figure for Activity Edge figure
 * 
 * @author arthur daussy
 * 
 */
public class ActivityEdgeFigure extends UMLEdgeFigure {

	/**
	 * @generated
	 */
	private WrappedLabel fEdgeName;

	/**
	 * Since the Activity diagram is using Pixel unit we can use this as constant
	 */
	private static IMapMode mapNode = MeasurementUnitHelper.getMapMode(MeasurementUnit.PIXEL_LITERAL);

	/**
	 * @generated
	 */
	private WrappedLabel fEdgeWeight;

	/**
	 * call the super constructor
	 */
	public ActivityEdgeFigure() {
		super();
		this.setLineWidth(1);
		setTargetDecoration(createTargetDecoration());
	}

	/**
	 * create the content
	 */
	protected void createContents() {
		super.createContents();
	}

	@Override
	public void resetStyle() {
		super.resetStyle();
		setTargetDecoration(createTargetDecoration());
	}

	/**
	 * Scale changed from default 7:3 to 5:2 to make a
	 * smaller arrow
	 */
	private RotatableDecoration createTargetDecoration() {
		PolylineDecoration df = new PolylineDecoration();
		df.setLineWidth(1);
		PointList pl = new PointList();
		pl.addPoint(mapNode.DPtoLP(-2), mapNode.DPtoLP(2));
		pl.addPoint(mapNode.DPtoLP(0), mapNode.DPtoLP(0));
		pl.addPoint(mapNode.DPtoLP(-2), mapNode.DPtoLP(-2));
		df.setTemplate(pl);
		df.setScale(mapNode.DPtoLP(5), mapNode.DPtoLP(2));
		return df;
	}

	/**
	 * 
	 */
	public WrappedLabel getEdgeName() {
		return fEdgeName;
	}

	/**
	 *
	 */
	public WrappedLabel getEdgeWeight() {
		return fEdgeWeight;
	}

	/**
	 * Get the stereotype label of super class
	 */
	public WrappingLabel getAppliedStereotypeLabel() {
		return super.getAppliedStereotypeLabel();
	}
}
