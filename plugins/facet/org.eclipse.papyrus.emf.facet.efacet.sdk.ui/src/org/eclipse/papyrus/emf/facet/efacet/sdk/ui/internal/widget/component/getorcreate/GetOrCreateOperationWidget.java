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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.component.getorcreate;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.composite.GetOrCreateOperationDialog;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithDialogButtonWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * This class provide the selection or the creation of a Operation.</p>
 * 
 * Operation : [ TextField ][...]</p>
 * 
 * The {@link GetOrCreateOperationDialog} dialog will be displayed when the
 * button is pressed.
 * 
 * @see GetOrCreateOperationDialog
 */
public class GetOrCreateOperationWidget extends
		AbstractGetOrCreateElementWithDialogButtonWidget<FacetOperation, IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>> {

	private final EditingDomain editingDomain;
	private final Facet context;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param facetOpProp
	 *            the property element that be edited with this composite.
	 * @param properties
	 *            the map of properties of the parent.
	 */
	public GetOrCreateOperationWidget(final Composite parent,
			final PropertyElement2<FacetOperation> facetOpProp,
			final EditingDomain editingDomain, final Facet context) {
		super(parent, facetOpProp);
		this.editingDomain = editingDomain;
		this.context = context;
	}

	@Override
	protected IDialog<IGetOrCreateFilteredElementCommmandWidget<FacetOperation, IDerivedTypedElementWidget>> getCreationDialog(
			final IWithResultDialogCallback<FacetOperation> callback) {
		return new GetOrCreateOperationDialog(callback, this.editingDomain,
				this.context);
	}

	@Override
	protected String getLabel() {
		return Messages.Operation;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.Operation_mustSelectOperation;
	}

	@Override
	protected String getTextFieldInitialText() {
		return this.getPropertyElement().getValue2().getName();
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
