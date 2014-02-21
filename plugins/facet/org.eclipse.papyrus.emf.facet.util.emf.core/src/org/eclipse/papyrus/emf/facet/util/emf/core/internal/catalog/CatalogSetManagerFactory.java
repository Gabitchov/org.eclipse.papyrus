/**
 * Copyright (c) 2012 Mia-Software.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	  Gregoire Dupe (Mia-Software) - Bug 369987 - [Restructuring][Table] Switch to the new customization and facet framework
 */
package org.eclipse.emf.facet.util.emf.core.internal.catalog;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.facet.util.emf.core.ICatalogSetManager2;
import org.eclipse.emf.facet.util.emf.core.ICatalogSetManagerFactory;

public class CatalogSetManagerFactory implements ICatalogSetManagerFactory {

	public ICatalogSetManager2 createICatalogSetManager(final ResourceSet resourceSet) {
		CatalogSetManager result = null;
		for (Adapter adapter : resourceSet.eAdapters()) {
			if (adapter instanceof CatalogSetManager) {
				result = (CatalogSetManager) adapter;

			}
		}
		if (result == null) {
			result = new CatalogSetManager(resourceSet);
			resourceSet.eAdapters().add(result);
		}
		return result;
	}

}
