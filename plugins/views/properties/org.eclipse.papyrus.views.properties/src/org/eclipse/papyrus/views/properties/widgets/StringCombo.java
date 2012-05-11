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
package org.eclipse.papyrus.views.properties.widgets;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.infra.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * A Property Editor for editing a String with an editable combo.
 * The combo proposes a set of default values.
 * 
 * @author Camille Letavernier
 */
public class StringCombo extends AbstractPropertyEditor {

	/**
	 * The StringCombo widget used by this property editor
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.StringCombo editor;

	/**
	 * 
	 * Constructor.
	 * 
	 * @param parent
	 * @param style
	 */
	public StringCombo(Composite parent, int style) {
		editor = createStringCombo(parent, style);
		super.setEditor(editor);
	}

	/**
	 * Creates the string combo dialog.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 * @return the string combo dialog.
	 */
	protected org.eclipse.papyrus.infra.widgets.editors.StringCombo createStringCombo(Composite parent, int style) {
		return new org.eclipse.papyrus.infra.widgets.editors.StringCombo(parent, style);
	}

	@Override
	public void doBinding() {
		IStaticContentProvider contentProvider = input.getContentProvider(propertyPath);
		editor.setContentProvider(contentProvider);
		editor.setUnsettable(!input.isMandatory(propertyPath));

		ILabelProvider labelProvider = input.getLabelProvider(propertyPath);
		if(labelProvider != null) {
			editor.setLabelProvider(labelProvider);
		}
		super.doBinding();
	}
}
