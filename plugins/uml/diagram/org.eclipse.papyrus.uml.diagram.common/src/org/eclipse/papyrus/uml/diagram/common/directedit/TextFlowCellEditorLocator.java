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
package org.eclipse.papyrus.uml.diagram.common.directedit;

import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.text.TextFlow;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Text;

/**
 * Locator of a cell editor for a Text Flow.
 */
final public class TextFlowCellEditorLocator implements CellEditorLocator {

	/**
	 * textflow to be edited.
	 */
	private final TextFlow figureToEdit;

	/**
	 * Creates a new TextFlowCellEditorLocator.
	 * 
	 * @param figureToEdit
	 *        The textflow to be edited.
	 */
	// @unused
	public TextFlowCellEditorLocator(TextFlow figureToEdit) {
		this.figureToEdit = figureToEdit;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.tools.CellEditorLocator#relocate(org.eclipse.jface.viewers
	 * .CellEditor)
	 */
	/**
	 * 
	 * 
	 * @param celleditor
	 */
	public void relocate(CellEditor celleditor) {
		Text text = (Text)celleditor.getControl();
		Point pref = text.computeSize(-1, -1);
		Rectangle rect = figureToEdit.getClientArea();
		figureToEdit.translateToAbsolute(rect);

		// add one more line to the bounds, so carriage return is taken into
		// account.
		// if the line is not added, pressing enter with nothing after the
		// cursor
		// makes the text scrolling, as a carriage return is not taken into the
		// original bounds.
		text.setBounds(rect.x - 4, rect.y - 1, pref.x + 1, pref.y + 1 + text.getLineHeight());
	}

}
