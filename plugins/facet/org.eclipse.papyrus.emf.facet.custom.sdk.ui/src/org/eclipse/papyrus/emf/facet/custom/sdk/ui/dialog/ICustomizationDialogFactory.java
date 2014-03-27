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
 *  	Gregoire Dupe (Mia-Software) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.sdk.ui.dialog;

import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.papyrus.emf.facet.custom.sdk.ui.internal.dialog.CustomizationDialogFactory;
import org.eclipse.papyrus.emf.facet.util.ui.internal.exported.dialog.IDialog;
import org.eclipse.swt.widgets.Display;

/**
 * Interface for the dialogs creation factory.
 * 
 * @see CustomizationDialogFactorImpl
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizationDialogFactory {

	ICustomizationDialogFactory DEFAULT = new CustomizationDialogFactory();

	/**
	 * Create an new Dialog for the creation of a EClass Customization.
	 * 
	 * @param editingDomain
	 */
	IDialog openCreateEClassCustomizationDialog(Display display,
			EditingDomain editingDomain);

	/**
	 * Create an new Dialog for the creation of a Facet Customization.
	 * 
	 * @return the dialog.
	 */
	IDialog openCreateFacetCustomizationDialog(Display display,
			EditingDomain editingDomain);

	/**
	 * Create an new Dialog for the creation of a Customization Operation into a
	 * Customization.
	 * 
	 * @return the dialog.
	 */
	IDialog openAddCustomizationPropertyDialog(Display display,
			EditingDomain editingDomain);

	/**
	 * Create an new Dialog for the creation of a Query into a Case.
	 * 
	 * @return the dialog.
	 */
	IDialog openAddCaseQueryDialog(Display display, EditingDomain editingDomain);
}
