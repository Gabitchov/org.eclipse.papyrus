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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedFacetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.edition.EditFacetWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;

/**
 * Concrete Dialog for the creation of a Facet in a FacetSet.
 */
public class CreateFacetInFacetSetDialog
		extends
		AbstractENamedElementDialog<
			FacetSet,
			IGetOrCreateFilteredFacetSetWidget,
			IFacetWidget> {

	private final PropertyElement2<FacetSet> facetSetProp;
	private final PropertyElement2<String> facetNameProp;
	private final PropertyElement2<EClass> extEClassProp;
	private final PropertyElement2<ETypedElement> conformProp;

	/**
	 * Constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param selection
	 *            the selection in the model (ecore file).
	 */
	public CreateFacetInFacetSetDialog(final FacetSet selection,
			final EditingDomain editingDomain) {
		super(selection, editingDomain);
		this.facetSetProp = new PropertyElement2<FacetSet>(true);
		this.facetNameProp = new PropertyElement2<String>(true);
		this.extEClassProp = new PropertyElement2<EClass>(true);
		this.conformProp = new PropertyElement2<ETypedElement>(true);
		if (selection != null) {
			this.facetSetProp.setValue2(selection);
		}
	}

	@Override
	protected IFacetWidget createWidget() {
		final Facet facet = EFacetFactory.eINSTANCE.createFacet();
		final EditFacetWidget widget = new EditFacetWidget(
				this.getDialogComposite(), facet, this.getEditingDomain(),
				this.facetNameProp, this.facetSetProp, this.conformProp,
				this.extEClassProp);
		return new SynchronizedFacetWidget(widget, widget.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.CreateFacetInFacetSetWizardPage_wizard_description;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Create_facet_in_facetSet;
	}

}
