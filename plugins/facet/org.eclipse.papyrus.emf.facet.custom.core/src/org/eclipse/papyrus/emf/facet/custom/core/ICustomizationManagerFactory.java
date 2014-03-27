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
 *      Gregoire Dupe (Mia-Software) - Bug 372626 - Aggregates
 */
package org.eclipse.papyrus.emf.facet.custom.core;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.custom.core.internal.CustomizationManagerFactory;

/**
 * Used to instantiate a customization manager
 * @author Gregoire Dupe
 * @since 0.2
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizationManagerFactory {
	
	/**
	 * Default factory instance.
	 */
	ICustomizationManagerFactory DEFAULT = new CustomizationManagerFactory();
	
	/**
	 * This method is used to instantiate a customization manager
	 * 
	 * @param resourceSet
	 *            the resource set to use to manage the customization models.
	 * @return
	 */
	ICustomizationManager getOrCreateICustomizationManager(ResourceSet resourceSet);

	/**
	 * 
	 * @param facetManager
	 * @return
	 * @since 0.2
	 */
	ICustomizationManager createICustomizationManager(IFacetManager facetManager);

}
