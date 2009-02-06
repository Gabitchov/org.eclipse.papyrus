/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.diagram.common.figure.edge;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolygonDecoration;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.swt.SWT;

/**
 * This edge figure is painted using dashes. This is the base figure for dependencies, for example
 * 
 * @author Patrick Tessier
 */
public class CAssociationFigure extends PolylineConnectionEx {

	/**
	 * the end of the association is an aggregation i.e. this a translucide diamond.
	 */
	public static final int aggregation = 1;

	/**
	 * the end of the association is a composition so this a black diamond.
	 */
	public static final int composition = 2;

	/**
	 * the end of the association is navigable so this is an arrow.
	 */
	public static final int navigable = 0;

	/**
	 * the end of teh association is not navigable so there is nothing.
	 */
	public static final int nothing = 3;

	/**
	 * Default constructor of the association figure
	 */
	public CAssociationFigure() {
		super();
		this.setEnd(nothing, navigable);

	}

	/**
	 * create an association figure.
	 * 
	 * @param targetType
	 *            the type of end of the association {@link AssociationFigure#navigable}
	 * @param sourceType
	 *            the type of end of the association {@link AssociationFigure#navigable}
	 */
	public CAssociationFigure(int sourceType, int targetType) {
		super();
		this.setEnd(sourceType, targetType);

	}

	/**
	 * @{inheritDoc
	 */
	@Override
	public void paintFigure(Graphics graphics) {
		graphics.pushState();
		graphics.setAntialias(SWT.ON);
		super.paintFigure(graphics);

		graphics.popState();
	}

	/**
	 * used to display end of the association.
	 * 
	 * @param targetType
	 *            the type of end of the association {@link AssociationFigure#navigable}
	 * @param sourceType
	 *            the type of end of the association {@link AssociationFigure#navigable}
	 */
	public void setEnd(int sourceType, int targetType) {
		PolylineDecoration dec;
		PolygonDecoration decoration;
		PointList decorationPointList;

		// display end link near of the source
		switch (sourceType) {
		case navigable: // its only navigable
			dec = new PolylineDecoration();
			dec.setScale(15, 5);
			dec.setLineWidth(1);
			this.setSourceDecoration(dec); // arrow at target endpoint
			break;

		case aggregation: // this is aggregation
			decoration = new PolygonDecoration();
			decorationPointList = new PointList();
			decorationPointList.addPoint(0, 0);
			decorationPointList.addPoint(-2, 2);
			decorationPointList.addPoint(-4, 0);
			decorationPointList.addPoint(-2, -2);
			decoration.setTemplate(decorationPointList);
			decoration.setBackgroundColor(ColorConstants.white);
			decoration.setScale(3, 3);
			this.setSourceDecoration(decoration);
			break;
		case composition: // this a compostion
			decoration = new PolygonDecoration();
			decorationPointList = new PointList();
			decorationPointList.addPoint(0, 0);
			decorationPointList.addPoint(-2, 2);
			decorationPointList.addPoint(-4, 0);
			decorationPointList.addPoint(-2, -2);
			decoration.setTemplate(decorationPointList);
			decoration.setScale(3, 3);
			this.setSourceDecoration(decoration);
			break;
		case nothing: // its only navigable

			this.setSourceDecoration(null); // arrow at target endpoint
			break;

		}
		switch (targetType) {
		case navigable:// navigation
			dec = new PolylineDecoration();
			dec.setScale(15, 5);
			dec.setLineWidth(1);
			this.setTargetDecoration(dec); // arrow at target endpoint
			break;

		case aggregation:// aggregation
			decoration = new PolygonDecoration();
			decorationPointList = new PointList();
			decorationPointList.addPoint(0, 0);
			decorationPointList.addPoint(-2, 2);
			decorationPointList.addPoint(-4, 0);
			decorationPointList.addPoint(-2, -2);
			decoration.setTemplate(decorationPointList);
			decoration.setBackgroundColor(ColorConstants.white);
			decoration.setScale(3, 3);
			this.setTargetDecoration(decoration);
			break;
		case composition:// composition
			decoration = new PolygonDecoration();
			decorationPointList = new PointList();
			decorationPointList.addPoint(0, 0);
			decorationPointList.addPoint(-2, 2);
			decorationPointList.addPoint(-4, 0);
			decorationPointList.addPoint(-2, -2);
			decoration.setScale(3, 3);
			decoration.setTemplate(decorationPointList);
			this.setTargetDecoration(decoration);
			break;
		case nothing: // its only navigable

			this.setTargetDecoration(null); // arrow at target endpoint
			break;
		}

	}
}
// DO NOT DELETE follow lines
// this code to display point that may be present in UML2
// circle

/*
 * PointList decorationPointList = new PointList(); decorationPointList.addPoint(0,1); decorationPointList.addPoint(-2,3); decorationPointList.addPoint(-4,3); decorationPointList.addPoint(-6,1);
 * decorationPointList.addPoint(-6,-1); decorationPointList.addPoint(-4,-3); decorationPointList.addPoint(-2,-3); decorationPointList.addPoint(0,-1);
 * 
 * decoration.setScale(1, 1);
 */
// this.setTargetDecoration(decoration);
// composition+ circle
/*
 * PointList decorationPointList = new PointList(); decorationPointList.addPoint(0,1); decorationPointList.addPoint(-2,3); decorationPointList.addPoint(-4,3); decorationPointList.addPoint(-6,1);
 * decorationPointList.addPoint(-6,0); decorationPointList.addPoint(-18,6); decorationPointList.addPoint(-30,0); decorationPointList.addPoint(-18,-6); decorationPointList.addPoint(-6,0);
 * decorationPointList.addPoint(-6,-1); decorationPointList.addPoint(-4,-3); decorationPointList.addPoint(-2,-3); decorationPointList.addPoint(0,-1); //color Point decorationPointList.addPoint(-1,-1);
 * decorationPointList.addPoint(-1,1); decorationPointList.addPoint(-2,3); decorationPointList.addPoint(-2,-3); decorationPointList.addPoint(-3,-3); decorationPointList.addPoint(-3,3);
 * decorationPointList.addPoint(-4,3); decorationPointList.addPoint(-4,-3); decorationPointList.addPoint(-5,-2); decorationPointList.addPoint(-5,2); decorationPointList.addPoint(-6,1);
 * decorationPointList.addPoint(-6,-1);
 * 
 * decoration.setScale(1, 1); decoration.setTemplate(decorationPointList); decoration.setBackgroundColor(ColorConstants.white); this.setSourceDecoration(decoration);
 */
// circle +arrow
/*
 * PointList decorationPointList = new PointList(); decorationPointList.addPoint(0,1); decorationPointList.addPoint(-2,3); decorationPointList.addPoint(-4,3); decorationPointList.addPoint(-6,1);
 * decorationPointList.addPoint(-6,0); decorationPointList.addPoint(-18,6); decorationPointList.addPoint(-6,0); decorationPointList.addPoint(-18,-6); decorationPointList.addPoint(-6,0);
 * decorationPointList.addPoint(-6,-1); decorationPointList.addPoint(-4,-3); decorationPointList.addPoint(-2,-3); decorationPointList.addPoint(0,-1);
 * 
 * decoration.setScale(1, 1); decoration.setTemplate(decorationPointList);
 * 
 * this.setSourceDecoration(decoration);
 */

