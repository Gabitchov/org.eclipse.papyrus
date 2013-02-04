/*******************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom.figures;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.graphics.Image;

public class LifelineFigure extends PapyrusNodeFigure implements IPapyrusNodeUMLElementFigure {

	protected final int LABEL_WIDTH = 30;

	protected RectangleFigure nameLabelContainerFigure;

	protected LifelineVerticalLabel nameLabel;

	protected RectangleFigure timeRulerContainerFigure;

	protected RectangleFigure lifelineDataContainerFigure;

	protected RectangleFigure timelineContainerFigure;

	private boolean selected;

	private boolean displayTimeRuler;

	public LifelineFigure() {
		setShadow(false);
		createContents();
		setLayoutManager(new AbstractLayout() {

			public void layout(final IFigure container) {
				final Rectangle clientArea = container.getClientArea();
				final List<?> children = container.getChildren();
				for(int i = 0; i < children.size(); i++) {
					final IFigure child = (IFigure)children.get(i);
					if(child == getNameLabelContainerFigure()) {
						child.setBounds(new Rectangle(clientArea.x, clientArea.y, LifelineFigure.this.LABEL_WIDTH, clientArea.height));
					} else if(child == getLifelineDataContainerFigure()) {
						child.setBounds(new Rectangle(clientArea.x + LifelineFigure.this.LABEL_WIDTH, clientArea.y, clientArea.width - LifelineFigure.this.LABEL_WIDTH, clientArea.height));
					}
				}
			}

			@Override
			protected Dimension calculatePreferredSize(final IFigure container, final int wHint, final int hHint) {
				return new Dimension(-1, -1);
			}
		});
	}

	protected void createContents() {
		// meant to be overridden
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.draw2d.Figure#setPreferredSize(org.eclipse.draw2d.geometry.Dimension)
	 */
	@Override
	public void setPreferredSize(final Dimension size) {
		final IFigure container = getParent();
		final int childrenSize = container.getChildren().size();
		final Rectangle containerRectangle = container.getBounds();
		final Rectangle resultBounds = new Rectangle(0, 0, containerRectangle.width(), containerRectangle.height() / childrenSize);
		this.prefSize = resultBounds.getSize();
	}

	public void setSelected(final boolean selected) {
		this.selected = selected;
	}

	@Override
	public void paintFigure(final Graphics graphics) {
		super.paintFigure(graphics);
		if(this.selected) {
			graphics.pushState();
			graphics.setForegroundColor(ColorConstants.black);
			graphics.setLineWidth(1);
			graphics.drawRectangle(getBounds().getShrinked(1, 1).resize(-1, -1));
			graphics.popState();
		}
	}

	public boolean isDisplayTimeRuler() {
		return this.displayTimeRuler;
	}

	public void setDisplayTimeRuler(final boolean visible) {
		this.displayTimeRuler = visible;
	}

	public LifelineVerticalLabel getLifelineLabelFigure() {
		return this.nameLabel;
	}

	public RectangleFigure getNameLabelContainerFigure() {
		return this.nameLabelContainerFigure;
	}

	public RectangleFigure getTimelineContainerFigure() {
		return this.timelineContainerFigure;
	}

	public RectangleFigure getTimeRulerContainerFigure() {
		return this.timeRulerContainerFigure;
	}

	public RectangleFigure getLifelineDataContainerFigure() {
		return this.lifelineDataContainerFigure;
	}

	public void setStereotypeDisplay(final String stereotypes, final Image image) {
		// TODO implement LifelineFigure#setStereotypeDisplay
	}

	public void setStereotypePropertiesInBrace(final String stereotypeProperties) {
		// TODO implement LifelineFigure#setStereotypePropertiesInBrace
	}

	public void setStereotypePropertiesInCompartment(final String stereotypeProperties) {
		// TODO implement LifelineFigure#setStereotypePropertiesInCompartment
	}

	public Label getStereotypesLabel() {
		return null;
	}
}
