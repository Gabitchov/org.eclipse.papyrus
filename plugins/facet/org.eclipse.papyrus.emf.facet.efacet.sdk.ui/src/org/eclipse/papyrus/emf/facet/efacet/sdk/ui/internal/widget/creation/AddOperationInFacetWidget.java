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

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.EFacetFactory;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.component.properties.name.GetOperationNameWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.properties.name.AbstractGetElementNameWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;


/**
 * Concrete implementation of {@link AbstractAddElementWidget} for the creation
 * of an operation in a facet.
 */
public class AddOperationInFacetWidget extends
		AbstractDerivedTypedElementWidget<FacetOperation> {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the properties.
	 * @param facet
	 */
	public AddOperationInFacetWidget(final Composite parent,
			final EditingDomain editingDomain,
			final PropertyElement2<Facet> facetProperty,
			final PropertyElement2<String> nameProperty,
			final PropertyElement2<Integer> lowerBdProperty,
			final PropertyElement2<Integer> upperBdProperty,
			final PropertyElement2<EClassifier> typeProperty,
			final PropertyElement2<Boolean> orderedProperty,
			final PropertyElement2<Boolean> uniqueProperty,
			final PropertyElement2<Query> queryProperty) {
		super(parent, editingDomain, facetProperty,
				nameProperty, lowerBdProperty, upperBdProperty, typeProperty,
				orderedProperty, uniqueProperty, queryProperty);
	}

	@Override
	public Command getCommand() {
		final Facet facet = this.getContainerPropery().getValue2();
		final FacetOperation facetOperation = createFacetOperation();
		return this.getCommandFactory().createAddOperationInFacetCommand(facet,
				facetOperation);
	}

	protected FacetOperation createFacetOperation() {
		final FacetOperation facetOperation = getFacetOperation();
		facetOperation.setName(getElementNamePropertyValue());
		facetOperation.setLowerBound(getLowerBoundProperty().getValue2()
				.intValue());
		facetOperation.setUpperBound(getUpperBoundProperty().getValue2()
				.intValue());
		facetOperation.setEType(getTypeProperty().getValue2());
		facetOperation.setOrdered(getOrderedProperty().getValue2()
				.booleanValue());
		facetOperation
				.setUnique(getUniqueProperty().getValue2().booleanValue());
		facetOperation.setQuery(getQueryProperty().getValue2());
		return facetOperation;
	}

	@SuppressWarnings("static-method")
	//@SuppressWarnings("static-method") This method cannot be static because it is overrode by EditFacetWidget.
	protected FacetOperation getFacetOperation() {
		return EFacetFactory.eINSTANCE.createFacetOperation();
	}

	@Override
	protected AbstractGetElementNameWidget createGetElementNameSubWidgetComposite() {
		return new GetOperationNameWidget(this, this.getElementNameProperty());
	}

	@Override
	protected Class<EClassifier> getETypeSelectionOption() {
		return EClassifier.class;
	}

	@Override
	public void onDialogValidation() {
		// Nothing.
	}

}
