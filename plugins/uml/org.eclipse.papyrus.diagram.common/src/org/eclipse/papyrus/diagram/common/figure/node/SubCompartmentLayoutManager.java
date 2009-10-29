/****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *		Patrick Tessier (CEA LIST), Thibault Landre (Atos Origin) - Initial API and implementation
 *	
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.figure.node;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;

/**
 * this is the layout manager in charge to place element in compartment element
 * 
 */

public class SubCompartmentLayoutManager extends AbstractLayout {

	protected int MINIMUMCOMPARTMENTSIZE = 15;

	protected int preferedHeight = MINIMUMCOMPARTMENTSIZE;

	@Override
	protected Dimension calculatePreferredSize(IFigure container, int wHint, int hHint) {
		return new Dimension(10, preferedHeight);
	}

	public void layout(IFigure container) {
		int containersize = container.getChildren().size();
		for (int i = 0; i < container.getChildren().size(); i++) {
			Rectangle bound = new Rectangle(((IFigure) container.getChildren().get(i)).getBounds());
			bound.setSize(getPreferedSize(((IFigure) container.getChildren().get(i))));
			if (i > 0) {
				bound.y = ((IFigure) container.getChildren().get(i - 1)).getBounds().getBottomLeft().y + 1;
				bound.x = container.getBounds().x;
				bound.width = container.getBounds().width;
			} else {
				bound.x = container.getBounds().x;
				bound.y = container.getBounds().y;
				bound.width = container.getBounds().width;

			}
			((IFigure) container.getChildren().get(i)).setBounds(bound);
		}
		// container
		if (containersize > 0) {
			Rectangle lastRectangle = ((IFigure) container.getChildren().get(containersize - 1)).getBounds();
			lastRectangle.height = container.getBounds().y + container.getBounds().height - lastRectangle.y;
			lastRectangle.width = container.getBounds().width;
			((IFigure) container.getChildren().get(containersize - 1)).setBounds(lastRectangle);
		}
	}

	public Dimension getPreferedSize(IFigure figure) {
		Dimension dim = figure.getPreferredSize();
		if (figure.getChildren().size() > 0) {
			if (figure.getChildren().get(0) instanceof ResizableCompartmentFigure) {
				dim.height = ((ResizableCompartmentFigure) figure.getChildren().get(0)).getPreferredSize().height + 10;
				if (dim.height == 0) {
					dim.height = 20;
				}

			}
		}
		return dim;
	}

	/**
	 * Sets the constraint for the given figure.
	 * 
	 * @param child
	 *            the child
	 * @param constraint
	 *            the child's new constraint
	 */
	public void setConstraint(IFigure child, Object constraint) {
		if (constraint instanceof Rectangle && ((Rectangle) constraint).height > MINIMUMCOMPARTMENTSIZE) {
			preferedHeight = ((Rectangle) constraint).height;
		} else {
			preferedHeight = MINIMUMCOMPARTMENTSIZE;
		}
		System.err.println("SubComponent change position" + constraint);
		invalidate(child);
	}

}
