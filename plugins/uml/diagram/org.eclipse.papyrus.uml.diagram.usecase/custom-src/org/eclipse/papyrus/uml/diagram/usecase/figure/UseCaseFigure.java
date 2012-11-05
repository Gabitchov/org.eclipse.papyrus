/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Emilien Perico (Atos Origin) emilien.perico@atosorigin.com - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.usecase.figure;

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.OrderedLayout;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.papyrus.uml.diagram.common.draw2d.SplitEllipseLayout;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IEllipseFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;

/**
 * The Class UseCaseFigure.
 * modified by Patrick Tessier inorder to extends nodeName
 */
public class UseCaseFigure extends NodeNamedElementFigure implements IPapyrusNodeUMLElementFigure, IEllipseFigure {

	private final RectangleFigure shapeCompartment;

	/**
	 * Instantiates a new use case figure.
	 */
	public UseCaseFigure() {
		super();
		
		SplitEllipseLayout layoutThis = new SplitEllipseLayout();
		this.setLayoutManager(layoutThis);
		layoutThis.setMinorAlignment(OrderedLayout.ALIGN_CENTER);
		shapeCompartment = new RectangleFigure();
		add(shapeCompartment);
		shapeCompartment.setBorder(null);
		shapeCompartment.setLineWidth(10);
		shapeCompartment.setOpaque(false);
		shapeCompartment.setFill(false);
		this.setBorder(null);
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ShapeCompartmentFigure getGMFExtensionPointContainer() {
		if(shapeCompartment.getChildren().size() > 0) {
			return (ShapeCompartmentFigure)shapeCompartment.getChildren().get(0);
		}
		return null;
	}

	public RectangleFigure getExtensionPointContainerFigure() {
		return shapeCompartment;
	}

	@Override
	protected void setBorder(IFigure borderedFigure, Border border) {
	}

	@Override
	public void paintFigure(Graphics graphics) {
		shapeCompartment.setForegroundColor(getBackgroundColor());
		// TODO Auto-generated method stub
		graphics.fillOval(getBounds());
		paintBackground(graphics, getBounds());
		//shadowborder.setColor(getForegroundColor());
	}

	@Override
	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		graphics.setBackgroundColor(getBackgroundColor());
		graphics.setForegroundColor(getForegroundColor());
		graphics.fillOval(rectangle);
		graphics.drawOval(rectangle);
	}
}
