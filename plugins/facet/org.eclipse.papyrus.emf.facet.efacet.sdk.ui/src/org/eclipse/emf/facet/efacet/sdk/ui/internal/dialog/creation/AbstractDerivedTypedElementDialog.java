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

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.DerivedTypedElement;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.extensible.Query;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IDerivedTypedElementWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.IFacetWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.util.widget.command.IGetOrCreateFilteredElementCommmandWidget;
import org.eclipse.emf.facet.util.ui.utils.PropertyElement2;

public abstract class AbstractDerivedTypedElementDialog<W extends IDerivedTypedElementWidget>
		extends
		AbstractETypedElementDialog<Facet, IGetOrCreateFilteredElementCommmandWidget<Facet, IFacetWidget>, W> {

	private final PropertyElement2<Query> queryProperty;

	protected AbstractDerivedTypedElementDialog(
			final DerivedTypedElement selection,
			final EditingDomain editingDomain) {
		super(selection, editingDomain);
		this.queryProperty = new PropertyElement2<Query>(true);
		if (selection != null) {
			this.queryProperty.setValue2(selection.getQuery());
		}
	}

	protected final PropertyElement2<Query> getQueryProperty() {
		return this.queryProperty;
	}

}
