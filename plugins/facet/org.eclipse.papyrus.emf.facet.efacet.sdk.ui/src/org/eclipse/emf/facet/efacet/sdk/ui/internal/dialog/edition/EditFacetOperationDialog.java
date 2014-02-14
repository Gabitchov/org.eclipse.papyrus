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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.edition;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.creation.AbstractDerivedTypedElementDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedDerivedTypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.edition.EditFacetOperationWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;

/**
 * Widget for the edition of a {@link FacetOperation}.
 */
public class EditFacetOperationDialog extends
		AbstractDerivedTypedElementDialog<IDerivedTypedElementWidget> {

	private final FacetOperation fOperation;
	private final PropertyElement2<Facet> facetProperty;

	/**
	 * Constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param selection
	 *            the selection in the model (ecore file).
	 * @param editingDomain
	 *            the current editing model.
	 */
	public EditFacetOperationDialog(final FacetOperation fOperation,
			final EditingDomain editingDomain) {
		super(fOperation, editingDomain);
		this.fOperation = fOperation;
		this.facetProperty = new PropertyElement2<Facet>(false,
				(Facet) this.fOperation.eContainer());
	}

	@Override
	protected IDerivedTypedElementWidget createWidget() {
		final EditFacetOperationWidget widget = new EditFacetOperationWidget(
				this.getDialogComposite(),
				this.fOperation, this.getEditingDomain(), this.facetProperty,
				this.getNameProperty(), this.getLowerBdProperty(),
				this.getUpperBdProperty(), this.getTypeProperty(),
				this.getOrderedProperty(), this.getUniqueProperty(),
				this.getQueryProperty());
		return new SynchronizedDerivedTypedElementWidget(widget,
				widget.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.Edit_FacetOperation;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Edit_FacetOperation;
	}

}
