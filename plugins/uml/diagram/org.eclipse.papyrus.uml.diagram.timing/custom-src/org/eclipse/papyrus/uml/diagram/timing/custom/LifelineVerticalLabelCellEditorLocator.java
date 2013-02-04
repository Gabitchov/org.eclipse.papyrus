/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.diagram.timing.custom;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.papyrus.uml.diagram.timing.custom.figures.LifelineVerticalLabel;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

public class LifelineVerticalLabelCellEditorLocator implements CellEditorLocator {

	private final LifelineVerticalLabel figure;

	public LifelineVerticalLabelCellEditorLocator(final LifelineVerticalLabel figure) {
		this.figure = figure;
	}

	public void relocate(final CellEditor celleditor) {
		final Text text = (Text)celleditor.getControl();
		// position the cell editor at the top of the vertical text
		final Rectangle rect = this.figure.getBounds().getCopy();
		rect.y -= text.getBounds().height + 5;
		this.figure.translateToAbsolute(rect);
		if(!text.getFont().isDisposed()) {
			final int avr = FigureUtilities.getFontMetrics(text.getFont()).getAverageCharWidth();
			rect.setSize(new Dimension(text.computeSize(SWT.DEFAULT, SWT.DEFAULT)).expand(avr * 2, 0));
		}
		if(!rect.equals(new Rectangle(text.getBounds()))) {
			text.setBounds(rect.x, rect.y, rect.width, rect.height);
		}

	}

}
