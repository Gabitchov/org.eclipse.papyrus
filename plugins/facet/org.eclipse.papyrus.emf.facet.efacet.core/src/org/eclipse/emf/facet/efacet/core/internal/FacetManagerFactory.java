/**
 * Copyright (c) 2011 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	Emmanuelle Rouillé (Mia-Software) - Bug 352618 - To be able to use non derived facet structural features and save them values.
 *  Nicolas Bros (Mia-Software) - Bug 361612 - New core for new version of the Facet metamodel
 *  Gregoire Dupe (Mia-Software) - Bug 361794 - [Restructuring] New customization meta-model
 *  Gregoire Dupe (Mia-Software) - Bug 373078 - API Cleaning
 *  Thomas Cicognani (Soft-Maint) - Bug 416223 - IFacetManagerFactory.getOrCreateFacetManager should not create an instance per call
 */
package org.eclipse.emf.facet.efacet.core.internal;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.efacet.core.IFacetManager;
import org.eclipse.emf.facet.efacet.core.IFacetManagerFactory;

public class FacetManagerFactory implements IFacetManagerFactory {

	public IFacetManager getOrCreateFacetManager(final Resource resource) {
		FacetManager result = null;
		for (Adapter adapter : resource.eAdapters()) {
			if (adapter instanceof FacetManager) {
				result = (FacetManager) adapter;
			}
		}
		if (result == null) {
			result = new FacetManager(resource);
			resource.eAdapters().add(result);
		}
		return result;
	}

	public IFacetManager getOrCreateFacetManager(final ResourceSet resourceSet) {
		FacetManager result = null;
		for (Adapter adapter : resourceSet.eAdapters()) {
			if (adapter instanceof FacetManager) {
				result = (FacetManager) adapter;
			}
		}
		if (result == null) {
			result = new FacetManager(resourceSet);
			resourceSet.eAdapters().add(result);
		}
		return result;
	}

}
