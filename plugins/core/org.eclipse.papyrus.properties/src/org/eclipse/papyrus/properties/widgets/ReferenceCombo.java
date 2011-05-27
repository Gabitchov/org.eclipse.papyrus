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

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.papyrus.widgets.providers.IStaticContentProvider;
import org.eclipse.swt.widgets.Composite;

/**
 * A PropertyEditor for editing references through a ComboBox
 * 
 * @see org.eclipse.papyrus.widgets.editors.ReferenceCombo
 * 
 * @author Camille Letavernier
 */
public class ReferenceCombo extends AbstractPropertyEditor {

	/**
	 * The ReferenceCombo widget
	 */
	protected org.eclipse.papyrus.widgets.editors.ReferenceCombo combo;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *        The composite in which the widget will be displayed
	 * @param style
	 *        The style for the widget
	 */
	public ReferenceCombo(Composite parent, int style) {
		combo = new org.eclipse.papyrus.widgets.editors.ReferenceCombo(parent, style);
		super.setEditor(combo);
	}

	@Override
	protected void doBinding() {
		IStaticContentProvider contentProvider = input.getContentProvider(propertyPath);
		ILabelProvider labelProvider = input.getLabelProvider(propertyPath);

		combo.setProviders(contentProvider, labelProvider);
		combo.setUnsettable(!input.isMandatory(propertyPath));

		super.doBinding();
	}

}
