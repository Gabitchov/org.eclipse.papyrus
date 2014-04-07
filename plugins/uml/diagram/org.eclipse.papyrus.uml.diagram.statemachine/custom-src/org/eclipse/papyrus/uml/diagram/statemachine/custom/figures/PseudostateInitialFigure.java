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
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IPapyrusNodeUMLElementFigure;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;

public class PseudostateInitialFigure extends PapyrusNodeFigure implements IPapyrusNodeUMLElementFigure {

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
		return new Dimension(20, 20);
	}

	/**
	 * {@inheritDoc}
	 */
	public Label getStereotypesLabel() {
		return new Label();
	}

	//	public PseudostateInitialFigure() {
	//		super();
	//		Dimension dim1 = new Dimension(20, 20);
	//		this.setPreferredSize(new Dimension(dim1));
	//		this.setMaximumSize(new Dimension(dim1));
	//		this.setMinimumSize(new Dimension(dim1));
	//		this.setSize(dim1);
	//	}
	//
	//	/**
	//	 * Fills the circle.
	//	 * 
	//	 * @param graphics
	//	 *        the graphics
	//	 * 
	//	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	//	 */
	//	protected void fillShape(Graphics graphics) {
	//		graphics.pushState();
	//		graphics.setBackgroundColor(ColorConstants.black);
	//		graphics.fillOval(getBounds());
	//		graphics.popState();
	//
	//	}
	/**
	 * {@inheritDoc}
	 */
	public void paintFigure(Graphics graphics) {
		Rectangle r = getBounds().getCopy();
		graphics.setBackgroundColor(getForegroundColor());
		graphics.fillOval(r);
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStereotypeDisplay(String stereotypes, Image image) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStereotypePropertiesInBrace(String stereotypeProperties) {
	}

	/**
	 * {@inheritDoc}
	 */
	public void setStereotypePropertiesInCompartment(String stereotypeProperties) {
	}
}
