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
package org.eclipse.papyrus.views.properties.widgets;



import org.eclipse.papyrus.infra.widgets.editors.ICommitListener;
import org.eclipse.papyrus.infra.widgets.editors.MultipleDoubleEditor;
import org.eclipse.swt.widgets.Composite;

public class MultiDouble extends AbstractPropertyEditor {

	/**
	 * The MultipleDoubleEditor widget
	 */
	protected MultipleDoubleEditor editor;

	/**
	 * Constructor.
	 *
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 */
	public MultiDouble(Composite parent, int style) {
		editor = createMultipleDoubleEditor(parent, style);
		super.setEditor(editor);
	}

	/**
	 * Creates the multiple double editor.
	 *
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the multiple double editor.
	 */
	protected MultipleDoubleEditor createMultipleDoubleEditor(Composite parent, int style) {
		return new MultipleDoubleEditor(parent, style);
	}

	@Override
	protected void doBinding() {
		editor.setOrdered(input.isOrdered(propertyPath));
		editor.setUnique(input.isUnique(propertyPath));

		if(getInputObservableList() instanceof ICommitListener) {
			editor.addCommitListener((ICommitListener)getInputObservableList());
		}

		super.doBinding();
	}
}
