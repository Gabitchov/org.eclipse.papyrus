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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.properties.bounds;

import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.properties.bounds.AbstractGetBoundsWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Concrete implementation of {@link AbstractGetBoundsWidget} for the
 * LowerBound.
 */
public class GetLowerBoundWidget extends AbstractGetBoundsWidget {

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
	public GetLowerBoundWidget(final Composite parent,
			final PropertyElement2<Integer> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	protected String getLabel() {
		return Messages.Lower_bound;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	public String getError() {
		// A property widget is a Spinner, the default value of a Spinner is "0"
		// so the value can't be null.
		return null;
	}
}
