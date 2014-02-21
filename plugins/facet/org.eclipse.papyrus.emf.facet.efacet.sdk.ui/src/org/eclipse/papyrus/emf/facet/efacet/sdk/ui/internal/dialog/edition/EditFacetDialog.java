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

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.creation.AbstractENamedElementDialog;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedFacetWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.edition.EditFacetWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;

/**
 * Widget for the edition of a {@link Facet}.
 */
public class EditFacetDialog extends
		AbstractENamedElementDialog<
			FacetSet,
			IGetOrCreateFilteredFacetSetWidget,
			IFacetWidget
		> {

	private final EditingDomain editingDomain;
	private final PropertyElement2<String> facetNameProperty;
	private final PropertyElement2<FacetSet> facetSetProperty;
	private final PropertyElement2<EClass> facetMetaclass;
	private final PropertyElement2<ETypedElement> conformProperty;

	/**
	 * Constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param selection
	 *            the selection in the model (ecore file).
	 */
	public EditFacetDialog(final Facet selection,
			final EditingDomain editingDomain) {
		super(selection, editingDomain);
		this.editingDomain = editingDomain;
		this.facetNameProperty = new PropertyElement2<String>(true);
		this.facetSetProperty = new PropertyElement2<FacetSet>(true);
		this.facetMetaclass = new PropertyElement2<EClass>(true);
		this.conformProperty = new PropertyElement2<ETypedElement>(true);
		if (selection != null) {
			// Get the first element of the selection
			this.facetNameProperty.setValue2(selection.getName());
			this.facetSetProperty.setValue2((FacetSet) selection.eContainer());
			this.facetMetaclass.setValue2(selection.getExtendedMetaclass());
			this.conformProperty.setValue2(selection
					.getConformanceTypedElement());
		}
	}

	@Override
	protected IFacetWidget createWidget() {
		final EditFacetWidget widget = new EditFacetWidget(
				this.getDialogComposite(), (Facet) getSelection(),
				this.editingDomain, this.facetNameProperty,
				this.facetSetProperty, this.conformProperty,
				this.facetMetaclass);
		return new SynchronizedFacetWidget(
				widget,
				widget.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.Edit_Facet;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Edit_Facet;
	}
}
