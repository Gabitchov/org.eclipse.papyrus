/*****************************************************************************
 * Copyright (c) 2009 Atos Origin.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Atos Origin - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.sequence.figures;

import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * The figure of the InteractionUse
 * 
 * Change super type to support displaying stereotypes, modified by [Jin Liu(jin.liu@soyatec.com)]
 */
public class InteractionUseRectangleFigure extends StereotypeInteractionFigure {

	/** A centered label */
	protected WrappingLabel centerLabel;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.papyrus.uml.diagram.sequence.figures.InteractionRectangleFigure#createContentPane()
	 */
	@Override
	protected RectangleFigure createContentPane() {
		// Create the ContentPane
		RectangleFigure contentPane = new RectangleFigure();
		contentPane.setOutline(false);
		contentPane.setFill(false);
		contentPane.setLayoutManager(new StackLayout());
		// Create the centered label
		centerLabel = new WrappingLabel();
		centerLabel.setAlignment(PositionConstants.CENTER);
		// Add the label to the contentPane
		contentPane.add(centerLabel);
		return contentPane;
	}

	public WrappingLabel getCenterLabel() {
		return centerLabel;
	}
}
