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
package org.eclipse.emf.facet.custom.sdk.ui.internal.util.dialog.selection;

import org.eclipse.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.custom.sdk.ui.internal.util.dialog.AbstractGetCustomizationDialog;
import org.eclipse.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate.GetExtendedFacetWidget;
import org.eclipse.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate.GetFiltredExtendedFacetWidget;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;

/**
 * Concrete dialog for the selection of the extended facet.
 * 
 * @see GetExtendedFacetWidget
 */
public class GetExtendedFacetDialog extends
		AbstractGetCustomizationDialog<Facet, GetFiltredExtendedFacetWidget> {

	private GetFiltredExtendedFacetWidget extendedFacetW;

	/**
	 * Constructor.
	 * 
	 * @param properties
	 *            properties that parent widget had.
	 */
	public GetExtendedFacetDialog(
			final IWithResultDialogCallback<Facet> callback) {
		super(callback);
	}

	@Override
	protected GetFiltredExtendedFacetWidget createWidget() {
		this.extendedFacetW = new GetFiltredExtendedFacetWidget(
				this.getDialogComposite());
		return this.extendedFacetW;
	}

	@Override
	protected String getDialogMessage() {
		return Messages.GetOrCreate_customization_message;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Select_Customization;
	}

	@Override
	protected void okPressed() {
		if (this.extendedFacetW.getFacetSelected() != null) {
			getCallback().commited(this.extendedFacetW.getElementSelected());
		}
		super.okPressed();
	}

	@Override
	protected void execute() {
		getCallback().commited(this.extendedFacetW.getFacetSelected());
	}
}
