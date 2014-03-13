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
package org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.widget;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.papyrus.emf.facet.query.ocl.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.properties.name.AbstractPrintElementWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the display of the expected type. Display a simple text field, not
 * editable with the type expected in it.
 */
public class PrintQueryContextWidget extends
		AbstractPrintElementWidget<EClassifier> {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this widget.
	 * @param propertyElement
	 *            the {@link PropertyElement} that this widget will edit.
	 */
	public PrintQueryContextWidget(final Composite parent,
			final PropertyElement2<EClassifier> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	protected String getLabel() {
		return Messages.Query_Context;
	}

	@Override
	public void notifyChanged() {
		// Nothing.
	}

	@Override
	protected String getErrorMessage() {
		return null;
	}

	@Override
	protected String getTextFieldInitialText() {
		return this.getPropertyElement().getValue2().getName();
	}

}
