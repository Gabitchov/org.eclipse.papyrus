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
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.creation.AbstractENamedElementDialog;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedENamedElementWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.edition.EditFacetSetWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;

/**
 * Widget for the edition of a {@link FacetSet}.
 */
public class EditFacetSetDialog extends
		AbstractENamedElementDialog<FacetSet, IGetOrCreateFilteredFacetSetWidget, IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> {

	private final PropertyElement2<FacetSet> contrainerProp;
	private final FacetSet editedFacetSet;

	/**
	 * Constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param selection
	 *            the selection in the model (ecore file).
	 */
	public EditFacetSetDialog(final FacetSet selection,
			final EditingDomain editingDomain) {
		super(selection, editingDomain);
		this.editedFacetSet = selection;
		this.contrainerProp = new PropertyElement2<FacetSet>(true, true);
		this.contrainerProp.setValue2((FacetSet) selection.eContainer());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.Edit_FacetSet;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Edit_FacetSet;
	}

	@Override
	protected IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget> createWidget() {
		final EditFacetSetWidget widget = new EditFacetSetWidget(
				this.getDialogComposite(), this.editedFacetSet,
				this.getEditingDomain(), this.getNameProperty(),
				this.contrainerProp);
		return new SynchronizedENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>(
				widget, widget.getDisplay());
	}

}
