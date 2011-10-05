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

import org.eclipse.swt.widgets.Composite;

/**
 * A PropertyEditor for editing enumerations through a ComboBox
 * 
 * @see org.eclipse.papyrus.widgets.editors.BooleanCheckbox
 * 
 * @author Camille Letavernier
 */
public class EnumCombo extends AbstractPropertyEditor {

	/**
	 * The EnumCombo widget
	 */
	protected org.eclipse.papyrus.widgets.editors.EnumCombo enumCombo;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 */
	public EnumCombo(Composite parent, int style) {
		super(new org.eclipse.papyrus.widgets.editors.EnumCombo(parent, style));
		enumCombo = (org.eclipse.papyrus.widgets.editors.EnumCombo)valueEditor;
	}

	/**
	 * @Problem : The different options come from input.
	 *          When we don't have an input (e.g. : during preview),
	 *          we don't have the different values, and we can't
	 *          display the correct preview.
	 * @TODO : Retrieve the values from the DataContext if possible.
	 */
	@Override
	protected void doBinding() {
		enumCombo.setProviders(input.getContentProvider(propertyPath), input.getLabelProvider(propertyPath));

		enumCombo.setUnsettable(!input.isMandatory(propertyPath));

		super.doBinding();
	}
}
