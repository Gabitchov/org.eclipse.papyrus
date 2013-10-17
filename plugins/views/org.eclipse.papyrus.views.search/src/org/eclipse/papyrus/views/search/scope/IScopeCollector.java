/*****************************************************************************
 * Copyright (c) 2013 CEA LIST.
 *
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  CEA LIST - Initial API and implementation
 *  Christian W. Damus (CEA LIST) - Replace workspace IResource dependency with URI for CDO compatibility
 *
 *****************************************************************************/
package org.eclipse.papyrus.views.search.scope;

import java.util.Collection;

import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.search.ui.ISearchPageContainer;

/**
 * 
 * Interface that must be implemented to generate scope (i.e. list of {@link URI}s) from a {@link ISearchPageContainer}
 * 
 */
public interface IScopeCollector {

	/**
	 * Find a collection of {@link IResource} that can be processed from those available in the container
	 * 
	 * @param container
	 *        the container to search in
	 * @return
	 *         a collection of {@link IResource} that can be processed
	 */
	public Collection<URI> computeSearchScope(ISearchPageContainer container);
}
