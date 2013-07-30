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
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;

/**
 * Figure for the display of the properties of stereotypes
 */
public class StereotypePropertiesCompartment extends RectangleFigure {

	protected boolean upperLine = true;

	public Dimension getPreferredSize(int wHint, int hHint) {
		//the calculus of the prefered size is contextual
		prefSize=null;
		return super.getPreferredSize(wHint,hHint);
	}

	/**
	 * {@inheritDoc}
	 */
	public void paint(Graphics graphics) {
		paintChildren(graphics);
		IFigure parentFigure = getParent();
		if(parentFigure instanceof PapyrusNodeFigure) {
			graphics.setForegroundColor(((PapyrusNodeFigure)parentFigure).getBorderColor());
			graphics.setBackgroundColor(((PapyrusNodeFigure)parentFigure).getBorderColor());
		}
		if(upperLine) {
			for(int i = 0; i < getChildren().size(); i++) {
				Point source = new Point(parentFigure.getBounds().x, ((IFigure)getChildren().get(i)).getBounds().getTopLeft().y);
				Point target = null;
				if(parentFigure instanceof PackageFigure) {
					target = new Point(((PackageFigure)(parentFigure)).getHeader().x + ((PackageFigure)(parentFigure)).getHeader().width, ((IFigure)getChildren().get(i)).getBounds().getTopRight().y);

				} else {
					target = new Point(parentFigure.getBounds().x + parentFigure.getBounds().width, ((IFigure)getChildren().get(i)).getBounds().getTopRight().y);
				}
				// graphics.setForegroundColor(ColorConstants.black);
				graphics.setLineWidth(1);
				if(!( parentFigure instanceof IEllipseFigure)){
					graphics.drawLine(source, target);
				}
			}
		}
	}

	/**
	 * used to display or not line upper the compartment stereotype
	 * 
	 * @param upperLine
	 *        true if we want to display
	 */
	public void setUpperLine(boolean upperLine) {
		this.upperLine = upperLine;
	}

}
