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
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.editor.Activator;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.RGB;

/**
 * Figure to represent primitive types
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

	public PrimitiveTypeFigure() {
		this("PrimitiveType");
	}

	/**
	 * constructor to create a TaggedElementFigure.
	 * 
	 * @param keyword
	 */
	public PrimitiveTypeFigure(String keyword) {
		super();
		this.createTagLabel(keyword);
		ToolbarLayout layout = new ToolbarLayout();
		layout.setStretchMinorAxis(true);
		this.setLayoutManager(layout);

		this.setOpaque(true); // non-transparent figure
		this.setBackgroundColor(Activator.colorManager.get(new RGB(242, 242, 242)));
		// The area accepting inner figures.
		this.createContentPane(keyword);
	}

	/**
	 * returns a container to add some graphical element as label for instance.
	 * 
	 * @return a container to add some new graphical elements
	 */
	public IFigure getContentPane() {
		return this.contentPane;
	}

	/**
	 * this method is used to create the content figure.
	 * 
	 * @param keyword
	 */
	protected void createContentPane(String keyword) {
		this.contentPane = new Figure();
		ToolbarLayout layout = new ToolbarLayout();
		layout.setVertical(true);
		this.contentPane.setLayoutManager(layout);
		this.add(this.contentPane);
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
	 * Helper method to calculate the size of compartements inside a EnumerationFigure. This method is subject to redefined in the subclasses.
	 * 
	 * @param rect
	 */
	protected void calculateComponentBounds(Rectangle rect) {
		if (this.getStereotypePropertiesContent() != null) {
			int stereotypePropertiesHeight = rect.height - this.getNameHeight() - 5;
			this.getStereotypePropertiesContent().setPreferredSize(rect.width, stereotypePropertiesHeight);
		}
	}

	/**
	 * Helper method to draw separate line between name and stereotypes properties displays
	 * 
	 * @param graphics
	 */
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
	protected int getNameHeight() {
		return tagLabel.getTextBounds().height + super.getNameHeight();
	}
}