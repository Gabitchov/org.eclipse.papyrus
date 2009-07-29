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
package org.eclipse.papyrus.diagram.common.figure.node;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;

/**
 * this is the custom figure for the package
 * 
 * @author Patrick Tessier
 * @deprecated
 * 
 */
public class CPackageFigure extends CNamedElementFigure {

	/** the container figure of the package **/
	private static final int packageableContainerIndex = 3;

	private Dimension header = new Dimension(0, 0);

	/**
	 * Creates a new PackageFigure.
	 */
	public CPackageFigure() {
		setLayoutManager(new ToolbarLayout());
		setOpaque(false);
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ShapeCompartmentFigure getGMFPackageableElementContainer() {
		if (getPackageableElementContainer() != null) {
			if (getPackageableElementContainer().getChildren().size() > 0) {
				return (ShapeCompartmentFigure) getPackageableElementContainer().getChildren().get(0);
			}
		}
		return null;
	}

	/**
	 * use to obtain the coordinates of the package header
	 * 
	 * @return coordinate of the package header, maybe null if the figure has never be painted.
	 */
	public Dimension getHeader() {
		Rectangle headerBound = new Rectangle(getBounds().x, getBounds().y, 0, 0);
		if (header.width == 0 && header.height == 0) {
			// stereotype Label
			if (getElementStereotype() != null && getElementStereotype().getText().length() != 0) {
				headerBound = getElementStereotype().getBounds().getCopy();
				headerBound.setSize(getElementStereotype().getPreferredSize());
			}

			// name label
			if (getElementName() != null) {
				// place at good Position
				if (getElementName().getPreferredSize().width > headerBound.width) {
					headerBound.width = getElementName().getPreferredSize().width;
				}
				headerBound.height += getElementName().getPreferredSize().height;
			}
			// qualified Name
			if (getElementQualifiedName() != null) {
				if (getElementQualifiedName().getPreferredSize().width > headerBound.width) {
					headerBound.width = getElementQualifiedName().getPreferredSize().width;
				}
				headerBound.height += getElementQualifiedName().getPreferredSize().height;
			}
			header.width = headerBound.width;
			header.height = headerBound.height;
		}
		return header;
	}

	/**
	 * get the container figure of the package
	 * 
	 * @return the container figure
	 */
	public RectangleFigure getPackageableElementContainer() {
		if (getSubFigure(packageableContainerIndex) != null
				&& getSubFigure(packageableContainerIndex) instanceof RectangleFigure) {
			return ((RectangleFigure) getSubFigure(packageableContainerIndex));
		}
		return null;
	}

	public Color getGradientColor() {
		return getForegroundColor();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void paint(Graphics graphics) {

		// get header dimension
		Rectangle headerBound = new Rectangle(getBounds().x, getBounds().y, 0, 0);
		graphics.setAntialias(SWT.ON);
		// stereotype Label
		if (getElementStereotype() != null && getElementStereotype().getText().length() != 0) {
			getElementStereotype().setOpaque(false);
			headerBound = getElementStereotype().getBounds().getCopy();
			headerBound.setSize(getElementStereotype().getPreferredSize());
		}

		// name label
		if (getElementName() != null) {
			getElementName().setOpaque(false);
			// place at good Position
			getElementName().setLocation(
					headerBound.getTopLeft().getCopy().getTranslated(new Dimension(0, headerBound.height)));
			if (getElementName().getPreferredSize().width > headerBound.width) {
				headerBound.width = getElementName().getPreferredSize().width;
			}
			headerBound.height += getElementName().getPreferredSize().height;
		}
		// qualified Name
		if (getElementQualifiedName() != null) {
			getElementQualifiedName().setOpaque(false);
			getElementQualifiedName().setLocation(
					headerBound.getTopLeft().getCopy().getTranslated(new Dimension(0, headerBound.height)));
			if (getElementQualifiedName().getPreferredSize().width > headerBound.width) {
				headerBound.width = getElementQualifiedName().getPreferredSize().width;
			}
			headerBound.height += getElementQualifiedName().getPreferredSize().height;
		}
		// draw header
		Rectangle containerBound = new Rectangle(headerBound.x, headerBound.y, headerBound.width, headerBound.height);
		graphics.setForegroundColor(this.getGradientColor());
		graphics.setBackgroundColor(this.getBackgroundColor());
		graphics.fillGradient(containerBound, true);
		graphics.drawRectangle(containerBound);

		graphics.setForegroundColor(getForegroundColor());

		header.width = headerBound.width;
		header.height = headerBound.height;

		if (getElementStereotype() != null) {
			graphics.pushState();
			getElementStereotype().paint(graphics);
			graphics.popState();

		}
		graphics.pushState();
		getElementName().paint(graphics);
		graphics.popState();
		if (getElementQualifiedName() != null) {
			graphics.pushState();
			getElementQualifiedName().paint(graphics);
			graphics.popState();

		}

		// display containment
		if (getPackageableElementContainer() != null) {
			getPackageableElementContainer().setLocation(
					headerBound.getTopLeft().getCopy().getTranslated(new Dimension(0, headerBound.height)));
			Rectangle container = getPackageableElementContainer().getBounds().getCopy();
			container.height = this.getBounds().height - headerBound.height;

			if (getGMFPackageableElementContainer() != null) {
				getGMFPackageableElementContainer().setBounds(container);
			}
			getPackageableElementContainer().setBounds(container);
			graphics.pushState();
			getPackageableElementContainer().paint(graphics);
			graphics.popState();
		}

		paintBorder(graphics, headerBound);
	}

	protected void paintBorder(Graphics graphics, Rectangle headerBound) {
		int borderwidth = 2;

		// draw the border on top part
		Rectangle tempRect = new Rectangle(headerBound.x, headerBound.y, headerBound.width, headerBound.height);
		tempRect.setBounds(tempRect.crop(NO_INSETS));
		// draw the shadow
		// first expand the clip rectangle
		Rectangle newRect = new Rectangle(tempRect);
		newRect.width = newRect.width + borderwidth;
		newRect.height = newRect.height + borderwidth;
		graphics.setClip(newRect);
		// paint the shadow
		PointList plt = new PointList();
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y + borderwidth);
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y + tempRect.height);
		plt.addPoint(tempRect.x + tempRect.width + borderwidth, tempRect.y + tempRect.height);
		plt.addPoint(tempRect.x + tempRect.width + borderwidth, tempRect.y + borderwidth);
		graphics.setBackgroundColor(getForegroundColor());
		graphics.fillPolygon(plt);

		// draw the border on bottom part
		tempRect.setBounds(getPackageableElementContainer().getBounds());
		tempRect.setBounds(tempRect.crop(NO_INSETS));
		// draw the shadow
		// first expand the clip rectangle
		newRect = new Rectangle(tempRect);
		newRect.width = newRect.width + borderwidth;
		newRect.height = newRect.height + borderwidth;
		graphics.setClip(newRect);
		// paint the shadow
		plt = new PointList();
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y);
		plt.addPoint(tempRect.x + tempRect.width, tempRect.y + tempRect.height);
		plt.addPoint(tempRect.x + borderwidth, tempRect.y + tempRect.height);
		plt.addPoint(tempRect.x + borderwidth, tempRect.y + tempRect.height + borderwidth);
		plt.addPoint(tempRect.x + tempRect.width + borderwidth, tempRect.y + tempRect.height + borderwidth);
		plt.addPoint(tempRect.x + tempRect.width + borderwidth, tempRect.y);
		graphics.setBackgroundColor(getForegroundColor());
		graphics.fillPolygon(plt);
	}

}
