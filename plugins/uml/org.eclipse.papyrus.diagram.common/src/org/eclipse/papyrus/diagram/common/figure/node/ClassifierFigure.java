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

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.papyrus.diagram.common.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

/**
 * this is the figure to represent a classifier.
 * 
 */
public class ClassifierFigure extends NodeNamedElementFigure {

	private static final int wrappedLabelSize = 18;

	private Label tagLabel;

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
			for (int i = 0; i < childrenList.size(); i++) {
				Rectangle bound = new Rectangle(((IFigure) childrenList.get(i)).getBounds());
				bound.setSize(((IFigure) childrenList.get(i)).getPreferredSize());
				bound.width = getBounds().width;
				if (i > 0) {
					bound.y = ((IFigure) childrenList.get(i - 1)).getBounds().getBottomLeft().y + 1;
					bound.x = getBounds().x;
				} else {
					bound.x = getBounds().x;
					bound.y = getBounds().y;

				}
				((IFigure) childrenList.get(i)).setBounds(bound);
			}

			Rectangle elementBound = new Rectangle(contentPane.getBounds());
			// display Attributes
			Rectangle attributeBound = new Rectangle(elementBound.getTopLeft().x, elementBound.getTopLeft().y, getBounds().width, 10);
			// getBounds().height-height);

