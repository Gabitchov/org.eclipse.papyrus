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
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.ICustomNodePlate;
import org.eclipse.papyrus.infra.gmfdiag.common.figure.node.SVGNodePlateFigure;

/**
 * this figure is used to display at the good positionn acnhor on the
 * packageable element
 * 
 * @author PT202707
 * 
 */
public class PackageNodePlateFigure extends DefaultSizeNodeFigure implements ICustomNodePlate{

	protected SVGNodePlateFigure svgNodePlateFigure=null;
	// @unused
	public PackageNodePlateFigure(Dimension defSize) {
		super(defSize);
		// TODO Auto-generated constructor stub
	}

	public PackageNodePlateFigure(int width, int height) {
		super(width, height);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the package figure, it's a child of PackageNodePlateFigure
	 * 
	 * @return the package figure
	 */
	public PackageFigure getPackageFigure() {
		if(getChildren().size() > 0 && getChildren().get(0) instanceof PackageFigure) {
			return (PackageFigure)getChildren().get(0);

		}
		if(svgNodePlateFigure!=null &&svgNodePlateFigure.getChildren().size() > 0 && svgNodePlateFigure.getChildren().get(0) instanceof PackageFigure) {
			return (PackageFigure)svgNodePlateFigure.getChildren().get(0);

		}
		return null;
	}

	
	// This returns as the anchoring area only the central line
	@Override
	public PointList getPolygonPoints() {
		PointList points = new PointList(5);
		Rectangle anchorableRectangle = getHandleBounds();
		points.addPoint(anchorableRectangle.x, anchorableRectangle.y);

		PackageFigure packageFigure = getPackageFigure();

		if(packageFigure != null) {
			// take in account the header of the package
			points.addPoint(anchorableRectangle.x + packageFigure.getHeader().width, anchorableRectangle.y);
			points.addPoint(anchorableRectangle.x + packageFigure.getHeader().width, anchorableRectangle.y + packageFigure.getHeader().height);
			points.addPoint(anchorableRectangle.x + anchorableRectangle.width, anchorableRectangle.y + packageFigure.getHeader().height);
		}// no header
		else {
			points.addPoint(anchorableRectangle.x + anchorableRectangle.width, anchorableRectangle.y);
		}

		points.addPoint(anchorableRectangle.x + anchorableRectangle.width, anchorableRectangle.y + anchorableRectangle.height);
		points.addPoint(anchorableRectangle.x, anchorableRectangle.y + anchorableRectangle.height);
		points.addPoint(anchorableRectangle.x, anchorableRectangle.y);
		return points;
	}

	/**
	 * 
	 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.ICustomNodePlate#setSVGNodePlateContainer(org.eclipse.papyrus.uml.diagram.common.figure.node.SVGNodePlateFigure)
	 *
	 * @param svgNodePlateFigure
	 */
	public void setSVGNodePlateContainer(SVGNodePlateFigure svgNodePlateFigure) {
		this.svgNodePlateFigure=svgNodePlateFigure;
		
	}
/**
 * 
 * @see org.eclipse.papyrus.infra.gmfdiag.common.figure.node.ICustomNodePlate#getSvgNodePlateContainer()
 *
 * @return
 */
	public SVGNodePlateFigure getSvgNodePlateContainer() {
		return this.svgNodePlateFigure;
	}

}
