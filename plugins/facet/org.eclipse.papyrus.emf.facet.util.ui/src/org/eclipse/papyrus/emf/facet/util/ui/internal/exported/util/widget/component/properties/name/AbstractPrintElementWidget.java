/**
 * Copyright (c) 2012 Mia-Software.
 *  
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *  	Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 *  	Grégoire Dupé (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.properties.name;

import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.papyrus.emf.facet.util.ui.utils.UIUtils;
import org.eclipse.swt.widgets.Composite;

/**
 * This abstract class provide the creation of:</p>
 * 
 * Label : [//TextFiled//]</p>
 * 
 * Where the label is getted by {@link #getLabel()}. The textField is disabled
 * an initializated with the value of the {@link #getTextFieldInitialText()}.
 * 
 * @since 0.3
 */
public abstract class AbstractPrintElementWidget<T extends Object> extends
		AbstractGetOrCreateElementWidget<T> {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param editingDomain
	 *            the current editing domain.
	 */
	protected AbstractPrintElementWidget(final Composite parent,
			final PropertyElement2<T> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	protected void addSubWidgets() {
		if ((getLabel() != null) && !"".equals(getLabel())) { //$NON-NLS-1$
			UIUtils.createLabel(this, getLabel());
		}
		createTextField(false);
	}

	/**
	 * @return the label for this composite. If no label has to be displayed,
	 *         null or void must be returned.
	 */
	protected abstract String getLabel();
}
