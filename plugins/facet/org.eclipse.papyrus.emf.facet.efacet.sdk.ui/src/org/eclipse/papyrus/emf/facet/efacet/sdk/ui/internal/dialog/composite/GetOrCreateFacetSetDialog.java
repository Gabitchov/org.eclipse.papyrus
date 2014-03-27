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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.composite;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.sync.generated.SynchronizedGetOrCreateFilteredFacetSetWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.creation.GetOrCreateFiltredFacetSetWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;

/**
 * Provide a dialog where the user can select a facetSet in the existing
 * facetSets list or create a new one. This class use the specific widget
 * {@link GetOrCreateFiltredFacetSetWidget} and return the selected element with
 * the method {@link #getFacetSetSelected()}.</p>
 * 
 * When the "ok" button is pressed, the parent property is set with the selected
 * element.
 * 
 * @see GetOrCreateFiltredFacetSetWidget
 */
public class GetOrCreateFacetSetDialog extends
		AbstractComandExecDialog<FacetSet, IGetOrCreateFilteredFacetSetWidget> {

	private GetOrCreateFiltredFacetSetWidget gOCFacetSet; // gOC=getOrCreate
	private final EditingDomain editingDomain;
	private final PropertyElement2<FacetSet> facetSetProp;
	private final FacetSet reject;

	/**
	 * The constructor.
	 * 
	 * @param callback
	 *            the callback.
	 * @param properties
	 *            properties that parent widget had.
	 * @param reject
	 */
	public GetOrCreateFacetSetDialog(
			final IWithResultDialogCallback<FacetSet> callback,
			final EditingDomain editingDomain,
			final PropertyElement2<FacetSet> facetSetProp, final FacetSet reject) {
		super(callback, editingDomain);
		this.editingDomain = editingDomain;
		this.facetSetProp = facetSetProp;
		this.reject = reject;
	}

	/**
	 * Return the facetSet selected by the user.
	 * 
	 * @return the facetSet selected.
	 */
	public FacetSet getFacetSet() {
		return this.gOCFacetSet.getFacetSetSelected();
	}

	@Override
	protected IGetOrCreateFilteredFacetSetWidget createWidget() {
		this.gOCFacetSet = new GetOrCreateFiltredFacetSetWidget(
				this.getDialogComposite(), this.editingDomain,
				this.facetSetProp, this.reject);
		return new SynchronizedGetOrCreateFilteredFacetSetWidget(
				this.gOCFacetSet, this.gOCFacetSet.getDisplay());
	}

	@Override
	protected String getDialogMessage() {
		return Messages.GetOrCreate_FacetSet_message;
	}

	@Override
	protected String getDialogTitle() {
		return Messages.Select_FacetSet;
	}

	@Override
	protected void okPressed() {
		final FacetSet newValue = this.gOCFacetSet.getFacetSetSelected();
		if (newValue != null) {
			this.facetSetProp.setValue2(newValue);
		}
		super.okPressed();
	}

	@Override
	protected FacetSet getResult() {
		return this.gOCFacetSet.getFacetSetSelected();
	}
}
