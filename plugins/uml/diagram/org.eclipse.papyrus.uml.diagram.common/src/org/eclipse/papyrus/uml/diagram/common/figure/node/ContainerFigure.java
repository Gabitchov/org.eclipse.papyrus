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
package org.eclipse.papyrus.uml.diagram.common.figure.node;

import org.eclipse.draw2d.ToolbarLayout;
import org.eclipse.swt.graphics.Color;

/**
 * Containe a list of element as attribute or operations.
 */
public class ContainerFigure extends NodeNamedElementFigure {

	/**
	 * 
	 */
	protected ContainerBorder border;

	/**
	 * 
	 */
	// @unused
	public ContainerFigure() {
		// this only a box
		// layout:
		ToolbarLayout layout = new ToolbarLayout(ToolbarLayout.VERTICAL);// to
		// add
		// element
		// vertically
		layout.setStretchMinorAxis(true);
		layout.setMinorAlignment(ToolbarLayout.ALIGN_TOPLEFT);
		int spacing = 0;
		layout.setSpacing(spacing);
		setLayoutManager(layout);
		// Add border to allow mouse over actions.

		border = new ContainerBorder(getBackgroundColor(), 5, 5, 5, 5, 20);
		setBorder(border);
	}

	/**
	 * 
	 * 
	 * @param backgroundColor
	 */
	@Override
	public void setBackgroundColor(Color backgroundColor) {
		super.setBackgroundColor(backgroundColor);
		border.setBorder(backgroundColor);
	}

}
