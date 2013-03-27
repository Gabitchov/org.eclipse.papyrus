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
package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.papyrus.infra.widgets.creation.ReferenceValueFactory;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * A PropertyEditor for editing references through a Dialog
 * 
 * @see org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog
 * 
 * @author Camille Letavernier
 */
public class ReferenceDialog extends AbstractPropertyEditor {

	/**
	 * The ReferenceDialog widget
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog editor;

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
		editor = createReferenceDialog(parent, style);
		setEditor(editor);
	}

	/**
	 * Creates the reference dialog.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the reference dialog.
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog createReferenceDialog(Composite parent, int style) {
		return new org.eclipse.papyrus.infra.widgets.editors.ReferenceDialog(parent, style);
	}

	@Override
	protected void doBinding() {
		IStaticContentProvider provider = input.getContentProvider(propertyPath);
		editor.setLabelProvider(input.getLabelProvider(propertyPath));
		editor.setContentProvider(provider);
		editor.setDirectCreation(input.getDirectCreation(propertyPath));
		editor.setMandatory(input.isMandatory(propertyPath));
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
