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
package org.eclipse.papyrus.uml.diagram.common.figure.node;

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

	protected final static int MINIMUMCOMPARTMENTSIZE = 15;

	protected final static int MINIMUM_COMPARTMENT_WIDTH = 20;

	protected int preferedHeight = MINIMUMCOMPARTMENTSIZE;

	@Override
	protected Dimension calculatePreferredSize(IFigure figure, int wHint, int hHint) {
		Dimension dim = new Dimension(10, preferedHeight);
		if(!figure.getChildren().isEmpty()) {
			Object compartment = figure.getChildren().get(0);
			if(compartment instanceof ResizableCompartmentFigure) {
				Dimension compartmentPreferredSize = ((ResizableCompartmentFigure)compartment).getPreferredSize();
				dim.height = compartmentPreferredSize.height + 10;
				if(dim.height == 0) {
					dim.height = 20;
				}
				dim.width = compartmentPreferredSize.width;
			}
		}
		return dim;
	}
	
	@Override
	public Dimension getMinimumSize(IFigure container, int wHint, int hHint) {
		return new Dimension(MINIMUM_COMPARTMENT_WIDTH, MINIMUMCOMPARTMENTSIZE);
	}

	public void layout(IFigure container) {
		for(int i = 0; i < container.getChildren().size(); i++) {
			IFigure child = ((IFigure)container.getChildren().get(i));
			Rectangle bound = new Rectangle(child.getBounds());
			bound.setSize(getPreferedSize(child));
			bound.x = container.getBounds().x;
			bound.width = container.getBounds().width;
			if(i > 0) {
				bound.y = ((IFigure)container.getChildren().get(i - 1)).getBounds().getBottomLeft().y + 1;
			} else {
				bound.y = container.getBounds().y;
			}
			child.setBounds(bound);
		}
		// container
		int containersize = container.getChildren().size();
		if(containersize > 0) {
			IFigure lastChild = (IFigure)container.getChildren().get(containersize - 1);
			Rectangle lastRectangle = lastChild.getBounds();
			lastRectangle.height = container.getBounds().y + container.getBounds().height - lastRectangle.y;
			lastRectangle.width = container.getBounds().width;
			lastChild.setBounds(lastRectangle);
		}
	}

	public Dimension getPreferedSize(IFigure figure) {
		Dimension dim = new Dimension(10, preferedHeight);
		if(figure.getChildren().size() > 0) {
			if(figure.getChildren().get(0) instanceof ResizableCompartmentFigure) {
				dim.height = ((ResizableCompartmentFigure)figure.getChildren().get(0)).getPreferredSize().height + 10;
				if(dim.height == 0) {
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
	 *        the child
	 * @param constraint
	 *        the child's new constraint
	 */
	@Override
	public void setConstraint(IFigure child, Object constraint) {
		if(constraint instanceof Rectangle && ((Rectangle)constraint).height > MINIMUMCOMPARTMENTSIZE) {
			preferedHeight = ((Rectangle)constraint).height;
		} else {
			preferedHeight = MINIMUMCOMPARTMENTSIZE;
		}
		invalidate(child);
	}

}
