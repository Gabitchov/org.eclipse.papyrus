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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.component.properties.name;

import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.properties.name.AbstractGetElementNameWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * The concrete implementation of {@link AbstractGetElementNameWidget} for the
 * Operation Name.
 * 
 * @see AbstractGetElementNameWidget
 */
public class GetOperationNameWidget extends AbstractGetElementNameWidget {

	public GetOperationNameWidget(final Composite parent,
			final PropertyElement2<String> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	protected String getLabel() {
		return Messages.Operation_name;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.Facet_mustGiveOperationName;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}
}
