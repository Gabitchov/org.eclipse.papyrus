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

import org.eclipse.papyrus.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * A PropertyEditor for editing references through a Dialog
 * 
 * @see org.eclipse.papyrus.widgets.editors.ReferenceDialog
 * 
 * @author Camille Letavernier
 */
public class ReferenceDialog extends AbstractPropertyEditor {

	/**
	 * The ReferenceDialog widget
	 */
	protected org.eclipse.papyrus.widgets.editors.ReferenceDialog editor;

	/**
	 * The ValueFactory used to create or edit Objects directly from
	 * this editor
	 */
	protected ReferenceValueFactory factory;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 */
	public ReferenceDialog(Composite parent, int style) {
		editor = new org.eclipse.papyrus.widgets.editors.ReferenceDialog(parent, style);
		setEditor(editor);
	}

	@Override
	protected void doBinding() {
		IStaticContentProvider provider = input.getContentProvider(propertyPath);
		editor.setLabelProvider(input.getLabelProvider(propertyPath));
		editor.setContentProvider(provider);
		if(factory == null) { //Use the default factory from the DataSource
			editor.setValueFactory(input.getValueFactory(propertyPath));
		} else { //Use the factory explicitly specified
			editor.setValueFactory(factory);
		}

		super.doBinding();
	}

	/**
	 * Sets the ValueFactory used to create or edit Objects directly from
	 * this editor
	 * 
	 * @param factory
	 */
	public void setFactory(ReferenceValueFactory factory) {
		this.factory = factory;
		editor.setValueFactory(factory);
	}

	/**
	 * @return The ValueFactory used to create or edit Objects directly from
	 *         this editor
	 */
	public ReferenceValueFactory getFactory() {
		return factory;
	}

}
