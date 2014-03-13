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
package org.eclipse.papyrus.emf.facet.custom.core.internal;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.efacet.core.IFacetManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationManagerFactory;

public class CustomizationManagerFactory implements
		ICustomizationManagerFactory {

	public ICustomizationManager getOrCreateICustomizationManager(final ResourceSet resourceSet) {
		return new CustomizationManager(resourceSet);
	}

	public ICustomizationManager createICustomizationManager(
			final IFacetManager facetManager) {
		return new CustomizationManager(facetManager);
	}

}
