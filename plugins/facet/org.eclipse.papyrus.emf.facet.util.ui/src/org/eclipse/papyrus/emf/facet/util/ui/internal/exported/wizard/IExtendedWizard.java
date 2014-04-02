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
package org.eclipse.papyrus.emf.facet.util.ui.internal.exported.wizard;

import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.IWizardPage;

/**
 * Interface for the facets wizards.
 * 
 * @since 0.3
 */
public interface IExtendedWizard extends IWizard {
	
	/**
	 * @return the current page of the wizard.
	 */
	IWizardPage getCurrentPage();

	/**
	 * Simulate the action of pressing the next button.
	 * 
	 * @return the next page.
	 */
	IWizardPage next();

	/**
	 * Simulate the action of pressing the previous button.
	 * 
	 * @return the previous page.
	 */
	IWizardPage previous();

	/**
	 * Simulate the action of pressing the finish button.
	 * 
	 * @return true if the wizard finish correctly.
	 */
	boolean finish();

	/**
	 * Open the wizard.
	 * 
	 * @return the return code when the wizard closes.
	 */
	int open();
}
