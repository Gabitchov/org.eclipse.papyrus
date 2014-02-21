/**
 *  Copyright (c) 2011 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.emf.facet.custom.ui;

import org.eclipse.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.emf.facet.custom.ui.internal.CustomizedLabelProviderFactory;

/**
 * This class is the factory allowing to get a instance of
 * {@link ICustomizedLabelProvider}.
 * 
 * @author Gregoire Dupe
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizedLabelProviderFactory {
	ICustomizedLabelProviderFactory DEFAULT = new CustomizedLabelProviderFactory();

	/**
	 * This method is used to instantiate a {@link ICustomizedLabelProvider}.
	 * 
	 * @param customizationManager
	 *            the customization manager which has to used by the content
	 *            provider.
	 * @return a label provider
	 */
	ICustomizedLabelProvider createCustomizedLabelProvider(
			ICustomizationManager customizationMgr);
}
