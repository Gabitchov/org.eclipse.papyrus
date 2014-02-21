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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.metaclass;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.Messages;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.creation.AddOperationInFacetWidget;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.util.widget.component.metaclass.AbstractGetMetaclassWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;


/**
 * Concrete implementation of {@link AbstractGetMetaclassWidget} abstract
 * class.</p>
 * 
 * Create a simple Label {@link #getLabel()}TextField and a button.</p> The type
 * used {@link ETypeSelectionOptions} depends of the element created.
 * 
 * @see AddOperationInFacetWidget
 */
public class GetElementTypeWidget extends
		AbstractGetMetaclassWidget<EClassifier> {

	/**
	 * Constructor.
	 * 
	 * @param parent
	 *            the parent of this composite.
	 * @param propertyElement
	 *            the property element that will be edited by this composite.
	 * @param facetSetProp
	 *            the property element to get the super, main, facetSet of the
	 *            model.
	 * @param eTypeOption
	 * @param eTypeOption
	 *            the type of the elements displayed in the selection wizard.
	 */
	public GetElementTypeWidget(final Composite parent,
			final PropertyElement2<EClassifier> propertyElement,
			final PropertyElement2<FacetSet> facetSetProp,
			final Class<? extends EClassifier> eTypeOption) {
		super(parent, propertyElement, facetSetProp, eTypeOption);
	}

	@Override
	protected String getLabel() {
		return Messages.Type;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.Type_mustSelectType;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	protected EPackage getEPackage() {
		// TODO Auto-generated method stub
		return null;
	}

}
