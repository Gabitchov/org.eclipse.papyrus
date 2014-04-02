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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.creation;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedENamedElementWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.edition.EditFacetSetWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;

/**
 * Concrete Dialog for the creation of a FacetSet in a FacetSet.
 */
public class CreateFacetSetInFacetSetDialog extends
		AbstractENamedElementDialog<
			FacetSet,
			IGetOrCreateFilteredFacetSetWidget,
			IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>
			> {

	private final PropertyElement2<String> facetNameProperty;
	private final PropertyElement2<FacetSet> facetSetProperty;

	/**
	 * Constructor.
	 * 
	 * @param shell
	 *            the parent shell.
	 * @param selection
	 *            the selection in the model (ecore file).
	 */
	public CreateFacetSetInFacetSetDialog(final FacetSet selection,
			final EditingDomain editingDomain) {
		super(selection, editingDomain);
		this.facetNameProperty = new PropertyElement2<String>(true);
		this.facetSetProperty = new PropertyElement2<FacetSet>(false);
		if (selection != null) {
			this.facetSetProperty.setValue2(selection);
		}
	}

	@Override
	protected String getDialogMessage() {
		return Messages.Create_facetSet_in_facetSet;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.CreateFacetSetWizardImpl_Create_new_facet_Set;
	}

	@Override
	protected IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget> createWidget() {
		final FacetSet editedFacetSet = EFacetFactory.eINSTANCE
				.createFacetSet();
		final EditFacetSetWidget widget = new EditFacetSetWidget(
				this.getDialogComposite(), editedFacetSet,
				this.getEditingDomain(), this.facetNameProperty,
				this.facetSetProperty);
		return new SynchronizedENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>(
				widget, widget.getDisplay());
	}

}
