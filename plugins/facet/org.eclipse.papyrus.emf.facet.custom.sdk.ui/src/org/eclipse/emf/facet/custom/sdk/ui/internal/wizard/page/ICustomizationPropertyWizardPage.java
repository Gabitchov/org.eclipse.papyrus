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
package org.eclipse.emf.facet.custom.sdk.ui.internal.wizard.page;

import org.eclipse.jface.wizard.IWizardPage;

/**
 * Interface to expose the services of {@link CustomizationPropertyWizardPage}.
 * 
 * @see CustomizationPropertyWizardPage
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizationPropertyWizardPage extends IWizardPage {

	/**
	 * @return the nsURI of the model.
	 */
	String getNsUri();

	/**
	 * Set the nsURI of the model.
	 * 
	 * @param nsUri
	 *            the new nsURI.
	 */
	void setNsUri(String nsUri);

	/**
	 * @return the prefix of the model.
	 */
	String getPrefix();

	/**
	 * Set the prefix of the model.
	 * 
	 * @param prefix
	 *            the new prefix.
	 */
	void setPrefix(String prefix);
}
