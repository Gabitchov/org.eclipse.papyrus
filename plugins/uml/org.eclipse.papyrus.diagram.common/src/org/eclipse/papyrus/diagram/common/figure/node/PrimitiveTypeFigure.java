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
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.draw2d.geometry.Dimension;

/**
 * Figure to represent primitive types
 * 
 */
public class PrimitiveTypeFigure extends NodeNamedElementFigure {

	/**
	 * The content pane.
	 */
	private Figure contentPane;

	/**
	 * 
	 */
	private Label tagLabel;

	/**
	 * constructor to create a TaggedElementFigure.
	 * 
	 * @param keyword
	 */
	public PrimitiveTypeFigure() {
		super("PrimitiveType");
		ToolbarLayout layout = new ToolbarLayout();
		layout.setStretchMinorAxis(true);
		this.setLayoutManager(layout);

		this.setOpaque(true); // non-transparent figure
		// The area accepting inner figures.
		createContentPane();
	}

	/**
	 * returns a container to add some graphical element as label for instance.
	 * 
	 * @return a container to add some new graphical elements
	 */
	// @unused
	public IFigure getContentPane() {
		return this.contentPane;
	}

	/**
	 * this method is used to create the content figure.
	 * 
	 */
	protected void createContentPane() {
		contentPane = new Figure();
		ToolbarLayout layout = new ToolbarLayout();
		layout.setVertical(true);
		this.contentPane.setLayoutManager(layout);
		this.add(this.contentPane);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cea.papyrus.core.common.figures.NodeFigure#getIconLabelPosition()
	 */
	/**
	 * 
	 * 
	 * @return
	 */
	@Override
	protected int getIconLabelPosition() {
		return 1;
	}

	@Override
	public Dimension getMinimumDimension() {
		int width = tagLabel.getTextBounds().width + 10;
		int height = tagLabel.getTextBounds().height + 10;
		Dimension dim = super.getMinimumDimension();
		dim.height += height;
		if (dim.width < width) {
			dim.width = width;
		}
		return dim;

	}

	/**
	 * Helper method to draw separate line between name and stereotypes properties displays
	 * 
	 * @param graphics
	 */
	// @unused
	protected void drawSeparateLine(Graphics graphics) {
		graphics.setForegroundColor(getBorderColor());
		graphics.setBackgroundColor(getBorderColor());

		if (this.getStereotypePropertiesContent() != null) {
			int x = getBounds().x, w = getBounds().width;

			// draw a line below name label
			int y = getBounds().y + this.getNameHeight();

			graphics.drawLine(x, y, x + w, y);
		}

	}

	/**
	 * Helper method to calculate the height of name
	 */
	@Override
	protected int getNameHeight() {
		return tagLabel.getTextBounds().height + super.getNameHeight();
	}
}