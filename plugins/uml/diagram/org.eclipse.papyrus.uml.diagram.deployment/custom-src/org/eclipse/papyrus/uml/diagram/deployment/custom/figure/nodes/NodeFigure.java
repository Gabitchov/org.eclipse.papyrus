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
package org.eclipse.papyrus.uml.diagram.deployment.custom.figure.nodes;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.graphics.ColorRegistry;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

// TODO: Auto-generated Javadoc
/**
 * The Class NodeFigure.
 */
public class NodeFigure extends NodeNamedElementFigure {

	public final int SPACE_FOR_PERSPECTIVE = 15;

	private RectangleFigure shapeCompartment;


	/** this is a label used to display a specific icon for this element **/
	protected Label iconNode = null;

	/**
	 * Creates a new NodeFigure.
	 */
	public NodeFigure() {
		super();
		createContent();
	}

	public NodeFigure(String taggedLabelValue) {
		super(taggedLabelValue);
		createContent();

	}

	protected void createContent() {
		setLayoutManager(new NodeLayoutManager(this));
		setOpaque(false);

		shapeCompartment = new RectangleFigure();
		shapeCompartment.setBorder(null);
		add(shapeCompartment);

		setBorder(null);
		getCompositeCompartmentFigure().setFill(false);
	}



	/**
	 * this method is used to display a symbol image for an element Node as
	 * triangle for the model
	 * 
	 * @param image
	 */
	public void setTagIcon(Image image) {
		iconNode = new Label();
		iconNode.setIcon(image);
		add(iconNode);

	}

	/**
	 * get the gmf container figure of the Node
	 * 
	 * @return the gmf container
	 */
	public ShapeCompartmentFigure getGMFCompositeContainer() {
		if(shapeCompartment.getChildren().size() > 0) {
			return (ShapeCompartmentFigure)shapeCompartment.getChildren().get(0);
		}
		return null;
	}

	public RectangleFigure getCompositeCompartmentFigure() {
		return shapeCompartment;
	}



	// @unused
	public Color getGradientColor() {
		return getForegroundColor();
	}

	@Override
	public void setShadow(boolean shadow) {
		// FIXME : set the outline border of the figure ?
	}

	@Override
	public void setLineWidth(int w) {

		getCompositeCompartmentFigure().setLineWidth(w);
		super.setLineWidth(w);
	}

	@Override
	protected void paintBorder(Graphics graphics) {
		super.paintBorder(graphics);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		if(isUsingGradient()) {
			applyTransparency(graphics);
			graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
			boolean isVertical = (getGradientStyle() == GradientStyle.VERTICAL) ? true : false;
			graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));
			graphics.setForegroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
			graphics.fillGradient(getCompositeCompartmentFigure().getBounds(), isVertical);
		} else {
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.setForegroundColor(getBorderColor());
			graphics.fillRectangle(getCompositeCompartmentFigure().getBounds());
		}
		graphics.setForegroundColor(getBorderColor());
		graphics.setLineWidth(getLineWidth());
	}


	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);

		Rectangle bounds = this.getBounds();
		graphics.pushState();
		graphics.setForegroundColor(getForegroundColor());
		// do not forget to set line width to 1, if not the color will
		// change because of the anti-aliasing
		graphics.setLineWidth(1);
		graphics.drawRectangle(bounds.x, bounds.y + SPACE_FOR_PERSPECTIVE, bounds.width - SPACE_FOR_PERSPECTIVE - 1, bounds.height - SPACE_FOR_PERSPECTIVE - 1);

		graphics.drawLine(new Point(bounds.x, bounds.y + SPACE_FOR_PERSPECTIVE), new Point(bounds.x + SPACE_FOR_PERSPECTIVE, bounds.y));
		graphics.drawLine(new Point(bounds.x + bounds.width - SPACE_FOR_PERSPECTIVE - 1, bounds.y + SPACE_FOR_PERSPECTIVE), new Point(bounds.x - 1 + bounds.width, bounds.y));
		graphics.drawLine(new Point(bounds.x + bounds.width - SPACE_FOR_PERSPECTIVE - 1, bounds.y + bounds.height), new Point(bounds.x + bounds.width - 1, bounds.y + bounds.height - SPACE_FOR_PERSPECTIVE));

		graphics.drawLine(new Point(bounds.x + SPACE_FOR_PERSPECTIVE, bounds.y), new Point(bounds.x + bounds.width, bounds.y));
		graphics.drawLine(new Point(bounds.x + bounds.width - 1, bounds.y), new Point(bounds.x + bounds.width - 1, bounds.y + bounds.height - SPACE_FOR_PERSPECTIVE));

		graphics.setBackgroundColor(getBackgroundColor());
		graphics.setForegroundColor(getBackgroundColor());

		graphics.popState();
	}
}
