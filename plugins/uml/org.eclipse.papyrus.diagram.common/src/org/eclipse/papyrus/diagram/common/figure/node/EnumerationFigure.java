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
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

/**
 * this is the figure to represent a classifier.
 * 
 */

public class EnumerationFigure extends NodeNamedElementFigure {

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
			// display Attribtutes
			Rectangle enumerationBound = new Rectangle(elementBound.getTopLeft().x, elementBound.getTopLeft().y, getBounds().width, 10);
			// getBounds().height-height);

			if (getGMFEnumerationElementContainer() != null) {
				if (!getGMFEnumerationElementContainer().isExpanded()) {
					enumerationBound.height = 10;
				} else {
					enumerationBound.height = wrappedLabelSize * (getGMFEnumerationElementContainer().getContentPane().getChildren().size() + 1);
				}
			}
			// graphics.drawLine(elementBound.getBottomLeft(), elementBound.getBottomRight());
			enumerationContent.setBounds(enumerationBound);
			if (getGMFEnumerationElementContainer() != null) {
				getGMFEnumerationElementContainer().setBounds(enumerationBound);
			}

			// fill the last compartment
			Rectangle lastRectangle = enumerationContent.getBounds();
			lastRectangle.height = getBounds().y + getBounds().height - lastRectangle.y;
			enumerationContent.setBounds(lastRectangle);
			if (getGMFEnumerationElementContainer() != null) {
				getGMFEnumerationElementContainer().setBounds(lastRectangle);
			}
			contentPane.getBounds().setSize(getBounds().width, getBounds().y + getBounds().height - contentPane.getBounds().y);
		}

	}

	/** The content pane. */
	private Figure contentPane;

	/* this is the containe of properties */
	/** The property content. */
	private RectangleFigure enumerationContent;

	/** The invisible container is a figure that used to detect the class figure with a layout */
	protected Figure invisibleContainer;

	/**
	 * @generated
	 */
	static final Color THIS_BACK = new Color(null, 235, 248, 255);

	/**
	 * @generated
	 */
	static final Color THIS_FORE = new Color(null, 177, 207, 229);

	/**
	 * this the constructor of a class figure.
	 */
	public EnumerationFigure() {
		super();
		this.createTagLabel("Enumeration");
		this.setLayoutManager(new ClassifierLayoutManager());

		this.setOpaque(true); // non-transparent figure

		// The area accepting inner figures.
		this.createContentPane();

		this.setBackgroundColor(Activator.colorManager.get(new RGB(235, 248, 255)));
		this.setForegroundColor(Activator.colorManager.get(new RGB(177, 207, 229)));
	}

	/**
	 * to obtain the property container of the class figure.
	 * 
	 * @return property container of the class figure
	 */
	public RectangleFigure getEnumerationLiteralCompartmentFigure() {
		return this.enumerationContent;
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

		this.add(this.contentPane);
		enumerationContent = new RectangleFigure();
		contentPane.add(enumerationContent);

	}

	public void setBackgroundColor(Color backgroundColor) {
		super.setBackgroundColor(backgroundColor);
		if (enumerationContent != null) {
			// propertyContent.setBorder(new LineBorder(backgroundColor));
			// methodContent.setBorder(new LineBorder(backgroundColor));
			// nestedClassContent.setBorder(new LineBorder(backgroundColor));

		}
	}

	/**
	 * Helper method to calculate the size of compartements inside a ClassifierFigure. This method is subject to redefined in the subclasses.
	 * 
	 * @param rect
	 */
	protected void calculateComponentBounds(Rectangle rect) {

		int propertyHeight = 0;
		System.err.println(rect + "\n contentPane " + contentPane.getBounds());

		// ContainerFigure

		// calculate property Content size
		if (this.getEnumerationLiteralCompartmentFigure() != null) {

			for (int i = 0; i < this.getEnumerationLiteralCompartmentFigure().getChildren().size(); i++) {
				propertyHeight = propertyHeight + ((IFigure) this.getEnumerationLiteralCompartmentFigure().getChildren().get(i)).getPreferredSize().height;
			}
			propertyHeight = propertyHeight + 2;
			if (propertyHeight < 15) {
				propertyHeight = 15;
			}
			this.getEnumerationLiteralCompartmentFigure().setLocation(contentPane.getLocation());
			this.getEnumerationLiteralCompartmentFigure().setPreferredSize(30, propertyHeight);
		}
	}

	/**
	 * Paint.
	 * 
	 * @param graphics
	 *            the graphics
	 */
	@Override
	public void paint(Graphics graphics) {
		enumerationContent.setFill(false);

		graphics.setForegroundColor(this.getGradientColor());
		graphics.setBackgroundColor(this.backgroundColor);
		if (getDisplayGradient()) {
			graphics.fillGradient(getBounds(), true);
		} else {
			graphics.fillRectangle(getBounds());
		}
		getGMFEnumerationElementContainer().setOpaque(false);

		super.paint(graphics);
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

		fProperty = this.getEnumerationLiteralCompartmentFigure();

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

	}

	/**
	 * to display the Class as abstract.
	 * 
	 * @param b
	 *            yes for abstract no other
	 */
	public void setAbstract(boolean b) {

		if (b) {
			FontData[] font = { new FontData(getfigureFont(), getFontSize(), SWT.ITALIC | SWT.BOLD) };
			this.getNameLabel().setFont(Activator.fontManager.get(font));// italic
		} else {
			FontData[] font = { new FontData(getfigureFont(), getFontSize(), SWT.BOLD) };
			this.getNameLabel().setFont(Activator.fontManager.get(font));
		}
	}

	/**
	 * This method is used to create the tag label in the figure.
	 * 
	 * @param keyword
	 */
	protected void createTagLabel(String keyword) {
		FontData[] fontdata = { new FontData(this.fontString, this.fontSize, SWT.NORMAL) };
		Font font = Activator.fontManager.get(fontdata);
		Label label = new Label();
		label.setFont(font);
		label.setForegroundColor(this.fontColor);
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
	public ResizableCompartmentFigure getGMFEnumerationElementContainer() {
		if (enumerationContent.getChildren().size() > 0) {
			return (ResizableCompartmentFigure) enumerationContent.getChildren().get(0);
		}
		return null;
	}

}
