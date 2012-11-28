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
package org.eclipse.papyrus.uml.table.common.provider;

import java.util.Collection;
import java.util.HashSet;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.infra.facet.Facet;
import org.eclipse.emf.facet.infra.facet.FacetSet;
import org.eclipse.emf.facet.infra.facet.core.FacetSetCatalog;


/**
 * 
 * This providers provides the list of the registered FacetSet available to display new columns in the table
 * 
 */
public class EMFFacetColumnsProvider extends AbstractAdditionalContentsProvider {

	@Override
	public Collection<FacetSet> getAdditionalFeatures() {
		final HashSet<FacetSet> availableFacetSets = new HashSet<FacetSet>();
		availableFacetSets.addAll(FacetSetCatalog.getSingleton().getAllFacetSets());
		if(pTable.getTable().getTableConfiguration() != null) {
			//FIXME
//			for(Facet facet : pTable.getTable().getTableConfiguration().getDefaultFacets()) {
//				availableFacetSets.add(FacetUtils.getRootFacetSet(facet));
//			}
		}
		for(Facet facet : pTable.getTable().getFacets2()) {
			availableFacetSets.add(getRootFacetSet(facet));
		}
		return availableFacetSets;
	}
	
	private FacetSet getRootFacetSet(final Facet facet){
		final EObject container = facet.eContainer();
		assert container instanceof FacetSet;
		return getRootFacetSet((FacetSet)container);
	}
	
	private FacetSet getRootFacetSet(final FacetSet set){
		final EObject container = set.eContainer();
		if(container!=null){
			if(container instanceof FacetSet){
				return getRootFacetSet((FacetSet)container);
			}else{
				return set;
			}
		}
		return set;
	}
}
