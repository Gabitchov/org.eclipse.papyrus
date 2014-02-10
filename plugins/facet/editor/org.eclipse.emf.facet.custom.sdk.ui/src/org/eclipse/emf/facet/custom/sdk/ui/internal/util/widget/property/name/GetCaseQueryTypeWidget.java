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
package org.eclipse.emf.facet.custom.sdk.ui.internal.util.widget.property.name;

import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.properties.name.AbstractPrintElementWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Display a textfield with the query type on it.
 */
public class GetCaseQueryTypeWidget extends
		AbstractPrintElementWidget<ETypedElement> {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param propertyElement
	 *            the property element that be edited with this composite.
	 */
	public GetCaseQueryTypeWidget(final Composite parent,
			final PropertyElement2<ETypedElement> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	protected String getLabel() {
		return Messages.Query_case_type;
	}

	@Override
	protected String getErrorMessage() {
		return null;
	}

	@Override
	protected String getTextFieldInitialText() {
		return this.getPropertyElement().getValue2().getName();
	}

	@Override
	public void notifyChanged() {
		// Nothing.
	}
}
