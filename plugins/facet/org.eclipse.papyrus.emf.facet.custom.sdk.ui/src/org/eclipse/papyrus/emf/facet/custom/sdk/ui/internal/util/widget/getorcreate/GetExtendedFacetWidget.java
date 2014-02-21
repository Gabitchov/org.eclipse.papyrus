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
package org.eclipse.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate;

import org.eclipse.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.custom.sdk.ui.internal.util.dialog.selection.GetExtendedFacetDialog;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithButtonWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * This class extends {@link AbstractGetOrCreateElementWithButtonWidget}. The
 * widget open the {@link GetExtendedFacetDialog} dialog when the button [...]
 * is pressed {@link #createDialog()}.
 */
public class GetExtendedFacetWidget extends
		AbstractGetFacetWidget<GetFiltredExtendedFacetWidget> {

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
	public GetExtendedFacetWidget(final Composite parent,
			final PropertyElement2<Facet> propertyElement) {
		super(parent, propertyElement);
	}

	@Override
	protected String getLabel() {
		return Messages.ExtendedFacet;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.Facet_mustSelectFacet;
	}

	@Override
	protected GetExtendedFacetDialog getCreationDialog(
			final IWithResultDialogCallback<Facet> callback) {
		return new GetExtendedFacetDialog(callback);
	}

}
