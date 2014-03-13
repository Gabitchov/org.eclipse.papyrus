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
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.widget.metaclass;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.Messages;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.util.widget.component.metaclass.AbstractGetMetaclassWidget;
import org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.wizard.ISelectETypeWizard;
import org.eclipse.papyrus.emf.facet.util.ui.utils.PropertyElement2;
import org.eclipse.swt.widgets.Composite;

/**
 * Concrete implementation of {@link AbstractGetMetaclassWidget} abstract
 * class.</p>
 * 
 * Create a simple Label {@link #getLabel()}TextField and a button.</p> This
 * class provide the selection the extended metaclass. The type used is
 * {@link ETypeSelectionOptions#ECLASS}
 * 
 * @since 0.3
 */
public class GetExtendedMetaclassWidget extends
		AbstractGetMetaclassWidget<EClass> {

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
	 */
	public GetExtendedMetaclassWidget(final Composite parent,
			final PropertyElement2<EClass> propertyElement,
			final PropertyElement2<? extends FacetSet> facetSetProp) {
		super(parent, propertyElement, facetSetProp, EClass.class);
	}

	@Override
	protected String getLabel() {
		return Messages.ExtendedMetaClass;
	}

	@Override
	protected String getErrorMessage() {
		return Messages.Metaclass_mustSelectMetaclass;
	}

	@Override
	public void notifyChanged() {
		// No action has to be done if a change appends.
	}

	@Override
	protected String getTextFieldInitialText() {
		return getPropertyElement().getValue2().getName();
	}

	@Override
	protected EPackage getEPackage() {
		return this.getEPackageProperty().getValue2();
	}

	@Override
	protected ISelectETypeWizard<EClass> createSynchronizedWizard(
			final ISelectETypeWizard<EClass> wizard) {
		// TODO Auto-generated method stub
		return null;
	}
}
