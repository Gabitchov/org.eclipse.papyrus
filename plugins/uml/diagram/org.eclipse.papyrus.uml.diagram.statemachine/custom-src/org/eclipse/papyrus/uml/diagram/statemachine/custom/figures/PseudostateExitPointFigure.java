/**
 * Copyright (c) 2014 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  CEA LIST - Initial API and implementation
 */
package org.eclipse.papyrus.uml.diagram.statemachine.custom.figures;

import java.util.Iterator;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.AffixedNamedElementFigure;

/**
 * PseudostateExitPointFigure.
 * 
 */
public class PseudostateExitPointFigure extends AffixedNamedElementFigure {
	/**
	 * Default Constructor.
	 */
	public PseudostateExitPointFigure() {
		super();
		Dimension dim1 = new Dimension(22, 22);
		this.setPreferredSize(new Dimension(dim1));
		this.setMaximumSize(new Dimension(dim1));
		this.setMinimumSize(new Dimension(dim1));
		this.setSize(dim1);
	}

	@Override
	public void paint(Graphics graphics) {
		graphics.pushState();
		IFigure ancestor = getParent();
		while ((ancestor != null) && !(ancestor instanceof RegionFigure))
			ancestor = ancestor.getParent();
		if (ancestor != null) {
			if (((RegionFigure) ancestor).getBorderColor() != null)
				graphics.setForegroundColor(((RegionFigure) ancestor).getBorderColor());
			if (((RegionFigure) ancestor).getBackgroundColor() != null)
				graphics.setBackgroundColor(((RegionFigure) ancestor).getBackgroundColor());
		} else {
			ancestor = getParent();
			Iterator<?> it = ancestor.getChildren().iterator();
			boolean found = false;
			while (it.hasNext() && !found) {
				ancestor = (IFigure) it.next();
				if (ancestor instanceof StateMachineFigure)
					found = true;
			}
			if (found) {
				if (((StateMachineFigure) ancestor).getBorderColor() != null)
					graphics.setForegroundColor(((StateMachineFigure) ancestor).getBorderColor());
				if (((StateMachineFigure) ancestor).getBackgroundColor() != null)
					graphics.setBackgroundColor(((StateMachineFigure) ancestor).getBackgroundColor());
			}
		}
		graphics.setLineWidth(1);
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getBounds());
		r.width -= 2;
		r.height -= 2;
		graphics.drawOval(r);
		r.shrink(1, 1);
		graphics.fillOval(r);
		// intersection coordinates.
		int x = (int) (bounds.width / (2 * Math.sqrt(2)));
		int y = (int) (bounds.height / (2 * Math.sqrt(2)));
		// cross.
		graphics.drawLine(bounds.getCenter().translate(x - 1, -y), bounds.getCenter().translate(-x, y - 2));
		graphics.drawLine(bounds.getCenter().translate(-x, -y), bounds.getCenter().translate(x - 1, y - 2));
		graphics.popState();
	}
}
