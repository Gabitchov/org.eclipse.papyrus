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
package org.eclipse.papyrus.properties.uml.widgets;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.papyrus.properties.uml.creation.ExpressionLanguageFactory;
import org.eclipse.papyrus.widgets.editors.MultipleValueEditor;
import org.eclipse.swt.widgets.Composite;


public class ExpressionLanguageEditor extends MultipleValueEditor {

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which this editor is created
	 * @param style
	 *        The style for this editor's list
	 * @param ordered
	 *        True if the list should be ordered
	 * @param unique
	 *        True if the list values should be unique
	 * @param label
	 *        The label for this editor
	 */
	public ExpressionLanguageEditor(Composite parent, int style) {
		super(parent, style, new LanguageSelector(), true, true, null);
		this.selector = super.selector;
	}

	@Override
	public void setReadOnly(boolean readOnly) {
		super.setReadOnly(readOnly);
		list.setEnabled(true); //The list is always enabled, to keep the selection-change event
	}

	@Override
	public void setModelObservable(IObservableList modelProperty) {
		super.setModelObservable(modelProperty);
		setFactory(new ExpressionLanguageFactory(modelProperty));
	}
}
