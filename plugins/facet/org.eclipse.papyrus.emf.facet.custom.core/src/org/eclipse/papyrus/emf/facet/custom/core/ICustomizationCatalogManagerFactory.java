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
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 */
package org.eclipse.papyrus.emf.facet.custom.core;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.custom.core.internal.CustomizationCatalogManagerFactory;

/**
 * A factory for {@link ICustomizationCatalogManager}
 * 
 * @since 0.2
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizationCatalogManagerFactory {

	ICustomizationCatalogManagerFactory DEFAULT = new CustomizationCatalogManagerFactory();

	ICustomizationCatalogManager getOrCreateCustomizationCatalogManager(
			ResourceSet resourceSet);
}
