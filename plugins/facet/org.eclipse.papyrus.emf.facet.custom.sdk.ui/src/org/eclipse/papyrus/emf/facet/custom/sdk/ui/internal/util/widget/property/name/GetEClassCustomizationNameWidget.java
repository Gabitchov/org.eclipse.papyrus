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
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.property.name;

import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.properties.name.AbstractGetElementNameWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Display a textfield with the customization name on it.
 */
public class GetEClassCustomizationNameWidget extends
		AbstractGetElementNameWidget {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param propertyElement
	 *            the property element that be edited with this composite.
	 */
	public GetEClassCustomizationNameWidget(final Composite parent,
			final PropertyElement2<String> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	protected String getLabel() {
		return Messages.Customization;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.Customization_mustGiveCustomizationName;
	}

	@Override
	protected String getTextFieldInitialText() {
		return (String) this.getPropertyElement().getValue();
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

}
