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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.creation;

import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.core.FacetUtils;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.creation.AddOperationInFacetDialog;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractGetOrCreateFilteredElementCommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWidget;
import org.eclipse.swt.widgets.Composite;

/**
 * Concrete implementation of {@link AbstractGetOrCreateElementWidget}.</p>
 * 
 * This class allows to select an Operation or create a new one.
 */
public class GetOrCreateFiltredOperationWidget extends
		AbstractGetOrCreateFilteredElementCommandWidget<FacetOperation, IDerivedTypedElementWidget> {

	private final EditingDomain editingDomain;
	private final Facet context;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this widget.
	 * @param properties
	 *            the properties.
	 */
	public GetOrCreateFiltredOperationWidget(final Composite parent,
			final EditingDomain editingDomain, final Facet context) {
		super(parent);
		this.editingDomain = editingDomain;
		this.context = context;
	}

	@Override
	protected Map<String, FacetOperation> getElements() {
		final FacetSet parent = FacetUtils.getContainingFacetSet(this.context);
		final Map<String, FacetOperation> allOperations = FacetUtils
				.getAllOperationsByName(parent);
		return allOperations;
	}

	@Override
	protected IDialog<IDerivedTypedElementWidget> createDialog() {
		final Facet container = this.context;
		return new AddOperationInFacetDialog(container, this.editingDomain);
	}

	/**
	 * @return the selected operation in the filtredList.
	 */
	public FacetOperation getFacetOperationSelected() {
		return getElementSelected();
	}

	@Override
	public Command getCommand() {
		// Here, this widget only return a selected element so, no command is
		// returned.
		return null;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	public void onDialogValidation() {
		// Nothing.
	}
}
