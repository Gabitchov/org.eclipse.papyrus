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
 *  Vincent Lorenzo (CEA LIST) vincent.lorenzo@cea.fr - Initial API and implementation
 *
 *****************************************************************************/
package org.eclipse.papyrus.uml.table.efacet.common.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;

import org.eclipse.emf.facet.custom.metamodel.v0_2_0.custom.Customization;
import org.eclipse.emf.facet.efacet.core.FacetUtils;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManagerFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.Facet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;

/**
 * 
 * This providers provides the list of the registered FacetSet available to display new columns in the table
 * 
 */
public class EMFFacetColumnsProvider extends AbstractAdditionalContentsProvider {

	@Override
	public Collection<FacetSet> getAdditionalFeatures() {
		final HashSet<FacetSet> availableFacetSets = new HashSet<FacetSet>();
		availableFacetSets.addAll(IFacetSetCatalogManagerFactory.DEFAULT.getOrCreateFacetSetCatalogManager(pTable.eResource().getResourceSet()).getRegisteredFacetSets());
		if(pTable.getTable().getTableConfiguration() != null) {
			for(Facet facet : pTable.getTable().getTableConfiguration().getDefaultFacets()) {
				availableFacetSets.add(FacetUtils.getRootFacetSet(facet));
			}
		}
		for(FacetSet facetSet : pTable.getTable().getFacetSets()) {
			availableFacetSets.add(FacetUtils.getRootFacetSet(facetSet));
		}
		final List<FacetSet> facetSets = new ArrayList<FacetSet>(availableFacetSets);
		final ListIterator<FacetSet> iter = facetSets.listIterator();
		while(iter.hasNext()) {
			final FacetSet current = iter.next();
			if(current instanceof Customization) {
				iter.remove();
			}
		}
		return facetSets;
	}
}
