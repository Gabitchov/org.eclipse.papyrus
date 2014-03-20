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
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.selection;

import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.AbstractGetCustomizationDialog;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate.GetFiltredOperationFacetWidget;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;

/**
 * Concrete dialog for the selection of a Customization. The Customization is an
 * operation into a particular facet.
 * 
 * @see GetFiltredOperationFacetWidget
 */
public class GetFacetOperationDialog extends
		AbstractGetCustomizationDialog<FacetOperation, GetFiltredOperationFacetWidget> {

	private GetFiltredOperationFacetWidget operationFacetW;
	private final Facet facet;

	/**
	 * Constructor.
	 * 
	 * @param properties
	 *            properties that parent widget had.
	 */
	public GetFacetOperationDialog(
			final IWithResultDialogCallback<FacetOperation> callback,
			final Facet facet) {
		super(callback);
		this.facet = facet;
	}

	@Override
	protected GetFiltredOperationFacetWidget createWidget() {
		this.operationFacetW = new GetFiltredOperationFacetWidget(
				this.getDialogComposite(), this.facet);
		return this.operationFacetW;
	}

	@Override
	protected String getDialogMessage() {
		return Messages.Get_customization_property_message;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Select_Customization_property;
	}

	@Override
	protected void okPressed() {
		if (this.operationFacetW.getFacetOperationSelected() != null) {
			this.getCallback().commited(
					this.operationFacetW.getFacetOperationSelected());
		}
		super.okPressed();
	}

	@Override
	protected void execute() {
		getCallback()
				.commited(this.operationFacetW.getFacetOperationSelected());
	}

}
