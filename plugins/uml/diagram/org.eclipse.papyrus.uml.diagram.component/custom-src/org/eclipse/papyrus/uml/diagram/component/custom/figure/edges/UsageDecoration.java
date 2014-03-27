/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *	Amine EL KOUHEN (CEA LIST/INRIA DaRT) amine.el_kouhen@inria.fr
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.component.custom.figure.edges;

import org.eclipse.papyrus.infra.gmfdiag.common.figure.edge.PapyrusEdgeFigure;


// TODO: Auto-generated Javadoc
/**
 * The Class UsageDecoration.
 */
public class UsageDecoration extends PapyrusEdgeFigure {


	/**
	 * Instantiates a new usage decoration.
	 */
	public UsageDecoration() {
		this.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
		setTargetDecoration(createTargetDecoration());
	}

	@Override
	public void resetStyle() {
		super.resetStyle();
		setTargetDecoration(createTargetDecoration());
	}

	/**
	 * Creates the target decoration.
	 * 
	 * @return the org.eclipse.draw2d. rotatable decoration
	 */
	private org.eclipse.draw2d.RotatableDecoration createTargetDecoration() {

		org.eclipse.draw2d.PolylineDecoration df = new org.eclipse.draw2d.PolylineDecoration();
		df.setFill(false);
		org.eclipse.draw2d.geometry.PointList pl = new org.eclipse.draw2d.geometry.PointList();

		pl.addPoint(2, 3);
		pl.addPoint(1, 3);
		pl.addPoint(0, 1);
		pl.addPoint(0, 0);
		pl.addPoint(0, -1);
		pl.addPoint(1, -3);
		pl.addPoint(2, -3);
		df.setTemplate(pl);
		df.setScale(7, 3);

		return df;
	}




}
