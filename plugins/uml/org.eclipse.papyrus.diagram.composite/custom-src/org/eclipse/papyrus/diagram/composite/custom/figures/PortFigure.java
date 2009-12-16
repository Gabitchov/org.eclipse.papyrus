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

package org.eclipse.papyrus.diagram.composite.custom.figures;

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.papyrus.diagram.common.figure.node.NodeNamedElementFigure;
import org.eclipse.swt.graphics.Image;

/**
 * Figure for Port representation.
 */
public class PortFigure extends NodeNamedElementFigure {

	/** Container for icon (stereotype icon) */
	protected ImageFigure icon;

	/** Constructor */
	public PortFigure() {
		super();

		icon = new ImageFigure();
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
		getIconContainer().setImage(image);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAppliedStereotypeIcon(Image image) {
		setIcon(image);
	}

}
