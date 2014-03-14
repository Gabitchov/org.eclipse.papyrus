/**
 *  Copyright (c) 2011, 2012 Mia-Software.
 *  
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 * 
 *  Contributors:
 *  	Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] EMF Facet customization meta-model
 *      Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *      Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *      Alban Ménager (Soft-Maint) - Bug 387470 - [EFacet][Custom] Editors
 */
package org.eclipse.papyrus.emf.facet.custom.core.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetOperation;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.util.emf.core.ICatalogManager;
import org.eclipse.papyrus.emf.facet.custom.core.ICustomizationPropertiesCatalogManager;
import org.eclipse.papyrus.emf.facet.custom.core.internal.exception.CustomizationCatalogRuntimeException;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationPropertiesCatalog;
import org.eclipse.papyrus.emf.facet.custom.metamodel.v0_2_0.customizationcatalog.CustomizationcatalogFactory;
import org.eclipse.papyrus.emf.facet.util.emf.catalog.CatalogSet;

/**
 * Customization catalog implementation using the catalog manager features
 * provided by the plug-in org.eclipse.papyrus.emf.facet.util.emf.core
 * 
 * @author Gregoire Dupe
 * 
 */
public class CustomizationPropertiesCatalogManager implements ICatalogManager,
		ICustomizationPropertiesCatalogManager {

	private static final String CUSTOM_SUFIX = "customproperties"; //$NON-NLS-1$
	private final CustomizationPropertiesCatalog catalog = CustomizationcatalogFactory.eINSTANCE
			.createCustomizationPropertiesCatalog();

	public boolean canBeManaged(final EObject root) {
		return root instanceof FacetSet;
	}

	public void manage(final EObject root) {
		if (root instanceof FacetSet) {
			final FacetSet customProperties = (FacetSet) root;
			// We have to force the integrator to use the suffix
			// "customproperties" to name them facetSet declaring custom
			// properties. Otherwise we won't be able to know if a facetSet is a
			// custom property declaration
			if (customProperties.getName().endsWith(CUSTOM_SUFIX)) {
				this.catalog.getInstalledEntries().add(customProperties);
			}
		} else {
			throw new CustomizationCatalogRuntimeException(
					"Only facetSets must be stored in the customization properties catalog"); //$NON-NLS-1$
		}
	}

	public void setCatalogSet(final CatalogSet catalogSet) {
		catalogSet.getCatalogs().add(this.catalog);
	}

	public List<FacetSet> getAllRegisteredCustomizationPropertySet() {
		final List<FacetSet> result = new ArrayList<FacetSet>();
		for (final EObject eObject : this.catalog.getInstalledEntries()) {
			if (eObject instanceof FacetSet) {
				final FacetSet facetSet = (FacetSet) eObject;
				result.add(facetSet);
			} else {
				throw new RuntimeException(
						"Only facetSets must be stored in the customization properties catalog"); //$NON-NLS-1$
			}
		}
		return result;
	}

	public List<FacetOperation> getCustomizationPropertiesByName(
			final String customPropName) {
		final List<FacetOperation> result = new ArrayList<FacetOperation>();
		for (final EObject facetSet : this.catalog.getInstalledEntries()) {
			final Iterator<EObject> iterator = facetSet.eAllContents();
			while (iterator.hasNext()) {
				final EObject eObject = iterator.next();
				if (eObject instanceof FacetOperation) {
					final FacetOperation customProperty = (FacetOperation) eObject;
					if (customPropName.equals(customProperty.getName())) {
						result.add(customProperty);	
					}
				}
			}
		}
		return result;
	}

}
