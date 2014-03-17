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
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.util.handler;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.dialog.ICustomizationDialogFactory;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.util.handler.AbstractSelectionExpectedTypeHandler;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.swt.widgets.Display;

/**
 * Handler for the creation of an EClass Customization.
 */
public class CreateEClassCustomizationHandler extends
		AbstractSelectionExpectedTypeHandler {

	public Object execute(final ExecutionEvent event) throws ExecutionException {
		final EditingDomain editingDomain = Utils.getEditingDomain(event);
		final Display display = Utils.getDisplay(event);
		return ICustomizationDialogFactory.DEFAULT
				.openCreateEClassCustomizationDialog(display, editingDomain);
	}

	@Override
	protected Class<?> getSelectionExpectedType() {
		return Customization.class;
	}

}
