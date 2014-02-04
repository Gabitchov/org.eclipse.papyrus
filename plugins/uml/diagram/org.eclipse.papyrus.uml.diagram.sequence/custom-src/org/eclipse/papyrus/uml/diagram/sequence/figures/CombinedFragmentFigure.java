/*****************************************************************************
 * Copyright (c) 2009 CEA
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

import org.eclipse.draw2d.BorderLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;

/**
 * Change super type to support displaying stereotypes, modified by [Jin Liu(jin.liu@soyatec.com)]
 */
public class CombinedFragmentFigure extends StereotypeInteractionFigure {

	private WrappingLabel titleLabel;
	private RectangleFigure header;

	@Override
	protected void createContents() {
		super.createContents();
		setShadow(false);
		interactionContentPane.setOutline(false);
		interactionContentPane.setOpaque(false);
		interactionContentPane.setBorder(null);
	}

	@Override
	protected RectangleFigure createHeader() {
		header = super.createHeader();
		titleLabel = new WrappingLabel();
		titleLabel.setAlignment(PositionConstants.RIGHT);
		titleLabel.setBorder(new MarginBorder(3, 0, 0, 3));
		titleLabel.setTextWrap(false);
		header.add(titleLabel, BorderLayout.RIGHT);
		return header;
	}

	public WrappingLabel getTitleLabel() {
		return titleLabel;
	}
	
	public IFigure getHeaderContainer(){
		return header;
	}
}
