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
 */
package org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.properties;

import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.properties.AbstractGetPropertyWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.swt.widgets.Composite;

/**
 * Concrete implementation of {@link AbstractGetPropertyWidget} for the
 * Derived property.
 */
public class GetDerivedWidget extends AbstractGetPropertyWidget {

	/**
	 * Constructor. 
	 * 
	 * @param parent
	 *            the parent containing this composite.
	 * @param style
	 *            the style of the composite.
	 * @param propertyElement
	 *            the property element that this composite will edit.
	 */
	public GetDerivedWidget(final Composite parent,
			final PropertyElement propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	protected String getLabel() {
		return Messages.Derived;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	public String getError() {
		// A property widget is a checkbox, so the values can be "true" or
		// "false" so, no error can be throws because a value will be always
		// put.
		return null;
	}
}
