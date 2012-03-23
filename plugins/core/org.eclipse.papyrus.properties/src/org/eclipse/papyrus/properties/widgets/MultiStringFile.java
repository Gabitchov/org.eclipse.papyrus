/*****************************************************************************
 * Copyright (c) 2011 CEA LIST.
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

import org.eclipse.papyrus.widgets.editors.ICommitListener;
import org.eclipse.papyrus.widgets.editors.MultipleStringFileEditor;
import org.eclipse.swt.widgets.Composite;


public class MultiStringFile extends AbstractPropertyEditor {

	public MultipleStringFileEditor editor;

	public MultiStringFile(Composite parent, int style) {
		editor = createMultipleStringFileEditor(parent, style);
		setEditor(editor);
	}

	/**
	 * Creates the multiple string file editor
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the multiple string file editor.
	 */
	protected MultipleStringFileEditor createMultipleStringFileEditor(Composite parent, int style) {
		return new MultipleStringFileEditor(parent, style);
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
