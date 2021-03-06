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

import org.eclipse.draw2d.Border;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class FinalStateFigure extends PapyrusNodeFigure implements IPapyrusNodeUMLElementFigure {
	/**
	 * {@inheritDoc}
	 */
	protected Border getDefaultBorder(Color borderColor) {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Dimension getPreferredSize(int wHint, int hHint) {
		// TODO Auto-generated method stub
		return new Dimension(20, 20);
	}

	/**
	 * {@inheritDoc}
	 */
	public Label getStereotypesLabel() {
		return new Label();
	}

	/**
	 * {@inheritDoc}
	 */
	public void paintFigure(Graphics graphics) {
		final int space = 3;
		Rectangle f = Rectangle.SINGLETON;
		// to be in adequation with the figure node plate
		Rectangle r = getBounds().getCopy().shrink(new Insets(0, 0, 1, 1));
		graphics.setBackgroundColor(getForegroundColor());
		graphics.setLineWidth(1);
		graphics.drawOval(r);
		f.x = r.x + space;
		f.y = r.y + space;
		f.width = r.width - space * 2 + 1;
		f.height = r.height - space * 2 + 1;
		graphics.setBackgroundColor(getForegroundColor());
		graphics.fillOval(f);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStereotypeDisplay(String stereotypes, Image image) {
		// TODO Auto-generated method stub
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
		// TODO Auto-generated method stub
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
		// TODO Auto-generated method stub
	}
}
