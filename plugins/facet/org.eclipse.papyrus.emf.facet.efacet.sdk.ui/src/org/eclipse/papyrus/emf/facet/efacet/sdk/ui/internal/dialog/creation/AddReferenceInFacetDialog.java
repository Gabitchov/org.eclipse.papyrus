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
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IEStructuralFeatureWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedEStructuralFeatureWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.edition.EditFacetReferenceWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;

/**
 * Concrete Dialog for the creation of a Reference in a Facet.
 */
public class AddReferenceInFacetDialog extends
		AbstractEStructuralFeatureDialog<IEStructuralFeatureWidget> {

	/**
	 * Constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param selection
	 *            the selection in the model (ecore file).
	 */
	public AddReferenceInFacetDialog(final Facet facet,
			final EditingDomain editingDomain) {
		super(null, editingDomain, new PropertyElement2<Facet>(false, facet));
	}

	@Override
	protected IEStructuralFeatureWidget createWidget() {
		final EditFacetReferenceWidget widget = new EditFacetReferenceWidget(
				this.getDialogComposite(),
				EFacetFactory.eINSTANCE.createFacetReference(),
				this.getEditingDomain(), this.getContainerProperty(),
				this.getNameProperty(), this.getLowerBdProperty(),
				this.getUpperBdProperty(), this.getTypeProperty(),
				this.getOrderedProperty(), this.getUniqueProperty(),
				this.getQueryProperty(), this.getVolatileProperty(),
				this.getChangeableroperty(), this.getDerivedroperty(),
				this.getTransientProperty());
		return new SynchronizedEStructuralFeatureWidget(widget,
				widget.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.Add_a_Reference_desc;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Add_a_Reference;
	}

}
