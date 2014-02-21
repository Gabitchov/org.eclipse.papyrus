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
package org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.properties.name;

import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.emf.facet.util.ui.utils.UIUtils;
import org.eclipse.swt.widgets.Composite;

/**
 * This abstract class provide the creation of:</p>
 * 
 * Label : [ TextFiled ]</p>
 * 
 * Where the label is getted by {@link #getLabel()}. The TextField will set the
 * value of the {@link PropertyElement} when edited. If the field is not setted,
 * an error will be displayed at the top of the dialog when the 'ok' button is
 * pressed.
 * 
 * @see GetAttributeNameWidget
 * @see GetFacetNameWidget
 * @see GetFacetSetNameWidget
 * @see GetOperationNameWidget
 * @see GetReferenceNameWidget
 * @see GetQueryNameWidget
 * @since 0.3
 */
public abstract class AbstractGetElementNameWidget extends
		AbstractGetOrCreateElementWidget<String> {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param editingDomain
	 *            the current editing domain.
	 * @param propertyElement
	 *            the property element that be edited with this composite.
	 */
	protected AbstractGetElementNameWidget(final Composite parent,
			final PropertyElement2<String> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	protected void addSubWidgets() {
		if ((getLabel() != null) && !"".equals(getLabel())) { //$NON-NLS-1$
			UIUtils.createLabel(this, getLabel());
		}
		createTextField(this.getPropertyElement().isChangeable());
	}

	/**
	 * @return the label for this composite. If no label has to be displayed,
	 *         null or empty string must be returned.
	 */
	protected abstract String getLabel();

	@Override
	public String getError() {
		String result = null;
		final String elementName = this.getPropertyElement().getValue2();
		if ((elementName == null) || "".equals(elementName)) { //$NON-NLS-1$
			result = getErrorMessage();
		}
		return result;
	}

	/**
	 * @return the error message.
	 */
	@Override
	protected abstract String getErrorMessage();
}
