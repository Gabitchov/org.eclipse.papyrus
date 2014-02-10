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
package org.eclipse.emf.facet.util.emf.ui.internal.exported.wizard.page;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.facet.util.emf.ui.internal.exported.util.wizard.page.SelectEClassifierWizardPage;
import org.eclipse.jface.wizard.IWizardPage;

/**
 * Interface for {@link SelectEClassifierWizardPage}.
 * 
 * @see SelectEClassifierWizardPage
 * @since 0.3
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ISelectEClassifierWizardPage<T extends EClassifier> extends
		IWizardPage {

	/**
	 * @return the selected {@link EClassifier}.
	 */
	T getSelectedEClassifier();

	/**
	 * Set the {@link EClassifier}.
	 * 
	 * @param selection
	 *            the name of the {@link EClassifier} to select.
	 */
	void selectEClassifier(final String selection);

}