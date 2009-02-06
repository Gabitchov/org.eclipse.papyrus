/*****************************************************************************
 * Copyright (c) 2008 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Patrick Tessier (CEA LIST) Patrick.tessier@cea.fr - Initial API and implementation
 *
  *****************************************************************************/
package org.eclipse.papyrus.diagram.common.figure.node;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;

/**
 * this is the custom figure of the PrimitiveType
 * 
 * @author Patrick Tessier
 * @author <a href="mailto:jerome.benois@obeo.fr">Jerome Benois</a>
 */
public class CPrimitiveFigure extends CNamedElementFigure {

	/** the shadow **/
	private RectangularShadowBorder shadow = null;

	public CPrimitiveFigure() {
		super();
	}

	public Color getGradientColor() {
		return getForegroundColor();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public void paint(Graphics graphics) {
		Rectangle ContainerBound = new Rectangle(getBounds().x, getBounds().y, getBounds().width - 1, getBounds().height - 1);
		int height = 0;

		graphics.setForegroundColor(this.getGradientColor());
		graphics.setBackgroundColor(this.getBackgroundColor());
		graphics.fillGradient(ContainerBound, true);

		graphics.setForegroundColor(this.getForegroundColor());
		graphics.drawRectangle(ContainerBound);

		if(shadow==null){
			this.shadow = new RectangularShadowBorder(2, this.getForegroundColor());
			setBorder(shadow);
		}
		
		Rectangle elementBound = new Rectangle(getBounds().x, getBounds().y, 0, 0);
		// display stereotypes
		if (getElementStereotype() != null && getElementStereotype().getText().length() != 0) {
			elementBound.width = getBounds().width;
			elementBound.height = getElementStereotype().getPreferredSize().height;
			height += elementBound.height;
			getElementStereotype().setBounds(elementBound);
			graphics.pushState();
			getElementStereotype().setAlignment(PositionConstants.CENTER);
			getElementStereotype().layout();
			getElementStereotype().paint(graphics);
			graphics.popState();
		}
		// display name
		if (getElementName() != null) {
			elementBound.y += elementBound.height;
			elementBound.height = getElementName().getPreferredSize().height;
			height += elementBound.height;
			getElementName().setBounds(elementBound);
			graphics.pushState();
			getElementName().setAlignment(PositionConstants.CENTER);
			getElementName().layout();
			getElementName().paint(graphics);
			graphics.popState();
		}
		// display qualifiedName
		if (getElementQualifiedName() != null) {
			elementBound.y += elementBound.height;
			elementBound.height = getElementQualifiedName().getPreferredSize().height;
			getElementQualifiedName().setBounds(elementBound);
			graphics.pushState();
			getElementQualifiedName().setAlignment(PositionConstants.CENTER);
			getElementQualifiedName().layout();
			getElementQualifiedName().paint(graphics);
			graphics.popState();
			height += elementBound.height;
		}

		super.paintBorder(graphics);

	}

}
