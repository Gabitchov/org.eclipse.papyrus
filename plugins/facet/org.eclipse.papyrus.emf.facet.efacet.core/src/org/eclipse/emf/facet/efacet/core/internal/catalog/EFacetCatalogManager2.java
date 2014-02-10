/*******************************************************************************
 * Copyright (c) 2011 Mia-Software
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	   Gregoire Dupe (Mia-Software) - Bug 333553 - The user has not to deal with two files to create a facet
 * 	   Nicolas Guyomar (Mia-Software) - Bug 333553 - The user has not to deal with two files to create a facet
 * 	   Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 * 	   Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 * 	   Nicolas Bros (Mia-Software) - Bug 361817 - [Restructuring] Dynamic load to the facet catalog
 * 	   Nicolas Bros (Mia-Software) - Bug 370110 - Rename efacetcatalog2.ecore
 *     Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 *     Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *******************************************************************************/
package org.eclipse.emf.facet.efacet.core.internal.catalog;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.facet.efacet.core.IFacetSetCatalogManager;
import org.eclipse.emf.facet.efacet.core.internal.Messages;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.EfacetcatalogFactory;
import org.eclipse.emf.facet.efacet.metamodel.v0_2_0.efacetcatalog.FacetSetCatalog;
import org.eclipse.emf.facet.util.emf.catalog.CatalogSet;
import org.eclipse.emf.facet.util.emf.core.ICatalogManager;

public class EFacetCatalogManager2 implements IFacetSetCatalogManager, ICatalogManager {

	private final FacetSetCatalog facetSetCatalog;

	public EFacetCatalogManager2() {
		this.facetSetCatalog = EfacetcatalogFactory.eINSTANCE
				.createFacetSetCatalog();
		this.facetSetCatalog.setName(Messages.EFacetCatalogManager_FacetSetCatalogName);
	}

	public boolean canBeManaged(final EObject root) {
		return root instanceof FacetSet;
	}

	public void manage(final EObject root) {
		if (root instanceof FacetSet) {
			final FacetSet facetSet = (FacetSet) root;
			this.facetSetCatalog.getInstalledEntries().add(facetSet);
		}
	}

	public void setCatalogSet(final CatalogSet catalogSet) {
		catalogSet.getCatalogs().add(this.facetSetCatalog);
	}

	public List<FacetSet> getRegisteredFacetSets() {
		final BasicEList<FacetSet> result = new BasicEList<FacetSet>();
		for (EObject eObject : this.facetSetCatalog.getInstalledEntries()) {
			if (eObject instanceof FacetSet) {
				final FacetSet facetSet = (FacetSet) eObject;
				result.add(facetSet);
			}
		}
		return Collections.unmodifiableList(result);
	}

	public void registerFacetSet(final FacetSet facetSet) {
		this.facetSetCatalog.getInstalledEntries().add(facetSet);
	}
}
