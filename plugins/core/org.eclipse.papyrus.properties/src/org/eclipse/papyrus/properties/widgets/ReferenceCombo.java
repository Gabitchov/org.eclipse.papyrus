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

public class ReferenceCombo extends AbstractPropertyEditor {

	protected org.eclipse.papyrus.widgets.editors.ReferenceCombo combo;

	protected IStaticContentProvider provider;

	public ReferenceCombo(Composite parent, int style) {
		combo = new org.eclipse.papyrus.widgets.editors.ReferenceCombo(parent, style);
		super.setEditor(combo);
	}

	@Override
	protected void doBinding() {
		IStaticContentProvider contentProvider = input.getContentProvider(propertyPath);
		ILabelProvider labelProvider = input.getLabelProvider(propertyPath);

		combo.setProviders(contentProvider, labelProvider);

		super.doBinding();
	}

}
