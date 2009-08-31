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
package org.eclipse.papyrus.diagram.common.directedit;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;

/**
 * DirectEdit manager for multi lines label managed by a LabelControlerManager. It is intended to be
 * used in conjunction with LabelDirectEditPolicy and LabelControler.
 */
public class MultilineLabelDirectEditManager extends LabelDirectEditManager {

	/**
	 * Constructor.
	 * 
	 * @param locator
	 * @param labelCtrl
	 *            The label to edit
	 * @param source
	 *            The EditPart owning the label.
	 */
	public MultilineLabelDirectEditManager(GraphicalEditPart source, CellEditorLocator locator,
			ILabelControler labelCtrl) {
		super(source, locator, labelCtrl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.eclipse.gef.tools.DirectEditManager#createCellEditorOn(org.eclipse.swt.widgets.Composite)
	 */
	/**
	 * 
	 * 
	 * @param composite
	 * 
	 * @return
	 */
	@Override
	protected CellEditor createCellEditorOn(Composite composite) {
		// creates a new TextCell Editor, but with multiline support
		return new TextCellEditor(composite, SWT.MULTI | SWT.WRAP);
	}
}