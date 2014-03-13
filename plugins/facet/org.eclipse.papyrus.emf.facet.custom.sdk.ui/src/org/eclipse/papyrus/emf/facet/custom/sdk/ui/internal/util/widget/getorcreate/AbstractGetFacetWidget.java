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
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate;

import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithButtonWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithDialogButtonWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * This class extends {@link AbstractGetOrCreateElementWithButtonWidget} and
 * display to the user a label with a textfield and a button to select the
 * customized facet.
 */
public abstract class AbstractGetFacetWidget<W extends Object> extends
		AbstractGetOrCreateElementWithDialogButtonWidget<Facet, W> {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param propertyElement
	 *            the property element that be edited with this composite.
	 * @param properties
	 *            the map of properties of the parent.
	 */
	public AbstractGetFacetWidget(final Composite parent,
			final PropertyElement2<Facet> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	protected String getTextFieldInitialText() {
		return this.getPropertyElement().getValue2().getName();
	}

	@Override
	public void notifyChanged() { // NOPMD by gdupe on 24/09/12 16:59
		// NOPMD This methods will be empty in all the sub classes of this class
		// No action has to be done if a change appends.
	}

	@Override
	protected void onCanceled() { // NOPMD by gdupe on 24/09/12 16:59
		// NOPMD This methods will be empty in all the sub classes of this class
		// Nothing to do.
	}

}
