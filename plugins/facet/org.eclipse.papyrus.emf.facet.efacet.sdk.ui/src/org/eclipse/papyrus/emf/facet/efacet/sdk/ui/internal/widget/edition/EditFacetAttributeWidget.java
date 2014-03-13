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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetAttribute;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.component.properties.name.GetAttributeNameWidget;
import org.eclipse.papyrus.emf.facet.efacet.sdk.ui.internal.widget.creation.AbstractEStructuralFeatureWidget;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.widget.component.properties.name.AbstractGetElementNameWidget;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Widget for the edition of a {@link FacetAttribute}.
 */
public class EditFacetAttributeWidget extends
		AbstractEStructuralFeatureWidget<FacetAttribute> {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param properties
	 *            the properties.
	 * @param initialAttribut
	 *            the {@link FacetAttribute} to edit.
	 */
	public EditFacetAttributeWidget(final Composite parent,
			final FacetAttribute initialAttribut,
			final EditingDomain editingDomain,
			final PropertyElement2<Facet> facetProperty,
			final PropertyElement2<String> nameProperty,
			final PropertyElement2<Integer> lowerBdProperty,
			final PropertyElement2<Integer> upperBdProperty,
			final PropertyElement2<EClassifier> typeProperty,
			final PropertyElement2<Boolean> orderedProperty,
			final PropertyElement2<Boolean> uniqueProperty,
			final PropertyElement2<Query> queryProperty,
			final PropertyElement2<Boolean> volatileProperty,
			final PropertyElement2<Boolean> changeProperty,
			final PropertyElement2<Boolean> derivedProperty,
			final PropertyElement2<Boolean> transientProperty) {
		super(initialAttribut, parent, editingDomain, facetProperty,
				nameProperty,
				lowerBdProperty, upperBdProperty, typeProperty,
				orderedProperty, uniqueProperty, queryProperty,
				volatileProperty, changeProperty, derivedProperty,
				transientProperty);
	}

	@Override
	protected AbstractGetElementNameWidget createGetElementNameSubWidgetComposite() {
		return new GetAttributeNameWidget(this, this.getElementNameProperty());
	}

	@Override
	protected Class<? extends EClassifier> getETypeSelectionOption() {
		return EDataType.class;
	}

	@Override
	public void onDialogValidation() {
		// Nothing.
	}

}
