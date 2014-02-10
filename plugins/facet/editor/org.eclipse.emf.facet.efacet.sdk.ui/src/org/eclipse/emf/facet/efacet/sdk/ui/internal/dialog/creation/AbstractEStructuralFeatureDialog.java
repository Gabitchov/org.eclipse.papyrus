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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.dialog.creation;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;

public abstract class AbstractEStructuralFeatureDialog<W extends IDerivedTypedElementWidget>
		extends AbstractDerivedTypedElementDialog<W> {

	private final PropertyElement2<Boolean> volatileProperty;
	private final PropertyElement2<Boolean> derivedroperty;
	private final PropertyElement2<Boolean> transientProperty;
	private final PropertyElement2<Boolean> changeableroperty;
	private final PropertyElement2<Facet> containerProperty;

	protected AbstractEStructuralFeatureDialog(
			final DerivedTypedElement selection,
			final EditingDomain editingDomain,
			final PropertyElement2<Facet> containerProperty) {
		super(selection, editingDomain);
		this.volatileProperty = new PropertyElement2<Boolean>(true);
		this.changeableroperty = new PropertyElement2<Boolean>(true);
		this.derivedroperty = new PropertyElement2<Boolean>(true);
		this.transientProperty = new PropertyElement2<Boolean>(true);
		if (selection instanceof EStructuralFeature) {
			final EStructuralFeature structuralFeature = (EStructuralFeature) getSelection();
			this.volatileProperty.setValue2(Boolean.valueOf(structuralFeature
					.isVolatile()));
			this.changeableroperty.setValue2(Boolean.valueOf(structuralFeature
					.isChangeable()));
			this.derivedroperty.setValue2(Boolean.valueOf(structuralFeature
					.isDerived()));
			this.transientProperty.setValue2(Boolean.valueOf(structuralFeature
					.isTransient()));
		}
		this.containerProperty = containerProperty;
	}

	protected final PropertyElement2<Boolean> getVolatileProperty() {
		return this.volatileProperty;
	}

	protected final PropertyElement2<Boolean> getDerivedroperty() {
		return this.derivedroperty;
	}

	protected final PropertyElement2<Boolean> getTransientProperty() {
		return this.transientProperty;
	}

	protected final PropertyElement2<Boolean> getChangeableroperty() {
		return this.changeableroperty;
	}

	/**
	 * @return the containerProperty
	 */
	public PropertyElement2<Facet> getContainerProperty() {
		return this.containerProperty;
	}

}
