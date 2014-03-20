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
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.creation.CreateFacetInFacetSetDialog;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractGetOrCreateFilteredElementCommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWidget;
import org.eclipse.swt.widgets.Composite;

/**
 * Concrete implementation of {@link AbstractGetOrCreateElementWidget}.</p>
 * 
 * This class allows to select a Facet or create a new one.
 */
public class GetOrCreateFiltredFacetWidget extends
		AbstractGetOrCreateFilteredElementCommandWidget<Facet, IFacetWidget> {

	private final EditingDomain editingDomain;
	private final FacetSet container;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this widget.
	 * @param properties
	 *            the properties.
	 */
	public GetOrCreateFiltredFacetWidget(final Composite parent,
			final EditingDomain editingDomain, final FacetSet container) {
		super(parent);
		this.editingDomain = editingDomain;
		this.container = container;
	}

	@Override
	protected Map<String, Facet> getElements() {
		final FacetSet parent = FacetUtils
				.getContainingFacetSet(this.container);
		final Map<String, Facet> allFacets = FacetUtils
				.getAllFacetsByName(parent);
		final Object name = this.container.getName();
		allFacets.remove(name);
		return allFacets;
	}

	@Override
	protected IDialog<IFacetWidget> createDialog() {
		return new CreateFacetInFacetSetDialog(this.container,
				this.editingDomain);
	}

	/**
	 * @return the selected facet in the filtredList.
	 */
	public Facet getFacetSelected() {
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
