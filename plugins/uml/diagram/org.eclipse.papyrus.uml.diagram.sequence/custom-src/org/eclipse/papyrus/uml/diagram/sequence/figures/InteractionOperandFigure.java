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

import org.eclipse.draw2d.Graphics;
import org.eclipse.papyrus.uml.diagram.common.figure.node.PapyrusNodeFigure;

public class InteractionOperandFigure extends PapyrusNodeFigure {

	/**
	 * True if line separator is printed
	 */
	private boolean lineSeparator = true;

	@Override
	public void paintFigure(Graphics graphics) {
		super.paintFigure(graphics);
		if(lineSeparator) {
			graphics.setLineStyle(getLineStyle());
			graphics.setLineWidth(getLineWidth());
			graphics.drawLine(getBounds().getTopLeft(), getBounds().getTopRight());
		}
	}

	/**
	 * Set the line separator
	 * 
	 * @param lineSeparator
	 */
	public void setLineSeparator(boolean lineSeparator) {
		this.lineSeparator = lineSeparator;
	}
}
