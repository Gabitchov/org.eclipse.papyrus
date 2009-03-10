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

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.swt.graphics.Color;

/**
 * this is the custom figure for an Enumeration
 * 
 * @author Patrick Tessier
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 * @deprecated
 */
public class CEnumeration extends CNamedElementFigure {

	/**
	 * this is the layout manager in charge to place element in the enumeration
	 * 
	 */
	private class EnumerationLayoutManager extends AbstractLayout {

		/**
		 * 
		 * {@inheritDoc}
		 */
		@Override
		protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {
			int minimumWith = 0;
			int minimumHeight = 0;

			if (getElementStereotype() != null && getElementStereotype().getText().length() != 0) {
				minimumWith = getElementStereotype().getPreferredSize().width;
				minimumHeight = getElementStereotype().getPreferredSize().height;
			}
			// display name
			if (getElementName() != null) {
				if (getElementName().getPreferredSize().width > minimumWith) {
					minimumWith = getElementName().getPreferredSize().width;
				}
				minimumHeight += getElementName().getPreferredSize().height;
			}
			// display qualifiedName
			if (getElementQualifiedName() != null) {
				if (getElementQualifiedName().getPreferredSize().width > minimumWith) {
					minimumWith = getElementQualifiedName().getPreferredSize().width;
				}
				minimumHeight += getElementQualifiedName().getPreferredSize().height;
			}
			if (getGMFLiteralContainer() != null) {
				if (!getGMFLiteralContainer().isExpanded()) {
					minimumHeight += 10;
				} else {
					minimumHeight += wrappedLabelSize * (getGMFLiteralContainer().getContentPane().getChildren().size() + 1);
				}
			}
			if (getLiteralContainer() != null) {
				if (getLiteralContainer().getPreferredSize().width > minimumWith) {
					minimumWith = getLiteralContainer().getPreferredSize().width;
				}
			}
			return new Dimension(minimumWith, minimumHeight);
		}

		/**
		 * 
		 * {@inheritDoc}
		 */
		public void layout(IFigure container) {
			int height = 0;

			Rectangle elementBound = new Rectangle(getBounds().x, getBounds().y, 0, 0);
			// display stereotypes
			if (getElementStereotype() != null && getElementStereotype().getText().length() != 0) {
				elementBound.width = getBounds().width;
				elementBound.height = getElementStereotype().getPreferredSize().height;
				height += elementBound.height;
				getElementStereotype().setBounds(elementBound);
				getElementStereotype().setAlignment(PositionConstants.CENTER);
				getElementStereotype().layout();
			}
			// display name
			if (getElementName() != null) {
				elementBound.y += elementBound.height;
				elementBound.height = getElementName().getPreferredSize().height;
				height += elementBound.height;
				getElementName().setBounds(elementBound);
				getElementName().setAlignment(PositionConstants.CENTER);
				getElementName().layout();
			}
			// display qualifiedName
			if (getElementQualifiedName() != null) {
				elementBound.y += elementBound.height;
				elementBound.height = getElementQualifiedName().getPreferredSize().height;
				getElementQualifiedName().setBounds(elementBound);
				getElementQualifiedName().setAlignment(PositionConstants.CENTER);
				getElementQualifiedName().layout();
				height += elementBound.height;
			}

			// display Attribtutes
			Rectangle attributeBound = new Rectangle(elementBound.getBottomLeft().x, elementBound.getBottomLeft().y, getBounds().width, 10);
			// getBounds().height-height);

			if (getGMFLiteralContainer() != null) {
				if (!getGMFLiteralContainer().isExpanded()) {
					attributeBound.height = 10;
				} else {
					attributeBound.height = wrappedLabelSize * (getGMFLiteralContainer().getContentPane().getChildren().size() + 1);
				}
			}
			if (getLiteralContainer() != null) {
				getLiteralContainer().setBounds(attributeBound);
			}
			if (getGMFLiteralContainer() != null) {
				getGMFLiteralContainer().setBounds(attributeBound);
			}
			// fill the last compartment
			int lastIndex = getChildren().size() - 1;
			Rectangle lastRectangle = getSubFigure(lastIndex).getBounds();
			lastRectangle.height = getBounds().y + getBounds().height - lastRectangle.y;
			getSubFigure(lastIndex).setBounds(lastRectangle);
			if (getSubFigure(lastIndex).getChildren().size() != 0 && getSubFigure(lastIndex).getChildren().get(0) instanceof ResizableCompartmentFigure) {
				((Figure) getSubFigure(lastIndex).getChildren().get(0)).setBounds(lastRectangle);
			}
		}

	}

	private static final int literalContainerIndex = 3;

	private static final int wrappedLabelSize = 18;

	private EnumerationLayoutManager myLayout = new EnumerationLayoutManager();

	/** the shadow **/
	private RectangularShadowBorder shadow = null;

	public CEnumeration() {
		super();
		this.setLayoutManager(myLayout);
		setForegroundColor(ColorConstants.blue);
		setBackgroundColor(ColorConstants.blue);
	}

	/**
	 * get the gmf container figure of the enumeration
	 * 
	 * @return the gmf container
	 */
	public ResizableCompartmentFigure getGMFLiteralContainer() {
		if (getLiteralContainer() != null) {
			if (getLiteralContainer().getChildren().size() > 0) {
				return (ResizableCompartmentFigure) getLiteralContainer().getChildren().get(0);
			}
		}
		return null;
	}

	/**
	 * get the container figure of the enumeration
	 * 
	 * @return the container figure
	 */
	public RectangleFigure getLiteralContainer() {
		if (getSubFigure(literalContainerIndex) != null && getSubFigure(literalContainerIndex) instanceof RectangleFigure) {
			return ((RectangleFigure) getSubFigure(literalContainerIndex));
		}
		return null;
	}

	public Color getGradientColor() {
		return getForegroundColor();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void paint(Graphics graphics) {
		graphics.setForegroundColor(this.getGradientColor());
		graphics.setBackgroundColor(this.getBackgroundColor());
		Rectangle ContainerBound = new Rectangle(getBounds().x, getBounds().y, getBounds().width - 1, getBounds().height - 1);
		graphics.fillGradient(ContainerBound, true);
		graphics.setForegroundColor(this.getForegroundColor());
		graphics.drawRectangle(ContainerBound);
		if (shadow == null) {
			this.shadow = new RectangularShadowBorder(2, this.getForegroundColor());
			super.setBorder(shadow);
		}
		super.paint(graphics);
	}
}
