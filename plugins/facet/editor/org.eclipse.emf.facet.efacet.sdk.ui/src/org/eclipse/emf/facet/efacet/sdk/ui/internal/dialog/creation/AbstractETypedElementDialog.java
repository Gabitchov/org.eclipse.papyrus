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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.ETypedElement;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IETypedElementWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;

public abstract class AbstractETypedElementDialog<C extends EObject, CW extends Object, W extends IETypedElementWidget<C, CW>>
		extends AbstractENamedElementDialog<C, CW, W> {

	private final PropertyElement2<Integer> lowerBdProperty;
	private final PropertyElement2<Integer> upperBdProperty;
	private final PropertyElement2<Boolean> uniqueProperty;
	private final PropertyElement2<Boolean> orderedProperty;
	private final PropertyElement2<EClassifier> typeProperty;

	protected AbstractETypedElementDialog(final ETypedElement eTypedElement,
			final EditingDomain editingDomain) {
		super(eTypedElement, editingDomain);
		this.lowerBdProperty = new PropertyElement2<Integer>(true);
		this.upperBdProperty = new PropertyElement2<Integer>(true);
		this.typeProperty = new PropertyElement2<EClassifier>(true);
		this.orderedProperty = new PropertyElement2<Boolean>(true);
		this.uniqueProperty = new PropertyElement2<Boolean>(true);
		if (eTypedElement == null) {
			this.lowerBdProperty.setValue2(Integer.valueOf(0));
			this.upperBdProperty.setValue2(Integer.valueOf(1));
		} else {
			this.lowerBdProperty.setValue2(Integer.valueOf(eTypedElement
					.getLowerBound()));
			// Upper Bound
			this.upperBdProperty.setValue2(Integer.valueOf(eTypedElement
					.getUpperBound()));
			// EType
			this.typeProperty.setValue2(eTypedElement.getEType());
			// Ordered
			this.orderedProperty.setValue2(Boolean.valueOf(eTypedElement
					.isOrdered()));
			// Unique
			this.uniqueProperty.setValue2(Boolean.valueOf(eTypedElement
					.isUnique()));
		}
	}

	protected final PropertyElement2<Integer> getLowerBdProperty() {
		return this.lowerBdProperty;
	}

	protected final PropertyElement2<Integer> getUpperBdProperty() {
		return this.upperBdProperty;
	}

	protected final PropertyElement2<Boolean> getUniqueProperty() {
		return this.uniqueProperty;
	}

	protected final PropertyElement2<Boolean> getOrderedProperty() {
		return this.orderedProperty;
	}

	protected final PropertyElement2<EClassifier> getTypeProperty() {
		return this.typeProperty;
	}
}
