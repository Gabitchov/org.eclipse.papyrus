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
package org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.component.getorcreate;

import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.exported.widget.creation.IGetOrCreateFilteredFacetSetWidget;
import org.eclipse.emf.facet.efacet.sdk.ui.internal.widget.component.getorcreate.GetOrCreateFacetSetWidget;
import org.eclipse.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.emf.facet.util.ui.internal.exported.widget.getorcreate.IAbstractGetOrCreateElementWithButtonWidget;

/**
 * Interface for {@link GetOrCreateFacetSetWidget}.
 * 
 * @see GetOrCreateFacetSetWidget
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IGetOrCreateFacetSetWidget extends
		IAbstractGetOrCreateElementWithButtonWidget<IDialog<IGetOrCreateFilteredFacetSetWidget>> {

	/**
	 * @return the {@link FacetSet} selected.
	 */
	FacetSet getFacetSet();
}