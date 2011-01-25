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

public class EnumRadio extends AbstractPropertyEditor {

	protected org.eclipse.papyrus.widgets.editors.EnumCombo enumCombo;

	public EnumRadio(Composite parent, int style) {
		super(new org.eclipse.papyrus.widgets.editors.EnumCombo(parent, style));
		enumCombo = (org.eclipse.papyrus.widgets.editors.EnumCombo)valueEditor;
	}

	@Override
	protected void doBinding() {
		enumCombo.setProviders(input.getContentProvider(propertyPath), null);

		super.doBinding();
	}
}
