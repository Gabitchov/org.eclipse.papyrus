/*****************************************************************************
 * Copyright (c) 2009 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Remi Schnekenburger (CEA LIST) - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.diagram.common.figure.node;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;

/**
 * Figure for the display of the properties of stereotypes
 */
public class StereotypePropertiesCompartment extends RectangleFigure {

	protected boolean upperLine=true;

	/**
	 * {@inheritDoc}
	 */
	public void paint(Graphics graphics) {
		paintChildren(graphics);
		graphics.setForegroundColor(getForegroundColor());
		if (upperLine){
		for(int i = 0; i < getChildren().size(); i++) {
			graphics.drawLine(((IFigure)getChildren().get(i)).getBounds().getTopLeft(), ((IFigure)getChildren().get(i)).getBounds().getTopRight());
		}
		}
	}
	/**
	 * used to display or not line upper the compartment stereotype
	 * @param upperLine true if we want to display
	 */
	public void setUpperLine(boolean upperLine){
		this.upperLine= upperLine;
	}

}
