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
package org.eclipse.papyrus.emf.facet.custom.core;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.papyrus.emf.facet.custom.core.internal.CustomizationPropertiesCatalogManagerFactory;

/**
 * This interface provides the customization catalog manager.
 * 
 * @since 0.3
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface ICustomizationPropertiesCatalogManagerFactory {

	ICustomizationPropertiesCatalogManagerFactory INSTANCE = new CustomizationPropertiesCatalogManagerFactory();

	ICustomizationPropertiesCatalogManager getOrCreateCustomizationPropertiesCatalogManager(
			final ResourceSet resourceSet);

}