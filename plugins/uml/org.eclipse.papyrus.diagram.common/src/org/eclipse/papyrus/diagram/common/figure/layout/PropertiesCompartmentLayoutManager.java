/*****************************************************************************
 * Copyright (c) 2010 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.figure.layout;

import java.util.List;

import org.eclipse.draw2d.AbstractLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;


public class PropertiesCompartmentLayoutManager extends AbstractLayout {

	protected static int MARGIN_X = 5;

	protected static int MARGIN_Y = 5;

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	protected Dimension calculatePreferredSize(IFigure container, int hint, int hint2) {

		int minimumWith = 0;
		int minimumHeight = 0;
		// display name
		for(int i = 0; i < container.getChildren().size(); i++) {
			minimumHeight = minimumHeight + ((IFigure)container.getChildren().get(i)).getPreferredSize().height + MARGIN_Y;
			minimumWith = Math.max(minimumWith, ((IFigure)container.getChildren().get(i)).getPreferredSize().width);
		}

		return new Dimension(minimumWith + MARGIN_X, minimumHeight + MARGIN_Y);
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public void layout(IFigure container) {
		List childrenList = container.getChildren();
		for(int i = 0; i < container.getChildren().size(); i++) {
			Rectangle bound = new Rectangle(((IFigure)childrenList.get(i)).getBounds());
			bound.setSize(((IFigure)childrenList.get(i)).getPreferredSize());
			if(i > 0) {
				bound.x = container.getBounds().x;
				bound.y = ((IFigure)childrenList.get(i - 1)).getBounds().getBottomLeft().y - 1;
				bound.width = container.getBounds().width;
				bound.height = bound.height + MARGIN_Y;
			} else {
				bound.x = container.getBounds().x;
				bound.y = container.getBounds().y;
				bound.width = container.getBounds().width;
				bound.height = bound.height + MARGIN_Y;

			}
			((IFigure)childrenList.get(i)).setBounds(bound);
		}

	}

}
