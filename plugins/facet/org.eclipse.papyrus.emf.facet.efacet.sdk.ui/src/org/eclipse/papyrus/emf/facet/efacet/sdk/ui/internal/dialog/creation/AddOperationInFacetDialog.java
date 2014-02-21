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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.creation;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedDerivedTypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.creation.AddOperationInFacetWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;

/**
 * Concrete dialog for the creation of an Operation in a facet.
 */
public class AddOperationInFacetDialog extends
		AbstractDerivedTypedElementDialog<IDerivedTypedElementWidget> {

	private final Facet facet;
	private final PropertyElement2<Facet> facetProperty;

	/**
	 * Constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param selection
	 *            the selection in the model (ecore file).
	 */
	public AddOperationInFacetDialog(final Facet facet,
			final EditingDomain editingDomain) {
		super(null, editingDomain);
		this.facet = facet;
		this.facetProperty = new PropertyElement2<Facet>(false, facet);
	}

	@Override
	protected IDerivedTypedElementWidget createWidget() {
		final AddOperationInFacetWidget widget = new AddOperationInFacetWidget(
				this.getDialogComposite(),
				this.getEditingDomain(), this.facetProperty,
				this.getNameProperty(),
				this.getLowerBdProperty(), this.getUpperBdProperty(),
				this.getTypeProperty(), this.getOrderedProperty(),
				this.getUniqueProperty(), this.getQueryProperty());
		return new SynchronizedDerivedTypedElementWidget(widget,
				widget.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.Add_an_Operation_desc;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Add_an_Operation;
	}

	protected Facet getFacet() {
		return this.facet;
	}

}
