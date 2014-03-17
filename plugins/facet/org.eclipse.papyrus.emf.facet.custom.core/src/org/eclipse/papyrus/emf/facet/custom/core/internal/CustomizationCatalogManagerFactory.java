/**
 *  Copyright (c) 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 */
package org.eclipse.papyrus.emf.facet.custom.core.internal;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.util.emf.core.ICatalogSetManagerFactory;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManager;

public class CustomizationCatalogManagerFactory implements
		org.eclipse.papyrus.emf.facet.custom.core.ICustomizationCatalogManagerFactory {

	public ICustomizationCatalogManager getOrCreateCustomizationCatalogManager(
			final ResourceSet resourceSet) {
		return ICatalogSetManagerFactory.DEFAULT
				.createICatalogSetManager(resourceSet)
				.getCatalogManagerByType(ICustomizationCatalogManager.class)
				.get(0);
	}

}
