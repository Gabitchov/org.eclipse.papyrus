/*****************************************************************************
 * Copyright (c) 2010 CEA LIST.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Camille Letavernier (CEA LIST) camille.letavernier@cea.fr - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.properties.widgets;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.papyrus.widgets.editors.ICommitListener;
import org.eclipse.papyrus.widgets.editors.MultipleStringEditor;
import org.eclipse.swt.widgets.Composite;

/**
 * A PropertyEditor for editing multiple strings in a list
 * 
 * @see org.eclipse.papyrus.widgets.editors.MultipleStringEditor
 * 
 * @author Camille Letavernier
 */
public class MultiString extends AbstractPropertyEditor {

	/**
	 * The MultipleStringEditor widget
	 */
	protected MultipleStringEditor editor;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 */
	public MultiString(Composite parent, int style) {
		editor = createMultipleStringEditor(parent, style);
		super.setEditor(editor);
	}

	/**
	 * Creates the multiple string editor
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the multiple string editor.
	 */
	protected MultipleStringEditor createMultipleStringEditor(Composite parent, int style) {
		return new MultipleStringEditor(parent, style);
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

	/**
	 * 
	 * @return the ListViewer associated to this editor
	 */
	public TreeViewer getViewer() {
		return editor.getViewer();
	}
}