			if (getGMFAttributeElementContainer() != null) {
				if (!getGMFAttributeElementContainer().isExpanded()) {
					attributeBound.height = 10;
				} else {
					attributeBound.height = wrappedLabelSize * (getGMFAttributeElementContainer().getContentPane().getChildren().size() + 1);
				}
			}
			// graphics.drawLine(elementBound.getBottomLeft(), elementBound.getBottomRight());
			propertyContent.setBounds(attributeBound);
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
			methodContent.setBounds(operationBound);
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
			nestedClassContent.setBounds(nestedClassifierBound);
			if (getGMFNestedClassifierContainer() != null) {
				getGMFNestedClassifierContainer().setBounds(nestedClassifierBound);
			}
			// fill the last compartment
			Rectangle lastRectangle = nestedClassContent.getBounds();
			lastRectangle.height = getBounds().y + getBounds().height - lastRectangle.y;
			nestedClassContent.setBounds(lastRectangle);
			if (getGMFNestedClassifierContainer() != null) {
				getGMFNestedClassifierContainer().setBounds(lastRectangle);
			}
			contentPane.getBounds().setSize(getBounds().width, getBounds().y + getBounds().height - contentPane.getBounds().y);
		}

	}

	/**
	 * Checks if is active.
	 * 
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the active.
	 * 
	 * @param active
	 *            the new active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/** The content pane. */
	private Figure contentPane;

	/* added for the container of nested classes */
	private RectangleFigure nestedClassContent;

	/* to present the class as an active class */
	/** The active. */
	private boolean active = false;

	/* this is the containe of properties */
	/** The property content. */
	private RectangleFigure propertyContent;

	/* this is the container of operations */
	/** The method content. */
	private RectangleFigure methodContent;

	/**
	 * this the constructor of a class figure.
	 */
	public ClassifierFigure() {
		super();

		this.setLayoutManager(new ClassifierLayoutManager());

		this.setOpaque(true); // non-transparent figure

		// The area accepting inner figures.
		this.createContentPane();

		this.setBackgroundColor(Activator.colorManager.get(new RGB(235, 248, 255)));
		this.setForegroundColor(Activator.colorManager.get(new RGB(177, 207, 229)));
		// this.setBorderColor(Activator.colorManager.get(new RGB(177, 207, 229)));
	}

	/**
	 * to obtain the property container of the class figure.
	 * 
	 * @return property container of the class figure
	 */
	public RectangleFigure getAttributeCompartmentFigure() {
		return this.propertyContent;
	}

	/**
	 * to obtain the method container of the class figure.
	 * 
	 * @return method container of the class figure
	 */
	public RectangleFigure getOperationCompartmentFigure() {
		return this.methodContent;
	}

	/**
	 * Get the inner figure accepting childs figure.
	 * 
	 * @return the contentPane of the class
	 */
	public IFigure getContentPane() {
		return this.contentPane;
	}

	/**
	 * used to create a container to add child figure in the class.
	 */

	protected void createContentPane() {
		this.contentPane = new Figure();
		contentPane.setOpaque(false);

		this.add(this.contentPane);
		methodContent = new RectangleFigure();
		propertyContent = new RectangleFigure();
		nestedClassContent = new RectangleFigure();
		contentPane.add(propertyContent);
		contentPane.add(methodContent);
		contentPane.add(nestedClassContent);
		methodContent.setFill(false);
		propertyContent.setFill(false);
		nestedClassContent.setFill(false);
		methodContent.setBorder(null);
		propertyContent.setBorder(null);
		nestedClassContent.setBorder(null);

	}

	/**
	 * to obtain the nested class container of the class figure
	 * 
	 */
	public RectangleFigure getNestedClassifierFigure() {
		return this.nestedClassContent;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Figure#paint(org.eclipse.draw2d.Graphics)
	 */
	/**
	 * Paint.
	 * 
	 * @param graphics
	 *            the graphics
	 */
	@Override
	public void paint(Graphics graphics) {
		super.paint(graphics);

		getGMFAttributeElementContainer().setOpaque(false);

		drawSeparateLine(graphics);

	}

	/**
	 * {@inheritDoc}
	 */
	/**
	 * Helper method to draw separation lines between name and compartements inside ClassifierFigure. It renders also the ClassifierFigure in case one represent an abstract or active class. This
	 * method is subject to be redefined in subclasses,
	 * 
	 * @param graphics
	 */
	protected void drawSeparateLine(Graphics graphics) {
		Figure fProperty, fMethod;

		// graphics.setForegroundColor(this.getBorderColor());
		graphics.setForegroundColor(ColorConstants.red);
		graphics.setBackgroundColor(this.getBorderColor());

		fProperty = this.getAttributeCompartmentFigure();
		fMethod = this.getOperationCompartmentFigure();

		/**
		 * y is used for store y-axis coordinates of seration lines between properties, methods and nested classes x is the x-axis coordinate of the left point of sepration lines w is the length of
		 * lines n is the number of lines to be drawn
		 */
		int y[] = { 0, 0, 0, 0 }, x = getBounds().x, w = getBounds().width, n = 0;

		/**
		 * Calculate the coordiates in the of separation lines for the non active classes
		 */

		y[0] = getBounds().y + this.getNameHeight();

		n++;

		if (fProperty != null) {
			Rectangle rect = fProperty.getBounds();
			y[n] = y[n - 1] + rect.height;
			n++;
		}

		if (fMethod != null) {
			Rectangle rect = fMethod.getBounds();
			y[n] = y[n - 1] + rect.height;
			n++;
		}
		/**
		 * If StereotypePropertiesContainer is present, we need draw a separate line between nestedclass container and StereotypePropertiesContainer
		 */
		if (this.getStereotypePropertiesContent() != null) {
			if (this.getNestedClassifierFigure() != null) {
				Rectangle rect = this.getNestedClassifierFigure().getBounds();
				y[n] = y[n - 1] + rect.height;
				n++;
			}
		}

		if (this.active == false) {
			for (int i = 0; i < n; i++) {
				// graphics.drawLine(x, y[i], x + w, y[i]);
			}
		}
		/**
		 * If the class if active, reduce the width figure by 4 for each size of separation lines
		 */
		if (this.active) {
			for (int i = 0; i < n; i++) {
				graphics.drawLine(x + 4, y[i], x + w - 4, y[i]);
			}

			// vertical lines for represents active
			Rectangle rect = this.getBounds().getCopy();
			graphics.setLineWidth(2);

			graphics.drawLine(rect.x + 1, rect.y, rect.x + 1, rect.y + rect.height);
			graphics.drawLine(rect.x + 4, rect.y, rect.x + 4, rect.y + rect.height);

			graphics.drawLine(rect.x + rect.width - 1, rect.y, rect.x + rect.width - 1, rect.y + rect.height);

			graphics.drawLine(rect.x + rect.width - 5, rect.y, rect.x + rect.width - 5, rect.y + rect.height);
		}

	}

	/**
	 * to display the Class as abstract.
	 * 
	 * @param b
	 *            yes for abstract no other
	 */
	public void setAbstract(boolean b) {

		if (b) {
			FontData[] font = { new FontData("Arial", 12, SWT.ITALIC | SWT.BOLD) };
			this.getNameLabel().setFont(Activator.fontManager.get(font));// italic
		} else {
			FontData[] font = { new FontData("Arial", 12, SWT.BOLD) };
			this.getNameLabel().setFont(Activator.fontManager.get(font));
		}
	}

	/**
	 * This method is used to create the tag label in the figure.
	 * 
	 * @param keyword
	 */
	protected void createTagLabel(String keyword) {
		FontData[] fontdata = { new FontData("Arial", 12, SWT.NORMAL) };
		Font font = Activator.fontManager.get(fontdata);
		Label label = new Label();
		label.setFont(font);
		label.setForegroundColor(getForegroundColor());
		label.setOpaque(false);
		label.setText(Activator.ST_LEFT + keyword + Activator.ST_RIGHT);
		// Add the tag label to the figure at the position 0
		this.add(label, 0);
		this.tagLabel = label;
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ResizableCompartmentFigure getGMFAttributeElementContainer() {
		if (propertyContent.getChildren().size() > 0) {
			return (ResizableCompartmentFigure) propertyContent.getChildren().get(0);
		}
		return null;
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ResizableCompartmentFigure getGMFNestedClassifierContainer() {

		if (nestedClassContent.getChildren().size() > 0) {
			return (ResizableCompartmentFigure) nestedClassContent.getChildren().get(0);
		}
		return null;
	}

	/**
	 * get the gmf container figure of the package
	 * 
	 * @return the gmf container
	 */
	public ResizableCompartmentFigure getGMFOperationElementContainer() {
		if (methodContent.getChildren().size() > 0) {
			return (ResizableCompartmentFigure) methodContent.getChildren().get(0);
		}
		return null;
	}

}
