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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/

package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Image;

/**
 * Figure for Affixed NamedElement representation. The name label is shown as an
 * external label.
 */
public class AffixedNamedElementFigure extends NodeNamedElementFigure {

	/** Container for icon (stereotype icon) */
	// protected ScalableImageFigure icon;
	protected ScaledImageFigure icon;

	/** Constructor */
	public AffixedNamedElementFigure() {
		super();

		// icon = new ScalableImageFigure(new Image(Display.getCurrent(), 2, 2));
		icon = new ScaledImageFigure();
		this.add(icon);

		BorderLayout layout = new BorderLayout();
		layout.setConstraint(icon, BorderLayout.CENTER);

		this.setLayoutManager(layout);
	}

	/**
	 * Get the figure containing the icon (for stereotype)
	 * 
	 * @return the image figure
	 */
	protected ImageFigure getIconContainer() {
		return icon;

	}

	/**
	 * Set the icon with a new image (for stereotype)
	 * 
	 * @param image
	 *        the new
	 */
	protected void setIcon(Image image) {
		icon.setImage(image);
		if(image == null) {
			icon.setScale(1.0);
			// icon.setImage(new Image(Display.getCurrent(), 2, 2));
			return;
		}

		Dimension imageDim = new Rectangle(image.getBounds()).getSize();
		int imageMax = imageDim.width;
		if(imageDim.height > imageMax) {
			imageMax = imageDim.height;
		}
		// size of enclosing box
		Dimension size = getParent().getBounds().getSize();

		if((imageDim.width >= size.width) || (imageDim.height >= size.height)) {
			// 5 = border width
			icon.setScale((size.width - 5.0) / imageMax);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAppliedStereotypeIcon(Image image) {
		setIcon(image);
	}

}
