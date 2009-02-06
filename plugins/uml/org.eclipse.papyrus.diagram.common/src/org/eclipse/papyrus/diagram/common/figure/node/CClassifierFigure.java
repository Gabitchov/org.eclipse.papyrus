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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.swt.graphics.Color;

/**
 * This a custom figure to represent a classifier
 * 
 * @author Patrick Tessier
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CClassifierFigure extends CNamedElementFigure {

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

			if (getGMFAttributeElementContainer() != null) {
				if (!getGMFAttributeElementContainer().isExpanded()) {
					minimumHeight += 10;
				} else {
					minimumHeight += wrappedLabelSize * (getGMFAttributeElementContainer().getContentPane().getChildren().size() + 1);
				}
			}
			if (getAttributeElementContainer() != null) {
				if (getAttributeElementContainer().getPreferredSize().width > minimumWith) {
					minimumWith = getAttributeElementContainer().getPreferredSize().width;
				}
			}

			if (getGMFOperationElementContainer() != null) {
				if (!getGMFOperationElementContainer().isExpanded()) {
					minimumHeight += 10;
				} else {
					minimumHeight += wrappedLabelSize * (getGMFOperationElementContainer().getContentPane().getChildren().size() + 1);
				}
			}

			if (getOperationElementContainer() != null) {
				if (getOperationElementContainer().getPreferredSize().width > minimumWith) {
					minimumWith = getOperationElementContainer().getPreferredSize().width;
				}
			}

			if (getGMFNestedClassifierContainer() != null) {
				if (!getGMFNestedClassifierContainer().isExpanded()) {
					minimumHeight += 10;
				} else {
					minimumHeight += wrappedLabelSize * (getGMFNestedClassifierContainer().getContentPane().getChildren().size() + 1);
				}
			}
			if (getNestedClassifierContainer() != null) {
				if (getNestedClassifierContainer().getPreferredSize().width > minimumWith) {
					minimumWith = getNestedClassifierContainer().getPreferredSize().width;
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
				height += elementBound.height;
			}
			// display Attribtutes
			Rectangle attributeBound = new Rectangle(elementBound.getBottomLeft().x, elementBound.getBottomLeft().y - 1, getBounds().width, 10);
			// getBounds().height-height);

			if (getGMFAttributeElementContainer() != null) {
				if (!getGMFAttributeElementContainer().isExpanded()) {
					attributeBound.height = 10;
				} else {
					attributeBound.height = wrappedLabelSize * (getGMFAttributeElementContainer().getContentPane().getChildren().size() + 1);
				}
			}
			if (getAttributeElementContainer() != null) {
				// graphics.drawLine(elementBound.getBottomLeft(), elementBound.getBottomRight());
				getAttributeElementContainer().setBounds(attributeBound);
			}
			if (getGMFAttributeElementContainer() != null) {
				getGMFAttributeElementContainer().setBounds(attributeBound);
			}
			// display Operation
			Rectangle operationBound = new Rectangle(attributeBound.getBottomLeft().x, attributeBound.getBottomLeft().y - 1, getBounds().width, 10);

			if (getGMFOperationElementContainer() != null) {
				if (!getGMFOperationElementContainer().isExpanded()) {
					operationBound.height = 10;
				} else {
					operationBound.height = wrappedLabelSize * (getGMFOperationElementContainer().getContentPane().getChildren().size() + 1);
				}
			}
			if (getOperationElementContainer() != null) {
				getOperationElementContainer().setBounds(operationBound);
			}
			if (getGMFOperationElementContainer() != null) {
				getGMFOperationElementContainer().setBounds(operationBound);
			}
			// dispalyNestedClassifier
			Rectangle nestedClassifierBound = new Rectangle(operationBound.getBottomLeft().x, operationBound.getBottomLeft().y - 1, getBounds().width, 10);

			if (getGMFNestedClassifierContainer() != null) {
				if (!getGMFNestedClassifierContainer().isExpanded()) {
					nestedClassifierBound.height = 10;
				} else {
					nestedClassifierBound.height = wrappedLabelSize * (getGMFNestedClassifierContainer().getContentPane().getChildren().size() + 1);
				}
			}
			if (getNestedClassifierContainer() != null) {
				getNestedClassifierContainer().setBounds(nestedClassifierBound);
			}
			if (getGMFNestedClassifierContainer() != null) {
				getGMFNestedClassifierContainer().setBounds(nestedClassifierBound);
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

	private static final int attibuteContainerIndex = 3;

	private static final int nestedClassifierContainerIndex = 5;

	private static final int operationContainerIndex = 4;

	private static final int wrappedLabelSize = 18;

	/** to display active class **/
	private boolean isActive = false;

	/** the shadow **/
	private RectangularShadowBorder shadow = null;

	/**
	 * the constructor
	 */
	public CClassifierFigure() {
		super();
		setLayoutManager(new ClassifierLayoutManager());
		setForegroundColor(ColorConstants.blue);
		setBackgroundColor(ColorConstants.blue);
		shadow = new RectangularShadowBorder(2, getForegroundColor());
		setBorder(shadow);
	}

	/**
	 * get the container figure of the package
	 * 
	 * @return the container figure
	 */
	public RectangleFigure getAttributeElementContainer() {
		if (getSubFigure(attibuteContainerIndex) != null && getSubFigure(attibuteContainerIndex) instanceof RectangleFigure) {
			return ((RectangleFigure) getSubFigure(attibuteContainerIndex));
		}
		return null;
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ResizableCompartmentFigure getGMFAttributeElementContainer() {
		if (getAttributeElementContainer() != null) {
			if (getAttributeElementContainer().getChildren().size() > 0) {
				return (ResizableCompartmentFigure) getAttributeElementContainer().getChildren().get(0);
			}
		}
		return null;
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ResizableCompartmentFigure getGMFNestedClassifierContainer() {
		if (getNestedClassifierContainer() != null) {
			if (getNestedClassifierContainer().getChildren().size() > 0) {
				return (ResizableCompartmentFigure) getNestedClassifierContainer().getChildren().get(0);
			}
		}
		return null;
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ResizableCompartmentFigure getGMFOperationElementContainer() {
		if (getOperationElementContainer() != null) {
			if (getOperationElementContainer().getChildren().size() > 0) {
				return (ResizableCompartmentFigure) getOperationElementContainer().getChildren().get(0);
			}
		}
		return null;
	}

	public Color getGradientColor() {
		return getForegroundColor();
	}

	/**
	 * display is class is active
	 * 
	 * @return true is the class is active
	 */
	public boolean getisActive() {
		return isActive;
	}

	/**
	 * get the container figure of the package
	 * 
	 * @return the container figure
	 */
	public RectangleFigure getNestedClassifierContainer() {
		if (getSubFigure(nestedClassifierContainerIndex) != null && getSubFigure(nestedClassifierContainerIndex) instanceof RectangleFigure) {
			return ((RectangleFigure) getSubFigure(nestedClassifierContainerIndex));
		}
		return null;
	}

	/**
	 * get the container figure of the package
	 * 
	 * @return the container figure
	 */
	public RectangleFigure getOperationElementContainer() {
		if (getSubFigure(operationContainerIndex) != null && getSubFigure(operationContainerIndex) instanceof RectangleFigure) {
			return ((RectangleFigure) getSubFigure(operationContainerIndex));
		}
		return null;
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void paint(Graphics graphics) {
		Rectangle ContainerBound = new Rectangle(getBounds().x, getBounds().y, getBounds().width - 1, getBounds().height - 1);
		graphics.setForegroundColor(this.getGradientColor());
		graphics.setBackgroundColor(this.getBackgroundColor());
		graphics.fillGradient(ContainerBound, true);
		if (isActive) {
			graphics.setLineWidth(2);
			graphics.drawLine(new Point(getBounds().x + 1, getBounds().y), new Point(getBounds().x + 1, getBounds().y + getBounds().y + getBounds().height));
			graphics.drawLine(new Point(getBounds().x + getBounds().width - 2, getBounds().y), new Point(getBounds().x + getBounds().width - 2, getBounds().y + getBounds().y + getBounds().height));

			graphics.drawLine(new Point(getBounds().x + 5, getBounds().y), new Point(getBounds().x + 5, getBounds().y + getBounds().y + getBounds().height));
			graphics.drawLine(new Point(getBounds().x + getBounds().width - 6, getBounds().y), new Point(getBounds().x + getBounds().width - 6, getBounds().y + getBounds().y + getBounds().height));
			graphics.setLineWidth(1);
		}
		graphics.setForegroundColor(this.getForegroundColor());
		graphics.drawRectangle(ContainerBound);
		shadow.setColor(getForegroundColor());
		super.paint(graphics);
	}

	/**
	 * set the class active
	 * 
	 * @param isActive
	 *            true to display class as an active class
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

}
