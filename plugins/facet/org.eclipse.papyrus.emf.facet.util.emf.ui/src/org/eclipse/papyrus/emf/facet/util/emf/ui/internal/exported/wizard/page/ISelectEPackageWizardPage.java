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
package org.eclipse.papyrus.emf.facet.util.emf.ui.internal.exported.wizard.page;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.jface.wizard.IWizardPage;

/**
 * Interface for {@link SelectEPackageWizardPage}.
 * 
 * @see SelectEPackageWizardPage
 * @since 0.3
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ISelectEPackageWizardPage extends IWizardPage {

	/**
	 * @return the first {@link EPackage} selected in the list.
	 */
	EPackage getSelectedEPackage();

	/**
	 * Set the {@link EPackage} to select.
	 * 
	 * @param selection
	 *            the name of the {@link EPackage} to select.
	 */
	void selectPackage(final String selection);

}