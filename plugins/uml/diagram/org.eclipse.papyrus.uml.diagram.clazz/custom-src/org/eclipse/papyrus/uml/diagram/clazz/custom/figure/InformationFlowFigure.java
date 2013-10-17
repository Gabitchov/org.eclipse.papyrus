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
package org.eclipse.papyrus.uml.diagram.clazz.custom.figure;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.edge.DashedEdgeFigure;

/**
 * Create an {@link InformationFlowFigure} with the tag <code>&laquo flow &raquo</code>
 * 
 */
public class InformationFlowFigure extends DashedEdgeFigure {

	/** Label displaying conveyed information */
	private WrappingLabel conveyedLabel;

	/** Get the label for conveyed information */
	public WrappingLabel getConveyedLabel() {
		return conveyedLabel;
	}

	@Override
	protected void createContents() {
		super.createContents();
		conveyedLabel = new WrappingLabel();
		conveyedLabel.setOpaque(false);
		conveyedLabel.setForegroundColor(getNameLabel().getForegroundColor());
		conveyedLabel.setFont(getNameLabel().getFont());
		add(conveyedLabel, 0);
	}
}
