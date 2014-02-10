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
package org.eclipse.emf.facet.custom.sdk.core.internal;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.custom.sdk.core.ICustomizationActions;
import org.eclipse.emf.facet.util.core.Logger;
//import org.eclipse.emf.facet.util.core.internal.BuildPropertiesUtils;
import org.eclipse.emf.facet.util.emf.core.ICatalogSetManager2;
import org.eclipse.emf.facet.util.emf.core.ICatalogSetManagerFactory;
import org.eclipse.emf.facet.util.emf.core.exception.InvalidFacetSetException;

/**
 * Concrete implementation of {@link ICustomizationActions}.
 */
public class CustomizationActionsImpl implements ICustomizationActions {

	public void saveCustomization(final Customization customization,
			final IFile file) throws IOException, InvalidFacetSetException {

		if (customization == null) {
			throw new IllegalArgumentException(
					"The given customization cannot be null"); //$NON-NLS-1$
		}
		if (file == null) {
			throw new IllegalArgumentException("The given file cannot be null"); //$NON-NLS-1$
		}
		if (file.exists()) {
			throw new IllegalArgumentException("The given file already exists"); //$NON-NLS-1$
		}
		// Create a resource set
		final ResourceSet resourceSet = new ResourceSetImpl();
		// Get the URI of the model file.
		final URI fileURI = URI.createPlatformResourceURI(file.getFullPath()
				.toString(), true);
		// Create a resource for this file.
		final Resource resource = resourceSet.createResource(fileURI);
		// Add the facetSet the resource contents.
		resource.getContents().add(customization);
		// Save the contents of the resource to the file system.
		resource.save(null);
		try {
			//BuildPropertiesUtils.addToBuild(file);
		} catch (final Exception e) {
			Logger.logError(e, "Error adding file " + file.getFullPath() //$NON-NLS-1$
					+ " to the build.properties", Activator.getDefault()); //$NON-NLS-1$
		}
		final ICatalogSetManager2 catalogSetManager = ICatalogSetManagerFactory.DEFAULT
				.createICatalogSetManager(resourceSet);
		catalogSetManager.registerModelDeclaration(file);
	}

}
