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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.core.FacetUtils;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.dialog.creation.CreateFacetSetInFacetSetDialog;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.IENamedElementWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.command.AbstractGetOrCreateFilteredElementCommandWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.getorcreate.AbstractGetOrCreateElementWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Concrete implementation of {@link AbstractGetOrCreateElementWidget}.</p>
 * 
 * This class allows to select a FacetSet or create a new one.
 */
public class GetOrCreateFiltredFacetSetWidget
		extends
		AbstractGetOrCreateFilteredElementCommandWidget<
			FacetSet,
			IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>
		>
		implements IGetOrCreateFilteredFacetSetWidget {

	private final EditingDomain editingDomain;
	private final PropertyElement2<FacetSet> parentFSProp;
	private final FacetSet reject;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this widget.
	 * @param properties
	 *            the properties.
	 * @param reject
	 * @param recursiveCreation
	 *            if the creation of the FacetSet can be recursive.
	 */
	public GetOrCreateFiltredFacetSetWidget(final Composite parent,
			final EditingDomain editingDomain,
			final PropertyElement2<FacetSet> parentFSProp, final FacetSet reject) {
		super(parent);
		this.editingDomain = editingDomain;
		this.parentFSProp = parentFSProp;
		this.reject = reject;
	}

	/**
	 * @return the selected facetSet in the filtredList.
	 */
	public FacetSet getFacetSetSelected() {
		return getElementSelected();
	}

	@Override
	protected Map<String, FacetSet> getElements() {
		final FacetSet containingFS = FacetUtils
				.getRootFacetSet(this.parentFSProp.getValue2());
		final Map<String, FacetSet> allFacets = getAllFacetSets(containingFS);
		allFacets.remove(this.parentFSProp.getName());
		return allFacets;
	}

	@Override
	protected IDialog<IENamedElementWidget<FacetSet, IGetOrCreateFilteredFacetSetWidget>> createDialog() {
		return new CreateFacetSetInFacetSetDialog(
				this.parentFSProp.getValue2(), this.editingDomain);
	}

	/**
	 * Return all the facetSets parent if the element in parameter.
	 * 
	 * @param element
	 *            where to begin.
	 * @return the list of facetSet.
	 */
	public Map<String, FacetSet> getAllSuperFacetSets(final FacetSet element) {
		final Map<String, FacetSet> facetSets = new HashMap<String, FacetSet>();
		facetSets.put(element.getName(), element);
		final FacetSet parent = (FacetSet) element.getESuperPackage();
		if (parent != null) {
			facetSets.putAll(getAllSuperFacetSets(parent));
		}
		return facetSets;
	}

	/**
	 * Return all the facetSets of the model.
	 * 
	 * @param parent
	 *            the first FacetSet of the model.
	 * @return the list of facetSet.
	 */
	private Map<String, FacetSet> getAllFacetSets(final FacetSet parent) {
		final Map<String, FacetSet> facetSets = new HashMap<String, FacetSet>();
		if (parent != this.reject) {
			facetSets.put(parent.getName(), parent);
			for (final EPackage element : parent.getESubpackages()) {
				facetSets.putAll(getAllFacetSets((FacetSet) element));
			}
		}
		return facetSets;
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
