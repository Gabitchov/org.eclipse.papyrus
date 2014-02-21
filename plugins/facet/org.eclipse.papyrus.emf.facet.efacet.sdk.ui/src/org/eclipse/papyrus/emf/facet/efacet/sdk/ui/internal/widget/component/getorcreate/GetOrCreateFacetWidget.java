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
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.composite.GetOrCreateFacetDialog;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithDialogButtonWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * This class provide the selection or the creation of a Facet.</p>
 * 
 * Facet : [ TextField ][...]</p>
 * 
 * The {@link GetOrCreateFacetDialog} dialog will be displayed when the button
 * is pressed.
 * 
 * @see GetOrCreateFacetDialog
 */
public class GetOrCreateFacetWidget extends
		AbstractGetOrCreateElementWithDialogButtonWidget<Facet, IGetOrCreateFilteredElementCommmandWidget<Facet, IFacetWidget>> {

	private final EditingDomain editingDomain;
	private final FacetSet container;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param facetProperty
	 *            the property element that be edited with this composite.
	 * @param container
	 * @param properties
	 *            the map of properties of the parent.
	 */
	public GetOrCreateFacetWidget(final Composite parent,
			final PropertyElement2<Facet> facetProperty,
			final EditingDomain editingDomain, final FacetSet container) {
		super(parent, facetProperty);
		this.editingDomain = editingDomain;
		this.container = container;
	}

	@Override
	protected String getLabel() {
		return Messages.Facet;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.Facet_mustSelectFacet;
	}

	@Override
	protected IDialog<IGetOrCreateFilteredElementCommmandWidget<Facet, IFacetWidget>> getCreationDialog(
			final IWithResultDialogCallback<Facet> callback) {
		return new GetOrCreateFacetDialog(callback, this.editingDomain,
				this.container);
	}

	@Override
	protected String getTextFieldInitialText() {
		return ((Facet) this.getPropertyElement().getValue()).getName();
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	protected void onCanceled() {
		// Nothing to do.
	}

}
