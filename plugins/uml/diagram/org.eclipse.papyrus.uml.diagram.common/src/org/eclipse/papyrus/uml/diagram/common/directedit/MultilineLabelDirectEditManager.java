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

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.papyrus.uml.diagram.common.figure.node.IMultilineEditableFigure;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * DirectEdit manager for multi lines label managed by a LabelControlerManager.
 * It is intended to be used in conjunction with LabelDirectEditPolicy and
 * LabelControler.
 */
public class MultilineLabelDirectEditManager extends TextDirectEditManager {

	protected boolean multiLine = false;

	/**
	 * Constructor.
	 * 
	 * @param source
	 * @param editorType
	 * @param locator
	 */
	@SuppressWarnings("unchecked")
	public MultilineLabelDirectEditManager(GraphicalEditPart source, Class editorType, CellEditorLocator locator) {
		super(source, editorType, locator);
		if(editorType != null && MultiLineCellEditor.class.isAssignableFrom(editorType)) {
			multiLine = true;
		}

	}

	/**
	 * @param source
	 *        the <code>GraphicalEditPart</code> that is used to determine
	 *        which <code>CellEditor</code> class to use.
	 * @return the <code>Class</code> of the <code>CellEditor</code> to use for
	 *         the text editing.
	 */
	public static Class getTextCellEditorClass(GraphicalEditPart source) {
		IFigure figure = source.getFigure();

		if(figure instanceof IMultilineEditableFigure) {
			return MultiLineCellEditor.class;
		} else {
			return TextDirectEditManager.getTextCellEditorClass(source);
		}
	}

	/**
	 * @see org.eclipse.gmf.runtime.diagram.ui.tools.TextDirectEditManager#createCellEditorOn(org.eclipse.swt.widgets.Composite)
	 * 
	 * @param composite
	 *        the editor on which to create the direct editor
	 * @return the cell editor
	 */
	@Override
	protected CellEditor createCellEditorOn(Composite composite) {
		if(multiLine) {
			// creates a new TextCell Editor, but with multiline support
			return new TextCellEditor(composite, SWT.MULTI | SWT.WRAP);
		}
		return super.createCellEditorOn(composite);

	}
}
