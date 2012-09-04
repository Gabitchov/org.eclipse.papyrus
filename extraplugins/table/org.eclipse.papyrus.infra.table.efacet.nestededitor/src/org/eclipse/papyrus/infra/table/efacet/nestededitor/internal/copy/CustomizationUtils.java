/*****************************************************************************
 * Copyright (c) 2012 CEA LIST.
 *
 *    
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Vincent Lorenzo (CEA LIST) Vincent.Lorenzo@cea.fr - Initial API and implementation
 *  
 *****************************************************************************/
package org.eclipse.papyrus.infra.table.efacet.nestededitor.internal.copy;

import java.util.Collection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.FacetCustomization;
import org.eclipse.emf.facet.efacet.core.FacetUtils;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;

//TODO duplicated and adapted code from EMF-Facet
//EMF-Facet should provides a best way to hide columns
public final class CustomizationUtils {

	private CustomizationUtils() {
		// Must not be used.
	}

	/** @return the {@link Facet}s customized by the given customizations. */
	public static Set<FacetSet> findFacetsCustomizedBy(final List<Customization> customizations) {
		final Set<FacetSet> referencedFS = new HashSet<FacetSet>();
		for(Customization customization : customizations) {
			for(EClassifier eClassifier : customization.getEClassifiers()) {
				if(eClassifier instanceof FacetCustomization) {
					final FacetCustomization facetCustom = (FacetCustomization)eClassifier;
					for(Facet extFacet : facetCustom.getExtendedFacets()) {
						referencedFS.add((FacetSet)extFacet.getEPackage());
					}
				}
			}
		}
		return referencedFS;
	}

	/** Returns the first customization among the given list of customizations that extends the given EPackage. */
	public static Customization findCustomizationExtendingEPackage(final List<Customization> customizations, final EPackage ePackage) {
		if(ePackage == null) {
			throw new IllegalArgumentException("ePackage must not be null"); //$NON-NLS-1$
		}
		Customization result = null;
		for(Customization customization : customizations) {
			if(customization != null && ePackage.equals(FacetUtils.getExtendedEPackage(customization))) {
				result = customization;
				break;
			}
		}
		return result;
	}

	/** Returns the first {@link Facet} among the given list of facets that extends the given EClass. */
	public static Facet findFacetByExtendedMetaclass(final Collection<Facet> facets, final EClass extendedMetaClass) {
		Facet result = null;
		for(Facet facet : facets) {
			Facet candidate = facet;
			if(candidate.getExtendedMetaclass() == extendedMetaClass) {
				result = candidate;
				break;
			}
		}
		return result;
	}

}
