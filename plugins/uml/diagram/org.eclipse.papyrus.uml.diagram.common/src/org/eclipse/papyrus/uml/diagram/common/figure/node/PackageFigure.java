/*******************************************************************************
 * Copyright (c) 2006, 2014 CEA List and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     CEA List - initial API and implementation
 *     Christian W. Damus (CEA) - bug 392301
 *     
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.graphics.ColorRegistry;
import org.eclipse.gmf.runtime.notation.GradientStyle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

/**
 * Figure for a package element
 */
public class PackageFigure extends NodeNamedElementFigure {

	private final RectangleFigure shapeCompartment;

	/**
	 * gap in x to display name stereotypes and qualified name
	 */
	protected final int GAP_X = 10;

	/**
	 * gap in y to display the first label at the top of the package
	 */
	protected final int GAP_Y = 5;

	/**
	 * this is the layout manager in charge to place element in the enumeration
	 * 
	 */
	private class PackageLayoutManager extends AbstractLayout {

		/**
		 * 
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {

			int minimumWith = 0;
			int minimumHeight = 0;
			// display name
			if(getNameLabel() != null) {
				if(getNameLabel().getPreferredSize().width > minimumWith) {
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
			for(int i = 0; i < container.getChildren().size(); i++) {
				Rectangle bound = new Rectangle(((IFigure)childrenList.get(i)).getBounds());
				IFigure fig=((IFigure)childrenList.get(i));
				fig.invalidate();
				Dimension pref=((IFigure)childrenList.get(i)).getPreferredSize();
				fig.invalidate();
				Dimension prefConstraint=((IFigure)childrenList.get(i)).getPreferredSize(container.getBounds().width-40,-1);
				if( pref.width<prefConstraint.width){
					bound.setSize(pref);
				}
				else{
					bound.setSize(prefConstraint);
				}
				if(((IFigure)childrenList.get(i)).equals(iconPackage)) {
					Rectangle boundName = getNameLabel().getBounds().getCopy();
					boundName.x += GAP_X / 2;
					iconPackage.setBounds(new Rectangle(boundName.getTopRight(), new Dimension(16, 16)));
				} else {
					if(i > 0) {
						bound.y = ((IFigure)childrenList.get(i - 1)).getBounds().getBottomLeft().y + 1;
						bound.x = getBounds().x + GAP_X;
					} else {
						bound.x = getBounds().x + GAP_X;
						bound.y = getBounds().y + GAP_Y;

					}
					((IFigure)childrenList.get(i)).setBounds(bound);
				}
			}
			// container
			Rectangle lastRectangle = getPackageableElementFigure().getBounds();
			lastRectangle.height = getBounds().y + getBounds().height - lastRectangle.y;
			lastRectangle.x = container.getBounds().x;
			lastRectangle.width = getBounds().width;
			//getPackageableElementFigure().setBounds(lastRectangle);
			if(getGMFPackageableElementContainer() != null) {
				//getGMFPackageableElementContainer().setBounds(lastRectangle);
			}
		}

	}

	/** this is a label used to display a specific icon for this element **/
	protected Label iconPackage = null;

	/**
	 * Creates a new PackageFigure.
	 */
	public PackageFigure() {
		super();

		setLayoutManager(new PackageLayoutManager());
		setOpaque(false);

		shapeCompartment = new RectangleFigure();
		add(shapeCompartment);

		setBorder(null);
		getPackageableElementFigure().setFill(false);

	}

	/**
	 * this method is used to display a symabol image for an element package as
	 * triangle for the model
	 * 
	 * @param image
	 */
	public void setTagIcon(Image image) {
		iconPackage = new Label();
		iconPackage.setIcon(image);
		add(iconPackage);

	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ShapeCompartmentFigure getGMFPackageableElementContainer() {
		if(shapeCompartment.getChildren().size() > 0) {
			return (ShapeCompartmentFigure)shapeCompartment.getChildren().get(0);
		}
		return null;
	}

	public RectangleFigure getPackageableElementFigure() {
		return shapeCompartment;
	}

	/**
	 * use to obtain the coordinates of the package header
	 * 
	 * @return coordinate of the package header, maybe null if the figure has
	 *         never be painted.
	 */
	public Rectangle getHeader() {
		// the index of the shape container
		int indexShapeContainer = getChildren().indexOf(shapeCompartment);
		Rectangle headerBound = new Rectangle(0, 0, 0, 0);
		for(int i = 0; i < indexShapeContainer; i++) {
			IFigure currentchild = (IFigure)this.getChildren().get(i);
			if(currentchild.getSize().width + 2 * GAP_X > headerBound.width) {
				headerBound.width = currentchild.getSize().width + 2 * GAP_X;
			}
			headerBound.height += currentchild.getSize().height;
		}
		headerBound.height += 1;

		headerBound.x = this.getBounds().x;
		headerBound.y = this.getBounds().y;
		headerBound.height = getPackageableElementFigure().getBounds().y - headerBound.y;
		if(iconPackage != null) {
			headerBound.width += iconPackage.getBounds().width;
		}
		return headerBound;
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
		getHeader().setWidth(w);
		getPackageableElementFigure().setLineWidth(w);
		super.setLineWidth(w);
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
		if(isUsingGradient()) {
			applyTransparency(graphics);
			graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
			graphics.fillRectangle(getHeader());
			boolean isVertical = (getGradientStyle() == GradientStyle.VERTICAL) ? true : false;
			graphics.setBackgroundColor(ColorRegistry.getInstance().getColor(getGradientColor1()));
			graphics.setForegroundColor(ColorRegistry.getInstance().getColor(getGradientColor2()));
			graphics.fillGradient(getPackageableElementFigure().getBounds(), isVertical);
		} else {
			graphics.setBackgroundColor(getBackgroundColor());
			graphics.setForegroundColor(getBorderColor());
			graphics.fillRectangle(getHeader());
			graphics.fillRectangle(getPackageableElementFigure().getBounds());
		}
		graphics.setForegroundColor(getBorderColor());
		graphics.setLineWidth(getLineWidth());
		graphics.drawRectangle(getHeader());
	}
}
