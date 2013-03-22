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
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.papyrus.uml.diagram.common.figure.node.InteractionRectangleFigure;

public class CombinedFragmentFigure extends InteractionRectangleFigure {

	private WrappingLabel titleLabel;

	@Override
	protected void createContents() {
		add(createHeaderPane(), BorderLayout.TOP);
		add(createContentPane(), BorderLayout.CENTER);
		setShadow(false);
		interactionContentPane.setOutline(false);
		interactionContentPane.setOpaque(false);
		interactionContentPane.setBorder(null);
	}

	protected Figure createHeaderPane() {
		titleLabel = new WrappingLabel();
		titleLabel.setAlignment(PositionConstants.RIGHT);
		titleLabel.setBorder(new MarginBorder(3, 0, 0, 3));
		titleLabel.setTextWrap(false);
		IFigure leftContainer = super.createHeader();

		Figure headerPane = new Figure();
		headerPane.setLayoutManager(new BorderLayout());
		headerPane.add(leftContainer, BorderLayout.LEFT);
		headerPane.add(titleLabel, BorderLayout.RIGHT);

		return headerPane;
	}

	public WrappingLabel getTitleLabel() {
		return titleLabel;
	}
}
