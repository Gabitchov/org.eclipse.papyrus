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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.edition;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.creation.AbstractEStructuralFeatureDialog;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IEStructuralFeatureWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedEStructuralFeatureWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.edition.EditFacetReferenceWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;

/**
 * Widget for the edition of a {@link FacetReference}.
 */
public class EditFacetReferenceDialog extends
		AbstractEStructuralFeatureDialog<IEStructuralFeatureWidget> {

	private final FacetReference facetReference;


	/**
	 * Constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param selection
	 *            the selection in the model (ecore file).
	 */
	public EditFacetReferenceDialog(final FacetReference facetReference,
			final EditingDomain editingDomain) {
		super(facetReference, editingDomain,  new PropertyElement2<Facet>(true,
				(Facet) facetReference.eContainer()));
		this.facetReference = facetReference;
	}

	@Override
	protected IEStructuralFeatureWidget createWidget() {
		final EditFacetReferenceWidget widget = new EditFacetReferenceWidget(
				this.getDialogComposite(), this.facetReference,
				this.getEditingDomain(), this.getContainerProperty(),
				this.getNameProperty(), this.getLowerBdProperty(),
				this.getUpperBdProperty(), this.getTypeProperty(),
				this.getOrderedProperty(), this.getOrderedProperty(),
				this.getQueryProperty(), this.getVolatileProperty(),
				this.getChangeableroperty(), this.getDerivedroperty(),
				this.getTransientProperty());
		return new SynchronizedEStructuralFeatureWidget(widget,
				widget.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.Edit_FacetReference;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Edit_FacetReference;
	}

}
