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

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.FreeformLayer;
import org.eclipse.draw2d.FreeformLayout;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LineBorder;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.editor.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.FontData;

/**
 * this is the figure to represent a classifier.
 * 
 */

public class ClassifierFigure extends NodeNamedElementFigure {

	/** The content pane. */
	private Figure contentPane;

	/* to present the class as an active class */
	/** The active. */
	// private boolean active=false;
	/* this is the containe of properties */
	/** The property content. */
	private ContainerFigure propertyContent;

	/* this is the container of operations */
	/** The method content. */
	private ContainerFigure methodContent;

	/** The invisible container is a figure that used to detect the class figure with a layout */
	protected Figure invisibleContainer;

	/**
	 * this the constructor of a class figure.
	 */
	public ClassifierFigure() {
		super();
		ToolbarLayout layout = new ToolbarLayout();

		this.setLayoutManager(layout);
		layout.setSpacing(2);

		this.setOpaque(true); // non-transparent figure
		// setBorder( new LineBorder(ColorConstants.black));
		this.setBorder(new LineBorder(this.borderColor));

		// The area accepting inner figures.
		this.createContentPane();

		// the invisble container is created and it transparent*/
		this.invisibleContainer = new Figure();
		this.invisibleContainer.setOpaque(false);
		this.invisibleContainer = new FreeformLayer();
		this.invisibleContainer.setLayoutManager(new FreeformLayout());
		this.add(this.invisibleContainer);
	}

	// /**
	// * To display a class as active.
	// *
	// * @param b true if the clas is active
	// */
	// public void setActive(boolean b){
	// this.active=b;
	// }

	/**
	 * add the property container in the class figure.
	 * 
	 * @param propertyContent
	 *            the poperty container
	 */
	public void addpropertyContainer(ContainerFigure propertyContent) {
		this.propertyContent = propertyContent;
	}

	/**
	 * add the method container in the class figure.
	 * 
	 * @param methodContent
	 *            the method container
	 */
	public void addmethodContainer(ContainerFigure methodContent) {
		this.methodContent = methodContent;
	}

	/**
	 * to obtain the property container of the class figure.
	 * 
	 * @return property container of the class figure
	 */
	public ContainerFigure getPropertyContent() {
		return this.propertyContent;
	}

	/**
	 * to obtain the method container of the class figure.
	 * 
	 * @return method container of the class figure
	 */
	public ContainerFigure getMethodContent() {
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
		ToolbarLayout layout = new ToolbarLayout();
		layout.setVertical(true);
		this.contentPane.setLayoutManager(layout);
		this.add(this.contentPane);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Figure#setBounds(org.eclipse.draw2d.geometry.Rectangle)
	 */
	/**
	 * Sets the bounds.
	 * 
	 * @param rect
	 *            the rect
	 */
	@Override
	public void setBounds(Rectangle rect) {
		super.setBounds(rect);
		calculateComponentBounds(rect);
	}

	/**
	 *{@inheritDoc}
	 */
	protected void calculateComponentBounds(Rectangle rect) {

		int propertyHeight = 0;

		// ContainerFigure

		// calculate property Content size
		if (this.getPropertyContent() != null) {

			for (int i = 0; i < this.getPropertyContent().getChildren().size(); i++) {
				propertyHeight = propertyHeight + ((IFigure) this.getPropertyContent().getChildren().get(i)).getPreferredSize().height;
			}
			propertyHeight = propertyHeight + 2;
			if (propertyHeight < 15) {
				propertyHeight = 15;
			}
			this.getPropertyContent().setPreferredSize(rect.width, propertyHeight);// 30
		}
		// calculate the method content size by the same manner as property content size

		// calculate the size of stereotype properties content

		if (this.getStereotypePropertiesContent() != null) {
			int methodHeight = 0;
			if (this.getMethodContent() != null) {
				for (int i = 0; i < this.getMethodContent().getChildren().size(); i++) {
					methodHeight += ((IFigure) this.getMethodContent().getChildren().get(i)).getPreferredSize().height;
				}
				methodHeight += 2;
				if (methodHeight < 15) {
					methodHeight = 15;
				}
				this.getMethodContent().setPreferredSize(rect.width, methodHeight);
			}

			int stereotypeHeight = rect.height - this.getNameHeight() - propertyHeight - methodHeight;

			stereotypeHeight -= 5;// in order to fit the nested class container in the mother class figure
			this.getStereotypePropertiesContent().setPreferredSize(rect.width, stereotypeHeight);
		} else {
			if (this.getMethodContent() != null) {
				int methodHeight = rect.height - this.getNameHeight() - propertyHeight;

				methodHeight -= 5;
				this.getMethodContent().setPreferredSize(rect.width, methodHeight);
			}
		}
	}

	/**
	 * Gets the invible container.
	 * 
	 * @return the invible container
	 */
	public IFigure getInvibleContainer() {
		return invisibleContainer;
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
		drawSeparateLine(graphics);
	}

	/**
	 * {@inheritDoc}
	 */
	protected void drawSeparateLine(Graphics graphics) {
		Figure fProperty, fMethod;

		graphics.setForegroundColor(this.getBorderColor());
		graphics.setBackgroundColor(this.getBorderColor());

		fProperty = this.getPropertyContent();
		fMethod = this.getMethodContent();

		/**
		 * y is used for store y-axis coordinates of seration lines between properties, methods and nested classes x is the x-axis coordinate of the left point of sepration lines w is the length of
		 * lines n is the number of lines to be drawn
		 */
		int x = getBounds().x, w = getBounds().width;

		/**
		 * Calculate the coordiates in the of separation lines for the non active classes
		 */

		// draw a line below the name label
		int y = getBounds().y + this.getNameHeight();
		graphics.drawLine(x, y, x + w, y);

		if (fProperty != null) {
			Rectangle rect = fProperty.getBounds();
			y += rect.height;
			graphics.drawLine(x, y, x + w, y);
		}

		if (this.getStereotypePropertiesContent() != null) {
			Rectangle rect = fMethod.getBounds();
			y += rect.height;
			graphics.drawLine(x, y, x + w, y);
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
}
