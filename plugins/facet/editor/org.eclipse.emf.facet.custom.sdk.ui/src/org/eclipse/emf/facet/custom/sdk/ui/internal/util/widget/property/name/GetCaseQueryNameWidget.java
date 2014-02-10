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
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.ETypedElementCase;
import org.eclipse.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.properties.name.AbstractPrintElementWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Display a textfield with the query name on it.
 */
public class GetCaseQueryNameWidget extends
		AbstractPrintElementWidget<ETypedElementCase> {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param propertyElement
	 *            the property element that be edited with this composite.
	 */
	public GetCaseQueryNameWidget(final Composite parent,
			final PropertyElement2<ETypedElementCase> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	protected String getLabel() {
		return Messages.Query_case_name;
	}

	@Override
	protected String getErrorMessage() {
		return null;
	}

	@Override
	protected String getTextFieldInitialText() {
		String result = "The object node cusomization"; //$NON-NLS-1$
		final ETypedElementCase eTECase = this.getPropertyElement().getValue2();
		final ETypedElement eTypedElement = eTECase.getCase();
		if (eTypedElement != null) {
			result = eTypedElement.getName();
		}
		return result;
	}

	@Override
	public void notifyChanged() {
		// Nothing.
	}


}
