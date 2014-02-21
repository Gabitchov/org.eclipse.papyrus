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
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.getorcreate;

import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.dialog.selection.GetFacetOperationDialog;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IWithResultDialogCallback;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithButtonWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWithDialogButtonWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * This widget extends {@link AbstractGetOrCreateElementWithButtonWidget}.
 */
public class GetOperationFacetWidget
		extends
		AbstractGetOrCreateElementWithDialogButtonWidget<FacetOperation, GetFiltredOperationFacetWidget> {

	private final Facet facet;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param propertyElement
	 *            the property element that be edited with this composite.
	 * @param properties
	 *            the map of properties of the parent.
	 */
	public GetOperationFacetWidget(final Composite parent,
			final PropertyElement2<FacetOperation> propertyElement,
			final Facet facet) {
		super(parent, propertyElement);
		this.facet = facet;
	}

	@Override
	protected String getLabel() {
		return Messages.OperationFacet;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.OperationFacet_mustSelectOperationFacet;
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

	@Override
	protected GetFacetOperationDialog getCreationDialog(
			final IWithResultDialogCallback<FacetOperation> callback) {
		return new GetFacetOperationDialog(callback, this.facet);
	}

}
