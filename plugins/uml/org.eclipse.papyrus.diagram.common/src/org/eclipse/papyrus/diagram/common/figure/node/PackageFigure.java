/*******************************************************************************
 * Copyright (c) 2006 CEA List.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *******************************************************************************/
package org.eclipse.papyrus.diagram.common.figure.node;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.swt.graphics.Color;

/**
 * Figure for a package element
 */
public class PackageFigure extends NodeNamedElementFigure {


	private RectangleFigure shapeCompartment;

	/**
	 * this is the layout manager in charge to place element in the enumeration
	 * 
	 */
	private class ClassifierLayoutManager extends AbstractLayout {

		/**
		 * 
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {

			int minimumWith = 0;
			int minimumHeight = 0;
			// display name
			if (getNameLabel() != null) {
				if (getNameLabel().getPreferredSize().width > minimumWith) {
					minimumWith = getNameLabel().getPreferredSize().width;
				}
				minimumHeight += getNameLabel().getPreferredSize().height;
			}

			return new Dimension(minimumWith, minimumHeight);
		}

		/**
		 * 
		 * {@inheritDoc}
		 */
		public void layout(IFigure container) {
			List childrenList = container.getChildren();
			int indexShapeContainer = container.getChildren().indexOf(shapeCompartment);
			for (int i = 0; i < container.getChildren().size(); i++) {
				Rectangle bound = new Rectangle(((IFigure) childrenList.get(i)).getBounds());
				bound.setSize(((IFigure) childrenList.get(i)).getPreferredSize());
				if (i > 0) {
					bound.y = ((IFigure) childrenList.get(i - 1)).getBounds().getBottomLeft().y + 1;
					bound.x = getBounds().x + 3;
				} else {
					bound.x = getBounds().x + 3;
					bound.y = getBounds().y;

				}
				((IFigure) childrenList.get(i)).setBounds(bound);
			}
			// container
			Rectangle lastRectangle = getPackageableElementFigure().getBounds();
			lastRectangle.height = getBounds().y + getBounds().height - lastRectangle.y;
			lastRectangle.x = lastRectangle.x - 3;
			lastRectangle.width = getBounds().width;
			getPackageableElementFigure().setBounds(lastRectangle);
			if (getGMFPackageableElementContainer() != null) {
				getGMFPackageableElementContainer().setBounds(lastRectangle);
			}
		}

	}

	/**
	 * Creates a new PackageFigure.
	 */
	public PackageFigure() {
		super();
		setLayoutManager(new ClassifierLayoutManager());
		setOpaque(false);

		shapeCompartment = new RectangleFigure();
		add(shapeCompartment);

		setBorder(null);
		getPackageableElementFigure().setFill(false);
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ShapeCompartmentFigure getGMFPackageableElementContainer() {
		if (shapeCompartment.getChildren().size() > 0) {
			return (ShapeCompartmentFigure) shapeCompartment.getChildren().get(0);
		}
		return null;
	}

	public RectangleFigure getPackageableElementFigure() {
		return shapeCompartment;
	}

	/**
	 * use to obtain the coordinates of the package header
	 * 
	 * @return coordinate of the package header, maybe null if the figure has never be painted.
	 */
	public Rectangle getHeader() {
		// the index of the shape container
		int indexShapeContainer = getChildren().indexOf(shapeCompartment);
		Rectangle headerBound = new Rectangle(0, 0, 0, 0);
		for (int i = 0; i < indexShapeContainer; i++) {
			IFigure currentchild = (IFigure) this.getChildren().get(i);
			if (currentchild.getPreferredSize().width > headerBound.width) {
				headerBound.width = currentchild.getPreferredSize().width + 10;
			}
			headerBound.height += currentchild.getPreferredSize().height;
		}
		headerBound.height += 1; 
		
		headerBound.x = getPackageableElementFigure().getBounds().x;
		headerBound.y = getPackageableElementFigure().getBounds().y - headerBound.height;

		return headerBound;
	}

	public Color getGradientColor() {
		return getForegroundColor();
	}

	public void setShadow(boolean shadow) {
		// FIXME : set the outline border of the figure ?
	}
	
	@Override
	protected void paintBorder(Graphics graphics) {
		graphics.drawRectangle(getHeader());
		super.paintBorder(graphics);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected void paintBackground(Graphics graphics, Rectangle rectangle) {
		if (isUsingGradient()) {
			applyTransparency(graphics);
			graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor2()));
			graphics.fillRectangle(getHeader());
			boolean isVertical = (getGradientStyle() == GradientStyle.VERTICAL) ? true : false;
			graphics.setBackgroundColor(FigureUtilities.integerToColor(getGradientColor1()));
			graphics.setForegroundColor(FigureUtilities.integerToColor(getGradientColor2()));
			graphics.fillGradient(getPackageableElementFigure().getBounds(), isVertical);
		} else {
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.setForegroundColor(getForegroundColor());
			graphics.fillRectangle(getHeader());
			graphics.fillRectangle(getPackageableElementFigure().getBounds());
		}
	}
}
