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
 */
package org.eclipse.emf.facet.efacet.sdk.ui.internal.handler.edition;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetReference;
import org.eclipse.emf.facet.efacet.sdk.ui.dialog.IFacetDialogFactory;
import org.eclipse.emf.facet.util.ui.internal.exported.util.handler.AbstractSelectionExpectedTypeHandler;

/**
 * Handler for the edition of a {@link FacetReference}
 */
public class EditFacetReferenceHandler extends AbstractSelectionExpectedTypeHandler {

	@Override
	protected Class<?> getSelectionExpectedType() {
		return FacetReference.class;
	}

	public Object execute(final ExecutionEvent event) {
		return IFacetDialogFactory.INSTANCE.openEditFacetReferenceDialog();
	}
}
