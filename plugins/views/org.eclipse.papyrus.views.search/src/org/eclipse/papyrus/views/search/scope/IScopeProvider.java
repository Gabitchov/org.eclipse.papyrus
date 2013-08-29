/*****************************************************************************
 * Copyright (c) 2013 CEA LIST and others.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   CEA LIST - Initial API and implementation
 *****************************************************************************/
package org.eclipse.papyrus.views.search.scope;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;


/**
 * A pluggable provider of scopes used by the default {@link IScopeCollector}. Different providers are expected to handle
 * different domains in which EMF model resources can be found. Examples of such domains include
 * <ul>
 * <li>the Eclipse Workspace</li>
 * <li>connected model repositories (e.g., CDO)</li>
 * <li>library models deployed in plug-ins</li>
 * <li>models discoverable on the Word-Wide Web</li>
 * </ul>
 * <p>
 * For workspace-wide searches, all scope providers are queried for their {@linkplain #getScope() full scope} and the resulting search scope is the
 * union of all provided URIs.
 * </p>
 * <p>
 * For selection-scoped searches, providers are queried in priority order for scopes based on each object selected in the workbench. The first
 * provider that returns some URIs for a selected object wins; lower-priority providers are not consulted for additional URIs.
 * </p>
 */
public interface IScopeProvider {

	/**
	 * Gets URIs applicable to a workspace-wide search from the provider's domain. This should be whatever is appropriate to
	 * search all reasonably available resources in the provider's domain, whatever that means. For example, in a model
	 * repository scope provider, it may be reasonable to expect a search to extend into all connected repositories but not
	 * any that are currently disconnected (though it may be known where they are and how to connect).
	 * 
	 * @return all URIs
	 */
	Collection<URI> getScope();

	/**
	 * Gets URIs applicable to a search that is constrained to a given object {@code selected} by the user in the workbench.
	 * 
	 * @param selected
	 *        an object selected in the workbench
	 * @return
	 */
	Collection<URI> getScope(Object selected);
}
