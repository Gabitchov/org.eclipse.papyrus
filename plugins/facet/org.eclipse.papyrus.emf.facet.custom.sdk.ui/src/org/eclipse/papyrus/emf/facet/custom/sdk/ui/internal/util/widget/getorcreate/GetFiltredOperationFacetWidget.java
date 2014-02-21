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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractGetOrCreateFilteredElementCommandWidget;
import org.eclipse.swt.widgets.Composite;

/**
 * This widget provide the selection of a {@link FacetOperation} available of
 * the selected {@link Facet}. The {@link Facet} is passed in the constructor
 * parameter.
 * <p/>
 * 
 * This widget extends {@link AbstractGetOrCreateFilteredElementCommandWidget}.
 * 
 * @see AbstractGetOrCreateFilteredElementCommandWidget
 */
public class GetFiltredOperationFacetWidget extends
		AbstractGetOrCreateFilteredElementCommandWidget<FacetOperation, Object> {

	private final Facet selectedFacet;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param facetOpProperty
	 * @param properties
	 *            the map of properties of the parent.
	 * @param facetOpProperty
	 */
	public GetFiltredOperationFacetWidget(final Composite parent,
			final Facet selectedFacet) {
		super(parent);
		this.selectedFacet = selectedFacet;
	}

	@Override
	protected Map<String, FacetOperation> getElements() {
		final Map<String, FacetOperation> allFacetOpes = new HashMap<String, FacetOperation>();
		for (final Facet facet : this.selectedFacet.getExtendedFacets()) {
			for (final FacetOperation operation : facet.getFacetOperations()) {
				allFacetOpes.put(operation.getName(), operation);
			}
		}
		return allFacetOpes;
	}

	@Override
	protected IDialog<Object> createDialog() {
		// No "New..." button.
		return null;
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

	/**
	 * @return
	 */
	public FacetOperation getFacetOperationSelected() {
		return getElementSelected();
	}

}
