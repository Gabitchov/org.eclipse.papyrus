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
package org.eclipse.papyrus.emf.facet.efacet.core;

import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.papyrus.emf.facet.efacet.core.internal.FacetActionsImpl;
import org.eclipse.papyrus.emf.facet.efacet.metamodel.v0_2_0.efacet.FacetSet;
import org.eclipse.papyrus.emf.facet.util.emf.core.exception.InvalidFacetSetException;

/**
 * This interface contains methods to create {@link FacetSet}s.
 * 
 * @since 0.3
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
public interface IFacetActions {

	IFacetActions INSTANCE = new FacetActionsImpl();

	/**
	 * Add the given facetSet to the given facetSet model file, which will be
	 * created
	 * 
	 * @param facetSet
	 *            the facetSet to be created. Cannot be <code>null</code>
	 * @param file
	 *            the new file in which the facetSet has to be created. Cannot
	 *            be <code>null</code>, and cannot already exist
	 */
	void saveFacetSet(FacetSet facetSet, IFile file) throws IOException,
			InvalidFacetSetException;

}
