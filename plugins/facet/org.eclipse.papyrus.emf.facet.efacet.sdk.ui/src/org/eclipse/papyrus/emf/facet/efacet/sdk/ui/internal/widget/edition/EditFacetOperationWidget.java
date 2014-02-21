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
package org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.edition;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.creation.AddOperationInFacetWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the edition of a {@link FacetOperation}.
 */
public class EditFacetOperationWidget extends AddOperationInFacetWidget {

	private final FacetOperation initialFacetOpe;

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the properties.
	 * @param initialFacetOpe
	 *            the {@link FacetOperation} to edit.
	 * @param facet
	 */
	public EditFacetOperationWidget(final Composite parent,
			final FacetOperation initialFacetOpe,
			final EditingDomain editingDomain,
			final PropertyElement2<Facet> facetProperty,
			final PropertyElement2<String> nameProperty,
			final PropertyElement2<Integer> lowerBdProperty,
			final PropertyElement2<Integer> upperBdProperty,
			final PropertyElement2<EClassifier> typeProperty,
			final PropertyElement2<Boolean> orderedProperty,
			final PropertyElement2<Boolean> uniqueProperty,
			final PropertyElement2<Query> queryProperty) {
		super(parent, editingDomain, facetProperty, nameProperty,
				lowerBdProperty, upperBdProperty, typeProperty,
				orderedProperty, uniqueProperty, queryProperty);
		this.initialFacetOpe = initialFacetOpe;
	}

	@Override
	protected FacetOperation getFacetOperation() {
		return this.initialFacetOpe;
	}

	@Override
	public Command getCommand() {
		final Facet facetContainer = this.getContainerPropery()
				.getValue2();
		final FacetOperation facetElement = createFacetOperation();
		return this.getCommandFactory().createEditFacetOperationCommand(
				facetElement, facetContainer, getElementName(), getLowerBound(),
				getUpperBound(), getTypeProperty().getValue2(),
				getOrderedProperty().getValue2().booleanValue(),
				getUniqueProperty().getValue2().booleanValue(),
				getQueryProperty().getValue2());

	}
}
