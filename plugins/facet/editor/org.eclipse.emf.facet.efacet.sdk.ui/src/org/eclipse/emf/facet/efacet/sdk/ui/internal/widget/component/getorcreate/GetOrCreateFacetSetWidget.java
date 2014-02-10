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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.getorcreate;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.composite.GetOrCreateFacetSetDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.getorcreate.IGetOrCreateFacetSetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithDialogButtonWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * This class provide the selection or the creation of a FacetSet.</p>
 * 
 * FaceSet : [ TextField ][...]</p>
 * 
 * The {@link GetOrCreateFacetSetDialog} dialog will be displayed when the
 * button is pressed.
 * 
 * @see GetOrCreateFacetSetDialog
 */
public class GetOrCreateFacetSetWidget extends
		AbstractGetOrCreateElementWithDialogButtonWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>
		implements IGetOrCreateFacetSetWidget {

	private final EditingDomain editingdoamin;
	private final PropertyElement2<FacetSet> facetSetProperty;
	private final FacetSet reject;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param facetSetProperty
	 *            the property element that be edited with this composite.
	 * @param properties
	 *            the map of properties of the parent.
	 */
	public GetOrCreateFacetSetWidget(final Composite parent,
			final PropertyElement2<FacetSet> facetSetProperty,
			final EditingDomain editingDomain, final FacetSet reject) {
		super(parent, facetSetProperty);
		this.facetSetProperty = facetSetProperty;
		this.editingdoamin = editingDomain;
		this.reject = reject;
	}

	@Override
	protected IDialog<IGetOrCreateFilteredFacetSetWidget> getCreationDialog(
			final IWithResultDialogCallback<FacetSet> callback) {
		return new GetOrCreateFacetSetDialog(callback, this.editingdoamin,
				this.facetSetProperty, this.reject);
	}

	@Override
	protected String getLabel() {
		return Messages.FacetSet;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.FacetSet_mustSelectFacetSet;
	}

	@Override
	protected String getTextFieldInitialText() {
		return this.getPropertyElement().getValue2().getName();
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	public FacetSet getFacetSet() {
		return this.facetSetProperty.getValue2();
	}

	@Override
	protected void onCanceled() {
		// Nothing to do.
	}

}
