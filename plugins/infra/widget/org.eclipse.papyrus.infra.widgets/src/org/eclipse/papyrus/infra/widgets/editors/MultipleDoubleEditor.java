/*****************************************************************************
 * Copyright (c) 2014 CEA LIST.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *****************************************************************************/
package org.eclipse.papyrus.infra.widgets.editors;


import org.eclipse.papyrus.infra.widgets.selectors.RealSelector;
import org.eclipse.swt.widgets.Composite;


public class MultipleDoubleEditor extends MultipleStringEditor {

	/**
	 * Constructs an Editor for multiple double values
	 * The widget is a List, with controls to move values up/down, add values
	 * and remove values.
	 *
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The List's style
	 */
	public MultipleDoubleEditor(Composite parent, int style) {
		super(parent, style, new RealSelector());
	}

	/**
	 * Constructs an Editor for multiple double values
	 * The widget is a List, with controls to move values up/down, add values
	 * and remove values.
	 *
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The List's style
	 * @param label
	 *        The editor's label
	 */
	public MultipleDoubleEditor(Composite parent, int style, String label) {
		super(parent, style, new RealSelector(), label);
	}

	/**
	 * Constructs an Editor for multiple double values
	 * The widget is a List, with controls to move values up/down, add values
	 * and remove values.
	 *
	 * @param parent
	 *        The Composite in which this editor is created
	 * @param style
	 *        The List's style
	 * @param ordered
	 *        Indicates if the values should be ordered. If true, the up/down controls will be activated
	 * @param unique
	 *        Indicates if the values should be unique.
	 * @param label
	 *        The editor's label
	 */
	public MultipleDoubleEditor(Composite parent, int style, boolean ordered, boolean unique, String label) {
		super(parent, style, new RealSelector(), ordered, unique, label);
	}

}
